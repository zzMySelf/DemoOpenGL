package com.baidu.talos.core.devsupport.performance.fps.jankstats;

import android.view.Choreographer;
import android.view.View;
import com.baidu.talos.core.R;
import com.baidu.talos.core.devsupport.performance.fps.jankstats.PerformanceMetricsState;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0014\b\u0011\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J+\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0010¢\u0006\u0002\b\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0010¢\u0006\u0002\b#J\r\u0010$\u001a\u00020\u001dH\u0000¢\u0006\u0002\b%J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u0005H\u0002J\u0014\u0010+\u001a\u00020'*\u00020\u00052\u0006\u0010,\u001a\u00020\u001aH\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006-"}, d2 = {"Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/JankStatsApi16Impl;", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/JankStatsBaseImpl;", "jankStats", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/JankStats;", "view", "Landroid/view/View;", "(Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/JankStats;Landroid/view/View;)V", "choreographer", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "decorViewRef", "Ljava/lang/ref/WeakReference;", "getDecorViewRef$lib_talos_core_release", "()Ljava/lang/ref/WeakReference;", "metricsStateHolder", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState$MetricsStateHolder;", "getMetricsStateHolder", "()Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState$MetricsStateHolder;", "onFrameListenerDelegate", "com/baidu/talos/core/devsupport/performance/fps/jankstats/JankStatsApi16Impl$onFrameListenerDelegate$1", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/JankStatsApi16Impl$onFrameListenerDelegate$1;", "createDelegatingOnDrawListener", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/DelegatingOnPreDrawListener;", "delegates", "", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/OnFrameListenerDelegate;", "createDelegatingOnDrawListener$lib_talos_core_release", "getExpectedFrameDuration", "", "getFrameData", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/FrameData;", "startTime", "uiDuration", "expectedDuration", "getFrameData$lib_talos_core_release", "getFrameStartTime", "getFrameStartTime$lib_talos_core_release", "setupFrameTimer", "", "enable", "", "getOrCreateOnPreDrawListenerDelegates", "removeOnPreDrawListenerDelegate", "delegate", "lib-talos-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JankStatsApi16Impl.kt */
public class JankStatsApi16Impl extends JankStatsBaseImpl {
    private final Choreographer choreographer;
    private final WeakReference<View> decorViewRef;
    private final PerformanceMetricsState.MetricsStateHolder metricsStateHolder;
    private final JankStatsApi16Impl$onFrameListenerDelegate$1 onFrameListenerDelegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JankStatsApi16Impl(JankStats jankStats, View view2) {
        super(jankStats);
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.decorViewRef = new WeakReference<>(view2);
        Choreographer instance = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        this.choreographer = instance;
        this.metricsStateHolder = PerformanceMetricsState.Companion.getForHierarchy(view2);
        this.onFrameListenerDelegate = new JankStatsApi16Impl$onFrameListenerDelegate$1(jankStats, this);
    }

    public final WeakReference<View> getDecorViewRef$lib_talos_core_release() {
        return this.decorViewRef;
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    public final PerformanceMetricsState.MetricsStateHolder getMetricsStateHolder() {
        return this.metricsStateHolder;
    }

    public void setupFrameTimer(boolean enable) {
        View decorView = (View) this.decorViewRef.get();
        if (decorView != null) {
            View view2 = decorView;
            if (enable) {
                getOrCreateOnPreDrawListenerDelegates(decorView).add(this.onFrameListenerDelegate);
            } else {
                removeOnPreDrawListenerDelegate(decorView, this.onFrameListenerDelegate);
            }
        }
    }

    public FrameData getFrameData$lib_talos_core_release(long startTime, long uiDuration, long expectedDuration) {
        List frameStates;
        List intervalStates$lib_talos_core_release;
        PerformanceMetricsState state = this.metricsStateHolder.getState();
        if (state == null || (intervalStates$lib_talos_core_release = state.getIntervalStates$lib_talos_core_release(startTime, startTime + uiDuration)) == null) {
            frameStates = CollectionsKt.emptyList();
        } else {
            frameStates = intervalStates$lib_talos_core_release;
        }
        return new FrameData(startTime, uiDuration, uiDuration > expectedDuration, frameStates);
    }

    private final void removeOnPreDrawListenerDelegate(View $this$removeOnPreDrawListenerDelegate, OnFrameListenerDelegate delegate) {
        $this$removeOnPreDrawListenerDelegate.setTag(R.id.talosApmMetricsDelegator, (Object) null);
        DelegatingOnPreDrawListener delegator = (DelegatingOnPreDrawListener) $this$removeOnPreDrawListenerDelegate.getTag(R.id.talosApmMetricsDelegator);
        List $this$removeOnPreDrawListenerDelegate_u24lambda_u2d1 = delegator != null ? delegator.getDelegates() : null;
        if ($this$removeOnPreDrawListenerDelegate_u24lambda_u2d1 != null) {
            $this$removeOnPreDrawListenerDelegate_u24lambda_u2d1.remove(delegate);
        }
        boolean z = false;
        if ($this$removeOnPreDrawListenerDelegate_u24lambda_u2d1 != null && $this$removeOnPreDrawListenerDelegate_u24lambda_u2d1.size() == 0) {
            z = true;
        }
        if (z) {
            $this$removeOnPreDrawListenerDelegate.getViewTreeObserver().removeOnPreDrawListener(delegator);
            $this$removeOnPreDrawListenerDelegate.setTag(R.id.talosApmMetricsDelegator, (Object) null);
        }
    }

    private final List<OnFrameListenerDelegate> getOrCreateOnPreDrawListenerDelegates(View $this$getOrCreateOnPreDrawListenerDelegates) {
        DelegatingOnPreDrawListener delegator = (DelegatingOnPreDrawListener) $this$getOrCreateOnPreDrawListenerDelegates.getTag(R.id.talosApmMetricsDelegator);
        if (delegator == null) {
            delegator = createDelegatingOnDrawListener$lib_talos_core_release($this$getOrCreateOnPreDrawListenerDelegates, this.choreographer, new ArrayList());
            $this$getOrCreateOnPreDrawListenerDelegates.getViewTreeObserver().addOnPreDrawListener(delegator);
            $this$getOrCreateOnPreDrawListenerDelegates.setTag(R.id.talosApmMetricsDelegator, delegator);
        }
        return delegator.getDelegates();
    }

    public DelegatingOnPreDrawListener createDelegatingOnDrawListener$lib_talos_core_release(View view2, Choreographer choreographer2, List<OnFrameListenerDelegate> delegates) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(choreographer2, "choreographer");
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        return new DelegatingOnPreDrawListener(view2, choreographer2, delegates);
    }

    public final long getFrameStartTime$lib_talos_core_release() {
        Object obj = DelegatingOnPreDrawListener.Companion.getChoreographerLastFrameTimeField().get(this.choreographer);
        if (obj != null) {
            return ((Long) obj).longValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    public final long getExpectedFrameDuration(View view2) {
        return DelegatingOnPreDrawListener.Companion.getExpectedFrameDuration(view2);
    }
}
