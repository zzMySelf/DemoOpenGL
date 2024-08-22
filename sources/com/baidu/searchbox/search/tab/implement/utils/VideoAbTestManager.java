package com.baidu.searchbox.search.tab.implement.utils;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.abtest.ioc.AbTestService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\t\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\f\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\f\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/utils/VideoAbTestManager;", "", "()V", "abTest", "Lcom/baidu/searchbox/abtest/ioc/AbTestService;", "isVideoAFocusCompatible", "", "()Z", "isVideoAFocusCompatible$delegate", "Lkotlin/Lazy;", "isVideoAPreTaskSwitchOpen", "isVideoAPreTaskSwitchOpen$delegate", "isVideoBUpdateSwitchOpen", "isVideoBUpdateSwitchOpen$delegate", "isVideoDragSeekOpen", "isVideoDragSeekOpen$delegate", "isVideoFocusCompatible", "isVideoFocusCompatible$delegate", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoAbTestManager.kt */
public final class VideoAbTestManager {
    public static final VideoAbTestManager INSTANCE = new VideoAbTestManager();
    /* access modifiers changed from: private */
    public static final AbTestService abTest = ((AbTestService) ServiceManager.getService(AbTestService.SERVICE_REFERENCE));
    private static final Lazy isVideoAFocusCompatible$delegate = LazyKt.lazy(VideoAbTestManager$isVideoAFocusCompatible$2.INSTANCE);
    private static final Lazy isVideoAPreTaskSwitchOpen$delegate = LazyKt.lazy(VideoAbTestManager$isVideoAPreTaskSwitchOpen$2.INSTANCE);
    private static final Lazy isVideoBUpdateSwitchOpen$delegate = LazyKt.lazy(VideoAbTestManager$isVideoBUpdateSwitchOpen$2.INSTANCE);
    private static final Lazy isVideoDragSeekOpen$delegate = LazyKt.lazy(VideoAbTestManager$isVideoDragSeekOpen$2.INSTANCE);
    private static final Lazy isVideoFocusCompatible$delegate = LazyKt.lazy(VideoAbTestManager$isVideoFocusCompatible$2.INSTANCE);

    private VideoAbTestManager() {
    }

    public final boolean isVideoFocusCompatible() {
        return ((Boolean) isVideoFocusCompatible$delegate.getValue()).booleanValue();
    }

    public final boolean isVideoAFocusCompatible() {
        return ((Boolean) isVideoAFocusCompatible$delegate.getValue()).booleanValue();
    }

    public final boolean isVideoDragSeekOpen() {
        return ((Boolean) isVideoDragSeekOpen$delegate.getValue()).booleanValue();
    }

    public final boolean isVideoAPreTaskSwitchOpen() {
        return ((Boolean) isVideoAPreTaskSwitchOpen$delegate.getValue()).booleanValue();
    }

    public final boolean isVideoBUpdateSwitchOpen() {
        return ((Boolean) isVideoBUpdateSwitchOpen$delegate.getValue()).booleanValue();
    }
}
