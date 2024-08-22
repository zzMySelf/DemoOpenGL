package com.baidu.searchbox.download.center.clearcache.view.funison.download.view;

import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectedAllView.kt */
final class SelectedAllView$mIconImageView$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ SelectedAllView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectedAllView$mIconImageView$2(SelectedAllView selectedAllView) {
        super(0);
        this.this$0 = selectedAllView;
    }

    public final ImageView invoke() {
        ImageView $this$invoke_u24lambda_u2d0 = new ImageView(this.this$0.getContext());
        $this$invoke_u24lambda_u2d0.setId(ViewCompat.generateViewId());
        return $this$invoke_u24lambda_u2d0;
    }
}
