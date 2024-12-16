package com.example.myplace.ui.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myplace.R;
import com.example.myplace.UserProfile;

public class profileEdit extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_edit, container, false);

        Button btnSave = view.findViewById(R.id.saveProfile);
        btnSave.setOnClickListener(v -> {
            if (getActivity() instanceof UserProfile) {
                ((UserProfile) getActivity()).navigateToInfoFragment();
            }
        });

        return view;
    }

}