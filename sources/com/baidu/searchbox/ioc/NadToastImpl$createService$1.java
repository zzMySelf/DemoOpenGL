package com.baidu.searchbox.ioc;

import android.content.Context;
import com.baidu.nadcore.toast.IToast;
import com.baidu.searchbox.feed.ad.AdUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/ioc/NadToastImpl$createService$1", "Lcom/baidu/nadcore/toast/IToast;", "showToast", "", "context", "Landroid/content/Context;", "resId", "", "duration", "text", "", "lib-ad-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadToastImpl.kt */
public final class NadToastImpl$createService$1 implements IToast {
    NadToastImpl$createService$1() {
    }

    public void showToast(Context context, int resId) {
        Intrinsics.checkNotNullParameter(context, "context");
        String text = context.getString(resId);
        Intrinsics.checkNotNullExpressionValue(text, "context.getString(resId)");
        AdUtil.showCustomBottomToast(text);
    }

    public void showToast(Context context, int resId, int duration) {
        Intrinsics.checkNotNullParameter(context, "context");
        String text = context.getString(resId);
        Intrinsics.checkNotNullExpressionValue(text, "context.getString(resId)");
        AdUtil.showCustomBottomToast(text);
    }

    public void showToast(Context context, String text) {
        Intrinsics.checkNotNullParameter(context, "context");
        AdUtil.showCustomBottomToast(text);
    }

    public void showToast(Context context, String text, int duration) {
        Intrinsics.checkNotNullParameter(context, "context");
        AdUtil.showCustomBottomToast(text);
    }
}
