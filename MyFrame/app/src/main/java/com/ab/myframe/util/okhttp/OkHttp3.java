package com.ab.myframe.util.okhttp;

import okhttp3.OkHttpClient;

/**
 * Created by shenbinghong on 2018/3/13.
 */

public class OkHttp3 {
    private static OkHttpClient client = new OkHttpClient();

    public static OkHttpClient getClient() {
        return client;
    }
}
