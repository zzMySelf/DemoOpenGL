package com.baidu.searchbox.payment.video;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.searchbox.video.detail.core.ComponentManager;
import com.baidu.searchbox.video.detail.core.plugin.ComponentAdapter;
import com.baidu.searchbox.video.detail.plugin.component.general.SpecialColumnAboveDividerComponent;
import com.baidu.searchbox.video.detail.plugin.component.general.SpecialColumnBottomDividerComponent;
import com.baidu.searchbox.video.detail.plugin.component.general.ViewFloatingComponent;
import com.baidu.searchbox.video.detail.plugin.component.relate.VideoPaymentAuthorRelateComponent;
import com.baidu.searchbox.video.detail.plugin.component.right.PaymentSpecialColumnComponent;
import com.baidu.searchbox.video.detail.plugin.component.title.VideoPaymentTitleAndTagComponent;
import com.baidu.searchbox.video.payment.videodetail.VideoPaymentBottomOperateComponent;
import com.baidu.searchbox.video.payment.videodetail.VideoPaymentColumnInfoComponent;
import com.baidu.searchbox.video.payment.videodetail.VideoPaymentColumnIntroComponent;
import com.baidu.searchbox.video.payment.videodetail.VideoPaymentEpisodesInfoComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0014¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/payment/video/VideoPaymentPageLayoutManager;", "Lcom/baidu/searchbox/payment/video/VideoPaymentLayoutManager;", "()V", "addBottomOperateView", "", "container", "Landroid/widget/RelativeLayout;", "componentManager", "Lcom/baidu/searchbox/video/detail/core/ComponentManager;", "layout", "root", "layoutVideoEpisodesAboveComponent", "rightView", "Landroid/view/ViewGroup;", "layoutVideoEpisodesBelowComponent", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPaymentPageLayoutManager.kt */
public final class VideoPaymentPageLayoutManager extends VideoPaymentLayoutManager {
    /* access modifiers changed from: protected */
    public void layoutVideoEpisodesAboveComponent(ComponentManager componentManager, ViewGroup rightView) {
        Intrinsics.checkNotNullParameter(componentManager, "componentManager");
        Intrinsics.checkNotNullParameter(rightView, "rightView");
        super.layoutVideoEpisodesAboveComponent(componentManager, rightView);
        addView(rightView, componentManager.getComponent(VideoPaymentTitleAndTagComponent.class));
        addView(rightView, componentManager.getComponent(VideoPaymentEpisodesInfoComponent.class));
    }

    /* access modifiers changed from: protected */
    public void layoutVideoEpisodesBelowComponent(ComponentManager componentManager, ViewGroup rightView) {
        Intrinsics.checkNotNullParameter(componentManager, "componentManager");
        Intrinsics.checkNotNullParameter(rightView, "rightView");
        addView(rightView, componentManager.getComponent(SpecialColumnAboveDividerComponent.class));
        addView(rightView, componentManager.getComponent(PaymentSpecialColumnComponent.class));
        addView(rightView, componentManager.getComponent(VideoPaymentColumnInfoComponent.class));
        addView(rightView, componentManager.getComponent(VideoPaymentColumnIntroComponent.class));
        addView(rightView, componentManager.getComponent(SpecialColumnBottomDividerComponent.class));
        addView(rightView, componentManager.getComponent(VideoPaymentAuthorRelateComponent.class));
    }

    public void layout(RelativeLayout root, ComponentManager componentManager) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(componentManager, "componentManager");
        super.layout(root, componentManager);
        addView(this.mBottomContainer, componentManager.getComponent(ViewFloatingComponent.class));
        RelativeLayout relativeLayout = this.mBottomContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBottomContainer");
        addBottomOperateView(relativeLayout, componentManager);
    }

    private final void addBottomOperateView(RelativeLayout container, ComponentManager componentManager) {
        ComponentAdapter componentAdapter;
        View operateView;
        List operateComponent = componentManager.getComponent(VideoPaymentBottomOperateComponent.class);
        addView(container, operateComponent);
        if (operateComponent != null && (componentAdapter = operateComponent.get(0)) != null && (operateView = componentAdapter.getView()) != null) {
            ViewGroup.LayoutParams layoutParams = operateView.getLayoutParams();
            RelativeLayout.LayoutParams $this$addBottomOperateView_u24lambda_u2d1_u24lambda_u2d0 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
            if ($this$addBottomOperateView_u24lambda_u2d1_u24lambda_u2d0 != null) {
                $this$addBottomOperateView_u24lambda_u2d1_u24lambda_u2d0.addRule(12, -1);
            }
        }
    }
}
