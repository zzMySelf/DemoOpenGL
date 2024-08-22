package com.baidu.searchbox.feed.widget.operationfloat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.common.matrixstyle.PrivacyMode;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.proxy.MediaPlayerProxy;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.feed.util.FeedRouter;
import com.baidu.searchbox.feed.widget.operationfloat.utils.Ext;
import com.baidu.searchbox.feed.widget.operationfloat.utils.OperationFloatStatisticsHelper;
import com.baidu.searchbox.privacy.PrivacyCommonDialog;
import com.baidu.searchbox.privacy.PrivacyDialogStatistic;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.widget.toucharea.ExpandTouchAreaHelper;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import java.io.File;

public class HomeOperationFloatContainer extends BaseOperationFloatContainer implements View.OnClickListener {
    private static final int BANNER_ANIM_DURATION = 500;
    private static final String TAG = "FeedOperationFloatView";
    /* access modifiers changed from: private */
    public AlphaVideo mAlphaVideo;
    /* access modifiers changed from: private */
    public AlphaVideo mBannerAlphaVideo;
    private FeedDraweeView mBannerImgView;
    /* access modifiers changed from: private */
    public FrameLayout mBannerLayout;
    /* access modifiers changed from: private */
    public BdBaseImageView mCloseIcon;
    private View mContentView;
    /* access modifiers changed from: private */
    public FrameLayout mFloatLayout;
    /* access modifiers changed from: private */
    public FeedDraweeView mImageView;

    public HomeOperationFloatContainer(Context context, HomeOperationModel model, IHomeOperationCache cache, boolean ifPlayGuideAnim) {
        super(context, model, cache, ifPlayGuideAnim);
    }

    public void onNightModeChanged(boolean isNight) {
        AlphaVideo alphaVideo = this.mAlphaVideo;
        if (alphaVideo != null) {
            alphaVideo.setDarkFilter(isNight ? 0.5f : 0.0f);
        }
    }

    /* access modifiers changed from: protected */
    public View createView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.feed_business_float_view, (ViewGroup) null);
        this.mContentView = inflate;
        this.mCloseIcon = (BdBaseImageView) inflate.findViewById(R.id.feed_operation_close_icon);
        this.mFloatLayout = (FrameLayout) this.mContentView.findViewById(R.id.feed_operation_fl);
        this.mAlphaVideo = (AlphaVideo) this.mContentView.findViewById(R.id.feed_operation_afx);
        this.mImageView = (FeedDraweeView) this.mContentView.findViewById(R.id.feed_operation_img);
        this.mBannerLayout = (FrameLayout) this.mContentView.findViewById(R.id.feed_operation_banner_fl);
        this.mBannerAlphaVideo = (AlphaVideo) this.mContentView.findViewById(R.id.feed_operation_banner_afx);
        this.mBannerImgView = (FeedDraweeView) this.mContentView.findViewById(R.id.feed_operation_banner_img);
        this.mContentView.setOnClickListener(this);
        this.mAlphaVideo.setOnClickListener(this);
        this.mCloseIcon.setOnClickListener(this);
        ExpandTouchAreaHelper.expandTouchArea(this.mContentView.getRootView(), this.mCloseIcon, DeviceUtils.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 15.0f));
        return this.mContentView;
    }

    /* access modifiers changed from: protected */
    public void showOperationFloat() {
        showDefaultImg(true);
        showWithAnim();
        this.mHasAddedToHomeView = true;
        OperationFloatStatisticsHelper.INSTANCE.display("home_icon", this.mModel.userType, this.mModel.type, new Ext(this.mModel.isHitNewUser, ""));
    }

    /* access modifiers changed from: protected */
    public boolean canShowShakeAnim() {
        if (this.mOperationCache.hasBannerShown()) {
            return true;
        }
        File res = DefaultOperationFloatControl.getAfxFile(this.mModel.bannerFileName, this.mModel.bannerAfxUrl, DefaultOperationFloatControl.BANNER_DIRECTORY_NAME);
        if ((res == null || !res.exists()) && TextUtils.isEmpty(this.mModel.bannerImgUrl)) {
            return true;
        }
        return false;
    }

    public void playGuideAnimation() {
        File res = DefaultOperationFloatControl.getAfxFile(this.mModel.resFileName, this.mModel.resourceUrl, DefaultOperationFloatControl.SUSPENSION_BALL_DIRECTORY_NAME);
        if (res == null || !res.exists()) {
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    HomeOperationFloatContainer.this.showBanner();
                }
            }, 1000);
        } else {
            showFloatAfx(res);
        }
    }

    private void showFloatAfx(File res) {
        this.mIsPlayingAnim = true;
        this.mAlphaVideo.setVisibility(0);
        this.mAlphaVideo.setPlayer(new MediaPlayerProxy());
        this.mAlphaVideo.setSourcePath(res.getAbsolutePath());
        this.mAlphaVideo.setDarkFilter(NightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.0f);
        this.mAlphaVideo.setOnVideoStartedListener(new OnVideoStartedListener() {
            public void onVideoStarted() {
                if (HomeOperationFloatContainer.this.mCloseIcon != null) {
                    HomeOperationFloatContainer.this.mCloseIcon.setVisibility(0);
                }
                if (HomeOperationFloatContainer.this.mImageView != null) {
                    HomeOperationFloatContainer.this.mImageView.setVisibility(4);
                }
            }
        });
        this.mAlphaVideo.setOnVideoEndedListener(new OnVideoEndedListener() {
            public void onVideoEnded() {
                HomeOperationFloatContainer.this.mIsPlayingAnim = false;
                HomeOperationFloatContainer.this.mAlphaVideo.destroy();
                HomeOperationFloatContainer.this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        HomeOperationFloatContainer.this.showDefaultImg(false);
                        HomeOperationFloatContainer.this.showBanner();
                    }
                }, 300);
            }
        });
        this.mAlphaVideo.setOnVideoErrorListener(new OnVideoErrorListener() {
            public boolean onError(ErrorInfo errorInfo) {
                HomeOperationFloatContainer.this.mIsPlayingAnim = false;
                HomeOperationFloatContainer.this.mAlphaVideo.destroy();
                UiThreadUtil.getMainHandler().post(new Runnable() {
                    public void run() {
                        HomeOperationFloatContainer.this.showDefaultImg(false);
                        HomeOperationFloatContainer.this.showBanner();
                    }
                });
                return true;
            }
        });
        this.mAlphaVideo.setLooping(false);
        this.mAlphaVideo.setKeepLastFrame(true);
        this.mAlphaVideo.play();
    }

    /* access modifiers changed from: private */
    public void showDefaultImg(final boolean playAnim) {
        if (TextUtils.isEmpty(this.mModel.coverImg)) {
            removeFromRootView();
            return;
        }
        this.mAlphaVideo.setVisibility(4);
        this.mImageView.setVisibility(0);
        PipelineDraweeControllerBuilder controllerBuilder = ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true)).setUri(this.mModel.coverImg);
        controllerBuilder.setOldController(this.mImageView.getController());
        controllerBuilder.setControllerListener(new BaseControllerListener<ImageInfo>() {
            public void onSubmit(String id, Object callerContext) {
            }

            public void onRelease(String id) {
            }

            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
                HomeOperationFloatContainer.this.removeFromRootView();
            }

            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                if (HomeOperationFloatContainer.this.mCloseIcon != null) {
                    HomeOperationFloatContainer.this.mCloseIcon.setVisibility(0);
                }
                if (playAnim && HomeOperationFloatContainer.this.mIfPlayGuideAnim) {
                    HomeOperationFloatContainer.this.playGuideAnimation();
                }
            }
        });
        controllerBuilder.setCallerContext((Object) FeedRuntime.getAppContext());
        this.mImageView.setController(controllerBuilder.build());
    }

    /* access modifiers changed from: private */
    public void showBanner() {
        if (this.mOperationCache.hasBannerShown()) {
            this.mIsPlayingAnim = false;
        } else if (this.mIsSliding || this.mIsHiding) {
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    HomeOperationFloatContainer.this.showBanner();
                }
            }, 1000);
        } else {
            int screenWidth = DeviceUtils.ScreenInfo.getDisplayWidth(FeedRuntime.getAppContext());
            if (screenWidth <= 0 || this.mModel.bannerWidth <= screenWidth - (BOTTOM_MARGIN_NO_TTS * 2)) {
                this.mIsPlayingAnim = true;
                File res = DefaultOperationFloatControl.getAfxFile(this.mModel.bannerFileName, this.mModel.bannerAfxUrl, DefaultOperationFloatControl.BANNER_DIRECTORY_NAME);
                if (res == null || !res.exists()) {
                    showBannerImg();
                } else {
                    showBannerAfx(res);
                }
            }
        }
    }

    private void showBannerAfx(File resFile) {
        this.mOperationCache.saveHasBannerShown(true);
        this.mBannerImgView.setVisibility(8);
        this.mBannerAlphaVideo.setVisibility(0);
        ViewGroup.LayoutParams params = this.mBannerAlphaVideo.getLayoutParams();
        updateBannerSize(params);
        this.mBannerAlphaVideo.setLayoutParams(params);
        this.mBannerAlphaVideo.setPlayer(new MediaPlayerProxy());
        this.mBannerAlphaVideo.setSourcePath(resFile.getAbsolutePath());
        this.mBannerAlphaVideo.setDarkFilter(NightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.0f);
        this.mBannerAlphaVideo.setOnVideoEndedListener(new OnVideoEndedListener() {
            public void onVideoEnded() {
                HomeOperationFloatContainer.this.mBannerAlphaVideo.destroy();
            }
        });
        this.mBannerAlphaVideo.setOnVideoErrorListener(new OnVideoErrorListener() {
            public boolean onError(ErrorInfo errorInfo) {
                HomeOperationFloatContainer.this.mBannerAlphaVideo.destroy();
                return true;
            }
        });
        this.mBannerAlphaVideo.setLooping(false);
        this.mBannerAlphaVideo.setKeepLastFrame(true);
        playShowBannerAnim();
        this.mBannerAlphaVideo.play();
    }

    private void updateBannerSize(ViewGroup.LayoutParams params) {
        params.width = getBannerWidth();
        if (params.width < this.mModel.bannerWidth) {
            params.height = (int) (((float) this.mModel.bannerWidth) * (getResources().getDimension(R.dimen.feed_operation_float_image_width) / ((float) this.mModel.bannerWidth)));
        }
    }

    private void showBannerImg() {
        if (TextUtils.isEmpty(this.mModel.bannerImgUrl)) {
            this.mIsPlayingAnim = false;
            return;
        }
        this.mOperationCache.saveHasBannerShown(true);
        this.mBannerImgView.setVisibility(0);
        this.mBannerLayout.setVisibility(0);
        this.mBannerAlphaVideo.setVisibility(8);
        ViewGroup.LayoutParams params = this.mBannerImgView.getLayoutParams();
        updateBannerSize(params);
        this.mBannerImgView.setLayoutParams(params);
        PipelineDraweeControllerBuilder controllerBuilder = ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true)).setUri(this.mModel.bannerImgUrl);
        controllerBuilder.setOldController(this.mBannerImgView.getController());
        controllerBuilder.setControllerListener(new BaseControllerListener<ImageInfo>() {
            public void onSubmit(String id, Object callerContext) {
                super.onSubmit(id, callerContext);
            }

            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
                HomeOperationFloatContainer.this.mBannerLayout.setVisibility(8);
                HomeOperationFloatContainer.this.mIsPlayingAnim = false;
            }

            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                HomeOperationFloatContainer.this.playShowBannerAnim();
            }
        });
        controllerBuilder.setCallerContext((Object) FeedRuntime.getAppContext());
        this.mBannerImgView.setController(controllerBuilder.build());
    }

    /* access modifiers changed from: private */
    public void playShowBannerAnim() {
        ValueAnimator.AnimatorUpdateListener listener = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                ViewGroup.LayoutParams params = HomeOperationFloatContainer.this.mBannerLayout.getLayoutParams();
                params.width = ((Integer) animation.getAnimatedValue()).intValue();
                HomeOperationFloatContainer.this.mBannerLayout.setLayoutParams(params);
            }
        };
        ObjectAnimator bannerShowAlpha = ObjectAnimator.ofFloat(this.mBannerLayout, "alpha", new float[]{0.0f, 1.0f});
        bannerShowAlpha.setDuration(500);
        ValueAnimator bannerShowWidth = ObjectAnimator.ofInt(new int[]{0, getBannerWidth()});
        bannerShowWidth.setDuration(500);
        bannerShowWidth.addUpdateListener(listener);
        ObjectAnimator floatHideAnimator = ObjectAnimator.ofFloat(this.mFloatLayout, "alpha", new float[]{1.0f, 0.0f});
        floatHideAnimator.setDuration(300);
        AnimatorSet bannerShowAnimator = new AnimatorSet();
        bannerShowAnimator.playTogether(new Animator[]{bannerShowAlpha, bannerShowWidth, floatHideAnimator});
        bannerShowAnimator.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
            }

            public void onAnimationEnd(Animator animation) {
                HomeOperationFloatContainer.this.mFloatLayout.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = HomeOperationFloatContainer.this.mBannerLayout.getLayoutParams();
                layoutParams.width = HomeOperationFloatContainer.this.getBannerWidth();
                HomeOperationFloatContainer.this.mBannerLayout.setLayoutParams(layoutParams);
                HomeOperationFloatContainer.this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        HomeOperationFloatContainer.this.hideBanner();
                    }
                }, (long) (HomeOperationFloatContainer.this.mModel.bannerDisplayTime * 1000));
            }

            public void onAnimationCancel(Animator animation) {
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
        this.mBannerLayout.setVisibility(0);
        bannerShowAnimator.start();
    }

    /* access modifiers changed from: private */
    public void hideBanner() {
        this.mFloatLayout.setVisibility(0);
        ValueAnimator.AnimatorUpdateListener listener = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                ViewGroup.LayoutParams params = HomeOperationFloatContainer.this.mBannerLayout.getLayoutParams();
                params.width = ((Integer) animation.getAnimatedValue()).intValue();
                HomeOperationFloatContainer.this.mBannerLayout.setLayoutParams(params);
            }
        };
        ObjectAnimator bannerHideAlpha = ObjectAnimator.ofFloat(this.mBannerLayout, "alpha", new float[]{1.0f, 0.0f});
        bannerHideAlpha.setDuration(500);
        ValueAnimator bannerHideWidth = ObjectAnimator.ofInt(new int[]{this.mBannerLayout.getWidth(), 0});
        bannerHideWidth.setDuration(500);
        bannerHideWidth.addUpdateListener(listener);
        ObjectAnimator floatShowAnimator = ObjectAnimator.ofFloat(this.mFloatLayout, "alpha", new float[]{0.0f, 1.0f});
        floatShowAnimator.setDuration(300);
        AnimatorSet bannerHideAnimator = new AnimatorSet();
        bannerHideAnimator.playTogether(new Animator[]{bannerHideAlpha, bannerHideWidth, floatShowAnimator});
        bannerHideAnimator.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
            }

            public void onAnimationEnd(Animator animation) {
                HomeOperationFloatContainer.this.mIsPlayingAnim = false;
                HomeOperationFloatContainer.this.mBannerLayout.setVisibility(8);
            }

            public void onAnimationCancel(Animator animation) {
                HomeOperationFloatContainer.this.mIsPlayingAnim = false;
                HomeOperationFloatContainer.this.mBannerLayout.setVisibility(8);
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
        bannerHideAnimator.start();
    }

    /* access modifiers changed from: private */
    public int getBannerWidth() {
        int screenWidth = DeviceUtils.ScreenInfo.getDisplayWidth(FeedRuntime.getAppContext());
        if (screenWidth <= 0 || this.mModel.bannerWidth <= screenWidth - (BOTTOM_MARGIN_NO_TTS * 2)) {
            return this.mModel.bannerWidth;
        }
        return screenWidth - (BOTTOM_MARGIN_NO_TTS * 2);
    }

    public void onClick(View v) {
        if (this.mModel != null) {
            if (v.getId() == R.id.feed_operation_close_icon) {
                onClose();
            } else {
                onFloatClick();
            }
        }
    }

    private void onFloatClick() {
        int currentState = PrivacyMode.INSTANCE.getCurrentState();
        PrivacyMode privacyMode = PrivacyMode.INSTANCE;
        if (currentState == 2) {
            new PrivacyCommonDialog.Builder(this.mContext).setTitle(R.string.privacy_operation_title).setMessage(getResources().getString(R.string.privacy_operation_message_prefix) + getResources().getString(com.baidu.searchbox.oem.privacy.R.string.androidm_warmalarm_exp_privacy_mode_common)).setPositiveButton(R.string.privacy_operation_agree, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    PrivacyMode.INSTANCE.changeBrowserModeToAuthority();
                    HomeOperationFloatContainer.this.handleFloatClick();
                }
            }).setNegativeButton(R.string.privacy_operation_disagree, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            }).setBrowsePage(PrivacyDialogStatistic.PAGE_BROWSE_FEED).create().show();
            return;
        }
        handleFloatClick();
    }

    /* access modifiers changed from: private */
    public void handleFloatClick() {
        this.mOperationCache.saveNoClickShowDays(0);
        this.mOperationCache.saveBackShowCount(0);
        FeedRouter.invoke(this.mContext, this.mModel.cmd, false);
        OperationFloatStatisticsHelper.INSTANCE.inClick("home_icon", this.mModel.userType, this.mModel.type, new Ext(this.mModel.isHitNewUser, ""));
    }

    private void onClose() {
        saveCloseCountAndTime();
        OperationFloatStatisticsHelper.INSTANCE.closeClick("home_icon", this.mModel.userType, this.mModel.type, new Ext(this.mModel.isHitNewUser, ""));
        removeFromRootView();
    }
}
