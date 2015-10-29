package com.renarosantos.secompp.model;

import android.support.annotation.NonNull;

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

    @SerializedName("quantidade")
    public String mQuantity;

    @SerializedName("preco_compra")
    public String mBuyingPrice;

    public Product(final String name, final String price, final String photo) {
        mName = name;
        mPrice = price;
        mPhoto = photo;
    }

    public Product(final String name, final String price, final String quantity, final String buyingPrice) {
        mName = name;
        mPrice = price;
        mQuantity = quantity;
        mBuyingPrice = buyingPrice;
    }

    public static Product from(@NonNull ProductEntity p){
        return new Product(p.name, ""+p.sellingPrice, ""+p.quantity, ""+p.buyingPrice);
    }


    public String name() {
        return mName;
    }

    public Float price() {
        try{
            return Float.parseFloat(mPrice);
        }catch (NumberFormatException e){
            return 0f;
        }
    }


    public String photo() {
        return mPhoto;
    }

    public int quantity() {
        try{
            return Integer.parseInt(mQuantity);
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public Float buyingPrice() {
        try{
            return Float.parseFloat(mBuyingPrice);
        }catch (NumberFormatException e){
            return 0f;
        }
    }

}
