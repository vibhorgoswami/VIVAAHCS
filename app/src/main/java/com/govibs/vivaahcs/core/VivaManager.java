package com.govibs.vivaahcs.core;

/**
 * VIVA - AHCS monitor
 * Created by Vibhor on 12/21/16.
 */

public class VivaManager {

    private static final VivaManager ourInstance = new VivaManager();

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
    }

}
