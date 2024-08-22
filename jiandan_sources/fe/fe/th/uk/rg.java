package fe.fe.th.uk;

import android.content.Context;
import android.widget.Toast;

public final class rg implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Context f3153ad;

    public rg(Context context) {
        this.f3153ad = context;
    }

    public void run() {
        Toast.makeText(this.f3153ad, "文件不可用", 0).show();
    }
}
