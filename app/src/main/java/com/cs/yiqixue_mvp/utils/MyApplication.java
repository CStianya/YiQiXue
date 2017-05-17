package com.cs.yiqixue_mvp.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class MyApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        sContext = getApplicationContext();
    }

    public static Context getContext() {
        return  sContext;
    }

}
