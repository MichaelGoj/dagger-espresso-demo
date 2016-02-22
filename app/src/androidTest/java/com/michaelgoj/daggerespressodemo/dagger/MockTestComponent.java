package com.michaelgoj.daggerespressodemo.dagger;

import com.michaelgoj.daggerespressodemo.profile.dagger.MockTestProfileComponent;
import com.michaelgoj.daggerespressodemo.profile.dagger.MockTestProfileModule;
import com.michaelgoj.daggerespressodemo.settings.dagger.MockTestSettingsComponent;
import com.michaelgoj.daggerespressodemo.settings.dagger.MockTestSettingsModule;

import dagger.Component;

@Component(modules = AndroidModule.class)
public interface MockTestComponent {
    MockTestProfileComponent plus(MockTestProfileModule mockTestProfileModule);

    MockTestSettingsComponent plus(MockTestSettingsModule mockTestSettingsModule);
}
