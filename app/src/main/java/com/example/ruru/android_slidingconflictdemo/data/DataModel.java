package com.example.ruru.android_slidingconflictdemo.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SophieRu on 2019/4/25
 */
public class DataModel {

    private static List<Integer> list;

    public static void setData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
    }
}
