package com.michaelgoj.daggerespressodemo.settings.dagger;

import com.michaelgoj.daggerespressodemo.dagger.PerActivity;
import com.michaelgoj.daggerespressodemo.settings.SettingsActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = MockTestSettingsModule.class)
public interface MockTestSettingsComponent {
    void inject(SettingsActivity activity);
}
