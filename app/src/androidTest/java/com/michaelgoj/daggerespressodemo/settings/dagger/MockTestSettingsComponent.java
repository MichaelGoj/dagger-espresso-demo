package com.michaelgoj.daggerespressodemo.settings.dagger;

import com.michaelgoj.daggerespressodemo.dagger.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = MockTestSettingsModule.class)
public interface MockTestSettingsComponent extends SettingsInjector {
}
