package com.baidu.apollon.restnet;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.restnet.converter.AbstractHttpMessageConverter;
import com.baidu.apollon.restnet.http.HttpDefines;
import com.baidu.apollon.restnet.http.HttpStatus;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.restnet.rest.f;
import com.baidu.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.baidu.apollon.restnet.rest.httpurlconnection.c;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.LogUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestTemplate {
    public static final String a = "RestTemplate";
    public AbstractHttpMessageConverter<?> b;
    public List<RestHttpRequestInterceptor> c;
    public Context d;
    public String e;
    public String f;
    public boolean g;

    public final class a implements RestHttpRequestInterceptor {
        public final Class<?> b;

        public void intercept(Context context, d dVar) {
            if (this.b != null) {
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
                    dVar.a().a(sb.toString());
                }
            }
        }

        public a(Class<?> cls) {
            this.b = cls;
        }
    }

    public RestTemplate(Context context) {
        this(true, context, (String) null, (String) null);
    }

    public List<RestHttpRequestInterceptor> a() {
        return this.c;
    }

    public AbstractHttpMessageConverter<?> b() {
        return this.b;
    }

    public <T> T c(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        a().add(new a(cls));
        f fVar = new f(cls, b());
        d a2 = a(str, list, (RestMultipartEntity) null, str2, HttpDefines.HttpMethod.POST, z);
        e a3 = a(a2);
        a(HttpDefines.HttpMethod.POST, str, a3);
        return a(a2, a3, fVar);
    }

    public <T> RestResponseEntity<T> d(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        LogUtil.d("#####. postForEntity. url = " + str);
        a().add(new a(cls));
        f fVar = new f(cls, b());
        d a2 = a(str, list, (RestMultipartEntity) null, str2, HttpDefines.HttpMethod.POST, z);
        e a3 = a(a2);
        a(HttpDefines.HttpMethod.POST, str, a3);
        return b(a2, a3, fVar);
    }

    public <T> T postMultipartForObject(String str, RestMultipartEntity restMultipartEntity, String str2, Class<T> cls) throws RestRuntimeException {
        a().add(new a(cls));
        f fVar = new f(cls, b());
        d a2 = a(str, (List<RestNameValuePair>) null, restMultipartEntity, str2, HttpDefines.HttpMethod.POST, false);
        e a3 = a(a2);
        a(HttpDefines.HttpMethod.POST, str, a3);
        return a(a2, a3, fVar);
    }

    public void setMessageConverter(AbstractHttpMessageConverter<?> abstractHttpMessageConverter) {
        this.b = abstractHttpMessageConverter;
    }

    public void setRequestInterceptor(List<RestHttpRequestInterceptor> list) {
        this.c = list;
    }

    public RestTemplate(Context context, String str, String str2) {
        this(true, context, str, str2);
    }

    public void a(boolean z) {
        this.g = z;
    }

    public <T> RestResponseEntity<T> b(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        a().add(new a(cls));
        f fVar = new f(cls, b());
        d a2 = a(str, list, (RestMultipartEntity) null, str2, HttpDefines.HttpMethod.GET, z);
        e a3 = a(a2);
        a(HttpDefines.HttpMethod.GET, str, a3);
        return b(a2, a3, fVar);
    }

    public RestTemplate(boolean z, Context context, String str, String str2) {
        this.b = null;
        this.c = new ArrayList();
        this.d = null;
        this.e = null;
        this.f = "";
        this.g = true;
        this.f = str2;
        this.d = DxmApplicationContextImpl.getApplicationContext(context);
        this.e = str;
    }

    public <T> T a(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        a().add(new a(cls));
        f fVar = new f(cls, b());
        d a2 = a(str, list, (RestMultipartEntity) null, str2, HttpDefines.HttpMethod.GET, z);
        e a3 = a(a2);
        a(HttpDefines.HttpMethod.GET, str, a3);
        return a(a2, a3, fVar);
    }

    public <T> RestResponseEntity<T> b(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return b(str, list, str2, cls, false);
    }

    public <T> T c(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return c(str, list, str2, cls, false);
    }

    public <T> RestResponseEntity<T> d(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return d(str, list, str2, cls, false);
    }

    private <T> RestResponseEntity<T> b(d dVar, e eVar, f<T> fVar) {
        RestResponseEntity<T> restResponseEntity;
        if (fVar == null) {
            return null;
        }
        if (eVar != null) {
            try {
                if (eVar.e().series() != HttpStatus.Series.CLIENT_ERROR) {
                    if (eVar.e().series() != HttpStatus.Series.SERVER_ERROR) {
                        T a2 = fVar.a(eVar);
                        if (a2 != null) {
                            restResponseEntity = new RestResponseEntity<>(a2, eVar.d(), eVar.e());
                        } else {
                            restResponseEntity = new RestResponseEntity<>(eVar.d(), eVar.e());
                        }
                        restResponseEntity.b(fVar.a());
                        if (dVar != null) {
                            dVar.f();
                        }
                        if (eVar != null) {
                            eVar.f();
                        }
                        return restResponseEntity;
                    }
                }
            } catch (Exception e2) {
                throw new RestRuntimeException("error: " + e2.getMessage(), e2);
            } catch (Throwable th2) {
                if (dVar != null) {
                    dVar.f();
                }
                if (eVar != null) {
                    eVar.f();
                }
                throw th2;
            }
        }
        if (dVar != null) {
            dVar.f();
        }
        if (eVar != null) {
            eVar.f();
        }
        return null;
    }

    public <T> T a(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return a(str, list, str2, cls, false);
    }

    private d a(String str, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2, HttpDefines.HttpMethod httpMethod, boolean z) {
        if (str == null || httpMethod == null) {
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
        d a2 = c.a().a(this.d, this.f, this.e, str, httpMethod, list, restMultipartEntity, str2, z);
        for (RestHttpRequestInterceptor intercept : a()) {
            intercept.intercept(this.d, a2);
        }
        return a2;
    }

    private e a(d dVar) throws RestRuntimeException {
        try {
            URL url = new URL(dVar.c());
            String host = url.getHost();
            int port = url.getPort();
            if (port > 0) {
                host + ":" + port;
            }
            if (this.g) {
                ((RestUrlConnectionRequest) dVar).b(RestHttpDNSEnabler.a(url));
            }
            dVar.a(url.toString());
            e d2 = dVar.d();
            if (ApollonConstants.DEBUG) {
                LogUtil.v("apollon_rest", "rtt:" + d2.d().u());
            }
            return d2;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                RestHttpDNSEnabler.b(new URL(dVar.c()).getHost());
            } catch (MalformedURLException e3) {
                e3.printStackTrace();
            }
            if (dVar != null) {
                dVar.f();
            }
            throw new RestRuntimeException("RestRuntimeException: " + e2.getMessage(), e2);
        }
    }

    private <T> T a(d dVar, e eVar, f<T> fVar) {
        if (fVar == null) {
            return null;
        }
        if (eVar != null) {
            try {
                if (eVar.e().series() != HttpStatus.Series.CLIENT_ERROR) {
                    if (eVar.e().series() != HttpStatus.Series.SERVER_ERROR) {
                        T a2 = fVar.a(eVar);
                        if (a2 != null) {
                            if (dVar != null) {
                                dVar.f();
                            }
                            if (eVar != null) {
                                eVar.f();
                            }
                            return a2;
                        }
                        if (dVar != null) {
                            dVar.f();
                        }
                        if (eVar != null) {
                            eVar.f();
                        }
                        return null;
                    }
                }
            } catch (Exception e2) {
                throw new RestRuntimeException("error: " + e2.getMessage(), e2);
            } catch (Throwable th2) {
                if (dVar != null) {
                    dVar.f();
                }
                if (eVar != null) {
                    eVar.f();
                }
                throw th2;
            }
        }
        if (dVar != null) {
            dVar.f();
        }
        if (eVar != null) {
            eVar.f();
        }
        return null;
    }

    private void a(HttpDefines.HttpMethod httpMethod, String str, e eVar) {
        if (eVar != null) {
            try {
                LogUtil.d("RestTemplate", httpMethod.name() + " request for \"" + str + "\" resulted in " + eVar.e() + " (" + eVar.b() + ")");
            } catch (Exception e2) {
                LogUtil.d("RestTemplate", "IOException : " + e2.getMessage());
            }
        }
    }
}
