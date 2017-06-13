package ga.astech.mbaya.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;

import ga.astech.mbaya.R;
import ga.astech.mbaya.adapter.MyAdapter;
import ga.astech.mbaya.fragments.DetailsItem;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DetailsItem> details;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar declaration
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Vanessa");
        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_home));

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
        switch(id) {
            case R.id.action_refresh :
                break;
            case R.id.action_mail :
                break;
            case R.id.action_profil :
                break;
            case R.id.action_setting :
                break;
            case R.id.action_about :
                break;
            default:
        }

        return super.onOptionsItemSelected(item);
    }
}
