package fe.fe.ddd.ddd.th;

import android.text.TextUtils;
import androidx.multidex.MultiDexExtractor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.upload.IBOSUploadListener;
import com.baidu.searchbox.retrieve.upload.IUploadListener;
import fe.fe.qqq.fe;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class pf {

    /* renamed from: ad  reason: collision with root package name */
    public static ExecutorService f1347ad;

    /* renamed from: de  reason: collision with root package name */
    public static volatile pf f1348de;
    public static final boolean qw = AppConfig.rg();

    public class ad implements IBOSUploadListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f1349ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ String f1350de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ String f1351fe;
        public final /* synthetic */ File qw;

        /* renamed from: rg  reason: collision with root package name */
        public final /* synthetic */ String f1352rg;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1353th;

        public ad(File file, String str, String str2, String str3, String str4, JSONObject jSONObject) {
            this.qw = file;
            this.f1349ad = str;
            this.f1350de = str2;
            this.f1351fe = str3;
            this.f1352rg = str4;
            this.f1353th = jSONObject;
        }

        public void qw(o oVar) {
            if (oVar != null && oVar.ad()) {
                this.qw.delete();
                boolean qw2 = pf.qw;
                pf.this.o(this.f1349ad, this.f1350de, this.f1351fe, this.f1352rg, "0", this.f1353th);
            } else if (oVar != null) {
                if (pf.qw) {
                    "message is: " + oVar.qw();
                }
                pf pfVar = pf.this;
                String str = this.f1349ad;
                String str2 = this.f1350de;
                String str3 = this.f1351fe;
                String str4 = this.f1352rg;
                JSONObject jSONObject = this.f1353th;
                fe.fe.ddd.ddd.de.de.qw.qw(jSONObject, oVar.qw());
                pfVar.o(str, str2, str3, str4, "1", jSONObject);
            }
        }
    }

    public class de implements Runnable {
        public de(pf pfVar) {
        }

        public void run() {
            File file = new File("/.fetch_zip");
            if (file.exists()) {
                fe.fe.ddd.ddd.de.de.ad.ad(file);
            }
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f1355ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f1356i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ List f1357o;

        /* renamed from: pf  reason: collision with root package name */
        public final /* synthetic */ long f1358pf;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f1359th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ long f1360uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ String f1361yj;

        /* renamed from: fe.fe.ddd.ddd.th.pf$qw$qw  reason: collision with other inner class name */
        public class C0072qw implements IUploadListener {
            public C0072qw() {
            }

            public void onFailure() {
            }

            public void qw(yj yjVar) {
                if (yjVar != null && TextUtils.equals("1", yjVar.qw())) {
                    boolean qw2 = pf.qw;
                    qw qwVar = qw.this;
                    HashSet ad2 = pf.this.uk(qwVar.f1360uk, qwVar.f1356i, qwVar.f1357o);
                    if (ad2 == null || ad2.size() <= 0) {
                        qw qwVar2 = qw.this;
                        pf.this.o(qwVar2.f1355ad, qwVar2.f1359th, qwVar2.f1361yj, "", "1", fe.fe.ddd.ddd.de.de.qw.de(qwVar2.f1357o));
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    String qw3 = fe.qw();
                    qw qwVar3 = qw.this;
                    File de2 = pf.this.m59if(ad2, qw3, qwVar3.f1355ad, qwVar3.f1359th, qwVar3.f1361yj, qwVar3.f1358pf, qwVar3.f1360uk, qwVar3.f1356i, jSONObject);
                    if (de2 == null || de2.length() <= 0) {
                        boolean qw4 = pf.qw;
                        qw qwVar4 = qw.this;
                        pf.this.o(qwVar4.f1355ad, qwVar4.f1359th, qwVar4.f1361yj, "", "1", jSONObject);
                        return;
                    }
                    qw qwVar5 = qw.this;
                    pf.this.pf(qwVar5.f1355ad, qwVar5.f1359th, qwVar5.f1361yj, de2, jSONObject);
                }
            }
        }

        public qw(String str, String str2, String str3, long j, long j2, List list, long j3) {
            this.f1355ad = str;
            this.f1359th = str2;
            this.f1361yj = str3;
            this.f1360uk = j;
            this.f1356i = j2;
            this.f1357o = list;
            this.f1358pf = j3;
        }

        public void run() {
            if (TextUtils.isEmpty(this.f1355ad) || TextUtils.isEmpty(this.f1359th) || TextUtils.isEmpty(this.f1361yj)) {
                boolean qw = pf.qw;
                return;
            }
            i.qw().de(new uk(this.f1355ad, "3", this.f1359th, this.f1361yj, "", "", ""), new C0072qw());
        }
    }

    public pf() {
        f1347ad = Executors.newSingleThreadExecutor();
        rg();
    }

    public static pf i() {
        if (f1348de == null) {
            synchronized (pf.class) {
                if (f1348de == null) {
                    f1348de = new pf();
                }
            }
        }
        return f1348de;
    }

    public final boolean fe(String str, long j, long j2) {
        if (TextUtils.isEmpty(str) || !str.endsWith(".log") || j >= j2 || j > System.currentTimeMillis()) {
            return false;
        }
        String[] split = str.split("-");
        if (split.length > 0) {
            String str2 = split[0];
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                if (str2.length() == 8) {
                    simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                } else if (str2.length() == 10) {
                    simpleDateFormat = new SimpleDateFormat("yyyyMMddHH");
                } else if (str2.length() == 12) {
                    simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
                } else if (str2.length() == 14) {
                    simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                }
                long time = simpleDateFormat.parse(str2).getTime();
                if (time < j || time > j2) {
                    return false;
                }
                return true;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: if  reason: not valid java name */
    public final File m59if(HashSet<String> hashSet, String str, String str2, String str3, String str4, long j, long j2, long j3, JSONObject jSONObject) {
        if (hashSet == null || hashSet.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        long j4 = 1000 * j;
        if (hashSet.size() > 0) {
            String str5 = fe.fe.ddd.i.qw.qw.qw().getApplicationInfo().dataDir + "/.yalog_fetch" + File.separator;
            File file = new File(str5);
            if (file.exists()) {
                file.delete();
            }
            String replace = UUID.randomUUID().toString().replace("-", "");
            File file2 = new File(str5, replace + File.separator);
            file2.mkdirs();
            Iterator<String> it = hashSet.iterator();
            long j5 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                File file3 = new File(next);
                if (file3.exists()) {
                    int lastIndexOf = next.lastIndexOf("/");
                    if (lastIndexOf > -1) {
                        next = next.substring(lastIndexOf + 1);
                    }
                    if (fe(next, j2, j3)) {
                        j5 += file3.length();
                        if (j5 > j4) {
                            yj(file3.getAbsolutePath(), "3", file3.getAbsolutePath() + "size exceed maxFileSize ", (File) null, (String) null, true, jSONObject);
                            break;
                        }
                        String str6 = file2.getAbsolutePath() + file3.getAbsolutePath().substring(str.length());
                        File file4 = new File(str6);
                        if (qw) {
                            "newPath: " + file4.getAbsolutePath();
                        }
                        if (fe.fe.ddd.ddd.de.de.ad.qw(file3, file4)) {
                            yj(file3.getAbsolutePath(), "0", " success", file3, str6, true, jSONObject);
                        } else {
                            File file5 = file3;
                            yj(file5.getAbsolutePath(), "2", " copy failure", file5, str6, true, jSONObject);
                        }
                    } else {
                        continue;
                    }
                }
            }
            String str7 = fe.fe.ddd.i.qw.qw.qw().getApplicationInfo().dataDir + "/.fetch_zip" + File.separator;
            String str8 = replace + MultiDexExtractor.EXTRACTED_SUFFIX;
            File file6 = new File(str7);
            if (!file6.exists()) {
                file6.mkdirs();
            }
            String str9 = str7 + str8;
            if (qw) {
                "zipPath: " + str9;
            }
            File file7 = new File(str9);
            if (fe.fe.ddd.ddd.de.de.ad.fe(file2, str9)) {
                fe.fe.ddd.ddd.de.de.ad.ad(file);
                if (file7.length() > 0) {
                    if (qw) {
                        "zip directory is succeed, zip length is: " + file7.length();
                    }
                    return file7;
                }
                o(str2, str3, str4, "", "1", jSONObject);
            } else {
                o(str2, str3, str4, "", "1", jSONObject);
            }
        }
        return null;
    }

    public void o(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
        String str6;
        String str7 = "";
        if (qw) {
            StringBuilder sb = new StringBuilder();
            sb.append("report task done: type: ");
            sb.append(str);
            sb.append(", jobId: ");
            sb.append(str2);
            sb.append(", version: ");
            sb.append(str3);
            sb.append(", fileID: ");
            sb.append(str4);
            sb.append(", status: ");
            sb.append(str5);
            sb.append(", fileMeta: ");
            if (jSONObject == null) {
                str6 = str7;
            } else {
                str6 = jSONObject.toString();
            }
            sb.append(str6);
            sb.toString();
        }
        if (!"2".equals(str5)) {
            fe.fe.ddd.ddd.de.de.fe.qw.ad().qw();
            fe.fe.ddd.ddd.de.de.fe.qw.ad().yj(0);
        }
        IFetchTask iFetchTask = (IFetchTask) fe.fe.vvv.ad.ad.ad.qw(IFetchTask.qw);
        if (jSONObject != null) {
            str7 = jSONObject.toString();
        }
        iFetchTask.de(str, str2, str3, str5, str4, str7);
    }

    public void pf(String str, String str2, String str3, File file, JSONObject jSONObject) {
        File file2 = file;
        if (file2 != null && file.length() != 0) {
            String replace = UUID.randomUUID().toString().replace("-", "");
            String ad2 = fe.fe.ddd.fe.qw.de.de().ad("fetchlog", replace);
            if (!TextUtils.isEmpty(replace)) {
                qw.qw().ad(replace, file2, new ad(file, str, str2, str3, ad2, jSONObject));
            }
        }
    }

    public final void rg() {
        f1347ad.execute(new de(this));
    }

    public void th(String str, String str2, String str3, long j, long j2, long j3, List<String> list) {
        f1347ad.execute(new qw(str, str2, str3, j2, j3, list, j));
    }

    public final HashSet<String> uk(long j, long j2, List<String> list) {
        File[] listFiles;
        String str;
        String str2;
        String qw2 = fe.qw();
        HashSet<String> hashSet = new HashSet<>();
        if (list == null || list.size() <= 0) {
            File file = new File(qw2);
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.isDirectory()) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(qw2);
                        stringBuffer.append(File.separatorChar);
                        stringBuffer.append(file2.getName());
                        hashSet.add(stringBuffer.toString());
                    }
                }
            }
        } else {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    int indexOf = next.indexOf("/");
                    if (indexOf == -1) {
                        str = "";
                    } else {
                        String substring = next.substring(0, indexOf);
                        str = next.substring(indexOf + 1);
                        next = substring;
                    }
                    String str3 = TextUtils.isEmpty(next) ? "*" : next;
                    if (TextUtils.isEmpty(str)) {
                        str2 = "*";
                    } else {
                        str2 = str;
                    }
                    List<String> ad2 = fe.ad(j / 1000, j2 / 1000, str3, str2);
                    if (!(ad2 == null || ad2.size() == 0)) {
                        for (String append : ad2) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(qw2);
                            stringBuffer2.append(File.separator);
                            stringBuffer2.append(append);
                            hashSet.add(stringBuffer2.toString());
                        }
                    }
                }
            }
        }
        if (qw) {
            "fetchDirList size is: " + hashSet.size();
            "fetchDirList: " + Arrays.asList(new HashSet[]{hashSet});
        }
        return hashSet;
    }

    public final void yj(String str, String str2, String str3, File file, String str4, boolean z, JSONObject jSONObject) {
        try {
            JSONObject ad2 = fe.fe.ddd.ddd.de.de.qw.ad(file, str4, str2, str3, z);
            jSONObject.put(str, ad2);
            if (qw) {
                "generateMetaInfo path " + str + " fileMeta ：" + ad2;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
