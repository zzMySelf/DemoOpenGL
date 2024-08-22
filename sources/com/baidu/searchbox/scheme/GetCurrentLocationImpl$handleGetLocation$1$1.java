package com.baidu.searchbox.scheme;

import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.location.BoxLocationManager;
import com.baidu.searchbox.location.LocationInfo;
import com.baidu.searchbox.location.LocationListener;
import com.baidu.searchbox.location.util.LocationUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/scheme/GetCurrentLocationImpl$handleGetLocation$1$1", "Lcom/baidu/searchbox/location/LocationListener;", "onError", "", "errCode", "", "onReceiveLocation", "locationInfo", "Lcom/baidu/searchbox/location/LocationInfo;", "lib-location-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GetCurrentLocationImpl.kt */
public final class GetCurrentLocationImpl$handleGetLocation$1$1 implements LocationListener {
    final /* synthetic */ String $callback;
    final /* synthetic */ String $coorType;
    final /* synthetic */ BoxLocationManager $lm;
    final /* synthetic */ WeakReference<BdSailorWebView> $webView;

    GetCurrentLocationImpl$handleGetLocation$1$1(BoxLocationManager $lm2, String $coorType2, String $callback2, WeakReference<BdSailorWebView> $webView2) {
        this.$lm = $lm2;
        this.$coorType = $coorType2;
        this.$callback = $callback2;
        this.$webView = $webView2;
    }

    public void onReceiveLocation(LocationInfo locationInfo) {
        try {
            this.$lm.removeLocationListener(this);
            LocationInfo localInfo = LocationUtils.transformLocationInfoCoorType(locationInfo, this.$coorType);
            GetCurrentLocationImpl getCurrentLocationImpl = GetCurrentLocationImpl.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(localInfo, "localInfo");
            JSONObject info = getCurrentLocationImpl.getCardLocationJson(localInfo);
            boolean z = false;
            info.put("st", 0);
            if (this.$callback.length() > 0) {
                z = true;
            }
            if (z) {
                GetCurrentLocationImpl getCurrentLocationImpl2 = GetCurrentLocationImpl.INSTANCE;
                WeakReference<BdSailorWebView> weakReference = this.$webView;
                getCurrentLocationImpl2.notifyCallback(weakReference != null ? (BdSailorWebView) weakReference.get() : null, this.$callback, new StringBuilder().append('\'').append(info).append('\'').toString());
            }
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    public void onError(int errCode) {
        try {
            JSONObject info = new JSONObject();
            info.put("st", errCode);
            if (this.$callback.length() > 0) {
                GetCurrentLocationImpl getCurrentLocationImpl = GetCurrentLocationImpl.INSTANCE;
                WeakReference<BdSailorWebView> weakReference = this.$webView;
                getCurrentLocationImpl.notifyCallback(weakReference != null ? (BdSailorWebView) weakReference.get() : null, this.$callback, new StringBuilder().append('\'').append(info).append('\'').toString());
            }
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }
}
