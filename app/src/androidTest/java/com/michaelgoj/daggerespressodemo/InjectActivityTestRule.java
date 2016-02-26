package com.michaelgoj.daggerespressodemo;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

public class InjectActivityTestRule<T extends Activity> extends ActivityTestRule<T> {
    private final Class<T> activityClass;
    private final TestActivityCallbacks.OnInjectListener onInjectListener;

    public InjectActivityTestRule(Class<T> activityClass, TestActivityCallbacks.OnInjectListener onInjectListener) {
        super(activityClass, false, false);
        this.activityClass = activityClass;
        this.onInjectListener = onInjectListener;
    }

    @Override
    protected void beforeActivityLaunched() {
        super.beforeActivityLaunched();
        MockDemoApplication mockDemoApplication = (MockDemoApplication) InstrumentationRegistry
                .getTargetContext().getApplicationContext();
        mockDemoApplication.registerInjectCallback(new TestActivityCallbacks<>(activityClass, onInjectListener));
    }


    @Override
    protected void afterActivityFinished() {
        MockDemoApplication mockDemoApplication = (MockDemoApplication) InstrumentationRegistry
                .getTargetContext().getApplicationContext();
        mockDemoApplication.unregisterInjectCallback();
    }
}
