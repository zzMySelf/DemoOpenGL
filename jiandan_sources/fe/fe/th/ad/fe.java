package fe.fe.th.ad;

import android.util.Log;
import fe.fe.aaa.qw;

public class fe extends Thread {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ byte[] f3087ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ de f3088th;

    public fe(de deVar, byte[] bArr) {
        this.f3088th = deVar;
        this.f3087ad = bArr;
    }

    public void run() {
        super.run();
        try {
            this.f3088th.fe();
            this.f3088th.f3086fe.de(this.f3087ad);
        } catch (Exception e) {
            qw.ad("LogUtils", Log.getStackTraceString(e));
        }
    }
}
