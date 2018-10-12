/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.activity.player;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.edulytica.app.R;
import com.edulytica.app.utils.Tools;

public class PlayerMusicGenre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_music_genre);
        Tools.setSystemBarColor(this, R.color.indigo_600);
    }

    public void genreClick(View view) {
        if (view instanceof Button) {
            Button b = (Button) view;
            b.setSelected(!b.isSelected());
        }
    }
}
