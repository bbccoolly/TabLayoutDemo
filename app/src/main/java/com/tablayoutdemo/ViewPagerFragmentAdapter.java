package com.tablayoutdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tablayoutdemo.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * created by bcoly on 2017/9/7.
 */

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragments = new ArrayList<>();
    private BaseFragment currentFragment;


    public ViewPagerFragmentAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        mFragments = fragments;
        currentFragment = fragments.get(0);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public BaseFragment getCurrentFragment() {
        return currentFragment;
    }
}
