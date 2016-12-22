package com.govibs.vivaahcs.core.protocol;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This is the address message protocol which controls the address locations
 * Created by Vibhor on 12/21/16.
 */

public class AddressMessageProtocol implements Parcelable {


    private int locationId;
    private String locationDescription;

    public AddressMessageProtocol(Parcel in) {
        this.locationId = in.readInt();
        this.locationDescription = in.readString();
    }

    /**
     * Creator for address message protocol
     */
    public static final Parcelable.Creator<AddressMessageProtocol> CREATOR =
            new Parcelable.Creator<AddressMessageProtocol>() {

                @Override
                public AddressMessageProtocol createFromParcel(Parcel in) {
                    return new AddressMessageProtocol(in);
                }

                @Override
                public AddressMessageProtocol[] newArray(int size) {
                    return new AddressMessageProtocol[size];
                }
            };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(locationId);
        parcel.writeString(locationDescription);
    }
}
