package com.baidu.ar.statistic;

import com.baidu.ar.p.m;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class a implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f10366c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static a f10367d = null;

    /* renamed from: e  reason: collision with root package name */
    private static int f10368e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f10369f = false;

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f10370a = new JSONObject();

    /* renamed from: b  reason: collision with root package name */
    private a f10371b = null;

    private a(String str) {
        h(str);
        a(System.currentTimeMillis());
    }

    public static void a(a aVar) {
        if (!f10369f) {
            synchronized (f10366c) {
                aVar.f();
            }
        }
    }

    public static void a(a... aVarArr) {
        if (!f10369f) {
            synchronized (f10366c) {
                if (aVarArr != null) {
                    for (a f2 : aVarArr) {
                        f2.f();
                    }
                }
            }
        }
    }

    public static a b(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str.trim());
                a f2 = f(jSONObject.getString(IntentData.KEY_EVENT_ID));
                f2.f10370a = jSONObject;
                return f2;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String b(a aVar) {
        JSONObject jSONObject;
        if (aVar == null || (jSONObject = aVar.f10370a) == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public static a f(String str) {
        if (!f10369f) {
            synchronized (f10366c) {
                a aVar = f10367d;
                if (aVar != null) {
                    f10367d = aVar.f10371b;
                    aVar.f10371b = null;
                    f10368e--;
                    if (aVar.f10370a == null) {
                        aVar.f10370a = new JSONObject();
                    }
                    aVar.h(str);
                    aVar.a(System.currentTimeMillis());
                    return aVar;
                }
            }
        }
        return new a(str);
    }

    private void f() {
        this.f10370a = null;
        int i2 = f10368e;
        if (i2 < 500) {
            this.f10371b = f10367d;
            f10367d = this;
            f10368e = i2 + 1;
        }
    }

    public static void g() {
        if (!f10369f) {
            synchronized (f10366c) {
                f10369f = true;
                f10367d = null;
                f10368e = 0;
            }
        }
    }

    /* renamed from: a */
    public a clone() {
        a f2 = f("");
        try {
            f2.f10370a = new JSONObject(this.f10370a.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return f2;
    }

    public JSONObject a(Collection<String> collection) {
        return a((JSONObject) null, collection);
    }

    public JSONObject a(JSONObject jSONObject, Collection<String> collection) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            Iterator<String> keys = this.f10370a.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (collection == null || !collection.contains(next)) {
                    jSONObject.put(next, this.f10370a.get(next));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(long j2) {
        try {
            this.f10370a.putOpt("time", Long.valueOf(j2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, Object obj) {
        try {
            this.f10370a.putOpt(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                for (Map.Entry next : map.entrySet()) {
                    this.f10370a.putOpt((String) next.getKey(), next.getValue());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean a(String str) {
        return this.f10370a.has(str);
    }

    public String b() {
        return this.f10370a.optString(IntentData.KEY_EVENT_ID);
    }

    public long c() {
        return this.f10370a.optLong("time");
    }

    public Object c(String str) {
        return this.f10370a.opt(str);
    }

    public long d(String str) {
        Object c2 = c(str);
        if (c2 instanceof Number) {
            return ((Number) c2).longValue();
        }
        return 0;
    }

    public String d() {
        String b2 = b(this);
        if (b2 == null) {
            return null;
        }
        return m.a(b2);
    }

    public String e(String str) {
        return this.f10370a.optString(str);
    }

    public Iterator<String> e() {
        return this.f10370a.keys();
    }

    public void g(String str) {
        this.f10370a.remove(str);
    }

    public JSONObject h() {
        return a((JSONObject) null, (Collection<String>) null);
    }

    public void h(String str) {
        try {
            this.f10370a.putOpt(IntentData.KEY_EVENT_ID, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
