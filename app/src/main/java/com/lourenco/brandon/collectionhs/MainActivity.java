package com.lourenco.brandon.collectionhs;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.support.v7.widget.Toolbar;
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
import com.lourenco.brandon.collectionhs.design.DividerItemDecoration;
import com.lourenco.brandon.collectionhs.hearthstone.CardRecyclerAdapter;
import com.lourenco.brandon.collectionhs.hearthstone.ResourcesHS;
import com.lourenco.brandon.collectionhs.json.JSONResourceReader;
import com.lourenco.brandon.collectionhs.hearthstone.model.Card;
import com.lourenco.brandon.collectionhs.hearthstone.CardComparator;
import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;
import com.lourenco.brandon.collectionhs.design.AppDesign;

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

    private EnumsHS.CardClass prevClassTheme = EnumsHS.CardClass.DRUID;

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

        final Spinner spnClass = (Spinner) findViewById(R.id.spnClass);

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
                        .replace(R.id.container, PlaceholderFragment.newInstance(getApplicationContext(), (ArrayList<Card>) getClassCards(EnumsHS.CardClass.values()[position])))
                        .commit();

                changeThemeColor(EnumsHS.CardClass.values()[position]);
                prevClassTheme = EnumsHS.CardClass.values()[position];
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



    public void changeThemeColor(EnumsHS.CardClass selectedClass)
    {
        int transitionDuration_ms = 240;

        /**
         * Status Bar + Toolbar
         */
        final int[] colors = ResourcesHS.getClassColors(this, selectedClass);
        final Point p1 = getLocationInView(revealColorView, revealColorView);
        revealColorView.reveal(p1.x, p1.y, colors[0], revealColorView.getHeight() / 2, transitionDuration_ms, null);

        /**
         * Fab
         */

        int prevColor = ResourcesHS.getClassColors(this, prevClassTheme)[2];

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

    public static List<Card> getClassCards(EnumsHS.CardClass playerClass)
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
            final ArrayList<Card> classCards = getArguments().getParcelableArrayList(ARG_CLASS_CARDS);

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
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    AppDesign.setEdgeGlowColor(recyclerView, ResourcesHS.getClassColors(context, classCards.get(0).getPlayerClassEnum())[0]);
                }

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

