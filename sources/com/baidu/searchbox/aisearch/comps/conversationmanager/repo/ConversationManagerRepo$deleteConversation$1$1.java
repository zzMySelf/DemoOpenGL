package com.baidu.searchbox.aisearch.comps.conversationmanager.repo;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "json", "Lorg/json/JSONObject;", "invoke", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationManagerRepo.kt */
final class ConversationManagerRepo$deleteConversation$1$1 extends Lambda implements Function1<JSONObject, Boolean> {
    public static final ConversationManagerRepo$deleteConversation$1$1 INSTANCE = new ConversationManagerRepo$deleteConversation$1$1();

    ConversationManagerRepo$deleteConversation$1$1() {
        super(1);
    }

    public final Boolean invoke(JSONObject json) {
        boolean z = false;
        if (json != null && json.optInt("status", -1) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
