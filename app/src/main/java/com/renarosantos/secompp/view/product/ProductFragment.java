package com.renarosantos.secompp.view.product;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.renarosantos.secompp.DAO.ProductDAO;
import com.renarosantos.secompp.R;
import com.renarosantos.secompp.business.product.ProductBO;
import com.renarosantos.secompp.model.Product;
import com.renarosantos.secompp.presenter.ProductPresenter;

import java.util.List;

/**
 * Created by renarosantos on 26/10/15.
 */
public class ProductFragment extends Fragment implements View.OnClickListener, ProductView {


    private EditText mProductQuantity;
    private Button mSearchButton;
    private RecyclerView mRecyclerView;
    private ProductListAdapter mAdapter;
    private ProductPresenter mPresenter;
    private ProgressDialog mProgress;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.product_fragment, container, false);
        mProductQuantity = (EditText) v.findViewById(R.id.product_quantity);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.product_list);
        mSearchButton = (Button) v.findViewById(R.id.buscar);
        mAdapter = new ProductListAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSearchButton.setOnClickListener(this);
        return v;

    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter = new ProductPresenter(this, new ProductBO( new ProductDAO()));


    }

    @Override
    public void onClick(final View v) {
        if(mPresenter != null){
            mPresenter.fetchProducts();
        }

    }

    @NonNull
    @Override
    public String getQuantityValue() {
        String value = mProductQuantity.getText().toString();
        return value;
    }

    @Override
    public void showLoading() {
        mProgress = ProgressDialog.show(getActivity(), getString(R.string.loading),
                getString(R.string.please_wait), true);
    }

    @Override
    public void hideLoading() {
        if (mProgress != null) {
            mProgress.dismiss();
        }

    }

    @Override
    public void populateList(@NonNull final List<Product> list) {
        mAdapter.setList(list);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(), "Houve um erro. Verifique as entradas", Toast.LENGTH_LONG).show();

    }
}
