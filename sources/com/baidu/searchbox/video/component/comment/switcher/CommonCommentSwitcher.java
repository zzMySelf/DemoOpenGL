package com.baidu.searchbox.video.component.comment.switcher;

import com.baidu.searchbox.video.detail.switcher.VideoSPData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/component/comment/switcher/CommonCommentSwitcher;", "", "()V", "<set-?>", "", "commentHasFall", "getCommentHasFall", "()Z", "setCommentHasFall", "(Z)V", "commentHasFall$delegate", "Lcom/baidu/searchbox/video/detail/switcher/VideoSPData;", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonCommentSwitcher.kt */
public final class CommonCommentSwitcher {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(CommonCommentSwitcher.class, "commentHasFall", "getCommentHasFall()Z", 0))};
    public static final CommonCommentSwitcher INSTANCE = new CommonCommentSwitcher();
    private static final VideoSPData commentHasFall$delegate = new VideoSPData("video_flow_common_comment_has_fall", false, false, (String) null, 12, (DefaultConstructorMarker) null);

    private CommonCommentSwitcher() {
    }

    public final boolean getCommentHasFall() {
        return ((Boolean) commentHasFall$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setCommentHasFall(boolean z) {
        commentHasFall$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }
}
