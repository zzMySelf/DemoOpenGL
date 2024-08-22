package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.SortedSet;

@GwtIncompatible
public interface SortedMultisetBridge<E> extends Multiset<E> {
    SortedSet<E> elementSet();
}
