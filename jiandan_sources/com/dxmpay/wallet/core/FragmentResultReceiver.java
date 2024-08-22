package com.dxmpay.wallet.core;

import android.os.Bundle;
import android.os.ResultReceiver;

public class FragmentResultReceiver extends ResultReceiver {
    public qw a;

    public interface qw {
        void onReceiveResult(int i2, Bundle bundle);
    }

    public void a() {
        this.a = null;
    }

    public void onReceiveResult(int i2, Bundle bundle) {
        qw qwVar = this.a;
        if (qwVar != null) {
            qwVar.onReceiveResult(i2, bundle);
        }
    }
}
