package com.journaldev.swipeviewpagerinshorts;

/**
 * Created by anupamchugh on 28/02/18.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ParentViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<DataModel> dataModels = new ArrayList<>();

    public ParentViewPagerAdapter(FragmentManager fm, ArrayList<DataModel> dataModels) {
        super(fm);
        this.dataModels = dataModels;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        return ParentFragment.newInstance(dataModels.get(position));

    }

    @Override
    public int getCount() {
        return 5;
    }
}



