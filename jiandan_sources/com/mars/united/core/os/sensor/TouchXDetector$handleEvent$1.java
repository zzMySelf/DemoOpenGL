package com.mars.united.core.os.sensor;

import android.hardware.SensorEvent;
import androidx.core.app.NotificationCompat;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import fe.ggg.ad.qw.ad.ad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Landroid/hardware/SensorEvent;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class TouchXDetector$handleEvent$1 extends Lambda implements Function1<SensorEvent, Unit> {
    public final /* synthetic */ TouchXDetector this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchXDetector$handleEvent$1(TouchXDetector touchXDetector) {
        super(1);
        this.this$0 = touchXDetector;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SensorEvent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, NotificationCompat.CATEGORY_EVENT);
        float[] fArr = sensorEvent.values;
        Intrinsics.checkNotNullExpressionValue(fArr, "event.values");
        float f = 0.0f;
        float f2 = ArraysKt___ArraysKt.getLastIndex(fArr) >= 0 ? fArr[0] : 0.0f;
        float[] fArr2 = sensorEvent.values;
        Intrinsics.checkNotNullExpressionValue(fArr2, "event.values");
        float f3 = 1 <= ArraysKt___ArraysKt.getLastIndex(fArr2) ? fArr2[1] : 0.0f;
        float[] fArr3 = sensorEvent.values;
        Intrinsics.checkNotNullExpressionValue(fArr3, "event.values");
        if (2 <= ArraysKt___ArraysKt.getLastIndex(fArr3)) {
            f = fArr3[2];
        }
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.v$default(ad.qw("(curX " + f2 + ", curY " + f3 + ", curZ " + f + ')'), (Object) null, 1, (Object) null);
        }
        this.this$0.rg(f2, f3, f);
        float[] access$getCacheValue$p = this.this$0.f6652i;
        fe.ggg.ad.qw.fe.ad.ad.uk(access$getCacheValue$p, this.this$0.ad(f2));
        ArraysKt___ArraysKt.joinToString$default(access$getCacheValue$p, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
    }
}
