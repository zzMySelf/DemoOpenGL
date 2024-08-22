package com.baidu.wallet.core.beans;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.ApollonBean;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.heartbeat.a;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.utils.BdWalletUtils;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class NetworkBean<T> extends ApollonBean<T> {
    public static final boolean DEBUG = false;
    public static final String PARAM_API_SIG = "sign";
    public static final String PARAM_COOKIE = "atbc";
    public static final String PARAM_CUID = "cuid_1";
    public static final String PARAM_CUID_2 = "cuid_2";
    public static final String PARAM_FKWCP = "fk_wcp";
    public static final String PARAM_FROM = "from";
    public static final String PARAM_IE = "_ie";
    public static final String PARAM_IMEI_NEW = "wime";
    public static final String PARAM_NETTYPE = "nettype";
    public static final String PARAM_NEW_COOKIE = "natbc";
    public static final String PARAM_UA = "ua";
    public static final String TAG = "NetworkBean";
    public Boolean[] tag = {Boolean.FALSE};

    public enum BizType {
        BackwardComp,
        BindCard,
        Pwd
    }

    public static class SessionCache implements Serializable {
        public HashMap<Integer, BeanResponseBase.Session> mCache;

        public static class a {
            public static final SessionCache a = new SessionCache();
        }

        public static SessionCache getInstance() {
            return a.a;
        }

        public static synchronized void sync(SessionCache sessionCache) {
            synchronized (SessionCache.class) {
                if (sessionCache != null) {
                    a.a.mCache = sessionCache.mCache;
                }
            }
        }

        public String getSessionId(BizType bizType) {
            if (bizType == null) {
                bizType = BizType.BackwardComp;
            }
            BeanResponseBase.Session session = this.mCache.get(Integer.valueOf(bizType.ordinal()));
            if (session == null) {
                return null;
            }
            return session.session_id;
        }

        public boolean matchSessionUri(String str) {
            String[] strArr;
            if (str == null) {
                return false;
            }
            BeanResponseBase.Session session = this.mCache.get(Integer.valueOf(BizType.BackwardComp.ordinal()));
            if (session == null) {
                strArr = null;
            } else {
                strArr = session.session_uri;
            }
            if (strArr == null) {
                return false;
            }
            for (String contains : strArr) {
                if (str.contains(contains)) {
                    return true;
                }
            }
            return false;
        }

        public void put(BizType bizType, BeanResponseBase.Session session) {
            if (session == null) {
                this.mCache.remove(Integer.valueOf(BizType.BackwardComp.ordinal()));
            } else if (BizType.BackwardComp.ordinal() != session.biz_code) {
                this.mCache.put(Integer.valueOf(bizType == null ? 0 : bizType.ordinal()), session);
            } else if ("1".equals(session.delete_flag)) {
                this.mCache.remove(Integer.valueOf(BizType.BackwardComp.ordinal()));
            } else {
                this.mCache.put(Integer.valueOf(BizType.BackwardComp.ordinal()), session);
            }
        }

        public SessionCache() {
            this.mCache = new HashMap<>();
        }
    }

    public NetworkBean(Context context) {
        super(context);
    }

    private void appendCertification(Context context, List<RestNameValuePair> list) {
        list.add(new RestNameValuePair("from", "JT"));
        if ("gbk".equals(getEncode())) {
            list.add(new RestNameValuePair("_ie", "gbk"));
            list.add(new RestNameValuePair("ie", "gbk"));
        } else {
            list.add(new RestNameValuePair("_ie", a.h));
            list.add(new RestNameValuePair("ie", a.h));
        }
        list.add(new RestNameValuePair("ua", BussinessUtils.getUA(context)));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wime", "");
            jSONObject.put("cuid_1", PayUtils.encrypt("phone_number", PhoneUtils.getCUID(context)));
            jSONObject.put("cuid_2", PayUtils.encrypt("phone_number", PhoneUtils.getCUID2(context)));
            jSONObject.put("fk_wcp", PayUtils.encrypt("phone_number", (((("fp=" + BdWalletUtils.getDeviceFP(this.mContext)) + "&lastModify=" + BdWalletUtils.getFPFileLastModified(this.mContext)) + "&cpuInfo=" + PhoneUtils.getSystemCPUInfo().getCpuPath() + "_" + PhoneUtils.getNumCores()) + "&diskCapacity=" + PhoneUtils.getTotalInternalMemorySize()) + "&upTime=" + (SystemClock.elapsedRealtime() / 1000)));
            jSONObject.put("nettype", NetworkUtils.getNetworkType(context));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        list.add(new RestNameValuePair("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes()))));
        String str = SafePay.getInstance().getpwProxy();
        boolean z = false;
        Iterator<RestNameValuePair> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if ("key".equals(it.next().getName())) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            list.add(new RestNameValuePair("key", str));
        }
        String newCookie = PayUtils.getNewCookie(context);
        if (!TextUtils.isEmpty(newCookie)) {
            list.add(new RestNameValuePair("natbc", SafePay.getInstance().encryptProxy(newCookie)));
        } else {
            list.add(new RestNameValuePair("natbc", ""));
        }
        if (isSign()) {
            list.add(new RestNameValuePair("sign", PayUtils.genAPIsig(list)));
        }
    }

    private List<RestNameValuePair> appendUriParameter(Context context, List<RestNameValuePair> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (getAuthLevel() > 0 && !isLbsPayBean()) {
            appendCertification(context, list);
        }
        if (!containsKey(list, "session_id") && SessionCache.getInstance().matchSessionUri(getUrl()) && !TextUtils.isEmpty(SessionCache.getInstance().getSessionId((BizType) null))) {
            list.add(new RestNameValuePair("session_id", SessionCache.getInstance().getSessionId((BizType) null)));
        }
        if (needNonce()) {
            list.add(new RestNameValuePair("nonce", PayUtils.getNonce(list)));
        }
        return list;
    }

    private boolean containsKey(List<RestNameValuePair> list, String str) {
        if (list == null) {
            return false;
        }
        for (RestNameValuePair name : list) {
            if (str.equals(name.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkSignSame(String str) {
        return false;
    }

    public <T> void execBean(Class<T> cls) throws RuntimeException {
        getUrl();
        if (!this.tag[0].booleanValue()) {
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.UNSUPPORT_DOMAIN_EXCHANGE, Arrays.asList(new String[]{getUrl()}));
        }
        super.execBean(cls);
    }

    public abstract List<RestNameValuePair> generateRequestParam();

    public List<RestNameValuePair> getRequestParams() {
        return appendUriParameter(this.mContext, generateRequestParam());
    }

    public void handleCommonErrors(Exception exc) {
        LogUtil.d(TAG, "execBean. exception = " + exc);
        if (exc instanceof RestRuntimeException) {
            if (this.mRspCallback != null) {
                RestRuntimeException restRuntimeException = (RestRuntimeException) exc;
                if (restRuntimeException.contains(SocketTimeoutException.class)) {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -15, ResUtils.getString(this.mContext, "ebpay_no_network"));
                } else if (restRuntimeException.contains(SSLPeerUnverifiedException.class) || restRuntimeException.contains(CertificateException.class)) {
                    if (exc.getMessage().contains("Pin verification failed")) {
                        String[] strArr = new String[2];
                        strArr[0] = getUrl();
                        strArr[1] = exc.getCause() == null ? exc.getMessage() : exc.getCause().toString();
                        DXMSdkSAUtils.onEventWithValues("#ssl_pinning_error", Arrays.asList(strArr));
                    } else {
                        DXMSdkSAUtils.onEvent("#ssl_certificate_error");
                    }
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -16, ResUtils.getString(this.mContext, "ebpay_ssl"));
                } else if (restRuntimeException.contains(IllegalArgumentException.class)) {
                    IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
                    if (iBeanResponseCallback != null) {
                        iBeanResponseCallback.onBeanExecFailure(getBeanId(), -2, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                    }
                } else {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -15, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                }
            }
        } else if (exc instanceof IllegalArgumentException) {
            IBeanResponseCallback iBeanResponseCallback2 = this.mRspCallback;
            if (iBeanResponseCallback2 != null) {
                iBeanResponseCallback2.onBeanExecFailure(getBeanId(), -2, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
            }
        } else {
            exc.printStackTrace();
        }
    }

    public void handleNetworkFailureError() {
        IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
        if (iBeanResponseCallback != null) {
            iBeanResponseCallback.onBeanExecFailure(getBeanId(), -8, ResUtils.getString(this.mContext, "ebpay_no_network"));
        }
    }

    public <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity) {
        String a = restResponseEntity.a("token");
        if (!TextUtils.isEmpty(a)) {
            AccountManager.getInstance(this.mContext).setBfbToken(a);
        }
        List<String> headerValue = restResponseEntity.getHeaderValue("Set-Cookie");
        if (headerValue != null) {
            for (int i2 = 0; i2 < headerValue.size(); i2++) {
                String str = headerValue.get(i2);
                try {
                    String[] split = str.substring(0, str.indexOf(i.b)).split("=");
                    if (split.length > 0 && "token".equals(split[0]) && !TextUtils.isEmpty(split[1]) && TextUtils.isEmpty(AccountManager.getInstance(this.mContext).getBfbToken())) {
                        AccountManager.getInstance(this.mContext).setBfbToken(split[1]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isLbsPayBean() {
        return false;
    }

    public boolean isSign() {
        return false;
    }

    public abstract boolean needNonce();

    public boolean needVerifySignature() {
        return false;
    }
}
