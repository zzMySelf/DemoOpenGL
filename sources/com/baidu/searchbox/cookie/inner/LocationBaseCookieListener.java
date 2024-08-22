package com.baidu.searchbox.cookie.inner;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.location.LocationInfo;
import com.baidu.searchbox.location.LocationListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/cookie/inner/LocationBaseCookieListener;", "Lcom/baidu/searchbox/location/LocationListener;", "()V", "onError", "", "errCode", "", "reSetCookie", "locationInfo", "Lcom/baidu/searchbox/location/LocationInfo;", "isForceUpdateSync", "", "Companion", "lib-location-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationBaseCookieListener.kt */
public abstract class LocationBaseCookieListener implements LocationListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    protected static final String TAG = "LocationCookieManager";

    public abstract void reSetCookie(LocationInfo locationInfo, boolean z);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/cookie/inner/LocationBaseCookieListener$Companion;", "", "()V", "TAG", "", "lib-location-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LocationBaseCookieListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onError(int errCode) {
        if (AppConfig.isDebug()) {
            Log.d("LocationCookieManager", "onError");
        }
    }
}
