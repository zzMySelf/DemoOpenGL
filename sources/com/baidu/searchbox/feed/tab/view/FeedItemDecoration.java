package com.baidu.searchbox.feed.tab.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.TplViewCaster;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.tab.interaction.IFeedAdapter;
import com.baidu.searchbox.feed.tab.model.TabController;
import java.util.List;
import javax.annotation.Nullable;

public class FeedItemDecoration extends RecyclerView.ItemDecoration {
    protected IFeedAdapter mFeedAdapter;

    public FeedItemDecoration(IFeedAdapter feedAdapter) {
        this.mFeedAdapter = feedAdapter;
    }

    public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
        FeedTemplate feedTemplate;
        super.getItemOffsets(outRect, view2, parent, state);
        int current = parent.getChildLayoutPosition(view2);
        if (current != -1) {
            FeedTemplate.FeedDividerPolicy nextForcePolicy = getNextTplForcePolicy(current + 1, parent);
            if (nextForcePolicy != null) {
                outRect.set(0, 0, 0, nextForcePolicy.getDividerWidth());
                return;
            }
            boolean shield = FeedAbtestManager.isFluencyOptOpen() && TextUtils.equals("1", TabController.INSTANCE.getCurrentChannelId());
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            RecyclerView.LayoutManager layoutManager2 = layoutManager;
            if ((layoutManager instanceof LinearLayoutManager) && (feedTemplate = TplViewCaster.castToTemplate(view2)) != null) {
                if (!shield) {
                    FeedTemplate.FeedDividerPolicy feedDividerPolicy = FeedThickDividerPolicy.getDefault();
                    FeedTemplate.FeedDividerPolicy dividerPolicy = feedDividerPolicy;
                    if (feedDividerPolicy.shouldDividerShow((RecyclerView.Adapter) this.mFeedAdapter, layoutManager2, view2, current)) {
                        outRect.set(0, 0, 0, dividerPolicy.getDividerWidth());
                        return;
                    }
                }
                FeedTemplate.FeedDividerPolicy dividerPolicy2 = feedTemplate.getFeedDividerPolicy();
                if ((dividerPolicy2 instanceof FeedThinDividerPolicy) && dividerPolicy2.shouldDividerShow((RecyclerView.Adapter) this.mFeedAdapter, layoutManager2, view2, current)) {
                    outRect.set(0, 0, 0, dividerPolicy2.getDividerWidth());
                }
            }
        }
    }

    public void onDraw(Canvas c2, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = parent;
        int itemCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int i2 = 0;
        while (i2 < itemCount) {
            View child = recyclerView.getChildAt(i2);
            int current = recyclerView.getChildLayoutPosition(child);
            if (child != null) {
                FeedTemplate.FeedDividerPolicy nextForcePolicy = getNextTplForcePolicy(current + 1, recyclerView);
                if (nextForcePolicy != null) {
                    doDraw(nextForcePolicy, c2, child, left, right);
                } else {
                    boolean shield = FeedAbtestManager.isFluencyOptOpen() && TextUtils.equals("1", TabController.INSTANCE.getCurrentChannelId());
                    RecyclerView.LayoutManager layoutManager2 = parent.getLayoutManager();
                    RecyclerView.LayoutManager layoutManager3 = layoutManager2;
                    if (layoutManager2 instanceof LinearLayoutManager) {
                        if (!shield) {
                            FeedTemplate.FeedDividerPolicy feedDividerPolicy = FeedThickDividerPolicy.getDefault();
                            FeedTemplate.FeedDividerPolicy dividerPolicy = feedDividerPolicy;
                            if (feedDividerPolicy.shouldDividerShow((RecyclerView.Adapter) this.mFeedAdapter, layoutManager3, child, current)) {
                                RecyclerView.LayoutManager layoutManager4 = layoutManager3;
                                doDraw(dividerPolicy, c2, child, left, right);
                            } else {
                                layoutManager = layoutManager3;
                            }
                        } else {
                            layoutManager = layoutManager3;
                        }
                        FeedTemplate tpl = TplViewCaster.castToTemplate(child);
                        if (tpl != null) {
                            FeedTemplate.FeedDividerPolicy dividerPolicy2 = tpl.getFeedDividerPolicy();
                            if (!(dividerPolicy2 instanceof FeedThinDividerPolicy)) {
                            } else if (dividerPolicy2.shouldDividerShow((RecyclerView.Adapter) this.mFeedAdapter, layoutManager, child, current)) {
                                FeedTemplate.FeedDividerPolicy feedDividerPolicy2 = dividerPolicy2;
                                doDraw(dividerPolicy2, c2, child, left, right);
                            }
                        }
                    }
                }
            }
            i2++;
            recyclerView = parent;
        }
    }

    @Nullable
    private FeedTemplate.FeedDividerPolicy getNextTplForcePolicy(int nextPos, RecyclerView parent) {
        View nextTplView = parent.getChildAt(nextPos);
        List<FeedBaseModel> modelList = this.mFeedAdapter.getFeedList();
        if (modelList == null || modelList.size() <= nextPos) {
            return null;
        }
        FeedBaseModel nextModel = modelList.get(nextPos);
        if (nextTplView == null || nextModel == null || nextModel.data == null) {
            return null;
        }
        FeedItemData data = nextModel.data;
        if (data.isNeedShowTopThickDivider()) {
            return FeedThickDividerPolicy.getDefault();
        }
        if (data.isNeedShowTopThinDivider()) {
            return FeedThinDividerPolicy.getDefault();
        }
        return null;
    }

    private void doDraw(FeedTemplate.FeedDividerPolicy dividerPolicy, Canvas c2, View child, int parentLeft, int parentRight) {
        int top = child.getBottom() + ((RecyclerView.LayoutParams) child.getLayoutParams()).bottomMargin;
        dividerPolicy.getDividerDrawable(child, top, dividerPolicy.getDividerWidth() + top, parentLeft, parentRight).draw(c2);
    }

    public void onFeedNightModeChanged(boolean isNightMode) {
        FeedThickDividerPolicy.getDefault().onFeedNightModeChanged(isNightMode);
        FeedThinDividerPolicy.getDefault().onFeedNightModeChanged(isNightMode);
    }
}
