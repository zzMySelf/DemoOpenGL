package com.mars.united.core.util.observer;

import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import fe.ggg.ad.qw.ad.ad;
import fe.ggg.ad.qw.fe.de.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "observersCount", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DatabaseDataLoader$observable$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ qw<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DatabaseDataLoader$observable$1(qw<T> qwVar) {
        super(1);
        this.this$0 = qwVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        boolean z = true;
        if (this.this$0.f7595ad) {
            qw<T> qwVar = this.this$0;
            if (Logger.INSTANCE.getEnable()) {
                LoggerKt.d$default(ad.qw(qwVar.qw + " observersCount=" + i2 + ", loader=" + qwVar), (Object) null, 1, (Object) null);
            }
        }
        if (i2 > 0) {
            if (!this.this$0.f7597fe) {
                this.this$0.pf();
                qw<T> qwVar2 = this.this$0;
                qwVar2.f7596de = qwVar2.f7596de + 1;
            }
        } else if (this.this$0.f7597fe) {
            this.this$0.m955switch();
        }
        qw<T> qwVar3 = this.this$0;
        if (i2 <= 0) {
            z = false;
        }
        qwVar3.m954if(z);
        throw null;
    }
}
