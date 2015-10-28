package com.renarosantos.secompp.business.product;

import android.support.annotation.NonNull;

import com.renarosantos.secompp.DAO.ProductDAO;
import com.renarosantos.secompp.business.BusinessCallback;
import com.renarosantos.secompp.model.Product;

import java.util.List;

/**
 * Created by renarosantos on 26/10/15.
 */
public class ProductBO {

    private final ProductDAO mProductDAO;

    public ProductBO(ProductDAO dao) {
        mProductDAO = dao;
    }

    public void getProduct(@NonNull final String qtd, final BusinessCallback<List<Product>> callback) {

        if (mProductDAO != null) {
            mProductDAO.getProduct(qtd, new BusinessCallback<List<Product>>() {
                @Override
                public void onSucess(final List<Product> result) {
                    callback.onSucess(result);
                }

                @Override
                public void onError() {
                    callback.onError();
                }
            });
        }

    }
}
