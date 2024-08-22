package com.baidu.swan.card.ioc.interfaces.location;

public interface ISwanCardLocation {

    public interface CardLocationListener {
        void onFailed(int i2);

        void onSuccess(CardLocationResult cardLocationResult);
    }

    double[] convertCoorType(CardLocationResult cardLocationResult, String str);

    CardLocationResult getCachedLocation();

    void pauseLocationUpdate();

    void requestLocation(String str, boolean z, boolean z2, CardLocationListener cardLocationListener);

    void resumeLocationUpdate();

    void startLocationUpdate(CardLocationListener cardLocationListener);

    void stopLocationUpdate();

    void warmUp();
}
