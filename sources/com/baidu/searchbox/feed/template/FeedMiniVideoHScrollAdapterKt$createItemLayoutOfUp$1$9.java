package com.baidu.searchbox.feed.template;

import com.baidu.searchbox.layout.GenFrameLayout;
import com.baidu.searchbox.layout.LayoutKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/layout/GenFrameLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedMiniVideoHScrollAdapter.kt */
final class FeedMiniVideoHScrollAdapterKt$createItemLayoutOfUp$1$9 extends Lambda implements Function1<GenFrameLayout, Unit> {
    public static final FeedMiniVideoHScrollAdapterKt$createItemLayoutOfUp$1$9 INSTANCE = new FeedMiniVideoHScrollAdapterKt$createItemLayoutOfUp$1$9();

    FeedMiniVideoHScrollAdapterKt$createItemLayoutOfUp$1$9() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GenFrameLayout) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GenFrameLayout $this$frameLayout) {
        Intrinsics.checkNotNullParameter($this$frameLayout, "$this$frameLayout");
        $this$frameLayout.lparams(LayoutKt.linearLayout($this$frameLayout, AnonymousClass1.INSTANCE), AnonymousClass2.INSTANCE);
        $this$frameLayout.lparams(LayoutKt.linearLayout($this$frameLayout, AnonymousClass3.INSTANCE), AnonymousClass4.INSTANCE);
    }
}
