package com.baidu.searchbox.sport.page.chatroom.comp;

import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.page.chatroom.event.RecordFileDeletedEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatRecordFileManager.kt */
final class ChatRecordFileManager$deleteFilePath$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ boolean $needNotice;
    final /* synthetic */ ChatRecordFileManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatRecordFileManager$deleteFilePath$1(ChatRecordFileManager chatRecordFileManager, String str, boolean z) {
        super(0);
        this.this$0 = chatRecordFileManager;
        this.$filePath = str;
        this.$needNotice = z;
    }

    public final void invoke() {
        UniqueId $this$invoke_u24lambda_u2d0;
        if (this.this$0.deleteFile(this.$filePath) && this.$needNotice && ($this$invoke_u24lambda_u2d0 = this.this$0.token) != null) {
            BdEventBus.Companion.getDefault().post(new RecordFileDeletedEvent($this$invoke_u24lambda_u2d0, this.$filePath));
        }
    }
}
