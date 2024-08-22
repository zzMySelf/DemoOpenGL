package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddErrorContent;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.utils.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class e extends BaseBean<CardAddResponse> {
    public String a = null;
    public BindFastRequest b = null;
    public Context c;

    public e(Context context) {
        super(context);
        this.c = context;
    }

    public void a(String str) {
        this.a = str;
    }

    public void execBean() {
        super.execBean(CardAddResponse.class, CardAddErrorContent.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        List<RestNameValuePair> list;
        if (this.b != null) {
            if (TextUtils.isEmpty(this.a)) {
                list = new ArrayList<>();
            } else {
                list = JsonUtil.json2KeyValuePairs(this.a);
                if (list == null) {
                    list = new ArrayList<>();
                }
                ListIterator<RestNameValuePair> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    RestNameValuePair next = listIterator.next();
                    if (next != null && "source_flag".equals(next.getName())) {
                        listIterator.remove();
                    }
                }
            }
            String str = "0";
            String str2 = WalletFingerprint.getInstance(this.c).isDevicesSupport() ? "1" : str;
            if (WalletFingerprint.getInstance(this.c).hasEnrollFingerprint()) {
                str = "1";
            }
            list.add(new RestNameValuePair("device_support", str2));
            list.add(new RestNameValuePair("enroll_fingerprint", str));
            list.add(new RestNameValuePair("verify_type", "2"));
            list.add(new RestNameValuePair("source_flag", "3"));
            list.add(new RestNameValuePair("is_new_version", "1"));
            return list;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_CARD_ADD;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_CARD_ADD;
    }

    public void handleSession(BeanResponseBase.Session session) {
        NewBindCardEntry.getInstance().setSession(session);
        BindFastRequest bindFastRequest = this.b;
        if (bindFastRequest != null) {
            bindFastRequest.saveSession(session);
        } else {
            NetworkBean.SessionCache.getInstance().put((NetworkBean.BizType) null, session);
        }
    }

    public void a(BindFastRequest bindFastRequest) {
        this.b = bindFastRequest;
    }

    public BindFastRequest a() {
        return this.b;
    }
}
