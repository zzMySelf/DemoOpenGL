package com.dlife.ctaccountapi;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.net.URLEncoder;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
    public static final byte[] a = {Ascii.SI, Ascii.US, 94, 10, 90, Ascii.SI, 91, Ascii.CAN, 10, Ascii.RS, 88, 7, 89, 10, 95, Ascii.RS};

    public static class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;

        public a(Context context, List list, int i2) {
            this.a = context;
            this.b = list;
            this.c = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0034 A[ADDED_TO_REGION, Catch:{ all -> 0x0047 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                android.content.Context r0 = r5.a     // Catch:{ all -> 0x0047 }
                java.util.List r1 = r5.b     // Catch:{ all -> 0x0047 }
                int r2 = r5.c     // Catch:{ all -> 0x0047 }
                java.util.Queue r0 = com.dlife.ctaccountapi.d.c(r0, r1, r2)     // Catch:{ all -> 0x0047 }
                boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0047 }
                if (r1 != 0) goto L_0x004b
                android.content.Context r1 = r5.a     // Catch:{ all -> 0x0047 }
                java.lang.String r1 = com.dlife.ctaccountapi.d.b((android.content.Context) r1, (java.util.Queue<java.lang.String>) r0)     // Catch:{ all -> 0x0047 }
                r2 = 0
                r3 = -1
                boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x002e }
                if (r4 != 0) goto L_0x0032
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x002e }
                r4.<init>(r1)     // Catch:{ Exception -> 0x002e }
                java.lang.String r1 = "code"
                int r3 = r4.getInt(r1)     // Catch:{ Exception -> 0x002b }
                r2 = r4
                goto L_0x0032
            L_0x002b:
                r1 = move-exception
                r2 = r4
                goto L_0x002f
            L_0x002e:
                r1 = move-exception
            L_0x002f:
                r1.printStackTrace()     // Catch:{ all -> 0x0047 }
            L_0x0032:
                if (r2 == 0) goto L_0x003f
                if (r3 != 0) goto L_0x003f
                android.content.Context r1 = r5.a     // Catch:{ all -> 0x0047 }
                com.dlife.ctaccountapi.d.b(r1)     // Catch:{ all -> 0x0047 }
                r0.clear()     // Catch:{ all -> 0x0047 }
                goto L_0x004b
            L_0x003f:
                android.content.Context r1 = r5.a     // Catch:{ all -> 0x0047 }
                int r2 = r5.c     // Catch:{ all -> 0x0047 }
                com.dlife.ctaccountapi.d.b((android.content.Context) r1, (java.util.Queue<java.lang.String>) r0, (int) r2)     // Catch:{ all -> 0x0047 }
                goto L_0x004b
            L_0x0047:
                r0 = move-exception
                r0.printStackTrace()
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dlife.ctaccountapi.d.a.run():void");
        }
    }

    public static String a(Context context, String str) {
        return a.a(context, "https://api-e189.21cn.com/gw/client/accountMsg.do", str);
    }

    public static void a(Context context, int i2) {
        try {
            h.b(context, "key_c_l_l_v", i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, List<String> list) {
        int c = c(context);
        if (c != -2) {
            b(context, list, c);
        }
    }

    public static String b(Context context, Queue<String> queue) {
        JSONArray jSONArray = new JSONArray();
        String jSONArray2 = jSONArray.toString();
        if (!queue.isEmpty()) {
            for (String jSONObject : queue) {
                try {
                    jSONArray.put(new JSONObject(jSONObject));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (jSONArray.length() <= 0) {
            return "";
        }
        String jSONArray3 = jSONArray.toString();
        if (!TextUtils.isEmpty(jSONArray3)) {
            try {
                jSONArray2 = URLEncoder.encode(g.a(j.c(jSONArray3, s.a(a)).getBytes()), "UTF-8");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return a(context, jSONArray2);
    }

    public static void b(Context context) {
        c.a(context, "");
    }

    public static void b(Context context, String str) {
        str.hashCode();
        a(context, !str.equals("ERROR") ? !str.equals("OFF") ? 0 : -2 : -1);
    }

    public static void b(Context context, List<String> list, int i2) {
        r.a().a(new a(context, list, i2));
    }

    public static void b(Context context, Queue<String> queue, int i2) {
        String str;
        JSONArray jSONArray = new JSONArray();
        if (queue != null && !queue.isEmpty()) {
            int i3 = 0;
            for (String jSONObject : queue) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject);
                    if (i2 != -1 || jSONObject2.getInt("rt") != 0) {
                        jSONArray.put(jSONObject2);
                        i3++;
                        if (i3 > 10) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (jSONArray.length() > 0) {
            try {
                str = j.c(jSONArray.toString(), s.a(a));
            } catch (Exception e2) {
                e2.printStackTrace();
                str = null;
            }
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            c.a(context, str);
        }
    }

    public static int c(Context context) {
        try {
            return h.a(context, "key_c_l_l_v", 0);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public static synchronized Queue<String> c(Context context, List<String> list, int i2) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        synchronized (d.class) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            String c = c.c(context);
            if (!TextUtils.isEmpty(c)) {
                try {
                    JSONArray jSONArray = new JSONArray(j.c(c, s.a(a)));
                    int i3 = 0;
                    int length = jSONArray.length();
                    while (i3 < length && i3 <= 10) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        if (jSONObject != null) {
                            concurrentLinkedQueue.add(jSONObject.toString());
                        }
                        i3++;
                    }
                    c.a(context, "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i2 == -1) {
                for (String next : list) {
                    try {
                        if (new JSONObject(next).getInt("rt") != 0) {
                            concurrentLinkedQueue.add(next);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (i2 == 0) {
                concurrentLinkedQueue.addAll(list);
            }
            while (concurrentLinkedQueue.size() > 10) {
                concurrentLinkedQueue.poll();
            }
        }
        return concurrentLinkedQueue;
    }
}
