package com.baidu.searchbox.live.imp;

import com.baidu.searchbox.live.imp.net.BdNetworkImpl;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.service.NetworkAgentService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/imp/NetworkAgentServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/NetworkAgentService;", "()V", "buildNetworkInstance", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkAgentServiceImpl.kt */
public final class NetworkAgentServiceImpl implements NetworkAgentService {
    public INetWork buildNetworkInstance() {
        return new BdNetworkImpl();
    }
}
