package com.baidu.searchbox.dynamicpublisher.groupselect;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.ugc.grouppanel.model.GroupListContentModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/groupselect/GroupSelectAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "GroupPanelDismiss", "SelectCompletion", "TriggerGroupSelection", "Lcom/baidu/searchbox/dynamicpublisher/groupselect/GroupSelectAction$TriggerGroupSelection;", "Lcom/baidu/searchbox/dynamicpublisher/groupselect/GroupSelectAction$SelectCompletion;", "Lcom/baidu/searchbox/dynamicpublisher/groupselect/GroupSelectAction$GroupPanelDismiss;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupSelectAction.kt */
public abstract class GroupSelectAction implements Action {
    public /* synthetic */ GroupSelectAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GroupSelectAction() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/groupselect/GroupSelectAction$TriggerGroupSelection;", "Lcom/baidu/searchbox/dynamicpublisher/groupselect/GroupSelectAction;", "selectedGroup", "Lcom/baidu/searchbox/ugc/grouppanel/model/GroupListContentModel;", "(Lcom/baidu/searchbox/ugc/grouppanel/model/GroupListContentModel;)V", "getSelectedGroup", "()Lcom/baidu/searchbox/ugc/grouppanel/model/GroupListContentModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GroupSelectAction.kt */
    public static final class TriggerGroupSelection extends GroupSelectAction {
        private final GroupListContentModel selectedGroup;

        public static /* synthetic */ TriggerGroupSelection copy$default(TriggerGroupSelection triggerGroupSelection, GroupListContentModel groupListContentModel, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                groupListContentModel = triggerGroupSelection.selectedGroup;
            }
            return triggerGroupSelection.copy(groupListContentModel);
        }

        public final GroupListContentModel component1() {
            return this.selectedGroup;
        }

        public final TriggerGroupSelection copy(GroupListContentModel groupListContentModel) {
            return new TriggerGroupSelection(groupListContentModel);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TriggerGroupSelection) && Intrinsics.areEqual((Object) this.selectedGroup, (Object) ((TriggerGroupSelection) obj).selectedGroup);
        }

        public int hashCode() {
            GroupListContentModel groupListContentModel = this.selectedGroup;
            if (groupListContentModel == null) {
                return 0;
            }
            return groupListContentModel.hashCode();
        }

        public String toString() {
            return "TriggerGroupSelection(selectedGroup=" + this.selectedGroup + ')';
        }

        public TriggerGroupSelection(GroupListContentModel selectedGroup2) {
            super((DefaultConstructorMarker) null);
            this.selectedGroup = selectedGroup2;
        }

        public final GroupListContentModel getSelectedGroup() {
            return this.selectedGroup;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/groupselect/GroupSelectAction$SelectCompletion;", "Lcom/baidu/searchbox/dynamicpublisher/groupselect/GroupSelectAction;", "newSelectGroup", "Lcom/baidu/searchbox/ugc/grouppanel/model/GroupListContentModel;", "(Lcom/baidu/searchbox/ugc/grouppanel/model/GroupListContentModel;)V", "getNewSelectGroup", "()Lcom/baidu/searchbox/ugc/grouppanel/model/GroupListContentModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GroupSelectAction.kt */
    public static final class SelectCompletion extends GroupSelectAction {
        private final GroupListContentModel newSelectGroup;

        public static /* synthetic */ SelectCompletion copy$default(SelectCompletion selectCompletion, GroupListContentModel groupListContentModel, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                groupListContentModel = selectCompletion.newSelectGroup;
            }
            return selectCompletion.copy(groupListContentModel);
        }

        public final GroupListContentModel component1() {
            return this.newSelectGroup;
        }

        public final SelectCompletion copy(GroupListContentModel groupListContentModel) {
            return new SelectCompletion(groupListContentModel);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectCompletion) && Intrinsics.areEqual((Object) this.newSelectGroup, (Object) ((SelectCompletion) obj).newSelectGroup);
        }

        public int hashCode() {
            GroupListContentModel groupListContentModel = this.newSelectGroup;
            if (groupListContentModel == null) {
                return 0;
            }
            return groupListContentModel.hashCode();
        }

        public String toString() {
            return "SelectCompletion(newSelectGroup=" + this.newSelectGroup + ')';
        }

        public SelectCompletion(GroupListContentModel newSelectGroup2) {
            super((DefaultConstructorMarker) null);
            this.newSelectGroup = newSelectGroup2;
        }

        public final GroupListContentModel getNewSelectGroup() {
            return this.newSelectGroup;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/groupselect/GroupSelectAction$GroupPanelDismiss;", "Lcom/baidu/searchbox/dynamicpublisher/groupselect/GroupSelectAction;", "()V", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GroupSelectAction.kt */
    public static final class GroupPanelDismiss extends GroupSelectAction {
        public static final GroupPanelDismiss INSTANCE = new GroupPanelDismiss();

        private GroupPanelDismiss() {
            super((DefaultConstructorMarker) null);
        }
    }
}
