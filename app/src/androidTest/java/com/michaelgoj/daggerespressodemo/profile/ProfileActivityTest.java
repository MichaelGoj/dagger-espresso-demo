package com.michaelgoj.daggerespressodemo.profile;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.MediumTest;

import com.michaelgoj.daggerespressodemo.MockDemoApplication;
import com.michaelgoj.daggerespressodemo.TestActivityCallbacks;
import com.michaelgoj.daggerespressodemo.profile.dagger.MockTestProfileModule;
import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileInjector;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.michaelgoj.daggerespressodemo.EspressoUtil.matchToolbarTitle;

@MediumTest
public class ProfileActivityTest {

    @Rule
    public ActivityTestRule<ProfileActivity> mActivityRule = new ActivityTestRule<>(ProfileActivity.class, false, false);

    @Before
    public void registerInject() throws Exception {
        final MockDemoApplication mockDemoApplication = (MockDemoApplication) InstrumentationRegistry
                .getTargetContext().getApplicationContext();
        mockDemoApplication.registerInjectCallback(new TestActivityCallbacks<>(ProfileActivity.class, new TestActivityCallbacks.OnInjectListener() {
            @Override
            public void inject(Activity activity) {
                ProfileActivity profileActivity = (ProfileActivity) activity;
                ProfileInjector injector = mockDemoApplication.mockTestComponent()
                        .plus(new MockTestProfileModule(profileActivity));
                profileActivity.setInjector(injector);
            }
        }));
    }

    @After
    public void unregisterInject() {
        MockDemoApplication mockDemoApplication = (MockDemoApplication) InstrumentationRegistry
                .getTargetContext().getApplicationContext();
        mockDemoApplication.unregisterInjectCallback();
    }

    @Test
    public void testTitle() {
        mActivityRule.launchActivity(null);
        matchToolbarTitle("Mock Test Profile");
    }
}
