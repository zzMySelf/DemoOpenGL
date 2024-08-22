package com.baidu.searchbox.player.property;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u00002\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00028\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/player/property/Property;", "T", "", "initState", "scope", "Lcom/baidu/searchbox/player/property/Scope;", "(Ljava/lang/Object;Lcom/baidu/searchbox/player/property/Scope;)V", "getScope", "()Lcom/baidu/searchbox/player/property/Scope;", "setScope", "(Lcom/baidu/searchbox/player/property/Scope;)V", "state", "Ljava/lang/Object;", "getState", "()Ljava/lang/Object;", "setState", "", "targetState", "notify", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerProperties.kt */
public class Property<T> {
    private Scope scope;
    private T state;

    public final void setState(T t) {
        setState$default(this, t, (Function0) null, 2, (Object) null);
    }

    public Property(T initState, Scope scope2) {
        Intrinsics.checkNotNullParameter(scope2, "scope");
        this.scope = scope2;
        this.state = initState;
    }

    public final Scope getScope() {
        return this.scope;
    }

    public final void setScope(Scope scope2) {
        Intrinsics.checkNotNullParameter(scope2, "<set-?>");
        this.scope = scope2;
    }

    public final T getState() {
        return this.state;
    }

    public static /* synthetic */ void setState$default(Property property, Object obj, Function0 function0, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                function0 = null;
            }
            property.setState(obj, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setState");
    }

    public final void setState(T targetState, Function0<Unit> notify) {
        this.state = targetState;
        if (notify != null) {
            notify.invoke();
        }
    }
}
