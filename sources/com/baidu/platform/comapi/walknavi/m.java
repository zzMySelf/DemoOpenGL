package com.baidu.platform.comapi.walknavi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import b.a.a.a.b.c.k;
import b.a.a.a.c.c.g;
import b.a.a.a.c.e.b;
import b.a.a.a.c.e.c;
import b.a.a.a.c.j.i;
import b.a.a.a.c.k.e;
import b.a.a.a.c.q.o;
import b.a.a.a.c.q.p;
import com.baidu.bikenavi.R;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.mapapi.bikenavi.adapter.IBNaviStatusListener;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.platform.comapi.walknavi.d.f;
import com.baidu.platform.comapi.walknavi.fsm.WGuideFSM;
import com.baidu.platform.comapi.walknavi.h.c.C;
import com.baidu.platform.comapi.walknavi.h.c.C0324a;
import com.baidu.platform.comapi.walknavi.h.u;
import com.baidu.platform.comapi.walknavi.widget.c;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.walkmap.d;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
import com.baidu.searchbox.account.contants.AccountConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: WNavigator */
public class m implements C0324a {

    /* renamed from: a  reason: collision with root package name */
    public static int f16551a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f16552b = 1;
    private int A;
    private int B;
    private LatLng C;
    private LatLng D;
    /* access modifiers changed from: private */
    public c E;
    private int F;
    private int G;
    private boolean H;
    private WalkNaviDisplayOption I;
    private ArrayList<com.baidu.platform.comapi.walknavi.d.a> J;
    private ArrayList<BaseNpcModel> K;
    private Bitmap L;
    private Bitmap M;
    /* access modifiers changed from: private */
    public boolean N;
    private int O;
    private float P;
    private com.baidu.platform.comapi.walknavi.widget.c Q;
    /* access modifiers changed from: private */
    public int R;
    private final BroadcastReceiver S;

    /* renamed from: c  reason: collision with root package name */
    private com.baidu.platform.comapi.walknavi.c.c f16553c;

    /* renamed from: d  reason: collision with root package name */
    private e f16554d;

    /* renamed from: e  reason: collision with root package name */
    private b.a.a.a.c.b.a f16555e;

    /* renamed from: f  reason: collision with root package name */
    private i f16556f;

    /* renamed from: g  reason: collision with root package name */
    private WGuideFSM f16557g;

    /* renamed from: h  reason: collision with root package name */
    private d f16558h;

    /* renamed from: i  reason: collision with root package name */
    private com.baidu.platform.comapi.walknavi.a.a f16559i;

    /* renamed from: j  reason: collision with root package name */
    private o f16560j;
    private b.a.a.a.c.o.a k;
    private b.a.a.a.c.l.c l;
    private g m;
    private b n;
    /* access modifiers changed from: private */
    public b.a.a.a.c.p.a o;
    private b.a.a.a.c.n.b p;
    private b.a.a.a.c.a.a q;
    private WalkPlan r;
    private b.a.a.a.c.h.b s;
    private IWNaviStatusListener t;
    private IBNaviStatusListener u;
    private int v;
    private int w;
    private Bundle x;
    /* access modifiers changed from: private */
    public Context y;
    /* access modifiers changed from: private */
    public Handler z;

    /* compiled from: WNavigator */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final m f16561a = new m((b) null);
    }

    /* synthetic */ m(b bVar) {
        this();
    }

    private int X() {
        int i2;
        if (z() != null) {
            i2 = z().i();
        } else {
            i2 = 0;
        }
        if (i2 <= 0) {
            return 12;
        }
        return i2;
    }

    private void Y() {
        if (b.a.a.a.c.b.b().i()) {
            this.k = new com.baidu.platform.comapi.walknavi.g.b();
        } else if (b.a.a.a.c.b.b().e()) {
            this.k = new b.a.a.a.b.b.b();
        }
    }

    private void Z() {
        com.baidu.platform.comapi.walknavi.b.a.f16268b = 19;
    }

    private void aa() {
        if (!b.a.a.a.c.b.b().i()) {
            return;
        }
        if (h().q().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
            h().f(-50);
        } else {
            h().f(0);
        }
    }

    private void ba() {
        BroadcastReceiver broadcastReceiver;
        try {
            Context context = this.y;
            if (context != null && (broadcastReceiver = this.S) != null) {
                context.unregisterReceiver(broadcastReceiver);
            }
        } catch (IllegalArgumentException e2) {
            b.a.a.a.c.d.a.b(e2.getMessage());
        }
    }

    public static m h() {
        return a.f16561a;
    }

    public WalkNaviDisplayOption A() {
        return this.I;
    }

    public int B() {
        return this.R;
    }

    public ArrayList<BaseNpcModel> C() {
        ArrayList<BaseNpcModel> arrayList = this.K;
        if (arrayList == null || arrayList.size() == 0) {
            c((ArrayList<BaseNpcModel>) null);
        }
        return this.K;
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.d.a> D() {
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> arrayList = this.J;
        if (arrayList == null || arrayList.size() == 0) {
            b((ArrayList<BaseNpcModel>) null);
        }
        return this.J;
    }

    public WalkPlan E() {
        return this.r;
    }

    public boolean F() {
        SensorManager sensorManager;
        List<Sensor> sensorList;
        Context a2 = b.a.a.a.c.q.b.a.a();
        if (a2 == null || (sensorManager = (SensorManager) a2.getSystemService("sensor")) == null || (sensorList = sensorManager.getSensorList(-1)) == null || (r0 = sensorList.iterator()) == null) {
            return true;
        }
        for (Sensor type : sensorList) {
            if (type.getType() == 11) {
                return true;
            }
        }
        return false;
    }

    public boolean G() {
        SensorManager sensorManager;
        List<Sensor> sensorList;
        Context a2 = b.a.a.a.c.q.b.a.a();
        if (a2 == null || (sensorManager = (SensorManager) a2.getSystemService("sensor")) == null || (sensorList = sensorManager.getSensorList(-1)) == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        for (Sensor type : sensorList) {
            int type2 = type.getType();
            if (type2 == 11) {
                z2 = true;
            } else if (type2 == 1) {
                z3 = true;
            } else if (type2 == 2) {
                z4 = true;
            }
        }
        if (z2 || (z3 && z4)) {
            return true;
        }
        return false;
    }

    public void H() {
        l().g();
    }

    public boolean I() {
        return this.H;
    }

    public boolean J() {
        return this.w != 0;
    }

    public void K() {
        b.a.a.a.c.p.a aVar;
        C q2;
        if (f.d().f() && (aVar = this.o) != null && (aVar instanceof u) && (q2 = ((u) aVar).q()) != null) {
            q2.b(false);
        }
    }

    public void L() {
        if (f.d().f()) {
            f.d().m();
        }
    }

    public void M() {
        K();
        b.a.a.a.c.l.c cVar = this.l;
        if (cVar != null) {
            cVar.a();
        }
        b.a.a.a.c.p.a aVar = this.o;
        if (aVar != null) {
            aVar.a((C0324a) null);
            this.o.n();
        }
    }

    public void N() {
        k().a();
    }

    public void O() {
        f.d().j();
        b.a.a.a.c.b.a aVar = this.f16555e;
        if (aVar != null && aVar.h()) {
            this.f16555e.q();
        }
        if (this.f16558h != null) {
            h().l().c(0);
        }
        h().a(false);
        ba();
        P();
        this.H = false;
    }

    public void P() {
        b.a.a.a.c.q.d.a(this.y);
        this.w = 0;
        this.t = null;
        this.u = null;
        b.a.a.a.c.p.a aVar = this.o;
        if (aVar != null) {
            aVar.a((C0324a) null);
            this.o.release();
            this.o = null;
        }
        e eVar = this.f16554d;
        if (eVar != null) {
            eVar.release();
            this.f16554d = null;
        }
        b.a.a.a.c.b.a aVar2 = this.f16555e;
        if (aVar2 != null) {
            aVar2.release();
            this.f16555e = null;
        }
        i iVar = this.f16556f;
        if (iVar != null) {
            iVar.release();
            this.f16556f = null;
        }
        WGuideFSM wGuideFSM = this.f16557g;
        if (wGuideFSM != null) {
            wGuideFSM.release();
            this.f16557g = null;
        }
        d dVar = this.f16558h;
        if (dVar != null) {
            dVar.release();
            this.f16558h = null;
        }
        com.baidu.platform.comapi.walknavi.a.a aVar3 = this.f16559i;
        if (aVar3 != null) {
            aVar3.release();
            this.f16559i = null;
        }
        o oVar = this.f16560j;
        if (oVar != null) {
            oVar.release();
            this.f16560j = null;
        }
        b.a.a.a.c.l.c cVar = this.l;
        if (cVar != null) {
            cVar.release();
            this.l = null;
        }
        g gVar = this.m;
        if (gVar != null) {
            gVar.release();
            this.m = null;
        }
        b bVar = this.n;
        if (bVar != null) {
            bVar.release();
            this.n = null;
        }
        b.a.a.a.c.n.b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.release();
            this.p = null;
        }
        b.a.a.a.c.h.b bVar3 = this.s;
        if (bVar3 != null) {
            bVar3.release();
            this.s = null;
        }
        b.a.a.a.c.a.a aVar4 = this.q;
        if (aVar4 == null) {
            ArrayList<com.baidu.platform.comapi.walknavi.d.a> arrayList = this.J;
            if (arrayList != null) {
                arrayList.clear();
                this.J = null;
            }
            ArrayList<BaseNpcModel> arrayList2 = this.K;
            if (arrayList2 != null) {
                arrayList2.clear();
                this.K = null;
            }
            Bitmap bitmap = this.L;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.L.recycle();
                this.L = null;
            }
            Bitmap bitmap2 = this.M;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.M.recycle();
                this.M = null;
            }
            this.f16554d = null;
            this.f16555e = null;
            this.f16556f = null;
            this.f16557g = null;
            this.f16559i = null;
            this.f16560j = null;
            this.l = null;
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = null;
            this.x = null;
            this.v = 0;
            this.y = null;
            this.r = null;
            com.baidu.platform.comapi.walknavi.h.b.b.a();
            p.b().a();
            b.a.a.a.c.q.a.a.c();
            return;
        }
        aVar4.release();
        throw null;
    }

    public void Q() {
        if (this.I != null) {
            this.I = null;
        }
    }

    public void R() {
        L();
        if (b.a.a.a.c.b.b().e()) {
            l().c(1);
        } else if (b.a.a.a.c.b.b().i()) {
            if (B() == 1) {
                l().c(1);
            } else if (B() == 2) {
                l().c(0);
            }
        }
        if (this.o != null) {
            u().a(this.y, this.o.j());
            this.o.a((C0324a) this);
            this.o.o();
        }
        g().runCurrentState();
    }

    public void S() {
        int i2;
        int i3 = 0;
        if (z() != null) {
            i3 = z().e();
            i2 = z().f();
        } else {
            i2 = 0;
        }
        l().a(i3, i2);
    }

    public boolean T() {
        if (this.w < 2) {
            return false;
        }
        this.H = true;
        MapStatus c2 = l().c();
        this.w = 3;
        this.o.m();
        l().c(1);
        k().g(X());
        if (com.baidu.platform.comapi.walknavi.h.b.b.f16451a != 4) {
            if (b.a.a.a.c.b.b().d()) {
                b(1);
            } else {
                b(0);
            }
            k().p();
        }
        h().k().c(true);
        l().a(c2);
        if (com.baidu.platform.comapi.walknavi.h.b.b.f16451a == 4) {
            k().l();
            return true;
        }
        this.z.postDelayed(new c(this), 500);
        return true;
    }

    public void U() {
        h().a(true);
        if (b.a.a.a.c.b.b().g()) {
            l().d().getMap().setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder(l().d().getMap().getMapStatus()).zoom(22.0f).build()));
            h().g().run("[2D正北]按钮点击");
        }
    }

    public void V() {
        com.baidu.platform.comapi.walknavi.c.c cVar = this.f16553c;
        if (cVar != null) {
            cVar.release();
        }
    }

    public void W() {
        if (J()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_token", true);
            bundle.putBoolean("is_phoneinfo", true);
            Set<String> keySet = bundle.keySet();
            if (keySet != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str : keySet) {
                        if (!TextUtils.equals(str, "glr")) {
                            if (!TextUtils.equals(str, "glv")) {
                                jSONObject.put(str, String.valueOf(bundle.get(str)));
                            }
                        }
                    }
                    h().k().b(jSONObject.toString());
                } catch (Exception e2) {
                    b.a.a.a.c.d.a.b(e2.getMessage());
                }
            }
        }
    }

    public void e(int i2) {
        k().c(i2);
    }

    public boolean f(int i2) {
        if (k() != null) {
            return this.f16555e.j(i2);
        }
        return false;
    }

    public void g(int i2) {
        this.O = i2;
    }

    public g i() {
        if (this.m == null) {
            this.m = new g();
        }
        return this.m;
    }

    public boolean j() {
        com.baidu.platform.comapi.walknavi.c.c cVar = this.f16553c;
        if (cVar == null || cVar.c() <= 0) {
            return false;
        }
        return true;
    }

    public b.a.a.a.c.b.a k() {
        if (this.f16555e == null) {
            this.f16555e = new b.a.a.a.c.b.a();
        }
        return this.f16555e;
    }

    public d l() {
        if (this.f16558h == null) {
            this.f16558h = new d();
        }
        return this.f16558h;
    }

    public int m() {
        return this.A;
    }

    public MapBound n() {
        new Bundle();
        Bundle f2 = h().k().f();
        if (f2 == null) {
            return null;
        }
        int i2 = f2.getInt("left");
        int i3 = f2.getInt("bottom");
        int i4 = f2.getInt("right");
        int i5 = f2.getInt("top");
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i2, i3));
        mapBound.setPtRT(new Point(i4, i5));
        return mapBound;
    }

    public boolean o() {
        return f.d().e();
    }

    public int p() {
        return this.F;
    }

    public o q() {
        if (this.f16560j == null) {
            this.f16560j = new o();
        }
        return this.f16560j;
    }

    public i r() {
        if (this.f16556f == null) {
            this.f16556f = new i();
        }
        return this.f16556f;
    }

    public int s() {
        return this.O;
    }

    public e t() {
        if (this.f16554d == null) {
            this.f16554d = new e();
        }
        return this.f16554d;
    }

    public b.a.a.a.c.l.c u() {
        if (this.l == null) {
            this.l = new b.a.a.a.c.l.c();
        }
        return this.l;
    }

    public LatLng v() {
        return this.C;
    }

    public Point w() {
        return CoordUtil.ll2point(this.C);
    }

    public b.a.a.a.c.o.a x() {
        return this.k;
    }

    public b.a.a.a.c.n.b y() {
        if (this.p == null) {
            this.p = new b.a.a.a.c.n.b();
        }
        return this.p;
    }

    public b.a.a.a.c.p.a z() {
        return this.o;
    }

    private m() {
        this.f16553c = null;
        this.f16554d = null;
        this.f16555e = null;
        this.f16556f = null;
        this.f16557g = null;
        this.f16558h = null;
        this.f16559i = null;
        this.f16560j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = 0;
        this.x = new Bundle();
        this.z = new Handler();
        this.F = -1;
        this.G = -1;
        this.H = false;
        this.J = new ArrayList<>();
        this.K = new ArrayList<>();
        this.L = null;
        this.M = null;
        this.N = false;
        this.O = 0;
        this.P = 0.0f;
        this.S = new l(this);
    }

    private int h(int i2) {
        return (b.a.a.a.c.q.g.a() != 1 || !b.a.a.a.c.q.g.b()) ? i2 : i2 | 4;
    }

    public void b() {
        l().a();
    }

    public Context c() {
        return this.y;
    }

    public void d(int i2) {
        this.A = i2;
    }

    public LatLng e() {
        return this.D;
    }

    public WGuideFSM g() {
        if (this.f16557g == null) {
            this.f16557g = new WGuideFSM();
        }
        return this.f16557g;
    }

    private void c(ArrayList<BaseNpcModel> arrayList) {
        ArrayList<BaseNpcModel> arrayList2 = this.K;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            this.K = new ArrayList<>();
        }
        if (this.L == null) {
            this.L = BitmapFactory.decodeResource(b.a.a.a.c.q.a.a.b(), R.drawable.wsdk_icon_classic);
        }
        BaseNpcModel baseNpcModel = new BaseNpcModel();
        baseNpcModel.setDownLoadKey("");
        baseNpcModel.setIcon(this.L);
        baseNpcModel.setOriginTitle("经典");
        baseNpcModel.setLoadFromLocal(true);
        this.K.add(baseNpcModel);
        if (this.M == null) {
            this.M = BitmapFactory.decodeResource(b.a.a.a.c.q.a.a.b(), R.drawable.wsdk_icon_tutu);
        }
        BaseNpcModel baseNpcModel2 = new BaseNpcModel();
        baseNpcModel2.setDownLoadKey("10279765");
        baseNpcModel2.setIcon(this.M);
        baseNpcModel2.setOriginTitle("图图");
        baseNpcModel2.setLoadFromLocal(false);
        this.K.add(baseNpcModel2);
        if (arrayList != null && arrayList.size() != 0) {
            this.K.addAll(arrayList);
        }
    }

    public View b(Activity activity) {
        if (b.a.a.a.c.b.b().i()) {
            if (this.o == null) {
                this.o = new u(activity);
            }
        } else if (b.a.a.a.c.b.b().e() && this.o == null) {
            this.o = new k(activity);
        }
        return this.o.g();
    }

    public b d() {
        if (this.n == null) {
            this.n = new b();
        }
        return this.n;
    }

    public com.baidu.platform.comapi.walknavi.c.c f() {
        if (this.f16553c == null) {
            this.f16553c = new com.baidu.platform.comapi.walknavi.c.c();
        }
        return this.f16553c;
    }

    public void a(int i2, int i3) {
        b.a.a.a.c.b.b().c(i2);
        b.a.a.a.c.b.b().b(i3);
        e(i2);
        Y();
    }

    public void a(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        a(activity).a(iWRouteGuidanceListener);
    }

    public void a(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        a(activity).a(iBRouteGuidanceListener);
    }

    private void b(ArrayList<BaseNpcModel> arrayList) {
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> arrayList2 = this.J;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            this.J = new ArrayList<>();
        }
        com.baidu.platform.comapi.walknavi.d.a aVar = new com.baidu.platform.comapi.walknavi.d.a();
        aVar.a("");
        aVar.c("经典");
        aVar.a(true);
        aVar.a(this.L);
        this.J.add(aVar);
        com.baidu.platform.comapi.walknavi.d.a aVar2 = new com.baidu.platform.comapi.walknavi.d.a();
        aVar2.a("10279765");
        aVar2.c("图图");
        aVar2.a(false);
        aVar2.a(this.M);
        this.J.add(aVar2);
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<BaseNpcModel> it = arrayList.iterator();
            while (it.hasNext()) {
                BaseNpcModel next = it.next();
                com.baidu.platform.comapi.walknavi.d.a aVar3 = new com.baidu.platform.comapi.walknavi.d.a();
                aVar3.a(next.getDownLoadKey());
                aVar3.c(next.getOriginTitle());
                aVar3.d(next.getModelSize());
                aVar3.b(next.getLocalPath());
                aVar3.a(next.getIcon());
                aVar3.a(next.isLoadFromLocal());
                this.J.add(aVar3);
            }
        }
    }

    public b.a.a.a.c.h.b a(Activity activity) {
        if (this.s == null) {
            this.s = new b.a.a.a.c.h.b(activity);
        }
        return this.s;
    }

    public void a(Context context, long j2, com.baidu.platform.comapi.walknavi.c.a aVar) {
        if (this.f16553c == null) {
            this.f16553c = new com.baidu.platform.comapi.walknavi.c.c();
        }
        this.w = 1;
        this.f16553c.a(context, j2, aVar);
    }

    public void a(Context context, MapView mapView) {
        l().a(context, mapView);
    }

    public void a(b.a.a.a.c.k.b bVar) {
        t().a(bVar);
    }

    public void a(WLocData wLocData) {
        g gVar = this.m;
        if (gVar != null && wLocData != null) {
            gVar.a(wLocData);
        }
    }

    public void a(WalkNaviDisplayOption walkNaviDisplayOption) {
        this.I = walkNaviDisplayOption;
    }

    public void a(b.a.a.a.c.o.c cVar) {
        x().a(cVar);
    }

    public void a(ArrayList<BaseNpcModel> arrayList) {
        c(arrayList);
        b(arrayList);
    }

    public void c(int i2) {
        this.B = i2;
    }

    public com.baidu.platform.comapi.walknavi.d.a a(String str) {
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> D2 = D();
        if (!(D2 == null || D2.size() == 0)) {
            Iterator<com.baidu.platform.comapi.walknavi.d.a> it = D2.iterator();
            while (it.hasNext()) {
                com.baidu.platform.comapi.walknavi.d.a next = it.next();
                if (TextUtils.equals(next.a(), str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public void a(BaseNpcModel baseNpcModel) {
        C q2;
        b.a.a.a.c.p.a aVar = this.o;
        if (aVar != null && (aVar instanceof u) && (q2 = ((u) aVar).q()) != null) {
            q2.a(baseNpcModel);
        }
    }

    public void a(IWNPCEngineInitListener iWNPCEngineInitListener) {
        f.d().b("10279765", (com.baidu.platform.comapi.walknavi.d.c) new b(this, iWNPCEngineInitListener));
    }

    public void a(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        C q2;
        b.a.a.a.c.p.a aVar = this.o;
        if (aVar != null && (aVar instanceof u) && (q2 = ((u) aVar).q()) != null) {
            q2.a(iWMoreNPCModelOnClickListener);
        }
    }

    public void b(int i2) {
        b.a.a.a.c.b.a aVar = this.f16555e;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    public void a(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        C q2;
        b.a.a.a.c.p.a aVar = this.o;
        if (aVar != null && (aVar instanceof u) && (q2 = ((u) aVar).q()) != null) {
            q2.a(iWNPCLoadAndInitListener);
        }
    }

    public void b(LatLng latLng) {
        this.C = latLng;
    }

    public void b(String str) {
    }

    public boolean a(Activity activity, Bundle bundle) {
        boolean z2;
        k().m();
        this.y = activity;
        if (bundle != null) {
            try {
                com.baidu.platform.comapi.walknavi.h.b.b.f16451a = bundle.getInt("wnavi_mode", 1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            com.baidu.platform.comapi.walknavi.h.b.b.f16451a = 1;
        }
        if (h().m() != 4) {
            if (x() != null) {
                x().ready();
            }
            if (b.a.a.a.c.b.b().i()) {
                z2 = h().q().a("WALKNAVI_VOICE_ON_OFF", true);
            } else if (b.a.a.a.c.b.b().e()) {
                z2 = h().q().a("BIKENAVI_VOICE_ON_OFF", true);
            } else {
                z2 = true;
            }
            if (z2) {
                WNaviTTSPlayer.resumeVoiceTTSOutput();
            } else {
                WNaviTTSPlayer.pauseVoiceTTSOutput();
            }
        } else {
            WNaviTTSPlayer.pauseVoiceTTSOutput();
        }
        l().ready();
        if (this.o == null) {
            if (b.a.a.a.c.b.b().i()) {
                this.o = new u(activity);
            } else if (b.a.a.a.c.b.b().e()) {
                this.o = new k(activity);
            }
        }
        b.a.a.a.c.p.a aVar = this.o;
        if (aVar == null || aVar.c()) {
            return false;
        }
        this.o.ready();
        S();
        if (h().m() != 4) {
            i().a(this.y);
        }
        r().ready();
        t().ready();
        N();
        int i2 = com.baidu.platform.comapi.walknavi.h.b.b.f16451a;
        if (i2 == 1) {
            i().b((Context) activity);
        } else if (i2 == 3) {
            y().ready();
        }
        Z();
        l().l();
        this.w = 2;
        aa();
        if (b.a.a.a.c.b.b().i()) {
            h().a(h(this.B == 1 ? 2 : 1), true);
            int a2 = b.a.a.a.c.q.g.a(E(), s());
            if (a2 == 2 || a2 == 3) {
                h().a(this.y, (u.b) null, a2);
            }
        } else if (b.a.a.a.c.b.b().e()) {
            h().b(0);
            b.a.a.a.c.b.b().a(1);
        }
        l().d().getMap().setBaiduHeatMapEnabled(false);
        l().d().getMap().setTrafficEnabled(false);
        l().d().getMap().setMyLocationEnabled(false);
        return true;
    }

    public void a(c cVar) {
        this.E = cVar;
    }

    public void a(Bundle bundle) {
        k().g(bundle);
    }

    public void a(int i2, String str) {
        this.z.postDelayed(new d(this, str), (long) i2);
    }

    public void a(IWNaviStatusListener iWNaviStatusListener) {
        this.t = iWNaviStatusListener;
    }

    public void a(IBNaviStatusListener iBNaviStatusListener) {
        this.u = iBNaviStatusListener;
    }

    public void a(boolean z2) {
        if (z2) {
            b.a.a.a.c.q.e.a(true);
            b.a.a.a.c.b.b().a(b.a.a.a.c.b.b().a() | 4);
            return;
        }
        b.a.a.a.c.q.e.a(false);
        b.a.a.a.c.b.b().a(b.a.a.a.c.b.b().a() & -5);
    }

    public void a(Context context, u.b bVar, int i2) {
        if (context != null) {
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (!wifiManager.isWifiEnabled()) {
                    Activity activity = (Activity) context;
                    com.baidu.platform.comapi.walknavi.widget.c b2 = new com.baidu.platform.comapi.walknavi.widget.c(activity).a(true).d("温馨提示").a("您所在的商户支持室内导航,开启WIFI即可使用室内导航").b((i2 == 1 || i2 == 3) ? "不导航了" : i2 == 2 ? "不需要" : AccountConstants.PROFESSION_APPROVE_DIALOG_CANCEL_TITLE_DEFAULT).a((c.a) new f(this, bVar, i2)).c("去开启").b((c.a) new e(this, wifiManager, bVar, i2));
                    this.Q = b2;
                    if (!b2.isShowing() && context != null && !activity.isFinishing()) {
                        this.Q.show();
                    }
                } else if (bVar != null) {
                    bVar.b(i2);
                }
            } catch (Exception e2) {
            }
        }
    }

    public void a(boolean z2, boolean z3) {
        if (z2) {
            a(this.y, (u.b) new h(this), b.a.a.a.c.q.g.a(z3));
            return;
        }
        h().a(false);
    }

    public void a(int i2, boolean z2) {
        b.a.a.a.c.b.b().a(i2);
        IWNaviStatusListener iWNaviStatusListener = this.t;
        if (iWNaviStatusListener != null) {
            iWNaviStatusListener.onWalkNaviModeChange(i2, new j(this, i2, z2));
        }
        if (!z2) {
            return;
        }
        if (b.a.a.a.c.b.b().f()) {
            U();
        } else {
            h().a(false);
        }
    }

    public void a() {
        IWNaviStatusListener iWNaviStatusListener = this.t;
        if (iWNaviStatusListener != null) {
            iWNaviStatusListener.onNaviExit();
        }
        IBNaviStatusListener iBNaviStatusListener = this.u;
        if (iBNaviStatusListener != null) {
            iBNaviStatusListener.onNaviExit();
        }
        O();
    }

    public void a(LatLng latLng) {
        this.D = latLng;
    }

    public void a(WalkPlan walkPlan) {
        this.r = walkPlan;
    }

    public MapBound a(int i2) {
        new Bundle();
        Bundle e2 = h().k().e(i2);
        int i3 = e2.getInt("left");
        int i4 = e2.getInt("bottom");
        int i5 = e2.getInt("right");
        int i6 = e2.getInt("top");
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i3, i4));
        mapBound.setPtRT(new Point(i5, i6));
        return mapBound;
    }
}
