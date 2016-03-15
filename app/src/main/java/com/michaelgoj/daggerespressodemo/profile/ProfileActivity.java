package com.michaelgoj.daggerespressodemo.profile;

import com.michaelgoj.daggerespressodemo.DemoApplication;
import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileInjector;
import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Named;

public class ProfileActivity extends AppCompatActivity {

    @Inject
    @Named(ProfileModule.PROFILE_TITLE)
    String profileTitle;

    private ProfileInjector profileInjector;

    @VisibleForTesting
    public void setInjector(ProfileInjector profileInjector) {
        this.profileInjector = profileInjector;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (profileInjector == null) {
            profileInjector = ((DemoApplication) getApplication()).component()
                    .plus(new ProfileModule(this));
        }
        profileInjector.inject(this);
        setTitle(profileTitle);
    }
}
