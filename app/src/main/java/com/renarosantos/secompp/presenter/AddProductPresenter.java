package com.renarosantos.secompp.presenter;

import com.renarosantos.secompp.business.BusinessCallback;
import com.renarosantos.secompp.business.product.ProductBO;
import com.renarosantos.secompp.model.Product;
import com.renarosantos.secompp.view.product.AddProductView;

/**
 * Created by renarosantos on 28/10/15.
 */
public class AddProductPresenter {

    private final AddProductView mView;
    private final ProductBO mProductBO;

    public AddProductPresenter(AddProductView view, ProductBO productBO) {
        mView = view;
        mProductBO = productBO;
    }


    public void onAddProductRequest() {
        String name = mView.getProductName();
        String price = mView.getProductPrice();
        String amount = mView.getProductQuantity();
        String buyingprice = mView.getProductBuyingPrice();
        Product product = new Product(name, price, amount, buyingprice);
        mProductBO.saveProduct(product, new ProductCallback());
    }


    public class ProductCallback implements BusinessCallback<Product> {

        @Override
        public void onSucess(final Product result) {
            mView.onAddProductSuccess();
            mView.clearInputs();
        }

        @Override
        public void onError() {
            mView.onRegisterFailed();

        }
    }

}
