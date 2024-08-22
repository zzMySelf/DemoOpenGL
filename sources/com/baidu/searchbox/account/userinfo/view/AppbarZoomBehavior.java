package com.baidu.searchbox.account.userinfo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.account.userinfo.R;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.favor.data.FavorModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J \u0010!\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020\nH\u0016J0\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0012H\u0016J@\u0010)\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\nH\u0016J8\u0010/\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020 2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0016J(\u00102\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\nH\u0016J\u0010\u00103\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u00104\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010+\u001a\u00020\nH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/view/AppbarZoomBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isAnimate", "", "mAppbarHeight", "", "mImageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mImageViewHeight", "mImageViewMask", "Landroid/view/View;", "mLastBottom", "mRvTotalDy", "", "mScaleValue", "mTotalDy", "mVideoView", "Lcom/baidu/searchbox/afx/AlphaVideo;", "topImageAnimate", "Landroid/graphics/drawable/Animatable;", "valueAnimator", "Landroid/animation/ValueAnimator;", "initView", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "abl", "Lcom/google/android/material/appbar/AppBarLayout;", "onLayoutChild", "layoutDirection", "onNestedPreFling", "coordinatorLayout", "child", "target", "velocityX", "velocityY", "onNestedPreScroll", "dx", "dy", "consumed", "", "type", "onStartNestedScroll", "directTargetChild", "nestedScrollAxes", "onStopNestedScroll", "recovery", "zoomHeaderImageView", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppbarZoomBehavior.kt */
public final class AppbarZoomBehavior extends AppBarLayout.Behavior {
    private boolean isAnimate;
    private int mAppbarHeight;
    private SimpleDraweeView mImageView;
    private int mImageViewHeight;
    private View mImageViewMask;
    private int mLastBottom;
    /* access modifiers changed from: private */
    public float mRvTotalDy;
    private float mScaleValue;
    private float mTotalDy;
    private AlphaVideo mVideoView;
    private Animatable topImageAnimate;
    private ValueAnimator valueAnimator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppbarZoomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean onLayoutChild(CoordinatorLayout parent, AppBarLayout abl, int layoutDirection) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(abl, "abl");
        boolean onLayoutChild = super.onLayoutChild(parent, abl, layoutDirection);
        initView(parent, abl);
        return onLayoutChild;
    }

    private final void initView(CoordinatorLayout parent, AppBarLayout abl) {
        View findViewById = parent.findViewById(R.id.album_list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "parent.findViewById(R.id.album_list)");
        ((RecyclerView) findViewById).addOnScrollListener(new AppbarZoomBehavior$initView$1(this));
        boolean z = false;
        abl.setClipChildren(false);
        this.mAppbarHeight = abl.getHeight();
        this.mImageView = (SimpleDraweeView) abl.findViewById(R.id.top_image);
        this.mVideoView = (AlphaVideo) abl.findViewById(R.id.top_video);
        this.mImageViewMask = abl.findViewById(R.id.top_image_mask);
        AlphaVideo alphaVideo = this.mVideoView;
        if (alphaVideo != null && alphaVideo.getVisibility() == 0) {
            z = true;
        }
        if (z) {
            AlphaVideo it = this.mVideoView;
            if (it != null) {
                this.mImageViewHeight = it.getHeight();
                return;
            }
            return;
        }
        SimpleDraweeView it2 = this.mImageView;
        if (it2 != null) {
            this.mImageViewHeight = it2.getHeight();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001d, code lost:
        r1 = r1.getController();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r5, com.google.android.material.appbar.AppBarLayout r6, android.view.View r7, android.view.View r8, int r9, int r10) {
        /*
            r4 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "child"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "directTargetChild"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1
            r4.isAnimate = r0
            com.facebook.drawee.view.SimpleDraweeView r1 = r4.mImageView
            if (r1 == 0) goto L_0x0028
            com.facebook.drawee.interfaces.DraweeController r1 = r1.getController()
            if (r1 == 0) goto L_0x0028
            android.graphics.drawable.Animatable r1 = r1.getAnimatable()
            goto L_0x0029
        L_0x0028:
            r1 = 0
        L_0x0029:
            r4.topImageAnimate = r1
            if (r1 == 0) goto L_0x0039
            r2 = 0
            boolean r3 = r1.isRunning()
            if (r3 == 0) goto L_0x0037
            r1.stop()
        L_0x0037:
        L_0x0039:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.view.AppbarZoomBehavior.onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, android.view.View, int, int):boolean");
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (!(this.mImageView == null && this.mVideoView == null) && child.getBottom() >= this.mAppbarHeight && dy < 0 && type == 0 && this.mRvTotalDy <= 0.0f) {
            zoomHeaderImageView(child, dy);
            return;
        }
        boolean z = true;
        if (!(this.mImageView == null && this.mVideoView == null) && child.getBottom() > this.mAppbarHeight && dy > 0 && type == 0 && this.mRvTotalDy <= 0.0f) {
            consumed[1] = dy;
            zoomHeaderImageView(child, dy);
            return;
        }
        ValueAnimator valueAnimator2 = this.valueAnimator;
        if (valueAnimator2 != null) {
            if (valueAnimator2 == null || valueAnimator2.isRunning()) {
                z = false;
            }
            if (!z) {
                return;
            }
        }
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
    }

    private final void zoomHeaderImageView(AppBarLayout abl, int dy) {
        float f2 = this.mTotalDy + ((float) (-dy));
        this.mTotalDy = f2;
        float coerceAtLeast = RangesKt.coerceAtLeast(1.0f, (f2 / ((float) 960)) + 1.0f);
        this.mScaleValue = coerceAtLeast;
        SimpleDraweeView simpleDraweeView = this.mImageView;
        if (simpleDraweeView != null) {
            simpleDraweeView.setScaleX(coerceAtLeast);
        }
        SimpleDraweeView simpleDraweeView2 = this.mImageView;
        if (simpleDraweeView2 != null) {
            simpleDraweeView2.setScaleY(this.mScaleValue);
        }
        AlphaVideo alphaVideo = this.mVideoView;
        if (alphaVideo != null) {
            alphaVideo.setScaleX(this.mScaleValue);
        }
        AlphaVideo alphaVideo2 = this.mVideoView;
        if (alphaVideo2 != null) {
            alphaVideo2.setScaleY(this.mScaleValue);
        }
        View view2 = this.mImageViewMask;
        if (view2 != null) {
            view2.setScaleX(this.mScaleValue);
        }
        View view3 = this.mImageViewMask;
        if (view3 != null) {
            view3.setScaleY(this.mScaleValue);
        }
        int roundToInt = MathKt.roundToInt(((float) this.mAppbarHeight) + (((float) (this.mImageViewHeight / 2)) * (this.mScaleValue - ((float) 1))));
        this.mLastBottom = roundToInt;
        abl.setBottom(roundToInt);
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if (velocityY > 100.0f) {
            this.isAnimate = false;
        }
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0017, code lost:
        r0 = r0.getController();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r4, com.google.android.material.appbar.AppBarLayout r5, android.view.View r6, int r7) {
        /*
            r3 = this;
            java.lang.String r0 = "coordinatorLayout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "abl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r3.recovery(r5)
            com.facebook.drawee.view.SimpleDraweeView r0 = r3.mImageView
            if (r0 == 0) goto L_0x0022
            com.facebook.drawee.interfaces.DraweeController r0 = r0.getController()
            if (r0 == 0) goto L_0x0022
            android.graphics.drawable.Animatable r0 = r0.getAnimatable()
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            r3.topImageAnimate = r0
            if (r0 == 0) goto L_0x0033
            r1 = 0
            boolean r2 = r0.isRunning()
            if (r2 != 0) goto L_0x0031
            r0.start()
        L_0x0031:
        L_0x0033:
            super.onStopNestedScroll(r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.view.AppbarZoomBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int):void");
    }

    private final void recovery(AppBarLayout abl) {
        if (this.mTotalDy > 0.0f) {
            this.mTotalDy = 0.0f;
            if (this.isAnimate) {
                ValueAnimator duration = ValueAnimator.ofFloat(new float[]{this.mScaleValue, 1.0f}).setDuration(180);
                this.valueAnimator = duration;
                if (duration != null) {
                    duration.addUpdateListener(new AppbarZoomBehavior$$ExternalSyntheticLambda0(this, abl));
                }
                ValueAnimator valueAnimator2 = this.valueAnimator;
                if (valueAnimator2 != null) {
                    valueAnimator2.start();
                    return;
                }
                return;
            }
            SimpleDraweeView simpleDraweeView = this.mImageView;
            if (simpleDraweeView != null) {
                simpleDraweeView.setScaleX(1.0f);
            }
            SimpleDraweeView simpleDraweeView2 = this.mImageView;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.setScaleY(1.0f);
            }
            View view2 = this.mImageViewMask;
            if (view2 != null) {
                view2.setScaleX(1.0f);
            }
            View view3 = this.mImageViewMask;
            if (view3 != null) {
                view3.setScaleY(1.0f);
            }
            AlphaVideo alphaVideo = this.mVideoView;
            if (alphaVideo != null) {
                alphaVideo.setScaleX(1.0f);
            }
            AlphaVideo alphaVideo2 = this.mVideoView;
            if (alphaVideo2 != null) {
                alphaVideo2.setScaleY(1.0f);
            }
            abl.setBottom(this.mAppbarHeight);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: recovery$lambda-4  reason: not valid java name */
    public static final void m14625recovery$lambda4(AppbarZoomBehavior this$0, AppBarLayout $abl, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($abl, "$abl");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue != null) {
            float scaleValue = ((Float) animatedValue).floatValue();
            SimpleDraweeView simpleDraweeView = this$0.mImageView;
            if (simpleDraweeView != null) {
                simpleDraweeView.setScaleX(scaleValue);
            }
            SimpleDraweeView simpleDraweeView2 = this$0.mImageView;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.setScaleY(scaleValue);
            }
            AlphaVideo alphaVideo = this$0.mVideoView;
            if (alphaVideo != null) {
                alphaVideo.setScaleX(scaleValue);
            }
            AlphaVideo alphaVideo2 = this$0.mVideoView;
            if (alphaVideo2 != null) {
                alphaVideo2.setScaleY(scaleValue);
            }
            View view2 = this$0.mImageViewMask;
            if (view2 != null) {
                view2.setScaleX(scaleValue);
            }
            View view3 = this$0.mImageViewMask;
            if (view3 != null) {
                view3.setScaleY(scaleValue);
            }
            int i2 = this$0.mLastBottom;
            $abl.setBottom((int) (((float) i2) - (((float) (i2 - this$0.mAppbarHeight)) * animation.getAnimatedFraction())));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
