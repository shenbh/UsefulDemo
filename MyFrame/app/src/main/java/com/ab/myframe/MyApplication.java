package com.ab.myframe;

import android.app.Application;

/**
 * Created by shenbinghong on 2018/3/20.
 */

public class MyApplication extends Application {

    private static MyApplication application;

    public static MyApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
