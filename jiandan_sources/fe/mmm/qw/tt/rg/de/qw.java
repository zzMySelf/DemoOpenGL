package fe.mmm.qw.tt.rg.de;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public SensorManager f8477ad;
    public int qw = 1;

    /* renamed from: fe.mmm.qw.tt.rg.de.qw$qw  reason: collision with other inner class name */
    public class C0294qw implements SensorEventListener {
        public C0294qw() {
        }

        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            int i2 = 1;
            if (1 == sensorEvent.sensor.getType()) {
                float[] fArr = sensorEvent.values;
                float f = fArr[0];
                float f2 = fArr[1];
                double d = (double) f;
                if (d >= 4.5d || d < -4.5d || ((double) f2) < 4.5d) {
                    if (d >= 4.5d) {
                        double d2 = (double) f2;
                        if (d2 < 4.5d && d2 >= -4.5d) {
                            i2 = 0;
                        }
                    }
                    if (d <= -4.5d) {
                        double d3 = (double) f2;
                        if (d3 < 4.5d && d3 >= -4.5d) {
                            i2 = 8;
                        }
                    }
                    i2 = 9;
                }
                if (i2 != qw.this.qw) {
                    int unused = qw.this.qw = i2;
                }
            }
        }
    }

    public qw(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f8477ad = sensorManager;
        sensorManager.registerListener(new C0294qw(), this.f8477ad.getDefaultSensor(1), 3);
    }

    public int de() {
        return this.qw;
    }
}
