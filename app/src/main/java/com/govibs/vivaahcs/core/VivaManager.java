package com.govibs.vivaahcs.core;

import com.govibs.vivaahcs.core.message.MessageFactory;
import com.govibs.vivaahcs.core.message.StartAppOnTvVivaMessage;
import com.govibs.vivaahcs.core.message.VivaMessage;

/**
 * VIVA - AHCS monitor
 * Created by Vibhor on 12/21/16.
 */

public class VivaManager {

    /**
     * Initialize State
     */
    public enum InitState {
        INIT_STATE_INITIALIZED,
        INIT_STATE_INITIALIZING,
        INIT_STATE_NOT_INITIALIZED
    }

    private static final VivaManager ourInstance = new VivaManager();
    private static InitState mInitState;

    public static VivaManager getInstance() {
        return ourInstance;
    }

    /**
     * Private constructor for singleton
     */
    private VivaManager() {
    }


    public void initialize() {
        // Check all connections and see if all systems are up.
        if (!isInitialized()) {
            setInitState(InitState.INIT_STATE_INITIALIZING);

        }
    }

    /**
     * Send Command
     * @param commandType {@link CommandType}
     */
    public void sendCommand(CommandType commandType) {
        switch (commandType) {
            case COMMAND_TYPE_START_APPLICATION_ON_TV:
                if (isInitialized()) {
                    VivaMessage vivaMessage = MessageFactory.createMessage(
                                    MessageFactory.MessageType.MESSAGE_TYPE_START_APP_ON_TV);
                }
                break;
        }
    }

    /**
     * Returns True if the manager is initialized or initializing
     * @return True if initialized or initializing, False otherwise
     */
    protected boolean isInitialized() {
        return mInitState != InitState.INIT_STATE_NOT_INITIALIZED;
    }

    /**
     * Set Initialization state
     * @param initState initialize state {@link InitState}
     */
    protected void setInitState(InitState initState) {
        mInitState = initState;
    }

    /**
     * Get initialization state
     * @return InitState
     */
    protected InitState getInitState() {
        return mInitState;
    }

}
