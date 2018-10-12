/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.activity.noitem;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.edulytica.app.R;
import com.edulytica.app.utils.Tools;

public class NoItemInternetImage extends AppCompatActivity {

    private ProgressBar progress_bar;
    private LinearLayout lyt_no_connection;
    private AppCompatButton bt_retry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_item_internet_image);
        initComponent();
        Tools.setSystemBarColor(this, android.R.color.white);
        Tools.setSystemBarLight(this);
    }

    private void initComponent() {
        progress_bar = findViewById(R.id.progress_bar);
        lyt_no_connection = findViewById(R.id.lyt_no_connection);
        bt_retry = findViewById(R.id.bt_retry);

        progress_bar.setVisibility(View.GONE);
        lyt_no_connection.setVisibility(View.VISIBLE);

        bt_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                progress_bar.setVisibility(View.VISIBLE);
                lyt_no_connection.setVisibility(View.GONE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progress_bar.setVisibility(View.GONE);
                        lyt_no_connection.setVisibility(View.VISIBLE);
                    }
                }, 1000);
            }
        });
    }
}