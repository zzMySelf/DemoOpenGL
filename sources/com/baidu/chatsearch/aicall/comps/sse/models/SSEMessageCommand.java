package com.baidu.chatsearch.aicall.comps.sse.models;

import com.baidu.chatsearch.aicall.comps.sse.command.IContainerCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0005HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0001HÂ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0001HÂ\u0003J3\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/sse/models/SSEMessageCommand;", "Lcom/baidu/chatsearch/aicall/comps/sse/command/IContainerCommand;", "businessParams", "Lorg/json/JSONObject;", "source", "", "content", "liveFigureInfo", "(Lorg/json/JSONObject;Ljava/lang/String;Lcom/baidu/chatsearch/aicall/comps/sse/command/IContainerCommand;Lcom/baidu/chatsearch/aicall/comps/sse/command/IContainerCommand;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toProtocolJson", "toString", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSERequestCommand.kt */
public final class SSEMessageCommand implements IContainerCommand {
    private final JSONObject businessParams;
    private final IContainerCommand content;
    private final IContainerCommand liveFigureInfo;
    private final String source;

    private final JSONObject component1() {
        return this.businessParams;
    }

    private final String component2() {
        return this.source;
    }

    private final IContainerCommand component3() {
        return this.content;
    }

    private final IContainerCommand component4() {
        return this.liveFigureInfo;
    }

    public static /* synthetic */ SSEMessageCommand copy$default(SSEMessageCommand sSEMessageCommand, JSONObject jSONObject, String str, IContainerCommand iContainerCommand, IContainerCommand iContainerCommand2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            jSONObject = sSEMessageCommand.businessParams;
        }
        if ((i2 & 2) != 0) {
            str = sSEMessageCommand.source;
        }
        if ((i2 & 4) != 0) {
            iContainerCommand = sSEMessageCommand.content;
        }
        if ((i2 & 8) != 0) {
            iContainerCommand2 = sSEMessageCommand.liveFigureInfo;
        }
        return sSEMessageCommand.copy(jSONObject, str, iContainerCommand, iContainerCommand2);
    }

    public final SSEMessageCommand copy(JSONObject jSONObject, String str, IContainerCommand iContainerCommand, IContainerCommand iContainerCommand2) {
        Intrinsics.checkNotNullParameter(jSONObject, "businessParams");
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(iContainerCommand, "content");
        return new SSEMessageCommand(jSONObject, str, iContainerCommand, iContainerCommand2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SSEMessageCommand)) {
            return false;
        }
        SSEMessageCommand sSEMessageCommand = (SSEMessageCommand) obj;
        return Intrinsics.areEqual((Object) this.businessParams, (Object) sSEMessageCommand.businessParams) && Intrinsics.areEqual((Object) this.source, (Object) sSEMessageCommand.source) && Intrinsics.areEqual((Object) this.content, (Object) sSEMessageCommand.content) && Intrinsics.areEqual((Object) this.liveFigureInfo, (Object) sSEMessageCommand.liveFigureInfo);
    }

    public int hashCode() {
        int hashCode = ((((this.businessParams.hashCode() * 31) + this.source.hashCode()) * 31) + this.content.hashCode()) * 31;
        IContainerCommand iContainerCommand = this.liveFigureInfo;
        return hashCode + (iContainerCommand == null ? 0 : iContainerCommand.hashCode());
    }

    public String toString() {
        return "SSEMessageCommand(businessParams=" + this.businessParams + ", source=" + this.source + ", content=" + this.content + ", liveFigureInfo=" + this.liveFigureInfo + ')';
    }

    public SSEMessageCommand(JSONObject businessParams2, String source2, IContainerCommand content2, IContainerCommand liveFigureInfo2) {
        Intrinsics.checkNotNullParameter(businessParams2, "businessParams");
        Intrinsics.checkNotNullParameter(source2, "source");
        Intrinsics.checkNotNullParameter(content2, "content");
        this.businessParams = businessParams2;
        this.source = source2;
        this.content = content2;
        this.liveFigureInfo = liveFigureInfo2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SSEMessageCommand(JSONObject jSONObject, String str, IContainerCommand iContainerCommand, IContainerCommand iContainerCommand2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, str, iContainerCommand, (i2 & 8) != 0 ? null : iContainerCommand2);
    }

    public JSONObject toProtocolJson() {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$toProtocolJson_u24lambda_u2d1 = jSONObject;
        $this$toProtocolJson_u24lambda_u2d1.put("content", this.content.toProtocolJson());
        $this$toProtocolJson_u24lambda_u2d1.put("businessParams", this.businessParams);
        $this$toProtocolJson_u24lambda_u2d1.put("source", this.source);
        IContainerCommand $this$toProtocolJson_u24lambda_u2d1_u24lambda_u2d0 = this.liveFigureInfo;
        if ($this$toProtocolJson_u24lambda_u2d1_u24lambda_u2d0 != null) {
            $this$toProtocolJson_u24lambda_u2d1.put("liveFigureInfo", $this$toProtocolJson_u24lambda_u2d1_u24lambda_u2d0.toProtocolJson());
        }
        return jSONObject;
    }
}
