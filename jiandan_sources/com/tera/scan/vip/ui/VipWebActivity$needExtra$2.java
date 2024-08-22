package com.tera.scan.vip.ui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VipWebActivity$needExtra$2 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ VipWebActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VipWebActivity$needExtra$2(VipWebActivity vipWebActivity) {
        super(0);
        this.this$0 = vipWebActivity;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra(VipWebActivity.PARAM_NEED_EXTRA, true));
    }
}
