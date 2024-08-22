package com.baidu.searchbox.videopublisher.rights.statement;

import android.app.Activity;
import com.baidu.searchbox.videopublisher.rights.OriginType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a\"\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¨\u0006\f"}, d2 = {"showRightsStatePopup", "", "context", "Landroid/app/Activity;", "type", "Lcom/baidu/searchbox/videopublisher/rights/OriginType;", "listener", "Lcom/baidu/searchbox/videopublisher/rights/statement/OnPopupCallback;", "showStatementPopup", "url", "", "title", "lib-publisher-video_debug"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RightsStatePopup.kt */
public final class RightsStatePopupKt {
    public static final void showRightsStatePopup(Activity context, OriginType type, OnPopupCallback listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        new RightsStatePopupKt$showRightsStatePopup$1(context, type, listener, context.getWindow().getDecorView()).showView();
    }

    public static final void showStatementPopup(Activity context, String url, String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        new RightsStatePopupKt$showStatementPopup$1(context, url, title, context.getWindow().getDecorView()).showView();
    }
}
