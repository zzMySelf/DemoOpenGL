package com.baidu.searchbox.openwidget.engine;

import com.baidu.searchbox.openwidget.animation.OpenWidgetAnimation;
import com.baidu.searchbox.openwidget.model.OpenWidgetTouch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/openwidget/engine/CallExactlyOnceEngineCallback;", "Lcom/baidu/searchbox/openwidget/engine/OpenWidgetEngineCallback;", "actualCallback", "(Lcom/baidu/searchbox/openwidget/engine/OpenWidgetEngineCallback;)V", "hasCompleted", "", "hasSetAnimation", "hasSetTouchData", "onLoadFail", "", "exception", "Lcom/baidu/searchbox/openwidget/engine/OpenWidgetLoadException;", "onLoadSuccess", "result", "Lcom/baidu/searchbox/openwidget/engine/LoadSuccessResult;", "onSetAnimation", "animation", "Lcom/baidu/searchbox/openwidget/animation/OpenWidgetAnimation;", "onSetTouchData", "touch", "Lcom/baidu/searchbox/openwidget/model/OpenWidgetTouch;", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenWidgetEngineCallback.kt */
final class CallExactlyOnceEngineCallback implements OpenWidgetEngineCallback {
    private final OpenWidgetEngineCallback actualCallback;
    private boolean hasCompleted;
    private boolean hasSetAnimation;
    private boolean hasSetTouchData;

    public CallExactlyOnceEngineCallback(OpenWidgetEngineCallback actualCallback2) {
        Intrinsics.checkNotNullParameter(actualCallback2, "actualCallback");
        this.actualCallback = actualCallback2;
    }

    public void onLoadSuccess(LoadSuccessResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!this.hasCompleted) {
            this.hasCompleted = true;
            this.actualCallback.onLoadSuccess(result);
        }
    }

    public void onLoadFail(OpenWidgetLoadException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (!this.hasCompleted) {
            this.hasCompleted = true;
            this.actualCallback.onLoadFail(exception);
        }
    }

    public void onSetTouchData(OpenWidgetTouch touch) {
        Intrinsics.checkNotNullParameter(touch, "touch");
        if (!this.hasCompleted && !this.hasSetTouchData) {
            this.hasSetTouchData = true;
            this.actualCallback.onSetTouchData(touch);
        }
    }

    public void onSetAnimation(OpenWidgetAnimation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (!this.hasCompleted && !this.hasSetAnimation) {
            this.hasSetAnimation = true;
            this.actualCallback.onSetAnimation(animation);
        }
    }
}
