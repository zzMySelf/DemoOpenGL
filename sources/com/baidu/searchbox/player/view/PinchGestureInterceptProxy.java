package com.baidu.searchbox.player.view;

import android.view.MotionEvent;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/player/view/PinchGestureInterceptProxy;", "", "gestureMode", "", "getGestureMode", "()I", "setGestureMode", "(I)V", "isInProgress", "", "()Z", "setInProgress", "(Z)V", "shouldPreventGesture", "getShouldPreventGesture", "setShouldPreventGesture", "onExternalPinchTouchEvent", "", "onExternalTouchEvent", "event", "Landroid/view/MotionEvent;", "scaleFactor", "", "shouldInterceptGesture", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinchGestureInterceptProxy.kt */
public interface PinchGestureInterceptProxy {
    int getGestureMode();

    boolean getShouldPreventGesture();

    boolean isInProgress();

    void onExternalPinchTouchEvent();

    void onExternalTouchEvent(MotionEvent motionEvent, float f2);

    void setGestureMode(int i2);

    void setInProgress(boolean z);

    void setShouldPreventGesture(boolean z);

    boolean shouldInterceptGesture();
}
