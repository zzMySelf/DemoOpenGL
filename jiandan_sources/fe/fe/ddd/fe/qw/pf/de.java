package fe.fe.ddd.fe.qw.pf;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.aperf.bosuploader.uploadstrategy.IUpload;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.wallet.paysdk.datamodel.Bank;
import fe.fe.ddd.fe.qw.o;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class de implements IUpload {

    /* renamed from: de  reason: collision with root package name */
    public static final boolean f1410de = AppConfig.rg();

    /* renamed from: ad  reason: collision with root package name */
    public ThreadPoolExecutor f1411ad = new ThreadPoolExecutor(1, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    public boolean qw = false;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f1412ad;

        public ad(int i2) {
            this.f1412ad = i2;
        }

        public void run() {
            if (de.this.pf(this.f1412ad)) {
                de.this.m66switch(this.f1412ad);
            } else {
                de.this.when();
            }
        }
    }

    /* renamed from: fe.fe.ddd.fe.qw.pf.de$de  reason: collision with other inner class name */
    public static final class C0078de implements Comparable<C0078de> {
        @NonNull

        /* renamed from: ad  reason: collision with root package name */
        public File f1414ad;
        @NonNull

        /* renamed from: th  reason: collision with root package name */
        public fe f1415th;

        public C0078de(@NonNull File file, @NonNull fe feVar) {
            this.f1414ad = file;
            this.f1415th = feVar;
        }

        public static C0078de rg(@NonNull File file) {
            fe th2;
            if (file == null || !file.exists() || (th2 = fe.uk(file.getName())) == null) {
                return null;
            }
            return new C0078de(file, th2);
        }

        /* renamed from: fe */
        public int compareTo(@NonNull C0078de deVar) {
            int i2 = ((this.f1415th.f1418fe.longValue() - deVar.f1415th.f1418fe.longValue()) > 0 ? 1 : ((this.f1415th.f1418fe.longValue() - deVar.f1415th.f1418fe.longValue()) == 0 ? 0 : -1));
            if (i2 > 0) {
                return -1;
            }
            return i2 < 0 ? 1 : 0;
        }
    }

    public static final class fe {

        /* renamed from: ad  reason: collision with root package name */
        public String f1416ad;

        /* renamed from: de  reason: collision with root package name */
        public String f1417de;

        /* renamed from: fe  reason: collision with root package name */
        public Long f1418fe;
        public String qw;

        public fe(@NonNull String str, long j, @NonNull String str2, @NonNull String str3) {
            this.qw = str;
            this.f1418fe = Long.valueOf(j);
            this.f1416ad = str2;
            this.f1417de = str3;
        }

        public static fe i(String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
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
                    return new fe(str, j2, str2, str3);
                }
            }
            return null;
        }

        @NonNull
        public static String o(@NonNull fe feVar) {
            return feVar.qw + Bank.HOT_BANK_LETTER + feVar.f1416ad + Bank.HOT_BANK_LETTER + feVar.f1417de;
        }

        public static fe uk(@NonNull String str) {
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
                String str5 = split[2];
                if (!TextUtils.isEmpty(str2) && j > 0 && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                    return new fe(str2, j, str4, str5);
                }
            }
            return null;
        }

        public static String yj(@NonNull String str, long j) {
            return str.replace("_", "").replace(Bank.HOT_BANK_LETTER, "") + "_" + j;
        }

        @NonNull
        public String toString() {
            return this.qw + Bank.HOT_BANK_LETTER + this.f1418fe + Bank.HOT_BANK_LETTER + this.f1416ad + Bank.HOT_BANK_LETTER + this.f1417de;
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ File f1419ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f1420th;

        public qw(File file, String str) {
            this.f1419ad = file;
            this.f1420th = str;
        }

        public void run() {
            if (!NetWorkUtils.isNetworkConnected()) {
                de.this.uk();
                return;
            }
            de.this.when();
            if (de.f1410de) {
                "new attachement file = " + this.f1419ad.getAbsolutePath();
            }
            fe fe2 = de.this.xxx(this.f1420th, this.f1419ad);
            if (fe2.ad()) {
                this.f1419ad.delete();
            }
            if (de.this.f1411ad.getQueue().size() != 0) {
                return;
            }
            if (fe2.ad()) {
                de.this.m66switch(5);
            } else {
                de.this.uk();
            }
        }
    }

    public static final class rg {
        @NonNull
        public static File i(@NonNull File file, @NonNull fe feVar) {
            return new File(file, fe.o(feVar));
        }

        public static File rg() {
            return new File(uk(), "attachment");
        }

        public static final File th() {
            return new File(uk(), "attachment.flag");
        }

        public static File uk() {
            Context qw = fe.fe.ddd.i.qw.qw.qw();
            Context applicationContext = qw.getApplicationContext();
            if (applicationContext != null) {
                qw = applicationContext;
            }
            return new File(new File(qw.getFilesDir(), "attachment_upload"), fe.fe.vvv.ad.qw.qw.ad().replace(":", "_"));
        }

        public static File yj() {
            return new File(uk(), "zip_supply");
        }
    }

    public static final class th {

        /* renamed from: ad  reason: collision with root package name */
        public long f1422ad;
        public int qw;

        public /* synthetic */ th(int i2, long j, qw qwVar) {
            this(i2, j);
        }

        public th(int i2, long j) {
            this.qw = i2;
            this.f1422ad = j;
        }
    }

    public static boolean yj() {
        return rg.th().exists();
    }

    public void ggg(@NonNull List<File> list, @NonNull String str, @NonNull String str2) {
        File o2 = o(list, fe.yj(str, System.currentTimeMillis()), fe.fe.vvv.ad.qw.qw.ad(), str2);
        if (o2 != null) {
            this.f1411ad.execute(new qw(o2, str));
        }
    }

    public final Pair<LinkedList<C0078de>, LinkedList<File>> i() {
        File[] listFiles = rg.rg().listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        Pair<LinkedList<C0078de>, LinkedList<File>> pair = m65if(listFiles, new th(100, 2592000000L, (qw) null));
        if (((LinkedList) pair.second).size() > 0) {
            Iterator it = ((LinkedList) pair.second).iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (file != null) {
                    if (f1410de) {
                        "invalid delete = " + file.getAbsolutePath();
                    }
                    file.delete();
                }
            }
        }
        return pair;
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public final Pair<LinkedList<C0078de>, LinkedList<File>> m65if(@NonNull File[] fileArr, @NonNull th thVar) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        for (File file : fileArr) {
            if (file != null && file.exists()) {
                C0078de rg2 = C0078de.rg(file);
                if (rg2 == null) {
                    linkedList2.add(file);
                } else if (currentTimeMillis - rg2.f1415th.f1418fe.longValue() > thVar.f1422ad) {
                    linkedList2.add(file);
                } else {
                    linkedList.add(rg2);
                }
            }
        }
        Collections.sort(linkedList);
        if (linkedList.size() > thVar.qw) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                i2++;
                C0078de deVar = (C0078de) it.next();
                if (i2 > thVar.qw) {
                    linkedList2.add(deVar.f1414ad);
                    it.remove();
                    if (f1410de) {
                        "fileCluster + " + Thread.currentThread().getName();
                    }
                }
            }
        }
        return new Pair<>(linkedList, linkedList2);
    }

    @Nullable
    public final File o(@Nullable List<File> list, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        fe ad2 = fe.i(str, str2, str3);
        if (ad2 == null) {
            return null;
        }
        File de2 = rg.rg();
        if (!de2.exists()) {
            de2.mkdirs();
        }
        File fe2 = rg.i(de2, ad2);
        try {
            if (fe2.exists()) {
                fe2.delete();
            }
            fe2.createNewFile();
        } catch (IOException e) {
            if (f1410de) {
                e.getMessage();
            }
        }
        if (fe2.exists()) {
            LinkedList linkedList = new LinkedList();
            if (list != null && list.size() > 0) {
                linkedList.addAll(list);
            }
            try {
                LinkedList linkedList2 = new LinkedList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (file != null) {
                        linkedList2.add(new o.qw(file));
                    }
                }
                o.qw(fe2, linkedList2);
                return fe2;
            } catch (IOException e2) {
                if (f1410de) {
                    e2.getMessage();
                }
            }
        }
        return null;
    }

    public final boolean pf(int i2) {
        int i3;
        Pair<LinkedList<C0078de>, LinkedList<File>> i4 = i();
        if (i4 == null) {
            return false;
        }
        if (((LinkedList) i4.first).size() > 0) {
            Iterator it = ((LinkedList) i4.first).iterator();
            i3 = 0;
            while (it.hasNext() && i3 < i2) {
                C0078de deVar = (C0078de) it.next();
                if (deVar != null) {
                    i3++;
                    fe vvv = vvv(deVar);
                    if (vvv == null || !vvv.ad()) {
                        break;
                    }
                    deVar.f1414ad.delete();
                }
            }
        } else {
            i3 = 0;
        }
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    public void ppp() {
        m66switch(5);
        if (!this.qw) {
            this.qw = true;
            File ad2 = rg.yj();
            if (ad2.exists()) {
                ad2.delete();
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m66switch(int i2) {
        ThreadPoolExecutor threadPoolExecutor;
        if (i2 > 0 && (threadPoolExecutor = this.f1411ad) != null) {
            threadPoolExecutor.execute(new ad(i2));
        }
    }

    public final void uk() {
        i();
        when();
    }

    @NonNull
    public final fe vvv(@NonNull C0078de deVar) {
        if (deVar == null) {
            return new fe(false);
        }
        String qw2 = deVar.f1415th.qw;
        return xxx(qw2.substring(0, qw2.indexOf("_")), deVar.f1414ad);
    }

    public final void when() {
        File qw2 = rg.th();
        File de2 = rg.rg();
        if (qw2 != null && de2 != null) {
            String[] list = de2.list();
            boolean z = false;
            if (list != null && list.length > 0) {
                z = true;
            }
            boolean exists = qw2.exists();
            if (z) {
                if (!exists) {
                    try {
                        qw2.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (exists) {
                qw2.delete();
            }
        }
    }

    @NonNull
    public final fe xxx(@NonNull String str, @NonNull File file) {
        if (TextUtils.isEmpty(str) || file == null) {
            return new fe(false);
        }
        fe qw2 = new qw().qw(str, file);
        if (qw2 == null) {
            qw2 = new fe(false);
        }
        if (f1410de && qw2 != null) {
            "attachment upload success = " + qw2.ad() + "," + file.getAbsolutePath();
            String qw3 = qw2.qw();
            if (!TextUtils.isEmpty(qw3)) {
                "attachment upload message = " + qw3;
            }
        }
        return qw2;
    }
}
