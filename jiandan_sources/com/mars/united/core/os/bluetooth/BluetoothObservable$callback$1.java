package com.mars.united.core.os.bluetooth;

import android.bluetooth.BluetoothDevice;
import com.alipay.sdk.m.p.e;
import com.mars.united.core.os.bluetooth.vo.BluetoothInfo;
import fe.ggg.ad.qw.de.fe.rg.qw;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "rssi", "", "device", "Landroid/bluetooth/BluetoothDevice;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class BluetoothObservable$callback$1 extends Lambda implements Function2<Integer, BluetoothDevice, Unit> {
    public final /* synthetic */ BluetoothObservable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BluetoothObservable$callback$1(BluetoothObservable bluetoothObservable) {
        super(2);
        this.this$0 = bluetoothObservable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (BluetoothDevice) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i2, @NotNull BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, e.p);
        String name = bluetoothDevice.getName();
        if (!(name == null || name.length() == 0)) {
            Intrinsics.checkNotNullExpressionValue(name, "deviceName");
            BluetoothInfo bluetoothInfo = new BluetoothInfo(name, i2, System.currentTimeMillis());
            this.this$0.f6584o.put(this.this$0.f6588yj.invoke(bluetoothInfo), bluetoothInfo);
            HashMap access$getObserverList$p = this.this$0.f6583i;
            BluetoothObservable bluetoothObservable = this.this$0;
            for (Map.Entry value : access$getObserverList$p.entrySet()) {
                ((qw) value.getValue()).ad().invoke(bluetoothObservable.getCurrentBluetoothInfoList());
            }
        }
    }
}
