package fe.fe.th.uk;

import android.content.Context;
import android.widget.Toast;

public final class th implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Context f3154ad;

    public th(Context context) {
        this.f3154ad = context;
    }

    public void run() {
        Toast.makeText(this.f3154ad, "手机存储空间不足,建议您释放空间后再下载", 1).show();
    }
}
