package b.a.a.a.b.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import b.a.a.a.c.i.d;
import b.a.a.a.c.j.b;
import b.a.a.a.c.q.g;
import com.baidu.bikenavi.R;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.bikenavi.widget.e;
import com.baidu.platform.comapi.bikenavi.widget.i;
import com.baidu.platform.comapi.walknavi.h.c.C0324a;
import com.baidu.platform.comapi.walknavi.m;
import com.baidu.platform.comapi.walknavi.widget.c;
import java.math.BigDecimal;

/* compiled from: BikeUiController */
public class k extends b.a.a.a.c.p.a {

    /* renamed from: a  reason: collision with root package name */
    private View f1225a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Activity f1226b;

    /* renamed from: c  reason: collision with root package name */
    private e f1227c;

    /* renamed from: d  reason: collision with root package name */
    private i f1228d;

    /* renamed from: e  reason: collision with root package name */
    private c f1229e;

    /* renamed from: f  reason: collision with root package name */
    private c f1230f;

    /* renamed from: g  reason: collision with root package name */
    private C0324a f1231g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1232h;

    /* renamed from: i  reason: collision with root package name */
    private long f1233i;

    /* renamed from: j  reason: collision with root package name */
    private double f1234j;
    private Bitmap k;
    private BitmapDescriptor l;
    private Bitmap m;
    private BitmapDescriptor n;
    LatLng o;
    LatLng p;
    private Handler q;
    private Runnable r;
    final Runnable s;
    final Runnable t;
    private int u;
    /* access modifiers changed from: private */
    public a v;
    private com.baidu.platform.comapi.wnplatform.walkmap.c w;

    /* compiled from: BikeUiController */
    public class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        Activity f1235a;

        /* renamed from: b  reason: collision with root package name */
        c f1236b;

        public a(long j2, long j3, Activity activity, c cVar) {
            super(j2, j3);
            this.f1235a = activity;
            this.f1236b = cVar;
        }

        public void onFinish() {
            k.this.d();
            Activity activity = this.f1235a;
            if (activity != null && !activity.isFinishing()) {
                this.f1236b.dismiss();
            }
        }

        public void onTick(long j2) {
            c cVar = this.f1236b;
            if (cVar != null) {
                ((Button) cVar.a()).setText("确定(" + ((j2 / 1000) - 1) + ")");
            }
        }
    }

    public k(Activity activity) {
        Bitmap decodeResource = BitmapFactory.decodeResource(b.a.a.a.c.q.a.a.b(), R.drawable.icon_start_walk);
        this.k = decodeResource;
        this.l = BitmapDescriptorFactory.fromBitmap(decodeResource);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(b.a.a.a.c.q.a.a.b(), R.drawable.icon_arrive_walk);
        this.m = decodeResource2;
        this.n = BitmapDescriptorFactory.fromBitmap(decodeResource2);
        this.q = new Handler();
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
        this.u = -1;
        this.v = null;
        this.w = new j(this);
        this.f1226b = activity;
        this.f1225a = b.a.a.a.c.q.a.a.a(activity, R.layout.wsdk_layout_bikenavi_ui_layout, (ViewGroup) null);
        C();
        G();
    }

    private void A() {
        m.h().t().a((b.a.a.a.c.k.c) this);
        m.h().r().a((b.a.a.a.c.j.a) this);
        m.h().r().a((b) this);
        m.h().i().a((b.a.a.a.c.c.a) this);
    }

    private void B() {
        Bitmap bitmap = this.k;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.k.recycle();
            this.k = null;
        }
        Bitmap bitmap2 = this.m;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.m.recycle();
            this.m = null;
        }
        BitmapDescriptor bitmapDescriptor = this.l;
        if (bitmapDescriptor != null) {
            bitmapDescriptor.recycle();
            this.l = null;
        }
        BitmapDescriptor bitmapDescriptor2 = this.n;
        if (bitmapDescriptor2 != null) {
            bitmapDescriptor2.recycle();
            this.n = null;
        }
    }

    private void C() {
        m.h().l().d().getMap().addOverlay(new MarkerOptions().position(w()).icon(this.l).zIndex(9).draggable(false));
        m.h().l().d().getMap().addOverlay(new MarkerOptions().position(x()).icon(this.n).zIndex(9).draggable(false));
        this.f1227c = new e(this.f1226b, this, this.f1225a);
        this.f1228d = new i(this.f1226b, this, this.f1225a);
        a(this.f1226b, m.h().l().d(), 70, 0, 0, 60);
    }

    private void D() {
        try {
            if (this.f1230f == null) {
                c b2 = new c(this.f1226b).d(b.a.a.a.c.q.a.a.b(this.f1226b, R.string.wsdk_string_rg_nav_title_tip)).a(b.a.a.a.c.q.a.a.b(this.f1226b, R.string.wsdk_string_rg_gps_not_open_and_set)).b(b.a.a.a.c.q.a.a.b(this.f1226b, R.string.wsdk_string_rg_alert_setting)).b().a((c.a) new h(this)).c(b.a.a.a.c.q.a.a.b(this.f1226b, R.string.wsdk_string_rg_nav_dialog_cancel)).b((c.a) new g(this));
                this.f1230f = b2;
                b2.setOnCancelListener(new i(this));
            }
            Activity activity = this.f1226b;
            if (activity != null && !activity.isFinishing()) {
                this.f1230f.show();
            }
        } catch (Exception e2) {
        }
    }

    private void E() {
        this.f1233i = System.currentTimeMillis();
    }

    private void F() {
        m.h().t().a((b.a.a.a.c.k.c) null);
        m.h().r().b((b.a.a.a.c.j.a) null);
        m.h().r().b((b) null);
        m.h().i().b((b.a.a.a.c.c.a) null);
    }

    private void G() {
        int e2 = m.h().k().e();
        b.a.a.a.c.d.a.c("yang10", "all size:" + e2);
        if (e2 > 2) {
            int i2 = e2 - 2;
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            m.h().k().b(iArr, iArr2, iArr3);
            d.b().a(this.f1226b, iArr, iArr2, iArr3);
        }
    }

    private void t() {
        if (!this.f1232h) {
            if (!m.h().i().b()) {
                D();
            } else {
                u();
            }
        }
    }

    private void u() {
        Activity activity;
        if (this.f1230f != null && (activity = this.f1226b) != null && !activity.isFinishing()) {
            if (this.f1230f.isShowing()) {
                this.f1230f.dismiss();
            }
            this.f1230f = null;
        }
    }

    private void v() {
        int i2 = (int) (this.f1234j * 100.0d);
        int i3 = 3;
        if (i2 >= 0 && i2 < 30) {
            b.a.a.a.c.m.a.a().a("ratio", 0);
        } else if (i2 >= 30 && i2 < 50) {
            b.a.a.a.c.m.a.a().a("ratio", 1);
        } else if (i2 >= 50 && i2 < 80) {
            b.a.a.a.c.m.a.a().a("ratio", 2);
        } else if (i2 >= 80 && i2 <= 100) {
            b.a.a.a.c.m.a.a().a("ratio", 3);
        }
        b.a.a.a.c.m.a.a().a("BikeNaviPG.realDisAndTotalDisRatio");
        int i4 = this.u;
        if (i4 >= 0 && i4 <= 1000) {
            i3 = 0;
        } else if (i4 > 1000 && i4 <= 3000) {
            i3 = 1;
        } else if (i4 > 3000 && i4 <= 5000) {
            i3 = 2;
        } else if (i4 <= 5000 || i4 > 10000) {
            if (i4 > 10000 && i4 <= 20000) {
                i3 = 4;
            } else if (i4 > 20000 && i4 <= 30000) {
                i3 = 5;
            } else if (i4 <= 30000 || i4 > 50000) {
                i3 = i4 > 50000 ? 7 : -1;
            } else {
                i3 = 6;
            }
        }
        b.a.a.a.c.m.a.a().a("distance", i3);
        b.a.a.a.c.m.a.a().a("BikeNaviPG.navDistance");
    }

    private LatLng w() {
        if (this.o == null) {
            this.o = m.h().v();
        }
        return this.o;
    }

    private LatLng x() {
        if (this.p == null) {
            this.p = m.h().e();
        }
        return this.p;
    }

    private void y() {
    }

    /* access modifiers changed from: private */
    public void z() {
        com.baidu.platform.comapi.walknavi.f.c.a();
        Activity activity = this.f1226b;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.h.d.c.a(activity, b.a.a.a.c.q.a.a.b(activity, R.string.wsdk_string_rg_open_gps));
        }
        q();
    }

    public void a(int i2) {
    }

    public void a(Bundle bundle) {
    }

    public void a(String str) {
    }

    public void a(byte[] bArr) {
    }

    public void b(Bundle bundle) {
    }

    public void d(int i2) {
        e eVar = this.f1227c;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public int e() {
        return b.a.a.a.c.q.b.c.b().d() - ((int) (b.a.a.a.c.q.b.c.b().a() * 30.0f));
    }

    public void e(Message message) {
    }

    public int f() {
        return (int) (b.a.a.a.c.q.b.c.b().a() * 45.0f);
    }

    public void f(Bundle bundle) {
    }

    public View g() {
        return this.f1225a;
    }

    public float h() {
        return 0.0f;
    }

    public int i() {
        return 0;
    }

    public Handler j() {
        return null;
    }

    public int k() {
        return 0;
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
        this.f1232h = true;
    }

    public void o() {
        this.f1232h = false;
        t();
    }

    public void onFinalEnd(Message message) {
    }

    public void onIndoorEnd(Message message) {
    }

    public void onRoutePlanStart() {
        m.h().k().q();
    }

    public void onRoutePlanSuccess() {
        m.h().l().c(1);
        y();
        m.h().k().p();
    }

    public void p() {
        Runnable runnable;
        Handler handler = this.q;
        if (handler != null && (runnable = this.t) != null) {
            handler.removeCallbacks(runnable);
            this.q.postDelayed(this.t, 3000);
        }
    }

    public void q() {
        b.a.a.a.c.d.a.c("yang13", "call quitNavWhenConfirm:" + this.f1231g);
        C0324a aVar = this.f1231g;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void r() {
        Runnable runnable;
        Handler handler = this.q;
        if (handler != null && (runnable = this.s) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public boolean ready() {
        A();
        E();
        return true;
    }

    public void release() {
        F();
        Handler handler = this.q;
        if (handler != null) {
            handler.removeCallbacks(this.s);
            this.q = null;
        }
        B();
    }

    public void s() {
        b.a.a.a.c.m.a.a().a("FootNaviAutoComplete");
        e eVar = this.f1227c;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void a() {
        Runnable runnable;
        e eVar = this.f1227c;
        if (eVar != null) {
            eVar.d();
        }
        Handler handler = this.q;
        if (handler != null && (runnable = this.s) != null) {
            handler.removeCallbacks(runnable);
            this.q.postDelayed(this.s, 15000);
        }
    }

    public void b() {
        Runnable runnable;
        Handler handler = this.q;
        if (handler != null && (runnable = this.r) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public boolean c() {
        return this.f1225a == null || this.f1226b == null;
    }

    public void c(int i2) {
        Runnable runnable;
        Handler handler = this.q;
        if (handler != null && (runnable = this.r) != null) {
            handler.removeCallbacks(runnable);
            this.q.postDelayed(this.r, (long) i2);
        }
    }

    public void d(Message message) {
        s();
        p();
    }

    public void e(Bundle bundle) {
        Bundle bundle2 = bundle;
        try {
            double doubleValue = new BigDecimal((double) ((bundle2.getFloat("curSpeed") * 3600.0f) / 1000.0f)).setScale(1, 4).doubleValue();
            double doubleValue2 = new BigDecimal((double) ((bundle2.getFloat("maxSpeed") * 3600.0f) / 1000.0f)).setScale(1, 4).doubleValue();
            double doubleValue3 = new BigDecimal((double) ((bundle2.getFloat("avgSpeed") * 3600.0f) / 1000.0f)).setScale(1, 4).doubleValue();
            this.u = bundle2.getInt("AddDist");
            double doubleValue4 = new BigDecimal((double) (((float) bundle2.getInt("AddDist")) / 1000.0f)).setScale(1, 4).doubleValue();
            double doubleValue5 = new BigDecimal((double) (((float) bundle2.getInt("RouteDist")) / 1000.0f)).setScale(1, 4).doubleValue();
            double d2 = doubleValue;
            double doubleValue6 = new BigDecimal((double) bundle2.getFloat("realDistance")).setScale(1, 4).doubleValue();
            this.f1227c.a(doubleValue6, bundle2.getLong("secTime"));
            float f2 = bundle2.getFloat("calorie");
            b.a.a.a.c.d.a.b("bike cal:" + f2 + "or:" + bundle2.getFloat("calorie"));
            double doubleValue7 = new BigDecimal((double) f2).setScale(1, 4).doubleValue();
            float f3 = bundle2.getFloat("altidiff");
            float f4 = bundle2.getFloat("altitude");
            this.f1234j = doubleValue4 / doubleValue5;
            this.f1227c.a(d2, doubleValue3, doubleValue2);
            this.f1227c.a((float) doubleValue7, f3, f4);
        } catch (Exception e2) {
        }
    }

    public void b(int i2) {
        t();
    }

    public void b(Message message) {
        if (message.arg1 == 0) {
            com.baidu.platform.comapi.walknavi.f.c.a(com.baidu.platform.comapi.walknavi.f.b.REFRESH_GUIDANCE);
            i iVar = this.f1228d;
            if (iVar != null) {
                iVar.a(R.drawable.bn_gps_blue, "GPS弱");
                this.f1228d.f();
            }
        }
    }

    public void d(Bundle bundle) {
        int i2 = bundle.getInt("simpleUpdateType");
        if (i2 != 0 && i2 != 3 && bundle.containsKey("enGuideType") && bundle.containsKey("nDistance2GP")) {
            int i3 = bundle.getInt("enGuideType");
            int a2 = a.a(b.a.a.a.c.j.d.a(RouteGuideKind.values()[i3]));
            int i4 = bundle.getInt("nDistance2GP");
            int i5 = ((i4 + 5) / 10) * 10;
            if ("到达目的地".equals(bundle.getString("usGuideText"))) {
                p();
            }
            StringBuilder sb = new StringBuilder();
            if (i3 != 0) {
                b.a.a.a.c.d.a.b("update guidance type:" + i3 + "dis:" + i4);
                StringBuffer stringBuffer = new StringBuffer();
                g.a(i5, g.b.ZH, stringBuffer);
                sb.append(stringBuffer.toString());
                int i6 = bundle.getInt("enSpliceType");
                if (i6 == 1) {
                    sb.append("前");
                } else if (i6 == 3) {
                    sb.append("后");
                }
                this.f1228d.a(a2, sb.toString());
                this.f1228d.e();
            }
        }
    }

    public void c(Message message) {
        b.a.a.a.c.m.a.a().a("BikeNaviPG.farAway");
        b.a.a.a.c.d.a.c("yang13", "call onRouteFarAway");
        com.baidu.platform.comapi.walknavi.f.c.a();
        com.baidu.platform.comapi.walknavi.f.c.a(com.baidu.platform.comapi.walknavi.f.b.REFRESH_GUIDANCE);
        i iVar = this.f1228d;
        if (iVar != null) {
            iVar.a(R.drawable.bn_faraway_route_blue, "已偏航");
        }
    }

    public void a(boolean z) {
        e eVar = this.f1227c;
        if (eVar != null) {
            eVar.a(z);
        }
    }

    public void a(Message message) {
        b.a.a.a.c.m.a.a().a("BikeNaviPG.reRoute");
        b.a.a.a.c.d.a.c("yang13", "call onReRouteComplete");
        if (!this.f1232h) {
            m.h().g().run("收到偏航算路成功消息");
        }
    }

    public void c(Bundle bundle) {
        if (bundle.getInt("updatetype") == b.a.a.a.c.j.e.f1318b) {
            int i2 = bundle.getInt("totaldist");
            int i3 = bundle.getInt("totaltime");
            StringBuffer stringBuffer = new StringBuffer();
            g.a(i2, g.b.ZH, stringBuffer);
            this.f1227c.a(stringBuffer.toString(), g.a(i3, 2));
        }
    }

    public void a(Context context, View view2, int i2, int i3, int i4, int i5) {
        super.a(context, view2, i2, i3, i4, i5);
    }

    public void a(boolean z, int i2) {
        String str;
        Activity activity;
        try {
            Activity activity2 = this.f1226b;
            if (activity2 != null) {
                if (!activity2.isFinishing()) {
                    c d2 = new c(this.f1226b).a(true).d(b.a.a.a.c.q.a.a.b(this.f1226b, R.string.wsdk_string_rg_nav_title_tip));
                    if (com.baidu.platform.comapi.walknavi.h.b.b.f16451a == 2) {
                        str = b.a.a.a.c.q.a.a.b(this.f1226b, i2);
                    } else {
                        str = b.a.a.a.c.q.a.a.b(this.f1226b, i2);
                    }
                    this.f1229e = d2.a(str).c(b.a.a.a.c.q.a.a.b(this.f1226b, R.string.wsdk_string_rg_exit_check)).c().b((c.a) new f(this)).b(b.a.a.a.c.q.a.a.b(this.f1226b, R.string.wsdk_string_rg_nav_dialog_cancel)).a((c.a) new e(this));
                    if (z) {
                        a aVar = new a(7000, 1000, this.f1226b, this.f1229e);
                        this.v = aVar;
                        aVar.start();
                    }
                    if (!this.f1229e.isShowing() && (activity = this.f1226b) != null && !activity.isFinishing()) {
                        this.f1229e.show();
                        return;
                    }
                    return;
                }
            }
            b.a.a.a.c.m.a.a().a("BikeNaviPG.exitNavi");
            q();
        } catch (Exception e2) {
        }
    }

    public void d() {
        com.baidu.platform.comapi.walknavi.f.c.a();
        v();
        q();
        View view2 = this.f1225a;
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.f1225a = null;
        }
        Activity activity = this.f1226b;
        if (activity != null && !activity.isFinishing()) {
            this.f1226b.finish();
        }
        this.f1226b = null;
    }

    public void a(C0324a aVar) {
        this.f1231g = aVar;
    }
}
