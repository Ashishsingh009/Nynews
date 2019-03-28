package com.ashi.xebiatest.di.module;

import android.app.Application;
import android.content.Context;

import com.ashi.xebiatest.NyNewsApp;
import com.ashi.xebiatest.di.annotation.ApplicationContext;
import com.google.gson.Gson;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
*APP BASE MODULE WITH MAPPING OF respective modules.
*@AUTHOR-ASHISH.SINGH
*/


@Module
public class AppModule {
    NyNewsApp app;
    public AppModule(NyNewsApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }




}
