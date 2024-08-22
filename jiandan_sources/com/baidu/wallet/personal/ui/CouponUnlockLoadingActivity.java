package com.baidu.wallet.personal.ui;

import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.SDKBaseActivity;

public class CouponUnlockLoadingActivity extends BaseActivity {
    public static final int FLAG_LOGIN_LOADING = 256;

    public static synchronized void exitLoading() {
        synchronized (CouponUnlockLoadingActivity.class) {
            BaseActivity.clearTasksWithFlag(256);
        }
    }

    private void initView() {
        setContentView(ResUtils.layout(getActivity(), "wallet_coupon_unlock_loading_layout"));
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

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setFlag();
        initView();
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
