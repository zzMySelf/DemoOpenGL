package com.baidu.searchbox.video.feedflow.detail.graphicgenre.pic;

import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/graphicgenre/pic/OnGraphicPicShowStartAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "pos", "", "(I)V", "getPos", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphicPicActionManifest.kt */
public final class OnGraphicPicShowStartAction implements Action {
    private final int pos;

    public static /* synthetic */ OnGraphicPicShowStartAction copy$default(OnGraphicPicShowStartAction onGraphicPicShowStartAction, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = onGraphicPicShowStartAction.pos;
        }
        return onGraphicPicShowStartAction.copy(i2);
    }

    public final int component1() {
        return this.pos;
    }

    public final OnGraphicPicShowStartAction copy(int i2) {
        return new OnGraphicPicShowStartAction(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OnGraphicPicShowStartAction) && this.pos == ((OnGraphicPicShowStartAction) obj).pos;
    }

    public int hashCode() {
        return Integer.hashCode(this.pos);
    }

    public String toString() {
        return "OnGraphicPicShowStartAction(pos=" + this.pos + ')';
    }

    public OnGraphicPicShowStartAction(int pos2) {
        this.pos = pos2;
    }

    public final int getPos() {
        return this.pos;
    }
}
