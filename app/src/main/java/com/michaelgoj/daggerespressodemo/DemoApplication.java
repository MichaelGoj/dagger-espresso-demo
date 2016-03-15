package com.michaelgoj.daggerespressodemo;

import android.app.Application;

import com.michaelgoj.daggerespressodemo.dagger.AndroidModule;
import com.michaelgoj.daggerespressodemo.dagger.AppComponent;
import com.michaelgoj.daggerespressodemo.dagger.DaggerAppComponent;
import com.michaelgoj.daggerespressodemo.profile.ProfileActivity;
import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileInjector;
import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileModule;
import com.michaelgoj.daggerespressodemo.settings.SettingsActivity;
import com.michaelgoj.daggerespressodemo.settings.dagger.SettingsInjector;
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

    public ProfileInjector buildProfileSubcomponent(ProfileActivity profileActivity) {
        return appComponent.plus(new ProfileModule(profileActivity));
    }

    public SettingsInjector buildSettingsSubcomponent(SettingsActivity settingsActivity) {
        return appComponent.plus(new SettingsModule(settingsActivity));
    }
}
