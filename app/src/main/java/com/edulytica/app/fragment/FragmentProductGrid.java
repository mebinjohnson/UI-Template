/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.edulytica.app.R;
import com.edulytica.app.adapter.AdapterGridShopProductCard;
import com.edulytica.app.data.DataGenerator;
import com.edulytica.app.model.ShopProduct;
import com.edulytica.app.utils.Tools;
import com.edulytica.app.widget.SpacingItemDecoration;

import java.util.Collections;
import java.util.List;

public class FragmentProductGrid extends Fragment {

    public FragmentProductGrid() {
    }

    public static FragmentProductGrid newInstance() {
        FragmentProductGrid fragment = new FragmentProductGrid();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_product_grid, container, false);


        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(getActivity(), 8), true));
        recyclerView.setHasFixedSize(true);

        List<ShopProduct> items = DataGenerator.getShoppingProduct(getActivity());
        Collections.shuffle(items);

        //set data and list adapter
        AdapterGridShopProductCard mAdapter = new AdapterGridShopProductCard(getActivity(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterGridShopProductCard.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ShopProduct obj, int position) {
                Snackbar.make(root, "Item " + obj.title + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

        mAdapter.setOnMoreButtonClickListener(new AdapterGridShopProductCard.OnMoreButtonClickListener() {
            @Override
            public void onItemClick(View view, ShopProduct obj, MenuItem item) {
                Snackbar.make(root, obj.title + " (" + item.getTitle() + ") clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}