package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;

@GwtCompatible
public abstract class Escaper {
    public final Function<String, String> asFunction = new Function<String, String>() {
        public String apply(String str) {
            return Escaper.this.escape(str);
        }
    };

    public final Function<String, String> asFunction() {
        return this.asFunction;
    }

    public abstract String escape(String str);
}
