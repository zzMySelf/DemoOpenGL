package com.baidu.searchbox.secondfloor;

import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.util.android.VibrateUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.home.HomeStyleManager;
import com.baidu.searchbox.secondfloor.SecondFloorViewManager;
import com.baidu.searchbox.secondfloor.config.SecondFloorPullDownInfo;
import com.baidu.searchbox.secondfloor.listener.ISecondFloorPullDownListener;
import com.baidu.searchbox.secondfloor.listener.IThresholdListener;

public abstract class BaseSecondFloorViewAdapter implements SecondFloorViewAdapter, SecondFloorViewManager.OnFloorChangeListener {
    private static final int DEFAULT_PULL_DOWN_MIN_HEIGHT_DP = 108;
    private static final int DEFAULT_PULL_DOWN_MIN_HEIGHT_DP_NO_LOGO = 135;
    private static final int DEFAULT_VIBRATE_AMPLITUDE = 30;
    private static final int DEFAULT_VIBRATE_TIMING = 60;
    private static final int FIRST_FLOOR_VIEW_ROUND_VALUE = 54;
    private static final int FIRST_VIEW_EXTRA_TRANSLATE_Y = 10;
    private boolean hasVibrate = true;
    private boolean isVibrated = false;
    protected Context mContext;
    protected View mFirstFloorView;
    protected SecondFloorHeaderView mHeaderView;
    private float mLastTotalDY;
    private ISecondFloorPullDownListener mPullDownListener;
    private int mPullDownMaxHeight;
    private String mPullPage;
    private int mPullUpMaxHeight;
    private int mPullUpMinHeight;
    private int mScreenHeight;
    protected ISecondFloorHost mSecondFloorHost;
    private int mStatusBarHeight;
    private IThresholdListener mThresholdListener;

    public abstract ISecondFloorDefaultPullDownInfo getSecondFloorDefaultPullDownInfo();

    public abstract SecondFloorPullDownInfo getSecondFloorPullDownInfo();

    public BaseSecondFloorViewAdapter(ISecondFloorHost secondFloorHost) {
        this.mSecondFloorHost = secondFloorHost;
        Activity activity = secondFloorHost.getActivity();
        this.mContext = activity;
        int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(activity);
        this.mScreenHeight = displayHeight;
        this.mPullDownMaxHeight = displayHeight;
        this.mPullUpMaxHeight = displayHeight;
        this.mPullUpMinHeight = displayHeight / 3;
    }

    public void setFirstFloorView(View firstFloorView) {
        this.mFirstFloorView = firstFloorView;
    }

    public void setHasVibrate(boolean hasVibrate2) {
        this.hasVibrate = hasVibrate2;
    }

    public int getPullDownMinHeight() {
        return DeviceUtil.ScreenInfo.dp2px(this.mContext, HomeStyleManager.INSTANCE.isLogoShow() ? 108.0f : 135.0f);
    }

    public int getPullDownMaxHeight() {
        return this.mPullDownMaxHeight;
    }

    public int getPullUpMinHeight() {
        return this.mPullUpMinHeight;
    }

    public int getPullUpMaxHeight() {
        return this.mPullUpMaxHeight;
    }

    public SecondFloorHeaderView getHeaderView() {
        if (this.mHeaderView == null) {
            this.mHeaderView = new SecondFloorHeaderView(this.mContext);
        }
        return this.mHeaderView;
    }

    public void pull(int currentFloorState, float totalDY) {
        if (currentFloorState == 1) {
            updateHeaderView(totalDY);
        }
    }

    public void releasePull(int currentFloorState, int nextFloorState) {
        if (currentFloorState == 1 && nextFloorState == 2) {
            SecondFloorHeaderView secondFloorHeaderView = this.mHeaderView;
            if (secondFloorHeaderView != null) {
                secondFloorHeaderView.startTipAlphaAnim();
            }
            ISecondFloorPullDownListener iSecondFloorPullDownListener = this.mPullDownListener;
            if (iSecondFloorPullDownListener != null) {
                iSecondFloorPullDownListener.releasePull();
            }
        }
    }

    public void resetHeader() {
        SecondFloorHeaderView secondFloorHeaderView = this.mHeaderView;
        if (secondFloorHeaderView != null) {
            secondFloorHeaderView.reset();
        }
        cancelRoundView(this.mFirstFloorView);
    }

    public void setPullPage(String pullPage) {
        this.mPullPage = pullPage;
    }

    public String getPullPage() {
        return this.mPullPage;
    }

    public void updateHeaderView(float totalDY) {
        ISecondFloorPullDownListener iSecondFloorPullDownListener;
        if (this.mHeaderView != null && totalDY <= ((float) this.mPullDownMaxHeight)) {
            int pullDownMinHeight = getPullDownMinHeight();
            if (this.mLastTotalDY < ((float) pullDownMinHeight) && totalDY >= ((float) pullDownMinHeight)) {
                this.mHeaderView.updateTip(true);
                this.mThresholdListener.isPassThreshold(true);
                if (!this.isVibrated && this.hasVibrate) {
                    new VibrateUtils.Builder((Vibrator) this.mContext.getSystemService("vibrator"), new long[]{60}, this.mContext).amplitudes(new int[]{30}).build().vibrateStart();
                    this.isVibrated = true;
                }
            }
            if (this.mLastTotalDY >= ((float) pullDownMinHeight) && totalDY < ((float) pullDownMinHeight)) {
                this.mHeaderView.updateTip(false);
                this.mThresholdListener.isPassThreshold(false);
            }
            if (totalDY < ((float) pullDownMinHeight) && (iSecondFloorPullDownListener = this.mPullDownListener) != null) {
                iSecondFloorPullDownListener.pull(totalDY);
            }
            this.mLastTotalDY = totalDY;
        }
    }

    public void floorStateChanged(int lastFloorState, int currentFloorState) {
        this.isVibrated = false;
        this.hasVibrate = true;
        this.mLastTotalDY = 0.0f;
        View view2 = this.mFirstFloorView;
        if (view2 != null) {
            view2.setBackgroundColor(this.mContext.getResources().getColor(17170445));
        }
        if (currentFloorState != 2) {
            SecondFloorHeaderView secondFloorHeaderView = this.mHeaderView;
            if (secondFloorHeaderView != null) {
                secondFloorHeaderView.reset();
            }
            cancelRoundView(this.mFirstFloorView);
        } else if (this.mFirstFloorView != null) {
            if (this.mStatusBarHeight == 0) {
                this.mStatusBarHeight = DeviceUtil.ScreenInfo.getStatusBarHeight();
            }
            View view3 = this.mFirstFloorView;
            view3.setTranslationY(view3.getTranslationY() + 10.0f + ((float) this.mStatusBarHeight));
        }
    }

    public void onFloorPullStart(int currentFloorState) {
        if (currentFloorState == 1) {
            View view2 = this.mFirstFloorView;
            if (view2 != null) {
                view2.setBackgroundColor(this.mContext.getResources().getColor(R.color.account_background_color));
            }
            getHeaderView().bindData();
            setRoundView(this.mFirstFloorView);
        }
    }

    public void onFloorPulling(int currentFloorState, float totalDY) {
    }

    public void onFloorChange(int lastFloorState, int currentFloorState) {
    }

    private void setRoundView(View view2) {
        if (view2 != null) {
            view2.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view2, Outline outline) {
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight() * 2, 54.0f);
                    view2.setClipToOutline(true);
                }
            });
        }
    }

    public void cancelRoundView(View view2) {
        if (view2 != null) {
            view2.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view2, Outline outline) {
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), 0.0f);
                    view2.setClipToOutline(true);
                }
            });
        }
    }

    public void setThresholdListener(IThresholdListener pullListener) {
        this.mThresholdListener = pullListener;
    }

    public void setPullDownListener(ISecondFloorPullDownListener pullDownListener) {
        this.mPullDownListener = pullDownListener;
    }
}
