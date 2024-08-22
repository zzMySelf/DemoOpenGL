package com.baidu.cyberplayer.sdk;

import com.baidu.cyberplayer.sdk.DuMediaNetBase;
import java.util.List;

public final class DuMediaNet {

    public interface GetNetHandleListener extends DuMediaNetBase.GetNetHandleListener {
    }

    public interface HttpDNS extends DuMediaNetBase.HttpDNS {
    }

    public interface HttpDNS2 extends DuMediaNetBase.HttpDNS2 {
    }

    public static List<String> getIPListWithHost(String host) {
        return MediaNet.getIPListWithHost(host);
    }

    public static void preResolveHosts(List<String> hosts) {
        MediaNet.preResolveHosts(hosts);
    }

    public static void setHttpDNS2(HttpDNS2 httpDNS) {
        MediaNet.setHttpDNS2(httpDNS);
    }

    public static int getPCDNType() {
        return MediaNet.getPCDNType();
    }

    public static void setPCDNType(int pcdn) {
        MediaNet.setPCDNType(pcdn);
    }

    public static GetNetHandleListener getNetHandleListener() {
        return (GetNetHandleListener) MediaNet.getNetHandleListener();
    }

    public static void setNetHandleListener(GetNetHandleListener listener) {
        MediaNet.setNetHandleListener(listener);
    }

    public static void kernelNetInit() {
        CyberPlayerCoreInvoker.kernelNetInit();
    }

    public static void pcdnNetInit() {
        CyberPlayerCoreInvoker.pcdnNetInit();
    }

    public static void netInit() {
        CyberPlayerCoreInvoker.netInit();
    }

    public static int getNetworkRank() {
        return CyberPlayerCoreInvoker.getNetworkRank();
    }
}
