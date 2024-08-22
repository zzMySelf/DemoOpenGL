package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;

public class iu implements jx<iu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final kf f7249a = new kf("", (byte) 10, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final kn f573a = new kn("DataCollectionItem");

    /* renamed from: b  reason: collision with root package name */
    private static final kf f7250b = new kf("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final kf f7251c = new kf("", Constants.GZIP_CAST_TYPE, 3);

    /* renamed from: a  reason: collision with other field name */
    public long f574a;

    /* renamed from: a  reason: collision with other field name */
    public io f575a;

    /* renamed from: a  reason: collision with other field name */
    public String f576a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f577a = new BitSet(1);

    public iu a(long j2) {
        this.f574a = j2;
        a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8642a() {
        return this.f577a.get(0);
    }

    public void a(boolean z) {
        this.f577a.set(0, z);
    }

    public iu a(io ioVar) {
        this.f575a = ioVar;
        return this;
    }

    public boolean b() {
        return this.f575a != null;
    }

    public String a() {
        return this.f576a;
    }

    public iu a(String str) {
        this.f576a = str;
        return this;
    }

    public boolean c() {
        return this.f576a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iu)) {
            return compareTo((iu) obj);
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8643a(iu iuVar) {
        if (iuVar == null || this.f574a != iuVar.f574a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iuVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f575a.equals(iuVar.f575a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iuVar.c();
        if (!c2 && !c3) {
            return true;
        }
        if (!c2 || !c3 || !this.f576a.equals(iuVar.f576a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public int compareTo(iu iuVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(iuVar.getClass())) {
            return getClass().getName().compareTo(iuVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(iuVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a4 = jy.a(this.f574a, iuVar.f574a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iuVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = jy.a((Comparable) this.f575a, (Comparable) iuVar.f575a)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iuVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = jy.a(this.f576a, iuVar.f576a)) == 0) {
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
                if (a()) {
                    a();
                    return;
                }
                throw new kj("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
            }
            switch (a2.f886a) {
                case 1:
                    if (a2.f7470a != 10) {
                        kl.a(kiVar, a2.f7470a);
                        break;
                    } else {
                        this.f574a = kiVar.a();
                        a(true);
                        break;
                    }
                case 2:
                    if (a2.f7470a != 8) {
                        kl.a(kiVar, a2.f7470a);
                        break;
                    } else {
                        this.f575a = io.a(kiVar.a());
                        break;
                    }
                case 3:
                    if (a2.f7470a != 11) {
                        kl.a(kiVar, a2.f7470a);
                        break;
                    } else {
                        this.f576a = kiVar.a();
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
        kiVar.a(f573a);
        kiVar.a(f7249a);
        kiVar.a(this.f574a);
        kiVar.b();
        if (this.f575a != null) {
            kiVar.a(f7250b);
            kiVar.a(this.f575a.a());
            kiVar.b();
        }
        if (this.f576a != null) {
            kiVar.a(f7251c);
            kiVar.a(this.f576a);
            kiVar.b();
        }
        kiVar.c();
        kiVar.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f574a);
        sb.append(", ");
        sb.append("collectionType:");
        io ioVar = this.f575a;
        if (ioVar == null) {
            sb.append("null");
        } else {
            sb.append(ioVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f576a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8641a() {
        if (this.f575a == null) {
            throw new kj("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f576a == null) {
            throw new kj("Required field 'content' was not present! Struct: " + toString());
        }
    }
}
