package com.govibs.vivaahcs.core.message;

/**
 * This is a factory class for creating messages
 * Created by Vibhor on 12/21/16.
 */

public final class MessageFactory {

    public enum MessageType {
        MESSAGE_TYPE_START_APP_ON_TV
    }

    private static final String ACTION_START_APP_ON_TV = "action_start_app_on_tv";

    public static VivaMessage createMessage(MessageType messageType) {

        switch (messageType) {
            case MESSAGE_TYPE_START_APP_ON_TV:
                StartAppOnTvVivaMessage startAppOnTvVivaMessage = new StartAppOnTvVivaMessage();
                startAppOnTvVivaMessage.createMessage(ACTION_START_APP_ON_TV, "YouTube", "");
                return startAppOnTvVivaMessage;

            default:
                return null;
        }
    }
}
