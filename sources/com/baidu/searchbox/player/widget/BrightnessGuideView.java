package com.baidu.searchbox.player.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.videoplayer.vulcan.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\u0001H\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cR\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/player/widget/BrightnessGuideView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hotView", "Landroid/view/View;", "getHotView", "()Landroid/view/View;", "hotView$delegate", "Lkotlin/Lazy;", "lottieBrightness", "Lorg/libpag/PAGView;", "getLottieBrightness", "()Lorg/libpag/PAGView;", "lottieBrightness$delegate", "lottieContainer", "getLottieContainer", "()Landroid/widget/LinearLayout;", "lottieContainer$delegate", "createBrightnessView", "createHotView", "createLottieContainer", "release", "", "show", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrightnessGuideView.kt */
public final class BrightnessGuideView extends LinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private final Lazy hotView$delegate;
    private final Lazy lottieBrightness$delegate;
    private final Lazy lottieContainer$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BrightnessGuideView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BrightnessGuideView(Context context, AttributeSet attributeSet) {
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
    public BrightnessGuideView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.lottieBrightness$delegate = BdPlayerUtils.lazyNone(new BrightnessGuideView$lottieBrightness$2(this));
        this.hotView$delegate = BdPlayerUtils.lazyNone(new BrightnessGuideView$hotView$2(this));
        this.lottieContainer$delegate = BdPlayerUtils.lazyNone(new BrightnessGuideView$lottieContainer$2(this));
        setOrientation(0);
        getLottieContainer().addView(getLottieBrightness());
        addView(getHotView());
        addView(getLottieContainer());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrightnessGuideView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final PAGView getLottieBrightness() {
        return (PAGView) this.lottieBrightness$delegate.getValue();
    }

    private final View getHotView() {
        return (View) this.hotView$delegate.getValue();
    }

    private final LinearLayout getLottieContainer() {
        return (LinearLayout) this.lottieContainer$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PAGView createBrightnessView() {
        PAGView pAGView = new PAGView(getContext());
        PAGView $this$createBrightnessView_u24lambda_u2d0 = pAGView;
        $this$createBrightnessView_u24lambda_u2d0.setLayoutParams(new LinearLayout.LayoutParams($this$createBrightnessView_u24lambda_u2d0.getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_209), $this$createBrightnessView_u24lambda_u2d0.getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_191)));
        $this$createBrightnessView_u24lambda_u2d0.setPath("assets://pag/videoplayer_vulcan_brightness_guide.pag");
        return pAGView;
    }

    /* access modifiers changed from: private */
    public final LinearLayout createLottieContainer() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout $this$createLottieContainer_u24lambda_u2d2 = linearLayout;
        $this$createLottieContainer_u24lambda_u2d2.setOrientation(0);
        $this$createLottieContainer_u24lambda_u2d2.setBackgroundColor(ContextCompat.getColor($this$createLottieContainer_u24lambda_u2d2.getContext(), R.color.videoplayer_vulcan_guide_bg_color));
        $this$createLottieContainer_u24lambda_u2d2.setGravity(16);
        LinearLayout.LayoutParams $this$createLottieContainer_u24lambda_u2d2_u24lambda_u2d1 = new LinearLayout.LayoutParams(0, -1, 9.0f);
        $this$createLottieContainer_u24lambda_u2d2_u24lambda_u2d1.leftMargin = -$this$createLottieContainer_u24lambda_u2d2.getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_6);
        $this$createLottieContainer_u24lambda_u2d2.setLayoutParams($this$createLottieContainer_u24lambda_u2d2_u24lambda_u2d1);
        return linearLayout;
    }

    /* access modifiers changed from: private */
    public final View createHotView() {
        View view2 = new View(getContext());
        View $this$createHotView_u24lambda_u2d4 = view2;
        $this$createHotView_u24lambda_u2d4.setBackgroundColor(ContextCompat.getColor($this$createHotView_u24lambda_u2d4.getContext(), R.color.videoplayer_vulcan_guide_hot_zone_bg_color));
        LinearLayout.LayoutParams $this$createHotView_u24lambda_u2d4_u24lambda_u2d3 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        $this$createHotView_u24lambda_u2d4_u24lambda_u2d3.rightMargin = $this$createHotView_u24lambda_u2d4.getContext().getResources().getDimensionPixelOffset(R.dimen.videoplayer_vulcan_dp_6);
        $this$createHotView_u24lambda_u2d4.setLayoutParams($this$createHotView_u24lambda_u2d4_u24lambda_u2d3);
        return view2;
    }

    public final void show() {
        setVisibility(0);
        getLottieBrightness().play();
    }

    public final void release() {
        getLottieBrightness().stop();
    }
}
