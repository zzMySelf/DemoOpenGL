package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.swan.game.ad.jsbridge.BaseHtmlBridgeHandler;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, b> f5878a = new HashMap<>();

    /* renamed from: com.tencent.open.a$a  reason: collision with other inner class name */
    /* compiled from: ProGuard */
    public static class C0101a {

        /* renamed from: a  reason: collision with root package name */
        protected WeakReference<WebView> f5879a;

        /* renamed from: b  reason: collision with root package name */
        protected long f5880b;

        /* renamed from: c  reason: collision with root package name */
        protected String f5881c;

        public C0101a(WebView webView, long j2, String str) {
            this.f5879a = new WeakReference<>(webView);
            this.f5880b = j2;
            this.f5881c = str;
        }

        public void a(Object obj) {
            String str;
            WebView webView = (WebView) this.f5879a.get();
            if (webView != null) {
                if (obj instanceof String) {
                    str = "'" + ((String) obj).replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("'", "\\'") + "'";
                } else if ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) {
                    str = obj.toString();
                } else if (obj instanceof Boolean) {
                    str = obj.toString();
                } else {
                    str = "'undefined'";
                }
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f5880b + ",{'r':0,'result':" + str + "});");
            }
        }

        public void a() {
            WebView webView = (WebView) this.f5879a.get();
            if (webView != null) {
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f5880b + ",{'r':1,'result':'no such method'})");
            }
        }

        public void a(String str) {
            WebView webView = (WebView) this.f5879a.get();
            if (webView != null) {
                webView.loadUrl(BaseHtmlBridgeHandler.JAVASCRIPT_PREFIX + str);
            }
        }
    }

    /* compiled from: ProGuard */
    public static class b {
        public void call(String str, List<String> list, C0101a aVar) {
            String str2;
            Method method;
            Object obj;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i2 = 0;
            while (true) {
                str2 = null;
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i2];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                }
                i2++;
            }
            if (method != null) {
                try {
                    switch (list.size()) {
                        case 0:
                            obj = method.invoke(this, new Object[0]);
                            break;
                        case 1:
                            obj = method.invoke(this, new Object[]{list.get(0)});
                            break;
                        case 2:
                            obj = method.invoke(this, new Object[]{list.get(0), list.get(1)});
                            break;
                        case 3:
                            obj = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2)});
                            break;
                        case 4:
                            obj = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3)});
                            break;
                        case 5:
                            obj = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)});
                            break;
                        default:
                            Object[] objArr = new Object[6];
                            objArr[0] = list.get(0);
                            objArr[1] = list.get(1);
                            objArr[2] = list.get(2);
                            objArr[3] = list.get(3);
                            objArr[4] = list.get(4);
                            objArr[5] = list.get(5);
                            obj = method.invoke(this, objArr);
                            break;
                    }
                    Class<?> returnType = method.getReturnType();
                    SLog.d("openSDK_LOG.JsBridge", "-->call, result: " + obj + " | ReturnType: " + returnType.getName());
                    if (!"void".equals(returnType.getName())) {
                        if (returnType != Void.class) {
                            if (aVar != null && customCallback()) {
                                if (obj != null) {
                                    str2 = obj.toString();
                                }
                                aVar.a(str2);
                                return;
                            }
                            return;
                        }
                    }
                    if (aVar != null) {
                        aVar.a((Object) null);
                    }
                } catch (Exception e2) {
                    SLog.e("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e2);
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            } else if (aVar != null) {
                aVar.a();
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(b bVar, String str) {
        this.f5878a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0101a aVar) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                list.set(i2, URLDecoder.decode(list.get(i2), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        b bVar = this.f5878a.get(str);
        if (bVar != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, aVar);
            return;
        }
        SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (aVar != null) {
            aVar.a();
        }
    }

    public boolean a(WebView webView, String str) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        List subList = arrayList.subList(4, arrayList.size() - 1);
        C0101a aVar = new C0101a(webView, 4, str);
        webView.getUrl();
        a((String) arrayList.get(2), (String) arrayList.get(3), subList, aVar);
        return true;
    }
}
