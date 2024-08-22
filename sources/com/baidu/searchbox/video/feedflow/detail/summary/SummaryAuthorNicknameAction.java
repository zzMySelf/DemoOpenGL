package com.baidu.searchbox.video.feedflow.detail.summary;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/summary/SummaryAuthorNicknameAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "cmd", "", "middleCmd", "kernelCacheKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCmd", "()Ljava/lang/String;", "getKernelCacheKey", "getMiddleCmd", "setMiddleCmd", "(Ljava/lang/String;)V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: SummaryAction.kt */
public final class SummaryAuthorNicknameAction implements Action {
    private final String cmd;
    private final String kernelCacheKey;
    private String middleCmd;

    public SummaryAuthorNicknameAction(String cmd2, String middleCmd2, String kernelCacheKey2) {
        Intrinsics.checkNotNullParameter(kernelCacheKey2, "kernelCacheKey");
        this.cmd = cmd2;
        this.middleCmd = middleCmd2;
        this.kernelCacheKey = kernelCacheKey2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SummaryAuthorNicknameAction(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getCmd() {
        return this.cmd;
    }

    public final String getMiddleCmd() {
        return this.middleCmd;
    }

    public final void setMiddleCmd(String str) {
        this.middleCmd = str;
    }

    public final String getKernelCacheKey() {
        return this.kernelCacheKey;
    }
}
