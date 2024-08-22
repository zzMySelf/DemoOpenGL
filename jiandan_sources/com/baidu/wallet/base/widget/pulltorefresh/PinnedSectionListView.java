package com.baidu.wallet.base.widget.pulltorefresh;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

public class PinnedSectionListView extends ListView {
    public AbsListView.OnScrollListener a;
    public a b;
    public a c;
    public int d;
    public final Rect e = new Rect();
    public final PointF f = new PointF();
    public int g;
    public View h;

    /* renamed from: i  reason: collision with root package name */
    public MotionEvent f3539i;
    public int j;
    public final AbsListView.OnScrollListener k = new AbsListView.OnScrollListener() {
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.a;
            if (onScrollListener != null) {
                onScrollListener.onScroll(absListView, i2, i3, i4);
            }
            ListAdapter adapter = PinnedSectionListView.this.getAdapter();
            if (adapter != null && i3 != 0) {
                if (!PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i2))) {
                    int b = PinnedSectionListView.this.b(i2);
                    if (b > -1) {
                        PinnedSectionListView.this.a(b, i2, i3);
                    } else {
                        PinnedSectionListView.this.a();
                    }
                } else if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                    PinnedSectionListView.this.a();
                } else {
                    PinnedSectionListView.this.a(i2, i2, i3);
                }
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.a;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i2);
            }
        }
    };
    public final DataSetObserver l = new DataSetObserver() {
        public void onChanged() {
            PinnedSectionListView.this.b();
        }

        public void onInvalidated() {
            PinnedSectionListView.this.b();
        }
    };

    public interface PinnedSectionListAdapter extends ListAdapter {
        boolean isItemViewTypePinned(int i2);
    }

    public static class a {
        public View a;
        public int b;
        public long c;
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    private void c() {
        setOnScrollListener(this.k);
        this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void d() {
        this.h = null;
        MotionEvent motionEvent = this.f3539i;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f3539i = null;
        }
    }

    private boolean e() {
        AdapterView.OnItemClickListener onItemClickListener;
        if (this.c == null || (onItemClickListener = getOnItemClickListener()) == null || !getAdapter().isEnabled(this.c.b)) {
            return false;
        }
        View view = this.c.a;
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        a aVar = this.c;
        onItemClickListener.onItemClick(this, view, aVar.b, aVar.c);
        return true;
    }

    public static boolean isItemViewTypePinned(ListAdapter listAdapter, int i2) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            listAdapter = ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return ((PinnedSectionListAdapter) listAdapter).isItemViewTypePinned(i2);
    }

    public void a(int i2) {
        a aVar = this.b;
        this.b = null;
        if (aVar == null) {
            aVar = new a();
        }
        View view = getAdapter().getView(i2, aVar.a, this);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
            view.setLayoutParams(layoutParams);
        }
        int mode = View.MeasureSpec.getMode(layoutParams.height);
        int size = View.MeasureSpec.getSize(layoutParams.height);
        if (mode == 0) {
            mode = 1073741824;
        }
        int height = (getHeight() - getListPaddingTop()) - getListPaddingBottom();
        if (size > height) {
            size = height;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getWidth() - getListPaddingLeft()) - getListPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(size, mode));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        this.d = 0;
        aVar.a = view;
        aVar.b = i2;
        aVar.c = getAdapter().getItemId(i2);
        this.c = aVar;
    }

    public int b(int i2) {
        ListAdapter adapter = getAdapter();
        if (i2 >= adapter.getCount()) {
            return -1;
        }
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            int positionForSection = sectionIndexer.getPositionForSection(sectionIndexer.getSectionForPosition(i2));
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(positionForSection))) {
                return positionForSection;
            }
        }
        while (i2 >= 0) {
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(i2))) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.c != null) {
            int listPaddingLeft = getListPaddingLeft();
            int listPaddingTop = getListPaddingTop();
            View view = this.c.a;
            canvas.save();
            canvas.clipRect(listPaddingLeft, listPaddingTop, view.getWidth() + listPaddingLeft, view.getHeight() + listPaddingTop);
            canvas.translate((float) listPaddingLeft, (float) (listPaddingTop + this.d));
            drawChild(canvas, this.c.a, getDrawingTime());
            canvas.restore();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0 && this.h == null && (aVar = this.c) != null && a(aVar.a, x, y)) {
            this.h = this.c.a;
            PointF pointF = this.f;
            pointF.x = x;
            pointF.y = y;
            this.f3539i = MotionEvent.obtain(motionEvent);
        }
        View view = this.h;
        if (view == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (a(view, x, y)) {
            this.h.dispatchTouchEvent(motionEvent);
        }
        if (action == 1) {
            super.dispatchTouchEvent(motionEvent);
            e();
            d();
        } else if (action == 3) {
            d();
        } else if (action == 2 && Math.abs(y - this.f.y) > ((float) this.g)) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            this.h.dispatchTouchEvent(obtain);
            obtain.recycle();
            super.dispatchTouchEvent(this.f3539i);
            super.dispatchTouchEvent(motionEvent);
            d();
        }
        return true;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.c != null && ((i4 - i2) - getPaddingLeft()) - getPaddingRight() != this.c.a.getWidth()) {
            b();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        post(new Runnable() {
            public void run() {
                PinnedSectionListView.this.b();
            }
        });
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        if (onScrollListener == this.k) {
            super.setOnScrollListener(onScrollListener);
        } else {
            this.a = onScrollListener;
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null && (listAdapter instanceof PinnedSectionListAdapter) && listAdapter.getViewTypeCount() >= 2) {
            ListAdapter adapter = getAdapter();
            if (adapter != null) {
                adapter.unregisterDataSetObserver(this.l);
            }
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(this.l);
            }
            if (adapter != listAdapter) {
                a();
            }
            super.setAdapter(listAdapter);
        }
    }

    public PinnedSectionListView(Context context) {
        super(context);
        c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = getFirstVisiblePosition();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r3 = this;
            r3.a()
            android.widget.ListAdapter r0 = r3.getAdapter()
            if (r0 == 0) goto L_0x0023
            int r0 = r0.getCount()
            if (r0 <= 0) goto L_0x0023
            int r0 = r3.getFirstVisiblePosition()
            int r1 = r3.b(r0)
            r2 = -1
            if (r1 != r2) goto L_0x001b
            return
        L_0x001b:
            int r2 = r3.getLastVisiblePosition()
            int r2 = r2 - r0
            r3.a((int) r1, (int) r0, (int) r2)
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.b():void");
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    public void a() {
        a aVar = this.c;
        if (aVar != null) {
            this.b = aVar;
            this.c = null;
        }
    }

    public void a(int i2, int i3, int i4) {
        if (i4 < 2) {
            a();
            return;
        }
        a aVar = this.c;
        if (!(aVar == null || aVar.b == i2)) {
            a();
        }
        if (this.c == null) {
            a(i2);
        }
        int i5 = i2 + 1;
        if (i5 < getCount()) {
            int a2 = a(i5, i4 - (i5 - i3));
            if (a2 > -1) {
                int top = getChildAt(a2 - i3).getTop() - (this.c.a.getBottom() + getPaddingTop());
                this.j = top;
                if (top < 0) {
                    this.d = top;
                } else {
                    this.d = 0;
                }
            } else {
                this.d = 0;
                this.j = Integer.MAX_VALUE;
            }
        }
    }

    public int a(int i2, int i3) {
        ListAdapter adapter = getAdapter();
        int count = adapter.getCount();
        if (getLastVisiblePosition() >= count) {
            return -1;
        }
        if (i2 + i3 >= count) {
            i3 = count - i2;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 + i4;
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(i5))) {
                return i5;
            }
        }
        return -1;
    }

    private boolean a(View view, float f2, float f3) {
        view.getHitRect(this.e);
        Rect rect = this.e;
        int i2 = rect.top;
        int i3 = this.d;
        rect.top = i2 + i3;
        rect.bottom += i3 + getPaddingTop();
        this.e.left += getPaddingLeft();
        this.e.right -= getPaddingRight();
        return this.e.contains((int) f2, (int) f3);
    }
}
