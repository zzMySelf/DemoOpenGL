package fe.mmm.qw.p024if.uk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: fe.mmm.qw.if.uk.qw  reason: invalid package */
public final class qw {
    @NotNull
    public static final Map<String, Object> ad(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != null) {
                if (obj instanceof JSONObject) {
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    linkedHashMap.put(next, ad((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    linkedHashMap.put(next, qw((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    Boolean bool = ((Boolean) obj).booleanValue() ? Boolean.TRUE : Boolean.FALSE;
                    Intrinsics.checkNotNullExpressionValue(bool, "if (tmp) java.lang.Boole…e java.lang.Boolean.FALSE");
                    linkedHashMap.put(next, bool);
                } else {
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    linkedHashMap.put(next, obj);
                }
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static final List<Object> qw(@NotNull JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        if (jSONArray.length() == 0) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = jSONArray.get(i2);
            if (obj != null) {
                if (obj instanceof JSONObject) {
                    arrayList.add(ad((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    arrayList.addAll(qw((JSONArray) obj));
                } else {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }
}
