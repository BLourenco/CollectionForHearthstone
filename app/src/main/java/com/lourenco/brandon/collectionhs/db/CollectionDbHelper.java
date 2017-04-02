package com.lourenco.brandon.collectionhs.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lourenco.brandon.collectionhs.R;
import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;
import com.lourenco.brandon.collectionhs.json.CollectionJsonContract;
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
        db.execSQL(CollectionDbContract.Locale.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardLocale.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardType.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.PlayerClass.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.TriClass.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardClasses.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Rarity.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Race.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Faction.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardSetType.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardSet.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Card.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Mechanic.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.PlayRequirement.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardMechanic.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardPlayRequirement.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardEntourage.CREATE_TABLE_SQL);

        initTables(db);

        db.execSQL(CollectionDbContract.CardAlbumView.CREATE_VIEW);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Just delete and re-create (from JSON)
        db.execSQL(CollectionDbContract.CardAlbumView.DELETE_VIEW);

        db.execSQL(CollectionDbContract.CardMechanic.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardEntourage.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardPlayRequirement.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Mechanic.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.PlayRequirement.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Card.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardSet.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardSetType.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Faction.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Race.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Rarity.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardClasses.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.TriClass.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.PlayerClass.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardType.DELETE_TABLE_SQL);
        db.execSQL(CollectionDbContract.CardLocale.CREATE_TABLE_SQL);
        db.execSQL(CollectionDbContract.Locale.CREATE_TABLE_SQL);

        onCreate(db);
    }

    public void initTables(SQLiteDatabase db) {
        initTableLocale(db);
        initTableCardType(db);
        initTablePlayerClass(db);
        initTableTriClass(db);
        initTableRarity(db);
        initTableRace(db);
        initTableFaction(db);
        initTableCardSetType(db);
        initTableCardSet(db);
        initTableCard(db);
        initTableMechanic(db);
        //initTableEntourage(db); not needed
        initTablePlayRequirement(db);
    }

    private void initTableCard(SQLiteDatabase db) {
        JSONResourceReader reader = new JSONResourceReader(context.getResources());

        try {
            JSONArray arrayCards = new JSONArray(reader.getStringFromJSON(R.raw.cards));
            insertCardArray(db, arrayCards);
            //JSONArray arrayUnreleasedCards = new JSONArray(reader.getStringFromJSON(R.raw.cards_unreleased)); // TODO LOW_PRIORITY: add unreleased card
            //insertCardArray(db, arrayUnreleasedCards);

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Error getting JSON string from JSON resource.");
        }
    }

    private void insertCardArray(SQLiteDatabase db, JSONArray cardArray) {
        for (int i = 0; i < cardArray.length(); i++) {
            try {
                JSONObject card = cardArray.getJSONObject(i);

                String id = card.getString(CollectionJsonContract.CardJson.KEY_ID);
                String type = card.has(CollectionJsonContract.CardJson.KEY_TYPE) ? card.getString(CollectionJsonContract.CardJson.KEY_TYPE) : null;
                Boolean collectible = card.has(CollectionJsonContract.CardJson.KEY_COLLECTIBLE) ? card.getBoolean(CollectionJsonContract.CardJson.KEY_COLLECTIBLE) : null;
                String set = card.has(CollectionJsonContract.CardJson.KEY_SET) ? card.getString(CollectionJsonContract.CardJson.KEY_SET) : null;
                String playerClass = card.has(CollectionJsonContract.CardJson.KEY_CARD_CLASS) ? card.getString(CollectionJsonContract.CardJson.KEY_CARD_CLASS) : "NEUTRAL";
                String triClass = card.has(CollectionJsonContract.CardJson.KEY_TRI_CLASS) ? card.getString(CollectionJsonContract.CardJson.KEY_TRI_CLASS) : null;
                JSONArray arrayClasses = card.has(CollectionJsonContract.CardJson.KEY_CLASSES) ? card.getJSONArray(CollectionJsonContract.CardJson.KEY_CLASSES) : null;
                String rarity = card.has(CollectionJsonContract.CardJson.KEY_RARITY) ? card.getString(CollectionJsonContract.CardJson.KEY_RARITY) : null;
                JSONObject jsonNames = card.has(CollectionJsonContract.CardJson.KEY_NAME) ? card.getJSONObject(CollectionJsonContract.CardJson.KEY_NAME) : null;
                JSONObject jsonText = card.has(CollectionJsonContract.CardJson.KEY_COLLECTION_TEXT) ? card.getJSONObject(CollectionJsonContract.CardJson.KEY_COLLECTION_TEXT) :
                        card.has(CollectionJsonContract.CardJson.KEY_TEXT) ? card.getJSONObject(CollectionJsonContract.CardJson.KEY_TEXT) : null;
                Integer cost = card.has(CollectionJsonContract.CardJson.KEY_COST) ? card.getInt(CollectionJsonContract.CardJson.KEY_COST) : null;
                Integer attack = card.has(CollectionJsonContract.CardJson.KEY_ATTACK) ? card.getInt(CollectionJsonContract.CardJson.KEY_ATTACK) : null;
                Integer health = card.has(CollectionJsonContract.CardJson.KEY_HEALTH) ? card.getInt(CollectionJsonContract.CardJson.KEY_HEALTH) : null;
                Integer durability = card.has(CollectionJsonContract.CardJson.KEY_DURABILITY) ? card.getInt(CollectionJsonContract.CardJson.KEY_DURABILITY) : null;
                String race = card.has(CollectionJsonContract.CardJson.KEY_RACE) ? card.getString(CollectionJsonContract.CardJson.KEY_RACE) : null;
                JSONArray arrayMechanics = card.has(CollectionJsonContract.CardJson.KEY_MECHANICS) ? card.getJSONArray(CollectionJsonContract.CardJson.KEY_MECHANICS) : null;
                JSONObject jsonFlavor = card.has(CollectionJsonContract.CardJson.KEY_FLAVOR) ? card.getJSONObject(CollectionJsonContract.CardJson.KEY_FLAVOR) : null;
                JSONObject jsonHowToEarn = card.has(CollectionJsonContract.CardJson.KEY_HOW_TO_EARN) ? card.getJSONObject(CollectionJsonContract.CardJson.KEY_HOW_TO_EARN) : null;
                JSONObject jsonHowToEarnGolden = card.has(CollectionJsonContract.CardJson.KEY_HOW_TO_EARN_GOLDEN) ? card.getJSONObject(CollectionJsonContract.CardJson.KEY_HOW_TO_EARN_GOLDEN) : null;
                JSONArray arrayEntourage = card.has(CollectionJsonContract.CardJson.KEY_ENTOURAGE) ? card.getJSONArray(CollectionJsonContract.CardJson.KEY_ENTOURAGE) : null;
                String artist = card.has(CollectionJsonContract.CardJson.KEY_ARTIST) ? card.getString(CollectionJsonContract.CardJson.KEY_ARTIST) : null;
                String faction = card.has(CollectionJsonContract.CardJson.KEY_FACTION) ? card.getString(CollectionJsonContract.CardJson.KEY_FACTION) : null;
                JSONObject jsonPlayReq = card.has(CollectionJsonContract.CardJson.KEY_PLAY_REQUIREMENTS) ? card.getJSONObject(CollectionJsonContract.CardJson.KEY_PLAY_REQUIREMENTS) : null;

                // CONVERT

                Integer convCollectible = collectible != null ? (collectible ? 1 : 0) : null;

                //TODO look up the foreign keys from the db tables, not the enums
                Integer convType = null;
                if (type != null)
                    for (EnumsHS.CardType cardType : EnumsHS.CardType.getValidTypes()) {
                        if (cardType.name().equals(type)) {
                            convType = cardType.getValue();
                            break;
                        }
                    }

                Integer convSet = null;
                if (set != null)
                    for (EnumsHS.CardSet cardSet : EnumsHS.CardSet.values()) {
                        if (cardSet.name().equals(set)) {
                            convSet = cardSet.getValue();
                            break;
                        }
                    }

                Integer convClass = null;
                if (playerClass != null)
                    for (EnumsHS.CardClass cardClass : EnumsHS.CardClass.getValidClasses()) {
                        if (cardClass.name().equals(playerClass)) {
                            convClass = cardClass.getValue();
                            break;
                        }
                    }

                Integer convTriClass = null;
                if (triClass != null)
                    for (EnumsHS.TriClass cardTriClass : EnumsHS.TriClass.getValidTriClasses()) {
                        if (cardTriClass.name().equals(triClass)) {
                            convTriClass = cardTriClass.getValue();
                            break;
                        }
                    }

                Integer convRarity = null;
                if (rarity != null)
                    for (EnumsHS.Rarity cardRarity : EnumsHS.Rarity.getValidRarities()) {
                        if (cardRarity.name().equals(rarity)) {
                            convRarity = cardRarity.getValue();
                            break;
                        }
                    }

                Integer convRace = null;
                if (race != null)
                    for (EnumsHS.Race cardRace : EnumsHS.Race.getValidRaces()) {
                        if (cardRace.name().equals(race)) {
                            convRace = cardRace.getValue();
                            break;
                        }
                    }

                Integer convFaction = null;
                if (faction != null)
                    for (EnumsHS.Faction cardFaction : EnumsHS.Faction.getValidFactions()) {
                        if (cardFaction.name().equals(faction)) {
                            convFaction = cardFaction.getValue();
                            break;
                        }
                    }

                // INSERT

                ContentValues values = new ContentValues();
                values.put(CollectionDbContract.Card.COLUMN_NAME_CARD_ID, id);
                values.put(CollectionDbContract.Card.COLUMN_NAME_CARD_TYPE_ID_FOREIGN, convType);
                values.put(CollectionDbContract.Card.COLUMN_NAME_COLLECTIBLE, convCollectible);
                values.put(CollectionDbContract.Card.COLUMN_NAME_CARD_SET_ID_FOREIGN, convSet);
                values.put(CollectionDbContract.Card.COLUMN_NAME_PLAYER_CLASS_ID_FOREIGN, convClass);
                values.put(CollectionDbContract.Card.COLUMN_NAME_TRI_CLASS_ID_FOREIGN, convTriClass);
                values.put(CollectionDbContract.Card.COLUMN_NAME_RARITY_ID_FOREIGN, convRarity);
                if (type != null) {
                    if (!type.equals("HERO") && !type.equals("ENCHANTMENT"))
                        values.put(CollectionDbContract.Card.COLUMN_NAME_COST, cost);
                    else
                        values.putNull(CollectionDbContract.Card.COLUMN_NAME_COST);
                    values.put(CollectionDbContract.Card.COLUMN_NAME_ATTACK, attack);

                    if (type.equals("MINION") || type.equals("HERO"))
                        values.put(CollectionDbContract.Card.COLUMN_NAME_HEALTH, health);
                    else if (type.equals("WEAPON"))
                        values.put(CollectionDbContract.Card.COLUMN_NAME_HEALTH, durability);
                    else
                        values.putNull(CollectionDbContract.Card.COLUMN_NAME_HEALTH);
                }
                values.put(CollectionDbContract.Card.COLUMN_NAME_RACE_ID_FOREIGN, convRace);
                values.put(CollectionDbContract.Card.COLUMN_NAME_ARTIST, artist);
                values.put(CollectionDbContract.Card.COLUMN_NAME_FACTION_ID_FOREIGN, convFaction);

                values.put(CollectionDbContract.Card.COLUMN_NAME_COLLECTED, 0);
                values.put(CollectionDbContract.Card.COLUMN_NAME_COLLECTED_GOLDEN, 0);
                values.put(CollectionDbContract.Card.COLUMN_NAME_BOOKMARKED, 0);

                db.insert(
                        CollectionDbContract.Card.TABLE_NAME,
                        null,
                        values
                );

                // LOCALIZATION

                for (EnumsHS.Locale locale : EnumsHS.Locale.getUsedLocales()) {
                    String name = null;
                    String text = null;
                    String flavor = null;
                    String howToEarn = null;
                    String howToEarnGolden = null;

                    if (jsonNames != null)
                        name = jsonNames.has(locale.name()) ? jsonNames.getString(locale.name()) : null;
                    if (jsonText != null)
                        text = jsonText.has(locale.name()) ? jsonText.getString(locale.name()) : null;
                    if (jsonFlavor != null)
                        flavor = jsonFlavor.has(locale.name()) ? jsonNames.getString(locale.name()) : null;
                    if (jsonHowToEarn != null)
                        howToEarn = jsonHowToEarn.has(locale.name()) ? jsonHowToEarn.getString(locale.name()) : null;
                    if (jsonHowToEarnGolden != null)
                        howToEarnGolden = jsonHowToEarnGolden.has(locale.name()) ? jsonHowToEarnGolden.getString(locale.name()) : null;

                    if (name == null) continue;

                    ContentValues localeValues = new ContentValues();
                    localeValues.put(CollectionDbContract.CardLocale.COLUMN_NAME_CARD_ID_COMPOSITE, id);
                    localeValues.put(CollectionDbContract.CardLocale.COLUMN_NAME_LOCALE_ID_COMPOSITE, locale.getValue());
                    localeValues.put(CollectionDbContract.CardLocale.COLUMN_NAME_CARD_NAME, name);
                    localeValues.put(CollectionDbContract.CardLocale.COLUMN_NAME_CARD_TEXT, text);
                    localeValues.put(CollectionDbContract.CardLocale.COLUMN_NAME_CARD_FLAVOR, flavor);
                    localeValues.put(CollectionDbContract.CardLocale.COLUMN_NAME_CARD_HOW_TO_EARN, howToEarn);
                    localeValues.put(CollectionDbContract.CardLocale.COLUMN_NAME_CARD_HOW_TO_EARN_GOLDEN, howToEarnGolden);

                    db.insert(
                            CollectionDbContract.CardLocale.TABLE_NAME,
                            null,
                            localeValues
                    );
                }

                // PLAY REQUIREMENTS

                if (jsonPlayReq != null)
                    for (EnumsHS.PlayReq playReqEnum : EnumsHS.PlayReq.values()) {
                        Integer playReq = jsonPlayReq.has(playReqEnum.name()) ? jsonPlayReq.getInt(playReqEnum.name()) : null;

                        if (playReq == null) continue;

                        ContentValues playReqValues = new ContentValues();
                        playReqValues.put(CollectionDbContract.CardPlayRequirement.COLUMN_NAME_CARD_ID_COMPOSITE, id);
                        playReqValues.put(CollectionDbContract.CardPlayRequirement.COLUMN_NAME_PLAY_REQUIREMENT_ID_COMPOSITE, playReqEnum.getValue());
                        playReqValues.put(CollectionDbContract.CardPlayRequirement.COLUMN_NAME_PLAY_REQUIREMENT_PARAMETER, playReq);

                        db.insert(
                                CollectionDbContract.CardPlayRequirement.TABLE_NAME,
                                null,
                                playReqValues
                        );
                    }


                // ARRAYS

                if (arrayClasses != null)
                    for (int c = 0; c < arrayClasses.length(); c++) {
                        Integer classId = EnumsHS.CardClass.valueOf(arrayClasses.getString(c)).getValue();

                        if (classId == EnumsHS.CardClass.INVALID.getValue() || classId == null)
                            continue;

                        ContentValues classValues = new ContentValues();
                        classValues.put(CollectionDbContract.CardClasses.COLUMN_NAME_CARD_ID_COMPOSITE, id);
                        classValues.put(CollectionDbContract.CardClasses.COLUMN_NAME_PLAYER_CLASS_ID_COMPOSITE, classId);

                        db.insert(
                                CollectionDbContract.CardClasses.TABLE_NAME,
                                null,
                                classValues
                        );
                    }

                if (arrayMechanics != null)
                    for (int m = 0; m < arrayMechanics.length(); m++) {
                        Integer mechId = EnumsHS.Mechanic.getValueByName(arrayMechanics.getString(m));

                        if (mechId == EnumsHS.Mechanic.INVALID.getValue() || mechId == null)
                            continue;

                        ContentValues mechValues = new ContentValues();
                        mechValues.put(CollectionDbContract.CardMechanic.COLUMN_NAME_CARD_ID_COMPOSITE, id);
                        mechValues.put(CollectionDbContract.CardMechanic.COLUMN_NAME_MECHANIC_ID_COMPOSITE, mechId);

                        db.insert(
                                CollectionDbContract.CardMechanic.TABLE_NAME,
                                null,
                                mechValues
                        );
                    }

                if (arrayEntourage != null)
                    for (int e = 0; e < arrayEntourage.length(); e++) {
                        String entId = arrayEntourage.getString(e);

                        ContentValues entValues = new ContentValues();
                        entValues.put(CollectionDbContract.CardEntourage.COLUMN_NAME_CARD_ID_COMPOSITE, id);
                        entValues.put(CollectionDbContract.CardEntourage.COLUMN_NAME_ENTOURAGE_ID_COMPOSITE, entId);

                        db.insert(
                                CollectionDbContract.CardEntourage.TABLE_NAME,
                                null,
                                entValues
                        );
                    }
            } catch (JSONException e) {
                Log.e(LOG_TAG, "Error pulling values from JSON resource at index " + i + ": " + e.toString());
            }
        }
    }

    // Enum Tables

    private void initTableLocale(SQLiteDatabase db) {
        for (EnumsHS.Locale locale : EnumsHS.Locale.values()) {
            ContentValues values = new ContentValues();
            values.put(CollectionDbContract.Locale.COLUMN_NAME_LOCALE_ID, locale.getValue());
            values.put(CollectionDbContract.Locale.COLUMN_NAME_LOCALE_NAME, locale.name());

            db.insert(
                    CollectionDbContract.Locale.TABLE_NAME,
                    null,
                    values
            );
        }
    }

    private void initTableCardType(SQLiteDatabase db) {
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

    private void initTablePlayerClass(SQLiteDatabase db) {
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

    private void initTableTriClass(SQLiteDatabase db) {
        for (EnumsHS.TriClass cardTriClass : EnumsHS.TriClass.getValidTriClasses()) {
            ContentValues values = new ContentValues();
            values.put(CollectionDbContract.TriClass.COLUMN_NAME_TRI_CLASS_ID, cardTriClass.getValue());
            values.put(CollectionDbContract.TriClass.COLUMN_NAME_TRI_CLASS_NAME, cardTriClass.name());

            db.insert(
                    CollectionDbContract.TriClass.TABLE_NAME,
                    null,
                    values
            );
        }
    }

    private void initTableRarity(SQLiteDatabase db) {
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

    private void initTableRace(SQLiteDatabase db) {
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

    private void initTableFaction(SQLiteDatabase db) {
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

    private void initTableCardSetType(SQLiteDatabase db) {
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

    private void initTableCardSet(SQLiteDatabase db) {
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

    private void initTableMechanic(SQLiteDatabase db) {
        for (EnumsHS.Mechanic mechanic : EnumsHS.Mechanic.values()) {
            ContentValues values = new ContentValues();
            values.put(CollectionDbContract.Mechanic.COLUMN_NAME_MECHANIC_ID, mechanic.getValue());
            values.put(CollectionDbContract.Mechanic.COLUMN_NAME_MECHANIC_NAME, mechanic.name());

            db.insert(
                    CollectionDbContract.Mechanic.TABLE_NAME,
                    null,
                    values
            );
        }
    }

    private void initTablePlayRequirement(SQLiteDatabase db) {
        for (EnumsHS.PlayReq playReq : EnumsHS.PlayReq.values()) {
            ContentValues values = new ContentValues();
            values.put(CollectionDbContract.PlayRequirement.COLUMN_NAME_PLAY_REQUIREMENT_ID, playReq.getValue());
            values.put(CollectionDbContract.PlayRequirement.COLUMN_NAME_PLAY_REQUIREMENT_NAME, playReq.name());

            db.insert(
                    CollectionDbContract.PlayRequirement.TABLE_NAME,
                    null,
                    values
            );
        }
    }
}
