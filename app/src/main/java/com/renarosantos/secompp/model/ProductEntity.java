package com.renarosantos.secompp.model;

import android.support.annotation.NonNull;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(databaseName = AppDatabase.NAME)
public class ProductEntity extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    long idAutoIncrement;

    @Column
    String id;

    @Column
    String name;

    @Column
    int quantity;

    @Column
    Float sellingPrice;

    @Column
    Float buyingPrice;

    @Column
    long lastModified;


    ProductEntity() {
    }

    public ProductEntity(String pName, int pQuantity, Float pSellingPrice, Float pBuyingPrice) {
        name = pName;
        quantity = pQuantity;
        sellingPrice = pSellingPrice;
        buyingPrice = pBuyingPrice;
    }

    public static ProductEntity from(@NonNull Product pProduct) {
        return new ProductEntity(pProduct.name(), pProduct.quantity(), pProduct.price(), pProduct.buyingPrice());
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Float getSellingPrice() {
        return sellingPrice;
    }

    public Float getBuyingPrice() {
        return buyingPrice;
    }

}