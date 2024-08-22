package com.baidu.mapsdkplatform.comapi.map;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapLayer;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.w;
import com.baidu.mapsdkplatform.comjni.map.basemap.BaseMapCallback;
import com.baidu.mapsdkplatform.comjni.map.basemap.JNIBaseMap;
import com.baidu.mapsdkplatform.comjni.map.basemap.b;
import com.baidu.searchbox.video.feedflow.flow.lagfluency.FpsReportManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class o implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15012a = w.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static float f15013b = 1096.0f;

    /* renamed from: c  reason: collision with root package name */
    private static int f15014c;

    /* renamed from: d  reason: collision with root package name */
    private static int f15015d;

    /* renamed from: e  reason: collision with root package name */
    static long f15016e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static List<JNIBaseMap> f15017f;
    long A;
    private List<C0323n> B;
    private HashMap<MapLayer, C0323n> C;
    private K D;
    private q E;
    private C0313d F;
    private C0316g G;
    private A H;
    private C0320k I;
    private B J;
    private C0314e K;
    boolean L;
    private int M;
    private int N;
    private int O;
    int P;
    private w.a Q = new w.a();
    private VelocityTracker R;
    private long S;
    private long T;
    private long U;
    private long V;
    private int W;
    private float X;
    private float Y;
    private boolean Z;
    private long aa;
    private long ba;
    private boolean ca = false;
    private boolean da = false;
    private float ea;
    private float fa;

    /* renamed from: g  reason: collision with root package name */
    public float f15018g = 21.0f;
    private float ga;

    /* renamed from: h  reason: collision with root package name */
    public float f15019h = 4.0f;
    private float ha;

    /* renamed from: i  reason: collision with root package name */
    public float f15020i = 21.0f;
    private long ia = 0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15021j;
    private long ja = 0;
    private boolean k;
    boolean ka;
    private boolean l = true;
    boolean la;
    private boolean m = false;
    boolean ma;
    private boolean n = false;
    private p na;
    private boolean o = false;
    private String oa;
    private boolean p = true;
    private int pa;
    boolean q = true;
    private C0321l qa;
    boolean r = true;
    private C0322m ra;
    boolean s = false;
    private boolean sa = false;
    private boolean t = true;
    private Queue<a> ta = new LinkedList();
    private boolean u = false;
    public MapStatusUpdate ua = null;
    private C0318i v;
    private boolean va = false;
    private C0317h w;
    private boolean wa = false;
    private Context x;
    List<x> y;
    com.baidu.mapsdkplatform.comjni.map.basemap.a z;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f15022a;

        /* renamed from: b  reason: collision with root package name */
        public int f15023b;

        /* renamed from: c  reason: collision with root package name */
        public int f15024c;

        /* renamed from: d  reason: collision with root package name */
        public int f15025d;

        /* renamed from: e  reason: collision with root package name */
        public Bundle f15026e;

        public a(long j2, int i2, int i3, int i4) {
            this.f15022a = j2;
            this.f15023b = i2;
            this.f15024c = i3;
            this.f15025d = i4;
        }

        public a(Bundle bundle) {
            this.f15026e = bundle;
        }
    }

    public o(Context context, String str, int i2) {
        this.x = context;
        this.y = new ArrayList();
        this.oa = str;
        this.pa = i2;
    }

    private void R() {
        if (this.n || this.k || this.f15021j || this.o) {
            if (this.f15018g > 20.0f) {
                this.f15018g = 20.0f;
            }
            if (e().f14965a > 20.0f) {
                C0310a e2 = e();
                e2.f14965a = 20.0f;
                a(e2);
                return;
            }
            return;
        }
        this.f15018g = this.f15020i;
    }

    private void S() {
        if (!this.ka) {
            this.ka = true;
            this.la = false;
            List<x> list = this.y;
            if (list != null) {
                for (x next : list) {
                    if (next != null) {
                        next.c(e());
                    }
                }
            }
        }
    }

    private boolean T() {
        if (this.z == null || !this.L) {
            return true;
        }
        this.da = false;
        if (!this.q) {
            return false;
        }
        float f2 = (float) (this.ja - this.ia);
        float abs = (Math.abs(this.ga - this.ea) * 1000.0f) / f2;
        float abs2 = (Math.abs(this.ha - this.fa) * 1000.0f) / f2;
        float sqrt = (float) Math.sqrt((double) ((abs * abs) + (abs2 * abs2)));
        if (sqrt <= 500.0f) {
            return false;
        }
        a();
        a(34, (int) (sqrt * 0.6f), (((int) this.ha) << 16) | ((int) this.ga));
        m();
        return true;
    }

    private Activity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private void a(C0323n nVar) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            nVar.f15008a = aVar.a(nVar.f15010c, nVar.f15011d, nVar.f15009b);
            this.B.add(nVar);
        }
    }

    private void a(String str, String str2, long j2) {
        try {
            Class<?> cls = Class.forName(str);
            Object newInstance = cls.newInstance();
            cls.getMethod(str2, new Class[]{Long.TYPE}).invoke(newInstance, new Object[]{Long.valueOf(j2)});
        } catch (Exception e2) {
        }
    }

    private void b(MotionEvent motionEvent) {
        if (!this.Q.f15057e) {
            long downTime = motionEvent.getDownTime();
            this.ba = downTime;
            if (downTime - this.aa < 400) {
                downTime = (Math.abs(motionEvent.getX() - this.X) >= 120.0f || Math.abs(motionEvent.getY() - this.Y) >= 120.0f) ? this.ba : 0;
            }
            this.aa = downTime;
            this.X = motionEvent.getX();
            this.Y = motionEvent.getY();
            a(4, 0, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()));
            this.Z = true;
        }
    }

    private void b(String str, Bundle bundle) {
        if (this.z != null) {
            this.E.a(str);
            this.E.a(bundle);
            this.z.b(this.E.f15008a);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.Q.f15057e || System.currentTimeMillis() - f15016e < 300) {
            return true;
        }
        if (this.ma) {
            List<x> list = this.y;
            if (list != null) {
                for (x next : list) {
                    GeoPoint b2 = b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (next != null) {
                        next.b(b2);
                    }
                }
            }
            return true;
        }
        float abs = Math.abs(motionEvent.getX() - this.X);
        float abs2 = Math.abs(motionEvent.getY() - this.Y);
        float density = (float) (((double) SysOSUtil.getDensity()) > 1.5d ? ((double) SysOSUtil.getDensity()) * 1.5d : (double) SysOSUtil.getDensity());
        if (this.Z && abs / density <= 3.0f && abs2 / density <= 3.0f) {
            return true;
        }
        this.Z = false;
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (x2 < 0) {
            x2 = 0;
        }
        if (y2 < 0) {
            y2 = 0;
        }
        if (this.q) {
            BaiduMap.mapStatusReason = 1 | BaiduMap.mapStatusReason;
            S();
            a(3, 0, (y2 << 16) | x2);
        }
        return false;
    }

    private boolean d(MotionEvent motionEvent) {
        if (this.ma) {
            List<x> list = this.y;
            if (list != null) {
                for (x next : list) {
                    GeoPoint b2 = b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (next != null) {
                        next.a(b2);
                    }
                }
            }
            this.ma = false;
            return true;
        }
        boolean z2 = !this.Q.f15057e && motionEvent.getEventTime() - this.ba < 400 && Math.abs(motionEvent.getX() - this.X) < 10.0f && Math.abs(motionEvent.getY() - this.Y) < 10.0f;
        m();
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (z2) {
            return false;
        }
        if (x2 < 0) {
            x2 = 0;
        }
        if (y2 < 0) {
            y2 = 0;
        }
        a(5, 0, (y2 << 16) | x2);
        return true;
    }

    private boolean e(float f2, float f3) {
        if (this.z == null || !this.L) {
            return true;
        }
        this.ca = false;
        GeoPoint b2 = b((int) f2, (int) f3);
        if (b2 != null) {
            List<x> list = this.y;
            if (list != null) {
                for (x next : list) {
                    if (next != null) {
                        next.d(b2);
                    }
                }
            }
            if (this.r) {
                C0310a e2 = e();
                e2.f14965a += 1.0f;
                e2.f14968d = b2.getLongitudeE6();
                e2.f14969e = b2.getLatitudeE6();
                a(e2, 300);
                f15016e = System.currentTimeMillis();
                return true;
            }
        }
        return false;
    }

    private boolean e(Bundle bundle) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        return aVar.d(bundle);
    }

    private boolean f(Bundle bundle) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        if (bundle == null || (aVar = this.z) == null) {
            return false;
        }
        boolean c2 = aVar.c(bundle);
        if (c2) {
            f(c2);
            this.z.b(this.v.f15008a);
        }
        return c2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r4 = (android.os.Bundle) r4.get("param");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g(android.os.Bundle r4) {
        /*
            r3 = this;
            java.lang.String r0 = "param"
            java.lang.Object r1 = r4.get(r0)
            java.lang.String r2 = "type"
            if (r1 == 0) goto L_0x0028
            java.lang.Object r4 = r4.get(r0)
            android.os.Bundle r4 = (android.os.Bundle) r4
            int r0 = r4.getInt(r2)
            com.baidu.mapsdkplatform.comapi.map.t r1 = com.baidu.mapsdkplatform.comapi.map.t.ground
            int r1 = r1.ordinal()
            if (r0 != r1) goto L_0x001f
            goto L_0x0043
        L_0x001f:
            com.baidu.mapsdkplatform.comapi.map.t r1 = com.baidu.mapsdkplatform.comapi.map.t.f15039f
            int r1 = r1.ordinal()
            if (r0 < r1) goto L_0x003e
            goto L_0x0043
        L_0x0028:
            int r0 = r4.getInt(r2)
            com.baidu.mapsdkplatform.comapi.map.t r1 = com.baidu.mapsdkplatform.comapi.map.t.ground
            int r1 = r1.ordinal()
            if (r0 != r1) goto L_0x0035
            goto L_0x0043
        L_0x0035:
            com.baidu.mapsdkplatform.comapi.map.t r1 = com.baidu.mapsdkplatform.comapi.map.t.f15039f
            int r1 = r1.ordinal()
            if (r0 < r1) goto L_0x003e
            goto L_0x0043
        L_0x003e:
            com.baidu.mapsdkplatform.comapi.map.t r0 = com.baidu.mapsdkplatform.comapi.map.t.popup
            r0.ordinal()
        L_0x0043:
            com.baidu.mapsdkplatform.comapi.map.g r0 = r3.G
            long r0 = r0.f15008a
            java.lang.String r2 = "layer_addr"
            r4.putLong(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.o.g(android.os.Bundle):void");
    }

    static void m(boolean z2) {
        List<JNIBaseMap> b2 = com.baidu.mapsdkplatform.comjni.map.basemap.a.b();
        f15017f = b2;
        if (b2 == null || b2.size() == 0) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a.c(0, z2);
            return;
        }
        com.baidu.mapsdkplatform.comjni.map.basemap.a.c(f15017f.get(0).f15124a, z2);
        for (JNIBaseMap next : f15017f) {
            if (next != null) {
                next.ClearLayer(next.f15124a, -1);
            }
        }
    }

    public boolean A() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        return aVar.k();
    }

    public boolean B() {
        return this.k;
    }

    public boolean C() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        return aVar.a(this.na.f15008a);
    }

    public boolean D() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        return aVar.o();
    }

    public void E() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.d(this.G.f15008a);
        }
    }

    public void F() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.p();
            this.z.b(this.H.f15008a);
        }
    }

    public MapBaseIndoorMapInfo G() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return null;
        }
        return aVar.q();
    }

    public boolean H() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        return aVar.r();
    }

    public boolean I() {
        return this.l;
    }

    public boolean J() {
        return this.m;
    }

    public void K() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.b(this.H.f15008a);
        }
    }

    /* access modifiers changed from: package-private */
    public void L() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.e();
        }
    }

    /* access modifiers changed from: package-private */
    public void M() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.f();
        }
    }

    public boolean N() {
        return this.q;
    }

    public boolean O() {
        return this.r;
    }

    public boolean P() {
        return this.t;
    }

    public boolean Q() {
        return this.p;
    }

    public float a(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (!this.L) {
            return 12.0f;
        }
        if (this.z == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", i2);
        bundle.putInt("right", i4);
        bundle.putInt("bottom", i5);
        bundle.putInt("top", i3);
        bundle.putInt("hasHW", 1);
        bundle.putInt("width", i6);
        bundle.putInt("height", i7);
        return this.z.b(bundle);
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, int i3, int i4) {
        if (!this.sa) {
            return com.baidu.mapsdkplatform.comjni.map.basemap.a.a(this.A, i2, i3, i4);
        }
        this.ta.add(new a(this.A, i2, i3, i4));
        return 0;
    }

    public int a(Bundle bundle, long j2, int i2, Bundle bundle2) {
        C0315f fVar;
        q qVar = this.E;
        if (j2 == qVar.f15008a) {
            bundle.putString("jsondata", qVar.a());
            bundle.putBundle("param", this.E.b());
            fVar = this.E;
        } else {
            K k2 = this.D;
            if (j2 == k2.f15008a) {
                bundle.putString("jsondata", k2.a());
                bundle.putBundle("param", this.D.b());
                fVar = this.D;
            } else if (j2 == this.H.f15008a) {
                bundle.putBundle("param", this.J.a(bundle2.getInt("x"), bundle2.getInt("y"), bundle2.getInt(FpsReportManager.Type.TYPE_ZOOM)));
                fVar = this.H;
            } else if (j2 != this.v.f15008a) {
                return 0;
            } else {
                bundle.putBundle("param", this.w.a(bundle2.getInt("x"), bundle2.getInt("y"), bundle2.getInt(FpsReportManager.Type.TYPE_ZOOM), this.x));
                fVar = this.v;
            }
        }
        return fVar.f14997g;
    }

    public Point a(GeoPoint geoPoint) {
        return this.K.a(geoPoint);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!this.ka && !this.la) {
            this.la = true;
            List<x> list = this.y;
            if (list != null) {
                for (x next : list) {
                    if (next != null) {
                        next.c(e());
                    }
                }
            }
        }
    }

    public void a(float f2, float f3) {
        this.f15018g = f2;
        this.f15020i = f2;
        this.f15019h = f3;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = new com.baidu.mapsdkplatform.comjni.map.basemap.a();
        this.z = aVar;
        aVar.a(i2);
        long a2 = this.z.a();
        this.A = a2;
        a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", a2);
        this.P = SysOSUtil.getDensityDpi() < 180 ? 18 : SysOSUtil.getDensityDpi() < 240 ? 25 : SysOSUtil.getDensityDpi() < 320 ? 37 : 50;
        String moduleFileName = SysOSUtil.getModuleFileName();
        String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
        String appCachePath = EnvironmentUtilities.getAppCachePath();
        String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
        int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
        int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
        int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
        String str = SysOSUtil.getDensityDpi() >= 180 ? "/h/" : "/l/";
        String str2 = moduleFileName + "/cfg";
        String str3 = appSDCardPath + "/vmp";
        String str4 = str2 + "/a/";
        String str5 = str2 + "/a/";
        String str6 = str2 + "/idrres/";
        String str7 = str3 + str;
        String str8 = str3 + str;
        String str9 = appCachePath + "/tmp/";
        String str10 = appSecondCachePath + "/tmp/";
        Activity a3 = a(this.x);
        if (a3 != null) {
            Display defaultDisplay = a3.getWindowManager().getDefaultDisplay();
            this.z.a(str4, str7, str9, str10, str8, str5, this.oa, this.pa, str6, defaultDisplay.getWidth(), defaultDisplay.getHeight(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
            return;
        }
        throw new RuntimeException("BDMapSDKException: Please give the right context.");
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        this.M = i2;
        this.N = i3;
    }

    public void a(long j2, long j3, long j4, long j5, boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.a(j2, j3, j4, j5, z2);
        }
    }

    public void a(Bitmap bitmap) {
        Bundle bundle;
        if (this.z != null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("type", 0);
                jSONObject2.put("x", f15014c);
                jSONObject2.put("y", f15015d);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (bitmap == null) {
                bundle = null;
            } else {
                Bundle bundle2 = new Bundle();
                ArrayList arrayList = new ArrayList();
                ParcelItem parcelItem = new ParcelItem();
                Bundle bundle3 = new Bundle();
                ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
                bitmap.copyPixelsToBuffer(allocate);
                bundle3.putByteArray("imgdata", allocate.array());
                bundle3.putInt("imgindex", bitmap.hashCode());
                bundle3.putInt("imgH", bitmap.getHeight());
                bundle3.putInt("imgW", bitmap.getWidth());
                bundle3.putInt("hasIcon", 1);
                parcelItem.setBundle(bundle3);
                arrayList.add(parcelItem);
                if (arrayList.size() > 0) {
                    ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        parcelItemArr[i2] = (ParcelItem) arrayList.get(i2);
                    }
                    bundle2.putParcelableArray("icondata", parcelItemArr);
                }
                bundle = bundle2;
            }
            b(jSONObject.toString(), bundle);
            this.z.b(this.E.f15008a);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Handler handler) {
        MessageCenter.registMessage(4000, handler);
        MessageCenter.registMessage(39, handler);
        MessageCenter.registMessage(41, handler);
        MessageCenter.registMessage(49, handler);
        MessageCenter.registMessage(65289, handler);
        MessageCenter.registMessage(50, handler);
        MessageCenter.registMessage(999, handler);
        BaseMapCallback.addLayerDataInterface(this.A, this);
    }

    public void a(MapLayer mapLayer, MapLayer mapLayer2) {
        if (this.z != null) {
            C0323n nVar = this.C.get(mapLayer);
            C0323n nVar2 = this.C.get(mapLayer2);
            if (nVar != null && nVar2 != null) {
                this.z.a(nVar.f15008a, nVar2.f15008a);
            }
        }
    }

    public void a(MapLayer mapLayer, boolean z2) {
        C0323n nVar;
        if (this.z != null && (nVar = this.C.get(mapLayer)) != null) {
            this.z.b(nVar.f15008a, z2);
        }
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.ua = mapStatusUpdate;
    }

    public void a(LatLngBounds latLngBounds) {
        if (latLngBounds != null && this.z != null) {
            LatLng latLng = latLngBounds.northeast;
            LatLng latLng2 = latLngBounds.southwest;
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
            int longitudeE6 = (int) ll2mc2.getLongitudeE6();
            int latitudeE6 = (int) ll2mc.getLatitudeE6();
            Bundle bundle = new Bundle();
            bundle.putInt("maxCoorx", (int) ll2mc.getLongitudeE6());
            bundle.putInt("minCoory", (int) ll2mc2.getLatitudeE6());
            bundle.putInt("minCoorx", longitudeE6);
            bundle.putInt("maxCoory", latitudeE6);
            this.z.a(bundle);
        }
    }

    public void a(B b2) {
        this.J = b2;
    }

    /* access modifiers changed from: package-private */
    public void a(M m2) {
        new C0310a();
        if (m2 == null) {
            m2 = new M();
        }
        C0310a aVar = m2.f14948a;
        this.p = m2.f14953f;
        this.t = m2.f14951d;
        this.q = m2.f14952e;
        this.r = m2.f14954g;
        this.z.a(aVar.a(this), false);
        this.z.c(L.DEFAULT.ordinal());
        boolean z2 = m2.f14949b;
        this.l = z2;
        if (!z2) {
            this.z.a(this.E.f15008a, false);
        } else {
            f15014c = (int) (SysOSUtil.getDensity() * 40.0f);
            f15015d = (int) (SysOSUtil.getDensity() * 40.0f);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("x", f15014c);
                jSONObject2.put("y", f15015d);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.E.a(jSONObject.toString());
            this.z.a(this.E.f15008a, true);
        }
        int i2 = m2.f14950c;
        if (i2 == 2) {
            a(true);
        }
        if (i2 == 3) {
            this.z.a(this.na.f15008a, false);
            this.z.a(this.ra.f15008a, false);
            this.z.a(this.F.f15008a, false);
            this.z.e(false);
        }
    }

    public void a(C0310a aVar) {
        if (this.z != null && aVar != null) {
            Bundle a2 = aVar.a(this);
            a2.putInt("animation", 0);
            a2.putInt("animatime", 0);
            this.z.a(a2, true);
        }
    }

    public void a(C0310a aVar, int i2) {
        if (this.z != null && aVar != null) {
            Bundle a2 = aVar.a(this);
            a2.putInt("animation", 1);
            a2.putInt("animatime", i2);
            if (this.sa) {
                this.ta.add(new a(a2));
                return;
            }
            a();
            this.z.a(a2, false);
        }
    }

    public void a(C0317h hVar) {
        this.w = hVar;
    }

    public void a(x xVar) {
        List<x> list;
        if (xVar != null && (list = this.y) != null) {
            list.add(xVar);
        }
    }

    public void a(String str, int i2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.a(str, i2);
        }
    }

    public void a(String str, Bundle bundle) {
        if (this.z != null) {
            this.D.a(str);
            this.D.a(bundle);
            this.z.b(this.D.f15008a);
        }
    }

    public void a(List<Bundle> list) {
        if (this.z != null && list != null) {
            int size = list.size();
            Bundle[] bundleArr = new Bundle[list.size()];
            for (int i2 = 0; i2 < size; i2++) {
                g(list.get(i2));
                bundleArr[i2] = list.get(i2);
            }
            this.z.a(bundleArr);
        }
    }

    public void a(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            if (!aVar.a(this.na.f15008a)) {
                this.z.a(this.na.f15008a, true);
            }
            this.k = z2;
            R();
            this.z.a(this.k);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(float r24, float r25, float r26, float r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r26
            int r3 = r0.N
            float r3 = (float) r3
            float r4 = r3 - r25
            float r3 = r3 - r27
            com.baidu.mapsdkplatform.comapi.map.w$a r5 = r0.Q
            boolean r6 = r5.f15057e
            r10 = 1
            if (r6 != r10) goto L_0x01df
            int r6 = r0.O
            r14 = 4640537203540230144(0x4066800000000000, double:180.0)
            r16 = 4666723172467343360(0x40c3880000000000, double:10000.0)
            r18 = 4611686018427387904(0x4000000000000000, double:2.0)
            r20 = 0
            if (r6 != 0) goto L_0x00a9
            float r6 = r5.f15055c
            float r6 = r6 - r4
            int r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r6 <= 0) goto L_0x0034
            float r5 = r5.f15056d
            float r5 = r5 - r3
            int r5 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r5 > 0) goto L_0x0044
        L_0x0034:
            com.baidu.mapsdkplatform.comapi.map.w$a r5 = r0.Q
            float r6 = r5.f15055c
            float r6 = r6 - r4
            int r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r6 >= 0) goto L_0x00a0
            float r5 = r5.f15056d
            float r5 = r5 - r3
            int r5 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r5 >= 0) goto L_0x00a0
        L_0x0044:
            float r5 = r3 - r4
            double r9 = (double) r5
            float r6 = r2 - r1
            double r7 = (double) r6
            double r7 = java.lang.Math.atan2(r9, r7)
            com.baidu.mapsdkplatform.comapi.map.w$a r9 = r0.Q
            float r10 = r9.f15056d
            float r11 = r9.f15055c
            float r10 = r10 - r11
            double r10 = (double) r10
            float r12 = r9.f15054b
            float r9 = r9.f15053a
            float r12 = r12 - r9
            double r12 = (double) r12
            double r9 = java.lang.Math.atan2(r10, r12)
            double r7 = r7 - r9
            float r6 = r6 * r6
            float r5 = r5 * r5
            float r6 = r6 + r5
            double r5 = (double) r6
            double r5 = java.lang.Math.sqrt(r5)
            com.baidu.mapsdkplatform.comapi.map.w$a r9 = r0.Q
            double r9 = r9.f15060h
            double r5 = r5 / r9
            double r9 = java.lang.Math.log(r5)
            double r11 = java.lang.Math.log(r18)
            double r9 = r9 / r11
            double r9 = r9 * r16
            int r9 = (int) r9
            double r7 = r7 * r14
            r10 = 4614256673094690983(0x400921ff2e48e8a7, double:3.1416)
            double r7 = r7 / r10
            int r7 = (int) r7
            r10 = 0
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x0093
            r5 = 3000(0xbb8, float:4.204E-42)
            if (r9 > r5) goto L_0x0091
            r5 = -3000(0xfffffffffffff448, float:NaN)
            if (r9 < r5) goto L_0x0091
            goto L_0x0093
        L_0x0091:
            r5 = 1
            goto L_0x00a1
        L_0x0093:
            int r5 = java.lang.Math.abs(r7)
            r6 = 10
            if (r5 < r6) goto L_0x009c
            goto L_0x0091
        L_0x009c:
            r5 = 1
            r0.O = r5
            goto L_0x00a4
        L_0x00a0:
            r5 = r10
        L_0x00a1:
            r6 = 2
            r0.O = r6
        L_0x00a4:
            int r6 = r0.O
            if (r6 != 0) goto L_0x00aa
            return r5
        L_0x00a9:
            r5 = r10
        L_0x00aa:
            int r6 = r0.O
            r7 = 0
            if (r6 != r5) goto L_0x00e4
            boolean r5 = r0.p
            if (r5 == 0) goto L_0x00e4
            com.baidu.mapsdkplatform.comapi.map.w$a r5 = r0.Q
            float r6 = r5.f15055c
            float r6 = r6 - r4
            int r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r6 <= 0) goto L_0x00ce
            float r5 = r5.f15056d
            float r5 = r5 - r3
            int r5 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x00ce
            r23.S()
            r5 = 83
        L_0x00c8:
            r6 = 1
            r0.a((int) r6, (int) r5, (int) r7)
            goto L_0x01df
        L_0x00ce:
            com.baidu.mapsdkplatform.comapi.map.w$a r5 = r0.Q
            float r6 = r5.f15055c
            float r6 = r6 - r4
            int r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r6 >= 0) goto L_0x01df
            float r5 = r5.f15056d
            float r5 = r5 - r3
            int r5 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r5 >= 0) goto L_0x01df
            r23.S()
            r5 = 87
            goto L_0x00c8
        L_0x00e4:
            r5 = 4
            r8 = 3
            r9 = 2
            if (r6 == r9) goto L_0x00ed
            if (r6 == r5) goto L_0x00ed
            if (r6 != r8) goto L_0x01df
        L_0x00ed:
            float r6 = r3 - r4
            double r9 = (double) r6
            float r11 = r2 - r1
            double r12 = (double) r11
            double r9 = java.lang.Math.atan2(r9, r12)
            com.baidu.mapsdkplatform.comapi.map.w$a r12 = r0.Q
            float r13 = r12.f15056d
            float r5 = r12.f15055c
            float r13 = r13 - r5
            double r7 = (double) r13
            float r13 = r12.f15054b
            float r12 = r12.f15053a
            float r13 = r13 - r12
            double r12 = (double) r13
            double r7 = java.lang.Math.atan2(r7, r12)
            double r9 = r9 - r7
            float r11 = r11 * r11
            float r6 = r6 * r6
            float r11 = r11 + r6
            double r6 = (double) r11
            double r6 = java.lang.Math.sqrt(r6)
            com.baidu.mapsdkplatform.comapi.map.w$a r8 = r0.Q
            double r11 = r8.f15060h
            double r6 = r6 / r11
            double r11 = java.lang.Math.log(r6)
            double r18 = java.lang.Math.log(r18)
            double r11 = r11 / r18
            double r11 = r11 * r16
            int r8 = (int) r11
            com.baidu.mapsdkplatform.comapi.map.w$a r11 = r0.Q
            float r12 = r11.f15059g
            float r13 = r11.f15055c
            float r12 = r12 - r13
            double r12 = (double) r12
            float r5 = r11.f15058f
            float r11 = r11.f15053a
            float r5 = r5 - r11
            double r14 = (double) r5
            double r11 = java.lang.Math.atan2(r12, r14)
            com.baidu.mapsdkplatform.comapi.map.w$a r5 = r0.Q
            float r13 = r5.f15058f
            float r14 = r5.f15053a
            float r13 = r13 - r14
            float r13 = r13 * r13
            float r14 = r5.f15059g
            float r5 = r5.f15055c
            float r14 = r14 - r5
            float r14 = r14 * r14
            float r13 = r13 + r14
            double r13 = (double) r13
            double r13 = java.lang.Math.sqrt(r13)
            double r11 = r11 + r9
            double r21 = java.lang.Math.cos(r11)
            double r21 = r21 * r13
            double r21 = r21 * r6
            r5 = r3
            double r2 = (double) r1
            double r2 = r21 + r2
            float r2 = (float) r2
            double r11 = java.lang.Math.sin(r11)
            double r13 = r13 * r11
            double r13 = r13 * r6
            double r11 = (double) r4
            double r13 = r13 + r11
            float r3 = (float) r13
            r11 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r9 = r9 * r11
            r11 = 4614256673094690983(0x400921ff2e48e8a7, double:3.1416)
            double r9 = r9 / r11
            int r9 = (int) r9
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            r10 = 8193(0x2001, float:1.1481E-41)
            if (r12 <= 0) goto L_0x01b2
            int r11 = r0.O
            r12 = 3
            if (r12 == r11) goto L_0x0188
            int r11 = java.lang.Math.abs(r8)
            r13 = 2000(0x7d0, float:2.803E-42)
            if (r11 <= r13) goto L_0x01b2
            int r11 = r0.O
            r13 = 2
            if (r13 != r11) goto L_0x01b2
        L_0x0188:
            r0.O = r12
            com.baidu.mapsdkplatform.comapi.map.a r9 = r23.e()
            float r9 = r9.f14965a
            boolean r11 = r0.r
            if (r11 == 0) goto L_0x01d8
            r11 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 <= 0) goto L_0x01a2
            float r6 = r0.f15018g
            int r6 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x01aa
            r6 = 0
            return r6
        L_0x01a2:
            r6 = 0
            float r7 = r0.f15019h
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x01aa
            return r6
        L_0x01aa:
            r23.S()
            r6 = 3
            r0.a((int) r10, (int) r6, (int) r8)
            goto L_0x01d8
        L_0x01b2:
            if (r9 == 0) goto L_0x01d8
            int r6 = r0.O
            r7 = 4
            if (r7 == r6) goto L_0x01c6
            int r6 = java.lang.Math.abs(r9)
            r8 = 10
            if (r6 <= r8) goto L_0x01d8
            int r6 = r0.O
            r8 = 2
            if (r8 != r6) goto L_0x01d8
        L_0x01c6:
            r0.O = r7
            boolean r6 = r0.t
            if (r6 == 0) goto L_0x01d8
            int r6 = com.baidu.mapapi.map.BaiduMap.mapStatusReason
            r7 = 1
            r6 = r6 | r7
            com.baidu.mapapi.map.BaiduMap.mapStatusReason = r6
            r23.S()
            r0.a((int) r10, (int) r7, (int) r9)
        L_0x01d8:
            com.baidu.mapsdkplatform.comapi.map.w$a r6 = r0.Q
            r6.f15058f = r2
            r6.f15059g = r3
            goto L_0x01e0
        L_0x01df:
            r5 = r3
        L_0x01e0:
            int r2 = r0.O
            r3 = 2
            if (r3 == r2) goto L_0x01f1
            com.baidu.mapsdkplatform.comapi.map.w$a r2 = r0.Q
            r2.f15055c = r4
            r2.f15056d = r5
            r2.f15053a = r1
            r1 = r26
            r2.f15054b = r1
        L_0x01f1:
            com.baidu.mapsdkplatform.comapi.map.w$a r1 = r0.Q
            boolean r2 = r1.f15057e
            if (r2 != 0) goto L_0x0225
            int r2 = r0.M
            r3 = 2
            int r2 = r2 / r3
            float r2 = (float) r2
            r1.f15058f = r2
            int r2 = r0.N
            int r2 = r2 / r3
            float r2 = (float) r2
            r1.f15059g = r2
            r2 = 1
            r1.f15057e = r2
            double r2 = r1.f15060h
            r4 = 0
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0225
            float r2 = r1.f15054b
            float r3 = r1.f15053a
            float r2 = r2 - r3
            float r2 = r2 * r2
            float r3 = r1.f15056d
            float r1 = r1.f15055c
            float r3 = r3 - r1
            float r3 = r3 * r3
            float r2 = r2 + r3
            double r1 = (double) r2
            double r1 = java.lang.Math.sqrt(r1)
            com.baidu.mapsdkplatform.comapi.map.w$a r0 = r0.Q
            r0.f15060h = r1
        L_0x0225:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.o.a(float, float, float, float):boolean");
    }

    public boolean a(long j2) {
        for (C0323n nVar : this.B) {
            if (nVar.f15008a == j2) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Point point) {
        int i2;
        int i3;
        if (point == null || this.z == null || (i2 = point.x) < 0 || (i3 = point.y) < 0) {
            return false;
        }
        f15014c = i2;
        f15015d = i3;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("x", f15014c);
            jSONObject2.put("y", f15015d);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.E.a(jSONObject.toString());
        this.z.b(this.E.f15008a);
        return true;
    }

    public boolean a(Bundle bundle) {
        if (this.z == null) {
            return false;
        }
        C0318i iVar = new C0318i();
        this.v = iVar;
        long a2 = this.z.a(iVar.f15010c, iVar.f15011d, iVar.f15009b);
        if (a2 != 0) {
            C0318i iVar2 = this.v;
            iVar2.f15008a = a2;
            this.B.add(iVar2);
            bundle.putLong("sdktileaddr", a2);
            return e(bundle) && f(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01d1 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r26) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            int r2 = r26.getPointerCount()
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 != r4) goto L_0x002e
            float r6 = r1.getX(r3)
            int r6 = (int) r6
            float r7 = r1.getY(r3)
            int r7 = (int) r7
            boolean r6 = r0.c((int) r6, (int) r7)
            if (r6 == 0) goto L_0x002d
            float r6 = r1.getX(r5)
            int r6 = (int) r6
            float r7 = r1.getY(r5)
            int r7 = (int) r7
            boolean r6 = r0.c((int) r6, (int) r7)
            if (r6 != 0) goto L_0x002e
        L_0x002d:
            r2 = r5
        L_0x002e:
            if (r2 != r4) goto L_0x0363
            int r2 = r0.N
            float r2 = (float) r2
            float r6 = r1.getY(r3)
            float r2 = r2 - r6
            int r6 = r0.N
            float r6 = (float) r6
            float r7 = r1.getY(r5)
            float r6 = r6 - r7
            float r7 = r1.getX(r3)
            float r8 = r1.getX(r5)
            int r9 = r26.getAction()
            r10 = 5
            if (r9 == r10) goto L_0x0073
            r10 = 6
            if (r9 == r10) goto L_0x0069
            r10 = 261(0x105, float:3.66E-43)
            if (r9 == r10) goto L_0x0062
            r10 = 262(0x106, float:3.67E-43)
            if (r9 == r10) goto L_0x005b
            goto L_0x007e
        L_0x005b:
            long r9 = r26.getEventTime()
            r0.U = r9
            goto L_0x006f
        L_0x0062:
            long r9 = r26.getEventTime()
            r0.S = r9
            goto L_0x0079
        L_0x0069:
            long r9 = r26.getEventTime()
            r0.V = r9
        L_0x006f:
            int r9 = r0.W
            int r9 = r9 + r5
            goto L_0x007c
        L_0x0073:
            long r9 = r26.getEventTime()
            r0.T = r9
        L_0x0079:
            int r9 = r0.W
            int r9 = r9 - r5
        L_0x007c:
            r0.W = r9
        L_0x007e:
            android.view.VelocityTracker r9 = r0.R
            if (r9 != 0) goto L_0x0088
            android.view.VelocityTracker r9 = android.view.VelocityTracker.obtain()
            r0.R = r9
        L_0x0088:
            android.view.VelocityTracker r9 = r0.R
            r9.addMovement(r1)
            android.content.Context r1 = com.baidu.mapapi.JNIInitializer.getCachedContext()
            android.view.ViewConfiguration r1 = android.view.ViewConfiguration.get(r1)
            if (r1 != 0) goto L_0x00a0
            int r1 = android.view.ViewConfiguration.getMinimumFlingVelocity()
            int r9 = android.view.ViewConfiguration.getMaximumFlingVelocity()
            goto L_0x00ad
        L_0x00a0:
            int r9 = r1.getScaledMinimumFlingVelocity()
            int r1 = r1.getScaledMaximumFlingVelocity()
            r24 = r9
            r9 = r1
            r1 = r24
        L_0x00ad:
            android.view.VelocityTracker r10 = r0.R
            float r9 = (float) r9
            r11 = 1000(0x3e8, float:1.401E-42)
            r10.computeCurrentVelocity(r11, r9)
            android.view.VelocityTracker r9 = r0.R
            float r9 = r9.getXVelocity(r5)
            android.view.VelocityTracker r10 = r0.R
            float r10 = r10.getYVelocity(r5)
            android.view.VelocityTracker r11 = r0.R
            float r11 = r11.getXVelocity(r4)
            android.view.VelocityTracker r12 = r0.R
            float r12 = r12.getYVelocity(r4)
            float r9 = java.lang.Math.abs(r9)
            float r1 = (float) r1
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 > 0) goto L_0x0132
            float r9 = java.lang.Math.abs(r10)
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 > 0) goto L_0x0132
            float r9 = java.lang.Math.abs(r11)
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 > 0) goto L_0x0132
            float r9 = java.lang.Math.abs(r12)
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ef
            goto L_0x0132
        L_0x00ef:
            int r1 = r0.O
            if (r1 != 0) goto L_0x0319
            int r1 = r0.W
            if (r1 != 0) goto L_0x0319
            long r9 = r0.U
            long r11 = r0.V
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            r9 = r11
        L_0x0101:
            r0.U = r9
            long r11 = r0.S
            long r13 = r0.T
            int r1 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r1 >= 0) goto L_0x010c
            r11 = r13
        L_0x010c:
            r0.S = r11
            long r9 = r9 - r11
            r11 = 200(0xc8, double:9.9E-322)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x0319
            boolean r1 = r0.r
            if (r1 == 0) goto L_0x0319
            com.baidu.mapsdkplatform.comapi.map.a r1 = r25.e()
            if (r1 == 0) goto L_0x0319
            float r3 = r1.f14965a
            r9 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 - r9
            r1.f14965a = r3
            int r3 = com.baidu.mapapi.map.BaiduMap.mapStatusReason
            r3 = r3 | r5
            com.baidu.mapapi.map.BaiduMap.mapStatusReason = r3
            r3 = 300(0x12c, float:4.2E-43)
            r0.a((com.baidu.mapsdkplatform.comapi.map.C0310a) r1, (int) r3)
            goto L_0x0319
        L_0x0132:
            com.baidu.mapsdkplatform.comapi.map.w$a r1 = r0.Q
            boolean r9 = r1.f15057e
            if (r9 == 0) goto L_0x0319
            int r9 = r0.O
            r13 = 4640537203540230144(0x4066800000000000, double:180.0)
            r16 = 4666723172467343360(0x40c3880000000000, double:10000.0)
            r18 = 4611686018427387904(0x4000000000000000, double:2.0)
            r20 = 0
            if (r9 != 0) goto L_0x01d2
            float r9 = r1.f15055c
            float r9 = r9 - r2
            int r9 = (r9 > r20 ? 1 : (r9 == r20 ? 0 : -1))
            if (r9 <= 0) goto L_0x0158
            float r1 = r1.f15056d
            float r1 = r1 - r6
            int r1 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r1 > 0) goto L_0x0168
        L_0x0158:
            com.baidu.mapsdkplatform.comapi.map.w$a r1 = r0.Q
            float r9 = r1.f15055c
            float r9 = r9 - r2
            int r9 = (r9 > r20 ? 1 : (r9 == r20 ? 0 : -1))
            if (r9 >= 0) goto L_0x01c7
            float r1 = r1.f15056d
            float r1 = r1 - r6
            int r1 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r1 >= 0) goto L_0x01c7
        L_0x0168:
            float r1 = r6 - r2
            double r3 = (double) r1
            float r9 = r8 - r7
            r21 = r6
            double r5 = (double) r9
            double r3 = java.lang.Math.atan2(r3, r5)
            com.baidu.mapsdkplatform.comapi.map.w$a r5 = r0.Q
            float r6 = r5.f15056d
            float r15 = r5.f15055c
            float r6 = r6 - r15
            double r10 = (double) r6
            float r6 = r5.f15054b
            float r5 = r5.f15053a
            float r6 = r6 - r5
            double r5 = (double) r6
            double r5 = java.lang.Math.atan2(r10, r5)
            double r3 = r3 - r5
            float r9 = r9 * r9
            float r1 = r1 * r1
            float r9 = r9 + r1
            double r5 = (double) r9
            double r5 = java.lang.Math.sqrt(r5)
            com.baidu.mapsdkplatform.comapi.map.w$a r1 = r0.Q
            double r9 = r1.f15060h
            double r5 = r5 / r9
            double r9 = java.lang.Math.log(r5)
            double r11 = java.lang.Math.log(r18)
            double r9 = r9 / r11
            double r9 = r9 * r16
            int r1 = (int) r9
            double r3 = r3 * r13
            r9 = 4614256673094690983(0x400921ff2e48e8a7, double:3.1416)
            double r3 = r3 / r9
            int r3 = (int) r3
            r9 = 0
            int r4 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x01ba
            r4 = 3000(0xbb8, float:4.204E-42)
            if (r1 > r4) goto L_0x01b7
            r4 = -3000(0xfffffffffffff448, float:NaN)
            if (r1 < r4) goto L_0x01b7
            goto L_0x01ba
        L_0x01b7:
            r1 = 1
            r3 = 2
            goto L_0x01cb
        L_0x01ba:
            int r1 = java.lang.Math.abs(r3)
            r3 = 10
            if (r1 < r3) goto L_0x01c3
            goto L_0x01b7
        L_0x01c3:
            r1 = 1
            r0.O = r1
            goto L_0x01cd
        L_0x01c7:
            r1 = r5
            r21 = r6
            r3 = r4
        L_0x01cb:
            r0.O = r3
        L_0x01cd:
            int r3 = r0.O
            if (r3 != 0) goto L_0x01d5
            return r1
        L_0x01d2:
            r1 = r5
            r21 = r6
        L_0x01d5:
            int r3 = r0.O
            if (r3 != r1) goto L_0x021c
            boolean r1 = r0.p
            if (r1 == 0) goto L_0x021c
            com.baidu.mapsdkplatform.comapi.map.w$a r1 = r0.Q
            float r3 = r1.f15055c
            float r3 = r3 - r2
            int r3 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r3 <= 0) goto L_0x01ff
            float r1 = r1.f15056d
            float r1 = r1 - r21
            int r1 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x01ff
            int r1 = com.baidu.mapapi.map.BaiduMap.mapStatusReason
            r3 = 1
            r1 = r1 | r3
            com.baidu.mapapi.map.BaiduMap.mapStatusReason = r1
            r25.S()
            r1 = 83
        L_0x01f9:
            r4 = 0
            r0.a((int) r3, (int) r1, (int) r4)
            goto L_0x031b
        L_0x01ff:
            com.baidu.mapsdkplatform.comapi.map.w$a r1 = r0.Q
            float r3 = r1.f15055c
            float r3 = r3 - r2
            int r3 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r3 >= 0) goto L_0x031b
            float r1 = r1.f15056d
            float r1 = r1 - r21
            int r1 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r1 >= 0) goto L_0x031b
            int r1 = com.baidu.mapapi.map.BaiduMap.mapStatusReason
            r3 = 1
            r1 = r1 | r3
            com.baidu.mapapi.map.BaiduMap.mapStatusReason = r1
            r25.S()
            r1 = 87
            goto L_0x01f9
        L_0x021c:
            r1 = 4
            r4 = 3
            r5 = 2
            if (r3 == r5) goto L_0x0225
            if (r3 == r1) goto L_0x0225
            if (r3 != r4) goto L_0x031b
        L_0x0225:
            float r6 = r21 - r2
            double r10 = (double) r6
            float r3 = r8 - r7
            double r4 = (double) r3
            double r4 = java.lang.Math.atan2(r10, r4)
            com.baidu.mapsdkplatform.comapi.map.w$a r10 = r0.Q
            float r11 = r10.f15056d
            float r12 = r10.f15055c
            float r11 = r11 - r12
            double r11 = (double) r11
            float r9 = r10.f15054b
            float r10 = r10.f15053a
            float r9 = r9 - r10
            double r9 = (double) r9
            double r9 = java.lang.Math.atan2(r11, r9)
            double r4 = r4 - r9
            float r3 = r3 * r3
            float r6 = r6 * r6
            float r3 = r3 + r6
            double r9 = (double) r3
            double r9 = java.lang.Math.sqrt(r9)
            com.baidu.mapsdkplatform.comapi.map.w$a r3 = r0.Q
            double r11 = r3.f15060h
            double r10 = r9 / r11
            double r22 = java.lang.Math.log(r10)
            double r18 = java.lang.Math.log(r18)
            double r22 = r22 / r18
            double r13 = r22 * r16
            int r3 = (int) r13
            com.baidu.mapsdkplatform.comapi.map.w$a r6 = r0.Q
            float r9 = r6.f15059g
            float r12 = r6.f15055c
            float r9 = r9 - r12
            double r12 = (double) r9
            float r9 = r6.f15058f
            float r6 = r6.f15053a
            float r9 = r9 - r6
            r6 = r2
            double r1 = (double) r9
            double r1 = java.lang.Math.atan2(r12, r1)
            com.baidu.mapsdkplatform.comapi.map.w$a r9 = r0.Q
            float r12 = r9.f15058f
            float r13 = r9.f15053a
            float r12 = r12 - r13
            float r12 = r12 * r12
            float r13 = r9.f15059g
            float r9 = r9.f15055c
            float r13 = r13 - r9
            float r13 = r13 * r13
            float r12 = r12 + r13
            double r12 = (double) r12
            double r12 = java.lang.Math.sqrt(r12)
            double r1 = r1 + r4
            double r16 = java.lang.Math.cos(r1)
            double r16 = r16 * r12
            double r16 = r16 * r10
            double r14 = (double) r7
            double r14 = r16 + r14
            float r14 = (float) r14
            double r1 = java.lang.Math.sin(r1)
            double r12 = r12 * r1
            double r12 = r12 * r10
            double r1 = (double) r6
            double r12 = r12 + r1
            float r1 = (float) r12
            r12 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r4 = r4 * r12
            r12 = 4614256673094690983(0x400921ff2e48e8a7, double:3.1416)
            double r4 = r4 / r12
            int r2 = (int) r4
            r4 = 0
            int r9 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            r4 = 8193(0x2001, float:1.1481E-41)
            if (r9 <= 0) goto L_0x02f1
            int r5 = r0.O
            r12 = 3
            if (r12 == r5) goto L_0x02c1
            int r5 = java.lang.Math.abs(r3)
            r9 = 2000(0x7d0, float:2.803E-42)
            if (r5 <= r9) goto L_0x02f1
            int r5 = r0.O
            r9 = 2
            if (r9 != r5) goto L_0x02f1
        L_0x02c1:
            r0.O = r12
            com.baidu.mapsdkplatform.comapi.map.a r2 = r25.e()
            float r2 = r2.f14965a
            boolean r5 = r0.r
            if (r5 == 0) goto L_0x0312
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 <= 0) goto L_0x02db
            float r5 = r0.f15018g
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x02e3
            r5 = 0
            return r5
        L_0x02db:
            r5 = 0
            float r10 = r0.f15019h
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 > 0) goto L_0x02e3
            return r5
        L_0x02e3:
            int r2 = com.baidu.mapapi.map.BaiduMap.mapStatusReason
            r5 = 1
            r2 = r2 | r5
            com.baidu.mapapi.map.BaiduMap.mapStatusReason = r2
            r25.S()
            r2 = 3
            r0.a((int) r4, (int) r2, (int) r3)
            goto L_0x0312
        L_0x02f1:
            if (r2 == 0) goto L_0x0312
            int r3 = r0.O
            r5 = 4
            if (r5 == r3) goto L_0x0305
            int r3 = java.lang.Math.abs(r2)
            r10 = 10
            if (r3 <= r10) goto L_0x0312
            int r3 = r0.O
            r9 = 2
            if (r9 != r3) goto L_0x0312
        L_0x0305:
            r0.O = r5
            boolean r3 = r0.t
            if (r3 == 0) goto L_0x0312
            r25.S()
            r3 = 1
            r0.a((int) r4, (int) r3, (int) r2)
        L_0x0312:
            com.baidu.mapsdkplatform.comapi.map.w$a r2 = r0.Q
            r2.f15058f = r14
            r2.f15059g = r1
            goto L_0x031c
        L_0x0319:
            r21 = r6
        L_0x031b:
            r6 = r2
        L_0x031c:
            int r1 = r0.O
            r2 = 2
            if (r2 == r1) goto L_0x032d
            com.baidu.mapsdkplatform.comapi.map.w$a r1 = r0.Q
            r1.f15055c = r6
            r6 = r21
            r1.f15056d = r6
            r1.f15053a = r7
            r1.f15054b = r8
        L_0x032d:
            com.baidu.mapsdkplatform.comapi.map.w$a r1 = r0.Q
            boolean r2 = r1.f15057e
            if (r2 != 0) goto L_0x0361
            int r2 = r0.M
            r3 = 2
            int r2 = r2 / r3
            float r2 = (float) r2
            r1.f15058f = r2
            int r2 = r0.N
            int r2 = r2 / r3
            float r2 = (float) r2
            r1.f15059g = r2
            r2 = 1
            r1.f15057e = r2
            double r2 = r1.f15060h
            r4 = 0
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0361
            float r2 = r1.f15054b
            float r3 = r1.f15053a
            float r2 = r2 - r3
            float r2 = r2 * r2
            float r3 = r1.f15056d
            float r1 = r1.f15055c
            float r3 = r3 - r1
            float r3 = r3 * r3
            float r2 = r2 + r3
            double r1 = (double) r2
            double r1 = java.lang.Math.sqrt(r1)
            com.baidu.mapsdkplatform.comapi.map.w$a r0 = r0.Q
            r0.f15060h = r1
        L_0x0361:
            r2 = 1
            return r2
        L_0x0363:
            r2 = r5
            int r3 = r26.getAction()
            if (r3 == 0) goto L_0x037a
            if (r3 == r2) goto L_0x0375
            r4 = 2
            if (r3 == r4) goto L_0x0371
            r3 = 0
            return r3
        L_0x0371:
            r25.c((android.view.MotionEvent) r26)
            goto L_0x037d
        L_0x0375:
            boolean r0 = r25.d((android.view.MotionEvent) r26)
            return r0
        L_0x037a:
            r25.b((android.view.MotionEvent) r26)
        L_0x037d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.o.a(android.view.MotionEvent):boolean");
    }

    public boolean a(String str, String str2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        return aVar.a(str, str2);
    }

    public GeoPoint b(int i2, int i3) {
        return this.K.a(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.la = false;
        this.ka = false;
        List<x> list = this.y;
        if (list != null) {
            for (x next : list) {
                if (next != null) {
                    next.a(e());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(float f2, float f3) {
        if (!this.Q.f15057e) {
            long currentTimeMillis = System.currentTimeMillis();
            this.ba = currentTimeMillis;
            if (currentTimeMillis - this.aa < 400) {
                if (Math.abs(f2 - this.X) >= 120.0f || Math.abs(f3 - this.Y) >= 120.0f) {
                    currentTimeMillis = this.ba;
                } else {
                    this.aa = 0;
                    this.ca = true;
                    this.X = f2;
                    this.Y = f3;
                    a(4, 0, ((int) f2) | (((int) f3) << 16));
                    this.Z = true;
                }
            }
            this.aa = currentTimeMillis;
            this.X = f2;
            this.Y = f3;
            a(4, 0, ((int) f2) | (((int) f3) << 16));
            this.Z = true;
        }
    }

    public void b(int i2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.f(i2);
        }
    }

    public void b(Bundle bundle) {
        if (this.z != null) {
            g(bundle);
            this.z.e(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Handler handler) {
        MessageCenter.unregistMessage(4000, handler);
        MessageCenter.unregistMessage(41, handler);
        MessageCenter.unregistMessage(49, handler);
        MessageCenter.unregistMessage(39, handler);
        MessageCenter.unregistMessage(65289, handler);
        MessageCenter.unregistMessage(50, handler);
        MessageCenter.unregistMessage(999, handler);
        BaseMapCallback.removeLayerDataInterface(this.A);
    }

    public void b(boolean z2) {
        this.u = z2;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.b(i2);
            this.z = null;
        }
    }

    public void c(Bundle bundle) {
        if (this.z != null) {
            g(bundle);
            this.z.f(bundle);
        }
    }

    public void c(boolean z2) {
        boolean z3;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            if (z2) {
                if (!this.va) {
                    aVar.a(this.qa.f15008a, this.G.f15008a);
                    z3 = true;
                } else {
                    return;
                }
            } else if (this.va) {
                aVar.a(this.G.f15008a, this.qa.f15008a);
                z3 = false;
            } else {
                return;
            }
            this.va = z3;
        }
    }

    public boolean c() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            return aVar.a(this.F.f15008a);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean c(float f2, float f3) {
        if (this.Q.f15057e || System.currentTimeMillis() - f15016e < 300) {
            return true;
        }
        if (this.ma) {
            List<x> list = this.y;
            if (list != null) {
                for (x next : list) {
                    GeoPoint b2 = b((int) f2, (int) f3);
                    if (next != null) {
                        next.b(b2);
                    }
                }
            }
            return true;
        }
        float abs = Math.abs(f2 - this.X);
        float abs2 = Math.abs(f3 - this.Y);
        float density = (float) (((double) SysOSUtil.getDensity()) > 1.5d ? ((double) SysOSUtil.getDensity()) * 1.5d : (double) SysOSUtil.getDensity());
        if (this.Z && abs / density <= 3.0f && abs2 / density <= 3.0f) {
            return true;
        }
        this.Z = false;
        int i2 = (int) f2;
        int i3 = (int) f3;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (this.q) {
            this.ea = this.ga;
            this.fa = this.ha;
            this.ga = f2;
            this.ha = f3;
            this.ia = this.ja;
            this.ja = System.currentTimeMillis();
            this.da = true;
            S();
            a(3, 0, (i3 << 16) | i2);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2, int i3) {
        return i2 >= 0 && i2 <= this.M + 0 && i3 >= 0 && i3 <= this.N + 0;
    }

    public void d(Bundle bundle) {
        if (this.z != null) {
            g(bundle);
            this.z.g(bundle);
        }
    }

    public void d(boolean z2) {
        boolean z3;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            if (z2) {
                if (!this.wa) {
                    aVar.a(this.G.f15008a, this.D.f15008a);
                    z3 = true;
                } else {
                    return;
                }
            } else if (this.wa) {
                aVar.a(this.D.f15008a, this.G.f15008a);
                z3 = false;
            } else {
                return;
            }
            this.wa = z3;
        }
    }

    public boolean d() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            return aVar.a(this.ra.f15008a);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean d(float f2, float f3) {
        if (this.ma) {
            List<x> list = this.y;
            if (list != null) {
                for (x next : list) {
                    GeoPoint b2 = b((int) f2, (int) f3);
                    if (next != null) {
                        next.a(b2);
                    }
                }
            }
            this.ma = false;
            return true;
        }
        if (!this.Q.f15057e) {
            if (this.ca) {
                return e(f2, f3);
            }
            if (this.da) {
                return T();
            }
            if (System.currentTimeMillis() - this.ba < 400 && Math.abs(f2 - this.X) < 10.0f && Math.abs(f3 - this.Y) < 10.0f) {
                m();
                return true;
            }
        }
        m();
        int i2 = (int) f2;
        int i3 = (int) f3;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        a(5, 0, i2 | (i3 << 16));
        return true;
    }

    public C0310a e() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return null;
        }
        Bundle h2 = aVar.h();
        C0310a aVar2 = new C0310a();
        aVar2.a(h2);
        return aVar2;
    }

    public void e(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.a(this.E.f15008a, z2);
        }
    }

    public LatLngBounds f() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return null;
        }
        Bundle i2 = aVar.i();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        int i3 = i2.getInt("maxCoorx");
        int i4 = i2.getInt("minCoorx");
        builder.include(CoordUtil.mc2ll(new GeoPoint((double) i2.getInt("minCoory"), (double) i3))).include(CoordUtil.mc2ll(new GeoPoint((double) i2.getInt("maxCoory"), (double) i4)));
        return builder.build();
    }

    public void f(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.a(this.v.f15008a, z2);
        }
    }

    public MapStatusUpdate g() {
        return this.ua;
    }

    public void g(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.a(this.na.f15008a, z2);
        }
    }

    public int h() {
        return this.M;
    }

    public void h(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            this.o = z2;
            aVar.b(z2);
        }
    }

    public int i() {
        return this.N;
    }

    public void i(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            this.f15021j = z2;
            aVar.c(z2);
        }
    }

    /* access modifiers changed from: package-private */
    public C0310a j() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return null;
        }
        Bundle j2 = aVar.j();
        C0310a aVar2 = new C0310a();
        aVar2.a(j2);
        return aVar2;
    }

    public void j(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.d(z2);
        }
    }

    public double k() {
        return e().m;
    }

    public void k(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            this.l = z2;
            aVar.a(this.E.f15008a, z2);
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        List<x> list;
        this.ka = false;
        if (!this.la && (list = this.y) != null) {
            for (x next : list) {
                if (next != null) {
                    next.a(e());
                }
            }
        }
    }

    public void l(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            float f2 = z2 ? 22.0f : 21.0f;
            this.f15018g = f2;
            this.f15020i = f2;
            aVar.e(z2);
            this.z.d(this.qa.f15008a);
            this.z.d(this.ra.f15008a);
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        this.O = 0;
        w.a aVar = this.Q;
        aVar.f15057e = false;
        aVar.f15060h = 0.0d;
    }

    public void n(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.f(z2);
        }
    }

    public float[] n() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return null;
        }
        return aVar.u();
    }

    public void o(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            this.m = z2;
            aVar.a(this.D.f15008a, z2);
        }
    }

    public float[] o() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return null;
        }
        return aVar.v();
    }

    public Queue<a> p() {
        return this.ta;
    }

    public void p(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            this.n = z2;
            aVar.a(this.H.f15008a, z2);
        }
    }

    public void q() {
        if (!this.ta.isEmpty()) {
            a poll = this.ta.poll();
            if (poll.f15026e == null) {
                com.baidu.mapsdkplatform.comjni.map.basemap.a.a(poll.f15022a, poll.f15023b, poll.f15024c, poll.f15025d);
            } else if (this.z != null) {
                a();
                this.z.a(poll.f15026e, true);
            }
        }
    }

    public void q(boolean z2) {
        this.q = z2;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        this.B = new ArrayList();
        this.C = new HashMap<>();
        p pVar = new p();
        this.na = pVar;
        a((C0323n) pVar);
        C0321l lVar = new C0321l();
        this.qa = lVar;
        a((C0323n) lVar);
        A a2 = new A();
        this.H = a2;
        a((C0323n) a2);
        C0320k kVar = new C0320k();
        this.I = kVar;
        a((C0323n) kVar);
        a((C0323n) new C());
        C0313d dVar = new C0313d();
        this.F = dVar;
        a((C0323n) dVar);
        this.C.put(MapLayer.MAP_LAYER_POI_MARKER, this.F);
        C0322m mVar = new C0322m();
        this.ra = mVar;
        a((C0323n) mVar);
        this.C.put(MapLayer.MAP_LAYER_INDOOR_POI, this.ra);
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.e(false);
        }
        C0316g gVar = new C0316g();
        this.G = gVar;
        a((C0323n) gVar);
        this.C.put(MapLayer.MAP_LAYER_OVERLAY, this.G);
        q qVar = new q();
        this.E = qVar;
        a((C0323n) qVar);
        K k2 = new K();
        this.D = k2;
        a((C0323n) k2);
        this.C.put(MapLayer.MAP_LAYER_LOCATION, this.D);
    }

    public void r(boolean z2) {
        this.r = z2;
    }

    public void s(boolean z2) {
        this.s = z2;
    }

    public boolean s() {
        return this.u;
    }

    public void t() {
        if (this.z != null) {
            for (C0323n nVar : this.B) {
                this.z.a(nVar.f15008a, false);
            }
        }
    }

    public void t(boolean z2) {
        this.t = z2;
    }

    public void u() {
        if (this.z != null) {
            for (C0323n next : this.B) {
                if ((next instanceof K) || (next instanceof C0320k) || (next instanceof A)) {
                    this.z.a(next.f15008a, false);
                } else {
                    this.z.a(next.f15008a, true);
                }
            }
            this.z.c(false);
        }
    }

    public void u(boolean z2) {
        this.p = z2;
    }

    public void v(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.a(this.F.f15008a, z2);
        }
    }

    public boolean v() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        C0318i iVar = this.v;
        if (iVar == null || (aVar = this.z) == null) {
            return false;
        }
        return aVar.c(iVar.f15008a);
    }

    /* access modifiers changed from: package-private */
    public void w() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            this.K = new C0314e(aVar);
        }
    }

    public void w(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.a(this.ra.f15008a, z2);
        }
    }

    public void x(boolean z2) {
        this.sa = z2;
    }

    public boolean x() {
        return this.f15021j;
    }

    public String y() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar == null) {
            return null;
        }
        return aVar.e(this.E.f15008a);
    }

    public void y(boolean z2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.z;
        if (aVar != null) {
            aVar.g(z2);
        }
    }

    public boolean z() {
        return this.o;
    }
}
