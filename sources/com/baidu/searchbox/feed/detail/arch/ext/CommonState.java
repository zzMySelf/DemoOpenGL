package com.baidu.searchbox.feed.detail.arch.ext;

import com.baidu.nps.main.manager.Bundle;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Consumer;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0017J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u000eJ\u001b\u0010\u0015\u001a\u00020\n\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0002\u001a\u0002H\u0016H\u0016¢\u0006\u0002\u0010\u0017J#\u0010\u0015\u001a\u00020\n\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u0002H\u0016H\u0016¢\u0006\u0002\u0010\u0019J#\u0010\u001a\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001a\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "data", "", "", "", "(Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "clear", "", "component1", "copy", "equals", "", "other", "getCurrentAction", "Lcom/baidu/searchbox/feed/detail/frame/Consumer;", "hashCode", "", "isActive", "put", "T", "(Ljava/lang/Object;)V", "key", "(Ljava/lang/String;Ljava/lang/Object;)V", "select", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Ljava/lang/String;)Ljava/lang/Object;", "toString", "lib-component-arch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonState.kt */
public final class CommonState extends AbsState {
    private final Map<String, Object> data;

    public static /* synthetic */ CommonState copy$default(CommonState commonState, Map<String, Object> map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = commonState.data;
        }
        return commonState.copy(map);
    }

    public final Map<String, Object> component1() {
        return this.data;
    }

    public final CommonState copy(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        return new CommonState(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CommonState) && Intrinsics.areEqual((Object) this.data, (Object) ((CommonState) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "CommonState(data=" + this.data + ')';
    }

    public CommonState(Map<String, Object> data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.data = data2;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    @Deprecated(message = "使用LiveData，不再遍历监听Action", replaceWith = @ReplaceWith(expression = "Consumer", imports = {"com.baidu.searchbox.feed.detail.frame.Consumer"}))
    public Consumer getCurrentAction() {
        return Consumer.INSTANCE;
    }

    public <T> void put(String key, T data2) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.data.put(key, data2);
    }

    public <T> void put(T data2) {
        if (data2 != null) {
            String key = data2.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            put(key, data2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    public <T> T select(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return cast(this.data.get(key));
    }

    public <T> T select(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, Bundle.EXTRA_KEY_CLAZZ);
        String name = clazz.getName();
        Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
        return select(name);
    }

    public void clear() {
        this.data.clear();
    }

    public final boolean isActive() {
        CoreState coreState = (CoreState) select(CoreState.class);
        return coreState != null && coreState.isActive();
    }
}
