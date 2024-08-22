package com.baidu.searchbox.generalcommunity.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.TplViewCaster;
import com.baidu.searchbox.feed.tab.interaction.IFeedAdapter;

public class FeedItemDivider extends RecyclerView.ItemDecoration {
    private IFeedAdapter mAdapter;

    public FeedItemDivider(GCommunityAdapter adapter) {
        this.mAdapter = adapter;
    }

    public void onDraw(Canvas c2, RecyclerView parent, RecyclerView.State state) {
        FeedTemplate tpl;
        FeedTemplate.FeedDividerPolicy dividerPolicy;
        RecyclerView recyclerView = parent;
        int itemCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        for (int i2 = 0; i2 < itemCount; i2++) {
            View child = recyclerView.getChildAt(i2);
            int current = recyclerView.getChildLayoutPosition(child);
            if (child != null) {
                RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
                if ((layoutManager instanceof LinearLayoutManager) && (tpl = TplViewCaster.castToTemplate(child)) != null && (dividerPolicy = tpl.getFeedDividerPolicy()) != null && dividerPolicy.shouldDividerShow((RecyclerView.Adapter) this.mAdapter, layoutManager, child, current)) {
                    doDraw(dividerPolicy, c2, child, left, right);
                }
            }
        }
    }

    public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
        FeedTemplate template;
        FeedTemplate.FeedDividerPolicy dividerPolicy;
        super.getItemOffsets(outRect, view2, parent, state);
        int current = parent.getChildLayoutPosition(view2);
        if (current != -1) {
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if ((layoutManager instanceof LinearLayoutManager) && (template = TplViewCaster.castToTemplate(view2)) != null && (dividerPolicy = template.getFeedDividerPolicy()) != null && dividerPolicy.shouldDividerShow((RecyclerView.Adapter) this.mAdapter, layoutManager, view2, current)) {
                outRect.set(0, 0, 0, dividerPolicy.getDividerWidth());
            }
        }
    }

    private void doDraw(FeedTemplate.FeedDividerPolicy dividerPolicy, Canvas c2, View child, int parentLeft, int parentRight) {
        int top = child.getBottom() + ((RecyclerView.LayoutParams) child.getLayoutParams()).bottomMargin;
        dividerPolicy.getDividerDrawable(child, top, dividerPolicy.getDividerWidth() + top, parentLeft, parentRight).draw(c2);
    }
}
