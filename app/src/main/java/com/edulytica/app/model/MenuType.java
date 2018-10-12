/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.model;


/**
 * Menu type for MainMenu.java
 */
public enum MenuType {

    NORMAL(1001), HEADER(1002), SUB_HEADER(1003), DIVIDER(1004);

    private final int value;

    MenuType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
