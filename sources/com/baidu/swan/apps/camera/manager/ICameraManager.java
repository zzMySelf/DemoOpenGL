package com.baidu.swan.apps.camera.manager;

import android.content.Context;
import com.baidu.swan.apps.camera.listener.CameraTimeOutListener;

public interface ICameraManager {
    void cancelTimer();

    boolean hasCameraPermission(Context context);

    boolean hasRecordPermission(Context context);

    void onExceptionError(String str, String str2, boolean z);

    void onSwanAppForegroundChange(boolean z);

    boolean saveImage(byte[] bArr, String str, int i2, int i3, boolean z);

    void startTimer(int i2, CameraTimeOutListener cameraTimeOutListener);

    void stopTimer();
}
