package fe.fe.th.i;

import android.content.Intent;
import com.baidu.clientupdate.download.Download;

public class fe implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ long f3096ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f3097th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ uk f3098yj;

    public fe(uk ukVar, long j, int i2) {
        this.f3098yj = ukVar;
        this.f3096ad = j;
        this.f3097th = i2;
    }

    public void run() {
        Download download = (Download) this.f3098yj.f3110de.get(Long.valueOf(this.f3096ad));
        if (download != null) {
            Intent intent = new Intent("com.baidu.clientupdate.download.PROGRESS_CHANGE");
            intent.putExtra("downloadid", this.f3096ad);
            intent.putExtra("download", download);
            intent.putExtra("progress", this.f3097th);
            intent.setPackage(this.f3098yj.f3109ad.getPackageName());
            this.f3098yj.f3109ad.sendBroadcast(intent);
        }
    }
}
