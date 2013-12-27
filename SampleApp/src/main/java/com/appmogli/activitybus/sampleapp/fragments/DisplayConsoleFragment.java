package com.appmogli.activitybus.sampleapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appmogli.activitybus.ActivityBus;
import com.appmogli.activitybus.Busable;
import com.appmogli.activitybus.sampleapp.R;

/**
 * Created by Madhu on 12/27/13.
 */
public class DisplayConsoleFragment extends Fragment {

    private TextView colorText;
    private TextView sizeText;
    private ActivityBus bus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_display_console, null, false);
        colorText = (TextView) root.findViewById(R.id.fragment_display_console_color);
        sizeText = (TextView) root.findViewById(R.id.fragment_display_console_size);
        return root;
    }

    public void setColorText(String colorText1) {
        this.colorText.setText(colorText1);
    }

    public void setSizeText(String sizeText1) {
        this.sizeText.setText(sizeText1);
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
