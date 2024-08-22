package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailShareBtnModel;", "Lcom/baidu/searchbox/NoProGuard;", "type", "", "text", "cmd", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCmd", "()Ljava/lang/String;", "getText", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class FlowDetailShareBtnModel implements NoProGuard {
    private final String cmd;
    private final String text;
    private final String type;

    public FlowDetailShareBtnModel() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FlowDetailShareBtnModel copy$default(FlowDetailShareBtnModel flowDetailShareBtnModel, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = flowDetailShareBtnModel.type;
        }
        if ((i2 & 2) != 0) {
            str2 = flowDetailShareBtnModel.text;
        }
        if ((i2 & 4) != 0) {
            str3 = flowDetailShareBtnModel.cmd;
        }
        return flowDetailShareBtnModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.cmd;
    }

    public final FlowDetailShareBtnModel copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(str3, "cmd");
        return new FlowDetailShareBtnModel(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowDetailShareBtnModel)) {
            return false;
        }
        FlowDetailShareBtnModel flowDetailShareBtnModel = (FlowDetailShareBtnModel) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) flowDetailShareBtnModel.type) && Intrinsics.areEqual((Object) this.text, (Object) flowDetailShareBtnModel.text) && Intrinsics.areEqual((Object) this.cmd, (Object) flowDetailShareBtnModel.cmd);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.text.hashCode()) * 31) + this.cmd.hashCode();
    }

    public String toString() {
        return "FlowDetailShareBtnModel(type=" + this.type + ", text=" + this.text + ", cmd=" + this.cmd + ')';
    }

    public FlowDetailShareBtnModel(String type2, String text2, String cmd2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(text2, "text");
        Intrinsics.checkNotNullParameter(cmd2, "cmd");
        this.type = type2;
        this.text = text2;
        this.cmd = cmd2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowDetailShareBtnModel(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getType() {
        return this.type;
    }

    public final String getText() {
        return this.text;
    }

    public final String getCmd() {
        return this.cmd;
    }
}
