package com.baidu.talos.core.devsupport.performance.fps.jankstats;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.baidu.talos.core.devsupport.performance.fps.jankstats.PerformanceMetricsState;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0010¢\u0006\u0002\b\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/DelegatingOnPreDrawListener;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "decorView", "Landroid/view/View;", "choreographer", "Landroid/view/Choreographer;", "delegates", "", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/OnFrameListenerDelegate;", "(Landroid/view/View;Landroid/view/Choreographer;Ljava/util/List;)V", "getChoreographer", "()Landroid/view/Choreographer;", "decorViewRef", "Ljava/lang/ref/WeakReference;", "getDecorViewRef", "()Ljava/lang/ref/WeakReference;", "getDelegates", "()Ljava/util/List;", "metricsStateHolder", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState$MetricsStateHolder;", "getMetricsStateHolder", "()Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState$MetricsStateHolder;", "getFrameStartTime", "", "onPreDraw", "", "setMessageAsynchronicity", "", "message", "Landroid/os/Message;", "setMessageAsynchronicity$lib_talos_core_release", "Companion", "lib-talos-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JankStatsApi16Impl.kt */
public class DelegatingOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Field choreographerLastFrameTimeField;
    private final Choreographer choreographer;
    private final WeakReference<View> decorViewRef;
    private final List<OnFrameListenerDelegate> delegates;
    private final PerformanceMetricsState.MetricsStateHolder metricsStateHolder;

    public DelegatingOnPreDrawListener(View decorView, Choreographer choreographer2, List<OnFrameListenerDelegate> delegates2) {
        Intrinsics.checkNotNullParameter(decorView, "decorView");
        Intrinsics.checkNotNullParameter(choreographer2, "choreographer");
        Intrinsics.checkNotNullParameter(delegates2, "delegates");
        this.choreographer = choreographer2;
        this.delegates = delegates2;
        this.decorViewRef = new WeakReference<>(decorView);
        this.metricsStateHolder = PerformanceMetricsState.Companion.getForHierarchy(decorView);
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    public final List<OnFrameListenerDelegate> getDelegates() {
        return this.delegates;
    }

    public final WeakReference<View> getDecorViewRef() {
        return this.decorViewRef;
    }

    public final PerformanceMetricsState.MetricsStateHolder getMetricsStateHolder() {
        return this.metricsStateHolder;
    }

    public boolean onPreDraw() {
        View decorView = (View) this.decorViewRef.get();
        Intrinsics.checkNotNull(decorView);
        View $this$onPreDraw_u24lambda_u2d3 = decorView;
        long frameStart = getFrameStartTime();
        View view2 = decorView;
        Handler handler = $this$onPreDraw_u24lambda_u2d3.getHandler();
        Message obtain = Message.obtain($this$onPreDraw_u24lambda_u2d3.getHandler(), new DelegatingOnPreDrawListener$$ExternalSyntheticLambda0(decorView, this, frameStart));
        Message $this$onPreDraw_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1 = obtain;
        Intrinsics.checkNotNullExpressionValue($this$onPreDraw_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1, "this");
        setMessageAsynchronicity$lib_talos_core_release($this$onPreDraw_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1);
        handler.sendMessage(obtain);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: onPreDraw$lambda-3$lambda-2$lambda-0  reason: not valid java name */
    public static final void m8122onPreDraw$lambda3$lambda2$lambda0(View $decorView, DelegatingOnPreDrawListener this$0, long $frameStart) {
        DelegatingOnPreDrawListener delegatingOnPreDrawListener = this$0;
        Intrinsics.checkNotNullParameter(delegatingOnPreDrawListener, "this$0");
        long now = System.nanoTime();
        View view2 = $decorView;
        long expectedDuration = Companion.getExpectedFrameDuration($decorView);
        for (OnFrameListenerDelegate onFrame : delegatingOnPreDrawListener.delegates) {
            onFrame.onFrame($frameStart, now - $frameStart, expectedDuration);
        }
        PerformanceMetricsState state = delegatingOnPreDrawListener.metricsStateHolder.getState();
        if (state != null) {
            state.cleanupSingleFrameStates$lib_talos_core_release();
        }
    }

    private final long getFrameStartTime() {
        Object obj = choreographerLastFrameTimeField.get(this.choreographer);
        if (obj != null) {
            return ((Long) obj).longValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    public void setMessageAsynchronicity$lib_talos_core_release(Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/DelegatingOnPreDrawListener$Companion;", "", "()V", "choreographerLastFrameTimeField", "Ljava/lang/reflect/Field;", "getChoreographerLastFrameTimeField", "()Ljava/lang/reflect/Field;", "getExpectedFrameDuration", "", "view", "Landroid/view/View;", "lib-talos-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: JankStatsApi16Impl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Field getChoreographerLastFrameTimeField() {
            return DelegatingOnPreDrawListener.choreographerLastFrameTimeField;
        }

        public final long getExpectedFrameDuration(View view2) {
            if (JankStatsBaseImpl.Companion.getFrameDuration() < 0) {
                float refreshRate = 60.0f;
                Window window = null;
                if ((view2 != null ? view2.getContext() : null) instanceof Activity) {
                    Context context = view2.getContext();
                    if (context != null) {
                        window = ((Activity) context).getWindow();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                    }
                }
                if (window != null) {
                    refreshRate = window.getWindowManager().getDefaultDisplay().getRefreshRate();
                }
                if (refreshRate < 30.0f || refreshRate > 200.0f) {
                    refreshRate = 60.0f;
                }
                JankStatsBaseImpl.Companion.setFrameDuration((long) ((((float) 1000) / refreshRate) * ((float) 1000000)));
            }
            return JankStatsBaseImpl.Companion.getFrameDuration();
        }
    }

    static {
        Field declaredField = Choreographer.class.getDeclaredField("mLastFrameTimeNanos");
        Intrinsics.checkNotNullExpressionValue(declaredField, "Choreographer::class.jav…ld(\"mLastFrameTimeNanos\")");
        choreographerLastFrameTimeField = declaredField;
        declaredField.setAccessible(true);
    }
}
