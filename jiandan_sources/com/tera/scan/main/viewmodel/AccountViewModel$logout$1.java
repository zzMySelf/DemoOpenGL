package com.tera.scan.main.viewmodel;

import fe.mmm.qw.xxx.rg.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AccountViewModel$logout$1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ AccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountViewModel$logout$1(AccountViewModel accountViewModel) {
        super(1);
        this.this$0 = accountViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            this.this$0.qw.setValue(Boolean.FALSE);
            this.this$0.f7004de.setValue(new qw(true, true));
            fe.mmm.qw.ggg.qw.qw.de();
            return;
        }
        this.this$0.qw.postValue(Boolean.FALSE);
        this.this$0.f7004de.postValue(new qw(false, false));
    }
}
