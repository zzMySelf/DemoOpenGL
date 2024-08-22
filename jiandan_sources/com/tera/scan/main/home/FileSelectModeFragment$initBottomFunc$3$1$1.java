package com.tera.scan.main.home;

import androidx.fragment.app.FragmentActivity;
import com.tera.scan.main.home.bean.recordwrapper.RecordWrapper;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import fe.mmm.qw.xxx.yj.g.qw.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FileSelectModeFragment$initBottomFunc$3$1$1 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ FragmentActivity $activity;
    public final /* synthetic */ int $index;
    public final /* synthetic */ RecordWrapper<?> $record;
    public final /* synthetic */ FileSelectModeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSelectModeFragment$initBottomFunc$3$1$1(RecordWrapper<?> recordWrapper, FileSelectModeFragment fileSelectModeFragment, FragmentActivity fragmentActivity, int i2) {
        super(1);
        this.$record = recordWrapper;
        this.this$0 = fileSelectModeFragment;
        this.$activity = fragmentActivity;
        this.$index = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        RecordWrapper<?> recordWrapper = this.$record;
        if (!Intrinsics.areEqual((Object) recordWrapper != null ? recordWrapper.getFileName() : null, (Object) str)) {
            MainActivityViewModel viewModel$app_main_aiscanConfigRelease = this.this$0.getViewModel$app_main_aiscanConfigRelease();
            FragmentActivity fragmentActivity = this.$activity;
            qw access$getListHolder = this.this$0.getListHolder();
            final int i2 = this.$index;
            final FileSelectModeFragment fileSelectModeFragment = this.this$0;
            viewModel$app_main_aiscanConfigRelease.updateRecordName(fragmentActivity, access$getListHolder, str, i2, new Function1<Boolean, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    if (z) {
                        fileSelectModeFragment.onItemSelect(i2);
                    }
                }
            });
        }
    }
}
