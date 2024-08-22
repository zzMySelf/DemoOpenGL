package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;

public class k extends d {
    private float[] w = new float[3];
    private float[] x = new float[3];

    public k(SensorManager sensorManager) {
        super(sensorManager);
        this.f9748d.add(sensorManager.getDefaultSensor(9));
        this.f9748d.add(sensorManager.getDefaultSensor(2));
        this.f9748d.add(sensorManager.getDefaultSensor(4));
        this.f9748d.add(sensorManager.getDefaultSensor(11));
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        if (sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 4) {
            super.onSensorChanged(sensorEvent);
        } else if (sensorEvent.sensor.getType() == 2) {
            this.w = (float[]) sensorEvent.values.clone();
        } else if (sensorEvent.sensor.getType() == 9) {
            float[] fArr2 = (float[]) sensorEvent.values.clone();
            this.x = fArr2;
            this.l = fArr2;
        }
        float[] fArr3 = this.w;
        if (fArr3 != null && (fArr = this.x) != null) {
            SensorManager.getRotationMatrix(this.f9749e.matrix, new float[16], fArr, fArr3);
            this.f9750f.setRowMajor(this.f9749e.matrix);
        }
    }
}
