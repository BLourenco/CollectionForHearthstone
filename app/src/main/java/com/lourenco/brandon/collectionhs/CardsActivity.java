package com.lourenco.brandon.collectionhs;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

import com.lourenco.brandon.collectionhs.db.CardQueryBuilder;
import com.lourenco.brandon.collectionhs.db.CollectionDbHelper;
import com.lourenco.brandon.collectionhs.design.DividerItemDecoration;
import com.lourenco.brandon.collectionhs.hearthstone.CardRecyclerAdapter;
import com.lourenco.brandon.collectionhs.hearthstone.ResourcesHS;
import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;
import com.lourenco.brandon.collectionhs.design.AppDesign;
import com.lourenco.brandon.collectionhs.hearthstone.model.Card;
import com.lourenco.brandon.collectionhs.util.AndroidUtils;

import java.util.ArrayList;
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
    private static SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private FloatingActionButton fab;

    private RevealColorView revealColorView;

    private static List<List<Card>> cards;

    static SQLiteDatabase db;
    static CardFilter filter;

    private final int REQUEST_CODE_FILTER = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new CollectionDbHelper(this).getWritableDatabase(); // TODO Put in AsyncTask

        initCardLists();
        initViews();
    }

    public void initViews()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Cards");

        AppDesign.setOverflowButtonColor(toolbar, Color.WHITE);

        // Adjust toolbar height for API < 21
        if (!AndroidUtils.hasLollipop()) {
            final int DEFAULT_STATUSBAR_HEIGHT = 24;
            final int DEFAULT_TOOLBAR_HEIGHT = 56;
            final int DEFAULT_TEXT_OR_ICON_TAB_HEIGHT = 48;
            final int DEFAULT_TEXT_AND_ICON_TAB_HEIGHT = 72;

            // Appbar Height
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
            CoordinatorLayout.LayoutParams paramsAppbar = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
            paramsAppbar.height = AndroidUtils.dpToPx(this, DEFAULT_TOOLBAR_HEIGHT + DEFAULT_TEXT_OR_ICON_TAB_HEIGHT);
            appBarLayout.setLayoutParams(paramsAppbar);

            // Toolbar Height & Top Margin
            FrameLayout.LayoutParams paramsToolbar = (FrameLayout.LayoutParams) toolbar.getLayoutParams();
            paramsToolbar.height = AndroidUtils.dpToPx(this, DEFAULT_TOOLBAR_HEIGHT);
            paramsToolbar.topMargin = 0;
            toolbar.setLayoutParams(paramsToolbar);

            // Frame (BG Color) Height
            FrameLayout toolbarFrame = (FrameLayout) findViewById(R.id.toolbarFrame);
            AppBarLayout.LayoutParams paramsFrame = (AppBarLayout.LayoutParams) toolbarFrame.getLayoutParams();
            paramsFrame.height = AndroidUtils.dpToPx(this, DEFAULT_TOOLBAR_HEIGHT + DEFAULT_TEXT_OR_ICON_TAB_HEIGHT);
            toolbarFrame.setLayoutParams(paramsFrame);


        }

        revealColorView = (RevealColorView) findViewById(R.id.toolbarReveal);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Properly implement filter
                startFilterActivity();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        //If no cards exist, display a single Fragment displaying "No Results Found."
        if (!cards.isEmpty()) {
            // Create the adapter that will return a fragment for each of the classes
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
        }

        // Changing the theme at this point crashes the app since the drawing phase has not been complete and
        // the width and height have not been measured, causing a zero divided by zero calculation. The below
        // is a solution found on StackOverflow: https://stackoverflow.com/a/24035591
        revealColorView.post(new Runnable() {
            @Override
            public void run() {
                changeTheme(0); //height is ready
            }
        });
    }

    public void initCardLists()
    {
        cards = new ArrayList<List<Card>>(); //TODO: Don't hardcode numbers

        for (int i = 0; i < 10; i++)
        {
            CardQueryBuilder cqb = new CardQueryBuilder();

            if (filter != null) {
                if (!filter.mana.isEmpty())
                    cqb.filterByMana(filter.mana.toArray(new Integer[filter.mana.size()]));
                if (!filter.attack.isEmpty())
                    cqb.filterByAttack(filter.attack.toArray(new Integer[filter.attack.size()]));
                if (!filter.health.isEmpty())
                    cqb.filterByHealth(filter.health.toArray(new Integer[filter.health.size()]));

                if (!filter.type.isEmpty())
                    cqb.filterByType(filter.type.toArray(new Integer[filter.type.size()]));
                if (!filter.set.isEmpty())
                    cqb.filterBySet(filter.set.toArray(new Integer[filter.set.size()]));
                if (!filter.race.isEmpty())
                    cqb.filterByRace(filter.race.toArray(new Integer[filter.race.size()]));
                if (!filter.rarity.isEmpty())
                    cqb.filterByRarity(filter.rarity.toArray(new Integer[filter.rarity.size()]));
                if (!filter.mechanic.isEmpty())
                    cqb.filterByMechanic(db, filter.mechanic.toArray(new Integer[filter.mechanic.size()]));
            }
            int classId = EnumsHS.CardClass.getClassAtOrdinal(i).getValue();
            String rawQuery = cqb.filterByClass(classId).build();
            Cursor c = db.rawQuery(rawQuery, null);

            if (c.getCount() == 0) continue;
            List<Card> classCards = new ArrayList<>();

            for (int j = 0; j < c.getCount(); j++)
            {
                Card card = new Card(c, j);
                classCards.add(card);
            }
            cards.add(classCards);
        }
    }

    private void startFilterActivity()
    {
        Intent intent = new Intent(this, CardFilterActivity.class);
        intent.putExtra("filter", filter);
        startActivityForResult(intent, REQUEST_CODE_FILTER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_CODE_FILTER) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Bundle extras = intent.getExtras();
                if (extras != null)
                {
                    filter = intent.getParcelableExtra("filter");

                    this.recreate();
                }
            }
        }
    }

    private void changeTheme(int position)
    {
        EnumsHS.CardClass selectedClass = !cards.isEmpty() ?
                EnumsHS.CardClass.getEnumByValue(cards.get(position).get(0).getPlayerClassId()) :
                EnumsHS.CardClass.NEUTRAL;

        if (tabLayout != null) {
            AppDesign.changeThemeColor(
                    getApplicationContext(),
                    revealColorView,
                    AppDesign.getLocationInView(toolbar, toolbar),
                    ResourcesHS.getClassColors(getApplicationContext(), selectedClass)[0],
                    240);

            tabLayout.setSelectedTabIndicatorColor(ResourcesHS.getClassColors(getApplicationContext(), selectedClass)[2]);
        }

        if (fab != null) {
            AppDesign.changeFabColor(
                    getApplicationContext(),
                    fab,
                    ResourcesHS.getClassColors(getApplicationContext(), selectedClass)[2],

                    240);

            fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Change menu item icons to white.
        AppDesign.changeAllMenuItemColors(menu, Color.WHITE);

        return true;
    }

    public void startSettingsActivity()
    {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
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
                startSettingsActivity();
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
            case R.id.nav_feedback:
                break;
            case R.id.nav_settings:
                startSettingsActivity();
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
        private static final String ARG_CLASS_ORDINAL = "class_ordinal";

        public PlaceholderFragment(){}


        RecyclerView.Adapter mAdapter;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(Context c, int classOrdinal) {
            context = c;
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_CLASS_ORDINAL, classOrdinal);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);
            final int classOrdinal = getArguments().getInt(ARG_CLASS_ORDINAL);

            // In the case that only 1 tab should be displayed, prevent the second page from pre-loading.
            // (The current page and the adjacent pages always try to be loaded)
            if (classOrdinal >= mSectionsPagerAdapter.getCount()) return rootView;

            RecyclerView mRecyclerView;
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
                    AppDesign.setEdgeGlowColor(recyclerView, ResourcesHS.getClassColors(context, EnumsHS.CardClass.getClassAtOrdinal(classOrdinal))[0]);
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    FloatingActionButton floatingActionButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);

                    if (isVisible && scrollDist > MIN_TRIGGER_DISTANCE) {
                        floatingActionButton.animate().translationY(floatingActionButton.getHeight() + 56).setInterpolator(new AccelerateInterpolator(2)).start();
                        //AndroidUtils.reveal(floatingActionButton, floatingActionButton.getWidth() / 2, floatingActionButton.getHeight() / 2);
                        scrollDist = 0;
                        isVisible = false;
                    } else if (!isVisible && scrollDist < -MIN_TRIGGER_DISTANCE) {
                        floatingActionButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
                        //AndroidUtils.unReveal(floatingActionButton, floatingActionButton.getWidth() / 2, floatingActionButton.getHeight() / 2);
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



            mAdapter = new CardRecyclerAdapter(context, cards.get(classOrdinal));
            //mAdapter = new CardRecyclerAdapter(context, db.rawQuery(rawQuery + manaFilterClause + orderByClause, null));
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
            return PlaceholderFragment.newInstance(getApplicationContext(), position);
        }

        @Override
        public int getCount() {
            return cards.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            int classId = cards.get(position).get(0).getPlayerClassId();
            return EnumsHS.CardClass.getEnumByValue(classId).name();
        }
    }
}

