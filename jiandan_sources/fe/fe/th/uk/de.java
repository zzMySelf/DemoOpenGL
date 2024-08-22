package fe.fe.th.uk;

import android.content.Context;
import android.widget.Toast;

public final class de implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Context f3141ad;

    public de(Context context) {
        this.f3141ad = context;
    }

    public void run() {
        Toast.makeText(this.f3141ad, "SD卡空间不足，将为你下载到手机内存", 0).show();
    }
}
