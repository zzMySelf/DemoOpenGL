package com.baidu.searchbox.aisearch.utils;

import android.view.View;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewExt.kt */
final class ViewExtKt$doClickAfterChangeToFullScreen$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Function0<Unit> $doClick;
    final /* synthetic */ UniqueId $pageToken;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewExtKt$doClickAfterChangeToFullScreen$1(UniqueId uniqueId, Function0<Unit> function0) {
        super(1);
        this.$pageToken = uniqueId;
        this.$doClick = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((View) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ViewExtKt.changeToFullScreen(this.$pageToken, this.$doClick);
    }
}
