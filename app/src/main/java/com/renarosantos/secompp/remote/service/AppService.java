package com.renarosantos.secompp.remote.service;

import com.renarosantos.secompp.model.Product;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by renarosantos on 26/10/15.
 */

public interface AppService {

    @GET("/produtos.php")
    void getProducts(@Query("quantidade") String qtd, Callback<List<Product>> callback);

}
