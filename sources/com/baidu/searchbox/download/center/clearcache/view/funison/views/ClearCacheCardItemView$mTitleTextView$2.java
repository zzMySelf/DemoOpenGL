package com.baidu.searchbox.download.center.clearcache.view.funison.views;

import android.widget.TextView;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCacheCardItemView.kt */
final class ClearCacheCardItemView$mTitleTextView$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ ClearCacheCardItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClearCacheCardItemView$mTitleTextView$2(ClearCacheCardItemView clearCacheCardItemView) {
        super(0);
        this.this$0 = clearCacheCardItemView;
    }

    public final TextView invoke() {
        TextView textView = new TextView(this.this$0.getContext());
        TextView $this$invoke_u24lambda_u2d0 = textView;
        $this$invoke_u24lambda_u2d0.setId(ViewCompat.generateViewId());
        $this$invoke_u24lambda_u2d0.setIncludeFontPadding(false);
        $this$invoke_u24lambda_u2d0.setMaxLines(1);
        return textView;
    }
}
