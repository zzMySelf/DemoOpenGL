package com.baidu.android.lbspay.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.EncodeUtils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.OSUtils;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class NewCashierBean extends BaseBean<NewCashierContent> {
    public CashierDataNew mCashierData;

    public NewCashierBean(Context context) {
        super(context);
    }

    public void execBean() {
        execBean(NewCashierContent.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        CashierDataNew cashierDataNew = this.mCashierData;
        if (cashierDataNew == null) {
            return arrayList;
        }
        cashierDataNew.addParams(arrayList);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NetworkBean.PARAM_REAL_OS, OSUtils.getOSName(this.mContext));
            jSONObject.put("ua", BussinessUtils.getUA(this.mContext));
            jSONObject.put("cuid_1", EncodeUtils.encodeCommParms(PhoneUtils.getCUID(this.mContext)));
            jSONObject.put("supportList", String.valueOf(343));
            jSONObject.put("wcp", PhoneUtils.getWCPParams(this.mContext));
            jSONObject.put("key", SecurePay.getInstance().getpwProxy());
            String cookie = PayUtils.getCookie(this.mContext);
            if (!TextUtils.isEmpty(cookie)) {
                jSONObject.put(com.baidu.wallet.core.beans.NetworkBean.PARAM_COOKIE, SecurePay.getInstance().encryptProxy(cookie));
            } else {
                jSONObject.put(com.baidu.wallet.core.beans.NetworkBean.PARAM_COOKIE, "");
            }
            String newCookie = PayUtils.getNewCookie(this.mContext);
            if (!TextUtils.isEmpty(newCookie)) {
                jSONObject.put("natbc", SecurePay.getInstance().encryptProxy(newCookie));
            } else {
                jSONObject.put("natbc", "");
            }
            if (WalletLoginHelper.getInstance().isLogin()) {
                jSONObject.put("preOrder", "1");
            } else {
                jSONObject.put("preOrder", "0");
            }
            if (WalletFingerprint.getInstance(this.mContext).hasEnrollFingerprint()) {
                jSONObject.put("enroll_fingerprint", "1");
            }
            if (this.mCashierData.isShowAllPayType()) {
                jSONObject.put("bfb_only_but_show", "1");
            }
        } catch (Exception unused) {
        }
        arrayList.add(new RestNameValuePair("reqData", jSONObject.toString()));
        return arrayList;
    }

    public int getBeanId() {
        return 1;
    }

    public int getHttpMethod() {
        return 1;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getZhiFuHost() + "/proxy/req/newcashier";
    }

    public boolean isLbsPayBean() {
        return true;
    }

    public void setmCashierData(CashierDataNew cashierDataNew) {
        this.mCashierData = cashierDataNew;
    }
}
