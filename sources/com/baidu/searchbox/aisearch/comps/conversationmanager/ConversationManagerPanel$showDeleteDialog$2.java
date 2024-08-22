package com.baidu.searchbox.aisearch.comps.conversationmanager;

import com.baidu.searchbox.aisearch.comps.conversationmanager.item.ConversationManagerItemData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationManagerPanel.kt */
final class ConversationManagerPanel$showDeleteDialog$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ConversationManagerItemData $itemData;
    final /* synthetic */ ConversationManagerPanel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationManagerPanel$showDeleteDialog$2(ConversationManagerItemData conversationManagerItemData, ConversationManagerPanel conversationManagerPanel) {
        super(0);
        this.$itemData = conversationManagerItemData;
        this.this$0 = conversationManagerPanel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r4 = this;
            com.baidu.searchbox.aisearch.comps.conversationmanager.item.ConversationManagerItemData r0 = r4.$itemData
            if (r0 == 0) goto L_0x000f
            com.baidu.searchbox.aisearch.comps.conversationmanager.model.ConversationItem r0 = r0.getData()
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getSessionID()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x001e
            int r1 = r1.length()
            if (r1 != 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r1 = 0
            goto L_0x001f
        L_0x001e:
            r1 = 1
        L_0x001f:
            if (r1 == 0) goto L_0x0031
            com.baidu.searchbox.aisearch.comps.conversationmanager.ConversationManagerPanel r1 = r4.this$0
            com.baidu.searchbox.aisearch.comps.conversationmanager.dependents.ConversationRecyclerComp r1 = r1.conversationRecyclerComp
            androidx.lifecycle.ViewModel r1 = r1.getViewModel()
            com.baidu.searchbox.aisearch.comps.conversationmanager.dependents.ConversationManagerPanelVM r1 = (com.baidu.searchbox.aisearch.comps.conversationmanager.dependents.ConversationManagerPanelVM) r1
            r1.deleteAllItem()
            goto L_0x0042
        L_0x0031:
            com.baidu.searchbox.aisearch.comps.conversationmanager.ConversationManagerPanel r1 = r4.this$0
            com.baidu.searchbox.aisearch.comps.conversationmanager.dependents.ConversationRecyclerComp r1 = r1.conversationRecyclerComp
            androidx.lifecycle.ViewModel r1 = r1.getViewModel()
            com.baidu.searchbox.aisearch.comps.conversationmanager.dependents.ConversationManagerPanelVM r1 = (com.baidu.searchbox.aisearch.comps.conversationmanager.dependents.ConversationManagerPanelVM) r1
            com.baidu.searchbox.aisearch.comps.conversationmanager.item.ConversationManagerItemData r2 = r4.$itemData
            r1.deleteItem(r2)
        L_0x0042:
            com.baidu.searchbox.aisearch.comps.conversationmanager.ConversationManagerPanel r1 = r4.this$0
            com.baidu.searchbox.aisearch.comps.conversationmanager.ConversationManagerUBC r1 = r1.conversationManagerUBC
            java.lang.String r2 = "click"
            java.lang.String r3 = "delete"
            r1.deleteDialogEvent(r2, r3, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aisearch.comps.conversationmanager.ConversationManagerPanel$showDeleteDialog$2.invoke():void");
    }
}
