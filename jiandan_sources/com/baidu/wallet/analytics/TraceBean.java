package com.baidu.wallet.analytics;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.alipay.sdk.m.u.i;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.converter.b;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;

public class TraceBean extends BaseBean {
    public static final String DEFAULT_URL = "/tongji/performance/stat.jpg";
    public static final String TAG = "TraceBean";
    public static String sCUID = "";
    public static String sCUID2 = "";
    public static String sUnionId = "";
    public String mBaseUrl;
    public List<RestNameValuePair> mPostParams;
    public List<RestNameValuePair> mQueryParams;

    public class CustomInterceptors implements RestHttpRequestInterceptor {
        public CustomInterceptors() {
        }

        public void intercept(Context context, d dVar) {
            String str;
            if (!TextUtils.isEmpty(TraceBean.sUnionId)) {
                dVar.a().b("Cookie", "unionId=" + TraceBean.sUnionId);
            }
            dVar.a().b("Cookie", "cuid_1=" + TraceBean.sCUID);
            dVar.a().b("Cookie", "cuid_2=" + TraceBean.sCUID2);
            List<String> a = dVar.a().get((Object) "Cookie");
            String str2 = "";
            for (int i2 = 0; i2 < a.size(); i2++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                if (a.get(i2).endsWith(i.b)) {
                    str = "";
                } else {
                    str = i.b + a.get(i2);
                }
                sb.append(str);
                str2 = sb.toString();
            }
            dVar.a().a("Cookie", str2.substring(1));
        }
    }

    public TraceBean(Context context) {
        super(context);
        if (TextUtils.isEmpty(sCUID)) {
            sCUID = PhoneUtils.getCUID(context);
        }
        if (TextUtils.isEmpty(sCUID2)) {
            sCUID2 = PhoneUtils.getCUID2(context);
        }
        if (WalletLoginHelper.getInstance().isLogin()) {
            sUnionId = WalletLoginHelper.getInstance().getUnionId();
        }
    }

    public TraceBean buildBaseUrl(String str) {
        this.mBaseUrl = str;
        if (!TextUtils.isEmpty(str)) {
            this.tag[0] = Boolean.TRUE;
        }
        return this;
    }

    public TraceBean buildParams(List<RestNameValuePair> list, String str) {
        if (ShareTarget.METHOD_GET.equalsIgnoreCase(str)) {
            buildQueryParams(list);
        } else {
            buildPostParams(list);
        }
        return this;
    }

    public TraceBean buildPostParams(List<RestNameValuePair> list) {
        if (this.mPostParams == null) {
            this.mPostParams = new ArrayList();
        }
        this.mPostParams.addAll(list);
        return this;
    }

    public TraceBean buildQueryParams(List<RestNameValuePair> list) {
        if (this.mQueryParams == null) {
            this.mQueryParams = new ArrayList();
        }
        this.mQueryParams.addAll(list);
        return this;
    }

    public void execBean() {
        super.execBean((Class) null);
    }

    public List<RestNameValuePair> generateRequestParam() {
        return this.mPostParams;
    }

    public int getBeanId() {
        return 0;
    }

    public int getHttpMethod() {
        List<RestNameValuePair> list = this.mPostParams;
        return (list == null || list.size() <= 0) ? 0 : 1;
    }

    public String getUrl() {
        String str;
        if (TextUtils.isEmpty(this.mBaseUrl)) {
            str = DomainConfig.getInstance().getHawkinghost(this.tag) + DEFAULT_URL;
        } else {
            str = this.mBaseUrl;
        }
        if (this.mQueryParams != null) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (int i2 = 0; i2 < this.mQueryParams.size(); i2++) {
                buildUpon.appendQueryParameter(this.mQueryParams.get(i2).getName(), this.mQueryParams.get(i2).getValue());
            }
            String uri = buildUpon.build().toString();
            LogUtil.i(TAG, "TraceBean getUrl：" + uri);
            return uri;
        }
        LogUtil.i(TAG, "TraceBean getUrl：" + str);
        return str;
    }

    public void prepareRestTemplate() {
        super.prepareRestTemplate();
        this.mRestTemplate.a().add(new CustomInterceptors());
        this.mRestTemplate.setMessageConverter(new b());
    }
}
