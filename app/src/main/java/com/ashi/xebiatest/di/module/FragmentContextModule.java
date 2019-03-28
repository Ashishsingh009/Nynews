package com.ashi.xebiatest.di.module;

import android.app.Activity;


import dagger.Module;
import dagger.Provides;

/**
 * @author Ashish Singh
 * Date-28-03-2019
 * This class provide activity to attache Fragment in to activity
 */
@Module
public class FragmentContextModule {
    Activity activity;

    public FragmentContextModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    public Activity activity() {
        return activity;
    }
}
