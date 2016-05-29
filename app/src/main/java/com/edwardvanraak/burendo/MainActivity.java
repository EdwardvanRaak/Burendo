package com.edwardvanraak.burendo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.edwardvanraak.burendo.communication.BlendleAPI;
import com.edwardvanraak.burendo.domain.pojo.data.Api;
import com.edwardvanraak.burendo.domain.pojo.data.popular_items.Item;
import com.edwardvanraak.burendo.domain.pojo.data.popular_items.PopularItems;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String APP_NAME = "Burendo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        retrieveAPILinks();
    }

    /**
     * TODO: Refactor and move this to appropriate class once ui/fragments are made
     * Test retrieving API links and popular items
     */
    private void retrieveAPILinks() {
        Call<Api> blendleApiCall = BlendleAPI.Factory.getInstance().getApi();
        blendleApiCall.enqueue(new Callback<Api>() {
            @Override
            public void onResponse(Call<Api> call, Response<Api> response) {
                Api api = response.body();
                String popularItemsLink = api.getLinks().getPopularItems().getHref();
                retrievePopularItems(popularItemsLink);
            }
            @Override
            public void onFailure(Call<Api> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void retrievePopularItems(String url){
        Call<PopularItems> popularItemsCall = BlendleAPI.Factory.getInstance().getPopularItems(url);
        popularItemsCall.enqueue(new Callback<PopularItems>() {
            @Override
            public void onResponse(Call<PopularItems> call, Response<PopularItems> response) {
                PopularItems popularItems = response.body();
                for(Item item : popularItems.getResources().getItems()){
                    Log.d(APP_NAME, "TITLE: " + item.getEmbedded().getManifest().getBody().get(0).getContent()); //Quick test to look at the title, or whatever is on the first position of the body ;)
                }
            }
            @Override
            public void onFailure(Call<PopularItems> call, Throwable t) {
                t.printStackTrace();
                Log.d(APP_NAME, "Failed");
            }
        });
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
