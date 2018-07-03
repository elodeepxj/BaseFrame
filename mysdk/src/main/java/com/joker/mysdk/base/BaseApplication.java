package com.joker.mysdk.base;

import android.app.Application;
import android.content.Context;

import butterknife.BuildConfig;
import butterknife.ButterKnife;

/**
 * Created by tv on 2018/7/2.
 */

public class BaseApplication extends Application {
    public static BaseApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        ButterKnife.setDebug(BuildConfig.DEBUG);
    }

    public static Application getApplication() {
        return application;
    }

}
