package com.baidu.searchbox.aisearch.comps.conversation.command;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversation/command/NewParams;", "Lcom/baidu/searchbox/aisearch/comps/conversation/command/IContainerCommand;", "url", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toProtocolJson", "Lorg/json/JSONObject;", "toProtocolJson-impl", "(Ljava/lang/String;)Lorg/json/JSONObject;", "toString", "toString-impl", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: NewParams.kt */
public final class NewParams implements IContainerCommand {
    private final String url;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ NewParams m15326boximpl(String str) {
        return new NewParams(str);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static String m15327constructorimpl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return str;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m15328equalsimpl(String str, Object obj) {
        return (obj instanceof NewParams) && Intrinsics.areEqual((Object) str, (Object) ((NewParams) obj).m15333unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m15329equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m15330hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m15332toStringimpl(String str) {
        return "NewParams(url=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m15328equalsimpl(this.url, obj);
    }

    public int hashCode() {
        return m15330hashCodeimpl(this.url);
    }

    public String toString() {
        return m15332toStringimpl(this.url);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m15333unboximpl() {
        return this.url;
    }

    private /* synthetic */ NewParams(String url2) {
        this.url = url2;
    }

    public JSONObject toProtocolJson() {
        return m15331toProtocolJsonimpl(this.url);
    }

    /* renamed from: toProtocolJson-impl  reason: not valid java name */
    public static JSONObject m15331toProtocolJsonimpl(String arg0) {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$toProtocolJson_impl_u24lambda_u2d1 = jSONObject;
        $this$toProtocolJson_impl_u24lambda_u2d1.put("name", "new-params");
        JSONObject $this$toProtocolJson_impl_u24lambda_u2d1_u24lambda_u2d0 = new JSONObject();
        $this$toProtocolJson_impl_u24lambda_u2d1_u24lambda_u2d0.put("url", arg0);
        Unit unit = Unit.INSTANCE;
        $this$toProtocolJson_impl_u24lambda_u2d1.put("params", $this$toProtocolJson_impl_u24lambda_u2d1_u24lambda_u2d0);
        return jSONObject;
    }
}
