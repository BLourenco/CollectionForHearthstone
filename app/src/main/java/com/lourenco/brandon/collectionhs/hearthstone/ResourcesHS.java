package com.lourenco.brandon.collectionhs.hearthstone;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;

import com.lourenco.brandon.collectionhs.R;

/**
 * Created by Brandon on 2016-03-19.
 */
public class ResourcesHS {

    /*
        CLASSES
     */
    public static int[] getClassColors(Context context, EnumsHS.CardClass selectedClass) {

        int[] colors = {0,0,0}; // Primary, Dark, Accent

        switch (selectedClass)
        {
            case DRUID:
                colors[0] = ContextCompat.getColor(context, R.color.classDruidPrimary);
                colors[1] = ContextCompat.getColor(context, R.color.classDruidPrimaryDark);
                colors[2] = ContextCompat.getColor(context, R.color.classDruidAccent);
                break;
            case HUNTER:
                colors[0] = ContextCompat.getColor(context, R.color.classHunterPrimary);
                colors[1] = ContextCompat.getColor(context, R.color.classHunterPrimaryDark);
                colors[2] = ContextCompat.getColor(context, R.color.classHunterAccent);
                break;
            case MAGE:
                colors[0] = ContextCompat.getColor(context, R.color.classMagePrimary);
                colors[1] = ContextCompat.getColor(context, R.color.classMagePrimaryDark);
                colors[2] = ContextCompat.getColor(context, R.color.classMageAccent);
                break;
            case PALADIN:
                colors[0] = ContextCompat.getColor(context, R.color.classPaladinPrimary);
                colors[1] = ContextCompat.getColor(context, R.color.classPaladinPrimaryDark);
                colors[2] = ContextCompat.getColor(context, R.color.classPaladinAccent);
                break;
            case PRIEST:
                colors[0] = ContextCompat.getColor(context, R.color.classPriestPrimary);
                colors[1] = ContextCompat.getColor(context, R.color.classPriestPrimaryDark);
                colors[2] = ContextCompat.getColor(context, R.color.classPriestAccent);
                break;
            case ROGUE:
                colors[0] = ContextCompat.getColor(context, R.color.classRoguePrimary);
                colors[1] = ContextCompat.getColor(context, R.color.classRoguePrimaryDark);
                colors[2] = ContextCompat.getColor(context, R.color.classRogueAccent);
                break;
            case SHAMAN:
                colors[0] = ContextCompat.getColor(context, R.color.classShamanPrimary);
                colors[1] = ContextCompat.getColor(context, R.color.classShamanPrimaryDark);
                colors[2] = ContextCompat.getColor(context, R.color.classShamanAccent);
                break;
            case WARLOCK:
                colors[0] = ContextCompat.getColor(context, R.color.classWarlockPrimary);
                colors[1] = ContextCompat.getColor(context, R.color.classWarlockPrimaryDark);
                colors[2] = ContextCompat.getColor(context, R.color.classWarlockAccent);
                break;
            case WARRIOR:
                colors[0] = ContextCompat.getColor(context, R.color.classWarriorPrimary);
                colors[1] = ContextCompat.getColor(context, R.color.classWarriorPrimaryDark);
                colors[2] = ContextCompat.getColor(context, R.color.classWarriorAccent);
                break;
            case NEUTRAL:
                colors[0] = ContextCompat.getColor(context, R.color.classNeutralPrimary);
                colors[1] = ContextCompat.getColor(context, R.color.classNeutralPrimaryDark);
                colors[2] = ContextCompat.getColor(context, R.color.classNeutralAccent);
                break;
            default:
                colors[0] = ContextCompat.getColor(context, R.color.colorPrimary);
                colors[1] = ContextCompat.getColor(context, R.color.colorPrimaryDark);
                colors[2] = ContextCompat.getColor(context, R.color.colorAccent);
        }

        return colors;
    }
    public static EnumsHS.CardClass getClassEnum(Context context, String className) {

        String[] classArray = context.getResources().getStringArray(R.array.classes);

        if (className == null || classArray == null)
            return EnumsHS.CardClass.INVALID;

        className = className.toUpperCase().replace("_", " ");

        int i = 0; // Used to check if a string exists at this index, increments after each checked index

        if (classArray.length > i && className.equals(classArray[i++]))
            return EnumsHS.CardClass.DRUID;
        else if (classArray.length > i && className.equals(classArray[i++]))
            return EnumsHS.CardClass.HUNTER;
        else if (classArray.length > i && className.equals(classArray[i++]))
            return EnumsHS.CardClass.MAGE;
        else if (classArray.length > i && className.equals(classArray[i++]))
            return EnumsHS.CardClass.PALADIN;
        else if (classArray.length > i && className.equals(classArray[i++]))
            return EnumsHS.CardClass.PRIEST;
        else if (classArray.length > i && className.equals(classArray[i++]))
            return EnumsHS.CardClass.ROGUE;
        else if (classArray.length > i && className.equals(classArray[i++]))
            return EnumsHS.CardClass.SHAMAN;
        else if (classArray.length > i && className.equals(classArray[i++]))
            return EnumsHS.CardClass.WARLOCK;
        else if (classArray.length > i && className.equals(classArray[i++]))
            return EnumsHS.CardClass.WARRIOR;
        else if (classArray.length > i && className.equals(classArray[i++]))
            return EnumsHS.CardClass.NEUTRAL;
        else
            return EnumsHS.CardClass.INVALID;

    }
    public static String getClassString(Context context, EnumsHS.CardClass cardClass) {
        String[] classArray = context.getResources().getStringArray(R.array.classes);
        if (cardClass.getOrdinal() >= classArray.length || cardClass.getValue() < 0)
            return null;
        return context.getResources().getStringArray(R.array.classes)[cardClass.getOrdinal()];
    }

    /*
        RARITIES
     */

    public static int getRarityColor(Context context, EnumsHS.Rarity rarity) {
        switch (rarity)
        {
            case COMMON:
                return ContextCompat.getColor(context, R.color.rarityCommon);
            case RARE:
                return ContextCompat.getColor(context, R.color.rarityRare);
            case EPIC:
                return ContextCompat.getColor(context, R.color.rarityEpic);
            case LEGENDARY:
                return ContextCompat.getColor(context, R.color.rarityLegendary);
            default:
                return Color.BLACK;
        }
    }
    public static int getRarityTextColor(Context context, EnumsHS.Rarity rarity)
    {
        switch (rarity)
        {
            case COMMON:
                return Color.BLACK;
            default:
                return getRarityColor(context, rarity);
        }
    }
    public static EnumsHS.Rarity getRarityEnum(Context context, String rarityName) {
        String[] rarityArray = context.getResources().getStringArray(R.array.rarity);

        if (rarityName == null || rarityArray == null)
            return EnumsHS.Rarity.INVALID;

        rarityName = rarityName.toUpperCase().replace("_", " ");

        int i = 0; // Used to check if a string exists at this index, increments after each checked index

        if (rarityArray.length > i && rarityName.equals(rarityArray[i++]))
            return EnumsHS.Rarity.FREE;
        else if (rarityArray.length > i && rarityName.equals(rarityArray[i++]))
            return EnumsHS.Rarity.COMMON;
        else if (rarityArray.length > i && rarityName.equals(rarityArray[i++]))
            return EnumsHS.Rarity.RARE;
        else if (rarityArray.length > i && rarityName.equals(rarityArray[i++]))
            return EnumsHS.Rarity.EPIC;
        else if (rarityArray.length > i && rarityName.equals(rarityArray[i++]))
            return EnumsHS.Rarity.LEGENDARY;
        else
            return EnumsHS.Rarity.INVALID;
    }
    public String getRarityString(Context context, EnumsHS.Rarity rarity) {
        String[] rarityArray = context.getResources().getStringArray(R.array.rarity);
        if (rarity.getValue() >= rarityArray.length || rarity.getValue() < 0)
            return null;
        return context.getResources().getStringArray(R.array.rarity)[rarity.getValue()];
    }

    /*
        CARD SETS
     */

    public static int getSetColor(Context context, EnumsHS.CardSet set) {
        switch (set)
        {
            case CORE:
                return ContextCompat.getColor(context, R.color.setCore);
            case EXPERT1:
                return ContextCompat.getColor(context, R.color.setClassic);
            case PROMO:
                return ContextCompat.getColor(context, R.color.setReward);
            case REWARD:
                return ContextCompat.getColor(context, R.color.setReward);
            case HERO_SKINS:
                return ContextCompat.getColor(context, R.color.setHeroSkins);
            case NAXX:
                return ContextCompat.getColor(context, R.color.setNaxx);
            case GVG:
                return ContextCompat.getColor(context, R.color.setGVG);
            case BRM:
                return ContextCompat.getColor(context, R.color.setBRM);
            case TGT:
                return ContextCompat.getColor(context, R.color.setTGT);
            case LOE:
                return ContextCompat.getColor(context, R.color.setLOE);
            case OG:
                return ContextCompat.getColor(context, R.color.setWOG);
            case KARA:
                return ContextCompat.getColor(context, R.color.setKARA);
            case GANGS:
                return ContextCompat.getColor(context, R.color.setMSG);
            case UNGORO:
                return ContextCompat.getColor(context, R.color.setJTU);
            default:
                return Color.BLACK;
        }
    }
    public static int getSetIcon(EnumsHS.CardSet set) {
        switch (set)
        {
            case CORE:
                return R.drawable.icon_set_core_color;
            case EXPERT1:
                return R.drawable.icon_set_classic_color;
            case PROMO:
                return R.drawable.icon_set_promo;
            case REWARD:
                return R.drawable.icon_set_reward_color;
            case HERO_SKINS:
                return R.drawable.icon_set_hero_skins;
            case NAXX:
                return R.drawable.icon_set_naxx_color;
            case GVG:
                return R.drawable.icon_set_gvg_color;
            case BRM:
                return R.drawable.icon_set_brm_color;
            case TGT:
                return R.drawable.icon_set_tgt_color;
            case LOE:
                return R.drawable.icon_set_loe_color;
            case OG:
                return R.drawable.icon_set_wog_color;
            case KARA:
                return R.drawable.icon_set_onik_color;
            case GANGS:
                return R.drawable.icon_set_msg_color;
            case UNGORO:
                return R.drawable.icon_set_jtu_color;
            default:
                return R.drawable.placeholder_missing;
        }
    }
    public static EnumsHS.CardSet getSetEnum(Context context, String setName) {
        String[] setArray = context.getResources().getStringArray(R.array.card_sets);

        if (setName == null || setArray == null)
            return EnumsHS.CardSet.INVALID;

        setName = setName.toUpperCase().replace("_", " ");

        int i = 0; // Used to check if a string exists at this index, increments after each checked index

        if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.CORE;
        else if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.EXPERT1;
        else if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.PROMO;
        else if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.REWARD;
        else if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.HERO_SKINS;
        else if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.NAXX;
        else if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.GVG;
        else if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.BRM;
        else if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.TGT;
        else if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.LOE;
        else if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.OG;
        else if (setArray.length > i && setName.equals(setArray[i++]))
            return EnumsHS.CardSet.KARA;
        else
            return EnumsHS.CardSet.INVALID;
    }
    public String getSetNameFullString(Context context, EnumsHS.CardSet set) {
        String[] setArray = context.getResources().getStringArray(R.array.card_set_full_names);
        if (set.getValue() >= setArray.length || set.getValue() < 0)
            return null;
        return context.getResources().getStringArray(R.array.card_set_full_names)[set.getValue()];
    }
    public String getSetNameShortString(Context context, EnumsHS.CardSet set) {
        String[] setArray = context.getResources().getStringArray(R.array.card_sets);
        if (set.getValue() >= setArray.length || set.getValue() < 0)
            return null;
        return context.getResources().getStringArray(R.array.card_sets)[set.getValue()];
    }

    /*
        CARD TYPES
     */

    public static EnumsHS.CardType getTypeEnum(Context context, String type) {
        String[] cardTypeArray = context.getResources().getStringArray(R.array.card_types);

        if (type == null || cardTypeArray == null)
            return EnumsHS.CardType.INVALID;

        type = type.toUpperCase().replace("_", " ");

        int i = 0; // Used to check if a string exists at this index, increments after each checked index

        if (cardTypeArray.length > i && type.equals(cardTypeArray[i++]))
            return EnumsHS.CardType.MINION;
        else if (cardTypeArray.length > i && type.equals(cardTypeArray[i++]))
            return EnumsHS.CardType.SPELL;
        else if (cardTypeArray.length > i && type.equals(cardTypeArray[i++]))
            return EnumsHS.CardType.WEAPON;
        else if (cardTypeArray.length > i && type.equals(cardTypeArray[i++]))
            return EnumsHS.CardType.HERO;
        else if (cardTypeArray.length > i && type.equals(cardTypeArray[i++]))
            return EnumsHS.CardType.HERO_POWER;
        else if (cardTypeArray.length > i && type.equals(cardTypeArray[i++]))
            return EnumsHS.CardType.ENCHANTMENT;
        else
            return EnumsHS.CardType.INVALID;
    }
    public static int getCardTypeMask(EnumsHS.CardType type) {
        switch (type)
        {
            case MINION:
                return R.drawable.mask_minion;
            case SPELL:
                return R.drawable.mask_spell;
            case WEAPON:
                return R.drawable.mask_weapon;
            case HERO:
                return R.drawable.mask_hero;
            case HERO_POWER:
                return R.drawable.mask_heropower;
            case ENCHANTMENT:
                return R.drawable.mask_enchantment;
            default:
                return R.drawable.placeholder_missing;
        }
    }

    /*
        CARD ART
     */
    public static int getCartArtResourceId(Context context, String cardId)
    {
        //TODO: Find a better way to identify cards with postfix's
        if (cardId.endsWith("e") ||
                cardId.endsWith("b") ||
                cardId.endsWith("o") ||
                cardId.endsWith("h"))
        {
            cardId = cardId.substring(0, cardId.length() - 1);
        }
        else if (cardId.endsWith("eh") ||
                cardId.endsWith("e2"))
        {
            cardId = cardId.substring(0, cardId.length()-2);
        }

        int resourceId = context.getResources().getIdentifier(cardId.toLowerCase(), "drawable",
                context.getPackageName());

        if (resourceId == 0)
        {
            resourceId = R.drawable.placeholder_missing;
        }
        return resourceId;
    }

    /*
        RACE TEXT
     */
    public static String getRaceText(Context context, EnumsHS.Race race)
    {
        switch (race)
        {
            case MURLOC:
                return context.getResources().getStringArray(R.array.races)[0];
            case DEMON:
                return context.getResources().getStringArray(R.array.races)[1];
            case MECHANICAL:
                return context.getResources().getStringArray(R.array.races)[2];
            case BEAST:
                return context.getResources().getStringArray(R.array.races)[3];
            case TOTEM:
                return context.getResources().getStringArray(R.array.races)[4];
            case PIRATE:
                return context.getResources().getStringArray(R.array.races)[5];
            case DRAGON:
                return context.getResources().getStringArray(R.array.races)[6];
            default:
                return null;
        }
    }
}
