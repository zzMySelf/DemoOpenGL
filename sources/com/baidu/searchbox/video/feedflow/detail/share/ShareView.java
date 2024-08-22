package com.baidu.searchbox.video.feedflow.detail.share;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.player.utils.InteractAreaIconScaleRatio;
import com.baidu.searchbox.player.utils.LayerUtil;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.utils.ScaleAnimHelperKt;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u00012B-\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0019H\u0014J\u0006\u0010!\u001a\u00020\u0019J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\nJ\u0018\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u0013J\u0010\u0010+\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010\u0002J\b\u0010-\u001a\u00020\u0019H\u0002J\u000e\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0006J\u000e\u00100\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\b\u00101\u001a\u00020\u0019H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/share/ShareView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "isBottomInteractAreaStyle", "", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;ZLandroid/util/AttributeSet;I)V", "clickListener", "isEnableShare", "shareBtnView", "Landroid/widget/ImageView;", "getShareBtnView", "()Landroid/widget/ImageView;", "shareCount", "", "shareScaleAnimator", "Landroid/animation/Animator;", "shareTextView", "Landroid/widget/TextView;", "autoSizeTextAndNum", "", "initClickScaleAnimator", "initShareBtnView", "initShareTextView", "onClick", "view", "Landroid/view/View;", "onDetachedFromWindow", "reset", "setFontAndPictureSize", "style", "Lcom/baidu/searchbox/video/feedflow/detail/share/ShareView$ShareViewStyle;", "setShareBtnResource", "resId", "setShareText", "text", "", "count", "setShareViewClickListener", "listener", "updateHorizontalStyle", "updateShareViewEnable", "isEnable", "updateStyle", "updateVerticalStyle", "ShareViewStyle", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShareView.kt */
public final class ShareView extends LinearLayout implements View.OnClickListener {
    private View.OnClickListener clickListener;
    private final boolean isBottomInteractAreaStyle;
    private boolean isEnableShare;
    private final ImageView shareBtnView;
    private long shareCount;
    private Animator shareScaleAnimator;
    private final TextView shareTextView;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/share/ShareView$ShareViewStyle;", "", "(Ljava/lang/String;I)V", "VERTICAL_STYLE", "HORIZONTAL_STYLE", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShareView.kt */
    public enum ShareViewStyle {
        VERTICAL_STYLE,
        HORIZONTAL_STYLE
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShareView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShareViewStyle.values().length];
            iArr[ShareViewStyle.VERTICAL_STYLE.ordinal()] = 1;
            iArr[ShareViewStyle.HORIZONTAL_STYLE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareView(Context context, boolean z) {
        this(context, z, (AttributeSet) null, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareView(Context context, boolean z, AttributeSet attributeSet) {
        this(context, z, attributeSet, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareView(Context context, boolean z, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z, (i3 & 4) != 0 ? null : attributeSet, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareView(Context context, boolean isBottomInteractAreaStyle2, AttributeSet attrs, int def) {
        super(context, attrs, def);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isBottomInteractAreaStyle = isBottomInteractAreaStyle2;
        this.isEnableShare = true;
        setClipToPadding(false);
        setGravity(17);
        ImageView initShareBtnView = initShareBtnView();
        this.shareBtnView = initShareBtnView;
        initShareBtnView.setId(R.id.video_flow_view_share_icon);
        addView(initShareBtnView);
        TextView initShareTextView = initShareTextView();
        this.shareTextView = initShareTextView;
        initShareTextView.setId(R.id.video_flow_view_share_text);
        addView(initShareTextView);
        updateStyle(ShareViewStyle.VERTICAL_STYLE);
        initClickScaleAnimator();
        setOnClickListener(this);
        autoSizeTextAndNum();
    }

    public final ImageView getShareBtnView() {
        return this.shareBtnView;
    }

    private final void initClickScaleAnimator() {
        this.shareScaleAnimator = ScaleAnimHelperKt.createScaleAnim(this.shareBtnView);
    }

    private final ImageView initShareBtnView() {
        ImageView $this$initShareBtnView_u24lambda_u2d0 = new ImageView(getContext());
        $this$initShareBtnView_u24lambda_u2d0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setGravity(17);
        return $this$initShareBtnView_u24lambda_u2d0;
    }

    private final TextView initShareTextView() {
        TextView textView = new TextView(getContext());
        TextView $this$initShareTextView_u24lambda_u2d1 = textView;
        $this$initShareTextView_u24lambda_u2d1.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        $this$initShareTextView_u24lambda_u2d1.setGravity(17);
        $this$initShareTextView_u24lambda_u2d1.setIncludeFontPadding(false);
        $this$initShareTextView_u24lambda_u2d1.setMaxLines(1);
        $this$initShareTextView_u24lambda_u2d1.setEllipsize(TextUtils.TruncateAt.END);
        $this$initShareTextView_u24lambda_u2d1.setText($this$initShareTextView_u24lambda_u2d1.getContext().getString(R.string.video_flow_share_text));
        $this$initShareTextView_u24lambda_u2d1.setTextColor(ContextCompat.getColor($this$initShareTextView_u24lambda_u2d1.getContext(), com.baidu.searchbox.feed.styles.R.color.FC410));
        $this$initShareTextView_u24lambda_u2d1.setShadowLayer($this$initShareTextView_u24lambda_u2d1.getContext().getResources().getDimension(R.dimen.video_flow_dimens_1px), 0.0f, 0.0f, ContextCompat.getColor($this$initShareTextView_u24lambda_u2d1.getContext(), R.color.video_flow_color_4D000000));
        return textView;
    }

    public final void setFontAndPictureSize(ShareViewStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        switch (WhenMappings.$EnumSwitchMapping$0[style.ordinal()]) {
            case 1:
                FontSizeHelperKt.setVideoScaledSizeRes$default(this.shareTextView, R.dimen.video_flow_dimens_11dp, 0, 0, 6, (Object) null);
                if (this.isBottomInteractAreaStyle) {
                    FontSizeViewExtKt.setScaledSizeRes$default(this.shareBtnView, InteractAreaIconScaleRatio.INSTANCE.getINTERACT_AREA_ICON_SCALE_TYPE(), R.dimen.video_flow_dimens_26dp, R.dimen.video_flow_dimens_26dp, 0, 8, (Object) null);
                    return;
                }
                return;
            case 2:
                FontSizeHelperKt.setVideoScaledSizeRes$default(this.shareTextView, R.dimen.video_flow_dimens_12dp, 0, 0, 6, (Object) null);
                return;
            default:
                return;
        }
    }

    public final void updateShareViewEnable(boolean isEnable) {
        this.isEnableShare = isEnable;
        float f2 = 1.0f;
        this.shareBtnView.setAlpha(isEnable ? 1.0f : 0.3f);
        TextView textView = this.shareTextView;
        if (!isEnable) {
            f2 = 0.3f;
        }
        textView.setAlpha(f2);
        if (!isEnable) {
            String string = getContext().getString(R.string.video_flow_share_text);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.video_flow_share_text)");
            setShareText(string, 0);
        }
        setOnTouchListener(isEnable ? new TouchStateListener() : null);
    }

    public static /* synthetic */ void setShareText$default(ShareView shareView, String str, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        shareView.setShareText(str, j2);
    }

    public final void setShareText(String text, long count) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.shareTextView.setText(text);
        this.shareCount = count;
        autoSizeTextAndNum();
    }

    public final void updateStyle(ShareViewStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        switch (WhenMappings.$EnumSwitchMapping$0[style.ordinal()]) {
            case 1:
                updateVerticalStyle();
                return;
            case 2:
                updateHorizontalStyle();
                return;
            default:
                return;
        }
    }

    private final void updateVerticalStyle() {
        setOrientation(1);
        if (!this.isBottomInteractAreaStyle) {
            setPadding(0, BdPlayerUtils.dp2px(this, 6.5f), 0, 0);
        } else {
            setPadding(0, 0, 0, 0);
        }
        ImageView $this$updateVerticalStyle_u24lambda_u2d3 = this.shareBtnView;
        ViewGroup.LayoutParams layoutParams = $this$updateVerticalStyle_u24lambda_u2d3.getLayoutParams();
        LinearLayout.LayoutParams $this$updateVerticalStyle_u24lambda_u2d3_u24lambda_u2d2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if ($this$updateVerticalStyle_u24lambda_u2d3_u24lambda_u2d2 != null) {
            $this$updateVerticalStyle_u24lambda_u2d3_u24lambda_u2d2.width = $this$updateVerticalStyle_u24lambda_u2d3.getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_36dp);
            $this$updateVerticalStyle_u24lambda_u2d3_u24lambda_u2d2.height = $this$updateVerticalStyle_u24lambda_u2d3.getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_36dp);
        }
        if (this.isBottomInteractAreaStyle) {
            $this$updateVerticalStyle_u24lambda_u2d3.setImageResource(R.drawable.video_flow_share_btn_portrait_img_bottom);
            FontSizeViewExtKt.setScaledSizeRes$default($this$updateVerticalStyle_u24lambda_u2d3, InteractAreaIconScaleRatio.INSTANCE.getINTERACT_AREA_ICON_SCALE_TYPE(), R.dimen.video_flow_dimens_26dp, R.dimen.video_flow_dimens_26dp, 0, 8, (Object) null);
        } else {
            $this$updateVerticalStyle_u24lambda_u2d3.setImageResource(R.drawable.video_flow_share_btn_portrait_img_new);
        }
        TextView $this$updateVerticalStyle_u24lambda_u2d5 = this.shareTextView;
        ViewGroup.LayoutParams layoutParams2 = $this$updateVerticalStyle_u24lambda_u2d5.getLayoutParams();
        LinearLayout.LayoutParams $this$updateVerticalStyle_u24lambda_u2d5_u24lambda_u2d4 = layoutParams2 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams2 : null;
        if ($this$updateVerticalStyle_u24lambda_u2d5_u24lambda_u2d4 != null) {
            $this$updateVerticalStyle_u24lambda_u2d5_u24lambda_u2d4.topMargin = 0;
            $this$updateVerticalStyle_u24lambda_u2d5_u24lambda_u2d4.leftMargin = 0;
        }
        FontSizeHelperKt.setVideoScaledSizeRes$default($this$updateVerticalStyle_u24lambda_u2d5, R.dimen.video_flow_dimens_11dp, 0, 0, 6, (Object) null);
        $this$updateVerticalStyle_u24lambda_u2d5.setTypeface(Typeface.DEFAULT);
        $this$updateVerticalStyle_u24lambda_u2d5.setIncludeFontPadding(false);
        LayerUtil.setFontFakeBold$default($this$updateVerticalStyle_u24lambda_u2d5, false, 0.0f, 2, (Object) null);
    }

    private final void autoSizeTextAndNum() {
        if (!this.isBottomInteractAreaStyle) {
            VideoFlowUtilsKt.autoSetInteractiveContainerPadding$default(this.shareTextView, this, getOrientation() == 0, 0, new ShareView$autoSizeTextAndNum$1(this), 4, (Object) null);
        }
    }

    private final void updateHorizontalStyle() {
        boolean z = false;
        setOrientation(0);
        setPadding(0, 0, 0, 0);
        ImageView $this$updateHorizontalStyle_u24lambda_u2d7 = this.shareBtnView;
        ViewGroup.LayoutParams layoutParams = $this$updateHorizontalStyle_u24lambda_u2d7.getLayoutParams();
        LinearLayout.LayoutParams $this$updateHorizontalStyle_u24lambda_u2d7_u24lambda_u2d6 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if ($this$updateHorizontalStyle_u24lambda_u2d7_u24lambda_u2d6 != null) {
            $this$updateHorizontalStyle_u24lambda_u2d7_u24lambda_u2d6.width = $this$updateHorizontalStyle_u24lambda_u2d7.getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_30dp);
            $this$updateHorizontalStyle_u24lambda_u2d7_u24lambda_u2d6.height = $this$updateHorizontalStyle_u24lambda_u2d7.getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_30dp);
        }
        $this$updateHorizontalStyle_u24lambda_u2d7.setImageResource(R.drawable.video_flow_share_btn_landscape_img);
        TextView $this$updateHorizontalStyle_u24lambda_u2d9 = this.shareTextView;
        ViewGroup.LayoutParams layoutParams2 = $this$updateHorizontalStyle_u24lambda_u2d9.getLayoutParams();
        LinearLayout.LayoutParams $this$updateHorizontalStyle_u24lambda_u2d9_u24lambda_u2d8 = layoutParams2 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams2 : null;
        if ($this$updateHorizontalStyle_u24lambda_u2d9_u24lambda_u2d8 != null) {
            $this$updateHorizontalStyle_u24lambda_u2d9_u24lambda_u2d8.topMargin = 0;
            $this$updateHorizontalStyle_u24lambda_u2d9_u24lambda_u2d8.leftMargin = $this$updateHorizontalStyle_u24lambda_u2d9.getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_4dp);
        }
        FontSizeHelperKt.setVideoScaledSizeRes$default($this$updateHorizontalStyle_u24lambda_u2d9, R.dimen.video_flow_dimens_12dp, 0, 0, 6, (Object) null);
        $this$updateHorizontalStyle_u24lambda_u2d9.setIncludeFontPadding(true);
        if (this.shareCount > 0) {
            z = true;
        }
        LayerUtil.setFontFakeBold$default($this$updateHorizontalStyle_u24lambda_u2d9, z, 0.0f, 2, (Object) null);
    }

    public final void setShareBtnResource(int resId) {
        if (resId > 0) {
            this.shareBtnView.setImageResource(resId);
        }
    }

    public final void setShareViewClickListener(View.OnClickListener listener) {
        this.clickListener = listener;
    }

    public final void reset() {
        ScaleAnimHelperKt.cancelScaleAnim(this.shareScaleAnimator);
        this.shareBtnView.setScaleX(1.0f);
        this.shareBtnView.setScaleY(1.0f);
    }

    public void onClick(View view2) {
        if (this.isEnableShare) {
            ScaleAnimHelperKt.startScaleAnim(this.shareScaleAnimator);
            View.OnClickListener onClickListener = this.clickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
        ScaleAnimHelperKt.releaseScaleAnim(this.shareScaleAnimator);
    }
}
