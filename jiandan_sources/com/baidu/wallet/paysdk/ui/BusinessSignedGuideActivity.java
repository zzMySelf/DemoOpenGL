package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.beans.c;
import com.baidu.wallet.paysdk.banksign.beans.d;
import com.baidu.wallet.paysdk.banksign.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.banksign.datamodel.PollingResponse;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
import java.util.List;

public class BusinessSignedGuideActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static final int DLG_BANK_SIGN_GUIDE = 64;
    public static final int SIGN_STATE_1 = 1;
    public static final int SIGN_STATE_2 = 2;
    public static final int SIGN_STATE_3 = 3;
    public static final int SIGN_STATE_4 = 4;
    public static final int SIGN_STATE_5 = 5;
    public static final int SIGN_STATE_6 = 6;
    public static final String TAG = "BusinessSignedGuideActivity";
    public static boolean g = false;
    public WalletBaseButtonWithImage a;
    public Runnable b;
    public Handler c = new Handler();
    public boolean d = false;
    public QueryResponse e;
    public String f = "";
    public int h = 0;

    public static class a implements IBeanResponseCallback {
        public a() {
        }

        public void onBeanExecFailure(int i2, int i3, String str) {
            BusinessSignedGuideActivity.b(false, i3, str);
            StatHelper.cacheCodeAndMsg(i3 + "", str);
            BeanManager.getInstance().removeAllBeans("QueryBean");
        }

        public void onBeanExecSuccess(int i2, Object obj, String str) {
            QueryResponse queryResponse = (QueryResponse) obj;
            StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
            if (queryResponse != null) {
                BusinessSignedGuideActivity.b(true, queryResponse.sign_state, queryResponse.agreement_trans_id);
            }
            BeanManager.getInstance().removeAllBeans("QueryBean");
        }
    }

    private void d() {
        int i2;
        if (TextUtils.isEmpty(this.e.toast_msg) || !this.f.equals(QueryResponse.Options.PAY)) {
            i2 = 0;
        } else {
            GlobalUtils.toast(this, this.e.toast_msg);
            i2 = 2000;
        }
        this.c.postDelayed(new Runnable() {
            public void run() {
                BusinessSignedGuideActivity.this.e();
            }
        }, (long) i2);
    }

    /* access modifiers changed from: private */
    public void e() {
        String str = this.e.form_data;
        com.baidu.wallet.paysdk.banksign.a.a.a().a(str == null ? null : str.getBytes());
        com.baidu.wallet.paysdk.banksign.a.a.a().d(this.e.form_url);
        com.baidu.wallet.paysdk.banksign.a.a.a().e(this.e.webview_title);
        this.h = 0;
        this.d = true;
        f();
        BankSignPayFlow a2 = BankSignPayFlow.a();
        a2.a(BankSignPayFlow.Action.JumpResign);
        a2.a((Context) this.mAct);
        this.c.post(this.b);
    }

    private void f() {
        if (!g || PayRequestCache.getInstance().isPaying()) {
            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getBankCode(), StatHelper.getCardType());
            StatHelper.setPayBankSign(true);
            StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BANKSIGN_ENTER, collectData);
            return;
        }
        StatisticManager.onEventWithValues(PayStatServiceEvent.INITIATIVE_BANKSIGN_ENETR, StatHelper.collectData(StatHelper.getBankCode(), StatHelper.getCardType()));
    }

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_base_half_sign_guide_activity"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void bindcard() {
        com.baidu.wallet.paysdk.banksign.beans.a aVar = (com.baidu.wallet.paysdk.banksign.beans.a) BankSignFactory.getInstance().getBean((Context) this.mAct, (int) BankSignFactory.BEAN_ID_BIND_CARD, TAG);
        aVar.setResponseCallback(this);
        aVar.execBean();
    }

    public void handleErrorContent() {
        WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
        super.handleErrorContent();
    }

    public void handleFailure(int i2, int i3, String str) {
        if (i2 != 769) {
            if (i2 == 770) {
                StatHelper.cacheCodeAndMsg(i3 + "", str);
                b(false, i3, str);
                WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
                GlobalUtils.toast(this, str);
            } else if (i2 == 771) {
                StatHelper.cacheCodeAndMsg(i3 + "", str);
                if (i3 != 0 && !TextUtils.isEmpty(str)) {
                    GlobalUtils.toast(this, str, 1000);
                }
                if (PayDataCache.getInstance().isFromPreCashier()) {
                    finishWithoutAnim();
                    return;
                }
                BankSignPayFlow a2 = BankSignPayFlow.a();
                a2.a(BankSignPayFlow.Action.Cancel);
                a2.a((Context) this.mAct);
            }
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        int i3 = 2000;
        boolean z = true;
        if (i2 == 769) {
            PollingResponse pollingResponse = (PollingResponse) obj;
            Handler handler = this.c;
            if (handler != null && pollingResponse != null && pollingResponse.has_sign_result == 1) {
                handler.removeCallbacks(this.b);
                if (!TextUtils.isEmpty(pollingResponse.toast_msg)) {
                    GlobalUtils.toast(this.mAct, pollingResponse.toast_msg, 2000);
                }
                this.c.postDelayed(new Runnable() {
                    public void run() {
                        BaseActivity.clearTasksTopOf(BusinessSignedGuideActivity.this);
                    }
                }, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            }
        } else if (i2 == 770) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
            QueryResponse queryResponse = (QueryResponse) obj;
            this.e = queryResponse;
            if (queryResponse != null) {
                this.h++;
                int i4 = queryResponse.sign_state;
                b(true, i4, queryResponse.agreement_trans_id);
                if (this.h == 1 && i4 == 2) {
                    z = false;
                }
                if (!TextUtils.isEmpty(this.e.agreement_trans_id) && z) {
                    com.baidu.wallet.paysdk.banksign.a.a.a().f(this.e.agreement_trans_id);
                }
                switch (i4) {
                    case 1:
                        if (this.h == 2) {
                            d();
                            return;
                        }
                        BankSignPayFlow a2 = BankSignPayFlow.a();
                        a2.a(BankSignPayFlow.Action.FirstFail);
                        a2.a((Context) this.mAct);
                        return;
                    case 2:
                        if (this.h == 2) {
                            d();
                            return;
                        } else if (this.e.isGuidanceAvilable()) {
                            WalletGlobalUtils.safeShowDialog(this, 64, "");
                            return;
                        } else {
                            return;
                        }
                    case 3:
                    case 5:
                    case 6:
                        if (this.h != 2 || TextUtils.isEmpty(this.e.toast_msg)) {
                            i3 = 0;
                        } else {
                            GlobalUtils.toast(this, this.e.toast_msg);
                        }
                        this.c.postDelayed(new Runnable() {
                            public void run() {
                                if (BusinessSignedGuideActivity.this.e.isGuidanceAvilable()) {
                                    WalletGlobalUtils.safeShowDialog(BusinessSignedGuideActivity.this, 64, "");
                                }
                            }
                        }, (long) i3);
                        return;
                    case 4:
                        if (this.h != 2 || TextUtils.isEmpty(this.e.toast_msg) || !this.f.equals(QueryResponse.Options.JUMP_RESIGN)) {
                            i3 = 0;
                        } else {
                            GlobalUtils.toast(this, this.e.toast_msg);
                        }
                        this.c.postDelayed(new Runnable() {
                            public void run() {
                                BankSignPayFlow a2 = BankSignPayFlow.a();
                                a2.a(BankSignPayFlow.Action.Pay);
                                a2.a((Context) BusinessSignedGuideActivity.this.mAct);
                                BusinessSignedGuideActivity.this.finishWithoutAnim();
                            }
                        }, (long) i3);
                        return;
                    default:
                        return;
                }
            }
        } else if (i2 == 771) {
            StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
            BindCardResponse bindCardResponse = (BindCardResponse) obj;
            if (bindCardResponse != null && !TextUtils.isEmpty(bindCardResponse.sign_card_no)) {
                if (PayDataCache.getInstance().isFromPreCashier()) {
                    String g2 = com.baidu.wallet.paysdk.banksign.a.a.a().g(bindCardResponse.sign_card_no);
                    if (!TextUtils.isEmpty(g2)) {
                        PayDataCache.getInstance().setOrderExtraInfo(g2);
                    }
                }
                BankSignPayFlow a3 = BankSignPayFlow.a();
                a3.a(BankSignPayFlow.Action.Cancel);
                a3.a((Context) this.mAct);
            }
        }
    }

    public void onBackPressed() {
        StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "BusinessSignGuideCancel");
        if (!PayDataCache.getInstance().isFromPreCashier()) {
            super.onBackPressed();
        } else if (BaseActivity.tasksIsExistActivityWithActivityName(PayTypeActivity.class)) {
            super.onBackPressed();
        } else {
            PayCallBackManager.callBackClientCancel(this, "BusinessSignGuideCancel");
        }
    }

    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.a && !CheckUtils.isFastDoubleClick()) {
            f();
            this.e = null;
            BankSignPayFlow a2 = BankSignPayFlow.a();
            a2.a(BankSignPayFlow.Action.JumpResign);
            a2.a((Context) this.mAct);
            this.d = true;
            this.a.setEnabled(false);
            b();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g = getIntent().getBooleanExtra("isActiveSign", false);
        StatisticManager.onEventStart(PayStatServiceEvent.PAY_BANK_SIGN_DURATION);
        a();
        showLikeDismissLadingPage();
        if (bundle != null) {
            this.h = bundle.getInt("mQueryCount", 0);
            this.d = bundle.getBoolean("mCloseH5", false);
            this.a.setEnabled(bundle.getBoolean("mSignBtnEnabled", true));
        }
    }

    public Dialog onCreateDialog(int i2) {
        if (64 != i2) {
            return super.onCreateDialog(i2);
        }
        PromptMultiBtnDialog promptMultiBtnDialog = new PromptMultiBtnDialog(this);
        promptMultiBtnDialog.setNewDialogStyle(false);
        return promptMultiBtnDialog;
    }

    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacks(this.b);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(StatHelper.BANK_SIGN_TYPE, g ? "1" : "0");
        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BANK_SIGN_DURATION, hashMap, new String[0]);
        com.baidu.wallet.paysdk.banksign.a.a.a().n();
        BeanManager.getInstance().removeAllBeans(TAG);
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (64 == i2) {
            a(dialog);
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.d) {
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacks(this.b);
            }
            c();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("mQueryCount", this.h);
        bundle.putBoolean("mCloseH5", this.d);
        bundle.putBoolean("mSignBtnEnabled", this.a.isEnabled());
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    private void b() {
        final c cVar = (c) BankSignFactory.getInstance().getBean((Context) getActivity(), (int) BankSignFactory.BEAN_ID_POLLING, TAG);
        AnonymousClass1 r1 = new Runnable() {
            public void run() {
                cVar.setResponseCallback(BusinessSignedGuideActivity.this);
                cVar.execBean();
                BusinessSignedGuideActivity.this.c.postDelayed(this, 3000);
            }
        };
        this.b = r1;
        this.c.post(r1);
    }

    private void c() {
        this.d = false;
        WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
        d dVar = (d) BankSignFactory.getInstance().getBean((Context) getActivity(), (int) BankSignFactory.BEAN_ID_QUERY, TAG);
        if (!g) {
            com.baidu.wallet.paysdk.banksign.a.a.a().a("");
            dVar.setResponseCallback(this);
            dVar.execBean();
            return;
        }
        d dVar2 = (d) BankSignFactory.getInstance().getBean((Context) getActivity(), (int) BankSignFactory.BEAN_ID_QUERY, "QueryBean");
        dVar2.execBean();
        dVar2.setResponseCallback(new a());
        finishWithoutAnim();
    }

    private void a() {
        this.mActionBar.setVisibility(0);
        this.mLeftImg.setOnClickListener(this);
        WalletBaseButtonWithImage walletBaseButtonWithImage = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getActivity(), "bd_wallet_sign_btn"));
        this.a = walletBaseButtonWithImage;
        if (g) {
            walletBaseButtonWithImage.setText(ResUtils.getString(getActivity(), "dxmpay_banksign_guide_sgin_btn"));
        } else {
            walletBaseButtonWithImage.setText(ResUtils.getString(getActivity(), "dxmpay_banksign_guide_pay_btn"));
        }
        this.a.setDrawableLeftVisible(false);
        this.a.setOnClickListener(this);
    }

    public static void b(boolean z, int i2, String str) {
        if (z) {
            if (!g || PayRequestCache.getInstance().isPaying()) {
                String orderNo = StatHelper.getOrderNo();
                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BANKSIGN_RESULT, StatHelper.collectData(orderNo, StatHelper.getBankCode(), StatHelper.getCardType(), i2 + "", str));
                return;
            }
            String bankCode = StatHelper.getBankCode();
            StatisticManager.onEventWithValues(PayStatServiceEvent.INITIATIVE_BANKSIGN_RESULT, StatHelper.collectData(bankCode, StatHelper.getCardType(), i2 + "", str));
        } else if (!g || PayRequestCache.getInstance().isPaying()) {
            String orderNo2 = StatHelper.getOrderNo();
            StatisticManager.onEventWithValues("pay_banksign_error", StatHelper.collectData(orderNo2, StatHelper.getBankCode(), StatHelper.getCardType(), i2 + "", str));
        } else {
            String bankCode2 = StatHelper.getBankCode();
            StatisticManager.onEventWithValues("pay_banksign_error", StatHelper.collectData(bankCode2, StatHelper.getCardType(), i2 + "", str));
        }
    }

    private void a(Dialog dialog) {
        PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
        QueryResponse queryResponse = this.e;
        if (queryResponse != null) {
            if (!TextUtils.isEmpty(queryResponse.dialog_title)) {
                promptMultiBtnDialog.setTitleMessage(this.e.dialog_title);
            } else {
                promptMultiBtnDialog.setTitleMessage(ResUtils.getString(this.mAct, "dxmpay_banksign_dialog_title"));
            }
            if (!TextUtils.isEmpty(this.e.dialog_hint)) {
                promptMultiBtnDialog.setMessage((CharSequence) this.e.dialog_hint);
            }
            promptMultiBtnDialog.setFirstBtn(this.e.dialog_options[0].msg, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BusinessSignedGuideActivity.this, 64);
                    BusinessSignedGuideActivity businessSignedGuideActivity = BusinessSignedGuideActivity.this;
                    businessSignedGuideActivity.a(businessSignedGuideActivity.e.dialog_options[0].type);
                }
            });
            promptMultiBtnDialog.setSecondBtn(this.e.dialog_options[1].msg, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BusinessSignedGuideActivity.this, 64);
                    BusinessSignedGuideActivity businessSignedGuideActivity = BusinessSignedGuideActivity.this;
                    businessSignedGuideActivity.a(businessSignedGuideActivity.e.dialog_options[1].type);
                }
            });
            promptMultiBtnDialog.setThirdBtn(this.e.dialog_options[2].msg, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BusinessSignedGuideActivity.this, 64);
                    BusinessSignedGuideActivity businessSignedGuideActivity = BusinessSignedGuideActivity.this;
                    businessSignedGuideActivity.a(businessSignedGuideActivity.e.dialog_options[2].type);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0096, code lost:
        r7 = (com.baidu.wallet.paysdk.datamodel.PayRequest) com.baidu.wallet.paysdk.storage.PayRequestCache.getInstance().getBeanRequestFromCache(com.baidu.wallet.paysdk.beans.DxmPayBeanConstants.REQUEST_ID_PAY);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r7) {
        /*
            r6 = this;
            com.baidu.wallet.paysdk.banksign.BankSignPayFlow r0 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.a()
            r6.f = r7
            int r1 = r7.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -1367724422: goto L_0x003a;
                case -930533934: goto L_0x0030;
                case 110760: goto L_0x0026;
                case 1221572179: goto L_0x001c;
                case 1235694497: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0044
        L_0x0012:
            java.lang.String r1 = "jump_resign"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0044
            r7 = 0
            goto L_0x0045
        L_0x001c:
            java.lang.String r1 = "change_paytype"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0044
            r7 = 3
            goto L_0x0045
        L_0x0026:
            java.lang.String r1 = "pay"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0044
            r7 = 1
            goto L_0x0045
        L_0x0030:
            java.lang.String r1 = "bind_card"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0044
            r7 = 4
            goto L_0x0045
        L_0x003a:
            java.lang.String r1 = "cancel"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0044
            r7 = 2
            goto L_0x0045
        L_0x0044:
            r7 = -1
        L_0x0045:
            if (r7 == 0) goto L_0x00bc
            if (r7 == r5) goto L_0x0079
            if (r7 == r4) goto L_0x006b
            if (r7 == r3) goto L_0x005d
            if (r7 == r2) goto L_0x0051
            goto L_0x00cd
        L_0x0051:
            com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r7 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.BindCard
            r0.a((com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action) r7)
            com.dxmpay.wallet.core.beans.BeanActivity r7 = r6.mAct
            r0.a((android.content.Context) r7)
            goto L_0x00cd
        L_0x005d:
            com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r7 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.ChangePayType
            r0.a((com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action) r7)
            com.dxmpay.wallet.core.beans.BeanActivity r7 = r6.mAct
            r0.a((android.content.Context) r7)
            r6.finishWithoutAnim()
            goto L_0x00cd
        L_0x006b:
            com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r7 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.Cancel
            r0.a((com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action) r7)
            com.dxmpay.wallet.core.beans.BeanActivity r7 = r6.mAct
            r0.a((android.content.Context) r7)
            r6.finishWithoutAnim()
            goto L_0x00cd
        L_0x0079:
            int r7 = r6.h
            if (r7 != r5) goto L_0x0087
            com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse r7 = r6.e
            int r7 = r7.sign_state
            if (r7 != r4) goto L_0x0087
            r6.c()
            goto L_0x00cd
        L_0x0087:
            com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse r7 = r6.e
            int r1 = r7.sign_state
            r2 = 5
            if (r1 != r2) goto L_0x00ae
            java.lang.String r7 = r7.sign_card_no
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00ae
            com.baidu.wallet.paysdk.storage.PayRequestCache r7 = com.baidu.wallet.paysdk.storage.PayRequestCache.getInstance()
            java.lang.String r1 = "key_pay_request"
            com.dxmpay.wallet.core.beans.BeanRequestBase r7 = r7.getBeanRequestFromCache(r1)
            com.baidu.wallet.paysdk.datamodel.PayRequest r7 = (com.baidu.wallet.paysdk.datamodel.PayRequest) r7
            com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse r1 = r6.e
            java.lang.String r1 = r1.sign_card_no
            com.baidu.wallet.base.datamodel.CardData$BondCard r1 = r7.getCardByCardNo(r1)
            if (r1 == 0) goto L_0x00ae
            r7.mBondCard = r1
        L_0x00ae:
            com.baidu.wallet.paysdk.banksign.BankSignPayFlow$Action r7 = com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action.Pay
            r0.a((com.baidu.wallet.paysdk.banksign.BankSignPayFlow.Action) r7)
            com.dxmpay.wallet.core.beans.BeanActivity r7 = r6.mAct
            r0.a((android.content.Context) r7)
            r6.finishWithoutAnim()
            goto L_0x00cd
        L_0x00bc:
            int r7 = r6.h
            if (r7 != r5) goto L_0x00ca
            com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse r7 = r6.e
            int r7 = r7.sign_state
            if (r7 != r4) goto L_0x00ca
            r6.c()
            goto L_0x00cd
        L_0x00ca:
            r6.e()
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.a(java.lang.String):void");
    }
}
