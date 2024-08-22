package com.baidu.searchbox.player.remote;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.cyberplayer.sdk.remote.DuMediaRemotePlayerService;
import com.baidu.searchbox.player.remote.BDPlayerServiceProxyWrapper;

public class BDRemotePlayerService extends DuMediaRemotePlayerService {
    public IBinder onBind(Intent intent) {
        BDPlayerServiceProxyWrapper.Impl.get().onServiceBind(this, intent);
        return super.onBind(intent);
    }

    public long getPCDNNetHandle() {
        return BDPlayerServiceProxyWrapper.Impl.get().getNetHandle();
    }

    public long getKernelNetHandle() {
        return BDPlayerServiceProxyWrapper.Impl.get().getNetHandle();
    }
}
