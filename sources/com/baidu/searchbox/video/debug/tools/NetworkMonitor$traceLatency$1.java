package com.baidu.searchbox.video.debug.tools;

import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/video/debug/tools/NetworkMonitor$traceLatency$1", "Ljava/util/TimerTask;", "run", "", "video-debug_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkMonitor.kt */
public final class NetworkMonitor$traceLatency$1 extends TimerTask {
    NetworkMonitor$traceLatency$1() {
    }

    public void run() {
        NetworkMonitor networkMonitor = NetworkMonitor.INSTANCE;
        NetworkMonitor.lastLatency = NetworkMonitor.INSTANCE.networkLatency2();
    }
}
