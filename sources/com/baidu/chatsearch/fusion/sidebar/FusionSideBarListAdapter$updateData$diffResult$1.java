package com.baidu.chatsearch.fusion.sidebar;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/baidu/chatsearch/fusion/sidebar/FusionSideBarListAdapter$updateData$diffResult$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "lib-chatsearch-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FusionSideBarAdapter.kt */
public final class FusionSideBarListAdapter$updateData$diffResult$1 extends DiffUtil.Callback {
    final /* synthetic */ List<SideBarItemModel> $newList;
    final /* synthetic */ Ref.IntRef $newSelectedPosition;
    final /* synthetic */ List<SideBarItemModel> $oldList;
    final /* synthetic */ int $oldSelectedPosition;
    final /* synthetic */ boolean $refreshAll;

    FusionSideBarListAdapter$updateData$diffResult$1(List<? extends SideBarItemModel> $oldList2, List<? extends SideBarItemModel> $newList2, boolean $refreshAll2, int $oldSelectedPosition2, Ref.IntRef $newSelectedPosition2) {
        this.$oldList = $oldList2;
        this.$newList = $newList2;
        this.$refreshAll = $refreshAll2;
        this.$oldSelectedPosition = $oldSelectedPosition2;
        this.$newSelectedPosition = $newSelectedPosition2;
    }

    public int getOldListSize() {
        return this.$oldList.size();
    }

    public int getNewListSize() {
        return this.$newList.size();
    }

    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return Intrinsics.areEqual((Object) this.$oldList.get(oldItemPosition).getAppId(), (Object) this.$newList.get(newItemPosition).getAppId()) && !this.$refreshAll;
    }

    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        if (oldItemPosition == this.$oldSelectedPosition || newItemPosition == this.$newSelectedPosition.element) {
            return false;
        }
        return this.$oldList.get(oldItemPosition).areContentsTheSame(this.$newList.get(newItemPosition));
    }
}
