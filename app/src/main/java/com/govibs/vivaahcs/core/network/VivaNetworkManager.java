package com.govibs.vivaahcs.core.network;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;

import com.govibs.vivaahcs.core.message.VivaMessage;

/**
 * VIVA Network Manager
 * Created by Vibhor on 12/21/16.
 */
public class VivaNetworkManager {

    /**
     * WiFi P2P Manager
     */
    private WifiP2pManager mWifiP2PManager;

    private WifiP2pManager.Channel mChannel;

    /**
     * VIVA Network Manager
     * @param context the calling application context
     */
    public VivaNetworkManager(Context context) {
        mWifiP2PManager = (WifiP2pManager) context.getApplicationContext().getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mWifiP2PManager.initialize(context, context.getApplicationContext().getMainLooper(), null);
    }

    /**
     * Send message over network
     * @param vivaMessage
     */
    public void sendMessage(VivaMessage vivaMessage) {
        
    }

}
