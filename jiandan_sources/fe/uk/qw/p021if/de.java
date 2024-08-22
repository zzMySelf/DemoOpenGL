package fe.uk.qw.p021if;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.manager.ConnectivityMonitor;
import fe.uk.qw.vvv.i;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

/* renamed from: fe.uk.qw.if.de  reason: invalid package */
public final class de implements ConnectivityMonitor {

    /* renamed from: ad  reason: collision with root package name */
    public final Context f5641ad;

    /* renamed from: i  reason: collision with root package name */
    public final BroadcastReceiver f5642i = new qw();

    /* renamed from: th  reason: collision with root package name */
    public final ConnectivityMonitor.ConnectivityListener f5643th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f5644uk;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f5645yj;

    /* renamed from: fe.uk.qw.if.de$qw */
    public class qw extends BroadcastReceiver {
        public qw() {
        }

        public void onReceive(@NonNull Context context, Intent intent) {
            de deVar = de.this;
            boolean z = deVar.f5645yj;
            deVar.f5645yj = deVar.uk(context);
            if (z != de.this.f5645yj) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    "connectivity changed, isConnected: " + de.this.f5645yj;
                }
                de deVar2 = de.this;
                deVar2.f5643th.qw(deVar2.f5645yj);
            }
        }
    }

    public de(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f5641ad = context.getApplicationContext();
        this.f5643th = connectivityListener;
    }

    public final void i() {
        if (!this.f5644uk) {
            this.f5645yj = uk(this.f5641ad);
            try {
                this.f5641ad.registerReceiver(this.f5642i, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
                this.f5644uk = true;
            } catch (SecurityException unused) {
                boolean isLoggable = Log.isLoggable("ConnectivityMonitor", 5);
            }
        }
    }

    public final void o() {
        if (this.f5644uk) {
            this.f5641ad.unregisterReceiver(this.f5642i);
            this.f5644uk = false;
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
        i();
    }

    public void onStop() {
        o();
    }

    @SuppressLint({"MissingPermission"})
    public boolean uk(@NonNull Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        i.fe(connectivityManager);
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (RuntimeException unused) {
            boolean isLoggable = Log.isLoggable("ConnectivityMonitor", 5);
            return true;
        }
    }
}
