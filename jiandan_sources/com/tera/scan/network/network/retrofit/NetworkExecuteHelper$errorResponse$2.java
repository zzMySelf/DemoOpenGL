package com.tera.scan.network.network.retrofit;

import fe.mmm.qw.nn.de.pf.qw;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tera/scan/network/network/response/BaseResponse;", "T", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NetworkExecuteHelper$errorResponse$2 extends Lambda implements Function0<qw<T>> {
    public static final NetworkExecuteHelper$errorResponse$2 INSTANCE = new NetworkExecuteHelper$errorResponse$2();

    public NetworkExecuteHelper$errorResponse$2() {
        super(0);
    }

    @NotNull
    public final qw<T> invoke() {
        qw<T> qwVar = new qw<>();
        qwVar.errno = -1;
        return qwVar;
    }
}
