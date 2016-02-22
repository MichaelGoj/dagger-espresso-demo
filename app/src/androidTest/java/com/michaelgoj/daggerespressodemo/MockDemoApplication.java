package com.michaelgoj.daggerespressodemo;

import com.michaelgoj.daggerespressodemo.dagger.AndroidModule;
import com.michaelgoj.daggerespressodemo.dagger.DaggerMockTestComponent;
import com.michaelgoj.daggerespressodemo.dagger.MockTestComponent;
import com.michaelgoj.daggerespressodemo.profile.ProfileActivity;
import com.michaelgoj.daggerespressodemo.profile.dagger.MockTestProfileComponent;
import com.michaelgoj.daggerespressodemo.profile.dagger.MockTestProfileModule;
import com.michaelgoj.daggerespressodemo.settings.SettingsActivity;
import com.michaelgoj.daggerespressodemo.settings.dagger.MockTestSettingsComponent;
import com.michaelgoj.daggerespressodemo.settings.dagger.MockTestSettingsModule;

public class MockDemoApplication extends DemoApplication {

    private MockTestComponent mockTestComponent;

    @Override
    protected void buildComponent() {
        mockTestComponent = DaggerMockTestComponent.builder().androidModule(new AndroidModule(this)).build();
    }

    @Override
    public void buildProfileSubcomponent(ProfileActivity profileActivity) {
        MockTestProfileComponent component = mockTestComponent.plus(new MockTestProfileModule(profileActivity));
        component.inject(profileActivity);
    }

    @Override
    public void buildSettingsSubcomponent(SettingsActivity settingsActivity) {
        MockTestSettingsComponent component = mockTestComponent.plus(new MockTestSettingsModule(settingsActivity));
        component.inject(settingsActivity);
    }
}
