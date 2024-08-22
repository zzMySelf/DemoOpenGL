package com.baidu.searchbox.feed.payment.core.manager.errorManager;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.Router;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\"\u0010\u0010\u0000\u001a\u00020\u00018\u0002XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"BASE_SCHEMA", "", "openHelpPage", "", "context", "Landroid/content/Context;", "helpUrl", "lib-feed-payment_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ErrorManager.kt */
public final class ErrorManagerKt {
    private static final String BASE_SCHEMA = "baiduboxapp://v1/easybrowse/open?url=";

    public static final void openHelpPage(Context context, String helpUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence charSequence = helpUrl;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Router.invoke(context, "baiduboxapp://v1/easybrowse/open?url=" + Uri.encode(helpUrl));
        }
    }
}
