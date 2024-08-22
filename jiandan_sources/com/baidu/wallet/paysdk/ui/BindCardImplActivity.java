package com.baidu.wallet.paysdk.ui;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.widget.OrderConfirmation;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.b.c;
import com.baidu.wallet.paysdk.b.f;
import com.baidu.wallet.paysdk.b.g;
import com.baidu.wallet.paysdk.b.j;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.z;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.QueryBankBinResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;
import com.baidu.wallet.paysdk.ui.widget.BankCardInfoView;
import com.baidu.wallet.paysdk.ui.widget.BankCvv2InfoView;
import com.baidu.wallet.paysdk.ui.widget.BankMsgInfoView;
import com.baidu.wallet.paysdk.ui.widget.BankUserInfoView;
import com.baidu.wallet.paysdk.ui.widget.BindCardHeadView;
import com.baidu.wallet.paysdk.ui.widget.CertificateMenuView;
import com.baidu.wallet.paysdk.ui.widget.JobAndAddressView;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.Base64;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardUtil;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.ui.WebViewActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class BindCardImplActivity extends BindCardBaseActivity implements c {
    public static final String PAY_BIND_CARD_HASH_ID = "paySDKPayBindCardPage";
    public static final String PAY_BIND_CARD_HASH_NAME = "支付中绑卡页面";
    public static final String TAG = "BindCardImplActivity";
    public static Pattern z = Pattern.compile("(4|1(1|2))");
    public int A;
    public ViewGroup B;
    public boolean C = true;
    public TextView D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public String K = "";
    public String L = "";
    public GetCardInfoResponse.CertificateTypeInfo M;
    public int N = 0;
    public LinearLayout b;
    public EditText c;
    public GetCardInfoResponse d;
    public boolean e;
    public int f = 100027;
    public boolean g = false;
    public BankCardInfoView h;

    /* renamed from: i  reason: collision with root package name */
    public OrderConfirmation f3609i;
    public AuthorizeInfoView j;
    public BankMsgInfoView k;
    public LinearLayout l;
    public WalletBaseButtonWithImage m;
    public BankCvv2InfoView mBankCvv2InfoView;
    public BankUserInfoView mBankUserInfoView;
    public com.baidu.wallet.paysdk.ui.widget.b mCertificateTypeDialog;
    public JobAndAddressView mJobAndAddressView;
    public TextView n;

    /* renamed from: o  reason: collision with root package name */
    public CheckBox f3610o;
    public BindCardHeadView p;
    public TextView q;
    public TextView r;
    public LinearLayout s;
    public LinearLayout t;
    public GetCardInfoResponse u;
    public GetCardInfoResponse.CardInfo v;
    public StringBuilder w = new StringBuilder();
    public boolean x;
    public a y;

    public static class a extends Handler {
        public WeakReference<c> a;

        public a(c cVar) {
            this.a = new WeakReference<>(cVar);
        }

        public void handleMessage(Message message) {
            WeakReference<c> weakReference;
            super.handleMessage(message);
            if (message.what == 0 && (weakReference = this.a) != null) {
                ((c) weakReference.get()).showBindCardDialog();
            }
        }
    }

    public class b {
        public CharSequence a;
        public CharSequence b;
        public CharSequence c;
        public CharSequence d;
        public CharSequence e;

        public b() {
        }
    }

    private boolean A() {
        if (this.E && TextUtils.isEmpty(this.mBankUserInfoView.getStartDateTip())) {
            return false;
        }
        if (this.F && TextUtils.isEmpty(this.mBankUserInfoView.getEndDateTip())) {
            return false;
        }
        if (this.I && (this.mJobAndAddressView.getJobTip() == null || TextUtils.isEmpty(this.mJobAndAddressView.getJobTip().jobName))) {
            return false;
        }
        if (!this.J) {
            return true;
        }
        if (this.mJobAndAddressView.getAddressTip() == null || TextUtils.isEmpty(this.mJobAndAddressView.getAddressTip().address)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void B() {
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest == null) {
            return;
        }
        if (bindFastRequest.getmBindFrom() == 1) {
            List<String> collectData = StatHelper.collectData(StatHelper.getSessionId(), StatHelper.SENSOR_ERR_2, "initivativeBindCardCancel");
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
            StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, (Collection<String>) collectData, (Map<String, Object>) hashMap);
            return;
        }
        int i2 = this.mBindReq.getmBindFrom();
        String str = PayStatServiceEvent.PAY_BIND_CARD_DURATION;
        String str2 = PayStatServiceEvent.PAY_BIND_CARD_FAILED;
        if (i2 == 0) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(StatHelper.HASH_NAME, PAY_BIND_CARD_HASH_NAME);
            hashMap2.put("hash", PAY_BIND_CARD_HASH_ID);
            hashMap2.put(StatHelper.EVENT_TAG, "绑卡失败");
            hashMap2.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
            hashMap2.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
            hashMap2.put(StatHelper.EVENT_PATH, "paySDK_pay_bind_card_failed");
            hashMap2.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
            StatHelper.statServiceEvent(str2, hashMap2, StatHelper.SENSOR_ERR_2, "payBindCardCancel");
            StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "payBindCardCancel");
            StatHelper.payEventEndWithValues(str, (Map<String, Object>) null, new String[0]);
        } else {
            String str3 = str;
            String str4 = str2;
            String str5 = StatHelper.SENSOR_ERR_2;
            if (this.mBindReq.getmBindFrom() == 6) {
                StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_CANCEL);
                HashMap hashMap3 = new HashMap();
                hashMap3.put(StatHelper.HASH_NAME, PAY_BIND_CARD_HASH_NAME);
                hashMap3.put("hash", PAY_BIND_CARD_HASH_ID);
                hashMap3.put(StatHelper.EVENT_TAG, "绑卡失败");
                hashMap3.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
                hashMap3.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
                hashMap3.put(StatHelper.EVENT_PATH, "paySDK_pay_bind_card_failed");
                hashMap3.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
                String str6 = str5;
                StatHelper.statServiceEvent(str4, hashMap3, str6, "authorizeBindCardCancel");
                StatHelper.cacheCodeAndMsg(str6, "authorizeBindCardCancel");
                StatHelper.payEventEndWithValues(str3, (Map<String, Object>) null, new String[0]);
            } else {
                String str7 = str5;
                int i3 = this.mBindReq.mBindFrom;
                if (i3 == 2 || i3 == 7) {
                    StatHelper.cacheCodeAndMsg(str7, "completeBindCardCardCancel");
                    return;
                }
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public EditText C() {
        return this.c;
    }

    private int q() {
        String format = new SimpleDateFormat("yyyy").format(new Date(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(format) && format.length() == 4) {
            try {
                return Integer.parseInt(format.substring(2, 4));
            } catch (Exception unused) {
            }
        }
        return 18;
    }

    private boolean r() {
        return this.mBindCardController.k() && this.mBankCvv2InfoView.getCvv2InputView().isEnabled() && !CheckUtils.isBandCardEndAvailable(this.mBankCvv2InfoView.getCvv2InputView().getText().toString());
    }

    private void s() {
        DivisionEditText cardNoView = this.h.getCardNoView();
        cardNoView.addTextChangedListener(new TextWatcher() {
            public boolean a = false;

            public void afterTextChanged(Editable editable) {
                if (!this.a) {
                    StatisticManager.onEvent("clickInputCardNo");
                    this.a = true;
                }
                BindCardImplActivity.this.h.hideErrorLayout();
                boolean unused = BindCardImplActivity.this.y();
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.h.setTipClick(this);
        cardNoView.setOnMyFocusChangeListener(this);
    }

    private void t() {
        CardData.BondCard bondCard;
        int currentStep = getCurrentStep();
        if (currentStep != 0) {
            boolean z2 = true;
            if (currentStep == 1) {
                if (!this.h.getCardNoView().isEnabled()) {
                    BindFastRequest bindFastRequest = this.mBindReq;
                    if (!(bindFastRequest == null || (bondCard = bindFastRequest.mBondCard) == null)) {
                        this.K = bondCard.account_no;
                    }
                } else {
                    this.K = this.h.getCardNoView().getRealText();
                }
                if (TextUtils.isEmpty(this.K)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("view.isEnable:");
                    sb.append(this.h.getCardNoView().isEnabled());
                    if (this.mBindReq != null) {
                        sb.append(";mBindReq.mBondCard(isNull):");
                        if (this.mBindReq.mBondCard != null) {
                            z2 = false;
                        }
                        sb.append(z2);
                    }
                    sb.append("; realText:");
                    sb.append(this.h.getCardNoView().getRealText());
                    StatisticManager.onEventEndWithValue("bindcard.cardNo", -1, sb.toString());
                }
                BindFastRequest bindFastRequest2 = this.mBindReq;
                if (bindFastRequest2 != null) {
                    bindFastRequest2.setmBankCard(this.K);
                }
                if (this.mBindCardController.E()) {
                    w();
                } else {
                    u();
                }
            }
        } else {
            this.mScrollView.dismissKeyBoard(this.h.getCardNoView());
            a("");
        }
    }

    private void u() {
        j jVar = this.mBindCardController;
        if (jVar instanceof g) {
            g gVar = (g) jVar;
            String[] strArr = new String[6];
            strArr[0] = this.mBankCvv2InfoView.getCvv2InputView().getText().toString();
            strArr[1] = this.mBankCvv2InfoView.getDateInputView().getText().toString();
            strArr[2] = this.mBankUserInfoView.getTrueNameText().getText().toString();
            strArr[3] = this.mBankUserInfoView.getIdEditText().getText().toString();
            strArr[4] = this.mBankUserInfoView.getMobileEditText().getText().toString();
            GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.M;
            strArr[5] = certificateTypeInfo != null ? certificateTypeInfo.type : "";
            gVar.b(strArr);
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            z zVar = (z) PayBeanFactory.getInstance().getBean((Context) this, 13, BindCardBaseActivity.BEAN_TAG);
            zVar.setResponseCallback(this);
            zVar.execBean();
        }
    }

    private boolean v() {
        int currentStep = getCurrentStep();
        if (currentStep == 0) {
            if (!this.h.getCardNoView().isEnabled()) {
                CardData.BondCard bondCard = this.mBindReq.mBondCard;
                if (bondCard != null) {
                    this.K = bondCard.account_no;
                }
            } else {
                this.K = this.h.getCardNoView().getRealText();
            }
            return j();
        } else if (currentStep != 1) {
            return true;
        } else {
            if (!k() || !l()) {
                return false;
            }
            return true;
        }
    }

    private void w() {
        StatHelper.statPayAllServiceEvent("secondNext", PAY_BIND_CARD_HASH_NAME, PAY_BIND_CARD_HASH_ID, "点击第二步", new String[0]);
        if (!isBindInvalid()) {
            String str = "";
            WalletGlobalUtils.safeShowDialog(this, -2, str);
            BindFastRequest bindFastRequest = this.mBindReq;
            if (bindFastRequest != null) {
                bindFastRequest.setIdCardSartDate(this.mBankUserInfoView.getStartDateTip());
                this.mBindReq.setIdCardEndDate(this.mBankUserInfoView.getEndDateTip());
                this.mBindReq.setNationality(this.mBankUserInfoView.getNationalityTip());
                this.mBindReq.setGender(this.mBankUserInfoView.getGenderTip());
                this.mBindReq.setJob(this.mJobAndAddressView.getJobTip());
                this.mBindReq.setAddress(this.mJobAndAddressView.getAddressTip());
            }
            j jVar = this.mBindCardController;
            String[] strArr = new String[6];
            strArr[0] = this.mBankCvv2InfoView.getCvv2InputView().getText().toString();
            strArr[1] = this.mBankCvv2InfoView.getDateInputView().getText().toString();
            strArr[2] = this.mBankUserInfoView.getTrueNameText().getText().toString();
            strArr[3] = this.mBankUserInfoView.getIdEditText().getText().toString();
            strArr[4] = this.mBankUserInfoView.getMobileEditText().getText().toString();
            GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.M;
            if (certificateTypeInfo != null) {
                str = certificateTypeInfo.type;
            }
            strArr[5] = str;
            jVar.c(strArr);
        }
    }

    private void x() {
        if (com.baidu.wallet.paysdk.a.b.a()) {
            WalletGlobalUtils.safeShowDialog(this, 629130, "");
        } else {
            WalletGlobalUtils.safeShowDialog(this, 4, "");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean y() {
        /*
            r8 = this;
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r0 = r8.h
            android.view.View r0 = r0.getClearView()
            r1 = 8
            r0.setVisibility(r1)
            android.view.Window r0 = r8.getWindow()
            android.view.View r0 = r0.getCurrentFocus()
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r2 = r8.h
            com.dxmpay.wallet.base.widget.DivisionEditText r2 = r2.getCardNoView()
            java.lang.String r2 = r2.getRealText()
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r3 = r8.h
            com.dxmpay.wallet.base.widget.DivisionEditText r3 = r3.getCardNoView()
            boolean r3 = r3.isEnabled()
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x003e
            int r3 = r8.getCurrentStep()
            if (r3 == 0) goto L_0x003e
            java.lang.String r3 = r8.K
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x003e
            r8.resetCardInfoState()
            r8.L = r4
        L_0x003e:
            r3 = 0
            if (r0 == 0) goto L_0x009c
            int r0 = r0.getId()
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r5 = r8.h
            com.dxmpay.wallet.base.widget.DivisionEditText r5 = r5.getCardNoView()
            int r5 = r5.getId()
            if (r0 != r5) goto L_0x0093
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r0 = r8.h
            com.dxmpay.wallet.base.widget.DivisionEditText r0 = r0.getCardNoView()
            boolean r0 = r0.isEnabled()
            if (r0 == 0) goto L_0x0093
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x0072
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r0 = r8.h
            android.view.View r0 = r0.getClearView()
            r0.setVisibility(r3)
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r0 = r8.h
            r0.setTipDel()
            goto L_0x009c
        L_0x0072:
            com.baidu.wallet.paysdk.b.j r0 = r8.mBindCardController
            boolean r0 = r0.y()
            if (r0 == 0) goto L_0x0084
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r0 = r8.h
            android.view.View r0 = r0.getClearView()
            r0.setVisibility(r3)
            goto L_0x008d
        L_0x0084:
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r0 = r8.h
            android.view.View r0 = r0.getClearView()
            r0.setVisibility(r1)
        L_0x008d:
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r0 = r8.h
            r0.setTipScan()
            goto L_0x009c
        L_0x0093:
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r0 = r8.h
            android.view.View r0 = r0.getClearView()
            r0.setVisibility(r1)
        L_0x009c:
            com.baidu.wallet.paysdk.ui.widget.BankCardInfoView r0 = r8.h
            com.dxmpay.wallet.base.widget.DivisionEditText r0 = r0.getCardNoView()
            int r0 = r0.getVisibility()
            r1 = 1
            if (r0 != 0) goto L_0x0101
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x00fb
            int r0 = r2.length()
            r5 = 10
            if (r0 >= r5) goto L_0x00b8
            goto L_0x00fb
        L_0x00b8:
            java.lang.String r0 = r2.substring(r3, r5)
            com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse$CardInfo r6 = r8.v
            if (r6 == 0) goto L_0x00e0
            java.lang.String r6 = r6.bank_no
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x00e0
            java.lang.String r7 = " "
            java.lang.String r4 = r6.replace(r7, r4)
            int r6 = r4.length()
            if (r6 < r5) goto L_0x00e0
            java.lang.String r4 = r4.substring(r3, r5)
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x00e0
            r0 = 1
            goto L_0x00e1
        L_0x00e0:
            r0 = 0
        L_0x00e1:
            if (r0 == 0) goto L_0x00e9
            com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse$CardInfo r0 = r8.v
            r8.updateBankTitleInfo(r0, r3)
            goto L_0x0101
        L_0x00e9:
            int r0 = r2.length()
            if (r0 != r5) goto L_0x00f3
            r8.b((java.lang.String) r2)
            goto L_0x0101
        L_0x00f3:
            java.lang.String r0 = r2.substring(r3, r5)
            r8.b((java.lang.String) r0)
            goto L_0x0101
        L_0x00fb:
            r8.L = r4
            r0 = 0
            r8.updateBankTitleInfo(r0, r3)
        L_0x0101:
            boolean r0 = r8.j()
            int r2 = r8.getCurrentStep()
            if (r2 == 0) goto L_0x0122
            if (r0 == 0) goto L_0x0120
            boolean r0 = r8.l()
            if (r0 == 0) goto L_0x0120
            boolean r0 = r8.k()
            if (r0 == 0) goto L_0x0120
            boolean r0 = r8.A()
            if (r0 == 0) goto L_0x0120
            goto L_0x0121
        L_0x0120:
            r1 = 0
        L_0x0121:
            r0 = r1
        L_0x0122:
            android.widget.LinearLayout r1 = r8.l
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0133
            android.widget.CheckBox r1 = r8.f3610o
            boolean r1 = r1.isChecked()
            if (r1 != 0) goto L_0x0133
            goto L_0x0134
        L_0x0133:
            r3 = r0
        L_0x0134:
            com.baidu.wallet.base.widget.WalletBaseButtonWithImage r0 = r8.m
            r0.setEnabled(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.ui.BindCardImplActivity.y():boolean");
    }

    /* access modifiers changed from: private */
    public void z() {
        boolean v2 = v();
        if (this.l.getVisibility() == 0 && !this.f3610o.isChecked()) {
            v2 = false;
        }
        if (v2) {
            v2 = A();
        }
        this.m.setEnabled(v2);
    }

    public void doLivingPay() {
        u();
    }

    public void handleBindOtherCard() {
        BankCardInfoView bankCardInfoView = this.h;
        if (bankCardInfoView != null) {
            bankCardInfoView.getCardNoView().getText().clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r6 = r6.channel_info;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleFailure(int r6, int r7, java.lang.String r8) {
        /*
            r5 = this;
            r0 = 65025(0xfe01, float:9.112E-41)
            if (r7 != r0) goto L_0x0013
            com.dxmpay.apollon.utils.GlobalUtils.toast(r5, r8)
            com.baidu.wallet.paysdk.storage.PayRequestCache r6 = com.baidu.wallet.paysdk.storage.PayRequestCache.getInstance()
            r6.clearPaySdkRequestCache()
            com.baidu.wallet.paysdk.ui.PayBaseBeanActivity.exitEbpay()
            return
        L_0x0013:
            r0 = 4
            r1 = 0
            r2 = -2
            r3 = 12
            java.lang.String r4 = ""
            if (r6 != r0) goto L_0x0060
            com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse r6 = r5.d
            if (r6 == 0) goto L_0x0027
            com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse$ChannelInfo r6 = r6.channel_info
            if (r6 == 0) goto L_0x0027
            java.lang.String r6 = r6.channel_no
            goto L_0x0029
        L_0x0027:
            java.lang.String r6 = "0"
        L_0x0029:
            java.lang.String r0 = "getCardInfo"
            com.dxmpay.wallet.statistics.api.StatisticManager.onEventEndWithValue((java.lang.String) r0, (int) r7, (java.lang.String) r6)
            com.dxmpay.wallet.core.utils.WalletGlobalUtils.safeDismissDialog(r5, r2)
            r5.mDialogMsg = r8
            r6 = 100010(0x186aa, float:1.40144E-40)
            if (r7 != r6) goto L_0x003d
            r6 = 1
            r5.a((boolean) r6)
            goto L_0x00a3
        L_0x003d:
            r6 = 100040(0x186c8, float:1.40186E-40)
            if (r7 == r6) goto L_0x005b
            r6 = 100026(0x186ba, float:1.40166E-40)
            if (r7 != r6) goto L_0x0048
            goto L_0x005b
        L_0x0048:
            r6 = 100028(0x186bc, float:1.40169E-40)
            if (r7 != r6) goto L_0x0057
            r5.f = r7
            r5.g = r1
            r6 = 33
            com.dxmpay.wallet.core.utils.WalletGlobalUtils.safeShowDialog(r5, r6, r4)
            goto L_0x00a3
        L_0x0057:
            com.dxmpay.wallet.core.utils.WalletGlobalUtils.safeShowDialog(r5, r3, r4)
            goto L_0x00a3
        L_0x005b:
            r6 = 3
            com.dxmpay.wallet.core.utils.WalletGlobalUtils.safeShowDialog(r5, r6, r4)
            goto L_0x00a3
        L_0x0060:
            r0 = 5
            if (r6 == r0) goto L_0x0098
            r0 = 17
            if (r6 != r0) goto L_0x0068
            goto L_0x0098
        L_0x0068:
            r0 = 13
            if (r6 != r0) goto L_0x00a3
            com.dxmpay.wallet.core.beans.BeanActivity r0 = r5.mAct
            com.dxmpay.wallet.core.utils.WalletGlobalUtils.safeDismissDialog(r0, r1)
            r5.mDialogMsg = r8
            r5.mPayErrorCode = r7
            r5.mBeanId = r6
            com.dxmpay.wallet.core.utils.WalletGlobalUtils.safeShowDialog(r5, r3, r4)
            java.lang.String r6 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "bindPayAcceptFail"
            com.dxmpay.wallet.statistics.api.StatisticManager.onEventWithValue(r8, r6)
            r6 = 55000(0xd6d8, float:7.7071E-41)
            if (r6 == r7) goto L_0x008d
            r6 = 55001(0xd6d9, float:7.7073E-41)
            if (r6 != r7) goto L_0x00a3
        L_0x008d:
            com.dxmpay.wallet.core.beans.sm.SMManagerDelegate r6 = new com.dxmpay.wallet.core.beans.sm.SMManagerDelegate
            r6.<init>()
            com.dxmpay.wallet.core.beans.BeanActivity r7 = r5.mAct
            r6.deleteUserKeyId(r7)
            goto L_0x00a3
        L_0x0098:
            com.dxmpay.wallet.core.utils.WalletGlobalUtils.safeDismissDialog(r5, r2)
            super.handleFailure(r6, r7, r8)
            r5.mDialogMsg = r8
            com.dxmpay.wallet.core.utils.WalletGlobalUtils.safeShowDialog(r5, r3, r4)
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.ui.BindCardImplActivity.handleFailure(int, int, java.lang.String):void");
    }

    public void handleResponse(int i2, Object obj, String str) {
        CardAddResponse.CustomerSvcCfg customerSvcCfg;
        int i3;
        super.handleResponse(i2, obj, str);
        if (i2 == 7) {
            if (obj != null && (obj instanceof QueryBankBinResponse)) {
                QueryBankBinResponse queryBankBinResponse = (QueryBankBinResponse) obj;
                GetCardInfoResponse.CardInfo cardInfo = queryBankBinResponse.card_info;
                if (cardInfo != null) {
                    String str2 = cardInfo.bank_name;
                    this.v = cardInfo;
                    if (this.h.getCardNoView() != null && !TextUtils.isEmpty(this.h.getCardNoView().getText())) {
                        this.v.bank_no = this.h.getCardNoView().getText().toString();
                    }
                }
                updateBankTitleInfo(queryBankBinResponse.card_info, false);
            }
        } else if (i2 == 4) {
            WalletGlobalUtils.safeDismissDialog(this, -2);
            GetCardInfoResponse getCardInfoResponse = (GetCardInfoResponse) obj;
            this.d = getCardInfoResponse;
            if (getCardInfoResponse != null) {
                GetCardInfoResponse.ChannelInfo channelInfo = getCardInfoResponse.channel_info;
                StatisticManager.onEventEndWithValue("getCardInfo", 0, channelInfo != null ? channelInfo.channel_no : "0");
                this.f = -1;
                this.mDialogMsg = "";
                Map<String, String> map = this.d.cashdesk;
                if (map != null && map.size() > 0) {
                    PayDataCache.getInstance().setSessionData(this.d.cashdesk);
                }
                GetCardInfoResponse.Algorithm algorithm = this.d.algorithm_check_info;
                if (algorithm == null || (i3 = algorithm.code) != 100027) {
                    GetCardInfoResponse.BindCardInfo bindCardInfo = this.d.bind_card_info;
                    if (bindCardInfo == null || TextUtils.isEmpty(bindCardInfo.bind_card_desc)) {
                        a(this.d);
                        return;
                    }
                    this.f = 100027;
                    this.mDialogMsg = this.d.bind_card_info.bind_card_desc;
                    this.g = true;
                    WalletGlobalUtils.safeShowDialog(this, 33, "");
                    return;
                }
                this.f = i3;
                this.mDialogMsg = algorithm.msg;
                this.g = false;
                WalletGlobalUtils.safeShowDialog(this, 33, "");
            }
        } else if (i2 == 5 || i2 == 17) {
            WalletGlobalUtils.safeDismissDialog(this, -2);
            CheckCardInfoResponse checkCardInfoResponse = (CheckCardInfoResponse) obj;
            this.mBindReq.setmNeedSms((1 == checkCardInfoResponse.send_sms_by_bfb || "1".equals(checkCardInfoResponse.need_verify_sms)) ? 1 : 0);
            Map<String, String> map2 = checkCardInfoResponse.cashdesk;
            if (map2 != null && map2.size() > 0) {
                PayDataCache.getInstance().setSessionData(checkCardInfoResponse.cashdesk);
            }
            if (!TextUtils.isEmpty(checkCardInfoResponse.channel_no)) {
                this.mBindReq.setChannelNo(checkCardInfoResponse.channel_no);
            }
            this.mBindReq.setRegEx(checkCardInfoResponse.sms_pattern);
            this.mBindReq.setSmsLength(checkCardInfoResponse.sms_length);
            this.mBindReq.setSmsType(checkCardInfoResponse.sms_type);
            this.mBindReq.setSendSmsphone(checkCardInfoResponse.send_sms_phone);
            if (i2 == 5) {
                Bundle extras = getIntent().getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                extras.putString(DxmPayBeanConstants.UPDATE_MOBILE_DESC, checkCardInfoResponse.update_mobile_desc);
                extras.putInt(DxmPayBeanConstants.SMS_ACTIVITY_FROM_KEY, this.mBindReq.getmBindFrom() == 1 ? 7 : 0);
                PayRequestCache.BindCategory bindCategory = this.a;
                if (bindCategory == null) {
                    bindCategory = PayRequestCache.BindCategory.Other;
                }
                extras.putString("baidu.wallet.from", bindCategory.name());
                extras.putInt("reasonForChangeCardItem", getBindCardCause());
                extras.putString(DxmPayBeanConstants.UPDATE_COMPLIANCE_TIP, checkCardInfoResponse.send_sms_tips);
                extras.putString(DxmPayBeanConstants.UNABLE_RECEIVE_SMSTIP, checkCardInfoResponse.display_reset_route);
                a(extras, WalletSmsActivity.class, false);
            }
            if (i2 == 17) {
                if (com.baidu.wallet.paysdk.a.b.a()) {
                    this.mBindReq.mBindFrom = 7;
                } else {
                    this.mBindReq.mBindFrom = 9;
                }
                Intent intent = new Intent();
                intent.setClass(this, WalletSmsActivity.class);
                intent.putExtra("reasonForChangeCardItem", getBindCardCause());
                intent.putExtra(DxmPayBeanConstants.UPDATE_MOBILE_DESC, checkCardInfoResponse.update_mobile_desc);
                intent.putExtra(DxmPayBeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, false);
                intent.putExtra(DxmPayBeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
                intent.putExtra(DxmPayBeanConstants.KEY_SEND_SMS_AUTO, false);
                PayRequestCache.BindCategory bindCategory2 = this.a;
                if (bindCategory2 == null) {
                    bindCategory2 = PayRequestCache.BindCategory.Other;
                }
                intent.putExtra("baidu.wallet.from", bindCategory2.name());
                intent.putExtra(DxmPayBeanConstants.UPDATE_COMPLIANCE_TIP, checkCardInfoResponse.send_sms_tips);
                intent.putExtra(DxmPayBeanConstants.UNABLE_RECEIVE_SMSTIP, checkCardInfoResponse.display_reset_route);
                startActivityForResultWithoutAnim(intent, 0);
            }
        } else if (i2 == 13) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, 0);
        } else if (597 == i2) {
            CardAddResponse.updateContent(obj);
            CardAddResponse instance = CardAddResponse.getInstance();
            if (instance != null && (customerSvcCfg = instance.intelligent_service) != null) {
                b.a(this.mAct, this.bdActionBar, customerSvcCfg.customer_service_url, customerSvcCfg.customer_service_icon, customerSvcCfg.customer_service_copy, "CSTM_SVC_cardAdd");
            }
        }
    }

    public void initSafeKeyBoard() {
        if (isShowWithHalfScreeen()) {
            SafeKeyBoardEditText[] safeKeyBoardEditTextArr = {this.h.getCardNoView(), this.mBankCvv2InfoView.getDateInputView(), this.mBankCvv2InfoView.getCvv2InputView(), this.mBankUserInfoView.getTrueNameText(), this.mBankUserInfoView.getIdEditText(), this.mBankUserInfoView.getMobileEditText()};
            for (int i2 = 0; i2 < 6; i2++) {
                SafeKeyBoardEditText safeKeyBoardEditText = safeKeyBoardEditTextArr[i2];
                safeKeyBoardEditText.setOnMyFocusChangeListener(this);
                safeKeyBoardEditText.initSafeKeyBoardParams(this.mRootView, this.mScrollView, (View) safeKeyBoardEditText.getTag(), false);
            }
        } else if (this.h.getCardNoView().isEnabled()) {
            this.h.getCardNoView().setOnMyFocusChangeListener(this);
            this.h.getCardNoView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, this.l.getVisibility() == 0 ? this.l : this.r.getVisibility() == 0 ? this.r : this.m, false);
        }
        super.initSafeKeyBoard();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 40976 && i3 == -1 && intent != null && intent.getExtras() != null) {
            a(intent.getExtras().getString("subbankcode"));
        }
        if (i2 == 0 && i3 != -1) {
            this.mBindReq.mBindFrom = this.A;
        }
    }

    public void onBackPressed() {
        LinkedList<BaseActivity> linkedList;
        PayRequest payRequest = this.mPayReq;
        if (payRequest != null) {
            payRequest.clearMktSolution();
        }
        if (!this.e) {
            B();
        }
        if (this.mBindReq.getmBindFrom() == 1) {
            PayController.getInstance().bindFail(this, "");
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            finish();
        } else if (this.mBindReq.getmBindFrom() == 5) {
            PayController.getInstance().bindFail(this, "");
            finish();
        } else if (this.e) {
            x();
        } else if ((this.mBindReq.getmBindFrom() == 2 || this.mBindReq.getmBindFrom() == 0 || ((linkedList = BaseActivity.mActivityStack) != null && linkedList.size() == 1)) && PayDataCache.getInstance().isFromPreCashier()) {
            PayCallBackManager.callBackClientCancel(this, "BindCardImplActivity.onBackPressed().1");
        } else {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        if (view == this.m || view.getId() == ResUtils.id(this.mAct, "wallet_base_safekeyboard_confirm")) {
            if (v()) {
                BankCardInfoView bankCardInfoView = this.h;
                if (bankCardInfoView != null) {
                    String scanCardNum = bankCardInfoView.getScanCardNum();
                    if (!TextUtils.isEmpty(scanCardNum) && !scanCardNum.equals(this.h.getCardNoView().getRealText())) {
                        StatisticManager.onEvent("#bankCardNumChangedAfterScan");
                    }
                    this.h.resetScanCardNum();
                }
                t();
            }
        } else if (view == this.f3609i.getCouponInfoView()) {
            StatisticManager.onEvent("pressOtherDiscount");
            PayController.getInstance().gotoDiscountPage(this);
        }
        super.onClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
        if (LocalRouter.getInstance(getActivity()).isProviderExisted("bankdetection")) {
            this.C = getIntent().getBooleanExtra("baidu.wallet.listbankcard.extra", true);
        } else {
            this.C = false;
        }
        if (bundle == null) {
            this.e = getIntent().getBooleanExtra(BindFastRequest.BIND_IS_FIRST, false);
            Serializable serializableExtra = getIntent().getSerializableExtra("cardinforesponse");
            if (serializableExtra != null && (serializableExtra instanceof GetCardInfoResponse)) {
                this.u = (GetCardInfoResponse) serializableExtra;
            }
        } else {
            this.e = bundle.getBoolean("isFrist", false);
            this.g = bundle.getBoolean("bindTipFromActivity", false);
            if (this.d == null) {
                Serializable serializable = bundle.getSerializable("cacheResult");
                if (serializable != null && (serializable instanceof GetCardInfoResponse)) {
                    this.d = (GetCardInfoResponse) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("cardinforesponse");
                if (serializable2 != null && (serializable2 instanceof GetCardInfoResponse)) {
                    this.u = (GetCardInfoResponse) serializable2;
                }
            }
        }
        a();
        getBindCardFlagDelegate().a(this.mBindReq);
        this.A = this.mBindReq.getmBindFrom();
        StatHelper.statPayAllServiceEvent(PayStatServiceEvent.ENTER_BIND_CARD_ACTIVITY, PAY_BIND_CARD_HASH_NAME, PAY_BIND_CARD_HASH_ID, "进入", new String[0]);
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest != null) {
            int i2 = bindFastRequest.mBindFrom;
            if (i2 == 2 || i2 == 7) {
                StatisticManager.onEventStart(PayStatServiceEvent.PAY_COMPLETION_BANK_CARD_DURATION);
            }
        }
    }

    public Dialog onCreateDialog(int i2) {
        if (i2 == 629128) {
            return new PromptDialog(getActivity());
        }
        return super.onCreateDialog(i2);
    }

    public void onDestroy() {
        int i2;
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest != null && ((i2 = bindFastRequest.mBindFrom) == 2 || i2 == 7)) {
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_COMPLETION_BANK_CARD_DURATION, (Map<String, Object>) null, new String[0]);
        }
        EventBus.getInstance().unregister((Object) this, "order_confirm_event_bus_key");
        this.mBindReq.setmBankInfo((GetCardInfoResponse) null);
        this.mBindReq.mCardInfoUpdateContent = null;
        BeanManager.getInstance().removeAllBeans(BindCardBaseActivity.BEAN_TAG);
        if (LocalRouter.getInstance(this.mAct).isProviderExisted("bankdetection")) {
            LocalRouter.getInstance(this.mAct).route(this.mAct, new RouterRequest().provider("bankdetection").action("clearcallback"), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "bankcarddetection");
                        hashMap2.put("action", "clearcallback");
                        StatisticManager.onEventEndWithValues("sdk_router_error", i2, (Collection<String>) hashMap2.values());
                    }
                }
            });
        }
        this.p.deleteSpan();
        super.onDestroy();
    }

    public void onFocusChange(View view, boolean z2) {
        a(view, z2);
        if (z2) {
            if (view instanceof EditText) {
                this.c = (EditText) view;
            }
            z();
        } else {
            a(view);
        }
        super.onFocusChange(view, z2);
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !"order_confirm_event_bus_key".equals(event.mEventKey)) {
            super.onModuleEvent(event);
            return;
        }
        if (this.mBindCardController.d()) {
            this.mBindCardController.o();
        }
        resetCardInfoState();
        y();
    }

    public void onMyFocusChange(View view, boolean z2) {
        Drawable drawable;
        int i2 = 1;
        if (this.mRootView instanceof LinearLayout) {
            View findViewById = findViewById(ResUtils.id(this.mAct, "padding_view"));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            int height = findViewById.getHeight();
            if (1.0f == layoutParams.weight && height > 0) {
                PayRequest payRequest = this.mPayReq;
                boolean z3 = payRequest != null && BaiduPay.PAY_FROM_AUTHORIZE.equals(payRequest.mPayFrom);
                if (PayDataCache.getInstance().isFromPreCashier() || z3) {
                    drawable = ResUtils.getDrawable(this.mAct, "dxm_wallet_base_halfscreen_bg");
                } else {
                    drawable = new ColorDrawable(0);
                }
                findViewById.setBackgroundDrawable(drawable);
                layoutParams.weight = 0.0f;
                layoutParams.height = height;
                findViewById.setLayoutParams(layoutParams);
            }
        }
        if (view == this.h.getCardNoView()) {
            if (z2) {
                this.h.hideErrorLayout();
                y();
            } else if (this.h.getCardNoView().isEnabled()) {
                if (this.mBindCardController.y()) {
                    this.h.getClearView().setVisibility(0);
                } else {
                    this.h.getClearView().setVisibility(8);
                }
                this.h.setTipScan();
            } else {
                this.h.getClearView().setVisibility(8);
            }
            com.baidu.wallet.paysdk.ui.widget.a.a(view, false, z2);
        } else {
            a(view, z2);
            if (z2) {
                if (view instanceof EditText) {
                    this.c = (EditText) view;
                }
                z();
                SafeKeyBoardEditText cvv2InputView = this.mBankCvv2InfoView.getCvv2InputView();
                if (view != this.mBankCvv2InfoView.getDateInputView()) {
                    i2 = 0;
                }
                if (view == this.mBankUserInfoView.getIdEditText()) {
                    i2 = 3;
                }
                if (view == this.mBankUserInfoView.getMobileEditText()) {
                    i2 = 4;
                }
                b(i2);
            } else {
                a(view);
            }
        }
        super.onMyFocusChange(view, z2);
    }

    public void onNewIntent(Intent intent) {
        boolean runInHalfScreenMode = runInHalfScreenMode();
        b d2 = d();
        super.onNewIntent(intent);
        int i2 = this.mBindReq.mBindFrom;
        if (i2 == 9) {
            j a2 = c.a(i2);
            this.mBindCardController = a2;
            a2.a((BindCardBaseActivity) this);
        }
        this.mBindCardController.a(this.mBindReq);
        if (runInHalfScreenMode != isShowWithHalfScreeen()) {
            a();
            a(d2);
        } else if (this.mBindCardController.s()) {
            loadCvv2();
        }
        if (this.mBindCardController instanceof f) {
            this.mBankUserInfoView.getMobileEditText().setEnabled(true);
            a(d2);
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage((CharSequence) this.mDialogMsg);
            if (!TextUtils.isEmpty(this.K)) {
                promptDialog.setTitleText(formatCardNo(this.K));
            }
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_choose_credit_tip2"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEvent("clickSupportBankList");
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 3);
                    BindCardImplActivity.this.a(false);
                }
            });
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_confirm"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEvent("selectOtherPayTypeFromCard");
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 3);
                }
            });
        } else if (i2 == 12) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage((CharSequence) this.mDialogMsg);
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 12);
                }
            });
            promptDialog2.hideNegativeButton();
        } else if (i2 == 33) {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage((CharSequence) this.mDialogMsg);
            if (!this.g && !TextUtils.isEmpty(this.K)) {
                if (this.g) {
                    promptDialog3.setTitleText(ResUtils.string(getActivity(), "dxm_ebpay_tip"));
                } else {
                    promptDialog3.setTitleText(formatCardNo(this.K));
                }
            }
            StatHelper.statServiceEvent(PayStatServiceEvent.BIND_CARD_CHECK_DIALOG, (Map<String, Object>) null, this.mDialogMsg);
            promptDialog3.setCanceledOnTouchOutside(false);
            final String string = ResUtils.getString(getActivity(), this.g ? "ebpay_choose_bind_sure" : "ebpay_choose_modify_card");
            final String string2 = ResUtils.getString(getActivity(), this.g ? "ebpay_choose_bind_continue" : "ebpay_choose_confirm");
            promptDialog3.setNegativeBtn(string, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.BIND_CARD_CHECK_DIALOG_MODIFY, (Map<String, Object>) null, string);
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 33);
                }
            });
            promptDialog3.setPositiveBtn(string2, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    StatHelper.statServiceEvent("confirmCardNo", (Map<String, Object>) null, string2);
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 33);
                    if (BindCardImplActivity.this.f == 100027) {
                        BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                        bindCardImplActivity.a(bindCardImplActivity.d);
                    } else if (BindCardImplActivity.this.f == 100028) {
                        BindCardImplActivity.this.a(true);
                    }
                }
            });
        } else if (i2 == 629128) {
            PromptDialog promptDialog4 = (PromptDialog) dialog;
            promptDialog4.setMessage((CharSequence) this.mDialogMsg);
            promptDialog4.setCanceledOnTouchOutside(false);
            promptDialog4.hideNegativeButton();
            promptDialog4.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BindCardImplActivity.this, 629128);
                }
            });
        } else if (i2 != 629130) {
            super.onPrepareDialog(i2, dialog);
        } else {
            final PromptDialog promptDialog5 = (PromptDialog) dialog;
            promptDialog5.setCanceledOnTouchOutside(false);
            promptDialog5.setMessage((CharSequence) ResUtils.getString(this, "bd_wallet_auth_confirm_to_cancel"));
            promptDialog5.setNegativeBtn(ResUtils.string(this, "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    promptDialog5.dismiss();
                }
            });
            promptDialog5.setPositiveBtn(ResUtils.string(this, "bd_wallet_auth_cancel_auth"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    BindCardImplActivity.this.B();
                    promptDialog5.dismiss();
                    PayCallBackManager.callBackClientCancel(BindCardImplActivity.this, "BindCardImplActivity.onPrepareDialog().1");
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        if (this.isFromRestore) {
            this.isFromRestore = false;
            WalletGlobalUtils.safeDismissDialog(this.mAct, 3);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 33);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 12);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        GetCardInfoResponse getCardInfoResponse = this.d;
        if (getCardInfoResponse != null) {
            bundle.putSerializable("cacheResult", getCardInfoResponse);
        }
        GetCardInfoResponse getCardInfoResponse2 = this.u;
        if (getCardInfoResponse2 != null) {
            bundle.putSerializable("cardinforesponse", getCardInfoResponse2);
        }
        bundle.putBoolean("bindTipFromActivity", this.g);
        bundle.putBoolean("is_first", this.e);
        super.onSaveInstanceState(bundle);
    }

    public void resetCardInfoState() {
        if (getCurrentStep() != 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.l.setLayoutParams(layoutParams);
            this.mBindReq.setmBankInfo((GetCardInfoResponse) null);
            this.mBindReq.setmBankCard("");
            this.M = null;
            this.L = "";
            this.c = null;
            this.mBindCardController.b((GetCardInfoResponse.CertificateTypeInfo) null);
            this.l.setVisibility(8);
            this.k.setVisibility(8);
            this.k.hideCouponView();
            this.q.setVisibility(8);
            this.mBankCvv2InfoView.clearEditMsg();
            this.mBankCvv2InfoView.setVisibility(8);
            this.mBankCvv2InfoView.hideErrorLayout();
            this.mBankUserInfoView.clearEditMsg();
            this.mBankUserInfoView.setVisibility(8);
            this.mJobAndAddressView.hideAllComplianceView();
            this.mJobAndAddressView.setVisibility(8);
            this.mBankUserInfoView.hideErrorLayout();
            this.mBankUserInfoView.setMoblieFromNet(false);
            this.mBankUserInfoView.setIdCardFromNet(false);
            this.r.setVisibility(8);
            g();
            initSafeKeyBoard();
            this.mScrollView.invalidate();
            this.N = 0;
            changeCurrentStepInfo(this.mBindCardController.a(0)[0], 0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new LinearLayout.LayoutParams(-1, 100);
            }
            layoutParams2.topMargin = 0;
            this.m.setLayoutParams(layoutParams2);
            this.m.setText(this.mBindCardController.a(0)[1]);
            updateBusinessTitleContentDescription(this.mBindCardController.a(0)[1]);
            this.m.setDrawableLeftVisible(true);
            this.mScrollView.setBackgroundColor(ResUtils.getColor(this.mAct, "dxm_wallet_base_whiteColor"));
        }
    }

    public boolean runInHalfScreenMode() {
        return this.mRootView instanceof LinearLayout;
    }

    public void showBindCardDialog() {
        if (!this.isFromRestore) {
            WalletGlobalUtils.safeShowDialog(this, 629128, "");
        }
    }

    public void showCardNineElementsError(String str, String str2) {
        BankCardInfoView bankCardInfoView;
        BankUserInfoView bankUserInfoView = this.mBankUserInfoView;
        if (bankUserInfoView != null) {
            bankUserInfoView.hideErrorLayout();
        }
        BankCardInfoView bankCardInfoView2 = this.h;
        if (bankCardInfoView2 != null) {
            bankCardInfoView2.hideErrorLayout();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (ErrorContentResponse.NINE_ELEMENTS_CARD_ERROR.equals(str) && (bankCardInfoView = this.h) != null) {
                bankCardInfoView.showErrorLayout(str2);
            } else if (this.mBankUserInfoView == null) {
            } else {
                if ("phone".equals(str)) {
                    this.mBankUserInfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_bank_bind_phone"), str2, this.mBankUserInfoView.getMobileEditText());
                } else if ("name".equals(str)) {
                    this.mBankUserInfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_name"), str2, this.mBankUserInfoView.getTrueNameText());
                } else if ("id_card".equals(str)) {
                    this.mBankUserInfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_id_card"), str2, this.mBankUserInfoView.getIdEditText());
                }
            }
        }
    }

    public void showPaySuccessPage(boolean z2, PayResultContent payResultContent, int i2) {
        if (z2) {
            PayController.getInstance().paySucess(this, payResultContent, i2);
        } else {
            PayController.getInstance().payPaying(this, payResultContent, i2);
        }
    }

    public void triggerSmsVerify(ErrorContentResponse.Verify verify, boolean z2, String str, int i2) {
        StatHelper.statServiceEvent("triggleSmsPay");
        Intent intent = new Intent();
        intent.setClass(this, WalletSmsActivity.class);
        intent.putExtra("reasonForChangeCardItem", getBindCardCause());
        intent.putExtra(DxmPayBeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, true);
        intent.putExtra(DxmPayBeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
        intent.putExtra(DxmPayBeanConstants.KEY_SEND_SMS_AUTO, z2);
        intent.putExtra(DxmPayBeanConstants.EXTRA_VERIFY_VOICE_DATA, verify);
        intent.putExtra(DxmPayBeanConstants.KEY_SMS_HINT, str);
        intent.putExtra(DxmPayBeanConstants.KEY_THE_REASON_FOR_SENDING, i2);
        PayRequestCache.BindCategory bindCategory = this.a;
        if (bindCategory == null) {
            bindCategory = PayRequestCache.BindCategory.Other;
        }
        intent.putExtra("baidu.wallet.from", bindCategory.name());
        startActivityWithoutAnim(intent);
    }

    public void triggerSpeechVerify(ErrorContentResponse.Verify verify) {
        StatisticManager.onEvent("triggerSpeechVerify");
        Intent intent = new Intent();
        intent.setClass(this, VoiceVerifyActivity.class);
        intent.putExtra(DxmPayBeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, true);
        intent.putExtra(DxmPayBeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
        intent.putExtra(DxmPayBeanConstants.EXTRA_VERIFY_VOICE_DATA, verify);
        startActivityWithoutAnim(intent);
    }

    public void updateBankCouponDesc(CharSequence charSequence) {
        this.k.setCouponDesc(charSequence);
    }

    public void updateBankTitleInfo(GetCardInfoResponse.CardInfo cardInfo, boolean z2) {
        String str;
        if (cardInfo != null) {
            this.k.setVisibility(isShowWithHalfScreeen() ? 8 : 0);
            BankMsgInfoView bankMsgInfoView = this.k;
            String str2 = cardInfo.bank_logourl;
            StringBuilder sb = new StringBuilder();
            sb.append(cardInfo.bank_name);
            sb.append(" ");
            if (cardInfo.card_type == 1) {
                str = ResUtils.getString(getActivity(), "bd_wallet_credit");
            } else {
                str = ResUtils.getString(getActivity(), "bd_wallet_debit");
            }
            sb.append(str);
            bankMsgInfoView.setBankInfo(str2, sb.toString());
        } else if (isShowWithHalfScreeen()) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(z2 ? 8 : 4);
        }
        this.k.invalidate();
        if (TextUtils.isEmpty(this.mBindCardController.c())) {
            this.q.setVisibility(8);
            return;
        }
        this.q.setVisibility(0);
        this.q.setText(this.mBindCardController.c());
    }

    public void updateBindCardProtocolFields(final GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo) {
        if (protocolPlatformInfo == null) {
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        CheckBox checkBox = (CheckBox) findViewById(ResUtils.id(getActivity(), "ebpay_protocol"));
        this.f3610o = checkBox;
        if (checkBox != null) {
            checkBox.setChecked(protocolPlatformInfo.isProtocolCheckedDefault());
            this.f3610o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    String[] strArr = new String[1];
                    strArr[0] = z ? "0" : "1";
                    StatHelper.statServiceEvent("clickAgreeBtn", (Map<String, Object>) null, strArr);
                    BindCardImplActivity.this.z();
                }
            });
        }
        TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "ebpay_protocol_text"));
        if (textView == null || protocolPlatformInfo == null || TextUtils.isEmpty(protocolPlatformInfo.prefix) || TextUtils.isEmpty(protocolPlatformInfo.main_title)) {
            CheckBox checkBox2 = this.f3610o;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
                return;
            }
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int color = ResUtils.getColor(getActivity(), "wallet_base_font_868e9e");
        spannableStringBuilder.append(protocolPlatformInfo.prefix + " ");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, protocolPlatformInfo.prefix.length(), 33);
        spannableStringBuilder.append("《");
        spannableStringBuilder.append(protocolPlatformInfo.main_title);
        spannableStringBuilder.append("》");
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                String str;
                String str2;
                String str3;
                CardData.BondCard bondCard;
                UserData.UserModel userModel;
                String str4;
                UserData.UserModel userModel2;
                if (!CheckUtils.isFastDoubleClick()) {
                    StatHelper.statServiceEvent("clickUserTerms");
                    Intent intent = new Intent(BindCardImplActivity.this.getActivity(), BindCardProtocolActivity.class);
                    PayRequestCache.BindCategory bindCategory = BindCardImplActivity.this.a;
                    if (bindCategory == null) {
                        bindCategory = PayRequestCache.BindCategory.Other;
                    }
                    intent.putExtra("baidu.wallet.from", bindCategory.name());
                    intent.putExtra(BindCardProtocolActivity.PROTOCOL_SNAPSHOT_ID, protocolPlatformInfo.snapshotId);
                    BankUserInfoView bankUserInfoView = BindCardImplActivity.this.mBankUserInfoView;
                    String str5 = null;
                    if (bankUserInfoView != null) {
                        if (TextUtils.isEmpty(bankUserInfoView.getTrueNameText().getText())) {
                            str2 = PayDataCache.getInstance().getUserName();
                        } else {
                            str2 = BindCardImplActivity.this.mBankUserInfoView.getTrueNameText().getText().toString();
                        }
                        intent.putExtra("true_name", str2);
                        if (!TextUtils.isEmpty(BindCardImplActivity.this.mBankUserInfoView.getIdEditText().getText())) {
                            str = BindCardImplActivity.this.mBankUserInfoView.getIdEditText().getText().toString();
                            intent.putExtra("identity_code", str);
                        } else {
                            str = null;
                        }
                        intent.putExtra("mobile", BindCardImplActivity.this.mBankUserInfoView.getMobileEditText().getText().toString());
                    } else {
                        str2 = null;
                        str = null;
                    }
                    if (BindCardImplActivity.this.M != null) {
                        if (TextUtils.isEmpty(BindCardImplActivity.this.M.type)) {
                            str3 = PayDataCache.getInstance().getCertificateType();
                        } else {
                            str3 = BindCardImplActivity.this.M.type;
                        }
                        intent.putExtra(BindCardProtocolActivity.IDENTITY_TYPE, str3);
                    } else {
                        str3 = null;
                    }
                    intent.putExtra("card_no", BindCardImplActivity.this.K);
                    if (!TextUtils.isEmpty(protocolPlatformInfo.snapshotId)) {
                        BindCardImplActivity.this.startActivityWithoutAnim(intent);
                        return;
                    }
                    DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                    intent.putExtra(BindCardProtocolActivity.PROTOCOL_DATA, protocolPlatformInfo);
                    intent.putExtra("true_name", str2);
                    intent.putExtra(BindCardProtocolActivity.IDENTITY_TYPE, str3);
                    if (TextUtils.isEmpty(str) && payResponse != null && (userModel2 = payResponse.user) != null && !TextUtils.isEmpty(userModel2.certificate_code)) {
                        intent.putExtra("identity_code", payResponse.user.certificate_code);
                    }
                    intent.putExtra("card_no", BindCardImplActivity.this.K);
                    Editable text = BindCardImplActivity.this.mBankUserInfoView.getMobileEditText().getText();
                    if (text != null) {
                        str5 = text.toString();
                    }
                    if (!(!TextUtils.isEmpty(str5) || payResponse == null || (userModel = payResponse.user) == null || (str4 = userModel.mobile) == null)) {
                        str5 = str4;
                    }
                    intent.putExtra("mobile", str5);
                    intent.putExtra(BindCardProtocolActivity.FROM_BAND_CARD, true);
                    BindFastRequest bindFastRequest = BindCardImplActivity.this.mBindReq;
                    if (!(bindFastRequest == null || (bondCard = bindFastRequest.mBondCard) == null || TextUtils.isEmpty(bondCard.bank_code))) {
                        intent.putExtra(BindCardProtocolActivity.BANK_CODE, BindCardImplActivity.this.mBindReq.mBondCard.bank_code);
                    }
                    BindCardImplActivity.this.startActivityWithoutAnim(intent);
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ResUtils.getColor(BindCardImplActivity.this.getActivity(), "dxm_wallet_base_color_clickable"));
            }
        }, protocolPlatformInfo.prefix.length(), spannableStringBuilder.length(), 33);
        textView.setEnabled(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHintTextColor(-1);
        textView.setBackgroundColor(-1);
        textView.setText(spannableStringBuilder);
        textView.setHighlightColor(getResources().getColor(17170445));
    }

    public void updateBusinessTitleContentDescription(String str) {
        String string = ResUtils.getString(this, "ebpay_pay_checkcard");
        String string2 = ResUtils.getString(this, "wallet_base_next_step");
        if (string.equals(str)) {
            this.m.getNextBtn().setContentDescription(ResUtils.getString(this, "wallet_access_checkcard_info"));
        } else if (string2.equals(str)) {
            this.m.getNextBtn().setContentDescription(ResUtils.getString(this, "wallet_access_confirm_info_for_pay"));
        } else {
            this.m.getNextBtn().setContentDescription(str);
        }
    }

    public void updateCardElement(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (z2 || z3) {
            this.mBankCvv2InfoView.setVisibility(0);
            this.mBankCvv2InfoView.hideArea(!z2, !z3);
        } else {
            this.mBankCvv2InfoView.setVisibility(8);
        }
        if (z4 || z5 || z6) {
            this.mBankUserInfoView.setVisibility(0);
            this.mBankUserInfoView.hideArea(!z4, !z5, !z6);
        } else {
            this.mBankUserInfoView.setVisibility(8);
        }
        this.mBankUserInfoView.setMobileInputAreaStatus(this.mBindCardController.u());
        GetCardInfoResponse.CertificateTypeInfo w2 = this.mBindCardController.w();
        this.M = w2;
        this.mBankUserInfoView.updateCertificateType(w2);
        this.mBankUserInfoView.setIdInputAreaStatus(this.mBindCardController.a(this.M));
        int x2 = this.mBindCardController.x();
        this.mBankUserInfoView.setCertificateCanClick(x2 > 1);
        if (x2 > 1) {
            final boolean z7 = z5;
            final boolean z8 = z2;
            final boolean z9 = z3;
            final boolean z10 = z4;
            final boolean z11 = z6;
            this.mBankUserInfoView.setOnCodeTypeClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEvent("clickSwitchIdentityType");
                    if (BindCardImplActivity.this.C() != null) {
                        BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                        bindCardImplActivity.mScrollView.dismissKeyBoard((SafeKeyBoardEditText) bindCardImplActivity.C());
                    }
                    com.baidu.wallet.paysdk.ui.widget.b bVar = BindCardImplActivity.this.mCertificateTypeDialog;
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                    BindCardImplActivity bindCardImplActivity2 = BindCardImplActivity.this;
                    bindCardImplActivity2.mCertificateTypeDialog = new com.baidu.wallet.paysdk.ui.widget.b(view, bindCardImplActivity2.a(bindCardImplActivity2.M, BindCardImplActivity.this.mBindCardController.v()));
                    BindCardImplActivity.this.mCertificateTypeDialog.a(new CertificateMenuView.b() {
                        public void a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
                            BindCardImplActivity.this.mCertificateTypeDialog.dismiss();
                            GetCardInfoResponse.CertificateTypeInfo unused = BindCardImplActivity.this.M = certificateTypeInfo;
                            BindCardImplActivity.this.mBindCardController.b(certificateTypeInfo);
                            BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                            bindCardImplActivity.mBankUserInfoView.setIdInputAreaStatus(bindCardImplActivity.mBindCardController.a(bindCardImplActivity.M), false);
                            BindCardImplActivity.this.mBankUserInfoView.updateCertificateType(certificateTypeInfo);
                            AnonymousClass22 r9 = AnonymousClass22.this;
                            if (z7 && BindCardImplActivity.this.mBankUserInfoView.getIdEditText().isEnabled()) {
                                SafeKeyBoardEditText idEditText = BindCardImplActivity.this.mBankUserInfoView.getIdEditText();
                                AnonymousClass22 r0 = AnonymousClass22.this;
                                BindCardImplActivity bindCardImplActivity2 = BindCardImplActivity.this;
                                idEditText.initSafeKeyBoardParams(bindCardImplActivity2.mRootView, bindCardImplActivity2.mScrollView, bindCardImplActivity2.a(3, z8, z9, z10, z7, z11), false);
                            }
                            BindCardImplActivity.this.mBankUserInfoView.setIdTipRedColor(false);
                            BindCardImplActivity bindCardImplActivity3 = BindCardImplActivity.this;
                            bindCardImplActivity3.a((View) bindCardImplActivity3.mBankUserInfoView.getIdEditText());
                            BindCardImplActivity.this.z();
                        }
                    });
                    BindCardImplActivity.this.mCertificateTypeDialog.show();
                }
            });
        }
        changeCurrentStepInfo(this.mBindCardController.a(1)[0], 1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, 100);
        }
        layoutParams.topMargin = this.mAct.getResources().getDimensionPixelSize(ResUtils.dimen(this.mAct, "ebpay_bind_card_info_below_height"));
        this.m.setLayoutParams(layoutParams);
        this.m.setText(this.mBindCardController.a(1)[1]);
        updateBusinessTitleContentDescription(this.mBindCardController.a(1)[1]);
        this.m.setDrawableLeftVisible(false);
        if (isShowWithHalfScreeen()) {
            this.m.setVisibility(8);
        }
        z();
        this.mScrollView.setBackgroundColor(ResUtils.getColor(this.mAct, "dxm_wallet_base_whiteColor"));
        final boolean z12 = z2;
        final boolean z13 = z3;
        final boolean z14 = z4;
        final boolean z15 = z5;
        final boolean z16 = z6;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                BindCardImplActivity.this.a(z12, z13, z14, z15, z16);
            }
        }, 150);
    }

    public void updateChangeCard() {
        if (this.h.getCardNoView().isEnabled()) {
            this.h.getCardNoView().requestFocus();
        }
    }

    public void updateCompliance(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        UserData.UserModel userModel;
        String str;
        this.E = z2;
        this.F = z3;
        this.G = z4;
        this.H = z5;
        this.I = z6;
        this.J = z7;
        if (z2 || z3 || z4 || z5 || z6 || z7) {
            if (z2 || z3 || z4 || z5) {
                this.mBankUserInfoView.setVisibility(0);
            }
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse != null && (userModel = payResponse.user) != null && userModel.age > 0) {
                if (userModel.gender == 1) {
                    str = ResUtils.getString(this, "ebpay_man_tip");
                } else {
                    str = ResUtils.getString(this, "ebpay_woman_tip");
                }
                a(payResponse.user.age, str);
            }
        }
    }

    public void updateCvv2Info(boolean z2, boolean z3, boolean z4) {
    }

    public void updateDiscountTitle(String str) {
        this.f3609i.setTitle(str);
    }

    public void updateDiscountTxt(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
        String str;
        this.f3609i.setOrderPrice(charSequence5, charSequence2);
        this.f3609i.setDiscountInfoVisiable(true);
        this.f3609i.setCouponInfo(charSequence3, charSequence4, this);
        this.f3609i.setOrderInfo(charSequence);
        this.f3609i.setSpNameValue(PayDataCache.getInstance().getSpName());
        if (PayDataCache.getInstance().isRemotePay() || com.baidu.wallet.paysdk.a.b.c()) {
            if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getPassUserName())) {
                str = WalletLoginHelper.getInstance().getPassUserName();
            } else {
                str = PayDataCache.getInstance().getPayResponse().getDisplayName();
            }
            this.f3609i.setAccountInfo(str, (View.OnClickListener) null);
        }
    }

    public void updateProtocolFields(GetCardInfoResponse.ProtocolInfo protocolInfo) {
        if (protocolInfo == null) {
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        CheckBox checkBox = (CheckBox) findViewById(ResUtils.id(getActivity(), "ebpay_protocol"));
        this.f3610o = checkBox;
        if (checkBox != null) {
            checkBox.setChecked(protocolInfo.isProtocolCheckedDefault());
            this.f3610o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    String[] strArr = new String[1];
                    strArr[0] = z ? "0" : "1";
                    StatHelper.statServiceEvent("clickAgreeBtn", (Map<String, Object>) null, strArr);
                    BindCardImplActivity.this.z();
                    if (z) {
                        BindCardImplActivity.this.f3610o.setContentDescription(ResUtils.getString(BindCardImplActivity.this, "wallet_access_disagree_protocol"));
                    } else {
                        BindCardImplActivity.this.f3610o.setContentDescription(ResUtils.getString(BindCardImplActivity.this, "wallet_access_agree_protocol"));
                    }
                }
            });
        }
        TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "ebpay_protocol_text"));
        AccessibilityUtils.changeRoleDescription(textView, ResUtils.getString(this, "wallet_access_button"));
        if (textView != null) {
            ArrayList arrayList = new ArrayList();
            GetCardInfoResponse.ProtocolItem[] protocolItemArr = protocolInfo.list;
            if (protocolItemArr != null) {
                for (GetCardInfoResponse.ProtocolItem protocolItem : protocolItemArr) {
                    if (!TextUtils.isEmpty(protocolItem.title)) {
                        arrayList.add(protocolItem);
                    }
                }
            }
            if (arrayList.size() > 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                int color = ResUtils.getColor(getActivity(), "wallet_base_font_868e9e");
                spannableStringBuilder.append(protocolInfo.prefix + " ");
                spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, protocolInfo.prefix.length(), 33);
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    GetCardInfoResponse.ProtocolItem protocolItem2 = (GetCardInfoResponse.ProtocolItem) arrayList.get(i2);
                    if (i2 != 0) {
                        String str = protocolInfo.separator;
                        if (i2 == arrayList.size() - 1) {
                            str = protocolInfo.last_separator;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            spannableStringBuilder.append(str);
                            sb.append(str);
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - str.length(), spannableStringBuilder.length(), 33);
                        }
                    }
                    sb.append(protocolItem2.title);
                    spannableStringBuilder.append(protocolItem2.title);
                    if (!TextUtils.isEmpty(protocolItem2.url)) {
                        final String str2 = protocolItem2.url;
                        final String replaceAll = protocolItem2.title.replaceAll("<|>|《|》", "");
                        spannableStringBuilder.setSpan(new ClickableSpan() {
                            public void onClick(View view) {
                                StatisticManager.onEvent("clickUserTerms");
                                Intent intent = new Intent(BindCardImplActivity.this.getActivity(), WebViewActivity.class);
                                intent.putExtra("jump_url", str2);
                                intent.putExtra("webview_title_string", replaceAll);
                                BindCardImplActivity.this.startActivity(intent);
                            }

                            public void updateDrawState(TextPaint textPaint) {
                                textPaint.setColor(ResUtils.getColor(BindCardImplActivity.this.getActivity(), "dxm_wallet_base_color_clickable"));
                            }
                        }, spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                    } else {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                    }
                }
                textView.setEnabled(true);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                if (!TextUtils.isEmpty(protocolInfo.suffix)) {
                    spannableStringBuilder.append(protocolInfo.suffix);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - protocolInfo.suffix.length(), spannableStringBuilder.length(), 33);
                }
                textView.setText(spannableStringBuilder);
                if (sb.length() > 0) {
                    sb.insert(0, "查看").append((sb.toString().endsWith("协议") || sb.toString().endsWith("协议》")) ? "详情" : "协议详情");
                    textView.setContentDescription(sb);
                    return;
                }
                return;
            }
            textView.setVisibility(8);
            CheckBox checkBox2 = this.f3610o;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
                return;
            }
            return;
        }
        CheckBox checkBox3 = this.f3610o;
        if (checkBox3 != null) {
            checkBox3.setVisibility(8);
        }
    }

    public void updateUiMode(Intent intent) {
        onNewIntent(intent);
    }

    private void b() {
        CardData.BondCard bondCard;
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest != null && (bondCard = bindFastRequest.mBondCard) != null) {
            bindFastRequest.mBankNo = bondCard.bank_code;
            this.mBindCardController.a();
        }
    }

    private void c() {
        Pair<Integer, Object> checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn();
        if (checkSecurityEvn != null && ((Integer) checkSecurityEvn.first).intValue() == 0) {
            Object obj = checkSecurityEvn.second;
            String str = null;
            if (obj != null && (obj instanceof String)) {
                str = (String) obj;
            }
            if (this.mBindReq != null && !TextUtils.isEmpty(str)) {
                this.mBindReq.mSecurityParams = Base64.encodeBytes(str.getBytes());
            }
        }
    }

    private b d() {
        b bVar = new b();
        BankCvv2InfoView bankCvv2InfoView = this.mBankCvv2InfoView;
        if (bankCvv2InfoView != null) {
            bVar.b = bankCvv2InfoView.getCvv2InputView().getEditableText().toString();
            bVar.c = this.mBankCvv2InfoView.getDateInputView().getEditableText().toString();
        }
        BankUserInfoView bankUserInfoView = this.mBankUserInfoView;
        if (bankUserInfoView != null) {
            bVar.a = bankUserInfoView.getTrueNameText().getEditableText().toString();
            bVar.d = this.mBankUserInfoView.getIdEditText().getEditableText().toString();
            bVar.e = this.mBankUserInfoView.getMobileEditText().getEditableText().toString();
        }
        return bVar;
    }

    private void e() {
        CardData.BondCard bondCard;
        a aVar;
        if (this.mBindCardController.g()) {
            this.h.setTrueName(this.mBindCardController.h());
        } else {
            this.h.setTrueName("");
        }
        this.h.setBindcardTip(this.mBindCardController.D());
        this.f3609i.setDiscountInfoVisiable(this.mBindCardController.e());
        int i2 = 8;
        this.p.setVisibility(this.mBindCardController.b() ? 0 : 8);
        ArrayList<CharSequence> z2 = this.mBindCardController.z();
        if (z2 == null || z2.size() <= 0) {
            this.p.setTitleVisiable(false);
        } else {
            this.p.setTitleVisiable(true);
            this.p.setImageSrcId(ResUtils.drawable(getActivity(), "wallet_base_bind_card_pic"));
            if (z2.size() >= 1) {
                this.p.setTitle(z2.get(0));
            }
            if (z2.size() >= 2) {
                this.p.setSubTitle(z2.get(1));
            } else {
                this.p.setSubTitleVisibility(8);
            }
        }
        if (this.mBindCardController.d()) {
            this.f3609i.setVisibility(0);
            a((View) this.f3609i, (View) this.t);
            if (!com.baidu.wallet.paysdk.a.b.a() && PayDataCache.getInstance().hasCanAmount()) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_complete_tip8");
                if (!this.x || (aVar = this.y) == null) {
                    showBindCardDialog();
                } else {
                    aVar.postDelayed(new Runnable() {
                        public void run() {
                            BindCardImplActivity.this.y.obtainMessage(0).sendToTarget();
                        }
                    }, 1200);
                }
            }
        } else {
            this.f3609i.setVisibility(8);
        }
        if (this.mBindCardController.i()) {
            this.j.setVisibility(0);
            this.j.refreshView();
        } else {
            this.j.setVisibility(8);
        }
        boolean q2 = this.mBindCardController.q();
        if (q2) {
            this.h.getCardNoView().setEnabled(true);
            this.h.getCardNoView().setFormatEnable(true);
            this.h.getCardNoView().requestFocus();
        } else {
            this.h.getCardNoView().setEnabled(false);
            this.h.getCardNoView().setFormatEnable(false);
            this.h.getClearView().setVisibility(8);
        }
        if (q2) {
            this.h.getCardNoView().setMyHint(this.mBindCardController.p(), "ebpay_bind_card_edittext_hint_txt_size");
        } else {
            this.h.getCardNoView().setMyHint(this.mBindCardController.p(), "dxm_wallet_base_level18Font");
            this.h.getCardNoView().setHintTextColor(ResUtils.getColor(this.mAct, "dxm_wallet_base_font_text3Color"));
        }
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest == null || bindFastRequest.getmBondCard() == null || TextUtils.isEmpty(this.mBindReq.getmBondCard().card_required_msg)) {
            BindFastRequest bindFastRequest2 = this.mBindReq;
            if (bindFastRequest2 == null || (bondCard = bindFastRequest2.mBondCard) == null || bondCard.bank_code == null) {
                com.baidu.wallet.paysdk.ui.widget.a.a(this.B, ResUtils.getString(this.mAct, "ebpay_title_complete_fixmsg"), (CharSequence) null, (CharSequence) null);
            } else {
                com.baidu.wallet.paysdk.ui.widget.a.a(this.B, "请完善", bondCard.getCardDesc(this.mAct, false), "的信息后继续支付");
            }
        } else {
            com.baidu.wallet.paysdk.ui.widget.a.a(this.B, this.mBindReq.getmBondCard().card_required_msg, (CharSequence) null, (CharSequence) null);
        }
        View findViewById = findViewById(ResUtils.id(this.mAct, "wallet_bind_card_subtitle"));
        if (this.mBindCardController.t()) {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
        if (this.mBindCardController.d()) {
            this.mBindCardController.o();
        }
        g();
        BindFastRequest bindFastRequest3 = this.mBindReq;
        if (!(bindFastRequest3 == null || bindFastRequest3.getmBankInfo() == null)) {
            this.mBindCardController.a();
        }
        if (this.mBindCardController.s()) {
            loadCvv2();
        }
        BindFastRequest bindFastRequest4 = this.mBindReq;
        if (bindFastRequest4 != null && bindFastRequest4.isNotPayBindCard() && CardAddResponse.getInstance().intelligent_service != null) {
            b.a(this.mAct, this.bdActionBar, CardAddResponse.getInstance().intelligent_service.customer_service_url, CardAddResponse.getInstance().intelligent_service.customer_service_icon, CardAddResponse.getInstance().intelligent_service.customer_service_copy, "CSTM_SVC_cardAdd");
        }
    }

    private void f() {
        BindFastRequest bindFastRequest;
        addContentView(ResUtils.layout(getActivity(), isShowWithHalfScreeen() ? "wallet_cashdesk_bind_card_view_half_screen" : "wallet_cashdesk_bind_card_view"));
        this.t = (LinearLayout) findViewById(ResUtils.id(getActivity(), "ebpay_parent_bindcard"));
        this.s = (LinearLayout) findViewById(ResUtils.id(getActivity(), "bindcard_root_view"));
        this.q = (TextView) findViewById(ResUtils.id(getActivity(), "bindcard_onecentsdecs"));
        BankCardInfoView bankCardInfoView = (BankCardInfoView) findViewById(ResUtils.id(getActivity(), "bindcard_cardinfo"));
        this.h = bankCardInfoView;
        bankCardInfoView.configDetectCardNum(this.C);
        this.f3609i = (OrderConfirmation) findViewById(ResUtils.id(getActivity(), "bindcard_amount"));
        this.j = (AuthorizeInfoView) findViewById(ResUtils.id(getActivity(), "auth_info_view"));
        this.k = (BankMsgInfoView) findViewById(ResUtils.id(getActivity(), "bindcard_msginfo"));
        this.mBankCvv2InfoView = (BankCvv2InfoView) findViewById(ResUtils.id(getActivity(), "bindcard_cvv2info"));
        this.mBankUserInfoView = (BankUserInfoView) findViewById(ResUtils.id(getActivity(), "bindcard_userinfo"));
        this.mJobAndAddressView = (JobAndAddressView) findViewById(ResUtils.id(getActivity(), "job_and_address"));
        this.mBankUserInfoView.getMobileEditText().setFormatEnable(false);
        this.mBankUserInfoView.getIdEditText().setUseSafeKeyBoard(true);
        this.mBankUserInfoView.getIdEditText().setUseKeyX(true);
        this.m = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getActivity(), "next_btn"));
        TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "lv_skip_text_view"));
        this.r = textView;
        textView.setVisibility(8);
        this.n = (TextView) findViewById(ResUtils.id(getActivity(), "authorize_fee_tip"));
        this.l = (LinearLayout) findViewById(ResUtils.id(getActivity(), "protocol_display_area"));
        this.p = (BindCardHeadView) findViewById(ResUtils.id(getActivity(), "bindcard_pic"));
        this.D = (TextView) findViewById(ResUtils.id(getActivity(), "bind_card_head_title"));
        if (!isShowWithHalfScreeen()) {
            findViewById(ResUtils.id(this.mAct, "card_area_top_margin")).setVisibility(this.mBindCardController.F() ? 4 : 8);
        }
        this.m.setEnabled(false);
        this.m.setOnClickListener(this);
        changeCurrentStepInfo(this.mBindCardController.a(0)[0], 0);
        this.m.setText(this.mBindCardController.a(0)[1]);
        updateBusinessTitleContentDescription(this.mBindCardController.a(0)[1]);
        this.mScrollView.setKeyBoardStatusChangeListener(new SafeScrollView.onKeyBoardStatusChangeListener() {
            public void onKeyBoardStatusChange(boolean z, int i2) {
                "安全键盘的状态" + z;
                if (z) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) BindCardImplActivity.this.l.getLayoutParams();
                    if (BindCardImplActivity.this.N - i2 < 0) {
                        layoutParams.bottomMargin = 0;
                    } else {
                        layoutParams.bottomMargin = BindCardImplActivity.this.N - i2;
                    }
                    BindCardImplActivity.this.l.setLayoutParams(layoutParams);
                    BindCardImplActivity.this.s.postInvalidate();
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) BindCardImplActivity.this.l.getLayoutParams();
                layoutParams2.bottomMargin = BindCardImplActivity.this.N;
                BindCardImplActivity.this.l.setLayoutParams(layoutParams2);
            }
        });
        AnonymousClass33 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                BindCardImplActivity.this.onBackPressed();
            }
        };
        this.f3609i.getBackButton().setOnClickListener(r0);
        if (isShowWithHalfScreeen()) {
            findViewById(ResUtils.id(getActivity(), "action_bar_left_img")).setOnClickListener(r0);
            SafeKeyBoardUtil safeKeyBoardUtil = new SafeKeyBoardUtil();
            safeKeyBoardUtil.setState(SafeKeyBoardUtil.SafeKeyBoardState.CONFRIM_STATE);
            this.mScrollView.setSafeKeyBoardUtil(safeKeyBoardUtil);
            this.mScrollView.setAlwaysShowSoftKeyBoard(true);
            this.m.setVisibility(8);
        } else {
            int bindCardCause = getBindCardCause();
            View findViewById = findViewById(ResUtils.id(this.mAct, "bind_card_head_block"));
            if (1 == bindCardCause || 2 == bindCardCause) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
        }
        this.B = (ViewGroup) findViewById(ResUtils.id(this.mAct, "wallet_bind_card_subtitle"));
        if (Build.VERSION.SDK_INT >= 19) {
            OrderConfirmation orderConfirmation = this.f3609i;
            orderConfirmation.setPadding(orderConfirmation.getPaddingLeft(), StatusBarUtils.getStatusBarHeight(this.mAct), this.f3609i.getPaddingRight(), this.f3609i.getPaddingBottom());
        }
        s();
        h();
        i();
        TextView textView2 = this.D;
        if (textView2 != null && (bindFastRequest = this.mBindReq) != null && bindFastRequest.mBindFrom == 9) {
            textView2.setText(ResUtils.string(this, "wallet_bindcard_head_modify_phone_title"));
        }
    }

    private void g() {
        if (com.baidu.wallet.paysdk.a.b.a() && !PayDataCache.getInstance().hasBondCards()) {
            if (PayDataCache.getInstance().getPayResponse() != null && PayDataCache.getInstance().getPayResponse().protocol_platform_info != null) {
                updateBindCardProtocolFields(PayDataCache.getInstance().getPayResponse().protocol_platform_info);
            } else if (PayDataCache.getInstance().getPayResponse() != null && PayDataCache.getInstance().getPayResponse().authorize != null) {
                Authorize authorize = PayDataCache.getInstance().getPayResponse().authorize;
                if (authorize.agreement_info != null) {
                    updateProtocolFields(PayDataCache.getInstance().getPayResponse().authorize.agreement_info);
                }
                Authorize.Extra extra = authorize.extra;
                if (extra == null || TextUtils.isEmpty(extra.fee_tip)) {
                    this.n.setVisibility(8);
                    return;
                }
                this.n.setVisibility(0);
                this.n.setText(authorize.extra.fee_tip);
            }
        }
    }

    private void h() {
        this.mBankUserInfoView.getTrueNameText().addTextChangedListener(new TextWatcher() {
            public boolean b = false;

            public void afterTextChanged(Editable editable) {
                boolean z = false;
                BindCardImplActivity.this.mBankUserInfoView.setTrueNameRedColor(false);
                BankUserInfoView bankUserInfoView = BindCardImplActivity.this.mBankUserInfoView;
                SafeKeyBoardEditText trueNameText = bankUserInfoView.getTrueNameText();
                if (BindCardImplActivity.this.mBankUserInfoView.getTrueNameText() == BindCardImplActivity.this.c) {
                    z = true;
                }
                bankUserInfoView.hideErrorLayoutWithTag(trueNameText, z);
                if (!this.b) {
                    StatisticManager.onEvent("clickInputTrueName");
                    this.b = true;
                }
                BindCardImplActivity.this.z();
                BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                bindCardImplActivity.a((TextView) bindCardImplActivity.mBankUserInfoView.getTrueNameText(), BindCardImplActivity.this.mBankUserInfoView.getNameTip());
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.mBankUserInfoView.getTrueNameText().setOnMyFocusChangeListener(this);
        this.mBankUserInfoView.getIdEditText().addTextChangedListener(new TextWatcher() {
            public boolean b = false;

            public void afterTextChanged(Editable editable) {
                String str;
                boolean z = false;
                if (BindCardImplActivity.this.mBankUserInfoView.getIdCardFromNet()) {
                    BindCardImplActivity.this.mBankUserInfoView.setIdCardFromNet(false);
                    BindCardImplActivity.this.mBankUserInfoView.getIdEditText().setText("");
                }
                BindCardImplActivity.this.mBankUserInfoView.setIdTipRedColor(false);
                BankUserInfoView bankUserInfoView = BindCardImplActivity.this.mBankUserInfoView;
                bankUserInfoView.hideErrorLayoutWithTag(bankUserInfoView.getIdEditText(), BindCardImplActivity.this.mBankUserInfoView.getIdEditText() == BindCardImplActivity.this.c);
                if (!this.b) {
                    StatisticManager.onEvent("clickInputIdCard");
                    this.b = true;
                }
                if (BindCardImplActivity.this.M == null || !"1".equals(BindCardImplActivity.this.M.type) || editable == null || editable.length() != 18 || BindCardImplActivity.this.n() || editable.toString().contains("*")) {
                    BindCardImplActivity.this.mBankUserInfoView.hideAllComplianceView();
                    BindCardImplActivity.this.mJobAndAddressView.hideAllComplianceView();
                } else {
                    String obj = editable.toString();
                    int parseInt = Calendar.getInstance().get(1) - Integer.parseInt(obj.subSequence(6, 10).toString());
                    if (Integer.parseInt(obj.subSequence(16, 17).toString()) % 2 == 0) {
                        z = true;
                    }
                    BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                    if (z) {
                        str = ResUtils.getString(bindCardImplActivity, "ebpay_woman_tip");
                    } else {
                        str = ResUtils.getString(bindCardImplActivity, "ebpay_man_tip");
                    }
                    BindCardImplActivity.this.a(parseInt, str);
                }
                BindCardImplActivity.this.z();
                BindCardImplActivity bindCardImplActivity2 = BindCardImplActivity.this;
                bindCardImplActivity2.a((TextView) bindCardImplActivity2.mBankUserInfoView.getIdEditText(), BindCardImplActivity.this.mBankUserInfoView.getIdTip());
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.mBankUserInfoView.getIdEditText().setOnMyFocusChangeListener(this);
        this.mBankUserInfoView.getMobileEditText().addTextChangedListener(new TextWatcher() {
            public boolean b = false;

            public void afterTextChanged(Editable editable) {
                boolean z = false;
                if (BindCardImplActivity.this.mBankUserInfoView.getMobileFromNet()) {
                    BindCardImplActivity.this.mBankUserInfoView.setMoblieFromNet(false);
                    BindCardImplActivity.this.mBankUserInfoView.getMobileEditText().setText("");
                }
                BindCardImplActivity.this.mBankUserInfoView.setMobileRedColor(false);
                BankUserInfoView bankUserInfoView = BindCardImplActivity.this.mBankUserInfoView;
                DivisionEditText mobileEditText = bankUserInfoView.getMobileEditText();
                if (BindCardImplActivity.this.mBankUserInfoView.getMobileEditText() == BindCardImplActivity.this.c) {
                    z = true;
                }
                bankUserInfoView.hideErrorLayoutWithTag(mobileEditText, z);
                if (!this.b) {
                    StatisticManager.onEvent("clickInputMobileNo");
                    this.b = true;
                }
                BindCardImplActivity.this.z();
                BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                bindCardImplActivity.a((TextView) bindCardImplActivity.mBankUserInfoView.getMobileEditText(), BindCardImplActivity.this.mBankUserInfoView.getMobileTip());
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.mBankUserInfoView.getMobileEditText().setOnMyFocusChangeListener(this);
        a((TextView) this.mBankUserInfoView.getTrueNameText(), this.mBankUserInfoView.getNameTip());
        a((TextView) this.mBankUserInfoView.getIdEditText(), this.mBankUserInfoView.getIdTip());
        a((TextView) this.mBankUserInfoView.getMobileEditText(), this.mBankUserInfoView.getMobileTip());
    }

    private void i() {
        this.mBankCvv2InfoView.getDateInputView().addTextChangedListener(new TextWatcher() {
            public boolean a = false;

            public void afterTextChanged(Editable editable) {
                BindCardImplActivity.this.mBankCvv2InfoView.setValidDateRedColor(false);
                BankCvv2InfoView bankCvv2InfoView = BindCardImplActivity.this.mBankCvv2InfoView;
                bankCvv2InfoView.hideErrorLayoutWithTag(bankCvv2InfoView.getDateInputView(), BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView() == BindCardImplActivity.this.c);
                if (!this.a) {
                    StatisticManager.onEvent("clickInputDate");
                    this.a = true;
                }
                String obj = BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().getText().toString();
                if (!BindCardImplActivity.this.w.toString().equals(obj)) {
                    BindCardImplActivity.this.w.delete(0, BindCardImplActivity.this.w.length());
                    BindCardImplActivity.this.w.append(obj.replace("/", ""));
                    if (BindCardImplActivity.this.w.length() > 2) {
                        BindCardImplActivity.this.w.insert(2, "/");
                    }
                    BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().setText(BindCardImplActivity.this.w);
                    BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().setSelection(BindCardImplActivity.this.w.length());
                    BindCardImplActivity.this.z();
                    return;
                }
                BindCardImplActivity.this.z();
                BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                bindCardImplActivity.a((TextView) bindCardImplActivity.mBankCvv2InfoView.getDateInputView(), BindCardImplActivity.this.mBankCvv2InfoView.getDateTip());
                if (BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().getText().toString().length() == 5) {
                    BindCardImplActivity bindCardImplActivity2 = BindCardImplActivity.this;
                    bindCardImplActivity2.a((View) bindCardImplActivity2.mBankCvv2InfoView.getDateInputView(), 0, true);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.mBankCvv2InfoView.getDateInputView().setOnMyFocusChangeListener(this);
        this.mBankCvv2InfoView.getCvv2InputView().addTextChangedListener(new TextWatcher() {
            public boolean a = false;

            public void afterTextChanged(Editable editable) {
                boolean z = false;
                BindCardImplActivity.this.mBankCvv2InfoView.setCNN2RedColor(false);
                BankCvv2InfoView bankCvv2InfoView = BindCardImplActivity.this.mBankCvv2InfoView;
                SafeKeyBoardEditText cvv2InputView = bankCvv2InfoView.getCvv2InputView();
                if (BindCardImplActivity.this.mBankCvv2InfoView.getCvv2InputView() == BindCardImplActivity.this.c) {
                    z = true;
                }
                bankCvv2InfoView.hideErrorLayoutWithTag(cvv2InputView, z);
                if (!this.a) {
                    StatisticManager.onEvent("clickInputCvv");
                    this.a = true;
                }
                BindCardImplActivity.this.z();
                BindCardImplActivity bindCardImplActivity = BindCardImplActivity.this;
                bindCardImplActivity.a((TextView) bindCardImplActivity.mBankCvv2InfoView.getCvv2InputView(), BindCardImplActivity.this.mBankCvv2InfoView.getCvv2Tip());
                if (BindCardImplActivity.this.mBankCvv2InfoView.getCvv2InputView().getText().toString().length() == 3) {
                    BindCardImplActivity bindCardImplActivity2 = BindCardImplActivity.this;
                    bindCardImplActivity2.a((View) bindCardImplActivity2.mBankCvv2InfoView.getCvv2InputView(), 1, true);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.mBankCvv2InfoView.getCvv2InputView().setOnMyFocusChangeListener(this);
        a((TextView) this.mBankCvv2InfoView.getCvv2InputView(), this.mBankCvv2InfoView.getCvv2Tip());
        a((TextView) this.mBankCvv2InfoView.getDateInputView(), this.mBankCvv2InfoView.getDateTip());
    }

    private boolean j() {
        return this.h.getCardNoView().getVisibility() != 0 || !this.h.getCardNoView().isEnabled() || this.h.getCardNoView().getRealText().length() >= 10;
    }

    private boolean k() {
        if (!m() && !n() && !o()) {
            return true;
        }
        return false;
    }

    private boolean l() {
        if (!r() && !p()) {
            return true;
        }
        return false;
    }

    private boolean m() {
        return this.mBindCardController.j() && this.mBankUserInfoView.getTrueNameText().isEnabled() && this.mBankUserInfoView.getTrueNameText().getText().toString().trim().length() < 2;
    }

    /* access modifiers changed from: private */
    public boolean n() {
        GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo;
        if (!this.mBindCardController.m() || !this.mBankUserInfoView.getIdEditText().isEnabled() || this.mBankUserInfoView.getIdCardFromNet() || (certificateTypeInfo = this.M) == null) {
            return false;
        }
        return !certificateTypeInfo.getValidator().a(this.mBankUserInfoView.getIdEditText().getText());
    }

    private boolean o() {
        return this.mBindCardController.n() && this.mBankUserInfoView.getMobileEditText().isEnabled() && !this.mBankUserInfoView.getMobileFromNet() && !CheckUtils.isMobileAvailable(this.mBankUserInfoView.getMobileEditText().getRealText());
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean p() {
        /*
            r6 = this;
            com.baidu.wallet.paysdk.b.j r0 = r6.mBindCardController
            boolean r0 = r0.l()
            r1 = 0
            if (r0 == 0) goto L_0x005a
            com.baidu.wallet.paysdk.ui.widget.BankCvv2InfoView r0 = r6.mBankCvv2InfoView
            com.dxmpay.wallet.base.widget.SafeKeyBoardEditText r0 = r0.getDateInputView()
            boolean r0 = r0.isEnabled()
            if (r0 == 0) goto L_0x005a
            com.baidu.wallet.paysdk.ui.widget.BankCvv2InfoView r0 = r6.mBankCvv2InfoView
            com.dxmpay.wallet.base.widget.SafeKeyBoardEditText r0 = r0.getDateInputView()
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            r3 = 1
            if (r2 != 0) goto L_0x0059
            int r2 = r0.length()
            r4 = 5
            if (r2 == r4) goto L_0x0032
            goto L_0x0059
        L_0x0032:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0059 }
            if (r2 != 0) goto L_0x0048
            r2 = 2
            java.lang.String r2 = r0.substring(r1, r2)     // Catch:{ Exception -> 0x0059 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0059 }
            if (r2 <= 0) goto L_0x0047
            r5 = 12
            if (r2 <= r5) goto L_0x0048
        L_0x0047:
            return r3
        L_0x0048:
            r2 = 3
            java.lang.String r0 = r0.substring(r2, r4)     // Catch:{  }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{  }
            int r2 = r6.q()     // Catch:{  }
            if (r0 >= r2) goto L_0x0058
            return r3
        L_0x0058:
            return r1
        L_0x0059:
            return r3
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.ui.BindCardImplActivity.p():boolean");
    }

    /* access modifiers changed from: private */
    public void b(View view, View view2) {
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        view2.setDrawingCacheEnabled(true);
        Bitmap drawingCache2 = view2.getDrawingCache();
        final ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(drawingCache);
        final ImageView imageView2 = new ImageView(this);
        imageView2.setImageBitmap(drawingCache2);
        this.b.addView(imageView, new LinearLayout.LayoutParams(-1, -2));
        this.b.addView(imageView2, new LinearLayout.LayoutParams(-1, -2));
        this.y.post(new Runnable() {
            public void run() {
                ViewGroup viewGroup = (ViewGroup) imageView.getParent();
                viewGroup.getTop();
                viewGroup.getBottom();
                final int bottom = imageView.getBottom();
                final int height = viewGroup.getHeight() - imageView2.getTop();
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                ofFloat.setDuration(500).setInterpolator(new LinearInterpolator());
                ofFloat.start();
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        ViewHelper.setTranslationY(imageView, ((float) (-bottom)) * floatValue);
                        ViewHelper.setTranslationY(imageView2, ((float) height) * floatValue);
                        if (floatValue <= 0.0f) {
                            BindCardImplActivity.this.initSafeKeyBoard();
                            BindCardImplActivity.this.b.setVisibility(8);
                            BindCardImplActivity.this.h.getCardNoView().clearFocus();
                            BindCardImplActivity.this.h.getCardNoView().requestFocus();
                        }
                    }
                });
            }
        });
    }

    private void a() {
        f();
        e();
        if (!this.x) {
            initSafeKeyBoard();
        }
        if ((this.mBindCardController instanceof g) && !this.h.getCardNoView().isEnabled() && getCurrentStep() == 0) {
            this.mScrollView.setBackgroundColor(ResUtils.getColor(this.mAct, "dxm_wallet_base_whiteColor"));
            b();
        }
    }

    private void b(String str) {
        if (!this.L.equals(str)) {
            this.L = str;
            updateBankTitleInfo((GetCardInfoResponse.CardInfo) null, false);
            this.mBindCardController.a(str);
        }
    }

    private void b(int i2) {
        if (i2 == 0) {
            this.mBankCvv2InfoView.getDateTip().setVisibility(0);
            this.mBankUserInfoView.getNameTip().setVisibility(0);
            this.mBankUserInfoView.getMobileTip().setVisibility(0);
            this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
            this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getNameTip().setOnClickListener(this);
            this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
        } else if (i2 == 1) {
            this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
            this.mBankUserInfoView.getNameTip().setVisibility(0);
            this.mBankUserInfoView.getMobileTip().setVisibility(0);
            this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
            this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getNameTip().setOnClickListener(this);
            this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
        } else if (i2 == 2) {
            this.mBankCvv2InfoView.getDateTip().setVisibility(0);
            this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
            this.mBankUserInfoView.getMobileTip().setVisibility(0);
            this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
            this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
            this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
        } else if (i2 == 3) {
            this.mBankCvv2InfoView.getDateTip().setVisibility(0);
            this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
            this.mBankUserInfoView.getNameTip().setVisibility(0);
            this.mBankUserInfoView.getMobileTip().setVisibility(0);
            this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
            this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
            this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
            this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getNameTip().setOnClickListener(this);
        } else if (i2 == 4) {
            this.mBankCvv2InfoView.getDateTip().setVisibility(0);
            this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
            this.mBankUserInfoView.getNameTip().setVisibility(0);
            this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
            this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
            this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            this.mBankUserInfoView.getNameTip().setOnClickListener(this);
        }
    }

    private void a(final View view, final View view2) {
        this.x = true;
        this.y = new a(this);
        LinearLayout linearLayout = new LinearLayout(this);
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        this.b.setBackgroundResource(ResUtils.color(this, "dxm_wallet_base_window_bg"));
        ((ViewGroup) findViewById(16908290)).addView(this.b, new FrameLayout.LayoutParams(-1, -1));
        this.y.post(new Runnable() {
            public void run() {
                BindCardImplActivity.this.b(view, view2);
            }
        });
    }

    private void a(b bVar) {
        if (bVar != null) {
            BankCvv2InfoView bankCvv2InfoView = this.mBankCvv2InfoView;
            if (bankCvv2InfoView != null) {
                bankCvv2InfoView.getCvv2InputView().setText(bVar.b);
                this.mBankCvv2InfoView.getDateInputView().setText(bVar.c);
            }
            BankUserInfoView bankUserInfoView = this.mBankUserInfoView;
            if (bankUserInfoView != null) {
                bankUserInfoView.getTrueNameText().setText(bVar.a);
                this.mBankUserInfoView.getIdEditText().setText(bVar.d);
                this.mBankUserInfoView.getMobileEditText().setText(bVar.e);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        AnonymousClass3 r0 = new BankUserInfoView.a() {
            public void a() {
                BindCardImplActivity.this.z();
            }

            public void b() {
                BindCardImplActivity.this.z();
            }
        };
        this.mBankUserInfoView.setIdCardStartDateStatus(this, this.E, r0);
        this.mBankUserInfoView.setIdCardEndDateStatus(this, this.F, i2 > 45, r0);
        this.mBankUserInfoView.setNationalityStatus(this.G);
        this.mBankUserInfoView.setGenderStatus(this.H);
        this.mBankUserInfoView.setGenderTxt(str);
        if (this.I || this.J) {
            this.mJobAndAddressView.setVisibility(0);
            AnonymousClass4 r7 = new JobAndAddressView.a() {
                public void a() {
                    BindCardImplActivity.this.z();
                }
            };
            this.mJobAndAddressView.setJobStatus(this.I, this.J, i2, r7);
            this.mJobAndAddressView.setAddressStatus(this, this.I, this.J, r7);
        }
    }

    /* access modifiers changed from: private */
    public void a(final TextView textView, ImageView imageView) {
        imageView.setVisibility(0);
        if (textView.getText().toString().length() == 0) {
            imageView.setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            a(imageView);
            imageView.setOnClickListener(this);
            if (imageView == this.mBankUserInfoView.getIdTip()) {
                imageView.setVisibility(4);
            }
        } else if (textView.isEnabled()) {
            imageView.setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
            AccessibilityUtils.setContentDescription(imageView, "清除");
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    textView.setText("");
                    textView.requestFocus();
                }
            });
        } else {
            imageView.setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
            a(imageView);
            imageView.setOnClickListener(this);
            if (imageView == this.mBankUserInfoView.getIdTip()) {
                imageView.setVisibility(4);
            }
        }
    }

    private void a(ImageView imageView) {
        ImageView dateTip = this.mBankCvv2InfoView.getDateTip();
        if (imageView == this.mBankCvv2InfoView.getCvv2Tip()) {
            AccessibilityUtils.setContentDescription(imageView, "CVN2 说明");
        } else if (imageView == dateTip) {
            AccessibilityUtils.setContentDescription(imageView, "有效期说明");
        }
    }

    private void a(View view, boolean z2) {
        if (view == this.mBankCvv2InfoView.getCvv2InputView()) {
            int length = ((SafeKeyBoardEditText) view).getText().toString().length();
            if (!z2) {
                this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
                return;
            }
            this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, true);
            if (length == 0) {
                this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
                return;
            }
            this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
            this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BindCardImplActivity.this.mBankCvv2InfoView.getCvv2InputView().setText("");
                    BindCardImplActivity.this.mBankCvv2InfoView.getCvv2InputView().requestFocus();
                }
            });
        } else if (view == this.mBankCvv2InfoView.getDateInputView()) {
            int length2 = ((SafeKeyBoardEditText) view).getText().toString().length();
            if (!z2) {
                this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
                return;
            }
            this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, true);
            if (length2 == 0) {
                this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
                return;
            }
            this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
            this.mBankCvv2InfoView.getDateTip().setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().setText("");
                    BindCardImplActivity.this.mBankCvv2InfoView.getDateInputView().requestFocus();
                }
            });
        } else if (view == this.mBankUserInfoView.getTrueNameText()) {
            int length3 = ((EditText) view).getText().toString().length();
            if (!z2) {
                this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getNameTip().setOnClickListener(this);
                return;
            }
            this.mBankUserInfoView.hideErrorLayoutWithTag(view, true);
            if (length3 == 0) {
                this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getNameTip().setOnClickListener(this);
                return;
            }
            this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
            this.mBankUserInfoView.getNameTip().setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BindCardImplActivity.this.mBankUserInfoView.getTrueNameText().setText("");
                    BindCardImplActivity.this.mBankUserInfoView.getTrueNameText().requestFocus();
                }
            });
        } else if (view == this.mBankUserInfoView.getMobileEditText()) {
            int length4 = ((DivisionEditText) view).getText().toString().length();
            if (!z2) {
                this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
                return;
            }
            this.mBankUserInfoView.hideErrorLayoutWithTag(view, true);
            if (length4 == 0) {
                this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
                return;
            }
            this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
            this.mBankUserInfoView.getMobileTip().setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BindCardImplActivity.this.mBankUserInfoView.getMobileEditText().setText("");
                    BindCardImplActivity.this.mBankUserInfoView.getMobileEditText().requestFocus();
                }
            });
        } else if (view == this.mBankUserInfoView.getIdEditText()) {
            int length5 = ((SafeKeyBoardEditText) view).getText().toString().length();
            if (!z2) {
                this.mBankUserInfoView.getIdTip().setVisibility(4);
                return;
            }
            this.mBankUserInfoView.hideErrorLayoutWithTag(view, true);
            if (length5 == 0) {
                this.mBankUserInfoView.getIdTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getIdTip().setOnClickListener(this);
                this.mBankUserInfoView.getIdTip().setVisibility(4);
                return;
            }
            this.mBankUserInfoView.getIdTip().setVisibility(0);
            this.mBankUserInfoView.getIdTip().setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
            this.mBankUserInfoView.getIdTip().setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BindCardImplActivity.this.mBankUserInfoView.getIdEditText().setText("");
                    BindCardImplActivity.this.mBankUserInfoView.getIdEditText().requestFocus();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(View view) {
        if (view == this.mBankCvv2InfoView.getCvv2InputView()) {
            if (TextUtils.isEmpty(this.mBankCvv2InfoView.getCvv2InputView().getText().toString()) || !r()) {
                this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, false);
                return;
            }
            StatisticManager.onEventWithValue("showInputError", ResUtils.getString(getActivity(), "ebpay_bank_cvv2_errortip"));
            this.mBankCvv2InfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_bank_cvv2"), ResUtils.getString(getActivity(), "ebpay_bank_cvv2_errortip"), view);
        } else if (view == this.mBankCvv2InfoView.getDateInputView()) {
            if (TextUtils.isEmpty(this.mBankCvv2InfoView.getDateInputView().getText().toString()) || !p()) {
                this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, false);
                return;
            }
            StatisticManager.onEventWithValue("showInputError", ResUtils.getString(getActivity(), "ebpay_valid_date_errortip"));
            this.mBankCvv2InfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_valid_date"), ResUtils.getString(getActivity(), "ebpay_valid_date_errortip"), view);
        } else if (view == this.mBankUserInfoView.getTrueNameText()) {
            if (TextUtils.isEmpty(this.mBankUserInfoView.getTrueNameText().getText().toString()) || !m()) {
                this.mBankUserInfoView.hideErrorLayoutWithTag(view, false);
                return;
            }
            StatisticManager.onEventWithValue("showInputError", ResUtils.getString(getActivity(), "ebpay_name_error_tip"));
            this.mBankUserInfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_name"), ResUtils.getString(getActivity(), "ebpay_name_error_tip"), view);
        } else if (view == this.mBankUserInfoView.getIdEditText()) {
            if (TextUtils.isEmpty(this.mBankUserInfoView.getIdEditText().getText()) || !n()) {
                this.mBankUserInfoView.hideErrorLayoutWithTag(view, false);
                return;
            }
            StatisticManager.onEventWithValue("showInputError", ResUtils.getString(getActivity(), "ebpay_id_card_errortip"));
            BankUserInfoView bankUserInfoView = this.mBankUserInfoView;
            GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.M;
            bankUserInfoView.showErrorLayout((certificateTypeInfo == null || TextUtils.isEmpty(certificateTypeInfo.description)) ? ResUtils.getString(getActivity(), "ebpay_id_card") : this.M.description, ResUtils.getString(getActivity(), "ebpay_id_card_errortip"), view);
        } else if (view != this.mBankUserInfoView.getMobileEditText()) {
        } else {
            if (TextUtils.isEmpty(this.mBankUserInfoView.getMobileEditText().getRealText()) || !o()) {
                this.mBankUserInfoView.hideErrorLayoutWithTag(view, false);
                return;
            }
            StatisticManager.onEventWithValue("showInputError", ResUtils.getString(getActivity(), "ebpay_bank_bind_phone_errortip"));
            this.mBankUserInfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_bank_bind_phone"), ResUtils.getString(getActivity(), "ebpay_bank_bind_phone_errortip"), view);
        }
    }

    private void a(String str) {
        StatHelper.statPayAllServiceEvent("firstNext", PAY_BIND_CARD_HASH_NAME, PAY_BIND_CARD_HASH_ID, "点击第一步", new String[0]);
        if (!isBindInvalid()) {
            WalletGlobalUtils.safeShowDialog(this, -2, "");
            c();
            this.mBindReq.setChannelNo("");
            this.mBindReq.setSubBankCode(str);
            this.mBindCardController.d(this.K, "");
        }
    }

    /* access modifiers changed from: private */
    public void a(GetCardInfoResponse getCardInfoResponse) {
        if (getCardInfoResponse != null) {
            GetCardInfoResponse.CardInfo cardInfo = getCardInfoResponse.card_info;
            if (cardInfo != null && !TextUtils.isEmpty(cardInfo.bank_no)) {
                this.mBindReq.mBankNo = getCardInfoResponse.card_info.bank_no;
            }
            this.mBindReq.setmBankInfo(getCardInfoResponse);
            this.mBindReq.setmBankCard(this.K);
            this.mBindCardController.a();
            this.r.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public GetCardInfoResponse.CertificateTypeInfo[] a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo, GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        if (certificateTypeInfoArr != null) {
            for (GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo2 : certificateTypeInfoArr) {
                if (certificateTypeInfo == null) {
                    certificateTypeInfo2.setDisplay(false);
                } else if (certificateTypeInfo.type.equals(certificateTypeInfo2.type)) {
                    certificateTypeInfo2.setDisplay(true);
                } else {
                    certificateTypeInfo2.setDisplay(false);
                }
            }
        }
        return certificateTypeInfoArr;
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest != null) {
            if (z2) {
                bindFastRequest.setmBankCard(this.K);
            }
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putBoolean("isSelectBank", z2);
            Intent intent = new Intent(getActivity(), SignChannelListActivity.class);
            intent.putExtras(extras);
            startActivityForResult(intent, (int) DxmPayBeanConstants.REQUEST_CODE_SIGN_CHANNEL_LIST);
        }
    }

    /* access modifiers changed from: private */
    public void a(View view, int i2, boolean z2) {
        boolean[] zArr = new boolean[5];
        boolean z3 = true;
        zArr[0] = this.mBindCardController.l() && this.mBankCvv2InfoView.getDateInputView().isEnabled();
        zArr[1] = this.mBindCardController.k() && this.mBankCvv2InfoView.getCvv2InputView().isEnabled();
        zArr[2] = this.mBindCardController.j() && this.mBankUserInfoView.getTrueNameText().isEnabled();
        zArr[3] = this.mBindCardController.m() && this.mBankUserInfoView.getIdEditText().isEnabled();
        zArr[4] = this.mBindCardController.n() && this.mBankUserInfoView.getMobileEditText().isEnabled();
        View a2 = a(i2, zArr);
        if (!(a2 instanceof TextView) || !TextUtils.isEmpty(((TextView) a2).getText())) {
            z3 = false;
        }
        if (z3) {
            a2.requestFocus();
            if (a2 == this.mBankUserInfoView.getTrueNameText()) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        GlobalUtils.showInputMethod(BindCardImplActivity.this.getActivity(), BindCardImplActivity.this.mBankUserInfoView.getTrueNameText());
                    }
                }, 150);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        CardData.BondCard bondCard;
        if (isShowWithHalfScreeen()) {
            SafeKeyBoardEditText[] safeKeyBoardEditTextArr = {this.h.getCardNoView(), this.mBankCvv2InfoView.getDateInputView(), this.mBankCvv2InfoView.getCvv2InputView(), this.mBankUserInfoView.getIdEditText(), this.mBankUserInfoView.getMobileEditText()};
            AnonymousClass26 r8 = new SafeKeyBoardEditText.CheckFunc() {
                public boolean check(String str) {
                    return BindCardImplActivity.this.y();
                }
            };
            boolean z7 = false;
            for (int i2 = 0; i2 < 5; i2++) {
                SafeKeyBoardEditText safeKeyBoardEditText = safeKeyBoardEditTextArr[i2];
                if (safeKeyBoardEditText.isShown()) {
                    safeKeyBoardEditText.setConfirmListener(this);
                    safeKeyBoardEditText.setCheckFunc(r8);
                    if (!z7) {
                        SafeScrollView safeScrollView = this.mScrollView;
                        safeScrollView.showKeyBoard(safeScrollView, safeKeyBoardEditText, (View) safeKeyBoardEditText.getTag());
                        z7 = true;
                    }
                }
            }
            if (this.mBankUserInfoView.getIdEditText().isShown()) {
                this.mBankUserInfoView.getIdEditText().setUseKeyX(true);
            }
            BindFastRequest bindFastRequest = this.mBindReq;
            if (bindFastRequest == null || (bondCard = bindFastRequest.mBondCard) == null || bondCard.bank_code == null) {
                com.baidu.wallet.paysdk.ui.widget.a.a(this.B, ResUtils.getString(this.mAct, "ebpay_title_complete_fixmsg"), (CharSequence) null, (CharSequence) null);
            } else {
                com.baidu.wallet.paysdk.ui.widget.a.a(this.B, "请完善", bondCard.getCardDesc(this.mAct, false), "的信息后继续支付");
            }
        }
        this.h.getCardNoView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, this.h.getCardNoView(), false);
        if (z3 && this.mBankCvv2InfoView.getDateInputView().isEnabled()) {
            this.mBankCvv2InfoView.getDateInputView().setOnMyFocusChangeListener(this);
            this.mBankCvv2InfoView.getDateInputView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, (View) this.mBankCvv2InfoView.getDateInputView().getTag(), false);
            this.mBankCvv2InfoView.getDateInputView().requestFocus();
        }
        if (z2 && this.mBankCvv2InfoView.getCvv2InputView().isEnabled()) {
            this.mBankCvv2InfoView.getCvv2InputView().setOnMyFocusChangeListener(this);
            this.mBankCvv2InfoView.getCvv2InputView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, this.mBankCvv2InfoView.getCvv2InputView(), false);
            if (!z3) {
                this.mBankCvv2InfoView.getCvv2InputView().requestFocus();
            }
        }
        if (z4 && this.mBankUserInfoView.getTrueNameText().isEnabled() && !z2 && !z3) {
            try {
                this.mBankUserInfoView.getTrueNameText().setSelection(this.mBankUserInfoView.getTrueNameText().getText().length());
            } catch (Exception unused) {
            }
            this.mBankUserInfoView.getTrueNameText().requestFocus();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    GlobalUtils.showInputMethod(BindCardImplActivity.this.getActivity(), BindCardImplActivity.this.mBankUserInfoView.getTrueNameText());
                }
            }, 150);
        }
        if (z5 && this.mBankUserInfoView.getIdEditText().isEnabled()) {
            this.mBankUserInfoView.getIdEditText().setOnMyFocusChangeListener(this);
            this.mBankUserInfoView.getIdEditText().initSafeKeyBoardParams(this.mRootView, this.mScrollView, a(3, z2, z3, z4, z5, z6), false);
            if (!z4 && !z3 && !z2) {
                try {
                    this.mBankUserInfoView.getIdEditText().setSelection(this.mBankUserInfoView.getIdEditText().getText().length());
                } catch (Exception unused2) {
                }
                this.mBankUserInfoView.getIdEditText().requestFocus();
            }
        }
        if (z6 && this.mBankUserInfoView.getMobileEditText().isEnabled()) {
            this.mBankUserInfoView.getMobileEditText().setOnMyFocusChangeListener(this);
            this.mBankUserInfoView.getMobileEditText().initSafeKeyBoardParams(this.mRootView, this.mScrollView, a(4, z2, z3, z4, z5, z6), false);
            if (!z4 && !z3 && !z2) {
                if (!z5 || !this.mBankUserInfoView.getIdEditText().isEnabled()) {
                    try {
                        this.mBankUserInfoView.getMobileEditText().setSelection(this.mBankUserInfoView.getMobileEditText().getText().length());
                    } catch (Exception unused3) {
                    }
                    this.mBankUserInfoView.getMobileEditText().requestFocus();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public View a(int i2, boolean... zArr) {
        if (i2 >= zArr.length) {
            return this.m;
        }
        int i3 = i2 + 1;
        while (i3 < zArr.length) {
            if (!zArr[i3]) {
                i3++;
            } else if (i3 == 0) {
                return this.mBankCvv2InfoView.getDateInputView();
            } else {
                if (i3 == 1) {
                    return this.mBankCvv2InfoView.getCvv2InputView();
                }
                if (i3 == 2) {
                    return this.mBankUserInfoView.getTrueNameText();
                }
                if (i3 == 3) {
                    return this.mBankUserInfoView.getIdEditText();
                }
                if (i3 != 4) {
                    return this.m;
                }
                return this.mBankUserInfoView.getMobileEditText();
            }
        }
        return this.m;
    }
}
