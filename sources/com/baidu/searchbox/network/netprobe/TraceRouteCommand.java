package com.baidu.searchbox.network.netprobe;

import com.baidu.searchbox.network.traceroute.TraceRoute;

public class TraceRouteCommand extends ProbeCommand {
    protected static final String TRACEROUTE_COMMAND_NAME = "traceroute";

    public String getCommandName() {
        return TRACEROUTE_COMMAND_NAME;
    }

    public String executeCommand() {
        if (ensureHostAvailable()) {
            return TraceRoute.trace(getHost());
        }
        setErrorMsg("host is invalid");
        return "";
    }

    /* access modifiers changed from: protected */
    public boolean checkParamsValid() {
        if (ensureHostAvailable()) {
            return true;
        }
        setErrorMsg("host is invalid");
        return false;
    }
}
