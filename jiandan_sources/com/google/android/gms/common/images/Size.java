package com.google.android.gms.common.images;

import com.dlife.ctaccountapi.x;

public final class Size {
    public final int zanj;
    public final int zank;

    public Size(int i2, int i3) {
        this.zanj = i2;
        this.zank = i3;
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw zah(str);
                }
            } else {
                throw zah(str);
            }
        } else {
            throw new IllegalArgumentException("string must not be null");
        }
    }

    public static NumberFormatException zah(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 16);
        sb.append("Invalid Size: \"");
        sb.append(str);
        sb.append("\"");
        throw new NumberFormatException(sb.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.zanj == size.zanj && this.zank == size.zank;
        }
    }

    public final int getHeight() {
        return this.zank;
    }

    public final int getWidth() {
        return this.zanj;
    }

    public final int hashCode() {
        int i2 = this.zank;
        int i3 = this.zanj;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    public final String toString() {
        int i2 = this.zanj;
        int i3 = this.zank;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i2);
        sb.append(x.a);
        sb.append(i3);
        return sb.toString();
    }
}
