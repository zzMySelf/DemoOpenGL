package fe.uk.qw.p021if;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.dxmbumptech.glide.manager.ConnectivityMonitor;
import com.dxmbumptech.glide.manager.ConnectivityMonitorFactory;

/* renamed from: fe.uk.qw.if.fe  reason: invalid package */
public class fe implements ConnectivityMonitorFactory {
    @NonNull
    public ConnectivityMonitor qw(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        boolean z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        boolean isLoggable = Log.isLoggable("ConnectivityMonitor", 3);
        if (z) {
            return new de(context, connectivityListener);
        }
        return new o();
    }
}
