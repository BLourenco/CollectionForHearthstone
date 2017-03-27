package com.lourenco.brandon.collectionhs;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ToggleButton;

import com.lourenco.brandon.collectionhs.design.AppDesign;
import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;

import java.util.ArrayList;

/**
 * Created by Brandon on 2016-03-30.
 */
public class CardFilterActivity extends AppCompatActivity{

    CardFilter filter;

    ToggleButton[] tglFilterManaCost;
    ToggleButton[] tglFilterAttack;
    ToggleButton[] tglFilterHealth;

    ToggleButton[] tglFilterType;
    ToggleButton[] tglFilterRarity;
    ToggleButton[] tglFilterSet;
    ToggleButton[] tglFilterRace;
    CheckBox[] cbFilterMechanic;

    ToggleButton tglFilterPreset_AllSets;
    ToggleButton tglFilterPreset_StandardSets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_filter);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Filter");

        tglFilterManaCost = new ToggleButton[] {
                (ToggleButton)findViewById(R.id.tglFilterMana0),
                (ToggleButton)findViewById(R.id.tglFilterMana1),
                (ToggleButton)findViewById(R.id.tglFilterMana2),
                (ToggleButton)findViewById(R.id.tglFilterMana3),
                (ToggleButton)findViewById(R.id.tglFilterMana4),
                (ToggleButton)findViewById(R.id.tglFilterMana5),
                (ToggleButton)findViewById(R.id.tglFilterMana6),
                (ToggleButton)findViewById(R.id.tglFilterMana7),
                (ToggleButton)findViewById(R.id.tglFilterMana8),
                (ToggleButton)findViewById(R.id.tglFilterMana9),
                (ToggleButton)findViewById(R.id.tglFilterMana10plus),
        };

        tglFilterAttack = new ToggleButton[] {
                (ToggleButton)findViewById(R.id.tglFilterAttack0),
                (ToggleButton)findViewById(R.id.tglFilterAttack1),
                (ToggleButton)findViewById(R.id.tglFilterAttack2),
                (ToggleButton)findViewById(R.id.tglFilterAttack3),
                (ToggleButton)findViewById(R.id.tglFilterAttack4),
                (ToggleButton)findViewById(R.id.tglFilterAttack5),
                (ToggleButton)findViewById(R.id.tglFilterAttack6),
                (ToggleButton)findViewById(R.id.tglFilterAttack7),
                (ToggleButton)findViewById(R.id.tglFilterAttack8),
                (ToggleButton)findViewById(R.id.tglFilterAttack9),
                (ToggleButton)findViewById(R.id.tglFilterAttack10plus),
        };

        tglFilterHealth = new ToggleButton[] {
                (ToggleButton)findViewById(R.id.tglFilterHealth0),
                (ToggleButton)findViewById(R.id.tglFilterHealth1),
                (ToggleButton)findViewById(R.id.tglFilterHealth2),
                (ToggleButton)findViewById(R.id.tglFilterHealth3),
                (ToggleButton)findViewById(R.id.tglFilterHealth4),
                (ToggleButton)findViewById(R.id.tglFilterHealth5),
                (ToggleButton)findViewById(R.id.tglFilterHealth6),
                (ToggleButton)findViewById(R.id.tglFilterHealth7),
                (ToggleButton)findViewById(R.id.tglFilterHealth8),
                (ToggleButton)findViewById(R.id.tglFilterHealth9),
                (ToggleButton)findViewById(R.id.tglFilterHealth10plus),
        };

        tglFilterType = new ToggleButton[] {
                (ToggleButton)findViewById(R.id.tglTypeMinion),
                (ToggleButton)findViewById(R.id.tglTypeSpell),
                (ToggleButton)findViewById(R.id.tglTypeWeapon),
        };

        tglFilterRarity = new ToggleButton[] {
                (ToggleButton)findViewById(R.id.tglRarityCommon),
                (ToggleButton)findViewById(R.id.tglRarityRare),
                (ToggleButton)findViewById(R.id.tglRarityEpic),
                (ToggleButton)findViewById(R.id.tglRarityLegendary),
        };

        tglFilterSet = new ToggleButton[] {
                (ToggleButton)findViewById(R.id.tglFilterSetBasic),
                (ToggleButton)findViewById(R.id.tglFilterSetClassic),
                (ToggleButton)findViewById(R.id.tglFilterSetReward),
                (ToggleButton)findViewById(R.id.tglFilterSetNaxx),
                (ToggleButton)findViewById(R.id.tglFilterSetGVG),
                (ToggleButton)findViewById(R.id.tglFilterSetBRM),
                (ToggleButton)findViewById(R.id.tglFilterSetTGT),
                (ToggleButton)findViewById(R.id.tglFilterSetLOE),
                (ToggleButton)findViewById(R.id.tglFilterSetWOG),
                (ToggleButton)findViewById(R.id.tglFilterSetONiK),
                (ToggleButton)findViewById(R.id.tglFilterSetMSG),
                (ToggleButton)findViewById(R.id.tglFilterSetJTU),
        };

        // Add listeners to Set ToggleButtons
        for (int i = 0; i < tglFilterSet.length; i++)
        {
            tglFilterSet[i].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    calculatePresetToggleState();
                }
            });
        }



        tglFilterPreset_AllSets = (ToggleButton)findViewById(R.id.tglFilterSetAll);
        tglFilterPreset_StandardSets = (ToggleButton)findViewById(R.id.tglFilterSetStandard);

        // Enable/Disable Preset Filters
        tglFilterPreset_AllSets.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean checked = false;

                if (tglFilterPreset_AllSets.isChecked())
                    checked = true;

                tglFilterSet[0].setChecked(false);
                tglFilterSet[1].setChecked(false);
                tglFilterSet[2].setChecked(checked);
                tglFilterSet[3].setChecked(checked);
                tglFilterSet[4].setChecked(checked);
                tglFilterSet[5].setChecked(false);
                tglFilterSet[6].setChecked(false);
                tglFilterSet[7].setChecked(false);
                tglFilterSet[8].setChecked(false);
                tglFilterSet[9].setChecked(false);
                tglFilterSet[10].setChecked(false);
                tglFilterSet[11].setChecked(false);

                tglFilterPreset_StandardSets.setChecked(false);
            }
        });

        tglFilterPreset_StandardSets.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean checked = false;

                if (tglFilterPreset_StandardSets.isChecked())
                    checked = true;

                tglFilterSet[0].setChecked(checked);
                tglFilterSet[1].setChecked(checked);
                tglFilterSet[2].setChecked(false);
                tglFilterSet[3].setChecked(false);
                tglFilterSet[4].setChecked(false);
                tglFilterSet[5].setChecked(checked);
                tglFilterSet[6].setChecked(checked);
                tglFilterSet[7].setChecked(checked);
                tglFilterSet[8].setChecked(checked);
                tglFilterSet[9].setChecked(checked);
                tglFilterSet[10].setChecked(checked);
                tglFilterSet[11].setChecked(checked);

                tglFilterPreset_AllSets.setChecked(false);
            }
        });

        tglFilterRace = new ToggleButton[] {
                (ToggleButton)findViewById(R.id.tglRaceMurloc),
                (ToggleButton)findViewById(R.id.tglRaceDemon),
                (ToggleButton)findViewById(R.id.tglRaceMech),
                (ToggleButton)findViewById(R.id.tglRaceBeast),
                (ToggleButton)findViewById(R.id.tglRaceTotem),
                (ToggleButton)findViewById(R.id.tglRacePirate),
                (ToggleButton)findViewById(R.id.tglRaceDragon),
        };

        cbFilterMechanic = new CheckBox[] {
                (CheckBox)findViewById(R.id.cbMechanicAdjacentBuff),
                (CheckBox)findViewById(R.id.cbMechanicAura),
                (CheckBox)findViewById(R.id.cbMechanicBattlecry),
                (CheckBox)findViewById(R.id.cbMechanicCharge),
                (CheckBox)findViewById(R.id.cbMechanicChooseOne),
                (CheckBox)findViewById(R.id.cbMechanicCombo),
                (CheckBox)findViewById(R.id.cbMechanicDeathrattle),
                (CheckBox)findViewById(R.id.cbMechanicDivineShield),
                (CheckBox)findViewById(R.id.cbMechanicEnraged),
                (CheckBox)findViewById(R.id.cbMechanicForgetful),
                (CheckBox)findViewById(R.id.cbMechanicFreeze),
                (CheckBox)findViewById(R.id.cbMechanicInspire),
                (CheckBox)findViewById(R.id.cbMechanicPoisonous),
                (CheckBox)findViewById(R.id.cbMechanicSecret),
                (CheckBox)findViewById(R.id.cbMechanicSilence),
                (CheckBox)findViewById(R.id.cbMechanicStealth),
                (CheckBox)findViewById(R.id.cbMechanicTaunt),
                (CheckBox)findViewById(R.id.cbMechanicTopDeck),
                (CheckBox)findViewById(R.id.cbMechanicWindfury),
        };

        // Load proper button states

        filter = getIntent().getParcelableExtra("filter");

        if (filter == null) {
            filter = new CardFilter();
        }
        else
        {
            if (filter.mana != null)
                for (int i : filter.mana) {
                    tglFilterManaCost[i].setChecked(true);
                }

            if (filter.attack != null)
                for (int i : filter.attack) {
                    tglFilterAttack[i].setChecked(true);
                }

            if (filter.health != null)
                for (int i : filter.health) {
                    tglFilterHealth[i].setChecked(true);
                }

            if (filter.type != null)
            {
                for (Integer i : filter.type)
                {

                    if (i == EnumsHS.CardType.MINION.getValue()) tglFilterType[0].setChecked(true);
                    else if (i == EnumsHS.CardType.SPELL.getValue()) tglFilterType[1].setChecked(true);
                    else if (i == EnumsHS.CardType.WEAPON.getValue()) tglFilterType[2].setChecked(true);
                }
            }

            if (filter.rarity != null)
            {
                for (Integer i : filter.rarity)
                {

                    if (i == EnumsHS.Rarity.COMMON.getValue()) tglFilterRarity[0].setChecked(true);
                    else if (i == EnumsHS.Rarity.RARE.getValue()) tglFilterRarity[1].setChecked(true);
                    else if (i == EnumsHS.Rarity.EPIC.getValue()) tglFilterRarity[2].setChecked(true);
                    else if (i == EnumsHS.Rarity.LEGENDARY.getValue()) tglFilterRarity[3].setChecked(true);
                }
            }

            if (filter.set != null)
            {
                for (Integer i : filter.set)
                {
                    if (i == EnumsHS.CardSet.CORE.getValue()) tglFilterSet[0].setChecked(true);
                    else if (i == EnumsHS.CardSet.EXPERT1.getValue()) tglFilterSet[1].setChecked(true);
                    else if (i == EnumsHS.CardSet.REWARD.getValue()) tglFilterSet[2].setChecked(true);
                    else if (i == EnumsHS.CardSet.NAXX.getValue()) tglFilterSet[3].setChecked(true);
                    else if (i == EnumsHS.CardSet.GVG.getValue()) tglFilterSet[4].setChecked(true);
                    else if (i == EnumsHS.CardSet.BRM.getValue()) tglFilterSet[5].setChecked(true);
                    else if (i == EnumsHS.CardSet.TGT.getValue()) tglFilterSet[6].setChecked(true);
                    else if (i == EnumsHS.CardSet.LOE.getValue()) tglFilterSet[7].setChecked(true);
                    else if (i == EnumsHS.CardSet.OG.getValue()) tglFilterSet[8].setChecked(true);
                    else if (i == EnumsHS.CardSet.KARA.getValue()) tglFilterSet[9].setChecked(true);
                    else if (i == EnumsHS.CardSet.MSG.getValue()) tglFilterSet[10].setChecked(true);
                    else if (i == EnumsHS.CardSet.JTU.getValue()) tglFilterSet[11].setChecked(true);
                }
                calculatePresetToggleState();
            }

            if (filter.race != null)
            {
                for (Integer i : filter.race)
                {

                    if (i == EnumsHS.Race.MURLOC.getValue()) tglFilterRace[0].setChecked(true);
                    else if (i == EnumsHS.Race.DEMON.getValue()) tglFilterRace[1].setChecked(true);
                    else if (i == EnumsHS.Race.MECHANICAL.getValue()) tglFilterRace[2].setChecked(true);
                    else if (i == EnumsHS.Race.BEAST.getValue()) tglFilterRace[3].setChecked(true);
                    else if (i == EnumsHS.Race.TOTEM.getValue()) tglFilterRace[4].setChecked(true);
                    else if (i == EnumsHS.Race.PIRATE.getValue()) tglFilterRace[5].setChecked(true);
                    else if (i == EnumsHS.Race.DRAGON.getValue()) tglFilterRace[6].setChecked(true);
                }
            }

            if (filter.mechanic != null)
            {
                for (Integer i : filter.mechanic)
                {
                    if (i == EnumsHS.Mechanic.ADJACENT_BUFF.getValue()) cbFilterMechanic[0].setChecked(true);
                    else if (i == EnumsHS.Mechanic.AURA.getValue()) cbFilterMechanic[1].setChecked(true);
                    else if (i == EnumsHS.Mechanic.BATTLECRY.getValue()) cbFilterMechanic[2].setChecked(true);
                    else if (i == EnumsHS.Mechanic.CHARGE.getValue()) cbFilterMechanic[3].setChecked(true);
                    else if (i == EnumsHS.Mechanic.CHOOSE_ONE.getValue()) cbFilterMechanic[4].setChecked(true);
                    else if (i == EnumsHS.Mechanic.COMBO.getValue()) cbFilterMechanic[5].setChecked(true);
                    else if (i == EnumsHS.Mechanic.DEATHRATTLE.getValue()) cbFilterMechanic[6].setChecked(true);
                    else if (i == EnumsHS.Mechanic.DIVINE_SHIELD.getValue()) cbFilterMechanic[7].setChecked(true);
                    else if (i == EnumsHS.Mechanic.ENRAGED.getValue()) cbFilterMechanic[8].setChecked(true);
                    else if (i == EnumsHS.Mechanic.FORGETFUL.getValue()) cbFilterMechanic[9].setChecked(true);
                    else if (i == EnumsHS.Mechanic.FREEZE.getValue()) cbFilterMechanic[10].setChecked(true);
                    else if (i == EnumsHS.Mechanic.INSPIRE.getValue()) cbFilterMechanic[11].setChecked(true);
                    else if (i == EnumsHS.Mechanic.POISONOUS.getValue()) cbFilterMechanic[12].setChecked(true);
                    else if (i == EnumsHS.Mechanic.SECRET.getValue()) cbFilterMechanic[13].setChecked(true);
                    else if (i == EnumsHS.Mechanic.SILENCE.getValue()) cbFilterMechanic[14].setChecked(true);
                    else if (i == EnumsHS.Mechanic.STEALTH.getValue()) cbFilterMechanic[15].setChecked(true);
                    else if (i == EnumsHS.Mechanic.TAUNT.getValue()) cbFilterMechanic[16].setChecked(true);
                    else if (i == EnumsHS.Mechanic.TOPDECK.getValue()) cbFilterMechanic[17].setChecked(true);
                    else if (i == EnumsHS.Mechanic.WINDFURY.getValue()) cbFilterMechanic[18].setChecked(true);
                }
            }
        }


    }

    private void calculatePresetToggleState()
    {
        if (tglFilterSet[0].isChecked() &&
                tglFilterSet[1].isChecked() &&
                !tglFilterSet[2].isChecked() &&
                !tglFilterSet[3].isChecked() &&
                !tglFilterSet[4].isChecked() &&
                tglFilterSet[5].isChecked() &&
                tglFilterSet[6].isChecked() &&
                tglFilterSet[7].isChecked() &&
                tglFilterSet[8].isChecked() &&
                tglFilterSet[9].isChecked() &&
                tglFilterSet[10].isChecked() &&
                tglFilterSet[11].isChecked())
        {
            tglFilterPreset_StandardSets.setChecked(true);
        }
        else
        {
            tglFilterPreset_StandardSets.setChecked(false);
        }

        if (!tglFilterSet[0].isChecked() &&
                !tglFilterSet[1].isChecked() &&
                tglFilterSet[2].isChecked() &&
                tglFilterSet[3].isChecked() &&
                tglFilterSet[4].isChecked() &&
                !tglFilterSet[5].isChecked() &&
                !tglFilterSet[6].isChecked() &&
                !tglFilterSet[7].isChecked() &&
                !tglFilterSet[8].isChecked() &&
                !tglFilterSet[9].isChecked() &&
                !tglFilterSet[10].isChecked() &&
                !tglFilterSet[11].isChecked())
        {
            tglFilterPreset_AllSets.setChecked(true);
        }
        else
        {
            tglFilterPreset_AllSets.setChecked(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card_filter, menu);

        // Change menu item icons to white.
        AppDesign.changeAllMenuItemColors(menu, Color.WHITE);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id) {
            case R.id.menu_card_filter_apply:
                filter.mana = getSelectedManaFilters();
                filter.attack = getSelectedAttackFilters();
                filter.health = getSelectedHealthFilters();
                filter.type = getSelectedTypeFilters();
                filter.rarity = getSelectedRarityFilters();
                filter.set = getSelectedSetFilters();
                filter.race = getSelectedRaceFilters();
                filter.mechanic = getSelectedMechanicFilters();

                Intent intent = new Intent();
                intent.putExtra("filter", filter);
                setResult(RESULT_OK,intent);

                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
        GET SELECTED FILTERS
     */

    private ArrayList<Integer> getSelectedManaFilters()
    {
        ArrayList<Integer> manaFilters = new ArrayList<>();
        for (int i = 0; i < tglFilterManaCost.length; i++)
        {
            if (tglFilterManaCost[i].isChecked()) manaFilters.add(i);
        }

        return manaFilters;
    }

    private ArrayList<Integer> getSelectedAttackFilters()
    {
        ArrayList<Integer> attackFilters = new ArrayList<>();
        for (int i = 0; i < tglFilterAttack.length; i++)
        {
            if (tglFilterAttack[i].isChecked()) attackFilters.add(i);
        }

        return attackFilters;
    }

    private ArrayList<Integer> getSelectedHealthFilters()
    {
        ArrayList<Integer> healthFilters = new ArrayList<>();
        for (int i = 0; i < tglFilterHealth.length; i++)
        {
            if (tglFilterHealth[i].isChecked()) healthFilters.add(i);
        }

        return healthFilters;
    }

    private ArrayList<Integer> getSelectedTypeFilters()
    {
        ArrayList<Integer> typeFilters = new ArrayList<>();
        if (tglFilterType[0].isChecked()) typeFilters.add(EnumsHS.CardType.MINION.getValue());
        if (tglFilterType[1].isChecked()) typeFilters.add(EnumsHS.CardType.SPELL.getValue());
        if (tglFilterType[2].isChecked()) typeFilters.add(EnumsHS.CardType.WEAPON.getValue());

        return typeFilters;
    }

    private ArrayList<Integer> getSelectedRarityFilters()
    {
        ArrayList<Integer> rarityFilters = new ArrayList<>();
        if (tglFilterRarity[0].isChecked()) rarityFilters.add(EnumsHS.Rarity.COMMON.getValue());
        if (tglFilterRarity[1].isChecked()) rarityFilters.add(EnumsHS.Rarity.RARE.getValue());
        if (tglFilterRarity[2].isChecked()) rarityFilters.add(EnumsHS.Rarity.EPIC.getValue());
        if (tglFilterRarity[3].isChecked()) rarityFilters.add(EnumsHS.Rarity.LEGENDARY.getValue());

        return rarityFilters;
    }

    private ArrayList<Integer> getSelectedSetFilters()
    {
        ArrayList<Integer> setFilters = new ArrayList<>();
        if (tglFilterSet[0].isChecked()) setFilters.add(EnumsHS.CardSet.CORE.getValue());
        if (tglFilterSet[1].isChecked()) setFilters.add(EnumsHS.CardSet.EXPERT1.getValue());
        if (tglFilterSet[2].isChecked())
        {
            setFilters.add(EnumsHS.CardSet.REWARD.getValue());
            setFilters.add(EnumsHS.CardSet.PROMO.getValue());
        }
        if (tglFilterSet[3].isChecked()) setFilters.add(EnumsHS.CardSet.NAXX.getValue());
        if (tglFilterSet[4].isChecked()) setFilters.add(EnumsHS.CardSet.GVG.getValue());
        if (tglFilterSet[5].isChecked()) setFilters.add(EnumsHS.CardSet.BRM.getValue());
        if (tglFilterSet[6].isChecked()) setFilters.add(EnumsHS.CardSet.TGT.getValue());
        if (tglFilterSet[7].isChecked()) setFilters.add(EnumsHS.CardSet.LOE.getValue());
        if (tglFilterSet[8].isChecked()) setFilters.add(EnumsHS.CardSet.OG.getValue());
        if (tglFilterSet[9].isChecked()) setFilters.add(EnumsHS.CardSet.KARA.getValue());
        if (tglFilterSet[10].isChecked()) setFilters.add(EnumsHS.CardSet.MSG.getValue());
        if (tglFilterSet[11].isChecked()) setFilters.add(EnumsHS.CardSet.JTU.getValue());

        return setFilters;
    }

    private ArrayList<Integer> getSelectedRaceFilters()
    {
        ArrayList<Integer> raceFilters = new ArrayList<>();
        if (tglFilterRace[0].isChecked()) raceFilters.add(EnumsHS.Race.MURLOC.getValue());
        if (tglFilterRace[1].isChecked()) raceFilters.add(EnumsHS.Race.DEMON.getValue());
        if (tglFilterRace[2].isChecked()) raceFilters.add(EnumsHS.Race.MECHANICAL.getValue());
        if (tglFilterRace[3].isChecked()) raceFilters.add(EnumsHS.Race.BEAST.getValue());
        if (tglFilterRace[4].isChecked()) raceFilters.add(EnumsHS.Race.TOTEM.getValue());
        if (tglFilterRace[5].isChecked()) raceFilters.add(EnumsHS.Race.PIRATE.getValue());
        if (tglFilterRace[6].isChecked()) raceFilters.add(EnumsHS.Race.DRAGON.getValue());

        return raceFilters;
    }

    private ArrayList<Integer> getSelectedMechanicFilters()
    {
        ArrayList<Integer> mechanicFilters = new ArrayList<>();
        if (cbFilterMechanic[0].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.ADJACENT_BUFF.getValue());
        if (cbFilterMechanic[1].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.AURA.getValue());
        if (cbFilterMechanic[2].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.BATTLECRY.getValue());
        if (cbFilterMechanic[3].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.CHARGE.getValue());
        if (cbFilterMechanic[4].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.CHOOSE_ONE.getValue());
        if (cbFilterMechanic[5].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.COMBO.getValue());
        if (cbFilterMechanic[6].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.DEATHRATTLE.getValue());
        if (cbFilterMechanic[7].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.DIVINE_SHIELD.getValue());
        if (cbFilterMechanic[8].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.ENRAGED.getValue());
        if (cbFilterMechanic[9].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.FORGETFUL.getValue());
        if (cbFilterMechanic[10].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.FREEZE.getValue());
        if (cbFilterMechanic[11].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.INSPIRE.getValue());
        if (cbFilterMechanic[12].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.POISONOUS.getValue());
        if (cbFilterMechanic[13].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.SECRET.getValue());
        if (cbFilterMechanic[14].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.SILENCE.getValue());
        if (cbFilterMechanic[15].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.STEALTH.getValue());
        if (cbFilterMechanic[16].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.TAUNT.getValue());
        if (cbFilterMechanic[17].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.TOPDECK.getValue());
        if (cbFilterMechanic[18].isChecked()) mechanicFilters.add(EnumsHS.Mechanic.WINDFURY.getValue());

        return mechanicFilters;
    }
}
