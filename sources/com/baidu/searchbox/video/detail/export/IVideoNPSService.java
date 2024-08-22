package com.baidu.searchbox.video.detail.export;

import com.baidu.searchbox.video.detail.dependency.impl.nps.VideoNPSServiceImpl_Factory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/detail/export/IVideoNPSService;", "", "preDownloadLiveNPS", "", "from", "", "Companion", "Impl", "lib-dependency_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IVideoNPSService.kt */
public interface IVideoNPSService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void preDownloadLiveNPS(String str);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/detail/export/IVideoNPSService$Impl;", "", "()V", "get", "Lcom/baidu/searchbox/video/detail/export/IVideoNPSService;", "lib-dependency_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IVideoNPSService.kt */
    public static final class Impl {
        public static final Impl INSTANCE = new Impl();

        private Impl() {
        }

        public final IVideoNPSService get() {
            return VideoNPSServiceImpl_Factory.get();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/detail/export/IVideoNPSService$Companion;", "", "()V", "EMPTY", "Lcom/baidu/searchbox/video/detail/export/IVideoNPSService;", "getEMPTY", "()Lcom/baidu/searchbox/video/detail/export/IVideoNPSService;", "lib-dependency_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IVideoNPSService.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IVideoNPSService EMPTY = new IVideoNPSService$Companion$EMPTY$1();

        private Companion() {
        }

        public final IVideoNPSService getEMPTY() {
            return EMPTY;
        }
    }
}
