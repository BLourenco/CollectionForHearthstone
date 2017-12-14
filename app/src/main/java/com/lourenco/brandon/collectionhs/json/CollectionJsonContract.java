package com.lourenco.brandon.collectionhs.json;

/**
 * Created by Brandon on 2016-03-24.
 */
public class CollectionJsonContract {

    public static abstract class CardJson {
        //private static final String RESOURCE_NAME = "cards";
        public static final String KEY_ID = "id";
        public static final String KEY_RARITY = "rarity";
        public static final String KEY_FACTION = "faction";
        public static final String KEY_SET = "set";
        public static final String KEY_CARD_CLASS = "cardClass";
        public static final String KEY_TRI_CLASS = "multiClassGroup";
        public static final String KEY_CLASSES = "classes";
        public static final String KEY_TYPE = "type";
        public static final String KEY_RACE = "race";

        public static final String KEY_NAME = "name";
        public static final String KEY_TEXT = "text";
        public static final String KEY_COLLECTION_TEXT = "collectionText";
        public static final String KEY_FLAVOR = "flavor";
        public static final String KEY_HOW_TO_EARN = "howToEarn";
        public static final String KEY_HOW_TO_EARN_GOLDEN = "howToEarnGolden";

        public static final String KEY_TARGETING_ARROW_TEXT = "targetingArrowText";

        public static final String KEY_COLLECTIBLE = "collectible";
        public static final String KEY_COST = "cost";
        public static final String KEY_ATTACK = "attack";
        public static final String KEY_HEALTH = "health";
        public static final String KEY_DURABILITY = "durability";
        public static final String KEY_HIDE_STATS = "hideStats";

        public static final String KEY_MECHANICS = "mechanics";
        public static final String KEY_REFERENCED_TAGS = "referencedTags";
        public static final String KEY_PLAY_REQUIREMENTS = "playRequirements";
        public static final String KEY_ENTOURAGE = "entourage";

        public static final String KEY_ARTIST = "artist";
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
