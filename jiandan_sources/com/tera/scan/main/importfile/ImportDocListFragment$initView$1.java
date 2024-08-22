package com.tera.scan.main.importfile;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class ImportDocListFragment$initView$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public ImportDocListFragment$initView$1(Object obj) {
        super(1, obj, ImportDocListFragment.class, "onImportDocItemClick", "onImportDocItemClick(I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        ((ImportDocListFragment) this.receiver).onImportDocItemClick(i2);
    }
}
