package com.baidu.searchbox.video.feedflow.detail.graphicgenre.pic;

import com.baidu.searchbox.feed.detail.frame.NoPostAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/graphicgenre/pic/OnGraphicPicTwoFingerPressEndAction;", "Lcom/baidu/searchbox/feed/detail/frame/NoPostAction;", "enlarge", "", "(Z)V", "getEnlarge", "()Z", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphicPicActionManifest.kt */
public final class OnGraphicPicTwoFingerPressEndAction implements NoPostAction {
    private final boolean enlarge;

    public OnGraphicPicTwoFingerPressEndAction() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public OnGraphicPicTwoFingerPressEndAction(boolean enlarge2) {
        this.enlarge = enlarge2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnGraphicPicTwoFingerPressEndAction(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z);
    }

    public final boolean getEnlarge() {
        return this.enlarge;
    }
}
