/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.activity.progressactivity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.edulytica.app.R;
import com.edulytica.app.adapter.AdapterListFolderFile;
import com.edulytica.app.model.FolderFile;
import com.edulytica.app.utils.ItemAnimation;
import com.edulytica.app.utils.Tools;
import com.edulytica.app.utils.ViewAnimation;

import java.util.ArrayList;
import java.util.List;

public class ProgressDotsBounce extends AppCompatActivity {

    private final static int LOADING_DURATION = 3500;
    private View parent_view;
    private RecyclerView recyclerView;
    private AdapterListFolderFile mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dots_bounce);
        parent_view = findViewById(android.R.id.content);
        recyclerView = findViewById(R.id.recyclerView);

        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.pink_600);

        loadingAndDisplayContent();
    }

    private void loadingAndDisplayContent() {
        final LinearLayout lyt_progress = findViewById(R.id.lyt_progress);
        lyt_progress.setVisibility(View.VISIBLE);
        lyt_progress.setAlpha(1.0f);
        recyclerView.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewAnimation.fadeOut(lyt_progress);
            }
        }, LOADING_DURATION);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initComponent();
            }
        }, LOADING_DURATION + 400);
    }

    private void initComponent() {
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        List<FolderFile> items = new ArrayList<>();

        items.add(new FolderFile("Folders", true));  // add section

        items.add(new FolderFile("Photos", "Jan 9, 2014", R.drawable.ic_folder, true));
        items.add(new FolderFile("Recipes", "Jan 17, 2014", R.drawable.ic_folder, true));
        items.add(new FolderFile("Work", "Jan 28, 2014", R.drawable.ic_folder, true));

        items.add(new FolderFile("Files", true));   // add section

        items.add(new FolderFile("Vacation itinerary", "Jan 20, 2014", R.drawable.ic_insert_drive, false));
        items.add(new FolderFile("Kitchen Remodel", "Jan 10, 2014", R.drawable.ic_insert_drive, false));
        items.add(new FolderFile("To Do Note", "Des 25, 2013", R.drawable.ic_insert_drive, false));

        items.add(new FolderFile("", true));   // add section

        //set data and list adapter
        mAdapter = new AdapterListFolderFile(this, items, ItemAnimation.FADE_IN);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterListFolderFile.OnItemClickListener() {
            @Override
            public void onItemClick(View view, FolderFile obj, int position) {
                Snackbar.make(parent_view, "Item " + obj.name + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_refresh_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else if (item.getItemId() == R.id.action_refresh) {
            loadingAndDisplayContent();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
