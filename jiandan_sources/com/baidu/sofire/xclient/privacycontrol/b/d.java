package com.baidu.sofire.xclient.privacycontrol.b;

import com.baidu.sofire.xclient.privacycontrol.PrivacyControlConfig;
import com.baidu.sofire.xclient.privacycontrol.PrvControlManager;
import com.baidu.sofire.xclient.privacycontrol.c.e;

public class d<T> {
    public final String a;
    public c b;
    public StackTraceElement[] c;
    public boolean d = false;
    public a<T> e;
    public e<T> f;

    public interface a<T> {
        T invokeOriginMethod();

        void onProcessConsume(long[] jArr);
    }

    public d(String str) {
        this.a = str;
    }

    /* JADX INFO: finally extract failed */
    public final T a(StackTraceElement[] stackTraceElementArr, boolean z, c cVar, a<T> aVar) {
        e<T> eVar;
        this.c = stackTraceElementArr;
        this.d = z;
        this.e = aVar;
        this.b = cVar;
        long[] jArr = new long[9];
        aVar.onProcessConsume(jArr);
        long currentTimeMillis = System.currentTimeMillis();
        PrivacyControlConfig privacyControlConfig = PrvControlManager.getInstance().getPrivacyControlConfig();
        boolean z2 = true;
        if (PrvControlManager.getInstance().getContext() == null) {
            jArr[1] = System.currentTimeMillis() - currentTimeMillis;
            try {
                return this.e.invokeOriginMethod();
            } finally {
                jArr[7] = System.currentTimeMillis() - currentTimeMillis;
            }
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            jArr[1] = currentTimeMillis2 - currentTimeMillis;
            c cVar2 = this.b;
            boolean z3 = false;
            if ((cVar2.a != 0) && b.a(cVar2, this.a)) {
                z3 = true;
            }
            if (!z3) {
                long currentTimeMillis3 = System.currentTimeMillis();
                jArr[2] = currentTimeMillis3 - currentTimeMillis2;
                try {
                    T invokeOriginMethod = this.e.invokeOriginMethod();
                    jArr[7] = System.currentTimeMillis() - currentTimeMillis3;
                    return invokeOriginMethod;
                } catch (Throwable th2) {
                    jArr[7] = System.currentTimeMillis() - currentTimeMillis3;
                    throw th2;
                }
            } else {
                long currentTimeMillis4 = System.currentTimeMillis();
                jArr[2] = currentTimeMillis4 - currentTimeMillis2;
                long currentTimeMillis5 = System.currentTimeMillis();
                jArr[3] = currentTimeMillis5 - currentTimeMillis4;
                long currentTimeMillis6 = System.currentTimeMillis();
                jArr[4] = currentTimeMillis6 - currentTimeMillis5;
                T t = null;
                if (privacyControlConfig.b && this.d) {
                    e<T> eVar2 = this.f;
                    if (eVar2 != null) {
                        z2 = eVar2.a();
                    }
                    if (!z2) {
                        jArr[5] = System.currentTimeMillis() - currentTimeMillis6;
                        e<T> eVar3 = this.f;
                        if (eVar3 != null) {
                            return eVar3.b();
                        }
                        return t;
                    }
                }
                long currentTimeMillis7 = System.currentTimeMillis();
                jArr[5] = currentTimeMillis7 - currentTimeMillis6;
                long currentTimeMillis8 = System.currentTimeMillis();
                jArr[6] = currentTimeMillis8 - currentTimeMillis7;
                try {
                    t = this.e.invokeOriginMethod();
                    return t;
                } finally {
                    long currentTimeMillis9 = System.currentTimeMillis();
                    jArr[7] = currentTimeMillis9 - currentTimeMillis8;
                    if (privacyControlConfig.b && this.d && (eVar = this.f) != null) {
                        eVar.a(t);
                    }
                    jArr[8] = System.currentTimeMillis() - currentTimeMillis9;
                }
            }
        }
    }
}
