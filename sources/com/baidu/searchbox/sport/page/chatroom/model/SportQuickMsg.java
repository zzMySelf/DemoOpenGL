package com.baidu.searchbox.sport.page.chatroom.model;

import com.baidu.searchbox.talos.modules.chatroom.ChatRoomConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/sport/page/chatroom/model/SportQuickMsg;", "Ljava/io/Serializable;", "msg", "", "msgType", "(Ljava/lang/String;Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getMsgType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SportQuickMsg.kt */
public final class SportQuickMsg implements Serializable {
    private final String msg;
    private final String msgType;

    public static /* synthetic */ SportQuickMsg copy$default(SportQuickMsg sportQuickMsg, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sportQuickMsg.msg;
        }
        if ((i2 & 2) != 0) {
            str2 = sportQuickMsg.msgType;
        }
        return sportQuickMsg.copy(str, str2);
    }

    public final String component1() {
        return this.msg;
    }

    public final String component2() {
        return this.msgType;
    }

    public final SportQuickMsg copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(str2, ChatRoomConstant.KEY_MSG_TYPE);
        return new SportQuickMsg(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SportQuickMsg)) {
            return false;
        }
        SportQuickMsg sportQuickMsg = (SportQuickMsg) obj;
        return Intrinsics.areEqual((Object) this.msg, (Object) sportQuickMsg.msg) && Intrinsics.areEqual((Object) this.msgType, (Object) sportQuickMsg.msgType);
    }

    public int hashCode() {
        return (this.msg.hashCode() * 31) + this.msgType.hashCode();
    }

    public String toString() {
        return "SportQuickMsg(msg=" + this.msg + ", msgType=" + this.msgType + ')';
    }

    public SportQuickMsg(String msg2, String msgType2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(msgType2, ChatRoomConstant.KEY_MSG_TYPE);
        this.msg = msg2;
        this.msgType = msgType2;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getMsgType() {
        return this.msgType;
    }
}
