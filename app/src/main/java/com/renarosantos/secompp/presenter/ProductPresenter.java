package com.renarosantos.secompp.presenter;

import com.renarosantos.secompp.business.BusinessCallback;
import com.renarosantos.secompp.business.product.ProductBO;
import com.renarosantos.secompp.model.Product;
import com.renarosantos.secompp.view.product.ProductView;

import java.util.List;

/**
 * Created by renarosantos on 26/10/15.
 */
public class ProductPresenter {


    private final ProductView mView;
    private final ProductBO mProductBO;

    public ProductPresenter(ProductView view, ProductBO productBO) {
        mView = view;
        mProductBO = productBO;
    }


    public void fetchProducts(){
        mView.showLoading();
        String qtd = mView.getQuantityValue();
        if (mProductBO != null){
            mProductBO.getProduct(qtd, new BusinessCallback<List<Product>>() {
                @Override
                public void onSucess(final List<Product> result) {
                    mView.hideLoading();
                    mView.populateList(result);
                }

                @Override
                public void onError() {
                    mView.hideLoading();
                    mView.showError();

                }
            });
        }
    }




}
