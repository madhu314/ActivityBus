package com.appmogli.activitybus.sampleapp;

import android.app.Activity;
import android.os.Bundle;

import com.appmogli.activitybus.ActivityBus;
import com.appmogli.activitybus.Busable;
import com.appmogli.activitybus.sampleapp.fragments.ColorChooserFragment;
import com.appmogli.activitybus.sampleapp.fragments.DisplayConsoleFragment;
import com.appmogli.activitybus.sampleapp.fragments.SizeChooserFragment;

public class MainActivity extends Activity implements Busable, ActivityBus.PostEventListener {

    private DisplayConsoleFragment displayConsoleFragment;
    private ColorChooserFragment colorChooserFragment;
    private SizeChooserFragment sizeChooserFragment;
    private ActivityBus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayConsoleFragment = (DisplayConsoleFragment) getFragmentManager().findFragmentById(R.id.activity_main_display_console);
        colorChooserFragment = (ColorChooserFragment) getFragmentManager().findFragmentById(R.id.activity_main_color_chooser);
        sizeChooserFragment = (SizeChooserFragment) getFragmentManager().findFragmentById(R.id.activity_main_size_chooser);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //register to bus events

        //color fragment events
        bus.subscribeForEvent(ColorChooserFragment.EVENT_NAME_RED, this);
        bus.subscribeForEvent(ColorChooserFragment.EVENT_NAME_BLUE, this);
        bus.subscribeForEvent(ColorChooserFragment.EVENT_NAME_GREEN, this);

        //size fragment events
        bus.subscribeForEvent(SizeChooserFragment.EVENT_NAME_SHORT, this);
        bus.subscribeForEvent(SizeChooserFragment.EVENT_NAME_MEDIUM, this);
        bus.subscribeForEvent(SizeChooserFragment.EVENT_NAME_LARGE, this);

    }

    @Override
    protected void onPause() {
        //color fragment events
        bus.unsubscribeForEvent(ColorChooserFragment.EVENT_NAME_RED, this);
        bus.unsubscribeForEvent(ColorChooserFragment.EVENT_NAME_BLUE, this);
        bus.unsubscribeForEvent(ColorChooserFragment.EVENT_NAME_GREEN, this);

        //size fragment events
        bus.unsubscribeForEvent(SizeChooserFragment.EVENT_NAME_SHORT, this);
        bus.unsubscribeForEvent(SizeChooserFragment.EVENT_NAME_MEDIUM, this);
        bus.unsubscribeForEvent(SizeChooserFragment.EVENT_NAME_LARGE, this);

        super.onPause();
        //unregister from bus events
    }

    @Override
    public void setActivityBus(ActivityBus bus) {
        this.bus = bus;
    }

    @Override
    public ActivityBus getActivityBus() {
        return bus;
    }

    @Override
    public void onEvent(String name, Object data) {
        if (ColorChooserFragment.EVENT_NAME_RED.equals(name)) {
            displayConsoleFragment.setColorText((String) data);
        } else if (ColorChooserFragment.EVENT_NAME_BLUE.equals(name)) {
            displayConsoleFragment.setColorText((String) data);
        } else if (ColorChooserFragment.EVENT_NAME_GREEN.equals(name)) {
            displayConsoleFragment.setColorText((String) data);
        } else if (SizeChooserFragment.EVENT_NAME_SHORT.equals(name)) {
            displayConsoleFragment.setSizeText((String) data);
        } else if (SizeChooserFragment.EVENT_NAME_MEDIUM.equals(name)) {
            displayConsoleFragment.setSizeText((String) data);
        } else if (SizeChooserFragment.EVENT_NAME_LARGE.equals(name)) {
            displayConsoleFragment.setSizeText((String) data);
        }
    }
}
