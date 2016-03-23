package com.lourenco.brandon.collectionhs.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lourenco.brandon.collectionhs.R;
import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;
import com.lourenco.brandon.collectionhs.json.JSONResourceReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Brandon on 2016-03-23.
 */
public class CollectionDbHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = "CollectionDbHelper";

    private Context context;

    public CollectionDbHelper(Context context) {
        super(context, CollectionDbContract.DATABASE_NAME, null, CollectionDbContract.DATABASE_VERSION);
        this.context = context;
    }

    //TODO Restructure DB code to remove multiple lines of create/delete/init code

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CollectionDbContract.CardType.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.PlayerClass.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Rarity.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Race.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Faction.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardSetType.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardSet.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Card.CREATE_TABLE_SQL);

        initTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Just delete and re-create (from JSON)
        db.execSQL(CollectionDbContract.Card.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardSet.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardSetType.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Faction.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Race.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Rarity.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.PlayerClass.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardType.DELETE_TABLE_SQL);

        onCreate(db);
    }

    public void initTables(SQLiteDatabase db)
    {
        initTableCardType(db);
        initTablePlayerClass(db);
        initTableRarity(db);
        initTableRace(db);
        initTableFaction(db);
        initTableCardSetType(db);
        initTableCardSet(db);
        initTableCard(db);
    }

    private void initTableCard(SQLiteDatabase db)
    {
        JSONResourceReader reader = new JSONResourceReader(context.getResources());

        try
        {
            JSONArray jsonCards = new JSONObject(reader.getStringFromJSON(R.raw.cards)).getJSONArray("cards");

            for (int i = 0; i < jsonCards.length(); i++)
            {
                JSONObject card = jsonCards.getJSONObject(i);

                String id = card.getString("id"); // TODO Store JSON field names as strings for easy updating (aka JSON Contract)
                String type = card.getString("type");
                boolean collectible = card.getBoolean("collectible");
                String set = card.getString("set");
                String playerClass = card.getString("playerClass");
                String rarity = card.getString("rarity");
                String name = card.getString("name");
                String text = card.getString("text");
                int cost = card.getInt("cost");
                int attack = card.getInt("attack");
                int health = card.getInt("health");
                int durability = card.getInt("durability");
                String race = card.getString("race");
                JSONArray jsonMechanics = card.getJSONArray("mechanics"); // Iterate
                String flavor = card.getString("flavor");
                String howToEarn = card.getString("howToEarn");
                String howToEarnGolden = card.getString("howToEarnGolden");
                JSONArray jsonEntourage = card.getJSONArray("entourage"); // Iterate
                String artist = card.getString("artist");
                String faction = card.getString("faction");
                JSONArray jsonPlayReq = card.getJSONArray("playRequirements");

                // CONVERT

                int convCollectible = collectible ? 1 : 0;

                //TODO look up the foreign keys from the db tables, not the enums
                int convType = -1;
                for (EnumsHS.CardType cardType : EnumsHS.CardType.getValidTypes()) {
                    if (cardType.name().equals(type))
                    {
                        convType = cardType.getValue();
                        break;
                    }
                }

                int convSet = -1;
                for (EnumsHS.CardSet cardSet : EnumsHS.CardSet.getPlayableSets()) {
                    if (cardSet.name().equals(set))
                    {
                        convSet = cardSet.getValue();
                        break;
                    }
                }

                int convClass = -1;
                for (EnumsHS.CardClass cardClass : EnumsHS.CardClass.getValidClasses()) {
                    if (cardClass.name().equals(playerClass))
                    {
                        convClass = cardClass.getValue();
                        break;
                    }
                }

                int convRarity = -1;
                for (EnumsHS.Rarity cardRarity : EnumsHS.Rarity.getValidRarities()) {
                    if (cardRarity.name().equals(rarity))
                    {
                        convRarity = cardRarity.getValue();
                        break;
                    }
                }

                int convRace = -1;
                for (EnumsHS.Race cardRace : EnumsHS.Race.getValidRaces()) {
                    if (cardRace.name().equals(race))
                    {
                        convRace = cardRace.getValue();
                        break;
                    }
                }

                int convFaction = -1;
                for (EnumsHS.Faction cardFaction : EnumsHS.Faction.getValidFactions()) {
                    if (cardFaction.name().equals(faction))
                    {
                        convFaction = cardFaction.getValue();
                        break;
                    }
                }

                // INSERT

                ContentValues values = new ContentValues();
                values.put(CollectionDbContract.Card.COLUMN_NAME_CARD_ID, id);
                values.put(CollectionDbContract.Card.COLUMN_NAME_CARD_TYPE_FOREIGN, convType);
                values.put(CollectionDbContract.Card.COLUMN_NAME_COLLECTIBLE, convCollectible);
                values.put(CollectionDbContract.Card.COLUMN_NAME_CARD_SET_FOREIGN, convSet);
                values.put(CollectionDbContract.Card.COLUMN_NAME_PLAYER_CLASS_FOREIGN, convClass);
                values.put(CollectionDbContract.Card.COLUMN_NAME_RARITY_FOREIGN, convRarity);
                values.put(CollectionDbContract.Card.COLUMN_NAME_COST, cost);
                values.put(CollectionDbContract.Card.COLUMN_NAME_ATTACK, attack);

                if (type.equals("MINION"))
                    values.put(CollectionDbContract.Card.COLUMN_NAME_HEALTH, health);
                else if (type.equals("WEAPON"))
                    values.put(CollectionDbContract.Card.COLUMN_NAME_HEALTH, durability);
                else
                    values.putNull(CollectionDbContract.Card.COLUMN_NAME_HEALTH);

                values.put(CollectionDbContract.Card.COLUMN_NAME_RACE_FOREIGN, convRace);
                values.put(CollectionDbContract.Card.COLUMN_NAME_ARTIST, artist);
                values.put(CollectionDbContract.Card.COLUMN_NAME_FACTION_FOREIGN, convFaction);

                values.put(CollectionDbContract.Card.COLUMN_NAME_COLLECTED, 0);
                values.put(CollectionDbContract.Card.COLUMN_NAME_COLLECTED_GOLDEN, 0);
                values.put(CollectionDbContract.Card.COLUMN_NAME_BOOKMARKED, 0);

                db.insert(
                        CollectionDbContract.Card.TABLE_NAME,
                        null,
                        values
                );
            }
        }
        catch (JSONException e)
        {
            Log.e(LOG_TAG, "Error initializing Card table from JSON resource.");
        }
    }

    // Enum Tables

    private void initTableCardType(SQLiteDatabase db)
    {
        for (EnumsHS.CardType type : EnumsHS.CardType.getValidTypes()) {
            ContentValues values = new ContentValues();
            values.put(CollectionDbContract.CardType.COLUMN_NAME_CARD_TYPE_ID, type.getValue());
            values.put(CollectionDbContract.CardType.COLUMN_NAME_TYPE_NAME, type.name());

            db.insert(
                    CollectionDbContract.CardType.TABLE_NAME,
                    null,
                    values
            );
        }
    }

    private void initTablePlayerClass(SQLiteDatabase db)
    {
        for (EnumsHS.CardClass cardClass : EnumsHS.CardClass.getValidClasses()) {
            ContentValues values = new ContentValues();
            values.put(CollectionDbContract.PlayerClass.COLUMN_NAME_PLAYER_CLASS_ID, cardClass.getValue());
            values.put(CollectionDbContract.PlayerClass.COLUMN_NAME_PLAYER_CLASS_NAME, cardClass.name());

            db.insert(
                    CollectionDbContract.PlayerClass.TABLE_NAME,
                    null,
                    values
            );
        }
    }

    private void initTableRarity(SQLiteDatabase db)
    {
        for (EnumsHS.Rarity rarity : EnumsHS.Rarity.getValidRarities()) {
            ContentValues values = new ContentValues();
            values.put(CollectionDbContract.Rarity.COLUMN_NAME_RARITY_ID, rarity.getValue());
            values.put(CollectionDbContract.Rarity.COLUMN_NAME_RARITY_NAME, rarity.name());
            values.put(CollectionDbContract.Rarity.COLUMN_NAME_CRAFT_COST, rarity.getCraftCost());
            values.put(CollectionDbContract.Rarity.COLUMN_NAME_CRAFT_GOLDEN_COST, rarity.getCraftGoldenCost());
            values.put(CollectionDbContract.Rarity.COLUMN_NAME_DISENCHANT_VALUE, rarity.getDisenchantValue());
            values.put(CollectionDbContract.Rarity.COLUMN_NAME_DISENCHANT_GOLDEN_VALUE, rarity.getDisenchantGoldenValue());

            db.insert(
                    CollectionDbContract.Rarity.TABLE_NAME,
                    null,
                    values
            );
        }
    }

    private void initTableRace(SQLiteDatabase db)
    {
        for (EnumsHS.Race race : EnumsHS.Race.getValidRaces()) {
            ContentValues values = new ContentValues();
            values.put(CollectionDbContract.Race.COLUMN_NAME_RACE_ID, race.getValue());
            values.put(CollectionDbContract.Race.COLUMN_NAME_RACE_NAME, race.name());

            db.insert(
                    CollectionDbContract.Race.TABLE_NAME,
                    null,
                    values
            );
        }
    }

    private void initTableFaction(SQLiteDatabase db)
    {
        for (EnumsHS.Faction faction : EnumsHS.Faction.getValidFactions()) {
            ContentValues values = new ContentValues();
            values.put(CollectionDbContract.Faction.COLUMN_NAME_FACTION_ID, faction.getValue());
            values.put(CollectionDbContract.Faction.COLUMN_NAME_FACTION_NAME, faction.name());

            db.insert(
                    CollectionDbContract.Faction.TABLE_NAME,
                    null,
                    values
            );
        }
    }

    private void initTableCardSetType (SQLiteDatabase db)
    {
        for (EnumsHS.CardSetType setType : EnumsHS.CardSetType.getValidSetTypes()) {
            ContentValues values = new ContentValues();
            values.put(CollectionDbContract.CardSetType.COLUMN_NAME_CARD_SET_TYPE_ID, setType.getValue());
            values.put(CollectionDbContract.CardSetType.COLUMN_NAME_TYPE_NAME, setType.name());

            db.insert(
                    CollectionDbContract.CardSetType.TABLE_NAME,
                    null,
                    values
            );
        }
    }

    private void initTableCardSet(SQLiteDatabase db)
    {
        for (EnumsHS.CardSet cardSet : EnumsHS.CardSet.getPlayableSets()) {
            ContentValues values = new ContentValues();
            values.put(CollectionDbContract.CardSet.COLUMN_NAME_CARD_SET_ID, cardSet.getValue());
            values.put(CollectionDbContract.CardSet.COLUMN_NAME_SET_NAME, cardSet.name());
            values.put(CollectionDbContract.CardSet.COLUMN_NAME_SET_TYPE_FOREIGN, cardSet.getSetType().getValue());
            values.put(CollectionDbContract.CardSet.COLUMN_NAME_RELEASE_YEAR, cardSet.getReleaseYear());

            db.insert(
                    CollectionDbContract.CardSet.TABLE_NAME,
                    null,
                    values
            );
        }
    }
}
