package com.mars.united.core.os.sensor;

import android.hardware.SensorEvent;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Landroid/hardware/SensorEvent;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class ScreenDirectionDetector$accelerometerHandleEvent$1 extends Lambda implements Function1<SensorEvent, Unit> {
    public final /* synthetic */ ScreenDirectionDetector this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenDirectionDetector$accelerometerHandleEvent$1(ScreenDirectionDetector screenDirectionDetector) {
        super(1);
        this.this$0 = screenDirectionDetector;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SensorEvent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, NotificationCompat.CATEGORY_EVENT);
        System.arraycopy(sensorEvent.values, 0, this.this$0.f6640uk, 0, this.this$0.f6640uk.length);
        this.this$0.ad();
    }
}
