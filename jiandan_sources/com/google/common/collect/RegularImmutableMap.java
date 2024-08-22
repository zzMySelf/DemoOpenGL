package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import java.util.Map;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true, serializable = true)
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    public static final byte ABSENT = -1;
    public static final int BYTE_MASK = 255;
    public static final int BYTE_MAX_SIZE = 128;
    public static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap((Object) null, new Object[0], 0);
    public static final int SHORT_MASK = 65535;
    public static final int SHORT_MAX_SIZE = 32768;
    public static final long serialVersionUID = 0;
    @VisibleForTesting
    public final transient Object[] alternatingKeysAndValues;
    public final transient Object hashTable;
    public final transient int size;

    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        public final transient Object[] alternatingKeysAndValues;
        public final transient int keyOffset;
        public final transient ImmutableMap<K, V> map;
        public final transient int size;

        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i2, int i3) {
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i2;
            this.size = i3;
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.map.get(key))) {
                return false;
            }
            return true;
        }

        public int copyIntoArray(Object[] objArr, int i2) {
            return asList().copyIntoArray(objArr, i2);
        }

        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() {
                public boolean isPartialView() {
                    return true;
                }

                public int size() {
                    return EntrySet.this.size;
                }

                public Map.Entry<K, V> get(int i2) {
                    Preconditions.checkElementIndex(i2, EntrySet.this.size);
                    int i3 = i2 * 2;
                    return new AbstractMap.SimpleImmutableEntry(EntrySet.this.alternatingKeysAndValues[EntrySet.this.keyOffset + i3], EntrySet.this.alternatingKeysAndValues[i3 + (EntrySet.this.keyOffset ^ 1)]);
                }
            };
        }

        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.size;
        }

        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    public static final class KeySet<K> extends ImmutableSet<K> {
        public final transient ImmutableList<K> list;
        public final transient ImmutableMap<K, ?> map;

        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.map = immutableMap;
            this.list = immutableList;
        }

        public ImmutableList<K> asList() {
            return this.list;
        }

        public boolean contains(@NullableDecl Object obj) {
            return this.map.get(obj) != null;
        }

        public int copyIntoArray(Object[] objArr, int i2) {
            return asList().copyIntoArray(objArr, i2);
        }

        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.map.size();
        }

        public UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }
    }

    public static final class KeysOrValuesAsList extends ImmutableList<Object> {
        public final transient Object[] alternatingKeysAndValues;
        public final transient int offset;
        public final transient int size;

        public KeysOrValuesAsList(Object[] objArr, int i2, int i3) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i2;
            this.size = i3;
        }

        public Object get(int i2) {
            Preconditions.checkElementIndex(i2, this.size);
            return this.alternatingKeysAndValues[(i2 * 2) + this.offset];
        }

        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.size;
        }
    }

    public RegularImmutableMap(Object obj, Object[] objArr, int i2) {
        this.hashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.size = i2;
    }

    public static <K, V> RegularImmutableMap<K, V> create(int i2, Object[] objArr) {
        if (i2 == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i2 == 1) {
            CollectPreconditions.checkEntryNotNull(objArr[0], objArr[1]);
            return new RegularImmutableMap<>((Object) null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i2, objArr.length >> 1);
        return new RegularImmutableMap<>(createHashTable(objArr, i2, ImmutableSet.chooseTableSize(i2), 0), objArr, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        r11[r5] = (byte) r1;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        r11[r5] = (short) r1;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b0, code lost:
        r11[r6] = r1;
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object createHashTable(java.lang.Object[] r9, int r10, int r11, int r12) {
        /*
            r0 = 1
            if (r10 != r0) goto L_0x000e
            r10 = r9[r12]
            r11 = r12 ^ 1
            r9 = r9[r11]
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r10, r9)
            r9 = 0
            return r9
        L_0x000e:
            int r0 = r11 + -1
            r1 = 128(0x80, float:1.794E-43)
            r2 = 0
            r3 = -1
            if (r11 > r1) goto L_0x0050
            byte[] r11 = new byte[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x001b:
            if (r2 >= r10) goto L_0x004f
            int r1 = r2 * 2
            int r1 = r1 + r12
            r3 = r9[r1]
            r4 = r1 ^ 1
            r4 = r9[r4]
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r3, r4)
            int r5 = r3.hashCode()
            int r5 = com.google.common.collect.Hashing.smear(r5)
        L_0x0031:
            r5 = r5 & r0
            byte r6 = r11[r5]
            r7 = 255(0xff, float:3.57E-43)
            r6 = r6 & r7
            if (r6 != r7) goto L_0x003f
            byte r1 = (byte) r1
            r11[r5] = r1
            int r2 = r2 + 1
            goto L_0x001b
        L_0x003f:
            r7 = r9[r6]
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x004a
            int r5 = r5 + 1
            goto L_0x0031
        L_0x004a:
            java.lang.IllegalArgumentException r9 = duplicateKeyException(r3, r4, r9, r6)
            throw r9
        L_0x004f:
            return r11
        L_0x0050:
            r1 = 32768(0x8000, float:4.5918E-41)
            if (r11 > r1) goto L_0x0090
            short[] r11 = new short[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x005a:
            if (r2 >= r10) goto L_0x008f
            int r1 = r2 * 2
            int r1 = r1 + r12
            r3 = r9[r1]
            r4 = r1 ^ 1
            r4 = r9[r4]
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r3, r4)
            int r5 = r3.hashCode()
            int r5 = com.google.common.collect.Hashing.smear(r5)
        L_0x0070:
            r5 = r5 & r0
            short r6 = r11[r5]
            r7 = 65535(0xffff, float:9.1834E-41)
            r6 = r6 & r7
            if (r6 != r7) goto L_0x007f
            short r1 = (short) r1
            r11[r5] = r1
            int r2 = r2 + 1
            goto L_0x005a
        L_0x007f:
            r7 = r9[r6]
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x008a
            int r5 = r5 + 1
            goto L_0x0070
        L_0x008a:
            java.lang.IllegalArgumentException r9 = duplicateKeyException(r3, r4, r9, r6)
            throw r9
        L_0x008f:
            return r11
        L_0x0090:
            int[] r11 = new int[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x0095:
            if (r2 >= r10) goto L_0x00c5
            int r1 = r2 * 2
            int r1 = r1 + r12
            r4 = r9[r1]
            r5 = r1 ^ 1
            r5 = r9[r5]
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.common.collect.Hashing.smear(r6)
        L_0x00ab:
            r6 = r6 & r0
            r7 = r11[r6]
            if (r7 != r3) goto L_0x00b5
            r11[r6] = r1
            int r2 = r2 + 1
            goto L_0x0095
        L_0x00b5:
            r8 = r9[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00c0
            int r6 = r6 + 1
            goto L_0x00ab
        L_0x00c0:
            java.lang.IllegalArgumentException r9 = duplicateKeyException(r4, r5, r9, r7)
            throw r9
        L_0x00c5:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableMap.createHashTable(java.lang.Object[], int, int, int):java.lang.Object");
    }

    public static IllegalArgumentException duplicateKeyException(Object obj, Object obj2, Object[] objArr, int i2) {
        return new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i2] + "=" + objArr[i2 ^ 1]);
    }

    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }

    @NullableDecl
    public V get(@NullableDecl Object obj) {
        return get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.size;
    }

    public static Object get(@NullableDecl Object obj, @NullableDecl Object[] objArr, int i2, int i3, @NullableDecl Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i2 == 1) {
            if (objArr[i3].equals(obj2)) {
                return objArr[i3 ^ 1];
            }
            return null;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int smear = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i4 = smear & length;
                    byte b = bArr[i4] & 255;
                    if (b == 255) {
                        return null;
                    }
                    if (objArr[b].equals(obj2)) {
                        return objArr[b ^ 1];
                    }
                    smear = i4 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int smear2 = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i5 = smear2 & length2;
                    short s = sArr[i5] & UShort.MAX_VALUE;
                    if (s == 65535) {
                        return null;
                    }
                    if (objArr[s].equals(obj2)) {
                        return objArr[s ^ 1];
                    }
                    smear2 = i5 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int smear3 = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i6 = smear3 & length3;
                    int i7 = iArr[i6];
                    if (i7 == -1) {
                        return null;
                    }
                    if (objArr[i7].equals(obj2)) {
                        return objArr[i7 ^ 1];
                    }
                    smear3 = i6 + 1;
                }
            }
        }
    }
}
