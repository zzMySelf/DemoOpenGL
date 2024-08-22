package com.baidu.searchbox.video.detail.export;

import com.baidu.searchbox.video.detail.dependency.impl.live.VideoLiveServiceImpl_Factory;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/detail/export/IVideoLiveService;", "", "getLivePluginVersions", "", "Lkotlin/Pair;", "", "Companion", "Impl", "lib-dependency_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IVideoLiveService.kt */
public interface IVideoLiveService {
    public static final Companion Companion = Companion.$$INSTANCE;

    List<Pair<String, String>> getLivePluginVersions();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/detail/export/IVideoLiveService$Impl;", "", "()V", "get", "Lcom/baidu/searchbox/video/detail/export/IVideoLiveService;", "lib-dependency_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IVideoLiveService.kt */
    public static final class Impl {
        public static final Impl INSTANCE = new Impl();

        private Impl() {
        }

        public final IVideoLiveService get() {
            return VideoLiveServiceImpl_Factory.get();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/detail/export/IVideoLiveService$Companion;", "", "()V", "EMPTY", "Lcom/baidu/searchbox/video/detail/export/IVideoLiveService;", "getEMPTY", "()Lcom/baidu/searchbox/video/detail/export/IVideoLiveService;", "lib-dependency_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IVideoLiveService.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IVideoLiveService EMPTY = new IVideoLiveService$Companion$EMPTY$1();

        private Companion() {
        }

        public final IVideoLiveService getEMPTY() {
            return EMPTY;
        }
    }
}
