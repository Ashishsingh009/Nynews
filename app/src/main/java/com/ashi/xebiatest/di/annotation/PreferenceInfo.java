package com.ashi.xebiatest.di.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * TO bind the Preferences at runtime in module.
 * @author jai.mishra1000006
 * Date-26-11-2018
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface PreferenceInfo {
}
