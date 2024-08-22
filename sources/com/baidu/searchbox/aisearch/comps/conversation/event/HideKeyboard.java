package com.baidu.searchbox.aisearch.comps.conversation.event;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversation/event/HideKeyboard;", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/IConversationInteractEvent;", "params", "Lorg/json/JSONObject;", "constructor-impl", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "getParams", "()Lorg/json/JSONObject;", "equals", "", "other", "", "equals-impl", "(Lorg/json/JSONObject;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lorg/json/JSONObject;)I", "toString", "", "toString-impl", "(Lorg/json/JSONObject;)Ljava/lang/String;", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: HideKeyboard.kt */
public final class HideKeyboard implements IConversationInteractEvent {
    private final JSONObject params;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ HideKeyboard m15493boximpl(JSONObject jSONObject) {
        return new HideKeyboard(jSONObject);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static JSONObject m15494constructorimpl(JSONObject jSONObject) {
        return jSONObject;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m15495equalsimpl(JSONObject jSONObject, Object obj) {
        return (obj instanceof HideKeyboard) && Intrinsics.areEqual((Object) jSONObject, (Object) ((HideKeyboard) obj).m15499unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m15496equalsimpl0(JSONObject jSONObject, JSONObject jSONObject2) {
        return Intrinsics.areEqual((Object) jSONObject, (Object) jSONObject2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m15497hashCodeimpl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m15498toStringimpl(JSONObject jSONObject) {
        return "HideKeyboard(params=" + jSONObject + ')';
    }

    public boolean equals(Object obj) {
        return m15495equalsimpl(this.params, obj);
    }

    public int hashCode() {
        return m15497hashCodeimpl(this.params);
    }

    public String toString() {
        return m15498toStringimpl(this.params);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ JSONObject m15499unboximpl() {
        return this.params;
    }

    private /* synthetic */ HideKeyboard(JSONObject params2) {
        this.params = params2;
    }

    public JSONObject getParams() {
        return this.params;
    }
}
