package com.baidu.android.pushservice.r;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.d0.c;
import com.baidu.android.pushservice.e0.i;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.s.b;
import com.baidu.android.pushservice.util.Utility;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class j extends c {

    /* renamed from: c  reason: collision with root package name */
    public Context f8733c;

    /* renamed from: d  reason: collision with root package name */
    public a f8734d;

    /* renamed from: e  reason: collision with root package name */
    public String f8735e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f8736f;

    public interface a {
        void a(int i2, List<String> list);
    }

    public j(Context context, String str, a aVar) {
        ArrayList arrayList = new ArrayList();
        this.f8736f = arrayList;
        this.f8733c = context;
        this.f8735e = str;
        this.f8734d = aVar;
        arrayList.clear();
        a("PushService-PushService-HTTPDNS");
        a(100);
    }

    public void a() {
        c();
    }

    public void c() {
        InputStream inputStream;
        String string;
        InputStream inputStream2 = null;
        try {
            String str = "https://180.76.76.112/v6/0025?type=ipv4,ipv6&dn=" + this.f8735e;
            if (!PushSocket.isIPv4Reachable()) {
                str = "https://[240c:4006::6666]/v6/0025?type=ipv4,ipv6&dn=" + this.f8735e;
            }
            b b2 = com.baidu.android.pushservice.s.c.b(this.f8733c, str, "GET", (HashMap<String, String>) null, (String) null, "httpsdns.baidu.com");
            int a2 = b2.a();
            inputStream = b2.b();
            if (a2 == 200) {
                try {
                    String a3 = Utility.a(this.f8733c, inputStream);
                    if (!TextUtils.isEmpty(a3)) {
                        try {
                            JSONObject jSONObject = new JSONObject(a3).getJSONObject("data").getJSONObject(this.f8735e);
                            JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                            JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6");
                            int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
                            int length2 = optJSONArray == null ? 0 : optJSONArray.length();
                            if (length2 + length > 0) {
                                int a4 = i.a(this.f8733c, "key_vip_type", 3);
                                if (a4 != 1) {
                                    if (a4 == 2) {
                                        if (optJSONArray2 != null && length > 0) {
                                            this.f8736f.add(optJSONArray2.getString(0));
                                        }
                                        if (optJSONArray != null && length2 > 0) {
                                            string = optJSONArray.getString(0);
                                        }
                                    } else if (a4 != 4) {
                                        if (optJSONArray != null && length2 > 0) {
                                            this.f8736f.add(optJSONArray.getString(0));
                                        }
                                        if (optJSONArray2 != null && length > 0) {
                                            string = optJSONArray2.getString(0);
                                        }
                                    } else if (optJSONArray != null && length2 > 0) {
                                        string = optJSONArray.getString(0);
                                    }
                                } else if (optJSONArray2 != null && length > 0) {
                                    string = optJSONArray2.getString(0);
                                }
                                this.f8736f.add(string);
                            }
                        } catch (Exception e2) {
                        }
                    }
                    this.f8734d.a(0, this.f8736f);
                } catch (Exception e3) {
                    try {
                        this.f8734d.a(-1, (List<String>) null);
                        com.baidu.android.pushservice.s.c.a(this.f8733c, inputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        com.baidu.android.pushservice.s.c.a(this.f8733c, inputStream2);
                        throw th;
                    }
                }
            } else {
                Utility.a(this.f8733c, inputStream);
                this.f8734d.a(-1, (List<String>) null);
            }
            com.baidu.android.pushservice.s.c.a(this.f8733c, inputStream);
        } catch (Exception e4) {
            inputStream = null;
            this.f8734d.a(-1, (List<String>) null);
            com.baidu.android.pushservice.s.c.a(this.f8733c, inputStream);
        } catch (Throwable th3) {
            th = th3;
            com.baidu.android.pushservice.s.c.a(this.f8733c, inputStream2);
            throw th;
        }
    }
}
