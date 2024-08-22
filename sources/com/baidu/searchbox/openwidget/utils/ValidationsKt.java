package com.baidu.searchbox.openwidget.utils;

import com.baidu.searchbox.openwidget.model.OpenWidgetSize;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0016\u0010\n\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\"B\u0010\u0000\u001a6\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001j\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004`\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"VALID_SIZES", "Ljava/util/HashMap;", "Lkotlin/Pair;", "", "Lcom/baidu/searchbox/openwidget/model/OpenWidgetSize;", "Lkotlin/collections/HashMap;", "equalsJson", "", "", "other", "isValidAsWidgetSize", "toSize", "lib-openwidget_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Validations.kt */
public final class ValidationsKt {
    private static final HashMap<Pair<Integer, Integer>, OpenWidgetSize> VALID_SIZES = MapsKt.hashMapOf(TuplesKt.to(new Pair(4, 4), OpenWidgetSize.SIZE_LARGE), TuplesKt.to(new Pair(4, 2), OpenWidgetSize.SIZE_MEDIUM), TuplesKt.to(new Pair(2, 2), OpenWidgetSize.SIZE_SMALL), TuplesKt.to(new Pair(4, 1), OpenWidgetSize.SIZE_WIDE), TuplesKt.to(new Pair(1, 1), OpenWidgetSize.SIZE_TINY));

    public static final OpenWidgetSize toSize(Pair<Integer, Integer> $this$toSize) {
        Intrinsics.checkNotNullParameter($this$toSize, "<this>");
        OpenWidgetSize openWidgetSize = VALID_SIZES.get($this$toSize);
        return openWidgetSize == null ? OpenWidgetSize.SIZE_MEDIUM : openWidgetSize;
    }

    public static final boolean isValidAsWidgetSize(Pair<Integer, Integer> $this$isValidAsWidgetSize) {
        Intrinsics.checkNotNullParameter($this$isValidAsWidgetSize, "<this>");
        return VALID_SIZES.containsKey($this$isValidAsWidgetSize);
    }

    public static final boolean equalsJson(String $this$equalsJson, String other) {
        Intrinsics.checkNotNullParameter($this$equalsJson, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual((Object) $this$equalsJson, (Object) other)) {
            return true;
        }
        if ($this$equalsJson.length() != other.length()) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            JSONObject thisJson = new JSONObject($this$equalsJson);
            JSONObject otherJson = new JSONObject(other);
            if (!Intrinsics.areEqual((Object) thisJson.keys(), (Object) otherJson.keys())) {
                return false;
            }
            Iterator $this$forEach$iv = thisJson.keys();
            Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "thisJson.keys()");
            while ($this$forEach$iv.hasNext()) {
                String key = $this$forEach$iv.next();
                String string = thisJson.getString(key);
                Intrinsics.checkNotNullExpressionValue(string, "thisJson.getString(key)");
                String string2 = otherJson.getString(key);
                Intrinsics.checkNotNullExpressionValue(string2, "otherJson.getString(key)");
                if (!equalsJson(string, string2)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Object r0 = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            if (Result.m8977isFailureimpl(r0)) {
                r0 = false;
            }
            return ((Boolean) r0).booleanValue();
        }
    }
}
