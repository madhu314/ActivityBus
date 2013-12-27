package com.appmogli.activitybus.sampleapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.appmogli.activitybus.ActivityBus;
import com.appmogli.activitybus.Busable;
import com.appmogli.activitybus.sampleapp.R;

/**
 * Created by Madhu on 12/27/13.
 */
public class ColorChooserFragment extends Fragment {

    public static final String EVENT_NAME_RED = ColorChooserFragment.class.getName() + "#" + "RED";
    public static final String EVENT_NAME_BLUE = ColorChooserFragment.class.getName() + "#" + "BLUE";
    public static final String EVENT_NAME_GREEN = ColorChooserFragment.class.getName() + "#" + "GREEN";


    private Button redButton;
    private Button blueButton;
    private Button greenButton;
    private ActivityBus bus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_color_chooser, null, false);
        redButton = (Button) root.findViewById(R.id.fragment_color_chooser_red);
        blueButton = (Button) root.findViewById(R.id.fragment_color_chooser_blue);
        greenButton = (Button) root.findViewById(R.id.fragment_color_chooser_green);

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(EVENT_NAME_RED, getResources().getString(R.string.red));
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(EVENT_NAME_BLUE, getResources().getString(R.string.blue));
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(EVENT_NAME_GREEN, getResources().getString(R.string.green));
            }
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof Busable) {
            this.bus = ((Busable) getActivity()).getActivityBus();
        } else {
            throw new RuntimeException("This fragment activity to be Busable to communicate events");
        }
    }

}
