package com.itextpdf.text.pdf.codec;

import fe.when.ad.c.qw;
import fe.when.ad.f.e2;
import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

public class TIFFDirectory implements Serializable {
    public static final long serialVersionUID = -168636766193675380L;
    public static final int[] sizeOfType = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    public long IFDOffset = 8;
    public Hashtable<Integer, Integer> fieldIndex = new Hashtable<>();
    public TIFFField[] fields;
    public boolean isBigEndian;
    public long nextIFDOffset = 0;
    public int numEntries;

    public TIFFDirectory() {
    }

    public static int getNumDirectories(e2 e2Var) throws IOException {
        long qw = e2Var.qw();
        e2Var.when(0);
        int readUnsignedShort = e2Var.readUnsignedShort();
        int i2 = 0;
        if (isValidEndianTag(readUnsignedShort)) {
            boolean z = readUnsignedShort == 19789;
            if (readUnsignedShort(e2Var, z) == 42) {
                e2Var.when(4);
                long readUnsignedInt = readUnsignedInt(e2Var, z);
                while (readUnsignedInt != 0) {
                    i2++;
                    try {
                        e2Var.when(readUnsignedInt);
                        e2Var.skip((long) (readUnsignedShort(e2Var, z) * 12));
                        readUnsignedInt = readUnsignedInt(e2Var, z);
                    } catch (EOFException unused) {
                        i2--;
                    }
                }
                e2Var.when(qw);
                return i2;
            }
            throw new IllegalArgumentException(qw.ad("bad.magic.number.should.be.42", new Object[0]));
        }
        throw new IllegalArgumentException(qw.ad("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [byte[], char[], short[]], vars: [r4v4 ?, r4v5 ?, r4v6 ?, r4v7 ?, r4v8 ?, r4v9 ?, r4v12 ?, r4v13 ?, r4v14 ?, r4v17 ?, r4v18 ?, r4v19 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private void initialize(fe.when.ad.f.e2 r20) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            long r2 = r20.ad()
            long r4 = r20.qw()
            r0.IFDOffset = r4
            int r4 = r19.readUnsignedShort(r20)
            r0.numEntries = r4
            com.itextpdf.text.pdf.codec.TIFFField[] r4 = new com.itextpdf.text.pdf.codec.TIFFField[r4]
            r0.fields = r4
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x001c:
            int r10 = r0.numEntries
            if (r7 >= r10) goto L_0x0151
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 >= 0) goto L_0x0151
            int r8 = r19.readUnsignedShort(r20)
            int r9 = r19.readUnsignedShort(r20)
            long r10 = r19.readUnsignedInt(r20)
            int r11 = (int) r10
            long r12 = r20.qw()
            r14 = 4
            long r12 = r12 + r14
            r10 = 1
            int[] r14 = sizeOfType     // Catch:{ ArrayIndexOutOfBoundsException -> 0x004f }
            r14 = r14[r9]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x004f }
            int r14 = r14 * r11
            r15 = 4
            if (r14 <= r15) goto L_0x004d
            long r14 = r19.readUnsignedInt(r20)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x004f }
            int r16 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r16 >= 0) goto L_0x004f
            r1.when(r14)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x004f }
        L_0x004d:
            r14 = 1
            goto L_0x0050
        L_0x004f:
            r14 = 0
        L_0x0050:
            if (r14 == 0) goto L_0x0148
            java.util.Hashtable<java.lang.Integer, java.lang.Integer> r14 = r0.fieldIndex
            java.lang.Integer r15 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r14.put(r15, r4)
            r4 = 0
            r5 = 2
            switch(r9) {
                case 1: goto L_0x0103;
                case 2: goto L_0x0103;
                case 3: goto L_0x00f4;
                case 4: goto L_0x00e6;
                case 5: goto L_0x00c2;
                case 6: goto L_0x0103;
                case 7: goto L_0x0103;
                case 8: goto L_0x00b4;
                case 9: goto L_0x00a6;
                case 10: goto L_0x0082;
                case 11: goto L_0x0074;
                case 12: goto L_0x0066;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x013f
        L_0x0066:
            double[] r4 = new double[r11]
            r5 = 0
        L_0x0069:
            if (r5 >= r11) goto L_0x013f
            double r14 = r19.readDouble(r20)
            r4[r5] = r14
            int r5 = r5 + 1
            goto L_0x0069
        L_0x0074:
            float[] r4 = new float[r11]
            r5 = 0
        L_0x0077:
            if (r5 >= r11) goto L_0x013f
            float r10 = r19.readFloat(r20)
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x0077
        L_0x0082:
            int[] r4 = new int[r5]
            r4[r10] = r5
            r4[r6] = r11
            java.lang.Class<int> r5 = int.class
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r5, r4)
            int[][] r4 = (int[][]) r4
            r5 = 0
        L_0x0091:
            if (r5 >= r11) goto L_0x013f
            r14 = r4[r5]
            int r15 = r19.readInt(r20)
            r14[r6] = r15
            r14 = r4[r5]
            int r15 = r19.readInt(r20)
            r14[r10] = r15
            int r5 = r5 + 1
            goto L_0x0091
        L_0x00a6:
            int[] r4 = new int[r11]
            r5 = 0
        L_0x00a9:
            if (r5 >= r11) goto L_0x013f
            int r10 = r19.readInt(r20)
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x00a9
        L_0x00b4:
            short[] r4 = new short[r11]
            r5 = 0
        L_0x00b7:
            if (r5 >= r11) goto L_0x013f
            short r10 = r19.readShort(r20)
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x00b7
        L_0x00c2:
            int[] r4 = new int[r5]
            r4[r10] = r5
            r4[r6] = r11
            java.lang.Class<long> r5 = long.class
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r5, r4)
            long[][] r4 = (long[][]) r4
            r5 = 0
        L_0x00d1:
            if (r5 >= r11) goto L_0x013f
            r14 = r4[r5]
            long r17 = r19.readUnsignedInt(r20)
            r14[r6] = r17
            r14 = r4[r5]
            long r17 = r19.readUnsignedInt(r20)
            r14[r10] = r17
            int r5 = r5 + 1
            goto L_0x00d1
        L_0x00e6:
            long[] r4 = new long[r11]
            r5 = 0
        L_0x00e9:
            if (r5 >= r11) goto L_0x013f
            long r14 = r19.readUnsignedInt(r20)
            r4[r5] = r14
            int r5 = r5 + 1
            goto L_0x00e9
        L_0x00f4:
            char[] r4 = new char[r11]
            r5 = 0
        L_0x00f7:
            if (r5 >= r11) goto L_0x013f
            int r10 = r19.readUnsignedShort(r20)
            char r10 = (char) r10
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x00f7
        L_0x0103:
            byte[] r4 = new byte[r11]
            r1.readFully(r4, r6, r11)
            if (r9 != r5) goto L_0x013f
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r10 = 0
            r14 = 0
        L_0x0111:
            if (r10 >= r11) goto L_0x012b
        L_0x0113:
            if (r10 >= r11) goto L_0x011e
            int r15 = r10 + 1
            byte r10 = r4[r10]
            if (r10 == 0) goto L_0x011d
            r10 = r15
            goto L_0x0113
        L_0x011d:
            r10 = r15
        L_0x011e:
            java.lang.String r15 = new java.lang.String
            int r6 = r10 - r14
            r15.<init>(r4, r14, r6)
            r5.add(r15)
            r14 = r10
            r6 = 0
            goto L_0x0111
        L_0x012b:
            int r11 = r5.size()
            java.lang.String[] r4 = new java.lang.String[r11]
            r6 = 0
        L_0x0132:
            if (r6 >= r11) goto L_0x013f
            java.lang.Object r10 = r5.get(r6)
            java.lang.String r10 = (java.lang.String) r10
            r4[r6] = r10
            int r6 = r6 + 1
            goto L_0x0132
        L_0x013f:
            com.itextpdf.text.pdf.codec.TIFFField[] r5 = r0.fields
            com.itextpdf.text.pdf.codec.TIFFField r6 = new com.itextpdf.text.pdf.codec.TIFFField
            r6.<init>(r8, r9, r11, r4)
            r5[r7] = r6
        L_0x0148:
            r1.when(r12)
            int r7 = r7 + 1
            r8 = r12
            r6 = 0
            goto L_0x001c
        L_0x0151:
            long r1 = r19.readUnsignedInt(r20)     // Catch:{ Exception -> 0x0158 }
            r0.nextIFDOffset = r1     // Catch:{ Exception -> 0x0158 }
            goto L_0x015c
        L_0x0158:
            r1 = 0
            r0.nextIFDOffset = r1
        L_0x015c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFDirectory.initialize(fe.when.ad.f.e2):void");
    }

    public static boolean isValidEndianTag(int i2) {
        return i2 == 18761 || i2 == 19789;
    }

    private double readDouble(e2 e2Var) throws IOException {
        if (this.isBigEndian) {
            return e2Var.readDouble();
        }
        return e2Var.rg();
    }

    private float readFloat(e2 e2Var) throws IOException {
        if (this.isBigEndian) {
            return e2Var.readFloat();
        }
        return e2Var.th();
    }

    private int readInt(e2 e2Var) throws IOException {
        if (this.isBigEndian) {
            return e2Var.readInt();
        }
        return e2Var.yj();
    }

    private long readLong(e2 e2Var) throws IOException {
        if (this.isBigEndian) {
            return e2Var.readLong();
        }
        return e2Var.uk();
    }

    private short readShort(e2 e2Var) throws IOException {
        if (this.isBigEndian) {
            return e2Var.readShort();
        }
        return e2Var.i();
    }

    private long readUnsignedInt(e2 e2Var) throws IOException {
        if (this.isBigEndian) {
            return e2Var.pf();
        }
        return e2Var.m1077if();
    }

    private int readUnsignedShort(e2 e2Var) throws IOException {
        if (this.isBigEndian) {
            return e2Var.readUnsignedShort();
        }
        return e2Var.m1078switch();
    }

    public TIFFField getField(int i2) {
        Integer num = this.fieldIndex.get(Integer.valueOf(i2));
        if (num == null) {
            return null;
        }
        return this.fields[num.intValue()];
    }

    public byte getFieldAsByte(int i2, int i3) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i2)).intValue()].getAsBytes()[i3];
    }

    public double getFieldAsDouble(int i2, int i3) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i2)).intValue()].getAsDouble(i3);
    }

    public float getFieldAsFloat(int i2, int i3) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i2)).intValue()].getAsFloat(i3);
    }

    public long getFieldAsLong(int i2, int i3) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i2)).intValue()].getAsLong(i3);
    }

    public TIFFField[] getFields() {
        return this.fields;
    }

    public long getIFDOffset() {
        return this.IFDOffset;
    }

    public long getNextIFDOffset() {
        return this.nextIFDOffset;
    }

    public int getNumEntries() {
        return this.numEntries;
    }

    public int[] getTags() {
        int[] iArr = new int[this.fieldIndex.size()];
        Enumeration<Integer> keys = this.fieldIndex.keys();
        int i2 = 0;
        while (keys.hasMoreElements()) {
            iArr[i2] = keys.nextElement().intValue();
            i2++;
        }
        return iArr;
    }

    public boolean isBigEndian() {
        return this.isBigEndian;
    }

    public boolean isTagPresent(int i2) {
        return this.fieldIndex.containsKey(Integer.valueOf(i2));
    }

    public double getFieldAsDouble(int i2) {
        return getFieldAsDouble(i2, 0);
    }

    public float getFieldAsFloat(int i2) {
        return getFieldAsFloat(i2, 0);
    }

    public long getFieldAsLong(int i2) {
        return getFieldAsLong(i2, 0);
    }

    public static long readUnsignedInt(e2 e2Var, boolean z) throws IOException {
        if (z) {
            return e2Var.pf();
        }
        return e2Var.m1077if();
    }

    public static int readUnsignedShort(e2 e2Var, boolean z) throws IOException {
        if (z) {
            return e2Var.readUnsignedShort();
        }
        return e2Var.m1078switch();
    }

    public byte getFieldAsByte(int i2) {
        return getFieldAsByte(i2, 0);
    }

    public TIFFDirectory(e2 e2Var, int i2) throws IOException {
        long qw = e2Var.qw();
        e2Var.when(0);
        int readUnsignedShort = e2Var.readUnsignedShort();
        if (isValidEndianTag(readUnsignedShort)) {
            this.isBigEndian = readUnsignedShort == 19789;
            if (readUnsignedShort(e2Var) == 42) {
                long readUnsignedInt = readUnsignedInt(e2Var);
                int i3 = 0;
                while (i3 < i2) {
                    if (readUnsignedInt != 0) {
                        e2Var.when(readUnsignedInt);
                        e2Var.skip((long) (readUnsignedShort(e2Var) * 12));
                        readUnsignedInt = readUnsignedInt(e2Var);
                        i3++;
                    } else {
                        throw new IllegalArgumentException(qw.ad("directory.number.too.large", new Object[0]));
                    }
                }
                e2Var.when(readUnsignedInt);
                initialize(e2Var);
                e2Var.when(qw);
                return;
            }
            throw new IllegalArgumentException(qw.ad("bad.magic.number.should.be.42", new Object[0]));
        }
        throw new IllegalArgumentException(qw.ad("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }

    public TIFFDirectory(e2 e2Var, long j, int i2) throws IOException {
        long qw = e2Var.qw();
        e2Var.when(0);
        int readUnsignedShort = e2Var.readUnsignedShort();
        if (isValidEndianTag(readUnsignedShort)) {
            this.isBigEndian = readUnsignedShort == 19789;
            e2Var.when(j);
            for (int i3 = 0; i3 < i2; i3++) {
                e2Var.when(j + ((long) (readUnsignedShort(e2Var) * 12)));
                j = readUnsignedInt(e2Var);
                e2Var.when(j);
            }
            initialize(e2Var);
            e2Var.when(qw);
            return;
        }
        throw new IllegalArgumentException(qw.ad("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }
}
