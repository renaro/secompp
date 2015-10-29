package com.renarosantos.secompp.presenter;

import com.renarosantos.secompp.business.BusinessCallback;
import com.renarosantos.secompp.business.product.ProductBO;
import com.renarosantos.secompp.model.Product;
import com.renarosantos.secompp.view.product.AddProductView;
import com.renarosantos.secompp.view.product.ListProductView;

import java.util.ArrayList;

/**
 * Created by renarosantos on 29/10/15.
 */
public class ProductListPresenter {

    private final ListProductView mView;
    private final ProductBO mProductBO;

    public ProductListPresenter(ListProductView view, ProductBO productBO) {
        mView = view;
        mProductBO = productBO;
    }

    public void fetchProducts(){
        mView.showLoading();
        mProductBO.getLocalProducts(new BusinessCallback<ArrayList<Product>>() {
            @Override
            public void onSucess(final ArrayList<Product> result) {
                mView.hideLoading();
                if(result.size() > 0){
                    mView.populateList(result);
                } else {
                    mView.showEmptyList();
                }
            }

            @Override
            public void onError() {
                mView.hideLoading();
                mView.showError();

            }
        });
    }



}
