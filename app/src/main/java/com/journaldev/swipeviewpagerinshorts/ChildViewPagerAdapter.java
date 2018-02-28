package com.journaldev.swipeviewpagerinshorts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by anupamchugh on 28/02/18.
 */

public class ChildViewPagerAdapter extends FragmentPagerAdapter {


    DataModel model;

    public ChildViewPagerAdapter(FragmentManager fm, DataModel model) {
        super(fm);
        this.model = model;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ChildFragment.newInstance(model, false);
            case 1:
                return ChildFragment.newInstance(model, true);
            default:
                return ChildFragment.newInstance(model, true);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Child Fragment " + position;
    }

}
