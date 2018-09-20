package com.daveboy.frame.application;

import android.app.Application;

import com.daveboy.frame.baseframe.base.BaseApplication;


public class MyApplication extends BaseApplication {
    public static Application mApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;

    }
}
