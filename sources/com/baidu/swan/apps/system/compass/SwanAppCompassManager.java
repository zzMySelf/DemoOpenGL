package com.baidu.swan.apps.system.compass;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.baidu.swan.apps.console.SwanAppLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SwanAppCompassManager {
    private static final String MODULE_TAG = "compass";
    private static final int REPORT_TIME_PERIOD = 200;
    private static final int SENSOR_STATUS_UNKNOWN = -100;
    private static final String STATUS_ACCURACY_HIGH = "high";
    private static final String STATUS_ACCURACY_LOW = "low";
    private static final String STATUS_ACCURACY_MEDIUM = "medium";
    private static final String STATUS_NO_CONTACT = "no-contact";
    private static final String STATUS_UNKNOWN = "unknow";
    private static final String STATUS_UNRELIABLE = "unreliable";
    private static final String TAG = "SwanAppCompassManager";
    private static volatile SwanAppCompassManager instance;
    private SensorEventListener mAccelerometerListener;
    private Sensor mAccelerometerSensor;
    /* access modifiers changed from: private */
    public float[] mAccelerometerValues = new float[3];
    /* access modifiers changed from: private */
    public int mAccuracy = -100;
    private ConcurrentHashMap<String, OnCompassChangeListener> mCompassChangeListenerMap;
    private Context mContext;
    private HashMap<String, Long> mIntervalMap;
    private boolean mIsStartListen = false;
    private SensorEventListener mMagneticFieldListener;
    /* access modifiers changed from: private */
    public float[] mMagneticFieldValues = new float[3];
    private Sensor mMagneticSensor;
    private SensorManager mSensorManager;

    public interface OnCompassChangeListener {
        void onCompassChange(String str, float f2, int i2);
    }

    private SwanAppCompassManager() {
    }

    public static SwanAppCompassManager getInstance() {
        if (instance == null) {
            synchronized (SwanAppCompassManager.class) {
                if (instance == null) {
                    instance = new SwanAppCompassManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void addOnCompassChangeListener(String slaveId, OnCompassChangeListener listener) {
        if (TextUtils.isEmpty(slaveId)) {
            slaveId = "master";
        }
        if (this.mCompassChangeListenerMap == null) {
            this.mCompassChangeListenerMap = new ConcurrentHashMap<>();
        }
        if (!TextUtils.isEmpty(slaveId) && listener != null) {
            this.mCompassChangeListenerMap.put(slaveId, listener);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void startListenCompass() {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.Context r0 = r4.mContext     // Catch:{ all -> 0x0064 }
            if (r0 != 0) goto L_0x000f
            java.lang.String r0 = "compass"
            java.lang.String r1 = "start error, none context"
            com.baidu.swan.apps.console.SwanAppLog.e(r0, r1)     // Catch:{ all -> 0x0064 }
            monitor-exit(r4)
            return
        L_0x000f:
            boolean r1 = r4.mIsStartListen     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x001c
            java.lang.String r0 = "compass"
            java.lang.String r1 = "has already start"
            com.baidu.swan.apps.console.SwanAppLog.w(r0, r1)     // Catch:{ all -> 0x0064 }
            monitor-exit(r4)
            return
        L_0x001c:
            java.lang.String r1 = "sensor"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x0064 }
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0     // Catch:{ all -> 0x0064 }
            r4.mSensorManager = r0     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x005a
            r1 = 1
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)     // Catch:{ all -> 0x0064 }
            r4.mAccelerometerSensor = r0     // Catch:{ all -> 0x0064 }
            android.hardware.SensorManager r0 = r4.mSensorManager     // Catch:{ all -> 0x0064 }
            r2 = 2
            android.hardware.Sensor r0 = r0.getDefaultSensor(r2)     // Catch:{ all -> 0x0064 }
            r4.mMagneticSensor = r0     // Catch:{ all -> 0x0064 }
            android.hardware.SensorManager r0 = r4.mSensorManager     // Catch:{ all -> 0x0064 }
            android.hardware.SensorEventListener r2 = r4.getAccelerometerListener()     // Catch:{ all -> 0x0064 }
            android.hardware.Sensor r3 = r4.mAccelerometerSensor     // Catch:{ all -> 0x0064 }
            r0.registerListener(r2, r3, r1)     // Catch:{ all -> 0x0064 }
            android.hardware.SensorManager r0 = r4.mSensorManager     // Catch:{ all -> 0x0064 }
            android.hardware.SensorEventListener r2 = r4.getMagneticFieldListener()     // Catch:{ all -> 0x0064 }
            android.hardware.Sensor r3 = r4.mMagneticSensor     // Catch:{ all -> 0x0064 }
            r0.registerListener(r2, r3, r1)     // Catch:{ all -> 0x0064 }
            r4.mIsStartListen = r1     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "compass"
            java.lang.String r1 = "start listen"
            com.baidu.swan.apps.console.SwanAppLog.i(r0, r1)     // Catch:{ all -> 0x0064 }
            goto L_0x0062
        L_0x005a:
            java.lang.String r0 = "compass"
            java.lang.String r1 = "none sensorManager"
            com.baidu.swan.apps.console.SwanAppLog.e(r0, r1)     // Catch:{ all -> 0x0064 }
        L_0x0062:
            monitor-exit(r4)
            return
        L_0x0064:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.system.compass.SwanAppCompassManager.startListenCompass():void");
    }

    public void stopListenCompass(String slaveId) {
        if (!reduceCompassListener(slaveId)) {
            unregisterSensorManager();
        }
    }

    private boolean reduceCompassListener(String slaveId) {
        ConcurrentHashMap<String, OnCompassChangeListener> concurrentHashMap = this.mCompassChangeListenerMap;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return false;
        }
        this.mCompassChangeListenerMap.remove(slaveId);
        if (this.mCompassChangeListenerMap.size() <= 0) {
            return false;
        }
        SwanAppLog.i(MODULE_TAG, "invoker map count = " + this.mCompassChangeListenerMap.size());
        return true;
    }

    private synchronized void unregisterSensorManager() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        if (!this.mIsStartListen) {
            SwanAppLog.w(MODULE_TAG, "has already stop");
            return;
        }
        SwanAppLog.i(MODULE_TAG, "stop listen");
        SensorEventListener sensorEventListener = this.mAccelerometerListener;
        if (!(sensorEventListener == null || (sensorManager2 = this.mSensorManager) == null)) {
            sensorManager2.unregisterListener(sensorEventListener);
            this.mAccelerometerListener = null;
        }
        SensorEventListener sensorEventListener2 = this.mMagneticFieldListener;
        if (!(sensorEventListener2 == null || (sensorManager = this.mSensorManager) == null)) {
            sensorManager.unregisterListener(sensorEventListener2);
            this.mMagneticFieldListener = null;
        }
        this.mSensorManager = null;
        this.mMagneticSensor = null;
        this.mAccelerometerSensor = null;
        this.mIsStartListen = false;
    }

    public static void release() {
        if (instance != null) {
            instance.realRelease();
        }
    }

    private synchronized void realRelease() {
        SwanAppLog.i(MODULE_TAG, "release");
        ConcurrentHashMap<String, OnCompassChangeListener> concurrentHashMap = this.mCompassChangeListenerMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.mCompassChangeListenerMap = null;
        }
        if (this.mIsStartListen) {
            unregisterSensorManager();
        }
        this.mSensorManager = null;
        this.mMagneticSensor = null;
        this.mAccelerometerSensor = null;
        this.mAccelerometerListener = null;
        this.mMagneticFieldListener = null;
        this.mContext = null;
        instance = null;
    }

    private SensorEventListener getAccelerometerListener() {
        SwanAppLog.i(MODULE_TAG, "get Accelerometer listener");
        SensorEventListener sensorEventListener = this.mAccelerometerListener;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        AnonymousClass1 r0 = new SensorEventListener() {
            public void onSensorChanged(SensorEvent event) {
                if (event == null || event.sensor == null || event.sensor.getType() != 1) {
                    SwanAppLog.w(SwanAppCompassManager.MODULE_TAG, "illegal accelerometer event");
                    return;
                }
                float[] unused = SwanAppCompassManager.this.mAccelerometerValues = event.values;
                int unused2 = SwanAppCompassManager.this.mAccuracy = event.accuracy;
                SwanAppLog.d(SwanAppCompassManager.TAG, "accelerometer changed accuracy: " + SwanAppCompassManager.this.mAccuracy);
                SwanAppCompassManager.this.handleSensorChanged();
            }

            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
        this.mAccelerometerListener = r0;
        return r0;
    }

    private SensorEventListener getMagneticFieldListener() {
        SwanAppLog.i(MODULE_TAG, "get MagneticFiled listener");
        SensorEventListener sensorEventListener = this.mMagneticFieldListener;
        if (sensorEventListener != null) {
            return sensorEventListener;
        }
        AnonymousClass2 r0 = new SensorEventListener() {
            public void onSensorChanged(SensorEvent event) {
                if (event == null || event.sensor == null || event.sensor.getType() != 2) {
                    SwanAppLog.w(SwanAppCompassManager.MODULE_TAG, "illegal magnetic filed event");
                    return;
                }
                float[] unused = SwanAppCompassManager.this.mMagneticFieldValues = event.values;
                int unused2 = SwanAppCompassManager.this.mAccuracy = event.accuracy;
                SwanAppLog.d(SwanAppCompassManager.TAG, "magneticFiled changed accuracy: " + SwanAppCompassManager.this.mAccuracy);
                SwanAppCompassManager.this.handleSensorChanged();
            }

            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
        this.mMagneticFieldListener = r0;
        return r0;
    }

    private float calculateOrientation() {
        float[] values = new float[3];
        float[] R = new float[9];
        SensorManager.getRotationMatrix(R, (float[]) null, this.mAccelerometerValues, this.mMagneticFieldValues);
        SensorManager.getOrientation(R, values);
        return (((float) Math.toDegrees((double) values[0])) + 360.0f) % 360.0f;
    }

    /* access modifiers changed from: private */
    public void handleSensorChanged() {
        if (this.mIntervalMap == null) {
            this.mIntervalMap = new HashMap<>();
        }
        ConcurrentHashMap<String, OnCompassChangeListener> concurrentHashMap = this.mCompassChangeListenerMap;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry<String, OnCompassChangeListener> entry : this.mCompassChangeListenerMap.entrySet()) {
                String slaveId = entry.getKey();
                OnCompassChangeListener listener = entry.getValue();
                if (!TextUtils.isEmpty(slaveId) && listener != null) {
                    Long lastReportTime = this.mIntervalMap.get(slaveId);
                    if (System.currentTimeMillis() - (lastReportTime != null ? lastReportTime.longValue() : 0) > 200) {
                        float orientation = calculateOrientation();
                        SwanAppLog.d(TAG, "slaveId = " + slaveId + " orientation   : " + orientation);
                        listener.onCompassChange(slaveId, orientation, this.mAccuracy);
                        this.mIntervalMap.put(slaveId, Long.valueOf(System.currentTimeMillis()));
                    }
                }
            }
        }
    }

    public static String getAccuracyType(int accuracy) {
        switch (accuracy) {
            case -1:
                return STATUS_NO_CONTACT;
            case 0:
                return STATUS_UNRELIABLE;
            case 1:
                return "low";
            case 2:
                return STATUS_ACCURACY_MEDIUM;
            case 3:
                return "high";
            default:
                return "unknow";
        }
    }
}
