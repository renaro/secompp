package com.renarosantos.secompp.DAO;

import android.support.annotation.NonNull;

import com.renarosantos.secompp.business.BusinessCallback;
import com.renarosantos.secompp.model.Product;
import com.renarosantos.secompp.remote.client.UserClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renarosantos on 26/10/15.
 */
public class ProductDAO {


    public ProductDAO() {
    }

    public void getProduct(@NonNull final String qtd, final BusinessCallback<List<Product>> callback) {

        new UserClient().getProducts(qtd, new BusinessCallback<List<Product>>() {
            @Override
            public void onSucess(final List<Product> result) {
                if (result == null) {
                    callback.onSucess(new ArrayList<Product>());
                } else {
                    callback.onSucess(result);
                }
            }

            @Override
            public void onError() {
                callback.onError();

            }
        });


    }

}
