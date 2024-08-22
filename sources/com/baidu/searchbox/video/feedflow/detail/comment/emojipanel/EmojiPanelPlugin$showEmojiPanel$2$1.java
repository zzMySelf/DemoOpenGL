package com.baidu.searchbox.video.feedflow.detail.comment.emojipanel;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.toast.ToastAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiPanelPlugin.kt */
final class EmojiPanelPlugin$showEmojiPanel$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EmojiPanelPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EmojiPanelPlugin$showEmojiPanel$2$1(EmojiPanelPlugin emojiPanelPlugin) {
        super(0);
        this.this$0 = emojiPanelPlugin;
    }

    public final void invoke() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(ToastAction.NetExc.INSTANCE);
        }
    }
}
