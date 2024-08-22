package com.baidu.browser.arch.event;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001a"}, d2 = {"Lcom/baidu/browser/arch/event/IBrowserBeeEvent;", "", "canGoBack", "", "handleGoBack", "", "isAnim", "handleGoForward", "onContainerAnimationFinish", "enter", "goback", "fromGesture", "onContainerAnimationStart", "onContainerAttachedToWindow", "onContainerDetachedFromWindow", "onContainerVisibleChanged", "show", "onRestart", "onRestore", "modelJsonStr", "", "onSaveState", "resetContainer", "updateContext", "context", "Landroid/content/Context;", "lib-browser-arch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IBrowserBeeEvent.kt */
public interface IBrowserBeeEvent {
    boolean canGoBack();

    void handleGoBack(boolean z);

    void handleGoForward();

    void onContainerAnimationFinish(boolean z, boolean z2, boolean z3);

    void onContainerAnimationStart(boolean z, boolean z2, boolean z3);

    void onContainerAttachedToWindow();

    void onContainerDetachedFromWindow();

    void onContainerVisibleChanged(boolean z);

    void onRestart();

    void onRestore(String str);

    void onSaveState(String str);

    void resetContainer();

    void updateContext(Context context);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IBrowserBeeEvent.kt */
    public static final class DefaultImpls {
        public static void onRestart(IBrowserBeeEvent iBrowserBeeEvent) {
        }

        public static void resetContainer(IBrowserBeeEvent iBrowserBeeEvent) {
        }

        public static void onSaveState(IBrowserBeeEvent iBrowserBeeEvent, String modelJsonStr) {
        }

        public static void onRestore(IBrowserBeeEvent iBrowserBeeEvent, String modelJsonStr) {
        }

        public static void onContainerAttachedToWindow(IBrowserBeeEvent iBrowserBeeEvent) {
        }

        public static void onContainerDetachedFromWindow(IBrowserBeeEvent iBrowserBeeEvent) {
        }

        public static void onContainerAnimationStart(IBrowserBeeEvent iBrowserBeeEvent, boolean enter, boolean goback, boolean fromGesture) {
        }

        public static void onContainerAnimationFinish(IBrowserBeeEvent iBrowserBeeEvent, boolean enter, boolean goback, boolean fromGesture) {
        }

        public static void updateContext(IBrowserBeeEvent iBrowserBeeEvent, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public static void handleGoForward(IBrowserBeeEvent iBrowserBeeEvent) {
        }

        public static boolean canGoBack(IBrowserBeeEvent iBrowserBeeEvent) {
            return false;
        }

        public static void handleGoBack(IBrowserBeeEvent iBrowserBeeEvent, boolean isAnim) {
        }

        public static void onContainerVisibleChanged(IBrowserBeeEvent iBrowserBeeEvent, boolean show) {
        }
    }
}
