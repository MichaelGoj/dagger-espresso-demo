package com.michaelgoj.daggerespressodemo.dagger;

import android.app.Application;
import android.content.Context;

import dagger.Module;

@Module
public class AndroidModule {

    private final Context context;

    public AndroidModule(Application app) {
        this.context = app;
    }

    Context provideContext() {
        return context;
    }
}
