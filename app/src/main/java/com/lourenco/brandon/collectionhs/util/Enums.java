package com.lourenco.brandon.collectionhs.util;

/**
 * Created by Brandon on 2016-03-13.
 */
public class Enums {

    public enum CardClass
    {
        DRUID(2),
        HUNTER(3),
        MAGE(4),
        PALADIN(5),
        PRIEST(6),
        ROGUE(7),
        SHAMAN(8),
        WARLOCK(9),
        WARRIOR(10),
        NEUTRAL(0),
        DEATHKNIGHT(1);
        //DREAM,
        //COUNT,
        /* TODO NEUTRAL = INVALID */

        private int classId;
        CardClass(int id) {classId = id; }
        public int getValue() {return classId;}
    }

    /**
     * Classes actually used by the game, in order.
     */
    public enum CardClassOrdered
    {
        DRUID,
        HUNTER,
        MAGE,
        PALADIN,
        PRIEST,
        ROGUE,
        SHAMAN,
        WARLOCK,
        WARRIOR,
        NEUTRAL
    }

    public enum CardSet
    {
        INVALID,
        TEST_TEMPORARY,
        CORE,
        EXPERT1,
        REWARD,
        MISSIONS,
        DEMO,
        NONE,
        CHEAT,
        BLANK,
        DEBUG_SP,
        PROMO,
        NAXX,
        GVG,
        BRM,
        TGT,
        CREDITS,
        HERO_SKINS,
        TB,
        SLUSH,
        LOE

        /* TODO FP1 = 12, PE1 = 13, FP2 = BRM, PE2 = TGT */

        /* TODO Mark which sets are craftable */
    }

    public enum CardType
    {
        INVALID,
        GAME,
        PLAYER,
        HERO,
        MINION,
        SPELL,
        ENCHANTMENT,
        WEAPON,
        ITEM,
        TOKEN,
        HERO_POWER,
        /*
        TODO ABILITY = SPELL
        TODO Mark minions, spells, weapons as craftable
        */

    }

    public enum Faction
    {
        INAVLID,
        HORDE,
        ALLIANCE,
        NEUTRAL
    }

    public enum PlayReq
    {
        REQ_MINION_TARGET,
        REQ_FRIENDLY_TARGET,
        REQ_ENEMY_TARGET,
        REQ_DAMAGED_TARGET,
        REQ_ENCHANTED_TARGET,
        REQ_FROZEN_TARGET,
        REQ_CHARGE_TARGET,
        REQ_TARGET_MAX_ATTACK,
        REQ_NONSELF_TARGET,
        REQ_TARGET_WITH_RACE,
        REQ_TARGET_TO_PLAY ,
        REQ_NUM_MINION_SLOTS,
        REQ_WEAPON_EQUIPPED,
        REQ_ENOUGH_MANA,
        REQ_YOUR_TURN,
        REQ_NONSTEALTH_ENEMY_TARGET,
        REQ_HERO_TARGET,
        REQ_SECRET_CAP,
        REQ_MINION_CAP_IF_TARGET_AVAILABLE,
        REQ_MINION_CAP,
        REQ_TARGET_ATTACKED_THIS_TURN,
        REQ_TARGET_IF_AVAILABLE,
        REQ_MINIMUM_ENEMY_MINIONS,
        REQ_TARGET_FOR_COMBO,
        REQ_NOT_EXHAUSTED_ACTIVATE,
        REQ_UNIQUE_SECRET,
        REQ_TARGET_TAUNTER,
        REQ_CAN_BE_ATTACKED,
        REQ_ACTION_PWR_IS_MASTER_PWR,
        REQ_TARGET_MAGNET,
        REQ_ATTACK_GREATER_THAN_0,
        REQ_ATTACKER_NOT_FROZEN ,
        REQ_HERO_OR_MINION_TARGET,
        REQ_CAN_BE_TARGETED_BY_SPELLS,
        REQ_SUBCARD_IS_PLAYABLE,
        REQ_TARGET_FOR_NO_COMBO,
        REQ_NOT_MINION_JUST_PLAYED,
        REQ_NOT_EXHAUSTED_HERO_POWER,
        REQ_CAN_BE_TARGETED_BY_OPPONENTS,
        REQ_ATTACKER_CAN_ATTACK,
        REQ_TARGET_MIN_ATTACK,
        REQ_CAN_BE_TARGETED_BY_HERO_POWERS,
        REQ_ENEMY_TARGET_NOT_IMMUNE,
        REQ_ENTIRE_ENTOURAGE_NOT_IN_PLAY,
        REQ_MINIMUM_TOTAL_MINIONS,
        REQ_MUST_TARGET_TAUNTER,
        REQ_UNDAMAGED_TARGET,
        REQ_CAN_BE_TARGETED_BY_BATTLECRIES,
        REQ_STEADY_SHOT,
        REQ_MINION_OR_ENEMY_HERO,
        REQ_TARGET_IF_AVAILABLE_AND_DRAGON_IN_HAND,
        REQ_LEGENDARY_TARGET,
        REQ_FRIENDLY_MINION_DIED_THIS_TURN,
        REQ_FRIENDLY_MINION_DIED_THIS_GAME,
        REQ_ENEMY_WEAPON_EQUIPPED,
        REQ_TARGET_IF_AVAILABLE_AND_MINIMUM_FRIENDLY_MINIONS,
        REQ_TARGET_WITH_BATTLECRY,
        REQ_TARGET_WITH_DEATHRATTLE,
        REQ_DRAG_TO_PLAY
    }

    public enum Race
    {
        INVALID,
        BLOODELF,
        DRAENEI,
        DWARF,
        GNOME,
        GOBLIN,
        HUMAN,
        NIGHTELF,
        ORC,
        TAUREN,
        TROLL,
        UNDEAD,
        WORGEN,
        GOBLIN2,
        MURLOC,
        DEMON,
        SCOURGE,
        MECHANICAL,
        ELEMENTAL,
        OGRE,
        BEAST,
        TOTEM,
        NERUBIAN,
        PIRATE,
        DRAGON,
        /* TODO PET = BEAST */
    }

    public enum Rarity
    {
        INVALID,
        COMMON,
        FREE,
        RARE,
        EPIC,
        LEGENDARY,

        UNKNOWN_6 // TB_BlingBrawl_Blade1e (10956)

        /* TODO Mark which are craftable, and crafting/disenchanting values */
    }

    public enum Booster
    {
        INVALID(0),
        CLASSIC(1),
        GOBLINS_VS_GNOMES(9),
        THE_GRAND_TOURNAMENT(10);

        private int booster;
        Booster(int id) {this.booster = booster; }
        public int getValue() {return booster;}
    }

    public enum Locale
    {
        enUS,
        enGB,
        frFR,
        deDE,
        koKR,
        esES,
        esMX,
        ruRU,
        zhTW,
        zhCN,
        itIT,
        ptBR,
        plPL,
        ptPT,
        jaJP
    }
}
