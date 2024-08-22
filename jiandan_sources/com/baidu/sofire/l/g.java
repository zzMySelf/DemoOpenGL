package com.baidu.sofire.l;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.a.a;
import com.baidu.sofire.jni.Asc;

public class g {
    public static Asc a = new Asc();
    public static byte[] b;
    public static byte[] c;

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        byte[] bArr3;
        if (bArr != null) {
            try {
                if (bArr.length > 0 && bArr2 != null) {
                    if (bArr2.length > 0) {
                        Asc asc = a;
                        if (asc != null) {
                            if (z) {
                                bArr3 = asc.dc(bArr2, bArr);
                            } else {
                                bArr3 = asc.dcn(bArr2, bArr);
                            }
                            if (bArr3 != null && bArr3.length > 0) {
                                return bArr3;
                            }
                        }
                        return new byte[0];
                    }
                }
            } catch (Throwable unused) {
                int i2 = a.a;
            }
        }
        return new byte[0];
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, boolean z) {
        byte[] bArr3;
        if (bArr != null) {
            try {
                if (bArr.length > 0 && bArr2 != null) {
                    if (bArr2.length > 0) {
                        Asc asc = a;
                        if (asc != null) {
                            if (z) {
                                bArr3 = asc.ac(bArr2, bArr);
                            } else {
                                bArr3 = asc.acn(bArr2, bArr);
                            }
                            if (bArr3 != null && bArr3.length > 0) {
                                return bArr3;
                            }
                        }
                        return new byte[0];
                    }
                }
            } catch (Throwable unused) {
                int i2 = a.a;
            }
        }
        return new byte[0];
    }

    public static synchronized byte[] a(int i2) {
        int i3 = i2;
        synchronized (g.class) {
            if (i3 == 16) {
                byte[] bArr = b;
                if (bArr == null || bArr.length != 16) {
                    b = Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 74, 107, 97, 87, 78, 49, 90, 71, 108, 104, 89, 103, 61, 61}, 0);
                }
                byte[] bArr2 = b;
                return bArr2;
            } else if (i3 != 24) {
                byte[] bArr3 = new byte[0];
                return bArr3;
            } else {
                byte[] bArr4 = c;
                if (bArr4 == null || bArr4.length != 24) {
                    c = new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 74, 107, 97, 87, 78, 49, 90, 71, 108, 104, 89, 103, 61, 61};
                }
                byte[] bArr5 = c;
                return bArr5;
            }
        }
    }

    public static String b(String str, int i2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return Base64.encodeToString(b(a(i2), str.getBytes("UTF-8"), true), 10);
        } catch (Throwable unused) {
            int i3 = a.a;
            return "";
        }
    }

    public static String a(String str, int i2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return new String(a(a(i2), Base64.decode(str, 10), true), "UTF-8");
        } catch (Throwable unused) {
            int i3 = a.a;
            return "";
        }
    }
}
