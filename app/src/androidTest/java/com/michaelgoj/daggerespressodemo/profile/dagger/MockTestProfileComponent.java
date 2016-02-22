package com.michaelgoj.daggerespressodemo.profile.dagger;

import com.michaelgoj.daggerespressodemo.dagger.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = MockTestProfileModule.class)
public interface MockTestProfileComponent extends ProfileInjector {
}
