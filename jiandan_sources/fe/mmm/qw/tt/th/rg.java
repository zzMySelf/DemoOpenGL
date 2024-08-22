package fe.mmm.qw.tt.th;

import android.app.Activity;
import android.content.DialogInterface;

public final class rg implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

    /* renamed from: ad  reason: collision with root package name */
    public final Activity f8524ad;

    public rg(Activity activity) {
        this.f8524ad = activity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        qw();
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        qw();
    }

    public final void qw() {
        this.f8524ad.finish();
    }
}
