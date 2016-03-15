package com.michaelgoj.daggerespressodemo.settings.dagger;

import com.michaelgoj.daggerespressodemo.dagger.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = SettingsModule.class)
public interface SettingsComponent extends SettingsInjector {
}
