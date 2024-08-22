package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public abstract class AbstractTable<R, C, V> implements Table<R, C, V> {
    @MonotonicNonNullDecl
    public transient Set<Table.Cell<R, C, V>> cellSet;
    @MonotonicNonNullDecl
    public transient Collection<V> values;

    public class CellSet extends AbstractSet<Table.Cell<R, C, V>> {
        public CellSet() {
        }

        public void clear() {
            AbstractTable.this.clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Map map = (Map) Maps.safeGet(AbstractTable.this.rowMap(), cell.getRowKey());
            if (map == null || !Collections2.safeContains(map.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue()))) {
                return false;
            }
            return true;
        }

        public Iterator<Table.Cell<R, C, V>> iterator() {
            return AbstractTable.this.cellIterator();
        }

        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Map map = (Map) Maps.safeGet(AbstractTable.this.rowMap(), cell.getRowKey());
            if (map == null || !Collections2.safeRemove(map.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue()))) {
                return false;
            }
            return true;
        }

        public int size() {
            return AbstractTable.this.size();
        }
    }

    public class Values extends AbstractCollection<V> {
        public Values() {
        }

        public void clear() {
            AbstractTable.this.clear();
        }

        public boolean contains(Object obj) {
            return AbstractTable.this.containsValue(obj);
        }

        public Iterator<V> iterator() {
            return AbstractTable.this.valuesIterator();
        }

        public int size() {
            return AbstractTable.this.size();
        }
    }

    public abstract Iterator<Table.Cell<R, C, V>> cellIterator();

    public Set<Table.Cell<R, C, V>> cellSet() {
        Set<Table.Cell<R, C, V>> set = this.cellSet;
        if (set != null) {
            return set;
        }
        Set<Table.Cell<R, C, V>> createCellSet = createCellSet();
        this.cellSet = createCellSet;
        return createCellSet;
    }

    public void clear() {
        Iterators.clear(cellSet().iterator());
    }

    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Map map = (Map) Maps.safeGet(rowMap(), obj);
        return map != null && Maps.safeContainsKey(map, obj2);
    }

    public boolean containsColumn(@NullableDecl Object obj) {
        return Maps.safeContainsKey(columnMap(), obj);
    }

    public boolean containsRow(@NullableDecl Object obj) {
        return Maps.safeContainsKey(rowMap(), obj);
    }

    public boolean containsValue(@NullableDecl Object obj) {
        for (Map containsValue : rowMap().values()) {
            if (containsValue.containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set<Table.Cell<R, C, V>> createCellSet() {
        return new CellSet();
    }

    public Collection<V> createValues() {
        return new Values();
    }

    public boolean equals(@NullableDecl Object obj) {
        return Tables.equalsImpl(this, obj);
    }

    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Map map = (Map) Maps.safeGet(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return Maps.safeGet(map, obj2);
    }

    public int hashCode() {
        return cellSet().hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @CanIgnoreReturnValue
    public V put(R r, C c, V v) {
        return row(r).put(c, v);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        for (Table.Cell next : table.cellSet()) {
            put(next.getRowKey(), next.getColumnKey(), next.getValue());
        }
    }

    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Map map = (Map) Maps.safeGet(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return Maps.safeRemove(map, obj2);
    }

    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public String toString() {
        return rowMap().toString();
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    public Iterator<V> valuesIterator() {
        return new TransformedIterator<Table.Cell<R, C, V>, V>(cellSet().iterator()) {
            public V transform(Table.Cell<R, C, V> cell) {
                return cell.getValue();
            }
        };
    }
}
