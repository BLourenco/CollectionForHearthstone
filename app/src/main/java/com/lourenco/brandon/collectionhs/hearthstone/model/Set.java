package com.lourenco.brandon.collectionhs.hearthstone.model;

import android.graphics.Color;

import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;

import java.util.ArrayList;

/**
 * Created by Brandon on 2017-07-29.
 */

public class Set {

    public static final byte _SET_ROTATION_LENGTH_YRS = 2;
    private static ArrayList<Set> _sets = new ArrayList<>();

    private int _id;
    private String _setName;
    private String _setNameShort;
    private boolean _isCraftable;
    private boolean _isCollectable;
    private EnumsHS.CardSetType _setType;
    private int _releaseYear;
    private boolean _isAlwaysInStandardSet;

    private int _icon; // = R.drawable.icon_set_core;
    private Color _iconColor; // = Color.valueOf(0.5f, 0.5f, 0.5f, 1.0f);

    private int _iconToggleOff; // = R.drawable.icon_set_core
    private int _iconToggleOn; // = R.drawable.icon_set_core

    public Set(String setName,
               String setNameShort,
               boolean isCraftable,
               boolean isCollectable,
               EnumsHS.CardSetType setType,
               int releaseYear,
               boolean isAlwaysInStandardSet,
               int icon,
               Color iconColor,
               int iconToggleOff,
               int iconToggleOn)
    {
        this._setName = setName;
        this._setNameShort = setNameShort;
        this._isCraftable = isCraftable;
        this._isCollectable = isCollectable;
        this._setType = setType;
        this._releaseYear = releaseYear;
        this._isAlwaysInStandardSet = isAlwaysInStandardSet;
        this._icon = icon;
        this._iconColor = iconColor;
        this._iconToggleOff = iconToggleOff;
        this._iconToggleOn = iconToggleOn;

        _sets.add(this);
    }



    public static ArrayList<Set> get_sets() {
        return _sets;
    }

    public int get_id() {
        return _id;
    }

    public String get_setName() {
        return _setName;
    }

    public String get_setNameShort() {
        return _setNameShort;
    }

    public boolean is_isCraftable() {
        return _isCraftable;
    }

    public boolean is_isCollectable() {
        return _isCollectable;
    }

    public EnumsHS.CardSetType get_setType() {
        return _setType;
    }

    public int get_releaseYear() {
        return _releaseYear;
    }

    public boolean is_isAlwaysInStandardSet() {
        return _isAlwaysInStandardSet;
    }

    public int get_icon() {
        return _icon;
    }

    public Color get_iconColor() {
        return _iconColor;
    }

    public int get_iconToggleOff() {
        return _iconToggleOff;
    }

    public int get_iconToggleOn() {
        return _iconToggleOn;
    }

}
