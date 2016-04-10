package com.lourenco.brandon.collectionhs;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ToggleButton;

import com.lourenco.brandon.collectionhs.design.AppDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2016-03-30.
 */
public class CardFilterActivity extends AppCompatActivity{

    ToggleButton[] tglFilterManaCost;
    ToggleButton[] tglFilterAttack;
    ToggleButton[] tglFilterHealth;

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
                (ToggleButton)findViewById(R.id.tglFilterMana7plus),
        };

        tglFilterAttack = new ToggleButton[] {
                (ToggleButton)findViewById(R.id.tglFilterAttack0),
                (ToggleButton)findViewById(R.id.tglFilterAttack1),
                (ToggleButton)findViewById(R.id.tglFilterAttack2),
                (ToggleButton)findViewById(R.id.tglFilterAttack3),
                (ToggleButton)findViewById(R.id.tglFilterAttack4),
                (ToggleButton)findViewById(R.id.tglFilterAttack5),
                (ToggleButton)findViewById(R.id.tglFilterAttack6),
                (ToggleButton)findViewById(R.id.tglFilterAttack7plus),
        };

        tglFilterHealth = new ToggleButton[] {
                (ToggleButton)findViewById(R.id.tglFilterHealth0),
                (ToggleButton)findViewById(R.id.tglFilterHealth1),
                (ToggleButton)findViewById(R.id.tglFilterHealth2),
                (ToggleButton)findViewById(R.id.tglFilterHealth3),
                (ToggleButton)findViewById(R.id.tglFilterHealth4),
                (ToggleButton)findViewById(R.id.tglFilterHealth5),
                (ToggleButton)findViewById(R.id.tglFilterHealth6),
                (ToggleButton)findViewById(R.id.tglFilterHealth7plus),
        };

        Bundle b = getIntent().getExtras();

        ArrayList<Integer> m = b.getIntegerArrayList("mana");
        if (m != null)
        for (int i : m)
        {
            tglFilterManaCost[i].setChecked(true);
        }

        ArrayList<Integer> a = b.getIntegerArrayList("attack");
        if (a != null)
        for (int i : a)
        {
            tglFilterAttack[i].setChecked(true);
        }

        ArrayList<Integer> h = b.getIntegerArrayList("health");
        if (h != null)
        for (int i : h)
        {
            tglFilterHealth[i].setChecked(true);
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

        //TODO Implement settings
        //noinspection SimplifiableIfStatement
        switch(id) {
            case R.id.menu_card_filter_apply:
                //create a new intent...
                Intent intent = new Intent();
                intent.putIntegerArrayListExtra("mana", getSelectedManaFilters());
                intent.putIntegerArrayListExtra("attack", getSelectedAttackFilters());
                intent.putIntegerArrayListExtra("health", getSelectedHealthFilters());
                setResult(RESULT_OK,intent);
//close this Activity...
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

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
}
