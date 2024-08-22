package rx.internal.util;

import rx.functions.Func1;

public final class UtilityFunctions {

    public enum AlwaysFalse implements Func1<Object, Boolean> {
        INSTANCE;

        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    public enum AlwaysTrue implements Func1<Object, Boolean> {
        INSTANCE;

        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }

    public enum Identity implements Func1<Object, Object> {
        INSTANCE;

        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> Func1<T, T> ad() {
        return Identity.INSTANCE;
    }

    public static <T> Func1<? super T, Boolean> qw() {
        return AlwaysTrue.INSTANCE;
    }
}
