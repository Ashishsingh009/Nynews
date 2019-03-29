package com.ashi.xebiatest.di.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * TO bind the activity at runtime in module.
 * @AUTHOR-ASHISHSINGH
 *
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}