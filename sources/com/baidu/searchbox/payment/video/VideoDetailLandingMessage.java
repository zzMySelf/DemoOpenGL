package com.baidu.searchbox.payment.video;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/payment/video/VideoDetailLandingMessage;", "", "type", "", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPaymentMessage.kt */
public final class VideoDetailLandingMessage {
    private final String type;

    public static /* synthetic */ VideoDetailLandingMessage copy$default(VideoDetailLandingMessage videoDetailLandingMessage, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = videoDetailLandingMessage.type;
        }
        return videoDetailLandingMessage.copy(str);
    }

    public final String component1() {
        return this.type;
    }

    public final VideoDetailLandingMessage copy(@VideoDetailLandingType String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return new VideoDetailLandingMessage(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VideoDetailLandingMessage) && Intrinsics.areEqual((Object) this.type, (Object) ((VideoDetailLandingMessage) obj).type);
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "VideoDetailLandingMessage(type=" + this.type + ')';
    }

    public VideoDetailLandingMessage(@VideoDetailLandingType String type2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        this.type = type2;
    }

    public final String getType() {
        return this.type;
    }
}
