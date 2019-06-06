package com.example.ruru.android_slidingconflictdemo.data;

import android.support.v4.app.Fragment;

import com.example.ruru.android_slidingconflictdemo.fragment.AFragment;
import com.example.ruru.android_slidingconflictdemo.fragment.BFragment;
import com.example.ruru.android_slidingconflictdemo.fragment.CFragment;
import com.example.ruru.android_slidingconflictdemo.fragment.DFragment;
import com.example.ruru.android_slidingconflictdemo.fragment.EFragment;
import com.example.ruru.android_slidingconflictdemo.fragment.FFragment;
import com.example.ruru.android_slidingconflictdemo.fragment.GFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SophieRu on 2019/4/25
 */
public class DataModel {

    public static List<String> getStringList1() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("item" + i);
        }
        return list;
    }

    public static List<String> getStringList2() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("你好" + i);
        }
        return list;
    }

    public static List<Fragment> getFragmentList1() {
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(new AFragment());
        list.add(new BFragment());
        return list;
    }

    public static List<Fragment> getFragmentList2() {
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(new CFragment());
        list.add(new DFragment());
        return list;
    }

    public static List<Fragment> getFragmentList3() {
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(new FFragment());
        list.add(new CFragment());
        return list;
    }

    public static List<Fragment> getFragmentList4() {
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(new EFragment());//CustomLV
        list.add(new GFragment());//LV
        return list;
    }
}
