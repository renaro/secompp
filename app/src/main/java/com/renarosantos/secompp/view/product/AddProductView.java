package com.renarosantos.secompp.view.product;

/**
 * Created by renarosantos on 28/10/15.
 */
public interface AddProductView {

    void onAddProductSuccess();

    void onRegisterFailed();

    void showLoading();

    void hideLoading();

    void clearInputs();

    String getProductName();

    String getProductPrice();

    String getProductQuantity();

    String getProductBuyingPrice();




}
