package com.michaelgoj.daggerespressodemo.profile.dagger;

import com.michaelgoj.daggerespressodemo.dagger.PerActivity;
import com.michaelgoj.daggerespressodemo.profile.ProfileActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = MockTestProfileModule.class)
public interface MockTestProfileComponent {
    void inject(ProfileActivity activity);
}
