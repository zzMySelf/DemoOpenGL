package com.baidu.searchbox.weather.comps.page.background;

import android.view.View;
import android.view.ViewStub;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.weather.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/baidu/searchbox/weather/comps/page/background/BackgroundComp$onRootPageScrollListener$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "dragged", "", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackgroundComp.kt */
public final class BackgroundComp$onRootPageScrollListener$1 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ View $view;
    private boolean dragged;
    final /* synthetic */ BackgroundComp this$0;

    BackgroundComp$onRootPageScrollListener$1(BackgroundComp $receiver, View $view2) {
        this.this$0 = $receiver;
        this.$view = $view2;
    }

    public void onPageScrollStateChanged(int state) {
        super.onPageScrollStateChanged(state);
        if (!this.dragged && state == 1) {
            this.dragged = true;
        }
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int pos;
        float p = ((float) position) + positionOffset;
        if (!Float.isNaN(p) && this.this$0.currentVpPos != (pos = MathKt.roundToInt(p))) {
            if (this.this$0.pageBgB == null && this.dragged) {
                BackgroundComp backgroundComp = this.this$0;
                View inflate = ((ViewStub) this.$view.findViewById(R.id.pageBgB)).inflate();
                View view2 = this.$view;
                View $this$onPageScrolled_u24lambda_u2d2 = inflate;
                ((AlphaVideo) $this$onPageScrolled_u24lambda_u2d2.findViewById(R.id.videoView)).setLooping(true);
                ((AlphaVideo) $this$onPageScrolled_u24lambda_u2d2.findViewById(R.id.videoView)).setOnVideoStartedListener(new BackgroundComp$onRootPageScrollListener$1$$ExternalSyntheticLambda1(view2, $this$onPageScrolled_u24lambda_u2d2));
                if (((SimpleDraweeView) $this$onPageScrolled_u24lambda_u2d2.findViewById(R.id.imageView)).hasHierarchy()) {
                    ((GenericDraweeHierarchy) ((SimpleDraweeView) $this$onPageScrolled_u24lambda_u2d2.findViewById(R.id.imageView)).getHierarchy()).setUseGlobalColorFilter(false);
                }
                backgroundComp.pageBgB = inflate;
            }
            this.this$0.currentVpPos = pos;
            this.this$0.bindBgAndAnim();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onPageScrolled$lambda-2$lambda-1  reason: not valid java name */
    public static final void m7508onPageScrolled$lambda2$lambda1(View $view2, View $this_apply) {
        Intrinsics.checkNotNullParameter($view2, "$view");
        $view2.post(new BackgroundComp$onRootPageScrollListener$1$$ExternalSyntheticLambda0($this_apply));
    }

    /* access modifiers changed from: private */
    /* renamed from: onPageScrolled$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m7509onPageScrolled$lambda2$lambda1$lambda0(View $this_apply) {
        ((AlphaVideo) $this_apply.findViewById(R.id.videoView)).setAlpha(1.0f);
    }
}
