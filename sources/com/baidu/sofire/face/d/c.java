package com.baidu.sofire.face.d;

import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.text.TextUtils;
import java.io.File;

/* compiled from: MediaRecordManager */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f3254f = false;

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f3255g;

    /* renamed from: a  reason: collision with root package name */
    public MediaRecorder f3256a;

    /* renamed from: b  reason: collision with root package name */
    public File f3257b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f3258c = false;

    /* renamed from: d  reason: collision with root package name */
    public Context f3259d;

    /* renamed from: e  reason: collision with root package name */
    public Camera f3260e;

    /* compiled from: MediaRecordManager */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f3261a;

        public a(a aVar) {
            this.f3261a = aVar;
        }

        public void run() {
            try {
                c cVar = c.this;
                MediaRecorder mediaRecorder = cVar.f3256a;
                if (mediaRecorder != null) {
                    mediaRecorder.start();
                    return;
                }
                boolean unused = cVar.f3258c = false;
                c.this.a();
                a aVar = this.f3261a;
                if (aVar != null) {
                    aVar.a(-5);
                }
            } catch (Throwable th2) {
                boolean unused2 = c.this.f3258c = false;
                c.this.a();
                a aVar2 = this.f3261a;
                if (aVar2 != null) {
                    aVar2.a(-5);
                }
                th2.printStackTrace();
            }
        }
    }

    public c(Context context) {
        this.f3259d = context;
    }

    public String b() {
        try {
            MediaRecorder mediaRecorder = this.f3256a;
            if (mediaRecorder != null) {
                try {
                    mediaRecorder.release();
                } catch (Throwable th2) {
                }
                this.f3256a = null;
            }
            Camera camera = this.f3260e;
            if (camera != null) {
                camera.lock();
                this.f3260e = null;
            }
        } catch (Throwable th3) {
            this.f3258c = false;
            return "";
        }
        this.f3258c = false;
        File file = this.f3257b;
        if (file != null) {
            return file.getAbsolutePath();
        }
        return "";
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.baidu.sofire.face.d.c a(android.content.Context r2) {
        /*
            java.lang.Class<com.baidu.sofire.face.d.c> r0 = com.baidu.sofire.face.d.c.class
            monitor-enter(r0)
            com.baidu.sofire.face.d.c r1 = f3255g     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.baidu.sofire.face.d.c r1 = f3255g     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.baidu.sofire.face.d.c r1 = new com.baidu.sofire.face.d.c     // Catch:{ all -> 0x0015 }
            r1.<init>(r2)     // Catch:{ all -> 0x0015 }
            f3255g = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.baidu.sofire.face.d.c r2 = f3255g     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r2
        L_0x001c:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.face.d.c.a(android.content.Context):com.baidu.sofire.face.d.c");
    }

    public synchronized int a(Camera camera, String str, int i2, a aVar) {
        if (camera == null) {
            return -1;
        }
        try {
            this.f3260e = camera;
            f3254f = false;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            long freeSpace = file.getFreeSpace();
            long j2 = freeSpace / 1048576;
            if (!(freeSpace >= 100)) {
                return -4;
            }
            if (this.f3258c) {
                return 2;
            }
            this.f3258c = true;
            if (!a(camera, str, i2)) {
                this.f3258c = false;
                a();
                return -2;
            }
            new a(aVar).start();
            return 1;
        } catch (Exception e2) {
            this.f3258c = false;
            e2.printStackTrace();
            a();
            return -3;
        }
    }

    public boolean a(Camera camera, String str, int i2) {
        try {
            int i3 = camera.getParameters().getPreviewSize().width;
            int i4 = camera.getParameters().getPreviewSize().height;
            camera.unlock();
            if (this.f3256a == null) {
                this.f3256a = new MediaRecorder();
            }
            this.f3256a.reset();
            this.f3256a.setCamera(camera);
            this.f3256a.setAudioSource(1);
            this.f3256a.setVideoSource(1);
            this.f3256a.setOutputFormat(2);
            this.f3256a.setAudioEncoder(3);
            this.f3256a.setVideoEncoder(2);
            this.f3256a.setVideoSize(i3, i4);
            File a2 = com.baidu.sofire.face.a.a.a(str);
            this.f3257b = a2;
            this.f3256a.setOutputFile(a2.getAbsolutePath());
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            this.f3256a.setOrientationHint(cameraInfo.orientation);
            this.f3256a.prepare();
            return true;
        } catch (Throwable th2) {
            return false;
        }
    }

    public void a() {
        try {
            this.f3258c = false;
            MediaRecorder mediaRecorder = this.f3256a;
            if (mediaRecorder != null) {
                try {
                    mediaRecorder.release();
                } catch (Throwable th2) {
                }
                this.f3256a = null;
            }
            Camera camera = this.f3260e;
            if (camera != null) {
                camera.lock();
                this.f3260e = null;
            }
        } catch (Throwable th3) {
            return;
        }
        File file = this.f3257b;
        if (file != null) {
            file.delete();
            this.f3257b = null;
        }
    }
}
