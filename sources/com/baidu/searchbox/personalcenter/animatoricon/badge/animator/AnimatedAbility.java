package com.baidu.searchbox.personalcenter.animatoricon.badge.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.AnimatorEmphasize;
import com.baidu.searchbox.personalcenter.animatoricon.AnimatorIconManager;
import com.baidu.searchbox.personalcenter.animatoricon.IAnimatorIcon;
import com.baidu.searchbox.personalcenter.animatoricon.badge.AnimationBadgeState;
import com.baidu.searchbox.personalcenter.animatoricon.badge.animator.emphasize.IEmphasizeAnimator;
import com.baidu.searchbox.personalcenter.animatoricon.badge.animator.emphasize.ShimmerAbility;
import com.baidu.searchbox.personalcenter.animatoricon.badge.animator.emphasize.ZoomAbility;
import com.baidu.searchbox.personalcenter.animatoricon.badge.animator.entry.IEntryAnimator;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0003bcdB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010O\u001a\u00020\u000fH\u0016J\b\u0010P\u001a\u00020\u001cH\u0016J\u0006\u0010Q\u001a\u00020/J&\u0010R\u001a\u00020/2\b\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020\u00152\f\u0010V\u001a\b\u0012\u0004\u0012\u00020/0WJ\u0006\u0010X\u001a\u00020/J\u0006\u0010Y\u001a\u00020>J\b\u0010Z\u001a\u00020>H\u0002J\b\u0010[\u001a\u00020>H\u0002J\u0006\u0010\\\u001a\u00020/J\u0016\u0010]\u001a\u00020/2\u0006\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020`J\u000e\u0010a\u001a\u00020/2\u0006\u0010^\u001a\u00020\u0007R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020!@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001f\u0010'\u001a\u00060(R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b)\u0010*R\u001a\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-X\u0004¢\u0006\u0002\n\u0000R\u001f\u00100\u001a\u000601R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b4\u0010\u000b\u001a\u0004\b2\u00103R\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\u001b\u00108\u001a\u0002098BX\u0002¢\u0006\f\n\u0004\b<\u0010\u000b\u001a\u0004\b:\u0010;R\u001a\u0010=\u001a\u00020>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001b\u0010C\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\bF\u0010\u000b\u001a\u0004\bD\u0010ER\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010\u0005R\u001b\u0010J\u001a\u00020K8BX\u0002¢\u0006\f\n\u0004\bN\u0010\u000b\u001a\u0004\bL\u0010M¨\u0006e"}, d2 = {"Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/AnimatedAbility;", "Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/entry/IEntryAnimator;", "Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/emphasize/IEmphasizeAnimator;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "badgeShadowHeight", "", "getBadgeShadowHeight", "()F", "badgeShadowHeight$delegate", "Lkotlin/Lazy;", "clipBounds", "Landroid/graphics/Rect;", "emphasizeAnimatorType", "Lcom/baidu/searchbox/kmm/personalcenter/entities/constants/AnimatorEmphasize;", "getEmphasizeAnimatorType", "()Lcom/baidu/searchbox/kmm/personalcenter/entities/constants/AnimatorEmphasize;", "setEmphasizeAnimatorType", "(Lcom/baidu/searchbox/kmm/personalcenter/entities/constants/AnimatorEmphasize;)V", "value", "", "emphasizePlayCount", "getEmphasizePlayCount", "()I", "setEmphasizePlayCount", "(I)V", "entryAnimatorType", "Lcom/baidu/searchbox/personalcenter/animatoricon/IAnimatorIcon$AnimatorEntry;", "getEntryAnimatorType", "()Lcom/baidu/searchbox/personalcenter/animatoricon/IAnimatorIcon$AnimatorEntry;", "setEntryAnimatorType", "(Lcom/baidu/searchbox/personalcenter/animatoricon/IAnimatorIcon$AnimatorEntry;)V", "", "keyId", "getKeyId", "()Ljava/lang/String;", "setKeyId", "(Ljava/lang/String;)V", "mEmphasizeAnimatorListener", "Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/AnimatedAbility$EmphasizeAnimatorListener;", "getMEmphasizeAnimatorListener", "()Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/AnimatedAbility$EmphasizeAnimatorListener;", "mEmphasizeAnimatorListener$delegate", "mEmphasizeAnimatorUpdateListener", "Lkotlin/Function1;", "Landroid/animation/ValueAnimator;", "", "mEntryAnimatorListener", "Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/AnimatedAbility$EntryAnimatorListener;", "getMEntryAnimatorListener", "()Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/AnimatedAbility$EntryAnimatorListener;", "mEntryAnimatorListener$delegate", "mEntryAnimatorUpdateListener", "mState", "Lcom/baidu/searchbox/personalcenter/animatoricon/badge/AnimationBadgeState;", "shimmerAbility", "Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/emphasize/ShimmerAbility;", "getShimmerAbility", "()Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/emphasize/ShimmerAbility;", "shimmerAbility$delegate", "showInScreen", "", "getShowInScreen", "()Z", "setShowInScreen", "(Z)V", "valueAnimator", "getValueAnimator", "()Landroid/animation/ValueAnimator;", "valueAnimator$delegate", "getView", "()Landroid/view/View;", "setView", "zoomAbility", "Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/emphasize/ZoomAbility;", "getZoomAbility", "()Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/emphasize/ZoomAbility;", "zoomAbility$delegate", "fetchEmphasizeAnimatorType", "fetchEntryAnimatorType", "onDismiss", "onDraw", "canvas", "Landroid/graphics/Canvas;", "backgroundColor", "block", "Lkotlin/Function0;", "onShow", "playAnimation", "playEmphasizeAnimation", "playEntryAnimation", "reset", "updateShimmerProgress", "progress", "duration", "", "updateZoomProgress", "Companion", "EmphasizeAnimatorListener", "EntryAnimatorListener", "lib-personal-center-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimatedAbility.kt */
public final class AnimatedAbility implements IEntryAnimator, IEmphasizeAnimator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long EMPHASIZE_DELAY = 1000;
    private static final long ENTRY_DELAY = 0;
    private static final String TAG = "AnimatedAbility";
    private final Lazy badgeShadowHeight$delegate = LazyKt.lazy(new AnimatedAbility$badgeShadowHeight$2(this));
    private final Rect clipBounds = new Rect();
    private AnimatorEmphasize emphasizeAnimatorType = AnimatorEmphasize.DEFAULT;
    private int emphasizePlayCount = 1;
    private IAnimatorIcon.AnimatorEntry entryAnimatorType = IAnimatorIcon.AnimatorEntry.DEFAULT;
    private String keyId = "";
    private final Lazy mEmphasizeAnimatorListener$delegate = LazyKt.lazy(new AnimatedAbility$mEmphasizeAnimatorListener$2(this));
    private final Function1<ValueAnimator, Unit> mEmphasizeAnimatorUpdateListener = new AnimatedAbility$mEmphasizeAnimatorUpdateListener$1(this);
    private final Lazy mEntryAnimatorListener$delegate = LazyKt.lazy(new AnimatedAbility$mEntryAnimatorListener$2(this));
    private final Function1<ValueAnimator, Unit> mEntryAnimatorUpdateListener = new AnimatedAbility$mEntryAnimatorUpdateListener$1(this);
    /* access modifiers changed from: private */
    public AnimationBadgeState mState = AnimationBadgeState.IDLE;
    private final Lazy shimmerAbility$delegate = LazyKt.lazy(new AnimatedAbility$shimmerAbility$2(this));
    private boolean showInScreen;
    private final Lazy valueAnimator$delegate = LazyKt.lazy(AnimatedAbility$valueAnimator$2.INSTANCE);

    /* renamed from: view  reason: collision with root package name */
    private View f2800view;
    private final Lazy zoomAbility$delegate = LazyKt.lazy(AnimatedAbility$zoomAbility$2.INSTANCE);

    public AnimatedAbility(View view2) {
        this.f2800view = view2;
    }

    public boolean checkIsShimmer(AnimatorEmphasize animatorType) {
        return IEmphasizeAnimator.DefaultImpls.checkIsShimmer(this, animatorType);
    }

    public long fetchEmphasizeAnimatorDuration(AnimatorEmphasize animatorType) {
        return IEmphasizeAnimator.DefaultImpls.fetchEmphasizeAnimatorDuration(this, animatorType);
    }

    public long fetchEntryAnimatorDuration(IAnimatorIcon.AnimatorEntry animatorType) {
        return IEntryAnimator.DefaultImpls.fetchEntryAnimatorDuration(this, animatorType);
    }

    public void onUpdateEmphasizeSwingProgress(View view2, float progress) {
        IEmphasizeAnimator.DefaultImpls.onUpdateEmphasizeSwingProgress(this, view2, progress);
    }

    public void onUpdateEmphasizeZoomProgress(View view2, float progress) {
        IEmphasizeAnimator.DefaultImpls.onUpdateEmphasizeZoomProgress(this, view2, progress);
    }

    public void onUpdateEntrySlideProgress(View view2, float progress) {
        IEntryAnimator.DefaultImpls.onUpdateEntrySlideProgress(this, view2, progress);
    }

    public void onUpdateEntrySwingProgress(View view2, float progress) {
        IEntryAnimator.DefaultImpls.onUpdateEntrySwingProgress(this, view2, progress);
    }

    public void updateEmphasizeAnimatorProgress(View view2, float progress) {
        IEmphasizeAnimator.DefaultImpls.updateEmphasizeAnimatorProgress(this, view2, progress);
    }

    public void updateEntryAnimatorProgress(View view2, float progress) {
        IEntryAnimator.DefaultImpls.updateEntryAnimatorProgress(this, view2, progress);
    }

    public final View getView() {
        return this.f2800view;
    }

    public final void setView(View view2) {
        this.f2800view = view2;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/AnimatedAbility$Companion;", "", "()V", "EMPHASIZE_DELAY", "", "ENTRY_DELAY", "TAG", "", "lib-personal-center-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AnimatedAbility.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final float getBadgeShadowHeight() {
        return ((Number) this.badgeShadowHeight$delegate.getValue()).floatValue();
    }

    private final ShimmerAbility getShimmerAbility() {
        return (ShimmerAbility) this.shimmerAbility$delegate.getValue();
    }

    private final ZoomAbility getZoomAbility() {
        return (ZoomAbility) this.zoomAbility$delegate.getValue();
    }

    public final IAnimatorIcon.AnimatorEntry getEntryAnimatorType() {
        return this.entryAnimatorType;
    }

    public final void setEntryAnimatorType(IAnimatorIcon.AnimatorEntry animatorEntry) {
        Intrinsics.checkNotNullParameter(animatorEntry, "<set-?>");
        this.entryAnimatorType = animatorEntry;
    }

    public final AnimatorEmphasize getEmphasizeAnimatorType() {
        return this.emphasizeAnimatorType;
    }

    public final void setEmphasizeAnimatorType(AnimatorEmphasize animatorEmphasize) {
        Intrinsics.checkNotNullParameter(animatorEmphasize, "<set-?>");
        this.emphasizeAnimatorType = animatorEmphasize;
    }

    public final String getKeyId() {
        return this.keyId;
    }

    public final void setKeyId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.keyId = value;
        AnimatorIconManager.INSTANCE.updatePlayCountLimit(this.keyId, this.emphasizePlayCount);
    }

    public final int getEmphasizePlayCount() {
        return this.emphasizePlayCount;
    }

    public final void setEmphasizePlayCount(int value) {
        this.emphasizePlayCount = value;
        AnimatorIconManager.INSTANCE.updatePlayCountLimit(this.keyId, value);
    }

    private final ValueAnimator getValueAnimator() {
        Object value = this.valueAnimator$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-valueAnimator>(...)");
        return (ValueAnimator) value;
    }

    public final boolean getShowInScreen() {
        return this.showInScreen;
    }

    public final void setShowInScreen(boolean z) {
        this.showInScreen = z;
    }

    private final EntryAnimatorListener getMEntryAnimatorListener() {
        return (EntryAnimatorListener) this.mEntryAnimatorListener$delegate.getValue();
    }

    private final EmphasizeAnimatorListener getMEmphasizeAnimatorListener() {
        return (EmphasizeAnimatorListener) this.mEmphasizeAnimatorListener$delegate.getValue();
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v6, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDraw(android.graphics.Canvas r17, int r18, kotlin.jvm.functions.Function0<kotlin.Unit> r19) {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r1 = "block"
            r10 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            com.baidu.searchbox.kmm.personalcenter.entities.constants.AnimatorEmphasize r1 = r0.emphasizeAnimatorType
            boolean r1 = r0.checkIsShimmer(r1)
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x0068
            android.view.View r1 = r0.f2800view
            boolean r4 = r1 instanceof android.widget.TextView
            if (r4 == 0) goto L_0x001c
            r2 = r1
            android.widget.TextView r2 = (android.widget.TextView) r2
        L_0x001c:
            if (r2 == 0) goto L_0x00dc
            r1 = r2
            r9 = 0
            android.graphics.Rect r11 = r0.clipBounds
            java.lang.CharSequence r2 = r1.getText()
            java.lang.String r12 = r2.toString()
            android.text.Layout r2 = r1.getLayout()
            android.text.TextPaint r2 = r2.getPaint()
            int r4 = r12.length()
            r2.getTextBounds(r12, r3, r4, r11)
            int r13 = r1.getBaseline()
            int r2 = r11.top
            int r2 = r2 + r13
            r11.top = r2
            android.view.View r2 = r0.f2800view
            boolean r2 = r2 instanceof com.baidu.searchbox.ui.view.BadgeView
            if (r2 == 0) goto L_0x004a
            r4 = r3
            goto L_0x004c
        L_0x004a:
            r2 = 1
            r4 = r2
        L_0x004c:
            com.baidu.searchbox.personalcenter.animatoricon.badge.animator.emphasize.ShimmerAbility r2 = r16.getShimmerAbility()
            int r3 = r11.top
            float r5 = (float) r3
            int r3 = r1.getPaddingLeft()
            float r6 = (float) r3
            r3 = r17
            r7 = r18
            r8 = r19
            r2.onDraw(r3, r4, r5, r6, r7, r8)
            goto L_0x00dc
        L_0x0068:
            com.baidu.searchbox.kmm.personalcenter.entities.constants.AnimatorEmphasize r1 = com.baidu.searchbox.kmm.personalcenter.entities.constants.AnimatorEmphasize.ZOOM
            com.baidu.searchbox.kmm.personalcenter.entities.constants.AnimatorEmphasize r4 = r0.emphasizeAnimatorType
            if (r1 != r4) goto L_0x00dc
            android.view.View r1 = r0.f2800view
            boolean r4 = r1 instanceof android.widget.TextView
            if (r4 == 0) goto L_0x0077
            r2 = r1
            android.widget.TextView r2 = (android.widget.TextView) r2
        L_0x0077:
            if (r2 == 0) goto L_0x00dc
            r1 = r2
            r11 = 0
            android.graphics.Rect r12 = r0.clipBounds
            java.lang.CharSequence r2 = r1.getText()
            java.lang.String r13 = r2.toString()
            android.text.Layout r2 = r1.getLayout()
            android.text.TextPaint r2 = r2.getPaint()
            int r4 = r13.length()
            r2.getTextBounds(r13, r3, r4, r12)
            int r14 = r1.getBaseline()
            int r2 = r12.top
            int r2 = r2 + r14
            r12.top = r2
            int r2 = r12.bottom
            int r2 = r2 + r14
            r12.bottom = r2
            int r15 = r1.getPaddingLeft()
            int r2 = r12.left
            int r2 = r2 + r15
            r12.left = r2
            android.text.Layout r2 = r1.getLayout()
            android.text.TextPaint r2 = r2.getPaint()
            int r4 = r13.length()
            float r2 = r2.measureText(r13, r3, r4)
            int r2 = (int) r2
            int r2 = r2 + r15
            r12.right = r2
            com.baidu.searchbox.personalcenter.animatoricon.badge.animator.emphasize.ZoomAbility r2 = r16.getZoomAbility()
            int r3 = r12.left
            float r4 = (float) r3
            int r3 = r12.top
            float r5 = (float) r3
            int r3 = r12.right
            float r6 = (float) r3
            int r3 = r12.bottom
            float r7 = (float) r3
            r3 = r17
            r8 = r18
            r9 = r19
            r2.onDraw(r3, r4, r5, r6, r7, r8, r9)
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.personalcenter.animatoricon.badge.animator.AnimatedAbility.onDraw(android.graphics.Canvas, int, kotlin.jvm.functions.Function0):void");
    }

    public final void updateShimmerProgress(float progress, long duration) {
        if (checkIsShimmer(this.emphasizeAnimatorType)) {
            getShimmerAbility().onUpdateProgress(this.f2800view, progress, duration);
        }
    }

    public final void updateZoomProgress(float progress) {
        if (AnimatorEmphasize.ZOOM == this.emphasizeAnimatorType) {
            getZoomAbility().onUpdateProgress(this.f2800view, progress);
        }
    }

    public IAnimatorIcon.AnimatorEntry fetchEntryAnimatorType() {
        return this.entryAnimatorType;
    }

    public AnimatorEmphasize fetchEmphasizeAnimatorType() {
        return this.emphasizeAnimatorType;
    }

    public final void onShow() {
        if (!this.showInScreen) {
            playAnimation();
        }
    }

    public final void onDismiss() {
        if (this.showInScreen) {
            this.showInScreen = false;
        }
    }

    public final void reset() {
        getValueAnimator().cancel();
    }

    public final boolean playAnimation() {
        this.showInScreen = true;
        if (!AnimatorIconManager.INSTANCE.checkClickInfo(this.keyId)) {
            Log.e(TAG, "不能播放飘新动画，点击次数达到了上限");
            return false;
        } else if (playEntryAnimation()) {
            return true;
        } else {
            return playEmphasizeAnimation();
        }
    }

    private final boolean playEntryAnimation() {
        if (IAnimatorIcon.AnimatorEntry.DEFAULT == this.entryAnimatorType || !this.showInScreen) {
            return false;
        }
        if (AnimationBadgeState.IN_ENTRY == this.mState) {
            return true;
        }
        if (!AnimatorIconManager.INSTANCE.checkCanPlayEntryAnimation(this.keyId)) {
            return false;
        }
        getValueAnimator().removeAllUpdateListeners();
        getValueAnimator().removeAllListeners();
        getValueAnimator().setRepeatCount(0);
        getValueAnimator().setStartDelay(0);
        getValueAnimator().setDuration(fetchEntryAnimatorDuration(this.entryAnimatorType));
        getValueAnimator().addUpdateListener(new AnimatedAbility$$ExternalSyntheticLambda0(this.mEntryAnimatorUpdateListener));
        getValueAnimator().addListener(getMEntryAnimatorListener());
        getValueAnimator().start();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: playEntryAnimation$lambda-2  reason: not valid java name */
    public static final void m2159playEntryAnimation$lambda2(Function1 $tmp0, ValueAnimator p0) {
        Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
        Intrinsics.checkNotNullParameter(p0, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
        $tmp0.invoke(p0);
    }

    /* access modifiers changed from: private */
    public final boolean playEmphasizeAnimation() {
        if (AnimatorEmphasize.DEFAULT == this.emphasizeAnimatorType || !this.showInScreen) {
            return false;
        }
        if (AnimationBadgeState.IN_EMPHASIZE == this.mState) {
            return true;
        }
        if ((AnimationBadgeState.IDLE != this.mState && AnimationBadgeState.AFTER_ENTRY != this.mState) || !AnimatorIconManager.checkCanPlayAgain$default(AnimatorIconManager.INSTANCE, this.keyId, 0, 2, (Object) null)) {
            return false;
        }
        getValueAnimator().removeAllUpdateListeners();
        getValueAnimator().removeAllListeners();
        getValueAnimator().setRepeatCount(0);
        getValueAnimator().setStartDelay(1000);
        getValueAnimator().setDuration(fetchEmphasizeAnimatorDuration(this.emphasizeAnimatorType));
        getValueAnimator().addUpdateListener(new AnimatedAbility$$ExternalSyntheticLambda1(this.mEmphasizeAnimatorUpdateListener));
        getValueAnimator().addListener(getMEmphasizeAnimatorListener());
        getValueAnimator().start();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: playEmphasizeAnimation$lambda-3  reason: not valid java name */
    public static final void m2158playEmphasizeAnimation$lambda3(Function1 $tmp0, ValueAnimator p0) {
        Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
        Intrinsics.checkNotNullParameter(p0, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
        $tmp0.invoke(p0);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/AnimatedAbility$EntryAnimatorListener;", "Landroid/animation/Animator$AnimatorListener;", "(Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/AnimatedAbility;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib-personal-center-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AnimatedAbility.kt */
    private final class EntryAnimatorListener implements Animator.AnimatorListener {
        public EntryAnimatorListener() {
        }

        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AnimatedAbility.this.mState = AnimationBadgeState.AFTER_ENTRY;
            AnimatedAbility animatedAbility = AnimatedAbility.this;
            animatedAbility.updateEntryAnimatorProgress(animatedAbility.getView(), 1.0f);
            AnimatorIconManager.INSTANCE.callbackEntryAnimationPlayed(AnimatedAbility.this.getKeyId());
            boolean unused = AnimatedAbility.this.playEmphasizeAnimation();
        }

        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AnimatedAbility.this.mState = AnimationBadgeState.AFTER_ENTRY;
        }

        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AnimatedAbility.this.mState = AnimationBadgeState.IN_ENTRY;
            AnimatorIconManager.INSTANCE.recordAnimationPlayed(AnimatedAbility.this.getKeyId());
            View view2 = AnimatedAbility.this.getView();
            IAnimatorIcon animatorView = view2 instanceof IAnimatorIcon ? (IAnimatorIcon) view2 : null;
            if (animatorView != null) {
                AnimatorIconManager.INSTANCE.addAnimatorIcon(animatorView);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/AnimatedAbility$EmphasizeAnimatorListener;", "Landroid/animation/Animator$AnimatorListener;", "(Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/AnimatedAbility;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib-personal-center-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AnimatedAbility.kt */
    private final class EmphasizeAnimatorListener implements Animator.AnimatorListener {
        public EmphasizeAnimatorListener() {
        }

        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AnimatedAbility.this.mState = AnimationBadgeState.IDLE;
            AnimatedAbility animatedAbility = AnimatedAbility.this;
            animatedAbility.updateEmphasizeAnimatorProgress(animatedAbility.getView(), 1.0f);
            if (AnimatedAbility.this.getShowInScreen()) {
                AnimatorIconManager.INSTANCE.callbackPlayed(AnimatedAbility.this.getKeyId());
                boolean unused = AnimatedAbility.this.playEmphasizeAnimation();
            }
        }

        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AnimatedAbility.this.mState = AnimationBadgeState.IDLE;
        }

        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AnimatedAbility.this.mState = AnimationBadgeState.IN_EMPHASIZE;
            AnimatorIconManager.INSTANCE.recordAnimationPlayed(AnimatedAbility.this.getKeyId());
            View view2 = AnimatedAbility.this.getView();
            IAnimatorIcon animatorView = view2 instanceof IAnimatorIcon ? (IAnimatorIcon) view2 : null;
            if (animatorView != null) {
                AnimatorIconManager.INSTANCE.addAnimatorIcon(animatorView);
            }
        }
    }
}
