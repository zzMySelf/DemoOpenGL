package fe.mmm.qw.tt.th;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;
import com.tera.scan.scanner.zxing.camera.FrontLightMode;
import fe.mmm.qw.tt.th.uk.fe;

public final class qw implements SensorEventListener {

    /* renamed from: ad  reason: collision with root package name */
    public final Context f8521ad;

    /* renamed from: th  reason: collision with root package name */
    public fe f8522th;

    /* renamed from: yj  reason: collision with root package name */
    public Sensor f8523yj;

    public qw(Context context) {
        this.f8521ad = context;
    }

    public void ad() {
        if (this.f8523yj != null) {
            ((SensorManager) this.f8521ad.getSystemService("sensor")).unregisterListener(this);
            this.f8522th = null;
            this.f8523yj = null;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        fe feVar = this.f8522th;
        if (feVar == null) {
            return;
        }
        if (f <= 45.0f) {
            feVar.o(true);
        } else if (f >= 450.0f) {
            feVar.o(false);
        }
    }

    public void qw(fe feVar) {
        this.f8522th = feVar;
        if (FrontLightMode.readPref(PreferenceManager.getDefaultSharedPreferences(this.f8521ad)) == FrontLightMode.AUTO) {
            SensorManager sensorManager = (SensorManager) this.f8521ad.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f8523yj = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }
}
