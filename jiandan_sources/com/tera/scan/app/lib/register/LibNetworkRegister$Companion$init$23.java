package com.tera.scan.app.lib.register;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.mars.kotlin.service.Extra;
import com.tera.scan.network.network.exception.RemoteException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "e", "Lcom/tera/scan/network/network/exception/RemoteException;", "receiver", "Landroid/os/ResultReceiver;", "extraData", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LibNetworkRegister$Companion$init$23 extends Lambda implements Function3<RemoteException, ResultReceiver, Bundle, Unit> {
    public static final LibNetworkRegister$Companion$init$23 INSTANCE = new LibNetworkRegister$Companion$init$23();

    public LibNetworkRegister$Companion$init$23() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RemoteException) obj, (ResultReceiver) obj2, (Bundle) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RemoteException remoteException, @Nullable ResultReceiver resultReceiver, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(remoteException, "e");
        if (resultReceiver != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (remoteException.getErrorInfo() != null) {
                bundle.putParcelable("com.mars.ERROR_INFO", remoteException.getErrorInfo());
            }
            bundle.putInt(Extra.ERROR, remoteException.getErrorCode());
            bundle.putString("com.mars.error_message", remoteException.getServerErrorMessage());
            bundle.putString(Extra.ERROR_SERVER_MESSAGE, remoteException.getServerAlertMessage());
            bundle.putInt("com.mars.server_prompt_type", remoteException.getmPromptType());
            resultReceiver.send(2, bundle);
        }
    }
}
