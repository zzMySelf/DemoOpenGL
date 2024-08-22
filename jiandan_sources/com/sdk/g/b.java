package com.sdk.g;

import android.content.Context;
import com.dlife.ctaccountapi.l;
import com.sdk.a.e;
import com.sdk.a.f;
import com.sdk.a.g;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.bean.MobileKInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.module.config.BaseConfig;
import com.sdk.d.j;
import com.sdk.e.a;
import com.sdk.f.c;
import com.sdk.f.f;
import com.sdk.p.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.Executor;

public class b<T> {
    public static final String a = "com.sdk.g.b";
    public static final boolean b = f.a;
    public PInfo c;
    public AInfo d;
    public SInfo e;
    public ArrayList<KInfo> f;
    public a<T> g;
    public Context h;

    /* renamed from: i  reason: collision with root package name */
    public String f6817i;
    public c j;

    public b(Context context, a<T> aVar, c cVar) {
        this.h = context;
        this.g = aVar;
        this.j = cVar;
    }

    public final String a(DataInfo dataInfo, String str, String str2) {
        String str3;
        try {
            if (this.d == null) {
                this.d = com.sdk.f.a.a(this.h);
            }
            if (this.e == null) {
                this.e = com.sdk.f.a.c();
            }
            if (this.f == null) {
                this.f = com.sdk.f.a.a();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<KInfo> it = this.f.iterator();
            while (it.hasNext()) {
                KInfo next = it.next();
                MobileKInfo mobileKInfo = new MobileKInfo();
                mobileKInfo.setIe(next.getIe());
                mobileKInfo.setIs(next.getIs());
                mobileKInfo.setM(next.getM());
                mobileKInfo.setIdfd(next.isIdfd());
                arrayList.add(mobileKInfo);
            }
            if (this.c == null) {
                this.c = com.sdk.f.a.b();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("{app:");
            sb.append(this.d);
            sb.append(",sdk:");
            sb.append(this.e);
            sb.append(",device:");
            sb.append(this.c);
            sb.append(",sim:");
            sb.append(arrayList);
            sb.append(",data:");
            sb.append(dataInfo);
            sb.append("}");
            str3 = sb.toString();
        } catch (Exception e2) {
            com.sdk.o.a.a(a, e2.toString(), Boolean.valueOf(b));
            str3 = null;
        }
        return com.sdk.r.f.a().b.a(str, str2, str3);
    }

    public void a(int i2, int i3, String str) {
        a<T> aVar = this.g;
        if (aVar != null) {
            aVar.a(i2, i3, str);
            this.g = null;
        }
    }

    public void a(int i2, String str, int i3, T t, String str2) {
        a<T> aVar = this.g;
        if (aVar != null) {
            aVar.onSuccess(i2, str, i3, t, str2);
            this.g = null;
        }
    }

    public e<T> a(String str, String str2, DataInfo dataInfo, com.sdk.e.b<T> bVar, int i2, f.a aVar) {
        DataInfo dataInfo2;
        boolean z;
        String str3 = str2;
        e<T> eVar = null;
        if (com.sdk.o.a.a(str).booleanValue()) {
            a(1, 101008, "未检测到域名");
            return null;
        }
        if (dataInfo == null) {
            try {
                dataInfo2 = new DataInfo();
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            dataInfo2 = dataInfo;
        }
        TreeMap<String, Object> treeMap = new TreeMap<>();
        String a2 = com.sdk.r.a.a(16);
        String a3 = com.sdk.r.a.a(16);
        String a4 = com.sdk.j.a.a(this.h, BaseConfig.apk);
        int i3 = 2;
        String[] strArr = {a4, com.sdk.v.a.b};
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                z = false;
                break;
            }
            String str4 = strArr[i4];
            if ((str4 == null || str4.length() < 1) && com.sdk.o.a.a(str4).booleanValue()) {
                z = true;
                break;
            }
            i4++;
            i3 = 2;
        }
        if (z) {
            a(1, 101004, "ApiKey或PublicKey不能为空");
            return null;
        }
        String a5 = a(dataInfo2, a2, a3);
        try {
            com.sdk.r.f a6 = com.sdk.r.f.a();
            String a7 = a6.b.a(a6.c, a2 + a3);
            treeMap.put("apiKey", a4);
            treeMap.put("params", a5);
            treeMap.put("paramsKey", a7);
            treeMap.put(l.a, Long.valueOf(System.currentTimeMillis()));
            String a8 = com.sdk.t.a.a(a4, str3, treeMap);
            HashMap<String, Object> hashMap = new HashMap<>(16);
            if (com.sdk.o.a.b(a8).booleanValue()) {
                treeMap.put("sign", a8);
                treeMap.put("sign_Type", com.sdk.v.a.e);
                hashMap.put("sign", a8);
                hashMap.put("api-protocol", "1.1");
            }
            g gVar = new g();
            gVar.a(aVar.l);
            gVar.b(str + str3);
            gVar.j = bVar;
            gVar.f6813i = i2;
            gVar.f = treeMap;
            gVar.g = null;
            gVar.h = hashMap;
            if ("/dro/netm/v1.0/qc".equals(str3)) {
                f.b bVar2 = f.b.b;
            }
            Params fVar = new com.sdk.a.f(this.h, gVar);
            e<T> eVar2 = new e<>(fVar);
            try {
                Params[] paramsArr = {fVar};
                Executor executor = com.sdk.d.e.b;
                if (!eVar2.g) {
                    eVar2.g = true;
                    eVar2.c.a = paramsArr;
                    executor.execute(new j(eVar2.f6816i, eVar2.d));
                    return eVar2;
                }
                throw new IllegalStateException("Cannot execute task: the task is already executed.");
            } catch (Exception e3) {
                e = e3;
                eVar = eVar2;
                com.sdk.o.b.c(e.toString());
                a(1, 302002, "网络访问异常:" + e.getMessage());
                com.sdk.o.a.a(a + "BaseProtocol sendRequest", e.toString() + "，" + e.getMessage(), Boolean.valueOf(b));
                return eVar;
            }
        } catch (Exception e4) {
            a(1, 101006, "公钥出错");
            String str5 = a;
            StringBuilder sb = new StringBuilder();
            sb.append("公钥出错：");
            sb.append(e4);
            com.sdk.o.a.a(str5, sb.toString(), Boolean.valueOf(b));
            return null;
        }
    }
}
