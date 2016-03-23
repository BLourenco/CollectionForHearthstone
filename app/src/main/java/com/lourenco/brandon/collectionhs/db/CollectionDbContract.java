package com.lourenco.brandon.collectionhs.db;

import android.provider.BaseColumns;

/**
 * Created by Brandon on 2016-03-22.
 */
public final class CollectionDbContract {

    // To prevent someone from accidentally instantiating the contract class, give it an
    // empty constructor.
    public CollectionDbContract() {}

    // Inner classes represent tables


    // JSON Objects

    public static abstract class Card implements BaseColumns {

        // Commented columns are localized string data held in the CardLocale table.

        public static final String TABLE_NAME = "card";
        public static final String COLUMN_NAME_CARD_ID = "card_id";
        public static final String COLUMN_NAME_CARD_TYPE_FOREIGN = "card_type_id";
        public static final String COLUMN_NAME_COLLECTIBLE = "collectible";
        public static final String COLUMN_NAME_CARD_SET_FOREIGN = "card_set_id";
        public static final String COLUMN_NAME_PLAYER_CLASS_FOREIGN = "player_class_id";
        public static final String COLUMN_NAME_RARITY_FOREIGN = "rarity_id";
        //public static final String COLUMN_NAME_CARD_NAME = "name";
        //public static final String COLUMN_NAME_TEXT = "text";
        public static final String COLUMN_NAME_COST = "cost";
        public static final String COLUMN_NAME_ATTACK = "attack";
        public static final String COLUMN_NAME_HEALTH = "health"; // will also hold durability
        public static final String COLUMN_NAME_RACE_FOREIGN = "race_id";
        public static final String COLUMN_NAME_MECHANICS_FOREIGN = "mechanics_id";
        //public static final String COLUMN_NAME_FLAVOR = "flavor";
        //public static final String COLUMN_NAME_HOW_TO_EARN = "how_to_earn";
        //public static final String COLUMN_NAME_HOW_TO_EARN_GOLDEN = "how_to_earn_golden";
        public static final String COLUMN_NAME_ENTOURAGE = "entourage"; // may not need, can simply look for the card's id in the entourage table.
        public static final String COLUMN_NAME_ARTIST = "artist";
        public static final String COLUMN_NAME_FACTION_FOREIGN = "faction_id";

        public static final String COLUMN_NAME_COLLECTED = "collected";
        public static final String COLUMN_NAME_COLLECTED_GOLDEN = "collected_golden";
        public static final String COLUMN_NAME_BOOKMARKED = "bookmarked";
    }

    public static abstract class CardBack implements BaseColumns {

        // Commented columns are localized string data held in the CardBackLocale table.

        public static final String TABLE_NAME = "card_back";
        public static final String COLUMN_NAME_CARD_BACK_ID = "card_back_id";
        //public static final String COLUMN_NAME_NAME = "name";
        //public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_NOTE_DESC = "note_desc"; // seem to always be equal to the name
        public static final String COLUMN_NAME_SOURCE = "source"; // Can be one of 'achieve', 'fixed_reward', or 'season'.
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

    //TODO Research if this design makes sense (maybe the Deck Id alone can be used to identify a record in this table.
    public static abstract class ConstructedDeck implements BaseColumns {
        public static final String TABLE_NAME = "constructed_deck";
        public static final String COLUMN_NAME_CONSTRUCTED_DECK_ID = "constructed_deck_id";
        public static final String COLUMN_NAME_DECK_ID_COMPOSITE = "deck_id";
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

        //Reward
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
    }

    public static abstract class CardSet implements BaseColumns {
        public static final String TABLE_NAME = "card_set";
        public static final String COLUMN_NAME_CARD_SET_ID = "card_set_id";
        public static final String COLUMN_NAME_SET_NAME = "name";
        public static final String COLUMN_NAME_SET_TYPE_FOREIGN = "card_set_type_id";
        public static final String COLUMN_NAME_RELEASE_YEAR = "release_year";
    }

    public static abstract class CardSetType implements BaseColumns {
        public static final String TABLE_NAME = "card_set_type";
        public static final String COLUMN_NAME_CARD_SET_TYPE_ID = "card_set_type_id";
        public static final String COLUMN_NAME_TYPE_NAME = "name"; // CORE, EXPANSION, ADVENTURE, PROMO, GAME (TB, Debug, Credits...)
    }

    public static abstract class PlayerClass implements BaseColumns {
        public static final String TABLE_NAME = "player_class";
        public static final String COLUMN_NAME_PLAYER_CLASS_ID = "player_class_id";
        public static final String COLUMN_NAME_PLAYER_CLASS_NAME = "name";
    }

    public static abstract class Rarity implements BaseColumns {
        public static final String TABLE_NAME = "rarity_id";
        public static final String COLUMN_NAME_RARITY_ID = "rarity_id";
        public static final String COLUMN_NAME_RARITY_NAME = "name";
        public static final String COLUMN_NAME_CRAFT_COST = "craft_cost";
        public static final String COLUMN_NAME_CRAFT_GOLDEN_COST = "craft_golden_cost";
        public static final String COLUMN_NAME_DISENCHANT_VALUE = "disenchant_value";
        public static final String COLUMN_NAME_DISENCHANT_GOLDEN_VALUE = "disenchant_value";
    }

    public static abstract class Race implements BaseColumns {
        public static final String TABLE_NAME = "race";
        public static final String COLUMN_NAME_RACE_ID = "race_id";
        public static final String COLUMN_NAME_RACE_NAME = "name";
    }

    public static abstract class Mechanic implements BaseColumns {
        public static final String TABLE_NAME = "mechanic";
        public static final String COLUMN_NAME_MECHANIC_ID = "mechanic_id";
        public static final String COLUMN_NAME_MECHANIC_NAME = "name";
    }

    public static abstract class Faction implements BaseColumns {
        public static final String TABLE_NAME = "faction";
        public static final String COLUMN_NAME_FACTION_ID = "faction_id";
        public static final String COLUMN_NAME_FACTION_NAME = "name";
    }

    public static abstract class PlayRequirement implements BaseColumns {
        public static final String TABLE_NAME = "play_requirement";
        public static final String COLUMN_NAME_PLAY_REQUIREMENT_ID = "play_requirement_id";
        public static final String COLUMN_NAME_PLAY_REQUIREMENT_NAME = "name";
    }

    public static abstract class Locale implements BaseColumns {
        public static final String TABLE_NAME = "locale";
        public static final String COLUMN_NAME_LOCALE_ID = "locale_id";
        public static final String COLUMN_NAME_LOCALE_NAME = "name";
        // track if a Right-to-Left language?
    }
}
