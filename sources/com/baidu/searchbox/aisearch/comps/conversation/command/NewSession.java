package com.baidu.searchbox.aisearch.comps.conversation.command;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u0004\u0018\u00010\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversation/command/NewSession;", "Lcom/baidu/searchbox/aisearch/comps/conversation/command/IContainerCommand;", "params", "Lorg/json/JSONObject;", "constructor-impl", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "equals", "", "other", "", "equals-impl", "(Lorg/json/JSONObject;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lorg/json/JSONObject;)I", "toProtocolJson", "toProtocolJson-impl", "toString", "", "toString-impl", "(Lorg/json/JSONObject;)Ljava/lang/String;", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: NewSession.kt */
public final class NewSession implements IContainerCommand {
    private final JSONObject params;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ NewSession m15334boximpl(JSONObject jSONObject) {
        return new NewSession(jSONObject);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static JSONObject m15335constructorimpl(JSONObject jSONObject) {
        return jSONObject;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m15337equalsimpl(JSONObject jSONObject, Object obj) {
        return (obj instanceof NewSession) && Intrinsics.areEqual((Object) jSONObject, (Object) ((NewSession) obj).m15342unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m15338equalsimpl0(JSONObject jSONObject, JSONObject jSONObject2) {
        return Intrinsics.areEqual((Object) jSONObject, (Object) jSONObject2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m15339hashCodeimpl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.hashCode();
    }

    public boolean equals(Object obj) {
        return m15337equalsimpl(this.params, obj);
    }

    public int hashCode() {
        return m15339hashCodeimpl(this.params);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ JSONObject m15342unboximpl() {
        return this.params;
    }

    private /* synthetic */ NewSession(JSONObject params2) {
        this.params = params2;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ JSONObject m15336constructorimpl$default(JSONObject jSONObject, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != 0) {
            jSONObject = null;
        }
        return m15335constructorimpl(jSONObject);
    }

    public JSONObject toProtocolJson() {
        return m15340toProtocolJsonimpl(this.params);
    }

    /* renamed from: toProtocolJson-impl  reason: not valid java name */
    public static JSONObject m15340toProtocolJsonimpl(JSONObject arg0) {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$toProtocolJson_impl_u24lambda_u2d1 = jSONObject;
        $this$toProtocolJson_impl_u24lambda_u2d1.put("name", "new-session");
        if (arg0 != null) {
            $this$toProtocolJson_impl_u24lambda_u2d1.put("params", arg0);
        }
        return jSONObject;
    }

    public String toString() {
        return m15341toStringimpl(this.params);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m15341toStringimpl(JSONObject arg0) {
        if (arg0 != null) {
            return "NewSession(params=" + arg0 + ')';
        }
        return "NewSession()";
    }
}
