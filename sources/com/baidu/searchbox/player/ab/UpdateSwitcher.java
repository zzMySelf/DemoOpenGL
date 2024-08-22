package com.baidu.searchbox.player.ab;

import com.baidu.searchbox.player.data.KVData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J$\u0010\t\u001a\u00028\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002¢\u0006\u0002\u0010\u0011R\u001b\u0010\b\u001a\u00028\u00008BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/player/ab/UpdateSwitcher;", "V", "Lcom/baidu/searchbox/player/data/KVData;", "key", "", "defaultValue", "spName", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "value", "getValue", "()Ljava/lang/Object;", "value$delegate", "Lkotlin/Lazy;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "lib-player-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpdateSwitcher.kt */
public class UpdateSwitcher<V> extends KVData<V> {
    private final Lazy value$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpdateSwitcher(String key, V defaultValue, String spName) {
        super(key, defaultValue, new KVStorageDataProvider(spName));
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(spName, "spName");
        this.value$delegate = LazyKt.lazy(new UpdateSwitcher$value$2(this, key, defaultValue));
    }

    private final V getValue() {
        return this.value$delegate.getValue();
    }

    public V getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return getValue();
    }
}
