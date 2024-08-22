package com.baidu.searchbox.video.feedflow.detail.landscapelistpanel;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.router.RouterAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeListPanelPlugin.kt */
final class LandscapeListPanelPlugin$initPopupWindow$1$1$4$onLeftClicked$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $scheme;
    final /* synthetic */ LandscapeListPanelPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LandscapeListPanelPlugin$initPopupWindow$1$1$4$onLeftClicked$1(LandscapeListPanelPlugin landscapeListPanelPlugin, String str) {
        super(0);
        this.this$0 = landscapeListPanelPlugin;
        this.$scheme = str;
    }

    public final void invoke() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new RouterAction(this.$scheme));
        }
    }
}
