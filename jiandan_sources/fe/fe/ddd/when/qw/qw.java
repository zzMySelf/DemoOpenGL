package fe.fe.ddd.when.qw;

import android.app.Service;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import fe.fe.ddd.when.fe.rg;
import fe.fe.ddd.when.fe.th;
import fe.fe.ddd.when.qw.fe.yj;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public List<BaseUploaderStrategy> f1690ad;
    @NonNull

    /* renamed from: de  reason: collision with root package name */
    public ThreadPoolExecutor f1691de;

    /* renamed from: fe  reason: collision with root package name */
    public Handler f1692fe;
    public fe.fe.ddd.when.fe.i.ad.de qw;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Service f1693ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f1694th;

        public ad(Service service, int i2) {
            this.f1693ad = service;
            this.f1694th = i2;
        }

        public void run() {
            for (int i2 = 0; i2 < qw.this.f1690ad.size(); i2++) {
                ((BaseUploaderStrategy) qw.this.f1690ad.get(i2)).ad(this.f1693ad.getApplicationContext());
            }
            qw.this.m89switch(this.f1693ad, this.f1694th);
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Service f1696ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f1697th;

        public de(Service service, int i2) {
            this.f1696ad = service;
            this.f1697th = i2;
        }

        public void run() {
            boolean z = true;
            for (int i2 = 0; i2 < qw.this.f1690ad.size(); i2++) {
                z = z && ((BaseUploaderStrategy) qw.this.f1690ad.get(i2)).qw();
                if (!z) {
                    break;
                }
            }
            if (z && qw.this.f1691de.getQueue().size() == 0 && qw.this.f1691de.getActiveCount() == 0) {
                this.f1696ad.stopSelf(this.f1697th);
            } else {
                qw.this.m89switch(this.f1696ad, this.f1697th);
            }
        }
    }

    public static /* synthetic */ class fe {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.baidu.searchbox.logsystem.logsys.LogType[] r0 = com.baidu.searchbox.logsystem.logsys.LogType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.baidu.searchbox.logsystem.logsys.LogType r1 = com.baidu.searchbox.logsystem.logsys.LogType.NATIVE_CRASH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.searchbox.logsystem.logsys.LogType r1 = com.baidu.searchbox.logsystem.logsys.LogType.JAVA_CRASH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.searchbox.logsystem.logsys.LogType r1 = com.baidu.searchbox.logsystem.logsys.LogType.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.when.qw.qw.fe.<clinit>():void");
        }
    }

    /* renamed from: fe.fe.ddd.when.qw.qw$qw  reason: collision with other inner class name */
    public class C0091qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ rg f1699ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Service f1700th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f1702yj;

        public C0091qw(rg rgVar, Service service, int i2) {
            this.f1699ad = rgVar;
            this.f1700th = service;
            this.f1702yj = i2;
        }

        public void run() {
            File file;
            List list;
            Object obj;
            File o2 = th.o(this.f1699ad.th());
            if (!o2.exists()) {
                o2.mkdirs();
            }
            Context applicationContext = this.f1700th.getApplicationContext();
            if (this.f1699ad.de() != null) {
                Pair<String, Boolean> ddd = fe.fe.ddd.when.yj.de.ddd(this.f1699ad.de(), 25600);
                if (ddd == null || (obj = ddd.first) == null) {
                    this.f1699ad.yj("logsystem read file error");
                    this.f1699ad.i(false);
                } else {
                    this.f1699ad.yj((String) obj);
                    this.f1699ad.i(((Boolean) ddd.second).booleanValue());
                }
            } else {
                this.f1699ad.uk(new File(o2, "pre_p_log_basicdata"));
                if (fe.fe.ddd.when.yj.de.qw(this.f1699ad.de())) {
                    FileUtils.saveToFile(this.f1699ad.ad(), this.f1699ad.de(), true);
                }
            }
            List list2 = null;
            ArrayList qw = this.f1699ad.rg() != null ? qw.this.pf(this.f1699ad.rg()) : null;
            boolean z = fe.fe.ddd.when.yj.ad.qw;
            Object obj2 = StringUtil.NULL_STRING;
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("processFiles.size = ");
                sb.append(qw != null ? Integer.valueOf(qw.size()) : obj2);
                sb.toString();
            }
            qw qwVar = qw.this;
            rg rgVar = this.f1699ad;
            Set ad2 = qwVar.i(applicationContext, new fe.fe.ddd.when.fe.i.qw(rgVar.qw, rgVar.ad()), o2);
            if (fe.fe.ddd.when.yj.ad.qw) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("devicesLogFiles.size = ");
                sb2.append(ad2 != null ? Integer.valueOf(ad2.size()) : obj2);
                sb2.toString();
            }
            if (this.f1699ad.qw == LogType.NATIVE_CRASH) {
                File th2 = th.ad().th(this.f1699ad.qw());
                if (th2 != null) {
                    list2 = qw.this.o(th2);
                }
                file = th2;
                list = list2;
            } else {
                list = null;
                file = null;
            }
            if (fe.fe.ddd.when.yj.ad.qw) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("crashFiles.size = ");
                if (list != null) {
                    obj2 = Integer.valueOf(list.size());
                }
                sb3.append(obj2);
                sb3.toString();
            }
            for (int i2 = 0; i2 < qw.this.f1690ad.size(); i2++) {
                BaseUploaderStrategy baseUploaderStrategy = (BaseUploaderStrategy) qw.this.f1690ad.get(i2);
                if (fe.fe.ddd.when.yj.ad.qw) {
                    "uploaderStrategy = " + baseUploaderStrategy.getClass().getName();
                }
                try {
                    baseUploaderStrategy.de(applicationContext, this.f1699ad, qw, ad2, list);
                } catch (Exception e) {
                    if (fe.fe.ddd.when.yj.ad.qw) {
                        e.printStackTrace();
                    }
                }
            }
            qw.this.uk(this.f1699ad, qw, ad2, file);
            qw.this.m89switch(this.f1700th, this.f1702yj);
        }
    }

    public qw() {
        this((fe.fe.ddd.when.fe.i.ad.de) null, (List<BaseUploaderStrategy>) null);
    }

    public final Set<fe.fe.ddd.when.fe.fe> i(@NonNull Context context, @NonNull fe.fe.ddd.when.fe.i.qw qwVar, @NonNull File file) {
        Set<fe.fe.ddd.when.fe.fe> de2;
        if (this.qw == null) {
            return null;
        }
        HashSet hashSet = new HashSet(5);
        Set<DeviceSnapshotType> ad2 = this.qw.ad(context, qwVar);
        if (ad2 != null && ad2.size() > 0 && (de2 = fe.fe.ddd.when.qw.uk.qw.de(context, ad2, file)) != null && de2.size() > 0) {
            hashSet.addAll(de2);
        }
        Set<fe.fe.ddd.when.fe.fe> qw2 = this.qw.qw(context, file, qwVar);
        if (qw2 != null && qw2.size() > 0) {
            hashSet.addAll(qw2);
        }
        fe.fe.ddd.when.fe.fe fe2 = fe.fe.ddd.when.qw.uk.qw.fe(context, this.qw, qwVar, file, "pre_d_fragment_data");
        if (fe2 == null || !fe2.qw.exists()) {
            return hashSet;
        }
        hashSet.add(fe2);
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: if  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m88if(@androidx.annotation.NonNull android.app.Service r3, int r4, @androidx.annotation.NonNull fe.fe.ddd.when.fe.ad r5) {
        /*
            r2 = this;
            int[] r0 = fe.fe.ddd.when.qw.qw.fe.qw
            com.baidu.searchbox.logsystem.logsys.LogType r1 = r5.qw
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x001c
            r1 = 2
            if (r0 == r1) goto L_0x001c
            r5 = 3
            if (r0 == r5) goto L_0x0015
            goto L_0x0095
        L_0x0015:
            fe.fe.ddd.when.qw.qw$ad r5 = new fe.fe.ddd.when.qw.qw$ad
            r5.<init>(r3, r4)
            goto L_0x0096
        L_0x001c:
            boolean r0 = r5 instanceof fe.fe.ddd.when.fe.rg
            if (r0 == 0) goto L_0x0095
            fe.fe.ddd.when.fe.rg r5 = (fe.fe.ddd.when.fe.rg) r5
            java.lang.String r0 = r5.ad()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "if the logType = "
            if (r0 == 0) goto L_0x005c
            java.io.File r0 = r5.de()
            if (r0 != 0) goto L_0x005c
            boolean r0 = fe.fe.ddd.when.yj.ad.qw
            if (r0 != 0) goto L_0x003c
            r2.m89switch(r3, r4)
            return
        L_0x003c:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            com.baidu.searchbox.logsystem.logsys.LogType r5 = r5.qw
            java.lang.String r5 = r5.getTypeName()
            r4.append(r5)
            java.lang.String r5 = ", mLogBasicData should not be empty and mLogBasicDataFile should not be null"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x005c:
            java.lang.String r0 = r5.th()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x008e
            boolean r0 = fe.fe.ddd.when.yj.ad.qw
            if (r0 != 0) goto L_0x006e
            r2.m89switch(r3, r4)
            return
        L_0x006e:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            com.baidu.searchbox.logsystem.logsys.LogType r5 = r5.qw
            java.lang.String r5 = r5.getTypeName()
            r4.append(r5)
            java.lang.String r5 = "mProcessName should not be null or its length = 0"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x008e:
            fe.fe.ddd.when.qw.qw$qw r0 = new fe.fe.ddd.when.qw.qw$qw
            r0.<init>(r5, r3, r4)
            r5 = r0
            goto L_0x0096
        L_0x0095:
            r5 = 0
        L_0x0096:
            if (r5 == 0) goto L_0x009d
            java.util.concurrent.ThreadPoolExecutor r3 = r2.f1691de
            r3.submit(r5)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.when.qw.qw.m88if(android.app.Service, int, fe.fe.ddd.when.fe.ad):void");
    }

    public final List<fe.fe.ddd.when.fe.fe> o(@NonNull File file) {
        File[] listFiles;
        if (file == null || !file.exists() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (File feVar : listFiles) {
            fe.fe.ddd.when.fe.fe feVar2 = new fe.fe.ddd.when.fe.fe(feVar, true, true);
            if (fe.fe.ddd.when.yj.ad.qw) {
                feVar2.qw.getAbsolutePath() + StringUtil.ARRAY_ELEMENT_SEPARATOR + feVar2.f1676ad + StringUtil.ARRAY_ELEMENT_SEPARATOR + feVar2.f1677de;
            }
            linkedList.add(feVar2);
        }
        return linkedList;
    }

    @Nullable
    public final ArrayList<fe.fe.ddd.when.fe.fe> pf(@NonNull File file) {
        BufferedReader bufferedReader = null;
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        ArrayList<fe.fe.ddd.when.fe.fe> arrayList = new ArrayList<>(5);
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!TextUtils.isEmpty(readLine)) {
                        if (fe.fe.ddd.when.yj.ad.qw) {
                            "pathNameKeep line = " + readLine;
                        }
                        String[] split = readLine.split("=");
                        if (!(split == null || split.length != 3 || split[0] == null || split[1] == null)) {
                            if (split[2] != null) {
                                File file2 = new File(split[0].trim());
                                if (file2.exists() && file2.isFile()) {
                                    fe.fe.ddd.when.fe.fe feVar = new fe.fe.ddd.when.fe.fe(file2, Boolean.valueOf(split[1].trim()).booleanValue(), Boolean.valueOf(split[2].trim()).booleanValue());
                                    arrayList.add(feVar);
                                    if (fe.fe.ddd.when.yj.ad.qw) {
                                        "LogFile = " + feVar.toString();
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    bufferedReader = bufferedReader2;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely((Closeable) bufferedReader);
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely((Closeable) bufferedReader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    Closeables.closeSafely((Closeable) bufferedReader);
                    throw th;
                }
            }
            Closeables.closeSafely((Closeable) bufferedReader2);
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            Closeables.closeSafely((Closeable) bufferedReader);
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m89switch(@NonNull Service service, int i2) {
        this.f1692fe.postDelayed(new de(service, i2), 60000);
    }

    public final void uk(@NonNull rg rgVar, @Nullable ArrayList<fe.fe.ddd.when.fe.fe> arrayList, @Nullable Set<fe.fe.ddd.when.fe.fe> set, @Nullable File file) {
        if (rgVar.de() != null) {
            rgVar.de().delete();
            if (fe.fe.ddd.when.yj.ad.qw) {
                "logBasicDataFile = " + rgVar.de();
            }
        }
        if (rgVar.rg() != null) {
            rgVar.rg().delete();
            if (fe.fe.ddd.when.yj.ad.qw) {
                "pathNameKeeper = " + rgVar.rg();
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<fe.fe.ddd.when.fe.fe> it = arrayList.iterator();
            while (it.hasNext()) {
                fe.fe.ddd.when.fe.fe next = it.next();
                if (next != null && next.f1676ad) {
                    next.qw.delete();
                    if (fe.fe.ddd.when.yj.ad.qw) {
                        "processLogFile = " + next.qw.getAbsolutePath();
                    }
                }
            }
        }
        if (set != null && set.size() > 0) {
            for (fe.fe.ddd.when.fe.fe next2 : set) {
                if (next2 != null && next2.f1676ad) {
                    next2.qw.delete();
                    if (fe.fe.ddd.when.yj.ad.qw) {
                        "deviceLogFile = " + next2.qw.getAbsolutePath();
                    }
                }
            }
        }
        if (file != null && file.exists()) {
            FileUtils.deleteFile(file);
        }
    }

    public qw(@Nullable fe.fe.ddd.when.fe.i.ad.de deVar, @Nullable List<BaseUploaderStrategy> list) {
        if (deVar == null) {
            this.qw = new fe.fe.ddd.when.fe.i.ad.de();
        } else {
            this.qw = deVar;
        }
        this.qw.fe(new fe.fe.ddd.when.qw.fe.qw());
        this.qw.fe(new fe.fe.ddd.when.qw.fe.de());
        this.qw.fe(new fe.fe.ddd.when.qw.fe.th());
        this.qw.fe(new yj());
        this.f1691de = new ThreadPoolExecutor(1, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        if (list == null) {
            list = new LinkedList<>();
            list.add(new LogSystemUploaderStrategy());
        }
        this.f1690ad = list;
        this.f1692fe = new Handler(Looper.getMainLooper());
    }
}
