package com.govibs.vivaahcs.core.protocol;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Custom control protocol is a message control protocol designed to pass on information from point
 * of origin to destination. These messages are basic bean objects which contain command information
 * and essential information which needs to acted upon.
 *
 * Created by Vibhor on 12/21/16.
 */
public class ControlMessageProtocol implements Parcelable {

    private AddressMessageProtocol source, destination;
    private String action, actionMetadata, apiRequest, response, statusMessage;
    private int statusCode;

    /**
     * Creator for creating parcel.
     */
    public static final Parcelable.Creator<ControlMessageProtocol> CREATOR =
            new Parcelable.Creator<ControlMessageProtocol>() {

                @Override
                public ControlMessageProtocol createFromParcel(Parcel in) {
                    return new ControlMessageProtocol(in);
                }

                @Override
                public ControlMessageProtocol[] newArray(int size) {
                    return new ControlMessageProtocol[size];
                }
            };

    /**
     * Parcelable constructor
     * @param in the parcel object
     */
    public ControlMessageProtocol(Parcel in) {
        this.source = in.readParcelable(AddressMessageProtocol.class.getClassLoader());
        this.destination = in.readParcelable(AddressMessageProtocol.class.getClassLoader());
        this.action = in.readString();
        this.actionMetadata = in.readString();
        this.apiRequest = in.readString();
        this.response = in.readString();
        this.statusMessage = in.readString();
        this.statusCode = in.readInt();
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(source, i);
        parcel.writeParcelable(destination, i);
        parcel.writeString(action);
        parcel.writeString(actionMetadata);
        parcel.writeString(apiRequest);
        parcel.writeString(response);
        parcel.writeString(statusMessage);
        parcel.writeInt(statusCode);
    }
}
