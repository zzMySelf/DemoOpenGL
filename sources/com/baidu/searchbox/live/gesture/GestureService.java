package com.baidu.searchbox.live.gesture;

import com.baidu.live.arch.api.IService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00070\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/live/gesture/GestureService;", "Lcom/baidu/live/arch/api/IService;", "()V", "mListeners", "", "Lcom/baidu/searchbox/live/gesture/OnGestureListener;", "kotlin.jvm.PlatformType", "", "addGestureListener", "", "listener", "onCloseEvent", "onLeftMove", "delX", "", "currentLeftViewOffset", "onRightMove", "currentRightViewOffset", "removeAllRegisterListener", "removeRegisterListener", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GestureService.kt */
public final class GestureService implements IService {
    private final List<OnGestureListener> mListeners = Collections.synchronizedList(new ArrayList());

    public final void addGestureListener(OnGestureListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        if (!this.mListeners.contains(listener)) {
            this.mListeners.add(listener);
        }
    }

    public final void removeRegisterListener(OnGestureListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        if (this.mListeners.contains(listener)) {
            this.mListeners.remove(listener);
        }
    }

    public final void removeAllRegisterListener(OnGestureListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        List<OnGestureListener> list = this.mListeners;
        Intrinsics.checkExpressionValueIsNotNull(list, "mListeners");
        synchronized (list) {
            this.mListeners.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void onRightMove(int delX, int currentRightViewOffset) {
        List<OnGestureListener> list = this.mListeners;
        Intrinsics.checkExpressionValueIsNotNull(list, "mListeners");
        synchronized (list) {
            for (OnGestureListener next : this.mListeners) {
                if (next != null) {
                    next.onRightMove(delX, currentRightViewOffset);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void onLeftMove(int delX, int currentLeftViewOffset) {
        List<OnGestureListener> list = this.mListeners;
        Intrinsics.checkExpressionValueIsNotNull(list, "mListeners");
        synchronized (list) {
            for (OnGestureListener next : this.mListeners) {
                if (next != null) {
                    next.onLeftMove(delX, currentLeftViewOffset);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void onCloseEvent() {
        List<OnGestureListener> list = this.mListeners;
        Intrinsics.checkExpressionValueIsNotNull(list, "mListeners");
        synchronized (list) {
            for (OnGestureListener next : this.mListeners) {
                if (next != null) {
                    next.onCloseEvent();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
