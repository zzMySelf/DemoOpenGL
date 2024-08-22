package com.tera.scan.main.home;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/tera/scan/main/home/FileSelectModeFragment$updateData$1$3$1$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileSelectModeFragment$updateData$1$3$1$1$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ FileSelectModeFragment qw;

    public FileSelectModeFragment$updateData$1$3$1$1$1(FileSelectModeFragment fileSelectModeFragment) {
        this.qw = fileSelectModeFragment;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i2, int i3) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        FileSelectModeFragment fileSelectModeFragment = this.qw;
        fileSelectModeFragment.scrollYDistance = fileSelectModeFragment.scrollYDistance + i3;
    }
}
