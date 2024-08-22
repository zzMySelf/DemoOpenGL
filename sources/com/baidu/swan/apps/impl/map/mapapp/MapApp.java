package com.baidu.swan.apps.impl.map.mapapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.impl.map.data.MapStatisticEvent;
import com.baidu.swan.apps.util.SwanAppUtils;

public abstract class MapApp {
    protected boolean installIfNotExist = false;
    protected String mId;
    protected String mName;
    protected String mPkg;

    /* access modifiers changed from: protected */
    public abstract void launchApp(Context context, LatLng latLng, LatLng latLng2, String str, String str2);

    /* access modifiers changed from: protected */
    public abstract void launchApp(Context context, LatLng latLng, LatLng latLng2, String str, String str2, NaviPreference naviPreference);

    MapApp(String id, String name, String pkg) {
        this.mId = id;
        this.mName = name;
        this.mPkg = pkg;
    }

    public boolean installed(Context context) {
        return SwanAppUtils.getPackageInfo(context.getApplicationContext(), this.mPkg) != null;
    }

    public boolean installIfNotExist() {
        return this.installIfNotExist;
    }

    public String getName() {
        return this.mName;
    }

    public void launch(Context context, LatLng startPos, LatLng endPos, String startAddr, String endAddr, NaviPreference naviPreference) {
        if (!installed(context) && this.installIfNotExist) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.mPkg));
            intent.addFlags(268435456);
            context.startActivity(intent);
            if (this instanceof BaiduMapApp) {
                MapStatisticEvent.INSTANCE.doUbcReport("click", MapStatisticEvent.VALUE_ROUTE_ACTIONSHEET, MapStatisticEvent.EXT_VAL_BAIDU_DOWNLOAD);
            }
        } else if (naviPreference == null) {
            launchApp(context, startPos, endPos, startAddr, endAddr);
        } else {
            launchApp(context, startPos, endPos, startAddr, endAddr, naviPreference);
        }
    }
}
