package com.itextpdf.text.pdf.hyphenation;

import com.google.common.base.Ascii;
import fe.when.ad.f.r2.ad;
import fe.when.ad.f.r2.qw;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class HyphenationTree extends TernaryTree implements PatternConsumer {
    public static final long serialVersionUID = -7763254239309429432L;
    public TernaryTree classmap = new TernaryTree();
    public transient TernaryTree ivalues;
    public HashMap<String, ArrayList<Object>> stoplist = new HashMap<>(23);
    public ByteVector vspace;

    public HyphenationTree() {
        ByteVector byteVector = new ByteVector();
        this.vspace = byteVector;
        byteVector.alloc(1);
    }

    public void addClass(String str) {
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            char[] cArr = new char[2];
            cArr[1] = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                cArr[0] = str.charAt(i2);
                this.classmap.insert(cArr, 0, charAt);
            }
        }
    }

    public void addException(String str, ArrayList<Object> arrayList) {
        this.stoplist.put(str, arrayList);
    }

    public void addPattern(String str, String str2) {
        int find = this.ivalues.find(str2);
        if (find <= 0) {
            find = packValues(str2);
            this.ivalues.insert(str2, (char) find);
        }
        insert(str, (char) find);
    }

    public String findPattern(String str) {
        int find = super.find(str);
        return find >= 0 ? unpackValues(find) : "";
    }

    public byte[] getValues(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + 1;
        byte b = this.vspace.get(i2);
        while (b != 0) {
            stringBuffer.append((char) ((b >>> 4) - 1));
            char c = (char) (b & Ascii.SI);
            if (c == 0) {
                break;
            }
            stringBuffer.append((char) (c - 1));
            b = this.vspace.get(i3);
            i3++;
        }
        int length = stringBuffer.length();
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = (byte) stringBuffer.charAt(i4);
        }
        return bArr;
    }

    public int hstrcmp(char[] cArr, int i2, char[] cArr2, int i3) {
        while (cArr[i2] == cArr2[i3]) {
            if (cArr[i2] == 0) {
                return 0;
            }
            i2++;
            i3++;
        }
        if (cArr2[i3] == 0) {
            return 0;
        }
        return cArr[i2] - cArr2[i3];
    }

    public qw hyphenate(String str, int i2, int i3) {
        char[] charArray = str.toCharArray();
        return hyphenate(charArray, 0, charArray.length, i2, i3);
    }

    public void loadSimplePatterns(InputStream inputStream) {
        ad adVar = new ad();
        this.ivalues = new TernaryTree();
        adVar.o(inputStream, this);
        trimToSize();
        this.vspace.trimToSize();
        this.classmap.trimToSize();
        this.ivalues = null;
    }

    public int packValues(String str) {
        int length = str.length();
        int i2 = (length & 1) == 1 ? (length >> 1) + 2 : (length >> 1) + 1;
        int alloc = this.vspace.alloc(i2);
        byte[] array = this.vspace.getArray();
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 >> 1;
            byte charAt = (byte) (((str.charAt(i3) - '0') + 1) & 15);
            if ((i3 & 1) == 1) {
                int i5 = i4 + alloc;
                array[i5] = (byte) (charAt | array[i5]);
            } else {
                array[i4 + alloc] = (byte) (charAt << 4);
            }
        }
        array[(i2 - 1) + alloc] = 0;
        return alloc;
    }

    public void printStats() {
        PrintStream printStream = System.out;
        printStream.println("Value space size = " + Integer.toString(this.vspace.length()));
        super.printStats();
    }

    public void searchPatterns(char[] cArr, int i2, byte[] bArr) {
        char c = cArr[i2];
        char c2 = this.root;
        int i3 = i2;
        while (c2 > 0) {
            char[] cArr2 = this.sc;
            if (c2 < cArr2.length) {
                int i4 = 0;
                if (cArr2[c2] != 65535) {
                    int i5 = c - cArr2[c2];
                    if (i5 == 0) {
                        if (c != 0) {
                            i3++;
                            c = cArr[i3];
                            c2 = this.eq[c2];
                            char c3 = c2;
                            while (true) {
                                if (c3 <= 0) {
                                    break;
                                }
                                char[] cArr3 = this.sc;
                                if (c3 >= cArr3.length || cArr3[c3] == 65535) {
                                    break;
                                } else if (cArr3[c3] == 0) {
                                    byte[] values = getValues(this.eq[c3]);
                                    int length = values.length;
                                    int i6 = i2;
                                    while (i4 < length) {
                                        byte b = values[i4];
                                        if (i6 < bArr.length && b > bArr[i6]) {
                                            bArr[i6] = b;
                                        }
                                        i6++;
                                        i4++;
                                    }
                                } else {
                                    c3 = this.lo[c3];
                                }
                            }
                        } else {
                            return;
                        }
                    } else {
                        c2 = i5 < 0 ? this.lo[c2] : this.hi[c2];
                    }
                } else if (hstrcmp(cArr, i3, this.kv.getArray(), this.lo[c2]) == 0) {
                    byte[] values2 = getValues(this.eq[c2]);
                    int length2 = values2.length;
                    while (i4 < length2) {
                        byte b2 = values2[i4];
                        if (i2 < bArr.length && b2 > bArr[i2]) {
                            bArr[i2] = b2;
                        }
                        i2++;
                        i4++;
                    }
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public String unpackValues(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + 1;
        byte b = this.vspace.get(i2);
        while (b != 0) {
            stringBuffer.append((char) (((b >>> 4) - 1) + 48));
            char c = (char) (b & Ascii.SI);
            if (c == 0) {
                break;
            }
            stringBuffer.append((char) ((c - 1) + 48));
            b = this.vspace.get(i3);
            i3++;
        }
        return stringBuffer.toString();
    }

    public qw hyphenate(char[] cArr, int i2, int i3, int i4, int i5) {
        int i6;
        char[] cArr2 = cArr;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        char[] cArr3 = new char[(i8 + 3)];
        char[] cArr4 = new char[2];
        int i10 = i8;
        boolean z = false;
        int i11 = 0;
        for (int i12 = 1; i12 <= i8; i12++) {
            cArr4[0] = cArr2[(i7 + i12) - 1];
            int find = this.classmap.find(cArr4, 0);
            if (find < 0) {
                int i13 = i11 + 1;
                if (i12 == i13) {
                    i11 = i13;
                } else {
                    z = true;
                }
                i10--;
            } else if (z) {
                return null;
            } else {
                cArr3[i12 - i11] = (char) find;
            }
        }
        if (i10 < i9 + i5) {
            return null;
        }
        int i14 = i10 + 1;
        int[] iArr = new int[i14];
        String str = new String(cArr3, 1, i10);
        if (this.stoplist.containsKey(str)) {
            ArrayList arrayList = this.stoplist.get(str);
            int i15 = 0;
            i6 = 0;
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                Object obj = arrayList.get(i16);
                if ((obj instanceof String) && (i15 = i15 + ((String) obj).length()) >= i9 && i15 < i10 - i5) {
                    iArr[i6] = i15 + i11;
                    i6++;
                }
            }
        } else {
            cArr3[0] = '.';
            cArr3[i14] = '.';
            cArr3[i10 + 2] = 0;
            byte[] bArr = new byte[(i10 + 3)];
            for (int i17 = 0; i17 < i14; i17++) {
                searchPatterns(cArr3, i17, bArr);
            }
            int i18 = 0;
            int i19 = 0;
            while (i19 < i10) {
                int i20 = i19 + 1;
                if ((bArr[i20] & 1) == 1 && i19 >= i9 && i19 <= i10 - i5) {
                    iArr[i18] = i19 + i11;
                    i18++;
                }
                i19 = i20;
            }
            i6 = i18;
        }
        if (i6 <= 0) {
            return null;
        }
        int[] iArr2 = new int[i6];
        System.arraycopy(iArr, 0, iArr2, 0, i6);
        return new qw(new String(cArr2, i7, i8), iArr2);
    }
}
