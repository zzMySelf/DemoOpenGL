package fe.fe.ddd.mmm.qw;

import android.app.Activity;
import android.os.Bundle;

public class de extends fe.fe.ddd.rg.de {

    /* renamed from: ad  reason: collision with root package name */
    public yj f1498ad = yj.rg();
    public fe qw = new fe();

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f1498ad.th()) {
            this.qw.qw(activity);
            this.f1498ad.uk(activity, (!yj.qw(activity) || bundle == null) ? null : bundle.getString("ActivityName"), (Object) null, "onCreated");
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.f1498ad.th()) {
            this.qw.ad(activity);
            this.f1498ad.uk(activity, (String) null, (Object) null, "onDestroyed");
        }
    }

    public void onActivityResumed(Activity activity) {
        if (this.f1498ad.th()) {
            this.f1498ad.uk(activity, (String) null, (Object) null, "onResumed");
        }
    }

    public void onBackgroundToForeground(Activity activity) {
        super.onBackgroundToForeground(activity);
        if (this.f1498ad.th()) {
            this.f1498ad.i(activity, true);
        }
    }

    public void onForegroundToBackground(Activity activity) {
        super.onForegroundToBackground(activity);
        if (this.f1498ad.th()) {
            this.f1498ad.i(activity, false);
        }
    }

    public void qw(Activity activity) {
        this.qw.qw(activity);
    }
}
