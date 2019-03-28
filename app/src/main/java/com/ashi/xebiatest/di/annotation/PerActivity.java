package com.ashi.xebiatest.di.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * TO bind the activity at runtime in module.
 * @AUTHOR-ASHISH.SINGH1000012
 * Date-19-11-2018
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}