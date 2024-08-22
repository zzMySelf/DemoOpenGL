package com.baidu.nadcore.cmd.runtime;

import com.baidu.pyramid.runtime.service.ServiceManager;

public class CmdRuntime {
    public static final String DEFAULT_HEAD = "nadcorevendor://";
    private static ICmdContext sCmdContextRef = null;

    public static ICmdContext hostRouter() {
        if (sCmdContextRef == null) {
            synchronized (CmdRuntime.class) {
                if (sCmdContextRef == null) {
                    sCmdContextRef = (ICmdContext) ServiceManager.getService(ICmdContext.SERVICE_REFERENCE);
                }
                if (sCmdContextRef == null) {
                    sCmdContextRef = ICmdContext.EMPTY;
                }
            }
        }
        return sCmdContextRef;
    }
}
