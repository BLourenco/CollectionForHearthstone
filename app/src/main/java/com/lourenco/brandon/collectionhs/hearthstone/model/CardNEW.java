package com.lourenco.brandon.collectionhs.hearthstone.model;

/**
 * Created by Brandon on 2016-03-23.
 */
public class CardNEW {

    private String cardId;
    private int cardTypeId;
    private boolean collectible;
    private int cardSetId;
    private int playerClassId;
    private int rarityId;
    private int cost;
    private int attack;
    private int health;
    private int raceId;
    private String artist;
    private int factionId;

    private int collectedCount;
    private int collectedGoldenCount;
    private boolean bookmarked;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(int cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public boolean isCollectible() {
        return collectible;
    }

    public void setCollectible(boolean collectible) {
        this.collectible = collectible;
    }

    public int getCardSetId() {
        return cardSetId;
    }

    public void setCardSetId(int cardSetId) {
        this.cardSetId = cardSetId;
    }

    public int getPlayerClassId() {
        return playerClassId;
    }

    public void setPlayerClassId(int playerClassId) {
        this.playerClassId = playerClassId;
    }

    public int getRarityId() {
        return rarityId;
    }

    public void setRarityId(int rarityId) {
        this.rarityId = rarityId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getFactionId() {
        return factionId;
    }

    public void setFactionId(int factionId) {
        this.factionId = factionId;
    }

    public int getCollectedCount() {
        return collectedCount;
    }

    public void setCollectedCount(int collectedCount) {
        this.collectedCount = collectedCount;
    }

    public int getCollectedGoldenCount() {
        return collectedGoldenCount;
    }

    public void setCollectedGoldenCount(int collectedGoldenCount) {
        this.collectedGoldenCount = collectedGoldenCount;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }
}
