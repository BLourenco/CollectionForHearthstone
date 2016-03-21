package com.lourenco.brandon.collectionhs.hearthstone;

/**
 * Created by Brandon on 2016-03-13.
 */
public class EnumsHS {

    public enum CardClass
    {
        DRUID(2, 0),
        HUNTER(3,1),
        MAGE(4,2),
        PALADIN(5,3),
        PRIEST(6,4),
        ROGUE(7,5),
        SHAMAN(8,6),
        WARLOCK(9,7),
        WARRIOR(10,8),
        NEUTRAL(0,9),

        INVALID(0,-1),

        DEATHKNIGHT(1,-1),

        DREAM(11,-1),
        COUNT(12,-1);


        private int classId;
        private int ordinal;
        CardClass(int id, int ordinal) {classId = id; this.ordinal = ordinal;}
        public int getValue() {return classId;}
        public int getOrdinal() {return ordinal;}
        public static CardClass getClassAtOrdinal (int ordinal)
        {
            for (CardClass cc : CardClass.values()) {
                if (cc.ordinal == ordinal) return cc;
            }
            return CardClass.INVALID;
        }
    }

    public enum CardSet
    {
        INVALID(0, false, false, 0),

        CORE(2, false, false, 2014),
        EXPERT1(3, true, false, 2014),
        REWARD(4, true, false, 2014),
        PROMO(11, true, false, 2014),
        NAXX(12, true, true, 2014),
        GVG(13, true, false, 2014),
        BRM(14, true, true, 2015),
        TGT(15, true, false, 2015),
        LOE(20, true, false, 2015),
        WOG(21, true, false, 2016),

        HERO_SKINS(17, false, false, 2015),
        TB(18, false, false, 2015),

        TEST_TEMPORARY(1, false, false, 0),
        MISSIONS(5, false, false, 0),
        DEMO(6, false, false, 0),
        NONE(7, false, false, 0),
        CHEAT(8, false, false, 0),
        BLANK(9, false, false, 0),
        DEBUG_SP(10, false, false, 0),
        CREDITS(16, false, false, 0),
        SLUSH(19, false, false, 0),

        // Aliased from the original enums
        FP1(NAXX.getValue(), NAXX.isCraftable(), NAXX.isAdventure(), NAXX.getReleaseYear()),
        PE1(GVG.getValue(), GVG.isCraftable(), GVG.isAdventure(), GVG.getReleaseYear()),

        //Renamed
        FP2(BRM.getValue(), BRM.isCraftable(), BRM.isAdventure(), BRM.getReleaseYear()),
        PE2(TGT.getValue(), TGT.isCraftable(), TGT.isAdventure(), TGT.getReleaseYear());

        private int value;
        private boolean craftable;
        private int releaseYear;
        private boolean adventure;

        private static final int LATEST_RELEASE = 2016;
        private static final int SET_ROTATION_LENGTH_YRS = 2;

        CardSet(int value, boolean craftable, boolean adventure, int releaseYear) {
            this.value = value;
            this.craftable = craftable;
            this.adventure = adventure;
            this.releaseYear = releaseYear;
        }

        public int getValue() {return value;}
        public boolean isAdventure() {return adventure;}
        public int getReleaseYear() {return  releaseYear;}
        public boolean isCraftable() {
            if (!craftable) return false;
            else if (adventure && isStandard()) {
                return false;
            }
            return true;
        }
        public boolean isStandard() {
            if (name().equals("CORE") ||
                    name().equals("EXPERT1") ||
                    name().equals("HERO_SKINS"))
                return true;
            return releaseYear >= (LATEST_RELEASE - SET_ROTATION_LENGTH_YRS);
        }
        public boolean isForPurchase() {
            return adventure && isStandard();
        }

    }

    public enum CardType
    {
        INVALID(0, false),

        MINION(4, true),
        SPELL(5, true),
        WEAPON(7, true),
        HERO(3, false),
        HERO_POWER(10, false),
        ENCHANTMENT(6, false),

        GAME(1, false),
        PLAYER(2, false),
        ITEM(8, false),
        TOKEN(9, false),

        // Renamed
        ABILITY(SPELL.getValue(), SPELL.isCraftable());

        private int value;
        private boolean craftable;

        CardType(int value, boolean craftable) {
            this.value = value;
            this.craftable = craftable;
        }

        public int getValue() {return value;}
        public boolean isCraftable(){return craftable;}

    }

    public enum Faction
    {
        INAVLID(0),
        HORDE(1),
        ALLIANCE(2),
        NEUTRAL(3);

        private int value;
        Faction(int value) {
            this.value = value;
        }
        public int getValue() {return value;}
    }

    public enum PlayReq
    {
        //TODO Include a boolean to tell if the requirement uses it's associated parameter
        REQ_MINION_TARGET(1),
        REQ_FRIENDLY_TARGET(2),
        REQ_ENEMY_TARGET(3),
        REQ_DAMAGED_TARGET(4),
        REQ_ENCHANTED_TARGET(5),
        REQ_FROZEN_TARGET(6),
        REQ_CHARGE_TARGET(7),
        REQ_TARGET_MAX_ATTACK(8),
        REQ_NONSELF_TARGET(9),
        REQ_TARGET_WITH_RACE(10),
        REQ_TARGET_TO_PLAY(11),
        REQ_NUM_MINION_SLOTS(12),
        REQ_WEAPON_EQUIPPED(13),
        REQ_ENOUGH_MANA(14),
        REQ_YOUR_TURN(15),
        REQ_NONSTEALTH_ENEMY_TARGET(16),
        REQ_HERO_TARGET(17),
        REQ_SECRET_CAP(18),
        REQ_MINION_CAP_IF_TARGET_AVAILABLE(19),
        REQ_MINION_CAP(20),
        REQ_TARGET_ATTACKED_THIS_TURN(21),
        REQ_TARGET_IF_AVAILABLE(22),
        REQ_MINIMUM_ENEMY_MINIONS(23),
        REQ_TARGET_FOR_COMBO(24),
        REQ_NOT_EXHAUSTED_ACTIVATE(25),
        REQ_UNIQUE_SECRET(26),
        REQ_TARGET_TAUNTER(27),
        REQ_CAN_BE_ATTACKED(28),
        REQ_ACTION_PWR_IS_MASTER_PWR(29),
        REQ_TARGET_MAGNET(30),
        REQ_ATTACK_GREATER_THAN_0(31),
        REQ_ATTACKER_NOT_FROZEN(32),
        REQ_HERO_OR_MINION_TARGET(33),
        REQ_CAN_BE_TARGETED_BY_SPELLS(34),
        REQ_SUBCARD_IS_PLAYABLE(35),
        REQ_TARGET_FOR_NO_COMBO(36),
        REQ_NOT_MINION_JUST_PLAYED(37),
        REQ_NOT_EXHAUSTED_HERO_POWER(38),
        REQ_CAN_BE_TARGETED_BY_OPPONENTS(39),
        REQ_ATTACKER_CAN_ATTACK(40),
        REQ_TARGET_MIN_ATTACK(41),
        REQ_CAN_BE_TARGETED_BY_HERO_POWERS(42),
        REQ_ENEMY_TARGET_NOT_IMMUNE(43),
        REQ_ENTIRE_ENTOURAGE_NOT_IN_PLAY(44),
        REQ_MINIMUM_TOTAL_MINIONS(45),
        REQ_MUST_TARGET_TAUNTER(46),
        REQ_UNDAMAGED_TARGET(47),
        REQ_CAN_BE_TARGETED_BY_BATTLECRIES(48),
        REQ_STEADY_SHOT(49),
        REQ_MINION_OR_ENEMY_HERO(50),
        REQ_TARGET_IF_AVAILABLE_AND_DRAGON_IN_HAND(51),
        REQ_LEGENDARY_TARGET(52),
        REQ_FRIENDLY_MINION_DIED_THIS_TURN(53),
        REQ_FRIENDLY_MINION_DIED_THIS_GAME(54),
        REQ_ENEMY_WEAPON_EQUIPPED(55),
        REQ_TARGET_IF_AVAILABLE_AND_MINIMUM_FRIENDLY_MINIONS(56),
        REQ_TARGET_WITH_BATTLECRY(57),
        REQ_TARGET_WITH_DEATHRATTLE(58),
        REQ_DRAG_TO_PLAY(59);

        private int value;
        PlayReq(int value) {
            this.value = value;
        }
        public int getValue() {return value;}
    }

    public enum Race
    {
        INVALID(0),

        MURLOC(14),
        DEMON(15),
        MECHANICAL(17),
        BEAST(20),
        TOTEM(21),
        PIRATE(23),
        DRAGON(24),

        // Currently unused
        BLOODELF(1),
        DRAENEI(2),
        DWARF(3),
        GNOME(4),
        GOBLIN(5),
        HUMAN(6),
        NIGHTELF(7),
        ORC(8),
        TAUREN(9),
        TROLL(10),
        UNDEAD(11),
        WORGEN(12),
        GOBLIN2(13),
        SCOURGE(16),
        ELEMENTAL(18),
        OGRE(19),
        NERUBIAN(22),

        // Aliased
        PET(BEAST.getValue());

        private int value;
        Race(int value) {
            this.value = value;
        }
        public int getValue() {return value;}
    }

    public enum Rarity
    {
        INVALID(0, false, new int[]{0,0,0,0}),
                                                            // Refund Value
        FREE(2, false,      new int[]{   0,   0,  0,   0}),
        COMMON(1, true,     new int[]{  40, 400,  5,  50}), // 12.5% | 12.5%
        RARE(3, true,       new int[]{ 100, 800, 20, 100}), // 20.0% | 12.5%
        EPIC(4, true,       new int[]{ 400,1600,100, 400}), // 25.0% | 25.0%
        LEGENDARY(5, true,  new int[]{1600,3200,400,1600}), // 25.0% | 50.0%

        UNKNOWN_6(6, false, new int[]{0,0,0,0});

        private int value;
        private boolean craftable;
        private int[] dustValue;
        Rarity(int value, boolean craftable, int[] dustValue) {
            this.value = value;
            this.craftable = craftable;
            this.dustValue = dustValue;
        }
        public int getValue() {return value;}
        public boolean isCraftable() {return craftable;}
        public int getCraftCost() {return dustValue[0];}
        public int getCraftGoldenCost() {return dustValue[1];}
        public int getDisenchantValue() {return dustValue[2];}
        public int getDisenchantGoldenValue() {return dustValue[3];}
        public int[] getDustValues() {return dustValue;}
    }

    public enum Booster
    {
        INVALID(0, CardSet.INVALID),
        CLASSIC(1, CardSet.EXPERT1),
        GOBLINS_VS_GNOMES(9, CardSet.GVG),
        THE_GRAND_TOURNAMENT(10, CardSet.TGT);

        private int value;
        private CardSet set;
        Booster(int value, CardSet set) {
            this.value = value;
            this.set = set;
        }

        public int getValue() {return value;}
        public CardSet getCardSet() {return set;}
        public boolean isForPurchase() {
            return set.isStandard();
        }
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
