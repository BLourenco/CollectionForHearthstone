package com.lourenco.brandon.collectionhs.hearthstone;

import android.graphics.Color;

import com.lourenco.brandon.collectionhs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2016-03-13.
 */
public class EnumsHS {

    //TODO Don't hardcode 'getValid...()' methods!
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

        INVALID(0,-1);

        //DEATHKNIGHT(1,-1),

        //DREAM(11,-1),
        //COUNT(12,-1);


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

        public static CardClass[] getValidClasses() {
            CardClass[] classes = new CardClass[] {
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
            };

            return classes;
        }

        public static CardClass getEnumByValue(int value)
        {
            for (CardClass cardClass : CardClass.values())
            {
                if (value == cardClass.getValue()) return cardClass;
            }
            return INVALID;
        }
    }

    public enum CardSet
    {

        INVALID(0, -1, -1, false, false, false, CardSetType.INVALID, -1, Color.BLACK, -1, -1),

        CORE(2, R.string.set_name_core, R.string.set_acronym_core, false, true, true, CardSetType.CORE, 2014, R.color.setCore, R.drawable.icon_set_core_off, R.drawable.icon_set_core_on),
        EXPERT1(3, R.string.set_name_expert, R.string.set_acronym_expert, true, true, true, CardSetType.CORE, 2014, R.color.setClassic, R.drawable.icon_set_classic_off, R.drawable.icon_set_classic_on),
        HOF(4, R.string.set_name_hof, R.string.set_acronym_hof, true, true, false, CardSetType.CORE, 2017, R.color.setHallOfFame, R.drawable.icon_set_hof_off, R.drawable.icon_set_hof_on),
        NAXX(12, R.string.set_name_naxx, R.string.set_acronym_naxx, true, true, false, CardSetType.ADVENTURE, 2014, R.color.setNaxx, R.drawable.icon_set_naxx_off, R.drawable.icon_set_naxx_on),
        GVG(13, R.string.set_name_gvg, R.string.set_acronym_gvg, true, true, false, CardSetType.EXPANSION, 2014, R.color.setGVG, R.drawable.icon_set_gvg_off, R.drawable.icon_set_gvg_on),
        BRM(14, R.string.set_name_brm, R.string.set_acronym_brm, true, true, false, CardSetType.ADVENTURE, 2015, R.color.setBRM, R.drawable.icon_set_brm_off, R.drawable.icon_set_brm_on),
        TGT(15, R.string.set_name_tgt, R.string.set_acronym_tgt, true, true, false, CardSetType.EXPANSION, 2015, R.color.setTGT, R.drawable.icon_set_tgt_off, R.drawable.icon_set_tgt_on),
        LOE(20, R.string.set_name_loe, R.string.set_acronym_loe, true, true, false, CardSetType.ADVENTURE, 2015, R.color.setLOE, R.drawable.icon_set_loe_off, R.drawable.icon_set_loe_on),
        OG(21, R.string.set_name_wog, R.string.set_acronym_wog, true, true, false, CardSetType.EXPANSION, 2016, R.color.setWOG, R.drawable.icon_set_wog_off, R.drawable.icon_set_wog_on),
        KARA(22, R.string.set_name_onk, R.string.set_acronym_onk, true, true, false, CardSetType.ADVENTURE, 2016, R.color.setKARA, R.drawable.icon_set_onk_off, R.drawable.icon_set_onk_on),
        GANGS(23, R.string.set_name_msg, R.string.set_acronym_msg, true, true, false, CardSetType.EXPANSION, 2016, R.color.setMSG, R.drawable.icon_set_msg_off, R.drawable.icon_set_msg_on),
        UNGORO(24, R.string.set_name_jtu, R.string.set_acronym_jtu, true, true, false, CardSetType.EXPANSION, 2017, R.color.setJTU, R.drawable.icon_set_jtu_off, R.drawable.icon_set_jtu_on),
        ICECROWN(25, R.string.set_name_kft, R.string.set_acronym_kft, true, true, false, CardSetType.EXPANSION, 2017, R.color.setKFT, R.drawable.icon_set_kft_off, R.drawable.icon_set_kft_on),
        LOOTAPALOOZA(26, R.string.set_name_knc, R.string.set_acronym_knc, true, true, false, CardSetType.EXPANSION, 2017, R.color.setKnC, R.drawable.icon_set_knc_off, R.drawable.icon_set_knc_on),

        HERO_SKINS(17, R.string.set_name_hero_skins, R.string.set_acronym_hero_skins, false, true, false, CardSetType.HERO_SKINS, 2015, R.color.setHeroSkins, R.drawable.icon_set_hero_skins, R.drawable.icon_set_hero_skins);

        /*TB(18, false, CardSetType.GAME, 2015),

        REWARD(99, true, CardSetType.GIFT, 2014),
        PROMO(99, true, CardSetType.GIFT, 2014),

        TEST_TEMPORARY(1, false, CardSetType.GAME, 0),
        MISSIONS(5, false, CardSetType.GAME, 0),
        DEMO(6, false, CardSetType.GAME, 0),
        NONE(7, false, CardSetType.GAME, 0),
        CHEAT(8, false, CardSetType.GAME, 0),
        BLANK(9, false, CardSetType.GAME, 0),
        DEBUG_SP(10, false, CardSetType.GAME, 0),
        CREDITS(16, false, CardSetType.GAME, 0),
        SLUSH(19, false, CardSetType.GAME, 0);*/

        // Aliased from the original enums
        //FP1(NAXX.getValue(), NAXX.isCraftable(), NAXX.getSetType(), NAXX.getReleaseYear()),
        //PE1(GVG.getValue(), GVG.isCraftable(), GVG.getSetType(), GVG.getReleaseYear()),

        //Renamed
        //FP2(BRM.getValue(), BRM.isCraftable(), BRM.getSetType(), BRM.getReleaseYear()),
        //PE2(TGT.getValue(), TGT.isCraftable(), TGT.getSetType(), TGT.getReleaseYear());

        private int id;
        private int setName;
        private int setNameAcronym;
        private boolean isCraftable;
        private boolean isCollectible;
        private boolean isAlwaysInStandardSet;
        private CardSetType setType;
        private int releaseYear;

        private int icon;
        private int iconColor;
        private int iconToggleOff;
        private int iconToggleOn;

        public static final int SET_ROTATION_LENGTH_YRS = 2;

        CardSet(int id, int setNameResource, int setNameAcronymResource, boolean isCraftable, boolean isCollectible, boolean isAlwaysInStandardSet, CardSetType setType, int releaseYear, int iconColor, int iconToggleOff, int iconToggleOn) {
            this.id = id;
            this.setName = setNameResource;
            this.setNameAcronym = setNameAcronymResource;
            this.isCraftable = isCraftable;
            this.isCollectible = isCollectible;
            this.setType = setType;
            this.releaseYear = releaseYear;
            this.isAlwaysInStandardSet = isAlwaysInStandardSet;
            this.iconColor = iconColor;
            this.iconToggleOff = iconToggleOff;
            this.iconToggleOn = iconToggleOn;
        }

        public int getLatestRelease()
        {
            int latestRelease = -1;
            for (CardSet set : CardSet.values())
            {
                if (set.getReleaseYear() > latestRelease)
                    latestRelease = set.getReleaseYear();
            }
            return latestRelease;
        }

        public int getId() {return id;}
        public int getSetName() {
            return setName;
        }
        public int getSetNameAcronym() {
            return setNameAcronym;
        }
        public boolean isCraftable() {
            return isCraftable;
        }
        public boolean isCollectible() {
            return isCollectible;
        }
        public boolean isAlwaysInStandardSet() {
            return isAlwaysInStandardSet;
        }
        public CardSetType getSetType() {return setType;}
        public int getReleaseYear() {return  releaseYear;}

        public int getIcon() {
            return iconToggleOff;
        }

        public int getIconColor() {
            return iconColor;
        }

        public int getIconToggleOff() {
            return iconToggleOff;
        }

        public int getIconToggleOn() {
            return iconToggleOn;
        }

        public boolean isStandard() {
            if (isAlwaysInStandardSet)
                return true;
            return releaseYear > (getLatestRelease() - SET_ROTATION_LENGTH_YRS);
        }

        /// Get all sets that players actually play with in regular mode. Ignores tavern brawl, credits, etc. sets
        public static CardSet[] getPlayableSets()
        {
            List<CardSet> sets = new ArrayList<>();

            for (CardSet set : CardSet.values())
            {
                if (set.getSetType() == CardSetType.CORE ||
                        set.getSetType() == CardSetType.ADVENTURE ||
                        set.getSetType() == CardSetType.EXPANSION)
                    sets.add(set);
            }

            return sets.toArray(new CardSet[0]);
        }

        public static CardSet getEnumById(int id)
        {
            for (CardSet cardSet : CardSet.values())
            {
                if (id == cardSet.getId()) return cardSet;
            }
            return INVALID;
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
        ENCHANTMENT(6, false);

        //GAME(1, false),
        //PLAYER(2, false),
        //ITEM(8, false),
        //TOKEN(9, false),

        // Renamed
        //ABILITY(SPELL.getValue(), SPELL.isCraftable());

        private int value;
        private boolean craftable;

        CardType(int value, boolean craftable) {
            this.value = value;
            this.craftable = craftable;
        }

        public int getValue() {return value;}
        public boolean isCraftable(){return craftable;}
        public static CardType[] getValidTypes() {
            CardType[] types = new CardType[] {
                    MINION,
                    SPELL,
                    WEAPON,
                    HERO,
                    HERO_POWER,
                    ENCHANTMENT
            };

            return types;
        }

        public static CardType getEnumByValue(int value)
        {
            for (CardType cardType : CardType.values())
            {
                if (value == cardType.getValue()) return cardType;
            }
            return INVALID;
        }
    }

    public enum Faction
    {
        INVALID(0),
        HORDE(1),
        ALLIANCE(2),
        NEUTRAL(3);

        private int value;
        Faction(int value) {
            this.value = value;
        }
        public int getValue() {return value;}
        public static Faction[] getValidFactions() {
            Faction[] factions = new Faction[] {
                    HORDE,
                    ALLIANCE,
                    NEUTRAL
            };

            return factions;
        }

        public static Faction getEnumByValue(int value)
        {
            for (Faction faction : Faction.values())
            {
                if (value == faction.getValue()) return faction;
            }
            return INVALID;
        }
    }

    public enum PlayReq
    {
        INVALID(0, false, ""),
        REQ_MINION_TARGET(1, false,                                         "Target must be a minion."),
        REQ_FRIENDLY_TARGET(2, false,                                       "Target must be friendly."),
        REQ_ENEMY_TARGET(3, false,                                          "Target must be an enemy."),
        REQ_DAMAGED_TARGET(4, false,                                        "Target must be damaged."),
        REQ_ENCHANTED_TARGET(5, false,                                      "Target must be enchanted"),                            // unused
        REQ_FROZEN_TARGET(6, false,                                         "Target must be <b>Frozen</b>."),                       // unused
        REQ_CHARGE_TARGET(7, false,                                         "Target must have Charge."),                            // unused
        REQ_TARGET_MAX_ATTACK(8, true,                                      "Target must have an Attack of # or less."),
        REQ_NONSELF_TARGET(9, false,                                        "Cannot target your hero."),
        REQ_TARGET_WITH_RACE(10, true,                                      "Target must be a $Race"),
        REQ_TARGET_TO_PLAY(11, false,                                       "A valid target must be available."),
        REQ_NUM_MINION_SLOTS(12, true,                                      "Must have space for # additional minion(s)."),
        REQ_WEAPON_EQUIPPED(13, false,                                      "You must have a weapon equipped."),
        REQ_ENOUGH_MANA(14, true, ""),
        REQ_YOUR_TURN(15, false, ""),
        REQ_NONSTEALTH_ENEMY_TARGET(16, false, ""),
        REQ_HERO_TARGET(17, false,                                          "Target must be a Hero."),
        REQ_SECRET_CAP(18, false, ""),
        REQ_MINION_CAP_IF_TARGET_AVAILABLE(19, false, ""),
        REQ_MINION_CAP(20, false, ""),
        REQ_TARGET_ATTACKED_THIS_TURN(21, false, ""),
        REQ_TARGET_IF_AVAILABLE(22, false,                                  "Can be played without a valid target with no effect."),
        REQ_MINIMUM_ENEMY_MINIONS(23, true,                                 "Your enemy must have at least # minion(s)."),
        REQ_TARGET_FOR_COMBO(24, false,                                     "The combo effect requires a valid target."),
        REQ_NOT_EXHAUSTED_ACTIVATE(25, false, ""),
        REQ_UNIQUE_SECRET(26, false, ""),
        REQ_TARGET_TAUNTER(27, false,                                       "Target must have <b>Taunt</b>."),
        REQ_CAN_BE_ATTACKED(28, false, ""),
        REQ_ACTION_PWR_IS_MASTER_PWR(29, false, ""),
        REQ_TARGET_MAGNET(30, false, ""),
        REQ_ATTACK_GREATER_THAN_0(31, false, ""),
        REQ_ATTACKER_NOT_FROZEN(32, false, ""),
        REQ_HERO_OR_MINION_TARGET(33, false, ""),
        REQ_CAN_BE_TARGETED_BY_SPELLS(34, false, ""),
        REQ_SUBCARD_IS_PLAYABLE(35, false, ""),
        REQ_TARGET_FOR_NO_COMBO(36, false, ""),
        REQ_NOT_MINION_JUST_PLAYED(37, false, ""),
        REQ_NOT_EXHAUSTED_HERO_POWER(38, false, ""),
        REQ_CAN_BE_TARGETED_BY_OPPONENTS(39, false, ""),
        REQ_ATTACKER_CAN_ATTACK(40, false, ""),
        REQ_TARGET_MIN_ATTACK(41, true,                                     "Target must have an Attack of # or more"),
        REQ_CAN_BE_TARGETED_BY_HERO_POWERS(42, false, ""),
        REQ_ENEMY_TARGET_NOT_IMMUNE(43, false, ""),
        REQ_ENTIRE_ENTOURAGE_NOT_IN_PLAY(44, false,                         "Must not have entire entourage in play."),
        REQ_MINIMUM_TOTAL_MINIONS(45, true,                                 "At least # minion(s) must be in play"),
        REQ_MUST_TARGET_TAUNTER(46, false,                                  "Target must have <b>Taunt</b>."),
        REQ_UNDAMAGED_TARGET(47, false,                                     "Target must be undamaged."),
        REQ_CAN_BE_TARGETED_BY_BATTLECRIES(48, false, ""),
        REQ_STEADY_SHOT(49, false,                                          "Must have the \"Steady Shot\" Hero Power."),
        REQ_MINION_OR_ENEMY_HERO(50, false,                                 "There must be a minion or enemy Hero to use."),
        REQ_TARGET_IF_AVAILABLE_AND_DRAGON_IN_HAND(51, false,               "Effect requires a dragon in hand and a valid target."),
        REQ_LEGENDARY_TARGET(52, false,                                     "Target must be a <b>Legendary</b>."),
        REQ_FRIENDLY_MINION_DIED_THIS_TURN(53, false, ""),
        REQ_FRIENDLY_MINION_DIED_THIS_GAME(54, false,                       "A friendly minion must have already died this game."),
        REQ_ENEMY_WEAPON_EQUIPPED(55, false,                                "The enemy must have a weapon equipped."),
        REQ_TARGET_IF_AVAILABLE_AND_MINIMUM_FRIENDLY_MINIONS(56, true,      "Effect only triggers if there is at least # friendly minions in play and there is a valid target."),
        REQ_TARGET_WITH_BATTLECRY(57, false, ""),
        REQ_TARGET_WITH_DEATHRATTLE(58, false,                              "Target must have <b>Deathrattle</b>."),
        REQ_DRAG_TO_PLAY(59, false, "");

        private int value;
        private boolean usesParameter;
        private String desc;
        PlayReq(int value, boolean usesParameter, String desc) {
            this.value = value;
            this.usesParameter = usesParameter;
            this.desc = desc;
        }
        public int getValue() {return value;}
        public boolean usesParameter() {return usesParameter;}
        public String getDesc() {return desc;}

        public static PlayReq getEnumByValue(int value)
        {
            for (PlayReq playReq : PlayReq.values())
            {
                if (value == playReq.getValue()) return playReq;
            }
            return INVALID;
        }
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
        ELEMENTAL(18),

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
        OGRE(19),
        NERUBIAN(22),

        // Aliased
        PET(BEAST.getValue());

        private int value;
        Race(int value) {
            this.value = value;
        }
        public int getValue() {return value;}
        public static Race[] getValidRaces()
        {
            Race[] race = new Race[] {
                    MURLOC,
                    DEMON,
                    MECHANICAL,
                    BEAST,
                    TOTEM,
                    PIRATE,
                    DRAGON,
                    ELEMENTAL
            };

            return race;
        }

        public static Race getEnumByValue(int value)
        {
            for (Race race : Race.values())
            {
                if (value == race.getValue()) return race;
            }
            return INVALID;
        }
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

        public static Rarity[] getValidRarities() {
            Rarity[] rarities = new Rarity[] {
                    FREE,
                    COMMON,
                    RARE,
                    EPIC,
                    LEGENDARY,
                    UNKNOWN_6
            };

            return rarities;
        }

        public static Rarity getEnumByValue(int value)
        {
            for (Rarity rarity : Rarity.values())
            {
                if (value == rarity.getValue()) return rarity;
            }
            return INVALID;
        }
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

        public static Booster getEnumByValue(int value)
        {
            for (Booster booster : Booster.values())
            {
                if (value == booster.getValue()) return booster;
            }
            return INVALID;
        }
    }

    public enum Locale
    {
        enUS(0, true),
        //enGB(1, false),
        frFR(2, true),
        deDE(3, true),
        koKR(4, true),
        esES(5, true),
        esMX(6, true),
        ruRU(7, true),
        zhTW(8, true),
        zhCN(9, true),
        itIT(10, true),
        ptBR(11, true),
        plPL(12, true),
        //ptPT(13, false),
        jaJP(14, true),
        thTh(15, true);

        private int value;
        private boolean used;
        Locale(int value, boolean used) {
            this.value = value;
            this.used = used;
        }
        public int getValue() {return value;}
        public boolean isUsed() {return used;}

        public static Locale getEnumByValue(int value)
        {
            for (Locale locale : Locale.values())
            {
                if (value == locale.getValue()) return locale;
            }
            return enUS;
        }

        public static Locale getEnumByDeviceLocale()
        {
            String name = java.util.Locale.getDefault().toString().replace("_", "");
            for (Locale locale : Locale.values())
            {
                if (name.equals(locale.name())) return locale;
            }
            for (Locale locale : Locale.values())
            {
                if (name.substring(0,2).equals(locale.name().substring(0, 2))) return locale;
            }
            return enUS;
        }

        public static Locale[] getUsedLocales()
        {
            List<Locale> locales = new ArrayList<>();
            for (Locale l : Locale.values())
            {
                locales.add(l);
            }

            return locales.toArray(new Locale[0]);
        }
    }

    public enum Mechanic
    {
        INVALID(0),

        ADAPT(1),
        ADJACENT_BUFF(2),
        AURA(3),
        BATTLECRY(4),
        CANT_BE_TARGETED_BY_SPELLS(5),
        CANT_BE_TARGETED_BY_HERO_POWERS(6),
        CHARGE(7),
        CHOOSE_ONE(8),
        COMBO(9),
        DEATHRATTLE(10),
        DISCOVER(11),
        DIVINE_SHIELD(12),
        ENRAGED(13),
        FORGETFUL(14),
        FREEZE(15),
        INSPIRE(16),
        POISONOUS(17),
        SECRET(18),
        SILENCE(19),
        STEALTH(20),
        TAUNT(21),
        TOPDECK(22), // Flame Leviathan, Burrowing Mine...
        WINDFURY(23),
        ImmuneToSpellpower(24),
        InvisibleDeathrattle(25),

        // Not really used
        MORPH(100),
        TAG_ONE_TURN_EFFECT(101), // Only on enchantments


        // Retired
        SPELLPOWER(102), // Now a card field
        OVERLOAD(103); // Now a card field


        private int value;
        Mechanic (int value) {this.value = value;}
        public int getValue() {return value;}

        public static int getValueByName(String name)
        {
            for (Mechanic m : Mechanic.values())
            {
                if (m.name().equals(name)) return m.value;
            }
            return INVALID.value;
        }
    }

    public enum TriClass
    {
        INVALID(0),
        GRIMY_GOONS(1),
        JADE_LOTUS(2),
        KABAL(3);

        private int value;
        TriClass(int value) {this.value = value;}
        public int getValue() {return value;}

        public static TriClass[] getValidTriClasses() {
            TriClass[] triClasses = new TriClass[] {
                    GRIMY_GOONS,
                    JADE_LOTUS,
                    KABAL
            };

            return triClasses;
        }

        public static int getValueByName(String name)
        {
            for (TriClass tc : TriClass.values())
            {
                if (tc.name().equals(name)) return tc.value;
            }
            return INVALID.value;
        }
    }

    // My Enums

    public enum CardSetType
    {
        INVALID(0),
        CORE(1),
        GIFT(2),
        ADVENTURE(3),
        EXPANSION(4),
        HERO_SKINS(5),
        GAME(6);

        private int value;
        CardSetType(int value) {
            this.value = value;
        }
        public int getValue() {return value;}
        public static CardSetType[] getValidSetTypes() {
            CardSetType[] setTypes = new CardSetType[] {
                    CORE,
                    GIFT,
                    ADVENTURE,
                    EXPANSION,
                    HERO_SKINS,
                    GAME
            };

            return setTypes;
        }

        public static CardSetType getEnumByValue(int value)
        {
            for (CardSetType cardSetType : CardSetType.values())
            {
                if (value == cardSetType.getValue()) return cardSetType;
            }
            return INVALID;
        }
    }
}
