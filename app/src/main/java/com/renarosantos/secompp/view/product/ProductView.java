package com.renarosantos.secompp.view.product;

import android.support.annotation.NonNull;

import com.renarosantos.secompp.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renarosantos on 26/10/15.
 */
public interface ProductView {

    @NonNull
    public String getQuantityValue();

    void showLoading();

    void hideLoading();

    void populateList(@NonNull List<Product> list);

    void showError();

}
