package com.mars.united.core.os;

import android.view.OrientationEventListener;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import fe.ggg.ad.qw.ad.ad;
import fe.ggg.ad.qw.de.th.rg;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0007\n\u0000\n\u0000*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "com/mars/united/core/os/ScreenExtKt$observerOrientation$orientationEventListener$2$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class ScreenExtKt$observerOrientation$orientationEventListener$2 extends Lambda implements Function0<AnonymousClass1> {
    public final /* synthetic */ MutableLiveData<Integer> $rotationValue;
    public final /* synthetic */ FragmentActivity $this_observerOrientation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenExtKt$observerOrientation$orientationEventListener$2(FragmentActivity fragmentActivity, MutableLiveData<Integer> mutableLiveData) {
        super(0);
        this.$this_observerOrientation = fragmentActivity;
        this.$rotationValue = mutableLiveData;
    }

    @NotNull
    public final AnonymousClass1 invoke() {
        return new OrientationEventListener(this.$rotationValue, this.$this_observerOrientation) {
            public final /* synthetic */ MutableLiveData<Integer> $rotationValue;
            public final /* synthetic */ FragmentActivity $this_observerOrientation;

            {
                this.$rotationValue = r1;
                this.$this_observerOrientation = r2;
            }

            public void onOrientationChanged(int i2) {
                if (Logger.INSTANCE.getEnable()) {
                    LoggerKt.v$default(ad.qw(hashCode() + " rot " + i2), (Object) null, 1, (Object) null);
                }
                rg.yj(this.$rotationValue, Integer.valueOf(i2));
            }
        };
    }
}
