package com.lourenco.brandon.collectionhs.hearthstone.model;

import android.database.Cursor;

import com.lourenco.brandon.collectionhs.db.CollectionDbContract;
import com.lourenco.brandon.collectionhs.hearthstone.CardComparator;

import java.util.Comparator;

/**
 * Created by Brandon on 2016-03-23.
 */
public class Card {

    private static final Comparator<Card> SORT_BY_COST = new CardComparator();
    //private static final Comparator<Card> SORT_BY_NAME = new CardComparator(); //TODO: Sort by Name (how will this work with different languages?)

    private String cardId;
    private String name;
    private Integer cardTypeId;
    private Boolean collectible;
    private Integer cardSetId;
    private Integer playerClassId;
    private Integer triClassId;
    private Integer rarityId;
    private Integer cost;
    private Integer attack;
    private Integer health;
    private Integer raceId;
    private String text;
    private String artist;
    private Integer factionId;

    private Integer collectedCount;
    private Integer collectedGoldenCount;
    private Boolean bookmarked;

    public Card(Cursor c, int position)
    {
        c.moveToPosition(position);
        cardId = c.getString(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_CARD_ID));
        cardTypeId = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_CARD_TYPE_ID_FOREIGN));
        cardSetId = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_CARD_SET_ID_FOREIGN));
        name = c.getString(c.getColumnIndexOrThrow(CollectionDbContract.CardLocale.COLUMN_NAME_CARD_NAME));
        rarityId = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_RARITY_ID_FOREIGN));
        text = c.getString(c.getColumnIndexOrThrow(CollectionDbContract.CardLocale.COLUMN_NAME_CARD_TEXT));
        cost = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_COST));
        attack = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_ATTACK));
        health = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_HEALTH));
        raceId = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_RACE_ID_FOREIGN));
        playerClassId = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_PLAYER_CLASS_ID_FOREIGN));
        triClassId = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_TRI_CLASS_ID_FOREIGN));
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(int cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public Boolean isCollectible() {
        return collectible;
    }

    public void setCollectible(boolean collectible) {
        this.collectible = collectible;
    }

    public Integer getCardSetId() {
        return cardSetId;
    }

    public void setCardSetId(int cardSetId) {
        this.cardSetId = cardSetId;
    }

    public Integer getPlayerClassId() {
        return playerClassId;
    }

    public void setPlayerClassId(int playerClassId) {
        this.playerClassId = playerClassId;
    }

    public Integer getTriClassId() {
        return triClassId;
    }

    public void setTriClassId(int triClassId) { this.triClassId = triClassId; }

    public Integer getRarityId() {
        return rarityId;
    }

    public void setRarityId(int rarityId) {
        this.rarityId = rarityId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getText() {
        return text;
    }

    public void setText(String artist) {
        this.text = text;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getFactionId() {
        return factionId;
    }

    public void setFactionId(int factionId) {
        this.factionId = factionId;
    }

    public Integer getCollectedCount() {
        return collectedCount;
    }

    public void setCollectedCount(int collectedCount) {
        this.collectedCount = collectedCount;
    }

    public Integer getCollectedGoldenCount() {
        return collectedGoldenCount;
    }

    public void setCollectedGoldenCount(int collectedGoldenCount) {
        this.collectedGoldenCount = collectedGoldenCount;
    }

    public Boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }
}
