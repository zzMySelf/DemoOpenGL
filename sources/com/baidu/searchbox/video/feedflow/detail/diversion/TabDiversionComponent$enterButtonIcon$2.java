package com.baidu.searchbox.video.feedflow.detail.diversion;

import com.baidu.searchbox.video.feedflow.component.R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabDiversionComponent.kt */
final class TabDiversionComponent$enterButtonIcon$2 extends Lambda implements Function0<SimpleDraweeView> {
    final /* synthetic */ TabDiversionComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabDiversionComponent$enterButtonIcon$2(TabDiversionComponent tabDiversionComponent) {
        super(0);
        this.this$0 = tabDiversionComponent;
    }

    public final SimpleDraweeView invoke() {
        return (SimpleDraweeView) this.this$0.getRootContainer().findViewById(R.id.tab_diversion_enter_button_icon);
    }
}
