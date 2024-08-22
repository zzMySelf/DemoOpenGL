package com.baidu.browser.explore.tab.webview;

import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.browser.tabna.IResultPageTabContext;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "newHeight", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MixTabContainer.kt */
final class MixTabContainer$createInlineContainer$8 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ MixTabContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MixTabContainer$createInlineContainer$8(MixTabContainer mixTabContainer) {
        super(1);
        this.this$0 = mixTabContainer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int newHeight) {
        if (AppConfig.isDebug()) {
            Log.v("searchInline", "onContentViewHeightChanged newHeight=" + newHeight);
            Log.v("searchInline", "onContentViewHeightChanged bottomContainerIsShow=" + this.this$0.getBottomContainerIsShow());
        }
        this.this$0.naContentViewHeight = newHeight;
        IResultPageTabContext iResultPageTabContext = this.this$0.mResultPageContext;
        boolean z = true;
        if (iResultPageTabContext == null || !iResultPageTabContext.isCurrentPreRender()) {
            z = false;
        }
        if (!z && !this.this$0.getBottomContainerIsShow() && this.this$0.focusManager.isFocusIdle()) {
            this.this$0.notifyWebViewFocusChange(false);
        }
        UiThreadUtils.getMainHandler().post(new MixTabContainer$createInlineContainer$8$$ExternalSyntheticLambda0(this.this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m12967invoke$lambda0(MixTabContainer this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Function0<Unit> onNaContentViewHeightChange = this$02.getOnNaContentViewHeightChange();
        if (onNaContentViewHeightChange != null) {
            onNaContentViewHeightChange.invoke();
        }
    }
}
