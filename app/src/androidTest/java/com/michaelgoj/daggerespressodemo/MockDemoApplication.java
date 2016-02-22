package com.michaelgoj.daggerespressodemo;

import com.michaelgoj.daggerespressodemo.dagger.AndroidModule;
import com.michaelgoj.daggerespressodemo.dagger.DaggerMockTestComponent;
import com.michaelgoj.daggerespressodemo.dagger.MockTestComponent;
import com.michaelgoj.daggerespressodemo.profile.ProfileActivity;
import com.michaelgoj.daggerespressodemo.profile.dagger.MockTestProfileModule;
import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileInjector;
import com.michaelgoj.daggerespressodemo.settings.SettingsActivity;
import com.michaelgoj.daggerespressodemo.settings.dagger.MockTestSettingsModule;
import com.michaelgoj.daggerespressodemo.settings.dagger.SettingsInjector;

public class MockDemoApplication extends DemoApplication {

    private MockTestComponent mockTestComponent;

    @Override
    protected void buildComponent() {
        mockTestComponent = DaggerMockTestComponent.builder().androidModule(new AndroidModule(this)).build();
    }

    @Override
    public ProfileInjector buildProfileSubcomponent(ProfileActivity profileActivity) {
        return mockTestComponent.plus(new MockTestProfileModule(profileActivity));
    }

    @Override
    public SettingsInjector buildSettingsSubcomponent(SettingsActivity settingsActivity) {
        return mockTestComponent.plus(new MockTestSettingsModule(settingsActivity));
    }
}
