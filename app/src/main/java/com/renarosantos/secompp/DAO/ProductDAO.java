package com.renarosantos.secompp.DAO;

import android.support.annotation.NonNull;

import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.renarosantos.secompp.business.BusinessCallback;
import com.renarosantos.secompp.model.Product;
import com.renarosantos.secompp.model.ProductEntity;
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

    public void saveProduct(final Product product, final BusinessCallback<Product> businessCallback) {
        final ProductEntity from = ProductEntity.from(product);
        from.save();
        businessCallback.onSucess(product);
    }


    public void fetchLocalProducts(final BusinessCallback<ArrayList<Product>> businessCallback) {
        List<ProductEntity> result = new Select().from(ProductEntity.class).queryList();
        ArrayList<Product> output = new ArrayList<>();
        if (result == null) {
            businessCallback.onError();
        } else {
            for (ProductEntity p : result) {
                output.add(Product.from(p));
            }
            businessCallback.onSucess(output);
        }
    }
}
