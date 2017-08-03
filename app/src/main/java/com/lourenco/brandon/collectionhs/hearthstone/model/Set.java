package com.lourenco.brandon.collectionhs.hearthstone.model;

import android.graphics.Color;

import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;

import java.util.ArrayList;

/**
 * Created by Brandon on 2017-07-29.
 */

public class Set {

    private static final byte _SET_ROTATION_LENGTH_YRS = 2;
    private static ArrayList<Set> _sets = new ArrayList<>();

    private int _id;
    private String _setName;
    private String _setNameShort;
    private boolean _isCraftable;
    private boolean _isCollectable;
    private EnumsHS.CardSetType _setType;
    private int _releaseYear;
    private boolean _isAlwaysInStandardSet;

    private int _iconSetGrey; // = R.drawable.icon_set_core_color;
    private int _iconSetColored;
    private Color _iconColor; // = Color.valueOf(0.5f, 0.5f, 0.5f, 1.0f);


}
