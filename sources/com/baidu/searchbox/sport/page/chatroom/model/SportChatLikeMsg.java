package com.baidu.searchbox.sport.page.chatroom.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/sport/page/chatroom/model/SportChatLikeMsg;", "", "likeCount", "", "reactType", "msgId", "", "emojiPackageId", "(IIJI)V", "getEmojiPackageId", "()I", "setEmojiPackageId", "(I)V", "getLikeCount", "setLikeCount", "getMsgId", "()J", "setMsgId", "(J)V", "getReactType", "setReactType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SportChatLikeMsg.kt */
public final class SportChatLikeMsg {
    private int emojiPackageId;
    private int likeCount;
    private long msgId;
    private int reactType;

    public SportChatLikeMsg() {
        this(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SportChatLikeMsg copy$default(SportChatLikeMsg sportChatLikeMsg, int i2, int i3, long j2, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = sportChatLikeMsg.likeCount;
        }
        if ((i5 & 2) != 0) {
            i3 = sportChatLikeMsg.reactType;
        }
        int i6 = i3;
        if ((i5 & 4) != 0) {
            j2 = sportChatLikeMsg.msgId;
        }
        long j3 = j2;
        if ((i5 & 8) != 0) {
            i4 = sportChatLikeMsg.emojiPackageId;
        }
        return sportChatLikeMsg.copy(i2, i6, j3, i4);
    }

    public final int component1() {
        return this.likeCount;
    }

    public final int component2() {
        return this.reactType;
    }

    public final long component3() {
        return this.msgId;
    }

    public final int component4() {
        return this.emojiPackageId;
    }

    public final SportChatLikeMsg copy(int i2, int i3, long j2, int i4) {
        return new SportChatLikeMsg(i2, i3, j2, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SportChatLikeMsg)) {
            return false;
        }
        SportChatLikeMsg sportChatLikeMsg = (SportChatLikeMsg) obj;
        return this.likeCount == sportChatLikeMsg.likeCount && this.reactType == sportChatLikeMsg.reactType && this.msgId == sportChatLikeMsg.msgId && this.emojiPackageId == sportChatLikeMsg.emojiPackageId;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.likeCount) * 31) + Integer.hashCode(this.reactType)) * 31) + Long.hashCode(this.msgId)) * 31) + Integer.hashCode(this.emojiPackageId);
    }

    public SportChatLikeMsg(int likeCount2, int reactType2, long msgId2, int emojiPackageId2) {
        this.likeCount = likeCount2;
        this.reactType = reactType2;
        this.msgId = msgId2;
        this.emojiPackageId = emojiPackageId2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SportChatLikeMsg(int r4, int r5, long r6, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0005
            r4 = 0
        L_0x0005:
            r10 = r9 & 2
            r0 = -1
            if (r10 == 0) goto L_0x000c
            r10 = r0
            goto L_0x000d
        L_0x000c:
            r10 = r5
        L_0x000d:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0015
            r6 = -1
            r1 = r6
            goto L_0x0016
        L_0x0015:
            r1 = r6
        L_0x0016:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r8
        L_0x001c:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r10 = r0
            r5.<init>(r6, r7, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.sport.page.chatroom.model.SportChatLikeMsg.<init>(int, int, long, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final void setLikeCount(int i2) {
        this.likeCount = i2;
    }

    public final int getReactType() {
        return this.reactType;
    }

    public final void setReactType(int i2) {
        this.reactType = i2;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    public final void setMsgId(long j2) {
        this.msgId = j2;
    }

    public final int getEmojiPackageId() {
        return this.emojiPackageId;
    }

    public final void setEmojiPackageId(int i2) {
        this.emojiPackageId = i2;
    }

    public String toString() {
        return "likeCount：" + this.likeCount + "，reactType：" + this.reactType + "，msgId：" + this.msgId + "，emojiPackageId：" + this.emojiPackageId;
    }
}
