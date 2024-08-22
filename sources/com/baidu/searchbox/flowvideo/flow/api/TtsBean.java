package com.baidu.searchbox.flowvideo.flow.api;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.feed.dependency.iocimpl.feedtts.FeedTtsContextImpl;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/flowvideo/flow/api/TtsBean;", "Lcom/baidu/searchbox/NoProGuard;", "horizontalCover", "", "shareInfo", "isFitListen", "", "returnCmd", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getHorizontalCover", "()Ljava/lang/String;", "()I", "getReturnCmd", "getShareInfo", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowListBean.kt */
public final class TtsBean implements NoProGuard {
    private final String horizontalCover;
    @SerializedName("voice_broadcast")
    private final int isFitListen;
    private final String returnCmd;
    private final String shareInfo;

    public TtsBean() {
        this((String) null, (String) null, 0, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public TtsBean(String horizontalCover2, String shareInfo2, int isFitListen2, String returnCmd2) {
        Intrinsics.checkNotNullParameter(horizontalCover2, "horizontalCover");
        Intrinsics.checkNotNullParameter(shareInfo2, "shareInfo");
        Intrinsics.checkNotNullParameter(returnCmd2, FeedTtsContextImpl.RETURN_CMD);
        this.horizontalCover = horizontalCover2;
        this.shareInfo = shareInfo2;
        this.isFitListen = isFitListen2;
        this.returnCmd = returnCmd2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TtsBean(String str, String str2, int i2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? "" : str3);
    }

    public final String getHorizontalCover() {
        return this.horizontalCover;
    }

    public final String getShareInfo() {
        return this.shareInfo;
    }

    public final int isFitListen() {
        return this.isFitListen;
    }

    public final String getReturnCmd() {
        return this.returnCmd;
    }
}
