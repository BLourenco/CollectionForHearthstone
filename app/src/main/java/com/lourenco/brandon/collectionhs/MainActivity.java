package com.lourenco.brandon.collectionhs;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lourenco.brandon.collectionhs.json.JSONResourceReader;
import com.lourenco.brandon.collectionhs.models.Card;
import com.lourenco.brandon.collectionhs.util.CardComparator;
import com.lourenco.brandon.collectionhs.util.Enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter mSpinnerAdapter;
    private Toolbar toolbar;

    static List<Card> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initCardObjects(getResources());
    }

    public void initViews()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        Spinner spnCollection = (Spinner) findViewById(R.id.spnCollection);
        spnCollection.setAdapter(new MyAdapter(
                toolbar.getContext(),
                getResources().getStringArray(R.array.collections)
        ));

        spnCollection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // When the given dropdown item is selected, show its contents in the
                // container view.
                //TODO change collections
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner spnClass = (Spinner) findViewById(R.id.spnClass);
        spnClass.setAdapter(new MyAdapter(
                toolbar.getContext(),
                getResources().getStringArray(R.array.classes)
        ));

        spnClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // When the given dropdown item is selected, show its contents in the
                // container view.
                //TODO Filter current list
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, PlaceholderFragment.newInstance(getApplicationContext(), (ArrayList<Card>) getClassCards(Enums.CardClass.values()[position])))
                        .commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public static void initCardObjects(Resources r)
    {
        JSONResourceReader reader = new JSONResourceReader(r, R.raw.cards);

        Gson gson = new Gson();
        cards = gson.fromJson(reader.getJSONString(), new TypeToken<List<Card>>(){}.getType());
        Collections.sort(cards, new CardComparator());
    }

    public void changeThemeColor()
    {
        TypedValue a = new TypedValue();
        int currentPrimaryColor = 0;
        int currentStatusColor = 0;
        int currentAccentColor = 0;
        getTheme().resolveAttribute(android.R.attr.windowBackground, a, true);
        if (a.type >= TypedValue.TYPE_FIRST_COLOR_INT && a.type <= TypedValue.TYPE_LAST_COLOR_INT) {
            // windowBackground is a color
            currentPrimaryColor = a.data;
        } else {
            // windowBackground is not a color, probably a drawable
            Drawable d = getResources().getDrawable(a.resourceId);
        }


        Integer colorFrom = getResources().getColor(R.color.classMagePrimary);;
        Integer colorTo = getResources().getColor(R.color.classDruidPrimary);
        //Integer colorStatusFrom = Color.parseColor(ThemeColor.getPrevStatusColor());
        //Integer colorStatusTo = Color.parseColor(ThemeColor.getStatusColor());
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        //ValueAnimator colorStatusAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorStatusFrom, colorStatusTo);

        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                toolbar.setBackgroundColor((Integer) animator.getAnimatedValue());
            }
        });

/*        colorStatusAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                if (currentApiVersion >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor((Integer) animator.getAnimatedValue());
                }
                if (currentApiVersion == Build.VERSION_CODES.KITKAT) {
                    //TODO tintManager.setStatusBarTintColor((Integer) animator.getAnimatedValue());
                }
            }
        });*/

        colorAnimation.setDuration(1300);
        colorAnimation.setStartDelay(0);
        colorAnimation.start();
        //colorStatusAnimation.setDuration(1300);
        //colorStatusAnimation.setStartDelay(0);
        //colorStatusAnimation.start();
    }

    public static List<Card> getClassCards(Enums.CardClass playerClass)
    {
        List<Card> classCards = new ArrayList<>();

        for (Card c : cards) {
            if(c.getCollectible() == null || (!c.getCollectible() && !c.getType().equals("HERO_POWER") /*|| c.getType().equals("HERO")*/)) continue; // TODO Add toggle to show/hide non-collectible cards
            if (c.getPlayerClass() == null) // Neutrals
            {
                if (playerClass.name().equals("NEUTRAL"))
                {
                    classCards.add(c);
                }
            }
            else // Classes
            {
                if (c.getPlayerClass().equals(playerClass.name().toUpperCase())) {
                    classCards.add(c);
                }
            }
        }
        return classCards;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //TODO Implement settings
            changeThemeColor();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        static Context context;

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_CLASS_CARDS = "class_cards";

        public PlaceholderFragment(){};

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(Context c, ArrayList<Card> classCards) {
            context = c;
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putParcelableArrayList(ARG_CLASS_CARDS, classCards);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ArrayList<Card> classCards = getArguments().getParcelableArrayList(ARG_CLASS_CARDS);

            RecyclerView mRecyclerView;
            RecyclerView.Adapter mAdapter;
            RecyclerView.LayoutManager mLayoutManager;

            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
            mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
            mRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(context);
            mRecyclerView.setLayoutManager(mLayoutManager);

            // specify an adapter (see also next example)
            mAdapter = new CardRecyclerAdapter(classCards, context);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());

            return rootView;
        }
    }

    private static class MyAdapter extends ArrayAdapter<String> implements ThemedSpinnerAdapter {
        private final ThemedSpinnerAdapter.Helper mDropDownHelper;

        public MyAdapter(Context context, String[] objects) {
            super(context, android.R.layout.simple_list_item_1, objects);
            mDropDownHelper = new ThemedSpinnerAdapter.Helper(context);
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                // Inflate the drop down using the helper's LayoutInflater
                LayoutInflater inflater = mDropDownHelper.getDropDownViewInflater();
                view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            } else {
                view = convertView;
            }

            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getItem(position));

            return view;
        }

        @Override
        public Resources.Theme getDropDownViewTheme() {
            return mDropDownHelper.getDropDownViewTheme();
        }

        @Override
        public void setDropDownViewTheme(Resources.Theme theme) {
            mDropDownHelper.setDropDownViewTheme(theme);
        }
    }
}

