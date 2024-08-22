package com.baidu.searchbox.video.detail.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u001a\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0004*\u0004\u0018\u00010\u0001\u001a\u0014\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002*\u0004\u0018\u00010\u0001\u001a\u001a\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b*\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"toJSONArray", "Lorg/json/JSONArray;", "", "toList", "T", "toSimpleArray", "", "toSimpleMap", "", "", "Lorg/json/JSONObject;", "lib-support_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsonTools.kt */
public final class JsonToolsKt {
    public static final Map<String, Object> toSimpleMap(JSONObject $this$toSimpleMap) {
        HashMap map = new HashMap();
        if ($this$toSimpleMap != null) {
            JSONObject it = $this$toSimpleMap;
            try {
                Iterator keys = it.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    Object value = it.get(key);
                    if (value instanceof JSONArray) {
                        value = toSimpleArray((JSONArray) value);
                    } else if (value instanceof JSONObject) {
                        value = toSimpleMap((JSONObject) value);
                    }
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    map.put(key, value);
                }
            } catch (Exception e2) {
            }
        }
        return map;
    }

    public static final List<Object> toSimpleArray(JSONArray $this$toSimpleArray) {
        List list = new ArrayList();
        if ($this$toSimpleArray != null) {
            JSONArray it = $this$toSimpleArray;
            int length = it.length();
            for (int i2 = 0; i2 < length; i2++) {
                Object value = it.get(i2);
                if (value instanceof JSONArray) {
                    value = toSimpleArray((JSONArray) value);
                } else if (value instanceof JSONObject) {
                    value = toSimpleMap((JSONObject) value);
                }
                list.add(value);
            }
        }
        return list;
    }

    public static final <T> List<T> toList(JSONArray $this$toList) {
        if ($this$toList == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            JSONArray $this$toList_u24lambda_u2d3 = $this$toList;
            List<T> arrayList = new ArrayList<>();
            int i2 = 0;
            int length = $this$toList_u24lambda_u2d3.length();
            while (true) {
                boolean z = true;
                if (i2 >= length) {
                    break;
                }
                Object data = $this$toList_u24lambda_u2d3.get(i2);
                if (data != null) {
                    z = data instanceof Object;
                }
                if (!z) {
                    data = null;
                }
                if (data != null) {
                    arrayList.add(data);
                }
                i2++;
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            Result.m8971constructorimpl(Unit.INSTANCE);
            return null;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public static final JSONArray toJSONArray(List<?> $this$toJSONArray) {
        if ($this$toJSONArray == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            List $this$toJSONArray_u24lambda_u2d4 = $this$toJSONArray;
            JSONArray array = new JSONArray();
            int size = $this$toJSONArray_u24lambda_u2d4.size();
            for (int i2 = 0; i2 < size; i2++) {
                array.put($this$toJSONArray_u24lambda_u2d4.get(i2));
            }
            return array;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
            return null;
        }
    }
}
