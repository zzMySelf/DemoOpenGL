package fe.rg.qw.pf;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor;
import fe.rg.qw.ggg.uk;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

public final class de implements ConnectivityMonitor {

    /* renamed from: ad  reason: collision with root package name */
    public final Context f5010ad;

    /* renamed from: i  reason: collision with root package name */
    public final BroadcastReceiver f5011i = new qw();

    /* renamed from: th  reason: collision with root package name */
    public final ConnectivityMonitor.ConnectivityListener f5012th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f5013uk;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f5014yj;

    public class qw extends BroadcastReceiver {
        public qw() {
        }

        public void onReceive(@NonNull Context context, Intent intent) {
            de deVar = de.this;
            boolean z = deVar.f5014yj;
            deVar.f5014yj = deVar.uk(context);
            if (z != de.this.f5014yj) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    "connectivity changed, isConnected: " + de.this.f5014yj;
                }
                de deVar2 = de.this;
                deVar2.f5012th.qw(deVar2.f5014yj);
            }
        }
    }

    public de(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f5010ad = context.getApplicationContext();
        this.f5012th = connectivityListener;
    }

    public final void i() {
        if (!this.f5013uk) {
            this.f5014yj = uk(this.f5010ad);
            try {
                this.f5010ad.registerReceiver(this.f5011i, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
                this.f5013uk = true;
            } catch (SecurityException unused) {
                boolean isLoggable = Log.isLoggable("ConnectivityMonitor", 5);
            }
        }
    }

    public final void o() {
        if (this.f5013uk) {
            this.f5010ad.unregisterReceiver(this.f5011i);
            this.f5013uk = false;
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
        uk.fe(connectivityManager);
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
