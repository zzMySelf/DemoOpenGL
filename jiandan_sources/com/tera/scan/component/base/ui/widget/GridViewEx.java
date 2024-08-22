package com.tera.scan.component.base.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.HashSet;

public class GridViewEx extends GridView {
    public static final int CHOICE_MODE_MULTIPLE = 2;
    public static final int CHOICE_MODE_NONE = 0;
    public static final int CHOICE_MODE_SINGLE = 1;
    public static final String TAG = "GridViewEx";
    public SparseBooleanArray mCheckStates;
    public HashSet<Integer> mCheckedIdStates;
    public int mChoiceMode;

    public GridViewEx(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void createState() {
        if (this.mCheckStates == null) {
            this.mCheckStates = new SparseBooleanArray();
        }
        if (this.mCheckedIdStates == null) {
            this.mCheckedIdStates = new HashSet<>();
        }
    }

    public void clearChoices() {
        ListAdapter adapter = getAdapter();
        if (!(adapter == null || this.mCheckStates == null)) {
            int count = adapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                this.mCheckStates.put(i2, false);
                View childAt = getChildAt(i2);
                if (childAt instanceof ICheckableItem) {
                    ((ICheckableItem) childAt).setChecked(false);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = this.mCheckStates;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        HashSet<Integer> hashSet = this.mCheckedIdStates;
        if (hashSet != null) {
            hashSet.clear();
        }
    }

    public void clearCurrentItemChecked(int i2) {
        SparseBooleanArray sparseBooleanArray;
        if (!(this.mChoiceMode != 2 || getAdapter() == null || (sparseBooleanArray = this.mCheckStates) == null)) {
            sparseBooleanArray.put(i2, false);
            this.mCheckedIdStates.remove(Integer.valueOf(i2));
            View childAt = getChildAt(i2);
            if (childAt instanceof ICheckableItem) {
                ((ICheckableItem) childAt).setChecked(false);
            }
        }
        requestLayout();
    }

    public SparseBooleanArray getCheckedItemPositions() {
        return this.mCheckStates;
    }

    public int getChoiceMode() {
        return this.mChoiceMode;
    }

    public boolean hasCheckId(int i2) {
        HashSet<Integer> hashSet = this.mCheckedIdStates;
        if (hashSet != null) {
            return hashSet.contains(Integer.valueOf(i2));
        }
        return false;
    }

    public boolean isAllItemChecked() {
        return getAdapter().getCount() == this.mCheckedIdStates.size();
    }

    public boolean performItemClick(View view, int i2, long j) {
        SparseBooleanArray sparseBooleanArray;
        if (!(this.mChoiceMode == 0 || (sparseBooleanArray = this.mCheckStates) == null)) {
            boolean z = !sparseBooleanArray.get(i2, false);
            this.mCheckStates.put(i2, z);
            if (view instanceof ICheckableItem) {
                ((ICheckableItem) view).toggle();
            }
            if (z) {
                this.mCheckedIdStates.add(Integer.valueOf(i2));
            } else {
                this.mCheckedIdStates.remove(Integer.valueOf(i2));
            }
        }
        return super.performItemClick(view, i2, j);
    }

    public void setAllItemChecked(boolean z) {
        HashSet<Integer> hashSet = this.mCheckedIdStates;
        if (hashSet != null) {
            hashSet.clear();
        }
        if (this.mChoiceMode != 0) {
            ListAdapter adapter = getAdapter();
            if (!(adapter == null || this.mCheckStates == null)) {
                int count = adapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    this.mCheckStates.put(i2, z);
                    HashSet<Integer> hashSet2 = this.mCheckedIdStates;
                    if (hashSet2 != null) {
                        if (z) {
                            hashSet2.add(Integer.valueOf(i2));
                        } else {
                            hashSet2.remove(Integer.valueOf(i2));
                        }
                    }
                    View childAt = getChildAt(i2);
                    if (childAt instanceof ICheckableItem) {
                        ((ICheckableItem) childAt).setChecked(z);
                    }
                }
            }
            requestLayout();
        }
    }

    public void setChoiceMode(int i2) {
        createState();
        clearChoices();
        this.mChoiceMode = i2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof ICheckableItem) {
                ((ICheckableItem) childAt).setChoiceMode(i2);
            }
        }
    }

    public void setCurrentItemChecked(int i2) {
        SparseBooleanArray sparseBooleanArray;
        if (!(this.mChoiceMode != 2 || getAdapter() == null || (sparseBooleanArray = this.mCheckStates) == null)) {
            sparseBooleanArray.put(i2, true);
            this.mCheckedIdStates.add(Integer.valueOf(i2));
            View childAt = getChildAt(i2);
            if (childAt instanceof ICheckableItem) {
                ((ICheckableItem) childAt).setChecked(true);
            }
        }
        requestLayout();
    }

    public GridViewEx(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mChoiceMode = 0;
        createState();
    }
}
