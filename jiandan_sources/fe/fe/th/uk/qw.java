package fe.fe.th.uk;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.clientupdate.IClientUpdaterCallback;
import com.baidu.clientupdate.appinfo.AppInfo;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.clientupdate.download.Download;
import fe.fe.aaa.ad;
import fe.fe.th.ad.de;
import fe.fe.th.i.uk;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;

public final class qw {

    /* renamed from: uk  reason: collision with root package name */
    public static qw f3146uk;

    /* renamed from: ad  reason: collision with root package name */
    public ClientUpdateInfo f3147ad = null;

    /* renamed from: de  reason: collision with root package name */
    public RuleInfo f3148de = null;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f3149fe = false;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f3150rg = null;

    /* renamed from: th  reason: collision with root package name */
    public fe.fe.th.th.qw f3151th;

    /* renamed from: yj  reason: collision with root package name */
    public de f3152yj;

    public qw(Context context) {
        this.qw = context;
        this.f3152yj = de.ad(context);
        this.f3151th = fe.fe.th.th.qw.qw(context);
    }

    public static synchronized qw ad(Context context) {
        qw qwVar;
        synchronized (qw.class) {
            if (f3146uk == null) {
                f3146uk = new qw(context);
            }
            qwVar = f3146uk;
        }
        return qwVar;
    }

    public final void de(AppInfo appInfo, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                    File file2 = new File(Environment.getExternalStorageDirectory(), "Download");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    str = file2.getAbsolutePath();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Download download = new Download();
        download.mFileName = appInfo.mSname;
        download.mSavedPath = str;
        download.mUrl = appInfo.mDownurl;
        download.mMimeType = "application/vnd.android.package-archive";
        download.mSourceKey = appInfo.mPackageName + "@" + appInfo.mVercode;
        uk.xxx(this.qw).d(download, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void fe(com.baidu.clientupdate.appinfo.ClientUpdateInfo r3, java.lang.String r4, boolean r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            com.baidu.clientupdate.appinfo.ClientUpdateInfo r0 = r2.f3147ad     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x000b
            r2.f3147ad = r3     // Catch:{ all -> 0x0046 }
        L_0x000b:
            r2.f3150rg = r4     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = r3.mStatus     // Catch:{ all -> 0x0046 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0044
            java.lang.String r0 = r3.mStatus     // Catch:{ all -> 0x0046 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0046 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0046 }
            r1 = 1
            if (r0 != r1) goto L_0x0044
            java.lang.String r0 = r3.mDownurl     // Catch:{ all -> 0x0046 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0044
            java.lang.String r0 = r3.mSize     // Catch:{ all -> 0x0046 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0044
            java.lang.String r0 = r3.mSize     // Catch:{ all -> 0x0046 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0046 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0046 }
            if (r0 <= 0) goto L_0x0044
            r2.de(r3, r4, r5)     // Catch:{ all -> 0x0046 }
            r3 = 0
            r2.f3149fe = r3     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r2)
            return
        L_0x0046:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.uk.qw.fe(com.baidu.clientupdate.appinfo.ClientUpdateInfo, java.lang.String, boolean):void");
    }

    public final void i() {
        try {
            File file = new File(ad.ad(this.qw).de("lcsdk_xml", "path", ""));
            if (file.exists() && file.isDirectory()) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClientUpdateInfo qw() {
        return this.f3147ad;
    }

    public synchronized void rg(JSONObject jSONObject, IClientUpdaterCallback iClientUpdaterCallback) {
        JSONObject jSONObject2 = jSONObject;
        IClientUpdaterCallback iClientUpdaterCallback2 = iClientUpdaterCallback;
        synchronized (this) {
            try {
                this.f3149fe = false;
                if (jSONObject2 == null) {
                    iClientUpdaterCallback2.fe((ClientUpdateInfo) null, (RuleInfo) null);
                    de deVar = this.f3152yj;
                    String i2 = this.f3151th.i();
                    String rg2 = this.f3151th.rg();
                    deVar.th(i2, "0", rg2, "a5", "0", (System.currentTimeMillis() / 1000) + "", "", "parseResult", "");
                    return;
                }
                String optString = jSONObject2.optString("status");
                if (TextUtils.isEmpty(optString)) {
                    iClientUpdaterCallback2.fe((ClientUpdateInfo) null, (RuleInfo) null);
                } else if (Integer.valueOf(optString).intValue() == 1) {
                    this.f3147ad = (ClientUpdateInfo) uk.qw(jSONObject2.optJSONObject("clientupdate"), 0);
                    if (!new URI(this.f3147ad.mDownurl).getHost().endsWith("baidu.com")) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("msgId", "3");
                        jSONObject3.put("messageDetail", "下载地址有问题");
                        if (iClientUpdaterCallback2 != null) {
                            iClientUpdaterCallback2.de(jSONObject3);
                        }
                    }
                    this.f3148de = (RuleInfo) uk.qw(jSONObject2.optJSONObject("rule"), 3);
                    if (this.f3147ad != null) {
                        this.f3147ad.mStatus = jSONObject2.optString("status");
                        this.f3147ad.mReverson = jSONObject2.optString("re_version");
                    }
                    if (this.f3147ad != null) {
                        fe.fe.aaa.qw.qw("ClientUpdateUtility", "mClientUpdateInfo: " + this.f3147ad.toString());
                    }
                    iClientUpdaterCallback2.fe(this.f3147ad, this.f3148de);
                } else if (Integer.valueOf(optString).intValue() == 0) {
                    i();
                    ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
                    this.f3147ad = clientUpdateInfo;
                    clientUpdateInfo.mStatus = optString;
                    iClientUpdaterCallback2.fe(clientUpdateInfo, (RuleInfo) null);
                }
                de deVar2 = this.f3152yj;
                String i3 = this.f3151th.i();
                String rg3 = this.f3151th.rg();
                deVar2.th(i3, "0", rg3, "a5", "0", (System.currentTimeMillis() / 1000) + "", "", "parseResult", "");
                fe.fe.aaa.qw.ad("ClientUpdateUtility", "加入统计耗时：" + (System.currentTimeMillis() - fe.fe.th.qw.f97switch));
            } catch (Exception e) {
                e.printStackTrace();
                de deVar3 = this.f3152yj;
                String i4 = this.f3151th.i();
                String rg4 = this.f3151th.rg();
                deVar3.th(i4, "0", rg4, "a5", "1", (System.currentTimeMillis() / 1000) + "", "", "parseResult", e.toString());
            }
        }
    }

    public RuleInfo th() {
        return this.f3148de;
    }

    public boolean uk() {
        return this.f3149fe;
    }

    public synchronized void yj() {
        if (this.f3147ad != null) {
            this.f3147ad = null;
        }
        if (this.f3150rg != null) {
            this.f3150rg = null;
        }
        this.f3149fe = false;
    }
}
