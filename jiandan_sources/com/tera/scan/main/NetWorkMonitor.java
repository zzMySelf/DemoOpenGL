package com.tera.scan.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import fe.mmm.qw.ppp.ad.qw.qw;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u000b"}, d2 = {"Lcom/tera/scan/main/NetWorkMonitor;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "p1", "Landroid/content/Intent;", "registerMonitor", "unregisterMonitor", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetWorkMonitor extends BroadcastReceiver {
    public final void ad(@Nullable Context context) {
        if (context != null) {
            context.unregisterReceiver(this);
        }
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (context != null && qw.ad(context)) {
            TradeAccount.ggg(TradeAccount.f913rg, (Function0) null, 1, (Object) null);
        }
    }

    public final void qw(@Nullable Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
        if (context != null) {
            context.registerReceiver(this, intentFilter);
        }
    }
}
