package com.tera.scan.component.base.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import fe.mmm.qw.i.qw;

public class ListViewEx extends ListView {
    public static final String TAG = "ListViewEx";

    public ListViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void beginRefresh() {
    }

    public void clearChoices() {
        super.clearChoices();
    }

    public void clearCurrentItemChecked(int i2) {
        if (getChoiceMode() == 2 && getAdapter() != null) {
            getCheckedItemPositions().put(i2, false);
        }
        requestLayout();
    }

    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Exception e) {
            qw.th(TAG, e.toString(), e);
        }
    }

    public long[] getCheckedItemIds() {
        return super.getCheckedItemIds();
    }

    public int getChoiceMode() {
        return super.getChoiceMode();
    }

    public void onRefreshComplete() {
    }

    public void onRefreshComplete(CharSequence charSequence) {
    }

    public void setAllItemChecked(boolean z) {
        ListAdapter adapter;
        if (getChoiceMode() == 2 && (adapter = getAdapter()) != null) {
            SparseBooleanArray checkedItemPositions = getCheckedItemPositions();
            int count = adapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                if (adapter.isEnabled(i2)) {
                    checkedItemPositions.put(i2, z);
                }
            }
        }
        requestLayout();
    }

    public void setChoiceMode(int i2) {
        clearChoices();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof CheckableLayout) {
                ((CheckableLayout) childAt).setChoiceMode(i2);
            }
        }
        super.setChoiceMode(i2);
    }

    public void setCurrentItemChecked(int i2) {
        if (getChoiceMode() == 2 && getAdapter() != null) {
            getCheckedItemPositions().put(i2, true);
        }
        requestLayout();
    }

    public ListViewEx(Context context) {
        super(context);
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }

    public ListViewEx(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setChoiceMode(0);
    }
}
