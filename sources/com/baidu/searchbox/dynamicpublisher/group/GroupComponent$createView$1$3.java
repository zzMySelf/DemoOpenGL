package com.baidu.searchbox.dynamicpublisher.group;

import com.baidu.searchbox.dynamicpublisher.group.GroupAction;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.ugc.grouppanel.model.GroupListContentModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "position", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupComponent.kt */
final class GroupComponent$createView$1$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ GroupComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GroupComponent$createView$1$3(GroupComponent groupComponent) {
        super(1);
        this.this$0 = groupComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int position) {
        Store access$getStore;
        GroupComponent groupComponent = this.this$0;
        groupComponent.groupModel = (GroupListContentModel) groupComponent.recommendGroups.get(position);
        this.this$0.groupStyle = 1;
        String str = null;
        GroupComponent.updateGroupView$default(this.this$0, false, 1, (Object) null);
        Store access$getStore2 = this.this$0.getStore();
        if (access$getStore2 != null) {
            access$getStore2.dispatch(new GroupAction.ClickRecommendGroup(this.this$0.groupModel));
        }
        if (this.this$0.recommendGuideGroupId != null) {
            String access$getRecommendGuideGroupId$p = this.this$0.recommendGuideGroupId;
            GroupListContentModel access$getGroupModel$p = this.this$0.groupModel;
            if (access$getGroupModel$p != null) {
                str = access$getGroupModel$p.getId();
            }
            if (Intrinsics.areEqual((Object) access$getRecommendGuideGroupId$p, (Object) str) && (access$getStore = this.this$0.getStore()) != null) {
                access$getStore.dispatch(new GroupAction.ClickRecommendGuideGroup(this.this$0.groupModel));
            }
        }
    }
}
