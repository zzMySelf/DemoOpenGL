package com.dxmpay.apollon.imagemanager;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b {

    /* renamed from: ad  reason: collision with root package name */
    public static HashMap<String, Bitmap> f4000ad = new ImageMemoryCache$1(7, 0.75f, true);

    /* renamed from: de  reason: collision with root package name */
    public static HandlerThread f4001de;

    /* renamed from: fe  reason: collision with root package name */
    public static Handler f4002fe;
    public static ConcurrentHashMap<String, SoftReference<Bitmap>> qw = new ConcurrentHashMap<>(7);

    /* renamed from: rg  reason: collision with root package name */
    public static Runnable f4003rg = new qw();

    public static class ad {
        static {
            HandlerThread unused = b.f4001de = new HandlerThread("sb_imagecache_loop", 10);
            b.f4001de.start();
            Handler unused2 = b.f4002fe = new Handler(b.f4001de.getLooper());
        }
    }

    public static class qw implements Runnable {
        public void run() {
            b.i();
        }
    }

    public static void i() {
        synchronized (f4000ad) {
            for (Map.Entry next : f4000ad.entrySet()) {
                qw.put(next.getKey(), new SoftReference(next.getValue()));
            }
            f4000ad.clear();
        }
        LinkedList linkedList = new LinkedList();
        for (Map.Entry next2 : qw.entrySet()) {
            if (((SoftReference) next2.getValue()).get() == null) {
                linkedList.add(next2.getKey());
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            qw.remove((String) it.next());
        }
    }

    public void fe() {
        if (f4002fe == null) {
        }
        Handler handler = f4002fe;
        if (handler != null) {
            handler.removeCallbacks(f4003rg);
            f4002fe.postDelayed(f4003rg, 10000);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r0 = (android.graphics.Bitmap) r0.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r0 == null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        rg(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        qw.remove(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = qw.get(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r0 == null) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap qw(java.lang.String r3) {
        /*
            r2 = this;
            java.util.HashMap<java.lang.String, android.graphics.Bitmap> r0 = f4000ad
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, android.graphics.Bitmap> r1 = f4000ad     // Catch:{ all -> 0x002d }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x002d }
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r1
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> r0 = qw
            java.lang.Object r0 = r0.get(r3)
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r0.get()
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 == 0) goto L_0x0026
            r2.rg(r3, r0)
            return r0
        L_0x0026:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> r0 = qw
            r0.remove(r3)
        L_0x002b:
            r3 = 0
            return r3
        L_0x002d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.imagemanager.b.qw(java.lang.String):android.graphics.Bitmap");
    }

    public void rg(String str, Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (f4000ad) {
                f4000ad.put(str, bitmap);
            }
        }
    }
}
