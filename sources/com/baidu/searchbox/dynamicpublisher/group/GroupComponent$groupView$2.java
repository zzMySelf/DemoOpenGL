package com.baidu.searchbox.dynamicpublisher.group;

import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/dynamicpublisher/group/GroupView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupComponent.kt */
final class GroupComponent$groupView$2 extends Lambda implements Function0<GroupView> {
    final /* synthetic */ GroupComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GroupComponent$groupView$2(GroupComponent groupComponent) {
        super(0);
        this.this$0 = groupComponent;
    }

    public final GroupView invoke() {
        return new GroupView(this.this$0.getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }
}
