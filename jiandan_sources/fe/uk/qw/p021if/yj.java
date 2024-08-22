package fe.uk.qw.p021if;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(26)
/* renamed from: fe.uk.qw.if.yj  reason: invalid package */
public final class yj implements i, ComponentCallbacks2 {
    public void onConfigurationChanged(@NonNull Configuration configuration) {
    }

    public void onLowMemory() {
        onTrimMemory(20);
    }

    public void onTrimMemory(int i2) {
    }

    public void qw(Activity activity) {
    }
}
