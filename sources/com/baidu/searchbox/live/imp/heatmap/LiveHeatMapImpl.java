package com.baidu.searchbox.live.imp.heatmap;

import android.content.Context;
import android.view.MotionEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.heatmap.HeatMapHelper;
import com.baidu.searchbox.heatmap.ccs.HeatMapConfigManager;
import com.baidu.searchbox.heatmap.utils.ScreenType;
import com.baidu.searchbox.live.host2live.heatmap.ILiveHeatMapService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J8\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/live/imp/heatmap/LiveHeatMapImpl;", "Lcom/baidu/searchbox/live/host2live/heatmap/ILiveHeatMapService;", "()V", "from", "", "heatMapHelper", "Lcom/baidu/searchbox/heatmap/HeatMapHelper;", "page", "source", "deviceOrientation", "Lcom/baidu/searchbox/heatmap/utils/ScreenType;", "screenType", "", "dispatchHeatMapCollectEv", "", "event", "Landroid/view/MotionEvent;", "liveType", "roomId", "templateId", "initHeatMap", "release", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveHeatMapImpl.kt */
public final class LiveHeatMapImpl implements ILiveHeatMapService {
    private String from;
    private HeatMapHelper heatMapHelper;
    private String page;
    private String source;

    public void initHeatMap(String from2, String page2, String source2) {
        if (HeatMapConfigManager.INSTANCE.isHit(from2, page2, source2)) {
            this.from = from2;
            this.page = page2;
            this.source = source2;
            Context appContext = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
            this.heatMapHelper = new HeatMapHelper(appContext, 50);
        }
    }

    public void dispatchHeatMapCollectEv(MotionEvent event, String liveType, String roomId, String templateId, int screenType) {
        HeatMapHelper helper = this.heatMapHelper;
        if (helper != null) {
            HeatMapHelper.traceMotionEvent$default(helper, event, this.from, this.page, this.source, liveType, roomId, templateId, deviceOrientation(screenType), (String) null, (String) null, (Boolean) null, 1792, (Object) null);
        }
    }

    private final ScreenType deviceOrientation(int screenType) {
        switch (screenType) {
            case 1:
                return ScreenType.LANDSCAPE;
            case 2:
                return ScreenType.HALF_SCREEN;
            default:
                return ScreenType.PORTRAIT;
        }
    }

    public void release() {
        HeatMapHelper heatMapHelper2 = this.heatMapHelper;
        if (heatMapHelper2 != null) {
            heatMapHelper2.uploadAndClearActionList();
        }
    }
}
