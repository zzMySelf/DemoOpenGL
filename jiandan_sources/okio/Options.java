package okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public final ByteString[] byteStrings;
    public final int[] trie;

    public Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public static void buildTrieRecursive(long j, Buffer buffer, int i2, List<ByteString> list, int i3, int i4, List<Integer> list2) {
        int i5;
        int i6;
        Buffer buffer2;
        int i7;
        Buffer buffer3 = buffer;
        int i8 = i2;
        List<ByteString> list3 = list;
        int i9 = i3;
        int i10 = i4;
        List<Integer> list4 = list2;
        if (i9 < i10) {
            int i11 = i9;
            while (i11 < i10) {
                if (list3.get(i11).size() >= i8) {
                    i11++;
                } else {
                    throw new AssertionError();
                }
            }
            ByteString byteString = list.get(i3);
            ByteString byteString2 = list3.get(i10 - 1);
            int i12 = -1;
            if (i8 == byteString.size()) {
                i12 = list4.get(i9).intValue();
                i9++;
                byteString = list3.get(i9);
            }
            int i13 = i9;
            if (byteString.getByte(i8) != byteString2.getByte(i8)) {
                int i14 = 1;
                for (int i15 = i13 + 1; i15 < i10; i15++) {
                    if (list3.get(i15 - 1).getByte(i8) != list3.get(i15).getByte(i8)) {
                        i14++;
                    }
                }
                long intCount = j + ((long) intCount(buffer)) + 2 + ((long) (i14 * 2));
                buffer3.writeInt(i14);
                buffer3.writeInt(i12);
                for (int i16 = i13; i16 < i10; i16++) {
                    byte b = list3.get(i16).getByte(i8);
                    if (i16 == i13 || b != list3.get(i16 - 1).getByte(i8)) {
                        buffer3.writeInt((int) b & 255);
                    }
                }
                Buffer buffer4 = new Buffer();
                int i17 = i13;
                while (i17 < i10) {
                    byte b2 = list3.get(i17).getByte(i8);
                    int i18 = i17 + 1;
                    int i19 = i18;
                    while (true) {
                        if (i19 >= i10) {
                            i6 = i10;
                            break;
                        } else if (b2 != list3.get(i19).getByte(i8)) {
                            i6 = i19;
                            break;
                        } else {
                            i19++;
                        }
                    }
                    if (i18 == i6 && i8 + 1 == list3.get(i17).size()) {
                        buffer3.writeInt(list4.get(i17).intValue());
                        i7 = i6;
                        buffer2 = buffer4;
                    } else {
                        buffer3.writeInt((int) ((((long) intCount(buffer4)) + intCount) * -1));
                        i7 = i6;
                        buffer2 = buffer4;
                        buildTrieRecursive(intCount, buffer4, i8 + 1, list, i17, i6, list2);
                    }
                    buffer4 = buffer2;
                    i17 = i7;
                }
                Buffer buffer5 = buffer4;
                buffer3.write(buffer5, buffer5.size());
                return;
            }
            int i20 = 0;
            int min = Math.min(byteString.size(), byteString2.size());
            int i21 = i8;
            while (i21 < min && byteString.getByte(i21) == byteString2.getByte(i21)) {
                i20++;
                i21++;
            }
            long intCount2 = 1 + j + ((long) intCount(buffer)) + 2 + ((long) i20);
            buffer3.writeInt(-i20);
            buffer3.writeInt(i12);
            int i22 = i8;
            while (true) {
                i5 = i8 + i20;
                if (i22 >= i5) {
                    break;
                }
                buffer3.writeInt((int) byteString.getByte(i22) & 255);
                i22++;
            }
            if (i13 + 1 != i10) {
                Buffer buffer6 = new Buffer();
                buffer3.writeInt((int) ((((long) intCount(buffer6)) + intCount2) * -1));
                buildTrieRecursive(intCount2, buffer6, i5, list, i13, i4, list2);
                buffer3.write(buffer6, buffer6.size());
            } else if (i5 == list3.get(i13).size()) {
                buffer3.writeInt(list4.get(i13).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    public static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    public static Options of(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(-1);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i3]), Integer.valueOf(i3));
        }
        if (((ByteString) arrayList.get(0)).size() != 0) {
            int i4 = 0;
            while (i4 < arrayList.size()) {
                ByteString byteString = (ByteString) arrayList.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < arrayList.size()) {
                    ByteString byteString2 = (ByteString) arrayList.get(i6);
                    if (!byteString2.startsWith(byteString)) {
                        continue;
                        break;
                    } else if (byteString2.size() == byteString.size()) {
                        throw new IllegalArgumentException("duplicate option: " + byteString2);
                    } else if (((Integer) arrayList2.get(i6)).intValue() > ((Integer) arrayList2.get(i4)).intValue()) {
                        arrayList.remove(i6);
                        arrayList2.remove(i6);
                    } else {
                        i6++;
                    }
                }
                i4 = i5;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive(0, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
            int intCount = intCount(buffer);
            int[] iArr = new int[intCount];
            for (int i7 = 0; i7 < intCount; i7++) {
                iArr[i7] = buffer.readInt();
            }
            if (buffer.exhausted()) {
                return new Options((ByteString[]) byteStringArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    public final int size() {
        return this.byteStrings.length;
    }

    public ByteString get(int i2) {
        return this.byteStrings[i2];
    }
}
