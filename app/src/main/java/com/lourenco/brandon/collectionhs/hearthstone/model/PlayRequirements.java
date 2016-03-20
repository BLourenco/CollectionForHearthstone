package com.lourenco.brandon.collectionhs.hearthstone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.Pair;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;

import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class PlayRequirements implements Parcelable {

    @SerializedName("REQ_MINION_TARGET")
    @Expose
    private Integer REQMINIONTARGET;
    @SerializedName("REQ_FRIENDLY_TARGET")
    @Expose
    private Integer REQFRIENDLYTARGET;
    @SerializedName("REQ_ENEMY_TARGET")
    @Expose
    private Integer REQENEMYTARGET;
    @SerializedName("REQ_DAMAGED_TARGET")
    @Expose
    private Integer REQDAMAGEDTARGET;
    @SerializedName("REQ_ENCHANTED_TARGET")
    @Expose
    private Integer REQENCHANTEDTARGET;
    @SerializedName("REQ_FROZEN_TARGET")
    @Expose
    private Integer REQFROZENTARGET;
    @SerializedName("REQ_CHARGE_TARGET")
    @Expose
    private Integer REQCHARGETARGET;
    @SerializedName("REQ_TARGET_MAX_ATTACK")
    @Expose
    private Integer REQTARGETMAXATTACK;
    @SerializedName("REQ_NONSELF_TARGET")
    @Expose
    private Integer REQNONSELFTARGET;
    @SerializedName("REQ_TARGET_WITH_RACE")
    @Expose
    private Integer REQTARGETWITHRACE;
    @SerializedName("REQ_TARGET_TO_PLAY")
    @Expose
    private Integer REQTARGETTOPLAY;
    @SerializedName("REQ_NUM_MINION_SLOTS")
    @Expose
    private Integer REQNUMMINIONSLOTS;
    @SerializedName("REQ_WEAPON_EQUIPPED")
    @Expose
    private Integer REQWEAPONEQUIPPED;
    @SerializedName("REQ_ENOUGH_MANA")
    @Expose
    private Integer REQENOUGHMANA;
    @SerializedName("REQ_YOUR_TURN")
    @Expose
    private Integer REQYOURTURN;
    @SerializedName("REQ_NONSTEALTH_ENEMY_TARGET")
    @Expose
    private Integer REQNONSTEALTHENEMYTARGET;
    @SerializedName("REQ_HERO_TARGET")
    @Expose
    private Integer REQHEROTARGET;
    @SerializedName("REQ_SECRET_CAP")
    @Expose
    private Integer REQSECRETCAP;
    @SerializedName("REQ_MINION_CAP_IF_TARGET_AVAILABLE")
    @Expose
    private Integer REQMINIONCAPIFTARGETAVAILABLE;
    @SerializedName("REQ_MINION_CAP")
    @Expose
    private Integer REQMINIONCAP;
    @SerializedName("REQ_TARGET_ATTACKED_THIS_TURN")
    @Expose
    private Integer REQTARGETATTACKEDTHISTURN;
    @SerializedName("REQ_TARGET_IF_AVAILABLE")
    @Expose
    private Integer REQTARGETIFAVAILABLE;
    @SerializedName("REQ_MINIMUM_ENEMY_MINIONS")
    @Expose
    private Integer REQMINIMUMENEMYMINIONS;
    @SerializedName("REQ_TARGET_FOR_COMBO")
    @Expose
    private Integer REQTARGETFORCOMBO;
    @SerializedName("REQ_NOT_EXHAUSTED_ACTIVATE")
    @Expose
    private Integer REQNOTEXHAUSTEDACTIVATE;
    @SerializedName("REQ_UNIQUE_SECRET")
    @Expose
    private Integer REQUNIQUESECRET;
    @SerializedName("REQ_TARGET_TAUNTER")
    @Expose
    private Integer REQTARGETTAUNTER;
    @SerializedName("REQ_CAN_BE_ATTACKED")
    @Expose
    private Integer REQCANBEATTACKED;
    @SerializedName("REQ_ACTION_PWR_IS_MASTER_PWR")
    @Expose
    private Integer REQACTIONPWRISMASTERPWR;
    @SerializedName("REQ_TARGET_MAGNET")
    @Expose
    private Integer REQTARGETMAGNET;
    @SerializedName("REQ_ATTACK_GREATER_THAN_0")
    @Expose
    private Integer REQATTACKGREATERTHAN0;
    @SerializedName("REQ_ATTACKER_NOT_FROZEN")
    @Expose
    private Integer REQATTACKERNOTFROZEN;
    @SerializedName("REQ_HERO_OR_MINION_TARGET")
    @Expose
    private Integer REQHEROORMINIONTARGET;
    @SerializedName("REQ_CAN_BE_TARGETED_BY_SPELLS")
    @Expose
    private Integer REQCANBETARGETEDBYSPELLS;
    @SerializedName("REQ_SUBCARD_IS_PLAYABLE")
    @Expose
    private Integer REQSUBCARDISPLAYABLE;
    @SerializedName("REQ_TARGET_FOR_NO_COMBO")
    @Expose
    private Integer REQTARGETFORNOCOMBO;
    @SerializedName("REQ_NOT_MINION_JUST_PLAYED")
    @Expose
    private Integer REQNOTMINIONJUSTPLAYED;
    @SerializedName("REQ_NOT_EXHAUSTED_HERO_POWER")
    @Expose
    private Integer REQNOTEXHAUSTEDHEROPOWER;
    @SerializedName("REQ_CAN_BE_TARGETED_BY_OPPONENTS")
    @Expose
    private Integer REQCANBETARGETEDBYOPPONENTS;
    @SerializedName("REQ_ATTACKER_CAN_ATTACK")
    @Expose
    private Integer REQATTACKERCANATTACK;
    @SerializedName("REQ_TARGET_MIN_ATTACK")
    @Expose
    private Integer REQTARGETMINATTACK;
    @SerializedName("REQ_CAN_BE_TARGETED_BY_HERO_POWERS")
    @Expose
    private Integer REQCANBETARGETEDBYHEROPOWERS;
    @SerializedName("REQ_ENEMY_TARGET_NOT_IMMUNE")
    @Expose
    private Integer REQENEMYTARGETNOTIMMUNE;
    @SerializedName("REQ_ENTIRE_ENTOURAGE_NOT_IN_PLAY")
    @Expose
    private Integer REQENTIREENTOURAGENOTINPLAY;
    @SerializedName("REQ_MINIMUM_TOTAL_MINIONS")
    @Expose
    private Integer REQMINIMUMTOTALMINIONS;
    @SerializedName("REQ_MUST_TARGET_TAUNTER")
    @Expose
    private Integer REQMUSTTARGETTAUNTER;
    @SerializedName("REQ_UNDAMAGED_TARGET")
    @Expose
    private Integer REQUNDAMAGEDTARGET;
    @SerializedName("REQ_CAN_BE_TARGETED_BY_BATTLECRIES")
    @Expose
    private Integer REQCANBETARGETEDBYBATTLECRIES;
    @SerializedName("REQ_STEADY_SHOT")
    @Expose
    private Integer REQSTEADYSHOT;
    @SerializedName("REQ_MINION_OR_ENEMY_HERO")
    @Expose
    private Integer REQMINIONORENEMYHERO;
    @SerializedName("REQ_TARGET_IF_AVAILABLE_AND_DRAGON_IN_HAND")
    @Expose
    private Integer REQTARGETIFAVAILABLEANDDRAGONINHAND;
    @SerializedName("REQ_LEGENDARY_TARGET")
    @Expose
    private Integer REQLEGENDARYTARGET;
    @SerializedName("REQ_FRIENDLY_MINION_DIED_THIS_TURN")
    @Expose
    private Integer REQFRIENDLYMINIONDIEDTHISTURN;
    @SerializedName("REQ_FRIENDLY_MINION_DIED_THIS_GAME")
    @Expose
    private Integer REQFRIENDLYMINIONDIEDTHISGAME;
    @SerializedName("REQ_ENEMY_WEAPON_EQUIPPED")
    @Expose
    private Integer REQENEMYWEAPONEQUIPPED;
    @SerializedName("REQ_TARGET_IF_AVAILABLE_AND_MINIMUM_FRIENDLY_MINIONS")
    @Expose
    private Integer REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS;
    @SerializedName("REQ_TARGET_WITH_BATTLECRY")
    @Expose
    private Integer REQTARGETWITHBATTLECRY;
    @SerializedName("REQ_TARGET_WITH_DEATHRATTLE")
    @Expose
    private Integer REQTARGETWITHDEATHRATTLE;
    @SerializedName("REQ_DRAG_TO_PLAY")
    @Expose
    private Integer REQDRAGTOPLAY;

    /* TODO */
    public List<Pair<EnumsHS.PlayReq, Integer>> getAllRequirements()
    {
        List<Pair<EnumsHS.PlayReq, Integer>> reqs = new ArrayList<>();

        /* TODO Redo implementation to avoid hard coding. (Reflection?) */
        if (REQMINIONTARGET != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_MINION_TARGET, REQMINIONTARGET));
        if (REQFRIENDLYTARGET != null)  reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_FRIENDLY_TARGET, REQFRIENDLYTARGET));
        if (REQENEMYTARGET != null)     reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_ENEMY_TARGET, REQENEMYTARGET));
        if (REQDAMAGEDTARGET != null)   reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_DAMAGED_TARGET, REQDAMAGEDTARGET));
        if (REQENCHANTEDTARGET != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_ENCHANTED_TARGET, REQENCHANTEDTARGET));
        if (REQFROZENTARGET != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_FROZEN_TARGET, REQFROZENTARGET));
        if (REQCHARGETARGET != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_CHARGE_TARGET, REQCHARGETARGET));
        if (REQTARGETMAXATTACK != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_MAX_ATTACK, REQTARGETMAXATTACK));
        if (REQNONSELFTARGET != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_NONSELF_TARGET, REQNONSELFTARGET));
        if (REQTARGETWITHRACE != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_WITH_RACE, REQTARGETWITHRACE));
        if (REQTARGETTOPLAY != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_TO_PLAY, REQTARGETTOPLAY));
        if (REQNUMMINIONSLOTS != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_NUM_MINION_SLOTS, REQNUMMINIONSLOTS));
        if (REQWEAPONEQUIPPED != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_WEAPON_EQUIPPED, REQWEAPONEQUIPPED));
        if (REQENOUGHMANA != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_ENOUGH_MANA, REQENOUGHMANA));
        if (REQYOURTURN != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_YOUR_TURN, REQYOURTURN));
        if (REQNONSTEALTHENEMYTARGET != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_NONSTEALTH_ENEMY_TARGET, REQNONSTEALTHENEMYTARGET));
        if (REQHEROTARGET != null)    reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_HERO_TARGET, REQHEROTARGET));
        if (REQSECRETCAP != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_SECRET_CAP, REQSECRETCAP));
        if (REQMINIONCAPIFTARGETAVAILABLE != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_MINION_CAP_IF_TARGET_AVAILABLE, REQMINIONCAPIFTARGETAVAILABLE));
        if (REQMINIONCAP != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_MINION_CAP, REQMINIONCAP));
        if (REQTARGETATTACKEDTHISTURN != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_ATTACKED_THIS_TURN, REQTARGETATTACKEDTHISTURN));
        if (REQTARGETIFAVAILABLE != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_IF_AVAILABLE, REQTARGETIFAVAILABLE));
        if (REQMINIMUMENEMYMINIONS != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_MINIMUM_ENEMY_MINIONS, REQMINIMUMENEMYMINIONS));
        if (REQTARGETFORCOMBO != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_FOR_COMBO, REQTARGETFORCOMBO));
        if (REQNOTEXHAUSTEDACTIVATE != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_NOT_EXHAUSTED_ACTIVATE, REQNOTEXHAUSTEDACTIVATE));
        if (REQUNIQUESECRET != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_UNIQUE_SECRET, REQUNIQUESECRET));
        if (REQTARGETTAUNTER != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_TAUNTER, REQTARGETTAUNTER));
        if (REQCANBEATTACKED != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_CAN_BE_ATTACKED, REQCANBEATTACKED));
        if (REQACTIONPWRISMASTERPWR != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_ACTION_PWR_IS_MASTER_PWR, REQACTIONPWRISMASTERPWR));
        if (REQTARGETMAGNET != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_MAGNET, REQTARGETMAGNET));
        if (REQATTACKGREATERTHAN0 != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_ATTACK_GREATER_THAN_0, REQATTACKGREATERTHAN0));
        if (REQATTACKERNOTFROZEN != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_ATTACKER_NOT_FROZEN, REQATTACKERNOTFROZEN));
        if (REQHEROORMINIONTARGET != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_HERO_OR_MINION_TARGET, REQHEROORMINIONTARGET));
        if (REQCANBETARGETEDBYSPELLS != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_CAN_BE_TARGETED_BY_SPELLS, REQCANBETARGETEDBYSPELLS));
        if (REQSUBCARDISPLAYABLE != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_SUBCARD_IS_PLAYABLE, REQSUBCARDISPLAYABLE));
        if (REQTARGETFORNOCOMBO != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_FOR_NO_COMBO, REQTARGETFORNOCOMBO));
        if (REQNOTMINIONJUSTPLAYED != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_NOT_MINION_JUST_PLAYED, REQNOTMINIONJUSTPLAYED));
        if (REQNOTEXHAUSTEDHEROPOWER != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_NOT_EXHAUSTED_HERO_POWER, REQNOTEXHAUSTEDHEROPOWER));
        if (REQCANBETARGETEDBYOPPONENTS != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_CAN_BE_TARGETED_BY_OPPONENTS, REQCANBETARGETEDBYOPPONENTS));
        if (REQATTACKERCANATTACK != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_ATTACKER_CAN_ATTACK, REQATTACKERCANATTACK));
        if (REQTARGETMINATTACK != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_MIN_ATTACK, REQTARGETMINATTACK));
        if (REQCANBETARGETEDBYHEROPOWERS != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_CAN_BE_TARGETED_BY_HERO_POWERS, REQCANBETARGETEDBYHEROPOWERS));
        if (REQENEMYTARGETNOTIMMUNE != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_ENEMY_TARGET_NOT_IMMUNE, REQENEMYTARGETNOTIMMUNE));
        if (REQENTIREENTOURAGENOTINPLAY != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_ENTIRE_ENTOURAGE_NOT_IN_PLAY, REQENTIREENTOURAGENOTINPLAY));
        if (REQMINIMUMTOTALMINIONS != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_MINIMUM_TOTAL_MINIONS, REQMINIMUMTOTALMINIONS));
        if (REQMUSTTARGETTAUNTER != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_MUST_TARGET_TAUNTER, REQMUSTTARGETTAUNTER));
        if (REQUNDAMAGEDTARGET != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_UNDAMAGED_TARGET, REQUNDAMAGEDTARGET));
        if (REQCANBETARGETEDBYBATTLECRIES != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_CAN_BE_TARGETED_BY_BATTLECRIES, REQCANBETARGETEDBYBATTLECRIES));
        if (REQSTEADYSHOT != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_STEADY_SHOT, REQSTEADYSHOT));
        if (REQMINIONORENEMYHERO != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_MINION_OR_ENEMY_HERO, REQMINIONORENEMYHERO));
        if (REQTARGETIFAVAILABLEANDDRAGONINHAND != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_IF_AVAILABLE_AND_DRAGON_IN_HAND, REQTARGETIFAVAILABLEANDDRAGONINHAND));
        if (REQLEGENDARYTARGET != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_LEGENDARY_TARGET, REQLEGENDARYTARGET));
        if (REQFRIENDLYMINIONDIEDTHISTURN != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_FRIENDLY_MINION_DIED_THIS_TURN, REQFRIENDLYMINIONDIEDTHISTURN));
        if (REQFRIENDLYMINIONDIEDTHISGAME != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_FRIENDLY_MINION_DIED_THIS_GAME, REQFRIENDLYMINIONDIEDTHISGAME));
        if (REQENEMYWEAPONEQUIPPED != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_ENEMY_WEAPON_EQUIPPED, REQENEMYWEAPONEQUIPPED));
        if (REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_IF_AVAILABLE_AND_MINIMUM_FRIENDLY_MINIONS, REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS));
        if (REQTARGETWITHBATTLECRY != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_WITH_BATTLECRY, REQTARGETWITHBATTLECRY));
        if (REQTARGETWITHDEATHRATTLE != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_TARGET_WITH_DEATHRATTLE, REQTARGETWITHDEATHRATTLE));
        if (REQDRAGTOPLAY != null) reqs.add(new Pair<EnumsHS.PlayReq, Integer>(EnumsHS.PlayReq.REQ_DRAG_TO_PLAY, REQDRAGTOPLAY));

        return reqs;
    }

    /**
     *
     * @return
     * The REQMINIONTARGET
     */
    public Integer getREQMINIONTARGET() {
        return REQMINIONTARGET;
    }

    /**
     *
     * @param REQMINIONTARGET
     * The REQ_MINION_TARGET
     */
    public void setREQMINIONTARGET(Integer REQMINIONTARGET) {
        this.REQMINIONTARGET = REQMINIONTARGET;
    }

    /**
     *
     * @return
     * The REQFRIENDLYTARGET
     */
    public Integer getREQFRIENDLYTARGET() {
        return REQFRIENDLYTARGET;
    }

    /**
     *
     * @param REQFRIENDLYTARGET
     * The REQ_FRIENDLY_TARGET
     */
    public void setREQFRIENDLYTARGET(Integer REQFRIENDLYTARGET) {
        this.REQFRIENDLYTARGET = REQFRIENDLYTARGET;
    }

    /**
     *
     * @return
     * The REQENEMYTARGET
     */
    public Integer getREQENEMYTARGET() {
        return REQENEMYTARGET;
    }

    /**
     *
     * @param REQENEMYTARGET
     * The REQ_ENEMY_TARGET
     */
    public void setREQENEMYTARGET(Integer REQENEMYTARGET) {
        this.REQENEMYTARGET = REQENEMYTARGET;
    }

    /**
     *
     * @return
     * The REQDAMAGEDTARGET
     */
    public Integer getREQDAMAGEDTARGET() {
        return REQDAMAGEDTARGET;
    }

    /**
     *
     * @param REQDAMAGEDTARGET
     * The REQ_DAMAGED_TARGET
     */
    public void setREQDAMAGEDTARGET(Integer REQDAMAGEDTARGET) {
        this.REQDAMAGEDTARGET = REQDAMAGEDTARGET;
    }

    /**
     *
     * @return
     * The REQENCHANTEDTARGET
     */
    public Integer getREQENCHANTEDTARGET() {
        return REQENCHANTEDTARGET;
    }

    /**
     *
     * @param REQENCHANTEDTARGET
     * The REQ_ENCHANTED_TARGET
     */
    public void setREQENCHANTEDTARGET(Integer REQENCHANTEDTARGET) {
        this.REQENCHANTEDTARGET = REQENCHANTEDTARGET;
    }

    /**
     *
     * @return
     * The REQFROZENTARGET
     */
    public Integer getREQFROZENTARGET() {
        return REQFROZENTARGET;
    }

    /**
     *
     * @param REQFROZENTARGET
     * The REQ_FROZEN_TARGET
     */
    public void setREQFROZENTARGET(Integer REQFROZENTARGET) {
        this.REQFROZENTARGET = REQFROZENTARGET;
    }

    /**
     *
     * @return
     * The REQCHARGETARGET
     */
    public Integer getREQCHARGETARGET() {
        return REQCHARGETARGET;
    }

    /**
     *
     * @param REQCHARGETARGET
     * The REQ_CHARGE_TARGET
     */
    public void setREQCHARGETARGET(Integer REQCHARGETARGET) {
        this.REQCHARGETARGET = REQCHARGETARGET;
    }

    /**
     *
     * @return
     * The REQTARGETMAXATTACK
     */
    public Integer getREQTARGETMAXATTACK() {
        return REQTARGETMAXATTACK;
    }

    /**
     *
     * @param REQTARGETMAXATTACK
     * The REQ_TARGET_MAX_ATTACK
     */
    public void setREQTARGETMAXATTACK(Integer REQTARGETMAXATTACK) {
        this.REQTARGETMAXATTACK = REQTARGETMAXATTACK;
    }

    /**
     *
     * @return
     * The REQNONSELFTARGET
     */
    public Integer getREQNONSELFTARGET() {
        return REQNONSELFTARGET;
    }

    /**
     *
     * @param REQNONSELFTARGET
     * The REQ_NONSELF_TARGET
     */
    public void setREQNONSELFTARGET(Integer REQNONSELFTARGET) {
        this.REQNONSELFTARGET = REQNONSELFTARGET;
    }

    /**
     *
     * @return
     * The REQTARGETWITHRACE
     */
    public Integer getREQTARGETWITHRACE() {
        return REQTARGETWITHRACE;
    }

    /**
     *
     * @param REQTARGETWITHRACE
     * The REQ_TARGET_WITH_RACE
     */
    public void setREQTARGETWITHRACE(Integer REQTARGETWITHRACE) {
        this.REQTARGETWITHRACE = REQTARGETWITHRACE;
    }

    /**
     *
     * @return
     * The REQTARGETTOPLAY
     */
    public Integer getREQTARGETTOPLAY() {
        return REQTARGETTOPLAY;
    }

    /**
     *
     * @param REQTARGETTOPLAY
     * The REQ_TARGET_TO_PLAY
     */
    public void setREQTARGETTOPLAY(Integer REQTARGETTOPLAY) {
        this.REQTARGETTOPLAY = REQTARGETTOPLAY;
    }

    /**
     *
     * @return
     * The REQNUMMINIONSLOTS
     */
    public Integer getREQNUMMINIONSLOTS() {
        return REQNUMMINIONSLOTS;
    }

    /**
     *
     * @param REQNUMMINIONSLOTS
     * The REQ_NUM_MINION_SLOTS
     */
    public void setREQNUMMINIONSLOTS(Integer REQNUMMINIONSLOTS) {
        this.REQNUMMINIONSLOTS = REQNUMMINIONSLOTS;
    }

    /**
     *
     * @return
     * The REQWEAPONEQUIPPED
     */
    public Integer getREQWEAPONEQUIPPED() {
        return REQWEAPONEQUIPPED;
    }

    /**
     *
     * @param REQWEAPONEQUIPPED
     * The REQ_WEAPON_EQUIPPED
     */
    public void setREQWEAPONEQUIPPED(Integer REQWEAPONEQUIPPED) {
        this.REQWEAPONEQUIPPED = REQWEAPONEQUIPPED;
    }

    /**
     *
     * @return
     * The REQENOUGHMANA
     */
    public Integer getREQENOUGHMANA() {
        return REQENOUGHMANA;
    }

    /**
     *
     * @param REQENOUGHMANA
     * The REQ_ENOUGH_MANA
     */
    public void setREQENOUGHMANA(Integer REQENOUGHMANA) {
        this.REQENOUGHMANA = REQENOUGHMANA;
    }

    /**
     *
     * @return
     * The REQYOURTURN
     */
    public Integer getREQYOURTURN() {
        return REQYOURTURN;
    }

    /**
     *
     * @param REQYOURTURN
     * The REQ_YOUR_TURN
     */
    public void setREQYOURTURN(Integer REQYOURTURN) {
        this.REQYOURTURN = REQYOURTURN;
    }

    /**
     *
     * @return
     * The REQNONSTEALTHENEMYTARGET
     */
    public Integer getREQNONSTEALTHENEMYTARGET() {
        return REQNONSTEALTHENEMYTARGET;
    }

    /**
     *
     * @param REQNONSTEALTHENEMYTARGET
     * The REQ_NONSTEALTH_ENEMY_TARGET
     */
    public void setREQNONSTEALTHENEMYTARGET(Integer REQNONSTEALTHENEMYTARGET) {
        this.REQNONSTEALTHENEMYTARGET = REQNONSTEALTHENEMYTARGET;
    }

    /**
     *
     * @return
     * The REQHEROTARGET
     */
    public Integer getREQHEROTARGET() {
        return REQHEROTARGET;
    }

    /**
     *
     * @param REQHEROTARGET
     * The REQ_HERO_TARGET
     */
    public void setREQHEROTARGET(Integer REQHEROTARGET) {
        this.REQHEROTARGET = REQHEROTARGET;
    }

    /**
     *
     * @return
     * The REQSECRETCAP
     */
    public Integer getREQSECRETCAP() {
        return REQSECRETCAP;
    }

    /**
     *
     * @param REQSECRETCAP
     * The REQ_SECRET_CAP
     */
    public void setREQSECRETCAP(Integer REQSECRETCAP) {
        this.REQSECRETCAP = REQSECRETCAP;
    }

    /**
     *
     * @return
     * The REQMINIONCAPIFTARGETAVAILABLE
     */
    public Integer getREQMINIONCAPIFTARGETAVAILABLE() {
        return REQMINIONCAPIFTARGETAVAILABLE;
    }

    /**
     *
     * @param REQMINIONCAPIFTARGETAVAILABLE
     * The REQ_MINION_CAP_IF_TARGET_AVAILABLE
     */
    public void setREQMINIONCAPIFTARGETAVAILABLE(Integer REQMINIONCAPIFTARGETAVAILABLE) {
        this.REQMINIONCAPIFTARGETAVAILABLE = REQMINIONCAPIFTARGETAVAILABLE;
    }

    /**
     *
     * @return
     * The REQMINIONCAP
     */
    public Integer getREQMINIONCAP() {
        return REQMINIONCAP;
    }

    /**
     *
     * @param REQMINIONCAP
     * The REQ_MINION_CAP
     */
    public void setREQMINIONCAP(Integer REQMINIONCAP) {
        this.REQMINIONCAP = REQMINIONCAP;
    }

    /**
     *
     * @return
     * The REQTARGETATTACKEDTHISTURN
     */
    public Integer getREQTARGETATTACKEDTHISTURN() {
        return REQTARGETATTACKEDTHISTURN;
    }

    /**
     *
     * @param REQTARGETATTACKEDTHISTURN
     * The REQ_TARGET_ATTACKED_THIS_TURN
     */
    public void setREQTARGETATTACKEDTHISTURN(Integer REQTARGETATTACKEDTHISTURN) {
        this.REQTARGETATTACKEDTHISTURN = REQTARGETATTACKEDTHISTURN;
    }

    /**
     *
     * @return
     * The REQTARGETIFAVAILABLE
     */
    public Integer getREQTARGETIFAVAILABLE() {
        return REQTARGETIFAVAILABLE;
    }

    /**
     *
     * @param REQTARGETIFAVAILABLE
     * The REQ_TARGET_IF_AVAILABLE
     */
    public void setREQTARGETIFAVAILABLE(Integer REQTARGETIFAVAILABLE) {
        this.REQTARGETIFAVAILABLE = REQTARGETIFAVAILABLE;
    }

    /**
     *
     * @return
     * The REQMINIMUMENEMYMINIONS
     */
    public Integer getREQMINIMUMENEMYMINIONS() {
        return REQMINIMUMENEMYMINIONS;
    }

    /**
     *
     * @param REQMINIMUMENEMYMINIONS
     * The REQ_MINIMUM_ENEMY_MINIONS
     */
    public void setREQMINIMUMENEMYMINIONS(Integer REQMINIMUMENEMYMINIONS) {
        this.REQMINIMUMENEMYMINIONS = REQMINIMUMENEMYMINIONS;
    }

    /**
     *
     * @return
     * The REQTARGETFORCOMBO
     */
    public Integer getREQTARGETFORCOMBO() {
        return REQTARGETFORCOMBO;
    }

    /**
     *
     * @param REQTARGETFORCOMBO
     * The REQ_TARGET_FOR_COMBO
     */
    public void setREQTARGETFORCOMBO(Integer REQTARGETFORCOMBO) {
        this.REQTARGETFORCOMBO = REQTARGETFORCOMBO;
    }

    /**
     *
     * @return
     * The REQNOTEXHAUSTEDACTIVATE
     */
    public Integer getREQNOTEXHAUSTEDACTIVATE() {
        return REQNOTEXHAUSTEDACTIVATE;
    }

    /**
     *
     * @param REQNOTEXHAUSTEDACTIVATE
     * The REQ_NOT_EXHAUSTED_ACTIVATE
     */
    public void setREQNOTEXHAUSTEDACTIVATE(Integer REQNOTEXHAUSTEDACTIVATE) {
        this.REQNOTEXHAUSTEDACTIVATE = REQNOTEXHAUSTEDACTIVATE;
    }

    /**
     *
     * @return
     * The REQUNIQUESECRET
     */
    public Integer getREQUNIQUESECRET() {
        return REQUNIQUESECRET;
    }

    /**
     *
     * @param REQUNIQUESECRET
     * The REQ_UNIQUE_SECRET
     */
    public void setREQUNIQUESECRET(Integer REQUNIQUESECRET) {
        this.REQUNIQUESECRET = REQUNIQUESECRET;
    }

    /**
     *
     * @return
     * The REQTARGETTAUNTER
     */
    public Integer getREQTARGETTAUNTER() {
        return REQTARGETTAUNTER;
    }

    /**
     *
     * @param REQTARGETTAUNTER
     * The REQ_TARGET_TAUNTER
     */
    public void setREQTARGETTAUNTER(Integer REQTARGETTAUNTER) {
        this.REQTARGETTAUNTER = REQTARGETTAUNTER;
    }

    /**
     *
     * @return
     * The REQCANBEATTACKED
     */
    public Integer getREQCANBEATTACKED() {
        return REQCANBEATTACKED;
    }

    /**
     *
     * @param REQCANBEATTACKED
     * The REQ_CAN_BE_ATTACKED
     */
    public void setREQCANBEATTACKED(Integer REQCANBEATTACKED) {
        this.REQCANBEATTACKED = REQCANBEATTACKED;
    }

    /**
     *
     * @return
     * The REQACTIONPWRISMASTERPWR
     */
    public Integer getREQACTIONPWRISMASTERPWR() {
        return REQACTIONPWRISMASTERPWR;
    }

    /**
     *
     * @param REQACTIONPWRISMASTERPWR
     * The REQ_ACTION_PWR_IS_MASTER_PWR
     */
    public void setREQACTIONPWRISMASTERPWR(Integer REQACTIONPWRISMASTERPWR) {
        this.REQACTIONPWRISMASTERPWR = REQACTIONPWRISMASTERPWR;
    }

    /**
     *
     * @return
     * The REQTARGETMAGNET
     */
    public Integer getREQTARGETMAGNET() {
        return REQTARGETMAGNET;
    }

    /**
     *
     * @param REQTARGETMAGNET
     * The REQ_TARGET_MAGNET
     */
    public void setREQTARGETMAGNET(Integer REQTARGETMAGNET) {
        this.REQTARGETMAGNET = REQTARGETMAGNET;
    }

    /**
     *
     * @return
     * The REQATTACKGREATERTHAN0
     */
    public Integer getREQATTACKGREATERTHAN0() {
        return REQATTACKGREATERTHAN0;
    }

    /**
     *
     * @param REQATTACKGREATERTHAN0
     * The REQ_ATTACK_GREATER_THAN_0
     */
    public void setREQATTACKGREATERTHAN0(Integer REQATTACKGREATERTHAN0) {
        this.REQATTACKGREATERTHAN0 = REQATTACKGREATERTHAN0;
    }

    /**
     *
     * @return
     * The REQATTACKERNOTFROZEN
     */
    public Integer getREQATTACKERNOTFROZEN() {
        return REQATTACKERNOTFROZEN;
    }

    /**
     *
     * @param REQATTACKERNOTFROZEN
     * The REQ_ATTACKER_NOT_FROZEN
     */
    public void setREQATTACKERNOTFROZEN(Integer REQATTACKERNOTFROZEN) {
        this.REQATTACKERNOTFROZEN = REQATTACKERNOTFROZEN;
    }

    /**
     *
     * @return
     * The REQHEROORMINIONTARGET
     */
    public Integer getREQHEROORMINIONTARGET() {
        return REQHEROORMINIONTARGET;
    }

    /**
     *
     * @param REQHEROORMINIONTARGET
     * The REQ_HERO_OR_MINION_TARGET
     */
    public void setREQHEROORMINIONTARGET(Integer REQHEROORMINIONTARGET) {
        this.REQHEROORMINIONTARGET = REQHEROORMINIONTARGET;
    }

    /**
     *
     * @return
     * The REQCANBETARGETEDBYSPELLS
     */
    public Integer getREQCANBETARGETEDBYSPELLS() {
        return REQCANBETARGETEDBYSPELLS;
    }

    /**
     *
     * @param REQCANBETARGETEDBYSPELLS
     * The REQ_CAN_BE_TARGETED_BY_SPELLS
     */
    public void setREQCANBETARGETEDBYSPELLS(Integer REQCANBETARGETEDBYSPELLS) {
        this.REQCANBETARGETEDBYSPELLS = REQCANBETARGETEDBYSPELLS;
    }

    /**
     *
     * @return
     * The REQSUBCARDISPLAYABLE
     */
    public Integer getREQSUBCARDISPLAYABLE() {
        return REQSUBCARDISPLAYABLE;
    }

    /**
     *
     * @param REQSUBCARDISPLAYABLE
     * The REQ_SUBCARD_IS_PLAYABLE
     */
    public void setREQSUBCARDISPLAYABLE(Integer REQSUBCARDISPLAYABLE) {
        this.REQSUBCARDISPLAYABLE = REQSUBCARDISPLAYABLE;
    }

    /**
     *
     * @return
     * The REQTARGETFORNOCOMBO
     */
    public Integer getREQTARGETFORNOCOMBO() {
        return REQTARGETFORNOCOMBO;
    }

    /**
     *
     * @param REQTARGETFORNOCOMBO
     * The REQ_TARGET_FOR_NO_COMBO
     */
    public void setREQTARGETFORNOCOMBO(Integer REQTARGETFORNOCOMBO) {
        this.REQTARGETFORNOCOMBO = REQTARGETFORNOCOMBO;
    }

    /**
     *
     * @return
     * The REQNOTMINIONJUSTPLAYED
     */
    public Integer getREQNOTMINIONJUSTPLAYED() {
        return REQNOTMINIONJUSTPLAYED;
    }

    /**
     *
     * @param REQNOTMINIONJUSTPLAYED
     * The REQ_NOT_MINION_JUST_PLAYED
     */
    public void setREQNOTMINIONJUSTPLAYED(Integer REQNOTMINIONJUSTPLAYED) {
        this.REQNOTMINIONJUSTPLAYED = REQNOTMINIONJUSTPLAYED;
    }

    /**
     *
     * @return
     * The REQNOTEXHAUSTEDHEROPOWER
     */
    public Integer getREQNOTEXHAUSTEDHEROPOWER() {
        return REQNOTEXHAUSTEDHEROPOWER;
    }

    /**
     *
     * @param REQNOTEXHAUSTEDHEROPOWER
     * The REQ_NOT_EXHAUSTED_HERO_POWER
     */
    public void setREQNOTEXHAUSTEDHEROPOWER(Integer REQNOTEXHAUSTEDHEROPOWER) {
        this.REQNOTEXHAUSTEDHEROPOWER = REQNOTEXHAUSTEDHEROPOWER;
    }

    /**
     *
     * @return
     * The REQCANBETARGETEDBYOPPONENTS
     */
    public Integer getREQCANBETARGETEDBYOPPONENTS() {
        return REQCANBETARGETEDBYOPPONENTS;
    }

    /**
     *
     * @param REQCANBETARGETEDBYOPPONENTS
     * The REQ_CAN_BE_TARGETED_BY_OPPONENTS
     */
    public void setREQCANBETARGETEDBYOPPONENTS(Integer REQCANBETARGETEDBYOPPONENTS) {
        this.REQCANBETARGETEDBYOPPONENTS = REQCANBETARGETEDBYOPPONENTS;
    }

    /**
     *
     * @return
     * The REQATTACKERCANATTACK
     */
    public Integer getREQATTACKERCANATTACK() {
        return REQATTACKERCANATTACK;
    }

    /**
     *
     * @param REQATTACKERCANATTACK
     * The REQ_ATTACKER_CAN_ATTACK
     */
    public void setREQATTACKERCANATTACK(Integer REQATTACKERCANATTACK) {
        this.REQATTACKERCANATTACK = REQATTACKERCANATTACK;
    }

    /**
     *
     * @return
     * The REQTARGETMINATTACK
     */
    public Integer getREQTARGETMINATTACK() {
        return REQTARGETMINATTACK;
    }

    /**
     *
     * @param REQTARGETMINATTACK
     * The REQ_TARGET_MIN_ATTACK
     */
    public void setREQTARGETMINATTACK(Integer REQTARGETMINATTACK) {
        this.REQTARGETMINATTACK = REQTARGETMINATTACK;
    }

    /**
     *
     * @return
     * The REQCANBETARGETEDBYHEROPOWERS
     */
    public Integer getREQCANBETARGETEDBYHEROPOWERS() {
        return REQCANBETARGETEDBYHEROPOWERS;
    }

    /**
     *
     * @param REQCANBETARGETEDBYHEROPOWERS
     * The REQ_CAN_BE_TARGETED_BY_HERO_POWERS
     */
    public void setREQCANBETARGETEDBYHEROPOWERS(Integer REQCANBETARGETEDBYHEROPOWERS) {
        this.REQCANBETARGETEDBYHEROPOWERS = REQCANBETARGETEDBYHEROPOWERS;
    }

    /**
     *
     * @return
     * The REQENEMYTARGETNOTIMMUNE
     */
    public Integer getREQENEMYTARGETNOTIMMUNE() {
        return REQENEMYTARGETNOTIMMUNE;
    }

    /**
     *
     * @param REQENEMYTARGETNOTIMMUNE
     * The REQ_ENEMY_TARGET_NOT_IMMUNE
     */
    public void setREQENEMYTARGETNOTIMMUNE(Integer REQENEMYTARGETNOTIMMUNE) {
        this.REQENEMYTARGETNOTIMMUNE = REQENEMYTARGETNOTIMMUNE;
    }

    /**
     *
     * @return
     * The REQENTIREENTOURAGENOTINPLAY
     */
    public Integer getREQENTIREENTOURAGENOTINPLAY() {
        return REQENTIREENTOURAGENOTINPLAY;
    }

    /**
     *
     * @param REQENTIREENTOURAGENOTINPLAY
     * The REQ_ENTIRE_ENTOURAGE_NOT_IN_PLAY
     */
    public void setREQENTIREENTOURAGENOTINPLAY(Integer REQENTIREENTOURAGENOTINPLAY) {
        this.REQENTIREENTOURAGENOTINPLAY = REQENTIREENTOURAGENOTINPLAY;
    }

    /**
     *
     * @return
     * The REQMINIMUMTOTALMINIONS
     */
    public Integer getREQMINIMUMTOTALMINIONS() {
        return REQMINIMUMTOTALMINIONS;
    }

    /**
     *
     * @param REQMINIMUMTOTALMINIONS
     * The REQ_MINIMUM_TOTAL_MINIONS
     */
    public void setREQMINIMUMTOTALMINIONS(Integer REQMINIMUMTOTALMINIONS) {
        this.REQMINIMUMTOTALMINIONS = REQMINIMUMTOTALMINIONS;
    }

    /**
     *
     * @return
     * The REQMUSTTARGETTAUNTER
     */
    public Integer getREQMUSTTARGETTAUNTER() {
        return REQMUSTTARGETTAUNTER;
    }

    /**
     *
     * @param REQMUSTTARGETTAUNTER
     * The REQ_MUST_TARGET_TAUNTER
     */
    public void setREQMUSTTARGETTAUNTER(Integer REQMUSTTARGETTAUNTER) {
        this.REQMUSTTARGETTAUNTER = REQMUSTTARGETTAUNTER;
    }

    /**
     *
     * @return
     * The REQUNDAMAGEDTARGET
     */
    public Integer getREQUNDAMAGEDTARGET() {
        return REQUNDAMAGEDTARGET;
    }

    /**
     *
     * @param REQUNDAMAGEDTARGET
     * The REQ_UNDAMAGED_TARGET
     */
    public void setREQUNDAMAGEDTARGET(Integer REQUNDAMAGEDTARGET) {
        this.REQUNDAMAGEDTARGET = REQUNDAMAGEDTARGET;
    }

    /**
     *
     * @return
     * The REQCANBETARGETEDBYBATTLECRIES
     */
    public Integer getREQCANBETARGETEDBYBATTLECRIES() {
        return REQCANBETARGETEDBYBATTLECRIES;
    }

    /**
     *
     * @param REQCANBETARGETEDBYBATTLECRIES
     * The REQ_CAN_BE_TARGETED_BY_BATTLECRIES
     */
    public void setREQCANBETARGETEDBYBATTLECRIES(Integer REQCANBETARGETEDBYBATTLECRIES) {
        this.REQCANBETARGETEDBYBATTLECRIES = REQCANBETARGETEDBYBATTLECRIES;
    }

    /**
     *
     * @return
     * The REQSTEADYSHOT
     */
    public Integer getREQSTEADYSHOT() {
        return REQSTEADYSHOT;
    }

    /**
     *
     * @param REQSTEADYSHOT
     * The REQ_STEADY_SHOT
     */
    public void setREQSTEADYSHOT(Integer REQSTEADYSHOT) {
        this.REQSTEADYSHOT = REQSTEADYSHOT;
    }

    /**
     *
     * @return
     * The REQMINIONORENEMYHERO
     */
    public Integer getREQMINIONORENEMYHERO() {
        return REQMINIONORENEMYHERO;
    }

    /**
     *
     * @param REQMINIONORENEMYHERO
     * The REQ_MINION_OR_ENEMY_HERO
     */
    public void setREQMINIONORENEMYHERO(Integer REQMINIONORENEMYHERO) {
        this.REQMINIONORENEMYHERO = REQMINIONORENEMYHERO;
    }

    /**
     *
     * @return
     * The REQTARGETIFAVAILABLEANDDRAGONINHAND
     */
    public Integer getREQTARGETIFAVAILABLEANDDRAGONINHAND() {
        return REQTARGETIFAVAILABLEANDDRAGONINHAND;
    }

    /**
     *
     * @param REQTARGETIFAVAILABLEANDDRAGONINHAND
     * The REQ_TARGET_IF_AVAILABLE_AND_DRAGON_IN_HAND
     */
    public void setREQTARGETIFAVAILABLEANDDRAGONINHAND(Integer REQTARGETIFAVAILABLEANDDRAGONINHAND) {
        this.REQTARGETIFAVAILABLEANDDRAGONINHAND = REQTARGETIFAVAILABLEANDDRAGONINHAND;
    }

    /**
     *
     * @return
     * The REQLEGENDARYTARGET
     */
    public Integer getREQLEGENDARYTARGET() {
        return REQLEGENDARYTARGET;
    }

    /**
     *
     * @param REQLEGENDARYTARGET
     * The REQ_LEGENDARY_TARGET
     */
    public void setREQLEGENDARYTARGET(Integer REQLEGENDARYTARGET) {
        this.REQLEGENDARYTARGET = REQLEGENDARYTARGET;
    }

    /**
     *
     * @return
     * The REQFRIENDLYMINIONDIEDTHISTURN
     */
    public Integer getREQFRIENDLYMINIONDIEDTHISTURN() {
        return REQFRIENDLYMINIONDIEDTHISTURN;
    }

    /**
     *
     * @param REQFRIENDLYMINIONDIEDTHISTURN
     * The REQ_FRIENDLY_MINION_DIED_THIS_TURN
     */
    public void setREQFRIENDLYMINIONDIEDTHISTURN(Integer REQFRIENDLYMINIONDIEDTHISTURN) {
        this.REQFRIENDLYMINIONDIEDTHISTURN = REQFRIENDLYMINIONDIEDTHISTURN;
    }

    /**
     *
     * @return
     * The REQFRIENDLYMINIONDIEDTHISGAME
     */
    public Integer getREQFRIENDLYMINIONDIEDTHISGAME() {
        return REQFRIENDLYMINIONDIEDTHISGAME;
    }

    /**
     *
     * @param REQFRIENDLYMINIONDIEDTHISGAME
     * The REQ_FRIENDLY_MINION_DIED_THIS_GAME
     */
    public void setREQFRIENDLYMINIONDIEDTHISGAME(Integer REQFRIENDLYMINIONDIEDTHISGAME) {
        this.REQFRIENDLYMINIONDIEDTHISGAME = REQFRIENDLYMINIONDIEDTHISGAME;
    }

    /**
     *
     * @return
     * The REQENEMYWEAPONEQUIPPED
     */
    public Integer getREQENEMYWEAPONEQUIPPED() {
        return REQENEMYWEAPONEQUIPPED;
    }

    /**
     *
     * @param REQENEMYWEAPONEQUIPPED
     * The REQ_ENEMY_WEAPON_EQUIPPED
     */
    public void setREQENEMYWEAPONEQUIPPED(Integer REQENEMYWEAPONEQUIPPED) {
        this.REQENEMYWEAPONEQUIPPED = REQENEMYWEAPONEQUIPPED;
    }

    /**
     *
     * @return
     * The REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS
     */
    public Integer getREQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS() {
        return REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS;
    }

    /**
     *
     * @param REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS
     * The REQ_TARGET_IF_AVAILABLE_AND_MINIMUM_FRIENDLY_MINIONS
     */
    public void setREQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS(Integer REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS) {
        this.REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS = REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS;
    }

    /**
     *
     * @return
     * The REQTARGETWITHBATTLECRY
     */
    public Integer getREQTARGETWITHBATTLECRY() {
        return REQTARGETWITHBATTLECRY;
    }

    /**
     *
     * @param REQTARGETWITHBATTLECRY
     * The REQ_TARGET_WITH_BATTLECRY
     */
    public void setREQTARGETWITHBATTLECRY(Integer REQTARGETWITHBATTLECRY) {
        this.REQTARGETWITHBATTLECRY = REQTARGETWITHBATTLECRY;
    }

    /**
     *
     * @return
     * The REQTARGETWITHDEATHRATTLE
     */
    public Integer getREQTARGETWITHDEATHRATTLE() {
        return REQTARGETWITHDEATHRATTLE;
    }

    /**
     *
     * @param REQTARGETWITHDEATHRATTLE
     * The REQ_TARGET_WITH_DEATHRATTLE
     */
    public void setREQTARGETWITHDEATHRATTLE(Integer REQTARGETWITHDEATHRATTLE) {
        this.REQTARGETWITHDEATHRATTLE = REQTARGETWITHDEATHRATTLE;
    }

    /**
     *
     * @return
     * The REQDRAGTOPLAY
     */
    public Integer getREQDRAGTOPLAY() {
        return REQDRAGTOPLAY;
    }

    /**
     *
     * @param REQDRAGTOPLAY
     * The REQ_DRAG_TO_PLAY
     */
    public void setREQDRAGTOPLAY(Integer REQDRAGTOPLAY) {
        this.REQDRAGTOPLAY = REQDRAGTOPLAY;
    }


    protected PlayRequirements(Parcel in) {
        REQMINIONTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQFRIENDLYTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQENEMYTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQDAMAGEDTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQENCHANTEDTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQFROZENTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQCHARGETARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETMAXATTACK = in.readByte() == 0x00 ? null : in.readInt();
        REQNONSELFTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETWITHRACE = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETTOPLAY = in.readByte() == 0x00 ? null : in.readInt();
        REQNUMMINIONSLOTS = in.readByte() == 0x00 ? null : in.readInt();
        REQWEAPONEQUIPPED = in.readByte() == 0x00 ? null : in.readInt();
        REQENOUGHMANA = in.readByte() == 0x00 ? null : in.readInt();
        REQYOURTURN = in.readByte() == 0x00 ? null : in.readInt();
        REQNONSTEALTHENEMYTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQHEROTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQSECRETCAP = in.readByte() == 0x00 ? null : in.readInt();
        REQMINIONCAPIFTARGETAVAILABLE = in.readByte() == 0x00 ? null : in.readInt();
        REQMINIONCAP = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETATTACKEDTHISTURN = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETIFAVAILABLE = in.readByte() == 0x00 ? null : in.readInt();
        REQMINIMUMENEMYMINIONS = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETFORCOMBO = in.readByte() == 0x00 ? null : in.readInt();
        REQNOTEXHAUSTEDACTIVATE = in.readByte() == 0x00 ? null : in.readInt();
        REQUNIQUESECRET = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETTAUNTER = in.readByte() == 0x00 ? null : in.readInt();
        REQCANBEATTACKED = in.readByte() == 0x00 ? null : in.readInt();
        REQACTIONPWRISMASTERPWR = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETMAGNET = in.readByte() == 0x00 ? null : in.readInt();
        REQATTACKGREATERTHAN0 = in.readByte() == 0x00 ? null : in.readInt();
        REQATTACKERNOTFROZEN = in.readByte() == 0x00 ? null : in.readInt();
        REQHEROORMINIONTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQCANBETARGETEDBYSPELLS = in.readByte() == 0x00 ? null : in.readInt();
        REQSUBCARDISPLAYABLE = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETFORNOCOMBO = in.readByte() == 0x00 ? null : in.readInt();
        REQNOTMINIONJUSTPLAYED = in.readByte() == 0x00 ? null : in.readInt();
        REQNOTEXHAUSTEDHEROPOWER = in.readByte() == 0x00 ? null : in.readInt();
        REQCANBETARGETEDBYOPPONENTS = in.readByte() == 0x00 ? null : in.readInt();
        REQATTACKERCANATTACK = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETMINATTACK = in.readByte() == 0x00 ? null : in.readInt();
        REQCANBETARGETEDBYHEROPOWERS = in.readByte() == 0x00 ? null : in.readInt();
        REQENEMYTARGETNOTIMMUNE = in.readByte() == 0x00 ? null : in.readInt();
        REQENTIREENTOURAGENOTINPLAY = in.readByte() == 0x00 ? null : in.readInt();
        REQMINIMUMTOTALMINIONS = in.readByte() == 0x00 ? null : in.readInt();
        REQMUSTTARGETTAUNTER = in.readByte() == 0x00 ? null : in.readInt();
        REQUNDAMAGEDTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQCANBETARGETEDBYBATTLECRIES = in.readByte() == 0x00 ? null : in.readInt();
        REQSTEADYSHOT = in.readByte() == 0x00 ? null : in.readInt();
        REQMINIONORENEMYHERO = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETIFAVAILABLEANDDRAGONINHAND = in.readByte() == 0x00 ? null : in.readInt();
        REQLEGENDARYTARGET = in.readByte() == 0x00 ? null : in.readInt();
        REQFRIENDLYMINIONDIEDTHISTURN = in.readByte() == 0x00 ? null : in.readInt();
        REQFRIENDLYMINIONDIEDTHISGAME = in.readByte() == 0x00 ? null : in.readInt();
        REQENEMYWEAPONEQUIPPED = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETWITHBATTLECRY = in.readByte() == 0x00 ? null : in.readInt();
        REQTARGETWITHDEATHRATTLE = in.readByte() == 0x00 ? null : in.readInt();
        REQDRAGTOPLAY = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (REQMINIONTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQMINIONTARGET);
        }
        if (REQFRIENDLYTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQFRIENDLYTARGET);
        }
        if (REQENEMYTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQENEMYTARGET);
        }
        if (REQDAMAGEDTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQDAMAGEDTARGET);
        }
        if (REQENCHANTEDTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQENCHANTEDTARGET);
        }
        if (REQFROZENTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQFROZENTARGET);
        }
        if (REQCHARGETARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQCHARGETARGET);
        }
        if (REQTARGETMAXATTACK == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETMAXATTACK);
        }
        if (REQNONSELFTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQNONSELFTARGET);
        }
        if (REQTARGETWITHRACE == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETWITHRACE);
        }
        if (REQTARGETTOPLAY == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETTOPLAY);
        }
        if (REQNUMMINIONSLOTS == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQNUMMINIONSLOTS);
        }
        if (REQWEAPONEQUIPPED == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQWEAPONEQUIPPED);
        }
        if (REQENOUGHMANA == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQENOUGHMANA);
        }
        if (REQYOURTURN == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQYOURTURN);
        }
        if (REQNONSTEALTHENEMYTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQNONSTEALTHENEMYTARGET);
        }
        if (REQHEROTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQHEROTARGET);
        }
        if (REQSECRETCAP == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQSECRETCAP);
        }
        if (REQMINIONCAPIFTARGETAVAILABLE == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQMINIONCAPIFTARGETAVAILABLE);
        }
        if (REQMINIONCAP == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQMINIONCAP);
        }
        if (REQTARGETATTACKEDTHISTURN == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETATTACKEDTHISTURN);
        }
        if (REQTARGETIFAVAILABLE == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETIFAVAILABLE);
        }
        if (REQMINIMUMENEMYMINIONS == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQMINIMUMENEMYMINIONS);
        }
        if (REQTARGETFORCOMBO == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETFORCOMBO);
        }
        if (REQNOTEXHAUSTEDACTIVATE == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQNOTEXHAUSTEDACTIVATE);
        }
        if (REQUNIQUESECRET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQUNIQUESECRET);
        }
        if (REQTARGETTAUNTER == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETTAUNTER);
        }
        if (REQCANBEATTACKED == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQCANBEATTACKED);
        }
        if (REQACTIONPWRISMASTERPWR == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQACTIONPWRISMASTERPWR);
        }
        if (REQTARGETMAGNET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETMAGNET);
        }
        if (REQATTACKGREATERTHAN0 == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQATTACKGREATERTHAN0);
        }
        if (REQATTACKERNOTFROZEN == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQATTACKERNOTFROZEN);
        }
        if (REQHEROORMINIONTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQHEROORMINIONTARGET);
        }
        if (REQCANBETARGETEDBYSPELLS == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQCANBETARGETEDBYSPELLS);
        }
        if (REQSUBCARDISPLAYABLE == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQSUBCARDISPLAYABLE);
        }
        if (REQTARGETFORNOCOMBO == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETFORNOCOMBO);
        }
        if (REQNOTMINIONJUSTPLAYED == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQNOTMINIONJUSTPLAYED);
        }
        if (REQNOTEXHAUSTEDHEROPOWER == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQNOTEXHAUSTEDHEROPOWER);
        }
        if (REQCANBETARGETEDBYOPPONENTS == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQCANBETARGETEDBYOPPONENTS);
        }
        if (REQATTACKERCANATTACK == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQATTACKERCANATTACK);
        }
        if (REQTARGETMINATTACK == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETMINATTACK);
        }
        if (REQCANBETARGETEDBYHEROPOWERS == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQCANBETARGETEDBYHEROPOWERS);
        }
        if (REQENEMYTARGETNOTIMMUNE == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQENEMYTARGETNOTIMMUNE);
        }
        if (REQENTIREENTOURAGENOTINPLAY == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQENTIREENTOURAGENOTINPLAY);
        }
        if (REQMINIMUMTOTALMINIONS == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQMINIMUMTOTALMINIONS);
        }
        if (REQMUSTTARGETTAUNTER == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQMUSTTARGETTAUNTER);
        }
        if (REQUNDAMAGEDTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQUNDAMAGEDTARGET);
        }
        if (REQCANBETARGETEDBYBATTLECRIES == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQCANBETARGETEDBYBATTLECRIES);
        }
        if (REQSTEADYSHOT == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQSTEADYSHOT);
        }
        if (REQMINIONORENEMYHERO == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQMINIONORENEMYHERO);
        }
        if (REQTARGETIFAVAILABLEANDDRAGONINHAND == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETIFAVAILABLEANDDRAGONINHAND);
        }
        if (REQLEGENDARYTARGET == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQLEGENDARYTARGET);
        }
        if (REQFRIENDLYMINIONDIEDTHISTURN == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQFRIENDLYMINIONDIEDTHISTURN);
        }
        if (REQFRIENDLYMINIONDIEDTHISGAME == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQFRIENDLYMINIONDIEDTHISGAME);
        }
        if (REQENEMYWEAPONEQUIPPED == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQENEMYWEAPONEQUIPPED);
        }
        if (REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETIFAVAILABLEANDMINIMUMFRIENDLYMINIONS);
        }
        if (REQTARGETWITHBATTLECRY == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETWITHBATTLECRY);
        }
        if (REQTARGETWITHDEATHRATTLE == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQTARGETWITHDEATHRATTLE);
        }
        if (REQDRAGTOPLAY == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(REQDRAGTOPLAY);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PlayRequirements> CREATOR = new Parcelable.Creator<PlayRequirements>() {
        @Override
        public PlayRequirements createFromParcel(Parcel in) {
            return new PlayRequirements(in);
        }

        @Override
        public PlayRequirements[] newArray(int size) {
            return new PlayRequirements[size];
        }
    };
}