package com.baidu.ar.statistic;

import android.content.Context;
import android.os.HandlerThread;
import com.baidu.ar.p.b;
import com.baidu.ar.p.o;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.json.JSONObject;

public final class StatisticApi {

    /* renamed from: a  reason: collision with root package name */
    private static g f10358a;

    /* renamed from: b  reason: collision with root package name */
    private static f f10359b;

    public static f getPerformanceApi() {
        if (f10359b == null) {
            f10359b = new o();
        }
        return f10359b;
    }

    public static void init(Context context) {
        if (f10358a == null) {
            try {
                Constructor<?> a2 = o.a("com.baidu.ar.statistic.StatisticApiImpl", (Class<?>[]) new Class[]{Context.class, HandlerThread.class});
                if (a2 != null) {
                    f10358a = (g) o.a(a2, context, null);
                }
            } catch (Throwable th2) {
                f10358a = null;
                b.b("Statistic init fail");
                th2.printStackTrace();
            }
        }
        if (f10359b == null) {
            f10359b = new o();
        }
    }

    public static boolean isAllowPerformanceEvent(String str) {
        g gVar = f10358a;
        if (gVar != null) {
            return gVar.isAllowPerformanceEvent(str);
        }
        return true;
    }

    public static void onEvent(String str) {
        onEvent(str, "");
    }

    public static void onEvent(String str, String str2) {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.onEvent(str, str2);
        }
    }

    public static void onEvent(String str, Map<String, String> map) {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.onEvent(str, map);
        }
    }

    public static void onEventDebounce(String str, long j2, String str2) {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.onEventDebounce(str, j2, str2);
        }
    }

    public static void onEventDebounce(String str, long j2, Map<String, String> map) {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.onEventDebounce(str, j2, map);
        }
    }

    public static void onEventEnd(String str) {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.onEventEnd(str);
        }
    }

    public static void onEventStart(String str) {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.onEventStart(str);
        }
    }

    public static void onEventStatus(String str, String str2, boolean z) {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.onEventStatus(str, str2, z);
        }
    }

    public static void onPerformance(String str, Map<String, String> map) {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.onPerformance(str, map);
        }
    }

    public static void onPerformance(String str, JSONObject jSONObject) {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.onPerformance(str, jSONObject);
        }
    }

    public static void pause() {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.pause();
        }
    }

    public static void release() {
        f10359b = null;
        g gVar = f10358a;
        if (gVar != null) {
            gVar.release();
            f10358a = null;
        }
    }

    public static void resume() {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.resume();
        }
    }

    public static void setPubParam(String str, String str2) {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.setPubParam(str, str2);
        }
    }

    public static void setPubParams(Map<String, String> map) {
        g gVar = f10358a;
        if (gVar != null) {
            gVar.setPubParams(map);
        }
    }
}
