package com.renarosantos.secompp.view.product;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.renarosantos.secompp.DAO.ProductDAO;
import com.renarosantos.secompp.R;
import com.renarosantos.secompp.business.product.ProductBO;
import com.renarosantos.secompp.presenter.AddProductPresenter;

/**
 * Created by renarosantos on 28/10/15.
 */
public class AddProductActivity extends AppCompatActivity implements AddProductView {


    private View mAddButton;
    private EditText mProductName;
    private EditText mProductPrice;
    private EditText mProductAmount;
    private EditText mProductBuyingPrice;
    private CoordinatorLayout mCoordinatorLayout;
    private AddProductPresenter mPresenter;
    private ProgressDialog mProgress;


    public static final Intent createIntent(Context context){
        return new Intent(context,AddProductActivity.class);
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product_fragment);
        mProductName = (EditText) findViewById(R.id.name);
        mProductPrice = (EditText) findViewById(R.id.selling_price);
        mProductAmount = (EditText) findViewById(R.id.amount);
        mProductBuyingPrice = (EditText) findViewById(R.id.buying_price);
        mAddButton = findViewById(R.id.button_add_product);
        mAddButton.setOnClickListener(new OnAddProductClicked());
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter = new AddProductPresenter(this, new ProductBO(new ProductDAO()));
    }


    @Override
    public void onAddProductSuccess() {
        Snackbar.make(mCoordinatorLayout, "Produto adicionado com sucesso!", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onRegisterFailed() {
        Snackbar.make(mCoordinatorLayout, "Erro! Nao esqueca o nome do produto!", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        mProgress = ProgressDialog.show(AddProductActivity.this, getString(R.string.loading),
                getString(R.string.please_wait), true);
    }

    @Override
    public void hideLoading() {
        if (mProgress != null) {
            mProgress.dismiss();
        }

    }

    @Override
    public void clearInputs() {
        mProductName.setText("");
        mProductPrice.setText("");
        mProductAmount.setText("");
        mProductBuyingPrice.setText("");
    }

    @Override
    public String getProductName() {
        return mProductName.getText().toString();
    }

    @Override
    public String getProductPrice() {
        return mProductPrice.getText().toString();
    }

    @Override
    public String getProductQuantity() {
        return mProductAmount.getText().toString();
    }

    @Override
    public String getProductBuyingPrice() {
        return mProductBuyingPrice.getText().toString();
    }



    private class OnAddProductClicked implements View.OnClickListener {
        @Override
        public void onClick(final View v) {
            mPresenter.onAddProductRequest();
        }
    }
}
