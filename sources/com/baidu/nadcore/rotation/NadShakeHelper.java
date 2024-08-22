package com.baidu.nadcore.rotation;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/baidu/nadcore/rotation/NadShakeHelper;", "Lcom/baidu/nadcore/rotation/NadSensorAbsHelper;", "context", "Landroid/content/Context;", "listener", "Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;", "(Landroid/content/Context;Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;)V", "realShakeCounts", "", "getRealShakeCounts", "()I", "setRealShakeCounts", "(I)V", "shakeDirection", "", "getShakeDirection", "()F", "setShakeDirection", "(F)V", "getSensitivity", "getSensorType", "handleEvent", "", "event", "Landroid/hardware/SensorEvent;", "stop", "nadcore-lib-widget"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadShakeHelper.kt */
public final class NadShakeHelper extends NadSensorAbsHelper {
    private int realShakeCounts;
    private float shakeDirection = 1.0f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NadShakeHelper(Context context, NadSensorEventAbsListener listener) {
        super(context, listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public final float getShakeDirection() {
        return this.shakeDirection;
    }

    public final void setShakeDirection(float f2) {
        this.shakeDirection = f2;
    }

    public final int getRealShakeCounts() {
        return this.realShakeCounts;
    }

    public final void setRealShakeCounts(int i2) {
        this.realShakeCounts = i2;
    }

    public int getSensorType() {
        return 1;
    }

    public int getSensitivity() {
        int updateInterval = getParams().getUpdateInterval();
        boolean z = true;
        if (updateInterval >= 0 && updateInterval < 67) {
            return 1;
        }
        if (67 > updateInterval || updateInterval >= 200) {
            z = false;
        }
        if (!z && updateInterval >= 200) {
            return 3;
        }
        return 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r11.sensor;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleEvent(android.hardware.SensorEvent r11) {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            if (r11 == 0) goto L_0x0010
            android.hardware.Sensor r2 = r11.sensor
            if (r2 == 0) goto L_0x0010
            int r2 = r2.getType()
            if (r2 != r1) goto L_0x0010
            r2 = r1
            goto L_0x0011
        L_0x0010:
            r2 = r0
        L_0x0011:
            if (r2 == 0) goto L_0x0068
            float[] r2 = r11.values
            r0 = r2[r0]
            float[] r2 = r11.values
            r2 = r2[r1]
            float[] r3 = r11.values
            r4 = 2
            r3 = r3[r4]
            double r4 = (double) r0
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = java.lang.Math.pow(r4, r6)
            double r8 = (double) r2
            double r8 = java.lang.Math.pow(r8, r6)
            double r4 = r4 + r8
            double r8 = (double) r3
            double r8 = java.lang.Math.pow(r8, r6)
            double r4 = r4 + r8
            com.baidu.nadcore.rotation.NadSensorHelperParams r8 = r10.getParams()
            float r8 = r8.getShakeSensitivity()
            double r8 = (double) r8
            double r6 = java.lang.Math.pow(r8, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0045
            return
        L_0x0045:
            float r8 = r10.shakeDirection
            float r8 = r8 * r0
            r9 = 0
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 < 0) goto L_0x0050
            r10.shakeDirection = r0
            return
        L_0x0050:
            r10.shakeDirection = r0
            int r8 = r10.realShakeCounts
            int r8 = r8 + r1
            r10.realShakeCounts = r8
            com.baidu.nadcore.rotation.NadSensorHelperParams r1 = r10.getParams()
            int r1 = r1.getShakeCounts()
            if (r8 < r1) goto L_0x0068
            com.baidu.nadcore.rotation.NadSensorEventAbsListener r1 = r10.getBusinessListener()
            r1.onShakeTrigger()
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.rotation.NadShakeHelper.handleEvent(android.hardware.SensorEvent):void");
    }

    public void stop() {
        super.stop();
        this.realShakeCounts = 0;
        this.shakeDirection = 1.0f;
    }
}
