package com.baidu.searchbox.sport.page.chatroom.comp.item.textitem.selfitem;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.sport.page.chatroom.comp.item.base.self.BaseSelfChatMsgComp;
import com.baidu.searchbox.sport.page.chatroom.comp.item.base.self.BaseSelfChatMsgVM;
import com.baidu.searchbox.sport.utils.SportUIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/sport/page/chatroom/comp/item/textitem/selfitem/ChatSelfMsgComp;", "Lcom/baidu/searchbox/sport/page/chatroom/comp/item/base/self/BaseSelfChatMsgComp;", "Lcom/baidu/searchbox/sport/page/chatroom/comp/item/textitem/selfitem/ChatSelfMsgModel;", "Lcom/baidu/searchbox/sport/page/chatroom/comp/item/base/self/BaseSelfChatMsgVM;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "itemView", "Landroid/view/View;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;)V", "onContentChanged", "", "content", "", "onCreateViewModel", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSelfMsgComp.kt */
public final class ChatSelfMsgComp extends BaseSelfChatMsgComp<ChatSelfMsgModel, BaseSelfChatMsgVM<ChatSelfMsgModel>> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatSelfMsgComp(LifecycleOwner owner, View itemView) {
        super(owner, itemView);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public BaseSelfChatMsgVM<ChatSelfMsgModel> onCreateViewModel() {
        return new BaseSelfChatMsgVM<>();
    }

    /* access modifiers changed from: protected */
    public void onContentChanged(String content) {
        super.onContentChanged(content);
        View view2 = getView();
        CharSequence charSequence = content;
        int i2 = 0;
        if (!(charSequence == null || charSequence.length() == 0)) {
            i2 = -2;
        }
        SportUIUtils.setLayoutParamsHeight(view2, i2);
    }
}
