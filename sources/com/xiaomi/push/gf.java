package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class gf implements jx<gf, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final kf f7051a = new kf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final kn f426a = new kn("StatsEvents");

    /* renamed from: b  reason: collision with root package name */
    private static final kf f7052b = new kf("", Constants.GZIP_CAST_TYPE, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final kf f7053c = new kf("", (byte) 15, 3);

    /* renamed from: a  reason: collision with other field name */
    public String f427a;

    /* renamed from: a  reason: collision with other field name */
    public List<ge> f428a;

    /* renamed from: b  reason: collision with other field name */
    public String f429b;

    public gf() {
    }

    public gf(String str, List<ge> list) {
        this();
        this.f427a = str;
        this.f428a = list;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8543a() {
        return this.f427a != null;
    }

    public gf a(String str) {
        this.f429b = str;
        return this;
    }

    public boolean b() {
        return this.f429b != null;
    }

    public boolean c() {
        return this.f428a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gf)) {
            return compareTo((gf) obj);
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8544a(gf gfVar) {
        if (gfVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = gfVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f427a.equals(gfVar.f427a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gfVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f429b.equals(gfVar.f429b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gfVar.c();
        if (!c2 && !c3) {
            return true;
        }
        if (!c2 || !c3 || !this.f428a.equals(gfVar.f428a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public int compareTo(gf gfVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(gfVar.getClass())) {
            return getClass().getName().compareTo(gfVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gfVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a4 = jy.a(this.f427a, gfVar.f427a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gfVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = jy.a(this.f429b, gfVar.f429b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gfVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = jy.a((List) this.f428a, (List) gfVar.f428a)) == 0) {
            return 0;
        }
        return a2;
    }

    public void a(ki kiVar) {
        kiVar.a();
        while (true) {
            kf a2 = kiVar.a();
            if (a2.f7470a == 0) {
                kiVar.f();
                a();
                return;
            }
            switch (a2.f886a) {
                case 1:
                    if (a2.f7470a != 11) {
                        kl.a(kiVar, a2.f7470a);
                        break;
                    } else {
                        this.f427a = kiVar.a();
                        break;
                    }
                case 2:
                    if (a2.f7470a != 11) {
                        kl.a(kiVar, a2.f7470a);
                        break;
                    } else {
                        this.f429b = kiVar.a();
                        break;
                    }
                case 3:
                    if (a2.f7470a != 15) {
                        kl.a(kiVar, a2.f7470a);
                        break;
                    } else {
                        kg a3 = kiVar.a();
                        this.f428a = new ArrayList(a3.f887a);
                        for (int i2 = 0; i2 < a3.f887a; i2++) {
                            ge geVar = new ge();
                            geVar.a(kiVar);
                            this.f428a.add(geVar);
                        }
                        kiVar.i();
                        break;
                    }
                default:
                    kl.a(kiVar, a2.f7470a);
                    break;
            }
            kiVar.g();
        }
    }

    public void b(ki kiVar) {
        a();
        kiVar.a(f426a);
        if (this.f427a != null) {
            kiVar.a(f7051a);
            kiVar.a(this.f427a);
            kiVar.b();
        }
        if (this.f429b != null && b()) {
            kiVar.a(f7052b);
            kiVar.a(this.f429b);
            kiVar.b();
        }
        if (this.f428a != null) {
            kiVar.a(f7053c);
            kiVar.a(new kg((byte) 12, this.f428a.size()));
            for (ge b2 : this.f428a) {
                b2.b(kiVar);
            }
            kiVar.e();
            kiVar.b();
        }
        kiVar.c();
        kiVar.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f427a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f429b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<ge> list = this.f428a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a() {
        if (this.f427a == null) {
            throw new kj("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f428a == null) {
            throw new kj("Required field 'events' was not present! Struct: " + toString());
        }
    }
}
