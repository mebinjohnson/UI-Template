/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.model;

import android.graphics.drawable.Drawable;

public class FolderFile {

    public int image;
    public Drawable imageDrw;
    public String name;
    public String date;
    public boolean section = false;
    public boolean folder = true;

    public FolderFile() {
    }

    public FolderFile(String name, String date, int image, boolean folder) {
        this.image = image;
        this.name = name;
        this.date = date;
        this.folder = folder;
    }

    public FolderFile(String name, boolean section) {
        this.name = name;
        this.section = section;
    }

}
