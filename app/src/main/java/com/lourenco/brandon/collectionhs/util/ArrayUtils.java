package com.lourenco.brandon.collectionhs.util;

import java.util.ArrayList;

/**
 * Created by Brandon on 2016-04-09.
 */
public class ArrayUtils {

    public static <T> ArrayList<T> arrayToArrayList(T[] array)
    {
        if (array == null) return null;

        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++)
        {
            list.add(array[i]);
        }
        return list;
    }
}
