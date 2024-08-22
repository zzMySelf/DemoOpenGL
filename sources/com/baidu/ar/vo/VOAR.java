package com.baidu.ar.vo;

import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.imu.g;
import com.baidu.ar.imu.i;
import com.baidu.ar.k.k;
import com.baidu.ar.k.l;
import com.baidu.ar.p.t;
import com.baidu.ar.vo.d.d;
import com.baidu.searchbox.home.tabs.constants.HomeTabConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VOAR extends com.baidu.ar.c {
    private com.baidu.ar.vo.d.c A;
    /* access modifiers changed from: private */
    public b B;
    private com.baidu.ar.lua.c C;
    private g D;
    /* access modifiers changed from: private */
    public com.baidu.ar.imu.f E;
    private com.baidu.ar.vo.c.b x;
    private com.baidu.ar.vo.d.e y;
    private com.baidu.ar.k.e z;

    class a implements com.baidu.ar.k.e {

        /* renamed from: a  reason: collision with root package name */
        private int f10519a = 0;

        a() {
        }

        public void a(com.baidu.ar.k.b bVar) {
            if (VOAR.this.B != null && bVar != null && (bVar instanceof com.baidu.ar.vo.d.f)) {
                int i2 = this.f10519a;
                if (i2 >= 3) {
                    VOAR.this.B.a((com.baidu.ar.vo.d.f) bVar, VOAR.this.m());
                    return;
                }
                this.f10519a = i2 + 1;
            }
        }

        public void a(l lVar) {
        }

        public void b(l lVar) {
            this.f10519a = 0;
        }
    }

    class b implements d.a {
        b() {
        }

        public float a() {
            return VOAR.this.l();
        }

        public float[] b() {
            return VOAR.this.m();
        }
    }

    class c implements a {
        c() {
        }

        public void a(int i2, HashMap<String, Object> hashMap) {
            VOAR.this.a(i2, hashMap);
        }

        public void a(HashMap<String, Object> hashMap) {
            VOAR.this.a(hashMap);
        }
    }

    class d implements ARPDataInteraction.b {
        d() {
        }

        public void a(float f2, float f3, float f4) {
            if (VOAR.this.B != null) {
                VOAR.this.B.a(f2, f3, f4);
            }
        }
    }

    class e implements com.baidu.ar.lua.c {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f10525a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f10526b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ HashMap f10527c;

            a(int i2, int i3, HashMap hashMap) {
                this.f10525a = i2;
                this.f10526b = i3;
                this.f10527c = hashMap;
            }

            public void run() {
                VOAR.this.a(this.f10525a, this.f10526b, (HashMap<String, Object>) this.f10527c);
            }
        }

        e() {
        }

        public List<Integer> a() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(401);
            arrayList.add(4100);
            arrayList.add(1901);
            return arrayList;
        }

        public void a(int i2, int i3, HashMap<String, Object> hashMap) {
            t.a(new a(i2, i3, hashMap));
        }
    }

    class f implements g {
        f() {
        }

        public void onImuUpdate(com.baidu.ar.imu.f fVar) {
            com.baidu.ar.imu.f unused = VOAR.this.E = fVar;
        }
    }

    private com.baidu.ar.vo.e.g a(com.baidu.ar.vo.d.d dVar) {
        com.baidu.ar.vo.e.g gVar = new com.baidu.ar.vo.e.g(g(), this.x, this.A, new c());
        gVar.b(dVar.f10552a, dVar.f10553b);
        return gVar;
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, HashMap<String, Object> hashMap) {
        com.baidu.ar.vo.e.b b2;
        boolean z2;
        b bVar = this.B;
        if (bVar != null) {
            if (i2 != 401) {
                if (i2 != 1901) {
                    if (i2 == 4100) {
                        b2 = b(hashMap);
                        z2 = false;
                    } else {
                        return;
                    }
                } else if (hashMap != null) {
                    int a2 = com.baidu.ar.arplay.util.b.a(hashMap.get("id"), -1);
                    if (4100 == a2) {
                        b2 = b(hashMap);
                        z2 = true;
                    } else if (4200 == a2) {
                        this.B.b();
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                b2.f10572e = z2;
                this.B.a(b2);
            } else if (bVar != null && hashMap != null && (hashMap.get("app_type") instanceof String)) {
                this.B.a(HomeTabConstants.TAB_TAG_NONE.equals((String) hashMap.get("app_type")));
            }
        }
    }

    private com.baidu.ar.vo.e.b b(HashMap<String, Object> hashMap) {
        com.baidu.ar.vo.e.b bVar = new com.baidu.ar.vo.e.b();
        bVar.f10568a = ((Float) hashMap.get("x")).floatValue();
        bVar.f10569b = ((Float) hashMap.get("y")).floatValue();
        bVar.f10570c = ((Integer) hashMap.get("type")).intValue();
        bVar.f10571d = ((Float) hashMap.get("distance")).floatValue();
        bVar.f10572e = true;
        return bVar;
    }

    private com.baidu.ar.vo.d.d j() {
        com.baidu.ar.vo.d.d dVar = new com.baidu.ar.vo.d.d();
        dVar.f10552a = 1280;
        dVar.f10553b = 720;
        dVar.f10554c = new b();
        return dVar;
    }

    private com.baidu.ar.lua.c k() {
        return new e();
    }

    /* access modifiers changed from: private */
    public float l() {
        com.baidu.ar.imu.f fVar = this.E;
        return (fVar == null ? null : Float.valueOf(fVar.a())).floatValue();
    }

    /* access modifiers changed from: private */
    public float[] m() {
        com.baidu.ar.imu.f fVar = this.E;
        if (fVar == null) {
            return null;
        }
        return fVar.d();
    }

    private void n() {
        a((k) this.y);
        com.baidu.ar.lua.c cVar = this.C;
        if (cVar != null) {
            b(cVar);
            this.C = null;
        }
        g gVar = this.D;
        if (gVar != null) {
            a(gVar);
            this.D = null;
        }
        this.y = null;
        this.z = null;
        b bVar = this.B;
        if (bVar != null) {
            bVar.a();
            this.B = null;
        }
        com.baidu.ar.vo.d.c cVar2 = this.A;
        if (cVar2 != null) {
            cVar2.c();
            this.A = null;
        }
    }

    private void o() {
        i iVar = new i();
        iVar.a(com.baidu.ar.imu.b.WORLD);
        iVar.a(0);
        iVar.c(false);
        iVar.b(true);
        f fVar = new f();
        this.D = fVar;
        a(iVar, (g) fVar);
    }

    public void onCaseCreate(String str) {
        o();
        com.baidu.ar.arrender.k g2 = g();
        if (g2 != null) {
            g2.a(true);
            g2.b(true);
            g2.setFieldOfView(56.144978f);
            g2.initWorldAxis();
            g2.a((ARPDataInteraction.b) new d());
        }
        a((k) this.y, this.z);
    }

    public void onCaseDestroy() {
    }

    public void release() {
        n();
        super.release();
    }

    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.x = com.baidu.ar.vo.c.a.a(g().e());
        com.baidu.ar.vo.d.d j2 = j();
        this.A = new com.baidu.ar.vo.d.c(j2);
        this.y = new com.baidu.ar.vo.d.e(this.x, this.A);
        this.z = new a();
        this.B = new b(a(j2), this.x, this.A, j2);
        com.baidu.ar.lua.c k = k();
        this.C = k;
        a(k);
    }
}
