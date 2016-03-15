package com.michaelgoj.daggerespressodemo.profile.dagger;

import com.michaelgoj.daggerespressodemo.dagger.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = ProfileModule.class)
public interface ProfileComponent extends ProfileInjector {
}
