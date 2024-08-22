package fe.fe.ddd.ddd.de;

import android.text.TextUtils;
import androidx.multidex.MultiDexExtractor;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.upload.IBOSUploadListener;
import com.baidu.searchbox.retrieve.upload.IUploadListener;
import fe.fe.ddd.ddd.de.ad.qw;
import fe.fe.ddd.ddd.de.de.de;
import fe.fe.ddd.ddd.de.de.fe.ad;
import fe.fe.ddd.ddd.th.i;
import fe.fe.ddd.ddd.th.o;
import fe.fe.ddd.ddd.th.uk;
import fe.fe.ddd.ddd.th.yj;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class qw extends fe.fe.ddd.ddd.fe.qw {
    public static final boolean qw = AppConfig.rg();

    public class ad implements IBOSUploadListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ qw.C0067qw f1324ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ String f1325de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1326fe;
        public final /* synthetic */ File qw;

        public ad(File file, qw.C0067qw qwVar, String str, JSONObject jSONObject) {
            this.qw = file;
            this.f1324ad = qwVar;
            this.f1325de = str;
            this.f1326fe = jSONObject;
        }

        public void qw(o oVar) {
            String str;
            if (oVar == null || !oVar.ad()) {
                qw qwVar = qw.this;
                qw.C0067qw qwVar2 = this.f1324ad;
                String str2 = this.f1325de;
                JSONObject jSONObject = this.f1326fe;
                if (oVar == null) {
                    str = "";
                } else {
                    str = oVar.qw();
                }
                fe.fe.ddd.ddd.de.de.qw.qw(jSONObject, str);
                qwVar.yj(qwVar2, str2, "2", jSONObject);
                return;
            }
            this.qw.delete();
            qw.this.yj(this.f1324ad, this.f1325de, "0", this.f1326fe);
        }
    }

    /* renamed from: fe.fe.ddd.ddd.de.qw$qw  reason: collision with other inner class name */
    public class C0068qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1328ad;

        /* renamed from: fe.fe.ddd.ddd.de.qw$qw$qw  reason: collision with other inner class name */
        public class C0069qw implements IUploadListener {
            public final /* synthetic */ qw.C0067qw qw;

            public C0069qw(qw.C0067qw qwVar) {
                this.qw = qwVar;
            }

            public void onFailure() {
            }

            public void qw(yj yjVar) {
                if (yjVar != null && TextUtils.equals("1", yjVar.qw())) {
                    qw.this.uk(this.qw);
                }
            }
        }

        public C0068qw(JSONObject jSONObject) {
            this.f1328ad = jSONObject;
        }

        public void run() {
            qw.C0067qw qw = fe.fe.ddd.ddd.de.ad.qw.qw(this.f1328ad);
            if (qw != null) {
                i.qw().de(new uk(qw.f1317ad, "3", qw.qw, qw.f1318de, "", "", ""), new C0069qw(qw));
            }
        }
    }

    public String ad() {
        return "file";
    }

    public void qw(JSONObject jSONObject) {
        Executors.newSingleThreadExecutor().execute(new C0068qw(jSONObject));
    }

    public final void rg(String str, String str2, String str3, File file, String str4, boolean z, JSONObject jSONObject) {
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

    public final File th(List<String> list, JSONObject jSONObject, qw.C0067qw qwVar) {
        Iterator<String> it;
        String str;
        File[] listFiles;
        boolean z;
        long j;
        ArrayList arrayList = new ArrayList(list.size());
        long j2 = qwVar.f1320rg * 1000;
        Iterator<String> it2 = list.iterator();
        long j3 = 0;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            String next = it2.next();
            if (!TextUtils.isEmpty(next)) {
                if (next.startsWith("external:")) {
                    str = next.replace("external:", fe.fe.ddd.i.qw.qw.qw().getExternalFilesDir((String) null).getParent() + File.separatorChar);
                } else if (next.startsWith("internal:")) {
                    str = next.replace("internal:", fe.fe.ddd.i.qw.qw.qw().getFilesDir().getParent() + File.separatorChar);
                } else {
                    it = it2;
                    rg(next, "4", next + " error", (File) null, (String) null, true, jSONObject);
                    it2 = it;
                }
                if (str.contains("../")) {
                    rg(str, "4", str + " error", (File) null, (String) null, true, jSONObject);
                } else {
                    File file = new File(str);
                    if (!file.exists()) {
                        rg(str, "1", str + " not exist", (File) null, (String) null, true, jSONObject);
                    } else {
                        if (file.isFile()) {
                            j3 += file.length();
                            if (j3 > j2) {
                                rg(str, "3", str + "size exceed maxFileSize ", (File) null, (String) null, true, jSONObject);
                                break;
                            }
                            StringBuilder sb = new StringBuilder(de.de(file.getAbsolutePath().getBytes(), true));
                            sb.append("_");
                            sb.append(file.getName());
                            arrayList.add(new ad.qw(file, sb.toString()));
                            rg(str, "0", str + " success", file, sb.toString(), true, jSONObject);
                        }
                        if (!(!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0)) {
                            ArrayList arrayList2 = new ArrayList(listFiles.length);
                            int length = listFiles.length;
                            int i2 = 0;
                            while (i2 < length) {
                                Iterator<String> it3 = it2;
                                File file2 = listFiles[i2];
                                long length2 = j3 + file2.length();
                                if (file2.exists()) {
                                    j = length2;
                                    arrayList2.add(new ad.qw(file2, file2.getName()));
                                } else {
                                    j = length2;
                                }
                                i2++;
                                it2 = it3;
                                j3 = j;
                            }
                            it = it2;
                            if (j3 > j2) {
                                rg(str, "3", file.getPath() + "size exceed maxFileSize ", (File) null, (String) null, true, jSONObject);
                                break;
                            }
                            File file3 = new File(fe.fe.ddd.i.qw.qw.qw().getFilesDir(), ".fetch_file_zip");
                            String de2 = de.de(file.getAbsolutePath().getBytes(), true);
                            File file4 = new File(file3, de2 + MultiDexExtractor.EXTRACTED_SUFFIX);
                            try {
                                if (!file3.exists()) {
                                    file3.mkdir();
                                }
                                if (file4.exists()) {
                                    file4.delete();
                                }
                                file4.createNewFile();
                                fe.fe.ddd.ddd.de.de.fe.ad.qw(file4, arrayList2);
                                z = true;
                            } catch (IOException unused) {
                                z = false;
                            }
                            if (z) {
                                arrayList.add(new ad.qw(file4, file4.getName(), true));
                                rg(str, "0", SmsLoginView.f.k, file4, file4.getPath(), false, jSONObject);
                            } else {
                                rg(str, "2", str + "copy error", (File) null, (String) null, false, jSONObject);
                            }
                            it2 = it;
                        }
                    }
                }
            }
            it = it2;
            it2 = it;
        }
        File file5 = new File(fe.fe.ddd.i.qw.qw.qw().getFilesDir(), ".fetch_file_zip");
        File file6 = new File(file5, System.nanoTime() + MultiDexExtractor.EXTRACTED_SUFFIX);
        try {
            if (!file5.exists()) {
                file5.mkdir();
            }
            if (file6.exists()) {
                file6.delete();
            }
            file6.createNewFile();
            if (arrayList.size() > 0) {
                fe.fe.ddd.ddd.de.de.fe.ad.qw(file6, arrayList);
                return new File(file6.getAbsolutePath());
            }
            String absolutePath = file6.getAbsolutePath();
            rg(absolutePath, "1", file6.getPath() + " not exist", (File) null, (String) null, true, jSONObject);
            return null;
        } catch (IOException e) {
            if (!qw) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public final void uk(qw.C0067qw qwVar) {
        List<String> list = qwVar.f1321th;
        if (list != null && list.size() != 0) {
            JSONObject jSONObject = new JSONObject();
            File th2 = th(list, jSONObject, qwVar);
            if (th2 == null || !th2.exists()) {
                yj(qwVar, "", "1", jSONObject);
                return;
            }
            String replace = UUID.randomUUID().toString().replace("-", "");
            String ad2 = fe.fe.ddd.fe.qw.de.de().ad("fetchlog", replace);
            if (!TextUtils.isEmpty(replace)) {
                fe.fe.ddd.ddd.th.qw.qw().ad(replace, th2, new ad(th2, qwVar, ad2, jSONObject));
            }
        }
    }

    public final void yj(qw.C0067qw qwVar, String str, String str2, JSONObject jSONObject) {
        String str3;
        if (qwVar != null) {
            if ("0".equals(str2)) {
                fe.fe.ddd.ddd.de.de.fe.qw.ad().qw();
                fe.fe.ddd.ddd.de.de.fe.qw.ad().yj(0);
            }
            IFetchTask iFetchTask = (IFetchTask) fe.fe.vvv.ad.ad.ad.qw(IFetchTask.qw);
            String str4 = qwVar.f1317ad;
            String str5 = qwVar.qw;
            String str6 = qwVar.f1318de;
            if (jSONObject == null) {
                str3 = "";
            } else {
                str3 = jSONObject.toString();
            }
            iFetchTask.de(str4, str5, str6, str2, str, str3);
        }
    }
}
