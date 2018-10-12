/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edulytica.app.R;
import com.edulytica.app.model.ShopCategory;

import java.util.ArrayList;
import java.util.List;

public class AdapterListShopCategory extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ShopCategory> items = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public AdapterListShopCategory(Context context, List<ShopCategory> items) {
        this.items = items;
        ctx = context;
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop_category, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            ShopCategory p = items.get(position);
            view.title.setText(p.title);
            view.brief.setText(p.brief);
            view.image.setImageResource(p.image);
            view.lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, items.get(position), position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, ShopCategory obj, int position);
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView brief;
        public View lyt_parent;

        public OriginalViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.image);
            title = v.findViewById(R.id.title);
            brief = v.findViewById(R.id.brief);
            lyt_parent = v.findViewById(R.id.lyt_parent);
        }
    }

}