package com.appmogli.activitybus;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.appmogli.activitybus.impl.ActivityBusImpl;

/**
 * Created by Madhu on 12/27/13.
 */
public class ActivityBusLifeCycleHandler implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = ActivityBusLifeCycleHandler.class.getSimpleName();

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof Busable) {
            ActivityBus bus = new ActivityBusImpl();
            Log.d(TAG, "Injecting a new instance of activity bus:" + bus);
            ((Busable) activity).setActivityBus(bus);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        //ignore
    }

    @Override
    public void onActivityResumed(Activity activity) {
        //ignore
    }

    @Override
    public void onActivityPaused(Activity activity) {
        //ignore
    }

    @Override
    public void onActivityStopped(Activity activity) {
        //ignore
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        //ignore
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (activity instanceof Busable) {
            Log.d(TAG, "De-referencing existing activity bus");
            ActivityBus bus = ((Busable) activity).getActivityBus();
            bus.unsubscribeAll();
            ((Busable) activity).setActivityBus(null);
        }

    }
}
