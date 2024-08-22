package com.baidu.talos.adaptee;

import com.baidu.talos.adapter.TokenizorInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/talos/adaptee/DefaultTokenizorAdapter;", "Lcom/baidu/talos/adapter/TokenizorInterface;", "()V", "cutString", "", "input", "isForceStringCutMode", "", "lib-talos-facade_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultTokenizorAdapter.kt */
public final class DefaultTokenizorAdapter implements TokenizorInterface {
    public String cutString(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return null;
    }

    public boolean isForceStringCutMode() {
        return false;
    }
}
