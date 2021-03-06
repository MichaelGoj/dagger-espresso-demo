package com.michaelgoj.daggerespressodemo.settings;

import com.michaelgoj.daggerespressodemo.DemoApplication;
import com.michaelgoj.daggerespressodemo.settings.dagger.SettingsInjector;
import com.michaelgoj.daggerespressodemo.settings.dagger.SettingsModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class SettingsActivity extends AppCompatActivity {

    @Inject
    @Named(SettingsModule.SETTINGS_TITLE)
    String settingsTitle;

    private SettingsInjector settingsInjector;

    @VisibleForTesting
    public void setInjector(SettingsInjector settingsInjector) {
        Log.d("SettingsInjector", "setInjector");
        this.settingsInjector = settingsInjector;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("SettingsInjector", "onCreate - pre super");
        super.onCreate(savedInstanceState);
        Log.d("SettingsInjector", "onCreate - post super");
        if (settingsInjector == null) {
            settingsInjector = ((DemoApplication) getApplication())
                    .component()
                    .plus(new SettingsModule(this));
        }
        settingsInjector.inject(this);
        setTitle(settingsTitle);
    }

}
