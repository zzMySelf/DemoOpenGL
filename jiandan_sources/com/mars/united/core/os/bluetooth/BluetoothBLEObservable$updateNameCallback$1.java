package com.mars.united.core.os.bluetooth;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "result", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class BluetoothBLEObservable$updateNameCallback$1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ BluetoothBLEObservable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BluetoothBLEObservable$updateNameCallback$1(BluetoothBLEObservable bluetoothBLEObservable) {
        super(1);
        this.this$0 = bluetoothBLEObservable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            this.this$0.th();
            BluetoothBLEObservable bluetoothBLEObservable = this.this$0;
            bluetoothBLEObservable.fe(bluetoothBLEObservable.f6560ad);
        }
    }
}
