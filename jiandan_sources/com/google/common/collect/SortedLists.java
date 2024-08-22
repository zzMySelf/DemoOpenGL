package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
@Beta
public final class SortedLists {

    public enum KeyAbsentBehavior {
        NEXT_LOWER {
            public int resultIndex(int i2) {
                return i2 - 1;
            }
        },
        NEXT_HIGHER {
            public int resultIndex(int i2) {
                return i2;
            }
        },
        INVERTED_INSERTION_INDEX {
            public int resultIndex(int i2) {
                return ~i2;
            }
        };

        public abstract int resultIndex(int i2);
    }

    public enum KeyPresentBehavior {
        ANY_PRESENT {
            public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i2) {
                return i2;
            }
        },
        LAST_PRESENT {
            public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i2) {
                int size = list.size() - 1;
                while (i2 < size) {
                    int i3 = ((i2 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i3), e) > 0) {
                        size = i3 - 1;
                    } else {
                        i2 = i3;
                    }
                }
                return i2;
            }
        },
        FIRST_PRESENT {
            public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i2) {
                int i3 = 0;
                while (i3 < i2) {
                    int i4 = (i3 + i2) >>> 1;
                    if (comparator.compare(list.get(i4), e) < 0) {
                        i3 = i4 + 1;
                    } else {
                        i2 = i4;
                    }
                }
                return i3;
            }
        },
        FIRST_AFTER {
            public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i2) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e, list, i2) + 1;
            }
        },
        LAST_BEFORE {
            public <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i2) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e, list, i2) - 1;
            }
        };

        public abstract <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i2);
    }

    public static <E extends Comparable> int binarySearch(List<? extends E> list, E e, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(e);
        return binarySearch(list, e, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K extends Comparable> int binarySearch(List<E> list, Function<? super E, K> function, @NullableDecl K k, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return binarySearch(list, function, k, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int binarySearch(List<E> list, Function<? super E, K> function, @NullableDecl K k, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return binarySearch(Lists.transform(list, function), k, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int binarySearch(List<? extends E> list, @NullableDecl E e, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(keyPresentBehavior);
        Preconditions.checkNotNull(keyAbsentBehavior);
        boolean z = list instanceof RandomAccess;
        ArrayList<? extends E> arrayList = list;
        if (!z) {
            arrayList = Lists.newArrayList(list);
        }
        int i2 = 0;
        int size = arrayList.size() - 1;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int compare = comparator.compare(e, arrayList.get(i3));
            if (compare < 0) {
                size = i3 - 1;
            } else if (compare <= 0) {
                return i2 + keyPresentBehavior.resultIndex(comparator, e, arrayList.subList(i2, size + 1), i3 - i2);
            } else {
                i2 = i3 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i2);
    }
}
