package com.baidu.searchbox.video.feedflow.detail.similarentrance;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/similarentrance/SimilarEntranceShowAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "position", "", "(I)V", "getPosition", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: SimilarEntranceActionManifest.kt */
public final class SimilarEntranceShowAction implements Action {
    private final int position;

    public static /* synthetic */ SimilarEntranceShowAction copy$default(SimilarEntranceShowAction similarEntranceShowAction, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = similarEntranceShowAction.position;
        }
        return similarEntranceShowAction.copy(i2);
    }

    public final int component1() {
        return this.position;
    }

    public final SimilarEntranceShowAction copy(int i2) {
        return new SimilarEntranceShowAction(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SimilarEntranceShowAction) && this.position == ((SimilarEntranceShowAction) obj).position;
    }

    public int hashCode() {
        return Integer.hashCode(this.position);
    }

    public String toString() {
        return "SimilarEntranceShowAction(position=" + this.position + ')';
    }

    public SimilarEntranceShowAction(int position2) {
        this.position = position2;
    }

    public final int getPosition() {
        return this.position;
    }
}
