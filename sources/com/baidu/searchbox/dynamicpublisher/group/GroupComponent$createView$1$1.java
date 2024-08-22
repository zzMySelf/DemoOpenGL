package com.baidu.searchbox.dynamicpublisher.group;

import com.baidu.searchbox.dynamicpublisher.group.GroupAction;
import com.baidu.searchbox.feed.detail.frame.Store;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupComponent.kt */
final class GroupComponent$createView$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GroupComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GroupComponent$createView$1$1(GroupComponent groupComponent) {
        super(0);
        this.this$0 = groupComponent;
    }

    public final void invoke() {
        int i2;
        switch (this.this$0.groupStyle) {
            case 1:
                GroupComponent groupComponent = this.this$0;
                Collection access$getRecommendGroups$p = groupComponent.recommendGroups;
                if (!(access$getRecommendGroups$p == null || access$getRecommendGroups$p.isEmpty())) {
                    this.this$0.getGroupView().updateShowStyle(0);
                    i2 = 3;
                } else {
                    i2 = 0;
                }
                groupComponent.groupStyle = i2;
                this.this$0.groupModel = null;
                GroupComponent.updateGroupView$default(this.this$0, false, 1, (Object) null);
                return;
            case 2:
                return;
            default:
                Store access$getStore = this.this$0.getStore();
                if (access$getStore != null) {
                    access$getStore.dispatch(new GroupAction.ClickGroupSelectedZone(this.this$0.groupModel));
                    return;
                }
                return;
        }
    }
}
