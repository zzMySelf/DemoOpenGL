package com.baidu.searchbox.download.center.clearcache.view.funison.views;

import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.ui.BdBaseImageView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlphaVideoWithPlaceHolderView.kt */
final class AlphaVideoWithPlaceHolderView$mPlaceHolderImageView$2 extends Lambda implements Function0<BdBaseImageView> {
    final /* synthetic */ AlphaVideoWithPlaceHolderView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlphaVideoWithPlaceHolderView$mPlaceHolderImageView$2(AlphaVideoWithPlaceHolderView alphaVideoWithPlaceHolderView) {
        super(0);
        this.this$0 = alphaVideoWithPlaceHolderView;
    }

    public final BdBaseImageView invoke() {
        BdBaseImageView bdBaseImageView = new BdBaseImageView(this.this$0.getContext());
        BdBaseImageView $this$invoke_u24lambda_u2d0 = bdBaseImageView;
        $this$invoke_u24lambda_u2d0.setId(ViewCompat.generateViewId());
        $this$invoke_u24lambda_u2d0.setScaleType(ImageView.ScaleType.FIT_XY);
        return bdBaseImageView;
    }
}
