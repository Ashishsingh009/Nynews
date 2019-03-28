package com.ashi.xebiatest.di.component;

import android.content.Context;


import com.ashi.xebiatest.di.annotation.ApplicationContext;
import com.ashi.xebiatest.di.module.AppModule;
import com.ashi.xebiatest.di.module.NetworkModule;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 AppComponent class contains the dependency of App module and n/w module.
 Class for Dagger injection. Methods with in the
interface is Globally access.
@AUTHOR-ASHISH.SINGH1000012
 */


@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    @ApplicationContext
    Context getContext();
    Gson gson();
    Retrofit getRetrofitClient();
}
