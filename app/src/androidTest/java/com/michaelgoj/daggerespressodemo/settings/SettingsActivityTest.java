package com.michaelgoj.daggerespressodemo.settings;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.michaelgoj.daggerespressodemo.MockDemoApplication;
import com.michaelgoj.daggerespressodemo.TestActivityCallbacks;
import com.michaelgoj.daggerespressodemo.settings.dagger.MockTestSettingsModule;
import com.michaelgoj.daggerespressodemo.settings.dagger.SettingsInjector;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.michaelgoj.daggerespressodemo.EspressoUtil.matchToolbarTitle;

public class SettingsActivityTest {
    @Rule
    public ActivityTestRule<SettingsActivity> mActivityRule = new ActivityTestRule<>(SettingsActivity.class, false, false);

    @Before
    public void registerInject() throws Exception {
        final MockDemoApplication mockDemoApplication = (MockDemoApplication) InstrumentationRegistry
                .getTargetContext().getApplicationContext();
        mockDemoApplication.registerInjectCallback(new TestActivityCallbacks<>(SettingsActivity.class, new TestActivityCallbacks.OnInjectListener() {
            @Override
            public void inject(Activity activity) {
                SettingsActivity settingsActivity = (SettingsActivity) activity;
                SettingsInjector injector =
                        mockDemoApplication.mockTestComponent().plus(new MockTestSettingsModule(settingsActivity));
                settingsActivity.setInjector(injector);
            }
        }));
    }

    @After
    public void unregisterInject() {
        final MockDemoApplication mockDemoApplication = (MockDemoApplication) InstrumentationRegistry
                .getTargetContext().getApplicationContext();
        mockDemoApplication.unregisterInjectCallback();
    }

    @Test
    public void testTitle() {
        mActivityRule.launchActivity(null);
        matchToolbarTitle("Mock Test Settings");
    }
}
