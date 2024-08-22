package com.baidu.chatsearch.menu.longpress.chatsearch;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0005"}, d2 = {"getExtObject", "Lorg/json/JSONObject;", "menuContext", "Lcom/baidu/chatsearch/menu/longpress/chatsearch/ChatLongPressMenuContext;", "ext", "lib-chatsearch-widget_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchLongPressMenuItem.kt */
public final class ChatSearchLongPressMenuItemKt {
    private static final JSONObject getExtObject(ChatLongPressMenuContext menuContext, JSONObject ext) {
        if (!(menuContext instanceof ChatSearchChatLongPressMenuContext)) {
            return ext;
        }
        CharSequence pd = ((ChatSearchChatLongPressMenuContext) menuContext).getPd();
        CharSequence charSequence = null;
        if (pd != null) {
            CharSequence charSequence2 = pd;
            if (!(charSequence2.length() == 0)) {
                charSequence = charSequence2;
            }
            charSequence = (String) charSequence;
        }
        CharSequence charSequence3 = charSequence;
        if (charSequence3 == null) {
            return ext;
        }
        JSONObject extJsonObject = ext == null ? new JSONObject() : ext;
        extJsonObject.put("pd", charSequence3);
        return extJsonObject;
    }
}
