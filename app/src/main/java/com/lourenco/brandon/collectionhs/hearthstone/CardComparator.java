package com.lourenco.brandon.collectionhs.hearthstone;

import com.lourenco.brandon.collectionhs.hearthstone.model.Card;

import java.util.Comparator;

/**
 * Created by Brandon on 2016-03-15.
 */
public class CardComparator implements Comparator<Card> {
    public int compare(Card card1, Card card2) {

        if (card1.getCost() == null && card2.getCost() == null)// both have no cost, order by name
            return card1.getName().compareTo(card2.getName());
        else if (card1.getCost() == null)
        {
            return -1;
        }
        else if (card2.getCost() == null)
        {
            return 1;
        }
        else
        {
            int value1 = card1.getCost().compareTo(card2.getCost());
            if (value1 == 0) {
                return card1.getName().compareTo(card2.getName());
            } else {
                return value1;
            }
        }
    }
}
