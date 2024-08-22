package com.baidu.searchbox.player.data;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@StableApi
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0006H\u0014J!\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00022\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0002J)\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00022\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/player/data/BigString;", "Lkotlin/properties/ReadWriteProperty;", "", "", "()V", "provider", "Lcom/baidu/searchbox/player/data/IBigStringProvider;", "getProvider", "()Lcom/baidu/searchbox/player/data/IBigStringProvider;", "provider$delegate", "Lkotlin/Lazy;", "createProvider", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BigString.kt */
public class BigString implements ReadWriteProperty<Object, String> {
    private final Lazy provider$delegate = LazyKt.lazy(new BigString$provider$2(this));

    private final IBigStringProvider getProvider() {
        return (IBigStringProvider) this.provider$delegate.getValue();
    }

    public String getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return getProvider().getData();
    }

    public void setValue(Object thisRef, KProperty<?> property, String value) {
        Intrinsics.checkNotNullParameter(property, "property");
        getProvider().setData(value);
    }

    /* access modifiers changed from: protected */
    public IBigStringProvider createProvider() {
        return new NativeStringProvider();
    }
}
