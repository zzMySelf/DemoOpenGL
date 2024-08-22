package com.baidu.wallet.paysdk.payresult.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ac;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.b;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.FeedbackDialog;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.BaseActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class a implements b.a {
    public static final String f = "a";
    public WeakReference<BaseActivity> a;
    public b.C0167b b;
    public int c = 0;
    public PayRequest d;
    public boolean e = true;
    public IPayResultDataAdapter g;

    public a(b.C0167b bVar, BaseActivity baseActivity, Bundle bundle) {
        PayRequest payRequest;
        this.a = new WeakReference<>(baseActivity);
        this.b = bVar;
        d(bundle);
        if (this.c != 1 || (payRequest = this.d) == null) {
            this.g = com.baidu.wallet.paysdk.payresult.adapters.a.a((BaseActivity) this.a.get(), this.c);
            return;
        }
        IPayResultDataAdapter a2 = com.baidu.wallet.paysdk.payresult.adapters.a.a(baseActivity, payRequest.getPayFrom());
        this.g = a2;
        if (a2 == null) {
            this.g = com.baidu.wallet.paysdk.payresult.adapters.a.a((BaseActivity) this.a.get(), this.c);
        }
    }

    public boolean b() {
        return this.g.isBelongPaySdk();
    }

    public void c() {
        IPayResultDataAdapter iPayResultDataAdapter = this.g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.clearDataOnDestroy();
        }
    }

    public void d() {
        this.b.showExpectedTime(this.g.getExpectedTime());
    }

    public void e() {
        PayResultContent payResultContent = this.g.getPayResultContent();
        if (payResultContent != null) {
            this.b.setTitleLogo(payResultContent.title_url);
            this.b.showPayResultRealMoneyText(payResultContent.cash_amount);
            this.b.showTotalAmountInfo(payResultContent.total_amount, payResultContent.order_prefix, payResultContent.cash_amount);
            this.b.showDiscountTypeInfo(payResultContent.discount_info, payResultContent.discount_amount, payResultContent.discount_prefix);
            this.b.showPayTypeInfo(payResultContent.paytype_info, payResultContent.discount_amount, payResultContent.cash_amount, payResultContent.total_amount);
            return;
        }
        this.b.showPayResultMoneyLayoutVisible(false);
    }

    public ArrayList<String> f() {
        IPayResultDataAdapter iPayResultDataAdapter = this.g;
        if (iPayResultDataAdapter == null) {
            return new ArrayList<>();
        }
        return iPayResultDataAdapter.getEventValue();
    }

    public void g() {
        IPayResultDataAdapter iPayResultDataAdapter = this.g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.handleOKBtnOnclick();
        }
    }

    public void h() {
        PayResultContent.CrossMarket crossMarket;
        IPayResultDataAdapter iPayResultDataAdapter = this.g;
        if (iPayResultDataAdapter != null) {
            if (iPayResultDataAdapter.getPayResultContent() != null) {
                this.b.showAuthDialog(this.g.getPayResultContent().compliance);
            }
            IPayResultDataAdapter iPayResultDataAdapter2 = this.g;
            if (iPayResultDataAdapter2 != null && iPayResultDataAdapter2.getPayResultContent() != null && (crossMarket = this.g.getPayResultContent().cross_market) != null && !TextUtils.isEmpty(crossMarket.jump_url)) {
                this.b.showMarketDialog(crossMarket.pic_url, crossMarket.jump_url);
            }
        }
    }

    public void i() {
        PayResultContent payResultContent = this.g.getPayResultContent();
        if (this.g.isPaySuccess()) {
            this.b.showPaySuccess(a(this.g.getPaySuccessContents(), payResultContent));
        } else {
            this.b.showPaying(a(this.g.getPayingContents(), payResultContent));
        }
    }

    public boolean j() {
        PayResultContent payResultContent;
        IPayResultDataAdapter iPayResultDataAdapter = this.g;
        if (iPayResultDataAdapter == null || (payResultContent = iPayResultDataAdapter.getPayResultContent()) == null || payResultContent.feedback_info == null || !this.e) {
            return false;
        }
        this.e = false;
        return true;
    }

    public FeedbackDialog.a k() {
        FeedbackDialog.a aVar = new FeedbackDialog.a();
        IPayResultDataAdapter iPayResultDataAdapter = this.g;
        if (!(iPayResultDataAdapter == null || iPayResultDataAdapter.getPayResultContent() == null)) {
            aVar.a = this.g.getPayResultContent().feedback_info;
            aVar.b = new FeedbackDialog.b() {
                public void a(FeedbackDialog.c cVar) {
                    ac acVar = (ac) PayBeanFactory.getInstance().getBean((Context) a.this.a.get(), (int) PayBeanFactory.BEAN_ID_SAVE_FEEDBACK, a.f);
                    acVar.a(a.this.g.getPayResultContent().trans_no, cVar);
                    acVar.execBean();
                    a.this.b.finishPage();
                    a.this.g();
                }

                public void a() {
                    a.this.b.finishPage();
                    a.this.g();
                }
            };
        }
        return aVar;
    }

    public boolean a() {
        return this.g != null;
    }

    public void b(Bundle bundle) {
        bundle.putSerializable(DxmPayBeanConstants.KEY_PAY_RESULT_TYPE, Integer.valueOf(this.c));
        PayRequest payRequest = this.d;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
        IPayResultDataAdapter iPayResultDataAdapter = this.g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.onSaveInstanceState(bundle);
        }
    }

    public boolean a(Bundle bundle) {
        return this.g.onCreateCheckInvalide(bundle);
    }

    public boolean c(Bundle bundle) {
        String actionBarTextId = this.g.getActionBarTextId();
        if (TextUtils.isEmpty(actionBarTextId)) {
            actionBarTextId = "bd_wallet_payresult_title";
        }
        this.b.initActionBar(actionBarTextId);
        this.b.initViewElements();
        i();
        e();
        d();
        this.b.showAuthorizeMsg(this.g.getAuthorizeMsg());
        if (this.g.isShowLBSPayText()) {
            b.C0167b bVar = this.b;
            bVar.setOKBtnText(ResUtils.getString((Context) this.a.get(), "ebpay_confirm_ret_msg") + this.g.getLBSPayText());
        }
        if (this.g.showResultPage()) {
            return true;
        }
        g();
        this.b.finishPage();
        return false;
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getInt(DxmPayBeanConstants.KEY_PAY_RESULT_TYPE);
            this.d = (PayRequest) bundle.getSerializable("mPayRequest");
        } else if (((BaseActivity) this.a.get()).getIntent() != null && ((BaseActivity) this.a.get()).getIntent().getExtras() != null) {
            this.c = ((BaseActivity) this.a.get()).getIntent().getExtras().getInt(DxmPayBeanConstants.KEY_PAY_RESULT_TYPE);
            this.d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        }
    }

    private HashMap a(HashMap hashMap, PayResultContent payResultContent) {
        if (!(hashMap == null || payResultContent == null)) {
            hashMap.put("update_phone_desc", payResultContent.subtitle_msg);
        }
        return hashMap;
    }
}
