package com.mars.united.core.os.bluetooth;

import com.mars.united.core.os.bluetooth.vo.BluetoothInfo;
import fe.ggg.ad.qw.de.fe.rg.qw;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "bluetoothInfo", "Lcom/mars/united/core/os/bluetooth/vo/BluetoothInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class BluetoothCompatObservable$callback$1 extends Lambda implements Function1<BluetoothInfo, Unit> {
    public final /* synthetic */ BluetoothCompatObservable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BluetoothCompatObservable$callback$1(BluetoothCompatObservable bluetoothCompatObservable) {
        super(1);
        this.this$0 = bluetoothCompatObservable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BluetoothInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BluetoothInfo bluetoothInfo) {
        Intrinsics.checkNotNullParameter(bluetoothInfo, "bluetoothInfo");
        if (bluetoothInfo.getRssi() > this.this$0.f6568i) {
            this.this$0.ppp.put(this.this$0.f6572uk.invoke(bluetoothInfo), bluetoothInfo);
            List<BluetoothInfo> uk2 = this.this$0.uk();
            for (Map.Entry value : this.this$0.when.entrySet()) {
                ((qw) value.getValue()).ad().invoke(uk2);
            }
        }
    }
}
