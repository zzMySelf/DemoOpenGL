package com.unionpay.b;

import android.util.Log;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.mi.UPTsmAddon;
import com.unionpay.utils.j;

final class i implements UPTsmAddon.UPTsmConnectionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f6118a;

    i(g gVar) {
        this.f6118a = gVar;
    }

    public final void onTsmConnected() {
        j.c("uppay", "mi TsmService connected.");
        this.f6118a.b();
    }

    public final void onTsmDisconnected() {
        Log.e("uppay", "mi TsmService disconnected.");
        g gVar = this.f6118a;
        gVar.a(gVar.f6110d, this.f6118a.f6111e, UPSEInfoResp.ERROR_NONE, "Tsm service disconnect");
    }
}
