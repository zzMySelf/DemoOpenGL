package com.baidu.searchbox.video.feedflow.detail.barrage;

import android.graphics.drawable.GradientDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageInputBarIconComponent.kt */
final class BarrageInputBarIconComponent$container$2 extends Lambda implements Function0<FrameLayout> {
    final /* synthetic */ BarrageInputBarIconComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BarrageInputBarIconComponent$container$2(BarrageInputBarIconComponent barrageInputBarIconComponent) {
        super(0);
        this.this$0 = barrageInputBarIconComponent;
    }

    public final FrameLayout invoke() {
        FrameLayout frameLayout = new FrameLayout(this.this$0.getContext());
        BarrageInputBarIconComponent barrageInputBarIconComponent = this.this$0;
        FrameLayout $this$invoke_u24lambda_u2d3 = frameLayout;
        FrameLayout.LayoutParams $this$invoke_u24lambda_u2d3_u24lambda_u2d0 = new FrameLayout.LayoutParams(-2, -2);
        $this$invoke_u24lambda_u2d3_u24lambda_u2d0.setMargins($this$invoke_u24lambda_u2d3.getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_7dp), 0, 0, 0);
        $this$invoke_u24lambda_u2d3.setLayoutParams($this$invoke_u24lambda_u2d3_u24lambda_u2d0);
        $this$invoke_u24lambda_u2d3.setPadding(0, $this$invoke_u24lambda_u2d3.getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_13dp), 0, 0);
        SimpleDraweeView access$getImageView = barrageInputBarIconComponent.getImageView();
        SimpleDraweeView $this$invoke_u24lambda_u2d3_u24lambda_u2d2 = access$getImageView;
        $this$invoke_u24lambda_u2d3_u24lambda_u2d2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        $this$invoke_u24lambda_u2d3_u24lambda_u2d2.setImageResource(R.drawable.video_flow_collection_barrage_icon_new);
        int size = $this$invoke_u24lambda_u2d3_u24lambda_u2d2.getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_33dp);
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable $this$invoke_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1 = gradientDrawable;
        $this$invoke_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.setShape(1);
        $this$invoke_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.setColor(ResourceUtils.getColor($this$invoke_u24lambda_u2d3_u24lambda_u2d2.getContext(), R.color.video_flow_barrage_input_bar_icon_color));
        $this$invoke_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.setSize(size, size);
        $this$invoke_u24lambda_u2d3_u24lambda_u2d2.setBackground(gradientDrawable);
        $this$invoke_u24lambda_u2d3.addView(access$getImageView);
        $this$invoke_u24lambda_u2d3.setVisibility(8);
        $this$invoke_u24lambda_u2d3.setAlpha(0.0f);
        return frameLayout;
    }
}
