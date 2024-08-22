package com.baidu.apollon.imagemanager;

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
    public static final boolean a = false;
    public static final String b = "ImageMemoryCache";
    public static final int c = 15;
    public static final int d = 10000;
    public static final float e = 0.75f;
    public static ConcurrentHashMap<String, SoftReference<Bitmap>> f = new ConcurrentHashMap<>(7);
    public static HashMap<String, Bitmap> g = new ImageMemoryCache$1(7, 0.75f, true);
    public static HandlerThread h;

    /* renamed from: i  reason: collision with root package name */
    public static Handler f701i;
    public static Runnable j = new Runnable() {
        public void run() {
            b.e();
        }
    };

    public static class a {
        static {
            HandlerThread unused = b.h = new HandlerThread("sb_imagecache_loop", 10);
            b.h.start();
            Handler unused2 = b.f701i = new Handler(b.h.getLooper());
        }

        public a() {
        }

        public /* synthetic */ a(ImageMemoryCache$1 imageMemoryCache$1) {
            this();
        }
    }

    public static void e() {
        synchronized (g) {
            for (Map.Entry next : g.entrySet()) {
                f.put(next.getKey(), new SoftReference(next.getValue()));
            }
            g.clear();
        }
        LinkedList linkedList = new LinkedList();
        for (Map.Entry next2 : f.entrySet()) {
            if (((SoftReference) next2.getValue()).get() == null) {
                linkedList.add(next2.getKey());
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f.remove((String) it.next());
        }
    }

    public void a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (g) {
                g.put(str, bitmap);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r0 = (android.graphics.Bitmap) r0.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r0 == null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        a(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        f.remove(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = f.get(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r0 == null) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap a(java.lang.String r3) {
        /*
            r2 = this;
            java.util.HashMap<java.lang.String, android.graphics.Bitmap> r0 = g
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, android.graphics.Bitmap> r1 = g     // Catch:{ all -> 0x002d }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x002d }
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r1
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> r0 = f
            java.lang.Object r0 = r0.get(r3)
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r0.get()
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 == 0) goto L_0x0026
            r2.a(r3, r0)
            return r0
        L_0x0026:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> r0 = f
            r0.remove(r3)
        L_0x002b:
            r3 = 0
            return r3
        L_0x002d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.imagemanager.b.a(java.lang.String):android.graphics.Bitmap");
    }

    public void a() {
        if (f701i == null) {
            new a((ImageMemoryCache$1) null);
        }
        Handler handler = f701i;
        if (handler != null) {
            handler.removeCallbacks(j);
            f701i.postDelayed(j, 10000);
        }
    }
}
