package com.baidu.searchbox.video.feedflow.ad.router;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/router/NadFlowCmd;", "", "cmd", "", "needWholeCardInvoke", "", "(Ljava/lang/String;Z)V", "getCmd", "()Ljava/lang/String;", "getNeedWholeCardInvoke", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdRouterPlugin.kt */
public final class NadFlowCmd {
    private final String cmd;
    private final boolean needWholeCardInvoke;

    public static /* synthetic */ NadFlowCmd copy$default(NadFlowCmd nadFlowCmd, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = nadFlowCmd.cmd;
        }
        if ((i2 & 2) != 0) {
            z = nadFlowCmd.needWholeCardInvoke;
        }
        return nadFlowCmd.copy(str, z);
    }

    public final String component1() {
        return this.cmd;
    }

    public final boolean component2() {
        return this.needWholeCardInvoke;
    }

    public final NadFlowCmd copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "cmd");
        return new NadFlowCmd(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NadFlowCmd)) {
            return false;
        }
        NadFlowCmd nadFlowCmd = (NadFlowCmd) obj;
        return Intrinsics.areEqual((Object) this.cmd, (Object) nadFlowCmd.cmd) && this.needWholeCardInvoke == nadFlowCmd.needWholeCardInvoke;
    }

    public int hashCode() {
        int hashCode = this.cmd.hashCode() * 31;
        boolean z = this.needWholeCardInvoke;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "NadFlowCmd(cmd=" + this.cmd + ", needWholeCardInvoke=" + this.needWholeCardInvoke + ')';
    }

    public NadFlowCmd(String cmd2, boolean needWholeCardInvoke2) {
        Intrinsics.checkNotNullParameter(cmd2, "cmd");
        this.cmd = cmd2;
        this.needWholeCardInvoke = needWholeCardInvoke2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NadFlowCmd(String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? true : z);
    }

    public final String getCmd() {
        return this.cmd;
    }

    public final boolean getNeedWholeCardInvoke() {
        return this.needWholeCardInvoke;
    }
}
