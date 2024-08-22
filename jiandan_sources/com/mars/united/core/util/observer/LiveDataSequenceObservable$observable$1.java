package com.mars.united.core.util.observer;

import androidx.lifecycle.LiveData;
import fe.ggg.ad.qw.de.th.rg;
import fe.ggg.ad.qw.fe.de.ad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class LiveDataSequenceObservable$observable$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ LiveData<T> $liveData;
    public final /* synthetic */ ad<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDataSequenceObservable$observable$1(ad<T> adVar, LiveData<T> liveData) {
        super(1);
        this.this$0 = adVar;
        this.$liveData = liveData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        if (i2 <= 0) {
            if (this.this$0.f7594ad) {
                rg.de(this.$liveData, this.this$0.qw);
                this.this$0.f7594ad = false;
            }
        } else if (!this.this$0.f7594ad) {
            rg.qw(this.$liveData, this.this$0.qw);
            this.this$0.f7594ad = true;
        }
    }
}
