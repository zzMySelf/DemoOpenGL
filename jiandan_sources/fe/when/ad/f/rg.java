package fe.when.ad.f;

import com.google.common.base.Ascii;
import fe.when.ad.c.qw;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class rg extends OutputStream {

    /* renamed from: i  reason: collision with root package name */
    public static final char[] f9750i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: if  reason: not valid java name */
    public static final DecimalFormatSymbols f454if = new DecimalFormatSymbols(Locale.US);

    /* renamed from: o  reason: collision with root package name */
    public static final byte[] f9751o = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: pf  reason: collision with root package name */
    public static boolean f9752pf = false;

    /* renamed from: uk  reason: collision with root package name */
    public static byte[][] f9753uk = new byte[0][];

    /* renamed from: yj  reason: collision with root package name */
    public static int f9754yj;

    /* renamed from: ad  reason: collision with root package name */
    public int f9755ad;

    /* renamed from: th  reason: collision with root package name */
    public byte[] f9756th;

    public rg() {
        this(128);
    }

    public static String ggg(double d) {
        return vvv(d, (rg) null);
    }

    public static String vvv(double d, rg rgVar) {
        boolean z;
        double d2 = d;
        rg rgVar2 = rgVar;
        if (f9752pf) {
            String format = new DecimalFormat("0.######", f454if).format(d2);
            if (rgVar2 == null) {
                return format;
            }
            rgVar2.uk(format);
            return null;
        } else if (Math.abs(d) >= 1.5E-5d) {
            int i2 = 0;
            if (d2 < 0.0d) {
                d2 = -d2;
                z = true;
            } else {
                z = false;
            }
            int i3 = 100000;
            if (d2 < 1.0d) {
                double d3 = d2 + 5.0E-6d;
                if (d3 >= 1.0d) {
                    if (z) {
                        if (rgVar2 == null) {
                            return "-1";
                        }
                        rgVar2.qw((byte) 45);
                        rgVar2.qw((byte) 49);
                        return null;
                    } else if (rgVar2 == null) {
                        return "1";
                    } else {
                        rgVar2.qw((byte) 49);
                        return null;
                    }
                } else if (rgVar2 != null) {
                    int i4 = (int) (d3 * 100000.0d);
                    if (z) {
                        rgVar2.qw((byte) 45);
                    }
                    rgVar2.qw((byte) 48);
                    rgVar2.qw((byte) 46);
                    rgVar2.qw((byte) ((i4 / 10000) + 48));
                    if (i4 % 10000 != 0) {
                        rgVar2.qw((byte) (((i4 / 1000) % 10) + 48));
                        if (i4 % 1000 != 0) {
                            rgVar2.qw((byte) (((i4 / 100) % 10) + 48));
                            if (i4 % 100 != 0) {
                                rgVar2.qw((byte) (((i4 / 10) % 10) + 48));
                                int i5 = i4 % 10;
                                if (i5 != 0) {
                                    rgVar2.qw((byte) (i5 + 48));
                                }
                            }
                        }
                    }
                    return null;
                } else {
                    int i6 = (int) (d3 * ((double) 100000));
                    StringBuilder sb = new StringBuilder();
                    if (z) {
                        sb.append('-');
                    }
                    sb.append("0.");
                    while (true) {
                        i3 /= 10;
                        if (i6 >= i3) {
                            break;
                        }
                        sb.append('0');
                    }
                    sb.append(i6);
                    int length = sb.length() - 1;
                    while (sb.charAt(length) == '0') {
                        length--;
                    }
                    sb.setLength(length + 1);
                    return sb.toString();
                }
            } else if (d2 <= 32767.0d) {
                int i7 = (int) ((d2 + 0.005d) * 100.0d);
                if (i7 < f9754yj) {
                    byte[][] bArr = f9753uk;
                    if (bArr[i7] != null) {
                        if (rgVar2 != null) {
                            if (z) {
                                rgVar2.qw((byte) 45);
                            }
                            rgVar2.pf(f9753uk[i7]);
                            return null;
                        }
                        String fe2 = a0.fe(bArr[i7], (String) null);
                        if (!z) {
                            return fe2;
                        }
                        return "-" + fe2;
                    }
                }
                if (rgVar2 != null) {
                    if (i7 < f9754yj) {
                        int i8 = i7 >= 1000000 ? 5 : i7 >= 100000 ? 4 : i7 >= 10000 ? 3 : i7 >= 1000 ? 2 : i7 >= 100 ? 1 : 0;
                        int i9 = i7 % 100;
                        if (i9 != 0) {
                            i8 += 2;
                        }
                        int i10 = i7 % 10;
                        if (i10 != 0) {
                            i8++;
                        }
                        byte[] bArr2 = new byte[i8];
                        if (i7 >= 1000000) {
                            bArr2[0] = f9751o[i7 / 1000000];
                            i2 = 1;
                        }
                        if (i7 >= 100000) {
                            bArr2[i2] = f9751o[(i7 / 100000) % 10];
                            i2++;
                        }
                        if (i7 >= 10000) {
                            bArr2[i2] = f9751o[(i7 / 10000) % 10];
                            i2++;
                        }
                        if (i7 >= 1000) {
                            bArr2[i2] = f9751o[(i7 / 1000) % 10];
                            i2++;
                        }
                        if (i7 >= 100) {
                            bArr2[i2] = f9751o[(i7 / 100) % 10];
                            i2++;
                        }
                        if (i9 != 0) {
                            int i11 = i2 + 1;
                            bArr2[i2] = 46;
                            int i12 = i11 + 1;
                            byte[] bArr3 = f9751o;
                            bArr2[i11] = bArr3[(i7 / 10) % 10];
                            if (i10 != 0) {
                                bArr2[i12] = bArr3[i10];
                            }
                        }
                        f9753uk[i7] = bArr2;
                    }
                    if (z) {
                        rgVar2.qw((byte) 45);
                    }
                    if (i7 >= 1000000) {
                        rgVar2.qw(f9751o[i7 / 1000000]);
                    }
                    if (i7 >= 100000) {
                        rgVar2.qw(f9751o[(i7 / 100000) % 10]);
                    }
                    if (i7 >= 10000) {
                        rgVar2.qw(f9751o[(i7 / 10000) % 10]);
                    }
                    if (i7 >= 1000) {
                        rgVar2.qw(f9751o[(i7 / 1000) % 10]);
                    }
                    if (i7 >= 100) {
                        rgVar2.qw(f9751o[(i7 / 100) % 10]);
                    }
                    if (i7 % 100 == 0) {
                        return null;
                    }
                    rgVar2.qw((byte) 46);
                    rgVar2.qw(f9751o[(i7 / 10) % 10]);
                    int i13 = i7 % 10;
                    if (i13 == 0) {
                        return null;
                    }
                    rgVar2.qw(f9751o[i13]);
                    return null;
                }
                StringBuilder sb2 = new StringBuilder();
                if (z) {
                    sb2.append('-');
                }
                if (i7 >= 1000000) {
                    sb2.append(f9750i[i7 / 1000000]);
                }
                if (i7 >= 100000) {
                    sb2.append(f9750i[(i7 / 100000) % 10]);
                }
                if (i7 >= 10000) {
                    sb2.append(f9750i[(i7 / 10000) % 10]);
                }
                if (i7 >= 1000) {
                    sb2.append(f9750i[(i7 / 1000) % 10]);
                }
                if (i7 >= 100) {
                    sb2.append(f9750i[(i7 / 100) % 10]);
                }
                if (i7 % 100 != 0) {
                    sb2.append('.');
                    sb2.append(f9750i[(i7 / 10) % 10]);
                    int i14 = i7 % 10;
                    if (i14 != 0) {
                        sb2.append(f9750i[i14]);
                    }
                }
                return sb2.toString();
            } else {
                long j = (long) (d2 + 0.5d);
                if (!z) {
                    return Long.toString(j);
                }
                return "-" + Long.toString(j);
            }
        } else if (rgVar2 == null) {
            return "0";
        } else {
            rgVar2.qw((byte) 48);
            return null;
        }
    }

    public void aaa(OutputStream outputStream) throws IOException {
        outputStream.write(this.f9756th, 0, this.f9755ad);
    }

    public void ddd(int i2) {
        if (i2 > this.f9755ad || i2 < 0) {
            throw new IndexOutOfBoundsException(qw.ad("the.new.size.must.be.positive.and.lt.eq.of.the.current.size", new Object[0]));
        }
        this.f9755ad = i2;
    }

    public rg de(char c) {
        ppp(c);
        return this;
    }

    public rg fe(double d) {
        uk(vvv(d, this));
        return this;
    }

    public byte[] mmm() {
        int i2 = this.f9755ad;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f9756th, 0, bArr, 0, i2);
        return bArr;
    }

    public int nn() {
        return this.f9755ad;
    }

    public rg pf(byte[] bArr) {
        m1118switch(bArr, 0, bArr.length);
        return this;
    }

    public rg ppp(int i2) {
        int i3 = this.f9755ad + 1;
        byte[] bArr = this.f9756th;
        if (i3 > bArr.length) {
            byte[] bArr2 = new byte[Math.max(bArr.length << 1, i3)];
            System.arraycopy(this.f9756th, 0, bArr2, 0, this.f9755ad);
            this.f9756th = bArr2;
        }
        this.f9756th[this.f9755ad] = (byte) i2;
        this.f9755ad = i3;
        return this;
    }

    public rg qw(byte b) {
        ppp(b);
        return this;
    }

    public rg rg(float f) {
        fe((double) f);
        return this;
    }

    /* renamed from: switch  reason: not valid java name */
    public rg m1118switch(byte[] bArr, int i2, int i3) {
        int i4;
        if (i2 >= 0 && i2 <= bArr.length && i3 >= 0 && (i4 = i2 + i3) <= bArr.length && i4 >= 0 && i3 != 0) {
            int i5 = this.f9755ad + i3;
            byte[] bArr2 = this.f9756th;
            if (i5 > bArr2.length) {
                byte[] bArr3 = new byte[Math.max(bArr2.length << 1, i5)];
                System.arraycopy(this.f9756th, 0, bArr3, 0, this.f9755ad);
                this.f9756th = bArr3;
            }
            System.arraycopy(bArr, i2, this.f9756th, this.f9755ad, i3);
            this.f9755ad = i5;
        }
        return this;
    }

    public rg th(int i2) {
        fe((double) i2);
        return this;
    }

    public String toString() {
        return new String(this.f9756th, 0, this.f9755ad);
    }

    public rg uk(String str) {
        if (str != null) {
            pf(fe.when.ad.rg.rg(str));
        }
        return this;
    }

    public rg when(byte b) {
        qw(f9751o[(b >> 4) & 15]);
        qw(f9751o[b & Ascii.SI]);
        return this;
    }

    public void write(int i2) throws IOException {
        qw((byte) i2);
    }

    public void xxx() {
        this.f9755ad = 0;
    }

    public rg yj(rg rgVar) {
        m1118switch(rgVar.f9756th, 0, rgVar.f9755ad);
        return this;
    }

    public rg(int i2) {
        this.f9756th = new byte[(i2 < 1 ? 128 : i2)];
    }

    public void write(byte[] bArr, int i2, int i3) {
        m1118switch(bArr, i2, i3);
    }
}
