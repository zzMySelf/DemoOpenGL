package com.tera.scan.vip.ui;

import androidx.lifecycle.ViewModelProvider;
import com.tera.scan.vip.ui.viewmodel.VipBuyViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/vip/ui/viewmodel/VipBuyViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VipWebActivity$vipBuyViewModel$2 extends Lambda implements Function0<VipBuyViewModel> {
    public final /* synthetic */ VipWebActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VipWebActivity$vipBuyViewModel$2(VipWebActivity vipWebActivity) {
        super(0);
        this.this$0 = vipWebActivity;
    }

    @NotNull
    public final VipBuyViewModel invoke() {
        return (VipBuyViewModel) new ViewModelProvider(this.this$0).get(VipBuyViewModel.class);
    }
}
