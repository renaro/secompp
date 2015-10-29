package com.renarosantos.secompp.view.product;

import android.support.annotation.NonNull;

import com.renarosantos.secompp.model.Product;

import java.util.List;

/**
 * Created by renarosantos on 29/10/15.
 */
public interface ListProductView {

    void showLoading();
    void hideLoading();
    void populateList(@NonNull List<Product> list);
    void showEmptyList();
    void showError();

}
