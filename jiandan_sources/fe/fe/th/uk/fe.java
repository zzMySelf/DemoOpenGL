package fe.fe.th.uk;

import android.content.Context;
import android.widget.Toast;

public final class fe implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Context f3142ad;

    public fe(Context context) {
        this.f3142ad = context;
    }

    public void run() {
        Toast.makeText(this.f3142ad, "无SD卡，将为你下载到手机内存", 0).show();
    }
}
