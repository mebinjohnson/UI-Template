/*
 * Copyright (c) 2018. Netsaps Technologies Pvt Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Last updated by Habel Philip <habel@netsaps.com>, 1/5/18 4:45 PM
 *
 */

package com.edulytica.app.model;

import java.io.Serializable;

public class Event implements Serializable {

    public String email;
    public String name;
    public String location;
    public String from;
    public String to;
    public Boolean is_allday;
    public String timezone;

}
