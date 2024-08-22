package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.c.a;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.PwdPayPresenterFactory;
import com.baidu.wallet.paysdk.presenter.PwdPayPresenterForCashdesk;
import com.baidu.wallet.paysdk.presenter.PwdPayPresenterForScancode;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.LicaiBalancePayLoading;
import com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew;
import com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.SixNumberPwdView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class PwdPayActivity extends HalfScreenBaseActivity implements View.OnClickListener, SixNumberPwdView.OnPwdChangedListener {
    public static final String PWD_PAY_HASH_ID = "paySDKPwdPayPage";
    public static final String PWD_PAY_HASH_NAME = "输入密码页面";
    public static final String TAG = "PwdPayActivity";
    public RelativeLayout a;
    public View b;
    public TextView c;
    public View d;
    public SafeScrollView e;
    public SafeKeyBoardEditText f;
    public TextView g;
    public TextView h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f3616i;
    public SixNumberPwdView j;
    public PayLoadingImageViewNew k;
    public View l;
    public SuccessImageViewNew m;
    public PwdPayContract.Presenter mPresenter;
    public PwdRequest n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3617o;
    public boolean p;
    public boolean q;
    public AtomicBoolean r = new AtomicBoolean(false);
    public LicaiBalancePayLoading s;
    public boolean t = false;
    public View u;
    public CheckBox v;
    public TextView w;
    public boolean x = true;
    public int y = 4;

    /* access modifiers changed from: private */
    public void e() {
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        this.d.setVisibility(0);
    }

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_pwd_pay_layout"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void dismissLoading(int i2) {
        this.mActionBar.setVisibility(0);
        this.f3617o = false;
        this.e.setVisibility(0);
        this.e.dismissKeyBoard(this.f);
        if (a.a().b() || (a.a().c() && a.a().e() != null)) {
            this.s.setVisibility(8);
            return;
        }
        this.k.stopAnimation();
        this.k.setVisibility(8);
    }

    public void doLivingPay() {
        PwdPayContract.Presenter presenter = this.mPresenter;
        if (presenter instanceof PwdPayPresenterForCashdesk) {
            ((PwdPayPresenterForCashdesk) presenter).doPay();
        }
    }

    public void doVerifyFingerprint(final IFingerprintPay iFingerprintPay) {
        this.j.resetPwd();
        PwdRequest pwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
        this.n = pwdRequest;
        if (pwdRequest != null) {
            pwdRequest.mPayPass = null;
            pwdRequest.mConfirmPayPass = null;
        }
        if (this.r.compareAndSet(false, true)) {
            setPageTransparent(true);
        }
        if (iFingerprintPay == null) {
            GlobalUtils.toast(this.mAct, "手机不支持指纹支付", 1);
            return;
        }
        StatisticManager.onEventStart(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION);
        iFingerprintPay.verify(getActivity(), new FingerprintCallback() {
            public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                PwdPayActivity.this.r.set(false);
                if (action == IFingerprintPay.Action.VERIFY) {
                    if (i2 == 0) {
                        StatHelper.cacheCodeAndMsg(i2 + "", StatHelper.SENSOR_OK);
                    } else {
                        StatHelper.cacheCodeAndMsg(i2 + "", str);
                    }
                    if (i2 == 0) {
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION, (Map<String, Object>) null, new String[0]);
                        PwdPayActivity.this.mPresenter.onFPCheckOK(str);
                    } else if (i2 == 1) {
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION, (Map<String, Object>) null, new String[0]);
                        PwdPayActivity.this.mPresenter.onFPCheckCancel();
                    } else if (i2 == 3) {
                        PwdPayActivity.this.turntoPwdPay(false, (String) null);
                    } else {
                        PwdPayActivity.this.turntoPwdPay(true, str);
                    }
                }
                iFingerprintPay.destory();
            }
        });
    }

    public void forgetPassword() {
        this.j.resetPwd();
        String findPayPwdUrl = SdkInitResponse.getInstance().getFindPayPwdUrl(getActivity());
        if (TextUtils.isEmpty(findPayPwdUrl)) {
            findPayPwdUrl = DxmPayBeanConstants.API_FIND_PAY_PWD_URL;
        }
        BaiduWalletDelegate.getInstance().openH5Module(getActivity(), findPayPwdUrl, false);
        this.t = true;
    }

    public void handleErrorContent() {
        this.mPresenter.handleActivityError();
    }

    public void handleFailure(int i2, int i3, String str) {
        if (i2 != 12) {
            dismissLoading(-1);
        }
        super.handleFailure(i2, i3, str);
    }

    public void handleResponse(int i2, Object obj, String str) {
        PwdPayContract.Presenter presenter = this.mPresenter;
        if ((presenter instanceof PwdPayPresenterForScancode) && i2 == 12) {
            presenter.handleResponse(i2, obj, str);
        }
        super.handleResponse(i2, obj, str);
    }

    public void hideFullScreenLoading() {
        PwdPayContract.Presenter presenter = this.mPresenter;
        if ((presenter instanceof PwdPayPresenterForCashdesk) && ((PwdPayPresenterForCashdesk) presenter).shouldFullScreenLoading()) {
            showLikeDismissLadingPage();
        }
    }

    public boolean isGatewaySignPay() {
        return this.q;
    }

    public void onBackPressed() {
        if (!this.f3617o && this.mPresenter.directQuit()) {
            StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "pwdPayCancel");
            boolean z = this.p;
            String str = PayStatServiceEvent.PAY_BIND_CARD_DURATION;
            String str2 = PayStatServiceEvent.PAY_BIND_CARD_FAILED;
            if (z) {
                HashMap hashMap = new HashMap();
                hashMap.put(StatHelper.HASH_NAME, BindCardImplActivity.PAY_BIND_CARD_HASH_NAME);
                hashMap.put("hash", BindCardImplActivity.PAY_BIND_CARD_HASH_ID);
                hashMap.put(StatHelper.EVENT_TAG, "绑卡失败");
                hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
                hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
                hashMap.put(StatHelper.EVENT_PATH, "paySDK_pay_bind_card_failed");
                hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
                StatHelper.statServiceEvent(str2, hashMap, StatHelper.SENSOR_ERR_2, "payBindCardCancel");
                StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "payBindCardCancel");
                StatHelper.payEventEndWithValues(str, (Map<String, Object>) null, new String[0]);
            } else {
                String str3 = str2;
                if (b.a()) {
                    String str4 = str3;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(StatHelper.HASH_NAME, BindCardImplActivity.PAY_BIND_CARD_HASH_NAME);
                    hashMap2.put("hash", BindCardImplActivity.PAY_BIND_CARD_HASH_ID);
                    hashMap2.put(StatHelper.EVENT_TAG, "绑卡失败");
                    hashMap2.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
                    hashMap2.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
                    hashMap2.put(StatHelper.EVENT_PATH, "paySDK_pay_bind_card_failed");
                    hashMap2.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
                    StatHelper.statServiceEvent(str4, hashMap2, StatHelper.SENSOR_ERR_2, "authorizeBindCardCancel");
                    StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "authorizeBindCardCancel");
                    StatHelper.payEventEndWithValues(str, (Map<String, Object>) null, new String[0]);
                }
            }
            super.onBackPressed();
        }
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        dismissLoading(-1);
        this.j.resetPwd();
        if (!this.mPresenter.onBeanExecFailureWithErrContent(i2, i3, str, obj)) {
            super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
        }
    }

    public void onClick(View view) {
        if (view == this.d) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_FORGET_PWD_IN_CASHDESK);
            forgetPassword();
        } else if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.mRightTxt) {
            this.mPresenter.pwdAndFpTypeChange();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        getActivity().getWindow().setSoftInputMode(2);
        if (bundle == null) {
            Intent intent = this.mAct.getIntent();
            if (intent != null) {
                this.y = intent.getIntExtra(PwdPayPresenterFactory.PWDPAYACTIVITY_FROM_KEY, -1);
                this.q = intent.getBooleanExtra("gatewaySign", false);
                this.p = intent.getBooleanExtra("IS_FOR_BIND_CARD_PAY", false);
            }
        } else {
            this.y = bundle.getInt("forwhat");
            this.q = bundle.getBoolean("gatewaySign", false);
            this.p = bundle.getBoolean("isforBindCardPay", false);
        }
        c();
        PwdPayContract.Presenter a2 = PwdPayPresenterFactory.a(this.y, this);
        this.mPresenter = a2;
        if (a2 == null) {
            PayCallBackManager.callBackClientCancel(this, "PwdPayActivityonCreate().1");
            return;
        }
        a2.onCreate(bundle);
        if (bundle != null) {
            this.f3617o = bundle.getBoolean("isloading");
            this.p = bundle.getBoolean("isforBindCardPay");
        }
        EventBus.getInstance().register((Object) this, DxmPayBeanConstants.EVT_PAY_PWD_CHANGE, 0, EventBus.ThreadMode.MainThread);
        StatHelper.statPayAllServiceEvent(PayStatServiceEvent.ENTER_PWD_PAY_ACTIVITY, PWD_PAY_HASH_NAME, PWD_PAY_HASH_ID, "进入", new String[0]);
        if (PayRequestCache.getInstance().isPaying()) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            if (payRequest == null || payRequest.getPayWay() != 3) {
                this.x = false;
            } else {
                this.x = true;
            }
            if (this.x) {
                StatisticManager.onEventStart(PayStatServiceEvent.PAY_CHECK_PWD_DURATION);
            }
        }
        a();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.x) {
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_PWD_DURATION, (Map<String, Object>) null, new String[0]);
        }
        BeanManager.getInstance().removeAllBeans(TAG);
        if (this.t) {
            PasswordController.getPassWordInstance().clearForgetPasswdCallback();
        }
        PwdPayContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onDestroy();
        }
        LicaiBalancePayLoading licaiBalancePayLoading = this.s;
        if (licaiBalancePayLoading != null) {
            licaiBalancePayLoading.destoryView();
        }
        this.mPresenter = null;
        EventBus.getInstance().unregister(this);
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !DxmPayBeanConstants.EVT_PAY_PWD_CHANGE.equals(event.mEventKey)) {
            super.onModuleEvent(event);
        } else if (event.mEventObj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                if (jSONObject.has("is_succeed") && 1 == jSONObject.getInt("is_succeed")) {
                    if (this.n != null) {
                        PayRequestCache.getInstance().addBeanRequestToCache(this.n.getRequestId(), this.n);
                    }
                    if (this.c != null) {
                        this.c.setVisibility(8);
                    }
                    int i2 = 0;
                    try {
                        i2 = jSONObject.getInt("is_bind_card");
                    } catch (Exception e2) {
                        LogUtil.e(TAG, e2.getMessage(), e2);
                    }
                    if (1 == i2 && PayRequestCache.getInstance().isPaying() && this.c != null) {
                        this.c.postDelayed(new Runnable() {
                            public void run() {
                                BaseActivity.clearTasksTopOf(PwdPayActivity.this);
                                BaiduPayDelegate.getInstance().reOrderPay(PwdPayActivity.this.getActivity());
                            }
                        }, 1000);
                    }
                }
            } catch (Exception e3) {
                LogUtil.e(TAG, e3.getMessage(), e3);
            }
        }
    }

    public void onNegativeBtnClick() {
        PwdPayContract.Presenter presenter = this.mPresenter;
        if (presenter == null || !presenter.dialogNevigateOper_QuitCashDesk()) {
            PwdPayContract.Presenter presenter2 = this.mPresenter;
            if (presenter2 != null && presenter2.dialogNevigateOper_QuitCurrentPage()) {
                finishWithoutAnim();
                return;
            }
            return;
        }
        PayCallBackManager.callBackClientCancel(this, "PwdPayActivityonNegativeBtnClick().1");
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 12) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage((CharSequence) this.mDialogMsg);
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 12);
                    PwdPayActivity.this.onNegativeBtnClick();
                }
            });
            promptDialog.hideNegativeButton();
        } else if (i2 == 17) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage((CharSequence) this.mDialogMsg);
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.findViewById(ResUtils.id(this, "positive_btn")).setContentDescription(ResUtils.getString(this, "wallet_access_retrieve_password_action_dec"));
            promptDialog2.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_find_password"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PwdPayActivity pwdPayActivity = PwdPayActivity.this;
                    pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_find_password"));
                    StatisticManager.onEvent(StatServiceEvent.EVENT_FIND_PWD_FROM_PWD_OVER_LIMIT);
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 17);
                    PwdPayActivity.this.e();
                    PwdPayActivity.this.forgetPassword();
                }
            });
            promptDialog2.setNegativeBtn(ResUtils.getString(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PwdPayActivity pwdPayActivity = PwdPayActivity.this;
                    pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "dxm_ebpay_know"));
                    StatisticManager.onEvent(StatServiceEvent.EVENT_IGNOREPWD_OVER_LIMIT);
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 17);
                    PwdPayActivity.this.e();
                }
            });
        } else if (i2 == 36) {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage((CharSequence) this.mDialogMsg);
            promptDialog3.setNegativeBtn(ResUtils.getString(this, "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 36);
                    PwdPayActivity.this.onNegativeBtnClick();
                }
            });
            promptDialog3.setPositiveBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 36);
                    PayController.getInstance().gotoPayTypePage(PwdPayActivity.this, false);
                    PwdPayActivity.this.finishWithoutAnim();
                }
            });
        } else if (i2 != 37) {
            super.onPrepareDialog(i2, dialog);
        } else {
            PromptDialog promptDialog4 = (PromptDialog) dialog;
            promptDialog4.setMessage((CharSequence) this.mDialogMsg);
            promptDialog4.setNegativeBtn(ResUtils.getString(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PwdPayActivity pwdPayActivity = PwdPayActivity.this;
                    pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "dxm_ebpay_know"));
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 37);
                    PwdPayActivity.this.onNegativeBtnClick();
                }
            });
            promptDialog4.setPositiveBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PwdPayActivity pwdPayActivity = PwdPayActivity.this;
                    pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_use_other_paytype"));
                    WalletGlobalUtils.safeDismissDialog(PwdPayActivity.this, 37);
                    PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
                    if (payRequest != null) {
                        payRequest.clearMktSolution();
                    }
                    PayController.getInstance().gotoPayTypePage(PwdPayActivity.this, false);
                    PwdPayActivity.this.finishWithoutAnim();
                }
            });
        }
    }

    public void onPwdChanged(int i2) {
        if (i2 == 6) {
            StatHelper.statPayAllServiceEvent(StatServiceEvent.EVENT_FINISH_INPUTPWD_IN_CASHDESK, PWD_PAY_HASH_NAME, PWD_PAY_HASH_ID, "输入密码完成", new String[0]);
            this.mPresenter.onPwdChanged(this.j.getPwd());
            return;
        }
        this.c.setVisibility(8);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("isloading", Boolean.valueOf(this.f3617o));
        bundle.putSerializable("pwdrequest", this.n);
        bundle.putSerializable("isforBindCardPay", Boolean.valueOf(this.p));
        bundle.putSerializable("gatewaySign", Boolean.valueOf(this.q));
        bundle.putSerializable("forwhat", Integer.valueOf(this.y));
        this.mPresenter.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            b();
        }
    }

    public void reFreshUI(Object obj) {
    }

    public void rightTextShow(boolean z, String str) {
        if (z) {
            this.mRightTxt.setVisibility(0);
            this.mRightTxt.setOnClickListener(this);
            if (str != null) {
                this.mRightTxt.setText(str);
            }
            this.mRightTxt.setTextColor(ResUtils.getColor(this, "wallet_base_primary_color"));
            String string = ResUtils.getString(this, "wallet_access_password_pay");
            if (ResUtils.getString(this, "wallet_access_fingerprint_pay").equals(str)) {
                this.mRightTxt.setContentDescription(ResUtils.getString(this, "wallet_access_change_to_fingerprint_pay"));
            } else if (string.equals(str)) {
                this.mRightTxt.setContentDescription(ResUtils.getString(this, "wallet_access_change_to_password_pay"));
            } else {
                TextView textView = this.mRightTxt;
                textView.setContentDescription(textView.getText());
            }
        } else {
            this.mRightTxt.setVisibility(8);
        }
    }

    public void setErrorArea(boolean z) {
        this.b.setVisibility(z ? 0 : 8);
    }

    public void setErrorTips(boolean z, String str) {
        this.c.setVisibility(z ? 0 : 8);
        if (str != null) {
            this.c.setText(str);
        }
    }

    public void setPresenter(PwdPayContract.Presenter presenter) {
    }

    public void setTitleText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.g.setText(str);
        }
    }

    public void showLoading(int i2) {
        this.mActionBar.setVisibility(4);
        this.f3617o = true;
        this.e.setVisibility(8);
        this.e.dismissKeyBoard(this.f);
        if (a.a().b() || (a.a().c() && a.a().e() != null)) {
            this.s.initView();
            this.s.setVisibility(0);
            return;
        }
        this.k.setVisibility(0);
        this.k.startAnimation();
    }

    public void showPWdInputView(boolean z) {
        if (z) {
            this.e.setVisibility(0);
            this.j.resetPwd();
            return;
        }
        this.e.setVisibility(8);
        this.e.dismissKeyBoard(this.f);
    }

    public void showPassError(String str) {
        if (AccessibilityUtils.isAccessibilityEnabled(this.mAct)) {
            b();
        }
        this.b.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.c.setText(str);
        }
        if (!TextUtils.isEmpty(str)) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        this.d.setVisibility(0);
        this.f.initSafeKeyBoardParams(this.a, this.e, this.j, true);
    }

    public void showPaySuccessPage(final boolean z, final PayResultContent payResultContent, final int i2) {
        PwdPayContract.Presenter presenter = this.mPresenter;
        if (presenter == null || presenter.showSucAnim()) {
            dismissLoading(-1);
            this.f3617o = true;
            this.mActionBar.setVisibility(4);
            this.e.setVisibility(8);
            if (a.a().b() || (a.a().c() && a.a().e() != null)) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
            }
            this.m.startAnimation(new SuccessImageViewNew.a() {
                public void a() {
                    if (z) {
                        PayController.getInstance().paySucess(PwdPayActivity.this, payResultContent, i2);
                    } else {
                        PayController.getInstance().payPaying(PwdPayActivity.this, payResultContent, i2);
                    }
                }
            });
        } else if (z) {
            PayController.getInstance().paySucess(this, payResultContent, 1);
        } else {
            PayController.getInstance().payPaying(this, payResultContent, 1);
        }
    }

    public void showWarningTips(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.h.setText(str);
            this.h.setVisibility(0);
        }
    }

    public void turntoPwdPay(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("pay_from", StatHelper.getPayFrom());
        ArrayList arrayList = new ArrayList();
        arrayList.add(StatHelper.getOrderNo());
        hashMap.put(StatHelper.PAY_WAY, "0");
        StatisticManager.onEventWithValues(PayStatServiceEvent.CHANGE_PAY_WAY, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION, (Map<String, Object>) null, new String[0]);
        this.mPresenter.onTurntoPwdPay(z);
        showLikeLoadingPage(false);
        showWarningTips(str);
        a();
    }

    private void b() {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (payRequest != null && payRequest.getPayWay() == 3 && this.f != null && !payRequest.isPayByMktSolution) {
            PayLoadingImageViewNew payLoadingImageViewNew = this.k;
            if (payLoadingImageViewNew == null || payLoadingImageViewNew.getVisibility() != 0) {
                LicaiBalancePayLoading licaiBalancePayLoading = this.s;
                if (licaiBalancePayLoading == null || licaiBalancePayLoading.getVisibility() != 0) {
                    this.f.requestFocus();
                }
            }
        }
    }

    private void c() {
        this.mActionBar.setVisibility(0);
        this.a = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "ebpay_pwdpay_layout"));
        SafeScrollView safeScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
        this.e = safeScrollView;
        safeScrollView.setVisibility(0);
        setSafeScrollView(this.e);
        this.g = (TextView) findViewById(ResUtils.id(this, "ebpay_pwd_title"));
        TextView textView = (TextView) findViewById(ResUtils.id(this, "warning_tips"));
        this.h = textView;
        textView.setVisibility(4);
        SixNumberPwdView sixNumberPwdView = (SixNumberPwdView) findViewById(ResUtils.id(this, "pwd_input_box"));
        this.j = sixNumberPwdView;
        sixNumberPwdView.setShowInputMethod(true);
        this.j.addSixNumberPwdChangedListenter(this);
        SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.j.findViewById(ResUtils.id(getActivity(), "pwd_input"));
        this.f = safeKeyBoardEditText;
        safeKeyBoardEditText.initSafeKeyBoardParams(this.a, this.e, this.j, false);
        this.f.setDisablePast(true);
        this.f.setGap(20);
        View findViewById = findViewById(ResUtils.id(this, "bd_wallet_pwd_error_layout"));
        this.b = findViewById;
        findViewById.setVisibility(0);
        TextView textView2 = (TextView) findViewById(ResUtils.id(this, "error_tip"));
        this.c = textView2;
        textView2.setVisibility(8);
        View findViewById2 = findViewById(ResUtils.id(this, "forget_pwd"));
        this.d = findViewById2;
        AccessibilityUtils.changeRoleDescription(findViewById2, ResUtils.getString(this, "wallet_access_button"));
        this.d.setVisibility(0);
        this.d.setOnClickListener(this);
        PayLoadingImageViewNew payLoadingImageViewNew = (PayLoadingImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_cashier_loading_view"));
        this.k = payLoadingImageViewNew;
        payLoadingImageViewNew.setVisibility(8);
        View findViewById3 = findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
        this.l = findViewById3;
        findViewById3.setVisibility(8);
        this.m = (SuccessImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
        this.mLeftImg.setOnClickListener(this);
        this.mLeftImg.setContentDescription(ResUtils.getString(this, "wallet_access_back"));
        this.u = findViewById(ResUtils.id(this, "protocol_display_area"));
        this.v = (CheckBox) findViewById(ResUtils.id(this, "ebpay_protocol"));
        this.w = (TextView) findViewById(ResUtils.id(this, "ebpay_protocol_text"));
        this.f3616i = (TextView) findViewById(ResUtils.id(this, "ebpay_protocol_msg"));
        LicaiBalancePayLoading licaiBalancePayLoading = (LicaiBalancePayLoading) findViewById(ResUtils.id(this, "dxm_wallet_licai_balance_loading"));
        this.s = licaiBalancePayLoading;
        licaiBalancePayLoading.setVisibility(8);
    }

    private void d() {
        final PwdPayContract.protocolModel needshowProtocolContainer = this.mPresenter.needshowProtocolContainer();
        if (needshowProtocolContainer == null || TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_msg) || TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_prefix) || TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_url)) {
            this.u.setVisibility(8);
            return;
        }
        this.w.setText(needshowProtocolContainer.passfree_protocol_prefix);
        this.f3616i.setText(needshowProtocolContainer.passfree_protocol_msg);
        this.f3616i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaiduWalletDelegate.getInstance().openH5Module(PwdPayActivity.this, needshowProtocolContainer.passfree_protocol_url, false);
            }
        });
        this.v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                needshowProtocolContainer.iClickCallback.onProtocolClicked(z);
            }
        });
        this.v.setChecked(needshowProtocolContainer.checked);
        this.c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (PwdPayActivity.this.c.getVisibility() == 0) {
                    PwdPayActivity.this.u.setVisibility(8);
                } else {
                    PwdPayActivity.this.u.setVisibility(0);
                }
            }
        });
        this.u.setVisibility(0);
    }

    private void a() {
        d();
    }
}
