package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    public static final LazyStringList EMPTY = EMPTY_LIST;
    public static final LazyStringArrayList EMPTY_LIST;
    public final List<Object> list;

    public static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        public final LazyStringArrayList list;

        public ByteArrayListView(LazyStringArrayList lazyStringArrayList) {
            this.list = lazyStringArrayList;
        }

        public int size() {
            return this.list.size();
        }

        public void add(int i2, byte[] bArr) {
            this.list.add(i2, bArr);
            this.modCount++;
        }

        public byte[] get(int i2) {
            return this.list.getByteArray(i2);
        }

        public byte[] remove(int i2) {
            String remove = this.list.remove(i2);
            this.modCount++;
            return LazyStringArrayList.asByteArray(remove);
        }

        public byte[] set(int i2, byte[] bArr) {
            Object access$000 = this.list.setAndReturn(i2, bArr);
            this.modCount++;
            return LazyStringArrayList.asByteArray(access$000);
        }
    }

    public static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        public final LazyStringArrayList list;

        public ByteStringListView(LazyStringArrayList lazyStringArrayList) {
            this.list = lazyStringArrayList;
        }

        public int size() {
            return this.list.size();
        }

        public void add(int i2, ByteString byteString) {
            this.list.add(i2, byteString);
            this.modCount++;
        }

        public ByteString get(int i2) {
            return this.list.getByteString(i2);
        }

        public ByteString remove(int i2) {
            String remove = this.list.remove(i2);
            this.modCount++;
            return LazyStringArrayList.asByteString(remove);
        }

        public ByteString set(int i2, ByteString byteString) {
            Object access$300 = this.list.setAndReturn(i2, byteString);
            this.modCount++;
            return LazyStringArrayList.asByteString(access$300);
        }
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        EMPTY_LIST = lazyStringArrayList;
        lazyStringArrayList.makeImmutable();
    }

    public LazyStringArrayList() {
        this(10);
    }

    public static byte[] asByteArray(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return Internal.toByteArray((String) obj);
        }
        return ((ByteString) obj).toByteArray();
    }

    public static ByteString asByteString(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.copyFromUtf8((String) obj);
        }
        return ByteString.copyFrom((byte[]) obj);
    }

    public static String asString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[]) obj);
    }

    public static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    /* access modifiers changed from: private */
    public Object setAndReturn(int i2, ByteString byteString) {
        ensureIsMutable();
        return this.list.set(i2, byteString);
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public boolean addAllByteArray(Collection<byte[]> collection) {
        ensureIsMutable();
        boolean addAll = this.list.addAll(collection);
        this.modCount++;
        return addAll;
    }

    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        ensureIsMutable();
        boolean addAll = this.list.addAll(collection);
        this.modCount++;
        return addAll;
    }

    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    public void clear() {
        ensureIsMutable();
        this.list.clear();
        this.modCount++;
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.util.List<java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getByteArray(int r3) {
        /*
            r2 = this;
            java.util.List<java.lang.Object> r0 = r2.list
            java.lang.Object r0 = r0.get(r3)
            byte[] r1 = asByteArray(r0)
            if (r1 == r0) goto L_0x0011
            java.util.List<java.lang.Object> r0 = r2.list
            r0.set(r3, r1)
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.LazyStringArrayList.getByteArray(int):byte[]");
    }

    public ByteString getByteString(int i2) {
        Object obj = this.list.get(i2);
        ByteString asByteString = asByteString(obj);
        if (asByteString != obj) {
            this.list.set(i2, asByteString);
        }
        return asByteString;
    }

    public Object getRaw(int i2) {
        return this.list.get(i2);
    }

    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    public LazyStringList getUnmodifiableView() {
        return isModifiable() ? new UnmodifiableLazyStringList(this) : this;
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    public void mergeFrom(LazyStringList lazyStringList) {
        ensureIsMutable();
        for (Object next : lazyStringList.getUnderlyingElements()) {
            if (next instanceof byte[]) {
                byte[] bArr = (byte[]) next;
                this.list.add(Arrays.copyOf(bArr, bArr.length));
            } else {
                this.list.add(next);
            }
        }
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public int size() {
        return this.list.size();
    }

    public LazyStringArrayList(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    public void add(int i2, String str) {
        ensureIsMutable();
        this.list.add(i2, str);
        this.modCount++;
    }

    public boolean addAll(int i2, Collection<? extends String> collection) {
        ensureIsMutable();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.list.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public String get(int i2) {
        Object obj = this.list.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.list.set(i2, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.list.set(i2, stringUtf82);
        }
        return stringUtf82;
    }

    public LazyStringArrayList mutableCopyWithCapacity(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.list);
            return new LazyStringArrayList((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public String set(int i2, String str) {
        ensureIsMutable();
        return asString(this.list.set(i2, str));
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.list = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    /* access modifiers changed from: private */
    public Object setAndReturn(int i2, byte[] bArr) {
        ensureIsMutable();
        return this.list.set(i2, bArr);
    }

    public String remove(int i2) {
        ensureIsMutable();
        Object remove = this.list.remove(i2);
        this.modCount++;
        return asString(remove);
    }

    /* access modifiers changed from: private */
    public void add(int i2, ByteString byteString) {
        ensureIsMutable();
        this.list.add(i2, byteString);
        this.modCount++;
    }

    public void set(int i2, ByteString byteString) {
        setAndReturn(i2, byteString);
    }

    public LazyStringArrayList(List<String> list2) {
        this((ArrayList<Object>) new ArrayList(list2));
    }

    public void set(int i2, byte[] bArr) {
        setAndReturn(i2, bArr);
    }

    public LazyStringArrayList(ArrayList<Object> arrayList) {
        this.list = arrayList;
    }

    /* access modifiers changed from: private */
    public void add(int i2, byte[] bArr) {
        ensureIsMutable();
        this.list.add(i2, bArr);
        this.modCount++;
    }

    public void add(ByteString byteString) {
        ensureIsMutable();
        this.list.add(byteString);
        this.modCount++;
    }

    public void add(byte[] bArr) {
        ensureIsMutable();
        this.list.add(bArr);
        this.modCount++;
    }
}
