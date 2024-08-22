package com.mars.united.core.os.bluetooth;

import com.mars.united.core.os.bluetooth.vo.BluetoothInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/mars/united/core/os/bluetooth/vo/BluetoothInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class BluetoothBLEObservable$Companion$getInstance$1 extends Lambda implements Function1<BluetoothInfo, String> {
    public static final BluetoothBLEObservable$Companion$getInstance$1 INSTANCE = new BluetoothBLEObservable$Companion$getInstance$1();

    public BluetoothBLEObservable$Companion$getInstance$1() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull BluetoothInfo bluetoothInfo) {
        Intrinsics.checkNotNullParameter(bluetoothInfo, "it");
        return bluetoothInfo.getDeviceName();
    }
}
