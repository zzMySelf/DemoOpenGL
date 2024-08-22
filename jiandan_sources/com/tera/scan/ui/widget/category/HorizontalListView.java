package com.tera.scan.ui.widget.category;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView extends AdapterView<ListAdapter> {
    public ListAdapter mAdapter;
    public boolean mAlwaysOverrideTouch = true;
    public int mCurrentX;
    public boolean mDataChanged = false;
    public DataSetObserver mDataObserver = new qw();
    public int mDisplayOffset = 0;
    public GestureDetector mGesture;
    public int mLastX;
    public int mLastY;
    public int mLeftViewIndex = -1;
    public int mMaxX = Integer.MAX_VALUE;
    public int mNextX;
    public GestureDetector.OnGestureListener mOnGesture = new de();
    public AdapterView.OnItemClickListener mOnItemClicked;
    public AdapterView.OnItemLongClickListener mOnItemLongClicked;
    public AdapterView.OnItemSelectedListener mOnItemSelected;
    public Queue<View> mRemovedViewQueue = new LinkedList();
    public int mRightViewIndex = 0;
    public Scroller mScroller;

    public class ad implements Runnable {
        public ad() {
        }

        public void run() {
            HorizontalListView.this.requestLayout();
        }
    }

    public class de extends GestureDetector.SimpleOnGestureListener {
        public de() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.onDown(motionEvent);
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return HorizontalListView.this.onFling(motionEvent, motionEvent2, f, f2);
        }

        public void onLongPress(MotionEvent motionEvent) {
            int childCount = HorizontalListView.this.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = HorizontalListView.this.getChildAt(i2);
                if (!qw(motionEvent, childAt)) {
                    i2++;
                } else if (HorizontalListView.this.mOnItemLongClicked != null) {
                    AdapterView.OnItemLongClickListener access$500 = HorizontalListView.this.mOnItemLongClicked;
                    HorizontalListView horizontalListView = HorizontalListView.this;
                    int access$300 = horizontalListView.mLeftViewIndex + 1 + i2;
                    HorizontalListView horizontalListView2 = HorizontalListView.this;
                    access$500.onItemLongClick(horizontalListView, childAt, access$300, horizontalListView2.mAdapter.getItemId(horizontalListView2.mLeftViewIndex + 1 + i2));
                    return;
                } else {
                    return;
                }
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            synchronized (HorizontalListView.this) {
                HorizontalListView.this.mNextX += (int) f;
            }
            HorizontalListView.this.requestLayout();
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            int i2 = 0;
            while (true) {
                if (i2 >= HorizontalListView.this.getChildCount()) {
                    break;
                }
                View childAt = HorizontalListView.this.getChildAt(i2);
                if (qw(motionEvent, childAt)) {
                    if (HorizontalListView.this.mOnItemClicked != null) {
                        AdapterView.OnItemClickListener access$200 = HorizontalListView.this.mOnItemClicked;
                        HorizontalListView horizontalListView = HorizontalListView.this;
                        int access$300 = horizontalListView.mLeftViewIndex + 1 + i2;
                        HorizontalListView horizontalListView2 = HorizontalListView.this;
                        access$200.onItemClick(horizontalListView, childAt, access$300, horizontalListView2.mAdapter.getItemId(horizontalListView2.mLeftViewIndex + 1 + i2));
                    }
                    if (HorizontalListView.this.mOnItemSelected != null) {
                        AdapterView.OnItemSelectedListener access$400 = HorizontalListView.this.mOnItemSelected;
                        HorizontalListView horizontalListView3 = HorizontalListView.this;
                        int access$3002 = horizontalListView3.mLeftViewIndex + 1 + i2;
                        HorizontalListView horizontalListView4 = HorizontalListView.this;
                        access$400.onItemSelected(horizontalListView3, childAt, access$3002, horizontalListView4.mAdapter.getItemId(horizontalListView4.mLeftViewIndex + 1 + i2));
                    }
                } else {
                    i2++;
                }
            }
            return true;
        }

        public final boolean qw(MotionEvent motionEvent, View view) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            rect.set(i2, i3, view.getWidth() + i2, view.getHeight() + i3);
            return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    public class qw extends DataSetObserver {
        public qw() {
        }

        public void onChanged() {
            synchronized (HorizontalListView.this) {
                boolean unused = HorizontalListView.this.mDataChanged = true;
            }
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        public void onInvalidated() {
            HorizontalListView.this.reset();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void addAndMeasureChild(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i2, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    private void fillList(int i2) {
        View childAt = getChildAt(getChildCount() - 1);
        int i3 = 0;
        fillListRight(childAt != null ? childAt.getRight() : 0, i2);
        View childAt2 = getChildAt(0);
        if (childAt2 != null) {
            i3 = childAt2.getLeft();
        }
        fillListLeft(i3, i2);
    }

    private void fillListLeft(int i2, int i3) {
        int i4;
        while (i2 + i3 > 0 && (i4 = this.mLeftViewIndex) >= 0) {
            View view = this.mAdapter.getView(i4, this.mRemovedViewQueue.poll(), this);
            addAndMeasureChild(view, 0);
            i2 -= view.getMeasuredWidth();
            this.mLeftViewIndex--;
            this.mDisplayOffset -= view.getMeasuredWidth();
        }
    }

    private void fillListRight(int i2, int i3) {
        while (i2 + i3 < getWidth() && this.mRightViewIndex < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.mRightViewIndex, this.mRemovedViewQueue.poll(), this);
            addAndMeasureChild(view, -1);
            i2 += view.getMeasuredWidth();
            if (this.mRightViewIndex == this.mAdapter.getCount() - 1) {
                this.mMaxX = (this.mCurrentX + i2) - getWidth();
            }
            if (this.mMaxX < 0) {
                this.mMaxX = 0;
            }
            this.mRightViewIndex++;
        }
    }

    private synchronized void initView() {
        this.mLeftViewIndex = -1;
        this.mRightViewIndex = 0;
        this.mDisplayOffset = 0;
        this.mCurrentX = 0;
        this.mNextX = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.mGesture = new GestureDetector(getContext(), this.mOnGesture);
    }

    private void positionItems(int i2) {
        if (getChildCount() > 0) {
            int i3 = this.mDisplayOffset + i2;
            this.mDisplayOffset = i3;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i3, 0, i3 + measuredWidth, childAt.getMeasuredHeight());
                i3 += measuredWidth + childAt.getPaddingRight();
            }
        }
    }

    private void removeNonVisibleItems(int i2) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i2 <= 0) {
            this.mDisplayOffset += childAt.getMeasuredWidth();
            this.mRemovedViewQueue.offer(childAt);
            removeViewInLayout(childAt);
            this.mLeftViewIndex++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i2 >= getWidth()) {
            this.mRemovedViewQueue.offer(childAt2);
            removeViewInLayout(childAt2);
            this.mRightViewIndex--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            if (Math.abs(x - this.mLastX) < Math.abs(y - this.mLastY)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        this.mLastX = x;
        this.mLastY = y;
        return this.mGesture.onTouchEvent(motionEvent) | super.dispatchTouchEvent(motionEvent);
    }

    public View getSelectedView() {
        return null;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.mScroller.forceFinished(true);
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.mNextX, 0, (int) (-f), 0, 0, this.mMaxX, 0, 0);
        }
        requestLayout();
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return this.mGesture.onTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        /*
            r0 = this;
            monitor-enter(r0)
            super.onLayout(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x006a }
            android.widget.ListAdapter r1 = r0.mAdapter     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x000a
            monitor-exit(r0)
            return
        L_0x000a:
            boolean r1 = r0.mDataChanged     // Catch:{ all -> 0x006a }
            r2 = 0
            if (r1 == 0) goto L_0x001b
            int r1 = r0.mCurrentX     // Catch:{ all -> 0x006a }
            r0.initView()     // Catch:{ all -> 0x006a }
            r0.removeAllViewsInLayout()     // Catch:{ all -> 0x006a }
            r0.mNextX = r1     // Catch:{ all -> 0x006a }
            r0.mDataChanged = r2     // Catch:{ all -> 0x006a }
        L_0x001b:
            android.widget.Scroller r1 = r0.mScroller     // Catch:{ all -> 0x006a }
            boolean r1 = r1.computeScrollOffset()     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x002b
            android.widget.Scroller r1 = r0.mScroller     // Catch:{ all -> 0x006a }
            int r1 = r1.getCurrX()     // Catch:{ all -> 0x006a }
            r0.mNextX = r1     // Catch:{ all -> 0x006a }
        L_0x002b:
            int r1 = r0.mNextX     // Catch:{ all -> 0x006a }
            r3 = 1
            if (r1 > 0) goto L_0x0037
            r0.mNextX = r2     // Catch:{ all -> 0x006a }
            android.widget.Scroller r1 = r0.mScroller     // Catch:{ all -> 0x006a }
            r1.forceFinished(r3)     // Catch:{ all -> 0x006a }
        L_0x0037:
            int r1 = r0.mNextX     // Catch:{ all -> 0x006a }
            int r2 = r0.mMaxX     // Catch:{ all -> 0x006a }
            if (r1 < r2) goto L_0x0046
            int r1 = r0.mMaxX     // Catch:{ all -> 0x006a }
            r0.mNextX = r1     // Catch:{ all -> 0x006a }
            android.widget.Scroller r1 = r0.mScroller     // Catch:{ all -> 0x006a }
            r1.forceFinished(r3)     // Catch:{ all -> 0x006a }
        L_0x0046:
            int r1 = r0.mCurrentX     // Catch:{ all -> 0x006a }
            int r2 = r0.mNextX     // Catch:{ all -> 0x006a }
            int r1 = r1 - r2
            r0.removeNonVisibleItems(r1)     // Catch:{ all -> 0x006a }
            r0.fillList(r1)     // Catch:{ all -> 0x006a }
            r0.positionItems(r1)     // Catch:{ all -> 0x006a }
            int r1 = r0.mNextX     // Catch:{ all -> 0x006a }
            r0.mCurrentX = r1     // Catch:{ all -> 0x006a }
            android.widget.Scroller r1 = r0.mScroller     // Catch:{ all -> 0x006a }
            boolean r1 = r1.isFinished()     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x0068
            com.tera.scan.ui.widget.category.HorizontalListView$ad r1 = new com.tera.scan.ui.widget.category.HorizontalListView$ad     // Catch:{ all -> 0x006a }
            r1.<init>()     // Catch:{ all -> 0x006a }
            r0.post(r1)     // Catch:{ all -> 0x006a }
        L_0x0068:
            monitor-exit(r0)
            return
        L_0x006a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.widget.category.HorizontalListView.onLayout(boolean, int, int, int, int):void");
    }

    public synchronized void scrollTo(int i2) {
        this.mScroller.startScroll(this.mNextX, 0, i2 - this.mNextX, 0);
        requestLayout();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClicked = onItemClickListener;
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClicked = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelected = onItemSelectedListener;
    }

    public void setSelection(int i2) {
    }

    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.mDataObserver);
        }
        this.mAdapter = listAdapter;
        listAdapter.registerDataSetObserver(this.mDataObserver);
        reset();
    }
}
