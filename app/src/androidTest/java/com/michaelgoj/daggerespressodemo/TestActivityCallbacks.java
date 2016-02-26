package com.michaelgoj.daggerespressodemo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class TestActivityCallbacks<T extends Activity> implements Application.ActivityLifecycleCallbacks {

    private final Class<T> activityClass;
    private final OnInjectListener onInjectListener;

    public TestActivityCallbacks(Class<T> activityClass, OnInjectListener onInjectListener) {
        this.activityClass = activityClass;
        this.onInjectListener = onInjectListener;
    }

    public interface OnInjectListener {
        void inject(Activity activity);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activity.getClass() == activityClass) {
            onInjectListener.inject(activity);
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
}
