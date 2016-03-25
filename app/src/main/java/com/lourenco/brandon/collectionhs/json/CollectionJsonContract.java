package com.lourenco.brandon.collectionhs.json;

/**
 * Created by Brandon on 2016-03-24.
 */
public class CollectionJsonContract {

    public static abstract class CardJson {
        //private static final String RESOURCE_NAME = "cards";
        private static final String KEY_ID = "id";
        private static final String KEY_RARITY = "rarity";
        private static final String KEY_FACTION = "faction";
        private static final String KEY_SET = "set";
        private static final String KEY_PLAYER_CLASS = "playerClass";
        private static final String KEY_TYPE = "type";
        private static final String KEY_RACE = "race";

        private static final String KEY_NAME = "name";
        private static final String KEY_TEXT = "text";
        private static final String KEY_FLAVOR = "flavor";
        private static final String KEY_HOW_TO_EARN = "howToEarn";
        private static final String KEY_HOW_TO_EARN_GOLDEN = "howToEarnGolden";

        private static final String KEY_TARGETING_ARROW_TEXT = "targetingArrowText";
        private static final String KEY_TEXT_IN_PLAY = "textInPlay";

        private static final String KEY_COLLECTIBLE = "collectible";
        private static final String KEY_COST = "cost";
        private static final String KEY_ATTACK = "attack";
        private static final String KEY_HEALTH = "health";
        private static final String KEY_DURABILITY = "durability";
        private static final String KEY_DUST = "dust";

        private static final String KEY_MECHANICS = "mechanics";
        private static final String KEY_PLAY_REQUIREMENTS = "playRequirements";
        private static final String KEY_ENTOURAGE = "entourage";
    }

    public static abstract class CardBacksJson {
        private static final String KEY_ID = "id";
        private static final String KEY_NAME = "name";
        private static final String KEY_DESCRIPTION = "description";
        private static final String KEY_NOTE_DESC = "note_desc";
        private static final String KEY_SOURCE = "source";
        private static final String KEY_SOURCE_DESCRIPTION = "source_description";
        private static final String KEY_ENABLED = "enabled";
        private static final String KEY_PREFAB_NAME = "prefab_name";
    }
}
