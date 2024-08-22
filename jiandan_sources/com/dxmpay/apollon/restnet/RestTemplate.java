package com.dxmpay.apollon.restnet;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.restnet.converter.AbstractHttpMessageConverter;
import com.dxmpay.apollon.restnet.http.HttpDefines$HttpMethod;
import com.dxmpay.apollon.restnet.http.HttpStatus;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.restnet.rest.d;
import com.dxmpay.apollon.restnet.rest.e;
import com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.wallet.statistics.NetStepStatManager;
import fe.i.qw.th.de.de;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestTemplate {
    public static final String TAG = "RestTemplate";

    /* renamed from: ad  reason: collision with root package name */
    public AbstractHttpMessageConverter<?> f4020ad;

    /* renamed from: de  reason: collision with root package name */
    public List<RestHttpRequestInterceptor> f4021de;

    /* renamed from: fe  reason: collision with root package name */
    public Context f4022fe;
    public long qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f4023rg;

    /* renamed from: th  reason: collision with root package name */
    public String f4024th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f4025yj;

    public final class ad implements RestHttpRequestInterceptor {
        public final Class<?> qw;

        public void qw(Context context, d dVar) {
            if (this.qw != null) {
                ArrayList arrayList = new ArrayList();
                if (!arrayList.isEmpty()) {
                    LogUtil.d("RestTemplate", "Setting request Accept header to " + arrayList);
                    StringBuilder sb = new StringBuilder();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        if (it.hasNext()) {
                            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        }
                    }
                    dVar.a().fe(sb.toString());
                }
            }
        }

        public ad(RestTemplate restTemplate, Class<?> cls) {
            this.qw = cls;
        }
    }

    public RestTemplate(Context context) {
        this(true, context, (String) null, (String) null);
    }

    public final e ad(d dVar) throws RestRuntimeException {
        try {
            URL url = new URL(dVar.b());
            String host = url.getHost();
            int port = url.getPort();
            if (port > 0) {
                host + ":" + port;
            }
            if (this.f4025yj) {
                ((RestUrlConnectionRequest) dVar).qw(RestHttpDNSEnabler.qw(url));
            }
            dVar.a(url.toString());
            e c = dVar.c();
            if (ApollonConstants.DEBUG) {
                LogUtil.v(ApollonConstants.APOLLON_REST_TAG, "rtt:" + c.c().pf());
            }
            return c;
        } catch (Exception e) {
            LogUtil.e("RestTemplate", e.getMessage(), e);
            try {
                RestHttpDNSEnabler.rg(new URL(dVar.b()).getHost());
            } catch (MalformedURLException e2) {
                LogUtil.e("RestTemplate", e2.getMessage(), e2);
            }
            if (dVar != null) {
                dVar.e();
            }
            throw new RestRuntimeException("RestRuntimeException: " + e.getMessage(), e);
        }
    }

    public final <T> T de(d dVar, e eVar, de<T> deVar) {
        if (deVar == null) {
            return null;
        }
        if (eVar != null) {
            try {
                if (eVar.d().series() != HttpStatus.Series.CLIENT_ERROR) {
                    if (eVar.d().series() != HttpStatus.Series.SERVER_ERROR) {
                        long currentTimeMillis = System.currentTimeMillis();
                        T qw2 = deVar.qw(eVar);
                        NetStepStatManager.getInstance().recordSMDecryptCost(dVar.h(), dVar.g(), System.currentTimeMillis() - currentTimeMillis);
                        if (qw2 != null) {
                            if (dVar != null) {
                                dVar.e();
                            }
                            if (eVar != null) {
                                eVar.e();
                            }
                            return qw2;
                        }
                        if (dVar != null) {
                            dVar.e();
                        }
                        if (eVar != null) {
                            eVar.e();
                        }
                        return null;
                    }
                }
            } catch (Exception e) {
                throw new RestRuntimeException("error: " + e.getMessage(), e);
            } catch (Throwable th2) {
                if (dVar != null) {
                    dVar.e();
                }
                if (eVar != null) {
                    eVar.e();
                }
                throw th2;
            }
        }
        if (dVar != null) {
            dVar.e();
        }
        if (eVar != null) {
            eVar.e();
        }
        return null;
    }

    public final void fe(HttpDefines$HttpMethod httpDefines$HttpMethod, String str, e eVar) {
        if (eVar != null) {
            try {
                LogUtil.d("RestTemplate", httpDefines$HttpMethod.name() + " request for \"" + str + "\" resulted in " + eVar.d() + " (" + eVar.a() + ")");
            } catch (Exception e) {
                LogUtil.d("RestTemplate", "IOException : " + e.getMessage());
            }
        }
    }

    public <T> RestResponseEntity<T> getForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        getRequestInterceptors().add(new ad(cls));
        de deVar = new de(cls, getMessageConverter());
        d qw2 = qw(str, list, (RestMultipartEntity) null, str2, HttpDefines$HttpMethod.GET, z);
        e ad2 = ad(qw2);
        fe(HttpDefines$HttpMethod.GET, str, ad2);
        return rg(qw2, ad2, deVar);
    }

    public <T> T getForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        getRequestInterceptors().add(new ad(cls));
        de deVar = new de(cls, getMessageConverter());
        d qw2 = qw(str, list, (RestMultipartEntity) null, str2, HttpDefines$HttpMethod.GET, z);
        e ad2 = ad(qw2);
        fe(HttpDefines$HttpMethod.GET, str, ad2);
        return de(qw2, ad2, deVar);
    }

    public AbstractHttpMessageConverter<?> getMessageConverter() {
        return this.f4020ad;
    }

    public List<RestHttpRequestInterceptor> getRequestInterceptors() {
        return this.f4021de;
    }

    public <T> RestResponseEntity<T> postForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        LogUtil.d("#####. postForEntity. url = " + str);
        getRequestInterceptors().add(new ad(cls));
        de deVar = new de(cls, getMessageConverter());
        d qw2 = qw(str, list, (RestMultipartEntity) null, str2, HttpDefines$HttpMethod.POST, z);
        e ad2 = ad(qw2);
        fe(HttpDefines$HttpMethod.POST, str, ad2);
        return rg(qw2, ad2, deVar);
    }

    public <T> T postForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        getRequestInterceptors().add(new ad(cls));
        de deVar = new de(cls, getMessageConverter());
        d qw2 = qw(str, list, (RestMultipartEntity) null, str2, HttpDefines$HttpMethod.POST, z);
        e ad2 = ad(qw2);
        fe(HttpDefines$HttpMethod.POST, str, ad2);
        return de(qw2, ad2, deVar);
    }

    public <T> T postMultipartForObject(String str, RestMultipartEntity restMultipartEntity, String str2, Class<T> cls) throws RestRuntimeException {
        getRequestInterceptors().add(new ad(cls));
        de deVar = new de(cls, getMessageConverter());
        d qw2 = qw(str, (List<RestNameValuePair>) null, restMultipartEntity, str2, HttpDefines$HttpMethod.POST, false);
        e ad2 = ad(qw2);
        fe(HttpDefines$HttpMethod.POST, str, ad2);
        return de(qw2, ad2, deVar);
    }

    public final d qw(String str, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2, HttpDefines$HttpMethod httpDefines$HttpMethod, boolean z) {
        if (str == null || httpDefines$HttpMethod == null) {
            return null;
        }
        if (ApollonConstants.DEBUG) {
            StringBuilder sb = new StringBuilder(str);
            if (list != null && !list.isEmpty()) {
                sb.append("? params : ");
                for (RestNameValuePair next : list) {
                    sb.append(next.getName() + "=" + next.getValue() + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
            }
            LogUtil.d("RestTemplate", sb.toString());
        }
        d qw2 = fe.i.qw.th.de.rg.qw.ad().qw(this.f4022fe, this.f4024th, this.f4023rg, str, httpDefines$HttpMethod, list, restMultipartEntity, str2, z);
        qw2.a(this.qw);
        for (RestHttpRequestInterceptor qw3 : getRequestInterceptors()) {
            qw3.qw(this.f4022fe, qw2);
        }
        return qw2;
    }

    public final <T> RestResponseEntity<T> rg(d dVar, e eVar, de<T> deVar) {
        RestResponseEntity<T> restResponseEntity;
        if (deVar == null) {
            return null;
        }
        if (eVar != null) {
            try {
                if (eVar.d().series() != HttpStatus.Series.CLIENT_ERROR) {
                    if (eVar.d().series() != HttpStatus.Series.SERVER_ERROR) {
                        long currentTimeMillis = System.currentTimeMillis();
                        T qw2 = deVar.qw(eVar);
                        NetStepStatManager.getInstance().recordSMDecryptCost(dVar.h(), dVar.g(), System.currentTimeMillis() - currentTimeMillis);
                        if (qw2 != null) {
                            restResponseEntity = new RestResponseEntity<>(qw2, eVar.c(), eVar.d());
                        } else {
                            restResponseEntity = new RestResponseEntity<>(eVar.c(), eVar.d());
                        }
                        restResponseEntity.setResponseString(deVar.ad());
                        if (dVar != null) {
                            dVar.e();
                        }
                        if (eVar != null) {
                            eVar.e();
                        }
                        return restResponseEntity;
                    }
                }
            } catch (Exception e) {
                throw new RestRuntimeException("error: " + e.getMessage(), e);
            } catch (Throwable th2) {
                if (dVar != null) {
                    dVar.e();
                }
                if (eVar != null) {
                    eVar.e();
                }
                throw th2;
            }
        }
        if (dVar != null) {
            dVar.e();
        }
        if (eVar != null) {
            eVar.e();
        }
        return null;
    }

    public void setMessageConverter(AbstractHttpMessageConverter<?> abstractHttpMessageConverter) {
        this.f4020ad = abstractHttpMessageConverter;
    }

    public void setRequestInterceptor(List<RestHttpRequestInterceptor> list) {
        this.f4021de = list;
    }

    public void setReuseLink(boolean z) {
        this.f4025yj = z;
    }

    public void setStartTime(long j) {
        this.qw = j;
    }

    public RestTemplate(Context context, String str, String str2) {
        this(true, context, str, str2);
    }

    public RestTemplate(boolean z, Context context, String str, String str2) {
        this.qw = 0;
        this.f4020ad = null;
        this.f4021de = new ArrayList();
        this.f4022fe = null;
        this.f4023rg = null;
        this.f4024th = "";
        this.f4025yj = true;
        this.f4024th = str2;
        this.f4022fe = context.getApplicationContext();
        this.f4023rg = str;
    }

    public <T> RestResponseEntity<T> getForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return getForEntity(str, list, str2, cls, false);
    }

    public <T> T getForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return getForObject(str, list, str2, cls, false);
    }

    public <T> RestResponseEntity<T> postForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return postForEntity(str, list, str2, cls, false);
    }

    public <T> T postForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return postForObject(str, list, str2, cls, false);
    }
}
