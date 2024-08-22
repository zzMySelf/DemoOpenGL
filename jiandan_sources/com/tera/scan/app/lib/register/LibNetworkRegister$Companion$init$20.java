package com.tera.scan.app.lib.register;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.mars.kotlin.service.Extra;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "available", "", "receiver", "Landroid/os/ResultReceiver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LibNetworkRegister$Companion$init$20 extends Lambda implements Function2<Boolean, ResultReceiver, Unit> {
    public static final LibNetworkRegister$Companion$init$20 INSTANCE = new LibNetworkRegister$Companion$init$20();

    public LibNetworkRegister$Companion$init$20() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), (ResultReceiver) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, @NotNull ResultReceiver resultReceiver) {
        Intrinsics.checkNotNullParameter(resultReceiver, "receiver");
        if (!z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(Extra.ERROR_NETWORK, true);
            resultReceiver.send(2, bundle);
        }
    }
}
