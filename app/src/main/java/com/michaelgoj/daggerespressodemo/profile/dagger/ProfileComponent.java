package com.michaelgoj.daggerespressodemo.profile.dagger;

import com.michaelgoj.daggerespressodemo.dagger.PerActivity;
import com.michaelgoj.daggerespressodemo.profile.ProfileActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = ProfileModule.class)
public interface ProfileComponent {
    void inject(ProfileActivity activity);
}
