package com.baidu.searchbox.personal.sidebar;

import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.personal.sidebar.SideBarBaseHolder;
import com.baidu.searchbox.personal.sidebar.SidebarCommonFunAdapter;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/personal/sidebar/SidebarCommonFunHolder$populate$1", "Lcom/baidu/searchbox/personal/sidebar/SidebarCommonFunAdapter$OnCommonFunItemClickListener;", "onClick", "", "position", "", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SidebarCommonFunHolder.kt */
public final class SidebarCommonFunHolder$populate$1 implements SidebarCommonFunAdapter.OnCommonFunItemClickListener {
    final /* synthetic */ List<PersonalCenterTabItemModel> $itemList;
    final /* synthetic */ SidebarCommonFunHolder this$0;

    SidebarCommonFunHolder$populate$1(List<? extends PersonalCenterTabItemModel> $itemList2, SidebarCommonFunHolder $receiver) {
        this.$itemList = $itemList2;
        this.this$0 = $receiver;
    }

    public void onClick(int position) {
        PersonalCenterTabItemModel info = this.$itemList.get(position);
        info.setItemType(PersonalCenterTabItemModel.ItemType.COMMON_FUN);
        SideBarBaseHolder.ActionListener listener = this.this$0.getListener();
        if (listener != null) {
            listener.itemClick(info, position + 1);
        }
        this.this$0.onItemClick(info);
    }
}
