package ga.astech.mbaya.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;

import ga.astech.mbaya.R;
import ga.astech.mbaya.adapter.MyAdapter;
import ga.astech.mbaya.fragments.DetailsItem;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DetailsItem> details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        final String[] titl = { "Gingerbread", "Honeycomb",
                "Ice Cream Sandwitch", "JellyBean", "KitKat", "LollyPop"};
        final int[] icons = {R.drawable.astech, R.drawable.astech, R.drawable.astech, R.drawable.astech, R.drawable.astech, R.drawable.astech};


        details = new ArrayList<>();

        for (int i = 0; i < titl.length; i++) {
            DetailsItem feed = new DetailsItem();

            feed.setTextView(titl[i]);
            feed.setImageView(icons[i]);
            details.add(feed);
        }

        mRecyclerView.setHasFixedSize(true  );
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        MyAdapter mAdapter = new MyAdapter(details);
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
}
