package com.baidu.wallet.lightapp.monitor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.monitor.WhiteScreenConfig;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.utils.URLUtil;
import com.tera.scan.component.base.ui.dialog.CustomListAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

public class WhiteScreenMonitor {
    public WhiteScreenConfig a;
    public List<a> b;
    public ThreadPoolExecutor c;
    public Handler d;
    public boolean e;
    public String f;
    public Context g;
    public final Map<String, c> h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, b> f3571i;

    public enum PageStates {
        START,
        FINISH,
        ACTIVE
    }

    public static class a {
        public Bitmap a;
        public boolean b;
        public Bitmap c;

        public a() {
            this.a = null;
            this.b = false;
            this.c = null;
        }
    }

    public static class b {
        public boolean a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;

        public b a(boolean z) {
            this.a = z;
            return this;
        }

        public b b(String str) {
            this.c = str;
            return this;
        }

        public b c(String str) {
            this.d = str;
            return this;
        }

        public b d(String str) {
            this.e = str;
            return this;
        }

        public b a(String str) {
            this.b = str;
            this.f = Uri.parse(str).getHost();
            return this;
        }
    }

    public static class c {
        public final Object a = this;
        public int b;
        public int c;
        public final int d;
        public final double e;

        public c(int i2, int i3, double d2) {
            this.b = i2;
            this.d = i3;
            this.e = Math.max(d2, 0.0d);
        }

        public boolean a() {
            boolean z;
            synchronized (this.a) {
                z = this.c <= this.d;
            }
            return z;
        }

        public int b() {
            int i2;
            synchronized (this.a) {
                i2 = this.b;
            }
            return i2;
        }

        public boolean c() {
            synchronized (this.a) {
                this.c++;
                this.b = (int) (((double) this.b) * this.e);
            }
            LogUtil.d("WhiteScreenMonitor", "Retry, count: " + this.c + ", delay: " + this.b + ", hasAttemptRemaining: " + a());
            return a();
        }
    }

    public static class d {
        public static WhiteScreenMonitor a = new WhiteScreenMonitor();
    }

    public WhiteScreenMonitor() {
        this.b = new CopyOnWriteArrayList();
        this.d = new Handler(Looper.getMainLooper());
        this.h = new ConcurrentHashMap();
        this.f3571i = new ConcurrentHashMap();
    }

    public void b() {
        Map<String, b> map = this.f3571i;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                if (((b) next.getValue()).a && !TextUtils.isEmpty(((b) next.getValue()).d)) {
                    a((String) next.getKey());
                }
            }
        }
        Map<String, c> map2 = this.h;
        if (map2 != null) {
            this.d.removeCallbacksAndMessages(map2);
            this.h.clear();
        }
        List<a> list = this.b;
        if (list != null) {
            for (a aVar : list) {
                a(aVar.a);
            }
            this.b.clear();
        }
    }

    public static WhiteScreenMonitor a() {
        return d.a;
    }

    private void a(Context context) {
        if (!this.e) {
            File externalFilesDir = context.getExternalFilesDir("");
            this.g = DxmApplicationContextImpl.getApplicationContext(context);
            if (externalFilesDir != null) {
                this.f = externalFilesDir.getAbsolutePath();
            } else {
                this.f = context.getFilesDir().getAbsolutePath();
            }
            String whiteScreenConfig = SdkInitResponse.getInstance().getWhiteScreenConfig(context);
            if (!TextUtils.isEmpty(whiteScreenConfig)) {
                try {
                    this.a = (WhiteScreenConfig) JsonUtils.fromJson(whiteScreenConfig, WhiteScreenConfig.class);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            WhiteScreenConfig whiteScreenConfig2 = this.a;
            if (whiteScreenConfig2 == null || !whiteScreenConfig2.isValid()) {
                this.a = new WhiteScreenConfig();
            }
            WhiteScreenConfig whiteScreenConfig3 = this.a;
            if (whiteScreenConfig3.wsc_enable || whiteScreenConfig3.wsc_view_enable) {
                AnonymousClass1 r9 = new ThreadFactory() {
                    public AtomicInteger a = new AtomicInteger(1);

                    public Thread newThread(Runnable runnable) {
                        return new Thread(runnable, "WhiteScreenMoniter #" + this.a.getAndIncrement());
                    }
                };
                WhiteScreenConfig whiteScreenConfig4 = this.a;
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(whiteScreenConfig4.wsc_core_task, whiteScreenConfig4.wsc_max_task, (long) whiteScreenConfig4.wsc_alive_time, TimeUnit.SECONDS, new SynchronousQueue(), r9, new ThreadPoolExecutor.DiscardPolicy());
                this.c = threadPoolExecutor;
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                this.e = true;
                return;
            }
            this.e = true;
        }
    }

    /* access modifiers changed from: private */
    public void b(WebView webView, PageStates pageStates) {
        if (webView != null) {
            String url = webView.getUrl();
            if (!TextUtils.isEmpty(url)) {
                final long currentTimeMillis = System.currentTimeMillis();
                final String clearQuery = URLUtil.clearQuery(url);
                LogUtil.d("WhiteScreenMonitor", "START DETECT, " + pageStates + StringUtil.ARRAY_ELEMENT_SEPARATOR + clearQuery);
                try {
                    final a a2 = a(webView);
                    final Bitmap bitmap = a2.c;
                    final WebView webView2 = webView;
                    final PageStates pageStates2 = pageStates;
                    this.c.execute(new Runnable() {
                        public void run() {
                            WhiteScreenMonitor whiteScreenMonitor = WhiteScreenMonitor.this;
                            ArrayList a2 = whiteScreenMonitor.a(whiteScreenMonitor.a.wsc_area_detect, 4, 0);
                            boolean a3 = WhiteScreenMonitor.this.a(bitmap, (ArrayList<Integer>) a2);
                            String str = "" + (System.currentTimeMillis() - currentTimeMillis);
                            b bVar = new b();
                            bVar.a(clearQuery).a(a3).b(pageStates2.name()).c(WhiteScreenMonitor.this.a((ArrayList<Integer>) a2)).d(str);
                            WhiteScreenMonitor.this.f3571i.put(clearQuery, bVar);
                            if (a3) {
                                WhiteScreenMonitor.this.a(true, clearQuery, webView2, pageStates2);
                            } else {
                                WhiteScreenMonitor.this.b(clearQuery);
                            }
                            WhiteScreenMonitor.this.a(a2);
                            WhiteScreenMonitor.this.a(bitmap);
                            LogUtil.d("WhiteScreenMonitor", "WhiteScreen:" + clearQuery + " " + a3 + " " + pageStates2 + " " + WhiteScreenMonitor.this.a((ArrayList<Integer>) a2));
                            StringBuilder sb = new StringBuilder();
                            sb.append("TIME COST:");
                            sb.append(str);
                            LogUtil.d("WhiteScreenMonitor", sb.toString());
                        }
                    });
                } catch (Exception e2) {
                    LogUtil.d("WhiteScreenMonitor", e2.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        this.h.remove(str);
    }

    private Rect[] b(int i2, int i3, int i4, int i5) {
        Rect[] rectArr = new Rect[(i4 * i5)];
        float f2 = (float) (i2 / i5);
        float f3 = (float) (i3 / i4);
        for (int i6 = 0; i6 < i4; i6++) {
            for (int i7 = 0; i7 < i5; i7++) {
                float f4 = ((float) i7) * f2;
                float f5 = ((float) i6) * f3;
                rectArr[(i6 * i5) + i7] = new Rect((int) f4, (int) f5, (int) (f4 + f2), (int) (f5 + f3));
            }
        }
        return rectArr;
    }

    private boolean b(Bitmap bitmap, Rect rect, boolean z, int i2) {
        Rect[] b2 = b(rect.width(), rect.height(), 3, 3);
        Iterator<Integer> it = a(this.a.wsc_simple_count, new int[0]).iterator();
        while (it.hasNext()) {
            Rect rect2 = b2[it.next().intValue()];
            int i3 = rect2.left + rect.left;
            while (true) {
                if (i3 < rect2.right + rect.left) {
                    for (int i4 = rect2.top + rect.top; i4 < rect2.bottom + rect.top; i4++) {
                        int pixel = bitmap.getPixel(i3, i4);
                        if (z) {
                            bitmap.setPixel(i3, i4, -16711936);
                        }
                        if (i2 == 0) {
                            i2 = pixel;
                        } else if (pixel != i2) {
                            LogUtil.d("WhiteScreenMonitor", "diff(" + i3 + "," + i4 + "):" + pixel + " != " + i2);
                            return false;
                        }
                    }
                    i3++;
                }
            }
        }
        return true;
    }

    public void a(WebView webView, PageStates pageStates) {
        if (webView != null) {
            String url = webView.getUrl();
            if (!TextUtils.isEmpty(url) && !"about:blank".equals(url)) {
                LogUtil.d("WhiteScreenMonitor", "startDetectWebView, " + url + ", states: " + pageStates);
                a(webView.getContext());
                if (this.a.wsc_enable) {
                    String clearQuery = URLUtil.clearQuery(url);
                    a(pageStates, clearQuery);
                    this.d.removeCallbacksAndMessages(this.h);
                    a(false, clearQuery, webView, pageStates);
                }
            }
        }
    }

    private void a(PageStates pageStates, String str) {
        c cVar;
        if (PageStates.START == pageStates) {
            WhiteScreenConfig.Policy policy = this.a.startPolicy;
            cVar = new c(policy.initialDelayMs, policy.maxNumRetries, policy.backoffMultiplier);
        } else if (PageStates.FINISH == pageStates) {
            WhiteScreenConfig.Policy policy2 = this.a.finishPolicy;
            cVar = new c(policy2.initialDelayMs, policy2.maxNumRetries, policy2.backoffMultiplier);
        } else {
            WhiteScreenConfig.Policy policy3 = this.a.resumePolicy;
            cVar = new c(policy3.initialDelayMs, policy3.maxNumRetries, policy3.backoffMultiplier);
        }
        this.h.put(str, cVar);
    }

    /* access modifiers changed from: private */
    public void a(boolean z, String str, final WebView webView, final PageStates pageStates) {
        LogUtil.d("WhiteScreenMonitor", "queuedDetectTask, " + str + ", retrying: " + z + ", states: " + pageStates);
        c cVar = this.h.get(str);
        if (cVar != null) {
            if (!z || cVar.c()) {
                this.d.postAtTime(new Runnable() {
                    public void run() {
                        WhiteScreenMonitor.this.b(webView, pageStates);
                    }
                }, this.h, SystemClock.uptimeMillis() + ((long) cVar.b()));
                return;
            }
            a(str);
            this.h.remove(str);
        }
    }

    private void a(String str) {
        boolean z;
        b bVar = this.f3571i.get(str);
        c cVar = this.h.get(str);
        if (bVar == null || !(z = bVar.a) || cVar == null) {
            this.f3571i.remove(str);
            return;
        }
        List asList = Arrays.asList(new String[]{bVar.b, String.valueOf(z), bVar.c, bVar.d, bVar.e, bVar.f, String.valueOf(cVar.a())});
        LogUtil.d("WhiteScreenMonitor", "reportResult, " + str + ", hasAttemptRemaining: " + cVar.a());
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, asList);
        HashMap hashMap = new HashMap(asList.size());
        hashMap.put(LightAppStatEvent.PAGE_URL, bVar.b);
        hashMap.put(CustomListAdapter.VIEW_TAG, bVar.c);
        hashMap.put("area", bVar.d);
        hashMap.put("timeCost", bVar.e);
        hashMap.put("host", bVar.f);
        hashMap.put("hasAttemptRemaining", String.valueOf(cVar.a()));
        Tracker.send(LightAppStatEvent.LIGHT_APP_WHITE_SCREEN, (Map<String, String>) hashMap, this.g);
        this.f3571i.remove(str);
    }

    /* access modifiers changed from: private */
    public ArrayList<Integer> a(int i2, int... iArr) {
        if (i2 < 1 || i2 > 9) {
            i2 = 9;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i3 : iArr) {
            if (i3 < 9) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        while (arrayList.size() < i2) {
            int nextInt = new Random().nextInt(9);
            if (!arrayList.contains(Integer.valueOf(nextInt))) {
                arrayList.add(Integer.valueOf(nextInt));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public String a(ArrayList<Integer> arrayList) {
        Iterator<Integer> it = arrayList.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next();
        }
        return str;
    }

    private a a(WebView webView) {
        long currentTimeMillis = System.currentTimeMillis();
        int width = webView.getWidth();
        int height = webView.getHeight();
        a a2 = a(width, height);
        ((View) webView.getParent()).draw(new Canvas(a2.a));
        int a3 = a(width, height, 96, 96);
        a2.c = ThumbnailUtils.extractThumbnail(a2.a, width / a3, height / a3);
        LogUtil.d("WhiteScreenMonitor", "captureWebView:" + (System.currentTimeMillis() - currentTimeMillis));
        return a2;
    }

    public static int a(int i2, int i3, int i4, int i5) {
        int i6 = 1;
        if (i3 > i5 || i2 > i4) {
            int i7 = i3 / 2;
            int i8 = i2 / 2;
            while (i7 / i6 >= i5 && i8 / i6 >= i4) {
                i6 *= 2;
            }
        }
        return i6;
    }

    /* access modifiers changed from: private */
    public boolean a(Bitmap bitmap, ArrayList<Integer> arrayList) {
        LogUtil.d("WhiteScreenMonitor", "isWhiteBitmap width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight());
        if (!a(bitmap, new Rect((bitmap.getWidth() / 2) - 1, 0, (bitmap.getWidth() / 2) + 1, bitmap.getHeight()), false, 0)) {
            LogUtil.d("WhiteScreenMonitor", "Fast detect: false");
            return false;
        }
        int pixel = bitmap.getPixel(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        Rect[] b2 = b(bitmap.getWidth(), bitmap.getHeight(), 3, 3);
        boolean z = false;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 < this.a.wsc_general_detect) {
                z = a(bitmap, b2[arrayList.get(i2).intValue()], false, pixel);
            } else {
                z = b(bitmap, b2[arrayList.get(i2).intValue()], false, pixel);
            }
            LogUtil.d("WhiteScreenMonitor", "Area(" + arrayList.get(i2) + "):" + z);
            if (!z) {
                break;
            }
        }
        return z;
    }

    private boolean a(Bitmap bitmap, Rect rect, boolean z, int i2) {
        for (int i3 = rect.left; i3 < rect.right; i3++) {
            for (int i4 = rect.top; i4 < rect.bottom; i4++) {
                int pixel = bitmap.getPixel(i3, i4);
                if (z) {
                    bitmap.setPixel(i3, i4, -16711936);
                }
                if (i2 == 0) {
                    i2 = pixel;
                } else if (pixel != i2) {
                    LogUtil.d("WhiteScreenMonitor", "diff(" + i3 + "," + i4 + "):" + pixel + " != " + i2);
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    private synchronized a a(int i2, int i3) {
        if (this.b != null && this.b.size() > 0) {
            for (a next : this.b) {
                if (next.a != null && !next.a.isRecycled() && !next.b && next.a.getWidth() == i2 && next.a.getHeight() == i3) {
                    next.b = true;
                    LogUtil.d("WhiteScreenMonitor", "Bitmap Recycled");
                    return next;
                }
            }
        }
        if (this.b.size() < this.a.wsc_core_cache) {
            a aVar = new a();
            aVar.a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
            aVar.b = true;
            this.b.add(aVar);
            LogUtil.d("WhiteScreenMonitor", "Bitmap created");
            return aVar;
        }
        LogUtil.d("WhiteScreenMonitor", "Bitmap new");
        a aVar2 = new a();
        aVar2.a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
        aVar2.b = true;
        return aVar2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.a r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.List<com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor$a> r0 = r4.b     // Catch:{ all -> 0x0057 }
            if (r0 == 0) goto L_0x003d
            java.util.List<com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor$a> r0 = r4.b     // Catch:{ all -> 0x0057 }
            int r0 = r0.size()     // Catch:{ all -> 0x0057 }
            if (r0 <= 0) goto L_0x003d
            java.util.List<com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor$a> r0 = r4.b     // Catch:{ all -> 0x0057 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0057 }
        L_0x0013:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x003d
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0057 }
            com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor$a r1 = (com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.a) r1     // Catch:{ all -> 0x0057 }
            android.graphics.Bitmap r2 = r1.a     // Catch:{ all -> 0x0057 }
            android.graphics.Bitmap r3 = r5.a     // Catch:{ all -> 0x0057 }
            if (r2 != r3) goto L_0x0013
            android.graphics.Bitmap r2 = r1.a     // Catch:{ all -> 0x0057 }
            boolean r2 = r2.isRecycled()     // Catch:{ all -> 0x0057 }
            if (r2 != 0) goto L_0x0013
            boolean r2 = r1.b     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x0013
            r5 = 0
            r1.b = r5     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = "WhiteScreenMonitor"
            java.lang.String r0 = "Bitmap Released"
            com.baidu.wallet.core.utils.LogUtil.d(r5, r0)     // Catch:{ all -> 0x0057 }
            monitor-exit(r4)
            return
        L_0x003d:
            android.graphics.Bitmap r0 = r5.a     // Catch:{ all -> 0x0057 }
            if (r0 == 0) goto L_0x0055
            android.graphics.Bitmap r0 = r5.a     // Catch:{ all -> 0x0057 }
            boolean r0 = r0.isRecycled()     // Catch:{ all -> 0x0057 }
            if (r0 != 0) goto L_0x0055
            java.lang.String r0 = "WhiteScreenMonitor"
            java.lang.String r1 = "Bitmap Full Released"
            com.baidu.wallet.core.utils.LogUtil.d(r0, r1)     // Catch:{ all -> 0x0057 }
            android.graphics.Bitmap r5 = r5.a     // Catch:{ all -> 0x0057 }
            r5.recycle()     // Catch:{ all -> 0x0057 }
        L_0x0055:
            monitor-exit(r4)
            return
        L_0x0057:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor.a(com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor$a):void");
    }
}
