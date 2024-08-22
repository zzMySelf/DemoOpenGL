package fe.rg.qw.pf;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;

public class fe implements ConnectivityMonitorFactory {
    @NonNull
    public ConnectivityMonitor qw(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        boolean z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        boolean isLoggable = Log.isLoggable("ConnectivityMonitor", 3);
        return z ? new de(context, connectivityListener) : new th();
    }
}
