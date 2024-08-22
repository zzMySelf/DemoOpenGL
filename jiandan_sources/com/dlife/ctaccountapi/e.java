package com.dlife.ctaccountapi;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class e {
    public static int a;
    public static Map<String, b> b = new HashMap();
    public static List<String> c = new ArrayList();

    public static class a extends TimerTask {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        public void run() {
            e.b(this.a);
        }
    }

    public static synchronized b a(String str) {
        b bVar;
        synchronized (e.class) {
            try {
                bVar = b.containsKey(str) ? b.get(str) : null;
                if (bVar == null) {
                    bVar = new b(str);
                    b.put(str, bVar);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return new b(str);
            }
        }
        return bVar;
    }

    public static void a(Context context, String str) {
        d.b(context, str);
    }

    public static void a(String str, String str2, String str3) {
        String str4 = "";
        int i2 = -1;
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                i2 = jSONObject.getInt("result");
                str4 = jSONObject.optString("msg");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        b a2 = a(str).a(i2);
        if (i2 == 0) {
            a2.f(str4);
        } else {
            a2.f(str4).i(str3);
        }
    }

    public static void b(Context context) {
        if (context != null) {
            try {
                ArrayList arrayList = new ArrayList();
                synchronized (e.class) {
                    arrayList.addAll(c);
                    a = 0;
                    c.clear();
                }
                if (!arrayList.isEmpty()) {
                    d.a(context, (List<String>) arrayList);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void b(Context context, String str) {
        try {
            synchronized (e.class) {
                if (b.containsKey(str)) {
                    c.add(b.get(str).toString());
                    b.remove(str);
                }
                if (a != 1) {
                    if (!c.isEmpty()) {
                        a = 1;
                        new Timer().schedule(new a(context), 8000);
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
