package com.ashi.xebiatest.di.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
/**
 * TO get the Application context at runtime.
 * @author jai.mishra1000006
 * Date-20-11-2018
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {

}
