package com.govibs.vivaahcs.core.protocol;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Custom control protocol is a message control protocol designed to pass on information from point
 * of origin to destination. These messages are basic bean objects which contain command information
 * and essential information which needs to acted upon.
 *
 * Created by Vibhor on 12/21/16.
 */
public class ControlMessageProtocol implements Serializable {

    private AddressMessageProtocol source, destination;
    private String action, actionMetadata, apiRequest, response, statusMessage;
    private int statusCode;

    public AddressMessageProtocol getSource() {
        return source;
    }

    public void setSource(AddressMessageProtocol source) {
        this.source = source;
    }

    public AddressMessageProtocol getDestination() {
        return destination;
    }

    public void setDestination(AddressMessageProtocol destination) {
        this.destination = destination;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActionMetadata() {
        return actionMetadata;
    }

    public void setActionMetadata(String actionMetadata) {
        this.actionMetadata = actionMetadata;
    }

    public String getApiRequest() {
        return apiRequest;
    }

    public void setApiRequest(String apiRequest) {
        this.apiRequest = apiRequest;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
