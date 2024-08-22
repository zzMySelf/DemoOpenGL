package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.apollon.heartbeat.a;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.ApollonBean;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestResponseEntity;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.NetworkUtils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.StatusCode;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.OSUtils;
import com.dxmpay.wallet.core.utils.SecurityUtils;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
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
    public static final int COMET_BEAN = 1;
    public static final String KEY_SDK_SM_URI_SMALLFLOW = "sdk_sm_uri_smallflow";
    public static final int NOLOGIN_STATUS_BEAN = 2;
    public static final String PARAM_CUID = "cuid_1";
    public static final String PARAM_CUID_2 = "cuid_2";
    public static final String PARAM_REAL_OS = "real_os";
    public static final String PARAM_UA = "ua";
    public int beanType = -1;
    public SMManagerDelegate smManagerDelegate = new SMManagerDelegate();

    public enum BizType {
        BackwardComp,
        BindCard,
        Pwd
    }

    public static class SessionCache implements Serializable {
        public HashMap<Integer, BeanResponseBase.Session> mCache;

        public static class qw {
            public static final SessionCache qw = new SessionCache();
        }

        public static SessionCache getInstance() {
            return qw.qw;
        }

        public static synchronized void sync(SessionCache sessionCache) {
            synchronized (SessionCache.class) {
                if (sessionCache != null) {
                    qw.qw.mCache = sessionCache.mCache;
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

    private List<RestNameValuePair> a(Context context, List<RestNameValuePair> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (getAuthLevel() > 0 && !isLbsPayBean()) {
            b(context, list);
        }
        if (!a(list, "session_id") && SessionCache.getInstance().matchSessionUri(getUrl()) && !TextUtils.isEmpty(SessionCache.getInstance().getSessionId((BizType) null))) {
            list.add(new RestNameValuePair("session_id", SessionCache.getInstance().getSessionId((BizType) null)));
        }
        if (needNonce()) {
            list.add(new RestNameValuePair("nonce", PayUtils.getNonce(list)));
        }
        return list;
    }

    private void b(Context context, List<RestNameValuePair> list) {
        list.add(new RestNameValuePair(PARAM_REAL_OS, OSUtils.getOSName(context)));
        list.add(new RestNameValuePair("from", "JT"));
        if (BeanConstants.ENCODE_GB_18030.equals(getEncode())) {
            list.add(new RestNameValuePair("_ie", BeanConstants.ENCODE_GB_18030));
            list.add(new RestNameValuePair("ie", BeanConstants.ENCODE_GB_18030));
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
            StringBuilder sb = new StringBuilder();
            sb.append("NetworkType:");
            sb.append(NetworkUtils.getNetworkType(context));
            sb.toString();
            jSONObject.put("nettype", NetworkUtils.getNetworkType(context));
            String dxmOaid = PayUtils.getDxmOaid();
            if (TextUtils.isEmpty(dxmOaid)) {
                jSONObject.put("oaid", "");
            } else {
                jSONObject.put("oaid", PayUtils.encrypt("phone_number", dxmOaid));
            }
            String str = "true";
            jSONObject.put("appIn_virtual_machine", PayUtils.encrypt("phone_number", SecurityUtils.isSimulator(context) ? str : "false"));
            if (!SecurityUtils.isRoot()) {
                str = "false";
            }
            jSONObject.put("wibk", PayUtils.encrypt("phone_number", str));
        } catch (JSONException e) {
            LogUtil.e(com.baidu.wallet.core.beans.NetworkBean.TAG, e.getMessage(), e);
        }
        list.add(new RestNameValuePair("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes()))));
        String str2 = SecurePay.getInstance().getpwProxy();
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
            list.add(new RestNameValuePair("key", str2));
        }
        if (isSign()) {
            list.add(new RestNameValuePair("sign", PayUtils.genAPIsig(list)));
        }
        if (2 != this.beanType) {
            String cookie = PayUtils.getCookie(context);
            "appendCertification(" + context + "|" + cookie + ")";
            if (!TextUtils.isEmpty(cookie)) {
                list.add(new RestNameValuePair(com.baidu.wallet.core.beans.NetworkBean.PARAM_COOKIE, SecurePay.getInstance().encryptProxy(cookie)));
            } else {
                list.add(new RestNameValuePair(com.baidu.wallet.core.beans.NetworkBean.PARAM_COOKIE, ""));
            }
            String newCookie = PayUtils.getNewCookie(context);
            if (!TextUtils.isEmpty(newCookie)) {
                list.add(new RestNameValuePair("natbc", SecurePay.getInstance().encryptProxy(newCookie)));
            } else {
                list.add(new RestNameValuePair("natbc", ""));
            }
            SMManagerDelegate sMManagerDelegate = this.smManagerDelegate;
            if (sMManagerDelegate != null && sMManagerDelegate.isOpenSMCipher(getUrl())) {
                list.add(new RestNameValuePair(KEY_SDK_SM_URI_SMALLFLOW, "1"));
            }
        }
    }

    public void addSMReqeustInterceptor(List<RestHttpRequestInterceptor> list) {
        SMManagerDelegate sMManagerDelegate = this.smManagerDelegate;
        if (sMManagerDelegate != null && sMManagerDelegate.isOpenSMCipher(getUrl())) {
            list.add(new fe.i.ad.ad.qw.qw(this.smManagerDelegate));
        }
    }

    public abstract List<RestNameValuePair> generateRequestParam();

    public List<RestNameValuePair> getRequestParams() {
        return a(this.mContext, generateRequestParam());
    }

    public void handleCommonErrors(Exception exc) {
        "execBean. exception = " + exc;
        if (exc instanceof RestRuntimeException) {
            if (this.mRspCallback != null) {
                RestRuntimeException restRuntimeException = (RestRuntimeException) exc;
                if (restRuntimeException.contains(SocketTimeoutException.class)) {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -15, ResUtils.getString(this.mContext, "dxm_ebpay_no_network"));
                } else if (restRuntimeException.contains(SSLPeerUnverifiedException.class) || restRuntimeException.contains(CertificateException.class)) {
                    if (exc.getMessage().contains("Pin verification failed")) {
                        String[] strArr = new String[2];
                        strArr[0] = getUrl();
                        strArr[1] = exc.getCause() == null ? exc.getMessage() : exc.getCause().toString();
                        StatisticManager.onEventWithValues("#ssl_pinning_error", Arrays.asList(strArr));
                    } else {
                        StatisticManager.onEvent("#ssl_certificate_error");
                    }
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -16, ResUtils.getString(this.mContext, "dxm_ebpay_ssl"));
                } else if (restRuntimeException.contains(IllegalArgumentException.class)) {
                    IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
                    if (iBeanResponseCallback != null) {
                        iBeanResponseCallback.onBeanExecFailure(getBeanId(), -2, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                    }
                } else {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -15, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                }
            }
        } else if (exc instanceof IllegalArgumentException) {
            IBeanResponseCallback iBeanResponseCallback2 = this.mRspCallback;
            if (iBeanResponseCallback2 != null) {
                iBeanResponseCallback2.onBeanExecFailure(getBeanId(), -2, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
            }
        } else {
            IBeanResponseCallback iBeanResponseCallback3 = this.mRspCallback;
            if (iBeanResponseCallback3 != null) {
                iBeanResponseCallback3.onBeanExecFailure(getBeanId(), StatusCode.REQUEST_LOCAL_UNKNOWN_ERROR, ResUtils.getString(this.mContext, "dxm_ebpay_request_unknown_error"));
            }
        }
    }

    public void handleNetworkFailureError() {
        IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
        if (iBeanResponseCallback != null) {
            iBeanResponseCallback.onBeanExecFailure(getBeanId(), -8, ResUtils.getString(this.mContext, "dxm_ebpay_no_network"));
        }
    }

    public <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity) {
        String firstHeaderValue = restResponseEntity.getFirstHeaderValue("token");
        if (!TextUtils.isEmpty(firstHeaderValue)) {
            AccountManager.getInstance(this.mContext).setBfbToken(firstHeaderValue);
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
                    LogUtil.e(com.baidu.wallet.core.beans.NetworkBean.TAG, e.getMessage(), e);
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

    public NetworkBean(Context context, int i2) {
        super(context);
        this.beanType = i2;
    }

    private boolean a(List<RestNameValuePair> list, String str) {
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
}
