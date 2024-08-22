package com.baidu.netdisk.transfer.transmitter.wifisetting;

public class DisableWiFiDetection implements IWiFiDetectionSwitcher {
    private static final String TAG = "DisableWiFiDetection";

    public boolean isEnable() {
        return false;
    }
}
