package fe.fe.th.i;

import android.net.Uri;
import android.text.TextUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.clientupdate.download.Download;
import com.baidu.clientupdate.download.DownloadState;
import fe.fe.aaa.qw;
import fe.fe.o.de.th;
import fe.fe.th.ad.de;
import java.io.File;

public class ad extends th {
    public final /* synthetic */ uk qw;

    public ad(uk ukVar) {
        this.qw = ukVar;
    }

    public void ad(String str, long j, long j2, long j3, String str2) {
        qw.ad("DownloadManager", "--- onDownloadCancel : " + j);
        this.qw.when(DownloadState.CANCEL, j);
    }

    public void de(String str, long j, long j2, String str2, String str3, int i2, fe.fe.o.de.qw qwVar) {
        long j3 = j;
        long j4 = j2;
        String str4 = str3;
        de rg2 = this.qw.vvv;
        String i3 = this.qw.ggg.i();
        String rg3 = this.qw.ggg.rg();
        rg2.th(i3, "0", rg3, "a7", "1", (System.currentTimeMillis() / 1000) + "", "", "DownloadFail", "");
        qw.ad("DownloadManager", "--- onDownloadFail : " + j3);
        Download download = (Download) this.qw.f3110de.get(Long.valueOf(j));
        if (download != null) {
            if (j4 <= download.mFileLength) {
                download.mCurrentLength = j4;
            }
            download.mFailReason = str4;
        }
        qw.ad("DownloadManager", "-- onDownloadFail : " + str4);
        this.qw.when(DownloadState.FAILED, j3);
    }

    public void fe(String str, long j, long j2, long j3, String str2) {
        long j4 = j;
        de rg2 = this.qw.vvv;
        String i2 = this.qw.ggg.i();
        String rg3 = this.qw.ggg.rg();
        rg2.th(i2, "0", rg3, "a7", "-1", (System.currentTimeMillis() / 1000) + "", "", "DownloadPause", "");
        qw.ad("DownloadManager", "--- onDownloadPause : " + j4);
        Download download = (Download) this.qw.f3110de.get(Long.valueOf(j));
        if (download != null) {
            download.mCurrentLength = j2;
        }
        this.qw.when(DownloadState.PAUSE, j4);
    }

    public void i(String str, long j, long j2, long j3, long j4, String str2) {
        qw.ad("DownloadManager", "--- onDownloading : " + j);
        if (j3 != 0 && j2 != 0 && j2 <= j3) {
            Download download = (Download) this.qw.f3110de.get(Long.valueOf(j));
            if (download == null) {
                qw.ad("DownloadManager", "*** onDownloading, found download is null!");
                return;
            }
            download.mCurrentLength = j2;
            download.mFileLength = j3;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - download.a >= 200) {
                download.a = currentTimeMillis;
                int progress = download.getProgress();
                if (progress != download.c) {
                    this.qw.mmm(j, progress);
                    download.c = progress;
                }
                if (currentTimeMillis - download.b > ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    this.qw.f3116th.ggg(download);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    qw.ad("DownloadManager", "1新的更新数据库用时time:" + (currentTimeMillis3 - currentTimeMillis2) + "ms");
                    download.b = currentTimeMillis;
                }
            }
        }
    }

    public void o(String str, long j, long j2, long j3, fe.fe.o.de.qw qwVar) {
        long j4 = j;
        this.qw.vvv.th(this.qw.ggg.i(), "0", this.qw.ggg.rg(), "a7", "0", (System.currentTimeMillis() / 1000) + "", "", "DownloadFinish", "");
        qw.ad("DownloadManager", "--- onWriteFinish : " + j4);
        Download download = (Download) this.qw.f3110de.get(Long.valueOf(j));
        if (download != null) {
            download.mCurrentLength = download.mFileLength;
            String str2 = download.mSavedPath + "/" + Uri.encode(download.mFileName);
            qw.qw("DownloadManager", "Download path:" + str2 + str2.endsWith(".bin"));
            if (!this.qw.when && (!fe.fe.th.uk.qw.ad(this.qw.f3109ad).uk() || !str2.endsWith(".bin"))) {
                this.qw.f3111fe.post(new qw(this, str2, download));
            }
        }
        this.qw.when(DownloadState.FINISH, j4);
    }

    public void rg(String str, long j, long j2, long j3) {
        qw.ad("DownloadManager", "--- onDownloadRunning ");
    }

    public void th(String str, long j, long j2, String str2, String str3, String str4, String str5, boolean z, fe.fe.o.de.qw qwVar) {
        DownloadState downloadState;
        uk ukVar;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        de deVar;
        long j3 = j;
        String str14 = str3;
        qw.ad("DownloadManager", "--- onDownloadStart : " + j3);
        Download download = (Download) this.qw.f3110de.get(Long.valueOf(j));
        if (download != null) {
            if (download.mMimeType.equals("patch")) {
                deVar = this.qw.vvv;
                str13 = this.qw.ggg.i();
                str11 = this.qw.ggg.rg();
                str8 = (System.currentTimeMillis() / 1000) + "";
                str12 = "0";
                str10 = "a6";
                str9 = "0";
                str7 = "";
                str6 = "PatchDownload";
            } else {
                deVar = this.qw.vvv;
                str13 = this.qw.ggg.i();
                str11 = this.qw.ggg.rg();
                str8 = (System.currentTimeMillis() / 1000) + "";
                str12 = "0";
                str10 = "a6";
                str9 = "0";
                str7 = "";
                str6 = "normalDownload";
            }
            deVar.th(str13, str12, str11, str10, str9, str8, str7, str6, "");
            uk.qqq(this.qw.f3109ad, str14);
            File file = new File(str14);
            String parent = file.getParent();
            if (!TextUtils.equals(parent, download.mSavedPath)) {
                String str15 = download.mFileName;
                if (str15 != null) {
                    new File(download.mSavedPath, Uri.encode(str15)).delete();
                }
                download.mSavedPath = parent;
                download.mCurrentLength = 0;
            }
            String decode = Uri.decode(file.getName());
            download.mETag = str4;
            download.mFileLength = j2;
            download.mFileName = decode;
            ukVar = this.qw;
            downloadState = DownloadState.DOWNLOADING;
        } else {
            ukVar = this.qw;
            downloadState = DownloadState.FAILED;
        }
        ukVar.when(downloadState, j3);
    }

    public void uk(String str, long j) {
        qw.ad("DownloadManager", "--- onDownloadWait : " + j);
    }

    public void yj(String str, long j, long j2, long j3, String str2, long j4) {
        qw.ad("DownloadManager", "--- onDownloadSuccess : " + j);
    }
}
