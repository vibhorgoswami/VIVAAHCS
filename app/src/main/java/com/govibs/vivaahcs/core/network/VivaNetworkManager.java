package com.govibs.vivaahcs.core.network;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;

import com.govibs.vivaahcs.core.message.StartAppOnTvVivaMessage;
import com.govibs.vivaahcs.core.message.VivaMessage;
import com.govibs.vivaahcs.core.protocol.ControlMessageProtocol;

/**
 * VIVA Network Manager
 * Created by Vibhor on 12/21/16.
 */
public class VivaNetworkManager {

    private static VivaNetworkManager mVivaNetworkManager;

    private Context mContext;
    /**
     * WiFi P2P Manager
     */
    private WifiP2pManager mWifiP2PManager;
    private WifiP2pManager.Channel mChannel;
    private VivaNetworkBroadcastReceiver mReceiver;
    private NetworkPeerListener mNetworkPeerListener = new NetworkPeerListener();
    private IntentFilter mIntentFilter;
    private WifiP2pDeviceList mWifiP2pDeviceList;

    public static synchronized VivaNetworkManager getInstance(Context context) {
        if (mVivaNetworkManager == null) {
            mVivaNetworkManager = new VivaNetworkManager(context);
        }
        return mVivaNetworkManager;
    }

    /**
     * Send message over network
     * @param vivaMessage {@link VivaMessage} linked to be passed.
     */
    public void sendMessage(VivaMessage vivaMessage) {
        if (vivaMessage != null) {
            ControlMessageProtocol controlMessageProtocol = vivaMessage.getControlMessageProtocol();
            connect(controlMessageProtocol.getDestination().getLocationAddress());
        }
    }

    /**
     * Class for receiving network peers.
     */
    private class NetworkPeerListener implements WifiP2pManager.PeerListListener {

        @Override
        public void onPeersAvailable(WifiP2pDeviceList wifiP2pDeviceList) {
            mWifiP2pDeviceList = wifiP2pDeviceList;
        }
    }

    /**
     * VIVA Network Manager
     * @param context the calling application context
     */
    private VivaNetworkManager(Context context) {
        mContext = context.getApplicationContext();
        mWifiP2PManager = (WifiP2pManager) mContext.getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mWifiP2PManager.initialize(context, mContext.getMainLooper(), null);
        mReceiver = new VivaNetworkBroadcastReceiver(mWifiP2PManager, mChannel, this);
        initIntentFilters();
        switchBroadcastReceiver(true);
        discoverPeers();
    }

    /**
     * Init Intent filters
     */
    private void initIntentFilters() {
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
    }

    /**
     * Switch the broadcast receiver on or off.
     * @param initFlag True if it has to be initialized, False otherwise
     */
    private void switchBroadcastReceiver(boolean initFlag) {
        if (initFlag) {
            mContext.registerReceiver(mReceiver, mIntentFilter);
        } else {
            mContext.unregisterReceiver(mReceiver);
        }
    }

    /**
     * Discover Peers
     */
    private void discoverPeers() {
        mWifiP2PManager.discoverPeers(mChannel, null);
    }

    /**
     * Connect to a specific device.
     * @param deviceAddress device address (MAC).
     */
    private void connect(String deviceAddress) {
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = deviceAddress;
        mWifiP2PManager.connect(mChannel, config, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                //success logic.

            }

            @Override
            public void onFailure(int reason) {
                //failure logic
            }
        });
    }

    /**
     * Disconnect from the specific device
     * @param deviceAddress device address (MAC).
     */
    private void disconnect(String deviceAddress) {

    }

    protected NetworkPeerListener getNetworkPeerListener() {
        return mNetworkPeerListener;
    }

}
