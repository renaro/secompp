package com.renarosantos.secompp.view.product;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renarosantos.secompp.DAO.ProductDAO;
import com.renarosantos.secompp.R;
import com.renarosantos.secompp.business.product.ProductBO;
import com.renarosantos.secompp.model.Product;
import com.renarosantos.secompp.presenter.ProductListPresenter;

import java.util.List;

/**
 * Created by renarosantos on 26/10/15.
 */
public class ProductListFragment extends Fragment implements ListProductView {
    private View mAddButton;
    private ProductListPresenter mPresenter;
    private ProgressDialog mProgress;
    private RecyclerView mRecyclerView;
    private ProductListAdapter mAdapter;
    private CoordinatorLayout mCoordinatorLayout;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.product_list_fragment, container, false);
        mAddButton = v.findViewById(R.id.add_products);
        mAddButton.setOnClickListener(new OnAddProductClicked());
        mRecyclerView = (RecyclerView) v.findViewById(R.id.product_list);
        mAdapter = new ProductListAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCoordinatorLayout = (CoordinatorLayout) v.findViewById(R.id.coordinator_layout);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter = new ProductListPresenter(this, new ProductBO(new ProductDAO()));
        mPresenter.fetchProducts();

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
    public void showEmptyList() {

    }

    @Override
    public void showError() {
        Snackbar.make(mCoordinatorLayout, "Houve um erro ao salvar o produto", Snackbar.LENGTH_LONG).show();
    }

    private class OnAddProductClicked implements View.OnClickListener {
        @Override
        public void onClick(final View v) {
            startActivity(AddProductActivity.createIntent(getActivity()));
        }
    }

}
