package com.baidu.swan.apps.impl.account.loginauthmobile;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.util.devices.KeyboardUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.ISmsLoginViewListener;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.account.view.C0328AccountSmsLoginView;
import com.baidu.swan.apps.impl.R;
import com.baidu.swan.apps.impl.config.SwanUrlConfig;
import com.baidu.swan.apps.view.BdBaseImageView;

public class SwanAppPrivacyPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog {
    private static final String SWAN_APP_LOGIN_SRC = "smMaskLogin";
    private static final String TAG = "SwanAppPrivacyPhoneLoginDialog";
    private BdBaseImageView mBackView;
    private BdBaseImageView mClose;
    /* access modifiers changed from: private */
    public boolean mIsRegister = false;
    /* access modifiers changed from: private */
    public boolean mIsShowBackView;
    /* access modifiers changed from: private */
    public C0328AccountSmsLoginView mSmsLoginView;
    private FrameLayout mSmsLoginViewLayout;
    private EditText mSmsPhoneView;
    private TextView mTitle;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        refreshPhoneNumAuthoStatus();
        return this.mRootView;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new Dialog(this.mActivity, getTheme()) {
            public void onBackPressed() {
                String str;
                SwanAppPrivacyPhoneLoginDialog swanAppPrivacyPhoneLoginDialog = SwanAppPrivacyPhoneLoginDialog.this;
                swanAppPrivacyPhoneLoginDialog.setFinishActivity(!swanAppPrivacyPhoneLoginDialog.mIsShowBackView);
                SwanAppPrivacyPhoneLoginDialog.this.finishDialog();
                if (SwanAppPrivacyPhoneLoginDialog.this.mIsShowBackView) {
                    FragmentManager fragmentManager = SwanAppPrivacyPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    StaticsData data = new StaticsData();
                    StaticsData appId = data.setType("show").setLoginPage(LoginAndGetMobileStatics.PAGE_QUICK_LOGIN).setLoginResult((String) null).setLaunchFrom(SwanAppPrivacyPhoneLoginDialog.this.mLaunchFrom).setMode("privacy").setAppId(SwanAppPrivacyPhoneLoginDialog.this.mAppId);
                    if (TextUtils.isEmpty(SwanAppPrivacyPhoneLoginDialog.this.mSharedAuthorization)) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    appId.setSharedAuth(str);
                    LoginAndGetMobileStatics.onLoginAndGetMobile(data);
                    return;
                }
                SwanAppPrivacyPhoneLoginDialog swanAppPrivacyPhoneLoginDialog2 = SwanAppPrivacyPhoneLoginDialog.this;
                LoginAndGetMobileStatics.doCancelStatics(swanAppPrivacyPhoneLoginDialog2, swanAppPrivacyPhoneLoginDialog2.mLaunchFrom, SwanAppPrivacyPhoneLoginDialog.this.mAppId);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void inflateView(LayoutInflater inflater, ViewGroup container) {
        this.mRootView = inflater.inflate(R.layout.swan_app_login_and_getphonenum_dialog_layout, container, false);
        this.mClose = (BdBaseImageView) this.mRootView.findViewById(R.id.close);
        this.mBackView = (BdBaseImageView) this.mRootView.findViewById(R.id.back);
        this.mPhoneNumAuthSwitch = (CheckBox) this.mRootView.findViewById(R.id.phonenum_autho_switch);
        this.mPhoneNumAuthSwitch.setChecked(false);
        this.mSharedPhoneNumAuthSwitch = (CheckBox) this.mRootView.findViewById(R.id.phonenum_autho_shared_switch);
        this.mSharedPhoneNumAuthSwitch.setChecked(false);
        this.mSharedPhoneNumAuthSwitch.setVisibility(8);
        this.mSmsLoginViewLayout = (FrameLayout) this.mRootView.findViewById(R.id.login_input_layout);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.mServiceText = (TextView) this.mRootView.findViewById(R.id.user_service_agreement);
        this.mServiceText.setVisibility(8);
        this.mSharedServiceText = (TextView) this.mRootView.findViewById(R.id.user_shared_service_agreement);
        this.mSharedServiceText.setVisibility(8);
        setServiceText();
        this.mClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SwanAppPrivacyPhoneLoginDialog.this.setFinishActivity(true);
                SwanAppPrivacyPhoneLoginDialog.this.finishDialog();
                SwanAppPrivacyPhoneLoginDialog swanAppPrivacyPhoneLoginDialog = SwanAppPrivacyPhoneLoginDialog.this;
                LoginAndGetMobileStatics.doCancelStatics(swanAppPrivacyPhoneLoginDialog, swanAppPrivacyPhoneLoginDialog.mLaunchFrom, SwanAppPrivacyPhoneLoginDialog.this.mAppId);
            }
        });
        if (this.mIsShowBackView) {
            this.mBackView.setVisibility(0);
            this.mBackView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String str;
                    SwanAppPrivacyPhoneLoginDialog.this.setFinishActivity(false);
                    SwanAppPrivacyPhoneLoginDialog.this.finishDialog();
                    FragmentManager fragmentManager = SwanAppPrivacyPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    StaticsData data = new StaticsData();
                    StaticsData appId = data.setType("show").setLoginPage(LoginAndGetMobileStatics.PAGE_QUICK_LOGIN).setLoginResult((String) null).setLaunchFrom(SwanAppPrivacyPhoneLoginDialog.this.mLaunchFrom).setMode("privacy").setAppId(SwanAppPrivacyPhoneLoginDialog.this.mAppId);
                    if (TextUtils.isEmpty(SwanAppPrivacyPhoneLoginDialog.this.mSharedAuthorization)) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    appId.setSharedAuth(str);
                    LoginAndGetMobileStatics.onLoginAndGetMobile(data);
                }
            });
        }
    }

    public void setBackView(boolean isShowBackViw) {
        this.mIsShowBackView = isShowBackViw;
    }

    /* access modifiers changed from: protected */
    public void updateUI() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Resources resources = getContext().getResources();
        if (resources != null) {
            BdBaseImageView bdBaseImageView = this.mClose;
            if (this.mIsNightMode) {
                i2 = R.drawable.swanapp_login_dialog_close_dark;
            } else {
                i2 = R.drawable.swanapp_login_dialog_close;
            }
            bdBaseImageView.setImageDrawable(resources.getDrawable(i2));
            this.mBackView.setImageResource(com.baidu.swan.apps.R.drawable.aiapps_action_bar_back_selector);
            TextView textView = this.mTitle;
            if (this.mIsNightMode) {
                i3 = R.color.aiapps_login_dialog_title_dark;
            } else {
                i3 = R.color.aiapps_login_dialog_title;
            }
            textView.setTextColor(resources.getColor(i3));
            CheckBox checkBox = this.mPhoneNumAuthSwitch;
            if (this.mIsNightMode) {
                i4 = R.color.aiapps_login_dialog_title_dark;
            } else {
                i4 = R.color.swan_app_color_999999;
            }
            checkBox.setTextColor(resources.getColor(i4));
            CheckBox checkBox2 = this.mPhoneNumAuthSwitch;
            if (this.mIsNightMode) {
                i5 = R.drawable.aiapp_login_and_phonenum_autho_selector_dark;
            } else {
                i5 = R.drawable.aiapp_login_and_phonenum_autho_selector;
            }
            checkBox2.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i5), (Drawable) null, (Drawable) null, (Drawable) null);
            CheckBox checkBox3 = this.mSharedPhoneNumAuthSwitch;
            if (this.mIsNightMode) {
                i6 = R.color.aiapps_login_dialog_title_dark;
            } else {
                i6 = R.color.swan_app_color_999999;
            }
            checkBox3.setTextColor(resources.getColor(i6));
            CheckBox checkBox4 = this.mSharedPhoneNumAuthSwitch;
            if (this.mIsNightMode) {
                i7 = R.drawable.aiapp_login_and_phonenum_autho_selector_dark;
            } else {
                i7 = R.drawable.aiapp_login_and_phonenum_autho_selector;
            }
            checkBox4.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i7), (Drawable) null, (Drawable) null, (Drawable) null);
            TextView textView2 = this.mServiceText;
            if (this.mIsNightMode) {
                i8 = com.baidu.swan.apps.R.drawable.aiapps_auth_dialog_detail_bg_dark;
            } else {
                i8 = com.baidu.swan.apps.ui.R.drawable.aiapps_auth_dialog_detail_bg;
            }
            textView2.setBackgroundResource(i8);
            this.mServiceText.setTextColor(getContext().getResources().getColor(this.mIsNightMode ? R.color.aiapps_login_dialog_title_dark : R.color.swan_app_color_999999));
            TextView textView3 = this.mSharedServiceText;
            if (this.mIsNightMode) {
                i9 = com.baidu.swan.apps.R.drawable.aiapps_auth_dialog_detail_bg_dark;
            } else {
                i9 = com.baidu.swan.apps.ui.R.drawable.aiapps_auth_dialog_detail_bg;
            }
            textView3.setBackgroundResource(i9);
            this.mSharedServiceText.setTextColor(getContext().getResources().getColor(this.mIsNightMode ? R.color.aiapps_login_dialog_title_dark : R.color.swan_app_color_999999));
        }
    }

    /* access modifiers changed from: protected */
    public void reInitPhoneNumberAuthSwitchAndLoginBtnView() {
    }

    /* access modifiers changed from: protected */
    public void handleLogin() {
        BoxAccountManager mLoginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        LoginParams loginParams = new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, SWAN_APP_LOGIN_SRC)).setLoginMode(10).build();
        if (this.mPhoneNumAuthSwitch != null) {
            this.mPhoneNumAuthSwitch.setVisibility(0);
            this.mPhoneNumAuthSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitchChecked = isChecked;
                    SwanAppLoginAndGetMobileDialog.sIsChecked = isChecked;
                    if (isChecked) {
                        SwanAppPrivacyPhoneLoginDialog.this.mSmsLoginView.try2SmsLogin();
                    } else {
                        SwanAppPrivacyPhoneLoginDialog.this.showUncheckedBoxToast();
                    }
                }
            });
        }
        if (!(this.mSharedPhoneNumAuthSwitch == null || this.mJSONSharedAuthorization == null)) {
            this.mSharedPhoneNumAuthSwitch.setVisibility(0);
            this.mSharedPhoneNumAuthSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SwanAppPrivacyPhoneLoginDialog.this.mSharedPhoneNumAuthSwitchChecked = isChecked;
                    if (isChecked && !SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitchChecked) {
                        if (SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitch != null) {
                            SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitch.setChecked(true);
                            SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitchChecked = true;
                        }
                        SwanAppPrivacyPhoneLoginDialog.this.showAuthTipToast();
                    }
                }
            });
        }
        C0328AccountSmsLoginView accountSmsLoginView = (C0328AccountSmsLoginView) mLoginManager.startBoxSmsLoginView(this.mActivity, loginParams, new ISmsLoginViewListener() {
            public void onCheckCodeViewShow() {
            }

            public void onCheckCodeViewHide() {
                SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitch.setVisibility(0);
                if (!TextUtils.isEmpty(SwanAppPrivacyPhoneLoginDialog.this.mSharedAuthorization)) {
                    SwanAppPrivacyPhoneLoginDialog.this.mSharedPhoneNumAuthSwitch.setVisibility(0);
                }
            }

            public void onRegister() {
                boolean unused = SwanAppPrivacyPhoneLoginDialog.this.mIsRegister = true;
            }

            public void onResult(int resultCode) {
                String loginResult;
                String str;
                if (resultCode == 0) {
                    loginResult = "succ_agree";
                } else {
                    loginResult = "fail";
                }
                StaticsData data = new StaticsData();
                data.setType("click").setLoginPage("telLogin").setLoginResult(loginResult).setLaunchFrom(SwanAppPrivacyPhoneLoginDialog.this.mLaunchFrom).setMode("privacy").setAppId(SwanAppPrivacyPhoneLoginDialog.this.mAppId);
                if (TextUtils.isEmpty(SwanAppPrivacyPhoneLoginDialog.this.mSharedAuthorization)) {
                    data.setSharedAuth("0");
                } else {
                    if (SwanAppPrivacyPhoneLoginDialog.this.mSharedPhoneNumAuthSwitchChecked) {
                        str = "1";
                    } else {
                        str = "-1";
                    }
                    data.setSharedAuth(str);
                }
                LoginAndGetMobileStatics.onLoginAndGetMobile(data);
                if (!SwanAppPrivacyPhoneLoginDialog.this.mIsRegister || resultCode != -1) {
                    if (resultCode == 0 && SwanAppPrivacyPhoneLoginDialog.this.mDialogCallback != null) {
                        if (SwanAppPrivacyPhoneLoginDialog.this.mSharedPhoneNumAuthSwitchChecked) {
                            SwanAppPrivacyPhoneLoginDialog.this.mDialogCallback.onLoginResult(1010);
                        } else {
                            SwanAppPrivacyPhoneLoginDialog.this.mDialogCallback.onLoginResult(resultCode);
                        }
                    }
                    if (SwanAppPrivacyPhoneLoginDialog.this.mActivity != null && SwanAppPrivacyPhoneLoginDialog.this.mActivity.getWindow() != null) {
                        KeyboardUtils.forceHiddenSoftInput(SwanAppPrivacyPhoneLoginDialog.this.mActivity, SwanAppPrivacyPhoneLoginDialog.this.mActivity.getWindow().getDecorView().getWindowToken());
                        return;
                    }
                    return;
                }
                SwanAppPrivacyPhoneLoginDialog.this.finishDialog();
            }
        });
        this.mSmsLoginView = accountSmsLoginView;
        accountSmsLoginView.setSendVerificationCodeIntercept(new SmsLoginView.PrivacyAgreementIntercept() {
            public boolean across(int operation) {
                if (operation == 1) {
                    if (SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitch != null && !SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitch.isChecked() && SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitch.getVisibility() == 0) {
                        SwanAppPrivacyPhoneLoginDialog.this.showUncheckedBoxToast();
                        return false;
                    }
                } else if (operation == 2 && SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitch != null && !SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitch.isChecked() && SwanAppPrivacyPhoneLoginDialog.this.mPhoneNumAuthSwitch.getVisibility() == 0) {
                    SwanAppPrivacyPhoneLoginDialog.this.showUncheckedBoxToast();
                    return false;
                }
                return true;
            }
        });
        this.mSmsLoginViewLayout.addView(this.mSmsLoginView);
        EditText editText = (EditText) this.mSmsLoginView.findViewById(com.baidu.searchbox.account.R.id.phone);
        this.mSmsPhoneView = editText;
        editText.setEnabled(true);
    }

    public void refreshUI(boolean nightMode) {
        C0328AccountSmsLoginView accountSmsLoginView;
        super.refreshUI(nightMode);
        if (!(this.mSmsLoginViewLayout == null || (accountSmsLoginView = this.mSmsLoginView) == null)) {
            accountSmsLoginView.close();
            this.mSmsLoginViewLayout.removeView(this.mSmsLoginView);
        }
        handleLogin();
    }

    /* access modifiers changed from: protected */
    public void finishDialog() {
        C0328AccountSmsLoginView accountSmsLoginView = this.mSmsLoginView;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.finishDialog();
    }

    public void onDismiss(DialogInterface dialog) {
        C0328AccountSmsLoginView accountSmsLoginView = this.mSmsLoginView;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.onDismiss(dialog);
    }

    public void onDestroyView() {
        C0328AccountSmsLoginView accountSmsLoginView = this.mSmsLoginView;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.onDestroyView();
    }

    private void refreshPhoneNumAuthoStatus() {
        setPhoneAuthSwitch();
        this.mSmsLoginView.postDelayed(new Runnable() {
            public void run() {
                if (SwanAppPrivacyPhoneLoginDialog.this.mSmsLoginView != null) {
                    SwanAppPrivacyPhoneLoginDialog.this.mSmsLoginView.clean();
                }
            }
        }, 150);
    }

    /* access modifiers changed from: protected */
    public void refreshCheckedBox(boolean isChecked) {
        this.mPhoneNumAuthSwitch.setChecked(sIsChecked);
    }

    private void setServiceText() {
        SpannableStringBuilder textStyle = new SpannableStringBuilder("");
        textStyle.append(getString(R.string.swanapp_service_agreement_tip));
        addClickableText(textStyle, textStyle.length(), getString(R.string.swanapp_service_agreement_baidu), SwanUrlConfig.getPassAccountAgreementUrl());
        textStyle.append(getString(R.string.swanapp_service_agreement_register_tip));
        this.mServiceText.setMovementMethod(LinkMovementMethod.getInstance());
        this.mServiceText.setText(textStyle);
        setSharedServiceText();
    }
}
