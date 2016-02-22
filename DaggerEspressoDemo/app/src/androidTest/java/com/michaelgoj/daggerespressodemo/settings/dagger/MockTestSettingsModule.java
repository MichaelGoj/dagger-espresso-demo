package com.michaelgoj.daggerespressodemo.settings.dagger;

import com.michaelgoj.daggerespressodemo.dagger.PerActivity;
import com.michaelgoj.daggerespressodemo.settings.SettingsActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MockTestSettingsModule {
    public static final String SETTINGS_TITLE = "SettingsTitle";
    private final SettingsActivity activity;

    public MockTestSettingsModule(SettingsActivity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    SettingsActivity provideSettingsActivity() {
        return activity;
    }

    @PerActivity
    @Provides
    @Named(SETTINGS_TITLE)
    String provideTitle() {
        return "Mock Test Settings";
    }
}
