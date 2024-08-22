package com.baidu.talos.core.devsupport.performance.fps.jankstats;

import android.view.View;
import android.view.ViewParent;
import com.baidu.talos.core.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001f !B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\r\u0010\u0014\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0015J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0000¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J&\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState;", "", "()V", "singleFrameStates", "", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState$StateData;", "states", "addFrameState", "", "frameStartTime", "", "frameEndTime", "frameStates", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/StateInfo;", "activeStates", "addSingleFrameState", "stateName", "", "state", "addState", "cleanupSingleFrameStates", "cleanupSingleFrameStates$lib_talos_core_release", "getIntervalStates", "", "startTime", "endTime", "getIntervalStates$lib_talos_core_release", "markSingleFrameStateForRemoval", "markStateForRemoval", "removalTime", "removeState", "Companion", "MetricsStateHolder", "StateData", "lib-talos-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PerformanceMetricsState.kt */
public final class PerformanceMetricsState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private List<StateData> singleFrameStates;
    private List<StateData> states;

    public /* synthetic */ PerformanceMetricsState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final MetricsStateHolder create$lib_talos_core_release(View view2) {
        return Companion.create$lib_talos_core_release(view2);
    }

    @JvmStatic
    public static final MetricsStateHolder getForHierarchy(View view2) {
        return Companion.getForHierarchy(view2);
    }

    private PerformanceMetricsState() {
        this.states = new ArrayList();
        this.singleFrameStates = new ArrayList();
    }

    private final void addFrameState(long frameStartTime, long frameEndTime, List<StateInfo> frameStates, List<StateData> activeStates) {
        int size = activeStates.size() - 1;
        if (size >= 0) {
            do {
                int i2 = size;
                size--;
                StateData item = activeStates.get(i2);
                if (item.getTimeRemoved() > 0 && item.getTimeRemoved() < frameStartTime) {
                    activeStates.remove(i2);
                    continue;
                } else if (item.getTimeAdded() < frameEndTime && !frameStates.contains(item.getState())) {
                    frameStates.add(item.getState());
                    continue;
                }
            } while (size >= 0);
        }
    }

    private final void markStateForRemoval(String stateName, List<StateData> states2, long removalTime) {
        synchronized (this.singleFrameStates) {
            for (StateData item : states2) {
                if (Intrinsics.areEqual((Object) item.getState().getStateName(), (Object) stateName) && item.getTimeRemoved() < 0) {
                    item.setTimeRemoved(removalTime);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void addState(String stateName, String state) {
        Intrinsics.checkNotNullParameter(stateName, "stateName");
        Intrinsics.checkNotNullParameter(state, "state");
        synchronized (this.singleFrameStates) {
            long nowTime = System.nanoTime();
            markStateForRemoval(stateName, this.states, nowTime);
            this.states.add(new StateData(nowTime, -1, new StateInfo(stateName, state)));
        }
    }

    public final void addSingleFrameState(String stateName, String state) {
        Intrinsics.checkNotNullParameter(stateName, "stateName");
        Intrinsics.checkNotNullParameter(state, "state");
        synchronized (this.singleFrameStates) {
            long nowTime = System.nanoTime();
            markStateForRemoval(stateName, this.singleFrameStates, nowTime);
            this.singleFrameStates.add(new StateData(nowTime, -1, new StateInfo(stateName, state)));
        }
    }

    private final void markStateForRemoval(String stateName) {
        markStateForRemoval(stateName, this.states, System.nanoTime());
    }

    private final void markSingleFrameStateForRemoval(String stateName) {
        markStateForRemoval(stateName, this.singleFrameStates, System.nanoTime());
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState$StateData;", "", "timeAdded", "", "timeRemoved", "state", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/StateInfo;", "(JJLcom/baidu/talos/core/devsupport/performance/fps/jankstats/StateInfo;)V", "getState", "()Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/StateInfo;", "setState", "(Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/StateInfo;)V", "getTimeAdded", "()J", "setTimeAdded", "(J)V", "getTimeRemoved", "setTimeRemoved", "lib-talos-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PerformanceMetricsState.kt */
    public static final class StateData {
        private StateInfo state;
        private long timeAdded;
        private long timeRemoved;

        public StateData(long timeAdded2, long timeRemoved2, StateInfo state2) {
            Intrinsics.checkNotNullParameter(state2, "state");
            this.timeAdded = timeAdded2;
            this.timeRemoved = timeRemoved2;
            this.state = state2;
        }

        public final long getTimeAdded() {
            return this.timeAdded;
        }

        public final void setTimeAdded(long j2) {
            this.timeAdded = j2;
        }

        public final long getTimeRemoved() {
            return this.timeRemoved;
        }

        public final void setTimeRemoved(long j2) {
            this.timeRemoved = j2;
        }

        public final StateInfo getState() {
            return this.state;
        }

        public final void setState(StateInfo stateInfo) {
            Intrinsics.checkNotNullParameter(stateInfo, "<set-?>");
            this.state = stateInfo;
        }
    }

    public final void removeState(String stateName) {
        Intrinsics.checkNotNullParameter(stateName, "stateName");
        markStateForRemoval(stateName);
    }

    public final List<StateInfo> getIntervalStates$lib_talos_core_release(long startTime, long endTime) {
        synchronized (this.singleFrameStates) {
            try {
                ArrayList arrayList = new ArrayList(this.states.size() + this.singleFrameStates.size());
                try {
                    addFrameState(startTime, endTime, arrayList, this.states);
                    addFrameState(startTime, endTime, arrayList, this.singleFrameStates);
                    Unit unit = Unit.INSTANCE;
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    ArrayList arrayList2 = arrayList;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    public final void cleanupSingleFrameStates$lib_talos_core_release() {
        synchronized (this.singleFrameStates) {
            this.singleFrameStates.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState$Companion;", "", "()V", "create", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState$MetricsStateHolder;", "view", "Landroid/view/View;", "create$lib_talos_core_release", "getForHierarchy", "getRootView", "getRootView$lib_talos_core_release", "lib-talos-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PerformanceMetricsState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MetricsStateHolder getForHierarchy(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            View rootView = getRootView$lib_talos_core_release(view2);
            Object metricsStateHolder = rootView.getTag(R.id.talosApmMetricsStateHolder);
            if (metricsStateHolder == null) {
                metricsStateHolder = new MetricsStateHolder();
                rootView.setTag(R.id.talosApmMetricsStateHolder, metricsStateHolder);
            }
            return (MetricsStateHolder) metricsStateHolder;
        }

        @JvmStatic
        public final MetricsStateHolder create$lib_talos_core_release(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            MetricsStateHolder holder = getForHierarchy(view2);
            if (holder.getState() == null) {
                holder.setState$lib_talos_core_release(new PerformanceMetricsState((DefaultConstructorMarker) null));
            }
            return holder;
        }

        public final View getRootView$lib_talos_core_release(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            View rootView = view2;
            ViewParent parent = rootView.getParent();
            while (parent instanceof View) {
                rootView = (View) parent;
                parent = rootView.getParent();
            }
            return rootView;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState$MetricsStateHolder;", "", "()V", "<set-?>", "Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState;", "state", "getState", "()Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState;", "setState$lib_talos_core_release", "(Lcom/baidu/talos/core/devsupport/performance/fps/jankstats/PerformanceMetricsState;)V", "lib-talos-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PerformanceMetricsState.kt */
    public static final class MetricsStateHolder {
        private PerformanceMetricsState state;

        public final PerformanceMetricsState getState() {
            return this.state;
        }

        public final void setState$lib_talos_core_release(PerformanceMetricsState performanceMetricsState) {
            this.state = performanceMetricsState;
        }
    }
}
