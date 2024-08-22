package com.sdk.y;

import android.net.ConnectivityManager;
import android.net.Network;
import com.sdk.a.e;
import com.sdk.x.a;
import java.net.HttpURLConnection;
import java.util.List;

public class b extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ f b;

    public b(f fVar, int i2) {
        this.b = fVar;
        this.a = i2;
    }

    public void onAvailable(Network network) {
        if (network != null) {
            try {
                f fVar = this.b;
                HttpURLConnection unused = fVar.k = (HttpURLConnection) network.openConnection(fVar.f6818i);
            } catch (Exception e) {
                String str = f.a;
                "onAvailable: " + e;
                return;
            }
        }
        List a2 = this.b.a();
        a aVar = new a();
        f fVar2 = this.b;
        e unused2 = fVar2.g = aVar.a(fVar2.e, this.a, a2, new a(this));
    }
}
