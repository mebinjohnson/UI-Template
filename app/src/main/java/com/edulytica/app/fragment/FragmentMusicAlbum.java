/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.edulytica.app.R;
import com.edulytica.app.adapter.AdapterGridMusicAlbum;
import com.edulytica.app.data.DataGenerator;
import com.edulytica.app.model.MusicAlbum;
import com.edulytica.app.utils.Tools;
import com.edulytica.app.widget.SpacingItemDecoration;

import java.util.Collections;
import java.util.List;

public class FragmentMusicAlbum extends Fragment {

    public FragmentMusicAlbum() {
    }

    public static FragmentMusicAlbum newInstance() {
        FragmentMusicAlbum fragment = new FragmentMusicAlbum();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_product_grid, container, false);


        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(getActivity(), 4), true));
        recyclerView.setHasFixedSize(true);

        List<MusicAlbum> items = DataGenerator.getMusicAlbum(getActivity());
        Collections.shuffle(items);

        //set data and list adapter
        AdapterGridMusicAlbum mAdapter = new AdapterGridMusicAlbum(getActivity(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterGridMusicAlbum.OnItemClickListener() {
            @Override
            public void onItemClick(View view, MusicAlbum obj, int position) {
                Toast.makeText(getActivity(), "Item " + obj.name + " clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}