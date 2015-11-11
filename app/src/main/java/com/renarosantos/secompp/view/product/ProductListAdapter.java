package com.renarosantos.secompp.view.product;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.renarosantos.secompp.R;
import com.renarosantos.secompp.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renarosantos on 26/10/15.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    ArrayList<Product> mProducts = new ArrayList<>();


    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Product product = mProducts.get(position);
        if (product != null) {
            holder.populate(product, position);
        }
    }

    @Override
    public int getItemCount() {
        return mProducts != null ? mProducts.size() : 0;
    }

    public void setList(List<Product> list) {
        mProducts.clear();
        mProducts.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;
        private TextView mProductName;
        private TextView mProductPrice;
        private View mRoot;
        private int mPosition;

        public ViewHolder(View root) {
            super(root);
            mImage = (ImageView) root.findViewById(R.id.product_photo);
            mProductPrice = (TextView) root.findViewById(R.id.product_price);
            mProductName = (TextView) root.findViewById(R.id.product_name);
            mRoot = root;
            mRoot.setOnClickListener(new ItemClick());

        }


        public void populate(final Product product, final int position) {
            mProductName.setText(product.name());
            mProductPrice.setText("PREÇO : R$ " + product.price());
            Glide.with(mRoot.getContext()).load(product.mPhoto).into(mImage);
            mPosition = position;

        }

        private class ItemClick implements View.OnClickListener {

            @Override
            public void onClick(final View v) {
                mProducts.remove(mPosition);
                notifyItemRemoved(mPosition);
                notifyItemRangeChanged(mPosition, mProducts.size());
            }
        }
    }
}
