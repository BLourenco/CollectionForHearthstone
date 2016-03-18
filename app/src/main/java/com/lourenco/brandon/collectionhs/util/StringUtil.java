package com.lourenco.brandon.collectionhs.util;

/**
 * Created by Brandon on 2016-03-13.
 */
public class StringUtil {

    public static String toTitleCase(String input)
    {
        String[] words = input.toString().split("_");
        StringBuilder sb = new StringBuilder();
        if (words[0].length() > 0) {
            sb.append(Character.toUpperCase(words[0].charAt(0)) + words[0].subSequence(1, words[0].length()).toString().toLowerCase());
            for (int i = 1; i < words.length; i++) {
                sb.append(" ");
                sb.append(Character.toUpperCase(words[i].charAt(0)) + words[i].subSequence(1, words[i].length()).toString().toLowerCase());
            }
        }
        return sb.toString();
    }
}
