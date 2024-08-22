package com.baidu.searchbox.feed.template;

import com.baidu.searchbox.feed.core.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChattingRoomEntranceView.kt */
final class ChattingRoomEntranceView$roomStaticIcon$2 extends Lambda implements Function0<FeedDraweeView> {
    final /* synthetic */ ChattingRoomEntranceView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChattingRoomEntranceView$roomStaticIcon$2(ChattingRoomEntranceView chattingRoomEntranceView) {
        super(0);
        this.this$0 = chattingRoomEntranceView;
    }

    public final FeedDraweeView invoke() {
        return (FeedDraweeView) this.this$0.findViewById(R.id.feed_item_chatting_room_static_icon);
    }
}
