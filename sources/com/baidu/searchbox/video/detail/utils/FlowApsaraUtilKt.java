package com.baidu.searchbox.video.detail.utils;

import com.baidu.apsaras.scheduler.ParticleDispatchers;
import com.baidu.apsaras.scheduler.ParticleGroup;
import com.baidu.apsaras.scheduler.ResourceGroups;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"enterVideoApsaras", "", "path", "", "exitVideoApsaras", "", "tokenHandleID", "lib-support_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowApsaraUtil.kt */
public final class FlowApsaraUtilKt {
    public static final long enterVideoApsaras(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        ParticleGroup particleGroup = ParticleGroup.Key.fromUriPath(path);
        particleGroup.migrateResourceGroup(ResourceGroups.FOREGROUND);
        return particleGroup.postSyncBarrier(ParticleDispatchers.Main).handle();
    }

    public static final void exitVideoApsaras(String path, long tokenHandleID) {
        Intrinsics.checkNotNullParameter(path, "path");
        ParticleGroup particleGroup = ParticleGroup.Key.fromUriPath(path);
        particleGroup.migrateResourceGroup(ResourceGroups.BACKGROUND);
        particleGroup.removeSyncBarrier(tokenHandleID);
    }
}
