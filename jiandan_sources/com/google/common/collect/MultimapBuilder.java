package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

@GwtCompatible
public abstract class MultimapBuilder<K0, V0> {
    public static final int DEFAULT_EXPECTED_KEYS = 8;

    public static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
        public final int expectedValuesPerKey;

        public ArrayListSupplier(int i2) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(i2, "expectedValuesPerKey");
        }

        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    public static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
        public final Class<V> clazz;

        public EnumSetSupplier(Class<V> cls) {
            this.clazz = (Class) Preconditions.checkNotNull(cls);
        }

        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }
    }

    public static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        public final int expectedValuesPerKey;

        public HashSetSupplier(int i2) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(i2, "expectedValuesPerKey");
        }

        public Set<V> get() {
            return Platform.newHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    public static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        public final int expectedValuesPerKey;

        public LinkedHashSetSupplier(int i2) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(i2, "expectedValuesPerKey");
        }

        public Set<V> get() {
            return Platform.newLinkedHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    public enum LinkedListSupplier implements Supplier<List<Object>> {
        INSTANCE;

        public static <V> Supplier<List<V>> instance() {
            return INSTANCE;
        }

        public List<Object> get() {
            return new LinkedList();
        }
    }

    public static abstract class MultimapBuilderWithKeys<K0> {
        public static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;

        public ListMultimapBuilder<K0, Object> arrayListValues() {
            return arrayListValues(2);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> createMap();

        public <V0 extends Enum<V0>> SetMultimapBuilder<K0, V0> enumSetValues(final Class<V0> cls) {
            Preconditions.checkNotNull(cls, "valueClass");
            return new SetMultimapBuilder<K0, V0>() {
                public <K extends K0, V extends V0> SetMultimap<K, V> build() {
                    return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new EnumSetSupplier(cls));
                }
            };
        }

        public SetMultimapBuilder<K0, Object> hashSetValues() {
            return hashSetValues(2);
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues() {
            return linkedHashSetValues(2);
        }

        public ListMultimapBuilder<K0, Object> linkedListValues() {
            return new ListMultimapBuilder<K0, Object>() {
                public <K extends K0, V> ListMultimap<K, V> build() {
                    return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.createMap(), LinkedListSupplier.instance());
                }
            };
        }

        public SortedSetMultimapBuilder<K0, Comparable> treeSetValues() {
            return treeSetValues(Ordering.natural());
        }

        public ListMultimapBuilder<K0, Object> arrayListValues(final int i2) {
            CollectPreconditions.checkNonnegative(i2, "expectedValuesPerKey");
            return new ListMultimapBuilder<K0, Object>() {
                public <K extends K0, V> ListMultimap<K, V> build() {
                    return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.createMap(), new ArrayListSupplier(i2));
                }
            };
        }

        public SetMultimapBuilder<K0, Object> hashSetValues(final int i2) {
            CollectPreconditions.checkNonnegative(i2, "expectedValuesPerKey");
            return new SetMultimapBuilder<K0, Object>() {
                public <K extends K0, V> SetMultimap<K, V> build() {
                    return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new HashSetSupplier(i2));
                }
            };
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues(final int i2) {
            CollectPreconditions.checkNonnegative(i2, "expectedValuesPerKey");
            return new SetMultimapBuilder<K0, Object>() {
                public <K extends K0, V> SetMultimap<K, V> build() {
                    return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new LinkedHashSetSupplier(i2));
                }
            };
        }

        public <V0> SortedSetMultimapBuilder<K0, V0> treeSetValues(final Comparator<V0> comparator) {
            Preconditions.checkNotNull(comparator, "comparator");
            return new SortedSetMultimapBuilder<K0, V0>() {
                public <K extends K0, V extends V0> SortedSetMultimap<K, V> build() {
                    return Multimaps.newSortedSetMultimap(MultimapBuilderWithKeys.this.createMap(), new TreeSetSupplier(comparator));
                }
            };
        }
    }

    public static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
        public final Comparator<? super V> comparator;

        public TreeSetSupplier(Comparator<? super V> comparator2) {
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }
    }

    public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> enumKeys(final Class<K0> cls) {
        Preconditions.checkNotNull(cls);
        return new MultimapBuilderWithKeys<K0>() {
            public <K extends K0, V> Map<K, Collection<V>> createMap() {
                return new EnumMap(cls);
            }
        };
    }

    public static MultimapBuilderWithKeys<Object> hashKeys() {
        return hashKeys(8);
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys() {
        return linkedHashKeys(8);
    }

    public static MultimapBuilderWithKeys<Comparable> treeKeys() {
        return treeKeys(Ordering.natural());
    }

    public abstract <K extends K0, V extends V0> Multimap<K, V> build();

    public <K extends K0, V extends V0> Multimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
        Multimap<K, V> build = build();
        build.putAll(multimap);
        return build;
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public ListMultimapBuilder() {
            super();
        }

        public abstract <K extends K0, V extends V0> ListMultimap<K, V> build();

        public <K extends K0, V extends V0> ListMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (ListMultimap) MultimapBuilder.super.build(multimap);
        }
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public SetMultimapBuilder() {
            super();
        }

        public abstract <K extends K0, V extends V0> SetMultimap<K, V> build();

        public <K extends K0, V extends V0> SetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SetMultimap) MultimapBuilder.super.build(multimap);
        }
    }

    public MultimapBuilder() {
    }

    public static MultimapBuilderWithKeys<Object> hashKeys(final int i2) {
        CollectPreconditions.checkNonnegative(i2, "expectedKeys");
        return new MultimapBuilderWithKeys<Object>() {
            public <K, V> Map<K, Collection<V>> createMap() {
                return Platform.newHashMapWithExpectedSize(i2);
            }
        };
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys(final int i2) {
        CollectPreconditions.checkNonnegative(i2, "expectedKeys");
        return new MultimapBuilderWithKeys<Object>() {
            public <K, V> Map<K, Collection<V>> createMap() {
                return Platform.newLinkedHashMapWithExpectedSize(i2);
            }
        };
    }

    public static <K0> MultimapBuilderWithKeys<K0> treeKeys(final Comparator<K0> comparator) {
        Preconditions.checkNotNull(comparator);
        return new MultimapBuilderWithKeys<K0>() {
            public <K extends K0, V> Map<K, Collection<V>> createMap() {
                return new TreeMap(comparator);
            }
        };
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
        public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> build();

        public <K extends K0, V extends V0> SortedSetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SortedSetMultimap) super.build((Multimap) multimap);
        }
    }
}
