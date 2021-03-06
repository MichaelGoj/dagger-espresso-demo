package com.michaelgoj.daggerespressodemo.profile.dagger;

import com.michaelgoj.daggerespressodemo.dagger.PerActivity;
import com.michaelgoj.daggerespressodemo.profile.ProfileActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MockTestProfileModule {
    public static final String PROFILE_TITLE = "ProfileTitle";

    private final ProfileActivity activity;

    public MockTestProfileModule(ProfileActivity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    ProfileActivity provideProfileActivity() {
        return activity;
    }

    @PerActivity
    @Provides
    @Named(PROFILE_TITLE)
    String provideTitle() {
        return "Mock Test Profile";
    }
}
