package com.baidu.searchbox.feed.flow.ui;

import android.view.View;
import com.baidu.searchbox.feed.flow.util.ViewVisitor;
import com.baidu.texas.context.Ability;
import java.util.List;

public interface LayoutManageAbility extends Ability {
    public static final int NO_POSITION = -1;
    public static final int POSITION_FIRST_VISIBLE = -1001;
    public static final int POSITION_LAST_VISIBLE = -1002;
    public static final int SPECIAL_POSITION_BEGIN = -1000;
    public static final int TYPE_FIRST_COMPLETELY_VISIBLE = 3;
    public static final int TYPE_FIRST_COMPLETELY_VISIBLE_GRID = 9;
    public static final int TYPE_FIRST_TITLE_COMPLETELY_VISIBLE = 5;
    public static final int TYPE_FIRST_VISIBLE_GRID = 7;
    public static final int TYPE_FRIST_VISIBLE = 1;
    public static final int TYPE_LAST_COMPLETELY_VISIBLE = 4;
    public static final int TYPE_LAST_COMPLETELY_VISIBLE_GRID = 10;
    public static final int TYPE_LAST_TITLE_COMPLETELY_VISIBLE = 6;
    public static final int TYPE_LAST_VISIBLE = 2;
    public static final int TYPE_LAST_VISIBLE_GRID = 8;

    public @interface ItemVisibleType {
    }

    int findFirstVisibleItemPosition();

    int findLastShowAtLeastItemPosition(float f2);

    int findLastVisibleItemPosition();

    View findViewByPosition(int i2);

    List<View> findViewsInRange(int i2, int i3);

    int findVisibleItemPosition(int i2);

    int findVisibleItemPosition(int i2, int i3);

    int findVisiblePositionAfter(int i2);

    void fling(int i2, int i3);

    List<View> getCurrentVisibleViewList();

    List<View> getCurrentVisibleViewsBySpan(int i2);

    int getSpanIndexByPosition(int i2);

    int getSpanIndexByView(View view2);

    int getViewPosition(View view2);

    void iterateVisibleSubviews(ViewVisitor viewVisitor);

    void postScrollToPosition(int i2, long j2);

    void scrollToPosition(int i2, boolean z);

    void scrollToPositionWithOffset(int i2, int i3);

    void smoothScrollToPosition(int i2, int i3);
}
