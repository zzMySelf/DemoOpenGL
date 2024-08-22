package com.baidu.searchbox.video.feedflow.cache.iml;

import com.baidu.searchbox.export.IFlowVideoDiskCacheCleanService;
import com.baidu.searchbox.video.feedflow.cache.FlowVideoOfflineCacheManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/cache/iml/FlowVideoDiskCacheCleanServiceImpl;", "Lcom/baidu/searchbox/export/IFlowVideoDiskCacheCleanService;", "()V", "onClean", "", "onManualClean", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoDiskCacheCleanServiceImpl.kt */
public final class FlowVideoDiskCacheCleanServiceImpl implements IFlowVideoDiskCacheCleanService {
    public void onClean() {
        FlowVideoOfflineCacheManager.INSTANCE.updateClearCacheTime();
        FlowVideoOfflineCacheManager.clearAllCache$default(FlowVideoOfflineCacheManager.INSTANCE, false, 1, (Object) null);
    }

    public void onManualClean() {
        FlowVideoOfflineCacheManager.INSTANCE.onManualForceClean();
    }
}
