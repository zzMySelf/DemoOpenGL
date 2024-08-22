package com.baidu.searchbox.video.feedflow.detail.barrage;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/barrage/BarrageSpecialClickAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "specialId", "", "(Ljava/lang/String;)V", "getSpecialId", "()Ljava/lang/String;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: BarrageActionManifest.kt */
public final class BarrageSpecialClickAction implements Action {
    private final String specialId;

    public BarrageSpecialClickAction() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public BarrageSpecialClickAction(String specialId2) {
        this.specialId = specialId2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BarrageSpecialClickAction(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getSpecialId() {
        return this.specialId;
    }
}
