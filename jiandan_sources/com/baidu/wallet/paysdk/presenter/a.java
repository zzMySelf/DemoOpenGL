package com.baidu.wallet.paysdk.presenter;

import android.view.View;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Map;

public class a implements View.OnClickListener, e {
    public AuthorizeSignActivity a;
    public int b = 1;

    public a(AuthorizeSignActivity authorizeSignActivity) {
        this.a = authorizeSignActivity;
    }

    private void h() {
        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_ENTER);
        StatisticManager.onEventStart(PayStatServiceEvent.PAY_BIND_CARD_DURATION);
        if (PayDataCache.getInstance().hasMobilePwd()) {
            PasswordController.getPassWordInstance().checkPwd(this.a.getActivity(), DxmPayBeanConstants.FROM_BIND_PAY, new PasswordController.IPwdListener() {
                public void onFail(int i2, String str) {
                    PayRequestCache.getInstance().removeBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
                }

                public void onSucceed(String str) {
                    PayRequestCache.getInstance().removeBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
                    BaiduPay.getInstance().bindCardAuth(a.this.a.getActivity(), false);
                    StatHelper.statServiceEvent(StatServiceEvent.EVENT_AuthorizePay_ClickNext, (Map<String, Object>) null, StatServiceEvent.VALUE_AuthorizePay_ClickNext_NewCard);
                }
            });
            return;
        }
        BaiduPay.getInstance().bindCardAuth(this.a.getActivity(), false);
        StatHelper.statServiceEvent(StatServiceEvent.EVENT_AuthorizePay_ClickNext, (Map<String, Object>) null, StatServiceEvent.VALUE_AuthorizePay_ClickNext_NewCard);
    }

    public void a() {
        AuthorizeSignActivity authorizeSignActivity = this.a;
        if (authorizeSignActivity != null) {
            authorizeSignActivity.initCardList();
            this.a.setSelectCardListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.a(a.this.a.getActivity(), (com.baidu.wallet.paysdk.a.a) null);
                }
            });
            this.a.initNextButton(this);
        }
    }

    public void a(boolean z) {
    }

    public void b() {
        AuthorizeSignActivity authorizeSignActivity = this.a;
        if (authorizeSignActivity != null) {
            authorizeSignActivity.updateProtocolFields();
            this.a.updateNextButton();
            AuthorizeSignActivity authorizeSignActivity2 = this.a;
            authorizeSignActivity2.updateSelBankInfo(authorizeSignActivity2.getPayRequest().mBondCard);
            DirectPayContentResponse payResponse = this.a.getPayResponse();
            if (payResponse != null && payResponse.authorize != null && f()) {
                this.a.updateHintText(payResponse.authorize.extra.fee_tip);
            }
        }
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (r0 = r0.authorize).extra;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.ui.AuthorizeSignActivity r0 = r1.a
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r0.getPayResponse()
            if (r0 == 0) goto L_0x001a
            com.baidu.wallet.base.datamodel.Authorize r0 = r0.authorize
            if (r0 == 0) goto L_0x001a
            com.baidu.wallet.base.datamodel.Authorize$Extra r0 = r0.extra
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = r0.fee_tip
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001a
            r0 = 1
            return r0
        L_0x001a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.presenter.a.f():boolean");
    }

    public int g() {
        return this.b;
    }

    public void onClick(View view) {
        if (this.a != null && view.getId() == ResUtils.id(this.a.getApplicationContext(), "sign_next_btn")) {
            PayRequest payRequest = this.a.getPayRequest();
            CardData.BondCard selectedCard = this.a.getSelectedCard();
            StatHelper.cacheHasPwd(PayDataCache.getInstance().hasMobilePwd());
            StatHelper.cacheHasBankCard(PayDataCache.getInstance().hasBondCards());
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(3);
            if (selectedCard == null) {
                h();
            } else if (!selectedCard.isCompled()) {
                if (payRequest != null) {
                    payRequest.mBondCard = selectedCard;
                }
                a(selectedCard);
            } else if (!CheckUtils.isFastDoubleClick()) {
                if (payRequest != null) {
                    payRequest.mBondCard = selectedCard;
                }
                BaiduPay.getInstance().directAuth(this.a.getActivity(), selectedCard);
                StatHelper.statServiceEvent(StatServiceEvent.EVENT_AuthorizePay_ClickNext, (Map<String, Object>) null, StatServiceEvent.VALUE_AuthorizePay_ClickNext_BoundCard);
                StatisticManager.onEventStart(PayStatServiceEvent.PAY_SMS_DURATION);
            }
        }
    }

    private void a(final CardData.BondCard bondCard) {
        if (PayDataCache.getInstance().hasMobilePwd()) {
            PasswordController.getPassWordInstance().checkPwd(this.a.getActivity(), DxmPayBeanConstants.FROM_COMPLETE_PAY, new PasswordController.IPwdListener() {
                public void onFail(int i2, String str) {
                    PayRequestCache.getInstance().removeBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
                }

                public void onSucceed(String str) {
                    PayRequestCache.getInstance().removeBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
                    BaiduPay.getInstance().completeCardAuth(a.this.a.getActivity(), bondCard);
                    StatHelper.statServiceEvent(StatServiceEvent.EVENT_AuthorizePay_ClickNext, (Map<String, Object>) null, StatServiceEvent.VALUE_AuthorizePay_ClickNext_CompleteCard);
                }
            });
            return;
        }
        BaiduPay.getInstance().completeCardAuth(this.a.getActivity(), bondCard);
        StatHelper.statServiceEvent(StatServiceEvent.EVENT_AuthorizePay_ClickNext, (Map<String, Object>) null, StatServiceEvent.VALUE_AuthorizePay_ClickNext_CompleteCard);
    }
}
