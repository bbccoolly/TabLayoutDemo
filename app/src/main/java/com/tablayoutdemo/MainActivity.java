package com.tablayoutdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tablayoutdemo.fragment.BaseFragment;
import com.tablayoutdemo.fragment.Fragment_1;
import com.tablayoutdemo.fragment.Fragment_2;
import com.tablayoutdemo.fragment.Fragment_3;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.vp)
    ViewPager mVp;

    private ViewPagerFragmentAdapter mAdapter;
    private List<BaseFragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFragments.clear();

        mFragments.add(new Fragment_1());
        mFragments.add(new Fragment_2());
        mFragments.add(new Fragment_3());

        mAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), mFragments);
        mVp.setAdapter(mAdapter);
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVp));
        Toast.makeText(this, ""+mVp.getCurrentItem(), Toast.LENGTH_SHORT).show();
    }
}
