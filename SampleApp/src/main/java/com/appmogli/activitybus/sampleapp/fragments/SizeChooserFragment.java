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
public class SizeChooserFragment extends Fragment {

    public static final String EVENT_NAME_SHORT = SizeChooserFragment.class.getName() + "#" + "SHORT";
    public static final String EVENT_NAME_MEDIUM = SizeChooserFragment.class.getName() + "#" + "MEDIUM";
    public static final String EVENT_NAME_LARGE = SizeChooserFragment.class.getName() + "#" + "LARGE";

    private Button shortButton;
    private Button mediumButton;
    private Button largeButton;
    private ActivityBus bus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_size_chooser, null, false);
        shortButton = (Button) root.findViewById(R.id.fragment_size_chooser_short);
        mediumButton = (Button) root.findViewById(R.id.fragment_size_chooser_medium);
        largeButton = (Button) root.findViewById(R.id.fragment_size_chooser_large);

        shortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(EVENT_NAME_SHORT, getResources().getString(R.string.size_short));
            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(EVENT_NAME_MEDIUM, getResources().getString(R.string.size_medium));
            }
        });

        largeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(EVENT_NAME_LARGE, getResources().getString(R.string.size_large));
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
