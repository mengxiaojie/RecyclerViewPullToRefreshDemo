package com.ys100.recyclerviewpulltorefreshdemo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * App
 * Created by MengJie on 2016/5/25.
 */
public class AppContext extends Application {

    //volley的请求队列
    public RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        //实例化请求队列
        mRequestQueue = Volley.newRequestQueue(this);
    }


}
