package com.baidu.android.util.io;

import java.text.DecimalFormat;

@Deprecated
public class ByteUnitConverter {
    public static final int GB = 1073741824;
    public static final int KB = 1024;
    public static final int MB = 1048576;
    public static final int UNIT = 1024;
    public String convertStr;

    /* renamed from: com.baidu.android.util.io.ByteUnitConverter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.baidu.android.util.io.ByteUnitConverter$UNITS[] r0 = com.baidu.android.util.io.ByteUnitConverter.UNITS.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS = r0
                com.baidu.android.util.io.ByteUnitConverter$UNITS r1 = com.baidu.android.util.io.ByteUnitConverter.UNITS.B     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.android.util.io.ByteUnitConverter$UNITS r1 = com.baidu.android.util.io.ByteUnitConverter.UNITS.KB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.android.util.io.ByteUnitConverter$UNITS r1 = com.baidu.android.util.io.ByteUnitConverter.UNITS.MB     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.android.util.io.ByteUnitConverter$UNITS r1 = com.baidu.android.util.io.ByteUnitConverter.UNITS.GB     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.io.ByteUnitConverter.AnonymousClass1.<clinit>():void");
        }
    }

    public enum UNITS {
        B,
        KB,
        MB,
        GB
    }

    public ByteUnitConverter(double d) {
        this(d, UNITS.B);
    }

    private void convertByte(double d) {
        String str;
        float f;
        if (d < 1024.0d) {
            f = (float) d;
            str = "B";
        } else if (d < 1048576.0d) {
            f = ((float) d) / 1024.0f;
            str = "KB";
        } else if (d < 1.073741824E9d) {
            f = ((float) d) / 1048576.0f;
            str = "MB";
        } else {
            f = ((float) d) / 1.07374182E9f;
            str = "GB";
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        this.convertStr = decimalFormat.format((double) f) + str;
    }

    private void convertGigaByte(double d) {
        convertMegaByte(d * 1024.0d);
    }

    private void convertKiloByte(double d) {
        convertByte(d * 1024.0d);
    }

    private void convertMegaByte(double d) {
        convertKiloByte(d * 1024.0d);
    }

    public String toString() {
        return this.convertStr;
    }

    public ByteUnitConverter(double d, UNITS units) {
        int i2 = AnonymousClass1.$SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS[units.ordinal()];
        if (i2 == 1) {
            convertByte(d);
        } else if (i2 == 2) {
            convertKiloByte(d);
        } else if (i2 == 3) {
            convertMegaByte(d);
        } else if (i2 == 4) {
            convertGigaByte(d);
        }
    }
}
