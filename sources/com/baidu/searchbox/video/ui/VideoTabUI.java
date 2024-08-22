package com.baidu.searchbox.video.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.feed.tab.fragment.RNFeedFragment;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.home.feed.videodetail.utils.VideoDetailUbcUtils;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.fragment.VideoTabBaseFragment;
import com.baidu.searchbox.video.page.player.VideoTabMutePlayUtil;
import com.baidu.searchbox.video.page.ubc.inf.IVideoTabListOuterUbc;
import com.baidu.searchbox.video.runtime.VideoRuntime;
import com.baidu.searchbox.video.util.VideoQuoteConstants;
import com.baidu.searchbox.video.util.VideoTabSearchQueryUtil;
import com.baidu.searchbox.video.util.VideoTrafficUtils;
import com.baidu.searchbox.video.util.VideoUtils;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class VideoTabUI extends VideoTabBaseUI {
    private static final String TAG = "VideoTabUI";
    private static final String VIDEO_SEARCH_DISABLE = "0";
    private static final String VIDEO_SEARCH_ENABLE = "1";
    private boolean isSearchBoxShow = false;
    private boolean isSearchBtnShow = false;
    private boolean isViewResume = false;
    private View mSearchBox;
    private Subscription mSearchQueryHintTimer;

    public VideoTabUI(int type) {
        super(type);
    }

    /* access modifiers changed from: protected */
    public void handleRightBtn(Context context, View rightBtnArea) {
        initSearchInfo();
        if (this.isSearchBoxShow) {
            super.handleRightBtn(context, rightBtnArea);
            addTopSearchBox(context);
        } else if (this.isSearchBtnShow) {
            rightBtnArea.setVisibility(0);
            rightBtnArea.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view2) {
                    VideoUtils.onVideoStartSearch(VideoTabUI.this.getContext());
                    VideoDetailUbcUtils.doVSearchStatistic(VideoQuoteConstants.UBC_VIDEO_TAB_SEARCH_ICON);
                }
            });
        } else {
            super.handleRightBtn(context, rightBtnArea);
        }
    }

    /* access modifiers changed from: protected */
    public void addTopSearchBox(Context context) {
        Resources resources = getContext().getResources();
        this.mSearchBox = VideoRuntime.getVideoContext().getSearchBoxView(VideoRuntime.getVideoContext().buildSearchBoxViewVideo(context));
        VideoRuntime.getVideoContext().doSearchBoxViewAddLogoView(this.mSearchBox);
        VideoRuntime.getVideoContext().setSearchBoxBackground(this.mSearchBox);
        FrameLayout.LayoutParams searchBoxLp = new FrameLayout.LayoutParams(-1, resources.getDimensionPixelSize(R.dimen.dimen_38dp));
        searchBoxLp.topMargin = resources.getDimensionPixelOffset(R.dimen.dimen_6dp);
        searchBoxLp.leftMargin = resources.getDimensionPixelOffset(R.dimen.dimen_13dp);
        searchBoxLp.rightMargin = resources.getDimensionPixelOffset(R.dimen.dimen_13dp);
        FrameLayout container = new FrameLayout(context);
        container.addView(this.mSearchBox, searchBoxLp);
        this.mVideoTabContainer.addView(container, 0);
        FrameLayout.LayoutParams tabParams = (FrameLayout.LayoutParams) this.mSlidingTab.getLayoutParams();
        tabParams.topMargin = resources.getDimensionPixelSize(R.dimen.dimen_43dp);
        this.mSlidingTab.setLayoutParams(tabParams);
        setSearchBoxHint();
    }

    /* access modifiers changed from: private */
    public void setSearchBoxHint() {
        if (this.mSearchBox != null) {
            VideoRuntime.getVideoContext().doSearchBoxViewVideoSetBoxHint(this.mSearchBox, VideoTabSearchQueryUtil.getNewHint(), 0);
            this.mSearchQueryHintTimer = Observable.timer((long) VideoTabSearchQueryUtil.getUpdateInterval(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
                public void call(Long aLong) {
                    VideoTabUI.this.setSearchBoxHint();
                }
            });
        }
    }

    private void initSearchInfo() {
        String vSearchButton = DefaultSharedPrefsWrapper.getInstance().getString(VideoQuoteConstants.PREF_VIDEO_SEARCH_SWITCH_BUTTON_KEY, "0");
        String vSearchBox = DefaultSharedPrefsWrapper.getInstance().getString(VideoQuoteConstants.PREF_VIDEO_SEARCH_SWITCH_BOX_KEY, "0");
        this.isSearchBtnShow = TextUtils.equals(vSearchButton, "1");
        this.isSearchBoxShow = TextUtils.equals(vSearchBox, "1");
    }

    public void onViewResume() {
        super.onViewResume();
        VideoTrafficUtils.showTrafficFreeTipIfNeed(AppRuntime.getAppContext());
        VideoDetailUbcUtils.uploadUBC4VideoChannelShown(VideoUtils.getVideoTabPD(getContext()));
        if (!this.isViewResume) {
            this.isViewResume = true;
            setSearchBoxHint();
        }
    }

    public void onViewPause() {
        super.onViewPause();
        this.isViewResume = false;
        Subscription subscription = this.mSearchQueryHintTimer;
        if (subscription != null) {
            subscription.unsubscribe();
            this.mSearchQueryHintTimer = null;
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        shouldResumeOrPausePlayer(hasFocus);
    }

    private void shouldResumeOrPausePlayer(boolean hasFocus) {
    }

    public Fragment makeFragment(MultiTabItemInfo info, Bundle extra) {
        if (info.isRnInfoComplete()) {
            return RNFeedFragment.newInstance(info, (Bundle) null, this.mMultitabInfoList, this.mBusiness);
        }
        VideoTabBaseFragment videoTabBaseFragment = VideoTabBaseFragment.newInstance(info, (Bundle) null);
        videoTabBaseFragment.setVideoTabListOuterUbcCallback(new IVideoTabListOuterUbc() {
            public void startFlowEvent() {
                VideoTabUI.this.startFlowEvent();
            }

            public void endFlowEvent() {
                VideoTabUI.this.endFlowEvent(true);
            }
        });
        return videoTabBaseFragment;
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        if (this.mSearchBox != null) {
            VideoRuntime.getVideoContext().doSearchBoxViewOnNightModeChanged(this.mSearchBox, isNightMode);
            VideoRuntime.getVideoContext().setSearchBoxBackground(this.mSearchBox);
        }
    }

    public void onViewDestroy() {
        super.onViewDestroy();
        VideoTabMutePlayUtil.clear();
    }
}
