package com.baidu.searchbox.player.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.videoplayer.vulcan.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0001H\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/player/widget/ThreeDivideGuideView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "createBrightView", "Landroidx/appcompat/widget/AppCompatImageView;", "createScrollUpView", "createVerticalDottedLine", "Lcom/baidu/searchbox/player/widget/VerticalDottedLineView;", "createVolumeView", "getScrollUpLottie", "", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThreeDivideGuideView.kt */
public final class ThreeDivideGuideView extends LinearLayout {
    public Map<Integer, View> _$_findViewCache;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ThreeDivideGuideView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ThreeDivideGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThreeDivideGuideView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        setOrientation(0);
        setGravity(16);
        addView(createBrightView());
        addView(createVerticalDottedLine());
        addView(createScrollUpView());
        addView(createVerticalDottedLine());
        addView(createVolumeView());
        setBackgroundColor(ContextCompat.getColor(context, R.color.videoplayer_vulcan_guide_bg_color));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThreeDivideGuideView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final AppCompatImageView createBrightView() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        AppCompatImageView $this$createBrightView_u24lambda_u2d0 = appCompatImageView;
        $this$createBrightView_u24lambda_u2d0.setImageResource(R.drawable.videoplayer_vulcan_guide_brightness);
        $this$createBrightView_u24lambda_u2d0.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        return appCompatImageView;
    }

    private final AppCompatImageView createVolumeView() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        AppCompatImageView $this$createVolumeView_u24lambda_u2d1 = appCompatImageView;
        $this$createVolumeView_u24lambda_u2d1.setImageResource(R.drawable.videoplayer_vulcan_guide_volume);
        $this$createVolumeView_u24lambda_u2d1.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        return appCompatImageView;
    }

    private final VerticalDottedLineView createVerticalDottedLine() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        VerticalDottedLineView $this$createVerticalDottedLine_u24lambda_u2d2 = new VerticalDottedLineView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$createVerticalDottedLine_u24lambda_u2d2.setLayoutParams(new LinearLayout.LayoutParams($this$createVerticalDottedLine_u24lambda_u2d2.getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_2), -1));
        return $this$createVerticalDottedLine_u24lambda_u2d2;
    }

    private final LinearLayout createScrollUpView() {
        LinearLayout verticalContainer = new LinearLayout(getContext());
        LinearLayout $this$createScrollUpView_u24lambda_u2d3 = verticalContainer;
        $this$createScrollUpView_u24lambda_u2d3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 8.0f));
        $this$createScrollUpView_u24lambda_u2d3.setGravity(17);
        $this$createScrollUpView_u24lambda_u2d3.setOrientation(1);
        LinearLayout.LayoutParams imageViewParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_280), getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_250));
        PAGView lottieView = new PAGView(getContext());
        PAGView $this$createScrollUpView_u24lambda_u2d4 = lottieView;
        $this$createScrollUpView_u24lambda_u2d4.setRepeatCount(-1);
        $this$createScrollUpView_u24lambda_u2d4.setPath(getScrollUpLottie());
        lottieView.play();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        BeginnerGuideTextView beginnerGuideTextView = new BeginnerGuideTextView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        BeginnerGuideTextView $this$createScrollUpView_u24lambda_u2d6 = beginnerGuideTextView;
        $this$createScrollUpView_u24lambda_u2d6.setText($this$createScrollUpView_u24lambda_u2d6.getContext().getString(R.string.videoplayer_vulcan_scroll_up_guide));
        LinearLayout.LayoutParams $this$createScrollUpView_u24lambda_u2d6_u24lambda_u2d5 = new LinearLayout.LayoutParams(-2, -1);
        $this$createScrollUpView_u24lambda_u2d6_u24lambda_u2d5.setMargins(0, $this$createScrollUpView_u24lambda_u2d6.getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_8), 0, 0);
        $this$createScrollUpView_u24lambda_u2d6.setLayoutParams($this$createScrollUpView_u24lambda_u2d6_u24lambda_u2d5);
        verticalContainer.addView(lottieView, imageViewParams);
        verticalContainer.addView(beginnerGuideTextView);
        return verticalContainer;
    }

    private final String getScrollUpLottie() {
        return "assets://pag/video_flow_guide_down_up_scroll_landscape.pag";
    }
}
