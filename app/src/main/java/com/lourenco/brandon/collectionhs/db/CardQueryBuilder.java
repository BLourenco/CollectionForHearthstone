package com.lourenco.brandon.collectionhs.db;

import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;

/**
 * Created by Brandon on 2016-03-31.
 */
public class CardQueryBuilder {

    private String[] searchTerms;

    private int[] filterMana;
    private int[] filterAttack;
    private int[] filterHealth;

    private int[] filterClass;
    private int[] filterType;
    private int[] filterSet;
    private int[] filterRarity;
    private int[] filterRace;
    private int[] filterMechanic;
    private int[] filterFaction;

    public String build() {
        StringBuilder sb = new StringBuilder();

        /*
            SELECT STATEMENT
         */

        // Get all cards in card album with all foreign table values included
        sb.append(
                "SELECT * FROM " +
                        CollectionDbContract.CardAlbumView.VIEW_NAME + " INNER JOIN " + CollectionDbContract.CardLocale.TABLE_NAME +
                        " ON " +
                        CollectionDbContract.CardAlbumView.VIEW_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_CARD_ID +
                        "=" +
                        CollectionDbContract.CardLocale.TABLE_NAME + "." + CollectionDbContract.CardLocale.COLUMN_NAME_CARD_ID_COMPOSITE +
                        " WHERE " +
                        CollectionDbContract.CardLocale.TABLE_NAME + "." + CollectionDbContract.CardLocale.COLUMN_NAME_LOCALE_ID_COMPOSITE +
                        "=" +
                        EnumsHS.Locale.getEnumByDeviceLocale().getValue()
        );

        /*
            SEARCH TERMS
         */

        //TODO implement search terms using the LIKE clause for card name & text (and maybe race/mechanic/type/etc.)

        /*
            FILTERS
         */

        sb.append(getFilterClause(filterMana, CollectionDbContract.Card.COLUMN_NAME_COST));
        sb.append(getFilterClause(filterAttack, CollectionDbContract.Card.COLUMN_NAME_ATTACK));
        sb.append(getFilterClause(filterHealth, CollectionDbContract.Card.COLUMN_NAME_HEALTH));

        sb.append(getFilterClause(filterClass, CollectionDbContract.Card.COLUMN_NAME_PLAYER_CLASS_ID_FOREIGN));
        sb.append(getFilterClause(filterType, CollectionDbContract.Card.COLUMN_NAME_CARD_TYPE_ID_FOREIGN));
        sb.append(getFilterClause(filterSet, CollectionDbContract.Card.COLUMN_NAME_CARD_SET_ID_FOREIGN));
        sb.append(getFilterClause(filterRarity, CollectionDbContract.Card.COLUMN_NAME_RARITY_ID_FOREIGN));
        sb.append(getFilterClause(filterRace, CollectionDbContract.Card.COLUMN_NAME_RACE_ID_FOREIGN));
        sb.append(getFilterClause(filterFaction, CollectionDbContract.Card.COLUMN_NAME_FACTION_ID_FOREIGN));

        //TODO allow filtering by card mechanic
        //sb.append(getFilterClause(filterMechanic, CollectionDbContract.Card.COLUMN_NAME_PLAYER_CLASS_ID_FOREIGN));

        /*
            ORDERING
         */

        //TODO allow changing the result ordering
        sb.append(
                " ORDER BY " +
                        CollectionDbContract.CardAlbumView.VIEW_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_COST + " ASC, " +
                        CollectionDbContract.CardLocale.TABLE_NAME + "." + CollectionDbContract.CardLocale.COLUMN_NAME_CARD_NAME + " ASC"
        );


        return sb.toString();
    }

    private String getFilterClause(int[] filterValues, String filterColumnName) {
        StringBuilder sb = new StringBuilder();
        if (filterValues != null) {
            boolean firstFilter = true;
            for (int i = 0; i < filterValues.length; i++) {
                if (firstFilter) {
                    sb.append(" AND (");
                    firstFilter = false;
                } else {
                    sb.append(" OR ");
                }
                sb.append(CollectionDbContract.CardAlbumView.VIEW_NAME + "." + filterColumnName + "=" + filterValues[i]);
                //TODO Deal with searching for 7+ mana/attack/health
            }

            if (firstFilter == false)
            {
                sb.append(") ");
            }

        } else {
            return "";
        }

        return sb.toString();
    }

    /*
        BUILDER METHODS
     */

    public CardQueryBuilder filterByMana(int... manaCosts)
    {
        filterMana = manaCosts;
        return this;
    }

    public CardQueryBuilder filterByAttack(int... attackValues)
    {
        filterAttack = attackValues;
        return this;
    }

    public CardQueryBuilder filterByHealth(int... healthValues)
    {
        filterHealth = healthValues;
        return this;
    }



    public CardQueryBuilder filterByClass(int... classIds)
    {
        filterClass = classIds;
        return this;
    }

    public CardQueryBuilder filterByType(int... typeIds)
    {
        filterType = typeIds;
        return this;
    }

    public CardQueryBuilder filterBySet(int... setIds)
    {
        filterSet = setIds;
        return this;
    }

    public CardQueryBuilder filterByRarity(int... rarityIds)
    {
        filterRarity = rarityIds;
        return this;
    }

    public CardQueryBuilder filterByRace(int... raceIds)
    {
        filterRace = raceIds;
        return this;
    }
    public CardQueryBuilder filterByMechanic(int... mechanicIds)
    {
        filterMechanic = mechanicIds;
        return this;
    }

    public CardQueryBuilder filterByFaction(int... factionIds)
    {
        filterFaction = factionIds;
        return this;
    }


}
