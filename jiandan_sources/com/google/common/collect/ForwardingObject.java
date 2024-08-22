package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public abstract class ForwardingObject {
    public abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
