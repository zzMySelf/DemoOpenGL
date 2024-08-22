package fe.ad.qw.qw.fe;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexExtractor;
import fe.ad.qw.qw.de.ad;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class qw {
    public static final String qw = (MultiDex.CODE_CACHE_NAME + File.separator + "secondary-dexes");

    /* renamed from: fe.ad.qw.qw.fe.qw$qw  reason: collision with other inner class name */
    public static class C0064qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f1199ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f1200th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f1201uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Set f1202yj;

        public C0064qw(String str, String str2, Set set, CountDownLatch countDownLatch) {
            this.f1199ad = str;
            this.f1200th = str2;
            this.f1202yj = set;
            this.f1201uk = countDownLatch;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
            if (r0 != null) goto L_0x0051;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
            if (0 == 0) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r0.close();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                r0 = 0
                java.lang.String r1 = r4.f1199ad     // Catch:{ all -> 0x004f }
                java.lang.String r2 = ".zip"
                boolean r1 = r1.endsWith(r2)     // Catch:{ all -> 0x004f }
                if (r1 == 0) goto L_0x0026
                java.lang.String r1 = r4.f1199ad     // Catch:{ all -> 0x004f }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
                r2.<init>()     // Catch:{ all -> 0x004f }
                java.lang.String r3 = r4.f1199ad     // Catch:{ all -> 0x004f }
                r2.append(r3)     // Catch:{ all -> 0x004f }
                java.lang.String r3 = ".tmp"
                r2.append(r3)     // Catch:{ all -> 0x004f }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004f }
                r3 = 0
                dalvik.system.DexFile r0 = dalvik.system.DexFile.loadDex(r1, r2, r3)     // Catch:{ all -> 0x004f }
                goto L_0x002e
            L_0x0026:
                dalvik.system.DexFile r1 = new dalvik.system.DexFile     // Catch:{ all -> 0x004f }
                java.lang.String r2 = r4.f1199ad     // Catch:{ all -> 0x004f }
                r1.<init>(r2)     // Catch:{ all -> 0x004f }
                r0 = r1
            L_0x002e:
                java.util.Enumeration r1 = r0.entries()     // Catch:{ all -> 0x004f }
            L_0x0032:
                boolean r2 = r1.hasMoreElements()     // Catch:{ all -> 0x004f }
                if (r2 == 0) goto L_0x004c
                java.lang.Object r2 = r1.nextElement()     // Catch:{ all -> 0x004f }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x004f }
                java.lang.String r3 = r4.f1200th     // Catch:{ all -> 0x004f }
                boolean r3 = r2.startsWith(r3)     // Catch:{ all -> 0x004f }
                if (r3 == 0) goto L_0x0032
                java.util.Set r3 = r4.f1202yj     // Catch:{ all -> 0x004f }
                r3.add(r2)     // Catch:{ all -> 0x004f }
                goto L_0x0032
            L_0x004c:
                if (r0 == 0) goto L_0x0054
                goto L_0x0051
            L_0x004f:
                if (r0 == 0) goto L_0x0054
            L_0x0051:
                r0.close()     // Catch:{ all -> 0x0054 }
            L_0x0054:
                java.util.concurrent.CountDownLatch r0 = r4.f1201uk
                r0.countDown()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.ad.qw.qw.fe.qw.C0064qw.run():void");
        }
    }

    public static SharedPreferences ad(Context context) {
        return context.getSharedPreferences(MultiDexExtractor.PREFS_FILE, Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    public static List<String> de(Context context) throws PackageManager.NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + MultiDexExtractor.EXTRACTED_NAME_EXT;
        if (!fe()) {
            int i2 = ad(context).getInt(MultiDexExtractor.KEY_DEX_NUMBER, 1);
            File file2 = new File(applicationInfo.dataDir, qw);
            int i3 = 2;
            while (i3 <= i2) {
                File file3 = new File(file2, str + i3 + MultiDexExtractor.EXTRACTED_SUFFIX);
                if (file3.isFile()) {
                    arrayList.add(file3.getAbsolutePath());
                    i3++;
                } else {
                    throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
                }
            }
        }
        if (fe.ad.qw.qw.ad.qw.ad()) {
            arrayList.addAll(th(applicationInfo));
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r2 < 1) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (java.lang.Integer.valueOf(java.lang.System.getProperty("ro.build.version.sdk")).intValue() >= 21) goto L_0x001d;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean fe() {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = rg()     // Catch:{  }
            r3 = 1
            if (r2 == 0) goto L_0x001f
            java.lang.String r1 = "'YunOS'"
            java.lang.String r2 = "ro.build.version.sdk"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{  }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{  }
            int r2 = r2.intValue()     // Catch:{  }
            r4 = 21
            if (r2 < r4) goto L_0x0052
        L_0x001d:
            r0 = 1
            goto L_0x0052
        L_0x001f:
            java.lang.String r1 = "'Android'"
            java.lang.String r2 = "java.vm.version"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{  }
            if (r2 == 0) goto L_0x0052
            java.lang.String r4 = "(\\d+)\\.(\\d+)(\\.\\d+)?"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch:{  }
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch:{  }
            boolean r4 = r2.matches()     // Catch:{  }
            if (r4 == 0) goto L_0x0052
            java.lang.String r4 = r2.group(r3)     // Catch:{ Exception -> 0x0051 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0051 }
            r5 = 2
            java.lang.String r2 = r2.group(r5)     // Catch:{ Exception -> 0x0051 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0051 }
            if (r4 > r5) goto L_0x001d
            if (r4 != r5) goto L_0x0052
            if (r2 < r3) goto L_0x0052
            goto L_0x001d
        L_0x0051:
        L_0x0052:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "VM with name "
            r2.append(r3)
            r2.append(r1)
            if (r0 == 0) goto L_0x0064
            java.lang.String r1 = " has multidex support"
            goto L_0x0066
        L_0x0064:
            java.lang.String r1 = " does not have multidex support"
        L_0x0066:
            r2.append(r1)
            r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.ad.qw.qw.fe.qw.fe():boolean");
    }

    public static Set<String> qw(Context context, String str) throws PackageManager.NameNotFoundException, IOException, InterruptedException {
        HashSet hashSet = new HashSet();
        List<String> de2 = de(context);
        CountDownLatch countDownLatch = new CountDownLatch(de2.size());
        for (String qwVar : de2) {
            ad.qw().execute(new C0064qw(qwVar, str, hashSet, countDownLatch));
        }
        countDownLatch.await();
        "Filter " + hashSet.size() + " classes by packageName <" + str + ">";
        return hashSet;
    }

    public static boolean rg() {
        try {
            String property = System.getProperty("ro.yunos.version");
            String property2 = System.getProperty("java.vm.name");
            if ((property2 == null || !property2.toLowerCase().contains("lemur")) && (property == null || property.trim().length() <= 0)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<String> th(ApplicationInfo applicationInfo) {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT < 21 || (strArr = applicationInfo.splitSourceDirs) == null) {
            try {
                File file = new File((String) Class.forName("com.android.tools.fd.runtime.Paths").getMethod("getDexFileDirectory", new Class[]{String.class}).invoke((Object) null, new Object[]{applicationInfo.packageName}));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists() && file2.isFile() && file2.getName().endsWith(MultiDexExtractor.DEX_SUFFIX)) {
                            arrayList.add(file2.getAbsolutePath());
                        }
                    }
                }
            } catch (Exception e) {
                "InstantRun support error, " + e.getMessage();
            }
        } else {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return arrayList;
    }
}
