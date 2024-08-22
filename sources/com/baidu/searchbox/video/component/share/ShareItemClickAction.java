package com.baidu.searchbox.video.component.share;

import android.view.View;
import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/component/share/ShareItemClickAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "view", "Landroid/view/View;", "message", "Lcom/baidu/searchbox/video/component/share/ShareMenuClickModel;", "(Landroid/view/View;Lcom/baidu/searchbox/video/component/share/ShareMenuClickModel;)V", "getMessage", "()Lcom/baidu/searchbox/video/component/share/ShareMenuClickModel;", "getView", "()Landroid/view/View;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: ShareActionManifest.kt */
public final class ShareItemClickAction implements Action {
    private final ShareMenuClickModel message;

    /* renamed from: view  reason: collision with root package name */
    private final View f2871view;

    public static /* synthetic */ ShareItemClickAction copy$default(ShareItemClickAction shareItemClickAction, View view2, ShareMenuClickModel shareMenuClickModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            view2 = shareItemClickAction.f2871view;
        }
        if ((i2 & 2) != 0) {
            shareMenuClickModel = shareItemClickAction.message;
        }
        return shareItemClickAction.copy(view2, shareMenuClickModel);
    }

    public final View component1() {
        return this.f2871view;
    }

    public final ShareMenuClickModel component2() {
        return this.message;
    }

    public final ShareItemClickAction copy(View view2, ShareMenuClickModel shareMenuClickModel) {
        return new ShareItemClickAction(view2, shareMenuClickModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareItemClickAction)) {
            return false;
        }
        ShareItemClickAction shareItemClickAction = (ShareItemClickAction) obj;
        return Intrinsics.areEqual((Object) this.f2871view, (Object) shareItemClickAction.f2871view) && Intrinsics.areEqual((Object) this.message, (Object) shareItemClickAction.message);
    }

    public int hashCode() {
        View view2 = this.f2871view;
        int i2 = 0;
        int hashCode = (view2 == null ? 0 : view2.hashCode()) * 31;
        ShareMenuClickModel shareMenuClickModel = this.message;
        if (shareMenuClickModel != null) {
            i2 = shareMenuClickModel.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "ShareItemClickAction(view=" + this.f2871view + ", message=" + this.message + ')';
    }

    public ShareItemClickAction(View view2, ShareMenuClickModel message2) {
        this.f2871view = view2;
        this.message = message2;
    }

    public final ShareMenuClickModel getMessage() {
        return this.message;
    }

    public final View getView() {
        return this.f2871view;
    }
}
