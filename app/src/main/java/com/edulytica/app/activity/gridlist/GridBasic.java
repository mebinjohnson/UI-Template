/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.activity.gridlist;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.edulytica.app.R;
import com.edulytica.app.adapter.AdapterGridBasic;
import com.edulytica.app.data.DataGenerator;
import com.edulytica.app.utils.Tools;
import com.edulytica.app.widget.SpacingItemDecoration;

import java.util.List;

public class GridBasic extends AppCompatActivity {

    private View parent_view;

    private RecyclerView recyclerView;
    private AdapterGridBasic mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_basic);
        parent_view = findViewById(android.R.id.content);

        initToolbar();
        initComponent();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Basic");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initComponent() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new SpacingItemDecoration(3, Tools.dpToPx(this, 2), true));
        recyclerView.setHasFixedSize(true);

        List<Integer> items = DataGenerator.getNatureImages(this);
        items.addAll(DataGenerator.getNatureImages(this));
        items.addAll(DataGenerator.getNatureImages(this));
        items.addAll(DataGenerator.getNatureImages(this));

        //set data and list adapter
        mAdapter = new AdapterGridBasic(this, items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterGridBasic.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Integer obj, int position) {
                Snackbar.make(parent_view, "Item " + position + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

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
