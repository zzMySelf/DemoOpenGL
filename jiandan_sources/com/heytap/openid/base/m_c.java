package com.heytap.openid.base;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Keep;

@Keep
public class m_c {
    @Keep
    public volatile IInterface m_a = null;
    @Keep
    public String m_b = null;
    @Keep
    public String m_c = null;
    @Keep
    public final Object m_d = new Object();
    @Keep
    public ServiceConnection m_e = null;
    @Keep
    public Handler m_f;
    @Keep
    public HandlerThread m_g;
    @Keep
    public Context m_h;
    @Keep
    public IBinder.DeathRecipient m_i = new m_a();

    @Keep
    public class m_a implements IBinder.DeathRecipient {
        public m_a() {
        }

        @Keep
        public native void binderDied();
    }

    @Keep
    public class m_b extends Handler {
        public m_b(Looper looper) {
            super(looper);
        }

        @Keep
        public native void handleMessage(Message message);
    }

    public m_c() {
        m_b();
    }

    @Keep
    public native Intent m_a();

    @Keep
    public native void m_a(Context context, String str, String str2);

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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void m_a(android.content.Context r9, java.util.List<java.lang.String> r10, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x014b }
            r0.<init>()     // Catch:{ all -> 0x014b }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x014b }
        L_0x000a:
            boolean r1 = r10.hasNext()     // Catch:{ all -> 0x014b }
            if (r1 == 0) goto L_0x0027
            java.lang.Object r1 = r10.next()     // Catch:{ all -> 0x014b }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x014b }
            if (r11 == 0) goto L_0x001d
            boolean r2 = r8.m_b(r1)     // Catch:{ all -> 0x014b }
            goto L_0x0021
        L_0x001d:
            boolean r2 = r8.m_a(r1)     // Catch:{ all -> 0x014b }
        L_0x0021:
            if (r2 != 0) goto L_0x000a
            r0.add(r1)     // Catch:{ all -> 0x014b }
            goto L_0x000a
        L_0x0027:
            boolean r10 = r0.isEmpty()     // Catch:{ all -> 0x014b }
            if (r10 == 0) goto L_0x002f
            monitor-exit(r8)
            return
        L_0x002f:
            android.os.IInterface r10 = r8.m_a     // Catch:{ all -> 0x014b }
            r11 = 1
            if (r10 != 0) goto L_0x0083
            java.lang.String r10 = "2009"
            com.heytap.openid.sdk.m_h.m_a(r10)     // Catch:{ all -> 0x014b }
            android.content.Intent r10 = r8.m_a()     // Catch:{ Exception -> 0x0063 }
            android.content.ServiceConnection r1 = r8.m_e     // Catch:{ Exception -> 0x0063 }
            boolean r10 = r9.bindService(r10, r1, r11)     // Catch:{ Exception -> 0x0063 }
            if (r10 == 0) goto L_0x0083
            java.lang.String r10 = "2013"
            com.heytap.openid.sdk.m_h.m_a(r10)     // Catch:{ Exception -> 0x0063 }
            android.os.IInterface r10 = r8.m_a     // Catch:{ Exception -> 0x0063 }
            if (r10 != 0) goto L_0x0083
            java.lang.Object r10 = r8.m_d     // Catch:{ Exception -> 0x0063 }
            monitor-enter(r10)     // Catch:{ Exception -> 0x0063 }
            android.os.IInterface r1 = r8.m_a     // Catch:{ InterruptedException -> 0x005f }
            if (r1 != 0) goto L_0x005f
            java.lang.Object r1 = r8.m_d     // Catch:{ InterruptedException -> 0x005f }
            r2 = 10000(0x2710, double:4.9407E-320)
            r1.wait(r2)     // Catch:{ InterruptedException -> 0x005f }
            goto L_0x005f
        L_0x005d:
            r1 = move-exception
            goto L_0x0061
        L_0x005f:
            monitor-exit(r10)     // Catch:{ all -> 0x005d }
            goto L_0x0083
        L_0x0061:
            monitor-exit(r10)     // Catch:{ all -> 0x005d }
            throw r1     // Catch:{ Exception -> 0x0063 }
        L_0x0063:
            r10 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x014b }
            r1.<init>()     // Catch:{ all -> 0x014b }
            java.lang.String r2 = "1008 "
            r1.append(r2)     // Catch:{ all -> 0x014b }
            java.lang.String r2 = r10.getMessage()     // Catch:{ all -> 0x014b }
            if (r2 == 0) goto L_0x0079
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x014b }
            goto L_0x007d
        L_0x0079:
            java.lang.String r10 = r10.getLocalizedMessage()     // Catch:{ all -> 0x014b }
        L_0x007d:
            r1.append(r10)     // Catch:{ all -> 0x014b }
            r1.toString()     // Catch:{ all -> 0x014b }
        L_0x0083:
            android.os.IInterface r10 = r8.m_a     // Catch:{ all -> 0x014b }
            if (r10 != 0) goto L_0x0089
            monitor-exit(r8)
            return
        L_0x0089:
            java.lang.String r10 = "2010"
            com.heytap.openid.sdk.m_h.m_a(r10)     // Catch:{ all -> 0x014b }
            java.lang.String r10 = r8.m_b     // Catch:{ all -> 0x014b }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x014b }
            if (r10 == 0) goto L_0x009c
            java.lang.String r10 = r9.getPackageName()     // Catch:{ all -> 0x014b }
            r8.m_b = r10     // Catch:{ all -> 0x014b }
        L_0x009c:
            java.lang.String r10 = r8.m_c     // Catch:{ all -> 0x014b }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x014b }
            if (r10 == 0) goto L_0x00ae
            java.lang.String r10 = r8.m_b     // Catch:{ all -> 0x014b }
            java.lang.String r1 = "SHA1"
            java.lang.String r9 = com.heytap.openid.sdk.m_a.m_a(r9, r10, r1)     // Catch:{ all -> 0x014b }
            r8.m_c = r9     // Catch:{ all -> 0x014b }
        L_0x00ae:
            android.os.Handler r9 = r8.m_f     // Catch:{ all -> 0x014b }
            r10 = 2
            r9.removeMessages(r10)     // Catch:{ all -> 0x014b }
            java.util.Iterator r9 = r0.iterator()     // Catch:{ all -> 0x014b }
        L_0x00b8:
            boolean r0 = r9.hasNext()     // Catch:{ all -> 0x014b }
            if (r0 == 0) goto L_0x0139
            java.lang.Object r0 = r9.next()     // Catch:{ all -> 0x014b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x014b }
            java.lang.Object r1 = r8.m_d     // Catch:{ all -> 0x014b }
            monitor-enter(r1)     // Catch:{ all -> 0x014b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0136 }
            r2.<init>()     // Catch:{ all -> 0x0136 }
            r2.append(r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r3 = " 2023"
            r2.append(r3)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0136 }
            com.heytap.openid.sdk.m_h.m_a(r2)     // Catch:{ all -> 0x0136 }
            android.os.Handler r2 = r8.m_f     // Catch:{ all -> 0x0136 }
            android.os.Message r2 = r2.obtainMessage()     // Catch:{ all -> 0x0136 }
            java.lang.String r3 = "RESET_OUID"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0136 }
            if (r3 == 0) goto L_0x00ed
            r3 = 3
            r2.what = r3     // Catch:{ all -> 0x0136 }
            goto L_0x00ef
        L_0x00ed:
            r2.what = r11     // Catch:{ all -> 0x0136 }
        L_0x00ef:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0136 }
            r3.<init>()     // Catch:{ all -> 0x0136 }
            java.lang.String r4 = "IdType"
            r3.putString(r4, r0)     // Catch:{ all -> 0x0136 }
            r2.setData(r3)     // Catch:{ all -> 0x0136 }
            android.os.Handler r3 = r8.m_f     // Catch:{ all -> 0x0136 }
            r3.sendMessage(r2)     // Catch:{ all -> 0x0136 }
            long r2 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0136 }
            java.lang.String r4 = "DUID"
            boolean r4 = r0.equals(r4)     // Catch:{ all -> 0x0136 }
            if (r4 == 0) goto L_0x0110
            r4 = 5000(0x1388, float:7.006E-42)
            goto L_0x0112
        L_0x0110:
            r4 = 2000(0x7d0, float:2.803E-42)
        L_0x0112:
            java.lang.Object r5 = r8.m_d     // Catch:{ InterruptedException -> 0x0118 }
            long r6 = (long) r4     // Catch:{ InterruptedException -> 0x0118 }
            r5.wait(r6)     // Catch:{ InterruptedException -> 0x0118 }
        L_0x0118:
            long r5 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0136 }
            long r5 = r5 - r2
            long r2 = (long) r4     // Catch:{ all -> 0x0136 }
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0136 }
            r2.<init>()     // Catch:{ all -> 0x0136 }
            r2.append(r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r0 = " 2024"
            r2.append(r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0136 }
            com.heytap.openid.sdk.m_h.m_a(r0)     // Catch:{ all -> 0x0136 }
            monitor-exit(r1)     // Catch:{ all -> 0x0136 }
            goto L_0x00b8
        L_0x0136:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0136 }
            throw r9     // Catch:{ all -> 0x014b }
        L_0x0139:
            android.os.Handler r9 = r8.m_f     // Catch:{ all -> 0x014b }
            android.os.Message r9 = r9.obtainMessage()     // Catch:{ all -> 0x014b }
            r9.what = r10     // Catch:{ all -> 0x014b }
            android.os.Handler r10 = r8.m_f     // Catch:{ all -> 0x014b }
            r0 = 300000(0x493e0, double:1.482197E-318)
            r10.sendMessageDelayed(r9, r0)     // Catch:{ all -> 0x014b }
            monitor-exit(r8)
            return
        L_0x014b:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.openid.base.m_c.m_a(android.content.Context, java.util.List, boolean):void");
    }

    @Keep
    public native boolean m_a(String str);

    @Keep
    public final native void m_b();

    @Keep
    public native boolean m_b(String str);

    @Keep
    public native String m_c(String str);
}
