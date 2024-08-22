package com.baidu.searchbox.containers.nps.netdisk.impl;

import com.baidu.pyramid.annotation.ServiceProvider;
import com.baidu.pyramid.runtime.service.CachedServiceFetcher;
import com.baidu.searchbox.containers.nps.netdisk.face.INetdiskPluginFace;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0014¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/containers/nps/netdisk/impl/NetdiskPluginFaceServiceFetcher;", "Lcom/baidu/pyramid/runtime/service/CachedServiceFetcher;", "Lcom/baidu/searchbox/containers/nps/netdisk/face/INetdiskPluginFace;", "()V", "createService", "lib-nps-netdisk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ServiceProvider(module = "netdiskPlugin", name = "face")
/* compiled from: NetdiskPluginFaceServiceFetcher.kt */
public final class NetdiskPluginFaceServiceFetcher extends CachedServiceFetcher<INetdiskPluginFace> {
    /* access modifiers changed from: protected */
    public INetdiskPluginFace createService() {
        return new NetdiskPluginFaceImpl();
    }
}
