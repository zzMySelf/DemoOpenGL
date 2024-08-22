package com.baidu.mapframework.location;

import android.os.Handler;
import android.os.Looper;
import com.baidu.searchbox.location.LocationManager;
import java.util.Iterator;
import java.util.LinkedList;

public class LocationManager {
    private static LocationManager mInstance;
    /* access modifiers changed from: private */
    public volatile LocationManager.LocationInfo currentLocation;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean isLocal = false;
    private LinkedList<LocationCallback> locationCallbacks = new LinkedList<>();
    private volatile LocationManager.LocationListener locationListener = new LocationManager.LocationListener() {
        public void onReceiveLocation(LocationManager.LocationInfo locationInfo) {
            if (locationInfo != null) {
                LocationManager.this.currentLocation = locationInfo;
            }
            LocationManager.this.notifyLocation();
        }

        public void onError(int i2) {
            LocationManager.this.notifyLocation();
        }
    };
    private LocationManagerWrapper locationManagerWrapper;

    public interface LocationCallback {
        void onLocation(LocationManager.LocationInfo locationInfo);
    }

    public static LocationManager getInstance() {
        if (mInstance == null) {
            mInstance = new LocationManager();
        }
        return mInstance;
    }

    private LocationManager() {
        LocationManagerWrapper locationManagerWrapper2 = new LocationManagerWrapper();
        this.locationManagerWrapper = locationManagerWrapper2;
        locationManagerWrapper2.addLocationListener(this.locationListener);
    }

    public LocationManager.LocationInfo getLocationInfo() {
        if (this.isLocal) {
            return new LocalLocationManagerWrapper().getDefaultLocationInfo();
        }
        return (LocationManager.LocationInfo) this.locationManagerWrapper.getLocationInfo().get(new LocationManager.LocationInfo());
    }

    /* access modifiers changed from: private */
    public synchronized void notifyLocation() {
        Iterator it = this.locationCallbacks.iterator();
        while (it.hasNext()) {
            final LocationCallback callback = (LocationCallback) it.next();
            if (callback != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        callback.onLocation(LocationManager.this.currentLocation);
                    }
                });
            }
        }
        this.locationCallbacks.clear();
    }
}
