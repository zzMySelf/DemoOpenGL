package com.dxmpay.apollon.beans;

import android.content.Context;
import android.net.Uri;
import com.baidu.sapi2.result.SapiResult;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestResponseEntity;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.taskmanager.TaskManager;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.NetworkUtils;
import com.dxmpay.wallet.statistics.NetStepStatManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertPathValidatorException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

public abstract class ApollonBean<T> {
    public static final String EVENT_CALL_INTERFACE = "call_interface";
    public String a = "";
    public Context mContext;
    public RestTemplate mRestTemplate;
    public IBeanResponseCallback mRspCallback;
    public long mStartTime = 0;

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Class f3962ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Class f3963th;

        public qw(Class cls, Class cls2) {
            this.f3962ad = cls;
            this.f3963th = cls2;
        }

        public void run() {
            try {
                ApollonBean.this.prepareRestTemplate();
                ApollonBean.this.executeAndHandleResponse(this.f3962ad, this.f3963th);
            } catch (Exception e) {
                ApollonBean.this.a(e);
                ApollonBean.this.handleCommonErrors(e);
                NetStepStatManager.getInstance().removeKey(Uri.parse(ApollonBean.this.getUrl()).getPath(), ApollonBean.this.mStartTime);
            } catch (Throwable th2) {
                ApollonBean.this.mRspCallback = null;
                throw th2;
            }
            ApollonBean.this.mRspCallback = null;
        }
    }

    public ApollonBean(Context context) {
        this.mContext = context.getApplicationContext();
        getClass().getName();
    }

    public void destroyBean() {
        this.mRspCallback = null;
        TaskManager.getInstance("DxmBeanTaskManager").cancelTask("DxmApollonBeanTask", this.a);
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
        long currentTimeMillis = System.currentTimeMillis();
        List<RestNameValuePair> requestParams = getRequestParams();
        NetStepStatManager.getInstance().recordBuildParamsCost(Uri.parse(getUrl()).getPath(), this.mStartTime, System.currentTimeMillis() - currentTimeMillis);
        if (getHttpMethod() == 0) {
            restResponseEntity = this.mRestTemplate.getForEntity(getUrl(), requestParams, getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
        } else if (getHttpMethod() == 1) {
            restResponseEntity = this.mRestTemplate.postForEntity(getUrl(), requestParams, getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
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

    /* access modifiers changed from: private */
    public void a(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter, true));
        String stringWriter2 = stringWriter.toString();
        int length = stringWriter2.length();
        int min = Math.min(length / 200, 9);
        ArrayList arrayList = new ArrayList();
        try {
            URL url = new URL(getUrl());
            arrayList.add(url.getPath());
            arrayList.add("-500");
            if (min > 0) {
                int i2 = 0;
                for (int i3 = 2; i3 <= min; i3++) {
                    if (i3 == 8) {
                        arrayList.add("");
                    } else if (i3 == min) {
                        arrayList.add(stringWriter2.substring(i2, length));
                    } else {
                        int i4 = i2 + 200;
                        arrayList.add(stringWriter2.substring(i2, i4));
                        i2 = i4;
                    }
                }
            } else {
                arrayList.add(stringWriter2);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.CURRENT_DOMAIN, url.getHost());
            int i5 = -200;
            Throwable cause = exc.getCause();
            if (cause instanceof UnknownHostException) {
                i5 = -201;
            } else if (cause instanceof ConnectException) {
                i5 = -202;
            } else if (cause instanceof SocketException) {
                i5 = -203;
            } else if (cause instanceof SocketTimeoutException) {
                i5 = -204;
            } else if (cause instanceof SSLHandshakeException) {
                i5 = -205;
            } else if (cause instanceof CertPathValidatorException) {
                i5 = SapiResult.ERROR_CODE_METHOD_DEPRECATED;
            } else if (cause instanceof SSLException) {
                i5 = SapiResult.ERROR_CODE_V2_SHARE_ACCOUNT_FAIL;
            }
            hashMap.put("value12", Integer.valueOf(i5));
            hashMap.put("errorMsg", exc.getMessage());
            StatisticManager.onEventWithValues(EVENT_CALL_INTERFACE, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
        } catch (MalformedURLException unused) {
            exc.getMessage();
        }
    }

    public <T, E> void execBean(Class<T> cls, Class<E> cls2) {
        NetStepStatManager.getInstance().recordStartTime(Uri.parse(getUrl()).getPath(), this.mStartTime);
        qw qwVar = new qw(cls, cls2);
        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            handleNetworkFailureError();
            return;
        }
        TaskManager instance = TaskManager.getInstance("DxmBeanTaskManager");
        this.a = "BeanTask_" + getBeanId() + "_" + System.currentTimeMillis();
        instance.getClass();
        instance.addTask(new TaskManager.Task(instance, 0, 0, false, this.a, qwVar), "DxmApollonBeanTask");
    }
}
