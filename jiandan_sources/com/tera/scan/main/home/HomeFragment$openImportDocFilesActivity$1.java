package com.tera.scan.main.home;

import androidx.fragment.app.FragmentActivity;
import com.tera.scan.main.importfile.ImportDocFilesActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$openImportDocFilesActivity$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$openImportDocFilesActivity$1(HomeFragment homeFragment) {
        super(0);
        this.this$0 = homeFragment;
    }

    public final void invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            ImportDocFilesActivity.Companion.qw(activity);
        }
    }
}
