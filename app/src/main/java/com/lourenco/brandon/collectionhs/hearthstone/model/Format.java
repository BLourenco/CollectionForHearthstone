package com.lourenco.brandon.collectionhs.hearthstone.model;

import android.graphics.Color;

import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;

import java.util.ArrayList;

/**
 * Created by Brandon on 2017-08-03.
 */

public class Format {

    private static ArrayList<Set> _formats = new ArrayList<>();

    private int _id;
    private String _formatName;
    private String _formatNameShort;
    private boolean _isCurrentFormat;
    private int _year;

    private int _icon; // = R.drawable.icon_set_core;
    private Color _iconColor; // = Color.valueOf(0.5f, 0.5f, 0.5f, 1.0f);

    private int _iconToggleOff; // = R.drawable.icon_set_core
    private int _iconToggleOn; // = R.drawable.icon_set_core
}
