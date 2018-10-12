/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.model;

public class SectionImage {
    public int image;
    public String title;
    public boolean section = false;

    public SectionImage() {
    }

    public SectionImage(int image, String title, boolean section) {
        this.image = image;
        this.title = title;
        this.section = section;
    }
}
