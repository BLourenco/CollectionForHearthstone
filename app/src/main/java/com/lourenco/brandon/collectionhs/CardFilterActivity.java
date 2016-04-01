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

/**
 * Created by Brandon on 2016-03-30.
 */
public class CardFilterActivity extends AppCompatActivity{

    ToggleButton[] tglFilterManaCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_filter);

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
                intent.putExtra("mana", getSelectedManaFilters());
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
            if (tglFilterManaCost[i].isSelected()) manaFilters.add(i);
            else
                manaFilters.add(null);
        }

        return manaFilters;
    }
}
