package com.baidu.wallet.base.widget;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.SDKBaseActivity;
import java.util.Arrays;

public class LoadingActivity extends BaseActivity {
    public static final int FLAG_LOGIN_LOADING = 256;
    public static final String FLAG_WHITE_BACKGROUND = "flag_white_background";
    public static final String WHITE_BACKGROUND = "is_white_background";
    public AnimationDrawable mAnimationDrawable;

    public static synchronized void exitLoading() {
        synchronized (LoadingActivity.class) {
            BaseActivity.clearTasksWithFlag(256);
        }
    }

    private void initView(boolean z) {
        Activity activity;
        String str;
        setContentView(ResUtils.layout(getActivity(), "wallet_base_layout_loading"));
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "relative_root"));
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"));
        if (relativeLayout != null) {
            if (z) {
                activity = getActivity();
                str = "bd_wallet_white";
            } else {
                activity = getActivity();
                str = "ebpay_transparent";
            }
            relativeLayout.setBackgroundColor(ResUtils.getColor(activity, str));
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        this.mAnimationDrawable = animationDrawable;
        animationDrawable.stop();
        this.mAnimationDrawable.start();
        setImmersiveActivityMargeinTop();
    }

    private void setFlag() {
        this.mFlag |= 256;
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public boolean isSlidingEnable() {
        return false;
    }

    public void onBackPressed() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getOpenLoginToken())) {
            finish();
            return;
        }
        Intent intent = getIntent();
        boolean equals = intent != null ? TextUtils.equals(WHITE_BACKGROUND, intent.getStringExtra(FLAG_WHITE_BACKGROUND)) : false;
        DXMSdkSAUtils.onEventWithValues("DXMLoadingShow", Arrays.asList(new String[]{String.valueOf(hashCode()), "onCreate"}));
        setFlag();
        initView(equals);
    }

    public void onDestroy() {
        DXMSdkSAUtils.onEventWithValues("DXMLoadingShow", Arrays.asList(new String[]{String.valueOf(hashCode()), "onDestory"}));
        super.onDestroy();
        AnimationDrawable animationDrawable = this.mAnimationDrawable;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.mAnimationDrawable.stop();
        }
    }

    public void setImmersiveActivityMargeinTop() {
        if (Build.VERSION.SDK_INT >= 19 && getActivity() != null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getActivity(), "welcome_page"));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, StatusBarUtils.getStatusBarHeight(getActivity()), 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
    }
}
