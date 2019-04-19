package com.example.ruru.android_slidingconflictdemo.first_demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by liangxingjian0614 on 2019/4/18.
 */

public class SubPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public SubPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
