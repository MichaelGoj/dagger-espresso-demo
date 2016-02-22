package com.michaelgoj.daggerespressodemo.settings.dagger;

import com.michaelgoj.daggerespressodemo.dagger.PerActivity;
import com.michaelgoj.daggerespressodemo.settings.SettingsActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = SettingsModule.class)
public interface SettingsComponent {
    void inject(SettingsActivity activity);
}
