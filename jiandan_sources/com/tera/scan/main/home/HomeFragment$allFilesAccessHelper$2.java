package com.tera.scan.main.home;

import androidx.fragment.app.FragmentActivity;
import com.tera.scan.permission.util.ManageAppAllFilesAccessHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/permission/util/ManageAppAllFilesAccessHelper;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$allFilesAccessHelper$2 extends Lambda implements Function0<ManageAppAllFilesAccessHelper> {
    public final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$allFilesAccessHelper$2(HomeFragment homeFragment) {
        super(0);
        this.this$0 = homeFragment;
    }

    @Nullable
    public final ManageAppAllFilesAccessHelper invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return new ManageAppAllFilesAccessHelper(activity, HomeFragment$allFilesAccessHelper$2$1$1.INSTANCE, (Function0) null, (Function0) null, (Function0) null, 28, (DefaultConstructorMarker) null);
        }
        return null;
    }
}
