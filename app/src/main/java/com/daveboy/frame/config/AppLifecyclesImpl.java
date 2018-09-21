package com.daveboy.frame.config;

import android.app.Application;
import android.content.Context;

import com.daveboy.frame.baseframe.base.delegate.AppLifecycles;

import butterknife.ButterKnife;
import timber.log.Timber;

public class AppLifecyclesImpl implements AppLifecycles {
    @Override
    public void attachBaseContext(Context base) {

    }

    @Override
    public void onCreate(Application application) {
        Timber.plant(new Timber.DebugTree());
        ButterKnife.setDebug(true);

    }

    @Override
    public void onTerminate(Application application) {

    }
}
