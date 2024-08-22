package com.baidu.searchbox.video.feedflow.detail.oneton;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.flowvideo.follow.api.FollowOneToNItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/oneton/OneToNItemClickAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "data", "Lcom/baidu/searchbox/flowvideo/follow/api/FollowOneToNItemModel;", "position", "", "(Lcom/baidu/searchbox/flowvideo/follow/api/FollowOneToNItemModel;I)V", "getData", "()Lcom/baidu/searchbox/flowvideo/follow/api/FollowOneToNItemModel;", "getPosition", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: OneToNActionManifest.kt */
public final class OneToNItemClickAction implements Action {
    private final FollowOneToNItemModel data;
    private final int position;

    public static /* synthetic */ OneToNItemClickAction copy$default(OneToNItemClickAction oneToNItemClickAction, FollowOneToNItemModel followOneToNItemModel, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            followOneToNItemModel = oneToNItemClickAction.data;
        }
        if ((i3 & 2) != 0) {
            i2 = oneToNItemClickAction.position;
        }
        return oneToNItemClickAction.copy(followOneToNItemModel, i2);
    }

    public final FollowOneToNItemModel component1() {
        return this.data;
    }

    public final int component2() {
        return this.position;
    }

    public final OneToNItemClickAction copy(FollowOneToNItemModel followOneToNItemModel, int i2) {
        return new OneToNItemClickAction(followOneToNItemModel, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OneToNItemClickAction)) {
            return false;
        }
        OneToNItemClickAction oneToNItemClickAction = (OneToNItemClickAction) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) oneToNItemClickAction.data) && this.position == oneToNItemClickAction.position;
    }

    public int hashCode() {
        FollowOneToNItemModel followOneToNItemModel = this.data;
        return ((followOneToNItemModel == null ? 0 : followOneToNItemModel.hashCode()) * 31) + Integer.hashCode(this.position);
    }

    public String toString() {
        return "OneToNItemClickAction(data=" + this.data + ", position=" + this.position + ')';
    }

    public OneToNItemClickAction(FollowOneToNItemModel data2, int position2) {
        this.data = data2;
        this.position = position2;
    }

    public final FollowOneToNItemModel getData() {
        return this.data;
    }

    public final int getPosition() {
        return this.position;
    }
}
