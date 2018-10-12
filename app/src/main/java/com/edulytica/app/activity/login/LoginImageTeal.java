/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.activity.login;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.edulytica.app.R;
import com.edulytica.app.utils.Tools;

public class LoginImageTeal extends AppCompatActivity {

    private ProgressBar progress_bar;
    private FloatingActionButton fab;
    private View parent_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_image_teal);
        parent_view = findViewById(android.R.id.content);
        progress_bar = findViewById(R.id.progress_bar);
        fab = findViewById(R.id.fab);

        Tools.setSystemBarColor(this, R.color.cyan_800);

        findViewById(R.id.sign_up_for_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(parent_view, "Sign up for an account", Snackbar.LENGTH_SHORT).show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                searchAction();
            }
        });
    }

    private void searchAction() {
        progress_bar.setVisibility(View.VISIBLE);
        fab.setAlpha(0f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progress_bar.setVisibility(View.GONE);
                fab.setAlpha(1f);
                Snackbar.make(parent_view, "Login data submitted", Snackbar.LENGTH_SHORT).show();
            }
        }, 1000);
    }
}
