package com.govibs.vivaahcs.core.message;

import com.govibs.vivaahcs.core.protocol.AddressMessageProtocol;
import com.govibs.vivaahcs.core.protocol.ControlMessageProtocol;

/**
 * Start application on TV VivaMessage
 * Created by Vibhor on 12/21/16.
 */
public class StartAppOnTvVivaMessage implements VivaMessage {

    private ControlMessageProtocol mControlMessageProtocol;
    private AddressMessageProtocol mAddressMessageProtocol;

    @Override
    public void createMessage(String action, String actionMetaData, String apiRequest) {
        mControlMessageProtocol = new ControlMessageProtocol();
        mControlMessageProtocol.setAction(action);
        mControlMessageProtocol.setActionMetadata(action);
        mControlMessageProtocol.setApiRequest(apiRequest);
        mAddressMessageProtocol = new AddressMessageProtocol();
        mAddressMessageProtocol.setLocationId(1101);
        mAddressMessageProtocol.setLocationDescription("Television");
    }


    public ControlMessageProtocol getControlMessageProtocol() {
        return mControlMessageProtocol;
    }

    public AddressMessageProtocol getAddressMessageProtocol() {
        return mAddressMessageProtocol;
    }

}
