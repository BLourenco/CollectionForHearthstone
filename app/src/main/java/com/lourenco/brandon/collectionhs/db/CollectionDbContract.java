package com.lourenco.brandon.collectionhs.db;

import android.provider.BaseColumns;

/**
 * Created by Brandon on 2016-03-22.
 */
public final class CollectionDbContract {

    // If the DB Schema changes, increment the DB version!
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CollectionHS.db";

    private static final String COMMA_SEP = ",";

    private static final String TYPE_TEXT = " TEXT";
    private static final String TYPE_INTEGER = " INTEGER";
    private static final String TYPE_REAL = " REAL";
    private static final String TYPE_BLOB = " BLOB";
    private static final String TYPE_NULL = " NULL";

    private static String ForeignKey(String keyName, String refTable, String refColumnName) {
        return String.format("FOREIGN KEY(%s) REFERENCES %s(%s)", keyName, refTable, refColumnName);
    }
    private static String CompositeKey(String...params) {
        StringBuilder sb = new StringBuilder();
        sb.append("PRIMARY KEY (");

        boolean firstParam = true;
        for (String param : params)
        {
            if (!firstParam)
                sb.append(", ");
            else
                firstParam = false;
            sb.append(param);
        }

        sb.append(")");

        return sb.toString();
    }


    // To prevent someone from accidentally instantiating the contract class, give it an
    // empty constructor.
    private CollectionDbContract() {}



    // Inner classes represent tables
    // JSON Objects

    public static abstract class Card implements BaseColumns {

        // Table & Column names
        public static final String TABLE_NAME = "card";
        public static final String COLUMN_NAME_CARD_ID = "card_id";
        public static final String COLUMN_NAME_CARD_TYPE_FOREIGN = "card_type_id";
        public static final String COLUMN_NAME_COLLECTIBLE = "collectible";
        public static final String COLUMN_NAME_CARD_SET_FOREIGN = "card_set_id";
        public static final String COLUMN_NAME_PLAYER_CLASS_FOREIGN = "player_class_id";
        public static final String COLUMN_NAME_RARITY_FOREIGN = "rarity_id";
        public static final String COLUMN_NAME_COST = "cost";
        public static final String COLUMN_NAME_ATTACK = "attack";
        public static final String COLUMN_NAME_HEALTH = "health"; // will also hold durability
        public static final String COLUMN_NAME_RACE_FOREIGN = "race_id";
        public static final String COLUMN_NAME_ARTIST = "artist";
        public static final String COLUMN_NAME_FACTION_FOREIGN = "faction_id";

        // User-specific data
        public static final String COLUMN_NAME_COLLECTED = "collected";
        public static final String COLUMN_NAME_COLLECTED_GOLDEN = "collected_golden";
        public static final String COLUMN_NAME_BOOKMARKED = "bookmarked";

        //TODO set NOT NULL columns

        // SQL Queries
        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_CARD_ID + " TEXT PRIMARY KEY," +
                        COLUMN_NAME_CARD_TYPE_FOREIGN + TYPE_TEXT + COMMA_SEP +
                        COLUMN_NAME_COLLECTIBLE + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_CARD_SET_FOREIGN + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_PLAYER_CLASS_FOREIGN + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_RARITY_FOREIGN + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_COST + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_ATTACK + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_HEALTH + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_RACE_FOREIGN + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_ARTIST + TYPE_TEXT + COMMA_SEP +
                        COLUMN_NAME_FACTION_FOREIGN + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_COLLECTED + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_COLLECTED_GOLDEN + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_BOOKMARKED + TYPE_INTEGER + COMMA_SEP +
                        //foreign keys
                        ForeignKey(COLUMN_NAME_CARD_TYPE_FOREIGN, CardType.TABLE_NAME, CardType.COLUMN_NAME_CARD_TYPE_ID) + COMMA_SEP +
                        ForeignKey(COLUMN_NAME_CARD_SET_FOREIGN, CardSet.TABLE_NAME, CardSet.COLUMN_NAME_CARD_SET_ID) + COMMA_SEP +
                        ForeignKey(COLUMN_NAME_PLAYER_CLASS_FOREIGN, PlayerClass.TABLE_NAME, PlayerClass.COLUMN_NAME_PLAYER_CLASS_ID) + COMMA_SEP +
                        ForeignKey(COLUMN_NAME_RARITY_FOREIGN, Rarity.TABLE_NAME, Rarity.COLUMN_NAME_RARITY_ID) + COMMA_SEP +
                        ForeignKey(COLUMN_NAME_RACE_FOREIGN, Race.TABLE_NAME, Race.COLUMN_NAME_RACE_ID) + COMMA_SEP +
                        ForeignKey(COLUMN_NAME_FACTION_FOREIGN, Faction.TABLE_NAME, Faction.COLUMN_NAME_FACTION_ID) +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class CardBack implements BaseColumns {

        public static final String TABLE_NAME = "card_back";
        public static final String COLUMN_NAME_CARD_BACK_ID = "card_back_id";
        public static final String COLUMN_NAME_NOTE_DESC = "note_desc"; // seem to always be equal to the name
        public static final String COLUMN_NAME_CARD_BACK_SOURCE_ID_FOREIGN = "card_back_source_id";
        public static final String COLUMN_NAME_SOURCE_DESC = "source_desc";
        public static final String COLUMN_NAME_ENABLED = "enabled";
        public static final String COLUMN_NAME_PREFAB_NAME = "prefab_name";
    }


    // Created Objects

    public static abstract class Deck implements BaseColumns {
        public static final String TABLE_NAME = "deck";
        public static final String COLUMN_NAME_DECK_ID = "deck_id";
        public static final String COLUMN_NAME_PLAYER_CLASS_ID_FOREIGN = "player_class_id";
        public static final String COLUMN_NAME_CREATION_TIMESTAMP = "creation_timestamp";
    }

    // How to get all constructed decks (under 'Relation Scheme Diagram'): http://www.tomjewett.com/dbdesign/dbdesign.php?page=subclass.php
    public static abstract class ConstructedDeck implements BaseColumns {
        public static final String TABLE_NAME = "constructed_deck";
        public static final String COLUMN_NAME_CONSTRUCTED_DECK_ID_FORIEGN = "deck_id";
        public static final String COLUMN_NAME_DECK_NAME = "name";
        public static final String COLUMN_NAME_HERO_CARD_ID_FOREIGN = "hero_id";
        public static final String COLUMN_NAME_CARD_BACK_ID_FOREIGN = "card_back_id";
        public static final String COLUMN_NAME_BOOKMARKED = "bookmarked";
        public static final String COLUMN_NAME_ORDINAL = "ordinal";
    }

    public static abstract class ConstructedDeckEdit implements BaseColumns {
        public static final String TABLE_NAME = "deck_edit";
        public static final String COLUMN_NAME_CONSTRUCTED_DECK_EDIT_ID = "constructed_deck_edit_id";
        public static final String COLUMN_NAME_CONSTRUCTED_DECK_ID_FOREIGN = "constructed_deck_id";
        public static final String COLUMN_NAME_EDIT_TIME_STAMP = "edit_timestamp";
    }

    public static abstract class DeckMatchResult implements BaseColumns {
        public static final String TABLE_NAME = "deck_match_result";
        public static final String COLUMN_NAME_DECK_MATCH_RESULT_ID = "deck_match_result_id";
        public static final String COLUMN_NAME_DECK_ID_FOREIGN = "deck_id";
        public static final String COLUMN_NAME_RESULT = "result";
        public static final String COLUMN_NAME_ENEMY_CLASS_ID_FOREIGN = "enemy_class_id";
        public static final String COLUMN_NAME_ENEMY_DECK_ARCHETYPE = "enemy_deck_archetype";
        public static final String COLUMN_NAME_STARTED_WITH_COIN = "started_with_coin";
    }

    public static abstract class ArenaRun implements BaseColumns {
        public static final String TABLE_NAME = "arena_run";
        public static final String COLUMN_NAME_ARENA_RUN_ID = "arena_run_id";
        public static final String COLUMN_NAME_DECK_ID_FOREIGN = "deck_id";
        public static final String COLUMN_NAME_COMPLETION_TIMESTAMP = "completion_timestamp";
        public static final String COLUMN_NAME_PAYMENT_METHOD = "payment_method";

        //Reward
        public static final String COLUMN_NAME_REWARD_GOLD = "reward_gold";
        public static final String COLUMN_NAME_REWARD_DUST = "reward_dust";
        public static final String COLUMN_NAME_REWARD_PACKS = "reward_packs";

        //TODO Link card rewards
    }

    // Booster Pack Table


    // Composite Tables

    public static abstract class DeckCard implements BaseColumns {
        public static final String TABLE_NAME = "deck_card";
        public static final String COLUMN_NAME_DECK_ID_COMPOSITE = "deck_id";
        public static final String COLUMN_NAME_CARD_ID_COMPOSITE = "card_id";
        public static final String COLUMN_NAME_CARD_QUANTITY = "card_quantity";
    }

    public static abstract class DeckEditCard implements BaseColumns {
        public static final String TABLE_NAME = "deck_edit_card";
        public static final String COLUMN_NAME_DECK_EDIT_CARD_ID = "deck_edit_card_id";
        public static final String COLUMN_NAME_CARD_ID_FOREIGN = "card_id";
        public static final String COLUMN_NAME_CARD_QUANTITY_DIFFERENCE = "card_quantity_difference";
    }

    public static abstract class CardLocale implements BaseColumns {
        public static final String TABLE_NAME = "card_locale";
        public static final String COLUMN_NAME_CARD_ID_COMPOSITE = "card_id";
        public static final String COLUMN_NAME_LOCALE_ID_COMPOSITE = "locale_id";
        public static final String COLUMN_NAME_CARD_NAME = "card_name";
        public static final String COLUMN_NAME_CARD_TEXT = "card_text";
        public static final String COLUMN_NAME_CARD_FLAVOR = "card_flavor";
        public static final String COLUMN_NAME_CARD_HOW_TO_EARN = "card_how_to_earn";
        public static final String COLUMN_NAME_CARD_HOW_TO_EARN_GOLDEN = "card_how_to_earn_golden";

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_CARD_ID_COMPOSITE + TYPE_TEXT + COMMA_SEP +
                        COLUMN_NAME_LOCALE_ID_COMPOSITE + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_CARD_NAME + TYPE_TEXT + COMMA_SEP +
                        COLUMN_NAME_CARD_TEXT + TYPE_TEXT + COMMA_SEP +
                        COLUMN_NAME_CARD_FLAVOR + TYPE_TEXT + COMMA_SEP +
                        COLUMN_NAME_CARD_HOW_TO_EARN + TYPE_TEXT + COMMA_SEP +
                        COLUMN_NAME_CARD_HOW_TO_EARN_GOLDEN + TYPE_TEXT + COMMA_SEP +
                        CompositeKey(COLUMN_NAME_CARD_ID_COMPOSITE, COLUMN_NAME_LOCALE_ID_COMPOSITE) +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class CardBackLocale implements BaseColumns {
        public static final String TABLE_NAME = "card_back_locale";
        public static final String COLUMN_NAME_CARD_BACK_ID_COMPOSITE = "card_back_id";
        public static final String COLUMN_NAME_LOCALE_ID_COMPOSITE = "locale_id";
        public static final String COLUMN_NAME_CARD_BACK_NAME = "name";
        public static final String COLUMN_NAME_CARD_BACK_DESCRIPTION = "card_back_description";
    }

    public static abstract class CardMechanic implements BaseColumns {
        public static final String TABLE_NAME = "card_mechanic";
        public static final String COLUMN_NAME_CARD_ID_COMPOSITE = "card_id";
        public static final String COLUMN_NAME_MECHANIC_ID_COMPOSITE = "mechanic_id";
    }

    public static abstract class CardEntourage implements BaseColumns {
        public static final String TABLE_NAME = "card_entourage";
        public static final String COLUMN_NAME_CARD_ID_COMPOSITE = "card_id";
        public static final String COLUMN_NAME_ENTOURAGE_ID_COMPOSITE = "entourage_id";
    }

    public static abstract class CardPlayRequirement implements BaseColumns {
        public static final String TABLE_NAME = "card_play_requirement";
        public static final String COLUMN_NAME_CARD_ID_COMPOSITE = "card_id";
        public static final String COLUMN_NAME_PLAY_REQUIREMENT_ID_COMPOSITE = "play_requirement_id";
        public static final String COLUMN_NAME_PLAY_REQUIREMENT_PARAMETER = "play_requirement_parameter";
    }


    // Enums

    public static abstract class CardType implements BaseColumns {
        public static final String TABLE_NAME = "card_type";
        public static final String COLUMN_NAME_CARD_TYPE_ID = "card_type_id";
        public static final String COLUMN_NAME_TYPE_NAME = "type_name";

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_CARD_TYPE_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_TYPE_NAME + TYPE_TEXT +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class CardSet implements BaseColumns {
        public static final String TABLE_NAME = "card_set";
        public static final String COLUMN_NAME_CARD_SET_ID = "card_set_id";
        public static final String COLUMN_NAME_SET_NAME = "name";
        public static final String COLUMN_NAME_SET_TYPE_FOREIGN = "card_set_type_id";
        public static final String COLUMN_NAME_RELEASE_YEAR = "release_year";

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_CARD_SET_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_SET_NAME + TYPE_TEXT + COMMA_SEP +
                        COLUMN_NAME_SET_TYPE_FOREIGN + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_RELEASE_YEAR + TYPE_INTEGER + COMMA_SEP +
                        ForeignKey(COLUMN_NAME_SET_TYPE_FOREIGN, CardSetType.TABLE_NAME, CardSetType.COLUMN_NAME_CARD_SET_TYPE_ID) +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class CardSetType implements BaseColumns {
        public static final String TABLE_NAME = "card_set_type";
        public static final String COLUMN_NAME_CARD_SET_TYPE_ID = "card_set_type_id";
        public static final String COLUMN_NAME_TYPE_NAME = "name"; // CORE, EXPANSION, ADVENTURE, GIFT, GAME (TB, Debug, Credits...)

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_CARD_SET_TYPE_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_TYPE_NAME + TYPE_TEXT +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class PlayerClass implements BaseColumns {
        public static final String TABLE_NAME = "player_class";
        public static final String COLUMN_NAME_PLAYER_CLASS_ID = "player_class_id";
        public static final String COLUMN_NAME_PLAYER_CLASS_NAME = "name";

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_PLAYER_CLASS_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_PLAYER_CLASS_NAME + TYPE_TEXT +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class Rarity implements BaseColumns {
        public static final String TABLE_NAME = "rarity_id";
        public static final String COLUMN_NAME_RARITY_ID = "rarity_id";
        public static final String COLUMN_NAME_RARITY_NAME = "name";
        public static final String COLUMN_NAME_CRAFT_COST = "craft_cost";
        public static final String COLUMN_NAME_CRAFT_GOLDEN_COST = "craft_golden_cost";
        public static final String COLUMN_NAME_DISENCHANT_VALUE = "disenchant_value";
        public static final String COLUMN_NAME_DISENCHANT_GOLDEN_VALUE = "disenchant_golden_value";

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_RARITY_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_RARITY_NAME + TYPE_TEXT + COMMA_SEP +
                        COLUMN_NAME_CRAFT_COST + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_CRAFT_GOLDEN_COST + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_DISENCHANT_VALUE + TYPE_INTEGER + COMMA_SEP +
                        COLUMN_NAME_DISENCHANT_GOLDEN_VALUE + TYPE_INTEGER +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class Race implements BaseColumns {
        public static final String TABLE_NAME = "race";
        public static final String COLUMN_NAME_RACE_ID = "race_id";
        public static final String COLUMN_NAME_RACE_NAME = "name";

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_RACE_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_RACE_NAME + TYPE_TEXT +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class Mechanic implements BaseColumns {
        public static final String TABLE_NAME = "mechanic";
        public static final String COLUMN_NAME_MECHANIC_ID = "mechanic_id";
        public static final String COLUMN_NAME_MECHANIC_NAME = "name";

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_MECHANIC_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_MECHANIC_NAME + TYPE_TEXT +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class Faction implements BaseColumns {
        public static final String TABLE_NAME = "faction";
        public static final String COLUMN_NAME_FACTION_ID = "faction_id";
        public static final String COLUMN_NAME_FACTION_NAME = "name";

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_FACTION_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_FACTION_NAME + TYPE_TEXT +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class PlayRequirement implements BaseColumns {
        public static final String TABLE_NAME = "play_requirement";
        public static final String COLUMN_NAME_PLAY_REQUIREMENT_ID = "play_requirement_id";
        public static final String COLUMN_NAME_PLAY_REQUIREMENT_NAME = "name";

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_PLAY_REQUIREMENT_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_PLAY_REQUIREMENT_NAME + TYPE_TEXT +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class Locale implements BaseColumns {
        public static final String TABLE_NAME = "locale";
        public static final String COLUMN_NAME_LOCALE_ID = "locale_id";
        public static final String COLUMN_NAME_LOCALE_NAME = "name";
        // track if a Right-to-Left language?

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_LOCALE_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_LOCALE_NAME + TYPE_TEXT +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    // TODO Create enum: startup, achieve, fixed_reward, season
    public static abstract class CardBackSource implements BaseColumns {
        public static final String TABLE_NAME = "card_back_source";
        public static final String COLUMN_NAME_CARD_BACK_SOURCE_ID = "card_back_source_id";
        public static final String COLUMN_NAME_CARD_BACK_SOURCE_NAME = "name";

        public static final String CREATE_TABLE_SQL =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_CARD_BACK_SOURCE_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_CARD_BACK_SOURCE_NAME + TYPE_TEXT +
                        " )";
        public static final String DELETE_TABLE_SQL =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
