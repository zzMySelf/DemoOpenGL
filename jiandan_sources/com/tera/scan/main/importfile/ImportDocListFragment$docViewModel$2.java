package com.tera.scan.main.importfile;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/main/importfile/viewmodel/ImportDocFileViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ImportDocListFragment$docViewModel$2 extends Lambda implements Function0<ImportDocFileViewModel> {
    public final /* synthetic */ ImportDocListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportDocListFragment$docViewModel$2(ImportDocListFragment importDocListFragment) {
        super(0);
        this.this$0 = importDocListFragment;
    }

    @NotNull
    public final ImportDocFileViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return (ImportDocFileViewModel) new ViewModelProvider(requireActivity).get(ImportDocFileViewModel.class);
    }
}
