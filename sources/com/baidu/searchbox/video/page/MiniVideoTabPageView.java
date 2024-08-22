package com.baidu.searchbox.video.page;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.behavior.UserStickinessCollector;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedRuntimeStatus;
import com.baidu.searchbox.feed.template.FeedTabMiniVideoView;
import com.baidu.searchbox.feed.widget.feedflow.VideoStaggeredGridLayoutManager;
import com.baidu.searchbox.home.feed.videodetail.adapter.MiniVideoStaggeredGridLayoutManager;
import com.baidu.searchbox.launch.SmartLaunchController;
import com.baidu.searchbox.video.controller.MiniVideoDataManager;
import com.baidu.searchbox.video.runtime.VideoRuntime;
import java.util.Iterator;

public class MiniVideoTabPageView extends VideoBasePageView implements MiniVideoDataManager.SyncPositionListener {
    private static final String MINI_VIDEO_MAIN_TAB_ID = "faxian";
    public static final String PARAMS_FROM_KEY = "from";
    private String mFrom;

    public MiniVideoTabPageView(int type) {
        super(type);
    }

    /* access modifiers changed from: protected */
    public String getName() {
        return "MiniVideoTabPageView";
    }

    public boolean init(Activity activity, String bundleId, String componentName, Bundle extraInfo) {
        if (SmartLaunchController.isSmartLaunchEnabled()) {
            UserStickinessCollector.getInstance().onBusinessCalled("miniVideo");
        }
        if (extraInfo != null) {
            this.mFrom = extraInfo.getString("from");
        }
        return super.init(activity, bundleId, componentName, extraInfo);
    }

    public RecyclerView.LayoutManager createLayoutManager() {
        VideoStaggeredGridLayoutManager recyclerLayoutManager = new MiniVideoStaggeredGridLayoutManager(2, 1);
        recyclerLayoutManager.setGapStrategy(0);
        return recyclerLayoutManager;
    }

    public View onCreateView(Activity context, Bundle info) {
        View view2 = super.onCreateView(context, info);
        if (this.mDataManager != null && (this.mDataManager instanceof MiniVideoDataManager)) {
            ((MiniVideoDataManager) this.mDataManager).setSyncPositionListener(this);
            ((MiniVideoDataManager) this.mDataManager).setFrom(this.mFrom);
        }
        return view2;
    }

    public void onViewResume() {
        super.onViewResume();
        if (!this.mCanFeedDisplayReport) {
            this.mCanFeedDisplayReport = true;
            changeCurrentFeedModelDisplayed();
        }
    }

    public void onViewPause() {
        this.mCanFeedDisplayReport = false;
        super.onViewPause();
    }

    public void onViewDestroy() {
        super.onViewDestroy();
        if (this.mDataManager != null && (this.mDataManager instanceof MiniVideoDataManager)) {
            ((MiniVideoDataManager) this.mDataManager).setSyncPositionListener((MiniVideoDataManager.SyncPositionListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public boolean foldableDevScreenChange() {
        if (this.mRecyclerView == null) {
            return true;
        }
        if (this.mRecyclerLayoutManager instanceof VideoStaggeredGridLayoutManager) {
            this.mCurrentPosition = ((VideoStaggeredGridLayoutManager) this.mRecyclerLayoutManager).findFirstVisibleItemPosition();
            View itemView = ((VideoStaggeredGridLayoutManager) this.mRecyclerLayoutManager).findViewByPosition(this.mCurrentPosition);
            if (itemView != null) {
                this.mCurrentPositionTopOffset = itemView.getTop();
            }
        }
        this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager) null);
        this.mRecyclerView.setAdapter((RecyclerView.Adapter) null);
        this.mRecyclerView.setLayoutManager(this.mRecyclerLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
        if (this.mCurrentPosition == -1 || this.mCurrentPositionTopOffset == -1 || !(this.mRecyclerLayoutManager instanceof VideoStaggeredGridLayoutManager)) {
            return true;
        }
        ((VideoStaggeredGridLayoutManager) this.mRecyclerLayoutManager).scrollToPositionWithOffset(this.mCurrentPosition, this.mCurrentPositionTopOffset);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean shouldAutoPlay() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean shouldShowTimeLine() {
        return false;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.ItemDecoration createItemDecoration() {
        return new SpacesItemDecoration(DeviceUtils.ScreenInfo.dp2px(this.mContext, 4.0f));
    }

    public void notifySyncPosition(int position) {
        if (position <= -1) {
            return;
        }
        if (!(this.mRecyclerView.getLayoutManager() instanceof VideoStaggeredGridLayoutManager) || !VideoRuntime.getVideoContext().playedVideoToTopSwitch()) {
            this.mRecyclerView.smoothScrollToPosition(position);
        } else {
            ((VideoStaggeredGridLayoutManager) this.mRecyclerView.getLayoutManager()).scrollToTop(this.mRecyclerView, position);
        }
    }

    public void notifyDataSetChanged() {
        this.mAdapter.notifyDataChanged();
    }

    private void changeCurrentFeedModelDisplayed() {
        int firstPos = findFirstVisibleItemPosition();
        int lastPos = findLastVisibleItemPosition();
        if (this.mDataManager != null && firstPos > -1 && lastPos > -1) {
            for (int i2 = findFirstVisibleItemPosition(); i2 <= findLastVisibleItemPosition(); i2++) {
                FeedBaseModel model = this.mDataManager.getFeedBaseMode(i2);
                if (model != null) {
                    FeedRuntimeStatus runtimeStatus = model.runtimeStatus;
                    if (!runtimeStatus.hasDisplayed) {
                        noticeAdDisplay(model);
                        if (!runtimeStatus.hasDisplayed && !runtimeStatus.hasRecorded) {
                            runtimeStatus.reportInfo.displayTime = System.currentTimeMillis();
                        }
                        runtimeStatus.hasDisplayed = true;
                    }
                }
            }
        }
    }

    static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private final int space;

        public SpacesItemDecoration(int space2) {
            this.space = space2;
        }

        public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
            outRect.bottom = this.space;
            outRect.top = this.space;
            if (view2.getLayoutParams() != null && (view2.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams)) {
                int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) view2.getLayoutParams()).getSpanIndex();
                if (spanIndex == 0) {
                    outRect.right = this.space;
                    outRect.top = 0;
                } else if (spanIndex == 1) {
                    outRect.top = 0;
                } else {
                    outRect.left = this.space;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void loadMoreFeeds(FeedBaseModel lastFeed) {
        if (this.mFooterView != null) {
            this.mFooterView.setState(801);
            this.mFooterView.setVisibility(0);
        }
        this.mHasMoreData = true;
        this.mIsLoadingMore = true;
        this.mDataManager.loadHistoryFeedsAsync(this.mContext, lastFeed, "7", 0);
    }

    public void onFeedNightModeChange(boolean isNightMode) {
        if (this.mRecyclerView != null && this.mAdapter != null) {
            this.mRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void webpAutoPlay() {
        Rect rVLocation = getRecyclerViewLocation(this.mRecyclerView);
        Iterator<View> it = getCurrentVisibleViewList().iterator();
        while (it.hasNext()) {
            View child = it.next();
            if (child instanceof FeedTabMiniVideoView) {
                ((FeedTabMiniVideoView) child).autoPlayWebP(rVLocation);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void reStartWebP() {
        Iterator<View> it = getCurrentVisibleViewList().iterator();
        while (it.hasNext()) {
            View child = it.next();
            if (child instanceof FeedTabMiniVideoView) {
                ((FeedTabMiniVideoView) child).startPlay();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void stopWebP() {
        Iterator<View> it = getCurrentVisibleViewList().iterator();
        while (it.hasNext()) {
            View child = it.next();
            if (child instanceof FeedTabMiniVideoView) {
                ((FeedTabMiniVideoView) child).stopPlay();
            }
        }
    }

    public MiniVideoDataManager getDataManager() {
        if (this.mDataManager == null || !(this.mDataManager instanceof MiniVideoDataManager)) {
            return null;
        }
        return (MiniVideoDataManager) this.mDataManager;
    }

    /* access modifiers changed from: protected */
    public void notifyData(int moreDataSize) {
        this.mAdapter.notifyItemRangeInserted(this.mLastPosition, moreDataSize);
    }

    /* access modifiers changed from: protected */
    public boolean isMainChannel() {
        return this.mDataManager != null && TextUtils.equals(this.mDataManager.getTabId(), "faxian");
    }
}
