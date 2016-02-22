package com.michaelgoj.daggerespressodemo.profile;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Rule;
import org.junit.Test;

import static com.michaelgoj.daggerespressodemo.EspressoUtil.matchToolbarTitle;

@MediumTest
public class ProfileActivityTest {

    @Rule
    public ActivityTestRule<ProfileActivity> mActivityRule = new ActivityTestRule<>(ProfileActivity.class, false, true);

    @Test
    public void testTitle() {
        matchToolbarTitle("Mock Test Profile");
    }
}
