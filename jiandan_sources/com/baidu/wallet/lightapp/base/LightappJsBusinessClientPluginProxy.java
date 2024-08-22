package com.baidu.wallet.lightapp.base;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.NoProguard;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public class LightappJsBusinessClientPluginProxy implements NoProguard, ILightappInvoker {
    public static String a = ";";
    public String b = LightappJsBusinessClientPluginProxy.class.getSimpleName();
    public Context c;
    public Method d;
    public Object e;
    public Class<?> f;

    public LightappJsBusinessClientPluginProxy(Context context) {
        Class<String> cls = String.class;
        this.c = context;
        try {
            Class<?> cls2 = Class.forName("com.baidu.apollon.xplugin.XPluginInvoker");
            this.e = cls2.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            Class<?> cls3 = Class.forName("com.baidu.apollon.xplugin.XPluginServiceCallback");
            this.f = cls3;
            this.d = cls2.getMethod("invokePluginService", new Class[]{Context.class, cls, cls, String[].class, cls3});
        } catch (Exception e2) {
            throw new RuntimeException("plugin interface failde", e2);
        }
    }

    public Set<String> getMethodList() {
        final HashSet hashSet = new HashSet();
        AnonymousClass1 r1 = new ILightappInvokerCallback() {
            public void onResult(int i2, String str) {
                String[] split;
                if (!TextUtils.isEmpty(str) && (split = str.split(LightappJsBusinessClientPluginProxy.a)) != null && split.length > 0) {
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2)) {
                            hashSet.add(str2);
                        }
                    }
                }
            }
        };
        Object newProxyInstance = Proxy.newProxyInstance(LightappJsBusinessClientPluginProxy.class.getClassLoader(), new Class[]{this.f}, new a(r1));
        try {
            this.d.invoke(this.e, new Object[]{this.c, "com.baidu.wallet.plugin", "getMethodList", null, newProxyInstance});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hashSet;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void lightappInvoke(android.content.Context r7, java.lang.String r8, com.baidu.wallet.api.ILightappInvokerCallback r9) {
        /*
            r6 = this;
            java.lang.Class<com.baidu.wallet.lightapp.base.LightappJsBusinessClientPluginProxy> r0 = com.baidu.wallet.lightapp.base.LightappJsBusinessClientPluginProxy.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]
            java.lang.Class<?> r3 = r6.f
            r4 = 0
            r2[r4] = r3
            com.baidu.wallet.lightapp.base.LightappJsBusinessClientPluginProxy$a r3 = new com.baidu.wallet.lightapp.base.LightappJsBusinessClientPluginProxy$a
            r3.<init>(r9)
            java.lang.Object r9 = java.lang.reflect.Proxy.newProxyInstance(r0, r2, r3)
            java.lang.reflect.Method r0 = r6.d     // Catch:{ Exception -> 0x0037 }
            java.lang.Object r2 = r6.e     // Catch:{ Exception -> 0x0037 }
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0037 }
            r3[r4] = r7     // Catch:{ Exception -> 0x0037 }
            java.lang.String r7 = "com.baidu.wallet.plugin"
            r3[r1] = r7     // Catch:{ Exception -> 0x0037 }
            r7 = 2
            java.lang.String r5 = "lightappInvoke"
            r3[r7] = r5     // Catch:{ Exception -> 0x0037 }
            r7 = 3
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0037 }
            r1[r4] = r8     // Catch:{ Exception -> 0x0037 }
            r3[r7] = r1     // Catch:{ Exception -> 0x0037 }
            r7 = 4
            r3[r7] = r9     // Catch:{ Exception -> 0x0037 }
            r0.invoke(r2, r3)     // Catch:{ Exception -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r7 = move-exception
            r7.printStackTrace()
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.base.LightappJsBusinessClientPluginProxy.lightappInvoke(android.content.Context, java.lang.String, com.baidu.wallet.api.ILightappInvokerCallback):void");
    }

    public class a implements NoProguard, InvocationHandler {
        public ILightappInvokerCallback b;

        public a(ILightappInvokerCallback iLightappInvokerCallback) {
            this.b = iLightappInvokerCallback;
        }

        public void a(String str, String str2) {
            int i2;
            try {
                i2 = Integer.parseInt(str);
            } catch (Throwable unused) {
                i2 = 1;
            }
            ILightappInvokerCallback iLightappInvokerCallback = this.b;
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(i2, str2);
            }
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            if ("onCallbackSuccess".equals(name)) {
                a(objArr[0], objArr[1]);
                return null;
            } else if (!"onCallbackFailed".equals(name)) {
                return null;
            } else {
                a(objArr[0], objArr[1].intValue(), objArr[2]);
                return null;
            }
        }

        public void a(String str, int i2, String str2) {
            int i3;
            try {
                i3 = Integer.parseInt(str);
            } catch (Throwable unused) {
                i3 = 1;
            }
            ILightappInvokerCallback iLightappInvokerCallback = this.b;
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(i3, str2);
            }
        }
    }
}
