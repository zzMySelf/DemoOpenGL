package com.dxmpay.wallet.download;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import com.dxmpay.apollon.downloadmanager.ApollonDownloadManager;
import com.dxmpay.apollon.downloadmanager.DownloadItemInfo;
import com.dxmpay.apollon.permission.PermissionManager;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.download.b;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.FileUtils;
import com.dxmpay.wallet.utils.ZipUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PayDownloadModule implements NoProguard {
    public static final int STATUS_DOWNLOAD_FAIL = 2;
    public static final String STATUS_DOWNLOAD_MSG_FAIL = "下载失败";
    public static final String STATUS_DOWNLOAD_MSG_SUCCESS = "下载成功";
    public static final int STATUS_DOWNLOAD_RUNNING = 1;
    public static final int STATUS_DOWNLOAD_SUCCESS = 0;
    public static final int STATUS_UN_ZIP_FAIL = 3;
    public static final String STATUS_UN_ZIP_MSG_FAIL = "解压失败";
    public static final String TAG = "PayDownloadModule";
    public Context context;
    public ExecutorService executorService = Executors.newSingleThreadExecutor();
    public PayDownloadCallBack mPayDownloadCallBack;
    public String moduleName;

    public interface PayDownloadCallBack {
        void onDownloadStatus(String str, int i2);
    }

    public class ad implements ApollonDownloadManager.DownloadListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f4300ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ String f4301de;
        public final /* synthetic */ long qw;

        public ad(long j, String str, String str2) {
            this.qw = j;
            this.f4300ad = str;
            this.f4301de = str2;
        }

        public void onChanged(DownloadItemInfo downloadItemInfo) {
            if (downloadItemInfo.getDownloadState() == 8) {
                ApollonDownloadManager.getInstance(PayDownloadModule.this.context).unregisterObserver(PayDownloadModule.this.context, this.qw, this);
                PayDownloadModule.this.downloadFileSuccess(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + this.f4300ad + this.f4301de, this.f4300ad, false);
            } else if (downloadItemInfo.getDownloadState() == 2) {
                if (PayDownloadModule.this.mPayDownloadCallBack != null) {
                    PayDownloadModule.this.mPayDownloadCallBack.onDownloadStatus("", 1);
                }
            } else if (downloadItemInfo.getDownloadState() == 16) {
                PayDownloadModule.this.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                if (PayDownloadModule.this.mPayDownloadCallBack != null) {
                    PayDownloadModule.this.mPayDownloadCallBack.onDownloadStatus("", 2);
                }
            } else {
                PayDownloadModule.this.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                if (PayDownloadModule.this.mPayDownloadCallBack != null) {
                    PayDownloadModule.this.mPayDownloadCallBack.onDownloadStatus("", 2);
                }
            }
        }
    }

    public class de implements b.a {
        public final /* synthetic */ String qw;

        public de(String str) {
            this.qw = str;
        }

        public void a(String str) {
            PayDownloadModule.this.downloadFileSuccess(str, this.qw, true);
        }

        public void b(String str) {
            PayDownloadModule.this.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
            if (PayDownloadModule.this.mPayDownloadCallBack != null) {
                PayDownloadModule.this.mPayDownloadCallBack.onDownloadStatus("", 2);
            }
        }

        public void a() {
            if (PayDownloadModule.this.mPayDownloadCallBack != null) {
                PayDownloadModule.this.mPayDownloadCallBack.onDownloadStatus("", 1);
            }
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f4304ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f4305th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ boolean f4307yj;

        public fe(String str, String str2, boolean z) {
            this.f4304ad = str;
            this.f4305th = str2;
            this.f4307yj = z;
        }

        public void run() {
            if (TextUtils.equals(Md5Utils.getMd5FromFileV2(this.f4304ad), this.f4305th)) {
                PayDownloadModule.this.setDownloadModuleStatusPoint(0, PayDownloadModule.STATUS_DOWNLOAD_MSG_SUCCESS);
                if (!ZipUtils.unzip(this.f4304ad, PayDownloadModule.this.getInternalUnZipPath(this.f4305th))) {
                    PayDownloadModule.this.setDownloadModuleStatusPoint(3, PayDownloadModule.STATUS_UN_ZIP_MSG_FAIL);
                    if (PayDownloadModule.this.mPayDownloadCallBack != null) {
                        PayDownloadModule.this.mPayDownloadCallBack.onDownloadStatus("", 3);
                    }
                } else if (PayDownloadModule.this.mPayDownloadCallBack != null) {
                    if (!TextUtils.isEmpty(PayDownloadCache.getDownloadFileMd5Value(PayDownloadModule.this.context, PayDownloadModule.this.moduleName))) {
                        PayDownloadModule payDownloadModule = PayDownloadModule.this;
                        FileUtils.deleteDir(new File(payDownloadModule.getInternalUnZipPath(PayDownloadCache.getDownloadFileMd5Value(payDownloadModule.context, PayDownloadModule.this.moduleName))), true);
                    }
                    PayDownloadCache.setDownloadFileMd5Value(PayDownloadModule.this.context, PayDownloadModule.this.moduleName, this.f4305th);
                    PayDownloadModule.this.mPayDownloadCallBack.onDownloadStatus(PayDownloadModule.this.getInternalUnZipPath(this.f4305th), 0);
                }
            } else {
                PayDownloadModule.this.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                if (PayDownloadModule.this.mPayDownloadCallBack != null) {
                    PayDownloadModule.this.mPayDownloadCallBack.onDownloadStatus("", 2);
                }
            }
            if (this.f4307yj) {
                FileUtils.deleteFile(this.f4304ad);
            }
        }
    }

    public class qw implements b.a {
        public final /* synthetic */ String qw;

        public qw(String str) {
            this.qw = str;
        }

        public void a(String str) {
            PayDownloadModule.this.downloadFileSuccess(str, this.qw, true);
        }

        public void b(String str) {
            PayDownloadModule.this.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
            if (PayDownloadModule.this.mPayDownloadCallBack != null) {
                PayDownloadModule.this.mPayDownloadCallBack.onDownloadStatus("", 2);
            }
        }

        public void a() {
            if (PayDownloadModule.this.mPayDownloadCallBack != null) {
                PayDownloadModule.this.mPayDownloadCallBack.onDownloadStatus("", 1);
            }
        }
    }

    public PayDownloadModule(Context context2, String str) {
        this.context = context2;
        this.moduleName = str;
    }

    private boolean checkUpdate(String str) {
        return !TextUtils.equals(str, PayDownloadCache.getDownloadFileMd5Value(this.context, this.moduleName));
    }

    private boolean checkUpdateExternal(String str, String str2) {
        String str3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str + str2;
        if (new File(str3).exists()) {
            return TextUtils.equals(str, Md5Utils.getMd5FromFileV2(str3));
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void downloadFileSuccess(String str, String str2, boolean z) {
        this.executorService.submit(new fe(str, str2, z));
    }

    /* access modifiers changed from: private */
    public void setDownloadModuleStatusPoint(int i2, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(i2 + "");
        arrayList.add(str + "");
        arrayList.add(this.moduleName + "");
        StatisticManager.onEventEndWithValues(StatServiceEvent.DOWNLOAD_MODULE_STATUS, arrayList);
    }

    private void setPreviousDownloadCompletedPoint() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.moduleName);
        StatisticManager.onEventEndWithValues(StatServiceEvent.DOWNLOAD_MODULE_PREVIOUS_DOWNLOAD_COMPLETED, arrayList);
    }

    @Deprecated
    public void download(String str, String str2, boolean z, boolean z2, String str3) {
        String str4 = str2;
        String str5 = str3;
        if (checkUpdate(str4)) {
            if (Build.VERSION.SDK_INT >= 29 || !PermissionManager.checkCallingPermission(this.context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                new b(this.moduleName).ad(str, str4, getInternalZipPath(str4, str5), new qw(str4));
            } else if (checkUpdateExternal(str4, str5)) {
                setPreviousDownloadCompletedPoint();
                downloadFileSuccess(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str4 + str5, str4, false);
            } else {
                ApollonDownloadManager apollonDownloadManager = new ApollonDownloadManager(this.context, this.moduleName);
                String str6 = Environment.DIRECTORY_DOWNLOADS;
                long doDownload = apollonDownloadManager.doDownload(str6, str4 + "", str, z, z2, false, str3);
                if (doDownload != -1) {
                    apollonDownloadManager.registerObserver(this.context, doDownload, new ad(doDownload, str2, str3));
                    return;
                }
                PayDownloadCallBack payDownloadCallBack = this.mPayDownloadCallBack;
                if (payDownloadCallBack != null) {
                    payDownloadCallBack.onDownloadStatus("", 2);
                }
            }
        } else if (this.mPayDownloadCallBack != null) {
            setPreviousDownloadCompletedPoint();
            PayDownloadCallBack payDownloadCallBack2 = this.mPayDownloadCallBack;
            payDownloadCallBack2.onDownloadStatus(this.context.getDir(this.moduleName, 0) + File.separator + str4, 0);
        }
    }

    public String getInternalRootPath() {
        return this.context.getDir(this.moduleName, 0).getAbsolutePath();
    }

    public String getInternalUnZipPath(String str) {
        String internalRootPath = getInternalRootPath();
        return new File(internalRootPath + File.separator + str).getAbsolutePath();
    }

    public String getInternalZipPath(String str, String str2) {
        String internalRootPath = getInternalRootPath();
        return new File(internalRootPath + File.separator + str + str2).getAbsolutePath();
    }

    public void resetMD5AndDeleteDownloadFiles(Context context2) {
        if (context2 != null) {
            PayDownloadCache.setDownloadFileMd5Value(context2, this.moduleName, "");
            FileUtils.deleteDir(new File(getInternalRootPath()), true);
        }
    }

    @Deprecated
    public void resetMD5AndDeleteFiles(Context context2) {
        if (context2 != null) {
            PayDownloadCache.setDownloadFileMd5Value(context2, BeanConstants.SDK_DOLEAD_FILE_FAEC_MODULE_NAME, "");
            FileUtils.deleteDir(new File(getInternalRootPath()), true);
        }
    }

    public void setPayDownloadCallBack(PayDownloadCallBack payDownloadCallBack) {
        this.mPayDownloadCallBack = payDownloadCallBack;
    }

    public void download(String str, String str2, String str3) {
        if (checkUpdate(str2)) {
            new b(this.moduleName).ad(str, str2, getInternalZipPath(str2, str3), new de(str2));
        } else if (this.mPayDownloadCallBack != null) {
            setPreviousDownloadCompletedPoint();
            PayDownloadCallBack payDownloadCallBack = this.mPayDownloadCallBack;
            payDownloadCallBack.onDownloadStatus(this.context.getDir(this.moduleName, 0) + File.separator + str2, 0);
        }
    }
}
