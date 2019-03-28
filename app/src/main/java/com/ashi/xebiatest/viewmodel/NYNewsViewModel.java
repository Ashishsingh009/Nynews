package com.ashi.xebiatest.viewmodel;

import android.app.Application;
import android.util.Log;

import com.ashi.xebiatest.NyNewsApp;
import com.ashi.xebiatest.apis.NyApiManagement;
import com.ashi.xebiatest.di.component.DaggerNYNewsComponent;
import com.ashi.xebiatest.models.NyResponse;
import com.ashi.xebiatest.utils.Constants;
import com.google.gson.Gson;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NYNewsViewModel extends AndroidViewModel {
    @Inject
    Retrofit mRetrofit;
    @Inject
    Gson mGson;
    public MutableLiveData<Boolean> loading = null;
    public MutableLiveData<Throwable> apiError = null;
    public MutableLiveData<NyResponse> newsResponse=null;



   public NYNewsViewModel(@NonNull Application application){
       super(application);
       loading = new MutableLiveData<>();
       apiError = new MutableLiveData<>();
       newsResponse = new MutableLiveData<>();
       initializeInjector();
    }

    private void initializeInjector() {
        DaggerNYNewsComponent
                .builder().appComponent(NyNewsApp.getInstance().getAppComponent())
                .build()
                .inject(this);

    }

    public LiveData<NyResponse> getNewsFromServer(){
        NyApiManagement nyapi=mRetrofit.create(NyApiManagement.class);
        loading.setValue(true);
        nyapi.getnewsList("7",Constants.NY_DEVELOPER_KEY).enqueue(new Callback<NyResponse>() {
            @Override
            public void onResponse(Call<NyResponse> call, Response<NyResponse> response) {
                Log.d("response :::",response.toString());
                if ((response.isSuccessful())&&response.code()==200){
                    NyResponse newslist=response.body();
                    newsResponse.setValue(newslist);
                }
            }

            @Override
            public void onFailure(Call<NyResponse> call, Throwable t) {
                loading.setValue(false);
                apiError.setValue(t);
            }
        });

       return newsResponse;
    }

}
