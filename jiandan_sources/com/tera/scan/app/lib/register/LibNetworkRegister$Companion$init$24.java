package com.tera.scan.app.lib.register;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.mars.kotlin.service.Extra;
import com.tera.scan.network.network.NetworkDetailException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "e", "Lcom/tera/scan/network/network/NetworkDetailException;", "receiver", "Landroid/os/ResultReceiver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LibNetworkRegister$Companion$init$24 extends Lambda implements Function2<NetworkDetailException, ResultReceiver, Unit> {
    public static final LibNetworkRegister$Companion$init$24 INSTANCE = new LibNetworkRegister$Companion$init$24();

    public LibNetworkRegister$Companion$init$24() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((NetworkDetailException) obj, (ResultReceiver) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable NetworkDetailException networkDetailException, @NotNull ResultReceiver resultReceiver) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(resultReceiver, "receiver");
        if (networkDetailException != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(Extra.ERROR, networkDetailException.getType());
            bundle.putString("com.mars.error_message", networkDetailException.getExpMessage() != null ? networkDetailException.getExpMessage() : "has no exception message");
            bundle.putInt("com.mars.error_status_code", networkDetailException.getStatusCode());
            Exception expCause = networkDetailException.getExpCause();
            bundle.putString("com.mars.error_exception_name", (expCause == null || (cls = expCause.getClass()) == null) ? null : cls.getName());
            resultReceiver.send(2, bundle);
        }
    }
}
