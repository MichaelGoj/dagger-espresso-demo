package com.michaelgoj.daggerespressodemo.dagger;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Based on http://fernandocejas.com/2015/04/11/tasting-dagger-2-on-android/
 *
 * This scope is a custom scoping annotation to permit objects whose lifetime should conform
 * to the life of the activity to be memorized in the correct component. We get these advantages:
 *
 * - The ability to inject objects where and activity is required to be constructed.
 * - The use of singletons on a per-activity basis.
 * - The global object graph is kept clear of things that can be used only in activities.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {

}
