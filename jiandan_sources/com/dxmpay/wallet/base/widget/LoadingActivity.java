package com.dxmpay.wallet.base.widget;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.Arrays;

public class LoadingActivity extends BaseActivity {
    public static final int FLAG_LOGIN_LOADING = 512;
    public AnimationDrawable mAnimationDrawable;

    public static synchronized void exitLoading() {
        synchronized (LoadingActivity.class) {
            BaseActivity.clearTasksWithFlag(512);
        }
    }

    private void initView() {
        setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_layout_loading"));
        AnimationDrawable animationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        this.mAnimationDrawable = animationDrawable;
        animationDrawable.stop();
        this.mAnimationDrawable.start();
        setImmersiveActivityMargeinTop();
    }

    private void setFlag() {
        this.mFlag |= 512;
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
        StatisticManager.onEventWithValues("DXMLoadingShow", Arrays.asList(new String[]{String.valueOf(hashCode()), "onCreate"}));
        setFlag();
        initView();
    }

    public void onDestroy() {
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
