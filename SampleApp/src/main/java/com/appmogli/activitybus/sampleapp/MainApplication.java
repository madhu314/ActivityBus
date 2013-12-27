package com.appmogli.activitybus.sampleapp;

import android.app.Application;

import com.appmogli.activitybus.ActivityBusLifeCycleHandler;

/**
 * Created by Madhu on 12/27/13.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityBusLifeCycleHandler());
    }
}
