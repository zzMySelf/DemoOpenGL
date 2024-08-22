package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public class hp extends hr {

    /* renamed from: a  reason: collision with root package name */
    private a f7119a = a.f7120a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, String> f510a = new HashMap();

    public hp() {
    }

    public hp(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.f7119a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public synchronized void a(Map<String, String> map) {
        this.f510a.putAll(map);
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m8597a() {
        return this.f7119a;
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.f7119a = a.f7120a;
        } else {
            this.f7119a = aVar;
        }
    }

    public Bundle a() {
        Bundle a2 = super.a();
        a aVar = this.f7119a;
        if (aVar != null) {
            a2.putString("ext_iq_type", aVar.toString());
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8598a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"").append(ic.a(l())).append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"").append(ic.a(m())).append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"").append(ic.a(k())).append("\" ");
        }
        for (Map.Entry next : this.f510a.entrySet()) {
            sb.append(ic.a((String) next.getKey())).append("=\"");
            sb.append(ic.a((String) next.getValue())).append("\" ");
        }
        if (this.f7119a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"").append(a()).append("\">");
        }
        String b2 = b();
        if (b2 != null) {
            sb.append(b2);
        }
        sb.append(o());
        hv a2 = a();
        if (a2 != null) {
            sb.append(a2.a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public String b() {
        return null;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f7120a = new a("get");

        /* renamed from: b  reason: collision with root package name */
        public static final a f7121b = new a("set");

        /* renamed from: c  reason: collision with root package name */
        public static final a f7122c = new a("result");

        /* renamed from: d  reason: collision with root package name */
        public static final a f7123d = new a("error");

        /* renamed from: e  reason: collision with root package name */
        public static final a f7124e = new a("command");

        /* renamed from: a  reason: collision with other field name */
        private String f511a;

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = f7120a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = f7121b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = f7123d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = f7122c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = f7124e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        private a(String str) {
            this.f511a = str;
        }

        public String toString() {
            return this.f511a;
        }
    }
}
