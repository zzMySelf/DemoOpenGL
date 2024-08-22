package com.baidu.searchbox.search.webvideo.player;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/player/H5VideoPlayerBufferConfig;", "", "()V", "deviceLevelConfig", "", "getDeviceLevelConfig", "()Ljava/lang/String;", "deviceLevelConfig$delegate", "Lkotlin/Lazy;", "deviceLevelVideoBuffer", "getDeviceLevelVideoBuffer", "deviceLevelVideoBuffer$delegate", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: H5VideoPlayerBufferConfig.kt */
public final class H5VideoPlayerBufferConfig {
    public static final H5VideoPlayerBufferConfig INSTANCE = new H5VideoPlayerBufferConfig();
    private static final Lazy deviceLevelConfig$delegate = LazyKt.lazy(H5VideoPlayerBufferConfig$deviceLevelConfig$2.INSTANCE);
    private static final Lazy deviceLevelVideoBuffer$delegate = LazyKt.lazy(H5VideoPlayerBufferConfig$deviceLevelVideoBuffer$2.INSTANCE);

    private H5VideoPlayerBufferConfig() {
    }

    public final String getDeviceLevelVideoBuffer() {
        return (String) deviceLevelVideoBuffer$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getDeviceLevelConfig() {
        return (String) deviceLevelConfig$delegate.getValue();
    }
}
