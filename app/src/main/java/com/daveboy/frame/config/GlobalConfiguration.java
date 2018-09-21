package com.daveboy.frame.config;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.daveboy.frame.baseframe.base.delegate.AppLifecycles;
import com.daveboy.frame.baseframe.di.module.ClientModule;
import com.daveboy.frame.baseframe.di.module.GlobalConfigModule;
import com.daveboy.frame.baseframe.integration.ConfigModule;
import com.daveboy.frame.mvp.module.Api;

import java.util.List;

import io.rx_cache2.internal.RxCache;

public class GlobalConfiguration implements ConfigModule {
    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        builder.baseurl(Api.APP_DOMAIN)
                .globalHttpHandler(new GlobalHttpHandlerImpl(context))
                .responseErrorListener(new ResponseErrorListenerImpl())
                .rxCacheConfiguration(new ClientModule.RxCacheConfiguration() {
                    @Override
                    public RxCache configRxCache(Context context, RxCache.Builder builder) {
                        builder.useExpiredDataIfLoaderNotAvailable(true);
                        return null;
                    }
                });
    }

    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles) {
        lifecycles.add(new AppLifecyclesImpl());
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {

    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {

    }
}
