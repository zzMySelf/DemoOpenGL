package com.baidu.searchbox.search.hottopic.utils;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.config.FontSizeHelper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000¨\u0006\n"}, d2 = {"getScaledSize", "", "size", "", "updateSize", "", "view", "Landroid/view/View;", "width", "height", "lib_hot_topic_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FontSizeUtils.kt */
public final class FontSizeUtilsKt {
    public static final void updateSize(View view2, int width, int height) {
        ViewGroup.LayoutParams layoutParms = view2 != null ? view2.getLayoutParams() : null;
        if (layoutParms != null) {
            layoutParms.width = width;
        }
        if (layoutParms != null) {
            layoutParms.height = height;
        }
        if (layoutParms != null && view2 != null) {
            view2.setLayoutParams(layoutParms);
        }
    }

    public static final int getScaledSize(float size) {
        return (int) FontSizeHelper.getScaledSize(0, size);
    }
}
