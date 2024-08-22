package com.baidu.swan.apps.impl.map.mapapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.impl.R;
import com.baidu.swan.apps.impl.map.data.MapStatisticEvent;

public class GaodeMapApp extends MapApp {
    public static final String ID = "GaodeMap";
    private static final String PKG_GAODE_MAP = "com.autonavi.minimap";

    public GaodeMapApp(Context context) {
        super(ID, context.getString(R.string.openlocation_bottommenu_gaodemap), PKG_GAODE_MAP);
    }

    public void launchApp(Context context, LatLng startPos, LatLng endPos, String startAddr, String endAddr) {
        if (startPos != null && endPos != null) {
            Uri.Builder builder = Uri.parse("androidamap://route?").buildUpon();
            builder.appendQueryParameter("sourceApplication", context.getPackageName());
            builder.appendQueryParameter("slat", String.valueOf(startPos.latitude));
            builder.appendQueryParameter("slon", String.valueOf(startPos.longitude));
            builder.appendQueryParameter("sname", startAddr);
            builder.appendQueryParameter("dlat", String.valueOf(endPos.latitude));
            builder.appendQueryParameter("dlon", String.valueOf(endPos.longitude));
            builder.appendQueryParameter("dname", endAddr);
            builder.appendQueryParameter("dev", "0");
            builder.appendQueryParameter("t", "0");
            Intent intent = new Intent("android.intent.action.VIEW", builder.build());
            intent.setPackage(PKG_GAODE_MAP);
            context.startActivity(intent);
            MapStatisticEvent.INSTANCE.doUbcReport("click", MapStatisticEvent.VALUE_ROUTE_ACTIONSHEET, MapStatisticEvent.EXT_VAL_GAODE);
        }
    }

    /* access modifiers changed from: protected */
    public void launchApp(Context context, LatLng startPos, LatLng endPos, String startAddr, String endAddr, NaviPreference naviPreference) {
        launchApp(context, startPos, endPos, startAddr, endAddr);
    }
}
