package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.f;

public class k implements SensorEventListener {

    /* renamed from: d  reason: collision with root package name */
    private static k f13734d;

    /* renamed from: a  reason: collision with root package name */
    private float[] f13735a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f13736b;

    /* renamed from: c  reason: collision with root package name */
    private SensorManager f13737c;

    /* renamed from: e  reason: collision with root package name */
    private float f13738e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13739f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13740g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13741h = false;

    private k() {
    }

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (f13734d == null) {
                f13734d = new k();
            }
            kVar = f13734d;
        }
        return kVar;
    }

    public void a(boolean z) {
        this.f13739f = z;
    }

    public synchronized void b() {
        if (!this.f13741h) {
            if (this.f13739f) {
                if (this.f13737c == null) {
                    this.f13737c = (SensorManager) f.getServiceContext().getSystemService("sensor");
                }
                SensorManager sensorManager = this.f13737c;
                if (sensorManager != null) {
                    Sensor defaultSensor = sensorManager.getDefaultSensor(11);
                    if (defaultSensor != null && this.f13739f) {
                        this.f13737c.registerListener(this, defaultSensor, 3);
                    }
                    Sensor defaultSensor2 = this.f13737c.getDefaultSensor(2);
                    if (defaultSensor2 != null && this.f13739f) {
                        this.f13737c.registerListener(this, defaultSensor2, 3);
                    }
                }
                this.f13741h = true;
            }
        }
    }

    public synchronized void c() {
        if (this.f13741h) {
            SensorManager sensorManager = this.f13737c;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                this.f13737c = null;
            }
            this.f13741h = false;
        }
    }

    public boolean d() {
        return this.f13739f;
    }

    public float e() {
        return this.f13738e;
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case 2:
                float[] fArr = (float[]) sensorEvent.values.clone();
                this.f13736b = fArr;
                float f2 = fArr[0];
                float f3 = fArr[1];
                float f4 = fArr[2];
                Math.sqrt((double) ((f2 * f2) + (f3 * f3) + (f4 * f4)));
                return;
            case 11:
                float[] fArr2 = (float[]) sensorEvent.values.clone();
                this.f13735a = fArr2;
                if (fArr2 != null) {
                    float[] fArr3 = new float[9];
                    try {
                        SensorManager.getRotationMatrixFromVector(fArr3, fArr2);
                        float[] fArr4 = new float[3];
                        SensorManager.getOrientation(fArr3, fArr4);
                        float degrees = (float) Math.toDegrees((double) fArr4[0]);
                        this.f13738e = degrees;
                        if (degrees < 0.0f) {
                            degrees += 360.0f;
                        }
                        this.f13738e = (float) Math.floor((double) degrees);
                        return;
                    } catch (Exception e2) {
                        this.f13738e = 0.0f;
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
