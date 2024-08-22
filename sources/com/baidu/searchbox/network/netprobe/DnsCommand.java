package com.baidu.searchbox.network.netprobe;

import com.baidu.searchbox.network.probe.DnsProbe;

public class DnsCommand extends ProbeCommand {
    static final String COMMAND_NAME_DNS = "dns";

    public String getCommandName() {
        return "dns";
    }

    /* access modifiers changed from: protected */
    public String executeCommand() {
        return new DnsProbe(getHost()).execute().toJson().toString();
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
