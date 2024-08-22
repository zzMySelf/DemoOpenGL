package com.baidu.searchbox.resources;

import android.content.Context;
import com.baidu.searchbox.resources.CategoryValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003Bg\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012<\u0010\u0006\u001a8\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0007\u0012\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f\"\u00028\u0000¢\u0006\u0002\u0010\u0010J$\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u0015RD\u0010\u0006\u001a8\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/resources/ResourceGroup;", "T", "Lcom/baidu/searchbox/resources/CategoryValue;", "", "type", "Ljava/lang/Class;", "provider", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "category", "Landroid/content/Context;", "context", "values", "", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function2;[Lcom/baidu/searchbox/resources/CategoryValue;)V", "getType", "()Ljava/lang/Class;", "[Lcom/baidu/searchbox/resources/CategoryValue;", "get", "(ILandroid/content/Context;)Lcom/baidu/searchbox/resources/CategoryValue;", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: resources.kt */
public class ResourceGroup<T extends CategoryValue> {
    private final Function2<Integer, Context, T> provider;
    private final Class<? extends T> type;
    private final T[] values;

    public ResourceGroup(Class<? extends T> type2, Function2<? super Integer, ? super Context, ? extends T> provider2, T... values2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(values2, "values");
        this.type = type2;
        this.provider = provider2;
        this.values = values2;
    }

    public final Class<? extends T> getType() {
        return this.type;
    }

    public static /* synthetic */ CategoryValue get$default(ResourceGroup resourceGroup, int i2, Context context, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                context = null;
            }
            return resourceGroup.get(i2, context);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
    }

    public final T get(int category, Context context) {
        T t;
        CategoryValue[] categoryValueArr = this.values;
        int length = categoryValueArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                t = null;
                break;
            }
            t = categoryValueArr[i2];
            if (t.getCategory() == category) {
                break;
            }
            i2++;
        }
        if (t != null) {
            return t;
        }
        Function2<Integer, Context, T> function2 = this.provider;
        if (function2 != null) {
            return (CategoryValue) function2.invoke(Integer.valueOf(category), context);
        }
        return null;
    }
}
