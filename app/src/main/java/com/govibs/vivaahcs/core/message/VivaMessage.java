package com.govibs.vivaahcs.core.message;

import com.govibs.vivaahcs.core.protocol.AddressMessageProtocol;
import com.govibs.vivaahcs.core.protocol.ControlMessageProtocol;

/**
 * The message base class provides abstract level access for messages to be created.
 * Created by Vibhor on 12/21/16.
 */

public interface VivaMessage {

    void createMessage(String action, String actionMetaData, String apiRequest);

    ControlMessageProtocol getControlMessageProtocol();
}
