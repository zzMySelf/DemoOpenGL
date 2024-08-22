package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.a;
import com.baidu.wallet.paysdk.beans.b;
import com.baidu.wallet.paysdk.beans.l;
import com.baidu.wallet.paysdk.beans.m;
import com.baidu.wallet.paysdk.beans.v;
import com.baidu.wallet.paysdk.beans.w;
import com.baidu.wallet.paysdk.beans.z;
import com.baidu.wallet.paysdk.datamodel.AuthorizeInfo;
import com.baidu.wallet.paysdk.datamodel.BalancePayResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.SixNumberPwdView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PwdSetAndConfirmActivity extends PayBaseActivity implements SixNumberPwdView.OnPwdChangedListener {
    public boolean a = false;
    public View b;
    public TextView c;
    public TextView d;
    public SixNumberPwdView e;
    public TextView f;
    public View g;
    public SafeKeyBoardEditText h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f3618i;
    public SafeScrollView j;
    public RelativeLayout k;
    public PwdRequest l;
    public BindFastRequest m;
    public PayRequest n;

    /* renamed from: o  reason: collision with root package name */
    public m f3619o;
    public l p;
    public z q;
    public b r;
    public CountDownTimer s;
    public final int t = 1;
    public final int u = 2;
    public final int v = 18;

    private void b() {
        this.f.setVisibility(8);
    }

    private void c() {
        this.a = true;
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        if (this.q == null) {
            this.q = (z) PayBeanFactory.getInstance().getBean((Context) getActivity(), 13, "PwdSetAndConfirmActivity");
        }
        this.q.setResponseCallback(this);
        StatHelper.cachePayType(0);
        StatHelper.cachePayWay(4);
        this.q.execBean();
    }

    private void d() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        if (this.q == null) {
            this.q = (z) PayBeanFactory.getInstance().getBean((Context) this, 13, "PwdSetAndConfirmActivity");
        }
        this.q.setResponseCallback(this);
        StatHelper.cachePayType(0);
        StatHelper.cachePayWay(3);
        this.q.execBean();
    }

    private void e() {
        this.a = true;
        WalletGlobalUtils.safeShowDialog(this.mAct, 0, "");
        a aVar = (a) PayBeanFactory.getInstance().getBean((Context) this.mAct, 14, "PwdSetAndConfirmActivity");
        aVar.setResponseCallback(this);
        aVar.execBean();
    }

    private void f() {
        this.a = true;
        WalletGlobalUtils.safeShowDialog(this.mAct, 0, "");
        v vVar = (v) PayBeanFactory.getInstance().getBean((Context) this.mAct, (int) PayBeanFactory.BEAN_ID_LICAI_BALANCE_PAY, "PwdSetAndConfirmActivity");
        vVar.setResponseCallback(this);
        vVar.execBean();
    }

    private void g() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        if (this.r == null) {
            this.r = (b) PayBeanFactory.getInstance().getBean((Context) getActivity(), 513, "PwdSetAndConfirmActivity");
        }
        this.r.a(this.m);
        this.r.setResponseCallback(this);
        this.r.execBean();
    }

    private void h() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        this.l.mConfirmPayPass = getPwdConfirm();
        if (this.f3619o == null) {
            this.f3619o = (m) PayBeanFactory.getInstance().getBean((Context) getActivity(), (int) PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD, "PwdSetAndConfirmActivity");
        }
        this.m.getBindFromOrigin();
        this.f3619o.a(this.m);
        this.f3619o.setResponseCallback(this);
        this.f3619o.execBean();
    }

    private void i() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        this.l.mConfirmPayPass = getPwdConfirm();
        if (this.p == null) {
            this.p = (l) PayBeanFactory.getInstance().getBean((Context) getActivity(), (int) PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, "PwdSetAndConfirmActivity");
        }
        this.p.setResponseCallback(this);
        this.p.execBean();
    }

    private void j() {
        this.l.mConfirmPayPass = getPwdConfirm();
        this.l.mRequestType = 3;
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        w wVar = (w) PayBeanFactory.getInstance().getBean((Context) getActivity(), (int) PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD, "PwdSetAndConfirmActivity");
        wVar.setResponseCallback(this);
        wVar.execBean();
    }

    private void k() {
        WalletGlobalUtils.safeDismissDialog(this, 0);
        int bindFromOrigin = this.m.getBindFromOrigin();
        if (bindFromOrigin == 4) {
            PasswordController.getPassWordInstance().setPwdSucceed(getPwdConfirm());
            EventBus instance = EventBus.getInstance();
            instance.getClass();
            instance.post(new EventBus.Event(DxmPayBeanConstants.EV_BANK_DETAIL_CARD_CHANGE, (Object) null));
        } else if (bindFromOrigin != 5) {
            PasswordController.getPassWordInstance().setPwdSucceed(getPwdConfirm());
            EventBus instance2 = EventBus.getInstance();
            instance2.getClass();
            instance2.post(new EventBus.Event(DxmPayBeanConstants.EV_BANK_DETAIL_CARD_CHANGE, (Object) null));
        } else {
            PasswordController.getPassWordInstance().setPassByUserSucceed("");
            BaseActivity.clearTasksWithFlag(1);
        }
        if (this.m.mUseNewCardFindPwd && PayRequestCache.getInstance().isPaying()) {
            BaiduPayDelegate.getInstance().reOrderPay(getActivity());
        }
    }

    private void l() {
        this.e.resetPwd();
        b();
    }

    public String getPwdConfirm() {
        return this.e.getPwd();
    }

    public void handleConfirmPwd() {
        this.a = false;
        int i2 = this.l.mFrom;
        if (i2 == 0) {
            switch (this.m.getmBindFrom()) {
                case 0:
                    PayRequest payRequest = this.n;
                    if (payRequest == null || payRequest.getPayPrice() == null) {
                        c();
                        return;
                    } else if (this.n.getPayPrice().payType == PayRequest.PayPrice.PayType.BALANCE) {
                        e();
                        return;
                    } else if (this.n.getPayPrice().payType == PayRequest.PayPrice.PayType.LICAIBALANCE) {
                        f();
                        return;
                    } else {
                        c();
                        return;
                    }
                case 1:
                    g();
                    return;
                case 2:
                    c();
                    return;
                case 3:
                    h();
                    return;
                case 4:
                    i();
                    return;
                case 5:
                    i();
                    return;
                case 6:
                case 7:
                case 8:
                    d();
                    return;
                default:
                    return;
            }
        } else if (i2 == 2) {
            j();
        }
    }

    public void handleFailure(int i2, int i3, String str) {
        l();
        WalletGlobalUtils.safeDismissDialog(this, 0);
        if ((i3 == 100038 || (i3 >= 16420 && i3 <= 16439)) && i2 != 12) {
            a(str);
        } else if (i2 == 259) {
            this.mDialogMsg = str;
            WalletGlobalUtils.safeShowDialog(this, 3, "");
        } else if (i2 == 260) {
            GlobalUtils.toast(getActivity(), str);
        } else if (i2 == 524) {
            int i4 = this.m.mBindFrom;
            if (i4 == 5 || i4 == 4) {
                GlobalUtils.toast(getActivity(), str);
            }
        } else if (i2 == 13 || i2 == 513 || i2 == 14) {
            this.mDialogMsg = str;
            WalletGlobalUtils.safeShowDialog(this, 3, "");
            if (i2 == 13) {
                StatisticManager.onEventWithValue("bindPayAcceptFail", String.valueOf(i3));
                BindFastRequest bindFastRequest = this.m;
                if (bindFastRequest != null) {
                    if (bindFastRequest.getmBindFrom() == 0 || this.m.getmBindFrom() == 6) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(StatHelper.HASH_NAME, BindCardImplActivity.PAY_BIND_CARD_HASH_NAME);
                        hashMap.put("hash", BindCardImplActivity.PAY_BIND_CARD_HASH_ID);
                        hashMap.put(StatHelper.EVENT_TAG, "绑卡失败");
                        hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
                        hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
                        hashMap.put(StatHelper.EVENT_PATH, "paySDK_pay_bind_card_failed");
                        hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_FAILED, hashMap, i3 + "", str);
                        StatHelper.cacheCodeAndMsg(i3 + "", str);
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, (Map<String, Object>) null, new String[0]);
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SET_PWD_DURATION, (Map<String, Object>) null, new String[0]);
                    } else if (this.m.getmBindFrom() == 2) {
                        StatHelper.cacheCodeAndMsg(i3 + "", str);
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SET_PWD_DURATION, (Map<String, Object>) null, new String[0]);
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_COMPLETION_BANK_CARD_DURATION, (Map<String, Object>) null, new String[0]);
                    }
                }
            } else {
                String sessionId = StatHelper.getSessionId();
                List<String> collectData = StatHelper.collectData(sessionId, i3 + "", str);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, (Collection<String>) collectData, (Map<String, Object>) hashMap2);
            }
            if (55000 == i3 || 55001 == i3) {
                new SMManagerDelegate().deleteUserKeyId(this.mAct);
            }
        } else {
            super.handleFailure(i2, i3, str);
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        BindFastRequest bindFastRequest;
        if (i2 == 259) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            PasswordController.getPassWordInstance().editPwdSucceed(getPwdConfirm());
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_modify_success"));
            BaseActivity.clearTasksWithFlag(1);
        } else if (i2 == 260) {
            k();
        } else if (i2 == 524) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            int i3 = this.m.mBindFrom;
            if (i3 == 5) {
                PasswordController.getPassWordInstance().setPassByUserSucceed("");
                BaseActivity.clearTasksWithFlag(1);
            } else if (i3 == 4) {
                PasswordController.getPassWordInstance().setPwdSucceed(getPwdConfirm());
            }
        } else if (i2 == 513) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            PayRequest payRequest = this.n;
            if (payRequest == null || !BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                PayController.getInstance().bindSuccess(obj);
            } else {
                PayController.getInstance().bindExtSuccess(this, obj);
            }
            PasswordController.getPassWordInstance().setPassByUserSucceed("");
        } else if (i2 == 14) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            a(obj);
        } else if (i2 == 622) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            super.handleResponse(i2, obj, str);
        } else {
            if (i2 == 13 && (bindFastRequest = this.m) != null) {
                if (bindFastRequest.getmBindFrom() == 0 || this.m.getmBindFrom() == 6) {
                    StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_SUCCESS, BindCardImplActivity.PAY_BIND_CARD_HASH_NAME, BindCardImplActivity.PAY_BIND_CARD_HASH_ID, "绑卡成功", new String[0]);
                    StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
                    StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, (Map<String, Object>) null, new String[0]);
                    StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SET_PWD_DURATION, (Map<String, Object>) null, new String[0]);
                } else if (this.m.getmBindFrom() == 2) {
                    StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
                    StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SET_PWD_DURATION, (Map<String, Object>) null, new String[0]);
                    StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_COMPLETION_BANK_CARD_DURATION, (Map<String, Object>) null, new String[0]);
                }
            }
            super.handleResponse(i2, obj, str);
        }
    }

    public boolean isBindPay() {
        return this.a;
    }

    public boolean isWindowNightMode() {
        return false;
    }

    public void onBackPressed() {
        PwdRequest pwdRequest = this.l;
        if (pwdRequest != null && pwdRequest.mFrom == 3) {
            PayRequestCache.getInstance().removeBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
        }
        StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "pwdSetAndConfirmCacel");
        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SET_PWD_DURATION, (Map<String, Object>) null, new String[0]);
        PasswordController.getPassWordInstance().setPwdFail(-1, "");
        super.onBackPressed();
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        ErrorContentResponse.Guidance guidance;
        WalletGlobalUtils.safeDismissDialog(this, 0);
        ErrorContentResponse errorContentResponse = (obj == null || !(obj instanceof ErrorContentResponse)) ? null : (ErrorContentResponse) obj;
        if (i3 == 15500) {
            this.mDialogMsg = str;
            this.mErrorContent = (ErrorContentResponse) obj;
            this.mPayErrorCode = i3;
            this.mBeanId = i2;
            WalletGlobalUtils.safeShowDialog(this, 1, "");
        } else if (i3 == 80320 || i3 == 80321 || i3 == 80326 || i3 == 80327) {
            PayDataCache.getInstance().cleanDetainmentDesc();
            this.mDialogMsg = str;
            WalletGlobalUtils.safeShowDialog(this, 2, "");
        } else if (i3 != 51000 || errorContentResponse == null || (guidance = errorContentResponse.guidance) == null) {
            super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
        } else {
            this.mGuidance = guidance;
            if (guidance != null) {
                l();
                this.mPayErrorCode = i3;
                this.mBeanId = i2;
                WalletGlobalUtils.safeShowDialog(this, 53, "");
                return;
            }
            super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFlagPaySdk();
        setIsShowMultiWindowTips(true);
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("mPwdRequest");
            if (serializable != null && (serializable instanceof PwdRequest)) {
                this.l = (PwdRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mBindRequest");
            if (serializable2 != null && (serializable2 instanceof BindFastRequest)) {
                this.m = (BindFastRequest) serializable2;
            }
            Serializable serializable3 = bundle.getSerializable("mPayRequest");
            if (serializable3 != null && (serializable3 instanceof PayRequest)) {
                this.n = (PayRequest) serializable3;
            }
        } else {
            PayRequestCache.BindCategory bindCategory = PayRequestCache.BindCategory.Pwd;
            if (getIntent() != null) {
                bindCategory = PayRequestCache.BindCategory.from(getIntent().getIntExtra("baidu.wallet.bindcard.category", 0));
            }
            this.m = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(bindCategory.name());
            this.n = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            this.l = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
        }
        String string = ResUtils.getString(this, "ebpay_pwd_set_tip");
        String string2 = ResUtils.getString(this, "ebpay_pwd_set_new_sub_tip");
        PwdRequest pwdRequest = this.l;
        if (pwdRequest == null) {
            PayCallBackManager.callBackClientCancel(this, "PwdSetAndConfirmActivityonCreate().1");
            return;
        }
        int i2 = pwdRequest.mFrom;
        if (!(i2 == 2 || i2 == 4)) {
            BindFastRequest bindFastRequest = this.m;
            if (bindFastRequest == null) {
                PayCallBackManager.callBackClientCancel(this, "PwdSetAndConfirmActivityonCreate().2");
                return;
            }
            if (bindFastRequest.isRealPay()) {
                if (this.n == null) {
                    PayCallBackManager.callBackClientCancel(this, "PwdSetAndConfirmActivityonCreate().3");
                    return;
                }
                if (!com.baidu.wallet.paysdk.a.b.a() || !com.baidu.wallet.paysdk.a.b.b()) {
                    string = ResUtils.getString(this, "ebpay_pwd_confim_tip_pay");
                }
                PayRequestCache.getInstance().addBeanRequestToCache(this.n.getRequestId(), this.n);
            }
            PayRequestCache.getInstance().addBeanRequestToCache(this.m.getRequestId(), this.m);
        }
        PayRequestCache.getInstance().addBeanRequestToCache(this.l.getRequestId(), this.l);
        setContentView(ResUtils.layout(this, "wallet_cashdesk_setandconfirm_pwd_activity"));
        getWindow().setSoftInputMode(2);
        this.j = (SafeScrollView) findViewById(ResUtils.id(this, "scrollview"));
        this.k = (RelativeLayout) findViewById(ResUtils.id(this, "root_view"));
        a(string, string2);
        initActionBar("ebpay_set_phone_paycode");
        setSafeScrollView(this.j);
        BindFastRequest bindFastRequest2 = this.m;
        if (bindFastRequest2 != null && bindFastRequest2.getmBindFrom() == 1) {
            setFlagActiveBindCard();
        }
        PwdRequest pwdRequest2 = this.l;
        if (pwdRequest2 != null && pwdRequest2.mFrom == 4) {
            setFlagAuthFlow();
        }
        StatHelper.statServiceEvent(PayStatServiceEvent.ENTER_PWD_SET_ACTIVITY);
        if (PayRequestCache.getInstance().isPaying()) {
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_SET_PWD_DURATION);
        }
    }

    public Dialog onCreateDialog(int i2) {
        if (i2 == 1) {
            return new PromptDialog(getActivity());
        }
        if (i2 == 2) {
            return new PromptDialog(getActivity());
        }
        if (i2 == 18) {
            return new PromptDialog(getActivity());
        }
        return super.onCreateDialog(i2);
    }

    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans("PwdSetAndConfirmActivity");
        CountDownTimer countDownTimer = this.s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.s = null;
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 1) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage((CharSequence) this.mDialogMsg);
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.showCloseBtn(false);
            promptDialog.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_wallet_continue_pay"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PwdSetAndConfirmActivity pwdSetAndConfirmActivity = PwdSetAndConfirmActivity.this;
                    pwdSetAndConfirmActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdSetAndConfirmActivity.getActivity(), "ebpay_wallet_continue_pay"));
                    WalletGlobalUtils.safeDismissDialog(PwdSetAndConfirmActivity.this, 1);
                    PayController instance = PayController.getInstance();
                    PwdSetAndConfirmActivity pwdSetAndConfirmActivity2 = PwdSetAndConfirmActivity.this;
                    instance.updateCardInfoPay(pwdSetAndConfirmActivity2, pwdSetAndConfirmActivity2.mErrorContent);
                }
            });
            promptDialog.setNegativeBtn(ResUtils.string(this, "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PwdSetAndConfirmActivity pwdSetAndConfirmActivity = PwdSetAndConfirmActivity.this;
                    pwdSetAndConfirmActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdSetAndConfirmActivity.getActivity(), "dxm_ebpay_cancel"));
                    WalletGlobalUtils.safeDismissDialog(PwdSetAndConfirmActivity.this, 1);
                }
            });
        } else if (i2 == 2) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage((CharSequence) this.mDialogMsg);
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.showCloseBtn(false);
            promptDialog2.hideNegativeButton();
            promptDialog2.setPositiveBtn(ResUtils.getString(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PwdSetAndConfirmActivity.this, 2);
                }
            });
        } else if (i2 == 3) {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.hideTitle();
            promptDialog3.hideNegativeButton();
            promptDialog3.setMessage((CharSequence) this.mDialogMsg);
            promptDialog3.setPositiveBtn(ResUtils.string(this.mAct, "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PwdSetAndConfirmActivity.this.mAct, 3);
                }
            });
        } else if (i2 == 18) {
            final PromptDialog promptDialog4 = (PromptDialog) dialog;
            promptDialog4.setMessage((CharSequence) ResUtils.getString(this.mAct, "ebpay_pwd_promotion_message"));
            promptDialog4.setTitleText(ResUtils.getString(this.mAct, "ebpay_pwd_explain"));
            promptDialog4.hideNegativeButton();
            promptDialog4.setPositiveBtn(ResUtils.getString(this.mAct, "ebpay_pwd_close_promotion_dialog"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    promptDialog4.dismiss();
                }
            });
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    public void onPwdChanged(int i2) {
        if (i2 == 6) {
            StatHelper.statServiceEvent(StatServiceEvent.EVENT_FINISH_INPUTPWD_IN_CASHDESK);
            this.l.mPayPass = getPwdConfirm();
            this.l.mConfirmPayPass = getPwdConfirm();
            handleConfirmPwd();
        } else if (i2 > 0 && this.b.getVisibility() == 0) {
            b();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("mPwdRequest", this.l);
        BindFastRequest bindFastRequest = this.m;
        if (bindFastRequest != null) {
            bundle.putSerializable("mBindRequest", bindFastRequest);
        }
        PayRequest payRequest = this.n;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.onWindowFocusChanged(z);
        if (z && (safeKeyBoardEditText = this.h) != null) {
            safeKeyBoardEditText.requestFocus();
        }
    }

    public void resetPwdConfirm() {
        this.e.resetPwd();
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        if (z) {
            PayController.getInstance().paySucess(this, payResultContent, i2);
        } else {
            PayController.getInstance().payPaying(this, payResultContent, i2);
        }
    }

    /* access modifiers changed from: private */
    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        PayRequest payRequest = this.n;
        String str = "";
        arrayList.add(payRequest != null ? payRequest.mSpNO : str);
        PayRequest payRequest2 = this.n;
        if (payRequest2 != null) {
            str = payRequest2.mOrderNo;
        }
        arrayList.add(str);
        return arrayList;
    }

    private void b(int i2) {
        StatHelper.cachePayType(i2);
        if (PayDataCache.getInstance().isFromPreCashier()) {
            StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY);
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_SUCCESS, PayCallBackManager.PRE_HASH_NAME, PayCallBackManager.PRE_HASH_ID, PayCallBackManager.PAY_SUCCESS_MSG, new String[0]);
            return;
        }
        StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY);
        StatHelper.statPayAllServiceEvent(PayStatServiceEvent.STD_PAY_SUCCESS, PayCallBackManager.STD_HASH_NAME, PayCallBackManager.STD_HASH_ID, PayCallBackManager.PAY_SUCCESS_MSG, new String[0]);
    }

    private void a(String str, String str2) {
        this.b = findViewById(ResUtils.id(this, "layout_confirm"));
        this.c = (TextView) findViewById(ResUtils.id(this, "pwd_tip_confirm"));
        this.d = (TextView) findViewById(ResUtils.id(this, "pwd_tip_sub"));
        SixNumberPwdView sixNumberPwdView = (SixNumberPwdView) findViewById(ResUtils.id(this, "pwd_input_box_confirm"));
        this.e = sixNumberPwdView;
        sixNumberPwdView.setShowInputMethod(true);
        this.g = findViewById(ResUtils.id(this, "error_area_confirm"));
        this.f = (TextView) findViewById(ResUtils.id(this, "error_tip_confirm"));
        TextView textView = (TextView) findViewById(ResUtils.id(this, "what_is_pay_password"));
        this.f3618i = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WalletGlobalUtils.safeShowDialog(PwdSetAndConfirmActivity.this.mAct, 18, "");
            }
        });
        b();
        this.e.addSixNumberPwdChangedListenter(this);
        SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.e.findViewById(ResUtils.id(getActivity(), "pwd_input"));
        this.h = safeKeyBoardEditText;
        safeKeyBoardEditText.initSafeKeyBoardParams(this.k, this.j, this.b, false);
        this.h.setGap(20);
        this.c.setText(str);
        this.d.setText(str2);
        this.h.setDisablePast(true);
        this.h.addTextChangedListener(new TextWatcher() {
            public boolean b = false;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!this.b) {
                    StatisticManager.onEventWithValues("clickConfirmPwd", PwdSetAndConfirmActivity.this.a());
                    this.b = true;
                }
            }
        });
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f.setVisibility(8);
            return;
        }
        this.f.setVisibility(0);
        this.f.setText(str);
    }

    private void a(Object obj) {
        if (PayDataCache.getInstance().isFromPreCashier() && com.baidu.wallet.paysdk.c.a.a().c()) {
            licaiBalancePaySuccess(3, 14, obj);
        } else if (obj != null && (obj instanceof BalancePayResponse)) {
            BalancePayResponse balancePayResponse = (BalancePayResponse) obj;
            PayResultContent payResultContent = new PayResultContent();
            payResultContent.notify = balancePayResponse.notify;
            payResultContent.paytype_desc = balancePayResponse.paytype_desc;
            payResultContent.coupon_msg = balancePayResponse.coupon_msg;
            BalancePayResponse.Business business = balancePayResponse.business;
            if (business != null) {
                String str = business.stream_recharge_msg;
                if (str != null) {
                    payResultContent.stream_recharge_msg = str;
                }
                String str2 = balancePayResponse.business.expected_time;
                if (str2 != null) {
                    payResultContent.expected_time = str2;
                }
            }
            payResultContent.coupon_find_prompt = balancePayResponse.coupon_find_prompt;
            payResultContent.total_amount = balancePayResponse.total_amount;
            payResultContent.cash_amount = balancePayResponse.cash_amount;
            payResultContent.discount_amount = balancePayResponse.discount_amount;
            payResultContent.pay_detail_info = balancePayResponse.pay_detail_info;
            payResultContent.paytype_info = balancePayResponse.paytype_info;
            payResultContent.order_no = balancePayResponse.order_no;
            AuthorizeInfo authorizeInfo = balancePayResponse.authorize_info;
            payResultContent.authorize_msg = authorizeInfo != null ? authorizeInfo.authorize_desc : "";
            payResultContent.order_prefix = balancePayResponse.order_prefix;
            payResultContent.discount_prefix = balancePayResponse.discount_prefix;
            payResultContent.payResultCashbackDetail = balancePayResponse.cashback_dialog_detail;
            payResultContent.feedback_info = balancePayResponse.feedback_info;
            payResultContent.trans_no = balancePayResponse.trans_no;
            payResultContent.redirect_sp_succpage_remain_time = balancePayResponse.redirect_sp_succpage_remain_time;
            payResultContent.fp_open_or_update_msg = balancePayResponse.fp_open_or_update_msg;
            payResultContent.compliance = balancePayResponse.compliance;
            StatHelper.cachePayAmount(Double.valueOf(balancePayResponse.cash_amount).doubleValue());
            b(1);
            if (balancePayResponse.toShowH5ResultPage()) {
                PayDataCache.getInstance().setH5ResultParams(new H5ResultParams(balancePayResponse.redirect_sp_succpage_remain_time, balancePayResponse.pay_result_url, balancePayResponse.pay_result_params, balancePayResponse.show_h5_result, CashierDeskPayResult.PayScenario.BalancedPay));
            }
            PayController.getInstance().paySucess(this.mAct, payResultContent, 1);
        }
    }
}
