package com.renarosantos.secompp.business.product;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.renarosantos.secompp.DAO.ProductDAO;
import com.renarosantos.secompp.business.BusinessCallback;
import com.renarosantos.secompp.model.Product;
import com.renarosantos.secompp.model.ProductEntity;

import java.util.ArrayList;
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

    public void saveProduct(final Product product, final BusinessCallback<Product> productCallback) {

        if (TextUtils.isEmpty(product.name())) {
            productCallback.onError();
            return;
        } else {
            mProductDAO.saveProduct(product, new BusinessCallback<Product>() {
                @Override
                public void onSucess(final Product result) {
                    productCallback.onSucess(result);
                }

                @Override
                public void onError() {
                    productCallback.onError();

                }
            });

        }
    }

    public void getLocalProducts(final BusinessCallback<ArrayList<Product>> businessCallback) {
        mProductDAO.fetchLocalProducts(new BusinessCallback<ArrayList<Product>>() {
            @Override
            public void onSucess(final ArrayList<Product> result) {
                businessCallback.onSucess(result);
            }

            @Override
            public void onError() {
                businessCallback.onError();
            }
        });
    }
}
