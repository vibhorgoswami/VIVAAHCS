package com.govibs.vivaahcs.core.protocol;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * This is the address message protocol which controls the address locations
 * Created by Vibhor on 12/21/16.
 */

public class AddressMessageProtocol implements Serializable {


    private int locationId;
    private String locationDescription;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }
}
