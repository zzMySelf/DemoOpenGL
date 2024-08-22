package com.baidu.searchbox.rewardsystem.newtimer.view;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieImageAsset;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.bdptask.resource.TimerResManagerKt;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.lite.ui.TaskSizeTypeKt;
import com.baidu.searchbox.rewardsystem.config.RewardConfig;
import com.baidu.searchbox.rewardsystem.newtimer.data.TimerDataModel;
import com.baidu.searchbox.rewardsystem.newtimer.event.TaskNotActiveRedPacketEvent;
import com.baidu.searchbox.rewardsystem.newtimer.listener.ITimerAnimationListener;
import com.baidu.searchbox.rewardsystem.newtimer.listener.ITimerButtomAnimationListener;
import com.baidu.searchbox.rewardsystem.newtimer.status.TimerStatus;
import com.baidu.searchbox.rewardsystem.newtimer.utils.ViewUtilsKt;
import com.baidu.searchbox.rewardsystem.operation.R;
import com.baidu.searchbox.rewardsystem.operation.RewardTaskStatusManager;
import com.baidu.searchbox.rewardsystem.operation.TaskFloatShowManager;
import com.baidu.searchbox.rewardsystem.repo.RewardTaskRepo;
import com.baidu.searchbox.rewardsystem.tips.TipsViewBean;
import com.baidu.searchbox.rewardsystem.utils.RedPacketAnimationHelper;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.taskapi.HomeComponentManager;
import com.baidu.searchbox.taskapi.core.intput.BusinessType;
import com.baidu.searchbox.taskapi.core.util.ICallback;
import com.baidu.searchbox.taskapi.core.util.TaskDebugUtil;
import com.baidu.searchbox.ui.RoundProgressBar;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

public class TimerWidget extends FrameLayout {
    private static final int HEIGHT_INIT = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size);
    private static final int HEIGHT_NORMAL = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size_h);
    private Boolean isBottomTipsAnimating = false;
    /* access modifiers changed from: private */
    public boolean isDetached = false;
    private boolean isShowAnimator = false;
    private Boolean isShowTxtCountDown = false;
    private boolean isShowingTreasureBox = false;
    private Runnable mActionDoOnBoxHide;
    private ViewGroup mBodyContainer;
    /* access modifiers changed from: private */
    public TextView mBottomScrollTips;
    /* access modifiers changed from: private */
    public TextView mBottomTips;
    /* access modifiers changed from: private */
    public FrameLayout mBottomTipsContainer;
    private String mBoxShowBottomText;
    private BusinessType mBusinessType;
    private int mCountdownWidgetType = 0;
    private int mCurrentLottieImage = -1;
    private String mCurrentLottieImgPath;
    private String mCurrentLottiePath;
    private SimpleDateFormat mDateFormatter;
    /* access modifiers changed from: private */
    public boolean mHideUnit = false;
    /* access modifiers changed from: private */
    public SimpleDraweeView mImageView;
    public LottieAnimationView mLottieAnimationView;
    /* access modifiers changed from: private */
    public String mLottiePath;
    private ProgressShadow mProgressShadow;
    private Long mRemainTimeLast = 0L;
    private View mRootView;
    private RoundProgressBar mRoundProgressBar;
    ScanningView mScanningView;
    private Runnable mTaskChangeBox2Normal = new Runnable() {
        public void run() {
            TimerWidget.this.changeBox2Normal();
        }
    };
    private TimerDataModel mTimerDataModel;

    public TimerWidget(Context context) {
        super(context);
        init();
    }

    public TimerWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttrs(attrs);
        init();
    }

    public TimerWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttrs(attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.newtimer_widget_container, this, true);
        this.mRootView = findViewById(R.id.newtimer_widget_layout_container);
        this.mBodyContainer = (ViewGroup) findViewById(R.id.timer_body_container);
        this.mRoundProgressBar = (RoundProgressBar) findViewById(R.id.newtimer_widget_progress_bar);
        this.mProgressShadow = (ProgressShadow) findViewById(R.id.newtimer_widget_inner_bg);
        this.mImageView = (SimpleDraweeView) findViewById(R.id.newtimer_widget_image);
        this.mBottomTipsContainer = (FrameLayout) findViewById(R.id.newtimer_widget_bottom_tips_container);
        this.mBottomTips = (TextView) findViewById(R.id.newtimer_widget_bottom_tips);
        this.mBottomScrollTips = (TextView) findViewById(R.id.newtimer_widget_bottom_scroll_tips);
        ViewUtilsKt.setTextViewBold(this.mBottomTips);
        ViewUtilsKt.setTextViewBold(this.mBottomScrollTips);
        this.mLottieAnimationView = (LottieAnimationView) findViewById(R.id.newtimer_widget_lottie);
        this.mScanningView = (ScanningView) findViewById(R.id.newtimer_widget_bottom_shimmer);
        initProgressBar();
        initImageView();
        updateWithFontSize();
        updateWithNightMode();
    }

    private int getTextViewWidth(TextView textView) {
        if (textView == null) {
            return 0;
        }
        int spec = View.MeasureSpec.makeMeasureSpec(0, 0);
        textView.measure(spec, spec);
        TaskDebugUtil.debugLog("【TimeWidget】[getTextViewWidth]=" + textView.getMeasuredWidth());
        return textView.getMeasuredWidth();
    }

    /* access modifiers changed from: private */
    public void resizeBottomTips() {
        if (getTextViewWidth(this.mBottomTips) > getTextViewWidth(this.mBottomScrollTips)) {
            this.mBottomScrollTips.setLayoutParams(this.mBottomTips.getLayoutParams());
        } else {
            this.mBottomTips.setLayoutParams(this.mBottomScrollTips.getLayoutParams());
        }
    }

    /* access modifiers changed from: package-private */
    public String getBottomTipsUnit(TimerDataModel timerData, boolean filterCoinUnit) {
        if ("coin".equals(((TipsViewBean) Objects.requireNonNull(timerData.getTipsViewBean())).mToastType)) {
            if (!filterCoinUnit) {
                return getResources().getString(R.string.multiple_timer_tips);
            }
            return "";
        } else if ("money".equals(timerData.getTipsViewBean().mToastType)) {
            return getResources().getString(R.string.money_unit_yuan);
        } else {
            return "";
        }
    }

    public void updateWithFontSize() {
        FontSizeViewExtKt.setScaledWidth(this, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size));
        FontSizeViewExtKt.setScaledHeight(this, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size_h));
        FontSizeViewExtKt.setScaledWidth(this.mRootView, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size));
        FontSizeViewExtKt.setScaledHeight(this.mRootView, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size_h));
        FontSizeViewExtKt.setScaledWidthRes(this.mBodyContainer, TaskSizeTypeKt.getTaskSizeType(), R.dimen.normal_timer_widget_size);
        FontSizeViewExtKt.setScaledHeightRes(this.mBodyContainer, TaskSizeTypeKt.getTaskSizeType(), R.dimen.normal_timer_widget_size);
        FontSizeViewExtKt.setScaledWidth(this.mProgressShadow, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_progress_shadow_size));
        FontSizeViewExtKt.setScaledHeight(this.mProgressShadow, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_progress_shadow_size));
        FontSizeViewExtKt.setScaledWidth(this.mRoundProgressBar, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_progress_circle_size));
        FontSizeViewExtKt.setScaledHeight(this.mRoundProgressBar, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_progress_circle_size));
        this.mRoundProgressBar.setRoundWidth(FontSizeHelper.getScaledSize(TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_progress_circle_width)));
        FontSizeViewExtKt.setScaledWidth(this.mImageView, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size));
        FontSizeViewExtKt.setScaledHeight(this.mImageView, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size));
        FontSizeViewExtKt.setScaledHeightRes(this.mBottomTipsContainer, TaskSizeTypeKt.getTaskSizeType(), R.dimen.newtimer_op_tips_height);
        FontSizeTextViewExtKt.setScaledSize(this.mBottomTips, TaskSizeTypeKt.getTaskSizeType(), 0, (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_bottom_tips_text_size), 2);
        FontSizeTextViewExtKt.setScaledSize(this.mBottomScrollTips, TaskSizeTypeKt.getTaskSizeType(), 0, (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_bottom_tips_text_size), 2);
        this.mBottomTipsContainer.setBackground(FontSizeHelper.getScaledDrawable(TaskSizeTypeKt.getTaskSizeType(), AppRuntime.getAppContext().getResources().getDrawable(R.drawable.newtimer_normal_tips_bg_drawable)));
    }

    private void initProgressBar() {
        RoundProgressBar roundProgressBar = this.mRoundProgressBar;
        if (roundProgressBar != null) {
            roundProgressBar.setMax(100);
            this.mRoundProgressBar.setCircleColor(AppRuntime.getAppContext().getResources().getColor(R.color.newtimer_normal_progressbar_circle_color));
            this.mRoundProgressBar.setRoundWidth((float) DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 3.0f));
            this.mRoundProgressBar.setCircleProgressColor(AppRuntime.getAppContext().getResources().getColor(R.color.newtimer_normal_progressbar_stroke_color));
        }
    }

    private void initImageView() {
        if (this.mImageView != null) {
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setRoundAsCircle(true);
            GenericDraweeHierarchyBuilder builder = GenericDraweeHierarchyBuilder.newInstance(getResources());
            builder.setRoundingParams(roundingParams);
            builder.setPlaceholderImage(R.drawable.timer_widget_initialized_placeholder);
            this.mImageView.setHierarchy(builder.build());
        }
    }

    public void setShowAnimator(boolean showAnimator) {
        this.isShowAnimator = showAnimator;
    }

    public TimerStatus getTimerStatus() {
        TimerDataModel timerDataModel = this.mTimerDataModel;
        return timerDataModel == null ? TimerStatus.INITIALIZED : timerDataModel.getTimerStatus();
    }

    public void setBusinessType(BusinessType businessType) {
        this.mBusinessType = businessType;
    }

    public boolean getIsDetached() {
        return this.isDetached;
    }

    public void setPercent(Float percent) {
        RoundProgressBar roundProgressBar = this.mRoundProgressBar;
        if (roundProgressBar != null) {
            roundProgressBar.setProgress((int) (percent.floatValue() * ((float) this.mRoundProgressBar.getMax())));
        }
    }

    public void loadImage(int drawable) {
        SimpleDraweeView simpleDraweeView = this.mImageView;
        if (simpleDraweeView != null && drawable >= 0) {
            if (simpleDraweeView.getVisibility() != 0 || drawable != this.mCurrentLottieImage) {
                this.mCurrentLottieImage = drawable;
                this.mImageView.setVisibility(0);
                this.mLottieAnimationView.setVisibility(8);
                this.mImageView.setImageResource(drawable);
            }
        }
    }

    public void loadLottie(int drawable, String assetsFileName, String imageAssetPath, boolean looping, ITimerAnimationListener timerAnimationListener) {
        if (this.mLottieAnimationView != null && this.mImageView != null) {
            if (!TextUtils.isEmpty(this.mLottiePath) && TextUtils.equals(this.mLottiePath, assetsFileName) && this.mLottieAnimationView.isAnimating()) {
                return;
            }
            if (!this.isShowAnimator) {
                loadImage(drawable);
                TaskDebugUtil.debugLog("【TimeWidget】[loadLottie] is not showAnimator, load Image");
                return;
            }
            final String str = assetsFileName;
            final ITimerAnimationListener iTimerAnimationListener = timerAnimationListener;
            final int i2 = drawable;
            final String str2 = imageAssetPath;
            final boolean z = looping;
            getLottieInputStream(assetsFileName, new ICallback<InputStream>() {
                public void callback(InputStream inputStream) {
                    if (inputStream == null) {
                        TaskDebugUtil.debugLog("【TimeWidget】[loadLottie] getLottieJson json is null , return " + str);
                        return;
                    }
                    TaskDebugUtil.debugLog("【TimeWidget】[loadLottie] show " + str);
                    String unused = TimerWidget.this.mLottiePath = str;
                    TimerWidget.this.mLottieAnimationView.cancelAnimation();
                    TimerWidget.this.mLottieAnimationView.setAnimation(inputStream, (String) null);
                    TimerWidget.this.mLottieAnimationView.removeAllAnimatorListeners();
                    TimerWidget.this.mLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
                        public void onAnimationStart(Animator animation) {
                            TaskDebugUtil.debugLog("【TimeWidget】loadLottie show start");
                            if (iTimerAnimationListener != null) {
                                iTimerAnimationListener.onFinisedStatusAnimationStart();
                            }
                            TimerWidget.this.mImageView.setVisibility(8);
                            TaskDebugUtil.insertSpeedTimeLog("[onAnimationStart]");
                        }

                        public void onAnimationEnd(Animator animation) {
                            TaskDebugUtil.debugLog("【TimeWidget】loadLottie show end");
                            if (iTimerAnimationListener != null) {
                                TimerWidget.this.loadImage(i2);
                                TaskDebugUtil.debugLog("【TimeWidget】onFinisedStatusAnimationEnd");
                                iTimerAnimationListener.onFinisedStatusAnimationEnd();
                                TaskDebugUtil.insertSpeedTimeLog("[onAnimationEnd]");
                            }
                        }

                        public void onAnimationCancel(Animator animation) {
                            TaskDebugUtil.debugLog("【TimeWidget】loadLottie cancel end [isDetached]" + TimerWidget.this.isDetached);
                            if (iTimerAnimationListener != null && TimerWidget.this.isDetached) {
                                TaskDebugUtil.debugLog("【TimeWidget】onFinisedStatusAnimationEnd");
                                iTimerAnimationListener.onFinisedStatusAnimationEnd();
                            }
                        }

                        public void onAnimationRepeat(Animator animation) {
                        }
                    });
                    if (!TextUtils.isEmpty(str2)) {
                        TimerWidget.this.mLottieAnimationView.setImageAssetDelegate(new ImageAssetDelegate() {
                            public Bitmap fetchBitmap(LottieImageAsset asset) {
                                if (asset == null || TextUtils.isEmpty(asset.getFileName())) {
                                    return null;
                                }
                                return BitmapFactory.decodeFile(str2 + asset.getFileName());
                            }
                        });
                    } else {
                        TimerWidget.this.mLottieAnimationView.setImageAssetDelegate((ImageAssetDelegate) null);
                    }
                    TimerWidget.this.mLottieAnimationView.loop(z);
                    TimerWidget.this.mLottieAnimationView.setVisibility(0);
                    TimerWidget.this.mLottieAnimationView.playAnimation();
                }
            });
        }
    }

    private void getLottieInputStream(final String assetsFileName, final ICallback<InputStream> callback) {
        if (callback != null) {
            if (TextUtils.isEmpty(assetsFileName)) {
                callback.callback(null);
            } else {
                ExecutorUtilsExt.postOnElastic(new Runnable() {
                    public void run() {
                        synchronized (TimerWidget.this) {
                            InputStream inputStream = null;
                            try {
                                inputStream = new BufferedInputStream(new FileInputStream(assetsFileName), 4096);
                            } catch (FileNotFoundException e2) {
                                e2.printStackTrace();
                            }
                            final InputStream result = inputStream;
                            UiThreadUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    callback.callback(result);
                                }
                            });
                        }
                    }
                }, "load_timer_lottie_json_data", 0);
            }
        }
    }

    public void updateWithNightMode() {
        this.mRoundProgressBar.setCircleColor(AppRuntime.getAppContext().getResources().getColor(R.color.newtimer_normal_progressbar_circle_color));
        this.mRoundProgressBar.setCircleProgressColor(AppRuntime.getAppContext().getResources().getColor(R.color.newtimer_normal_progressbar_stroke_color));
        this.mProgressShadow.setInnerCircleColor(AppRuntime.getAppContext().getResources().getColor(R.color.newtimer_progress_shadow_color));
        updateImageWithNightMode();
        this.mScanningView.setLightImage(R.drawable.timer_widget_bottom_tips_shimmer_img);
        updateLottiePathWithNightMode();
        this.mBottomTips.setTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.newtimer_timer_widget_bottom_tips_color));
        this.mBottomScrollTips.setTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.newtimer_timer_widget_bottom_tips_color));
        this.mBottomTipsContainer.setBackground(FontSizeHelper.getScaledDrawable(TaskSizeTypeKt.getTaskSizeType(), AppRuntime.getAppContext().getResources().getDrawable(R.drawable.newtimer_normal_tips_bg_drawable)));
    }

    private void updateLottiePathWithNightMode() {
        TimerDataModel timerDataModel = this.mTimerDataModel;
        if (timerDataModel != null && this.mCurrentLottiePath != null) {
            if (timerDataModel.getTimerStatus() == TimerStatus.INITIALIZED) {
                updateLottieInitializedPathWithNightMode();
            } else if (this.mTimerDataModel.getTimerStatus() == TimerStatus.PROCESSING) {
                updateLottieProcessingPathWithNightMode();
            } else if (this.mTimerDataModel.getTimerStatus() == TimerStatus.FINISHED) {
                updateLottieFinishedPathWithNightMode();
            }
        }
    }

    private void updateImageWithNightMode() {
        TimerDataModel timerDataModel = this.mTimerDataModel;
        if (timerDataModel != null && this.mCurrentLottieImage != -1 && this.mImageView != null) {
            if (timerDataModel.getTimerStatus() == TimerStatus.INITIALIZED) {
                this.mImageView.setImageResource(R.drawable.timer_widget_initialized_placeholder);
            } else if (this.mTimerDataModel.getTimerStatus() == TimerStatus.PROCESSING) {
                this.mImageView.setImageResource(R.drawable.timer_widget_processing_placeholder);
            } else if (this.mTimerDataModel.getTimerStatus() == TimerStatus.FINISHED) {
                this.mImageView.setImageResource(R.drawable.timer_widget_processing_placeholder);
            }
        }
    }

    public void updateAnimator() {
        TaskDebugUtil.debugLog("【TimeWidget】updateAnimator , loadLottie");
        loadLottie(this.mCurrentLottieImage, this.mCurrentLottiePath, this.mCurrentLottieImgPath, false, new ITimerAnimationListener.Adapter() {
            public void onFinisedStatusAnimationStart() {
                BoxAccountManager accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
                if (accountManager != null) {
                    if (accountManager.isLogin(0) && RewardConfig.isStatusRunning(RewardTaskStatusManager.getInstance().getCurStatus())) {
                        TaskFloatShowManager.getInstance().setShowAnimLogin(true);
                    } else if (!accountManager.isLogin(0) && RewardTaskStatusManager.getInstance().getCurStatus() == 0) {
                        TaskFloatShowManager.getInstance().setShowAnimUnlogin(true);
                    }
                }
            }
        });
    }

    public void updateAnimator(boolean loop) {
        TaskDebugUtil.debugLog("【TimeWidget】updateAnimator  loop, loadLottie");
        loadLottie(this.mCurrentLottieImage, this.mCurrentLottiePath, this.mCurrentLottieImgPath, loop, (ITimerAnimationListener) null);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        TaskDebugUtil.debugLog("【TimeWidget】onVisibilityChanged");
        if (!isShown()) {
            TaskDebugUtil.debugLog("【TimeWidget】onVisibilityChanged 隐藏，取消动画");
            this.isDetached = true;
            cancelFinishedButtomAnim();
            return;
        }
        this.isDetached = false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (HomeComponentManager.INSTANCE.getNotLoginReceive() && !RedPacketAnimationHelper.INSTANCE.isAllAnimationFinished()) {
            updateTipsView(0);
            this.mBottomTips.setVisibility(0);
            this.mBottomScrollTips.setVisibility(8);
            RedPacketAnimationHelper.INSTANCE.setAllAnimationFinished(true);
        }
        this.isDetached = false;
        TaskDebugUtil.debugLog("【TimeWidget】onAttachedToWindow");
        TaskDebugUtil.insertSpeedTimeLog("[onAttachedToWindow]");
        BdEventBus.Companion.getDefault().register(this, TaskNotActiveRedPacketEvent.class, new TimerWidget$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onAttachedToWindow$1$com-baidu-searchbox-rewardsystem-newtimer-view-TimerWidget  reason: not valid java name */
    public /* synthetic */ void m2680lambda$onAttachedToWindow$1$combaidusearchboxrewardsystemnewtimerviewTimerWidget(TaskNotActiveRedPacketEvent taskNotActiveRedPacketEvent) {
        String redPacket = RewardTaskRepo.INSTANCE.getRedPacketText();
        if (!redPacket.isEmpty() && RewardTaskRepo.INSTANCE.getNeedShowRedPacketNotActive()) {
            UiThreadUtils.runOnUiThread(new TimerWidget$$ExternalSyntheticLambda1(this, redPacket));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isDetached = true;
        this.mCurrentLottiePath = "";
        this.mCurrentLottieImgPath = "";
        UiThreadUtils.getMainHandler().removeCallbacks(this.mTaskChangeBox2Normal);
        LottieAnimationView lottieAnimationView = this.mLottieAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        clearBoxStatus();
        TaskDebugUtil.debugLog("【TimeWidget】onDetachedFromWindow");
        cancelFinishedButtomAnim();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void updateProgressView(int visibility) {
        RoundProgressBar roundProgressBar = this.mRoundProgressBar;
        if (roundProgressBar != null) {
            roundProgressBar.setVisibility(visibility);
        }
    }

    public void updateTipsView(int visibility) {
        FrameLayout frameLayout = this.mBottomTipsContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(visibility);
            this.mBottomTips.setVisibility(visibility);
            this.mBottomScrollTips.setVisibility(visibility);
        }
    }

    /* renamed from: updateTipsText */
    public void m2679lambda$onAttachedToWindow$0$combaidusearchboxrewardsystemnewtimerviewTimerWidget(String text) {
        if (text != null) {
            this.mBottomTips.setText(text);
        }
    }

    private void updateLottieInitializedPathWithNightMode() {
        this.mCurrentLottiePath = TimerResManagerKt.getInitializedRes(NightModeHelper.isNightMode());
        this.mCurrentLottieImgPath = "";
    }

    private void updateLottieProcessingPathWithNightMode() {
        this.mCurrentLottiePath = TimerResManagerKt.getProcessingRes(NightModeHelper.isNightMode());
        this.mCurrentLottieImgPath = "";
    }

    private void updateLottieFinishedPathWithNightMode() {
        this.mCurrentLottiePath = TimerResManagerKt.getFinishedRes(NightModeHelper.isNightMode());
        this.mCurrentLottieImgPath = "";
    }

    private void updateLottieTreasureBoxPathWithNightMode() {
        this.mCurrentLottiePath = TimerResManagerKt.getBoxRes(NightModeHelper.isNightMode());
        this.mCurrentLottieImgPath = TimerResManagerKt.getBoxImgResDir();
    }

    private void updateRootViewParam(boolean isInit) {
        int height;
        ViewGroup.LayoutParams params = this.mRootView.getLayoutParams();
        if (isInit) {
            height = (int) FontSizeHelper.getScaledSize(TaskSizeTypeKt.getTaskSizeType(), (float) HEIGHT_INIT);
        } else {
            height = (int) FontSizeHelper.getScaledSize(TaskSizeTypeKt.getTaskSizeType(), (float) HEIGHT_NORMAL);
        }
        if (height != params.height) {
            params.height = height;
            this.mRootView.setLayoutParams(params);
        }
    }

    public void processInitialized(TimerDataModel timerData) {
        this.mTimerDataModel = timerData;
        TaskFloatShowManager.getInstance().setShowAnimLogin(false);
        updateLottieInitializedPathWithNightMode();
        updateProgressView(4);
        updateProgressShadowView(4);
        if ((isShown() || !this.isDetached) && !TaskFloatShowManager.getInstance().isShowAnimUnlogin()) {
            TaskDebugUtil.debugLog("【TimeWidget】processInitialized is show, loadLottie");
            loadLottie(R.drawable.timer_widget_initialized_placeholder, this.mCurrentLottiePath, this.mCurrentLottieImgPath, false, new ITimerAnimationListener() {
                public void onFinisedStatusAnimationStart() {
                    TaskFloatShowManager.getInstance().setShowAnimUnlogin(true);
                }

                public void onFinisedStatusAnimationEnd() {
                }
            });
        } else {
            TaskDebugUtil.debugLog("【TimeWidget】processInitialized is not show, loadImage");
            loadImage(R.drawable.timer_widget_initialized_placeholder);
        }
        updateRootViewParam(true);
        String bottomTips = timerData.getTimerBottomTips();
        if (HomeComponentManager.INSTANCE.getNotLoginReceive()) {
            m2679lambda$onAttachedToWindow$0$combaidusearchboxrewardsystemnewtimerviewTimerWidget(HomeComponentManager.INSTANCE.getAmount() + getResources().getString(R.string.money_unit_yuan));
            updateTipsView(0);
            this.mBottomTips.setVisibility(0);
            this.mBottomScrollTips.setVisibility(8);
            if (this.mBusinessType == BusinessType.TYPE_HOME) {
                RedPacketAnimationHelper.INSTANCE.startFirstAnimation(this.mBottomTipsContainer, this.mBottomTips, this.mBottomScrollTips, this.mScanningView);
            }
        } else if (TextUtils.isEmpty(bottomTips)) {
            updateTipsView(8);
        } else {
            updateTipsView(0);
            this.mBottomTips.setVisibility(0);
            this.mBottomScrollTips.setVisibility(8);
            m2679lambda$onAttachedToWindow$0$combaidusearchboxrewardsystemnewtimerviewTimerWidget(bottomTips);
        }
    }

    public void processTiming(TimerDataModel timerData) {
        this.mTimerDataModel = timerData;
        updateLottieProcessingPathWithNightMode();
        setPercent(Float.valueOf(timerData.getTimerProcess()));
        updateProgressView(0);
        updateProgressShadowView(0);
        TaskDebugUtil.debugLog("【TimeWidget】processTiming is show, loadLottie isShown:" + isShown() + ", isDetached:" + this.isDetached + ", isShowAnimLogin:" + TaskFloatShowManager.getInstance().isShowAnimLogin());
        if ((isShown() || !this.isDetached) && !TaskFloatShowManager.getInstance().isShowAnimLogin()) {
            TaskDebugUtil.debugLog("【TimeWidget】processTiming is show, loadLottie");
            loadLottie(R.drawable.timer_widget_processing_placeholder, this.mCurrentLottiePath, this.mCurrentLottieImgPath, false, new ITimerAnimationListener.Adapter() {
                public void onFinisedStatusAnimationStart() {
                    TaskFloatShowManager.getInstance().setShowAnimLogin(true);
                }
            });
        } else {
            TaskDebugUtil.debugLog("【TimeWidget】processTiming is not show, loadImage");
            loadImage(R.drawable.timer_widget_processing_placeholder);
        }
        updateRootViewParam(false);
        if (!this.isBottomTipsAnimating.booleanValue() && !this.isShowTxtCountDown.booleanValue() && !this.isShowingTreasureBox) {
            updateTipsView(0);
            String bottomTips = timerData.getTimerBottomTips();
            this.mBottomTips.setVisibility(0);
            this.mBottomScrollTips.setVisibility(8);
            m2679lambda$onAttachedToWindow$0$combaidusearchboxrewardsystemnewtimerviewTimerWidget(bottomTips);
        }
    }

    public void processTiming(float percent) {
        TimerDataModel timerDataModel = this.mTimerDataModel;
        if (timerDataModel != null && timerDataModel.getTimerStatus() == TimerStatus.PROCESSING) {
            updateLottieProcessingPathWithNightMode();
            setPercent(Float.valueOf(percent));
            updateProgressView(0);
            updateProgressShadowView(0);
            if (isShown() && !TaskFloatShowManager.getInstance().isShowAnimLogin()) {
                loadLottie(R.drawable.timer_widget_processing_placeholder, this.mCurrentLottiePath, this.mCurrentLottieImgPath, false, new ITimerAnimationListener.Adapter() {
                    public void onFinisedStatusAnimationStart() {
                        TaskFloatShowManager.getInstance().setShowAnimLogin(true);
                    }
                });
            }
            updateRootViewParam(false);
            if (!this.isBottomTipsAnimating.booleanValue() && !this.isShowTxtCountDown.booleanValue() && !this.isShowingTreasureBox) {
                updateTipsView(0);
                this.mBottomScrollTips.setVisibility(8);
            }
        }
    }

    public void processLoginNotActive(TimerDataModel timerData) {
        this.mTimerDataModel = timerData;
        updateLottieProcessingPathWithNightMode();
        setPercent(Float.valueOf(timerData.getTimerProcess()));
        updateProgressView(0);
        updateProgressShadowView(0);
        TaskDebugUtil.debugLog("【TimeWidget】processTiming is not show, loadImage");
        loadImage(R.drawable.timer_widget_processing_placeholder);
        updateRootViewParam(false);
        if (!this.isShowTxtCountDown.booleanValue() && !this.isShowingTreasureBox) {
            updateTipsView(0);
            String bottomTips = timerData.getTimerBottomTips();
            String redPacket = RewardTaskRepo.INSTANCE.getRedPacketText();
            this.mBottomTips.setVisibility(0);
            this.mBottomScrollTips.setVisibility(8);
            if (redPacket.isEmpty() || !RewardTaskRepo.INSTANCE.getNeedShowRedPacketNotActive()) {
                m2679lambda$onAttachedToWindow$0$combaidusearchboxrewardsystemnewtimerviewTimerWidget(bottomTips);
            } else {
                m2679lambda$onAttachedToWindow$0$combaidusearchboxrewardsystemnewtimerviewTimerWidget(redPacket);
            }
        }
    }

    public boolean processFinished(TimerDataModel timerData, ITimerAnimationListener timerAnimationListener) {
        updateRootViewParam(false);
        this.mTimerDataModel = timerData;
        updateLottieFinishedPathWithNightMode();
        if (timerData.getTimerFinishedShowProgressbar()) {
            setPercent(Float.valueOf(1.0f));
            updateProgressView(0);
            updateProgressShadowView(0);
        } else {
            updateProgressView(8);
            updateProgressShadowView(8);
        }
        if (!timerData.getTimerFinishedAnimationEnabled()) {
            loadImage(R.drawable.timer_widget_processing_placeholder);
            return false;
        } else if (!isShown() || !this.isShowAnimator) {
            if (timerAnimationListener != null) {
                timerAnimationListener.onFinisedStatusAnimationEnd();
            }
            return false;
        } else {
            loadLottie(R.drawable.timer_widget_processing_placeholder, this.mCurrentLottiePath, this.mCurrentLottieImgPath, false, timerAnimationListener);
            return true;
        }
    }

    public void playFinishedButtomAnim(final TimerDataModel timerData) {
        if (timerData != null && timerData.getTipsViewBean() != null) {
            if ("coin".equals(((TipsViewBean) Objects.requireNonNull(timerData.getTipsViewBean())).mToastType) || "money".equals(timerData.getTipsViewBean().mToastType)) {
                TaskDebugUtil.debugLog("【TimeWidget】[playFinishedButtomAnim] mBottomScrollTips mAssetTotalPre：" + timerData.getTipsViewBean().mAssetTotalPre);
                this.isBottomTipsAnimating = true;
                resizeViewWidth(timerData);
                updateUnitFlag(timerData.getTipsViewBean().mAssetTotal + getResources().getString(R.string.multiple_timer_tips));
                this.mBottomScrollTips.setText(timerData.getTipsViewBean().mAssetTotalPre + getBottomTipsUnit(timerData, this.mHideUnit));
                resizeBottomTips();
                TaskDebugUtil.debugLog("【TimeWidget】[playFinishedButtomAnim] 计时完成底部btn动画开始 ——>");
                RedPacketAnimationHelper.INSTANCE.scrollTextAnimation(this.mBottomTipsContainer, this.mBottomTips, this.mBottomScrollTips, 0, 240, new ITimerButtomAnimationListener());
                this.mBottomScrollTips.postDelayed(new Runnable() {
                    public void run() {
                        TimerWidget.this.playButtomTipChangeAnim(timerData);
                    }
                }, 3000);
                this.mBottomScrollTips.postDelayed(new Runnable() {
                    public void run() {
                        TextView access$500 = TimerWidget.this.mBottomScrollTips;
                        StringBuilder append = new StringBuilder().append(timerData.getTipsViewBean().mAssetTotal);
                        TimerWidget timerWidget = TimerWidget.this;
                        access$500.setText(append.append(timerWidget.getBottomTipsUnit(timerData, timerWidget.mHideUnit)).toString());
                        TimerWidget.this.mBottomTips.setText(RewardConfig.getBottomTips());
                        TimerWidget.this.resizeBottomTips();
                        TaskDebugUtil.debugLog("【TimeWidget】[playFinishedButtomAnim] 第二次滚动开始 mBottomTips：" + RewardConfig.getBottomTips() + " ——>");
                        RedPacketAnimationHelper.INSTANCE.scrollTextAnimation(TimerWidget.this.mBottomTipsContainer, TimerWidget.this.mBottomScrollTips, TimerWidget.this.mBottomTips, 0, 240, new ITimerButtomAnimationListener() {
                            public void onAnimationEnd(Animation animation) {
                                TaskDebugUtil.debugLog("【TimeWidget】[playFinishedButtomAnim] 第二次滚动结束 <——");
                                TimerWidget.this.mBottomTips.setVisibility(0);
                                TimerWidget.this.mBottomScrollTips.setVisibility(8);
                                TimerWidget.this.cancelFinishedButtomAnim();
                                FontSizeViewExtKt.setScaledWidth(TimerWidget.this, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size));
                            }
                        });
                    }
                }, 5000);
            }
        }
    }

    public void resizeViewWidth(TimerDataModel timerData) {
        if (timerData != null && timerData.getTipsViewBean() != null) {
            String assetTotal = timerData.getTipsViewBean().mAssetTotal + getBottomTipsUnit(timerData, this.mHideUnit);
            TaskDebugUtil.debugLog("【TimeWidget】[resizeViewWidth] assetTotal: " + assetTotal + ", length:" + assetTotal.length());
            if (assetTotal.length() >= 7) {
                FontSizeViewExtKt.setScaledWidth(this, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size_max));
            } else {
                FontSizeViewExtKt.setScaledWidth(this, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size));
            }
        }
    }

    private void updateUnitFlag(String content) {
        ViewGroup.LayoutParams params;
        if (!this.mHideUnit && (params = getLayoutParams()) != null && params.width > 0) {
            this.mHideUnit = (this.mBottomScrollTips.getPaint().measureText(content) + ((float) this.mBottomTipsContainer.getPaddingLeft())) + ((float) this.mBottomTipsContainer.getPaddingRight()) > ((float) params.width);
        }
    }

    /* access modifiers changed from: private */
    public void playButtomTipChangeAnim(TimerDataModel timerData) {
        if (timerData != null && timerData.getTipsViewBean() != null) {
            TaskDebugUtil.debugLog("【TimeWidget】[playButtomTipChangeAnim] 金额变动");
            ViewGroup.LayoutParams layoutParams = this.mBottomScrollTips.getLayoutParams();
            try {
                float preF = Float.parseFloat(timerData.getTipsViewBean().mAssetTotalPre);
                float diff = Float.parseFloat(timerData.getTipsViewBean().mAssetTotal) - preF;
                for (int i2 = 1; i2 <= 5; i2++) {
                    final int finalI = i2;
                    final float f2 = preF;
                    final float f3 = diff;
                    final TimerDataModel timerDataModel = timerData;
                    final ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    this.mBottomScrollTips.postDelayed(new Runnable() {
                        public void run() {
                            try {
                                StringBuilder append = new StringBuilder().append((int) (f2 + ((f3 / 5.0f) * ((float) finalI))));
                                TimerWidget timerWidget = TimerWidget.this;
                                String finalText = append.append(timerWidget.getBottomTipsUnit(timerDataModel, timerWidget.mHideUnit)).toString();
                                if ("money".equals(((TipsViewBean) Objects.requireNonNull(timerDataModel.getTipsViewBean())).mToastType)) {
                                    StringBuilder append2 = new StringBuilder().append(Float.parseFloat(new DecimalFormat("0.00").format((double) (((float) (((((int) (f3 * 100.0f)) / 5) * finalI) + ((int) (f2 * 100.0f)))) / 100.0f))));
                                    TimerWidget timerWidget2 = TimerWidget.this;
                                    finalText = append2.append(timerWidget2.getBottomTipsUnit(timerDataModel, timerWidget2.mHideUnit)).toString();
                                }
                                if (finalI == 5) {
                                    StringBuilder append3 = new StringBuilder().append(timerDataModel.getTipsViewBean().mAssetTotal);
                                    TimerWidget timerWidget3 = TimerWidget.this;
                                    finalText = append3.append(timerWidget3.getBottomTipsUnit(timerDataModel, timerWidget3.mHideUnit)).toString();
                                }
                                TimerWidget.this.mBottomScrollTips.setText(finalText);
                                TimerWidget.this.mBottomScrollTips.setLayoutParams(layoutParams2);
                                TaskDebugUtil.debugLog("【TimeWidget】[playButtomTipChangeAnim] 金额变动 ——>" + finalText);
                            } catch (NumberFormatException e2) {
                            }
                        }
                    }, (long) (i2 * 50));
                }
            } catch (NumberFormatException e2) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void cancelFinishedButtomAnim() {
        TextView textView = this.mBottomTips;
        if (textView != null) {
            textView.clearAnimation();
        }
        TextView textView2 = this.mBottomScrollTips;
        if (textView2 != null) {
            textView2.clearAnimation();
        }
        this.isBottomTipsAnimating = false;
    }

    public void destroy() {
        LottieAnimationView lottieAnimationView = this.mLottieAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
    }

    private void parseAttrs(AttributeSet attrs) {
        TypedArray typedArray = AppRuntime.getAppContext().obtainStyledAttributes(attrs, R.styleable.TimerWidget);
        this.mCountdownWidgetType = typedArray.getInteger(R.styleable.TimerWidget_widgetType, 0);
        typedArray.recycle();
    }

    public void updateProgressShadowView(int visibility) {
        if (this.mProgressShadow != null) {
            if (this.mTimerDataModel.getTimerProgressShadowEnabled()) {
                this.mProgressShadow.setVisibility(visibility);
                this.mProgressShadow.setAlpha(0.8f);
                return;
            }
            this.mProgressShadow.setVisibility(4);
        }
    }

    public void onTick(Long remainTimeMillis) {
        if (enterTickStatus() && remainTimeMillis.longValue() > 0 && remainTimeMillis.longValue() / 1000 != this.mRemainTimeLast.longValue() / 1000) {
            try {
                this.mRemainTimeLast = remainTimeMillis;
                this.mBottomTips.setText(this.mDateFormatter.format(Long.valueOf((long) (Math.ceil((double) (((float) remainTimeMillis.longValue()) / 1000.0f)) * 1000.0d))));
            } catch (Exception e2) {
                TaskDebugUtil.debugLog("【TimeWidget】[onTick] TimeFormat Exception: " + e2.getMessage());
            }
        }
    }

    private boolean enterTickStatus() {
        if (!this.isShowTxtCountDown.booleanValue()) {
            return false;
        }
        if (!(this.mBottomTipsContainer.getVisibility() == 0 && this.mBottomTips.getVisibility() == 0)) {
            this.mBottomTipsContainer.setVisibility(0);
            this.mBottomTips.setVisibility(0);
            this.mBottomScrollTips.setVisibility(8);
        }
        if (this.mDateFormatter != null) {
            return true;
        }
        this.mDateFormatter = new SimpleDateFormat("mm:ss", Locale.CHINA);
        return true;
    }

    public void setShowTxtCountDown(Boolean showTxtCountDown) {
        this.isShowTxtCountDown = showTxtCountDown;
        if (showTxtCountDown.booleanValue()) {
            updateTipsView(8);
            enterTickStatus();
            this.mBottomTips.setText(R.string.normal_timer_txt_count_down_default);
        }
    }

    public boolean isShowTxtCountDown() {
        return this.isShowTxtCountDown.booleanValue();
    }

    public View getToastAnchorView() {
        return this.mRoundProgressBar;
    }

    public void showTreasureBox(String boxShowBottomText, long boxShowDurationMillis, Runnable doOnBoxHide) {
        this.isShowingTreasureBox = true;
        this.mBoxShowBottomText = boxShowBottomText;
        this.mActionDoOnBoxHide = doOnBoxHide;
        if (boxShowDurationMillis < 0) {
            boxShowDurationMillis = 0;
        }
        updateLottieTreasureBoxPathWithNightMode();
        loadLottie(R.drawable.timer_widget_processing_placeholder, this.mCurrentLottiePath, this.mCurrentLottieImgPath, false, (ITimerAnimationListener) null);
        updateTipsView(0);
        this.mBottomScrollTips.setText(this.mBoxShowBottomText);
        resizeBottomTips();
        RedPacketAnimationHelper.INSTANCE.scrollTextAnimation(this.mBottomTipsContainer, this.mBottomTips, this.mBottomScrollTips, 0, 240, new ITimerButtomAnimationListener() {
            public void onAnimationEnd(Animation animation) {
                TimerWidget.this.mBottomTips.setVisibility(8);
                TimerWidget.this.mBottomScrollTips.setVisibility(0);
                FontSizeViewExtKt.setScaledWidth(TimerWidget.this, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size));
            }
        });
        UiThreadUtils.getMainHandler().postDelayed(this.mTaskChangeBox2Normal, boxShowDurationMillis);
    }

    public void changeBox2Normal() {
        this.isShowingTreasureBox = false;
        this.mBoxShowBottomText = null;
        Runnable runnable = this.mActionDoOnBoxHide;
        if (runnable != null) {
            runnable.run();
        }
        this.mActionDoOnBoxHide = null;
        updateTipsView(0);
        this.mBottomTips.setText(RewardConfig.getBottomTips());
        resizeBottomTips();
        RedPacketAnimationHelper.INSTANCE.scrollTextAnimation(this.mBottomTipsContainer, this.mBottomScrollTips, this.mBottomTips, 0, 240, new ITimerButtomAnimationListener() {
            public void onAnimationEnd(Animation animation) {
                TimerWidget.this.mBottomTips.setVisibility(0);
                TimerWidget.this.mBottomScrollTips.setVisibility(8);
                FontSizeViewExtKt.setScaledWidth(TimerWidget.this, TaskSizeTypeKt.getTaskSizeType(), (float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.normal_timer_widget_size));
            }
        });
        UiThreadUtils.getMainHandler().removeCallbacks(this.mTaskChangeBox2Normal);
        loadImage(R.drawable.timer_widget_processing_placeholder);
    }

    private void clearBoxStatus() {
        if (this.isShowingTreasureBox) {
            this.isShowingTreasureBox = false;
            this.mBoxShowBottomText = null;
            this.mActionDoOnBoxHide = null;
            this.mBottomTips.setVisibility(0);
            this.mBottomScrollTips.setVisibility(8);
            loadImage(R.drawable.timer_widget_processing_placeholder);
        }
    }
}
