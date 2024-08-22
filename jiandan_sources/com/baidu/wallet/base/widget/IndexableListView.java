package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;

public class IndexableListView extends ListView {
    public boolean a = false;
    public IndexScroller b = null;
    public GestureDetector c = null;

    public IndexableListView(Context context) {
        super(context);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        IndexScroller indexScroller = this.b;
        if (indexScroller != null) {
            indexScroller.draw(canvas);
        }
    }

    public boolean isFastScrollEnabled() {
        return this.a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.b.contains(motionEvent.getX(), motionEvent.getY())) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        IndexScroller indexScroller = this.b;
        if (indexScroller != null) {
            indexScroller.onSizeChanged(i2, i3, i4, i5);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IndexScroller indexScroller = this.b;
        if (indexScroller != null && indexScroller.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.c == null) {
            this.c = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (IndexableListView.this.b != null) {
                        IndexableListView.this.b.show();
                    }
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
            });
        }
        this.c.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void setFastScrollEnabled(boolean z) {
        this.a = z;
        if (!z) {
            IndexScroller indexScroller = this.b;
            if (indexScroller != null) {
                indexScroller.hide();
                this.b = null;
            }
        } else if (this.b == null) {
            this.b = new IndexScroller(getContext(), this);
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        IndexScroller indexScroller = this.b;
        if (indexScroller != null) {
            indexScroller.setAdapter(listAdapter);
        }
    }

    public IndexableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IndexableListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
