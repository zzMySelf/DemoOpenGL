package com.baidu.searchbox.feed.attention.page;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.TplViewCaster;
import com.baidu.searchbox.feed.tab.interaction.IFeedAdapter;
import com.baidu.searchbox.feed.tab.view.FeedThickDividerPolicy;

public class AttentionItemDecoration extends RecyclerView.ItemDecoration {
    protected IFeedAdapter mFeedAdapter;

    public AttentionItemDecoration(IFeedAdapter feedAdapter) {
        this.mFeedAdapter = feedAdapter;
    }

    public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
        FeedTemplate feedTemplate;
        super.getItemOffsets(outRect, view2, parent, state);
        int current = parent.getChildLayoutPosition(view2);
        if (current != -1 && (parent.getLayoutManager() instanceof LinearLayoutManager) && (feedTemplate = TplViewCaster.castToTemplate(view2)) != null) {
            if (current == 0 && feedTemplate.getFeedDividerPolicy() == null) {
                outRect.set(0, 0, 0, 0);
            } else if (current >= 0 && current <= this.mFeedAdapter.getFeedList().size() - 1) {
                outRect.set(0, 0, 0, FeedThickDividerPolicy.getDefault().getDividerWidth());
            }
        }
    }

    public void onDraw(Canvas c2, RecyclerView parent, RecyclerView.State state) {
        FeedTemplate feedTemplate;
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        for (int i2 = 0; i2 < this.mFeedAdapter.getFeedList().size(); i2++) {
            View child = parent.getChildAt(i2);
            if (child != null && (((feedTemplate = TplViewCaster.castToTemplate(child)) == null || feedTemplate.getFeedDividerPolicy() != null) && (parent.getLayoutManager() instanceof LinearLayoutManager))) {
                doDraw(FeedThickDividerPolicy.getDefault(), c2, child, left, right);
            }
        }
    }

    private void doDraw(FeedTemplate.FeedDividerPolicy dividerPolicy, Canvas c2, View child, int parentLeft, int parentRight) {
        int top = child.getBottom() + ((RecyclerView.LayoutParams) child.getLayoutParams()).bottomMargin;
        dividerPolicy.getDividerDrawable(child, top, dividerPolicy.getDividerWidth() + top, parentLeft, parentRight).draw(c2);
    }
}
