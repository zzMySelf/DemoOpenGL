package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.ApollonBean;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestResponseEntity;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.restnet.converter.StringHttpMessageConverter;
import com.dxmpay.apollon.restnet.http.HttpStatus;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.VerSig;
import com.dxmpay.wallet.statistics.NetStepStatManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class OtherBean<T> extends NetworkBean<T> {
    public int mRetCode = -1;
    public String mRetMsg = "";

    public OtherBean(Context context) {
        super(context);
    }

    public void addOnEventWithValues(int i2, String str, @Nullable HttpStatus httpStatus) {
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
            LogUtil.e(com.baidu.wallet.core.beans.OtherBean.a, e.getMessage(), e);
        }
    }

    public <T, E> void execBean(Class<T> cls, Class<E> cls2) {
        this.mStartTime = System.currentTimeMillis();
        super.execBean(cls, cls2);
    }

    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> restResponseEntity;
        long currentTimeMillis = System.currentTimeMillis();
        List<RestNameValuePair> requestParams = getRequestParams();
        NetStepStatManager.getInstance().recordBuildParamsCost(Uri.parse(getUrl()).getPath(), this.mStartTime, System.currentTimeMillis() - currentTimeMillis);
        if (getHttpMethod() == 0) {
            restResponseEntity = this.mRestTemplate.getForEntity(getUrl(), requestParams, getEncode(), cls);
        } else {
            restResponseEntity = getHttpMethod() == 1 ? this.mRestTemplate.postForEntity(getUrl(), requestParams, getEncode(), cls) : null;
        }
        if (restResponseEntity != null && this.mRspCallback != null) {
            handleResponseHeaders(restResponseEntity);
            T body = restResponseEntity.getBody();
            HttpStatus statusCode = restResponseEntity.getStatusCode();
            if (body == null) {
                addOnEventWithValues(-103, "Callback not null,rsp.getBody() is null", statusCode);
                this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                return;
            }
            if (body instanceof String) {
                try {
                    BeanResponseBase beanResponseBase = (BeanResponseBase) JsonUtils.fromJson((String) body, BeanResponseBase.class);
                    if (beanResponseBase != null) {
                        this.mRetCode = beanResponseBase.ret;
                        this.mRetMsg = beanResponseBase.msg;
                    } else {
                        this.mRetCode = -4;
                        this.mRetMsg = "无效的response";
                    }
                    addOnEventWithValues(this.mRetCode, this.mRetMsg, statusCode);
                    if (beanResponseBase != null && beanResponseBase.ret == 0 && (beanResponseBase.needVerifySignature() || needVerifySignature())) {
                        String string = new JSONObject(restResponseEntity.getResponseString()).getString(beanResponseBase.getNameOfRealResponseContent());
                        if (!VerSig.verify(beanResponseBase.signature, string, beanResponseBase.mdAlgorithm)) {
                            if (!TextUtils.isEmpty(getUrl())) {
                                StatisticManager.onEvent("#verify_sign_failed");
                            }
                            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                            return;
                        } else if (beanResponseBase.needDecryption()) {
                            org.json.JSONObject jSONObject = new org.json.JSONObject((String) body);
                            if (!TextUtils.isEmpty(string)) {
                                jSONObject.put(beanResponseBase.getNameOfRealResponseContent(), SecurePay.getInstance().decryptProxy(string));
                            }
                            body = jSONObject.toString();
                        }
                    }
                } catch (JSONException e) {
                    LogUtil.e(com.baidu.wallet.core.beans.OtherBean.a, e.getMessage(), e);
                } catch (org.json.JSONException e2) {
                    LogUtil.e(com.baidu.wallet.core.beans.OtherBean.a, e2.getMessage(), e2);
                }
            }
            this.mRspCallback.onBeanExecSuccess(getBeanId(), body, (String) null);
        } else if (this.mRspCallback != null) {
            if (restResponseEntity == null) {
                addOnEventWithValues(-100, "Callback not null,Response is null", (HttpStatus) null);
            }
            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
        } else if (restResponseEntity == null) {
            addOnEventWithValues(-101, "Callback is null,Response is null", (HttpStatus) null);
        } else {
            addOnEventWithValues(-102, "Callback is null,Response not null", restResponseEntity.getStatusCode());
        }
    }

    public void handleCommonErrors(Exception exc) {
        super.handleCommonErrors(exc);
    }

    public void handleNetworkFailureError() {
        addOnEventWithValues(-8, ResUtils.getString(this.mContext, "dxm_ebpay_no_network"), HttpStatus.CLIENT_NO_NETWORK);
        super.handleNetworkFailureError();
    }

    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        HttpStatus httpStatus;
        if (restResponseEntity == null || restResponseEntity.getBody() == null) {
            if (restResponseEntity == null) {
                httpStatus = null;
            } else {
                httpStatus = restResponseEntity.getStatusCode();
            }
            addOnEventWithValues(-104, "Response is error", httpStatus);
            return;
        }
        addOnEventWithValues(((BeanResponseBase) restResponseEntity.getBody()).ret, ((BeanResponseBase) restResponseEntity.getBody()).msg, restResponseEntity.getStatusCode());
    }

    public void prepareRestTemplate() {
        Context context = this.mContext;
        this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EbpayHttpRequestInterceptor());
        if (2 != this.beanType) {
            arrayList.add(new LoginStatusHttpRequestInterceptor());
        }
        this.mRestTemplate.setRequestInterceptor(arrayList);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        this.mRestTemplate.setMessageConverter(stringHttpMessageConverter);
        addSMReqeustInterceptor(arrayList);
        stringHttpMessageConverter.de(this.smManagerDelegate);
        this.mRestTemplate.setStartTime(this.mStartTime);
    }

    public OtherBean(Context context, int i2) {
        super(context, i2);
    }
}
