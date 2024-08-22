package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.content.Context;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.lightapp.ability.b;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityErrorModel;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

public class d extends b {
    public boolean a = false;
    public Class<?> b;
    public Method c;
    public Class<?> d;

    public static class a implements InvocationHandler {
        public ILightappInvokerCallback a;

        public a(ILightappInvokerCallback iLightappInvokerCallback) {
            this.a = iLightappInvokerCallback;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (this.a == null) {
                return null;
            }
            if (!"onResult".equals(method.getName())) {
                return method.invoke(this.a, objArr);
            }
            if (objArr != null && objArr.length >= 2) {
                this.a.onResult(objArr[0].intValue(), objArr[1]);
            }
            return null;
        }
    }

    public String a() {
        return LightappBusinessClient.CALL_NATIVE_VOICE;
    }

    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Activity activity2 = activity;
        String str3 = str;
        ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
        Set<String> methodList = LightAppWrapper.getInstance().getMethodList();
        if (methodList == null || !methodList.contains(LightappBusinessClient.CALL_NATIVE_VOICE)) {
            if (!this.a) {
                try {
                    this.b = Class.forName("com.baidu.walletfacesdk.LightInvokerImpl");
                    Class<?> cls = Class.forName("com.baidu.walletfacesdk.LightInvokerCallback");
                    this.d = cls;
                    this.c = this.b.getDeclaredMethod(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE, new Class[]{Context.class, String.class, Boolean.TYPE, cls});
                } catch (Throwable th2) {
                    this.a = true;
                    throw th2;
                }
                this.a = true;
            }
            if (this.b == null || this.d == null || this.c == null) {
                NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
                NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
                data.errCode = "10004";
                data.des = "没有找到对应的方法";
                iLightappInvokerCallback2.onResult(1, nativeAbilityErrorModel.toJson());
                return;
            }
            try {
                Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.d}, new a(iLightappInvokerCallback2));
                boolean equals = "ONLINE".equals(DebugConfig.getInstance().getEnvironment());
                this.c.invoke((Object) null, new Object[]{activity2, str3, Boolean.valueOf(equals), newProxyInstance});
            } catch (Throwable unused) {
                a(iLightappInvokerCallback, str2, "10003", "reflect callNativeVoice fail!", "#callNativeVoiceFail");
            }
        } else {
            LightAppWrapper.getInstance().lightappInvoke(activity2, str3, iLightappInvokerCallback2);
        }
    }
}
