package com.mars.united.core.os.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.mars.united.core.os.network.NetworkObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/mars/united/core/os/network/NetworkObservable$networkTypeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NetworkObservable$networkTypeReceiver$1 extends BroadcastReceiver {
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            boolean z2 = false;
            if (activeNetworkInfo == null) {
                z = false;
            } else {
                z = activeNetworkInfo.isAvailable();
            }
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                z2 = true;
            }
            for (NetworkObservable.IObserver qw : NetworkObservable.qw) {
                qw.qw(z, z2);
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
}
