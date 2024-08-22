package com.baidu.searchbox.video.feedflow.view.carousepic.gesture.abs;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J(\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/view/carousepic/gesture/abs/IOnScaleDragGestureListener;", "", "onDrag", "", "dx", "", "dy", "onDragEnd", "onDragStart", "onFling", "startX", "startY", "velocityX", "velocityY", "onScale", "scaleFactor", "focusX", "focusY", "onScaleEnd", "isBounced", "", "onScaleStart", "scale", "onTwoFingerTouchEnd", "onTwoFingerTouchStart", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IOnScaleDragGestureListener.kt */
public interface IOnScaleDragGestureListener {
    void onDrag(float f2, float f3);

    void onDragEnd();

    void onDragStart();

    void onFling(float f2, float f3, float f4, float f5);

    void onScale(float f2, float f3, float f4);

    void onScaleEnd(boolean z);

    void onScaleStart(float f2, float f3, float f4);

    void onTwoFingerTouchEnd();

    void onTwoFingerTouchStart();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IOnScaleDragGestureListener.kt */
    public static final class DefaultImpls {
        public static void onDrag(IOnScaleDragGestureListener iOnScaleDragGestureListener, float dx, float dy) {
        }

        public static void onFling(IOnScaleDragGestureListener iOnScaleDragGestureListener, float startX, float startY, float velocityX, float velocityY) {
        }

        public static void onScale(IOnScaleDragGestureListener iOnScaleDragGestureListener, float scaleFactor, float focusX, float focusY) {
        }

        public static void onScaleStart(IOnScaleDragGestureListener iOnScaleDragGestureListener, float scale, float focusX, float focusY) {
        }

        public static void onScaleEnd(IOnScaleDragGestureListener iOnScaleDragGestureListener, boolean isBounced) {
        }

        public static /* synthetic */ void onScaleEnd$default(IOnScaleDragGestureListener iOnScaleDragGestureListener, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                iOnScaleDragGestureListener.onScaleEnd(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onScaleEnd");
        }

        public static void onTwoFingerTouchStart(IOnScaleDragGestureListener iOnScaleDragGestureListener) {
        }

        public static void onTwoFingerTouchEnd(IOnScaleDragGestureListener iOnScaleDragGestureListener) {
        }

        public static void onDragStart(IOnScaleDragGestureListener iOnScaleDragGestureListener) {
        }

        public static void onDragEnd(IOnScaleDragGestureListener iOnScaleDragGestureListener) {
        }
    }
}
