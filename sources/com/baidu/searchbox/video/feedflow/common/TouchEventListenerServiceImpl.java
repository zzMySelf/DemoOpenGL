package com.baidu.searchbox.video.feedflow.common;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\u00072\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016R\"\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/common/TouchEventListenerServiceImpl;", "Lcom/baidu/searchbox/video/feedflow/common/ITouchEventListenerService;", "()V", "listeners", "", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "", "addTouchEventListener", "listener", "clearAllListener", "dispatch", "event", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TouchEventListenerServiceImpl.kt */
public final class TouchEventListenerServiceImpl implements ITouchEventListenerService {
    private final List<Function1<MotionEvent, Unit>> listeners = new ArrayList();

    public void addTouchEventListener(Function1<? super MotionEvent, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public void dispatch(MotionEvent event) {
        for (Function1 listener : this.listeners) {
            listener.invoke(event);
        }
    }

    public void clearAllListener() {
        this.listeners.clear();
    }
}
