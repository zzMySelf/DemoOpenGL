package com.baidu.searchbox.account.component;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.app.account.utils.LogDescription;
import com.baidu.android.app.account.utils.LogUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.account.R;
import com.baidu.searchbox.account.view.ShimmerFrameLayout;
import com.baidu.searchbox.config.AppConfig;
import com.facebook.drawee.generic.GenericDraweeHierarchy;

public class AccountFollowRedBoxView extends AccountBaseComponent {
    private static final String TAG = "AccountFollowRedBoxView";
    private View mCommonLoginRoot;
    private boolean mIsFirstOneKeyLogin = false;
    private ShimmerFrameLayout mOneKeyLoginRoot;
    private ShimmerFrameLayout mShareLoginRoot;

    public AccountFollowRedBoxView(Context context) {
        super(context);
        init(context);
    }

    public AccountFollowRedBoxView(Context context, IAccountComponentCallback callback) {
        super(context);
        setComponentCallback(callback);
        init(context);
    }

    public void stableApiStub() {
    }

    private void init(Context context) {
        setLoginViewType(2);
        initView(R.layout.account_compontent_follow_red);
        this.mShareLoginRoot = (ShimmerFrameLayout) findViewById(R.id.share_login_root);
        this.mOneKeyLoginRoot = (ShimmerFrameLayout) findViewById(R.id.onekey_login_root);
        this.mCommonLoginRoot = findViewById(R.id.common_login);
        updateAccountAgreementCheckBox((AccountAgreementCheckBox) findViewById(R.id.agree_checkbox));
    }

    private void updateAccountAgreementCheckBox(AccountAgreementCheckBox checkBox) {
        if (checkBox != null) {
            checkBox.setSize(getResources().getDimension(R.dimen.account_dimen_11dp), getResources().getDimension(R.dimen.account_dimen_16dp));
            if (checkBox.mIcon.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) checkBox.mIcon.getLayoutParams();
                layoutParams.topMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 1.0f);
                layoutParams.rightMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 5.0f);
                checkBox.mIcon.setLayoutParams(layoutParams);
            }
        }
    }

    public void showOneKeyLoginPanel(boolean isFirstOneKeyLogin) {
        int i2 = 0;
        setVisibility(this.mOneKeyLayout, 0);
        setVisibility(this.mOtherLogin, 0);
        setVisibility(this.mShareLayout, 8);
        setVisibility(this.mCommonLoginRoot, 8);
        setVisibility(this.mThirdLayout, 8);
        AccountAgreementCheckBox accountAgreementCheckBox = this.mAgreeCheckBox;
        if (!isFirstOneKeyLogin) {
            i2 = 8;
        }
        setVisibility(accountAgreementCheckBox, i2);
        this.mIsFirstOneKeyLogin = isFirstOneKeyLogin;
        if (this.mOneKeyLogin == null) {
            LogUtils.writeOnlineLog(LogUtils.DATA_ID_VIEW_NULL, LogDescription.EVENT_VIEW_NULL, "mOneKeyLogin =" + this.mOneKeyLogin, "showOneKeyLoginPanel", false, false, true);
        }
        updateView();
    }

    public void showShareLoginPanel() {
        setVisibility(this.mShareLayout, 0);
        setVisibility(this.mOtherLogin, 0);
        setVisibility(this.mOneKeyLayout, 8);
        setVisibility(this.mCommonLoginRoot, 8);
        setVisibility(this.mThirdLayout, 8);
        if (this.mAgreeCheckBox != null) {
            ((LinearLayout.LayoutParams) this.mAgreeCheckBox.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.account_dimen_10dp);
        }
        updateView();
    }

    public void showHistoryLoginPanel() {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "show history login panel");
        }
    }

    public void showCommonLoginPanel(boolean isDeafultStyle) {
        setVisibility(this.mShareLayout, 8);
        setVisibility(this.mOtherLogin, 8);
        setVisibility(this.mOneKeyLayout, 8);
        if (isDeafultStyle) {
            setVisibility(this.mCommonLoginRoot, 0);
            setVisibility(this.mThirdLayout, 8);
        } else {
            setVisibility(this.mCommonLoginRoot, 8);
            setVisibility(this.mThirdLayout, 0);
        }
        setVisibility(this.mAgreeCheckBox, 8);
        updateView();
    }

    private void updateView() {
        try {
            setBackground(this.mShareLayout, ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.account_component_hutong_backgroud, (Resources.Theme) null));
            if (this.mAvatar != null) {
                ((GenericDraweeHierarchy) this.mAvatar.getHierarchy()).setPlaceholderImage(com.baidu.android.common.ui.style.R.drawable.common_login_head_login);
            }
            setText(this.mThirdTitle, (CharSequence) getContext().getResources().getString(R.string.account_launch_login_other_login));
        } catch (Exception e2) {
            LogUtils.writeOnlineLog(LogUtils.DATA_ID_VIEW_NULL, LogDescription.EVENT_VIEW_NULL, e2.getMessage(), "AccountOperationView", false, false, true);
        }
    }

    public void showWXEnhanceLoginPanel() {
    }

    /* access modifiers changed from: protected */
    public String getLoginScene() {
        return "follow";
    }

    public boolean isFirstOneKeyLogin() {
        return this.mIsFirstOneKeyLogin;
    }

    public void login(int loginStyle) {
        switch (loginStyle) {
            case 0:
                commonLogin();
                return;
            case 1:
                if (this.boxOneKeyLoginResult != null) {
                    oneKeyLogin(this.boxOneKeyLoginResult.getLoginMode());
                    return;
                }
                return;
            case 2:
                shareLogin(this.boxShareLoginResult);
                return;
            default:
                return;
        }
    }

    public void updateCheckbox(int loginStyle) {
    }

    /* access modifiers changed from: protected */
    public boolean isNight() {
        return false;
    }
}
