package com.baidu.ar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ar.ability.AbilityType;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.pixel.IPixelReader;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.IGLRenderer;
import com.baidu.ar.arrender.c;
import com.baidu.ar.arrender.k;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.auth.IDuMixAuthCallback;
import com.baidu.ar.auth.IOfflineAuthenticator;
import com.baidu.ar.bean.CaseModel;
import com.baidu.ar.bean.Watermark;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.content.IContentPlatform;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.filter.IFilter;
import com.baidu.ar.libloader.ILibLoaderPlugin;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.lua.e;
import com.baidu.ar.p.o;
import com.baidu.ar.photo.IPhoto;
import com.baidu.ar.photo.PhotoCallback;
import com.baidu.ar.record.IRecord;
import com.baidu.ar.record.RecordCallback;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.steploading.IStepLoading;
import com.baidu.speech.utils.AsrError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class DuMixController implements IDuMix, IFilter, IRecord, IPhoto, IPixelReader {
    private static volatile DuMixController t;
    /* access modifiers changed from: private */
    public static volatile int u;
    /* access modifiers changed from: private */
    public static volatile Object v = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f8896a;

    /* renamed from: b  reason: collision with root package name */
    private DefaultParams f8897b;

    /* renamed from: c  reason: collision with root package name */
    private DuMixInput f8898c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public DuMixOutput f8899d;

    /* renamed from: e  reason: collision with root package name */
    protected DuMixCallback f8900e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public HandlerThread f8901f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f8902g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Handler f8903h;

    /* renamed from: i  reason: collision with root package name */
    private DuMixCallback f8904i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public e f8905j;
    /* access modifiers changed from: private */
    public com.baidu.ar.lua.b k;
    private e l;
    /* access modifiers changed from: private */
    public c m;
    private com.baidu.ar.filter.a n;
    private b o;
    private com.baidu.ar.g.b p;
    private OrientationManager q;
    private com.baidu.ar.record.a r;
    private IContentPlatform s;

    class a implements DuMixCallback {

        /* renamed from: com.baidu.ar.DuMixController$a$a  reason: collision with other inner class name */
        class C0143a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f8907a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DuMixInput f8908b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ DuMixOutput f8909c;

            C0143a(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
                this.f8907a = z;
                this.f8908b = duMixInput;
                this.f8909c = duMixOutput;
            }

            public void run() {
                if (DuMixController.this.f8900e != null) {
                    com.baidu.ar.p.b.a("DuMixController", "mDuMixCallback.onSetup()");
                    DuMixController.this.f8900e.onSetup(this.f8907a, this.f8908b, this.f8909c);
                }
            }
        }

        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f8911a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f8912b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f8913c;

            b(boolean z, String str, String str2) {
                this.f8911a = z;
                this.f8912b = str;
                this.f8913c = str2;
            }

            public void run() {
                DuMixCallback duMixCallback = DuMixController.this.f8900e;
                if (duMixCallback != null) {
                    duMixCallback.onCaseCreate(this.f8911a, this.f8912b, this.f8913c);
                }
            }
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                DuMixCallback duMixCallback = DuMixController.this.f8900e;
                if (duMixCallback != null) {
                    duMixCallback.onCaseDestroy();
                }
            }
        }

        class d implements Runnable {
            d() {
            }

            public void run() {
                DuMixCallback duMixCallback = DuMixController.this.f8900e;
                if (duMixCallback != null) {
                    duMixCallback.onRelease();
                    DuMixController.this.f8900e = null;
                }
            }
        }

        class e implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ DuMixErrorType f8917a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f8918b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f8919c;

            e(DuMixErrorType duMixErrorType, String str, String str2) {
                this.f8917a = duMixErrorType;
                this.f8918b = str;
                this.f8919c = str2;
            }

            public void run() {
                DuMixCallback duMixCallback = DuMixController.this.f8900e;
                if (duMixCallback != null) {
                    duMixCallback.onError(this.f8917a, this.f8918b, this.f8919c);
                }
            }
        }

        a() {
        }

        public void onCaseCreate(boolean z, String str, String str2) {
            if (DuMixController.this.f8903h != null) {
                DuMixController.this.f8903h.post(new b(z, str, str2));
            }
        }

        public void onCaseDestroy() {
            if (DuMixController.this.f8903h != null) {
                DuMixController.this.f8903h.post(new c());
            }
        }

        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            if (DuMixController.this.f8903h != null) {
                DuMixController.this.f8903h.post(new e(duMixErrorType, str, str2));
            }
        }

        public void onRelease() {
            com.baidu.ar.p.b.a("DuMixController", "getDuMixCallbackProxy onRelease sState = " + DuMixController.u);
            if (DuMixController.this.k != null) {
                DuMixController.this.k.c();
                com.baidu.ar.lua.b unused = DuMixController.this.k = null;
            }
            if (DuMixController.this.f8905j != null) {
                DuMixController.this.f8905j.r();
                e unused2 = DuMixController.this.f8905j = null;
            }
            if (DuMixController.this.f8901f != null) {
                DuMixController.this.f8901f.quitSafely();
                HandlerThread unused3 = DuMixController.this.f8901f = null;
            }
            int unused4 = DuMixController.u = 0;
            synchronized (DuMixController.v) {
                try {
                    DuMixController.v.notifyAll();
                } catch (Exception e2) {
                    com.baidu.ar.p.b.a("DuMixController", "onRelease normal!!!");
                }
            }
            if (DuMixController.this.f8903h != null) {
                DuMixController.this.f8903h.post(new d());
                Handler unused5 = DuMixController.this.f8903h = null;
            }
        }

        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            com.baidu.ar.p.b.a("DuMixController", "getDuMixCallbackProxy onSetup sState = " + DuMixController.u);
            if (z) {
                int unused = DuMixController.u = 2;
            }
            if (DuMixController.this.f8905j != null) {
                DuMixController.this.f8905j.e();
            }
            if (DuMixController.this.f8903h != null) {
                DuMixController.this.f8903h.post(new C0143a(z, duMixInput, duMixOutput));
            }
            synchronized (DuMixController.v) {
                try {
                    DuMixController.v.notifyAll();
                } catch (Exception e2) {
                    com.baidu.ar.p.b.a("DuMixController", "onSetup normal!!!");
                }
            }
        }
    }

    class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 3000:
                    DuMixController.this.h();
                    return;
                case 3001:
                    DuMixController.this.e();
                    return;
                case 3002:
                    DuMixController.this.g();
                    return;
                case 3003:
                    DuMixController.this.f();
                    return;
                case 3004:
                    DuMixController.this.a((CaseModel) message.obj);
                    return;
                case 3005:
                    DuMixController.this.d();
                    return;
                case 3006:
                    if (DuMixController.this.m != null) {
                        DuMixController.this.m.changeOutputSize(message.arg1, message.arg2);
                        return;
                    }
                    return;
                case AsrError.ERROR_AUDIO_RECORDER_CLOSE:
                    DuMixOutput unused = DuMixController.this.f8899d = (DuMixOutput) message.obj;
                    if (DuMixController.this.m != null) {
                        DuMixController.this.m.changeOutput(DuMixController.this.f8899d);
                        return;
                    }
                    return;
                case AsrError.ERROR_AUDIO_FILE_OPEN:
                    if (DuMixController.this.m != null) {
                        DuMixController.this.m.pauseScene();
                        return;
                    }
                    return;
                case AsrError.ERROR_AUDIO_FILE_READ:
                    if (DuMixController.this.m != null) {
                        DuMixController.this.m.resumeScene();
                        return;
                    }
                    return;
                case AsrError.ERROR_AUDIO_FILE_CLOSE:
                    if (DuMixController.this.m != null) {
                        DuMixController.this.m.a(message.obj, message.arg1, message.arg2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private DuMixController(Context context, DefaultParams defaultParams) {
        this.f8896a = context;
        if (defaultParams != null) {
            this.f8897b = defaultParams;
        } else {
            this.f8897b = new DefaultParams();
        }
        com.baidu.ar.p.b.a("DuMixController", "create DuMixController sState = " + u);
        if (u == 3) {
            synchronized (v) {
                try {
                    com.baidu.ar.p.b.a("DuMixController", "create DuMixController wait for release!");
                    v.wait(3000);
                } catch (Exception e2) {
                    com.baidu.ar.p.b.b("DuMixController", "create DuMixController wait error!!!");
                }
            }
        }
        HandlerThread handlerThread = new HandlerThread("DuMixController");
        this.f8901f = handlerThread;
        handlerThread.start();
        this.f8902g = new b(this.f8901f.getLooper());
        com.baidu.ar.j.c.a().a(this.f8901f.getLooper());
        a(this.f8896a, this.f8897b);
        "ar_sdk_version : " + getVersionCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.baidu.ar.arrender.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.baidu.ar.arrender.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: com.baidu.ar.arrender.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.baidu.ar.arrender.d} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r9, com.baidu.ar.DefaultParams r10) {
        /*
            r8 = this;
            java.lang.String r0 = "DuMixController"
            java.lang.String r1 = "createManagers start!!!"
            com.baidu.ar.p.b.a(r0, r1)
            android.os.Handler r1 = r8.f8903h
            if (r1 != 0) goto L_0x0016
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = r9.getMainLooper()
            r1.<init>(r2)
            r8.f8903h = r1
        L_0x0016:
            boolean r1 = r10.isLogEnable()
            com.baidu.ar.p.b.a((boolean) r1)
            java.lang.String r1 = r9.getPackageName()
            com.baidu.ar.p.a.b(r1)
            com.baidu.ar.arplay.core.engine.rotate.OrientationManager r1 = r8.q
            if (r1 != 0) goto L_0x002f
            com.baidu.ar.arplay.core.engine.rotate.OrientationManager r1 = new com.baidu.ar.arplay.core.engine.rotate.OrientationManager
            r1.<init>(r9)
            r8.q = r1
        L_0x002f:
            com.baidu.ar.statistic.StatisticApi.init(r9)
            com.baidu.ar.e r1 = r8.f8905j
            if (r1 != 0) goto L_0x0047
            com.baidu.ar.e r1 = new com.baidu.ar.e
            android.os.HandlerThread r2 = r8.f8901f
            r1.<init>(r9, r10, r2)
            r8.f8905j = r1
            r1.a((com.baidu.ar.DuMixController) r8)
            com.baidu.ar.e r1 = r8.f8905j
            r1.a()
        L_0x0047:
            com.baidu.ar.g.b r1 = r8.p
            if (r1 != 0) goto L_0x0059
            com.baidu.ar.g.b r1 = new com.baidu.ar.g.b
            r1.<init>(r9)
            r8.p = r1
            org.json.JSONObject r2 = r10.getGradingConfig()
            r1.a((org.json.JSONObject) r2)
        L_0x0059:
            com.baidu.ar.filter.a r1 = r8.n
            if (r1 != 0) goto L_0x0078
            com.baidu.ar.filter.a r1 = new com.baidu.ar.filter.a
            r1.<init>(r10)
            r8.n = r1
            com.baidu.ar.b r1 = new com.baidu.ar.b
            android.os.HandlerThread r2 = r8.f8901f
            android.os.Looper r4 = r2.getLooper()
            com.baidu.ar.g.b r6 = r8.p
            com.baidu.ar.filter.a r7 = r8.n
            r2 = r1
            r3 = r9
            r5 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            r8.o = r1
        L_0x0078:
            com.baidu.ar.lua.b r1 = r8.k
            if (r1 != 0) goto L_0x008a
            com.baidu.ar.lua.b r1 = new com.baidu.ar.lua.b
            r1.<init>(r9)
            r8.k = r1
            boolean r2 = r10.isUserPlayAudio()
            r1.a((boolean) r2)
        L_0x008a:
            com.baidu.ar.arrender.c r1 = r8.m
            if (r1 != 0) goto L_0x00d2
            boolean r1 = r10.isUseTextureIO()
            if (r1 == 0) goto L_0x00ac
            com.baidu.ar.arrender.d r1 = new com.baidu.ar.arrender.d
            android.os.HandlerThread r2 = r8.f8901f
            android.os.Looper r4 = r2.getLooper()
            com.baidu.ar.lua.b r5 = r8.k
            android.opengl.EGLContext r6 = r10.getShareContext()
            java.lang.String r7 = r10.get3dShaderDBPath()
            r2 = r1
            r3 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x00bd
        L_0x00ac:
            com.baidu.ar.arrender.c r1 = new com.baidu.ar.arrender.c
            android.os.HandlerThread r2 = r8.f8901f
            android.os.Looper r2 = r2.getLooper()
            com.baidu.ar.lua.b r3 = r8.k
            java.lang.String r4 = r10.get3dShaderDBPath()
            r1.<init>(r9, r2, r3, r4)
        L_0x00bd:
            r8.m = r1
            java.lang.String r9 = r10.getRenderPipeline()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00d2
            com.baidu.ar.arrender.c r9 = r8.m
            java.lang.String r10 = r10.getRenderPipeline()
            r9.setDefaultPipeLine(r10)
        L_0x00d2:
            java.lang.String r9 = "createManagers end!!!"
            com.baidu.ar.p.b.a(r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.DuMixController.a(android.content.Context, com.baidu.ar.DefaultParams):void");
    }

    /* access modifiers changed from: private */
    public void a(CaseModel caseModel) {
        if (this.f8905j == null || u != 2) {
            com.baidu.ar.p.b.b("DuMixController", "handleLoadCase DuMix has not setup!!!!!!");
            DuMixCallback duMixCallback = this.f8904i;
            if (duMixCallback != null) {
                duMixCallback.onCaseCreate(false, caseModel.mCasePath, caseModel.mCaseId);
                return;
            }
            return;
        }
        this.f8905j.c(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
    }

    private DuMixCallback c() {
        return new a();
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.f8905j == null || u != 2) {
            com.baidu.ar.p.b.b("DuMixController", "handleClearCase DuMix has not setup!!!!!!");
        } else {
            this.f8905j.c();
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (u == 2) {
            b bVar = this.o;
            if (bVar != null) {
                bVar.j();
            }
            c cVar = this.m;
            if (cVar != null) {
                cVar.pause();
            }
            OrientationManager orientationManager = this.q;
            if (orientationManager != null) {
                orientationManager.disable();
            }
            StatisticApi.pause();
            e eVar = this.f8905j;
            if (eVar != null) {
                eVar.c("pause");
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        com.baidu.ar.p.b.a("DuMixController", "handleRelease() sState = " + u);
        Handler handler = this.f8902g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f8902g = null;
        }
        this.s = null;
        e eVar = this.f8905j;
        if (eVar != null) {
            eVar.s();
        }
        e eVar2 = this.l;
        if (eVar2 != null) {
            eVar2.b();
            this.l = null;
        }
        com.baidu.ar.filter.a aVar = this.n;
        if (aVar != null) {
            aVar.b();
            this.n.e();
            this.n = null;
        }
        b bVar = this.o;
        if (bVar != null) {
            bVar.k();
            this.o = null;
        }
        c cVar = this.m;
        if (cVar != null) {
            cVar.release();
            this.m = null;
        }
        OrientationManager orientationManager = this.q;
        if (orientationManager != null) {
            orientationManager.destroy();
            this.q = null;
        }
        com.baidu.ar.g.b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.c();
            this.p = null;
        }
        com.baidu.ar.libloader.a.c();
        ARAuth.release();
        StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
        StatisticApi.onEventEnd(StatisticConstants.EVENT_SDK_END);
        StatisticApi.release();
        this.f8898c = null;
        this.f8899d = null;
        this.f8897b = null;
        this.f8904i = null;
        this.f8896a = null;
        com.baidu.ar.p.b.a("DuMixController", "handleRelease() end");
    }

    /* access modifiers changed from: private */
    public void g() {
        if (u == 2) {
            e eVar = this.f8905j;
            if (eVar != null) {
                eVar.c("resume");
            }
            StatisticApi.resume();
            OrientationManager orientationManager = this.q;
            if (orientationManager != null) {
                orientationManager.enable();
            }
            c cVar = this.m;
            if (cVar != null) {
                cVar.resume();
            }
            b bVar = this.o;
            if (bVar != null) {
                bVar.m();
            }
        }
    }

    public static IAuthenticator getAsyncAuthenticator(String str, String str2, String str3) {
        return com.baidu.ar.auth.a.a(str, str2, str3);
    }

    public static IAuthenticator getAuthenticator() {
        return com.baidu.ar.auth.a.a();
    }

    public static DuMixController getInstance(Context context, DefaultParams defaultParams) {
        if (context == null) {
            com.baidu.ar.p.b.b("DuMixController", "getInstance() context must be set!!!");
            return null;
        }
        if (t == null) {
            synchronized (DuMixController.class) {
                if (t == null) {
                    t = new DuMixController(context, defaultParams);
                }
            }
        }
        return t;
    }

    public static IOfflineAuthenticator getOfflineAuthenticator() {
        return com.baidu.ar.auth.a.b();
    }

    public static String getSoDownLoadDir(Context context) {
        return e.a(context);
    }

    public static int getVersionCode() {
        return com.baidu.ar.p.c.a();
    }

    public static String getVersionName() {
        return com.baidu.ar.p.c.b();
    }

    /* access modifiers changed from: private */
    public void h() {
        com.baidu.ar.p.b.a("DuMixController", "handleSetup() sState = " + u);
        if (u == 0 && this.f8905j != null && this.m != null && this.n != null && this.o != null && this.p != null) {
            u = 1;
            this.f8904i = c();
            this.f8905j.a(this.m, this.o, this.n, this.k);
            this.f8905j.a(this.f8898c, this.f8899d, this.f8904i);
            StatisticApi.setPubParam(StatisticConstants.FRAME_DATA_FROM, this.f8898c.isCameraInput() ? "camera" : "video");
            StatisticApi.onEventStart(StatisticConstants.EVENT_SDK_START);
            this.q.addOrientationListener(this.m);
            this.q.enable();
            this.n.a((k) this.m);
            com.baidu.ar.g.b bVar = this.p;
            if (bVar != null) {
                JSONObject b2 = bVar.b();
                if (b2 != null) {
                    this.m.a(b2);
                } else {
                    this.m.b(this.p.a());
                }
            }
            this.o.a(this.k, this.m);
            this.m.a(this.f8898c, this.f8899d);
            this.f8905j.a(this.p);
            this.f8905j.f();
        }
    }

    public boolean addAbility(String str, String str2) {
        return addAbility(str, str2, (String) null);
    }

    public boolean addAbility(String str, String str2, String str3) {
        b bVar = this.o;
        if (bVar == null) {
            return false;
        }
        return bVar.a(str, (List<String>) Arrays.asList(new String[]{str2}), str3);
    }

    public boolean addAbility(String str, List<String> list) {
        b bVar = this.o;
        if (bVar != null) {
            return bVar.a(str, list, (String) null);
        }
        return false;
    }

    public void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.addFrameRenderListener(frameRenderListener);
        }
    }

    public boolean addLuaMsgListener(LuaMsgListener luaMsgListener) {
        com.baidu.ar.lua.b bVar = this.k;
        if (bVar == null || bVar.d() == null) {
            return false;
        }
        return this.k.d().a(luaMsgListener);
    }

    public void addOutput(DuMixOutput duMixOutput) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.addOutputSurface(duMixOutput);
        }
    }

    public boolean adjustAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        if (this.o == null || abilityType == null || u != 2) {
            return false;
        }
        return this.o.b(abilityType.getTypeValue(), hashMap);
    }

    public boolean adjustAbility(String str, HashMap<String, Object> hashMap) {
        if (this.o == null || TextUtils.isEmpty(str) || u != 2) {
            return false;
        }
        return this.o.b(str, hashMap);
    }

    public void changeInputSize(int i2, int i3) {
        com.baidu.ar.p.b.a("DuMixController", "changeInputSize width * height = " + i2 + " * " + i3);
        Handler handler = this.f8902g;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(AsrError.ERROR_AUDIO_FILE_CLOSE, i2, i3, (Object) null));
        }
    }

    public void changeInputSize(SurfaceTexture surfaceTexture, int i2, int i3) {
        com.baidu.ar.p.b.a("DuMixController", "changeInputSize width * height = " + i2 + " * " + i3 + " && texture = " + surfaceTexture);
        Handler handler = this.f8902g;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(AsrError.ERROR_AUDIO_FILE_CLOSE, i2, i3, surfaceTexture));
        }
    }

    public void changeOutput(DuMixOutput duMixOutput) {
        Handler handler;
        if (duMixOutput != null && (handler = this.f8902g) != null) {
            handler.sendMessage(handler.obtainMessage(AsrError.ERROR_AUDIO_RECORDER_CLOSE, duMixOutput));
        }
    }

    public void changeOutputObject(Object obj, int i2, int i3) {
        c cVar;
        if (obj != null && (cVar = this.m) != null) {
            cVar.b(obj, i2, i3);
        }
    }

    public void changeOutputSize(int i2, int i3) {
        com.baidu.ar.p.b.a("DuMixController", "changeOutputSize width * height = " + i2 + " * " + i3);
        Handler handler = this.f8902g;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3006, i2, i3));
        }
    }

    @Deprecated
    public List<Integer> checkAuth(byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        return ARAuth.checkAuth(this.f8896a, bArr, iDuMixAuthCallback);
    }

    @Deprecated
    public List<Integer> checkAuth(byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        return ARAuth.checkAuth(this.f8896a, bArr, iCallbackWith, iCallbackWith2);
    }

    public void clearAllFilter() {
        if (this.n != null && u == 2) {
            this.n.b();
        }
    }

    public void clearCase() {
        Handler handler = this.f8902g;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3005));
        }
    }

    public void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        c cVar;
        e eVar;
        if ((u == 0 || u == 1) && (eVar = this.f8905j) != null) {
            eVar.a(pixelReadParams, pixelReadListener);
        } else if (u == 2 && (cVar = this.m) != null) {
            cVar.a(pixelReadParams, pixelReadListener);
        }
    }

    public void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.b(pixelReadParams, pixelReadListener);
        }
    }

    public ARProxyManager getARProxyManager() {
        b bVar = this.o;
        if (bVar != null) {
            return bVar.d();
        }
        return null;
    }

    public k getARRenderer() {
        c cVar = this.m;
        if (cVar == null || !(cVar instanceof k)) {
            return null;
        }
        return cVar;
    }

    public List<String> getActiveAbilities() {
        if (this.o == null || u != 2) {
            return null;
        }
        return this.o.e();
    }

    public IContentPlatform getContentPlatform() {
        if (this.s == null) {
            this.s = (IContentPlatform) o.a("com.baidu.ar.content.ContentCloud", new Class[]{Context.class}, new Object[]{this.f8896a});
        }
        return this.s;
    }

    public IGLRenderer getGLRenderer() {
        c cVar = this.m;
        if (cVar == null || !(cVar instanceof IGLRenderer)) {
            return null;
        }
        return (IGLRenderer) cVar;
    }

    public IStepLoading getStepLoading() {
        c cVar = this.m;
        if (cVar != null) {
            return cVar.u();
        }
        return null;
    }

    public List<String> getSupportedAbilities() {
        if (this.o == null || u != 2) {
            return null;
        }
        return this.o.g();
    }

    public boolean isAbilityActive(AbilityType abilityType) {
        if (this.o == null || abilityType == null || u != 2) {
            return false;
        }
        return this.o.d(abilityType.getTypeValue());
    }

    public boolean isAbilityActive(String str) {
        if (this.o == null || TextUtils.isEmpty(str) || u != 2) {
            return false;
        }
        return this.o.d(str);
    }

    public boolean isAbilitySupported(String str) {
        if (this.o == null || u != 2) {
            return false;
        }
        return this.o.e(str);
    }

    public void loadCase(ARType aRType, String str, String str2) {
        if (this.f8902g != null) {
            CaseModel caseModel = new CaseModel(aRType, str, str2);
            Handler handler = this.f8902g;
            handler.sendMessage(handler.obtainMessage(3004, caseModel));
        }
    }

    public void loadCase(String str, String str2) {
        loadCase((ARType) null, str, str2);
    }

    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (this.m == null || u != 2) {
            return false;
        }
        return this.m.onTouch(view2, motionEvent);
    }

    public void pause() {
        Handler handler = this.f8902g;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3001));
        }
    }

    public void pauseRecord() {
        if (this.r != null && u == 2) {
            this.r.pauseRecord();
        }
    }

    public void pauseScene() {
        Handler handler = this.f8902g;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(AsrError.ERROR_AUDIO_FILE_OPEN));
        }
    }

    public void release() {
        com.baidu.ar.p.b.a("DuMixController", "release() sState = " + u);
        if (u == 1) {
            c cVar = this.m;
            if (cVar == null || !cVar.k()) {
                synchronized (v) {
                    try {
                        com.baidu.ar.p.b.a("DuMixController", "release DuMixController wait for setup!");
                        v.wait(3000);
                    } catch (Exception e2) {
                        com.baidu.ar.p.b.b("DuMixController", "release DuMixController wait error!!!");
                    }
                }
            } else {
                this.m.e(true);
                t = null;
            }
        } else if (u == 0) {
            t = null;
            return;
        } else if (u != 3) {
            if (u != 2) {
                com.baidu.ar.p.b.b("DuMixController", "release error!!!");
                return;
            }
        } else {
            return;
        }
        if (this.f8902g != null) {
            u = 3;
            this.f8902g.removeCallbacksAndMessages((Object) null);
            Handler handler = this.f8902g;
            handler.sendMessage(handler.obtainMessage(3003));
        }
        t = null;
    }

    public void removeFrameRenderListener(FrameRenderListener frameRenderListener) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.removeFrameRenderListener(frameRenderListener);
        }
    }

    public boolean removeLuaMsgListener(LuaMsgListener luaMsgListener) {
        com.baidu.ar.lua.b bVar = this.k;
        if (bVar == null || bVar.d() == null) {
            return false;
        }
        return this.k.d().b(luaMsgListener);
    }

    public void removeOutput(DuMixOutput duMixOutput) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.removeOutputSurface(duMixOutput);
        }
    }

    public void resetAllFilter() {
        if (this.n != null && u == 2) {
            this.n.f();
        }
    }

    public void resume() {
        Handler handler = this.f8902g;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3002));
        }
    }

    public void resumeRecord() {
        if (this.r != null && u == 2) {
            this.r.resumeRecord();
        }
    }

    public void resumeScene() {
        Handler handler = this.f8902g;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(AsrError.ERROR_AUDIO_FILE_READ));
        }
    }

    public boolean sendLuaScript2Engine(String str) {
        if (this.k == null || u != 2) {
            return false;
        }
        this.k.b(str);
        return true;
    }

    public boolean sendMsg2Lua(HashMap<String, Object> hashMap) {
        if (this.k == null || u != 2) {
            return false;
        }
        this.k.a(1902, hashMap);
        return true;
    }

    public void setARRenderFpsCallback(ARRenderFpsCallback aRRenderFpsCallback) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.a(aRRenderFpsCallback);
        }
    }

    public void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        ARAuth.setAuthLicense(bArr, str, str2, str3);
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        if (this.l == null) {
            this.l = new e(this.k);
        }
        this.l.a(definedLuaListener);
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        com.baidu.ar.filter.a aVar = this.n;
        if (aVar != null) {
            aVar.a(filterStateListener);
        }
    }

    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.a(context, viewGroup);
        }
    }

    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        com.baidu.ar.libloader.a.a(iLibLoaderPlugin);
    }

    public void setMdlModelPath(String str) {
        b bVar = this.o;
        if (bVar != null) {
            bVar.h(str);
        }
    }

    public void setNativeWebViewUseable(Context context, ViewGroup viewGroup) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.b(context, viewGroup);
        }
    }

    public void setRecordWatermark(Watermark watermark) {
        if (u == 2) {
            if (this.r == null && this.m != null) {
                this.r = new com.baidu.ar.record.a(this.f8896a, this.m);
            }
            com.baidu.ar.record.a aVar = this.r;
            if (aVar != null) {
                aVar.setRecordWatermark(watermark);
            }
        }
    }

    public void setStateListener(DuMixStateListener duMixStateListener) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.setStateListener(duMixStateListener);
        }
    }

    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback) {
        com.baidu.ar.p.b.a("DuMixController", "setup() sState = " + u);
        if (duMixInput == null || duMixOutput == null) {
            com.baidu.ar.p.b.b("DuMixController", "setup error!!! params maybe null!!!");
            if (duMixCallback != null) {
                duMixCallback.onSetup(false, duMixInput, duMixOutput);
                return;
            }
            return;
        }
        this.f8898c = duMixInput;
        this.f8899d = duMixOutput;
        this.f8900e = duMixCallback;
        Handler handler = this.f8902g;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3000));
        }
        com.baidu.ar.p.b.a("DuMixController", "Welcome to BaiDu AR " + getVersionName());
    }

    public boolean startAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        if (this.o == null || abilityType == null || u != 2) {
            return false;
        }
        return this.o.a(abilityType.getTypeValue(), hashMap, true);
    }

    public boolean startAbility(String str, HashMap<String, Object> hashMap) {
        if (this.o == null || TextUtils.isEmpty(str) || u != 2) {
            return false;
        }
        return this.o.a(str, hashMap, true);
    }

    public void startRecord(String str, long j2, RecordCallback recordCallback) {
        DefaultParams defaultParams;
        if (u == 2) {
            if (this.r == null && this.m != null) {
                this.r = new com.baidu.ar.record.a(this.f8896a, this.m);
            }
            e eVar = this.f8905j;
            if (eVar != null) {
                eVar.b("start");
            }
            if (this.r != null) {
                if (!(this.f8899d == null || (defaultParams = this.f8897b) == null || !defaultParams.isRecordAutoCrop())) {
                    this.r.a(this.f8899d.getOutputWidth(), this.f8899d.getOutputHeight());
                }
                this.r.startRecord(str, j2, recordCallback);
            }
        }
    }

    public boolean stopAbility(AbilityType abilityType) {
        if (this.o == null || abilityType == null || u != 2) {
            return false;
        }
        return this.o.a(abilityType.getTypeValue(), true);
    }

    public boolean stopAbility(String str) {
        if (this.o == null || TextUtils.isEmpty(str) || u != 2) {
            return false;
        }
        return this.o.a(str, true);
    }

    public void stopRecord() {
        if (u == 2) {
            com.baidu.ar.record.a aVar = this.r;
            if (aVar != null) {
                aVar.stopRecord();
                this.r = null;
            }
            e eVar = this.f8905j;
            if (eVar != null) {
                eVar.b("stop");
            }
        }
    }

    public void takePicture(String str, PhotoCallback photoCallback) {
        if (this.m != null && u == 2) {
            new com.baidu.ar.photo.a().a(this.m, str, photoCallback);
        }
    }

    public void updateFilter(FilterParam filterParam, float f2) {
        if (this.n != null && u == 2) {
            this.n.a(filterParam, (Object) Float.valueOf(f2));
        }
    }

    public void updateFilter(FilterParam filterParam, int i2) {
        if (this.n != null && u == 2) {
            this.n.a(filterParam, (Object) Integer.valueOf(i2));
        }
    }

    public void updateFilter(FilterParam filterParam, String str) {
        if (this.n != null && u == 2) {
            this.n.a(filterParam, (Object) str);
        }
    }

    public void updateFilter(FilterParam filterParam, List<Point> list) {
        if (list != null && u == 2) {
            float[] fArr = new float[(list.size() * 2)];
            for (int i2 = 0; i2 < list.size(); i2++) {
                int i3 = i2 * 2;
                fArr[i3] = (float) list.get(i2).x;
                fArr[i3 + 1] = (float) list.get(i2).y;
            }
            com.baidu.ar.filter.a aVar = this.n;
            if (aVar != null) {
                aVar.a(filterParam, Integer.valueOf(list.size()), "_count", false);
                this.n.a(filterParam, (Object) fArr);
            }
        }
    }

    public void updateFilter(FilterParam filterParam, float[] fArr) {
        if (this.n != null && u == 2) {
            this.n.a(filterParam, (Object) fArr);
        }
    }

    public String updateFilterCase(String str) {
        if (this.n == null || u != 2) {
            return null;
        }
        return this.n.b(str);
    }

    public void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.a(pixelReadParams, pixelRotation);
        }
    }
}
