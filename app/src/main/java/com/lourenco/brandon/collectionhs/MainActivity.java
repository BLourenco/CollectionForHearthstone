package com.lourenco.brandon.collectionhs;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
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
import com.lourenco.brandon.collectionhs.util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import at.markushi.ui.RevealColorView;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter mSpinnerAdapter;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    private RevealColorView revealColorView;
    //private RevealColorView revealColorViewFab;
    private View selectedView;

    static List<Card> cards;

    private Enums.CardClass prevClassTheme = Enums.CardClass.DRUID;

    @NonNull
    public static MainActivity get(@NonNull Context anyContext) {
        return (MainActivity) anyContext.getApplicationContext();
    }

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

        final Spinner spnCollection = (Spinner) findViewById(R.id.spnCollection);
        final Spinner spnClass = (Spinner) findViewById(R.id.spnClass);

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
                if (position == 0)
                {
                    spnClass.setEnabled(true);
                }
                else
                {
                    spnClass.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

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

                changeThemeColor(Enums.CardClass.values()[position]);
                prevClassTheme = Enums.CardClass.values()[position];
                fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        revealColorView = (RevealColorView) findViewById(R.id.reveal);
        //revealColorViewFab = (RevealColorView) findViewById(R.id.revealFab);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    public static void initCardObjects(Resources r)
    {
        JSONResourceReader reader = new JSONResourceReader(r, R.raw.cards);

        Gson gson = new Gson();
        cards = gson.fromJson(reader.getJSONString(), new TypeToken<List<Card>>(){}.getType());
        Collections.sort(cards, new CardComparator());
    }

    private Point getLocationInView(View src, View target) {
        final int[] l0 = new int[2];
        src.getLocationOnScreen(l0);

        final int[] l1 = new int[2];
        target.getLocationOnScreen(l1);

        l1[0] = l1[0] - l0[0] + target.getWidth() / 2;
        l1[1] = l1[1] - l0[1] + target.getHeight() / 2;

        return new Point(l1[0], l1[1]);
    }

    private int[] getColors(Enums.CardClass selectedClass) {

        int[] colors = {0,0,0}; // Primary, Dark, Accent

        switch (selectedClass)
        {
            case DRUID:
                colors[0] = getResources().getColor(R.color.classDruidPrimary);
                colors[1] = getResources().getColor(R.color.classDruidPrimaryDark);
                colors[2] = getResources().getColor(R.color.classDruidAccent);
                break;
            case HUNTER:
                colors[0] = getResources().getColor(R.color.classHunterPrimary);
                colors[1] = getResources().getColor(R.color.classHunterPrimaryDark);
                colors[2] = getResources().getColor(R.color.classHunterAccent);
                break;
            case MAGE:
                colors[0] = getResources().getColor(R.color.classMagePrimary);
                colors[1] = getResources().getColor(R.color.classMagePrimaryDark);
                colors[2] = getResources().getColor(R.color.classMageAccent);
                break;
            case PALADIN:
                colors[0] = getResources().getColor(R.color.classPaladinPrimary);
                colors[1] = getResources().getColor(R.color.classPaladinPrimaryDark);
                colors[2] = getResources().getColor(R.color.classPaladinAccent);
                break;
            case PRIEST:
                colors[0] = getResources().getColor(R.color.classPriestPrimary);
                colors[1] = getResources().getColor(R.color.classPriestPrimaryDark);
                colors[2] = getResources().getColor(R.color.classPriestAccent);
                break;
            case ROGUE:
                colors[0] = getResources().getColor(R.color.classRoguePrimary);
                colors[1] = getResources().getColor(R.color.classRoguePrimaryDark);
                colors[2] = getResources().getColor(R.color.classRogueAccent);
                break;
            case SHAMAN:
                colors[0] = getResources().getColor(R.color.classShamanPrimary);
                colors[1] = getResources().getColor(R.color.classShamanPrimaryDark);
                colors[2] = getResources().getColor(R.color.classShamanAccent);
                break;
            case WARLOCK:
                colors[0] = getResources().getColor(R.color.classWarlockPrimary);
                colors[1] = getResources().getColor(R.color.classWarlockPrimaryDark);
                colors[2] = getResources().getColor(R.color.classWarlockAccent);
                break;
            case WARRIOR:
                colors[0] = getResources().getColor(R.color.classWarriorPrimary);
                colors[1] = getResources().getColor(R.color.classWarriorPrimaryDark);
                colors[2] = getResources().getColor(R.color.classWarriorAccent);
                break;
            case NEUTRAL:
                colors[0] = getResources().getColor(R.color.classNeutralPrimary);
                colors[1] = getResources().getColor(R.color.classNeutralPrimaryDark);
                colors[2] = getResources().getColor(R.color.classNeutralAccent);
                break;
            default:
                colors[0] = getResources().getColor(R.color.colorPrimary);
                colors[1] = getResources().getColor(R.color.colorPrimaryDark);
                colors[2] = getResources().getColor(R.color.colorAccent);
        }

        return colors;
    }

    public void changeThemeColor(Enums.CardClass selectedClass)
    {
        int transitionDuration_ms = 240;

        /**
         * Status Bar + Toolbar
         */
        final int[] colors = getColors(selectedClass);
        final Point p1 = getLocationInView(revealColorView, revealColorView);
        revealColorView.reveal(p1.x, p1.y, colors[0], revealColorView.getHeight() / 2, transitionDuration_ms, null);

        /**
         * Fab
         */

        int prevColor = getColors(prevClassTheme)[2];

        Integer colorFrom = prevColor;
        Integer colorTo = colors[2];
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);

        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                fab.setBackgroundTintList(ColorStateList.valueOf((Integer) animator.getAnimatedValue()));
            }
        });

        colorAnimation.setDuration(transitionDuration_ms);
        colorAnimation.setStartDelay(0);
        colorAnimation.start();
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

            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                int scrollDist = 0;
                boolean isVisible = true;
                final int MIN_TRIGGER_DISTANCE = 25;

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    FloatingActionButton floatingActionButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);

                    if (isVisible && scrollDist > MIN_TRIGGER_DISTANCE) {
                        floatingActionButton.animate().translationY(floatingActionButton.getHeight() + 56).setInterpolator(new AccelerateInterpolator(2)).start();
                        //Utils.reveal(floatingActionButton, floatingActionButton.getWidth() / 2, floatingActionButton.getHeight() / 2);
                        scrollDist = 0;
                        isVisible = false;
                    }
                    else if (!isVisible && scrollDist < -MIN_TRIGGER_DISTANCE) {
                        floatingActionButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
                        //Utils.unReveal(floatingActionButton, floatingActionButton.getWidth() / 2, floatingActionButton.getHeight() / 2);
                        scrollDist = 0;
                        isVisible = true;
                    }
                    if ((isVisible && dy > 0) || (!isVisible && dy < 0)) {
                        scrollDist += dy;
                    }

                }
            });

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

