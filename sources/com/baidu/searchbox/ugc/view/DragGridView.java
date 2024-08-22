package com.baidu.searchbox.ugc.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.OverScroller;
import com.baidu.spswitch.utils.UIUtils;
import java.util.ArrayList;
import java.util.List;

public class DragGridView extends GridView {
    private static final float AMP_FACTOR = 1.1f;
    private static final int DRAG_VIEW_SCROLL_DURATION = 200;
    private static final int LONG_CLICK_DURATION = 200;
    private static final int MODE_DRAG = 2;
    private static final int MODE_NORMAL = 1;
    private static final int SCALE_ANIM_DURATION = 80;
    private static final String TAG = "DragGridView";
    private static final int VIEW_TRANSLATE_ANIM_DURATION = 200;
    /* access modifiers changed from: private */
    public boolean isAnimRunning;
    private List<Rect> mChildGlobalRects;
    private List<Rect> mChildRects;
    /* access modifiers changed from: private */
    public int mCurAction;
    /* access modifiers changed from: private */
    public int mCurX;
    /* access modifiers changed from: private */
    public int mCurY;
    private int mDeltaLeft;
    private int mDeltaTop;
    private int mDeltaX;
    private int mDeltaY;
    private int mDistanceToCenterX;
    private int mDistanceToCenterY;
    private int mDownRawX;
    private int mDownRawY;
    /* access modifiers changed from: private */
    public FrameLayout mDragLayout;
    private WindowManager.LayoutParams mDragLayoutLp;
    /* access modifiers changed from: private */
    public int mDragPos;
    private Handler mHandler;
    private int mInitDragPos;
    private Runnable mLongClickRunnable;
    /* access modifiers changed from: private */
    public int mMode;
    private OverScroller mScroller;
    private int mTargetPos;
    private int mTouchSlop;
    private WindowManager mWindowManager;

    public DragGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DragGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mChildRects = new ArrayList();
        this.mChildGlobalRects = new ArrayList();
        this.mMode = 1;
        this.isAnimRunning = false;
        this.mLongClickRunnable = new Runnable() {
            public void run() {
                DragGridView dragGridView = DragGridView.this;
                if (dragGridView.pointToPosition(dragGridView.mCurX, DragGridView.this.mCurY) == DragGridView.this.mDragPos) {
                    int unused = DragGridView.this.mMode = 2;
                    DragGridView.this.initDragWindow();
                    DragGridView.this.postDelayed(new Runnable() {
                        public void run() {
                            if (DragGridView.this.mCurAction != 1 && DragGridView.this.mCurAction != 3) {
                                DragGridView.this.hideDragItem();
                            }
                        }
                    }, 80);
                }
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mScroller = new OverScroller(context);
        this.mHandler = new Handler();
        this.mDragLayout = new FrameLayout(getContext());
        this.mDragLayoutLp = new WindowManager.LayoutParams();
        this.mWindowManager = (WindowManager) getContext().getSystemService("window");
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* access modifiers changed from: private */
    public void removeDragView() {
        if (this.mMode == 2 && Build.VERSION.SDK_INT >= 19 && this.mDragLayout.isAttachedToWindow()) {
            this.mWindowManager.removeView(this.mDragLayout);
            this.mDragLayout.setAlpha(1.0f);
        }
    }

    /* access modifiers changed from: private */
    public void initDragWindow() {
        View dragItem = getChildAt(this.mDragPos);
        dragItem.setDrawingCacheEnabled(true);
        Bitmap bmp = Bitmap.createBitmap(dragItem.getDrawingCache());
        this.mDragLayoutLp.format = -3;
        this.mDragLayoutLp.gravity = 51;
        this.mDragLayoutLp.height = (int) (((float) bmp.getHeight()) * 1.1f);
        this.mDragLayoutLp.width = (int) (((float) bmp.getWidth()) * 1.1f);
        Rect globalRect = this.mChildGlobalRects.get(this.mDragPos);
        this.mDeltaLeft = (this.mDragLayoutLp.width - bmp.getWidth()) / 2;
        this.mDragLayoutLp.x = globalRect.left - this.mDeltaLeft;
        int statusBarHeight = UIUtils.getStatusBarHeight(getContext());
        this.mDeltaTop = (this.mDragLayoutLp.height - bmp.getHeight()) / 2;
        this.mDragLayoutLp.y = (globalRect.top - statusBarHeight) - this.mDeltaTop;
        this.mWindowManager.addView(this.mDragLayout, this.mDragLayoutLp);
        this.mDeltaX = this.mDownRawX - this.mDragLayoutLp.x;
        this.mDeltaY = this.mDownRawY - this.mDragLayoutLp.y;
        this.mDragLayout.removeAllViews();
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(bmp);
        FrameLayout.LayoutParams dragViewLp = new FrameLayout.LayoutParams(bmp.getWidth(), bmp.getHeight());
        dragViewLp.gravity = 17;
        this.mDragLayout.addView(imageView, dragViewLp);
        this.mDragLayout.setAlpha(1.0f);
        imageView.animate().scaleX(1.1f).scaleY(1.1f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                DragGridView.this.mDragLayout.setAlpha(0.6f);
            }
        }).setDuration(80).start();
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        this.mCurAction = ev.getAction();
        switch (ev.getAction()) {
            case 0:
                if (this.mMode != 2) {
                    fillRect();
                    this.mDownRawX = (int) ev.getRawX();
                    this.mDownRawY = (int) ev.getRawY();
                    this.mCurX = (int) ev.getX();
                    int y = (int) ev.getY();
                    this.mCurY = y;
                    int pointToPosition = pointToPosition(this.mCurX, y);
                    this.mDragPos = pointToPosition;
                    if (pointToPosition != -1 && !isMorePosition(pointToPosition)) {
                        View child = getChildAt(this.mDragPos);
                        if (child != null) {
                            Rect rect = new Rect();
                            child.getHitRect(rect);
                            this.mDistanceToCenterX = rect.centerX() - this.mCurX;
                            this.mDistanceToCenterY = rect.centerY() - this.mCurY;
                            int i2 = this.mDragPos;
                            this.mTargetPos = i2;
                            this.mInitDragPos = i2;
                            this.mHandler.postDelayed(this.mLongClickRunnable, 200);
                            break;
                        } else {
                            return super.dispatchTouchEvent(ev);
                        }
                    } else {
                        return super.dispatchTouchEvent(ev);
                    }
                } else {
                    return super.dispatchTouchEvent(ev);
                }
            case 1:
            case 3:
                if (this.mMode == 2) {
                    dragViewScrollToTarget();
                }
                this.mHandler.removeCallbacksAndMessages((Object) null);
                break;
            case 2:
                this.mCurX = (int) ev.getX();
                this.mCurY = (int) ev.getY();
                int dx = ((int) ev.getRawX()) - this.mDownRawX;
                int dy = ((int) ev.getRawY()) - this.mDownRawY;
                if (this.mMode != 2) {
                    if (Math.abs(dx) > this.mTouchSlop || Math.abs(dy) > this.mTouchSlop) {
                        this.mHandler.removeCallbacksAndMessages((Object) null);
                        break;
                    }
                } else {
                    updateWindowPosition(ev);
                    exchangeItemsWithAnim(ev);
                    break;
                }
        }
        return super.dispatchTouchEvent(ev);
    }

    public void computeScroll() {
        if (this.mDragLayout.isAttachedToWindow() && this.mScroller.computeScrollOffset()) {
            int x = this.mScroller.getCurrX();
            int y = this.mScroller.getCurrY();
            this.mDragLayoutLp.x = x;
            this.mDragLayoutLp.y = y;
            this.mWindowManager.updateViewLayout(this.mDragLayout, this.mDragLayoutLp);
            invalidate();
            if (this.mScroller.isFinished()) {
                exchangePosition(this.mInitDragPos, this.mTargetPos);
                post(new Runnable() {
                    public void run() {
                        DragGridView.this.removeDragView();
                        int unused = DragGridView.this.mMode = 1;
                    }
                });
            }
        }
    }

    private void exchangeItemsWithAnim(MotionEvent ev) {
        int realPos;
        int targetPos;
        int dragPos;
        if (this.mMode == 2 && !this.isAnimRunning && (realPos = pointToPosition(((int) ev.getX()) + this.mDistanceToCenterX, ((int) ev.getY()) + this.mDistanceToCenterY)) != -1 && (targetPos = realPosToVisual(realPos)) != (dragPos = this.mDragPos) && !isMorePosition(targetPos)) {
            this.isAnimRunning = true;
            if (targetPos < dragPos) {
                for (int i2 = targetPos; i2 < dragPos; i2++) {
                    int index = i2;
                    View view2 = getChild(this.mChildRects.get(i2));
                    if (view2 != null) {
                        if (index == dragPos - 1) {
                            animView(view2, true, new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animation) {
                                    boolean unused = DragGridView.this.isAnimRunning = false;
                                }
                            });
                        } else {
                            animView(view2, true, (Animator.AnimatorListener) null);
                        }
                    }
                }
            } else {
                for (int i3 = dragPos + 1; i3 <= targetPos; i3++) {
                    int index2 = i3;
                    View view3 = getChild(this.mChildRects.get(i3));
                    if (view3 != null) {
                        if (index2 == targetPos) {
                            animView(view3, false, new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animation) {
                                    boolean unused = DragGridView.this.isAnimRunning = false;
                                }
                            });
                        } else {
                            animView(view3, false, (Animator.AnimatorListener) null);
                        }
                    }
                }
            }
            this.mDragPos = targetPos;
            this.mTargetPos = targetPos;
        }
    }

    private int realPosToVisual(int realPos) {
        View child = getChildAt(realPos);
        float translationX = child.getTranslationX();
        float translationY = child.getTranslationY();
        if (translationY > 0.0f) {
            return realPos + 1;
        }
        if (translationY < 0.0f) {
            return realPos - 1;
        }
        if (translationX > 0.0f) {
            return realPos + 1;
        }
        if (translationX < 0.0f) {
            return realPos - 1;
        }
        return realPos;
    }

    private View getChild(Rect rect) {
        int count = getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View child = getChildAt(i2);
            if (child.getVisibility() == 0) {
                Rect r = new Rect();
                child.getHitRect(r);
                if (r.equals(rect)) {
                    return child;
                }
            }
        }
        return null;
    }

    private void animView(View view2, boolean isBack, Animator.AnimatorListener listener) {
        Rect rect = new Rect();
        view2.getHitRect(rect);
        Rect peerRect = isBack ? getNextRect(rect) : getPriorRect(rect);
        if (peerRect != null) {
            view2.animate().translationX((view2.getTranslationX() + ((float) peerRect.left)) - ((float) rect.left)).translationY((view2.getTranslationY() + ((float) peerRect.top)) - ((float) rect.top)).setDuration(200).setListener(listener);
        }
    }

    private Rect getPriorRect(Rect rect) {
        int pos = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mChildRects.size()) {
                break;
            } else if (rect.equals(this.mChildRects.get(i2))) {
                pos = i2;
                break;
            } else {
                i2++;
            }
        }
        if (pos == 0 || pos == -1) {
            return null;
        }
        return this.mChildRects.get(pos - 1);
    }

    private Rect getNextRect(Rect rect) {
        int pos = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mChildRects.size()) {
                break;
            } else if (rect.equals(this.mChildRects.get(i2))) {
                pos = i2;
                break;
            } else {
                i2++;
            }
        }
        if (pos == -1 || pos == this.mChildRects.size() - 1) {
            return null;
        }
        return this.mChildRects.get(pos + 1);
    }

    private void dragViewScrollToTarget() {
        if (getChildAt(this.mTargetPos - getFirstVisiblePosition()) != null) {
            Rect globalRect = this.mChildGlobalRects.get(this.mTargetPos);
            int targetX = globalRect.left - this.mDeltaLeft;
            int targetY = (globalRect.top - UIUtils.getStatusBarHeight(getContext())) - this.mDeltaTop;
            int startX = this.mDragLayoutLp.x;
            int startY = this.mDragLayoutLp.y;
            this.mScroller.startScroll(startX, startY, targetX - startX, targetY - startY, 200);
            scaleDownImageView();
            invalidate();
        }
    }

    private void scaleDownImageView() {
        View imageView = this.mDragLayout.getChildAt(0);
        if (imageView != null) {
            imageView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
        }
    }

    private void updateWindowPosition(MotionEvent ev) {
        if (this.mMode == 2) {
            this.mDragLayoutLp.x = (int) (ev.getRawX() - ((float) this.mDeltaX));
            this.mDragLayoutLp.y = (int) (ev.getRawY() - ((float) this.mDeltaY));
            this.mWindowManager.updateViewLayout(this.mDragLayout, this.mDragLayoutLp);
        }
    }

    private void fillRect() {
        this.mChildRects.clear();
        this.mChildGlobalRects.clear();
        int count = getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            if (!isMorePosition(i2)) {
                View child = getChildAt(i2);
                Rect rect = new Rect();
                child.getHitRect(rect);
                this.mChildRects.add(rect);
                Rect globalRect = new Rect();
                child.getGlobalVisibleRect(globalRect);
                this.mChildGlobalRects.add(globalRect);
            }
        }
    }

    public boolean isDragMode() {
        return this.mMode == 2;
    }

    /* access modifiers changed from: private */
    public void hideDragItem() {
        View child = getChildAt(this.mDragPos);
        if (child != null) {
            child.setVisibility(4);
        }
    }

    public boolean isMorePosition(int position) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void exchangePosition(int draggedPos, int targetPos) {
    }
}
