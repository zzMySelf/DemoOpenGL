package com.baidu.android.lbspay.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.lbspay.presenter.LBSTransPresenter;
import com.baidu.android.lbspay.presenter.LBSTransPresenterFactory;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.beans.BeanManager;

public class LBSTransActivity extends LBSBaseActivity {
    public static final String BEAN_TAG = "LBSTransActivity";
    public static final String PRESENTER_TYPE = "presentertype";
    public LBSTransPresenter mPresenter;

    private void initView() {
        setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_layout_loading"));
        AnimationDrawable animationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setImmersiveActivityMargeinTop();
    }

    public void handleFailure(int i2, int i3, String str) {
        LBSTransPresenter lBSTransPresenter = this.mPresenter;
        if (lBSTransPresenter != null) {
            lBSTransPresenter.handleFailure(i2, i3, str);
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        LBSTransPresenter lBSTransPresenter = this.mPresenter;
        if (lBSTransPresenter != null) {
            lBSTransPresenter.handleResponse(i2, obj, str);
        }
    }

    public void onBackPressed() {
        LBSTransPresenter lBSTransPresenter = this.mPresenter;
        if (lBSTransPresenter != null) {
            lBSTransPresenter.cancelBean();
        }
        onBackPressedWithoutAnim();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPresenter = LBSTransPresenterFactory.getInstance().getTransPresenter(this, getIntent().getExtras().getString(PRESENTER_TYPE));
        initView();
        LBSTransPresenter lBSTransPresenter = this.mPresenter;
        if (lBSTransPresenter != null) {
            lBSTransPresenter.init(bundle);
            this.mPresenter.execBean();
            return;
        }
        finishWithoutAnim();
    }

    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(BEAN_TAG);
    }

    public void onSaveInstanceState(Bundle bundle) {
        LBSTransPresenter lBSTransPresenter = this.mPresenter;
        if (lBSTransPresenter != null) {
            lBSTransPresenter.SaveInstanceState(bundle);
        }
        super.onSaveInstanceState(bundle);
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
