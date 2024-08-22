package com.baidu.searchbox.introduction.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ad.SplashSpeedState;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.exclusion.popup.ShowStatus;
import com.baidu.searchbox.exclusion.popup.ShowStatusCallback;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.model.TopViewLocation;
import com.baidu.searchbox.introduction.SplashLifeCycleEvent;
import com.baidu.searchbox.introduction.data.SplashPolicyRecorder;
import com.baidu.searchbox.introduction.hotboot.HotSplashManager;
import com.baidu.searchbox.introduction.presenter.SplashAdTopviewVideoPresenter;
import com.baidu.searchbox.introduction.presenter.SplashAdVideoPresenter;
import com.baidu.searchbox.introduction.view.TopViewAnimationManager;
import com.baidu.searchbox.player.assistant.PlayerCacheAssistant;
import java.io.File;
import org.json.JSONObject;

public class SplashAdTopviewVideoViewBuilder extends SplashAdVideoViewBuilder {
    private static final int ALPHA_ANIM_DURATION = 1000;
    private static final float LOTTIE_PROGRESS_DO_TRANSLATE = 0.75f;
    private View decorView;
    private double mCurrentScaleX;
    /* access modifiers changed from: private */
    public Rect mFeedRect;
    private boolean mIsTopviewSuccess;
    private Als.NonAnimationReason mNonAnimationReason;
    /* access modifiers changed from: private */
    public Rect mSplashRect = new Rect();
    Runnable mSurfaceFeedRunnable = new Runnable() {
        public void run() {
            TopviewHelper.surfaceFeed();
        }
    };
    private int mTopViewAnimateType;
    /* access modifiers changed from: private */
    public JSONObject mTopViewInfo;
    private File mTopViewLottieFile;
    private double videoRate;

    public void setVideoRate(double videoRate2) {
        this.videoRate = videoRate2;
    }

    public void setTopViewAnimateType(int type) {
        this.mTopViewAnimateType = type;
    }

    public void setTopViewLottieFile(File file) {
        this.mTopViewLottieFile = file;
    }

    public void setTopViewInfo(JSONObject topViewInfo) {
        this.mTopViewInfo = topViewInfo;
    }

    public SplashAdTopviewVideoViewBuilder(Context ctx) {
        super(ctx);
        TopviewHelper.setIsTopview(true);
    }

    /* access modifiers changed from: protected */
    public void relayoutContentView() {
        this.mCurrentScaleX = TopviewHelper.calculateScralRate((double) DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext), ((double) DeviceUtil.ScreenInfo.getDisplayHeight(this.mContext)) * this.videoRate);
        if (this.videoRate > 1.0d) {
            this.mSplashContentView.setScaleX((float) this.mCurrentScaleX);
        }
        this.mRemoveCoverDelayTime = 25;
        postOnViewUpdated(new Runnable() {
            public void run() {
                SplashAdTopviewVideoViewBuilder.this.mSplashContentView.getGlobalVisibleRect(SplashAdTopviewVideoViewBuilder.this.mSplashRect);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void tryAttachDecoration() {
        super.tryAttachDecoration();
        if (this.mVideoDecoration != null) {
            if (DEBUG) {
                Log.d("SplashAdVideoViewBuilder", "tryAttachDecoration");
            }
            View decorView2 = this.mVideoDecoration.getDecorView();
            this.decorView = decorView2;
            if (decorView2 != null && decorView2.getParent() != this.mSplashContentView) {
                if (this.decorView.getParent() != null) {
                    if (DEBUG) {
                        Log.w("SplashAdVideoViewBuilder", "tryAttachDecoration while attaching!");
                    }
                    ((ViewGroup) this.decorView.getParent()).removeView(this.decorView);
                }
                this.mSplashContentView.addView(this.decorView, 1);
            }
        } else if (DEBUG) {
            Log.d("SplashAdVideoViewBuilder", "tryAttachDecoration when decor is null!");
        }
    }

    /* access modifiers changed from: protected */
    public void onBuildFinish() {
        super.onBuildFinish();
        if (this.mPresenter instanceof SplashAdTopviewVideoPresenter) {
            ((SplashAdTopviewVideoPresenter) this.mPresenter).notifyHomeInit();
        }
    }

    /* access modifiers changed from: protected */
    public boolean isNeedCover() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void setCoverScaleType() {
        if (this.videoRate > 1.0d) {
            this.mVideoCoverView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            this.mVideoCoverView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void onFinishAnimate() {
        super.onFinishAnimate();
        TopViewLocation location = TopviewHelper.getTopviewLocaion(this.mTopViewInfo);
        this.mNonAnimationReason = location.mReason;
        if (HotSplashManager.getInstance().isHotBoot()) {
            this.mNonAnimationReason = Als.NonAnimationReason.BACK_TO_FOREGROUND;
        }
        if (this.mPresenter instanceof SplashAdTopviewVideoPresenter) {
            ((SplashAdTopviewVideoPresenter) this.mPresenter).setNonAnimationReason(this.mNonAnimationReason);
        }
        Rect rect = location.mPlayerLocation;
        this.mFeedRect = rect;
        if (rect == null || this.mNonAnimationReason != Als.NonAnimationReason.ANIMATION_SHOWABLE) {
            this.mIsTopviewSuccess = false;
            TopviewHelper.notifyAnimatorEnd();
            ((SplashAdVideoPresenter) this.mPresenter).notifySplashFinish(2);
        } else {
            this.mIsTopviewSuccess = true;
            doTopViewAnimator(this.mTopViewAnimateType);
        }
        TopviewHelper.setIsTopviewSuccess(this.mIsTopviewSuccess);
    }

    /* access modifiers changed from: protected */
    public void onAdShow() {
        SplashSpeedState.getInstance().onBlockSplashVideoStart();
        setupCover();
        ((SplashAdVideoPresenter) this.mPresenter).onAdShow();
        TopviewHelper.setShowedTopView(true);
        if (SplashPolicyRecorder.getInstance().isBackSkipOptOn()) {
            BdEventBus.Companion.getDefault().register(this, SplashLifeCycleEvent.class, 1, new SplashAdTopviewVideoViewBuilder$$ExternalSyntheticLambda0(this));
        }
        PopupExclusionManagerMap.getInstance().display("scene_home", new PopupExclusionManagerMap.Operation(ExclusionType.HOME_SPLASH_TOPVIEW, 1.3f, true, false) {
            public void onShow(ShowStatusCallback callback) {
                callback.callback(ShowStatus.UNKNOWN);
            }
        });
        this.mUiHandler.postDelayed(this.mSurfaceFeedRunnable, 4500);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onAdShow$0$com-baidu-searchbox-introduction-view-SplashAdTopviewVideoViewBuilder  reason: not valid java name */
    public /* synthetic */ void m20579lambda$onAdShow$0$combaidusearchboxintroductionviewSplashAdTopviewVideoViewBuilder(SplashLifeCycleEvent splashLifeCycleEvent) {
        if (this.mPresenter != null) {
            ((SplashAdVideoPresenter) this.mPresenter).onBackGround();
        }
    }

    public void showAdEnd() {
        this.mUiHandler.removeCallbacks(this.mSurfaceFeedRunnable);
        if (!this.mIsTopviewSuccess && this.mNonAnimationReason != Als.NonAnimationReason.EMPTY_TOP_VIEW_LOCATION) {
            TopviewHelper.gotoMain();
        }
        removeMessages();
    }

    public void release() {
        unbindGestureEvent();
        unRegisterSensor();
        if (!BdBoxActivityManager.isForeground()) {
            removeSelf();
            removeMessages();
            if (this.mPresenter instanceof SplashAdTopviewVideoPresenter) {
                ((SplashAdTopviewVideoPresenter) this.mPresenter).onBackground();
            }
        } else if (!this.mIsTopviewSuccess) {
            removeMessages();
            removeSelf();
            if (this.mVideoDecoration != null) {
                this.mVideoDecoration.release();
                this.mVideoDecoration = null;
            }
            PlayerCacheAssistant.get().removeTempPlayer(PlayerCacheAssistant.AD_TOP_VIEW_CACHE);
            if (this.mNonAnimationReason != Als.NonAnimationReason.EMPTY_TOP_VIEW_LOCATION) {
                TopviewHelper.gotoMain();
            }
            TopviewHelper.preInitWebView();
            TopviewHelper.notifyHomeDelayTask();
        }
        PopupExclusionManagerMap.getInstance().unDisplay("scene_home", ExclusionType.HOME_SPLASH_TOPVIEW);
        if (SplashPolicyRecorder.getInstance().isBackSkipOptOn()) {
            BdEventBus.Companion.getDefault().unregister(this);
        }
    }

    private void removeSelf() {
        if (this.mRootView != null && (this.mRootView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void onVideoPrepared() {
    }

    public void onHomeUiInitReady() {
        startCountdown();
        if (this.mVideoDecoration != null) {
            this.mVideoDecoration.play();
        }
        SplashSpeedState.getInstance().onBlockSplashVideoEnd();
    }

    private void doTopViewAnimator(int topViewAnimateType) {
        switch (topViewAnimateType) {
            case 2:
                doVideoScaleAnim();
                return;
            case 3:
                doVideoCropAlphaAnim();
                return;
            case 4:
                doVideoAlphaLottieAnim();
                return;
            default:
                TopviewHelper.notifyAnimatorEnd();
                notifyAnimEnd();
                return;
        }
    }

    private void doVideoAlphaLottieAnim() {
        this.mRootView.setBackgroundColor(0);
        removeCommonView();
        TopviewHelper.notifyAnimatorEnd();
        TopViewAnimationManager.getInstance().doTopViewAlphaAnim(this.decorView, 1000, new TopViewAnimationManager.TopViewAnimListener() {
            public void animEnd() {
            }
        });
        TopViewAnimationManager.getInstance().doLottieAnim(this.mTopViewLottieFile, this.mLottieAnimationView, new TopViewAnimationManager.TopViewAnimListener() {
            public void animEnd() {
                SplashAdTopviewVideoViewBuilder.this.notifyAnimEnd();
            }
        }, new TopViewAnimationManager.LottieCallBack() {
            public void finishSetLottie(long lottieDuration) {
                TopViewAnimationManager.getInstance().doTranslateAnim(SplashAdTopviewVideoViewBuilder.this.mLottieAnimationView, SplashAdTopviewVideoViewBuilder.this.mSplashRect, SplashAdTopviewVideoViewBuilder.this.mFeedRect, (long) (((float) lottieDuration) * 0.75f), (long) (((float) lottieDuration) * 0.25f));
            }
        });
    }

    private void doVideoCropAlphaAnim() {
        this.mRootView.setBackgroundColor(0);
        removeCommonView();
        TopViewAnimationManager.getInstance().doVideoCropAlphaAnim(this.decorView, this.mSplashContentView, this.mSplashRect, this.mFeedRect, new TopViewAnimationManager.TopViewAnimListener() {
            public void animEnd() {
                TopviewHelper.notifyAnimatorEnd();
                SplashAdTopviewVideoViewBuilder.this.notifyAnimEnd();
            }
        });
    }

    private void doVideoScaleAnim() {
        this.mRootView.setBackgroundColor(0);
        removeCommonView();
        TopViewAnimationManager.getInstance().doVideoScaleAnim(this.mSplashContentView, this.mSplashRect, this.mFeedRect, this.mCurrentScaleX, new TopViewAnimationManager.TopViewAnimListener() {
            public void animEnd() {
                TopviewHelper.notifyAnimatorEnd();
                SplashAdTopviewVideoViewBuilder.this.notifyAnimEnd();
            }
        });
    }

    /* access modifiers changed from: private */
    public void notifyAnimEnd() {
        SplashSpeedState.getInstance().onBlockFeedVideoStart();
        removeSelf();
        this.mUiHandler.postDelayed(new Runnable() {
            public void run() {
                if (SplashAdTopviewVideoViewBuilder.this.mPresenter != null) {
                    ((SplashAdVideoPresenter) SplashAdTopviewVideoViewBuilder.this.mPresenter).notifySplashFinish(2);
                    if (SplashAdTopviewVideoViewBuilder.this.mTopViewInfo == null || SplashAdTopviewVideoViewBuilder.this.mTopViewInfo.length() == 0) {
                        TopviewHelper.notifyHomeDelayTask();
                    }
                }
            }
        }, 15);
    }

    private void removeCommonView() {
        if (this.mWifiTip != null) {
            this.mWifiTip.setVisibility(8);
        }
        this.mCountSkipContainer.setVisibility(8);
        this.mSmallLogoView.setVisibility(8);
        if (this.mLabel != null) {
            this.mLabel.setVisibility(8);
        }
        if (!(this.mVideoDecoration == null || this.mVideoDecoration.getVoiceView() == null)) {
            this.mVideoDecoration.getVoiceView().setVisibility(8);
        }
        if (this.mFloatBarView != null) {
            this.mFloatBarView.setVisibility(8);
        }
        if (this.mFloatBarWrapper != null) {
            this.mFloatBarWrapper.setVisibility(8);
        }
    }
}
