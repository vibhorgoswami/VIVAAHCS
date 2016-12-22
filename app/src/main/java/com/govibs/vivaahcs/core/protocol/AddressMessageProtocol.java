package com.govibs.vivaahcs.core.protocol;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * This is the address message protocol which controls the address locations
 * Created by Vibhor on 12/21/16.
 */

public class AddressMessageProtocol implements Serializable {


    private String locationAddress;
    private String locationDescription;

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }
}
