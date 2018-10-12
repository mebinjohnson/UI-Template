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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.edulytica.app.R;
import com.edulytica.app.utils.Tools;

public class FragmentTabsStore extends Fragment {

    public FragmentTabsStore() {
    }

    public static FragmentTabsStore newInstance() {
        FragmentTabsStore fragment = new FragmentTabsStore();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tabs_store, container, false);

        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_1), R.drawable.image_8);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_2), R.drawable.image_9);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_3), R.drawable.image_15);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_4), R.drawable.image_14);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_5), R.drawable.image_12);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_6), R.drawable.image_2);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_7), R.drawable.image_5);

        return root;
    }
}