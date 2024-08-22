package com.baidu.sofire.d;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.b.c;
import com.baidu.sofire.b.j;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.d.a;
import com.baidu.sofire.l.t;
import com.baidu.sofire.mutiprocess.BinderHolder;
import com.baidu.sofire.mutiprocess.Sp;
import com.baidu.sofire.xclient.privacycontrol.PrvControlManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b {
    public static Context a;
    public static Map<Integer, a> b = new HashMap();
    public static Map<Integer, List<String>> c = new HashMap();
    public static List<String> d = new ArrayList();
    public static a e = new a();

    public static Bundle a(Bundle bundle) {
        try {
            String string = bundle.getString("bundle_key_method_name");
            String string2 = bundle.getString("bundle_key_plugin_package_name");
            if (!TextUtils.isEmpty(string2)) {
                if (!TextUtils.isEmpty(string)) {
                    j jVar = j.g;
                    if (jVar == null) {
                        return a(-102);
                    }
                    ApkInfo b2 = jVar.b(string2);
                    c cVar = c.d;
                    if (cVar == null) {
                        return a(-105);
                    }
                    Pair<Integer, Object> a2 = cVar.a(b2.key, string, (Class<?>[]) new Class[]{Bundle.class}, bundle);
                    if (((Integer) a2.first).intValue() != 0) {
                        return a(((Integer) a2.first).intValue());
                    }
                    Object obj = a2.second;
                    if (!(obj instanceof Bundle)) {
                        return a(-103);
                    }
                    Bundle bundle2 = (Bundle) obj;
                    bundle2.putInt("bundle_key_error_code", 0);
                    return bundle2;
                }
            }
            return a(-101);
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return null;
        }
    }

    public static Bundle a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return a(-301);
        }
        if (!TextUtils.isEmpty(str) && str.contains("register_sub_process")) {
            try {
                bundle.setClassLoader(b.class.getClassLoader());
                int i2 = bundle.getInt("bundle_key_pid");
                BinderHolder binderHolder = (BinderHolder) bundle.getParcelable("bundle_key_binder_holder");
                if (i2 > 0 && binderHolder != null) {
                    IBinder iBinder = binderHolder.a;
                    if (iBinder != null) {
                        b.put(Integer.valueOf(i2), a.C0051a.a(iBinder));
                        if (d.size() <= 0) {
                            return a(0);
                        }
                        c cVar = c.d;
                        j jVar = j.g;
                        if (cVar != null) {
                            if (jVar != null) {
                                for (String b2 : d) {
                                    ApkInfo b3 = jVar.b(b2);
                                    if (b3 == null) {
                                        return a(0);
                                    }
                                    int i3 = b3.key;
                                    cVar.a(i3, "notifyNewSubProcess", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i2));
                                }
                                return a(0);
                            }
                        }
                        return a(0);
                    }
                }
                return a(-101);
            } catch (Throwable unused) {
                int i4 = com.baidu.sofire.a.a.a;
                return null;
            }
        } else if (!TextUtils.isEmpty(str) && str.contains("call_main_plugin")) {
            return a(bundle);
        } else {
            if (!str.contains("call_provacy_control")) {
                return a(-300);
            }
            if (com.baidu.sofire.k.b.b()) {
                try {
                    return PrvControlManager.getInstance().handleProviderCall(bundle);
                } catch (Throwable unused2) {
                    int i5 = com.baidu.sofire.a.a.a;
                }
            }
            return a(-1);
        }
    }

    public class a extends a.C0051a {
        /* JADX WARNING: Can't wrap try/catch for region: R(2:19|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:35|36|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:51|52|58) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r9 = com.baidu.sofire.a.a.a;
            r9 = com.baidu.sofire.d.b.a(-1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            r9 = com.baidu.sofire.a.a.a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            r9 = com.baidu.sofire.a.a.a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            return null;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00b1 */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0042=Splitter:B:21:0x0042, B:14:0x0024=Splitter:B:14:0x0024, B:37:0x0078=Splitter:B:37:0x0078} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.os.Bundle a(android.os.Bundle r9) throws android.os.RemoteException {
            /*
                r8 = this;
                r0 = 0
                java.lang.String r1 = "bundle_key_ctrl_action"
                int r1 = r9.getInt(r1)     // Catch:{ all -> 0x00b4 }
                r2 = 1
                r3 = -100
                r4 = -101(0xffffffffffffff9b, float:NaN)
                r5 = -104(0xffffffffffffff98, float:NaN)
                java.lang.String r6 = "bundle_key_plugin_package_name"
                r7 = 0
                if (r1 == r2) goto L_0x0078
                r2 = 2
                if (r1 == r2) goto L_0x0042
                r2 = 3
                if (r1 == r2) goto L_0x0022
                r9 = -106(0xffffffffffffff96, float:NaN)
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r9)     // Catch:{ all -> 0x00b4 }
            L_0x001f:
                r0 = r9
                goto L_0x00b6
            L_0x0022:
                java.lang.String r1 = "bundle_key_config"
                java.lang.String r9 = r9.getString(r1)     // Catch:{ all -> 0x003a }
                boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x003a }
                if (r1 != 0) goto L_0x0035
                com.baidu.sofire.xclient.privacycontrol.PrvControlManager r1 = com.baidu.sofire.xclient.privacycontrol.PrvControlManager.getInstance()     // Catch:{ all -> 0x003a }
                r1.updateConfig(r9)     // Catch:{ all -> 0x003a }
            L_0x0035:
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r7)     // Catch:{ all -> 0x003a }
                goto L_0x001f
            L_0x003a:
                int r9 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00b4 }
                r9 = -1
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r9)     // Catch:{ all -> 0x00b4 }
                goto L_0x001f
            L_0x0042:
                android.content.Context r1 = com.baidu.sofire.d.b.a     // Catch:{ all -> 0x0075 }
                if (r1 != 0) goto L_0x004b
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r5)     // Catch:{ all -> 0x0075 }
                goto L_0x001f
            L_0x004b:
                java.lang.String r9 = r9.getString(r6)     // Catch:{ all -> 0x0075 }
                boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0075 }
                if (r1 == 0) goto L_0x005a
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r4)     // Catch:{ all -> 0x0075 }
                goto L_0x001f
            L_0x005a:
                com.baidu.sofire.b.j r1 = com.baidu.sofire.b.j.g     // Catch:{ all -> 0x0075 }
                if (r1 != 0) goto L_0x0065
                r9 = -102(0xffffffffffffff9a, float:NaN)
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r9)     // Catch:{ all -> 0x0075 }
                goto L_0x001f
            L_0x0065:
                boolean r9 = r1.e(r9)     // Catch:{ all -> 0x0075 }
                if (r9 == 0) goto L_0x0070
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r7)     // Catch:{ all -> 0x0075 }
                goto L_0x001f
            L_0x0070:
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r3)     // Catch:{ all -> 0x0075 }
                goto L_0x001f
            L_0x0075:
                int r9 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00b4 }
                goto L_0x00b6
            L_0x0078:
                android.content.Context r1 = com.baidu.sofire.d.b.a     // Catch:{ all -> 0x00b1 }
                if (r1 != 0) goto L_0x0081
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r5)     // Catch:{ all -> 0x00b1 }
                goto L_0x001f
            L_0x0081:
                java.lang.String r9 = r9.getString(r6)     // Catch:{ all -> 0x00b1 }
                boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x00b1 }
                if (r1 == 0) goto L_0x0090
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r4)     // Catch:{ all -> 0x00b1 }
                goto L_0x001f
            L_0x0090:
                android.content.Context r1 = com.baidu.sofire.d.b.a     // Catch:{ all -> 0x00b1 }
                com.baidu.sofire.b.c r1 = com.baidu.sofire.b.c.a((android.content.Context) r1)     // Catch:{ all -> 0x00b1 }
                if (r1 != 0) goto L_0x009f
                r9 = -105(0xffffffffffffff97, float:NaN)
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r9)     // Catch:{ all -> 0x00b1 }
                goto L_0x001f
            L_0x009f:
                boolean r9 = r1.a((java.lang.String) r9)     // Catch:{ all -> 0x00b1 }
                if (r9 == 0) goto L_0x00ab
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r7)     // Catch:{ all -> 0x00b1 }
                goto L_0x001f
            L_0x00ab:
                android.os.Bundle r9 = com.baidu.sofire.d.b.a((int) r3)     // Catch:{ all -> 0x00b1 }
                goto L_0x001f
            L_0x00b1:
                int r9 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00b4 }
                goto L_0x00b6
            L_0x00b4:
                int r9 = com.baidu.sofire.a.a.a
            L_0x00b6:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.d.b.a.a(android.os.Bundle):android.os.Bundle");
        }

        public Bundle b(Bundle bundle) throws RemoteException {
            return b.a(bundle);
        }

        public Bundle a(String str) throws RemoteException {
            Bundle bundle;
            try {
                if (TextUtils.isEmpty(str)) {
                    bundle = b.a(-101);
                } else {
                    j jVar = j.g;
                    if (jVar == null) {
                        bundle = b.a(-102);
                    } else {
                        Bundle bundle2 = new Bundle();
                        if (jVar.b(str) == null) {
                            bundle2.putInt("bundle_key_error_code", 0);
                            bundle2.putInt("status", -1);
                            return bundle2;
                        }
                        bundle2.putInt("bundle_key_error_code", 0);
                        bundle2.putInt("status", 1);
                        return bundle2;
                    }
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
                return null;
            }
            return bundle;
        }
    }

    public static Bundle a(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("bundle_key_error_code", i2);
        return bundle;
    }

    public static int a(int i2, String str, boolean z) {
        Map<Integer, List<String>> map;
        try {
            if (TextUtils.isEmpty(str)) {
                return -201;
            }
            Map<Integer, a> map2 = b;
            if (map2 == null) {
                return -200;
            }
            a aVar = map2.get(Integer.valueOf(i2));
            if (aVar == null) {
                return -202;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(Sp.BUNDLE_KEY_CTRL_ACTION, z ? 1 : 2);
            bundle.putString("bundle_key_plugin_package_name", str);
            int i3 = aVar.a(bundle).getInt("bundle_key_error_code", -200);
            if (i3 == 0 && (map = c) != null) {
                List list = map.get(Integer.valueOf(i2));
                if (list == null) {
                    list = new ArrayList();
                    c.put(Integer.valueOf(i2), list);
                }
                if (z && !list.contains(str)) {
                    list.add(str);
                } else if (!z && list.contains(str)) {
                    list.remove(str);
                }
            }
            return i3;
        } catch (RemoteException unused) {
            int i4 = com.baidu.sofire.a.a.a;
            return -203;
        } catch (Throwable unused2) {
            int i5 = com.baidu.sofire.a.a.a;
            return -200;
        }
    }

    public static void a(String str) {
        Set<Map.Entry<Integer, List<String>>> entrySet;
        try {
            Map<Integer, List<String>> map = c;
            if (map != null && (entrySet = map.entrySet()) != null) {
                for (Map.Entry next : entrySet) {
                    List list = (List) next.getValue();
                    if (list != null && list.contains(str)) {
                        a(((Integer) next.getKey()).intValue(), str, false);
                    }
                }
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                if (com.baidu.sofire.l.c.a(context, "ampf")) {
                    a = context.getApplicationContext();
                    Bundle bundle = new Bundle();
                    bundle.putInt("bundle_key_pid", Process.myPid());
                    bundle.putParcelable("bundle_key_binder_holder", new BinderHolder(e.asBinder()));
                    t.a(context, "sub_process_register_sub_process", bundle, "sofire");
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        }
    }
}
