package com.lourenco.brandon.collectionhs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
import com.lourenco.brandon.collectionhs.util.StringUtil;
import com.lourenco.brandon.collectionhs.util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import at.markushi.ui.RevealColorView;

public class CardsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private FloatingActionButton fab;

    private RevealColorView revealColorView;
    private View selectedView;

    static List<Card> cards;

    private EnumsHS.CardClass prevSelectedClass = EnumsHS.CardClass.DRUID;

    @NonNull
    public static CardsActivity get(@NonNull Context anyContext) {
        return (CardsActivity) anyContext.getApplicationContext();
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
            getSupportActionBar().setTitle("Cards");

        // Adjust toolbar height for API < 21
        if (!Utils.hasLollipop()) {
            final int DEFAULT_STATUSBAR_HEIGHT = 24;
            final int DEFAULT_TOOLBAR_HEIGHT = 56;
            final int DEFAULT_TEXT_OR_ICON_TAB_HEIGHT = 48;
            final int DEFAULT_TEXT_AND_ICON_TAB_HEIGHT = 72;

            // Appbar Height
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
            CoordinatorLayout.LayoutParams paramsAppbar = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
            paramsAppbar.height = Utils.dpToPx(this, DEFAULT_TOOLBAR_HEIGHT + DEFAULT_TEXT_OR_ICON_TAB_HEIGHT);
            appBarLayout.setLayoutParams(paramsAppbar);

            // Toolbar Height & Top Margin
            FrameLayout.LayoutParams paramsToolbar = (FrameLayout.LayoutParams) toolbar.getLayoutParams();
            paramsToolbar.height = Utils.dpToPx(this, DEFAULT_TOOLBAR_HEIGHT);
            paramsToolbar.topMargin = 0;
            toolbar.setLayoutParams(paramsToolbar);

            // Frame (BG Color) Height
            FrameLayout toolbarFrame = (FrameLayout) findViewById(R.id.toolbarFrame);
            AppBarLayout.LayoutParams paramsFrame = (AppBarLayout.LayoutParams) toolbarFrame.getLayoutParams();
            paramsFrame.height = Utils.dpToPx(this, DEFAULT_TOOLBAR_HEIGHT + DEFAULT_TEXT_OR_ICON_TAB_HEIGHT);
            toolbarFrame.setLayoutParams(paramsFrame);


        }

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabsClass);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                changeTheme(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });






        /*spnClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                EnumsHS.CardClass selectedClass = EnumsHS.CardClass.values()[position];
                // When the given dropdown item is selected, show its contents in the
                // container view.
                //TODO Filter current list
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, PlaceholderFragment.newInstance(getApplicationContext(), (ArrayList<Card>) getClassCards(EnumsHS.CardClass.values()[position])))
                        .commit();

                AppDesign.changeThemeColor(
                        getApplicationContext(),
                        revealColorView,
                        AppDesign.getLocationInView(spnClass, toolbar),
                        ResourcesHS.getClassColors(getApplicationContext(), selectedClass)[0],
                        240);

                AppDesign.changeFabColor(
                        getApplicationContext(),
                        fab,
                        ResourcesHS.getClassColors(getApplicationContext(), selectedClass)[2],

                        240);

                prevSelectedClass = EnumsHS.CardClass.values()[position];
                fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });*/

        revealColorView = (RevealColorView) findViewById(R.id.toolbarReveal);
        //revealColorViewFab = (RevealColorView) findViewById(R.id.revealFab);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        changeTheme(0); //TODO change to favourite class' theme and tab
    }

    private void changeTheme(int position)
    {
        EnumsHS.CardClass selectedClass = EnumsHS.CardClass.values()[position];

        AppDesign.changeThemeColor(
                getApplicationContext(),
                revealColorView,
                AppDesign.getLocationInView(toolbar, toolbar),
                ResourcesHS.getClassColors(getApplicationContext(), selectedClass)[0],
                240);

        tabLayout.setSelectedTabIndicatorColor(ResourcesHS.getClassColors(getApplicationContext(), selectedClass)[2]);

        AppDesign.changeFabColor(
                getApplicationContext(),
                fab,
                ResourcesHS.getClassColors(getApplicationContext(), selectedClass)[2],

                240);

        prevSelectedClass = EnumsHS.CardClass.values()[position];
        fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
    }

    public static void initCardObjects(Resources r)
    {
        JSONResourceReader reader = new JSONResourceReader(r, R.raw.cards);
        JSONResourceReader readerUnreleased = new JSONResourceReader(r, R.raw.cards_unreleased);

        Gson gson = new Gson();
        cards = gson.fromJson(reader.getJSONString(), new TypeToken<List<Card>>(){}.getType());
        List<Card> unreleased = gson.fromJson(readerUnreleased.getJSONString(), new TypeToken<List<Card>>() {}.getType());
        cards.addAll(unreleased);
        Collections.sort(cards, new CardComparator());
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

        for (int i = 0; i < menu.size(); i++)
        {
            Drawable drawable = menu.getItem(i).getIcon();
            drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawable, Color.WHITE);

            DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN);
        }
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
            case R.id.nav_settings:
                Toast.makeText(this, "Overflow > Settings selected.", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
        NAVIGATION DRAWER
     */

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_cards:
                break;
            case R.id.nav_card_backs:
                break;
            case R.id.nav_heroes:
                break;
            case R.id.nav_decks:
                break;
            case R.id.nav_rate:
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_about:
                break;
            default:
                return false;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
            View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);
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

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(getApplicationContext(), (ArrayList<Card>) getClassCards(EnumsHS.CardClass.getClassAtOrdinal(position)));
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 10; //TODO Don't hardcode number of tabs
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return ResourcesHS.getClassString(getApplicationContext(), EnumsHS.CardClass.getClassAtOrdinal(position));
        }
    }
}

