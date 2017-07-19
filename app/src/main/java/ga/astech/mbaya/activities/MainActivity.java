package ga.astech.mbaya.activities;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;

import ga.astech.mbaya.R;
import ga.astech.mbaya.adapter.MyAdapter;
import ga.astech.mbaya.fragments.DetailsItem;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DetailsItem> details;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*setTitle(null);*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_home);
        toolbar.setLogoDescription(getResources().getString(R.string.logo_desc));

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // ReclyclerView declaration
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        final String[] titl = { "Gingerbread", "Honeycomb",
                "Ice Cream Sandwitch", "JellyBean", "KitKat", "LollyPop"};
        final String[] cost = { "15 000 FCFA", "125 000 FCFA",
                "43 200 FCFA", "315 250 FCFA", "25 000 FCFA", "5 500 FCFA"};
        final String[] descrip = { "l’application que le système doit connaitre pour pouvoir la lancer. Ce fichier définit le nom du package de l’application,",
                "Pour chaque fichier de ressource qu’on inclue dans le projet, un identifiant unique est créé pour référencer cette ressource.",
                "Pour chaque fichier de ressource qu’on inclue dans le projet, un identifiant unique est créé pour référencer cette ressource.",
                "Pour chaque fichier de ressource qu’on inclue dans le projet, un identifiant unique est créé pour référencer cette ressource.",
                "Pour chaque fichier de ressource qu’on inclue dans le projet, un identifiant unique est créé pour référencer cette ressource.",
                "l’application que le système doit connaitre pour pouvoir la lancer. Ce fichier définit le nom du package de l’application,"};
        final String[] city = { "Moabi", "Lastourville",
                "Libreville", "Ovan", "Oyem", "Port Gentil"};
        final String[] dpub = { "02-06-2017", "29-05-2017",
                "18-05-2017", "22-04-2017", "12-03-2017", "23-01-2017"};
        final int[] icons = {R.drawable.astech, R.drawable.astech, R.drawable.astech, R.drawable.astech, R.drawable.astech, R.drawable.astech};


        details = new ArrayList<>();

        for (int i = 0; i < titl.length; i++) {
            DetailsItem feed = new DetailsItem();

            feed.setTextView(titl[i]);
            feed.setCostView(cost[i]);
            feed.setDescriptionView(descrip[i]);
            feed.setCityView(city[i]);
            feed.setDateView(dpub[i]);
            feed.setImageView(icons[i]);
            details.add(feed);
        }

        mRecyclerView.setHasFixedSize(true  );
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        MyAdapter mAdapter = new MyAdapter(details, this);
        mRecyclerView.setAdapter(mAdapter);

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Nouveau";
                case 1:
                    return "Boutiques";
                case 2:
                    return "Vendre";
            }
            return null;
        }
    }
}
