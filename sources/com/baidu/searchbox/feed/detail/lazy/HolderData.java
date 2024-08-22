package com.baidu.searchbox.feed.detail.lazy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0003HÖ\u0001R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/feed/detail/lazy/HolderData;", "", "name", "", "id", "", "componentInflater", "Lkotlin/Function2;", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "(Ljava/lang/String;ILkotlin/jvm/functions/Function2;Landroid/view/ViewGroup$LayoutParams;)V", "getComponentInflater", "()Lkotlin/jvm/functions/Function2;", "getId", "()I", "getName", "()Ljava/lang/String;", "getParams", "()Landroid/view/ViewGroup$LayoutParams;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "inflateView", "view", "Lcom/baidu/searchbox/feed/detail/lazy/ComponentHolder;", "toString", "lib-component-arch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComponentHolder.kt */
public final class HolderData {
    private final Function2<String, Integer, View> componentInflater;
    private final int id;
    private final String name;
    private final ViewGroup.LayoutParams params;

    public static /* synthetic */ HolderData copy$default(HolderData holderData, String str, int i2, Function2<String, Integer, View> function2, ViewGroup.LayoutParams layoutParams, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = holderData.name;
        }
        if ((i3 & 2) != 0) {
            i2 = holderData.id;
        }
        if ((i3 & 4) != 0) {
            function2 = holderData.componentInflater;
        }
        if ((i3 & 8) != 0) {
            layoutParams = holderData.params;
        }
        return holderData.copy(str, i2, function2, layoutParams);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.id;
    }

    public final Function2<String, Integer, View> component3() {
        return this.componentInflater;
    }

    public final ViewGroup.LayoutParams component4() {
        return this.params;
    }

    public final HolderData copy(String str, int i2, Function2<? super String, ? super Integer, ? extends View> function2, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, "componentInflater");
        return new HolderData(str, i2, function2, layoutParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HolderData)) {
            return false;
        }
        HolderData holderData = (HolderData) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) holderData.name) && this.id == holderData.id && Intrinsics.areEqual((Object) this.componentInflater, (Object) holderData.componentInflater) && Intrinsics.areEqual((Object) this.params, (Object) holderData.params);
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + Integer.hashCode(this.id)) * 31) + this.componentInflater.hashCode()) * 31;
        ViewGroup.LayoutParams layoutParams = this.params;
        return hashCode + (layoutParams == null ? 0 : layoutParams.hashCode());
    }

    public String toString() {
        return "HolderData(name=" + this.name + ", id=" + this.id + ", componentInflater=" + this.componentInflater + ", params=" + this.params + ')';
    }

    public HolderData(String name2, int id2, Function2<? super String, ? super Integer, ? extends View> componentInflater2, ViewGroup.LayoutParams params2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(componentInflater2, "componentInflater");
        this.name = name2;
        this.id = id2;
        this.componentInflater = componentInflater2;
        this.params = params2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HolderData(String str, int i2, Function2 function2, ViewGroup.LayoutParams layoutParams, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i2, function2, (i3 & 8) != 0 ? null : layoutParams);
    }

    public final String getName() {
        return this.name;
    }

    public final int getId() {
        return this.id;
    }

    public final Function2<String, Integer, View> getComponentInflater() {
        return this.componentInflater;
    }

    public final ViewGroup.LayoutParams getParams() {
        return this.params;
    }

    public final View inflateView(ComponentHolder view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        ViewParent parent = view2.getParent();
        ViewGroup vg = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        int index = vg != null ? vg.indexOfChild(view2) : -1;
        if (index == -1) {
            return null;
        }
        if (vg != null) {
            vg.removeView(view2);
        }
        View inflateView = this.componentInflater.invoke(this.name, Integer.valueOf(this.id));
        if (inflateView == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = this.params;
        if (layoutParams != null) {
            if (vg != null) {
                vg.addView(inflateView, index, layoutParams);
            }
        } else if (vg != null) {
            vg.addView(inflateView, index);
        }
        return view2;
    }
}
