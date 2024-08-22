package com.baidu.fsg.base.restnet.beans;

import android.content.Context;
import com.baidu.fsg.base.a.a;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestTemplate;
import com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.NetworkUtils;
import java.util.List;

public abstract class ApollonBean {
    private static final String BEAN_TASK_MGR_KEY = "BeanTaskManager";
    private static final String BEAN_TASK_MGR_TASK_KEY = "ApollonBeanTask";
    protected Context mContext;
    protected RestTemplate mRestTemplate;
    protected IBeanResponseCallback mRspCallback;
    private String mTskKey = "";

    public ApollonBean(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void destroyBean() {
        this.mRspCallback = null;
        a.a(BEAN_TASK_MGR_KEY).a(BEAN_TASK_MGR_TASK_KEY, this.mTskKey);
        RestTemplate restTemplate = this.mRestTemplate;
        if (restTemplate != null) {
            restTemplate.setRequestInterceptor((List<RestHttpRequestInterceptor>) null);
        }
    }

    public void execBean() {
        execBean(responseClass());
    }

    public <T> void execBean(Class<T> cls) {
        execBean(cls, (Class) null);
    }

    public <T, E> void execBean(final Class<T> cls, final Class<E> cls2) {
        AnonymousClass1 r8 = new Runnable() {
            public void run() {
                try {
                    ApollonBean.this.prepareRestTemplate();
                    ApollonBean.this.executeAndHandleResponse(cls, cls2);
                } catch (Exception e2) {
                    ApollonBean.this.handleCommonErrors(e2);
                } catch (Throwable th2) {
                    ApollonBean.this.mRspCallback = null;
                    throw th2;
                }
                ApollonBean.this.mRspCallback = null;
            }
        };
        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            handleNetworkFailureError();
            return;
        }
        a a2 = a.a(BEAN_TASK_MGR_KEY);
        this.mTskKey = "BeanTask_" + getBeanId() + "_" + System.currentTimeMillis();
        a2.getClass();
        a2.a(new a.c(0, 0, false, this.mTskKey, r8), BEAN_TASK_MGR_TASK_KEY);
    }

    /* access modifiers changed from: protected */
    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> restResponseEntity;
        if (getHttpMethod() == 0) {
            restResponseEntity = this.mRestTemplate.getForEntity(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
        } else if (getHttpMethod() == 1) {
            restResponseEntity = this.mRestTemplate.postForEntity(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
        } else {
            restResponseEntity = null;
        }
        handleResponse(cls, cls2, restResponseEntity);
    }

    public abstract int getBeanId();

    public String getEncode() {
        return "UTF-8";
    }

    public int getHttpMethod() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public abstract List<RestNameValuePair> getRequestParams();

    public abstract String getUrl();

    /* access modifiers changed from: protected */
    public abstract <T, E> void handleCommonErrors(Exception exc);

    /* access modifiers changed from: protected */
    public abstract void handleNetworkFailureError();

    public abstract <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity);

    /* access modifiers changed from: protected */
    public abstract <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity);

    /* access modifiers changed from: protected */
    public abstract void prepareRestTemplate();

    public abstract Class<?> responseClass();

    public void setResponseCallback(IBeanResponseCallback iBeanResponseCallback) {
        this.mRspCallback = iBeanResponseCallback;
    }
}
