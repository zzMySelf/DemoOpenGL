package com.baidu.searchbox.aisearch.comps.conversationmanager;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversationmanager/ConversationManagerTab;", "", "tabId", "", "tabName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getTabId", "()Ljava/lang/String;", "getTabName", "CONVERSATION_LIST", "AI_BOT", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationManagerTab.kt */
public enum ConversationManagerTab {
    CONVERSATION_LIST("conversation_list", "对话列表"),
    AI_BOT("ai_bot", "我的应用");
    
    private final String tabId;
    private final String tabName;

    private ConversationManagerTab(String tabId2, String tabName2) {
        this.tabId = tabId2;
        this.tabName = tabName2;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }
}
