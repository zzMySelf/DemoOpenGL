package com.baidu.searchbox.video.feedflow.flow.collection.collectionrecord;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/collectionrecord/RecordCollectionAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "vid", "", "position", "", "(Ljava/lang/String;I)V", "getPosition", "()I", "getVid", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: CollectionRecordManifest.kt */
public final class RecordCollectionAction implements Action {
    private final int position;
    private final String vid;

    public static /* synthetic */ RecordCollectionAction copy$default(RecordCollectionAction recordCollectionAction, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = recordCollectionAction.vid;
        }
        if ((i3 & 2) != 0) {
            i2 = recordCollectionAction.position;
        }
        return recordCollectionAction.copy(str, i2);
    }

    public final String component1() {
        return this.vid;
    }

    public final int component2() {
        return this.position;
    }

    public final RecordCollectionAction copy(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "vid");
        return new RecordCollectionAction(str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordCollectionAction)) {
            return false;
        }
        RecordCollectionAction recordCollectionAction = (RecordCollectionAction) obj;
        return Intrinsics.areEqual((Object) this.vid, (Object) recordCollectionAction.vid) && this.position == recordCollectionAction.position;
    }

    public int hashCode() {
        return (this.vid.hashCode() * 31) + Integer.hashCode(this.position);
    }

    public String toString() {
        return "RecordCollectionAction(vid=" + this.vid + ", position=" + this.position + ')';
    }

    public RecordCollectionAction(String vid2, int position2) {
        Intrinsics.checkNotNullParameter(vid2, "vid");
        this.vid = vid2;
        this.position = position2;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getVid() {
        return this.vid;
    }
}
