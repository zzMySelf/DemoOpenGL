package com.baidu.searchbox.video.collectiondetail.poster;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.ViewUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.video.detail.utils.ActivityExtKt;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.night.NightModeState;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010(\u001a\u00020\"H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0012\u0010\u0006R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/video/collectiondetail/poster/CollectionDetailPosterComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "darkMaskView", "Landroid/widget/FrameLayout;", "getDarkMaskView", "()Landroid/widget/FrameLayout;", "darkMaskView$delegate", "Lkotlin/Lazy;", "gradientMaskView", "Lcom/baidu/searchbox/video/collectiondetail/poster/GradientMaskView;", "getGradientMaskView", "()Lcom/baidu/searchbox/video/collectiondetail/poster/GradientMaskView;", "gradientMaskView$delegate", "maskColor", "", "Ljava/lang/Integer;", "posterContainer", "getPosterContainer", "posterContainer$delegate", "posterView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "posterWidth", "createView", "Landroid/view/View;", "getCurrentHeight", "getCurrentWidth", "getMaskColor", "model", "Lcom/baidu/searchbox/video/collectiondetail/poster/CollectionDetailPosterModel;", "initDarkMaskView", "initGradientMaskView", "initPosterContainer", "onAttachToManager", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "refresh", "view", "updateNightMode", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionDetailPosterComponent.kt */
public final class CollectionDetailPosterComponent extends LiveDataComponent {
    private final Lazy darkMaskView$delegate = BdPlayerUtils.lazyNone(new CollectionDetailPosterComponent$darkMaskView$2(this));
    private final Lazy gradientMaskView$delegate = BdPlayerUtils.lazyNone(new CollectionDetailPosterComponent$gradientMaskView$2(this));
    private Integer maskColor;
    private final Lazy posterContainer$delegate = BdPlayerUtils.lazyNone(new CollectionDetailPosterComponent$posterContainer$2(this));
    private SimpleDraweeView posterView;
    private int posterWidth;

    private final FrameLayout getPosterContainer() {
        return (FrameLayout) this.posterContainer$delegate.getValue();
    }

    private final GradientMaskView getGradientMaskView() {
        return (GradientMaskView) this.gradientMaskView$delegate.getValue();
    }

    private final FrameLayout getDarkMaskView() {
        return (FrameLayout) this.darkMaskView$delegate.getValue();
    }

    private final int getCurrentWidth() {
        if (DIFactory.INSTANCE.isPadStyle()) {
            return DIFactory.INSTANCE.getDisplayWidth();
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        boolean z = true;
        if (activity == null || !ActivityExtKt.isLandscape(activity)) {
            z = false;
        }
        if (z) {
            return DIFactory.INSTANCE.getDisplayHeight();
        }
        return DIFactory.INSTANCE.getDisplayWidth();
    }

    private final int getCurrentHeight() {
        return (int) (((float) getCurrentWidth()) / 1.7777778f);
    }

    /* access modifiers changed from: private */
    public final FrameLayout initPosterContainer() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout $this$initPosterContainer_u24lambda_u2d1 = frameLayout;
        $this$initPosterContainer_u24lambda_u2d1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        $this$initPosterContainer_u24lambda_u2d1.setClipChildren(false);
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView($this$initPosterContainer_u24lambda_u2d1.getContext());
        SimpleDraweeView $this$initPosterContainer_u24lambda_u2d1_u24lambda_u2d0 = simpleDraweeView;
        this.posterView = $this$initPosterContainer_u24lambda_u2d1_u24lambda_u2d0;
        ((GenericDraweeHierarchy) $this$initPosterContainer_u24lambda_u2d1_u24lambda_u2d0.getHierarchy()).setPlaceholderImage(R.drawable.video_flow_poster_img_placeholder);
        $this$initPosterContainer_u24lambda_u2d1_u24lambda_u2d0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        $this$initPosterContainer_u24lambda_u2d1_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(getCurrentWidth(), getCurrentHeight()));
        $this$initPosterContainer_u24lambda_u2d1.addView(simpleDraweeView);
        $this$initPosterContainer_u24lambda_u2d1.addView(getGradientMaskView());
        $this$initPosterContainer_u24lambda_u2d1.addView(getDarkMaskView());
        this.posterWidth = getCurrentWidth();
        return frameLayout;
    }

    /* access modifiers changed from: private */
    public final GradientMaskView initGradientMaskView() {
        GradientMaskView $this$initGradientMaskView_u24lambda_u2d2 = new GradientMaskView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$initGradientMaskView_u24lambda_u2d2.setLayoutParams(new ViewGroup.LayoutParams(getCurrentWidth(), getCurrentHeight()));
        Integer num = this.maskColor;
        $this$initGradientMaskView_u24lambda_u2d2.setColors(num != null ? num.intValue() : ResourceUtils.getColor($this$initGradientMaskView_u24lambda_u2d2.getContext(), R.color.video_flow_collection_detail_mask_default_color_without_poster));
        $this$initGradientMaskView_u24lambda_u2d2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return $this$initGradientMaskView_u24lambda_u2d2;
    }

    /* access modifiers changed from: private */
    public final FrameLayout initDarkMaskView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout $this$initDarkMaskView_u24lambda_u2d4 = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getCurrentWidth(), getCurrentHeight() + BdPlayerUtils.dp2px($this$initDarkMaskView_u24lambda_u2d4, 500.0f));
        FrameLayout.LayoutParams layoutParams2 = layoutParams;
        $this$initDarkMaskView_u24lambda_u2d4.setBackgroundColor(ResourceUtils.getColor($this$initDarkMaskView_u24lambda_u2d4.getContext(), R.color.video_flow_collection_detail_mask_dark));
        $this$initDarkMaskView_u24lambda_u2d4.setVisibility(8);
        $this$initDarkMaskView_u24lambda_u2d4.setLayoutParams(layoutParams);
        return frameLayout;
    }

    public View createView() {
        return getPosterContainer();
    }

    public void onAttachToManager() {
        NightModeState $this$onAttachToManager_u24lambda_u2d10;
        CollectionDetailPosterState $this$onAttachToManager_u24lambda_u2d8;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || ($this$onAttachToManager_u24lambda_u2d8 = (CollectionDetailPosterState) $this$subscribe$iv.subscribe(CollectionDetailPosterState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d8.getBindData().observe(this, new CollectionDetailPosterComponent$$ExternalSyntheticLambda0(this));
        }
        Store $this$subscribe$iv2 = getStore();
        if ($this$subscribe$iv2 != null && ($this$onAttachToManager_u24lambda_u2d10 = (NightModeState) $this$subscribe$iv2.subscribe(NightModeState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d10.getData().observe(this, new CollectionDetailPosterComponent$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-7  reason: not valid java name */
    public static final void m5048onAttachToManager$lambda8$lambda7(CollectionDetailPosterComponent this$0, CollectionDetailPosterModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (model != null) {
            CollectionDetailPosterModel collectionDetailPosterModel = model;
            SimpleDraweeView simpleDraweeView = this$0.posterView;
            if (simpleDraweeView != null) {
                simpleDraweeView.setImageURI(model.getPoster());
            }
            Integer valueOf = Integer.valueOf(this$0.getMaskColor(model));
            this$0.maskColor = valueOf;
            if (valueOf != null) {
                this$0.getGradientMaskView().setColors(valueOf.intValue());
                this$0.getGradientMaskView().setVisibility(0);
            }
        }
        this$0.updateNightMode();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-10$lambda-9  reason: not valid java name */
    public static final void m5047onAttachToManager$lambda10$lambda9(CollectionDetailPosterComponent this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateNightMode();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (getCurrentWidth() != this.posterWidth) {
            refresh(this.posterView);
            refresh(getGradientMaskView());
            this.posterWidth = getCurrentWidth();
        }
    }

    private final void refresh(View view2) {
        ViewGroup.LayoutParams lp;
        int i2;
        if (view2 == null || (lp = view2.getLayoutParams()) == null) {
            lp = null;
        } else {
            ViewGroup.LayoutParams $this$refresh_u24lambda_u2d11 = lp;
            $this$refresh_u24lambda_u2d11.width = getCurrentWidth();
            if (Intrinsics.areEqual((Object) view2, (Object) getDarkMaskView())) {
                i2 = getCurrentHeight() + ViewUtil.dp2px(500.0f);
            } else {
                i2 = getCurrentHeight();
            }
            $this$refresh_u24lambda_u2d11.height = i2;
        }
        if (view2 != null) {
            view2.setLayoutParams(lp);
        }
    }

    private final void updateNightMode() {
        int i2;
        FrameLayout darkMaskView = getDarkMaskView();
        if (NightModeHelper.isNightMode()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        darkMaskView.setVisibility(i2);
    }

    private final int getMaskColor(CollectionDetailPosterModel model) {
        boolean z = true;
        if (model.getMaskColor().length() > 0) {
            return Color.parseColor(model.getMaskColor());
        }
        if (model.getPoster().length() <= 0) {
            z = false;
        }
        if (z) {
            return ResourceUtils.getColor(getContext(), R.color.video_flow_collection_detail_mask_default_color_with_poster);
        }
        return ResourceUtils.getColor(getContext(), R.color.video_flow_collection_detail_mask_default_color_without_poster);
    }
}
