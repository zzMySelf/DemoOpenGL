package com.itextpdf.text.pdf.codec;

import java.io.Serializable;
import kotlin.jvm.internal.CharCompanionObject;

public class TIFFField implements Comparable<TIFFField>, Serializable {
    public static final int TIFF_ASCII = 2;
    public static final int TIFF_BYTE = 1;
    public static final int TIFF_DOUBLE = 12;
    public static final int TIFF_FLOAT = 11;
    public static final int TIFF_LONG = 4;
    public static final int TIFF_RATIONAL = 5;
    public static final int TIFF_SBYTE = 6;
    public static final int TIFF_SHORT = 3;
    public static final int TIFF_SLONG = 9;
    public static final int TIFF_SRATIONAL = 10;
    public static final int TIFF_SSHORT = 8;
    public static final int TIFF_UNDEFINED = 7;
    public static final long serialVersionUID = 9088332901412823834L;
    public int count;
    public Object data;
    public int tag;
    public int type;

    public TIFFField() {
    }

    public byte[] getAsBytes() {
        return (byte[]) this.data;
    }

    public char[] getAsChars() {
        return (char[]) this.data;
    }

    public double getAsDouble(int i2) {
        double d;
        double d2;
        switch (this.type) {
            case 1:
                return (double) (((byte[]) this.data)[i2] & 255);
            case 3:
                return (double) (((char[]) this.data)[i2] & CharCompanionObject.MAX_VALUE);
            case 4:
                return (double) ((long[]) this.data)[i2];
            case 5:
                long[] asRational = getAsRational(i2);
                d = (double) asRational[0];
                d2 = (double) asRational[1];
                break;
            case 6:
                return (double) ((byte[]) this.data)[i2];
            case 8:
                return (double) ((short[]) this.data)[i2];
            case 9:
                return (double) ((int[]) this.data)[i2];
            case 10:
                int[] asSRational = getAsSRational(i2);
                d = (double) asSRational[0];
                d2 = (double) asSRational[1];
                break;
            case 11:
                return (double) ((float[]) this.data)[i2];
            case 12:
                return ((double[]) this.data)[i2];
            default:
                throw new ClassCastException();
        }
        return d / d2;
    }

    public double[] getAsDoubles() {
        return (double[]) this.data;
    }

    public float getAsFloat(int i2) {
        switch (this.type) {
            case 1:
                return (float) (((byte[]) this.data)[i2] & 255);
            case 3:
                return (float) (((char[]) this.data)[i2] & CharCompanionObject.MAX_VALUE);
            case 4:
                return (float) ((long[]) this.data)[i2];
            case 5:
                long[] asRational = getAsRational(i2);
                return (float) (((double) asRational[0]) / ((double) asRational[1]));
            case 6:
                return (float) ((byte[]) this.data)[i2];
            case 8:
                return (float) ((short[]) this.data)[i2];
            case 9:
                return (float) ((int[]) this.data)[i2];
            case 10:
                int[] asSRational = getAsSRational(i2);
                return (float) (((double) asSRational[0]) / ((double) asSRational[1]));
            case 11:
                return ((float[]) this.data)[i2];
            case 12:
                return (float) ((double[]) this.data)[i2];
            default:
                throw new ClassCastException();
        }
    }

    public float[] getAsFloats() {
        return (float[]) this.data;
    }

    public int getAsInt(int i2) {
        int i3 = this.type;
        if (i3 != 1) {
            if (i3 == 3) {
                return ((char[]) this.data)[i2] & CharCompanionObject.MAX_VALUE;
            }
            switch (i3) {
                case 6:
                    return ((byte[]) this.data)[i2];
                case 7:
                    break;
                case 8:
                    return ((short[]) this.data)[i2];
                case 9:
                    return ((int[]) this.data)[i2];
                default:
                    throw new ClassCastException();
            }
        }
        return ((byte[]) this.data)[i2] & 255;
    }

    public int[] getAsInts() {
        return (int[]) this.data;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [byte, short], vars: [r4v2 ?, r4v7 ?, r4v4 ?, r4v5 ?, r4v6 ?, r4v8 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public long getAsLong(int r4) {
        /*
            r3 = this;
            int r0 = r3.type
            switch(r0) {
                case 1: goto L_0x0033;
                case 2: goto L_0x0005;
                case 3: goto L_0x0028;
                case 4: goto L_0x0021;
                case 5: goto L_0x0005;
                case 6: goto L_0x001a;
                case 7: goto L_0x0033;
                case 8: goto L_0x0013;
                case 9: goto L_0x000b;
                default: goto L_0x0005;
            }
        L_0x0005:
            java.lang.ClassCastException r4 = new java.lang.ClassCastException
            r4.<init>()
            throw r4
        L_0x000b:
            java.lang.Object r0 = r3.data
            int[] r0 = (int[]) r0
            r4 = r0[r4]
        L_0x0011:
            long r0 = (long) r4
            return r0
        L_0x0013:
            java.lang.Object r0 = r3.data
            short[] r0 = (short[]) r0
            short r4 = r0[r4]
            goto L_0x0011
        L_0x001a:
            java.lang.Object r0 = r3.data
            byte[] r0 = (byte[]) r0
            byte r4 = r0[r4]
            goto L_0x0011
        L_0x0021:
            java.lang.Object r0 = r3.data
            long[] r0 = (long[]) r0
            r1 = r0[r4]
            return r1
        L_0x0028:
            java.lang.Object r0 = r3.data
            char[] r0 = (char[]) r0
            char r4 = r0[r4]
            r0 = 65535(0xffff, float:9.1834E-41)
            r4 = r4 & r0
            goto L_0x0011
        L_0x0033:
            java.lang.Object r0 = r3.data
            byte[] r0 = (byte[]) r0
            byte r4 = r0[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFField.getAsLong(int):long");
    }

    public long[] getAsLongs() {
        return (long[]) this.data;
    }

    public long[] getAsRational(int i2) {
        if (this.type == 4) {
            return getAsLongs();
        }
        return ((long[][]) this.data)[i2];
    }

    public long[][] getAsRationals() {
        return (long[][]) this.data;
    }

    public int[] getAsSRational(int i2) {
        return ((int[][]) this.data)[i2];
    }

    public int[][] getAsSRationals() {
        return (int[][]) this.data;
    }

    public short[] getAsShorts() {
        return (short[]) this.data;
    }

    public String getAsString(int i2) {
        return ((String[]) this.data)[i2];
    }

    public int getCount() {
        return this.count;
    }

    public int getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public TIFFField(int i2, int i3, int i4, Object obj) {
        this.tag = i2;
        this.type = i3;
        this.count = i4;
        this.data = obj;
    }

    public int compareTo(TIFFField tIFFField) {
        if (tIFFField != null) {
            int tag2 = tIFFField.getTag();
            int i2 = this.tag;
            if (i2 < tag2) {
                return -1;
            }
            return i2 > tag2 ? 1 : 0;
        }
        throw new IllegalArgumentException();
    }
}
