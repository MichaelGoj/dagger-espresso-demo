package com.michaelgoj.daggerespressodemo.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.michaelgoj.daggerespressodemo.DemoApplication;
import com.michaelgoj.daggerespressodemo.settings.dagger.SettingsModule;

import javax.inject.Inject;
import javax.inject.Named;

public class SettingsActivity extends AppCompatActivity {

    @Inject
    @Named(SettingsModule.SETTINGS_TITLE)
    String settingsTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DemoApplication) getApplication()).buildSettingsSubcomponent(this);
        setTitle(settingsTitle);
    }
}
