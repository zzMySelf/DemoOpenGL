package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.baidu.mapsdkplatform.comapi.commonutils.c;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class z extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f15063a;

    /* renamed from: b  reason: collision with root package name */
    private SurfaceTexture f15064b;

    /* renamed from: c  reason: collision with root package name */
    private a f15065c;

    /* renamed from: d  reason: collision with root package name */
    private EGL10 f15066d;

    /* renamed from: e  reason: collision with root package name */
    private EGLDisplay f15067e = EGL10.EGL_NO_DISPLAY;

    /* renamed from: f  reason: collision with root package name */
    private EGLContext f15068f = EGL10.EGL_NO_CONTEXT;

    /* renamed from: g  reason: collision with root package name */
    private EGLSurface f15069g = EGL10.EGL_NO_SURFACE;

    /* renamed from: h  reason: collision with root package name */
    private GL10 f15070h;

    /* renamed from: i  reason: collision with root package name */
    private int f15071i = 1;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15072j = false;
    private final C0312c k;
    /* access modifiers changed from: private */
    public Object l = new Object();

    public interface a {
        int a();
    }

    public z(SurfaceTexture surfaceTexture, a aVar, AtomicBoolean atomicBoolean, C0312c cVar) {
        this.f15064b = surfaceTexture;
        this.f15065c = aVar;
        this.f15063a = atomicBoolean;
        this.k = cVar;
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f15066d = egl10;
        if (egl10 == null) {
            return false;
        }
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f15067e = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (this.f15066d.eglInitialize(eglGetDisplay, new int[2])) {
                EGLConfig[] eGLConfigArr = new EGLConfig[100];
                int[] iArr = new int[1];
                if (!this.f15066d.eglChooseConfig(this.f15067e, new int[]{12352, 4, 12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344}, eGLConfigArr, 100, iArr) || iArr[0] <= 0) {
                    return false;
                }
                this.f15068f = this.f15066d.eglCreateContext(this.f15067e, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                EGLSurface eglCreateWindowSurface = this.f15066d.eglCreateWindowSurface(this.f15067e, eGLConfigArr[0], this.f15064b, (int[]) null);
                this.f15069g = eglCreateWindowSurface;
                if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE || this.f15068f == EGL10.EGL_NO_CONTEXT) {
                    if (this.f15066d.eglGetError() != 12299) {
                        GLUtils.getEGLErrorString(this.f15066d.eglGetError());
                    } else {
                        throw new RuntimeException("eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                    }
                }
                EGL10 egl102 = this.f15066d;
                EGLDisplay eGLDisplay = this.f15067e;
                EGLSurface eGLSurface = this.f15069g;
                if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f15068f)) {
                    this.f15070h = (GL10) this.f15068f.getGL();
                    return true;
                }
                throw new RuntimeException("eglMakeCurrent failed : " + GLUtils.getEGLErrorString(this.f15066d.eglGetError()));
            }
            throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.f15066d.eglGetError()));
        }
        throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.f15066d.eglGetError()));
    }

    private static boolean b(int i2, int i3, int i4, int i5, int i6, int i7) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        return egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
    }

    private void d() {
        try {
            b(5, 6, 5, 0, 24, 0);
            a(8, 8, 8, 0, 24, 0);
        } catch (IllegalArgumentException e2) {
            a(8, 8, 8, 0, 24, 0);
        }
        C0312c cVar = this.k;
        if (cVar != null) {
            synchronized (cVar) {
                if (this.k.b() != null) {
                    MapRenderer.nativeInit(this.k.b().A);
                    MapRenderer.nativeResize(this.k.b().A, C0312c.f14985a, C0312c.f14986b);
                }
            }
        }
    }

    private void e() {
        try {
            if (this.f15069g != EGL10.EGL_NO_SURFACE) {
                this.f15066d.eglMakeCurrent(this.f15067e, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                this.f15066d.eglDestroySurface(this.f15067e, this.f15069g);
                this.f15069g = EGL10.EGL_NO_SURFACE;
            }
            if (this.f15068f != EGL10.EGL_NO_CONTEXT) {
                this.f15066d.eglDestroyContext(this.f15067e, this.f15068f);
                this.f15068f = EGL10.EGL_NO_CONTEXT;
            }
            if (this.f15067e != EGL10.EGL_NO_DISPLAY) {
                this.f15066d.eglTerminate(this.f15067e);
                this.f15067e = EGL10.EGL_NO_DISPLAY;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        this.f15071i = 1;
        this.f15072j = false;
        c.a().a((Runnable) new y(this, this));
    }

    public void b() {
        this.f15071i = 0;
        synchronized (this.l) {
            this.f15072j = true;
        }
    }

    public void c() {
        this.f15072j = true;
        synchronized (this.l) {
            if (getState() == Thread.State.WAITING) {
                this.l.notifyAll();
            }
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void run() {
        /*
            r6 = this;
            com.baidu.mapsdkplatform.comapi.map.c r0 = r6.k
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.baidu.mapsdkplatform.comapi.map.o r0 = r0.b()
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            com.baidu.mapsdkplatform.comapi.map.z$a r0 = r6.f15065c
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            r6.d()
            javax.microedition.khronos.egl.EGL10 r0 = r6.f15066d
            if (r0 != 0) goto L_0x0019
            return
        L_0x0019:
            com.baidu.mapsdkplatform.comapi.map.z$a r0 = r6.f15065c
            if (r0 == 0) goto L_0x00a7
            int r0 = r6.f15071i     // Catch:{ InterruptedException -> 0x0098 }
            r1 = 1
            if (r0 != r1) goto L_0x008b
            boolean r0 = r6.f15072j     // Catch:{ InterruptedException -> 0x0098 }
            if (r0 != 0) goto L_0x008b
            com.baidu.mapsdkplatform.comapi.map.c r0 = r6.k     // Catch:{ InterruptedException -> 0x0098 }
            com.baidu.mapsdkplatform.comapi.map.o r0 = r0.b()     // Catch:{ InterruptedException -> 0x0098 }
            if (r0 != 0) goto L_0x0030
            goto L_0x00a7
        L_0x0030:
            com.baidu.mapsdkplatform.comapi.map.c r0 = r6.k     // Catch:{ InterruptedException -> 0x0098 }
            com.baidu.mapsdkplatform.comapi.map.o r0 = r0.b()     // Catch:{ InterruptedException -> 0x0098 }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0098 }
            java.lang.Object r1 = r6.l     // Catch:{ all -> 0x0088 }
            monitor-enter(r1)     // Catch:{ all -> 0x0088 }
            boolean r2 = r6.f15072j     // Catch:{ all -> 0x0085 }
            if (r2 != 0) goto L_0x0046
            com.baidu.mapsdkplatform.comapi.map.z$a r2 = r6.f15065c     // Catch:{ all -> 0x0085 }
            int r2 = r2.a()     // Catch:{ all -> 0x0085 }
            r6.f15071i = r2     // Catch:{ all -> 0x0085 }
        L_0x0046:
            monitor-exit(r1)     // Catch:{ all -> 0x0085 }
            com.baidu.mapsdkplatform.comapi.map.c r1 = r6.k     // Catch:{ all -> 0x0088 }
            com.baidu.mapsdkplatform.comapi.map.o r1 = r1.b()     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x007a
            java.util.List<com.baidu.mapsdkplatform.comapi.map.x> r2 = r1.y     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x007a
            java.util.List<com.baidu.mapsdkplatform.comapi.map.x> r2 = r1.y     // Catch:{ all -> 0x0088 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0088 }
        L_0x0059:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0088 }
            if (r3 == 0) goto L_0x007a
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0088 }
            com.baidu.mapsdkplatform.comapi.map.x r3 = (com.baidu.mapsdkplatform.comapi.map.x) r3     // Catch:{ all -> 0x0088 }
            if (r3 != 0) goto L_0x0068
            goto L_0x0059
        L_0x0068:
            com.baidu.mapsdkplatform.comapi.map.a r4 = r1.j()     // Catch:{ all -> 0x0088 }
            if (r4 != 0) goto L_0x006f
            goto L_0x007a
        L_0x006f:
            javax.microedition.khronos.opengles.GL10 r5 = r6.f15070h     // Catch:{ all -> 0x0088 }
            if (r5 != 0) goto L_0x0074
            goto L_0x007a
        L_0x0074:
            if (r3 == 0) goto L_0x0059
            r3.a((javax.microedition.khronos.opengles.GL10) r5, (com.baidu.mapsdkplatform.comapi.map.C0310a) r4)     // Catch:{ all -> 0x0088 }
            goto L_0x0059
        L_0x007a:
            javax.microedition.khronos.egl.EGL10 r1 = r6.f15066d     // Catch:{ all -> 0x0088 }
            javax.microedition.khronos.egl.EGLDisplay r2 = r6.f15067e     // Catch:{ all -> 0x0088 }
            javax.microedition.khronos.egl.EGLSurface r3 = r6.f15069g     // Catch:{ all -> 0x0088 }
            r1.eglSwapBuffers(r2, r3)     // Catch:{ all -> 0x0088 }
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            goto L_0x009c
        L_0x0085:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0085 }
            throw r2     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            throw r1     // Catch:{ InterruptedException -> 0x0098 }
        L_0x008b:
            java.lang.Object r0 = r6.l     // Catch:{ InterruptedException -> 0x0098 }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0098 }
            java.lang.Object r1 = r6.l     // Catch:{ all -> 0x0095 }
            r1.wait()     // Catch:{ all -> 0x0095 }
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            goto L_0x009c
        L_0x0095:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            throw r1     // Catch:{ InterruptedException -> 0x0098 }
        L_0x0098:
            r0 = move-exception
            r0.printStackTrace()
        L_0x009c:
            boolean r0 = r6.f15072j
            if (r0 == 0) goto L_0x00a1
            goto L_0x00a7
        L_0x00a1:
            boolean r0 = r6.isInterrupted()
            if (r0 == 0) goto L_0x0019
        L_0x00a7:
            r6.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.z.run():void");
    }
}
