package com.baidu.searchbox.draftbox;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/draftbox/DraftBoxViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DraftBoxActivity.kt */
final class DraftBoxActivity$viewModel$2 extends Lambda implements Function0<DraftBoxViewModel> {
    final /* synthetic */ DraftBoxActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DraftBoxActivity$viewModel$2(DraftBoxActivity draftBoxActivity) {
        super(0);
        this.this$0 = draftBoxActivity;
    }

    public final DraftBoxViewModel invoke() {
        return (DraftBoxViewModel) new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new ViewModelProvider.NewInstanceFactory()).get(DraftBoxViewModel.class);
    }
}
