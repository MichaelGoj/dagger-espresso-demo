package com.michaelgoj.daggerespressodemo.settings;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;

import com.michaelgoj.daggerespressodemo.InjectActivityTestRule;
import com.michaelgoj.daggerespressodemo.MockDemoApplication;
import com.michaelgoj.daggerespressodemo.TestActivityCallbacks;
import com.michaelgoj.daggerespressodemo.settings.dagger.MockTestSettingsModule;
import com.michaelgoj.daggerespressodemo.settings.dagger.SettingsInjector;

import org.junit.Rule;
import org.junit.Test;

import static com.michaelgoj.daggerespressodemo.EspressoUtil.matchToolbarTitle;

public class SettingsActivityTest {
    @Rule
    public InjectActivityTestRule<SettingsActivity> mActivityRule = new InjectActivityTestRule<>(SettingsActivity.class, new TestActivityCallbacks.OnInjectListener() {
        @Override
        public void inject(Activity activity) {
            MockDemoApplication mockDemoApplication = (MockDemoApplication) InstrumentationRegistry
                    .getTargetContext().getApplicationContext();
            SettingsActivity settingsActivity = (SettingsActivity) activity;
            SettingsInjector injector =
                    mockDemoApplication.mockTestComponent().plus(new MockTestSettingsModule(settingsActivity));
            settingsActivity.setInjector(injector);
        }
    });

    @Test
    public void testTitle() {
        mActivityRule.launchActivity(null);
        matchToolbarTitle("Mock Test Settings");
    }
}
