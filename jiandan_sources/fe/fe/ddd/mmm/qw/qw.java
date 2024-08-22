package fe.fe.ddd.mmm.qw;

import android.app.Activity;
import com.baidu.searchbox.track.ui.ITraceFragmentCallback;

public abstract class qw implements ITraceFragmentCallback {
    public void ad(Object obj, boolean z, Activity activity) {
        if (z) {
            yj.rg().uk(activity, (String) null, obj, "onResumed");
        }
    }

    public void qw(Object obj, boolean z, Activity activity) {
        if (z) {
            yj.rg().uk(activity, (String) null, obj, "onCreated");
        }
    }
}
