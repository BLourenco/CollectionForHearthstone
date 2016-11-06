package com.lourenco.brandon.collectionhs.hearthstone.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.lourenco.brandon.collectionhs.R;
import com.lourenco.brandon.collectionhs.hearthstone.CardComparator;
import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;
import com.lourenco.brandon.collectionhs.util.StringUtil;

@Generated("org.jsonschema2pojo")
public class CardOLD implements Parcelable {

    private static final Comparator<Card> SORT_BY_COST = new CardComparator();
    //private static final Comparator<Card> SORT_BY_NAME = new CardComparator(); //TODO Sort by name

    @SerializedName("artist")
    @Expose
    @DatabaseField
    private String artist;
    @SerializedName("howToEarnGolden")
    @Expose
    @DatabaseField
    private String howToEarnGolden;
    @SerializedName("dust")
    @Expose
    private List<Integer> dust = new ArrayList<Integer>();
    @SerializedName("texture")
    @Expose
    @DatabaseField
    private String texture;
    @SerializedName("set")
    @Expose
    @DatabaseField
    private String set;
    @SerializedName("targetingArrowText")
    @Expose
    @DatabaseField
    private String targetingArrowText;
    @SerializedName("collectible")
    @Expose
    @DatabaseField
    private Boolean collectible;
    @SerializedName("faction")
    @Expose
    @DatabaseField
    private String faction;
    @SerializedName("id")
    @Expose
    @DatabaseField
    private String id;
    @SerializedName("race")
    @Expose
    @DatabaseField
    private String race;
    @SerializedName("type")
    @Expose
    @DatabaseField
    private String type;
    @SerializedName("playerClass")
    @Expose
    @DatabaseField
    private String playerClass;
    @SerializedName("textInPlay")
    @Expose
    @DatabaseField
    private String textInPlay;
    @SerializedName("playRequirements")
    @Expose
    @DatabaseField
    private PlayRequirements playRequirements;
    @SerializedName("flavor")
    @Expose
    @DatabaseField
    private String flavor;
    @SerializedName("text")
    @Expose
    @DatabaseField
    private String text;
    @SerializedName("entourage")
    @Expose
    @DatabaseField
    private List<String> entourage = new ArrayList<String>();
    @SerializedName("mechanics")
    @Expose
    @DatabaseField
    private List<String> mechanics = new ArrayList<String>();
    @SerializedName("cost")
    @Expose
    @DatabaseField
    private Integer cost;
    @SerializedName("howToEarn")
    @Expose
    @DatabaseField
    private String howToEarn;
    @SerializedName("attack")
    @Expose
    @DatabaseField
    private Integer attack;
    @SerializedName("name")
    @Expose
    @DatabaseField
    private String name;
    @SerializedName("health")
    @Expose
    @DatabaseField
    private Integer health;
    @SerializedName("durability")
    @Expose
    @DatabaseField
    private Integer durability;
    @SerializedName("rarity")
    @Expose
    @DatabaseField
    private String rarity;

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " - ");

        if (type.equals("MINION") || type.equals("WEAPON") || type.equals("SPELL") || type.equals("HERO_POWER")) {
            sb.append(cost + " Mana ");
            if (type.equals("MINION") || type.equals("WEAPON")) {
                sb.append(attack + "/");
                if (type.equals("MINION")) {
                    sb.append(health + " ");
                } else {
                    sb.append(durability + " ");
                }
            }
        }

        if (!type.equals("ENCHANTMENT")) {
            if (playerClass == null) {
                sb.append("Neutral" + " ");
            } else {
                sb.append(StringUtil.toTitleCase(playerClass) + " ");
            }

            if (race != null) {
                sb.append(StringUtil.toTitleCase(race) + " ");
            }
        }
        sb.append(StringUtil.toTitleCase(type));

        return sb.toString();
    }

    public EnumsHS.CardType getTypeEnum()
    {
        switch (type)
        {
            case "MINION":
                return EnumsHS.CardType.MINION;
            case "SPELL":
                return EnumsHS.CardType.SPELL;
            case "WEAPON":
                return EnumsHS.CardType.WEAPON;
            case "HERO":
                return EnumsHS.CardType.HERO;
            case "HERO_POWER":
                return EnumsHS.CardType.HERO_POWER;
            case "ENCHANTMENT":
                return EnumsHS.CardType.ENCHANTMENT;
        }
        return EnumsHS.CardType.INVALID;
    }

    public String TEST()
    {
        String a = getArtist();
        Integer b = getAttack();
        Boolean c = getCollectible();
        Integer d = getCost();
        Integer e = getDurability();
        List<Integer> f = getDust();
        List<String> g = getEntourage();
        String h = getFaction();
        String i = getFlavor();
        Integer j = getHealth();
        String k = getHowToEarn();
        String l = getHowToEarnGolden();
        String m = getId();
        List<String> n = getMechanics();
        String o = getName();
        String p = getPlayerClass();
        String q = getRace();
        String r = getRarity();
        String s = getSet();
        String t = getTargetingArrowText();
        String u = getText();
        String v = getTextInPlay();
        String w = getType();
        String x = getTexture();

        //TODO: WTF is this?!
        return a+"\n"+b+"\n"+c+"\n"+d+"\n"+e+"\n"+f+"\n"+g+"\n"+h+"\n"+i+"\n"+j+"\n"+k+"\n"+l+"\n"+m+"\n"+n+"\n"+o+"\n"+p+"\n"+q+"\n"+r+"\n"+s+"\n"+t+"\n"+u+"\n"+v+"\n"+w+"\n"+x+"\n-----------------\n";
    }

    /**
     *
     * @return
     * The artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     *
     * @param artist
     * The artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     *
     * @return
     * The howToEarnGolden
     */
    public String getHowToEarnGolden() {
        return howToEarnGolden;
    }

    /**
     *
     * @param howToEarnGolden
     * The howToEarnGolden
     */
    public void setHowToEarnGolden(String howToEarnGolden) {
        this.howToEarnGolden = howToEarnGolden;
    }

    /**
     *
     * @return
     * The dust
     */
    public List<Integer> getDust() {
        return dust;
    }

    /**
     *
     * @param dust
     * The dust
     */
    public void setDust(List<Integer> dust) {
        this.dust = dust;
    }

    /**
     *
     * @return
     * The texture
     */
    public String getTexture() {
        return texture;
    }

    /**
     *
     * @param texture
     * The texture
     */
    public void setTexture(String texture) {
        this.texture = texture;
    }

    /**
     *
     * @return
     * The set
     */
    public String getSet() {
        return set;
    }

    /**
     *
     * @param set
     * The set
     */
    public void setSet(String set) {
        this.set = set;
    }

    /**
     *
     * @return
     * The targetingArrowText
     */
    public String getTargetingArrowText() {
        return targetingArrowText;
    }

    /**
     *
     * @param targetingArrowText
     * The targetingArrowText
     */
    public void setTargetingArrowText(String targetingArrowText) {
        this.targetingArrowText = targetingArrowText;
    }

    /**
     *
     * @return
     * The collectible
     */
    public Boolean getCollectible() {
        return collectible;
    }

    /**
     *
     * @param collectible
     * The collectible
     */
    public void setCollectible(Boolean collectible) {
        this.collectible = collectible;
    }

    /**
     *
     * @return
     * The faction
     */
    public String getFaction() {
        return faction;
    }

    /**
     *
     * @param faction
     * The faction
     */
    public void setFaction(String faction) {
        this.faction = faction;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The race
     */
    public String getRace() {
        if (race != null && race.equals("MECHANICAL")) return "MECH";
        return race;
    }

    /**
     *
     * @param race
     * The race
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The playerClass
     */
    public String getPlayerClass() {
        return playerClass;
    }

    public EnumsHS.CardClass getPlayerClassEnum() {
        if (playerClass == null) return EnumsHS.CardClass.NEUTRAL;
        switch (playerClass)
        {
            case "DRUID":
                return EnumsHS.CardClass.DRUID;
            case "HUNTER":
                return EnumsHS.CardClass.HUNTER;
            case "MAGE":
                return EnumsHS.CardClass.MAGE;
            case "PALADIN":
                return EnumsHS.CardClass.PALADIN;
            case "PRIEST":
                return EnumsHS.CardClass.PRIEST;
            case "ROGUE":
                return EnumsHS.CardClass.ROGUE;
            case "SHAMAN":
                return EnumsHS.CardClass.SHAMAN;
            case "WARLOCK":
                return EnumsHS.CardClass.WARLOCK;
            case "WARRIOR":
                return EnumsHS.CardClass.WARRIOR;
            default:
                return EnumsHS.CardClass.NEUTRAL;

        }
    }

    /**
     *
     * @param playerClass
     * The playerClass
     */
    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    /**
     *
     * @return
     * The textInPlay
     */
    public String getTextInPlay() {
        return textInPlay;
    }

    /**
     *
     * @param textInPlay
     * The textInPlay
     */
    public void setTextInPlay(String textInPlay) {
        this.textInPlay = textInPlay;
    }

    /**
     *
     * @return
     * The playRequirements
     */
    public PlayRequirements getPlayRequirements() {
        return playRequirements;
    }

    /**
     *
     * @param playRequirements
     * The playRequirements
     */
    public void setPlayRequirements(PlayRequirements playRequirements) {
        this.playRequirements = playRequirements;
    }

    /**
     *
     * @return
     * The flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     *
     * @param flavor
     * The flavor
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     *
     * @return
     * The text
     */
    public String getText() {
        if (text != null)
            return text.replace("$", "")
                    .replace("#", "")
                    .replace("\n", "<br/>");
        return text;
    }

    /**
     *
     * @param text
     * The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     * The entourage
     */
    public List<String> getEntourage() {
        return entourage;
    }

    /**
     *
     * @param entourage
     * The entourage
     */
    public void setEntourage(List<String> entourage) {
        this.entourage = entourage;
    }

    /**
     *
     * @return
     * The mechanics
     */
    public List<String> getMechanics() {
        return mechanics;
    }

    /**
     *
     * @param mechanics
     * The mechanics
     */
    public void setMechanics(List<String> mechanics) {
        this.mechanics = mechanics;
    }

    /**
     *
     * @return
     * The cost
     */
    public Integer getCost() {
        return cost;
    }

    /**
     *
     * @param cost
     * The cost
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     *
     * @return
     * The howToEarn
     */
    public String getHowToEarn() {
        return howToEarn;
    }

    /**
     *
     * @param howToEarn
     * The howToEarn
     */
    public void setHowToEarn(String howToEarn) {
        this.howToEarn = howToEarn;
    }

    /**
     *
     * @return
     * The attack
     */
    public Integer getAttack() {
        return attack;
    }

    /**
     *
     * @param attack
     * The attack
     */
    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The health
     */
    public Integer getHealth() {
        return health;
    }

    /**
     *
     * @param health
     * The health
     */
    public void setHealth(Integer health) {
        this.health = health;
    }

    /**
     *
     * @return
     * The durability
     */
    public Integer getDurability() {
        return durability;
    }

    /**
     *
     * @param durability
     * The durability
     */
    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    /**
     *
     * @return
     * The rarity
     */
    public String getRarity() {
        return rarity;
    }

    /**
     *
     * @param rarity
     * The rarity
     */
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    protected CardOLD(Parcel in) {
        artist = in.readString();
        howToEarnGolden = in.readString();
        if (in.readByte() == 0x01) {
            dust = new ArrayList<Integer>();
            in.readList(dust, Integer.class.getClassLoader());
        } else {
            dust = null;
        }
        texture = in.readString();
        set = in.readString();
        targetingArrowText = in.readString();
        byte collectibleVal = in.readByte();
        collectible = collectibleVal == 0x02 ? null : collectibleVal != 0x00;
        faction = in.readString();
        id = in.readString();
        race = in.readString();
        type = in.readString();
        playerClass = in.readString();
        textInPlay = in.readString();
        playRequirements = (PlayRequirements) in.readValue(PlayRequirements.class.getClassLoader());
        flavor = in.readString();
        text = in.readString();
        if (in.readByte() == 0x01) {
            entourage = new ArrayList<String>();
            in.readList(entourage, String.class.getClassLoader());
        } else {
            entourage = null;
        }
        if (in.readByte() == 0x01) {
            mechanics = new ArrayList<String>();
            in.readList(mechanics, String.class.getClassLoader());
        } else {
            mechanics = null;
        }
        cost = in.readByte() == 0x00 ? null : in.readInt();
        howToEarn = in.readString();
        attack = in.readByte() == 0x00 ? null : in.readInt();
        name = in.readString();
        health = in.readByte() == 0x00 ? null : in.readInt();
        durability = in.readByte() == 0x00 ? null : in.readInt();
        rarity = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(artist);
        dest.writeString(howToEarnGolden);
        if (dust == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(dust);
        }
        dest.writeString(texture);
        dest.writeString(set);
        dest.writeString(targetingArrowText);
        if (collectible == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (collectible ? 0x01 : 0x00));
        }
        dest.writeString(faction);
        dest.writeString(id);
        dest.writeString(race);
        dest.writeString(type);
        dest.writeString(playerClass);
        dest.writeString(textInPlay);
        dest.writeValue(playRequirements);
        dest.writeString(flavor);
        dest.writeString(text);
        if (entourage == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(entourage);
        }
        if (mechanics == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mechanics);
        }
        if (cost == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(cost);
        }
        dest.writeString(howToEarn);
        if (attack == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(attack);
        }
        dest.writeString(name);
        if (health == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(health);
        }
        if (durability == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(durability);
        }
        dest.writeString(rarity);
    }

    public int getCartArtResourceId(Context context)
    {
        if (id.endsWith("e") ||
                id.endsWith("b") ||
                id.endsWith("o") ||
                id.endsWith("h"))
        {
            id = id.substring(0, id.length() - 1);
        }
        else if (id.endsWith("eh") ||
                id.endsWith("e2"))
        {
            id = id.substring(0, id.length()-2);
        }

        int resourceId = context.getResources().getIdentifier(id.toLowerCase(), "drawable",
                context.getPackageName());

        if (resourceId == 0)
        {
            resourceId = R.drawable.placeholder_missing;
        }
        return resourceId;
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CardOLD> CREATOR = new Parcelable.Creator<CardOLD>() {
        @Override
        public CardOLD createFromParcel(Parcel in) {
            return new CardOLD(in);
        }

        @Override
        public CardOLD[] newArray(int size) {
            return new CardOLD[size];
        }
    };
}