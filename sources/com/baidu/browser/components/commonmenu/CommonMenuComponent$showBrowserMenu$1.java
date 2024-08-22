package com.baidu.browser.components.commonmenu;

import com.baidu.browser.components.commonmenu.impl.NewMenuUbcHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonMenuComponent.kt */
final class CommonMenuComponent$showBrowserMenu$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ CommonMenuComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonMenuComponent$showBrowserMenu$1(CommonMenuComponent commonMenuComponent) {
        super(1);
        this.this$0 = commonMenuComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean result) {
        if (!result) {
            this.this$0.commonMenuManager.showBrowserMenu((Function1<? super Boolean, Unit>) null);
            NewMenuUbcHelperKt.oldMenuShowUBC$default(this.this$0.getManager().getPageViewContext(), (String) null, 2, (Object) null);
        }
    }
}
