package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.lang.reflect.Array;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
@Immutable(containerOf = {"R", "C", "V"})
public final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    public final int[] cellColumnIndices;
    public final int[] cellRowIndices;
    public final int[] columnCounts = new int[this.columnKeyToIndex.size()];
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    public final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    public final int[] rowCounts = new int[this.rowKeyToIndex.size()];
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    public final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    public final V[][] values;

    public final class Column extends ImmutableArrayMap<R, V> {
        public final int columnIndex;

        public Column(int i2) {
            super(DenseImmutableTable.this.columnCounts[i2]);
            this.columnIndex = i2;
        }

        public V getValue(int i2) {
            return DenseImmutableTable.this.values[i2][this.columnIndex];
        }

        public boolean isPartialView() {
            return true;
        }

        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }
    }

    public final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        public boolean isPartialView() {
            return false;
        }

        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }

        public ColumnMap() {
            super(DenseImmutableTable.this.columnCounts.length);
        }

        public ImmutableMap<R, V> getValue(int i2) {
            return new Column(i2);
        }
    }

    public static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        public final int size;

        public ImmutableArrayMap(int i2) {
            this.size = i2;
        }

        private boolean isFull() {
            return this.size == keyToIndex().size();
        }

        public ImmutableSet<K> createKeySet() {
            return isFull() ? keyToIndex().keySet() : super.createKeySet();
        }

        public UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
            return new AbstractIterator<Map.Entry<K, V>>() {
                public int index = -1;
                public final int maxIndex = ImmutableArrayMap.this.keyToIndex().size();

                public Map.Entry<K, V> computeNext() {
                    int i2 = this.index;
                    while (true) {
                        this.index = i2 + 1;
                        int i3 = this.index;
                        if (i3 >= this.maxIndex) {
                            return (Map.Entry) endOfData();
                        }
                        Object value = ImmutableArrayMap.this.getValue(i3);
                        if (value != null) {
                            return Maps.immutableEntry(ImmutableArrayMap.this.getKey(this.index), value);
                        }
                        i2 = this.index;
                    }
                }
            };
        }

        public V get(@NullableDecl Object obj) {
            Integer num = (Integer) keyToIndex().get(obj);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        public K getKey(int i2) {
            return keyToIndex().keySet().asList().get(i2);
        }

        @NullableDecl
        public abstract V getValue(int i2);

        public abstract ImmutableMap<K, Integer> keyToIndex();

        public int size() {
            return this.size;
        }
    }

    public final class Row extends ImmutableArrayMap<C, V> {
        public final int rowIndex;

        public Row(int i2) {
            super(DenseImmutableTable.this.rowCounts[i2]);
            this.rowIndex = i2;
        }

        public V getValue(int i2) {
            return DenseImmutableTable.this.values[this.rowIndex][i2];
        }

        public boolean isPartialView() {
            return true;
        }

        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }
    }

    public final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        public boolean isPartialView() {
            return false;
        }

        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }

        public RowMap() {
            super(DenseImmutableTable.this.rowCounts.length);
        }

        public ImmutableMap<C, V> getValue(int i2) {
            return new Row(i2);
        }
    }

    public DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        int size = immutableSet.size();
        int[] iArr = new int[2];
        iArr[1] = immutableSet2.size();
        iArr[0] = size;
        this.values = (Object[][]) Array.newInstance(Object.class, iArr);
        this.rowKeyToIndex = Maps.indexMap(immutableSet);
        this.columnKeyToIndex = Maps.indexMap(immutableSet2);
        int[] iArr2 = new int[immutableList.size()];
        int[] iArr3 = new int[immutableList.size()];
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            Table.Cell cell = immutableList.get(i2);
            Object rowKey = cell.getRowKey();
            Object columnKey = cell.getColumnKey();
            int intValue = this.rowKeyToIndex.get(rowKey).intValue();
            int intValue2 = this.columnKeyToIndex.get(columnKey).intValue();
            checkNoDuplicate(rowKey, columnKey, this.values[intValue][intValue2], cell.getValue());
            this.values[intValue][intValue2] = cell.getValue();
            int[] iArr4 = this.rowCounts;
            iArr4[intValue] = iArr4[intValue] + 1;
            int[] iArr5 = this.columnCounts;
            iArr5[intValue2] = iArr5[intValue2] + 1;
            iArr2[i2] = intValue;
            iArr3[i2] = intValue2;
        }
        this.cellRowIndices = iArr2;
        this.cellColumnIndices = iArr3;
        this.rowMap = new RowMap();
        this.columnMap = new ColumnMap();
    }

    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
    }

    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.values[num.intValue()][num2.intValue()];
    }

    public Table.Cell<R, C, V> getCell(int i2) {
        int i3 = this.cellRowIndices[i2];
        int i4 = this.cellColumnIndices[i2];
        return ImmutableTable.cellOf(rowKeySet().asList().get(i3), columnKeySet().asList().get(i4), this.values[i3][i4]);
    }

    public V getValue(int i2) {
        return this.values[this.cellRowIndices[i2]][this.cellColumnIndices[i2]];
    }

    public int size() {
        return this.cellRowIndices.length;
    }

    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }
}
