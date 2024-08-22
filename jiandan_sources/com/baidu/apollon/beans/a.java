package com.baidu.apollon.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.converter.GsonHttpMessageConverter;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.ResUtils;
import java.util.ArrayList;
import org.json.JSONException;

public abstract class a<T> extends ApollonBean<T> {
    public static final String a = "CommonBean";

    public a(Context context) {
        super(context);
    }

    private <T> T a(String str, Class<T> cls) {
        try {
            return JsonUtils.fromJson(str, cls);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        if (restResponseEntity == null || this.mRspCallback == null) {
            IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
            if (iBeanResponseCallback != null) {
                iBeanResponseCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                return;
            }
            return;
        }
        BeanResponseBase beanResponseBase = (BeanResponseBase) restResponseEntity.getBody();
        if (beanResponseBase != null) {
            int serverReturnValue = beanResponseBase.getServerReturnValue(cls);
            if (serverReturnValue != 0) {
                this.mRspCallback.onBeanExecFailure(getBeanId(), serverReturnValue, beanResponseBase.getRealResponseMsg());
                return;
            }
            LogUtil.d(a, "execBean. ret       . rsp class = " + cls);
            if (cls == null) {
                this.mRspCallback.onBeanExecSuccess(getBeanId(), (Object) null, beanResponseBase.getRealResponseMsg());
            } else if (JsonUtils.DataType.isString(cls)) {
                this.mRspCallback.onBeanExecSuccess(getBeanId(), (Object) null, beanResponseBase.getRealResponseContent());
            } else {
                T a2 = a(beanResponseBase.getRealResponseContent(), cls);
                LogUtil.d(a, "execBean. ret ok. real response = " + a2);
                if (a2 != null) {
                    IBeanResponse iBeanResponse = (IBeanResponse) a2;
                    if (iBeanResponse.checkResponseValidity()) {
                        iBeanResponse.storeResponse(this.mContext);
                        this.mRspCallback.onBeanExecSuccess(getBeanId(), a2, beanResponseBase.getRealResponseMsg());
                        return;
                    }
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                    return;
                }
                this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
            }
        } else {
            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
        }
    }

    public void prepareRestTemplate() {
        this.mRestTemplate = new RestTemplate(this.mContext, ChannelUtils.getHostUA(), "apollon");
        this.mRestTemplate.setRequestInterceptor(new ArrayList());
        this.mRestTemplate.setMessageConverter(new GsonHttpMessageConverter());
    }

    public a(Context context, int i2) {
        super(context);
    }
}
