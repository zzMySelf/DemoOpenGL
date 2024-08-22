package com.mars.united.core.os.bluetooth;

import androidx.fragment.app.FragmentActivity;
import fe.ggg.ad.qw.de.uk.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isSuccess", "", "needJumpSetting"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class BluetoothUtilKt$requestBluetoothPermission$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    public final /* synthetic */ FragmentActivity $activity;
    public final /* synthetic */ Function1<Boolean, Unit> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BluetoothUtilKt$requestBluetoothPermission$1(Function1<? super Boolean, Unit> function1, FragmentActivity fragmentActivity) {
        super(2);
        this.$result = function1;
        this.$activity = fragmentActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, boolean z2) {
        this.$result.invoke(Boolean.valueOf(z));
        if (!z && z2) {
            new qw(this.$activity).qw();
        }
    }
}
