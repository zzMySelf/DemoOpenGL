package th.na.th.th;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import th.na.th.th.na.ma;
import th.na.th.th.th.mo;

/* compiled from: DownloadManager */
public class li implements mo.th {

    /* renamed from: th  reason: collision with root package name */
    public static li f7817th;
    public th li;
    public ExecutorService ma;
    public Handler mo = new Handler(Looper.getMainLooper());
    public Map<String, mo> na = new LinkedHashMap();

    public li() {
        th thVar = new th();
        if (thVar.na() <= thVar.th()) {
            this.li = thVar;
            this.ma = Executors.newFixedThreadPool(thVar.th());
            new ma(this.mo);
            return;
        }
        throw new IllegalArgumentException("thread num must < max thread num");
    }

    public static li th() {
        if (f7817th == null) {
            synchronized (li.class) {
                if (f7817th == null) {
                    f7817th = new li();
                }
            }
        }
        return f7817th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0039, code lost:
        r0 = r10.na.get(r11);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void th(java.lang.String r11, java.lang.String r12, java.lang.String r13, android.os.Looper r14, th.na.th.th.th.th r15) {
        /*
            r10 = this;
            if (r14 != 0) goto L_0x0006
            android.os.Looper r14 = android.os.Looper.getMainLooper()
        L_0x0006:
            java.io.File r2 = new java.io.File
            r2.<init>(r12)
            th.na.th.th.mo r12 = new th.na.th.th.mo
            r4 = 0
            r5 = 0
            r0 = r12
            r1 = r11
            r3 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            th.na.th.th.na.ma r13 = new th.na.th.th.na.ma
            android.os.Handler r0 = new android.os.Handler
            r0.<init>(r14)
            r13.<init>(r0)
            java.lang.String r14 = "RtcDownSo"
            java.lang.String r0 = "start down judge is downloading"
            android.util.Log.d(r14, r0)
            if (r11 == 0) goto L_0x008f
            int r11 = r11.hashCode()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.util.Map<java.lang.String, th.na.th.th.th.mo> r0 = r10.na
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto L_0x004d
            java.util.Map<java.lang.String, th.na.th.th.th.mo> r0 = r10.na
            java.lang.Object r0 = r0.get(r11)
            th.na.th.th.th.mo r0 = (th.na.th.th.th.mo) r0
            if (r0 == 0) goto L_0x004d
            th.na.th.th.na.re r0 = (th.na.th.th.na.re) r0
            boolean r0 = r0.th()
            if (r0 == 0) goto L_0x004d
            r0 = 1
            goto L_0x004e
        L_0x004d:
            r0 = 0
        L_0x004e:
            if (r0 != 0) goto L_0x008e
            java.lang.String r0 = "real start down ..."
            android.util.Log.d(r14, r0)
            th.na.th.th.na.na r5 = new th.na.th.th.na.na
            r5.<init>(r13, r15)
            th.na.th.th.na.re r13 = new th.na.th.th.na.re
            java.util.concurrent.ExecutorService r6 = r10.ma
            th.na.th.th.th r8 = r10.li
            r3 = r13
            r4 = r12
            r7 = r11
            r9 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9)
            java.util.Map<java.lang.String, th.na.th.th.th.mo> r12 = r10.na
            r12.put(r11, r13)
            r11 = 101(0x65, float:1.42E-43)
            r13.ked = r11
            th.na.th.th.na.na r12 = r13.na
            th.na.th.th.th.na r12 = r12.na
            r12.f7831th = r11
            th.na.th.th.th.th r11 = r12.re
            r11.th()
            th.na.th.th.na.ked r11 = new th.na.th.th.na.ked
            th.na.th.th.mo r12 = r13.f7827th
            java.lang.String r12 = r12.f7819th
            r11.<init>(r12, r13)
            r13.saw = r11
            java.util.concurrent.Executor r11 = r13.li
            th.na.th.th.th.re r12 = r13.saw
            r11.execute(r12)
        L_0x008e:
            return
        L_0x008f:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Tag can't be null!"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: th.na.th.th.li.th(java.lang.String, java.lang.String, java.lang.String, android.os.Looper, th.na.th.th.th.th):void");
    }

    public final String th(String str) {
        if (str != null) {
            return String.valueOf(str.hashCode());
        }
        throw new IllegalArgumentException("Tag can't be null!");
    }
}
