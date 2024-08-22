package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible(emulated = true)
public final class LongAddables {
    public static final Supplier<LongAddable> SUPPLIER;

    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        public PureJavaLongAddable() {
        }

        public void add(long j) {
            getAndAdd(j);
        }

        public void increment() {
            getAndIncrement();
        }

        public long sum() {
            return get();
        }
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() {
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            supplier = new Supplier<LongAddable>() {
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        SUPPLIER = supplier;
    }

    public static LongAddable create() {
        return SUPPLIER.get();
    }
}
