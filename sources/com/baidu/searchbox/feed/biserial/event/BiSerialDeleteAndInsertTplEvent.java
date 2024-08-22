package com.baidu.searchbox.feed.biserial.event;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\u0002\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/feed/biserial/event/BiSerialDeleteAndInsertTplEvent;", "", "msgId", "", "id", "", "relatedList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "Lkotlin/collections/ArrayList;", "(ILjava/lang/String;Ljava/util/ArrayList;)V", "arg0", "getArg0", "()I", "setArg0", "(I)V", "list", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "messageId", "getMessageId", "setMessageId", "nid", "getNid", "()Ljava/lang/String;", "setNid", "(Ljava/lang/String;)V", "Companion", "lib-feed-biserial_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiSerialDeleteAndInsertTplEvent.kt */
public final class BiSerialDeleteAndInsertTplEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MSG_PROBING_CARD_DELETE_AND_INSERT = 1;
    private int arg0;
    private ArrayList<FeedBaseModel> list;
    private int messageId;
    private String nid;

    public BiSerialDeleteAndInsertTplEvent(int msgId, String id, ArrayList<FeedBaseModel> relatedList) {
        this.messageId = msgId;
        this.nid = id;
        this.list = relatedList;
    }

    public final int getMessageId() {
        return this.messageId;
    }

    public final void setMessageId(int i2) {
        this.messageId = i2;
    }

    public final int getArg0() {
        return this.arg0;
    }

    public final void setArg0(int i2) {
        this.arg0 = i2;
    }

    public final String getNid() {
        return this.nid;
    }

    public final void setNid(String str) {
        this.nid = str;
    }

    public final ArrayList<FeedBaseModel> getList() {
        return this.list;
    }

    public final void setList(ArrayList<FeedBaseModel> arrayList) {
        this.list = arrayList;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/feed/biserial/event/BiSerialDeleteAndInsertTplEvent$Companion;", "", "()V", "MSG_PROBING_CARD_DELETE_AND_INSERT", "", "lib-feed-biserial_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BiSerialDeleteAndInsertTplEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
