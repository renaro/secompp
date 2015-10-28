package com.renarosantos.secompp.remote.client;

/**
 * Created by renarosantos on 26/10/15.
 */

import android.util.Log;

import com.renarosantos.secompp.BuildConfig;
import com.renarosantos.secompp.business.BusinessCallback;
import com.renarosantos.secompp.model.Product;
import com.renarosantos.secompp.remote.service.AppService;
import com.squareup.okhttp.OkHttpClient;

import java.util.List;

import retrofit.Callback;
import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;
import retrofit.client.Response;


public class UserClient {

    private final AppService mService;
    private RestAdapter mAdapter;
    public OkHttpClient mHttpClient;

    public UserClient() {
        mHttpClient = new OkHttpClient();
        RestAdapter.Builder restBuilder = new RestAdapter.Builder();
        restBuilder.setLogLevel(RestAdapter.LogLevel.FULL);
        restBuilder.setEndpoint(BuildConfig.API_ENDPOINT);
        restBuilder.setLog(new AndroidLog("RETROFIT"));

        ErrorHandler errorHandler = new ErrorHandler() {

            @Override
            public Throwable handleError(RetrofitError cause) {
                Log.d("ERROR", cause.toString());
                return cause;
            }
        };
        restBuilder.setErrorHandler(errorHandler);
        restBuilder.setClient(new OkClient(mHttpClient));
        mAdapter = restBuilder.build();

        mService = mAdapter.create(AppService.class);


    }

    public void getProducts(String qtd, final BusinessCallback<List<Product>> callback) {
        mService.getProducts(qtd, new Callback<List<Product>>() {
            @Override
            public void success(final List<Product> product, final Response response) {
                callback.onSucess(product);
            }

            @Override
            public void failure(final RetrofitError error) {
                callback.onError();
            }
        });
    }


}
