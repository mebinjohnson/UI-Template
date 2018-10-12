/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.model;

import android.graphics.drawable.Drawable;

public class Social {

    public int image;
    public Drawable imageDrw;
    public String name;
    public boolean expanded = false;
    public boolean parent = false;

    // flag when item swiped
    public boolean swiped = false;

    public Social() {
    }

    public Social(int image, String name) {
        this.image = image;
        this.name = name;
    }
}
