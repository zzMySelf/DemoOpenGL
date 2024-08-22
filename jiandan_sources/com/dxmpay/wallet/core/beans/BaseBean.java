package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.ApollonBean;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.restnet.RestResponseEntity;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.restnet.converter.GsonHttpMessageConverter;
import com.dxmpay.apollon.restnet.http.HttpStatus;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.VerSig;
import com.dxmpay.wallet.statistics.NetStepStatManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public abstract class BaseBean<T> extends NetworkBean<T> {
    public String a;

    public BaseBean(Context context) {
        super(context);
    }

    private <T> T a(String str, Class<T> cls) {
        try {
            return JsonUtils.fromJson(str, cls);
        } catch (JSONException e) {
            a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_JSON_ERROR, e.getMessage());
            LogUtil.e(com.baidu.wallet.core.beans.BaseBean.TAG, e.getMessage(), e);
            return null;
        }
    }

    public <T, E> void execBean(Class<T> cls, Class<E> cls2) {
        this.mStartTime = System.currentTimeMillis();
        super.execBean(cls, cls2);
    }

    public String getHttpRealContent() {
        return this.a;
    }

    public void handleCommonErrors(Exception exc) {
        super.handleCommonErrors(exc);
    }

    public void handleNetworkFailureError() {
        a(-8, ResUtils.getString(this.mContext, "dxm_ebpay_no_network"), HttpStatus.CLIENT_NO_NETWORK);
        super.handleNetworkFailureError();
    }

    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        String str;
        if (restResponseEntity != null && this.mRspCallback != null) {
            handleResponseHeaders(restResponseEntity);
            BeanResponseBase beanResponseBase = (BeanResponseBase) restResponseEntity.getBody();
            HttpStatus statusCode = restResponseEntity.getStatusCode();
            if (beanResponseBase != null) {
                a(beanResponseBase.ret, beanResponseBase.msg, statusCode);
                handleSession(beanResponseBase.cashdesk);
                int serverReturnValue = beanResponseBase.getServerReturnValue(cls);
                if (serverReturnValue != 0) {
                    if (serverReturnValue == 5003) {
                        String url = getUrl();
                        if (!TextUtils.isEmpty(url)) {
                            StatisticManager.onEventWithValue("#invalidLoginStatus", url);
                        }
                    }
                    String realResponseErrContent = beanResponseBase.getRealResponseErrContent();
                    this.a = realResponseErrContent;
                    if (TextUtils.isEmpty(realResponseErrContent) || cls2 == null) {
                        this.mRspCallback.onBeanExecFailure(getBeanId(), serverReturnValue, beanResponseBase.getRealResponseMsg());
                        return;
                    }
                    EventBus instance = EventBus.getInstance();
                    instance.getClass();
                    instance.postStickyEvent(new EventBus.Event("ev_bean_execut_err_content", new BeanErrorContent(getBeanId(), serverReturnValue, beanResponseBase.getRealResponseMsg(), a(beanResponseBase.getRealResponseErrContent(), cls2))));
                    return;
                }
                String token = beanResponseBase.getToken();
                if (!TextUtils.isEmpty(token)) {
                    AccountManager.getInstance(this.mContext).setBfbToken(token);
                }
                "execBean. ret       . rsp class = " + cls;
                this.a = beanResponseBase.getRealResponseContent();
                try {
                    str = new JSONObject(restResponseEntity.getResponseString()).getString(beanResponseBase.getNameOfRealResponseContent());
                    if ((needVerifySignature() || beanResponseBase.needVerifySignature()) && !VerSig.verify(beanResponseBase.signature, str, beanResponseBase.mdAlgorithm)) {
                        String url2 = getUrl();
                        if (!TextUtils.isEmpty(url2)) {
                            StatisticManager.onEvent("#verify_sign_failed", url2);
                        }
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                        return;
                    }
                } catch (com.dxmpay.wallet.core.lollipop.json.JSONException e) {
                    a(-106, e.getMessage());
                    LogUtil.e(com.baidu.wallet.core.beans.BaseBean.TAG, e.getMessage(), e);
                    str = "";
                }
                if (beanResponseBase.needDecryption() && !TextUtils.isEmpty(str)) {
                    this.a = SecurePay.getInstance().decryptProxy(str);
                }
                if (cls == null) {
                    a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_HIT_RISK_MANAGEMENT, "rspClass is null");
                    this.mRspCallback.onBeanExecSuccess(getBeanId(), (Object) null, beanResponseBase.getRealResponseMsg());
                } else if (JsonUtils.DataType.isString(cls)) {
                    this.mRspCallback.onBeanExecSuccess(getBeanId(), (Object) null, this.a);
                } else {
                    T a2 = a(this.a, cls);
                    "execBean. ret ok. real response = " + a2;
                    if (a2 != null) {
                        IBeanResponse iBeanResponse = (IBeanResponse) a2;
                        if (iBeanResponse.checkResponseValidity()) {
                            iBeanResponse.storeResponse(this.mContext);
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), a2, beanResponseBase.getRealResponseMsg());
                            return;
                        }
                        a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_ANDROID_VERSION_BELOW_KITKAT, "checkResponseValidity fail");
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                        return;
                    }
                    a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IS_LOGIN_WHEN_SECOND_PRE_PHONE, "realRsp is null");
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                }
            } else {
                a(-103, "Callback not null,rsp.getBody() is null", statusCode);
                this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
            }
        } else if (this.mRspCallback != null) {
            if (restResponseEntity == null) {
                a(-100, "Callback not null,Response is null", (HttpStatus) null);
            }
            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
        } else if (restResponseEntity == null) {
            a(-101, "Callback is null,Response is null", (HttpStatus) null);
        } else {
            a(-102, "Callback is null,Response not null", restResponseEntity.getStatusCode());
        }
    }

    public void handleSession(BeanResponseBase.Session session) {
        BdWalletUtils.dealCashDesk(session);
    }

    public boolean needNonce() {
        return false;
    }

    public void prepareRestTemplate() {
        Object obj;
        Context context = this.mContext;
        this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
        ArrayList arrayList = new ArrayList();
        if (this.beanType == 1) {
            obj = new CometHttpRequestInterceptor();
        } else {
            obj = new EbpayHttpRequestInterceptor();
        }
        arrayList.add(obj);
        if (2 != this.beanType) {
            arrayList.add(new LoginStatusHttpRequestInterceptor());
        }
        this.mRestTemplate.setRequestInterceptor(arrayList);
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        this.mRestTemplate.setMessageConverter(gsonHttpMessageConverter);
        addSMReqeustInterceptor(arrayList);
        gsonHttpMessageConverter.de(this.smManagerDelegate);
        this.mRestTemplate.setStartTime(this.mStartTime);
    }

    public void setBeanParams(String... strArr) {
    }

    public BaseBean(Context context, int i2) {
        super(context, i2);
    }

    private void a(int i2, String str, @Nullable HttpStatus httpStatus) {
        Object obj;
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        try {
            URL url = new URL(getUrl());
            ArrayList arrayList = new ArrayList();
            String path = url.getPath();
            arrayList.add(path);
            arrayList.add(i2 + "");
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(currentTimeMillis));
            hashMap.put("errmsg", str);
            if (!TextUtils.isEmpty(StatHelper.getOrderNo())) {
                hashMap.put("order_no", StatHelper.getOrderNo());
            }
            if (!TextUtils.isEmpty(StatHelper.getSpNo())) {
                hashMap.put(StatHelper.SP_NO, StatHelper.getSpNo());
            }
            hashMap.put(StatHelper.REQ_URI, path);
            hashMap.put("errorCode", i2 + "");
            hashMap.put("errorMsg", str);
            hashMap.put(StatHelper.CURRENT_DOMAIN, url.getHost());
            if (httpStatus == null) {
                obj = "200";
            } else {
                obj = Integer.valueOf(httpStatus.value());
            }
            hashMap.put("value12", obj);
            NetStepStatManager.getInstance().statist(Uri.parse(getUrl()).getPath(), this.mStartTime, currentTimeMillis, arrayList);
            StatisticManager.onEventWithValues(ApollonBean.EVENT_CALL_INTERFACE, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
        } catch (MalformedURLException e) {
            LogUtil.e(com.baidu.wallet.core.beans.BaseBean.TAG, e.getMessage(), e);
        }
    }

    private void a(int i2, String str) {
        try {
            URL url = new URL(getUrl());
            ArrayList arrayList = new ArrayList();
            arrayList.add(url.getPath());
            arrayList.add(i2 + "");
            HashMap hashMap = new HashMap();
            hashMap.put("errmsg", str);
            if (!TextUtils.isEmpty(StatHelper.getOrderNo())) {
                hashMap.put("order_no", StatHelper.getOrderNo());
            }
            if (!TextUtils.isEmpty(StatHelper.getSpNo())) {
                hashMap.put(StatHelper.SP_NO, StatHelper.getSpNo());
            }
            StatisticManager.onEventWithValues(StatServiceEvent.ANALYTIC_INTERFACE, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
        } catch (MalformedURLException e) {
            LogUtil.e(com.baidu.wallet.core.beans.BaseBean.TAG, e.getMessage(), e);
        }
    }
}
