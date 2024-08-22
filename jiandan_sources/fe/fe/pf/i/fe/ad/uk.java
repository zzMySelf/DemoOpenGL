package fe.fe.pf.i.fe.ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.baidu.helios.ids.oid.brand.g;

public class uk {

    public class qw implements ServiceConnection {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ g.a f2760ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ Context f2761de;
        public final /* synthetic */ Class[] qw;

        public qw(Class[] clsArr, g.a aVar, Context context) {
            this.qw = clsArr;
            this.f2760ad = aVar;
            this.f2761de = context;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:5|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r6.f2761de.unbindService(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
            r6.f2760ad.qw(false, (java.lang.String) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0041, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x003a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onServiceConnected(android.content.ComponentName r7, android.os.IBinder r8) {
            /*
                r6 = this;
                r7 = 0
                r0 = 0
                java.lang.Class[] r1 = r6.qw     // Catch:{ all -> 0x003a }
                r1 = r1[r0]     // Catch:{ all -> 0x003a }
                java.lang.String r2 = "asInterface"
                r3 = 1
                java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x003a }
                java.lang.Class<android.os.IBinder> r5 = android.os.IBinder.class
                r4[r0] = r5     // Catch:{ all -> 0x003a }
                java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ all -> 0x003a }
                java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x003a }
                r2[r0] = r8     // Catch:{ all -> 0x003a }
                java.lang.Object r8 = r1.invoke(r7, r2)     // Catch:{ all -> 0x003a }
                java.lang.Class r1 = r8.getClass()     // Catch:{ all -> 0x003a }
                java.lang.String r2 = "getOAID"
                java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch:{ all -> 0x003a }
                java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ all -> 0x003a }
                java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x003a }
                java.lang.Object r8 = r1.invoke(r8, r2)     // Catch:{ all -> 0x003a }
                java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x003a }
                com.baidu.helios.ids.oid.brand.g$a r1 = r6.f2760ad     // Catch:{ all -> 0x003a }
                r1.qw(r3, r8)     // Catch:{ all -> 0x003a }
            L_0x0034:
                android.content.Context r7 = r6.f2761de     // Catch:{ all -> 0x0040 }
                r7.unbindService(r6)     // Catch:{ all -> 0x0040 }
                goto L_0x0040
            L_0x003a:
                com.baidu.helios.ids.oid.brand.g$a r8 = r6.f2760ad     // Catch:{ all -> 0x0041 }
                r8.qw(r0, r7)     // Catch:{ all -> 0x0041 }
                goto L_0x0034
            L_0x0040:
                return
            L_0x0041:
                r7 = move-exception
                android.content.Context r8 = r6.f2761de     // Catch:{ all -> 0x0047 }
                r8.unbindService(r6)     // Catch:{ all -> 0x0047 }
            L_0x0047:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.fe.pf.i.fe.ad.uk.qw.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static void qw(Context context, g.a aVar) {
        if (context == null) {
            aVar.qw(false, (String) null);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        Class[] clsArr = new Class[1];
        try {
            clsArr[0] = Class.forName("com.samsung.android.deviceidservice.IDeviceIdService$Stub");
        } catch (Throwable unused) {
        }
        if (clsArr[0] == null) {
            aVar.qw(false, (String) null);
            return;
        }
        try {
            context.bindService(intent, new qw(clsArr, aVar, context), 1);
        } catch (Throwable unused2) {
            aVar.qw(false, (String) null);
        }
    }
}
