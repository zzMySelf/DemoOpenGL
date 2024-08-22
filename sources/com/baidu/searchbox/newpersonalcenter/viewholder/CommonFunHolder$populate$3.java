package com.baidu.searchbox.newpersonalcenter.viewholder;

import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/newpersonalcenter/viewholder/CommonFunHolder$populate$3", "Lcom/baidu/searchbox/newpersonalcenter/commonfun/PersonalCommonFunAdapter$OnCommonFunItemClickListener;", "onClick", "", "position", "", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonFunHolder.kt */
public final class CommonFunHolder$populate$3 implements PersonalCommonFunAdapter.OnCommonFunItemClickListener {
    final /* synthetic */ List<PersonalCenterTabItemModel> $secondPageList;
    final /* synthetic */ CommonFunHolder this$0;

    CommonFunHolder$populate$3(List<? extends PersonalCenterTabItemModel> $secondPageList2, CommonFunHolder $receiver) {
        this.$secondPageList = $secondPageList2;
        this.this$0 = $receiver;
    }

    public void onClick(int position) {
        PersonalCenterTabItemModel info = this.$secondPageList.get(position);
        info.setItemType(PersonalCenterTabItemModel.ItemType.COMMON_FUN);
        ModuleActionListener moduleActionListener = this.this$0.getModuleActionListener();
        if (moduleActionListener != null) {
            moduleActionListener.onChildItemClickListener(info, position + 10, this.this$0.cardPosition);
        }
        this.this$0.onItemClick(info);
    }
}
