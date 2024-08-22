package com.baidu.wallet.core.beans.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.restnet.RestMultipartEntity;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.converter.GsonHttpMessageConverter;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.beans.CometHttpRequestInterceptor;
import com.baidu.wallet.core.beans.CometHttpTimeoutRequestInterceptor;
import com.baidu.wallet.core.beans.EbpayHttpRequestInterceptor;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public abstract class a extends NetworkBean {
    public static final int c = 1;
    public static final String d = "a";
    public static final int h = 2;
    public RestMultipartEntity.ProgressListener a;
    public List<C0152a> b = new ArrayList();
    public int e = -1;
    public Class<?> f;
    public long g = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f3550i;

    /* renamed from: com.baidu.wallet.core.beans.a.a$a  reason: collision with other inner class name */
    public static class C0152a {
        public String a;
        public String b;
        public String c;
        public String d;
    }

    public a(Context context) {
        super(context);
    }

    private void a(int i2) {
    }

    public void a(RestMultipartEntity.ProgressListener progressListener) {
        this.a = progressListener;
    }

    public void destroyBean() {
        super.destroyBean();
        this.b.clear();
    }

    public void execBean(Class cls) {
        this.f = cls;
        this.g = System.currentTimeMillis();
        super.execBean(cls);
    }

    public void executeAndHandleResponse(Class cls, Class cls2) {
        try {
            b a2 = a();
            BeanResponseBase beanResponseBase = (BeanResponseBase) this.mRestTemplate.postMultipartForObject(getUrl(), a2, getEncode(), BeanResponseBase.class);
            a2.closeOutStream();
            if (beanResponseBase != null) {
                a(beanResponseBase.ret);
            } else {
                a(-4);
            }
            a(cls, (Class) null, beanResponseBase);
        } catch (Exception e2) {
            a(-4);
            if (!(e2 instanceof RestRuntimeException) || !((RestRuntimeException) e2).contains(SocketTimeoutException.class)) {
                a(cls, (Class) null, (BeanResponseBase) null);
            } else {
                IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
                if (iBeanResponseCallback != null) {
                    iBeanResponseCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "appmg_resolve_error"));
                }
            }
            e2.printStackTrace();
        }
    }

    public void handleResponse(Class cls, Class cls2, RestResponseEntity restResponseEntity) {
    }

    public boolean needNonce() {
        return true;
    }

    public void prepareRestTemplate() {
        Object obj;
        Context context = this.mContext;
        this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
        ArrayList arrayList = new ArrayList();
        String str = d;
        LogUtil.d(str, "beanType:" + this.e);
        int i2 = this.e;
        if (i2 == 2) {
            LogUtil.d(d, "beanType, 有超时拦截器");
            obj = new CometHttpTimeoutRequestInterceptor(this.f3550i);
        } else if (i2 == 1) {
            obj = new CometHttpRequestInterceptor();
        } else {
            obj = new EbpayHttpRequestInterceptor();
        }
        arrayList.add(obj);
        arrayList.add(new com.baidu.wallet.core.beans.a(this.tag[0].booleanValue()));
        this.mRestTemplate.setRequestInterceptor(arrayList);
        this.mRestTemplate.setMessageConverter(new GsonHttpMessageConverter());
    }

    public void a(C0152a aVar) {
        if (aVar != null) {
            this.b.add(aVar);
        }
    }

    private void a(Class cls, Class cls2, BeanResponseBase beanResponseBase) {
        IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
        if (iBeanResponseCallback == null) {
            return;
        }
        if (beanResponseBase != null) {
            int serverReturnValue = beanResponseBase.getServerReturnValue(cls);
            if (serverReturnValue != 0) {
                this.mRspCallback.onBeanExecFailure(getBeanId(), serverReturnValue, beanResponseBase.msg);
                return;
            }
            String str = d;
            LogUtil.d(str, "execBean. ret       . rsp class = " + cls);
            if (cls == null) {
                this.mRspCallback.onBeanExecSuccess(getBeanId(), (Object) null, beanResponseBase.getRealResponseContent());
            } else if (JsonUtils.DataType.isString(cls)) {
                this.mRspCallback.onBeanExecSuccess(getBeanId(), beanResponseBase.getRealResponseContent(), (String) null);
            } else {
                Object a2 = a(beanResponseBase.getRealResponseContent(), cls);
                String str2 = d;
                LogUtil.d(str2, "execBean. ret ok. real response = " + a2);
                if (a2 != null) {
                    IBeanResponse iBeanResponse = (IBeanResponse) a2;
                    if (iBeanResponse.checkResponseValidity()) {
                        iBeanResponse.storeResponse(this.mContext);
                        this.mRspCallback.onBeanExecSuccess(getBeanId(), a2, beanResponseBase.msg);
                        return;
                    }
                    IBeanResponseCallback iBeanResponseCallback2 = this.mRspCallback;
                    if (iBeanResponseCallback2 != null) {
                        iBeanResponseCallback2.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "appmg_resolve_error"));
                        return;
                    }
                    return;
                }
                IBeanResponseCallback iBeanResponseCallback3 = this.mRspCallback;
                if (iBeanResponseCallback3 != null) {
                    iBeanResponseCallback3.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "appmg_resolve_error"));
                }
            }
        } else if (iBeanResponseCallback != null) {
            iBeanResponseCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "appmg_resolve_error"));
        }
    }

    public a(Context context, int i2) {
        super(context);
        this.e = i2;
    }

    private b a() throws Exception {
        b bVar = new b();
        List<RestNameValuePair> requestParams = getRequestParams();
        for (RestNameValuePair next : requestParams) {
            if ("ua".equals(next.getName())) {
                next.setValue(BussinessUtils.getUA(this.mContext));
            }
        }
        boolean z = false;
        int i2 = 0;
        while (i2 < this.b.size()) {
            boolean z2 = i2 == this.b.size() - 1 ? true : z;
            C0152a aVar = this.b.get(i2);
            if (aVar != null && !TextUtils.isEmpty(aVar.a) && this.b.size() > 0) {
                requestParams.add(new RestNameValuePair("fileKey", SafePay.getInstance().encryptProxy(a(aVar.a))));
                bVar.addPart(aVar.d, aVar.c, new FileInputStream(aVar.a), aVar.b, z2);
            }
            i2++;
            z = z2;
        }
        if (requestParams != null) {
            for (RestNameValuePair next2 : requestParams) {
                bVar.addPart(next2.getName(), next2.getValue());
            }
        }
        bVar.setProgressListener(this.a);
        return bVar;
    }

    private <T> T a(String str, Class<T> cls) {
        try {
            return JsonUtils.fromJson(str, cls);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return com.baidu.wallet.utils.a.a(new File(str), "MD5");
        } catch (Exception unused) {
            return "";
        }
    }
}
