package com.baidu.searchbox.ad.lp.reward.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.InputMethodController;
import com.baidu.searchbox.ad.dazzle.view.ExpandIconView;
import com.baidu.searchbox.ad.lightbrowser.IBrowserInjector;
import com.baidu.searchbox.ad.lp.reward.R;
import com.baidu.searchbox.ad.reward.data.AdMonitorUrl;
import com.baidu.searchbox.ad.tailframe.ILandingPageInjector;
import com.baidu.searchbox.ad.tailframe.ILandingPageStatusChangeListener;
import com.baidu.searchbox.ad.util.AdUtilsKt;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.net.ParallelCharge;
import com.baidu.searchbox.home.feed.WebViewContainer;
import com.baidu.searchbox.lightbrowser.container.base.IFrameContext;
import java.util.List;

public class NadRewardLandingPage extends FrameLayout implements IBrowserInjector, ILandingPageInjector {
    private ExpandIconView mArrowView;
    private int mBaseBottomMargin;
    /* access modifiers changed from: private */
    public View.OnClickListener mBlankClickListener;
    private List<AdMonitorUrl> mCharge;
    /* access modifiers changed from: private */
    public String mExt;
    /* access modifiers changed from: private */
    public int mMaxTopMargin;
    /* access modifiers changed from: private */
    public int mMinTopMargin;
    private String mOpenUrl;
    /* access modifiers changed from: private */
    public String mPage;
    private ValueAnimator mScrollAnimator;
    private WebViewContainer.OnScrollChangedCallback mScrollCallback;
    /* access modifiers changed from: private */
    public WebViewContainer mScrollContainer;
    /* access modifiers changed from: private */
    public int mScrollThreshold;
    private ILandingPageStatusChangeListener mStateListener;
    /* access modifiers changed from: private */
    public RewardWebViewContainer mWebViewContainer;
    private WebViewContainer.OnUpListener onUpListener;

    public NadRewardLandingPage(Context context) {
        this(context, (AttributeSet) null);
    }

    public NadRewardLandingPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NadRewardLandingPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mBaseBottomMargin = 0;
        this.onUpListener = new WebViewContainer.OnUpListener() {
            public void onUp(boolean scrollUp) {
                if (NadRewardLandingPage.this.mScrollContainer != null) {
                    boolean isScrollDown = true;
                    if (!scrollUp) {
                        int touchSlop = ViewConfiguration.get(NadRewardLandingPage.this.getContext()).getScaledTouchSlop();
                        int distance = NadRewardLandingPage.this.mScrollContainer.getTopMargin() - NadRewardLandingPage.this.mMinTopMargin;
                        if (distance > touchSlop) {
                            if (distance <= NadRewardLandingPage.this.mScrollThreshold) {
                                isScrollDown = false;
                            }
                        } else {
                            return;
                        }
                    } else if (NadRewardLandingPage.this.mScrollContainer.getTopMargin() != NadRewardLandingPage.this.mMinTopMargin) {
                        if (NadRewardLandingPage.this.mMaxTopMargin - NadRewardLandingPage.this.mScrollContainer.getTopMargin() >= NadRewardLandingPage.this.mScrollThreshold) {
                            isScrollDown = false;
                        }
                    } else {
                        return;
                    }
                    NadRewardLandingPage.this.handleStateChange(isScrollDown);
                }
            }
        };
        this.mScrollCallback = new WebViewContainer.OnScrollChangedCallback() {
            public void onScroll(int dx, int dy) {
                NadRewardLandingPage.this.updateArrow((((float) (NadRewardLandingPage.this.mScrollContainer.getTopMargin() - NadRewardLandingPage.this.mMinTopMargin)) * 1.0f) / ((float) (NadRewardLandingPage.this.mMaxTopMargin - NadRewardLandingPage.this.mMinTopMargin)));
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ad_video_arrow_view, this);
        this.mMinTopMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 47.0f);
        this.mScrollThreshold = DeviceUtils.ScreenInfo.dp2px(getContext(), 43.0f);
        this.mMaxTopMargin = (DeviceUtils.ScreenInfo.getRealScreenHeight(getContext()) - DeviceUtils.ScreenInfo.getStatusBarHeight()) - this.mMinTopMargin;
        if (Build.VERSION.SDK_INT >= 21 && (getContext() instanceof Activity) && AdUtilsKt.isNavBarVisible(((Activity) getContext()).getWindow(), getContext())) {
            this.mMaxTopMargin -= DeviceUtils.ScreenInfo.getNavigationBarHeight();
        }
        initArrowView();
        initScrollContainer();
        initWebView();
    }

    private void initArrowView() {
        ExpandIconView expandIconView = (ExpandIconView) findViewById(R.id.arrow_image);
        this.mArrowView = expandIconView;
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) expandIconView.getLayoutParams();
        params.topMargin = this.mMaxTopMargin - getArrowMarginByPos(1.0f);
        params.bottomMargin = getArrowMarginByPos(1.0f);
        this.mArrowView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (NadRewardLandingPage.this.mScrollContainer != null && NadRewardLandingPage.this.mScrollContainer.getVisibility() == 8) {
                    NadRewardLandingPage.this.startLoad();
                    Als.postADRealTimeLog(new Als.Builder().setType(Als.LogType.CLICK).setPage(NadRewardLandingPage.this.mPage).setExtraParam(NadRewardLandingPage.this.mExt).setArea(Als.Area.ARROW));
                    NadRewardLandingPage.this.tryCharge();
                }
            }
        });
        this.mArrowView.setState(1, true);
        this.mArrowView.bringToFront();
    }

    /* access modifiers changed from: private */
    public void tryCharge() {
        ParallelCharge.clickCharge(this.mCharge);
    }

    /* access modifiers changed from: private */
    public void updateArrow(float fraction) {
        if (this.mArrowView != null) {
            float fraction2 = Math.min(fraction, 1.0f);
            this.mArrowView.setFraction(fraction2, false);
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this.mArrowView.getLayoutParams();
            params.bottomMargin = (this.mMaxTopMargin - this.mScrollContainer.getTopMargin()) + getArrowMarginByPos(fraction2) + this.mBaseBottomMargin;
            this.mArrowView.setLayoutParams(params);
        }
    }

    private int getArrowMarginByPos(float fraction) {
        return DeviceUtils.ScreenInfo.dp2px(getContext(), (7.0f * fraction) - 2.0f);
    }

    private void initScrollContainer() {
        WebViewContainer webViewContainer = new WebViewContainer(getContext());
        this.mScrollContainer = webViewContainer;
        webViewContainer.setClipChildren(false);
        this.mScrollContainer.setLayerType(2, (Paint) null);
        this.mScrollContainer.setStyle(3);
        this.mScrollContainer.setTopLimit(this.mMaxTopMargin);
        this.mScrollContainer.setTopMargin(this.mMaxTopMargin);
        this.mScrollContainer.setMinTopMargin(this.mMinTopMargin);
        this.mScrollContainer.setOnScrollChangeListener(this.mScrollCallback);
        this.mScrollContainer.setOnUpListener(this.onUpListener);
        this.mScrollContainer.setHandleTopYMove(true);
        this.mScrollContainer.setInterceptScrollLister(new WebViewContainer.InterceptScrollLister() {
            public boolean isInterceptParentScroll() {
                return NadRewardLandingPage.this.mWebViewContainer.shouldInterceptScroll();
            }
        });
        this.mScrollContainer.setMinFlingVelocity(1000);
        this.mScrollContainer.setUpYVelocityRatio(3.5f);
        this.mScrollContainer.setInterceptFlingListener(new WebViewContainer.InterceptFlingListener() {
            public boolean interceptFling(boolean scrollUp) {
                NadRewardLandingPage.this.handleStateChange(!scrollUp);
                return true;
            }
        });
        this.mScrollContainer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (NadRewardLandingPage.this.mBlankClickListener != null) {
                    NadRewardLandingPage.this.mBlankClickListener.onClick(v);
                }
                Als.postADRealTimeLog(new Als.Builder().setType(Als.LogType.FREE_Click).setPage(NadRewardLandingPage.this.mPage).setExtraParam(NadRewardLandingPage.this.mExt).setArea(Als.Area.AD_BLANK));
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        setClipChildren(false);
        addView(this.mScrollContainer, layoutParams);
    }

    public void setBaseBottomMargin(int margin) {
        this.mBaseBottomMargin = margin;
    }

    public void setArrowViewVisible(boolean visible) {
        ExpandIconView expandIconView = this.mArrowView;
        if (expandIconView != null) {
            expandIconView.setVisibility(visible ? 0 : 8);
        }
    }

    public void setVisibility(int visibility) {
        WebViewContainer webViewContainer = this.mScrollContainer;
        if (webViewContainer != null) {
            webViewContainer.setVisibility(visibility);
        } else {
            super.setVisibility(visibility);
        }
    }

    private void initWebView() {
        this.mWebViewContainer = new RewardWebViewContainer(getContext());
        this.mScrollContainer.addView(this.mWebViewContainer, new FrameLayout.LayoutParams(-1, -1));
        this.mScrollContainer.scrollTo(0, -this.mMaxTopMargin);
        if (getContext() instanceof IFrameContext) {
            this.mWebViewContainer.setIFrameContext((IFrameContext) getContext());
        }
    }

    public void setData(String ext, String page, List<AdMonitorUrl> urls) {
        this.mExt = ext;
        this.mPage = page;
        this.mCharge = urls;
    }

    public void setMaxTopMargin(int margin) {
        this.mMaxTopMargin = margin;
        this.mScrollContainer.setTopLimit(margin);
        this.mScrollContainer.setTopMargin(margin);
    }

    public void setMinTopMargin(int margin) {
        this.mMinTopMargin = margin;
        this.mScrollContainer.setMinTopMargin(margin);
    }

    public void handleStateChange(boolean toHalf) {
        if (this.mMinTopMargin > 0 && this.mScrollContainer != null) {
            moveViewWithAnim(toHalf);
        }
    }

    private void moveViewWithAnim(final boolean toHalf) {
        if (this.mScrollContainer != null && !isScrollAnimatorRunning()) {
            cancelScrollAnimator();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.mScrollAnimator = ofFloat;
            ofFloat.setDuration(100);
            this.mScrollAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            this.mScrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(toHalf) {
                float lastAnimValue = 0.0f;
                int preWebContainerTopMargin;
                final int scrollDistance;
                final int scrollDistanceDown;
                final int scrollDistanceUp;
                final /* synthetic */ boolean val$toHalf;

                {
                    this.val$toHalf = r5;
                    int access$200 = NadRewardLandingPage.this.mMaxTopMargin - NadRewardLandingPage.this.mScrollContainer.getTopMargin();
                    this.scrollDistanceDown = access$200;
                    int topMargin = NadRewardLandingPage.this.mScrollContainer.getTopMargin() - NadRewardLandingPage.this.mMinTopMargin;
                    this.scrollDistanceUp = topMargin;
                    this.scrollDistance = !r5 ? topMargin : access$200;
                    this.preWebContainerTopMargin = NadRewardLandingPage.this.mScrollContainer.getTopMargin();
                }

                public void onAnimationUpdate(ValueAnimator animation) {
                    if (NadRewardLandingPage.this.mScrollContainer != null && animation != null) {
                        float value = ((Float) animation.getAnimatedValue()).floatValue();
                        int preScrollDistance = (int) (((float) this.scrollDistance) * (value - this.lastAnimValue));
                        if (this.val$toHalf) {
                            preScrollDistance = -preScrollDistance;
                        }
                        this.preWebContainerTopMargin -= preScrollDistance;
                        NadRewardLandingPage.this.mScrollContainer.scrollBy(0, preScrollDistance);
                        NadRewardLandingPage.this.mScrollContainer.setTopMargin(this.preWebContainerTopMargin);
                        this.lastAnimValue = value;
                    }
                }
            });
            this.mScrollAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    if (NadRewardLandingPage.this.mScrollContainer != null) {
                        NadRewardLandingPage.this.handleScrollAnimateEnd(toHalf);
                    }
                }
            });
            this.mScrollAnimator.start();
        }
    }

    private boolean isScrollAnimatorRunning() {
        ValueAnimator valueAnimator = this.mScrollAnimator;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    private void cancelScrollAnimator() {
        ValueAnimator valueAnimator = this.mScrollAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* access modifiers changed from: private */
    public void handleScrollAnimateEnd(boolean toHalf) {
        if (this.mScrollContainer != null) {
            if (toHalf) {
                this.mWebViewContainer.onPause();
                this.mScrollContainer.scrollTo(0, -this.mMaxTopMargin);
                this.mScrollContainer.setTopMargin(this.mMaxTopMargin);
                this.mScrollContainer.setVisibility(8);
                updateArrow(1.0f);
                Als.postADRealTimeLog(new Als.Builder().setType(Als.LogType.REWARD_HALF_TAIL_SLIDE).setPage(Als.Page.WELFAREWEB).setExtraParam(this.mExt));
                ILandingPageStatusChangeListener iLandingPageStatusChangeListener = this.mStateListener;
                if (iLandingPageStatusChangeListener != null) {
                    iLandingPageStatusChangeListener.onDismiss();
                    return;
                }
                return;
            }
            this.mWebViewContainer.onResume();
            Als.postADRealTimeLog(new Als.Builder().setType(Als.LogType.FREE_SHOW).setPage(Als.Page.WELFAREWEB).setExtraParam(this.mExt));
            this.mScrollContainer.scrollTo(0, -this.mMinTopMargin);
            this.mScrollContainer.setTopMargin(this.mMinTopMargin);
            this.mScrollContainer.setVisibility(0);
            hideInputMethod();
            updateArrow(0.0f);
            ILandingPageStatusChangeListener iLandingPageStatusChangeListener2 = this.mStateListener;
            if (iLandingPageStatusChangeListener2 != null) {
                iLandingPageStatusChangeListener2.onShow();
            }
        }
    }

    private void hideInputMethod() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(InputMethodController.BUTTON_INPUT_METHOD);
        if (imm != null && imm.isActive()) {
            imm.hideSoftInputFromWindow(this.mScrollContainer.getApplicationWindowToken(), 0);
        }
    }

    public void setStatusChangeListener(ILandingPageStatusChangeListener listener) {
        this.mStateListener = listener;
    }

    public boolean consumeBackPress() {
        WebViewContainer webViewContainer = this.mScrollContainer;
        if (webViewContainer == null || webViewContainer.getVisibility() != 0) {
            return false;
        }
        handleStateChange(true);
        return true;
    }

    public void setOpenUrl(String url) {
        this.mOpenUrl = url;
    }

    public void startLoad() {
        RewardWebViewContainer rewardWebViewContainer;
        if (!TextUtils.isEmpty(this.mOpenUrl) && (rewardWebViewContainer = this.mWebViewContainer) != null && this.mScrollContainer != null) {
            rewardWebViewContainer.startLoad(this.mOpenUrl);
            this.mScrollContainer.setVisibility(0);
            handleStateChange(false);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onPostCreate(Bundle savedInstanceState) {
    }

    public void onAttachedToWindow() {
        RewardWebViewContainer rewardWebViewContainer;
        super.onAttachedToWindow();
        if (getVisibility() == 0 && (rewardWebViewContainer = this.mWebViewContainer) != null) {
            rewardWebViewContainer.onAttachedToWindow();
        }
    }

    public void onStart() {
        RewardWebViewContainer rewardWebViewContainer;
        if (getVisibility() == 0 && (rewardWebViewContainer = this.mWebViewContainer) != null) {
            rewardWebViewContainer.onStart();
        }
    }

    public void onResume() {
        RewardWebViewContainer rewardWebViewContainer;
        if (getVisibility() == 0 && (rewardWebViewContainer = this.mWebViewContainer) != null) {
            rewardWebViewContainer.onResume();
        }
    }

    public void onPause() {
        RewardWebViewContainer rewardWebViewContainer;
        if (getVisibility() == 0 && (rewardWebViewContainer = this.mWebViewContainer) != null) {
            rewardWebViewContainer.onPause();
        }
    }

    public void onStop() {
        RewardWebViewContainer rewardWebViewContainer;
        if (getVisibility() == 0 && (rewardWebViewContainer = this.mWebViewContainer) != null) {
            rewardWebViewContainer.onStop();
        }
    }

    public void onDestroy() {
        RewardWebViewContainer rewardWebViewContainer;
        if (getVisibility() == 0 && (rewardWebViewContainer = this.mWebViewContainer) != null) {
            rewardWebViewContainer.onDestroy();
        }
    }

    public void onNewIntent(Intent intent) {
        RewardWebViewContainer rewardWebViewContainer = this.mWebViewContainer;
        if (rewardWebViewContainer != null) {
            rewardWebViewContainer.onNewIntent(intent);
        }
    }

    public void setBlankClickListener(View.OnClickListener listener) {
        this.mBlankClickListener = listener;
    }
}
