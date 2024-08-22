package com.baidu.searchbox.aisearch.comps.conversation.command;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@JvmInline
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u0004\u0018\u00010\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversation/command/SessionDeleted;", "Lcom/baidu/searchbox/aisearch/comps/conversation/command/IContainerCommand;", "params", "Lorg/json/JSONObject;", "constructor-impl", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "equals", "", "other", "", "equals-impl", "(Lorg/json/JSONObject;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lorg/json/JSONObject;)I", "toProtocolJson", "toProtocolJson-impl", "toString", "", "toString-impl", "(Lorg/json/JSONObject;)Ljava/lang/String;", "Companion", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SessionDeleted.kt */
public final class SessionDeleted implements IContainerCommand {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final JSONObject params;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ SessionDeleted m15364boximpl(JSONObject jSONObject) {
        return new SessionDeleted(jSONObject);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static JSONObject m15365constructorimpl(JSONObject jSONObject) {
        return jSONObject;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m15367equalsimpl(JSONObject jSONObject, Object obj) {
        return (obj instanceof SessionDeleted) && Intrinsics.areEqual((Object) jSONObject, (Object) ((SessionDeleted) obj).m15372unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m15368equalsimpl0(JSONObject jSONObject, JSONObject jSONObject2) {
        return Intrinsics.areEqual((Object) jSONObject, (Object) jSONObject2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m15369hashCodeimpl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.hashCode();
    }

    public boolean equals(Object obj) {
        return m15367equalsimpl(this.params, obj);
    }

    public int hashCode() {
        return m15369hashCodeimpl(this.params);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ JSONObject m15372unboximpl() {
        return this.params;
    }

    private /* synthetic */ SessionDeleted(JSONObject params2) {
        this.params = params2;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ JSONObject m15366constructorimpl$default(JSONObject jSONObject, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != 0) {
            jSONObject = null;
        }
        return m15365constructorimpl(jSONObject);
    }

    public JSONObject toProtocolJson() {
        return m15370toProtocolJsonimpl(this.params);
    }

    /* renamed from: toProtocolJson-impl  reason: not valid java name */
    public static JSONObject m15370toProtocolJsonimpl(JSONObject arg0) {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$toProtocolJson_impl_u24lambda_u2d1 = jSONObject;
        $this$toProtocolJson_impl_u24lambda_u2d1.put("name", "session-deleted");
        if (arg0 != null) {
            $this$toProtocolJson_impl_u24lambda_u2d1.put("params", arg0);
        }
        return jSONObject;
    }

    public String toString() {
        return m15371toStringimpl(this.params);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m15371toStringimpl(JSONObject arg0) {
        if (arg0 != null) {
            return "SessionDeleted(params=" + arg0 + ')';
        }
        return "SessionDeleted()";
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversation/command/SessionDeleted$Companion;", "", "()V", "deleteAll", "Lcom/baidu/searchbox/aisearch/comps/conversation/command/SessionDeleted;", "deleteAll-penMeF0", "()Lorg/json/JSONObject;", "deleteSingle", "sessionId", "", "deleteSingle-2JfPbjM", "(Ljava/lang/String;)Lorg/json/JSONObject;", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SessionDeleted.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: deleteSingle-2JfPbjM  reason: not valid java name */
        public final JSONObject m15374deleteSingle2JfPbjM(String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return SessionDeleted.m15365constructorimpl(new JSONObject().put("sessionId", sessionId).put("type", 0));
        }

        /* renamed from: deleteAll-penMeF0  reason: not valid java name */
        public final JSONObject m15373deleteAllpenMeF0() {
            return SessionDeleted.m15365constructorimpl(new JSONObject().put("type", 1));
        }
    }
}
