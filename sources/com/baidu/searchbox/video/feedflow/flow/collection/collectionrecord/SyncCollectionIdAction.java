package com.baidu.searchbox.video.feedflow.flow.collection.collectionrecord;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/collectionrecord/SyncCollectionIdAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "collId", "", "(Ljava/lang/String;)V", "getCollId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: CollectionRecordManifest.kt */
public final class SyncCollectionIdAction implements Action {
    private final String collId;

    public static /* synthetic */ SyncCollectionIdAction copy$default(SyncCollectionIdAction syncCollectionIdAction, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = syncCollectionIdAction.collId;
        }
        return syncCollectionIdAction.copy(str);
    }

    public final String component1() {
        return this.collId;
    }

    public final SyncCollectionIdAction copy(String str) {
        Intrinsics.checkNotNullParameter(str, "collId");
        return new SyncCollectionIdAction(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SyncCollectionIdAction) && Intrinsics.areEqual((Object) this.collId, (Object) ((SyncCollectionIdAction) obj).collId);
    }

    public int hashCode() {
        return this.collId.hashCode();
    }

    public String toString() {
        return "SyncCollectionIdAction(collId=" + this.collId + ')';
    }

    public SyncCollectionIdAction(String collId2) {
        Intrinsics.checkNotNullParameter(collId2, "collId");
        this.collId = collId2;
    }

    public final String getCollId() {
        return this.collId;
    }
}
