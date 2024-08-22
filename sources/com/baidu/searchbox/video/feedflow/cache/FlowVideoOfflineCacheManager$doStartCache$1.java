package com.baidu.searchbox.video.feedflow.cache;

import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.video.feedflow.cache.model.FlowVideoCacheStateModel;
import com.baidu.searchbox.video.feedflow.cache.model.OfflineCacheRunTimeStatus;
import com.baidu.searchbox.video.feedflow.db.FlowVideoCacheStateDBControl;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoOfflineCacheManager.kt */
final class FlowVideoOfflineCacheManager$doStartCache$1 extends Lambda implements Function0<Unit> {
    public static final FlowVideoOfflineCacheManager$doStartCache$1 INSTANCE = new FlowVideoOfflineCacheManager$doStartCache$1();

    FlowVideoOfflineCacheManager$doStartCache$1() {
        super(0);
    }

    public final void invoke() {
        if (FlowVideoOfflineCacheManager.INSTANCE.isCacheEnabled()) {
            BdVideoLog.d(FlowVideoOfflineCacheManager.TAG, "doStartCache>>>");
            FlowVideoOfflineCacheManager.INSTANCE.updateRuntimeStatus(OfflineCacheRunTimeStatus.RUNNING);
            FlowVideoCacheStateModel nonCachedStateModel = FlowVideoCacheStateDBControl.Companion.getFlowVideoCacheStateDBControl().queryNonCachedStateModel();
            if (nonCachedStateModel != null) {
                FlowVideoOfflineCacheManager.INSTANCE.startDownloadVideo(nonCachedStateModel);
            } else {
                FlowVideoOfflineCacheManager.INSTANCE.startCache(FlowVideoOfflineCacheManager.INSTANCE.getPendingCachedData());
            }
        } else {
            VideoFlowUBCHelper.INSTANCE.uploadOfflineCacheForbidDownloadLog(FlowVideoOfflineCacheManager.cacheDownloadForbidFlag.getValue());
        }
    }
}
