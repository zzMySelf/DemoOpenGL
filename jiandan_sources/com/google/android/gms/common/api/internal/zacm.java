package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zar;

public final class zacm extends zar {
    public final /* synthetic */ zack zaky;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zacm(zack zack, Looper looper) {
        super(looper);
        this.zaky = zack;
    }

    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            PendingResult pendingResult = (PendingResult) message.obj;
            synchronized (this.zaky.zadp) {
                if (pendingResult == null) {
                    this.zaky.zaks.zad(new Status(13, "Transform returned null"));
                } else if (pendingResult instanceof zacc) {
                    this.zaky.zaks.zad(((zacc) pendingResult).getStatus());
                } else {
                    this.zaky.zaks.zaa(pendingResult);
                }
            }
        } else if (i2 != 1) {
            StringBuilder sb = new StringBuilder(70);
            sb.append("TransformationResultHandler received unknown message type: ");
            sb.append(i2);
            sb.toString();
        } else {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String valueOf = String.valueOf(runtimeException.getMessage());
            if (valueOf.length() != 0) {
                "Runtime exception on the transformation worker thread: ".concat(valueOf);
            } else {
                new String("Runtime exception on the transformation worker thread: ");
            }
            throw runtimeException;
        }
    }
}
