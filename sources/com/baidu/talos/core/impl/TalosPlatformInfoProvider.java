package com.baidu.talos.core.impl;

import com.baidu.talos.ITalosPlatformInfoProvider;
import com.baidu.talos.core.BuildConfig;

public class TalosPlatformInfoProvider implements ITalosPlatformInfoProvider {
    public String getTalosFrameVersion() {
        return BuildConfig.TALOS_FRAME_VERSION;
    }
}
