package com.moc.eventfinder.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.moc.eventfinder.R;
import com.moc.eventfinder.controller.activity.StartActivity;

public class StartFragment1 extends Fragment {

    Button next;
    ImageButton close;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start1, container, false);

        next = (Button) view.findViewById(R.id.next);
        close = (ImageButton) view.findViewById(R.id.close);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartActivity activity = (StartActivity) getActivity();

                FragmentManager fragmentManager = activity.getSupportFragmentManager();

                StartFragment2 fragment = new StartFragment2();
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.to_left_in, R.anim.to_left_out, R.anim.to_right_in, R.anim.to_right_out)
                        .replace(R.id.fragmentContainerView, fragment)
                        .addToBackStack(null)
                        .commit();
            }

        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartActivity activity = (StartActivity) getActivity();

                FragmentManager fragmentManager = activity.getSupportFragmentManager();

                StartFragment4 fragment = new StartFragment4();
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.to_left_in, R.anim.to_left_out, R.anim.to_right_in, R.anim.to_right_out)
                        .replace(R.id.fragmentContainerView, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;

    }
}