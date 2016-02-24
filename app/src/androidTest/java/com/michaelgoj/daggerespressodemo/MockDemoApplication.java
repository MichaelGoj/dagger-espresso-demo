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

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MockDemoApplication extends DemoApplication {

    private MockTestComponent mockTestComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                if (activity instanceof SettingsActivity) {
                    Log.d("SettingsInjector", "onActivityCreated");
                    SettingsActivity settingsActivity = (SettingsActivity) activity;
                    SettingsInjector injector =
                            mockTestComponent.plus(new MockTestSettingsModule(settingsActivity));
                    settingsActivity.setInjector(injector);
                } else if (activity instanceof ProfileActivity) {
                    ProfileActivity profileActivity = (ProfileActivity) activity;
                    ProfileInjector injector =
                            mockTestComponent.plus(new MockTestProfileModule(profileActivity));
                    profileActivity.setInjector(injector);
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    @Override
    protected void buildComponent() {
        mockTestComponent = DaggerMockTestComponent.builder().androidModule(new AndroidModule(this))
                .build();
    }
}
