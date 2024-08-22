package com.itextpdf.text.pdf.hyphenation;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Stack;
import kotlin.jvm.internal.CharCompanionObject;

public class TernaryTree implements Cloneable, Serializable {
    public static final int BLOCK_SIZE = 2048;
    public static final long serialVersionUID = 5313366505322983510L;
    public char[] eq;
    public char freenode;
    public char[] hi;
    public CharVector kv;
    public int length;
    public char[] lo;
    public char root;
    public char[] sc;

    public class qw implements Enumeration<String> {

        /* renamed from: ad  reason: collision with root package name */
        public String f6552ad;

        /* renamed from: de  reason: collision with root package name */
        public Stack<C0258qw> f6553de = new Stack<>();

        /* renamed from: fe  reason: collision with root package name */
        public StringBuffer f6554fe = new StringBuffer();
        public int qw = -1;

        /* renamed from: com.itextpdf.text.pdf.hyphenation.TernaryTree$qw$qw  reason: collision with other inner class name */
        public class C0258qw implements Cloneable {

            /* renamed from: ad  reason: collision with root package name */
            public char f6556ad;

            /* renamed from: th  reason: collision with root package name */
            public char f6557th;

            public C0258qw(char c, char c2) {
                this.f6556ad = c;
                this.f6557th = c2;
            }

            /* renamed from: ad */
            public C0258qw clone() {
                return new C0258qw(this.f6556ad, this.f6557th);
            }
        }

        public qw() {
            de();
        }

        /* renamed from: ad */
        public String nextElement() {
            String str = this.f6552ad;
            this.qw = rg();
            fe();
            return str;
        }

        public void de() {
            this.f6553de.removeAllElements();
            this.f6554fe.setLength(0);
            this.qw = TernaryTree.this.root;
            fe();
        }

        /* JADX WARNING: type inference failed for: r4v1, types: [int] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int fe() {
            /*
                r8 = this;
                int r0 = r8.qw
                r1 = -1
                if (r0 != r1) goto L_0x0006
                return r1
            L_0x0006:
                r0 = 0
                r2 = 0
            L_0x0008:
                int r3 = r8.qw
                r4 = 65535(0xffff, float:9.1834E-41)
                r5 = 1
                if (r3 == 0) goto L_0x0037
                com.itextpdf.text.pdf.hyphenation.TernaryTree r6 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                char[] r6 = r6.sc
                char r6 = r6[r3]
                if (r6 != r4) goto L_0x001a
            L_0x0018:
                r2 = 1
                goto L_0x0037
            L_0x001a:
                java.util.Stack<com.itextpdf.text.pdf.hyphenation.TernaryTree$qw$qw> r6 = r8.f6553de
                com.itextpdf.text.pdf.hyphenation.TernaryTree$qw$qw r7 = new com.itextpdf.text.pdf.hyphenation.TernaryTree$qw$qw
                char r3 = (char) r3
                r7.<init>(r3, r0)
                r6.push(r7)
                com.itextpdf.text.pdf.hyphenation.TernaryTree r3 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                char[] r6 = r3.sc
                int r7 = r8.qw
                char r6 = r6[r7]
                if (r6 != 0) goto L_0x0030
                goto L_0x0018
            L_0x0030:
                char[] r3 = r3.lo
                char r3 = r3[r7]
                r8.qw = r3
                goto L_0x0008
            L_0x0037:
                if (r2 == 0) goto L_0x0072
                java.lang.StringBuffer r1 = new java.lang.StringBuffer
                java.lang.StringBuffer r2 = r8.f6554fe
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                com.itextpdf.text.pdf.hyphenation.TernaryTree r2 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                char[] r3 = r2.sc
                int r5 = r8.qw
                char r3 = r3[r5]
                if (r3 != r4) goto L_0x006b
                char[] r2 = r2.lo
                char r2 = r2[r5]
            L_0x0052:
                com.itextpdf.text.pdf.hyphenation.TernaryTree r3 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                com.itextpdf.text.pdf.hyphenation.CharVector r3 = r3.kv
                char r3 = r3.get(r2)
                if (r3 == 0) goto L_0x006b
                com.itextpdf.text.pdf.hyphenation.TernaryTree r3 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                com.itextpdf.text.pdf.hyphenation.CharVector r3 = r3.kv
                int r4 = r2 + 1
                char r2 = r3.get(r2)
                r1.append(r2)
                r2 = r4
                goto L_0x0052
            L_0x006b:
                java.lang.String r1 = r1.toString()
                r8.f6552ad = r1
                return r0
            L_0x0072:
                int r3 = r8.rg()
                r8.qw = r3
                if (r3 != r1) goto L_0x0008
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.hyphenation.TernaryTree.qw.fe():int");
        }

        public boolean hasMoreElements() {
            return this.qw != -1;
        }

        public char qw() {
            int i2 = this.qw;
            if (i2 >= 0) {
                return TernaryTree.this.eq[i2];
            }
            return 0;
        }

        public final int rg() {
            if (this.f6553de.empty()) {
                return -1;
            }
            int i2 = this.qw;
            if (i2 != 0) {
                TernaryTree ternaryTree = TernaryTree.this;
                if (ternaryTree.sc[i2] == 0) {
                    return ternaryTree.lo[i2];
                }
            }
            boolean z = true;
            char c = 0;
            while (z) {
                C0258qw pop = this.f6553de.pop();
                char c2 = (char) (pop.f6557th + 1);
                pop.f6557th = c2;
                if (c2 == 1) {
                    TernaryTree ternaryTree2 = TernaryTree.this;
                    char[] cArr = ternaryTree2.sc;
                    char c3 = pop.f6556ad;
                    if (cArr[c3] != 0) {
                        c = ternaryTree2.eq[c3];
                        this.f6553de.push(pop.clone());
                        this.f6554fe.append(TernaryTree.this.sc[pop.f6556ad]);
                    } else {
                        pop.f6557th = (char) (c2 + 1);
                        this.f6553de.push(pop.clone());
                        c = TernaryTree.this.hi[pop.f6556ad];
                    }
                } else if (c2 == 2) {
                    c = TernaryTree.this.hi[pop.f6556ad];
                    this.f6553de.push(pop.clone());
                    if (this.f6554fe.length() > 0) {
                        StringBuffer stringBuffer = this.f6554fe;
                        stringBuffer.setLength(stringBuffer.length() - 1);
                    }
                } else if (this.f6553de.empty()) {
                    return -1;
                } else {
                    z = true;
                }
                z = false;
            }
            return c;
        }
    }

    public TernaryTree() {
        init();
    }

    private void compact(CharVector charVector, TernaryTree ternaryTree, char c) {
        if (c != 0) {
            if (this.sc[c] == 65535) {
                int find = ternaryTree.find(this.kv.getArray(), this.lo[c]);
                if (find < 0) {
                    find = charVector.alloc(strlen(this.kv.getArray(), this.lo[c]) + 1);
                    strcpy(charVector.getArray(), find, this.kv.getArray(), this.lo[c]);
                    ternaryTree.insert(charVector.getArray(), find, (char) find);
                }
                this.lo[c] = (char) find;
                return;
            }
            compact(charVector, ternaryTree, this.lo[c]);
            if (this.sc[c] != 0) {
                compact(charVector, ternaryTree, this.eq[c]);
            }
            compact(charVector, ternaryTree, this.hi[c]);
        }
    }

    private void redimNodeArrays(int i2) {
        char[] cArr = this.lo;
        int length2 = i2 < cArr.length ? i2 : cArr.length;
        char[] cArr2 = new char[i2];
        System.arraycopy(this.lo, 0, cArr2, 0, length2);
        this.lo = cArr2;
        char[] cArr3 = new char[i2];
        System.arraycopy(this.hi, 0, cArr3, 0, length2);
        this.hi = cArr3;
        char[] cArr4 = new char[i2];
        System.arraycopy(this.eq, 0, cArr4, 0, length2);
        this.eq = cArr4;
        char[] cArr5 = new char[i2];
        System.arraycopy(this.sc, 0, cArr5, 0, length2);
        this.sc = cArr5;
    }

    public static int strcmp(char[] cArr, int i2, char[] cArr2, int i3) {
        while (cArr[i2] == cArr2[i3]) {
            if (cArr[i2] == 0) {
                return 0;
            }
            i2++;
            i3++;
        }
        return cArr[i2] - cArr2[i3];
    }

    public static void strcpy(char[] cArr, int i2, char[] cArr2, int i3) {
        while (cArr2[i3] != 0) {
            cArr[i2] = cArr2[i3];
            i2++;
            i3++;
        }
        cArr[i2] = 0;
    }

    public static int strlen(char[] cArr, int i2) {
        int i3 = 0;
        while (i2 < cArr.length && cArr[i2] != 0) {
            i3++;
            i2++;
        }
        return i3;
    }

    public void balance() {
        int i2 = this.length;
        String[] strArr = new String[i2];
        char[] cArr = new char[i2];
        qw qwVar = new qw();
        int i3 = 0;
        while (qwVar.hasMoreElements()) {
            cArr[i3] = qwVar.qw();
            strArr[i3] = qwVar.nextElement();
            i3++;
        }
        init();
        insertBalanced(strArr, cArr, 0, i2);
    }

    public Object clone() {
        TernaryTree ternaryTree = new TernaryTree();
        ternaryTree.lo = (char[]) this.lo.clone();
        ternaryTree.hi = (char[]) this.hi.clone();
        ternaryTree.eq = (char[]) this.eq.clone();
        ternaryTree.sc = (char[]) this.sc.clone();
        ternaryTree.kv = (CharVector) this.kv.clone();
        ternaryTree.root = this.root;
        ternaryTree.freenode = this.freenode;
        ternaryTree.length = this.length;
        return ternaryTree;
    }

    public int find(String str) {
        int length2 = str.length();
        char[] cArr = new char[(length2 + 1)];
        str.getChars(0, length2, cArr, 0);
        cArr[length2] = 0;
        return find(cArr, 0);
    }

    public void init() {
        this.root = 0;
        this.freenode = 1;
        this.length = 0;
        this.lo = new char[2048];
        this.hi = new char[2048];
        this.eq = new char[2048];
        this.sc = new char[2048];
        this.kv = new CharVector();
    }

    public void insert(String str, char c) {
        int length2 = str.length() + 1;
        int i2 = this.freenode + length2;
        char[] cArr = this.eq;
        if (i2 > cArr.length) {
            redimNodeArrays(cArr.length + 2048);
        }
        int i3 = length2 - 1;
        char[] cArr2 = new char[length2];
        str.getChars(0, i3, cArr2, 0);
        cArr2[i3] = 0;
        this.root = insert(this.root, cArr2, 0, c);
    }

    public void insertBalanced(String[] strArr, char[] cArr, int i2, int i3) {
        if (i3 >= 1) {
            int i4 = i3 >> 1;
            int i5 = i4 + i2;
            insert(strArr[i5], cArr[i5]);
            insertBalanced(strArr, cArr, i2, i4);
            insertBalanced(strArr, cArr, i5 + 1, (i3 - i4) - 1);
        }
    }

    public Enumeration<String> keys() {
        return new qw();
    }

    public boolean knows(String str) {
        return find(str) >= 0;
    }

    public void printStats() {
        PrintStream printStream = System.out;
        printStream.println("Number of keys = " + Integer.toString(this.length));
        PrintStream printStream2 = System.out;
        printStream2.println("Node count = " + Integer.toString(this.freenode));
        PrintStream printStream3 = System.out;
        printStream3.println("Key Array length = " + Integer.toString(this.kv.length()));
    }

    public int size() {
        return this.length;
    }

    public void trimToSize() {
        balance();
        redimNodeArrays(this.freenode);
        CharVector charVector = new CharVector();
        charVector.alloc(1);
        compact(charVector, new TernaryTree(), this.root);
        this.kv = charVector;
        charVector.trimToSize();
    }

    public static int strlen(char[] cArr) {
        return strlen(cArr, 0);
    }

    public static int strcmp(String str, char[] cArr, int i2) {
        int length2 = str.length();
        int i3 = 0;
        while (i3 < length2) {
            int i4 = i2 + i3;
            int charAt = str.charAt(i3) - cArr[i4];
            if (charAt != 0 || cArr[i4] == 0) {
                return charAt;
            }
            i3++;
        }
        int i5 = i2 + i3;
        if (cArr[i5] != 0) {
            return -cArr[i5];
        }
        return 0;
    }

    public int find(char[] cArr, int i2) {
        char c = this.root;
        while (c != 0) {
            char[] cArr2 = this.sc;
            if (cArr2[c] != 65535) {
                char c2 = cArr[i2];
                int i3 = c2 - cArr2[c];
                if (i3 == 0) {
                    if (c2 == 0) {
                        return this.eq[c];
                    }
                    i2++;
                    c = this.eq[c];
                } else if (i3 < 0) {
                    c = this.lo[c];
                } else {
                    c = this.hi[c];
                }
            } else if (strcmp(cArr, i2, this.kv.getArray(), this.lo[c]) == 0) {
                return this.eq[c];
            } else {
                return -1;
            }
        }
        return -1;
    }

    public void insert(char[] cArr, int i2, char c) {
        int strlen = this.freenode + strlen(cArr) + 1;
        char[] cArr2 = this.eq;
        if (strlen > cArr2.length) {
            redimNodeArrays(cArr2.length + 2048);
        }
        this.root = insert(this.root, cArr, i2, c);
    }

    private char insert(char c, char[] cArr, int i2, char c2) {
        int strlen = strlen(cArr, i2);
        if (c == 0) {
            char c3 = this.freenode;
            this.freenode = (char) (c3 + 1);
            this.eq[c3] = c2;
            this.length++;
            this.hi[c3] = 0;
            if (strlen > 0) {
                this.sc[c3] = CharCompanionObject.MAX_VALUE;
                this.lo[c3] = (char) this.kv.alloc(strlen + 1);
                strcpy(this.kv.getArray(), this.lo[c3], cArr, i2);
            } else {
                this.sc[c3] = 0;
                this.lo[c3] = 0;
            }
            return c3;
        }
        char[] cArr2 = this.sc;
        if (cArr2[c] == 65535) {
            char c4 = this.freenode;
            this.freenode = (char) (c4 + 1);
            char[] cArr3 = this.lo;
            cArr3[c4] = cArr3[c];
            char[] cArr4 = this.eq;
            cArr4[c4] = cArr4[c];
            cArr3[c] = 0;
            if (strlen > 0) {
                cArr2[c] = this.kv.get(cArr3[c4]);
                this.eq[c] = c4;
                char[] cArr5 = this.lo;
                cArr5[c4] = (char) (cArr5[c4] + 1);
                if (this.kv.get(cArr5[c4]) == 0) {
                    this.lo[c4] = 0;
                    this.sc[c4] = 0;
                    this.hi[c4] = 0;
                } else {
                    this.sc[c4] = CharCompanionObject.MAX_VALUE;
                }
            } else {
                cArr2[c4] = CharCompanionObject.MAX_VALUE;
                this.hi[c] = c4;
                cArr2[c] = 0;
                cArr4[c] = c2;
                this.length++;
                return c;
            }
        }
        char c5 = cArr[i2];
        char[] cArr6 = this.sc;
        if (c5 < cArr6[c]) {
            char[] cArr7 = this.lo;
            cArr7[c] = insert(cArr7[c], cArr, i2, c2);
        } else if (c5 != cArr6[c]) {
            char[] cArr8 = this.hi;
            cArr8[c] = insert(cArr8[c], cArr, i2, c2);
        } else if (c5 != 0) {
            char[] cArr9 = this.eq;
            cArr9[c] = insert(cArr9[c], cArr, i2 + 1, c2);
        } else {
            this.eq[c] = c2;
        }
        return c;
    }
}
