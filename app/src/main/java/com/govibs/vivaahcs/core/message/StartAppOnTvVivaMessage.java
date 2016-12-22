package com.govibs.vivaahcs.core.message;

import com.govibs.vivaahcs.core.protocol.AddressMessageProtocol;
import com.govibs.vivaahcs.core.protocol.ControlMessageProtocol;

/**
 * Start application on TV VivaMessage
 * Created by Vibhor on 12/21/16.
 */
public class StartAppOnTvVivaMessage implements VivaMessage {

    private ControlMessageProtocol mControlMessageProtocol;

    @Override
    public void createMessage(String action, String actionMetaData, String apiRequest) {
        mControlMessageProtocol = new ControlMessageProtocol();
        mControlMessageProtocol.setAction(action);
        mControlMessageProtocol.setActionMetadata(action);
        mControlMessageProtocol.setApiRequest(apiRequest);
        AddressMessageProtocol mAddressMessageProtocolSource = new AddressMessageProtocol();
        mAddressMessageProtocolSource.setLocationAddress("");
        mAddressMessageProtocolSource.setLocationDescription("Phone");
        AddressMessageProtocol mAddressMessageProtocolDestination = new AddressMessageProtocol();
        mAddressMessageProtocolSource.setLocationAddress("");
        mAddressMessageProtocolSource.setLocationDescription("Television");
        mControlMessageProtocol.setSource(mAddressMessageProtocolSource);
        mControlMessageProtocol.setDestination(mAddressMessageProtocolDestination);
    }

    @Override
    public ControlMessageProtocol getControlMessageProtocol() {
        return mControlMessageProtocol;
    }

}
