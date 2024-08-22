package com.baidu.searchbox.logsystem.basic.upload;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.wallet.paysdk.datamodel.Bank;
import fe.fe.ddd.when.fe.qw;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LogSystemUploaderStrategy extends BaseUploaderStrategy {

    /* renamed from: yj  reason: collision with root package name */
    public static final boolean f1057yj = fe.fe.ddd.when.yj.ad.qw;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f1058fe;

    /* renamed from: rg  reason: collision with root package name */
    public ThreadPoolExecutor f1059rg;

    /* renamed from: th  reason: collision with root package name */
    public ThreadPoolExecutor f1060th;

    public enum Type {
        CONTENT,
        ATTACHMENT
    }

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1061ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ File f1062th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ String f1064yj;

        public ad(Context context, File file, String str) {
            this.f1061ad = context;
            this.f1062th = file;
            this.f1064yj = str;
        }

        public void run() {
            if (!fe.fe.ddd.when.yj.de.th(this.f1061ad)) {
                LogSystemUploaderStrategy.this.pf(Type.ATTACHMENT);
                return;
            }
            LogSystemUploaderStrategy.this.vvv(Type.ATTACHMENT);
            if (fe.fe.ddd.when.yj.ad.qw) {
                "new attachement file = " + this.f1062th.getAbsolutePath();
            }
            fe.fe.ddd.when.qw.yj.yj yj2 = LogSystemUploaderStrategy.this.ddd(this.f1064yj, this.f1062th);
            if (yj2.ad()) {
                this.f1062th.delete();
            }
            if (LogSystemUploaderStrategy.this.f1060th.getQueue().size() != 0) {
                return;
            }
            if (yj2.ad()) {
                LogSystemUploaderStrategy.this.ggg(Type.ATTACHMENT, 5);
            } else {
                LogSystemUploaderStrategy.this.pf(Type.ATTACHMENT);
            }
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Type f1065ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f1066th;

        public de(Type type, int i2) {
            this.f1065ad = type;
            this.f1066th = i2;
        }

        public void run() {
            if (LogSystemUploaderStrategy.this.when(this.f1065ad, this.f1066th)) {
                LogSystemUploaderStrategy.this.ggg(this.f1065ad, this.f1066th);
            } else {
                LogSystemUploaderStrategy.this.vvv(this.f1065ad);
            }
        }
    }

    public static /* synthetic */ class fe {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy$Type[] r0 = com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy$Type r1 = com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.Type.CONTENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy$Type r1 = com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.Type.ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.fe.<clinit>():void");
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1068ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ File f1069th;

        public qw(Context context, File file) {
            this.f1068ad = context;
            this.f1069th = file;
        }

        public void run() {
            if (!fe.fe.ddd.when.yj.de.th(this.f1068ad)) {
                LogSystemUploaderStrategy.this.pf(Type.CONTENT);
                return;
            }
            LogSystemUploaderStrategy.this.vvv(Type.CONTENT);
            if (fe.fe.ddd.when.yj.ad.qw) {
                "new content file = " + this.f1069th.getAbsolutePath();
            }
            fe.fe.ddd.when.qw.yj.yj nn = LogSystemUploaderStrategy.this.nn(this.f1069th);
            if (nn.ad()) {
                this.f1069th.delete();
            }
            if (LogSystemUploaderStrategy.this.f1059rg.getQueue().size() != 0) {
                return;
            }
            if (nn.ad()) {
                LogSystemUploaderStrategy.this.ggg(Type.CONTENT, 5);
            } else {
                LogSystemUploaderStrategy.this.pf(Type.CONTENT);
            }
        }
    }

    public static final class rg implements Comparable<rg> {
        @NonNull

        /* renamed from: ad  reason: collision with root package name */
        public File f1071ad;
        @NonNull

        /* renamed from: th  reason: collision with root package name */
        public th f1072th;

        public rg(@NonNull File file, @NonNull th thVar) {
            this.f1071ad = file;
            this.f1072th = thVar;
        }

        public static rg rg(@NonNull File file) {
            th rg2;
            if (file == null || !file.exists() || (rg2 = th.uk(file.getName())) == null) {
                return null;
            }
            return new rg(file, rg2);
        }

        /* renamed from: fe */
        public int compareTo(@NonNull rg rgVar) {
            int i2 = ((this.f1072th.f1075fe.longValue() - rgVar.f1072th.f1075fe.longValue()) > 0 ? 1 : ((this.f1072th.f1075fe.longValue() - rgVar.f1072th.f1075fe.longValue()) == 0 ? 0 : -1));
            if (i2 > 0) {
                return -1;
            }
            return i2 < 0 ? 1 : 0;
        }
    }

    public static final class th {

        /* renamed from: ad  reason: collision with root package name */
        public String f1073ad;

        /* renamed from: de  reason: collision with root package name */
        public LogType f1074de;

        /* renamed from: fe  reason: collision with root package name */
        public Long f1075fe;
        public String qw;

        public th(@NonNull String str, long j, @NonNull String str2, @NonNull LogType logType) {
            this.qw = str;
            this.f1075fe = Long.valueOf(j);
            this.f1073ad = str2;
            this.f1074de = logType;
        }

        public static th i(String str, String str2, LogType logType) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && logType != null) {
                long j = -1;
                String[] split = str.split("_");
                if (split != null && split.length == 2) {
                    try {
                        j = Long.valueOf(split[1]).longValue();
                    } catch (NumberFormatException unused) {
                        return null;
                    }
                }
                long j2 = j;
                if (j2 > 0) {
                    return new th(str, j2, str2, logType);
                }
            }
            return null;
        }

        @NonNull
        public static String o(@NonNull th thVar) {
            return thVar.qw + Bank.HOT_BANK_LETTER + thVar.f1073ad + Bank.HOT_BANK_LETTER + thVar.f1074de.getTypeName();
        }

        public static th uk(@NonNull String str) {
            String[] split;
            String[] split2;
            if (!TextUtils.isEmpty(str) && (split = str.split(Bank.HOT_BANK_LETTER)) != null && split.length == 3) {
                long j = -1;
                String str2 = split[0];
                if (!TextUtils.isEmpty(str2) && (split2 = str2.split("_")) != null && split2.length == 2) {
                    String str3 = split2[1];
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            j = Long.valueOf(str3).longValue();
                        } catch (NumberFormatException unused) {
                            return null;
                        }
                    }
                }
                String str4 = split[1];
                LogType logType = LogType.getLogType(split[2]);
                if (!TextUtils.isEmpty(str2) && j > 0 && !TextUtils.isEmpty(str4) && logType != null) {
                    return new th(str2, j, str4, logType);
                }
            }
            return null;
        }

        public static String yj(@NonNull String str, long j) {
            return str.replace("_", "").replace(Bank.HOT_BANK_LETTER, "") + "_" + j;
        }

        @NonNull
        public String toString() {
            return this.qw + Bank.HOT_BANK_LETTER + this.f1075fe + Bank.HOT_BANK_LETTER + this.f1073ad + Bank.HOT_BANK_LETTER + this.f1074de.getTypeName();
        }
    }

    public static final class uk {

        /* renamed from: ad  reason: collision with root package name */
        public long f1076ad;
        public int qw;

        public /* synthetic */ uk(int i2, long j, qw qwVar) {
            this(i2, j);
        }

        public uk(int i2, long j) {
            this.qw = i2;
            this.f1076ad = j;
        }
    }

    public static final class yj {
        public static File i() {
            return new File(fe.fe.ddd.when.fe.th.ad().de().get(), "content");
        }

        /* renamed from: if  reason: not valid java name */
        public static File m47if() {
            return fe.fe.ddd.when.fe.th.ad().de().get();
        }

        public static final File o() {
            return new File(m47if(), "content.flag");
        }

        public static File pf() {
            return new File(fe.fe.ddd.when.fe.th.ad().de().get(), "zip_supply");
        }

        @NonNull
        /* renamed from: switch  reason: not valid java name */
        public static File m48switch(@NonNull File file, @NonNull th thVar) {
            return new File(file, th.o(thVar));
        }

        public static final File uk() {
            return new File(m47if(), "attachment.flag");
        }

        public static File yj() {
            return new File(fe.fe.ddd.when.fe.th.ad().de().get(), "attachment");
        }
    }

    public LogSystemUploaderStrategy() {
        this(true, true, (BaseUploaderStrategy.UploadListener) null);
    }

    public static boolean o() {
        return yj.o().exists() || yj.uk().exists();
    }

    public void ad(Context context) {
        ggg(Type.CONTENT, 5);
        ggg(Type.ATTACHMENT, 5);
        if (!this.f1058fe) {
            this.f1058fe = true;
            File th2 = yj.pf();
            if (th2.exists()) {
                th2.delete();
            }
        }
    }

    @NonNull
    public final fe.fe.ddd.when.qw.yj.yj ddd(@NonNull String str, @NonNull File file) {
        if (TextUtils.isEmpty(str) || file == null) {
            return new fe.fe.ddd.when.qw.yj.yj(false);
        }
        fe.fe.ddd.when.qw.yj.yj qw2 = fe.fe.ddd.when.qw.yj.uk.qw().qw(str, file);
        if (qw2 == null) {
            qw2 = new fe.fe.ddd.when.qw.yj.yj(false);
        }
        if (f1057yj && qw2 != null) {
            "attachment upload success = " + qw2.ad() + "," + file.getAbsolutePath();
            String qw3 = qw2.qw();
            if (!TextUtils.isEmpty(qw3)) {
                "attachment upload message = " + qw3;
            }
        }
        return qw2;
    }

    public void de(Context context, @NonNull fe.fe.ddd.when.fe.rg rgVar, @Nullable List<fe.fe.ddd.when.fe.fe> list, @Nullable Set<fe.fe.ddd.when.fe.fe> set, @Nullable List<fe.fe.ddd.when.fe.fe> list2) {
        qw.C0090qw qw2;
        if (rgVar.qw == LogType.JAVA_CRASH && !this.qw) {
            return;
        }
        if ((rgVar.qw != LogType.NATIVE_CRASH || this.f1055ad) && (qw2 = qw.C0090qw.qw(rgVar.qw())) != null) {
            String th2 = th.yj(qw2.qw, System.currentTimeMillis());
            File file = m46switch(rgVar, list2, th2);
            File file2 = m45if(rgVar, list, set, list2, th2);
            BaseUploaderStrategy.UploadListener uploadListener = this.f1056de;
            if (uploadListener != null) {
                uploadListener.ad(rgVar);
            }
            if (file != null) {
                this.f1059rg.execute(new qw(context, file));
            }
            if (file2 != null) {
                this.f1060th.execute(new ad(context, file2, th2));
                BaseUploaderStrategy.UploadListener uploadListener2 = this.f1056de;
                if (uploadListener2 != null) {
                    uploadListener2.qw(rgVar);
                }
            }
        }
    }

    public void ggg(Type type, int i2) {
        if (i2 > 0) {
            ThreadPoolExecutor threadPoolExecutor = null;
            int i3 = fe.qw[type.ordinal()];
            if (i3 == 1) {
                threadPoolExecutor = this.f1059rg;
            } else if (i3 == 2) {
                threadPoolExecutor = this.f1060th;
            }
            if (threadPoolExecutor != null) {
                threadPoolExecutor.execute(new de(type, i2));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a4, code lost:
        if (r6 == 2) goto L_0x00a6;
     */
    @androidx.annotation.Nullable
    /* renamed from: if  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.File m45if(@androidx.annotation.NonNull fe.fe.ddd.when.fe.rg r5, @androidx.annotation.Nullable java.util.List<fe.fe.ddd.when.fe.fe> r6, @androidx.annotation.Nullable java.util.Set<fe.fe.ddd.when.fe.fe> r7, @androidx.annotation.Nullable java.util.List<fe.fe.ddd.when.fe.fe> r8, @androidx.annotation.NonNull java.lang.String r9) {
        /*
            r4 = this;
            java.io.File r0 = r5.de()
            r1 = 0
            if (r0 == 0) goto L_0x00ea
            java.io.File r0 = r5.de()
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0013
            goto L_0x00ea
        L_0x0013:
            java.lang.String r0 = r5.th()
            com.baidu.searchbox.logsystem.logsys.LogType r2 = r5.qw
            com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy$th r9 = com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.th.i(r9, r0, r2)
            if (r9 != 0) goto L_0x0020
            return r1
        L_0x0020:
            java.io.File r0 = com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.yj.yj()
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x002d
            r0.mkdirs()
        L_0x002d:
            java.io.File r9 = com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.yj.m48switch(r0, r9)
            boolean r0 = r9.exists()     // Catch:{ IOException -> 0x003e }
            if (r0 == 0) goto L_0x003a
            r9.delete()     // Catch:{ IOException -> 0x003e }
        L_0x003a:
            r9.createNewFile()     // Catch:{ IOException -> 0x003e }
            goto L_0x0046
        L_0x003e:
            r0 = move-exception
            boolean r2 = fe.fe.ddd.when.yj.ad.qw
            if (r2 == 0) goto L_0x0046
            r0.getMessage()
        L_0x0046:
            boolean r0 = r9.exists()
            if (r0 == 0) goto L_0x00ea
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            if (r7 == 0) goto L_0x005c
            int r2 = r7.size()
            if (r2 <= 0) goto L_0x005c
            r0.addAll(r7)
        L_0x005c:
            if (r6 == 0) goto L_0x0067
            int r7 = r6.size()
            if (r7 <= 0) goto L_0x0067
            r0.addAll(r6)
        L_0x0067:
            if (r8 == 0) goto L_0x00a6
            int r6 = r8.size()
            if (r6 <= 0) goto L_0x00a6
            r6 = 0
            java.util.Iterator r7 = r8.iterator()
        L_0x0074:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00a6
            java.lang.Object r8 = r7.next()
            fe.fe.ddd.when.fe.fe r8 = (fe.fe.ddd.when.fe.fe) r8
            if (r8 == 0) goto L_0x00a3
            java.io.File r2 = r8.qw
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "fullbdmp-"
            boolean r2 = r2.startsWith(r3)
            if (r2 != 0) goto L_0x009e
            java.io.File r2 = r8.qw
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "txt-json_supplement"
            boolean r2 = r2.startsWith(r3)
            if (r2 == 0) goto L_0x00a3
        L_0x009e:
            r0.add(r8)
            int r6 = r6 + 1
        L_0x00a3:
            r8 = 2
            if (r6 != r8) goto L_0x0074
        L_0x00a6:
            java.util.LinkedList r6 = new java.util.LinkedList     // Catch:{ IOException -> 0x00e2 }
            r6.<init>()     // Catch:{ IOException -> 0x00e2 }
            fe.fe.ddd.when.yj.fe$qw r7 = new fe.fe.ddd.when.yj.fe$qw     // Catch:{ IOException -> 0x00e2 }
            java.io.File r5 = r5.de()     // Catch:{ IOException -> 0x00e2 }
            java.lang.String r8 = "pre_p_log_basicdata"
            r7.<init>(r5, r8)     // Catch:{ IOException -> 0x00e2 }
            r6.add(r7)     // Catch:{ IOException -> 0x00e2 }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ IOException -> 0x00e2 }
        L_0x00bd:
            boolean r7 = r5.hasNext()     // Catch:{ IOException -> 0x00e2 }
            if (r7 == 0) goto L_0x00de
            java.lang.Object r7 = r5.next()     // Catch:{ IOException -> 0x00e2 }
            fe.fe.ddd.when.fe.fe r7 = (fe.fe.ddd.when.fe.fe) r7     // Catch:{ IOException -> 0x00e2 }
            if (r7 == 0) goto L_0x00bd
            java.io.File r8 = r7.qw     // Catch:{ IOException -> 0x00e2 }
            boolean r8 = r8.exists()     // Catch:{ IOException -> 0x00e2 }
            if (r8 == 0) goto L_0x00bd
            fe.fe.ddd.when.yj.fe$qw r8 = new fe.fe.ddd.when.yj.fe$qw     // Catch:{ IOException -> 0x00e2 }
            java.io.File r7 = r7.qw     // Catch:{ IOException -> 0x00e2 }
            r8.<init>(r7)     // Catch:{ IOException -> 0x00e2 }
            r6.add(r8)     // Catch:{ IOException -> 0x00e2 }
            goto L_0x00bd
        L_0x00de:
            fe.fe.ddd.when.yj.fe.qw(r9, r6)     // Catch:{ IOException -> 0x00e2 }
            return r9
        L_0x00e2:
            r5 = move-exception
            boolean r6 = fe.fe.ddd.when.yj.ad.qw
            if (r6 == 0) goto L_0x00ea
            r5.getMessage()
        L_0x00ea:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.m45if(fe.fe.ddd.when.fe.rg, java.util.List, java.util.Set, java.util.List, java.lang.String):java.io.File");
    }

    @NonNull
    public fe.fe.ddd.when.qw.yj.yj nn(@NonNull File file) {
        fe.fe.ddd.when.qw.yj.ad ad2;
        if (file == null) {
            return new fe.fe.ddd.when.qw.yj.yj(false);
        }
        fe.fe.ddd.when.qw.yj.ad de2 = fe.fe.ddd.when.qw.yj.uk.de();
        fe.fe.ddd.when.qw.yj.yj de3 = de2.de(file);
        if (!(de3 != null ? de3.ad() : false) && (ad2 = fe.fe.ddd.when.qw.yj.uk.ad()) != de2) {
            de3 = ad2.de(file);
        }
        if (de3 == null) {
            de3 = new fe.fe.ddd.when.qw.yj.yj(false);
        }
        if (f1057yj && de3 != null) {
            "content upload file = " + file.getAbsolutePath();
            "content upload success = " + de3.ad();
            String qw2 = de3.qw();
            if (!TextUtils.isEmpty(qw2)) {
                "content upload message = " + qw2;
            }
        }
        return de3;
    }

    public final void pf(Type type) {
        int i2;
        File[] fileArr;
        int i3 = fe.qw[type.ordinal()];
        if (i3 == 1) {
            fileArr = yj.i().listFiles();
            i2 = 500;
        } else if (i3 != 2) {
            fileArr = null;
            i2 = 0;
        } else {
            fileArr = yj.yj().listFiles();
            i2 = 100;
        }
        if (fileArr != null && fileArr.length != 0) {
            Pair<LinkedList<rg>, LinkedList<File>> ppp = ppp(fileArr, new uk(i2, 2592000000L, (qw) null));
            if (((LinkedList) ppp.second).size() > 0) {
                Iterator it = ((LinkedList) ppp.second).iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (file != null) {
                        file.delete();
                    }
                }
            }
            vvv(type);
        }
    }

    @NonNull
    public final Pair<LinkedList<rg>, LinkedList<File>> ppp(@NonNull File[] fileArr, @NonNull uk ukVar) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        for (File file : fileArr) {
            if (file != null && file.exists()) {
                rg rg2 = rg.rg(file);
                if (rg2 == null) {
                    linkedList2.add(file);
                } else if (currentTimeMillis - rg2.f1072th.f1075fe.longValue() > ukVar.f1076ad) {
                    linkedList2.add(file);
                } else {
                    linkedList.add(rg2);
                }
            }
        }
        Collections.sort(linkedList);
        if (linkedList.size() > ukVar.qw) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                i2++;
                rg rgVar = (rg) it.next();
                if (i2 > ukVar.qw) {
                    linkedList2.add(rgVar.f1071ad);
                    it.remove();
                    if (f1057yj) {
                        "fileCluster + " + Thread.currentThread().getName();
                    }
                }
            }
        }
        return new Pair<>(linkedList, linkedList2);
    }

    public boolean qw() {
        return this.f1060th.getQueue().size() == 0 && this.f1060th.getActiveCount() == 0 && this.f1059rg.getQueue().size() == 0 && this.f1059rg.getActiveCount() == 0;
    }

    /* renamed from: switch  reason: not valid java name */
    public final File m46switch(@NonNull fe.fe.ddd.when.fe.rg rgVar, @Nullable List<fe.fe.ddd.when.fe.fe> list, @NonNull String str) {
        File de2 = yj.i();
        if (!de2.exists()) {
            de2.mkdirs();
        }
        th ad2 = th.i(str, rgVar.th(), rgVar.qw);
        if (ad2 == null) {
            return null;
        }
        File rg2 = yj.m48switch(de2, ad2);
        File file = new File(rg2.getAbsolutePath() + ".tmp");
        File file2 = new File(rg2.getAbsolutePath() + ".gz.tmp");
        fe.fe.ddd.when.yj.de.qw(file);
        fe.fe.ddd.when.yj.de.qw(file2);
        if (file.exists()) {
            fe.fe.ddd.when.qw.yj.de.fe(rgVar, list, str, file);
            if (file2.exists()) {
                fe.fe.ddd.when.qw.yj.de.rg(file, file2);
            }
            file2.renameTo(rg2);
        }
        file.delete();
        file2.delete();
        if (rg2.exists()) {
            return rg2;
        }
        return null;
    }

    public final void vvv(Type type) {
        File file;
        int i2 = fe.qw[type.ordinal()];
        boolean z = true;
        File file2 = null;
        if (i2 == 1) {
            file2 = yj.o();
            file = yj.i();
        } else if (i2 != 2) {
            file = null;
        } else {
            file2 = yj.uk();
            file = yj.yj();
        }
        if (file2 != null && file != null) {
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                z = false;
            }
            boolean exists = file2.exists();
            if (z) {
                if (!exists) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (exists) {
                file2.delete();
            }
        }
    }

    public final boolean when(Type type, int i2) {
        int i3;
        File[] fileArr;
        int i4;
        int i5 = fe.qw[type.ordinal()];
        if (i5 == 1) {
            fileArr = yj.i().listFiles();
            i3 = 500;
        } else if (i5 != 2) {
            fileArr = null;
            i3 = 0;
        } else {
            fileArr = yj.yj().listFiles();
            i3 = 100;
        }
        if (fileArr == null || fileArr.length == 0) {
            return false;
        }
        Pair<LinkedList<rg>, LinkedList<File>> ppp = ppp(fileArr, new uk(i3, 2592000000L, (qw) null));
        if (((LinkedList) ppp.second).size() > 0) {
            Iterator it = ((LinkedList) ppp.second).iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (file != null) {
                    if (f1057yj) {
                        "invalid delete = " + file.getAbsolutePath();
                    }
                    file.delete();
                }
            }
        }
        if (((LinkedList) ppp.first).size() > 0) {
            Iterator it2 = ((LinkedList) ppp.first).iterator();
            i4 = 0;
            while (it2.hasNext() && i4 < i2) {
                rg rgVar = (rg) it2.next();
                if (rgVar != null) {
                    i4++;
                    fe.fe.ddd.when.qw.yj.yj xxx = xxx(type, rgVar);
                    if (xxx == null || !xxx.ad()) {
                        break;
                    }
                    rgVar.f1071ad.delete();
                }
            }
        } else {
            i4 = 0;
        }
        if (i4 == i2) {
            return true;
        }
        return false;
    }

    @NonNull
    public final fe.fe.ddd.when.qw.yj.yj xxx(@NonNull Type type, @NonNull rg rgVar) {
        if (type == null || rgVar == null) {
            return new fe.fe.ddd.when.qw.yj.yj(false);
        }
        int i2 = fe.qw[type.ordinal()];
        if (i2 == 1) {
            return nn(rgVar.f1071ad);
        }
        if (i2 != 2) {
            return new fe.fe.ddd.when.qw.yj.yj(false);
        }
        return ddd(rgVar.f1072th.qw, rgVar.f1071ad);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LogSystemUploaderStrategy(boolean z, boolean z2, @Nullable BaseUploaderStrategy.UploadListener uploadListener) {
        super(z, z2, uploadListener);
        this.f1058fe = false;
        this.f1059rg = new ThreadPoolExecutor(1, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.f1060th = new ThreadPoolExecutor(1, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }
}
