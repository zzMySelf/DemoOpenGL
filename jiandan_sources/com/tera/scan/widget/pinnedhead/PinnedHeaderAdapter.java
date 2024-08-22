package com.tera.scan.widget.pinnedhead;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\b¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/widget/pinnedhead/PinnedHeaderAdapter;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "isPinnedPosition", "", "position", "", "onBindPinnedViewHolder", "", "holder", "onCreatePinnedViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "x-widgets_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PinnedHeaderAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public abstract boolean isPinnedPosition(int i2);

    public final void onBindPinnedViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        onBindViewHolder(viewHolder, i2);
    }

    @Nullable
    public final RecyclerView.ViewHolder onCreatePinnedViewHolder(@Nullable ViewGroup viewGroup, int i2) {
        if (viewGroup != null) {
            return onCreateViewHolder(viewGroup, i2);
        }
        return null;
    }
}
