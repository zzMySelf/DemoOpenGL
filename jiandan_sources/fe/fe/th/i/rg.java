package fe.fe.th.i;

import fe.fe.aaa.qw;
import java.io.File;

public class rg implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ File f3104ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ th f3105th;

    public rg(th thVar, File file) {
        this.f3105th = thVar;
        this.f3104ad = file;
    }

    public void run() {
        qw.ad("DownloadManager", "notifyStateChange   launchSystemInstalller");
        this.f3105th.f3108yj.nn(this.f3104ad.getAbsolutePath(), this.f3105th.f3107th);
    }
}
