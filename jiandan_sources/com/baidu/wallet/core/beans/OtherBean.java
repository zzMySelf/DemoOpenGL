package com.baidu.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.converter.b;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.lollipop.json.JSONException;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.VerSig;
import java.util.ArrayList;

public abstract class OtherBean<T> extends NetworkBean<T> {
    public static final String a = "OtherBaseBean";
    public int mRetCode = -1;
    public String mRetMsg;

    public OtherBean(Context context) {
        super(context);
    }

    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> restResponseEntity;
        if (getHttpMethod() == 0) {
            restResponseEntity = this.mRestTemplate.b(getUrl(), getRequestParams(), getEncode(), cls);
        } else {
            restResponseEntity = getHttpMethod() == 1 ? this.mRestTemplate.d(getUrl(), getRequestParams(), getEncode(), cls) : null;
        }
        if (restResponseEntity == null || this.mRspCallback == null) {
            IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
            if (iBeanResponseCallback != null) {
                iBeanResponseCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                return;
            }
            return;
        }
        T body = restResponseEntity.getBody();
        if (body == null) {
            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
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
                    this.mRetMsg = "-4";
                }
                if (beanResponseBase != null && beanResponseBase.ret == 0 && (beanResponseBase.needVerifySignature() || needVerifySignature())) {
                    String string = new JSONObject(restResponseEntity.b()).getString(beanResponseBase.getNameOfRealResponseContent());
                    if (!VerSig.verify(beanResponseBase.signature, string, beanResponseBase.mdAlgorithm)) {
                        DXMSdkSAUtils.onEvent("#verify_sign_failed");
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                        return;
                    } else if (beanResponseBase.needDecryption()) {
                        org.json.JSONObject jSONObject = new org.json.JSONObject((String) body);
                        if (!TextUtils.isEmpty(string)) {
                            jSONObject.put(beanResponseBase.getNameOfRealResponseContent(), SafePay.getInstance().decryptProxy(string));
                        }
                        body = jSONObject.toString();
                    }
                }
            } catch (JSONException e) {
                LogUtil.e(a, e.getMessage(), e);
            } catch (org.json.JSONException e2) {
                LogUtil.e(a, e2.getMessage(), e2);
            }
        }
        this.mRspCallback.onBeanExecSuccess(getBeanId(), body, (String) null);
    }

    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
    }

    public void prepareRestTemplate() {
        Context context = this.mContext;
        this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EbpayHttpRequestInterceptor());
        arrayList.add(new a(this.tag[0].booleanValue()));
        this.mRestTemplate.setRequestInterceptor(arrayList);
        this.mRestTemplate.setMessageConverter(new b());
    }
}
