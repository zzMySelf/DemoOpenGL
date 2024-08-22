package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class jf implements jx<jf, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final kf f7325a = new kf("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final kn f678a = new kn("XmPushActionCollectData");

    /* renamed from: a  reason: collision with other field name */
    public List<iu> f679a;

    public jf a(List<iu> list) {
        this.f679a = list;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8696a() {
        return this.f679a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof jf)) {
            return compareTo((jf) obj);
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8697a(jf jfVar) {
        if (jfVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = jfVar.a();
        if (!a2 && !a3) {
            return true;
        }
        if (!a2 || !a3 || !this.f679a.equals(jfVar.f679a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public int compareTo(jf jfVar) {
        int a2;
        if (!getClass().equals(jfVar.getClass())) {
            return getClass().getName().compareTo(jfVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(jfVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!a() || (a2 = jy.a((List) this.f679a, (List) jfVar.f679a)) == 0) {
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
                    if (a2.f7470a != 15) {
                        kl.a(kiVar, a2.f7470a);
                        break;
                    } else {
                        kg a3 = kiVar.a();
                        this.f679a = new ArrayList(a3.f887a);
                        for (int i2 = 0; i2 < a3.f887a; i2++) {
                            iu iuVar = new iu();
                            iuVar.a(kiVar);
                            this.f679a.add(iuVar);
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
        kiVar.a(f678a);
        if (this.f679a != null) {
            kiVar.a(f7325a);
            kiVar.a(new kg((byte) 12, this.f679a.size()));
            for (iu b2 : this.f679a) {
                b2.b(kiVar);
            }
            kiVar.e();
            kiVar.b();
        }
        kiVar.c();
        kiVar.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<iu> list = this.f679a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a() {
        if (this.f679a == null) {
            throw new kj("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }
}
