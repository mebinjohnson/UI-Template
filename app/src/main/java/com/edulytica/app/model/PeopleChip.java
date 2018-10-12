/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.model;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.pchmn.materialchips.model.ChipInterface;

public class PeopleChip implements ChipInterface {

    private String id;
    private Drawable image;
    private String name;
    private String info;

    public PeopleChip(String id, Drawable image, String name, String info) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.info = info;
    }

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public Uri getAvatarUri() {
        return null;
    }

    @Override
    public Drawable getAvatarDrawable() {
        return image;
    }

    @Override
    public String getLabel() {
        return name;
    }

    @Override
    public String getInfo() {
        return info;
    }
}