package com.michaelgoj.daggerespressodemo.settings;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static com.michaelgoj.daggerespressodemo.EspressoUtil.matchToolbarTitle;

public class SettingsActivityTest {
    @Rule
    public ActivityTestRule<SettingsActivity> mActivityRule = new ActivityTestRule<>(SettingsActivity.class, false, true);

    @Test
    public void testTitle() {
        matchToolbarTitle("Mock Test Settings");
    }
}
