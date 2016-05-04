package com.lourenco.brandon.collectionhs;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2016-04-15.
 */
public class CardFilter implements Parcelable{
    public ArrayList<Integer> mana = new ArrayList<>();
    public ArrayList<Integer> attack = new ArrayList<>();
    public ArrayList<Integer> health = new ArrayList<>();

    public ArrayList<Integer> type = new ArrayList<>();
    public ArrayList<Integer> set = new ArrayList<>();
    public ArrayList<Integer> race = new ArrayList<>();
    public ArrayList<Integer> rarity = new ArrayList<>();
    public ArrayList<Integer> mechanic = new ArrayList<>();

    public CardFilter(){}
    protected CardFilter(Parcel in) {
        if (in.readByte() == 0x01) {
            mana = new ArrayList<Integer>();
            in.readList(mana, Integer.class.getClassLoader());
        } else {
            mana = null;
        }
        if (in.readByte() == 0x01) {
            attack = new ArrayList<Integer>();
            in.readList(attack, Integer.class.getClassLoader());
        } else {
            attack = null;
        }
        if (in.readByte() == 0x01) {
            health = new ArrayList<Integer>();
            in.readList(health, Integer.class.getClassLoader());
        } else {
            health = null;
        }
        if (in.readByte() == 0x01) {
            type = new ArrayList<Integer>();
            in.readList(type, Integer.class.getClassLoader());
        } else {
            type = null;
        }
        if (in.readByte() == 0x01) {
            set = new ArrayList<Integer>();
            in.readList(set, Integer.class.getClassLoader());
        } else {
            set = null;
        }
        if (in.readByte() == 0x01) {
            race = new ArrayList<Integer>();
            in.readList(race, Integer.class.getClassLoader());
        } else {
            race = null;
        }
        if (in.readByte() == 0x01) {
            rarity = new ArrayList<Integer>();
            in.readList(rarity, Integer.class.getClassLoader());
        } else {
            rarity = null;
        }
        if (in.readByte() == 0x01) {
            mechanic = new ArrayList<Integer>();
            in.readList(mechanic, Integer.class.getClassLoader());
        } else {
            mechanic = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mana == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mana);
        }
        if (attack == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(attack);
        }
        if (health == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(health);
        }
        if (type == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(type);
        }
        if (set == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(set);
        }
        if (race == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(race);
        }
        if (rarity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(rarity);
        }
        if (mechanic == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mechanic);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CardFilter> CREATOR = new Parcelable.Creator<CardFilter>() {
        @Override
        public CardFilter createFromParcel(Parcel in) {
            return new CardFilter(in);
        }

        @Override
        public CardFilter[] newArray(int size) {
            return new CardFilter[size];
        }
    };
}