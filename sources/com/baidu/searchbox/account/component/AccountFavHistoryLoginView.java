package com.baidu.searchbox.account.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.android.app.account.BoxAccountContants;
import com.baidu.android.app.account.utils.AccountUBCHelperKt;
import com.baidu.android.app.account.utils.SoftInputHelper;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.ISmsLoginViewListener;
import com.baidu.searchbox.account.R;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.event.AccountQuickLoginEvent;
import com.baidu.searchbox.account.listener.IUBCWhenUiUpdateListener;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.account.view.AccountSMSLoginView;
import com.baidu.searchbox.account.view.ChangeTextViewSpace;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.skin.NightModeHelper;
import java.util.ArrayList;

public class AccountFavHistoryLoginView extends AccountBaseComponent {
    private static final float SMS_CODE_LAYOUT_MARGIN_TOP = 40.0f;
    private static final float SMS_LAYOUT_MARGIN_BOTTOM = 27.6f;
    private static final float SMS_LAYOUT_MARGIN_TOP = 58.6f;
    protected static final String TAG = "AccountFavHistoryLoginView";
    protected RelativeLayout mCommonLayout;
    protected ImageView mFunctionIconIv;
    private AccountFavHistoryGuestLoginView mGuestLoginView;
    /* access modifiers changed from: private */
    public boolean mHasShowed;
    private TextView mHistoryLastLoginHint;
    protected LinearLayout mLoginContent;
    protected TextView mPhoneTitle;
    protected LinearLayout mPhoneTitleLayout;
    private MaxHeightFrameLayout mSmsLoginMaxTopMargin;
    protected SoftInputHelper mSoftInputHelper = new SoftInputHelper();
    protected View mThirdSection;
    private IUBCWhenUiUpdateListener mUIReadyUbcListener;

    public AccountFavHistoryLoginView(Context context, IAccountComponentCallback callback) {
        super(context);
        setIsNeedUpdateFontSize(true);
        setLoginViewType(3);
        setComponentCallback(callback);
        if (context instanceof LifecycleOwner) {
            ((LifecycleOwner) context).getLifecycle().addObserver(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                    int supportGuest;
                    if (event.compareTo(Lifecycle.Event.ON_DESTROY) == 0) {
                        BoxAccountManager manager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
                        if (AccountFavHistoryLoginView.this.mConfig != null) {
                            if (AccountFavHistoryLoginView.this.mConfig.mIsSupportGuest) {
                                supportGuest = 0;
                            } else {
                                supportGuest = 2;
                            }
                            if (manager != null && !manager.isLogin(supportGuest)) {
                                String page = AccountUBCHelperKt.loginStyle2Page(AccountFavHistoryLoginView.this.getLoginStyle());
                                AccountUBCHelperKt.statisticUbcOnEvent("full_screen", page, "cancel", AccountUBCHelperKt.pageStyle2Value(page, AccountFavHistoryLoginView.this.boxOneKeyLoginResult), AccountFavHistoryLoginView.this.mConfig.mLoginSrc, 0);
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void initViewAndLayout() {
        initView(R.layout.account_compontent_fav_history_login);
        initLayout();
        registerQuickLoginShowEvent();
        updateFontSize();
    }

    public void updateFontSize() {
        updateFontSize(this.mMainTitle, 0, R.dimen.account_dimen_16_5dp);
        updateFontSize(this.mCommonLogin, 0, R.dimen.account_dimen_16dp);
        updateFontSize(this.mShareLogin, 0, R.dimen.account_dimen_16dp);
        updateFontSize(this.mOneKeyLogin, 0, R.dimen.account_dimen_16dp);
        updateFontSize(this.mThirdTitle, 0, R.dimen.account_dimen_10dp);
        updateFontSize(this.mOtherLogin, 0, R.dimen.account_dimen_12dp);
        updateFontSize(this.mAvatar, 0, R.dimen.account_dimen_46dp, R.dimen.account_dimen_46dp);
        updateFontSize(this.mUserName, 0, R.dimen.account_dimen_16_5dp);
        updateFontSize(this.mAppName, 0, R.dimen.account_dimen_12dp);
        updateFontSize(this.mHistoryLastLoginHint, 0, R.dimen.account_dimen_9dp);
        updateFontSize(this.mPhone, 0, R.dimen.account_dimen_21dp);
        updateFontSize(this.mPhoneTitle, 0, R.dimen.account_dimen_11_3dp);
        updateFontSize(this.mAgreeCheckBox.mText, 0, R.dimen.account_dimen_12dp);
        updateFontSize(this.mAgreeCheckBox.mIcon, 0, R.dimen.account_dimen_17dp, R.dimen.account_dimen_17dp);
        RelativeLayout.LayoutParams avatarLayoutParams = (RelativeLayout.LayoutParams) this.mAvatar.getLayoutParams();
        LinearLayout.LayoutParams hutongContentLayoutParams = (LinearLayout.LayoutParams) this.mHutongContent.getLayoutParams();
        if (FontSizeHelper.getFontSizeType() > 2) {
            avatarLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.account_dimen_5dp);
            avatarLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.account_dimen_5dp);
            hutongContentLayoutParams.height = getResources().getDimensionPixelSize(R.dimen.account_dimen_75dp);
        } else {
            avatarLayoutParams.topMargin = 0;
            avatarLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.account_dimen_15dp);
            hutongContentLayoutParams.height = getResources().getDimensionPixelSize(R.dimen.account_dimen_70dp);
        }
        updateFontSize(this.mBack, 0, R.dimen.account_dimen_41dp, R.dimen.account_dimen_38dp);
        updateFontSize(this.mPhoneIcon, 0, R.dimen.account_dimen_30dp, R.dimen.account_dimen_30dp);
        updateFontSize(this.mWXIcon, 0, R.dimen.account_dimen_30dp, R.dimen.account_dimen_30dp);
        updateFontSize(this.mQQIcon, 0, R.dimen.account_dimen_30dp, R.dimen.account_dimen_30dp);
        updateFontSize(this.mSinaIcon, 0, R.dimen.account_dimen_30dp, R.dimen.account_dimen_30dp);
        updateFontSize(this.mYYIcon, 0, R.dimen.account_dimen_30dp, R.dimen.account_dimen_30dp);
        updateFontSize(this.mMoreIcon, 0, R.dimen.account_dimen_30dp, R.dimen.account_dimen_30dp);
        if (this.mAgreeCheckBox != null) {
            this.mAgreeCheckBox.updateFontSize(this.mIsNeedUpdateFontSize, 0);
        }
    }

    public void initReady() {
        super.initReady();
        if (this.mHasShowed) {
            UiThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (AccountFavHistoryLoginView.this.isSMSLoginViewVisible() && AccountFavHistoryLoginView.this.isSMSPhoneViewRequestAutoFocus()) {
                        AccountFavHistoryLoginView.this.mAccountSMSLoginView.requestPhoneInputViewFocusAndShowKeyboard();
                    }
                }
            }, 500);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mSoftInputHelper.attachSoftInput(this.mThirdSection, new SoftInputHelper.ISoftInputChanged() {
            public void onChanged(boolean isSoftInputShow, int softInputHeight, int viewOffset) {
                AccountFavHistoryLoginView.this.mThirdSection.setPadding(0, 0, 0, Math.max(0, viewOffset));
            }
        });
    }

    private void registerQuickLoginShowEvent() {
        BdEventBus.Companion.getDefault().register(this, AccountQuickLoginEvent.class, new Action<AccountQuickLoginEvent>() {
            public void call(AccountQuickLoginEvent event) {
                if (event.getEventType() == 1) {
                    String source = (String) event.getParam("source");
                    if (!TextUtils.isEmpty(source) && source.equals(AccountFavHistoryLoginView.this.mConfig.mLoginSrc)) {
                        AccountFavHistoryLoginView.this.resetLoginStyle();
                        AccountFavHistoryLoginView.this.statisticUbcShow();
                        AccountFavHistoryLoginView.this.ubc4407Show();
                        if (AccountFavHistoryLoginView.this.mIsInitReady) {
                            UiThreadUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    if (AccountFavHistoryLoginView.this.isSMSLoginViewVisible()) {
                                        AccountFavHistoryLoginView.this.mAccountSMSLoginView.requestPhoneInputViewFocusAndShowKeyboard();
                                    }
                                }
                            });
                            if (!AccountFavHistoryLoginView.this.mHasShowed) {
                                UiThreadUtils.runOnUiThread(new Runnable() {
                                    public void run() {
                                        if (AccountFavHistoryLoginView.this.isSMSLoginViewVisible()) {
                                            AccountFavHistoryLoginView.this.mAccountSMSLoginView.requestPhoneInputViewFocusAndShowKeyboard();
                                        }
                                    }
                                }, 500);
                            }
                        }
                        boolean unused = AccountFavHistoryLoginView.this.mHasShowed = true;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void resetLoginStyle() {
        if (this.mSmsLoginLayout != null && this.mOneKeyLayout != null && this.mShareLayout != null) {
            if (this.mSmsLoginLayout.isShown()) {
                AccountBaseComponent.mLoginStyle = 0;
            } else if (this.mOneKeyLayout.isShown()) {
                AccountBaseComponent.mLoginStyle = 1;
            } else if (!this.mShareLayout.isShown()) {
            } else {
                if (this.boxShareLoginResult != null) {
                    AccountBaseComponent.mLoginStyle = 2;
                } else if (this.boxHistoryLoginResult != null) {
                    AccountBaseComponent.mLoginStyle = 7;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasShowed() {
        return this.mHasShowed;
    }

    /* access modifiers changed from: protected */
    public boolean isSMSPhoneViewRequestAutoFocus() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void initLayout() {
        this.mLoginContent = (LinearLayout) findViewById(R.id.login_content);
        this.mThirdSection = findViewById(R.id.third_section);
        this.mSmsLoginMaxTopMargin = (MaxHeightFrameLayout) findViewById(R.id.sms_login_max_top_margin);
        this.mCommonLayout = (RelativeLayout) findViewById(R.id.common_layout);
        this.mPhoneTitle = (TextView) findViewById(R.id.phone_title);
        this.mPhoneTitleLayout = (LinearLayout) findViewById(R.id.phone_title_layout);
        this.mHistoryLastLoginHint = (TextView) findViewById(R.id.share_last_login_hint);
        this.mFunctionIconIv = (ImageView) findViewById(R.id.function_icon);
        if (this.mSmsLoginLayout != null) {
            ViewGroup.MarginLayoutParams smsLoginLayoutParams = (ViewGroup.MarginLayoutParams) this.mSmsLoginLayout.getLayoutParams();
            smsLoginLayoutParams.topMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), SMS_LAYOUT_MARGIN_TOP);
            smsLoginLayoutParams.bottomMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), SMS_LAYOUT_MARGIN_BOTTOM);
        }
        setSpacing((ChangeTextViewSpace) this.mMainTitle, 4.0f);
    }

    public void showOneKeyLoginPanel(boolean needShowAgree) {
        int i2;
        this.mLoginContent.setGravity(17);
        setViewTopMargin(this.mFunctionIconIv, 0);
        setVisibility(this.mSmsLoginMaxTopMargin, 8);
        setSpacing(this.mPhone, 4.0f);
        setVisibility(this.mThirdTitleLayout, 8);
        setVisibility(this.mShareLayout, 8);
        setVisibility(this.mCommonLayout, 8);
        setVisibility(this.mSmsLoginLayout, 8);
        setVisibility(this.mOneKeyLayout, 0);
        setThirdLayoutVisility(0);
        boolean isNight = NightModeHelper.getNightModeSwitcherState();
        if (this.mPhoneTitle != null && this.boxOneKeyLoginResult != null) {
            this.mPhoneTitle.setText(this.boxOneKeyLoginResult.getOperatorServiceText());
            TextView textView = this.mPhoneTitle;
            if (isNight) {
                i2 = getResources().getColor(R.color.account_color_666666);
            } else {
                i2 = getResources().getColor(com.baidu.account.R.color.account_color_b8b8b8);
            }
            setTextColor(textView, i2);
        }
    }

    public void showShareLoginPanel() {
        shareHistoryStyle();
        setVisibility(this.mHistoryLastLoginHint, 8);
    }

    public void showHistoryLoginPanel() {
        int i2;
        if (AppConfig.isDebug()) {
            Log.d(TAG, "show history login panel");
        }
        shareHistoryStyle();
        if (FontSizeHelper.isFontSizeBigger()) {
            setVisibility(this.mHistoryLastLoginHint, 8);
        } else {
            setVisibility(this.mHistoryLastLoginHint, 0);
        }
        TextView textView = this.mHistoryLastLoginHint;
        if (isNight()) {
            i2 = AppRuntime.getAppContext().getResources().getColor(com.baidu.account.R.color.account_color_263678);
        } else {
            i2 = AppRuntime.getAppContext().getResources().getColor(com.baidu.account.R.color.account_color_4e6ef2);
        }
        setTextColor(textView, i2);
    }

    private void shareHistoryStyle() {
        this.mLoginContent.setGravity(17);
        setViewTopMargin(this.mFunctionIconIv, 0);
        setVisibility(this.mSmsLoginMaxTopMargin, 8);
        setVisibility(this.mThirdTitleLayout, 8);
        setVisibility(this.mOneKeyLayout, 8);
        setVisibility(this.mCommonLayout, 8);
        setVisibility(this.mSmsLoginLayout, 8);
        setVisibility(this.mShareLayout, 0);
        setThirdLayoutVisility(0);
    }

    public void initSMSLoginView() {
        if (this.mSmsLoginLayout != null) {
            if (this.mAccountSMSLoginView != null) {
                this.mSmsLoginLayout.removeView(this.mAccountSMSLoginView);
            }
            LoginParams loginParams = new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, this.mConfig.mLoginSrc)).setLoginMode(10).setLoginViewType(3).build();
            loginParams.mShowKeyBoard = false;
            this.mAccountSMSLoginView = (AccountSMSLoginView) ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).startBoxSmsLoginViewV2(this.mContext, loginParams, new ISmsLoginViewListener() {
                public void onResult(int resultCode) {
                }

                public void onCheckCodeViewShow() {
                    AccountFavHistoryLoginView.this.mAgreeCheckBox.setVisibility(8);
                    AccountFavHistoryLoginView accountFavHistoryLoginView = AccountFavHistoryLoginView.this;
                    accountFavHistoryLoginView.setViewTopMargin(accountFavHistoryLoginView.mSmsLoginLayout, DeviceUtils.ScreenInfo.dp2px(AccountFavHistoryLoginView.this.getContext(), AccountFavHistoryLoginView.SMS_CODE_LAYOUT_MARGIN_TOP));
                }

                public void onCheckCodeViewHide() {
                    AccountFavHistoryLoginView.this.updateCheckbox();
                    AccountFavHistoryLoginView accountFavHistoryLoginView = AccountFavHistoryLoginView.this;
                    accountFavHistoryLoginView.setViewTopMargin(accountFavHistoryLoginView.mSmsLoginLayout, DeviceUtils.ScreenInfo.dp2px(AccountFavHistoryLoginView.this.getContext(), AccountFavHistoryLoginView.SMS_LAYOUT_MARGIN_TOP));
                }

                public void onRegister() {
                }
            });
            this.mAccountSMSLoginView.setPhoneInputTextWatcher(new TextWatcher() {
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence text, int start, int before, int count) {
                    if (text == null || text.length() == 0) {
                        AccountFavHistoryLoginView.this.setThirdLayoutVisility(0);
                    } else {
                        AccountFavHistoryLoginView.this.setThirdLayoutVisility(8);
                    }
                }

                public void afterTextChanged(Editable s) {
                }
            });
            this.mAccountSMSLoginView.setPrivacyAgreementIntercept(new SmsLoginView.PrivacyAgreementIntercept() {
                public boolean across(int operation) {
                    AccountFavHistoryLoginView.this.statisticUbcOnSmsEvent("click");
                    return !AccountFavHistoryLoginView.this.shouldInterceptLoginAndShake();
                }
            });
            this.mSmsLoginLayout.addView(this.mAccountSMSLoginView);
            if (this.mAccountSMSLoginView != null && this.mAccountSMSLoginView.isShown()) {
                if (isSMSPhoneViewRequestAutoFocus()) {
                    this.mAccountSMSLoginView.requestPhoneInputViewFocusAndShowKeyboard();
                }
                setThirdLayoutVisility(!this.mAccountSMSLoginView.getLoginPhoneNumber().isEmpty() ? 8 : 0);
            }
            this.mAccountSMSLoginView.setTransparentBackground(this.transparentBackground);
            this.mAccountSMSLoginView.setHideSoftInputDelay(this.hideSoftInputDelay);
            this.mAccountSMSLoginView.setNightTheme(NightModeHelper.getNightModeSwitcherState());
            this.mAccountSMSLoginView.updateFontSize(this.mIsNeedUpdateFontSize, 0);
        }
    }

    public void showCommonLoginPanel(boolean isDeafultStyle) {
        initSMSLoginView();
        this.mLoginContent.setGravity(48);
        setViewTopMargin(this.mFunctionIconIv, -DeviceUtils.ScreenInfo.dp2px(getContext(), 90.0f));
        this.mSmsLoginMaxTopMargin.setMaxHeight(DeviceUtils.ScreenInfo.dp2px(getContext(), 229.0f));
        setVisibility(this.mSmsLoginMaxTopMargin, 0);
        setVisibility(this.mSmsLoginLayout, 0);
        setVisibility(this.mThirdTitleLayout, 0);
        setThirdLayoutVisility(0);
        setVisibility(this.mCommonLayout, 8);
        setVisibility(this.mShareLayout, 8);
        setVisibility(this.mOneKeyLayout, 8);
    }

    public void showWXEnhanceLoginPanel() {
    }

    /* access modifiers changed from: protected */
    public String getLoginScene() {
        return "fullscreen";
    }

    /* access modifiers changed from: protected */
    public void setViewTopMargin(View view2, int topMargin) {
        if (view2 != null && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            layoutParams.topMargin = topMargin;
            view2.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void updateUI() {
        super.updateUI();
        setVisibility(this.mFunctionIconIv, 8);
        if (this.mConfig != null && this.mConfig.mFunctionIconDrawable != null) {
            Drawable drawable = this.mConfig.mFunctionIconDrawable;
            if (NightModeHelper.getNightModeSwitcherState()) {
                if (this.mConfig.mFunctionIconNightDrawable != null) {
                    drawable = this.mConfig.mFunctionIconNightDrawable;
                } else {
                    drawable.setColorFilter(createNightColorFilter());
                }
            }
            ImageView imageView = this.mFunctionIconIv;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
                setVisibility(this.mFunctionIconIv, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int visibility) {
        BoxAccountManager manager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (visibility == 0 && manager.isGuestLogin()) {
            showGuestLoginView();
        }
    }

    /* access modifiers changed from: protected */
    public void statisticUbcShowWithCondition() {
    }

    /* access modifiers changed from: protected */
    public void statisticUbcCommonRoutineOnShowWithCondition() {
        IUBCWhenUiUpdateListener iUBCWhenUiUpdateListener = this.mUIReadyUbcListener;
        if (iUBCWhenUiUpdateListener != null) {
            iUBCWhenUiUpdateListener.onUpdate();
        }
    }

    /* access modifiers changed from: protected */
    public String getCommonLoginValue() {
        return BoxAccountContants.LOGIN_VALUE_LOGIN_NEW;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BdEventBus.Companion.getDefault().unregister(this);
        this.mSoftInputHelper.removeOnGlobalLayoutListener();
    }

    private void setSpacing(ChangeTextViewSpace view2, float spacing) {
        if (view2 != null) {
            view2.setSpacing(spacing);
        }
    }

    private void showGuestLoginView() {
        if (this.mGuestLoginView == null) {
            AccountFavHistoryGuestLoginView accountFavHistoryGuestLoginView = new AccountFavHistoryGuestLoginView(getContext(), (IAccountComponentCallback) null);
            this.mGuestLoginView = accountFavHistoryGuestLoginView;
            accountFavHistoryGuestLoginView.initData(this.mConfig);
        }
        ViewGroup viewParent = (ViewGroup) getParent();
        if (viewParent != null) {
            viewParent.removeView(this);
            if (this.mGuestLoginView.getParent() != null) {
                ((ViewGroup) this.mGuestLoginView.getParent()).removeView(this.mGuestLoginView);
            }
            viewParent.addView(this.mGuestLoginView);
        }
    }

    public void destroy() {
        BdEventBus.Companion.getDefault().unregister(this);
        if (this.mAccountSMSLoginView != null) {
            this.mAccountSMSLoginView.close();
        }
    }

    /* access modifiers changed from: protected */
    public String getPanelPriority() {
        ArrayList<String> supportLoginStyles = getSupportLoginStyles();
        String panelPriority = supportLoginStyles.get(0);
        String prioritySP = getCloudControlPriority();
        if (TextUtils.isEmpty(prioritySP)) {
            return panelPriority;
        }
        for (String priority : prioritySP.split("_")) {
            if (supportLoginStyles.contains(priority)) {
                return priority;
            }
        }
        return panelPriority;
    }

    /* access modifiers changed from: protected */
    public String getCloudControlPriority() {
        return DefaultSharedPrefsWrapper.getInstance().getString("account_favhistory_priority", "share_onekey_history_normal");
    }

    public void setUiReadyUbcListener(IUBCWhenUiUpdateListener uiReadyUbcListener) {
        this.mUIReadyUbcListener = uiReadyUbcListener;
    }
}
