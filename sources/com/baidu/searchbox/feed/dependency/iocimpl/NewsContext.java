package com.baidu.searchbox.feed.dependency.iocimpl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.launch.LaunchUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.comment.BDCommentConstants;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.controller.OtherSceneBackToHomeManager;
import com.baidu.searchbox.feed.news.INewsContext;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.statistic.FeedUBCWrapper;
import com.baidu.searchbox.home.feed.CeilingScene;
import com.baidu.searchbox.home.feed.CeilingSceneKt;
import com.baidu.searchbox.homepage.extend.IHomeFun;
import com.baidu.searchbox.leadsetting.LeadSettingUtils;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.push.PushUtils;
import com.baidu.searchbox.socialshare.statistics.SharePerformanceFlowUtil;
import org.json.JSONObject;

public class NewsContext implements INewsContext {
    private static final long FEED_TO_TOP_DELAY_TIME = 380;

    public boolean isPushFeed(String slog) {
        return PushUtils.isPushFeed(slog);
    }

    public boolean isShowBackTips() {
        return PushUtils.isShowBackTips();
    }

    public void recordShareClick(String nid) {
        if (SharePerformanceFlowUtil.hasFlow()) {
            SharePerformanceFlowUtil.resetFlow();
        }
        SharePerformanceFlowUtil.instanceFlow();
        SharePerformanceFlowUtil.setNid(nid);
        SharePerformanceFlowUtil.addEvent("P0");
    }

    public void dealTriviaWhenPageFinished(Intent newsIntent, JSONObject ubcInfo) {
        tryCeilingHomePage();
        ubcLaunchSourceInfo(newsIntent, ubcInfo);
    }

    private void ubcLaunchSourceInfo(Intent intent, JSONObject launchInfo) {
        if (intent != null) {
            String launchSource = intent.getStringExtra(LaunchUtils.LAUNCH_SOURCE_KEY);
            if (TextUtils.equals(launchSource, "push") || TextUtils.equals(launchSource, "scheme") || TextUtils.equals(launchSource, "widget")) {
                FeedUBCWrapper.ubcOnEvent("5107", launchInfo);
            }
        }
    }

    private void tryCeilingHomePage() {
        if (!FeedRuntime.getFeedContext().isInSearchSession() && OtherSceneBackToHomeManager.isNeedCellingFromLanding()) {
            UiThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    ((IHomeFun) ServiceManager.getService(IHomeFun.SERVICE_REFERENCE)).goToFeedWithoutAnim(new CeilingScene("auto", CeilingSceneKt.CEILING_TYPE_BAIDU_LOGO));
                    FeedStatisticCenter.setHasFeedBehaviour();
                }
            }, FEED_TO_TOP_DELAY_TIME);
        }
    }

    public boolean canShowNoticeGuideDialog(Activity activity) {
        boolean isNewUser = SpeedStats.getInstance().getLaunchType() == 2;
        boolean isOpen = LeadSettingUtils.isOpenNotification(BDCommentConstants.COMMENT_NOTIFY_DIALOG_SOURCE, 1);
        if (ActivityUtils.isDestroyed(activity) || isNewUser || isOpen) {
            return false;
        }
        return true;
    }
}
