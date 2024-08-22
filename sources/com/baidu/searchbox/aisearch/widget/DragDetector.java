package com.baidu.searchbox.aisearch.widget;

import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0007J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0007J\b\u0010)\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020\u001fH\u0002J\u0018\u0010+\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0014\u0010-\u001a\u00020\r*\u00020!2\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0014\u0010.\u001a\u00020\r*\u00020!2\u0006\u0010,\u001a\u00020\u0006H\u0002R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/aisearch/widget/DragDetector;", "", "view", "Landroid/view/View;", "types", "", "", "(Landroid/view/View;Ljava/util/Set;)V", "activePointerId", "currType", "getCurrType$annotations", "()V", "distance", "", "dragListener", "Lcom/baidu/searchbox/aisearch/widget/DragListener;", "getDragListener", "()Lcom/baidu/searchbox/aisearch/widget/DragListener;", "setDragListener", "(Lcom/baidu/searchbox/aisearch/widget/DragListener;)V", "initialDownX", "initialDownY", "isBeingDragged", "", "isUnableDrag", "lastTouch", "minFlingVelocity", "touchSlop", "velocityTracker", "Landroid/view/VelocityTracker;", "checkDrag", "", "ev", "Landroid/view/MotionEvent;", "checkDragWithType", "initTouch", "initVelocity", "isQuickDrag", "onDragging", "onInterceptTouchEvent", "onTouchEvent", "recycleVelocity", "resetTouch", "updateLastTouch", "pointerIndex", "safeGetX", "safeGetY", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DragDetector.kt */
public final class DragDetector {
    private int activePointerId = -1;
    private int currType;
    private float distance;
    private DragListener dragListener;
    private float initialDownX;
    private float initialDownY;
    private boolean isBeingDragged;
    private boolean isUnableDrag;
    private float lastTouch;
    private final int minFlingVelocity;
    private final int touchSlop;
    private final Set<Integer> types;
    private VelocityTracker velocityTracker;

    /* renamed from: view  reason: collision with root package name */
    private final View f18615view;

    private static /* synthetic */ void getCurrType$annotations() {
    }

    public DragDetector(View view2, Set<Integer> types2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(types2, "types");
        this.f18615view = view2;
        this.types = types2;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view2.getContext());
        this.touchSlop = viewConfiguration != null ? viewConfiguration.getScaledTouchSlop() : ViewExKt.getDp(8);
        this.minFlingVelocity = ViewConfiguration.get(view2.getContext()).getScaledMinimumFlingVelocity();
    }

    public final DragListener getDragListener() {
        return this.dragListener;
    }

    public final void setDragListener(DragListener dragListener2) {
        this.dragListener = dragListener2;
    }

    private final void initVelocity() {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    private final void recycleVelocity() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
        }
        this.velocityTracker = null;
    }

    public final boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.types.isEmpty()) {
            return false;
        }
        int actionMasked = ev.getActionMasked();
        switch (actionMasked) {
            case 1:
            case 3:
                if (DragDetectorKt.DEBUG) {
                    Log.v("DragDetector", "Intercept done!");
                }
                resetTouch();
                return false;
            default:
                if (actionMasked == 0 || !this.isUnableDrag) {
                    switch (actionMasked) {
                        case 0:
                            resetTouch();
                            initTouch(ev);
                            DragListener dragListener2 = this.dragListener;
                            if (dragListener2 != null) {
                                dragListener2.onTouchDown(ev);
                            }
                            if (DragDetectorKt.DEBUG) {
                                Log.d("DragDetector", "onInterceptTouchEvent: ACTION DOWN");
                                break;
                            }
                            break;
                        case 2:
                            checkDrag(ev);
                            onDragging(ev);
                            break;
                        case 5:
                            if (!this.isBeingDragged) {
                                this.isUnableDrag = true;
                                if (DragDetectorKt.DEBUG) {
                                    Log.d("DragDetector", "onInterceptTouchEvent: disable drag on multiple pointer down");
                                    break;
                                }
                            }
                            break;
                    }
                    return this.isBeingDragged;
                }
                if (DragDetectorKt.DEBUG) {
                    Log.d("DragDetector", "onInterceptTouchEvent: isUnableDrag: action: " + actionMasked);
                }
                return false;
        }
    }

    private final void initTouch(MotionEvent ev) {
        this.initialDownY = ev.getY();
        this.initialDownX = ev.getX();
        this.activePointerId = ev.getPointerId(0);
        updateLastTouch(ev, 0);
    }

    private final void checkDrag(MotionEvent ev) {
        if (!this.isBeingDragged && checkDragWithType(ev)) {
            DragListener dragListener2 = this.dragListener;
            if (!(dragListener2 != null && !dragListener2.canDrag(ev, this.currType))) {
                if (DragDetectorKt.DEBUG) {
                    Log.d("DragDetector", "checkDrag: startDrag");
                }
                this.isBeingDragged = true;
                DragListener dragListener3 = this.dragListener;
                if (dragListener3 != null) {
                    dragListener3.onDragStart(this.currType);
                }
                updateLastTouch(ev, 0);
                ViewParent parent = this.f18615view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
    }

    private final boolean checkDragWithType(MotionEvent ev) {
        float x = ev.getX();
        float y = ev.getY();
        float dx = x - this.initialDownX;
        float dy = y - this.initialDownY;
        float absDx = Math.abs(dx);
        float absDy = Math.abs(y - this.initialDownY);
        int i2 = this.touchSlop;
        boolean isHorizonTouch = absDx > ((float) i2) && absDx * 0.5f > absDy;
        boolean isVerticalTouch = absDy > ((float) i2) && 0.5f * absDy > absDx;
        if (this.types.contains(2) && dx < 0.0f && isHorizonTouch) {
            this.currType = 2;
            return true;
        } else if (this.types.contains(3) && dx > 0.0f && isHorizonTouch) {
            this.currType = 3;
            return true;
        } else if (this.types.contains(1) && dy > 0.0f && isVerticalTouch) {
            this.currType = 1;
            return true;
        } else if (!this.types.contains(4) || dy >= 0.0f || !isVerticalTouch) {
            return false;
        } else {
            this.currType = 4;
            return true;
        }
    }

    public final boolean onTouchEvent(MotionEvent ev) {
        DragListener dragListener2;
        DragListener dragListener3;
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.types.isEmpty()) {
            return false;
        }
        initVelocity();
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(ev);
        }
        switch (ev.getActionMasked()) {
            case 0:
                initTouch(ev);
                DragListener dragListener4 = this.dragListener;
                if (dragListener4 != null) {
                    dragListener4.onTouchDown(ev);
                }
                if (DragDetectorKt.DEBUG) {
                    Log.d("DragDetector", "onTouchEvent: ACTION DOWN");
                    break;
                }
                break;
            case 1:
                if (this.isBeingDragged && (dragListener2 = this.dragListener) != null) {
                    dragListener2.onDragEnd(this.distance, isQuickDrag(), this.currType);
                }
                resetTouch();
                break;
            case 2:
                checkDrag(ev);
                onDragging(ev);
                break;
            case 3:
                if (this.isBeingDragged && (dragListener3 = this.dragListener) != null) {
                    dragListener3.onDragCancel(this.currType);
                }
                resetTouch();
                break;
            case 5:
                if (this.isBeingDragged != 0) {
                    int pointerId = ev.getPointerId(ev.getActionIndex());
                    this.activePointerId = pointerId;
                    updateLastTouch(ev, pointerId);
                    break;
                }
                break;
            case 6:
                if (this.isBeingDragged) {
                    int actionIndex = ev.getActionIndex();
                    int pointerId2 = ev.getPointerId(actionIndex);
                    if (this.isBeingDragged && pointerId2 == this.activePointerId) {
                        int lastIndex = ev.getPointerCount() - 1;
                        int newPointerIndex = (actionIndex != lastIndex || lastIndex <= 0) ? lastIndex : lastIndex - 1;
                        this.activePointerId = ev.getPointerId(newPointerIndex);
                        updateLastTouch(ev, newPointerIndex);
                        break;
                    }
                }
                break;
        }
        return this.isBeingDragged;
    }

    private final int isQuickDrag() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.computeCurrentVelocity(1000);
        }
        switch (this.currType) {
            case 1:
            case 4:
                VelocityTracker velocityTracker3 = this.velocityTracker;
                if (velocityTracker3 == null) {
                    return -1;
                }
                float $this$isQuickDrag_u24lambda_u2d1 = velocityTracker3.getYVelocity();
                int i2 = this.minFlingVelocity;
                if ($this$isQuickDrag_u24lambda_u2d1 > ((float) i2)) {
                    return 0;
                }
                if ($this$isQuickDrag_u24lambda_u2d1 < ((float) (-i2))) {
                    return 1;
                }
                return -1;
            case 2:
            case 3:
                VelocityTracker velocityTracker4 = this.velocityTracker;
                if (velocityTracker4 == null) {
                    return -1;
                }
                float $this$isQuickDrag_u24lambda_u2d0 = velocityTracker4.getXVelocity();
                if (DragDetectorKt.DEBUG) {
                    Log.d("DragDetector", "onDragEnd: xVelocity: " + $this$isQuickDrag_u24lambda_u2d0);
                }
                int i3 = this.minFlingVelocity;
                if ($this$isQuickDrag_u24lambda_u2d0 < ((float) (-i3))) {
                    return 2;
                }
                if ($this$isQuickDrag_u24lambda_u2d0 > ((float) i3)) {
                    return 3;
                }
                return -1;
            default:
                return -1;
        }
    }

    private final void updateLastTouch(MotionEvent ev, int pointerIndex) {
        if (pointerIndex >= 0 && pointerIndex < ev.getPointerCount()) {
            switch (this.currType) {
                case 1:
                case 4:
                    this.lastTouch = safeGetY(ev, pointerIndex);
                    return;
                case 2:
                case 3:
                    this.lastTouch = safeGetX(ev, pointerIndex);
                    return;
                default:
                    return;
            }
        } else if (DragDetectorKt.DEBUG) {
            Log.e("DragDetector", "updateLastTouch err,  pointerIndex: " + pointerIndex);
        }
    }

    private final float safeGetX(MotionEvent $this$safeGetX, int pointerIndex) {
        Float f2;
        try {
            Result.Companion companion = Result.Companion;
            f2 = Result.m8971constructorimpl(Float.valueOf($this$safeGetX.getX(pointerIndex)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            f2 = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Float valueOf = Float.valueOf(0.0f);
        if (Result.m8977isFailureimpl(f2)) {
            f2 = valueOf;
        }
        return ((Number) f2).floatValue();
    }

    private final float safeGetY(MotionEvent $this$safeGetY, int pointerIndex) {
        Float f2;
        try {
            Result.Companion companion = Result.Companion;
            f2 = Result.m8971constructorimpl(Float.valueOf($this$safeGetY.getY(pointerIndex)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            f2 = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Float valueOf = Float.valueOf(0.0f);
        if (Result.m8977isFailureimpl(f2)) {
            f2 = valueOf;
        }
        return ((Number) f2).floatValue();
    }

    private final void onDragging(MotionEvent ev) {
        Float f2;
        int activeIndex = ev.findPointerIndex(this.activePointerId);
        if (activeIndex >= 0 && activeIndex < ev.getPointerCount()) {
            switch (this.currType) {
                case 1:
                case 4:
                    f2 = Float.valueOf(safeGetY(ev, activeIndex));
                    break;
                case 2:
                case 3:
                    f2 = Float.valueOf(safeGetX(ev, activeIndex));
                    break;
                default:
                    f2 = null;
                    break;
            }
            if (f2 != null) {
                float xy = f2.floatValue();
                if (this.isBeingDragged) {
                    float f3 = this.distance + (xy - this.lastTouch);
                    this.distance = f3;
                    DragListener dragListener2 = this.dragListener;
                    if (dragListener2 != null) {
                        dragListener2.onDragging(f3, this.currType);
                    }
                }
                this.lastTouch = xy;
            }
        } else if (DragDetectorKt.DEBUG) {
            Log.e("DragDetector", "onDragging err,  activeIndex: " + activeIndex);
        }
    }

    private final void resetTouch() {
        this.isBeingDragged = false;
        this.isUnableDrag = false;
        this.distance = 0.0f;
        this.activePointerId = -1;
        recycleVelocity();
    }
}
