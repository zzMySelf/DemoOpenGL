package com.baidu.searchbox.introduction.presenter;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.introduction.SplashUtils;
import com.baidu.searchbox.introduction.data.SplashData;
import com.baidu.searchbox.introduction.data.SplashDataManager;
import com.baidu.searchbox.introduction.data.SplashType;
import com.baidu.searchbox.introduction.statistic.SplashReportUtils;
import com.baidu.searchbox.introduction.view.SplashAdTopviewVideoDecoration;
import com.baidu.searchbox.introduction.view.SplashAdTopviewVideoViewBuilder;
import com.baidu.searchbox.introduction.view.SplashAdVideoDecoration;
import com.baidu.searchbox.introduction.view.SplashAdVideoViewBuilder;
import com.baidu.searchbox.introduction.view.TopviewHelper;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashAdTopviewVideoPresenter extends SplashAdVideoPresenter {
    Als.NonAnimationReason mNonAnimationReason = Als.NonAnimationReason.ANIMATION_SHOWABLE;

    public void setNonAnimationReason(Als.NonAnimationReason nonAnimationReason) {
        this.mNonAnimationReason = nonAnimationReason;
    }

    public SplashAdTopviewVideoPresenter(Context ctx, SplashData data) {
        super(ctx, data);
    }

    public void setUpBuilder(SplashAdVideoViewBuilder builder) {
        super.setUpBuilder(builder);
        File lottieFile = SplashDataManager.getInstance().getSplashSourceFile(this.mSplashDataItem.lottieUrl, SplashType.SourceType.LOTTIE);
        if (builder instanceof SplashAdTopviewVideoViewBuilder) {
            ((SplashAdTopviewVideoViewBuilder) builder).setVideoRate(this.mSplashDataItem.topviewRate);
            ((SplashAdTopviewVideoViewBuilder) builder).setTopViewAnimateType(this.mSplashDataItem.topViewAnimType);
            ((SplashAdTopviewVideoViewBuilder) builder).setTopViewLottieFile(lottieFile);
            String planId = SplashUtils.getTopViewKey(this.mSplashDataItem.key);
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("planId", planId);
                jsonObject.put("videoInfo", this.mSplashDataItem.videoInfo);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            ((SplashAdTopviewVideoViewBuilder) builder).setTopViewInfo(jsonObject);
        }
    }

    public void notifyHomeInit() {
        if (this.mListener != null) {
            this.mListener.onStart();
        }
    }

    public void onHomeUiInitReady() {
        super.onHomeUiInitReady();
        if (this.mViewBuilder instanceof SplashAdTopviewVideoViewBuilder) {
            ((SplashAdTopviewVideoViewBuilder) this.mViewBuilder).onHomeUiInitReady();
        }
    }

    /* access modifiers changed from: protected */
    public SplashAdVideoDecoration createVideoDecoration() {
        return new SplashAdTopviewVideoDecoration((Activity) this.mContext, this.mSplashDataItem.topviewRate);
    }

    /* access modifiers changed from: protected */
    public void sendStatistics(int source, JSONObject extObject) {
        super.sendStatistics(source, extObject);
        if (source == 2) {
            SplashReportUtils.executeTopviewResultStatistics(this.mSplashDataItem.key, this.mNonAnimationReason, extObject);
        }
    }

    /* access modifiers changed from: protected */
    public void quitSplash(int source) {
        if (source == 1 || source == 3 || source == 6 || source == 4) {
            AdRuntimeHolder.getFeedProxy().splashBeenQuited();
        }
        super.quitSplash(source);
    }

    /* access modifiers changed from: protected */
    public void notifySplashClose(int quitType) {
        super.notifySplashClose(quitType);
        if (quitType != 2) {
            TopviewHelper.setShowedTopView(false);
            TopviewHelper.notifyAnimatorEnd();
        }
    }

    public void onBackground() {
        SplashReportUtils.executeTopviewResultStatistics(this.mSplashDataItem.key, Als.NonAnimationReason.SKIP_SPLASH_AD, new JSONObject());
    }
}
