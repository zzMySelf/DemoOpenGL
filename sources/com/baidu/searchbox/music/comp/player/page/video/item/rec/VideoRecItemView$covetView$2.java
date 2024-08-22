package com.baidu.searchbox.music.comp.player.page.video.item.rec;

import android.content.Context;
import android.widget.FrameLayout;
import com.baidu.searchbox.music.R;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/facebook/drawee/view/SimpleDraweeView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoRecView.kt */
final class VideoRecItemView$covetView$2 extends Lambda implements Function0<SimpleDraweeView> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoRecItemView$covetView$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final SimpleDraweeView invoke() {
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this.$context);
        SimpleDraweeView $this$invoke_u24lambda_u2d1 = simpleDraweeView;
        $this$invoke_u24lambda_u2d1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GenericDraweeHierarchy $this$invoke_u24lambda_u2d1_u24lambda_u2d0 = (GenericDraweeHierarchy) $this$invoke_u24lambda_u2d1.getHierarchy();
        if ($this$invoke_u24lambda_u2d1_u24lambda_u2d0 != null) {
            Intrinsics.checkNotNullExpressionValue($this$invoke_u24lambda_u2d1_u24lambda_u2d0, "hierarchy");
            $this$invoke_u24lambda_u2d1_u24lambda_u2d0.setRoundingParams(RoundingParams.fromCornersRadius((float) ViewExKt.getDp(8)));
            $this$invoke_u24lambda_u2d1_u24lambda_u2d0.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            $this$invoke_u24lambda_u2d1_u24lambda_u2d0.setPlaceholderImage(R.drawable.video_rec_item_default);
        }
        return simpleDraweeView;
    }
}
