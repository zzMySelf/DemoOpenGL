package com.tera.scan.main.home;

import androidx.lifecycle.ViewModelProvider;
import com.tera.scan.main.viewmodel.ScanHomeFragmentViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/main/viewmodel/ScanHomeFragmentViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$scanHomeFragmentViewModel$2 extends Lambda implements Function0<ScanHomeFragmentViewModel> {
    public final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$scanHomeFragmentViewModel$2(HomeFragment homeFragment) {
        super(0);
        this.this$0 = homeFragment;
    }

    @NotNull
    public final ScanHomeFragmentViewModel invoke() {
        return (ScanHomeFragmentViewModel) new ViewModelProvider(this.this$0).get(ScanHomeFragmentViewModel.class);
    }
}
