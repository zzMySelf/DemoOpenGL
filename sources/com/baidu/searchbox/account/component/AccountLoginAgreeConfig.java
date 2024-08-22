package com.baidu.searchbox.account.component;

import android.content.Context;
import android.text.Html;
import android.text.Spannable;
import com.baidu.account.R;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.account.result.BoxOneKeyLoginResult;
import com.baidu.searchbox.common.runtime.AppRuntime;

public class AccountLoginAgreeConfig {
    private boolean isFirstOneKeyLogin;
    private Spannable mAgreementText;
    private String mButtonText;
    private String mLoginScene;
    private String mTitle;

    public String getTitle() {
        return this.mTitle;
    }

    public Spannable getAgreementText() {
        return this.mAgreementText;
    }

    public String getButtonText() {
        return this.mButtonText;
    }

    public boolean isFirstOneKeyLogin() {
        return this.isFirstOneKeyLogin;
    }

    public String getLoginScene() {
        return this.mLoginScene;
    }

    private AccountLoginAgreeConfig(Builder builder) {
        this.mTitle = builder.mTitle;
        this.mAgreementText = builder.mAgreementText;
        this.mButtonText = builder.mButtonText;
        this.isFirstOneKeyLogin = builder.isFirstOneKeyLogin;
        this.mLoginScene = builder.mLoginScene;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean isFirstOneKeyLogin;
        /* access modifiers changed from: private */
        public Spannable mAgreementText;
        /* access modifiers changed from: private */
        public String mButtonText;
        /* access modifiers changed from: private */
        public String mLoginScene;
        /* access modifiers changed from: private */
        public String mTitle;

        public Builder setTitle(String title) {
            this.mTitle = title;
            return this;
        }

        public Builder setAgreementText(Spannable agreementText) {
            this.mAgreementText = agreementText;
            return this;
        }

        public Builder setButtonText(String text) {
            this.mButtonText = text;
            return this;
        }

        public Builder setFirstOneKeyLogin(boolean isFirstOneKeyLogin2) {
            this.isFirstOneKeyLogin = isFirstOneKeyLogin2;
            return this;
        }

        public Builder setLoginScene(String loginScene) {
            this.mLoginScene = loginScene;
            return this;
        }

        public AccountLoginAgreeConfig build() {
            return new AccountLoginAgreeConfig(this);
        }
    }

    public static Builder getDefaulgBuilder() {
        return new Builder().setTitle(AppRuntime.getAppContext().getString(R.string.account_login_agree_dialog_title)).setAgreementText(generateAccountDialogAgreement3(AppRuntime.getAppContext())).setButtonText(AppRuntime.getAppContext().getString(R.string.account_login_agree_dialog_button)).setFirstOneKeyLogin(false);
    }

    public static Spannable generateAccountDialogAgreement1(Context context, BoxOneKeyLoginResult oneKeyLoginResult) {
        if (oneKeyLoginResult == null) {
            return generateAccountDialogAgreement3(context);
        }
        return (Spannable) Html.fromHtml(context.getResources().getString(R.string.account_login_agree_dialog_agreement_content_1, new Object[]{AccountConstants.easyBrowserScheme + oneKeyLoginResult.getAgreeUrl(), oneKeyLoginResult.getAgreeText(), AccountConstants.easyBrowserScheme + "https://wappass.baidu.com/passport/agreement", AccountConstants.easyBrowserScheme + BoxOneKeyLoginResult.BAIDU_PRIVACY_POLICY}));
    }

    public static Spannable generateAccountDialogAgreement2(Context context, BoxOneKeyLoginResult oneKeyLoginResult) {
        if (oneKeyLoginResult == null) {
            return generateAccountDialogAgreement3(context);
        }
        return (Spannable) Html.fromHtml(context.getResources().getString(R.string.account_login_agree_dialog_agreement_content_2, new Object[]{AccountConstants.easyBrowserScheme + oneKeyLoginResult.getAgreeUrl(), oneKeyLoginResult.getAgreeText(), AccountConstants.easyBrowserScheme + "https://wappass.baidu.com/passport/agreement", AccountConstants.easyBrowserScheme + BoxOneKeyLoginResult.BAIDU_PRIVACY_POLICY}));
    }

    public static Spannable generateAccountDialogAgreement3(Context context) {
        return (Spannable) Html.fromHtml(context.getResources().getString(R.string.account_login_agree_dialog_agreement_content_3, new Object[]{AccountConstants.easyBrowserScheme + "https://wappass.baidu.com/passport/agreement", AccountConstants.easyBrowserScheme + BoxOneKeyLoginResult.BAIDU_PRIVACY_POLICY}));
    }
}
