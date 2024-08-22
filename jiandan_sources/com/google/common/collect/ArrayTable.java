package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
@Beta
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    public static final long serialVersionUID = 0;
    public final V[][] array;
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    public final ImmutableList<C> columnList;
    @MonotonicNonNullDecl
    public transient ArrayTable<R, C, V>.ColumnMap columnMap;
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    public final ImmutableList<R> rowList;
    @MonotonicNonNullDecl
    public transient ArrayTable<R, C, V>.RowMap rowMap;

    public static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {
        public final ImmutableMap<K, Integer> keyIndex;

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean containsKey(@NullableDecl Object obj) {
            return this.keyIndex.containsKey(obj);
        }

        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new AbstractIndexedListIterator<Map.Entry<K, V>>(size()) {
                public Map.Entry<K, V> get(int i2) {
                    return ArrayMap.this.getEntry(i2);
                }
            };
        }

        public V get(@NullableDecl Object obj) {
            Integer num = this.keyIndex.get(obj);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        public Map.Entry<K, V> getEntry(final int i2) {
            Preconditions.checkElementIndex(i2, size());
            return new AbstractMapEntry<K, V>() {
                public K getKey() {
                    return ArrayMap.this.getKey(i2);
                }

                public V getValue() {
                    return ArrayMap.this.getValue(i2);
                }

                public V setValue(V v) {
                    return ArrayMap.this.setValue(i2, v);
                }
            };
        }

        public K getKey(int i2) {
            return this.keyIndex.keySet().asList().get(i2);
        }

        public abstract String getKeyRole();

        @NullableDecl
        public abstract V getValue(int i2);

        public boolean isEmpty() {
            return this.keyIndex.isEmpty();
        }

        public Set<K> keySet() {
            return this.keyIndex.keySet();
        }

        public V put(K k, V v) {
            Integer num = this.keyIndex.get(k);
            if (num != null) {
                return setValue(num.intValue(), v);
            }
            throw new IllegalArgumentException(getKeyRole() + " " + k + " not in " + this.keyIndex.keySet());
        }

        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @NullableDecl
        public abstract V setValue(int i2, V v);

        public int size() {
            return this.keyIndex.size();
        }

        public ArrayMap(ImmutableMap<K, Integer> immutableMap) {
            this.keyIndex = immutableMap;
        }
    }

    public class Column extends ArrayMap<R, V> {
        public final int columnIndex;

        public Column(int i2) {
            super(ArrayTable.this.rowKeyToIndex);
            this.columnIndex = i2;
        }

        public String getKeyRole() {
            return "Row";
        }

        public V getValue(int i2) {
            return ArrayTable.this.at(i2, this.columnIndex);
        }

        public V setValue(int i2, V v) {
            return ArrayTable.this.set(i2, this.columnIndex, v);
        }
    }

    public class ColumnMap extends ArrayMap<C, Map<R, V>> {
        public String getKeyRole() {
            return "Column";
        }

        public ColumnMap() {
            super(ArrayTable.this.columnKeyToIndex);
        }

        public Map<R, V> getValue(int i2) {
            return new Column(i2);
        }

        public Map<R, V> put(C c, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<R, V> setValue(int i2, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    public class Row extends ArrayMap<C, V> {
        public final int rowIndex;

        public Row(int i2) {
            super(ArrayTable.this.columnKeyToIndex);
            this.rowIndex = i2;
        }

        public String getKeyRole() {
            return "Column";
        }

        public V getValue(int i2) {
            return ArrayTable.this.at(this.rowIndex, i2);
        }

        public V setValue(int i2, V v) {
            return ArrayTable.this.set(this.rowIndex, i2, v);
        }
    }

    public class RowMap extends ArrayMap<R, Map<C, V>> {
        public String getKeyRole() {
            return "Row";
        }

        public RowMap() {
            super(ArrayTable.this.rowKeyToIndex);
        }

        public Map<C, V> getValue(int i2) {
            return new Row(i2);
        }

        public Map<C, V> put(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V> setValue(int i2, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    public ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        this.rowList = ImmutableList.copyOf(iterable);
        this.columnList = ImmutableList.copyOf(iterable2);
        Preconditions.checkArgument(this.rowList.isEmpty() == this.columnList.isEmpty());
        this.rowKeyToIndex = Maps.indexMap(this.rowList);
        this.columnKeyToIndex = Maps.indexMap(this.columnList);
        int size = this.rowList.size();
        int[] iArr = new int[2];
        iArr[1] = this.columnList.size();
        iArr[0] = size;
        this.array = (Object[][]) Array.newInstance(Object.class, iArr);
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* access modifiers changed from: private */
    public Table.Cell<R, C, V> getCell(final int i2) {
        return new Tables.AbstractCell<R, C, V>() {
            public final int columnIndex = (i2 % ArrayTable.this.columnList.size());
            public final int rowIndex = (i2 / ArrayTable.this.columnList.size());

            public C getColumnKey() {
                return ArrayTable.this.columnList.get(this.columnIndex);
            }

            public R getRowKey() {
                return ArrayTable.this.rowList.get(this.rowIndex);
            }

            public V getValue() {
                return ArrayTable.this.at(this.rowIndex, this.columnIndex);
            }
        };
    }

    /* access modifiers changed from: private */
    public V getValue(int i2) {
        return at(i2 / this.columnList.size(), i2 % this.columnList.size());
    }

    public V at(int i2, int i3) {
        Preconditions.checkElementIndex(i2, this.rowList.size());
        Preconditions.checkElementIndex(i3, this.columnList.size());
        return this.array[i2][i3];
    }

    public Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(size()) {
            public Table.Cell<R, C, V> get(int i2) {
                return ArrayTable.this.getCell(i2);
            }
        };
    }

    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Map<R, V> column(C c) {
        Preconditions.checkNotNull(c);
        Integer num = this.columnKeyToIndex.get(c);
        return num == null ? ImmutableMap.of() : new Column(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.ColumnMap columnMap2 = this.columnMap;
        if (columnMap2 != null) {
            return columnMap2;
        }
        ArrayTable<R, C, V>.ColumnMap columnMap3 = new ColumnMap();
        this.columnMap = columnMap3;
        return columnMap3;
    }

    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    public boolean containsColumn(@NullableDecl Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    public boolean containsRow(@NullableDecl Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    public boolean containsValue(@NullableDecl Object obj) {
        for (V[] vArr : this.array) {
            for (V equal : r0[r3]) {
                if (Objects.equal(obj, equal)) {
                    return true;
                }
            }
        }
        return false;
    }

    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public V erase(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), (Object) null);
    }

    public void eraseAll() {
        for (V[] fill : this.array) {
            Arrays.fill(fill, (Object) null);
        }
    }

    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @CanIgnoreReturnValue
    public V put(R r, C c, @NullableDecl V v) {
        Preconditions.checkNotNull(r);
        Preconditions.checkNotNull(c);
        Integer num = this.rowKeyToIndex.get(r);
        boolean z = true;
        Preconditions.checkArgument(num != null, "Row %s not in %s", (Object) r, (Object) this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c);
        if (num2 == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "Column %s not in %s", (Object) c, (Object) this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @CanIgnoreReturnValue
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public Map<C, V> row(R r) {
        Preconditions.checkNotNull(r);
        Integer num = this.rowKeyToIndex.get(r);
        return num == null ? ImmutableMap.of() : new Row(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.RowMap rowMap2 = this.rowMap;
        if (rowMap2 != null) {
            return rowMap2;
        }
        ArrayTable<R, C, V>.RowMap rowMap3 = new RowMap();
        this.rowMap = rowMap3;
        return rowMap3;
    }

    @CanIgnoreReturnValue
    public V set(int i2, int i3, @NullableDecl V v) {
        Preconditions.checkElementIndex(i2, this.rowList.size());
        Preconditions.checkElementIndex(i3, this.columnList.size());
        V[][] vArr = this.array;
        V v2 = vArr[i2][i3];
        vArr[i2][i3] = v;
        return v2;
    }

    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @GwtIncompatible
    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (Object[][]) Array.newInstance(cls, new int[]{this.rowList.size(), this.columnList.size()});
        for (int i2 = 0; i2 < this.rowList.size(); i2++) {
            V[][] vArr2 = this.array;
            System.arraycopy(vArr2[i2], 0, vArr[i2], 0, vArr2[i2].length);
        }
        return vArr;
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public Collection<V> values() {
        return super.values();
    }

    public Iterator<V> valuesIterator() {
        return new AbstractIndexedListIterator<V>(size()) {
            public V get(int i2) {
                return ArrayTable.this.getValue(i2);
            }
        };
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        return table instanceof ArrayTable ? new ArrayTable<>((ArrayTable) table) : new ArrayTable<>(table);
    }

    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    public ArrayTable(Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    public ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        this.columnList = arrayTable.columnList;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        int size = immutableList.size();
        int[] iArr = new int[2];
        iArr[1] = this.columnList.size();
        iArr[0] = size;
        V[][] vArr = (Object[][]) Array.newInstance(Object.class, iArr);
        this.array = vArr;
        for (int i2 = 0; i2 < this.rowList.size(); i2++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i2], 0, vArr[i2], 0, vArr2[i2].length);
        }
    }
}
