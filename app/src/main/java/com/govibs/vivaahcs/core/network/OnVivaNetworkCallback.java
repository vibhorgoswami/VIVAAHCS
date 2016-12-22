package com.govibs.vivaahcs.core.network;

/**
 * This is the callback interface for receiving Network calls.
 * Created by Vibhor on 12/22/16.
 */

public interface OnVivaNetworkCallback {
    /**
     * The message was delivered successfully.
     */
    void onSuccess();

    /**
     * The message was not delivered.
     */
    void onFailed();
}
