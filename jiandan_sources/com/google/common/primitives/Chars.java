package com.google.common.primitives;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.CharCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
public final class Chars {
    public static final int BYTES = 2;

    @GwtCompatible
    public static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final char[] array;
        public final int end;
        public final int start;

        public CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Character) && Chars.indexOf(this.array, ((Character) obj).charValue(), this.start, this.end) != -1;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CharArrayAsList)) {
                return super.equals(obj);
            }
            CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
            int size = size();
            if (charArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.array[this.start + i2] != charArrayAsList.array[charArrayAsList.start + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.start; i3 < this.end; i3++) {
                i2 = (i2 * 31) + Chars.hashCode(this.array[i3]);
            }
            return i2;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Character) || (access$000 = Chars.indexOf(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Character) || (access$100 = Chars.lastIndexOf(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Character> subList(int i2, int i3) {
            Preconditions.checkPositionIndexes(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            char[] cArr = this.array;
            int i4 = this.start;
            return new CharArrayAsList(cArr, i2 + i4, i4 + i3);
        }

        public char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 3);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i2 = this.start;
            while (true) {
                i2++;
                if (i2 < this.end) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(this.array[i2]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        public CharArrayAsList(char[] cArr, int i2, int i3) {
            this.array = cArr;
            this.start = i2;
            this.end = i3;
        }

        public Character get(int i2) {
            Preconditions.checkElementIndex(i2, size());
            return Character.valueOf(this.array[this.start + i2]);
        }

        public Character set(int i2, Character ch) {
            Preconditions.checkElementIndex(i2, size());
            char[] cArr = this.array;
            int i3 = this.start;
            char c = cArr[i3 + i2];
            cArr[i3 + i2] = ((Character) Preconditions.checkNotNull(ch)).charValue();
            return Character.valueOf(c);
        }
    }

    public enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        public String toString() {
            return "Chars.lexicographicalComparator()";
        }

        public int compare(char[] cArr, char[] cArr2) {
            int min = Math.min(cArr.length, cArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int compare = Chars.compare(cArr[i2], cArr2[i2]);
                if (compare != 0) {
                    return compare;
                }
            }
            return cArr.length - cArr2.length;
        }
    }

    public static List<Character> asList(char... cArr) {
        if (cArr.length == 0) {
            return Collections.emptyList();
        }
        return new CharArrayAsList(cArr);
    }

    public static char checkedCast(long j) {
        char c = (char) ((int) j);
        Preconditions.checkArgument(((long) c) == j, "Out of range: %s", j);
        return c;
    }

    public static int compare(char c, char c2) {
        return c - c2;
    }

    public static char[] concat(char[]... cArr) {
        int i2 = 0;
        for (char[] length : cArr) {
            i2 += length.length;
        }
        char[] cArr2 = new char[i2];
        int i3 = 0;
        for (char[] cArr3 : cArr) {
            System.arraycopy(cArr3, 0, cArr2, i3, cArr3.length);
            i3 += cArr3.length;
        }
        return cArr2;
    }

    @Beta
    public static char constrainToRange(char c, char c2, char c3) {
        Preconditions.checkArgument(c2 <= c3, "min (%s) must be less than or equal to max (%s)", c2, c3);
        if (c < c2) {
            return c2;
        }
        return c < c3 ? c : c3;
    }

    public static boolean contains(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public static char[] ensureCapacity(char[] cArr, int i2, int i3) {
        boolean z = true;
        Preconditions.checkArgument(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i3);
        return cArr.length < i2 ? Arrays.copyOf(cArr, i2 + i3) : cArr;
    }

    @GwtIncompatible
    public static char fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static char fromBytes(byte b, byte b2) {
        return (char) ((b << 8) | (b2 & 255));
    }

    public static int hashCode(char c) {
        return c;
    }

    public static int indexOf(char[] cArr, char c) {
        return indexOf(cArr, c, 0, cArr.length);
    }

    public static String join(String str, char... cArr) {
        Preconditions.checkNotNull(str);
        int length = cArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder((str.length() * (length - 1)) + length);
        sb.append(cArr[0]);
        for (int i2 = 1; i2 < length; i2++) {
            sb.append(str);
            sb.append(cArr[i2]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(char[] cArr, char c) {
        return lastIndexOf(cArr, c, 0, cArr.length);
    }

    public static Comparator<char[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static char max(char... cArr) {
        Preconditions.checkArgument(cArr.length > 0);
        char c = cArr[0];
        for (int i2 = 1; i2 < cArr.length; i2++) {
            if (cArr[i2] > c) {
                c = cArr[i2];
            }
        }
        return c;
    }

    public static char min(char... cArr) {
        Preconditions.checkArgument(cArr.length > 0);
        char c = cArr[0];
        for (int i2 = 1; i2 < cArr.length; i2++) {
            if (cArr[i2] < c) {
                c = cArr[i2];
            }
        }
        return c;
    }

    public static void reverse(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        reverse(cArr, 0, cArr.length);
    }

    public static char saturatedCast(long j) {
        if (j > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return CharCompanionObject.MAX_VALUE;
        }
        if (j < 0) {
            return 0;
        }
        return (char) ((int) j);
    }

    public static void sortDescending(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        sortDescending(cArr, 0, cArr.length);
    }

    public static char[] toArray(Collection<Character> collection) {
        if (collection instanceof CharArrayAsList) {
            return ((CharArrayAsList) collection).toCharArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = ((Character) Preconditions.checkNotNull(array[i2])).charValue();
        }
        return cArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(char c) {
        return new byte[]{(byte) (c >> 8), (byte) c};
    }

    public static int indexOf(char[] cArr, char c, int i2, int i3) {
        while (i2 < i3) {
            if (cArr[i2] == c) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOf(char[] cArr, char c, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (cArr[i4] == c) {
                return i4;
            }
        }
        return -1;
    }

    public static int indexOf(char[] cArr, char[] cArr2) {
        Preconditions.checkNotNull(cArr, "array");
        Preconditions.checkNotNull(cArr2, AnimatedVectorDrawableCompat.TARGET);
        if (cArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (cArr.length - cArr2.length) + 1) {
            int i3 = 0;
            while (i3 < cArr2.length) {
                if (cArr[i2 + i3] != cArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static void reverse(char[] cArr, int i2, int i3) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i2, i3, cArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            char c = cArr[i2];
            cArr[i2] = cArr[i4];
            cArr[i4] = c;
            i2++;
        }
    }

    public static void sortDescending(char[] cArr, int i2, int i3) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i2, i3, cArr.length);
        Arrays.sort(cArr, i2, i3);
        reverse(cArr, i2, i3);
    }
}
