package com.mars.united.core.util.observer;

import fe.ggg.ad.qw.fe.de.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n"}, d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DatabaseDataLoader$updateData$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ T $data;
    public final /* synthetic */ long $version;
    public final /* synthetic */ qw<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DatabaseDataLoader$updateData$1(qw<T> qwVar, long j, T t) {
        super(0);
        this.this$0 = qwVar;
        this.$version = j;
        this.$data = t;
    }

    public final void invoke() {
        this.this$0.when(this.$version, this.$data);
    }
}
