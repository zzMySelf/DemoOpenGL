package com.baidu.talos.jni;

import java.util.Iterator;
import javax.annotation.Nullable;

public class IteratorHelper {
    @Nullable
    private Object mElement;
    private final Iterator mIterator;

    public IteratorHelper(Iterator iterator) {
        this.mIterator = iterator;
    }

    public IteratorHelper(Iterable iterable) {
        this.mIterator = iterable.iterator();
    }

    /* access modifiers changed from: package-private */
    public boolean hasNext() {
        if (this.mIterator.hasNext()) {
            this.mElement = this.mIterator.next();
            return true;
        }
        this.mElement = null;
        return false;
    }
}
