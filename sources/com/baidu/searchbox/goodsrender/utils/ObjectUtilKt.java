package com.baidu.searchbox.goodsrender.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002¢\u0006\u0002\u0010\u0003\u001a'\u0010\u0004\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\u001f\u0010\f\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002¢\u0006\u0002\u0010\u0003\u001a$\u0010\r\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001*\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000fH\bø\u0001\u0000\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0012\u001a$\u0010\u0013\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001*\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000fH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0014"}, d2 = {"firstItem", "T", "", "(Ljava/util/List;)Ljava/lang/Object;", "getByIndex", "", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "isArrayEmpty", "", "", "lastItem", "no", "action", "Lkotlin/Function0;", "toSecondStr", "", "", "yes", "lib_render_sdk_impl_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ObjectUtil.kt */
public final class ObjectUtilKt {
    public static final <T> boolean yes(boolean $this$yes, Function0<? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if ($this$yes) {
            action.invoke();
        }
        return $this$yes;
    }

    public static final <T> boolean no(boolean $this$no, Function0<? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!$this$no) {
            action.invoke();
        }
        return $this$no;
    }

    public static final <T> T getByIndex(List<? extends T> $this$getByIndex, int index) {
        Intrinsics.checkNotNullParameter($this$getByIndex, "<this>");
        if (!(!$this$getByIndex.isEmpty()) || index < 0 || index >= $this$getByIndex.size()) {
            return null;
        }
        return $this$getByIndex.get(index);
    }

    public static final <T> T lastItem(List<T> $this$lastItem) {
        Intrinsics.checkNotNullParameter($this$lastItem, "<this>");
        if (!$this$lastItem.isEmpty()) {
            return CollectionsKt.last($this$lastItem);
        }
        return null;
    }

    public static final <T> T firstItem(List<T> $this$firstItem) {
        Intrinsics.checkNotNullParameter($this$firstItem, "<this>");
        if (!$this$firstItem.isEmpty()) {
            return CollectionsKt.first($this$firstItem);
        }
        return null;
    }

    public static final String toSecondStr(long $this$toSecondStr) {
        return String.valueOf(((double) $this$toSecondStr) / ((double) 1000));
    }

    public static final boolean isArrayEmpty(float[] $this$isArrayEmpty) {
        Intrinsics.checkNotNullParameter($this$isArrayEmpty, "<this>");
        int zeroBits = Float.floatToIntBits(0.0f);
        for (float v : $this$isArrayEmpty) {
            if (Float.floatToIntBits(v) != zeroBits) {
                return false;
            }
        }
        return true;
    }
}
