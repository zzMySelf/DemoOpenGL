package fe.fe.th.i;

import android.content.Intent;
import android.net.Uri;
import com.baidu.android.common.jni.MiniGzip;
import com.baidu.clientupdate.download.Download;
import com.baidu.clientupdate.download.DownloadState;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import fe.fe.de.qw.qw.qw;
import fe.fe.th.uk.o;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class th implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ long f3106ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Download f3107th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ uk f3108yj;

    public th(uk ukVar, long j, Download download) {
        this.f3108yj = ukVar;
        this.f3106ad = j;
        this.f3107th = download;
    }

    public void run() {
        File file;
        qw qwVar = new qw();
        Intent intent = new Intent("com.baidu.clientupdate.download.STATUS_CHANGE");
        intent.putExtra("downloadid", this.f3106ad);
        intent.putExtra(WXLoginActivity.w, this.f3107th.getState());
        intent.putExtra("download", this.f3107th);
        intent.setPackage(this.f3108yj.f3109ad.getPackageName());
        this.f3108yj.f3109ad.sendBroadcast(intent);
        if (this.f3107th.mMimeType.equals("patch") && this.f3107th.getState() == DownloadState.FINISH) {
            String[] strArr = new String[4];
            strArr[0] = "-d";
            strArr[1] = o.yj(this.f3108yj.f3109ad, this.f3108yj.f3109ad.getPackageName()).applicationInfo.publicSourceDir;
            String str = null;
            String str2 = this.f3107th.mFileName;
            if (str2 != null) {
                str = Uri.encode(str2);
            }
            strArr[2] = this.f3107th.mSavedPath + File.separator + uk.ggg(this.f3107th.mUrl, str, "patch") + uk.ppp(this.f3107th.mUrl, str, "patch");
            strArr[3] = this.f3107th.mSavedPath + File.separator + uk.ggg(this.f3107th.mUrl, str, "application/vnd.android.package-archive") + uk.ppp(this.f3107th.mUrl, str, "application/vnd.android.package-archive");
            File file2 = new File(strArr[1]);
            File file3 = new File(strArr[3]);
            if (file3.exists()) {
                file3.delete();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (uk.ddd(strArr[2])) {
                String str3 = strArr[2];
                MiniGzip.unGzipFile(str3, strArr[2] + ".temp");
                file = new File(strArr[2] + ".temp");
            } else {
                file = new File(strArr[2]);
            }
            Intent intent2 = new Intent("com.baidu.clientupdate.download.STATUS_MERGE");
            intent2.putExtra("downloadid", this.f3106ad);
            intent2.putExtra(WXLoginActivity.w, DownloadState.MEAGESTART);
            Download download = this.f3107th;
            download.mState = DownloadState.MEAGESTART;
            intent2.putExtra("download", download);
            intent2.setPackage(this.f3108yj.f3109ad.getPackageName());
            this.f3108yj.f3109ad.sendBroadcast(intent2);
            try {
                qwVar.th(file2, file, file3);
            } catch (Exception e) {
                e.printStackTrace();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msgId", "2");
                    jSONObject.put("messageDetail", e.getMessage());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                fe.fe.th.qw.ddd(this.f3108yj.f3109ad).b(jSONObject);
            }
            fe.fe.aaa.qw.qw("DownloadManager", "time is >>>  " + (System.currentTimeMillis() - currentTimeMillis) + "");
            Intent intent3 = new Intent("com.baidu.clientupdate.download.STATUS_MERGE");
            intent3.putExtra("downloadid", this.f3106ad);
            intent3.putExtra(WXLoginActivity.w, DownloadState.MEAGEEND);
            Download download2 = this.f3107th;
            download2.mState = DownloadState.MEAGEEND;
            intent3.putExtra("download", download2);
            intent3.setPackage(this.f3108yj.f3109ad.getPackageName());
            this.f3108yj.f3109ad.sendBroadcast(intent3);
            if (!this.f3108yj.when) {
                this.f3108yj.f3111fe.post(new rg(this, file3));
            }
        }
    }
}
