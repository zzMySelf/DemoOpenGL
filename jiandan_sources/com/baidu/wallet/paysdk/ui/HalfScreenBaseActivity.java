package com.baidu.wallet.paysdk.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.wallet.paysdk.ui.widget.HalfScreenContainerLayout;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.utils.AccessibilityUtils;

public abstract class HalfScreenBaseActivity extends PayBaseActivity {
    public static int a;
    public AnimationDrawable b;
    public View c;
    public View mActionBar;
    public ViewGroup mContentView;
    public HalfScreenContainerLayout mHalfScreenContainer;
    public ViewGroup mHalfScreenPageView;
    public ImageView mLeftImg;
    public TextView mRightTxt;
    public View mRootView;
    public TextView mTitle;

    private void a() {
        int size;
        if (a > 1 && BaseActivity.mActivityStack.size() - 2 >= 0 && (BaseActivity.mActivityStack.get(size) instanceof HalfScreenBaseActivity)) {
            findViewById(ResUtils.id(getActivity(), "ebpay_top_half")).setVisibility(4);
        }
    }

    private void b() {
        int i2;
        if (a > 1) {
            i2 = ResUtils.drawable(this, "wallet_base_new_halfscreen_actionbar_back");
            this.mLeftImg.setContentDescription("返回");
        } else {
            i2 = ResUtils.drawable(this, "wallet_base_halfscreen_actionbar_close");
            this.mLeftImg.setContentDescription("关闭");
        }
        this.mLeftImg.setImageResource(i2);
    }

    public static void resetInstanceCount() {
        a = 0;
    }

    public abstract void addContentView();

    public void finish() {
        super.finish();
        int i2 = a;
        if (i2 > 0) {
            a = i2 - 1;
        }
    }

    public void finishWithoutAnim() {
        super.finishWithoutAnim();
        int i2 = a;
        if (i2 > 0) {
            a = i2 - 1;
        }
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public boolean isWindowNightMode() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a++;
        setFlagPaySdk();
        setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_half_scrren_activity"));
        this.mHalfScreenPageView = (ViewGroup) findViewById(ResUtils.id(getActivity(), "ebpay_half_screen_page"));
        View findViewById = findViewById(ResUtils.id(getActivity(), "welcome_page"));
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.mRootView = findViewById(ResUtils.id(getActivity(), "root_view"));
        this.mHalfScreenContainer = (HalfScreenContainerLayout) findViewById(ResUtils.id(getActivity(), "ebpay_half_screen_container"));
        a();
        this.mActionBar = findViewById(ResUtils.id(getActivity(), "ebpay_halfscreen_action_bar"));
        this.mLeftImg = (ImageView) findViewById(ResUtils.id(getActivity(), "action_bar_left_img"));
        this.mTitle = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_title"));
        TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_left_txt"));
        this.mRightTxt = textView;
        AccessibilityUtils.changeRoleDescription(textView, ResUtils.getString(this, "wallet_access_button"));
        b();
        this.b = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        addContentView();
    }

    public void onDestroy() {
        int i2;
        super.onDestroy();
        if (!isFinishing() && (i2 = a) > 0) {
            a = i2 - 1;
        }
    }

    public void setPageTransparent(boolean z) {
        this.mRootView.setVisibility(z ? 4 : 0);
    }

    public void showLikeDismissLadingPage() {
        this.c.setVisibility(8);
        this.b.stop();
    }

    public void showLikeLoadingPage(boolean z) {
        setPageTransparent(false);
        if (z) {
            this.mHalfScreenPageView.setVisibility(8);
            this.c.setVisibility(0);
            this.b.start();
            return;
        }
        this.mHalfScreenPageView.setVisibility(0);
        this.c.setVisibility(8);
        this.b.stop();
    }
}
