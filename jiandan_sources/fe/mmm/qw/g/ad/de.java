package fe.mmm.qw.g.ad;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.baidu.clientupdate.IClientUpdaterCallback;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.clientupdate.download.Download;
import com.baidu.clientupdate.download.DownloadState;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.network.NetWorkMonitor;
import com.tera.scan.upgrade.base.ILCUpdateHelper;
import com.tera.scan.upgrade.base.IUpgradeCallBack;
import com.tera.scan.upgrade.model.UpdateInfo;
import com.tera.scan.upgrade.ui.UpgradeDialog;
import fe.mmm.qw.nn.qw.qw.i;
import fe.mmm.qw.th.qw.th.o;
import fe.mmm.qw.yj.th;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class de implements ILCUpdateHelper, NetWorkMonitor.NetWorkChangeListener {
    public static volatile de ppp;

    /* renamed from: ad  reason: collision with root package name */
    public boolean f7818ad = false;

    /* renamed from: de  reason: collision with root package name */
    public boolean f7819de = false;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f7820fe = false;

    /* renamed from: i  reason: collision with root package name */
    public UpgradeDialog f7821i;

    /* renamed from: if  reason: not valid java name */
    public NetWorkMonitor f335if;

    /* renamed from: o  reason: collision with root package name */
    public UpdateInfo f7822o;

    /* renamed from: pf  reason: collision with root package name */
    public Download f7823pf;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final List<IUpgradeCallBack> f7824rg = Collections.synchronizedList(new ArrayList());

    /* renamed from: switch  reason: not valid java name */
    public final IClientUpdaterCallback f336switch = new C0280de();

    /* renamed from: th  reason: collision with root package name */
    public fe.fe.th.qw f7825th;

    /* renamed from: uk  reason: collision with root package name */
    public fe f7826uk;
    public final BroadcastReceiver when = new rg();

    /* renamed from: yj  reason: collision with root package name */
    public final IntentFilter f7827yj = new IntentFilter();

    public class ad extends fe.mmm.qw.a.uk.rg {
        public ad(String str) {
            super(str);
        }

        public void when() {
            File[] listFiles;
            if (TextUtils.isEmpty(de.this.qw)) {
                File ppp = de.this.f();
                if (ppp != null) {
                    String unused = de.this.qw = ppp.getAbsolutePath();
                } else {
                    return;
                }
            }
            File file = new File(de.this.qw);
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
            }
        }
    }

    /* renamed from: fe.mmm.qw.g.ad.de$de  reason: collision with other inner class name */
    public class C0280de implements IClientUpdaterCallback {
        public C0280de() {
        }

        public void ad(JSONObject jSONObject) {
            for (IUpgradeCallBack iUpgradeCallBack : de.this.f7824rg) {
                if (iUpgradeCallBack != null) {
                    iUpgradeCallBack.ad(jSONObject);
                }
            }
        }

        public void de(JSONObject jSONObject) {
            boolean unused = de.this.f7818ad = false;
            for (IUpgradeCallBack iUpgradeCallBack : de.this.f7824rg) {
                if (iUpgradeCallBack != null) {
                    iUpgradeCallBack.de(jSONObject);
                }
            }
        }

        public void fe(ClientUpdateInfo clientUpdateInfo, RuleInfo ruleInfo) {
            UpdateInfo ddd = de.this.d(clientUpdateInfo);
            for (IUpgradeCallBack iUpgradeCallBack : de.this.f7824rg) {
                if (iUpgradeCallBack != null) {
                    iUpgradeCallBack.fe(ddd);
                }
            }
        }

        public void qw(JSONObject jSONObject) {
            boolean unused = de.this.f7818ad = false;
            for (IUpgradeCallBack iUpgradeCallBack : de.this.f7824rg) {
                if (iUpgradeCallBack != null) {
                    iUpgradeCallBack.qw(jSONObject);
                }
            }
        }
    }

    public class fe implements Function0<Unit> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Activity f7828ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ UpdateInfo f7829th;

        public fe(Activity activity, UpdateInfo updateInfo) {
            this.f7828ad = activity;
            this.f7829th = updateInfo;
        }

        /* renamed from: qw */
        public Unit invoke() {
            if (!i.rg(BaseApplication.getInstance())) {
                o.rg(R.string.network_exception_message);
                new fe(BaseApplication.getInstance()).ad(BaseApplication.getInstance(), R.string.network_exception_message);
                fe.mmm.qw.g.de.qw.th(false);
                return Unit.INSTANCE;
            } else if (!de.this.a()) {
                o.rg(R.string.storage_space_not_enough);
                new fe(BaseApplication.getInstance()).ad(BaseApplication.getInstance(), R.string.storage_space_not_enough);
                fe.mmm.qw.g.de.qw.th(false);
                return Unit.INSTANCE;
            } else {
                if (!de.this.k()) {
                    de.this.f7821i.dismiss();
                } else if (!de.this.f7819de || de.this.f7823pf == null) {
                    de.this.q(0, 0);
                } else {
                    de deVar = de.this;
                    deVar.j(this.f7828ad, deVar.f7823pf.getDownloadFileName());
                    return Unit.INSTANCE;
                }
                if (de.this.f7818ad) {
                    fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "正在下载，关闭弹窗");
                    return Unit.INSTANCE;
                }
                boolean unused = de.this.f7818ad = true;
                fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "下载");
                de.this.e(this.f7828ad, this.f7829th);
                return Unit.INSTANCE;
            }
        }
    }

    public class qw extends fe.mmm.qw.a.uk.rg {
        public final /* synthetic */ ClientUpdateInfo xxx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public qw(String str, ClientUpdateInfo clientUpdateInfo) {
            super(str);
            this.xxx = clientUpdateInfo;
        }

        public void when() {
            de.this.f7825th.a(this.xxx, de.this.qw, true);
        }
    }

    public class rg extends BroadcastReceiver {
        public rg() {
        }

        public void onReceive(Context context, Intent intent) {
            String str;
            fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "onReceive action = " + intent.getAction());
            if ("com.baidu.clientupdate.download.PROGRESS_CHANGE".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("progress", 0);
                Download download = (Download) intent.getSerializableExtra("download");
                Download unused = de.this.f7823pf = download;
                fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "下载进度 :" + intExtra);
                if (download != null && (str = download.mSourceKey) != null && str.contains(BaseApplication.getInstance().getPackageName())) {
                    fe.mmm.qw.i.qw.ad("VersionUpdateHelper", download.mFileName + " " + intExtra + "%");
                    de.this.n();
                    boolean unused2 = de.this.f7818ad = true;
                    if (de.this.f7826uk != null) {
                        de.this.f7826uk.th(intExtra);
                    }
                    de.this.q(0, intExtra);
                    return;
                }
                return;
            }
            boolean equals = "com.baidu.clientupdate.download.STATUS_CHANGE".equals(intent.getAction());
            int i2 = R.string.apk_force_download_failed_notify;
            int i3 = R.string.apk_force_download_failed_toast;
            if (equals) {
                boolean unused3 = de.this.f7820fe = false;
                boolean unused4 = de.this.f7818ad = false;
                Download download2 = (Download) intent.getSerializableExtra("download");
                Download unused5 = de.this.f7823pf = download2;
                if (download2 != null) {
                    fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "下载状态改变: " + download2);
                    if (DownloadState.FINISH == download2.getState()) {
                        fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "DownloadState.FINISH");
                        de.this.l();
                        if (context != null) {
                            de.this.q(1, 0);
                            String downloadFileName = download2.getDownloadFileName();
                            fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "安装包路径 path" + downloadFileName);
                            th.ppp().m1013switch("key_update_apk_path", downloadFileName);
                            boolean unused6 = de.this.f7819de = true;
                            Download unused7 = de.this.f7823pf = download2;
                            if (!de.this.k()) {
                                fe.mmm.qw.g.de.qw.th(true);
                            }
                            new fe(context).fe(context, downloadFileName);
                            de.this.j(context, downloadFileName);
                            de.this.rrr();
                        }
                    } else if (DownloadState.FAILED == download2.getState()) {
                        fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "下载失败: " + download2);
                        if (context != null) {
                            de.this.c(context, true);
                            fe feVar = new fe(context);
                            if (!de.this.k()) {
                                i2 = R.string.apk_download_failed_toast;
                            }
                            feVar.ad(context, i2);
                            de.this.q(2, 0);
                        }
                        fe.mmm.qw.g.de.qw.th(false);
                        Context instance = BaseApplication.getInstance();
                        if (!de.this.k()) {
                            i3 = R.string.apk_download_failed_toast;
                        }
                        o.de(instance, i3);
                        de.this.rrr();
                    }
                }
            } else if ("com.baidu.clientupdate.RSA.STATUS_FAIL".equals(intent.getAction())) {
                boolean unused8 = de.this.f7818ad = false;
                boolean unused9 = de.this.f7820fe = false;
                Download download3 = (Download) intent.getSerializableExtra("download");
                if (!(context == null || download3 == null)) {
                    fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "RSA验证失败: " + download3);
                    de.this.c(context, true);
                    fe feVar2 = new fe(context);
                    if (!de.this.k()) {
                        i2 = R.string.apk_download_failed_toast;
                    }
                    feVar2.ad(context, i2);
                }
                de.this.q(2, 0);
                fe.mmm.qw.g.de.qw.th(false);
                Context instance2 = BaseApplication.getInstance();
                if (!de.this.k()) {
                    i3 = R.string.apk_download_failed_toast;
                }
                o.de(instance2, i3);
                de.this.rrr();
            }
        }
    }

    public de() {
        h();
    }

    public static de g() {
        if (ppp == null) {
            synchronized (de.class) {
                if (ppp == null) {
                    ppp = new de();
                }
            }
        }
        return ppp;
    }

    public final boolean a() {
        if (this.f7822o == null) {
            return false;
        }
        StatFs statFs = new StatFs(BaseApplication.getInstance().getCacheDir().getAbsolutePath());
        if (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > Long.parseLong(this.f7822o.mSize)) {
            return true;
        }
        return false;
    }

    public void ad() {
    }

    public final void b() {
        new ad("clearCacheNotify").mmm();
    }

    public void c(@NonNull Context context, boolean z) {
        if (z) {
            new fe(context).qw();
        }
        b();
    }

    public final UpdateInfo d(ClientUpdateInfo clientUpdateInfo) {
        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.mVercode = clientUpdateInfo.mVercode;
        updateInfo.mVername = clientUpdateInfo.mVername;
        updateInfo.mDownurl = clientUpdateInfo.mDownurl;
        updateInfo.mChangelog = clientUpdateInfo.mChangelog;
        updateInfo.mSize = clientUpdateInfo.mSize;
        updateInfo.mPackageName = clientUpdateInfo.mPackageName;
        updateInfo.mSign = clientUpdateInfo.mSign;
        updateInfo.mProdline = clientUpdateInfo.mProdline;
        updateInfo.mSignMd5 = clientUpdateInfo.mSignMd5;
        updateInfo.mApkMd5 = clientUpdateInfo.mApkMd5;
        updateInfo.mPatchDownUrl = clientUpdateInfo.mPatchDownUrl;
        updateInfo.mPatchSize = clientUpdateInfo.mPatchSize;
        updateInfo.mIconUrl = clientUpdateInfo.mIconUrl;
        updateInfo.mSname = clientUpdateInfo.mSname;
        updateInfo.mUpdateTime = clientUpdateInfo.mUpdateTime;
        updateInfo.mIsForceUpdate = clientUpdateInfo.mIsForceUpdate;
        updateInfo.mStatus = clientUpdateInfo.mStatus;
        updateInfo.mReverson = clientUpdateInfo.mReverson;
        updateInfo.mContentUrl = clientUpdateInfo.mContentUrl;
        return updateInfo;
    }

    public void e(Context context, UpdateInfo updateInfo) {
        ClientUpdateInfo r = r(updateInfo);
        m(context, updateInfo);
        this.f7822o = updateInfo;
        rrr();
        this.f335if = new NetWorkMonitor(this, BaseApplication.getInstance());
        new qw("downApk", r).mmm();
    }

    public final File f() {
        File file = new File(BaseApplication.getInstance().getCacheDir(), ".apk");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        fe.mmm.qw.i.qw.ppp("VersionUpdateHelper", "unable to create dir=.apkcache directory");
        return null;
    }

    public final void h() {
        fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "initLCUpdate");
        this.f7827yj.addAction("com.baidu.clientupdate.download.PROGRESS_CHANGE");
        this.f7827yj.addAction("com.baidu.clientupdate.download.STATUS_CHANGE");
        this.f7827yj.addAction("com.baidu.clientupdate.RSA.STATUS_FAIL");
        BaseApplication.getInstance().registerReceiver(this.when, this.f7827yj);
        this.f7825th = fe.fe.th.qw.ddd(BaseApplication.getInstance());
        String packageName = BaseApplication.getInstance().getPackageName();
        fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "packageName:" + packageName);
        fe.fe.th.qw qwVar = this.f7825th;
        qwVar.mmm(packageName + ".nestdiskFileprovider");
        if (Build.SUPPORTED_64_BIT_ABIS.length == 0) {
            this.f7825th.i("cpu_type", "arm_32");
        } else {
            this.f7825th.i("cpu_type", "arm_64");
        }
        this.f7825th.qqq("aiscan");
        this.f7825th.eee("0");
        this.f7825th.aaa(fe.mmm.qw.de.ad.qw.qw.f7752rg);
        this.f7825th.tt(true);
        this.f7825th.nn(true);
        this.f7825th.rrr(fe.mmm.qw.i.qw.o());
    }

    public final void j(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        Uri ad2 = new fe.mmm.qw.j.de().ad(context, str);
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(ad2, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public final boolean k() {
        UpdateInfo updateInfo = this.f7822o;
        return updateInfo != null && TextUtils.equals(updateInfo.mIsForceUpdate, "1");
    }

    public final void l() {
        UpdateInfo updateInfo = this.f7822o;
        if (updateInfo != null) {
            int i2 = 0;
            try {
                i2 = Integer.parseInt(updateInfo.mVercode);
            } catch (NumberFormatException e) {
                fe.mmm.qw.i.qw.rg("VersionUpdateHelper", e.getMessage());
            }
            th.ppp().pf("update_apk_version", i2);
            th.ppp().pf("key_tip_update_apk_version", i2);
        }
    }

    public final void m(Context context, UpdateInfo updateInfo) {
        if (this.f7826uk == null) {
            this.f7826uk = new fe(context);
        }
        this.f7826uk.de(context, R.string.download_apk, updateInfo.mVername);
    }

    public final void n() {
        if (!k() && !this.f7820fe) {
            this.f7820fe = true;
            o.uk(String.format(BaseApplication.getInstance().getString(R.string.download_apk), new Object[]{this.f7822o.mVername}));
        }
    }

    public void p(@NotNull Activity activity, @NonNull UpdateInfo updateInfo) {
        fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "显示更新弹窗");
        if (activity.isFinishing()) {
            fe.mmm.qw.i.qw.rg("VersionUpdateHelper", "context is null");
            return;
        }
        UpgradeDialog upgradeDialog = this.f7821i;
        if ((upgradeDialog == null || !upgradeDialog.isShowing()) && !this.f7818ad) {
            File f = f();
            if (f == null) {
                o.rg(R.string.update_version_failed_mount_sdcard);
                return;
            }
            this.qw = f.getAbsolutePath();
            this.f7822o = updateInfo;
            fe.mmm.qw.i.qw.ad("VersionUpdateHelper", "downloadpath=" + this.qw);
            String format = String.format(activity.getString(R.string.check_version), new Object[]{updateInfo.mVername});
            String str = updateInfo.mChangelog;
            if (k()) {
                UpgradeDialog.qw qwVar = new UpgradeDialog.qw();
                qwVar.ppp(format);
                qwVar.fe(str);
                qwVar.de(activity.getString(R.string.update_now));
                qwVar.when(true);
                qwVar.ad(false);
                this.f7821i = qwVar.qw();
            } else {
                UpgradeDialog.qw qwVar2 = new UpgradeDialog.qw();
                qwVar2.ppp(format);
                qwVar2.fe(str);
                qwVar2.de(activity.getString(R.string.update_now));
                qwVar2.when(false);
                this.f7821i = qwVar2.qw();
            }
            this.f7821i.setOnConfirmChange(new fe(activity, updateInfo));
            if (activity instanceof FragmentActivity) {
                this.f7821i.show(((FragmentActivity) activity).getSupportFragmentManager(), "upgrade_dialog");
            }
        }
    }

    public final void q(int i2, int i3) {
        if (this.f7821i != null && k()) {
            this.f7821i.onDownloadStatusChange(i2, i3);
        }
    }

    public void qw(boolean z, boolean z2) {
        if (!z) {
            if (fe.mmm.qw.ggg.ad.yj.ad.o()) {
                o.rg(R.string.network_exception_message);
            }
            this.f7826uk.ad(BaseApplication.getInstance(), R.string.network_exception_message);
            fe.mmm.qw.g.de.qw.th(false);
        }
    }

    public final ClientUpdateInfo r(UpdateInfo updateInfo) {
        ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
        clientUpdateInfo.mVercode = updateInfo.mVercode;
        clientUpdateInfo.mVername = updateInfo.mVername;
        clientUpdateInfo.mDownurl = updateInfo.mDownurl;
        clientUpdateInfo.mChangelog = updateInfo.mChangelog;
        clientUpdateInfo.mSize = updateInfo.mSize;
        clientUpdateInfo.mPackageName = updateInfo.mPackageName;
        clientUpdateInfo.mSign = updateInfo.mSign;
        clientUpdateInfo.mProdline = updateInfo.mProdline;
        clientUpdateInfo.mSignMd5 = updateInfo.mSignMd5;
        clientUpdateInfo.mApkMd5 = updateInfo.mApkMd5;
        clientUpdateInfo.mPatchDownUrl = updateInfo.mPatchDownUrl;
        clientUpdateInfo.mPatchSize = updateInfo.mPatchSize;
        clientUpdateInfo.mIconUrl = updateInfo.mIconUrl;
        clientUpdateInfo.mSname = updateInfo.mSname;
        clientUpdateInfo.mUpdateTime = updateInfo.mUpdateTime;
        clientUpdateInfo.mIsForceUpdate = updateInfo.mIsForceUpdate;
        clientUpdateInfo.mStatus = updateInfo.mStatus;
        clientUpdateInfo.mReverson = updateInfo.mReverson;
        clientUpdateInfo.mContentUrl = updateInfo.mContentUrl;
        return clientUpdateInfo;
    }

    public final void rrr() {
        NetWorkMonitor netWorkMonitor = this.f335if;
        if (netWorkMonitor != null) {
            try {
                netWorkMonitor.i(BaseApplication.getInstance());
            } catch (IllegalArgumentException e) {
                fe.mmm.qw.i.qw.th("VersionUpdateHelper", e.getMessage(), e);
            }
            this.f335if = null;
        }
    }

    public void tt(@NotNull IUpgradeCallBack iUpgradeCallBack, @NotNull Context context) {
        if (!this.f7824rg.contains(iUpgradeCallBack)) {
            this.f7824rg.add(iUpgradeCallBack);
        }
        this.f7825th.when(this.f336switch);
    }
}
