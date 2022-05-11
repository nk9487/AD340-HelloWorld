package com.example.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    ProfileData profileData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView name = view.findViewById(R.id.user_name_field);
        TextView occupation = view.findViewById(R.id.occupation_field);
        TextView age = view.findViewById(R.id.id_age);
        TextView description = view.findViewById(R.id.description_field);

//        if (this.profileData != null) {
//            name.setText(this.profileData.getName());
//            age.setText("" + this.profileData.getAge());
//            occupation.setText(this.profileData.getOccupation());
//            description.setText(this.profileData.getDescription());
//        }
        return view;
    }

    public void setProfileData(ProfileData profileData) {
        this.profileData = profileData;
    }
}
