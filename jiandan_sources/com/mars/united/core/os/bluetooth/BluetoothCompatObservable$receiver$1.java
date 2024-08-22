package com.mars.united.core.os.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.united.core.os.bluetooth.vo.BluetoothInfo;
import fe.ggg.ad.qw.ad.ad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/mars/united/core/os/bluetooth/BluetoothCompatObservable$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BluetoothCompatObservable$receiver$1 extends BroadcastReceiver {
    public final /* synthetic */ BluetoothCompatObservable qw;

    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1780914469) {
                if (hashCode == 1167529923 && action.equals("android.bluetooth.device.action.FOUND")) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", 0);
                    if (bluetoothDevice == null) {
                        str = null;
                    } else {
                        str = bluetoothDevice.getName();
                    }
                    if (shortExtra != 0 && str != null) {
                        Function1 fe2 = this.qw.f262if;
                        BluetoothInfo bluetoothInfo = new BluetoothInfo(str, shortExtra, System.currentTimeMillis());
                        if (Logger.INSTANCE.getEnable()) {
                            LoggerKt.d$default(ad.qw(Intrinsics.stringPlus("broadcast ", bluetoothInfo)), (Object) null, 1, (Object) null);
                        }
                        Unit unit = Unit.INSTANCE;
                        fe2.invoke(bluetoothInfo);
                    }
                }
            } else if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                this.qw.i();
                this.qw.f6573yj.startDiscovery();
            }
        }
    }
}
