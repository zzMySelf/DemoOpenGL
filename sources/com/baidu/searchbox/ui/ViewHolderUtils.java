package com.baidu.searchbox.ui;

import android.util.SparseArray;
import android.view.View;

public final class ViewHolderUtils {
    private ViewHolderUtils() {
    }

    public static <T extends View> T get(View view2, int id) {
        SparseArray<View> viewHolder = (SparseArray) view2.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<>();
            view2.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView != null) {
            return childView;
        }
        View childView2 = view2.findViewById(id);
        viewHolder.put(id, childView2);
        return childView2;
    }
}
