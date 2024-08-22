package fe.fe.th.i;

import com.baidu.clientupdate.download.Download;

public class qw implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ String f3101ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Download f3102th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ ad f3103yj;

    public qw(ad adVar, String str, Download download) {
        this.f3103yj = adVar;
        this.f3101ad = str;
        this.f3102th = download;
    }

    public void run() {
        fe.fe.aaa.qw.ad("DownloadManager", "onWriteFinish   launchSystemInstalller");
        this.f3103yj.qw.nn(this.f3101ad, this.f3102th);
    }
}
