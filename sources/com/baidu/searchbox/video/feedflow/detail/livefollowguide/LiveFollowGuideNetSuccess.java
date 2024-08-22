package com.baidu.searchbox.video.feedflow.detail.livefollowguide;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.detail.author.AuthorModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livefollowguide/LiveFollowGuideNetSuccess;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "authorModel", "Lcom/baidu/searchbox/video/feedflow/detail/author/AuthorModel;", "(Lcom/baidu/searchbox/video/feedflow/detail/author/AuthorModel;)V", "getAuthorModel", "()Lcom/baidu/searchbox/video/feedflow/detail/author/AuthorModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFollowGuideActionManifest.kt */
public final class LiveFollowGuideNetSuccess implements Action {
    private final AuthorModel authorModel;

    public static /* synthetic */ LiveFollowGuideNetSuccess copy$default(LiveFollowGuideNetSuccess liveFollowGuideNetSuccess, AuthorModel authorModel2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            authorModel2 = liveFollowGuideNetSuccess.authorModel;
        }
        return liveFollowGuideNetSuccess.copy(authorModel2);
    }

    public final AuthorModel component1() {
        return this.authorModel;
    }

    public final LiveFollowGuideNetSuccess copy(AuthorModel authorModel2) {
        return new LiveFollowGuideNetSuccess(authorModel2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveFollowGuideNetSuccess) && Intrinsics.areEqual((Object) this.authorModel, (Object) ((LiveFollowGuideNetSuccess) obj).authorModel);
    }

    public int hashCode() {
        AuthorModel authorModel2 = this.authorModel;
        if (authorModel2 == null) {
            return 0;
        }
        return authorModel2.hashCode();
    }

    public String toString() {
        return "LiveFollowGuideNetSuccess(authorModel=" + this.authorModel + ')';
    }

    public LiveFollowGuideNetSuccess(AuthorModel authorModel2) {
        this.authorModel = authorModel2;
    }

    public final AuthorModel getAuthorModel() {
        return this.authorModel;
    }
}
