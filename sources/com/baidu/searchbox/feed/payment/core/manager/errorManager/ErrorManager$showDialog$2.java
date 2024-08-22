package com.baidu.searchbox.feed.payment.core.manager.errorManager;

import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/payment/core/manager/errorManager/ErrorManager$showDialog$2", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ErrorManager.kt */
public final class ErrorManager$showDialog$2 implements BdAlertDialog.OnItemClickListener {
    final /* synthetic */ ICallback $cb;

    ErrorManager$showDialog$2(ICallback $cb2) {
        this.$cb = $cb2;
    }

    public void onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        ICallback iCallback = this.$cb;
        if (iCallback != null) {
            iCallback.onRetry();
        }
    }
}
