package com.journaldev.swipeviewpagerinshorts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ParentFragment.ToggleVerticalViewPagerScrolling {

    private ParentViewPagerAdapter verticalPagerAdapter;
    private VerticalViewPager verticalViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<DataModel> dataModels = new ArrayList<>();
        dataModels.add(new DataModel("Android Volley Tutorial", getString(R.string.volley_description), getString(R.string.volley_url)));
        dataModels.add(new DataModel("Android Dagger 2", getString(R.string.dagger_description), getString(R.string.dagger_url)));
        dataModels.add(new DataModel("Android Geocoder Reverse Geocoding", getString(R.string.geocoder_description), getString(R.string.geocoder_url)));
        dataModels.add(new DataModel("Android Notification Direct Reply", getString(R.string.notification_description), getString(R.string.notification_url)));
        dataModels.add(new DataModel("RecyclerView Android with Dividers and Contextual Toolbar", getString(R.string.recyclerview_description), getString(R.string.recyclerview_url)));


        verticalPagerAdapter = new ParentViewPagerAdapter(getSupportFragmentManager(), dataModels);
        verticalViewPager = findViewById(R.id.container);
        verticalViewPager.setAdapter(verticalPagerAdapter);

    }

    @Override
    public void trigger(int page) {


        if (page == 1) {
            verticalViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        } else {
            verticalViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return false;
                }
            });
        }

    }
}
