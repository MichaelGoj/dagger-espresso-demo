package com.michaelgoj.daggerespressodemo.profile;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.test.suitebuilder.annotation.MediumTest;

import com.michaelgoj.daggerespressodemo.InjectActivityTestRule;
import com.michaelgoj.daggerespressodemo.MockDemoApplication;
import com.michaelgoj.daggerespressodemo.TestActivityCallbacks;
import com.michaelgoj.daggerespressodemo.profile.dagger.MockTestProfileModule;
import com.michaelgoj.daggerespressodemo.profile.dagger.ProfileInjector;

import org.junit.Rule;
import org.junit.Test;

import static com.michaelgoj.daggerespressodemo.EspressoUtil.matchToolbarTitle;

@MediumTest
public class ProfileActivityTest {

    @Rule
    public InjectActivityTestRule<ProfileActivity> mActivityRule = new InjectActivityTestRule<>(ProfileActivity.class, new TestActivityCallbacks.OnInjectListener() {
        @Override
        public void inject(Activity activity) {
            MockDemoApplication mockDemoApplication = (MockDemoApplication) InstrumentationRegistry
                    .getTargetContext().getApplicationContext();
            ProfileActivity profileActivity = (ProfileActivity) activity;
            ProfileInjector injector = mockDemoApplication.mockTestComponent()
                    .plus(new MockTestProfileModule(profileActivity));
            profileActivity.setInjector(injector);
        }
    });


    @Test
    public void testTitle() {
        mActivityRule.launchActivity(null);
        matchToolbarTitle("Mock Test Profile");
    }
}
