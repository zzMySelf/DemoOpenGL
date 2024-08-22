package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.b;
import com.baidu.platform.comapi.pano.c;

class a implements b.a<c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14724a;

    a(Context context) {
        this.f14724a = context;
    }

    public void a(HttpClient.HttpStateError httpStateError) {
        String str;
        int i2 = b.f14726b[httpStateError.ordinal()];
        if (i2 == 1) {
            str = "current network is not available";
        } else if (i2 == 2) {
            str = "network inner error, please check network";
        } else {
            return;
        }
        Log.d("baidumapsdk", str);
    }

    public void a(c cVar) {
        String str;
        if (cVar == null) {
            Log.d("baidumapsdk", "pano info is null");
            return;
        }
        switch (b.f14725a[cVar.a().ordinal()]) {
            case 1:
                str = "pano uid is error, please check param poi uid";
                break;
            case 2:
                str = "pano id not found for this poi point";
                break;
            case 3:
                str = "please check ak for permission";
                break;
            case 4:
                if (cVar.c() != 1) {
                    str = "this point do not support for pano show";
                    break;
                } else {
                    try {
                        BaiduMapPoiSearch.b(cVar.b(), this.f14724a);
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            default:
                return;
        }
        Log.d("baidumapsdk", str);
    }
}
