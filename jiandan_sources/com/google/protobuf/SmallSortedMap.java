package com.google.protobuf;

import com.google.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public List<SmallSortedMap<K, V>.Entry> entryList;
    public boolean isImmutable;
    public volatile SmallSortedMap<K, V>.DescendingEntrySet lazyDescendingEntrySet;
    public volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    public final int maxArraySize;
    public Map<K, V> overflowEntries;
    public Map<K, V> overflowEntriesDescending;

    public class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {
        public Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        public int pos;

        public DescendingEntryIterator() {
            this.pos = SmallSortedMap.this.entryList.size();
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = SmallSortedMap.this.overflowEntriesDescending.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }

        public boolean hasNext() {
            int i2 = this.pos;
            return (i2 > 0 && i2 <= SmallSortedMap.this.entryList.size()) || getOverflowIterator().hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Map.Entry<K, V> next() {
            if (getOverflowIterator().hasNext()) {
                return (Map.Entry) getOverflowIterator().next();
            }
            List access$600 = SmallSortedMap.this.entryList;
            int i2 = this.pos - 1;
            this.pos = i2;
            return (Map.Entry) access$600.get(i2);
        }
    }

    public class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        public DescendingEntrySet() {
            super();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator();
        }
    }

    public static class EmptySet {
        public static final Iterable<Object> ITERABLE = new Iterable<Object>() {
            public Iterator<Object> iterator() {
                return EmptySet.ITERATOR;
            }
        };
        public static final Iterator<Object> ITERATOR = new Iterator<Object>() {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        public static <T> Iterable<T> iterable() {
            return ITERABLE;
        }
    }

    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        public final K key;
        public V value;

        public Entry(SmallSortedMap smallSortedMap, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!equals(this.key, entry.getKey()) || !equals(this.value, entry.getValue())) {
                return false;
            }
            return true;
        }

        public V getValue() {
            return this.value;
        }

        public int hashCode() {
            K k = this.key;
            int i2 = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        public V setValue(V v) {
            SmallSortedMap.this.checkMutable();
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public int compareTo(SmallSortedMap<K, V>.Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        public K getKey() {
            return this.key;
        }

        private boolean equals(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }
    }

    public class EntryIterator implements Iterator<Map.Entry<K, V>> {
        public Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        public boolean nextCalledBeforeRemove;
        public int pos;

        public EntryIterator() {
            this.pos = -1;
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = SmallSortedMap.this.overflowEntries.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }

        public boolean hasNext() {
            if (this.pos + 1 < SmallSortedMap.this.entryList.size()) {
                return true;
            }
            if (SmallSortedMap.this.overflowEntries.isEmpty() || !getOverflowIterator().hasNext()) {
                return false;
            }
            return true;
        }

        public void remove() {
            if (this.nextCalledBeforeRemove) {
                this.nextCalledBeforeRemove = false;
                SmallSortedMap.this.checkMutable();
                if (this.pos < SmallSortedMap.this.entryList.size()) {
                    SmallSortedMap smallSortedMap = SmallSortedMap.this;
                    int i2 = this.pos;
                    this.pos = i2 - 1;
                    Object unused = smallSortedMap.removeArrayEntryAt(i2);
                    return;
                }
                getOverflowIterator().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int i2 = this.pos + 1;
            this.pos = i2;
            if (i2 < SmallSortedMap.this.entryList.size()) {
                return (Map.Entry) SmallSortedMap.this.entryList.get(this.pos);
            }
            return (Map.Entry) getOverflowIterator().next();
        }
    }

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        public void clear() {
            SmallSortedMap.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            SmallSortedMap.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return SmallSortedMap.this.size();
        }

        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            SmallSortedMap.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }
    }

    private int binarySearchInArray(K k) {
        int size = this.entryList.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.entryList.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k.compareTo(this.entryList.get(i3).getKey());
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    /* access modifiers changed from: private */
    public void checkMutable() {
        if (this.isImmutable) {
            throw new UnsupportedOperationException();
        }
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (this.entryList.isEmpty() && !(this.entryList instanceof ArrayList)) {
            this.entryList = new ArrayList(this.maxArraySize);
        }
    }

    private SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.overflowEntries = treeMap;
            this.overflowEntriesDescending = treeMap.descendingMap();
        }
        return (SortedMap) this.overflowEntries;
    }

    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> newFieldMap(int i2) {
        return new SmallSortedMap<FieldDescriptorType, Object>(i2) {
            public void makeImmutable() {
                if (!isImmutable()) {
                    for (int i2 = 0; i2 < getNumArrayEntries(); i2++) {
                        Map.Entry arrayEntryAt = getArrayEntryAt(i2);
                        if (((FieldSet.FieldDescriptorLite) arrayEntryAt.getKey()).isRepeated()) {
                            arrayEntryAt.setValue(Collections.unmodifiableList((List) arrayEntryAt.getValue()));
                        }
                    }
                    for (Map.Entry entry : getOverflowEntries()) {
                        if (((FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                SmallSortedMap.super.makeImmutable();
            }

            public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
                return SmallSortedMap.super.put((FieldSet.FieldDescriptorLite) obj, obj2);
            }
        };
    }

    public static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest(int i2) {
        return new SmallSortedMap<>(i2);
    }

    /* access modifiers changed from: private */
    public V removeArrayEntryAt(int i2) {
        checkMutable();
        V value = this.entryList.remove(i2).getValue();
        if (!this.overflowEntries.isEmpty()) {
            Iterator it = getOverflowEntriesMutable().entrySet().iterator();
            this.entryList.add(new Entry(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public void clear() {
        checkMutable();
        if (!this.entryList.isEmpty()) {
            this.entryList.clear();
        }
        if (!this.overflowEntries.isEmpty()) {
            this.overflowEntries.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return binarySearchInArray(comparable) >= 0 || this.overflowEntries.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> descendingEntrySet() {
        if (this.lazyDescendingEntrySet == null) {
            this.lazyDescendingEntrySet = new DescendingEntrySet();
        }
        return this.lazyDescendingEntrySet;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet == null) {
            this.lazyEntrySet = new EntrySet();
        }
        return this.lazyEntrySet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap)) {
            return super.equals(obj);
        }
        SmallSortedMap smallSortedMap = (SmallSortedMap) obj;
        int size = size();
        if (size != smallSortedMap.size()) {
            return false;
        }
        int numArrayEntries = getNumArrayEntries();
        if (numArrayEntries != smallSortedMap.getNumArrayEntries()) {
            return entrySet().equals(smallSortedMap.entrySet());
        }
        for (int i2 = 0; i2 < numArrayEntries; i2++) {
            if (!getArrayEntryAt(i2).equals(smallSortedMap.getArrayEntryAt(i2))) {
                return false;
            }
        }
        if (numArrayEntries != size) {
            return this.overflowEntries.equals(smallSortedMap.overflowEntries);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return this.entryList.get(binarySearchInArray).getValue();
        }
        return this.overflowEntries.get(comparable);
    }

    public Map.Entry<K, V> getArrayEntryAt(int i2) {
        return this.entryList.get(i2);
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty()) {
            return EmptySet.iterable();
        }
        return this.overflowEntries.entrySet();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntriesDescending() {
        if (this.overflowEntriesDescending.isEmpty()) {
            return EmptySet.iterable();
        }
        return this.overflowEntriesDescending.entrySet();
    }

    public int hashCode() {
        int numArrayEntries = getNumArrayEntries();
        int i2 = 0;
        for (int i3 = 0; i3 < numArrayEntries; i3++) {
            i2 += this.entryList.get(i3).hashCode();
        }
        return getNumOverflowEntries() > 0 ? i2 + this.overflowEntries.hashCode() : i2;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public void makeImmutable() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.isImmutable) {
            if (this.overflowEntries.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.overflowEntries);
            }
            this.overflowEntries = map;
            if (this.overflowEntriesDescending.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.overflowEntriesDescending);
            }
            this.overflowEntriesDescending = map2;
            this.isImmutable = true;
        }
    }

    public V remove(Object obj) {
        checkMutable();
        Comparable comparable = (Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return removeArrayEntryAt(binarySearchInArray);
        }
        if (this.overflowEntries.isEmpty()) {
            return null;
        }
        return this.overflowEntries.remove(comparable);
    }

    public int size() {
        return this.entryList.size() + this.overflowEntries.size();
    }

    public SmallSortedMap(int i2) {
        this.maxArraySize = i2;
        this.entryList = Collections.emptyList();
        this.overflowEntries = Collections.emptyMap();
        this.overflowEntriesDescending = Collections.emptyMap();
    }

    public V put(K k, V v) {
        checkMutable();
        int binarySearchInArray = binarySearchInArray(k);
        if (binarySearchInArray >= 0) {
            return this.entryList.get(binarySearchInArray).setValue(v);
        }
        ensureEntryArrayMutable();
        int i2 = -(binarySearchInArray + 1);
        if (i2 >= this.maxArraySize) {
            return getOverflowEntriesMutable().put(k, v);
        }
        int size = this.entryList.size();
        int i3 = this.maxArraySize;
        if (size == i3) {
            Entry remove = this.entryList.remove(i3 - 1);
            getOverflowEntriesMutable().put(remove.getKey(), remove.getValue());
        }
        this.entryList.add(i2, new Entry(k, v));
        return null;
    }
}
