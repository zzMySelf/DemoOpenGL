package com.baidu.searchbox.video.feedflow.ad.adreminder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.nadcore.utils.ColorUtils;
import com.baidu.nadcore.utils.DeviceUtils;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.video.feedflow.ad.R;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010%\u001a\u00020\u001dJ\u000e\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0013J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0015\u0010\u000fR\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/adreminder/NadReminderView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "data", "Lcom/baidu/searchbox/video/feedflow/ad/adreminder/NadReminderModel;", "leftIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getLeftIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "leftIcon$delegate", "Lkotlin/Lazy;", "reminderListener", "Lcom/baidu/searchbox/video/feedflow/ad/adreminder/NadReminderView$NadReminderListener;", "rightIcon", "getRightIcon", "rightIcon$delegate", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "text$delegate", "onClick", "", "v", "Landroid/view/View;", "resetLayout", "resetLeftIconLayout", "resetRightIconLayout", "resetTextLayout", "setData", "setFontSize", "setOuterListener", "listener", "updateLayout", "NadReminderListener", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadReminderView.kt */
public final class NadReminderView extends RelativeLayout implements View.OnClickListener {
    private NadReminderModel data;
    private final Lazy leftIcon$delegate;
    private NadReminderListener reminderListener;
    private final Lazy rightIcon$delegate;
    private final Lazy text$delegate;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/adreminder/NadReminderView$NadReminderListener;", "", "onClick", "", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadReminderView.kt */
    public interface NadReminderListener {
        void onClick();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NadReminderView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NadReminderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NadReminderView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NadReminderView(Context context, AttributeSet attributeSet, int style) {
        super(context, attributeSet, style);
        Intrinsics.checkNotNullParameter(context, "context");
        this.leftIcon$delegate = LazyKt.lazy(new NadReminderView$leftIcon$2(this));
        this.text$delegate = LazyKt.lazy(new NadReminderView$text$2(this));
        this.rightIcon$delegate = LazyKt.lazy(new NadReminderView$rightIcon$2(this));
        this.data = new NadReminderModel();
        RelativeLayout.inflate(context, R.layout.video_flow_ad_reminder_layout, this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.video_flow_ad_12dp);
        setLayoutParams(layoutParams);
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getLeftIcon().getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setUseGlobalColorFilter(false);
        }
        GenericDraweeHierarchy genericDraweeHierarchy2 = (GenericDraweeHierarchy) getRightIcon().getHierarchy();
        if (genericDraweeHierarchy2 != null) {
            genericDraweeHierarchy2.setUseGlobalColorFilter(false);
        }
    }

    /* access modifiers changed from: private */
    public final SimpleDraweeView getLeftIcon() {
        Object value = this.leftIcon$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-leftIcon>(...)");
        return (SimpleDraweeView) value;
    }

    /* access modifiers changed from: private */
    public final TextView getText() {
        Object value = this.text$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-text>(...)");
        return (TextView) value;
    }

    /* access modifiers changed from: private */
    public final SimpleDraweeView getRightIcon() {
        Object value = this.rightIcon$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-rightIcon>(...)");
        return (SimpleDraweeView) value;
    }

    public final void setData(NadReminderModel data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.data = data2;
        setVisibility(0);
        CharSequence charSequence = data2.leftIcon;
        boolean z = true;
        if (!(charSequence == null || charSequence.length() == 0)) {
            getLeftIcon().setImageURI(data2.leftIcon);
            getLeftIcon().setVisibility(0);
            getLeftIcon().setOnClickListener(this);
        } else {
            getLeftIcon().setVisibility(8);
            getLeftIcon().setOnClickListener((View.OnClickListener) null);
        }
        CharSequence charSequence2 = data2.rightIcon;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            getRightIcon().setImageURI(data2.rightIcon);
            getRightIcon().setVisibility(0);
            getRightIcon().setOnClickListener(this);
        } else {
            getRightIcon().setVisibility(8);
            getRightIcon().setOnClickListener((View.OnClickListener) null);
        }
        CharSequence charSequence3 = data2.text;
        if (!(charSequence3 == null || charSequence3.length() == 0)) {
            z = false;
        }
        if (!z) {
            getText().setText(data2.text);
            getText().setTextColor(ColorUtils.parseColorSafe(data2.textColor, com.baidu.nadcore.uad.R.color.nad_color_white));
            getText().setVisibility(0);
            getText().setOnClickListener(this);
        } else {
            getText().setVisibility(8);
            getText().setOnClickListener((View.OnClickListener) null);
        }
        updateLayout(data2);
    }

    public final void setOuterListener(NadReminderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.reminderListener = listener;
    }

    public final void setFontSize() {
        switch (this.data.style) {
            case 1:
                FontSizeViewExtKt.setScaledSize$default(getLeftIcon(), 0, this.data.leftIconWhRatio * ((float) DeviceUtils.ScreenInfo.dp2px(getContext(), 16.0f)), (float) DeviceUtils.ScreenInfo.dp2px(getContext(), 16.0f), 0, 8, (Object) null);
                FontSizeViewExtKt.setScaledSizeRes$default(getRightIcon(), 0, R.dimen.video_flow_ad_reminder_right_icon_wh, R.dimen.video_flow_ad_reminder_right_icon_wh, 0, 8, (Object) null);
                FontSizeTextViewExtKt.setScaledSizeRes$default(getText(), 0, R.dimen.video_flow_ad_reminder_text_size, 0, 4, (Object) null);
                return;
            case 2:
                FontSizeViewExtKt.setScaledSize$default(getLeftIcon(), 0, this.data.leftIconWhRatio * ((float) DeviceUtils.ScreenInfo.dp2px(getContext(), 16.0f)), (float) DeviceUtils.ScreenInfo.dp2px(getContext(), 16.0f), 0, 8, (Object) null);
                FontSizeViewExtKt.setScaledSizeRes$default(getRightIcon(), 0, R.dimen.video_flow_ad_reminder_banner_right_icon_wh, R.dimen.video_flow_ad_reminder_banner_right_icon_wh, 0, 8, (Object) null);
                FontSizeTextViewExtKt.setScaledSizeRes$default(getText(), 0, R.dimen.video_flow_ad_reminder_banner_text_size, 0, 4, (Object) null);
                return;
            default:
                FontSizeViewExtKt.setScaledSizeRes$default(getLeftIcon(), 0, R.dimen.video_flow_ad_reminder_left_icon_wh, R.dimen.video_flow_ad_reminder_left_icon_wh, 0, 8, (Object) null);
                FontSizeViewExtKt.setScaledSizeRes$default(getRightIcon(), 0, R.dimen.video_flow_ad_reminder_right_icon_wh, R.dimen.video_flow_ad_reminder_right_icon_wh, 0, 8, (Object) null);
                FontSizeTextViewExtKt.setScaledSizeRes$default(getText(), 0, R.dimen.video_flow_ad_reminder_text_size, 0, 4, (Object) null);
                return;
        }
    }

    private final void updateLayout(NadReminderModel data2) {
        getViewTreeObserver().addOnGlobalLayoutListener(new NadReminderView$updateLayout$1(this, data2));
    }

    /* access modifiers changed from: private */
    public final void resetLeftIconLayout() {
        if (getLeftIcon().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = getLeftIcon().getLayoutParams();
            RelativeLayout.LayoutParams lp = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
            if (lp != null) {
                RelativeLayout.LayoutParams $this$resetLeftIconLayout_u24lambda_u2d0 = lp;
                $this$resetLeftIconLayout_u24lambda_u2d0.height = DeviceUtils.ScreenInfo.dp2px(getContext(), 10.0f);
                $this$resetLeftIconLayout_u24lambda_u2d0.width = DeviceUtils.ScreenInfo.dp2px(getContext(), 10.0f);
                $this$resetLeftIconLayout_u24lambda_u2d0.rightMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 5.0f);
                $this$resetLeftIconLayout_u24lambda_u2d0.addRule(9, 1);
                $this$resetLeftIconLayout_u24lambda_u2d0.addRule(15, 1);
                GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getLeftIcon().getHierarchy();
                if (genericDraweeHierarchy != null) {
                    genericDraweeHierarchy.setPlaceholderImage(R.drawable.video_flow_ad_reminder_icon_placeholder);
                }
                GenericDraweeHierarchy genericDraweeHierarchy2 = (GenericDraweeHierarchy) getLeftIcon().getHierarchy();
                if (genericDraweeHierarchy2 != null) {
                    genericDraweeHierarchy2.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
                }
                getLeftIcon().setLayoutParams(lp);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void resetRightIconLayout() {
        if (getRightIcon().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = getRightIcon().getLayoutParams();
            RelativeLayout.LayoutParams lp = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
            if (lp != null) {
                RelativeLayout.LayoutParams $this$resetRightIconLayout_u24lambda_u2d1 = lp;
                $this$resetRightIconLayout_u24lambda_u2d1.height = DeviceUtils.ScreenInfo.dp2px(getContext(), 9.0f);
                $this$resetRightIconLayout_u24lambda_u2d1.width = DeviceUtils.ScreenInfo.dp2px(getContext(), 9.0f);
                $this$resetRightIconLayout_u24lambda_u2d1.addRule(17, R.id.nad_reminder_text);
                $this$resetRightIconLayout_u24lambda_u2d1.addRule(15, 1);
                $this$resetRightIconLayout_u24lambda_u2d1.addRule(11, 0);
                getRightIcon().setLayoutParams(lp);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void resetTextLayout() {
        if (getText().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = getText().getLayoutParams();
            RelativeLayout.LayoutParams lp = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
            if (lp != null) {
                RelativeLayout.LayoutParams $this$resetTextLayout_u24lambda_u2d2 = lp;
                $this$resetTextLayout_u24lambda_u2d2.topMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 0.0f);
                $this$resetTextLayout_u24lambda_u2d2.bottomMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 0.0f);
                getText().setLayoutParams(lp);
                getText().setTextSize(0, getResources().getDimension(R.dimen.video_flow_ad_reminder_text_size));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void resetLayout() {
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
        lp.topMargin = getResources().getDimensionPixelSize(R.dimen.video_flow_ad_12dp);
        NadReminderView $this$resetLayout_u24lambda_u2d3 = this;
        $this$resetLayout_u24lambda_u2d3.setPadding(0, 0, 0, 0);
        $this$resetLayout_u24lambda_u2d3.setLayoutParams(lp);
        $this$resetLayout_u24lambda_u2d3.setBackground((Drawable) null);
    }

    public void onClick(View v) {
        NadReminderListener nadReminderListener = this.reminderListener;
        if (nadReminderListener != null) {
            nadReminderListener.onClick();
        }
    }
}
