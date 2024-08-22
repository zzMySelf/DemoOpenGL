package com.baidu.helios.bridge.multiprocess.providers.defaultproc;

import com.baidu.helios.bridge.multiprocess.BaseIPCProvider;

public class DefaultIPCProvider extends BaseIPCProvider {
    public String getAuthoritySuffix() {
        return ".helios.ipc.default";
    }
}
