package com.baidu.searchbox.network.netprobe;

import com.baidu.searchbox.network.netcheck.NetCheckUtils;

public class HttpCommand extends ProbeCommand {
    static final String COMMAND_NAME_HTTP = "http";
    private static final int CONNECT_TIMEOUT = 30000;
    private static final int READ_TIMEOUT = 30000;

    public String getCommandName() {
        return "http";
    }

    /* access modifiers changed from: protected */
    public String executeCommand() {
        return NetCheckUtils.httpRequestCheck(getUrl(), "post".equalsIgnoreCase(getMethod()), 30000, 30000).toJson().toString();
    }

    /* access modifiers changed from: protected */
    public boolean checkParamsValid() {
        if (ensureUrlAvailable()) {
            return true;
        }
        setErrorMsg("url is invalid");
        return false;
    }
}
