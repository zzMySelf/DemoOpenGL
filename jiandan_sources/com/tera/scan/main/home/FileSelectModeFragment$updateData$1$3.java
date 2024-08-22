package com.tera.scan.main.home;

import androidx.recyclerview.widget.RecyclerView;
import fe.mmm.qw.xxx.yj.tt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FileSelectModeFragment$updateData$1$3 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ int $itemY;
    public final /* synthetic */ FileSelectModeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSelectModeFragment$updateData$1$3(FileSelectModeFragment fileSelectModeFragment, int i2) {
        super(1);
        this.this$0 = fileSelectModeFragment;
        this.$itemY = i2;
    }

    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m793invoke$lambda1$lambda0(FileSelectModeFragment fileSelectModeFragment, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(fileSelectModeFragment, "this$0");
        Intrinsics.checkNotNullParameter(recyclerView, "$fileList");
        fileSelectModeFragment.scrollYDistance = 0;
        recyclerView.setVisibility(0);
        recyclerView.setBackgroundColor(-1);
        recyclerView.addOnScrollListener(new FileSelectModeFragment$updateData$1$3$1$1$1(fileSelectModeFragment));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        RecyclerView access$getFileSelectList$p = this.this$0.fileSelectList;
        if (access$getFileSelectList$p != null) {
            int i3 = this.$itemY;
            FileSelectModeFragment fileSelectModeFragment = this.this$0;
            access$getFileSelectList$p.clearOnScrollListeners();
            access$getFileSelectList$p.scrollBy(0, -(i3 - i2));
            access$getFileSelectList$p.post(new tt(fileSelectModeFragment, access$getFileSelectList$p));
        }
    }
}
