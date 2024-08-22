package com.baidu.searchbox.personal.sidebar;

import android.view.View;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.personal.sidebar.SideBarBaseHolder;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0017J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/personal/sidebar/SidebarClearCacheHolder;", "Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder;", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabModel;", "itemView", "Landroid/view/View;", "listener", "Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;", "(Landroid/view/View;Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;)V", "getListener", "()Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;", "setListener", "(Lcom/baidu/searchbox/personal/sidebar/SideBarBaseHolder$ActionListener;)V", "populate", "", "data", "ubcShow", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SidebarClearCacheHolder.kt */
public final class SidebarClearCacheHolder extends SideBarBaseHolder<PersonalCenterTabModel> {
    private SideBarBaseHolder.ActionListener listener;

    public final SideBarBaseHolder.ActionListener getListener() {
        return this.listener;
    }

    public final void setListener(SideBarBaseHolder.ActionListener actionListener) {
        this.listener = actionListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SidebarClearCacheHolder(View itemView, SideBarBaseHolder.ActionListener listener2) {
        super(itemView, listener2);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.listener = listener2;
    }

    public void populate(PersonalCenterTabModel data) {
        View view2 = this.itemView;
        SidebarClearCacheView sidebarClearCacheView = view2 instanceof SidebarClearCacheView ? (SidebarClearCacheView) view2 : null;
        if (sidebarClearCacheView != null) {
            sidebarClearCacheView.populate(data);
        }
    }

    public void ubcShow(PersonalCenterTabModel data) {
        List<PersonalCenterTabItemModel> $this$forEach$iv;
        if (data != null && ($this$forEach$iv = data.getBody()) != null) {
            for (PersonalCenterTabItemModel tabItemModel : $this$forEach$iv) {
                PersonCenterUBCStatistic.statisticUBC(tabItemModel.getUbcType(), "0", "show", (JSONObject) null, tabItemModel.getUbcFrom(), tabItemModel.getUbcEventId(), (String) null);
            }
        }
    }
}
