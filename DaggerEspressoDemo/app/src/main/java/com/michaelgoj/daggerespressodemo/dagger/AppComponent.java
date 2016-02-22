package com.michaelgoj.daggerespressodemo.dagger;

import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileComponent;
import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileModule;
import com.michaelgoj.daggerespressodemo.settings.dagger.SettingsComponent;
import com.michaelgoj.daggerespressodemo.settings.dagger.SettingsModule;

import dagger.Component;

@Component(modules = AndroidModule.class)
public interface AppComponent {
    ProfileComponent plus(ProfileModule profileModule);

    SettingsComponent plus(SettingsModule settingsModule);
}
