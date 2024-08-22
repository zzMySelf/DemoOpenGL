package com.baidu.ar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.c;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.p.o;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.searchbox.video.feedflow.ubc.UBC2736;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class b {
    private com.baidu.ar.arrender.g A;

    /* renamed from: a  reason: collision with root package name */
    private Context f9155a;

    /* renamed from: b  reason: collision with root package name */
    private Looper f9156b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public g f9157c;

    /* renamed from: d  reason: collision with root package name */
    private DefaultParams f9158d;

    /* renamed from: e  reason: collision with root package name */
    private com.baidu.ar.mdl.b f9159e;

    /* renamed from: f  reason: collision with root package name */
    private com.baidu.ar.lua.b f9160f;

    /* renamed from: g  reason: collision with root package name */
    private com.baidu.ar.arrender.c f9161g;

    /* renamed from: h  reason: collision with root package name */
    private com.baidu.ar.k.g f9162h;

    /* renamed from: i  reason: collision with root package name */
    private com.baidu.ar.imu.c f9163i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public ConcurrentHashMap<String, String> f9164j = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, String> k = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, c> l = new ConcurrentHashMap<>();
    private ARProxyManager m;
    /* access modifiers changed from: private */
    public List<Integer> n;
    private com.baidu.ar.lua.c o;
    /* access modifiers changed from: private */
    public List<String> p;
    private LuaMsgListener q;
    /* access modifiers changed from: private */
    public List<String> r;
    private LuaMsgListener s;
    /* access modifiers changed from: private */
    public List<String> t = new ArrayList();
    /* access modifiers changed from: private */
    public final List<String> u;
    private List<String> v;
    private com.baidu.ar.g.b w;
    private boolean x;
    private com.baidu.ar.filter.a y;
    private c.b z;

    class a implements ILibLoader.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f9165a;

        a(List list) {
            this.f9165a = list;
        }

        public void a(ARType aRType, String str, String str2) {
            b.this.u.addAll(b.this.t);
            String str3 = (String) b.this.f9164j.get("ability_face_filter");
            if (!TextUtils.isEmpty(str3) && b.this.f9157c != null) {
                if (b.this.l.get(str3) == null) {
                    b.this.f9157c.sendMessage(b.this.f9157c.obtainMessage(1001, new i(b.this, str3, (List<String>) this.f9165a, true, (HashMap<String, Object>) null)));
                    return;
                }
                ((c) b.this.l.get(str3)).b();
                ((c) b.this.l.get(str3)).a((List<String>) this.f9165a);
            }
        }

        public void a(DuMixErrorType duMixErrorType, String str) {
            com.baidu.ar.p.b.b("AbilityManager", "startDefaultFaceAbility error!!! errorType = " + duMixErrorType.toString() + " && error message = " + str);
        }
    }

    /* renamed from: com.baidu.ar.b$b  reason: collision with other inner class name */
    class C0149b implements com.baidu.ar.lua.c {
        C0149b() {
        }

        public List<Integer> a() {
            return b.this.n;
        }

        public void a(int i2, int i3, HashMap<String, Object> hashMap) {
            b.this.a(i2, hashMap);
        }
    }

    class c implements LuaMsgListener {
        c() {
        }

        public List<String> getMsgKeyListened() {
            return b.this.p;
        }

        public void onLuaMessage(HashMap<String, Object> hashMap) {
            b.this.b(hashMap);
        }
    }

    class d implements LuaMsgListener {
        d() {
        }

        public List<String> getMsgKeyListened() {
            return b.this.r;
        }

        public void onLuaMessage(HashMap<String, Object> hashMap) {
            b.this.a(hashMap);
            b.this.c(hashMap);
        }
    }

    class e implements c.b {
        e() {
        }

        public boolean a(String str, com.baidu.ar.k.e eVar) {
            if (b.this.k == null || !b.this.k.containsKey(str)) {
                return false;
            }
            String str2 = (String) b.this.k.get(str);
            if (TextUtils.isEmpty(str2) || b.this.f9157c == null) {
                return false;
            }
            b.this.f9157c.sendMessage(b.this.f9157c.obtainMessage(1003, new j(b.this, str2, str, eVar)));
            return true;
        }
    }

    class f implements com.baidu.ar.arrender.g {
        f() {
        }

        public void a(boolean z) {
            for (c a2 : b.this.l.values()) {
                a2.a(z);
            }
        }
    }

    class g extends Handler {
        public g(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 1001:
                        i iVar = (i) message.obj;
                        b.this.a(iVar.f9175a, iVar.f9176b, iVar.f9177c, iVar.f9178d, iVar.f9179e, iVar.f9180f);
                        return;
                    case 1002:
                        h hVar = (h) message.obj;
                        b.this.a(hVar.f9173a, hVar.f9174b);
                        return;
                    case 1003:
                        j jVar = (j) message.obj;
                        b.this.a(jVar.f9181a, jVar.f9182b, jVar.f9183c);
                        return;
                    default:
                        return;
                }
            } catch (Exception e2) {
                com.baidu.ar.p.b.b("AbilityManager", "handleMessage Exception: " + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    class h {

        /* renamed from: a  reason: collision with root package name */
        String f9173a;

        /* renamed from: b  reason: collision with root package name */
        HashMap<String, Object> f9174b;

        h(b bVar, String str, HashMap<String, Object> hashMap) {
            this.f9173a = str;
            this.f9174b = hashMap;
        }
    }

    class i {

        /* renamed from: a  reason: collision with root package name */
        String f9175a;

        /* renamed from: b  reason: collision with root package name */
        List<String> f9176b;

        /* renamed from: c  reason: collision with root package name */
        boolean f9177c;

        /* renamed from: d  reason: collision with root package name */
        HashMap<String, Object> f9178d;

        /* renamed from: e  reason: collision with root package name */
        String f9179e;

        /* renamed from: f  reason: collision with root package name */
        com.baidu.ar.k.e f9180f;

        i(b bVar, String str, String str2, boolean z, HashMap<String, Object> hashMap) {
            this.f9175a = str;
            ArrayList arrayList = new ArrayList();
            this.f9176b = arrayList;
            arrayList.add(str2);
            this.f9177c = z;
            this.f9178d = hashMap;
        }

        i(b bVar, String str, List<String> list, boolean z, HashMap<String, Object> hashMap) {
            this.f9175a = str;
            this.f9176b = list;
            this.f9177c = z;
            this.f9178d = hashMap;
        }
    }

    class j {

        /* renamed from: a  reason: collision with root package name */
        String f9181a;

        /* renamed from: b  reason: collision with root package name */
        String f9182b;

        /* renamed from: c  reason: collision with root package name */
        com.baidu.ar.k.e f9183c;

        j(b bVar, String str) {
            this.f9181a = str;
        }

        j(b bVar, String str, String str2, com.baidu.ar.k.e eVar) {
            this.f9181a = str;
            this.f9182b = str2;
            this.f9183c = eVar;
        }
    }

    b(Context context, Looper looper, DefaultParams defaultParams, com.baidu.ar.g.b bVar, com.baidu.ar.filter.a aVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.u = copyOnWriteArrayList;
        this.v = new ArrayList();
        this.x = true;
        this.f9155a = context;
        this.f9156b = looper;
        this.f9157c = new g(looper);
        this.f9158d = defaultParams;
        h(defaultParams.getMdlAlgoModelPath());
        this.m = new ARProxyManager();
        this.w = bVar;
        this.y = aVar;
        h();
        copyOnWriteArrayList.add("ability_common_filter");
        b();
    }

    private c a(String str) {
        c cVar = (c) o.a(str);
        if (cVar == null) {
            com.baidu.ar.p.b.b("AbilityManager", "createARAbility error!!!");
            return null;
        }
        this.l.put(str, cVar);
        cVar.a(this.f9155a, this.f9156b);
        cVar.a(this.f9162h, this.f9161g, this.y);
        cVar.a(this.f9160f);
        cVar.a(this.f9163i);
        cVar.a(this.z);
        com.baidu.ar.g.b bVar = this.w;
        if (bVar != null) {
            cVar.a(bVar.b());
        }
        ARProxyManager aRProxyManager = this.m;
        if (aRProxyManager != null && aRProxyManager.c(str)) {
            this.m.a(cVar, str);
        }
        return cVar;
    }

    private void a() {
        f fVar = new f();
        this.A = fVar;
        this.f9161g.setCameraSwitchListener(fVar);
    }

    /* access modifiers changed from: private */
    public void a(int i2, HashMap<String, Object> hashMap) {
        if (i2 != 301) {
            if (i2 == 303) {
                if (this.l == null || !this.u.contains("ability_image_track")) {
                    i("ability_imu");
                }
            }
        } else if (this.l == null || !this.u.contains("ability_image_track")) {
            c("ability_imu", hashMap);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, com.baidu.ar.k.e eVar) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "destroyAbility error!!! arClassName is empty!!!";
        } else {
            c cVar = this.l.get(str);
            if (cVar == null) {
                str3 = "destroyAbility error!!! As arClassName = " + str + " not active!!!";
            } else {
                if (TextUtils.isEmpty(str2) || eVar == null) {
                    cVar.b();
                } else {
                    cVar.b(str2, eVar);
                }
                if (cVar.a()) {
                    ARProxyManager aRProxyManager = this.m;
                    if (aRProxyManager != null && aRProxyManager.c(str)) {
                        this.m.d(str);
                    }
                    this.l.remove(str);
                    cVar.release();
                    return;
                }
                return;
            }
        }
        com.baidu.ar.p.b.b("AbilityManager", str3);
    }

    /* access modifiers changed from: private */
    public void a(String str, HashMap<String, Object> hashMap) {
        c cVar = this.l.get(str);
        if (cVar != null) {
            cVar.adjust(hashMap);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, List<String> list, boolean z2, HashMap<String, Object> hashMap, String str2, com.baidu.ar.k.e eVar) {
        String str3;
        if (!com.baidu.ar.ability.a.a(str)) {
            str3 = "checkARTypeAuth error!!!";
        } else {
            c cVar = this.l.get(str);
            if (cVar != null) {
                com.baidu.ar.p.b.a("AbilityManager", "createARAbility arClassName = " + str + " ARAbility exist!!!");
                if (list != null) {
                    if (z2) {
                        cVar.b();
                    }
                    cVar.a(list);
                }
                cVar.adjust(hashMap);
            } else {
                cVar = a(str);
                if (cVar == null) {
                    str3 = "createARAbility createARAbility error!!!";
                } else {
                    if (list != null) {
                        cVar.a(list);
                    }
                    if (!TextUtils.isEmpty(this.f9158d.getFaceAlgoModelPath())) {
                        cVar.setFaceModelPath(this.f9158d.getFaceAlgoModelPath());
                    }
                    cVar.setMdlConfigParams(this.f9159e);
                    cVar.setup(hashMap);
                }
            }
            if (!TextUtils.isEmpty(str2) && eVar != null) {
                cVar.a(str2, eVar);
                return;
            }
            return;
        }
        com.baidu.ar.p.b.b("AbilityManager", str3);
    }

    /* access modifiers changed from: private */
    public void a(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get("event_name");
        com.baidu.ar.p.b.a("AbilityManager", "operateAbilityByEvent eventName = " + str);
        if ("ability_operation".equals(str)) {
            String str2 = (String) hashMap.get("ability_name");
            if (!TextUtils.isEmpty(str2)) {
                String str3 = (String) hashMap.get("ability_action");
                if ("open".equals(str3)) {
                    c(str2, hashMap);
                } else if ("close".equals(str3)) {
                    i(str2);
                } else if (UBC2736.TYPE.TYPE_ADJUST.equals(str3)) {
                    b(str2, hashMap);
                } else if ("query".equals(str3)) {
                    n();
                }
            }
        } else {
            String str4 = com.baidu.ar.ability.b.f8946c.get(str);
            if (!TextUtils.isEmpty(str4)) {
                c(str4, hashMap);
                return;
            }
            String str5 = com.baidu.ar.ability.b.f8947d.get(str);
            if (!TextUtils.isEmpty(str5)) {
                i(str5);
            }
        }
    }

    private void a(List<String> list) {
        com.baidu.ar.libloader.a.a(ARType.FACE, (String) null, (String) null, new a(list));
    }

    private void b() {
        this.z = new e();
    }

    private void b(String str) {
        ConcurrentHashMap<String, c> concurrentHashMap;
        c cVar;
        if (!TextUtils.isEmpty(str)) {
            ConcurrentHashMap<String, String> concurrentHashMap2 = this.f9164j;
            if (concurrentHashMap2 != null) {
                String str2 = concurrentHashMap2.get(str);
                if (!(TextUtils.isEmpty(str2) || (concurrentHashMap = this.l) == null || (cVar = concurrentHashMap.get(str2)) == null)) {
                    cVar.b(str);
                }
            }
            if (this.u.contains(str)) {
                if (str.equals("ability_makeup_filter") || str.equals("ability_face_filter")) {
                    this.u.remove("ability_makeup_filter");
                }
                this.u.remove(str);
                return;
            }
            com.baidu.ar.p.b.a("AbilityManager", "disableAbility() abilityName " + str + " has disabled!!!");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        if (r0 == 3006) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.util.HashMap<java.lang.String, java.lang.Object> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "id"
            java.lang.Object r0 = r7.get(r0)
            r1 = -1
            int r0 = com.baidu.ar.arplay.util.b.a((java.lang.Object) r0, (int) r1)
            java.lang.String r2 = "open"
            java.lang.Object r2 = r7.get(r2)
            int r1 = com.baidu.ar.arplay.util.b.a((java.lang.Object) r2, (int) r1)
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x001b
            r1 = r3
            goto L_0x001c
        L_0x001b:
            r1 = r2
        L_0x001c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "operateAbilityById id = "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r5 = " && open = "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "AbilityManager"
            com.baidu.ar.p.b.a(r5, r4)
            r4 = 0
            r5 = 5001(0x1389, float:7.008E-42)
            if (r0 != r5) goto L_0x0047
            java.lang.String r4 = "ability_gesture"
        L_0x0045:
            r2 = r1
            goto L_0x005a
        L_0x0047:
            r5 = 5011(0x1393, float:7.022E-42)
            if (r0 != r5) goto L_0x004e
            java.lang.String r4 = "ability_image_segmentation"
            goto L_0x0045
        L_0x004e:
            r5 = 3005(0xbbd, float:4.211E-42)
            if (r0 != r5) goto L_0x0056
            java.lang.String r4 = "ability_logo_recognition"
            r2 = r3
            goto L_0x005a
        L_0x0056:
            r3 = 3006(0xbbe, float:4.212E-42)
            if (r0 != r3) goto L_0x0045
        L_0x005a:
            if (r4 == 0) goto L_0x0065
            if (r2 == 0) goto L_0x0062
            r6.c((java.lang.String) r4, (java.util.HashMap<java.lang.String, java.lang.Object>) r7)
            goto L_0x0065
        L_0x0062:
            r6.i((java.lang.String) r4)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.b.b(java.util.HashMap):void");
    }

    private void c(String str) {
        if (!this.u.contains(str)) {
            this.u.add(str);
            if ((str.equals("ability_makeup_filter") || str.equals("ability_face_filter")) && this.f9158d.isUseMakeupFilter()) {
                this.u.add("ability_makeup_filter");
                return;
            }
            return;
        }
        com.baidu.ar.p.b.a("AbilityManager", "enableAbility() abilityName " + str + " has enabled!!!");
    }

    /* access modifiers changed from: private */
    public void c(HashMap<String, Object> hashMap) {
        com.baidu.ar.filter.a aVar;
        FilterNode filterNode;
        if ("ability_operation".equals((String) hashMap.get("event_name"))) {
            String str = (String) hashMap.get("ability_name");
            if (!TextUtils.isEmpty(str) && com.baidu.ar.ability.b.f8945b.contains(str)) {
                com.baidu.ar.p.b.a("AbilityManager", "operateFilterState abilityName = " + str);
                String str2 = (String) hashMap.get("ability_action");
                if ("open".equals(str2) && "close".equals(str2)) {
                    boolean equals = "open".equals(str2);
                    if (this.y != null) {
                        if ("ability_makeup_filter".equals(str)) {
                            aVar = this.y;
                            filterNode = FilterNode.makeupFilter;
                        } else if ("ability_face_filter".equals(str)) {
                            aVar = this.y;
                            filterNode = FilterNode.faceFilter;
                        } else if ("ability_beauty_filter".equals(str)) {
                            aVar = this.y;
                            filterNode = FilterNode.skinFilter;
                        } else {
                            if ("ability_lut_filter".equals(str)) {
                                aVar = this.y;
                                filterNode = FilterNode.lutFilter;
                            }
                            this.y.a();
                        }
                        aVar.a(filterNode, equals);
                        this.y.a();
                    }
                }
            }
        }
    }

    private List<String> f() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.t) {
            String str2 = this.f9164j.get(str);
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    private void h() {
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = b.class.getClassLoader();
        for (Map.Entry next : com.baidu.ar.ability.b.f8944a.entrySet()) {
            if (o.a((String) next.getValue(), classLoader)) {
                this.f9164j.put(next.getKey(), next.getValue());
            }
        }
        this.k.putAll(com.baidu.ar.ability.b.f8949f);
        com.baidu.ar.p.b.c("AbilityManager", "initSupportedARClasses mSupportedARClasses = " + this.f9164j.values());
        com.baidu.ar.p.b.a("AbilityManager", "initSupportedARClasses time cost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private void n() {
        if (this.f9160f != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ability_name", this.u);
            this.f9160f.a(1902, hashMap);
        }
    }

    private void o() {
        if (this.f9160f != null) {
            this.n = Arrays.asList(new Integer[]{301, 303});
            C0149b bVar = new C0149b();
            this.o = bVar;
            this.f9160f.a((com.baidu.ar.lua.c) bVar);
            this.p = Arrays.asList(new String[]{"id"});
            this.q = new c();
            this.f9160f.d().a(this.q);
            this.r = Arrays.asList(new String[]{"event_name"});
            this.s = new d();
            this.f9160f.d().a(this.s);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r0 = r7.f9158d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.baidu.ar.ARType r8) {
        /*
            r7 = this;
            com.baidu.ar.ARType r0 = com.baidu.ar.ARType.FACE
            if (r8 != r0) goto L_0x0019
            java.lang.String r0 = "ability_face_model"
            boolean r1 = com.baidu.ar.ability.a.b(r0)
            if (r1 != 0) goto L_0x000d
            return
        L_0x000d:
            com.baidu.ar.DefaultParams r1 = r7.f9158d
            boolean r1 = r1.isUseFaceFilter()
            if (r1 == 0) goto L_0x001c
            r7.c((java.lang.String) r0)
            goto L_0x001c
        L_0x0019:
            r7.c()
        L_0x001c:
            com.baidu.ar.ARType r0 = com.baidu.ar.ARType.FACE
            if (r8 == r0) goto L_0x002d
            com.baidu.ar.DefaultParams r0 = r7.f9158d
            if (r0 == 0) goto L_0x002b
            boolean r0 = r0.isUseBeautyFilter()
            if (r0 == 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r0 = 0
            goto L_0x002e
        L_0x002d:
            r0 = 1
        L_0x002e:
            com.baidu.ar.filter.a r1 = r7.y
            com.baidu.ar.filter.FilterParam$SkinFilter r2 = com.baidu.ar.filter.FilterParam.SkinFilter.whiten
            r1.a((com.baidu.ar.filter.FilterParam) r2, (boolean) r0)
            java.util.HashMap<com.baidu.ar.ARType, java.lang.String> r0 = com.baidu.ar.ability.b.f8948e
            java.lang.Object r0 = r0.get(r8)
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0045
            return
        L_0x0045:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = r7.f9164j
            java.lang.Object r0 = r0.get(r4)
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0067
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.baidu.ar.c> r0 = r7.l
            java.lang.Object r0 = r0.get(r3)
            if (r0 == 0) goto L_0x0067
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.baidu.ar.c> r0 = r7.l
            java.lang.Object r0 = r0.get(r3)
            com.baidu.ar.c r0 = (com.baidu.ar.c) r0
            r0.a((java.lang.String) r4)
        L_0x0067:
            java.util.List<java.lang.String> r0 = r7.u
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto L_0x0070
            return
        L_0x0070:
            com.baidu.ar.ARType r0 = com.baidu.ar.ARType.IMU
            if (r8 == r0) goto L_0x0097
            boolean r8 = android.text.TextUtils.isEmpty(r3)
            if (r8 != 0) goto L_0x0097
            com.baidu.ar.b$g r8 = r7.f9157c
            if (r8 == 0) goto L_0x0097
            java.util.List<java.lang.String> r8 = r7.u
            r8.add(r4)
            com.baidu.ar.b$i r8 = new com.baidu.ar.b$i
            r5 = 0
            r6 = 0
            r1 = r8
            r2 = r7
            r1.<init>((com.baidu.ar.b) r2, (java.lang.String) r3, (java.lang.String) r4, (boolean) r5, (java.util.HashMap<java.lang.String, java.lang.Object>) r6)
            com.baidu.ar.b$g r0 = r7.f9157c
            r1 = 1001(0x3e9, float:1.403E-42)
            android.os.Message r8 = r0.obtainMessage(r1, r8)
            r0.sendMessage(r8)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.b.a(com.baidu.ar.ARType):void");
    }

    /* access modifiers changed from: package-private */
    public void a(com.baidu.ar.lua.b bVar, com.baidu.ar.arrender.c cVar) {
        this.f9160f = bVar;
        this.f9161g = cVar;
        cVar.a(this.u);
        a();
        this.f9162h = new com.baidu.ar.k.g(cVar, this.f9156b);
        com.baidu.ar.imu.c b2 = a.b();
        this.f9163i = b2;
        if (b2 != null) {
            try {
                b2.setContext(this.f9155a);
            } catch (Exception e2) {
                com.baidu.ar.p.b.b("AbilityManager", "setup exception: " + e2.getMessage());
                e2.printStackTrace();
                return;
            }
        }
        o();
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, HashMap<String, Object> hashMap, boolean z2) {
        StringBuilder append;
        String str2;
        if (!com.baidu.ar.ability.a.b(str)) {
            append = new StringBuilder().append("startAbility abilityType = ").append(str);
            str2 = " is no authorization!!!";
        } else {
            if (z2 && !this.v.contains(str)) {
                this.v.add(str);
            }
            if (this.u.contains(str)) {
                append = new StringBuilder().append("startAbility abilityType = ").append(str);
                str2 = " is exist!!!";
            } else {
                String str3 = this.f9164j.get(str);
                if (!TextUtils.isEmpty(str3)) {
                    c(str);
                    if (this.f9157c != null) {
                        i iVar = new i(this, str3, str, false, hashMap);
                        g gVar = this.f9157c;
                        gVar.sendMessage(gVar.obtainMessage(1001, iVar));
                        return true;
                    }
                }
                return false;
            }
        }
        com.baidu.ar.p.b.b("AbilityManager", append.append(str2).toString());
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, List<String> list, String str2) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || !o.a(str, b.class.getClassLoader())) {
            return false;
        }
        for (String put : list) {
            this.f9164j.put(put, str);
        }
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        this.k.put(str2, str);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, boolean z2) {
        g gVar;
        if (z2 && this.v.contains(str)) {
            this.v.remove(str);
        }
        b(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : this.u) {
            String str3 = this.f9164j.get(str2);
            if (!TextUtils.isEmpty(str3) && !arrayList.contains(str3)) {
                arrayList.add(str3);
            }
        }
        String str4 = this.f9164j.get(str);
        if (arrayList.contains(str4) || (gVar = this.f9157c) == null) {
            return false;
        }
        gVar.sendMessage(gVar.obtainMessage(1003, new j(this, str4)));
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b(String str, HashMap<String, Object> hashMap) {
        if (!this.u.contains(str)) {
            com.baidu.ar.p.b.b("AbilityManager", "adjustAbility abilityType = " + str + " not start!!!");
            return false;
        } else if (this.f9157c == null) {
            return false;
        } else {
            h hVar = new h(this, this.f9164j.get(str), hashMap);
            g gVar = this.f9157c;
            gVar.sendMessage(gVar.obtainMessage(1002, hVar));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        com.baidu.ar.filter.a aVar = this.y;
        if (aVar != null) {
            aVar.a(FilterNode.faceFilter, false);
            this.y.a(FilterNode.makeupFilter, false);
        }
        ARProxyManager aRProxyManager = this.m;
        if (aRProxyManager != null) {
            aRProxyManager.b();
        }
        for (String b2 : this.u) {
            b(b2);
        }
        this.u.clear();
        this.u.add("ability_common_filter");
        List<String> list = this.v;
        if (list != null && list.size() > 0) {
            this.u.addAll(this.v);
        }
        if (this.f9157c != null) {
            for (Map.Entry next : this.l.entrySet()) {
                if (!f((String) next.getKey())) {
                    g gVar = this.f9157c;
                    gVar.sendMessage(gVar.obtainMessage(1003, new j(this, (String) next.getKey())));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str, HashMap<String, Object> hashMap) {
        return a(str, hashMap, false);
    }

    /* access modifiers changed from: package-private */
    public ARProxyManager d() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public boolean d(String str) {
        return this.u.contains(str);
    }

    /* access modifiers changed from: package-private */
    public List<String> e() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public boolean e(String str) {
        return this.f9164j.get(str) != null;
    }

    /* access modifiers changed from: package-private */
    public boolean f(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str) || (list = this.v) == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.equals(this.f9164j.get(str2))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public List<String> g() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> key : this.f9164j.entrySet()) {
            arrayList.add(key.getKey());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void g(String str) {
        if (!this.l.isEmpty()) {
            for (c onCaseCreate : this.l.values()) {
                com.baidu.ar.p.b.a("AbilityManager", "onCaseCreate casePath = " + str);
                onCaseCreate.onCaseCreate(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(String str) {
        if (this.f9159e == null) {
            this.f9159e = new com.baidu.ar.mdl.b();
        }
        this.f9159e.a(str, this.f9155a);
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (!this.l.isEmpty()) {
            for (c onCaseDestroy : this.l.values()) {
                onCaseDestroy.onCaseDestroy();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean i(String str) {
        return a(str, false);
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (!this.l.isEmpty()) {
            for (c pause : this.l.values()) {
                pause.pause();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        ARProxyManager aRProxyManager = this.m;
        if (aRProxyManager != null) {
            aRProxyManager.a();
            this.m = null;
        }
        for (c release : this.l.values()) {
            release.release();
        }
        this.l.clear();
        this.f9164j.clear();
        com.baidu.ar.lua.b bVar = this.f9160f;
        if (!(bVar == null || bVar.d() == null)) {
            this.f9160f.b(this.o);
            this.f9160f.d().b(this.q);
            this.f9160f.d().b(this.s);
            this.f9160f = null;
            this.o = null;
            this.q = null;
            this.s = null;
        }
        this.n = null;
        this.p = null;
        this.r = null;
        com.baidu.ar.imu.c cVar = this.f9163i;
        if (cVar != null) {
            cVar.destroy();
            this.f9163i = null;
        }
        com.baidu.ar.k.g gVar = this.f9162h;
        if (gVar != null) {
            gVar.a();
            this.f9162h = null;
        }
        List<String> list = this.v;
        if (list != null) {
            list.clear();
            this.v = null;
        }
        this.f9155a = null;
        this.f9156b = null;
        this.f9158d = null;
        this.f9159e = null;
        this.y = null;
        this.f9161g = null;
        if (this.w != null) {
            this.w = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        ARProxyManager aRProxyManager = this.m;
        if (aRProxyManager != null) {
            aRProxyManager.b();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> f2 = f();
        for (String next : this.u) {
            String str = null;
            if (!TextUtils.isEmpty(next)) {
                str = this.f9164j.get(next);
            }
            if (!TextUtils.isEmpty(str) && !f2.contains(str) && !arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        p();
        if (this.f9157c != null) {
            for (String jVar : arrayList) {
                g gVar = this.f9157c;
                gVar.sendMessage(gVar.obtainMessage(1003, new j(this, jVar)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        if (!this.l.isEmpty()) {
            for (c resume : this.l.values()) {
                resume.resume();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        if (this.f9158d != null) {
            this.t.clear();
            this.u.clear();
            this.u.add("ability_common_filter");
            List<String> list = this.v;
            if (list != null && list.size() > 0) {
                this.u.addAll(this.v);
            }
            if (this.f9158d.isUseFaceFilter() && com.baidu.ar.ability.a.c("ability_face_filter")) {
                this.t.add("ability_face_filter");
                com.baidu.ar.filter.a aVar = this.y;
                if (aVar != null) {
                    aVar.a((FilterParam) FilterParam.SkinFilter.whiten, true);
                    this.y.a(FilterNode.faceFilter, true);
                }
                if (this.x) {
                    this.x = false;
                    StatisticApi.onEventDebounce(StatisticConstants.EVENT_FILTER_ADJUST, 200, "");
                    StatisticApi.onEventDebounce(StatisticConstants.EVENT_BEAUTIFY_ADJUST, 200, "");
                }
            }
            if (this.f9158d.isUseMakeupFilter()) {
                if (com.baidu.ar.ability.a.c("ability_makeup_filter")) {
                    this.t.add("ability_makeup_filter");
                }
                com.baidu.ar.filter.a aVar2 = this.y;
                if (aVar2 != null) {
                    aVar2.a(FilterNode.makeupFilter, true);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.t.contains("ability_face_filter")) {
                arrayList.add("ability_face_filter");
            }
            if (this.t.contains("ability_makeup_filter")) {
                arrayList.add("ability_makeup_filter");
            }
            if (arrayList.size() > 0) {
                a((List<String>) arrayList);
            }
        }
    }
}
