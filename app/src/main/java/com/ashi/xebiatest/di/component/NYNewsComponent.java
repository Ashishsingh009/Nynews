package com.ashi.xebiatest.di.component;

import com.ashi.xebiatest.di.annotation.PerActivity;
import com.ashi.xebiatest.view.NyNewsActivity;
import com.ashi.xebiatest.viewmodel.NYNewsViewModel;

import dagger.Component;

/**
 * Interface for dependency injection in NYNewsActivity, NYNewsViewModel
 * @author Ashish Singh
 */
@PerActivity
@Component(dependencies = AppComponent.class)
public interface NYNewsComponent {

    /**
     * Method to provide dependency injection for NYNewsActivity.
     * @param activity Dependent instance to which dagger will provide dependency.
     */
    void inject(NyNewsActivity activity);

    /**
     * Method to provide dependency injection for nyNewsViewModel.
     * @param nyNewsViewModel Dependent instance to which dagger will provide dependency.
     */
    void inject(NYNewsViewModel nyNewsViewModel);
}
