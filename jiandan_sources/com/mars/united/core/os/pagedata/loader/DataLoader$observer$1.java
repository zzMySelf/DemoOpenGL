package com.mars.united.core.os.pagedata.loader;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "V", "Lcom/mars/united/core/os/pagedata/data/DataVersion;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DataLoader$observer$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ DataLoader<T, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataLoader$observer$1(DataLoader<T, V> dataLoader) {
        super(0);
        this.this$0 = dataLoader;
    }

    public final void invoke() {
        this.this$0.when.ad();
    }
}
