package cn.com.chinatelecom.gateway.lib;

import android.content.Context;
import android.text.TextUtils;
import com.dlife.ctaccountapi.e;
import com.dlife.ctaccountapi.f;
import com.dlife.ctaccountapi.n;
import org.json.JSONObject;

public final class CtAuth {
    public static final String a = "CtAuth";
    public static int mConnTimeoutL;
    public static int mReadTimeout;
    public static int mTotalTimeout;
    public static TraceLogger mTraceLogger;

    public static void a(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        String str4;
        if (preCodeListener == null) {
            mTraceLogger = null;
            return;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str4 = "{\"result\":80106,\"msg\":\"请求参数异常\"}";
        } else if (!n.k(context)) {
            str4 = "{\"result\":80003,\"msg\":\"网络无连接\"}";
        } else if (n.j(context)) {
            new f().a(context, str, str2, str3, preCodeListener);
            return;
        } else if (n.i(context)) {
            new f().b(context, str, str2, str3, preCodeListener);
            return;
        } else {
            preCodeListener.onResult("{\"result\":80004,\"msg\":\"移动网络未开启\"}");
            mTraceLogger = null;
            return;
        }
        preCodeListener.onResult(str4);
        mTraceLogger = null;
    }

    public static void info(String str, String str2) {
        if (mTraceLogger != null) {
            try {
                mTraceLogger.info("CT_" + str, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(int i2, int i3, int i4, TraceLogger traceLogger) {
        mConnTimeoutL = i2;
        mReadTimeout = i3;
        mTotalTimeout = i4;
        mTraceLogger = traceLogger;
    }

    public static void postResult(Context context, String str, String str2, PreCodeListener preCodeListener) {
        if (preCodeListener != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("reqId", str2);
                preCodeListener.onResult(jSONObject.toString());
                String str3 = a;
                info(str3, "callback result : " + jSONObject.toString());
            } catch (Exception unused) {
                preCodeListener.onResult(str);
                String str4 = a;
                info(str4, "Exception callback result : " + str);
            }
            mTraceLogger = null;
            e.b(context, str2);
        }
    }

    public static void requestPreAuth(Context context, String str, String str2, PreCodeListener preCodeListener) {
        String str3 = a;
        info(str3, "called requestPreAuth()   appId：" + str + ",appSecret:" + str2);
        a(context, str, str2, "mhqh", preCodeListener);
    }

    public static void requestPreAuthCode(Context context, String str, String str2, PreCodeListener preCodeListener) {
        String str3 = a;
        info(str3, "called requestPreAuthCode()   appId：" + str + ",appSecret:" + str2);
        a(context, str, str2, "qhx", preCodeListener);
    }

    public static void warn(String str, String str2, Throwable th2) {
        if (mTraceLogger != null) {
            try {
                mTraceLogger.warn("CT_" + str, str2, th2);
            } catch (Throwable unused) {
            }
        }
    }
}
