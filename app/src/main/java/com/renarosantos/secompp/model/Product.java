package com.renarosantos.secompp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by renarosantos on 26/10/15.
 */
public class Product {

    @SerializedName("nome")
    public String mName;

    @SerializedName("preco")
    public String mPrice;

    @SerializedName("foto")
    public String mPhoto;

    public Product(final String name, final String price, final String photo) {
        mName = name;
        mPrice = price;
        mPhoto = photo;
    }


    public String name() {
        return mName;
    }

    public String price() {
        return mPrice;
    }


    public String photo() {
        return mPhoto;
    }

}
