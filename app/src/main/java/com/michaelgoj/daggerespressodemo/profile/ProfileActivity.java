package com.michaelgoj.daggerespressodemo.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.michaelgoj.daggerespressodemo.DemoApplication;
import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileModule;

import javax.inject.Inject;
import javax.inject.Named;

public class ProfileActivity extends AppCompatActivity {

    @Inject
    @Named(ProfileModule.PROFILE_TITLE)
    String profileTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DemoApplication) getApplication()).buildProfileSubcomponent(this);
        setTitle(profileTitle);
    }
}
