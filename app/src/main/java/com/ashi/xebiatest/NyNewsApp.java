package com.ashi.xebiatest;

import android.app.Application;

import com.ashi.xebiatest.di.component.AppComponent;
import com.ashi.xebiatest.di.component.DaggerAppComponent;
import com.ashi.xebiatest.di.module.AppModule;
import com.ashi.xebiatest.di.module.NetworkModule;
import com.ashi.xebiatest.utils.Constants;

public class NyNewsApp extends Application {
    private static NyNewsApp mApp;
    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        initializeInjector();
    }
    private void initializeInjector(){
        mAppComponent= DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(Constants.BASE_URL_SERVER))
                .build();
    }
    /**
     * Method to return the instance of this application.
     * @return Instance of this class;
     */
    public static NyNewsApp getInstance() {
        return mApp;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


}
