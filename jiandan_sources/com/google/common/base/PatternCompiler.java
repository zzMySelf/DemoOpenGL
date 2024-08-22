package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;

@GwtIncompatible
public interface PatternCompiler {
    CommonPattern compile(String str);

    boolean isPcreLike();
}
