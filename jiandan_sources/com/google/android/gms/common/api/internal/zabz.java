package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zabz extends UnregisterListenerMethod<A, L> {
    public final /* synthetic */ RegistrationMethods.Builder zakk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zabz(RegistrationMethods.Builder builder, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
        this.zakk = builder;
    }

    public final void unregisterListener(A a, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException {
        this.zakk.zakf.accept(a, taskCompletionSource);
    }
}
