package com.michaelgoj.daggerespressodemo;

import android.app.Application;

import com.michaelgoj.daggerespressodemo.dagger.AndroidModule;
import com.michaelgoj.daggerespressodemo.dagger.AppComponent;
import com.michaelgoj.daggerespressodemo.dagger.DaggerAppComponent;
import com.michaelgoj.daggerespressodemo.profile.ProfileActivity;
import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileComponent;
import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileModule;
import com.michaelgoj.daggerespressodemo.settings.SettingsActivity;
import com.michaelgoj.daggerespressodemo.settings.dagger.SettingsComponent;
import com.michaelgoj.daggerespressodemo.settings.dagger.SettingsModule;

public class DemoApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponent();
    }

    protected void buildComponent() {
        appComponent = DaggerAppComponent.builder().androidModule(new AndroidModule(this)).build();
    }

    public void buildProfileComponent(ProfileActivity profileActivity) {
        ProfileComponent profileComponent = appComponent.plus(new ProfileModule(profileActivity));
        profileComponent.inject(profileActivity);
    }

    public void buildSettingsComponent(SettingsActivity settingsActivity) {
        SettingsComponent settingsComponent = appComponent.plus(new SettingsModule(settingsActivity));
        settingsComponent.inject(settingsActivity);
    }
}
