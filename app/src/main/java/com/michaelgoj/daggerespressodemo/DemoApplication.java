package com.michaelgoj.daggerespressodemo;

import android.app.Application;

import com.michaelgoj.daggerespressodemo.dagger.AndroidModule;
import com.michaelgoj.daggerespressodemo.dagger.AppComponent;
import com.michaelgoj.daggerespressodemo.dagger.DaggerAppComponent;

public class DemoApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponent();
    }

    protected void buildComponent() {
        appComponent = DaggerAppComponent.builder().androidModule(new AndroidModule(this)).build();
    }

    public AppComponent component() {
        return appComponent;
    }
}
