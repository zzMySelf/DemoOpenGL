package com.baidu.searchbox.sport.page.chatroom.repo.bim;

import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.mcast.IMEmojiReplyListener;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.sport.page.chatroom.model.SportChatLikeMsgKt;
import com.baidu.searchbox.sport.page.chatroom.model.SportChatLikeSendMsg;
import com.baidu.searchbox.sport.page.chatroom.model.SportChatSendMessage;
import com.baidu.searchbox.sport.page.chatroom.model.SportChatSendResult;
import com.baidu.searchbox.sport.page.chatroom.repo.bim.ChatMsgBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.SingleSubscriber;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/sport/page/chatroom/repo/bim/BimChatRoomService$sendEmojiMessage$1$1$1", "Lcom/baidu/searchbox/sport/page/chatroom/repo/bim/ChatMsgBuilder$BuildChatMsgCallback;", "onFailed", "", "t", "", "onSuccess", "chatMsg", "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsg;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BimChatRoomService.kt */
public final class BimChatRoomService$sendEmojiMessage$1$1$1 implements ChatMsgBuilder.BuildChatMsgCallback {
    final /* synthetic */ SportChatSendMessage $message;
    final /* synthetic */ SingleSubscriber<? super SportChatSendResult> $subscriber;
    final /* synthetic */ BimChatRoomService this$0;

    BimChatRoomService$sendEmojiMessage$1$1$1(SportChatSendMessage $message2, BimChatRoomService $receiver, SingleSubscriber<? super SportChatSendResult> $subscriber2) {
        this.$message = $message2;
        this.this$0 = $receiver;
        this.$subscriber = $subscriber2;
    }

    public void onSuccess(ChatMsg chatMsg) {
        Intrinsics.checkNotNullParameter(chatMsg, "chatMsg");
        IMEmojiReplyListener.IMEmojiReplyRequestInfo info = new IMEmojiReplyListener.IMEmojiReplyRequestInfo();
        info.msg = chatMsg;
        info.emojiContent = "like";
        info.emojiPackageId = 3;
        SportChatLikeSendMsg likeMsg = this.$message.getLikeMsg();
        info.opType = likeMsg != null ? likeMsg.getOpType() : -1;
        info.toUser = this.this$0.roomId;
        if (AppConfig.isDebug()) {
            StringBuilder append = new StringBuilder().append("发送点赞消息数据：");
            SportChatLikeSendMsg likeMsg2 = this.$message.getLikeMsg();
            Log.d(SportChatLikeMsgKt.LIKE_TAG, append.append(likeMsg2 != null ? likeMsg2.toString() : null).toString());
        }
        BIMManager.emojiReplyForChatRoom(this.this$0.context, info, new BimChatRoomService$sendEmojiMessage$1$1$1$onSuccess$1(this.$subscriber, this.$message));
    }

    public void onFailed(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        this.$subscriber.onError(t);
    }
}
