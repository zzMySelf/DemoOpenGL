package com.baidu.searchbox.config.dialog;

import android.util.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/config/dialog/IHomeFontTipsDialog;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeFontToastManager.kt */
final class HomeFontToastManager$showFontGuidePopWindow$constructor$5 extends Lambda implements Function1<IHomeFontTipsDialog, Unit> {
    public static final HomeFontToastManager$showFontGuidePopWindow$constructor$5 INSTANCE = new HomeFontToastManager$showFontGuidePopWindow$constructor$5();

    HomeFontToastManager$showFontGuidePopWindow$constructor$5() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((IHomeFontTipsDialog) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(IHomeFontTipsDialog it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (HomeFontToastManager.DEBUG) {
            Log.d("HomeFontToastManager", "font pop window hide");
        }
    }
}
