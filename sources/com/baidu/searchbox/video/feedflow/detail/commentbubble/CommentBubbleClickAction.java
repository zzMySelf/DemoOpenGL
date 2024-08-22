package com.baidu.searchbox.video.feedflow.detail.commentbubble;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/commentbubble/CommentBubbleClickAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "nid", "", "topicId", "(Ljava/lang/String;Ljava/lang/String;)V", "getNid", "()Ljava/lang/String;", "getTopicId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: CommentBubbleActionManifest.kt */
public final class CommentBubbleClickAction implements Action {
    private final String nid;
    private final String topicId;

    public static /* synthetic */ CommentBubbleClickAction copy$default(CommentBubbleClickAction commentBubbleClickAction, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commentBubbleClickAction.nid;
        }
        if ((i2 & 2) != 0) {
            str2 = commentBubbleClickAction.topicId;
        }
        return commentBubbleClickAction.copy(str, str2);
    }

    public final String component1() {
        return this.nid;
    }

    public final String component2() {
        return this.topicId;
    }

    public final CommentBubbleClickAction copy(String str, String str2) {
        return new CommentBubbleClickAction(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentBubbleClickAction)) {
            return false;
        }
        CommentBubbleClickAction commentBubbleClickAction = (CommentBubbleClickAction) obj;
        return Intrinsics.areEqual((Object) this.nid, (Object) commentBubbleClickAction.nid) && Intrinsics.areEqual((Object) this.topicId, (Object) commentBubbleClickAction.topicId);
    }

    public int hashCode() {
        String str = this.nid;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.topicId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "CommentBubbleClickAction(nid=" + this.nid + ", topicId=" + this.topicId + ')';
    }

    public CommentBubbleClickAction(String nid2, String topicId2) {
        this.nid = nid2;
        this.topicId = topicId2;
    }

    public final String getNid() {
        return this.nid;
    }

    public final String getTopicId() {
        return this.topicId;
    }
}
