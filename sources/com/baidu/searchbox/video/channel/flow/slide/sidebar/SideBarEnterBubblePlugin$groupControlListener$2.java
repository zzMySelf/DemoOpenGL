package com.baidu.searchbox.video.channel.flow.slide.sidebar;

import com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.service.IGroupControlListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/channel/flow/slide/sidebar/SideBarEnterBubblePlugin$groupControlListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/channel/flow/slide/sidebar/SideBarEnterBubblePlugin$groupControlListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SideBarEnterBubblePlugin.kt */
final class SideBarEnterBubblePlugin$groupControlListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ SideBarEnterBubblePlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SideBarEnterBubblePlugin$groupControlListener$2(SideBarEnterBubblePlugin sideBarEnterBubblePlugin) {
        super(0);
        this.this$0 = sideBarEnterBubblePlugin;
    }

    public final AnonymousClass1 invoke() {
        final SideBarEnterBubblePlugin sideBarEnterBubblePlugin = this.this$0;
        return new IGroupControlListener() {
            public void tryShowGroup(GroupControlArea group) {
                IGroupControlListener.DefaultImpls.tryShowGroup(this, group);
            }

            public void tryHideGroup(GroupControlArea group) {
                Intrinsics.checkNotNullParameter(group, "group");
                sideBarEnterBubblePlugin.showOrHideGuide(false);
            }
        };
    }
}
