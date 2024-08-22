package com.baidu.searchbox.video.feedflow.flow.collection.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.player.utils.VideoNotchUtils;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelFavorModel;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionCommonModel;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.LimbicView;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.OnViewClickListener;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0006\u0010(\u001a\u00020\u0017J\u0006\u0010)\u001a\u00020\u0017J\b\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020#H\u0002J\u000e\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u000e\u0010\u001b\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u000e\u0010\u001f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/view/CollectionFooterView;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/LimbicView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collectClickListener", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/OnViewClickListener;", "getCollectClickListener", "()Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/OnViewClickListener;", "setCollectClickListener", "(Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/OnViewClickListener;)V", "collectIcon", "Landroid/widget/ImageView;", "collectText", "Landroid/widget/TextView;", "collectionCollect", "Landroid/widget/LinearLayout;", "collectionShare", "isHitShortPlayExperiments", "", "payClickListener", "getPayClickListener", "setPayClickListener", "payText", "shareClickListener", "getShareClickListener", "setShareClickListener", "shareIcon", "shareText", "shortPlayPay", "bindData", "", "data", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/CollectionCommonModel;", "changeStyle", "style", "isCollectionShareBtnVisible", "isShortPlayPayBtnVisible", "setFontAndPictureSize", "switchToLandscapeBlackStyle", "switchToPortraitBlackStyle", "switchToPortraitWhiteStyle", "updateRightButton", "isSupportShortPlayPayBtn", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionFooterView.kt */
public final class CollectionFooterView extends LimbicView {
    private OnViewClickListener collectClickListener;
    private final ImageView collectIcon;
    private final TextView collectText;
    private final LinearLayout collectionCollect;
    private final LinearLayout collectionShare;
    private boolean isHitShortPlayExperiments;
    private OnViewClickListener payClickListener;
    private final TextView payText;
    private OnViewClickListener shareClickListener;
    private final ImageView shareIcon;
    private final TextView shareText;
    private final LinearLayout shortPlayPay;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CollectionFooterView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CollectionFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CollectionFooterView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.video_flow_collection_panel_footer, this);
        View findViewById = findViewById(R.id.collection_collect);
        ((LinearLayout) findViewById).setOnClickListener(new CollectionFooterView$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<LinearLayou…)\n            }\n        }");
        this.collectionCollect = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.collection_collect_icon);
        ((ImageView) findViewById2).setSelected(false);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(…elected = false\n        }");
        this.collectIcon = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.collection_collect_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.collection_collect_text)");
        this.collectText = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.collection_share);
        ((LinearLayout) findViewById4).setOnClickListener(new CollectionFooterView$$ExternalSyntheticLambda1(this));
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<LinearLayou…)\n            }\n        }");
        this.collectionShare = (LinearLayout) findViewById4;
        View findViewById5 = findViewById(R.id.collection_share_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.collection_share_icon)");
        this.shareIcon = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.collection_share_text);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.collection_share_text)");
        this.shareText = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.collection_pay);
        ((LinearLayout) findViewById7).setOnClickListener(new CollectionFooterView$$ExternalSyntheticLambda2(this));
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById<LinearLayou…)\n            }\n        }");
        this.shortPlayPay = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R.id.collection_pay_text);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.collection_pay_text)");
        this.payText = (TextView) findViewById8;
    }

    public final OnViewClickListener getCollectClickListener() {
        return this.collectClickListener;
    }

    public final void setCollectClickListener(OnViewClickListener onViewClickListener) {
        this.collectClickListener = onViewClickListener;
    }

    public final OnViewClickListener getShareClickListener() {
        return this.shareClickListener;
    }

    public final void setShareClickListener(OnViewClickListener onViewClickListener) {
        this.shareClickListener = onViewClickListener;
    }

    public final OnViewClickListener getPayClickListener() {
        return this.payClickListener;
    }

    public final void setPayClickListener(OnViewClickListener onViewClickListener) {
        this.payClickListener = onViewClickListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-1$lambda-0  reason: not valid java name */
    public static final void m6224lambda1$lambda0(CollectionFooterView this$0, View collectView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnViewClickListener onViewClickListener = this$0.collectClickListener;
        if (onViewClickListener != null) {
            Intrinsics.checkNotNullExpressionValue(collectView, "collectView");
            onViewClickListener.onViewClicked(collectView);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-4$lambda-3  reason: not valid java name */
    public static final void m6225lambda4$lambda3(CollectionFooterView this$0, View shareView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnViewClickListener onViewClickListener = this$0.shareClickListener;
        if (onViewClickListener != null) {
            Intrinsics.checkNotNullExpressionValue(shareView, "shareView");
            onViewClickListener.onViewClicked(shareView);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-6$lambda-5  reason: not valid java name */
    public static final void m6226lambda6$lambda5(CollectionFooterView this$0, View payView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnViewClickListener onViewClickListener = this$0.payClickListener;
        if (onViewClickListener != null) {
            Intrinsics.checkNotNullExpressionValue(payView, "payView");
            onViewClickListener.onViewClicked(payView);
        }
    }

    public void bindData(CollectionCommonModel data) {
        CollectionPanelFavorModel $this$bindData_u24lambda_u2d9;
        CharSequence charSequence;
        CharSequence charSequence2;
        Intrinsics.checkNotNullParameter(data, "data");
        if (CollectionFooterViewKt.isCollectionFooter(data) && ($this$bindData_u24lambda_u2d9 = CollectionFooterViewKt.getCollectionPanelFooterModel(data)) != null) {
            boolean z = false;
            setVisibility($this$bindData_u24lambda_u2d9.isAuthorColl() ? 0 : 8);
            LinearLayout $this$bindData_u24lambda_u2d9_u24lambda_u2d7 = this.collectionShare;
            $this$bindData_u24lambda_u2d9_u24lambda_u2d7.setClickable($this$bindData_u24lambda_u2d9.isSupportShare());
            float f2 = 1.0f;
            $this$bindData_u24lambda_u2d9_u24lambda_u2d7.setAlpha($this$bindData_u24lambda_u2d9.isSupportShare() ? 1.0f : 0.34f);
            LinearLayout $this$bindData_u24lambda_u2d9_u24lambda_u2d8 = this.collectionCollect;
            if ($this$bindData_u24lambda_u2d9.isAuthorColl() && $this$bindData_u24lambda_u2d9.isDataBack()) {
                z = true;
            }
            $this$bindData_u24lambda_u2d9_u24lambda_u2d8.setClickable(z);
            if (!$this$bindData_u24lambda_u2d9.isAuthorColl() || !$this$bindData_u24lambda_u2d9.isDataBack()) {
                f2 = 0.34f;
            }
            $this$bindData_u24lambda_u2d9_u24lambda_u2d8.setAlpha(f2);
            if ($this$bindData_u24lambda_u2d9.isHitShortPlayExperiment()) {
                this.collectIcon.setImageResource(R.drawable.video_flow_collection_shortplay_collect_selector);
            }
            this.isHitShortPlayExperiments = $this$bindData_u24lambda_u2d9.isHitShortPlayExperiment();
            this.collectIcon.setSelected($this$bindData_u24lambda_u2d9.isFavor());
            TextView textView = this.collectText;
            if ($this$bindData_u24lambda_u2d9.isFavor() && $this$bindData_u24lambda_u2d9.isHitShortPlayExperiment() && $this$bindData_u24lambda_u2d9.isShortPlay()) {
                charSequence = getResources().getText(R.string.video_flow_collection_collected_favor_short_play);
            } else if ($this$bindData_u24lambda_u2d9.isFavor() && !$this$bindData_u24lambda_u2d9.isHitShortPlayExperiment()) {
                charSequence = getResources().getText(R.string.video_flow_collection_collected);
            } else if (!$this$bindData_u24lambda_u2d9.isFavor() && $this$bindData_u24lambda_u2d9.isShortPlay() && $this$bindData_u24lambda_u2d9.isHitShortPlayExperiment()) {
                charSequence = getResources().getText(R.string.video_flow_collection_detail_collect_favor_short_play);
            } else if ($this$bindData_u24lambda_u2d9.isFavor() || !$this$bindData_u24lambda_u2d9.isShortPlay() || $this$bindData_u24lambda_u2d9.isHitShortPlayExperiment()) {
                charSequence = getResources().getText(R.string.video_flow_collection_collect);
            } else {
                charSequence = getResources().getText(R.string.video_flow_collection_short_play);
            }
            textView.setText(charSequence);
            TextView textView2 = this.shareText;
            if ($this$bindData_u24lambda_u2d9.isShortPlay()) {
                charSequence2 = getResources().getText(R.string.video_flow_collection_share_short_play);
            } else {
                charSequence2 = getResources().getText(R.string.video_flow_collection_share);
            }
            textView2.setText(charSequence2);
            this.payText.setText($this$bindData_u24lambda_u2d9.getPayBtnText());
            updateRightButton($this$bindData_u24lambda_u2d9.isSupportShortPlayPayBtn());
        }
    }

    public final void updateRightButton(boolean isSupportShortPlayPayBtn) {
        if (isSupportShortPlayPayBtn) {
            this.collectionShare.setVisibility(8);
            this.shortPlayPay.setVisibility(0);
            return;
        }
        this.collectionShare.setVisibility(0);
        this.shortPlayPay.setVisibility(8);
    }

    public final boolean isCollectionShareBtnVisible() {
        return this.collectionShare.getVisibility() == 0;
    }

    public final boolean isShortPlayPayBtnVisible() {
        return this.shortPlayPay.getVisibility() == 0;
    }

    private final void switchToPortraitWhiteStyle() {
    }

    private final void switchToPortraitBlackStyle() {
        this.collectionCollect.setBackground(ResourceUtils.getDrawable(getContext(), R.drawable.video_flow_collection_collect_button_bg_dark));
        if (this.isHitShortPlayExperiments) {
            this.collectIcon.setImageResource(R.drawable.video_flow_collection_shortplay_collect_selector);
        } else {
            this.collectIcon.setImageResource(R.drawable.video_flow_collection_collect_selector_dark);
        }
        this.collectText.setTextColor(ResourceUtils.getColor(getContext(), R.color.video_flow_color_FFFFFFFF));
        this.collectionShare.setBackground(ResourceUtils.getDrawable(getContext(), R.drawable.video_flow_collection_collect_button_bg_dark));
        this.shareIcon.setImageResource(R.drawable.video_flow_collection_share_dark);
        this.shareText.setTextColor(ResourceUtils.getColor(getContext(), R.color.video_flow_color_FFFFFFFF));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        RelativeLayout.LayoutParams $this$switchToPortraitBlackStyle_u24lambda_u2d10 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if ($this$switchToPortraitBlackStyle_u24lambda_u2d10 != null) {
            $this$switchToPortraitBlackStyle_u24lambda_u2d10.leftMargin = getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_15dp);
            $this$switchToPortraitBlackStyle_u24lambda_u2d10.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_7_5dp);
        }
    }

    private final void switchToLandscapeBlackStyle() {
        int viewBottomMargin;
        this.collectionCollect.setBackground(ResourceUtils.getDrawable(getContext(), R.drawable.video_flow_collection_collect_button_bg_dark));
        if (this.isHitShortPlayExperiments) {
            this.collectIcon.setImageResource(R.drawable.video_flow_collection_shortplay_collect_selector);
        } else {
            this.collectIcon.setImageResource(R.drawable.video_flow_collection_collect_selector_dark);
        }
        this.collectText.setTextColor(ResourceUtils.getColor(getContext(), R.color.video_flow_color_B2FFFFFF));
        this.collectionShare.setBackground(ResourceUtils.getDrawable(getContext(), R.drawable.video_flow_collection_collect_button_bg_dark));
        this.shareIcon.setImageResource(R.drawable.video_flow_collection_share_dark);
        this.shareText.setTextColor(ResourceUtils.getColor(getContext(), R.color.video_flow_color_B2FFFFFF));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        RelativeLayout.LayoutParams $this$switchToLandscapeBlackStyle_u24lambda_u2d11 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if ($this$switchToLandscapeBlackStyle_u24lambda_u2d11 != null) {
            $this$switchToLandscapeBlackStyle_u24lambda_u2d11.leftMargin = getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_9dp);
            if (VideoNotchUtils.isNavigationBarShown(VideoFlowUtilsKt.getActivity(getContext()))) {
                viewBottomMargin = getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_17dp);
            } else {
                viewBottomMargin = getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_14dp);
            }
            $this$switchToLandscapeBlackStyle_u24lambda_u2d11.bottomMargin = viewBottomMargin;
        }
    }

    public void changeStyle(int style) {
        switch (style) {
            case 1:
                switchToLandscapeBlackStyle();
                break;
            case 2:
                switchToPortraitBlackStyle();
                break;
            case 3:
                switchToPortraitWhiteStyle();
                break;
            default:
                switchToPortraitWhiteStyle();
                break;
        }
        setFontAndPictureSize();
    }

    private final void setFontAndPictureSize() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.collectIcon, com.baidu.searchbox.video.detail.business.R.dimen.dimen_14dp, com.baidu.searchbox.video.detail.business.R.dimen.dimen_14dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.collectText, com.baidu.searchbox.video.detail.business.R.dimen.dimen_14dp, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.shareIcon, com.baidu.searchbox.video.detail.business.R.dimen.dimen_14dp, com.baidu.searchbox.video.detail.business.R.dimen.dimen_14dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.shareText, com.baidu.searchbox.video.detail.business.R.dimen.dimen_14dp, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.payText, com.baidu.searchbox.video.detail.business.R.dimen.dimen_14dp, 0, 0, 6, (Object) null);
    }
}
