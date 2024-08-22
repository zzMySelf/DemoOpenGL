package com.baidu.swan.apps.impl.swancard.adapter;

import com.baidu.swan.apps.ioc.interfaces.ISwanAppLocation;
import com.baidu.swan.apps.scheme.actions.location.LocationResult;
import com.baidu.swan.card.ioc.interfaces.location.CardLocationResult;
import com.baidu.swan.card.ioc.interfaces.location.ISwanCardLocation;

public class SwanCardLocationAdapter implements ISwanCardLocation {
    private final ISwanAppLocation mSwanAppLocation;

    public SwanCardLocationAdapter(ISwanAppLocation swanAppLocation) {
        this.mSwanAppLocation = swanAppLocation;
    }

    public void requestLocation(String coorType, boolean useCache, boolean openGPS, ISwanCardLocation.CardLocationListener cardLocationListener) {
        this.mSwanAppLocation.requestLocation(coorType, useCache, openGPS, toLocationListener(cardLocationListener));
    }

    public CardLocationResult getCachedLocation() {
        return toCardLocationResult(this.mSwanAppLocation.getCachedLocation());
    }

    public void warmUp() {
        this.mSwanAppLocation.warmUp();
    }

    public double[] convertCoorType(CardLocationResult cardLocationResult, String toType) {
        return this.mSwanAppLocation.convertCoorType(toLocationResult(cardLocationResult), toType);
    }

    public void startLocationUpdate(ISwanCardLocation.CardLocationListener cardLocationListener) {
        this.mSwanAppLocation.startLocationUpdate(toLocationListener(cardLocationListener));
    }

    public void stopLocationUpdate() {
        this.mSwanAppLocation.stopLocationUpdate();
    }

    public void resumeLocationUpdate() {
        this.mSwanAppLocation.resumeLocationUpdate();
    }

    public void pauseLocationUpdate() {
        this.mSwanAppLocation.pauseLocationUpdate();
    }

    /* access modifiers changed from: private */
    public CardLocationResult toCardLocationResult(LocationResult locationResult) {
        LocationResult locationResult2 = locationResult;
        if (locationResult2 == null) {
            return null;
        }
        CardLocationResult cardLocationResult = r2;
        CardLocationResult cardLocationResult2 = new CardLocationResult(locationResult2.coorType, locationResult2.longitude, locationResult2.latitude, locationResult2.speed, locationResult2.accuracy, locationResult2.altitude, locationResult2.country, locationResult2.countryCode, locationResult2.city, locationResult2.cityCode, locationResult2.province, locationResult2.district, locationResult2.street, locationResult2.streetNumber, locationResult2.isFullAccuracy);
        return cardLocationResult;
    }

    private LocationResult toLocationResult(CardLocationResult cardLocationResult) {
        CardLocationResult cardLocationResult2 = cardLocationResult;
        if (cardLocationResult2 == null) {
            return null;
        }
        LocationResult locationResult = r2;
        LocationResult locationResult2 = new LocationResult(cardLocationResult2.coorType, cardLocationResult2.longitude, cardLocationResult2.latitude, cardLocationResult2.speed, cardLocationResult2.accuracy, cardLocationResult2.altitude, cardLocationResult2.country, cardLocationResult2.countryCode, cardLocationResult2.city, cardLocationResult2.cityCode, cardLocationResult2.province, cardLocationResult2.district, cardLocationResult2.street, cardLocationResult2.streetNumber, cardLocationResult2.isFullAccuracy);
        return locationResult;
    }

    private ISwanAppLocation.LocationListener toLocationListener(final ISwanCardLocation.CardLocationListener cardLocationListener) {
        if (cardLocationListener == null) {
            return null;
        }
        return new ISwanAppLocation.LocationListener() {
            public void onSuccess(LocationResult result) {
                cardLocationListener.onSuccess(SwanCardLocationAdapter.this.toCardLocationResult(result));
            }

            public void onFailed(int errCode) {
                cardLocationListener.onFailed(errCode);
            }
        };
    }
}
