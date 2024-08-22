package com.baidu.apollon.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.taskmanager.TaskManager;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import java.util.List;
import java.util.Objects;

public abstract class ApollonBean<T> {
    public static final String BEAN_TASK_MGR_KEY = "BeanTaskManager";
    public static final String BEAN_TASK_MGR_TASK_KEY = "ApollonBeanTask";
    public Context mContext;
    public RestTemplate mRestTemplate;
    public IBeanResponseCallback mRspCallback;
    public String mTskKey = "";

    public ApollonBean(Context context) {
        this.mContext = DxmApplicationContextImpl.getApplicationContext(context);
    }

    public void destroyBean() {
        this.mRspCallback = null;
        TaskManager.getInstance(BEAN_TASK_MGR_KEY).cancelTask(BEAN_TASK_MGR_TASK_KEY, this.mTskKey);
        RestTemplate restTemplate = this.mRestTemplate;
        if (restTemplate != null) {
            restTemplate.setRequestInterceptor((List<RestHttpRequestInterceptor>) null);
        }
    }

    public abstract void execBean();

    public <T> void execBean(Class<T> cls) {
        execBean(cls, (Class) null);
    }

    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> restResponseEntity;
        Class<BeanResponseString> cls3 = BeanResponseString.class;
        Class<BeanResponseBase> cls4 = BeanResponseBase.class;
        if (getHttpMethod() == 0) {
            RestTemplate restTemplate = this.mRestTemplate;
            String url = getUrl();
            List<RestNameValuePair> requestParams = getRequestParams();
            String encode = getEncode();
            if (!JsonUtils.DataType.isString(cls)) {
                cls3 = cls4;
            }
            restResponseEntity = restTemplate.b(url, requestParams, encode, cls3);
        } else if (getHttpMethod() == 1) {
            RestTemplate restTemplate2 = this.mRestTemplate;
            String url2 = getUrl();
            List<RestNameValuePair> requestParams2 = getRequestParams();
            String encode2 = getEncode();
            if (!JsonUtils.DataType.isString(cls)) {
                cls3 = cls4;
            }
            restResponseEntity = restTemplate2.d(url2, requestParams2, encode2, cls3);
        } else {
            restResponseEntity = null;
        }
        handleResponse(cls, cls2, restResponseEntity);
    }

    public int getAuthLevel() {
        return 2;
    }

    public abstract int getBeanId();

    public String getEncode() {
        return "UTF-8";
    }

    public int getHttpMethod() {
        return 1;
    }

    public abstract List<RestNameValuePair> getRequestParams();

    public abstract String getUrl();

    public abstract <T, E> void handleCommonErrors(Exception exc);

    public abstract void handleNetworkFailureError();

    public abstract <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity);

    public abstract <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity);

    public abstract void prepareRestTemplate();

    public void setResponseCallback(IBeanResponseCallback iBeanResponseCallback) {
        this.mRspCallback = iBeanResponseCallback;
    }

    public <T, E> void execBean(final Class<T> cls, final Class<E> cls2) {
        AnonymousClass1 r8 = new Runnable() {
            public void run() {
                try {
                    ApollonBean.this.prepareRestTemplate();
                    ApollonBean.this.executeAndHandleResponse(cls, cls2);
                } catch (Exception e) {
                    ApollonBean.this.handleCommonErrors(e);
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
        TaskManager instance = TaskManager.getInstance(BEAN_TASK_MGR_KEY);
        this.mTskKey = "BeanTask_" + getBeanId() + "_" + System.currentTimeMillis();
        Objects.requireNonNull(instance);
        instance.addTask(new TaskManager.Task(0, 0, false, this.mTskKey, r8), BEAN_TASK_MGR_TASK_KEY);
    }
}
