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
        CLASS DATA
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

        className = className.toUpperCase();

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
        if (cardClass.getValue() >= classArray.length || cardClass.getValue() < 0)
            return null;
        return context.getResources().getStringArray(R.array.classes)[cardClass.getValue()];
    }

    /*
        RARITY DATA
     */

    public static int getRarityColor(Context context, EnumsHS.Rarity rarity) {
        switch (rarity)
        {
            case FREE:
                return ContextCompat.getColor(context, R.color.rarityFree);
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
    public static EnumsHS.Rarity getRarityEnum(Context context, String rarityName) {
        String[] rarityArray = context.getResources().getStringArray(R.array.rarity);

        if (rarityName == null || rarityArray == null)
            return EnumsHS.Rarity.INVALID;

        rarityName = rarityName.toUpperCase();

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
        return context.getResources().getStringArray(R.array.classes)[rarity.getValue()];
    }
}
