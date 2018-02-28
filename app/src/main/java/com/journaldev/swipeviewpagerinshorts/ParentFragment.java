package com.journaldev.swipeviewpagerinshorts;

/**
 * Created by anupamchugh on 28/02/18.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ParentFragment extends Fragment {


    ViewPager nestedViewPager;
    Activity mActivity;
    ToggleVerticalViewPagerScrolling tv;
    int oldPosition = -1;

    public ParentFragment() {
    }

    public static ParentFragment newInstance(DataModel dataModel) {
        ParentFragment fragment = new ParentFragment();
        Bundle args = new Bundle();
        args.putString("title", dataModel.title);
        args.putString("description", dataModel.description);
        args.putString("url", dataModel.url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_parent, container, false);


        String title = getArguments().getString("title");
        String description = getArguments().getString("description");
        String url = getArguments().getString("url");
        DataModel model = new DataModel(title, description, url);
        nestedViewPager = rootView.findViewById(R.id.nestedViewPager);
        /** Important: Must use the child FragmentManager or you will see side effects. */
        nestedViewPager.setAdapter(new ChildViewPagerAdapter(getChildFragmentManager(), model));


        nestedViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position != oldPosition) {
                    tv.trigger(position);
                }
                oldPosition = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return rootView;
    }

    public interface ToggleVerticalViewPagerScrolling {
        void trigger(int page);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            mActivity = (Activity) context;
        }

        try {
            tv = (ToggleVerticalViewPagerScrolling) mActivity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }
}
