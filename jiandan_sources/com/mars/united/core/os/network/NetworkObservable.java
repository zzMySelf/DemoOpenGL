package com.mars.united.core.os.network;

import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mars/united/core/os/network/NetworkObservable;", "", "()V", "isRegister", "", "networkTypeReceiver", "com/mars/united/core/os/network/NetworkObservable$networkTypeReceiver$1", "Lcom/mars/united/core/os/network/NetworkObservable$networkTypeReceiver$1;", "observers", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/mars/united/core/os/network/NetworkObservable$IObserver;", "addObserver", "", "context", "Landroid/content/Context;", "observer", "observeNetworkType", "removeNetworkTypeObserver", "removeObserver", "IObserver", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NetworkObservable {
    @NotNull
    public static final ConcurrentLinkedDeque<IObserver> qw = new ConcurrentLinkedDeque<>();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/mars/united/core/os/network/NetworkObservable$IObserver;", "", "onChanged", "", "isAvailable", "", "isWifi", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface IObserver {
        void qw(boolean z, boolean z2);
    }

    static {
        new NetworkObservable$networkTypeReceiver$1();
    }
}
