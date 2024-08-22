package com.baidu.wallet.core;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class FragmentResultReceiver extends ResultReceiver {
    public a a;

    public interface a {
        void onReceiveResult(int i2, Bundle bundle);
    }

    public FragmentResultReceiver(Handler handler) {
        super(handler);
    }

    public void a() {
        this.a = null;
    }

    public void onReceiveResult(int i2, Bundle bundle) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onReceiveResult(i2, bundle);
        }
    }

    public void a(a aVar) {
        this.a = aVar;
    }
}
