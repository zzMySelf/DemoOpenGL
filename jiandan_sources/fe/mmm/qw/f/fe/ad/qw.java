package fe.mmm.qw.f.fe.ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import com.tera.scan.ui.widget.titlebar.EditModeLayout;
import java.lang.ref.WeakReference;

public abstract class qw {

    /* renamed from: ad  reason: collision with root package name */
    public View f7813ad;

    /* renamed from: de  reason: collision with root package name */
    public Boolean f7814de;
    public WeakReference<Activity> qw;

    public qw(Activity activity) {
        this(activity, (View) null, 0);
    }

    public abstract void ad();

    public View de(int i2) {
        Activity activity = (Activity) this.qw.get();
        if (activity != null) {
            return activity.findViewById(i2);
        }
        return null;
    }

    public abstract ViewGroup fe();

    public void qw() {
        this.qw.clear();
        ad();
    }

    public abstract void rg();

    public void th(Activity activity) {
        new EditModeLayout(activity, fe(), this.f7814de);
    }

    public qw(Activity activity, View view, @IdRes int i2) {
        this.f7814de = Boolean.FALSE;
        this.qw = new WeakReference<>(activity);
        this.f7813ad = view;
        rg();
        th(activity);
    }
}
