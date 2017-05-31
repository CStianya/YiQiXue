package com.cs.yiqixue_mvp;

import android.app.Application;
import android.content.Context;

import com.cs.yiqixue_mvp.api.APIService;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class MyApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        sContext = getApplicationContext();
        APIService.init();
    }

    public static Context getContext() {
        return  sContext;
    }

}
