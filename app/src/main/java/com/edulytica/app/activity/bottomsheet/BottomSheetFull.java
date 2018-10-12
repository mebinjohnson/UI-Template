/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.activity.bottomsheet;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.edulytica.app.R;
import com.edulytica.app.adapter.AdapterPeopleLeft;
import com.edulytica.app.data.DataGenerator;
import com.edulytica.app.fragment.FragmentBottomSheetDialogFull;
import com.edulytica.app.model.People;
import com.edulytica.app.utils.Tools;

public class BottomSheetFull extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterPeopleLeft adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_full);

        initComponent();
        initToolbar();
        Toast.makeText(this, "Swipe up bottom sheet", Toast.LENGTH_SHORT).show();
    }

    private void initComponent() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //set data and list adapter
        adapter = new AdapterPeopleLeft(this, DataGenerator.getPeopleData(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new AdapterPeopleLeft.OnItemClickListener() {
            @Override
            public void onItemClick(View view, People obj, int pos) {
                FragmentBottomSheetDialogFull fragment = new FragmentBottomSheetDialogFull();
                fragment.setPeople(obj);
                fragment.show(getSupportFragmentManager(), "dialog");
            }
        });

        // display first sheet
        FragmentBottomSheetDialogFull fragment = new FragmentBottomSheetDialogFull();
        fragment.setPeople(adapter.getItem(0));
        fragment.show(getSupportFragmentManager(), "dialog");
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Full");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_basic, menu);
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
