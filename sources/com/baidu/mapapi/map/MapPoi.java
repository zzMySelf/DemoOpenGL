package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.game.ad.interfaces.IGdtAdRequestParameter;
import org.json.JSONObject;

public final class MapPoi {

    /* renamed from: a  reason: collision with root package name */
    String f14215a;

    /* renamed from: b  reason: collision with root package name */
    LatLng f14216b;

    /* renamed from: c  reason: collision with root package name */
    String f14217c;

    /* access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        String optString = jSONObject.optString("tx");
        this.f14215a = optString;
        if (optString != null && !optString.equals("")) {
            this.f14215a = this.f14215a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.f14216b = CoordUtil.decodeNodeLocation(jSONObject.optString(IGdtAdRequestParameter.DEVICE_GEO));
        this.f14217c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.f14215a;
    }

    public LatLng getPosition() {
        return this.f14216b;
    }

    public String getUid() {
        return this.f14217c;
    }
}
