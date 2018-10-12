/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.activity.stepper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.edulytica.app.R;
import com.edulytica.app.utils.ViewAnimation;

public class StepperText extends AppCompatActivity {

    private static final int MAX_STEP = 5;
    private int current_step = 1;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepper_text);

        initToolbar();
        initComponent();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Text");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initComponent() {
        status = findViewById(R.id.status);

        findViewById(R.id.lyt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backStep(current_step);
            }
        });

        findViewById(R.id.lyt_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStep(current_step);
            }
        });

        String str_progress = String.format(getString(R.string.step_of), current_step, MAX_STEP);
        ((TextView) findViewById(R.id.tv_steps)).setText(str_progress);
        status.setText(str_progress);
    }

    private void nextStep(int progress) {
        if (progress < MAX_STEP) {
            progress++;
            current_step = progress;
            ViewAnimation.fadeOutIn(status);
        }
        String str_progress = String.format(getString(R.string.step_of), current_step, MAX_STEP);
        ((TextView) findViewById(R.id.tv_steps)).setText(str_progress);
        status.setText(str_progress);
    }

    private void backStep(int progress) {
        if (progress > 1) {
            progress--;
            current_step = progress;
            ViewAnimation.fadeOutIn(status);
        }
        String str_progress = String.format(getString(R.string.step_of), current_step, MAX_STEP);
        ((TextView) findViewById(R.id.tv_steps)).setText(str_progress);
        status.setText(str_progress);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
