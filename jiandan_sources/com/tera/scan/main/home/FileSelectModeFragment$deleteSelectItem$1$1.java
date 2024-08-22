package com.tera.scan.main.home;

import androidx.fragment.app.FragmentActivity;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import fe.mmm.qw.xxx.yj.e;
import fe.mmm.qw.xxx.yj.g.qw.qw;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FileSelectModeFragment$deleteSelectItem$1$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ FragmentActivity $activity;
    public final /* synthetic */ FileSelectModeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSelectModeFragment$deleteSelectItem$1$1(FileSelectModeFragment fileSelectModeFragment, FragmentActivity fragmentActivity) {
        super(0);
        this.this$0 = fileSelectModeFragment;
        this.$activity = fragmentActivity;
    }

    public final void invoke() {
        List<T> list;
        Set<Integer> uk2;
        qw access$getListHolder = this.this$0.getListHolder();
        if ((access$getListHolder != null ? Integer.valueOf(access$getListHolder.yj()) : null) != null) {
            qw access$getListHolder2 = this.this$0.getListHolder();
            boolean z = false;
            if (access$getListHolder2 != null && access$getListHolder2.yj() == 0) {
                z = true;
            }
            if (!z) {
                MainActivityViewModel viewModel$app_main_aiscanConfigRelease = this.this$0.getViewModel$app_main_aiscanConfigRelease();
                FragmentActivity fragmentActivity = this.$activity;
                qw access$getListHolder3 = this.this$0.getListHolder();
                qw access$getListHolder4 = this.this$0.getListHolder();
                if (access$getListHolder4 == null || (uk2 = access$getListHolder4.uk()) == null || (list = CollectionsKt___CollectionsKt.toList(uk2)) == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                final FileSelectModeFragment fileSelectModeFragment = this.this$0;
                viewModel$app_main_aiscanConfigRelease.deleteFiles(fragmentActivity, access$getListHolder3, list, new Function1<Boolean, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Boolean) obj).booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        e.qw(fileSelectModeFragment, z);
                    }
                });
            }
        }
    }
}
