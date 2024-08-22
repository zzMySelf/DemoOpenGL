package com.baidu.searchbox.video.inf;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.video.config.VideoManifest;
import com.baidu.searchbox.video.utils.VideoRefUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/inf/VideoPreCreateProcessService;", "", "preCreateVideoProcess", "", "Companion", "lib-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPreCreateProcessService.kt */
public interface VideoPreCreateProcessService {
    public static final Companion Companion = Companion.$$INSTANCE;

    static ServiceReference getNAME() {
        return Companion.getNAME();
    }

    void preCreateVideoProcess();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/inf/VideoPreCreateProcessService$Companion;", "", "()V", "NAME", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getNAME$annotations", "getNAME", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "lib-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoPreCreateProcessService.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ServiceReference NAME = VideoRefUtils.getServiceRef$default(VideoManifest.ServiceName.VIDEO_PRE_CREATE_PROCESS, (String) null, 2, (Object) null);

        @JvmStatic
        public static /* synthetic */ void getNAME$annotations() {
        }

        private Companion() {
        }

        public final ServiceReference getNAME() {
            return NAME;
        }
    }
}
