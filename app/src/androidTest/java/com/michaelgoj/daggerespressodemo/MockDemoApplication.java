package com.michaelgoj.daggerespressodemo;

import com.michaelgoj.daggerespressodemo.dagger.AndroidModule;
import com.michaelgoj.daggerespressodemo.dagger.DaggerMockTestComponent;
import com.michaelgoj.daggerespressodemo.dagger.MockTestComponent;

public class MockDemoApplication extends DemoApplication {

    private MockTestComponent mockTestComponent;
    private TestActivityCallbacks testActivityCallbacks;

    public MockTestComponent mockTestComponent() {
        return mockTestComponent;
    }

    @Override
    protected void buildComponent() {
        mockTestComponent = DaggerMockTestComponent.builder().androidModule(new AndroidModule(this))
                .build();
    }

    public void registerInjectCallback(TestActivityCallbacks testActivityCallbacks) {
        this.testActivityCallbacks = testActivityCallbacks;
        registerActivityLifecycleCallbacks(testActivityCallbacks);
    }

    public void unregisterInjectCallback() {
        unregisterActivityLifecycleCallbacks(testActivityCallbacks);
        testActivityCallbacks = null;
    }
}
