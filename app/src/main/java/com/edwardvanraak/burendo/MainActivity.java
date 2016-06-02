package com.edwardvanraak.burendo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.edwardvanraak.burendo.userinterface.modules.popular_items.callbacks.OnPopularItemSelectedListener;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.fragments.PopularItemsFragment;

import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity implements OnPopularItemSelectedListener {

    private static final String TAG = PopularItemsFragment.class.getCanonicalName();

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_main, PopularItemsFragment.newInstance())
                    .commit();
        }
    }


    @Override
    public void onPopularItemSelected(String identifier) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
