package com.baidu.searchbox.player.menu.element;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.player.menu.view.MenuDownloadView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/player/menu/view/MenuDownloadView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MenuDownloadElement.kt */
final class MenuDownloadElement$downloadView$2 extends Lambda implements Function0<MenuDownloadView> {
    final /* synthetic */ MenuDownloadElement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MenuDownloadElement$downloadView$2(MenuDownloadElement menuDownloadElement) {
        super(0);
        this.this$0 = menuDownloadElement;
    }

    public final MenuDownloadView invoke() {
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new MenuDownloadView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }
}
