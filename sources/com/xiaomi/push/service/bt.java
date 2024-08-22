package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.lockscreen.helper.SwipeGestureHelper;
import com.baidu.searchbox.net.TurboNetContext;
import com.baidu.swan.apps.util.SwanAppEncryptUtils;
import com.baidu.talos.core.archivers.tar.TarConstants;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class bt {

    /* renamed from: a  reason: collision with root package name */
    private static RSAPublicKey f7636a;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f1019a;

    static {
        byte[] bArr = {TarConstants.LF_NORMAL, -127, -97, TarConstants.LF_NORMAL, 13, 6, 9, 42, TurboNetContext.OBSFUCATE_KEY, 72, TurboNetContext.OBSFUCATE_KEY, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, TarConstants.LF_NORMAL, -127, -119, 2, -127, -127, 0, -109, -38, -114, 26, -72, 78, 16, 70, -90, 113, -30, 36, 85, -3, -43, 123, 61, -98, 4, -16, 67, 19, -90, -73, -5, -89, 36, 44, -27, 59, -123, 72, -73, -48, TarConstants.LF_LINK, 13, 16, TarConstants.LF_SYMLINK, -27, -82, 18, -28, 84, 0, -41, 16, 69, -39, 7, 82, 56, 79, -37, 40, 85, 107, SwipeGestureHelper.BOTTOM_SWIPE, 33, 123, -34, -49, 111, -11, TarConstants.LF_LINK, 28, 117, -74, SwipeGestureHelper.RIGHT_SWIPE, TurboNetContext.OBSFUCATE_KEY, -29, -84, 82, 22, TurboNetContext.OBSFUCATE_KEY, 42, -40, -79, 18, -116, -42, 101, -70, 44, Constants.GZIP_CAST_TYPE, 62, -49, -3, -22, -2, 66, 90, -116, -75, -99, 34, 121, 69, 10, -81, -57, 89, -23, -36, -60, -81, 67, -114, 10, 79, 100, 29, 47, -24, 110, -66, -7, 87, 16, -125, -91, -43, -103, 67, -20, 41, 117, -37, -11, 2, 3, 1, 0, 1};
        f1019a = bArr;
        try {
            f7636a = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Throwable th2) {
            b.d("rsa key pair init failure!!!");
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance(SwanAppEncryptUtils.ALGORITHM_RSA_ECB_PKCS1_PADDING);
            instance.init(1, f7636a);
            return Base64.encodeToString(a(instance, 1, str.getBytes("UTF-8"), f7636a.getModulus().bitLength()), 2);
        } catch (Throwable th2) {
            return null;
        }
    }

    private static byte[] a(Cipher cipher, int i2, byte[] bArr, int i3) {
        int i4;
        byte[] bArr2;
        if (cipher == null || bArr == null) {
            return null;
        }
        if (i2 == 2) {
            i4 = i3 / 8;
        } else {
            i4 = (i3 / 8) - 11;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i5 = 0;
            int i6 = 0;
            while (bArr.length > i5) {
                if (bArr.length - i5 > i4) {
                    bArr2 = cipher.doFinal(bArr, i5, i4);
                } else {
                    bArr2 = cipher.doFinal(bArr, i5, bArr.length - i5);
                }
                byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                i6++;
                i5 = i6 * i4;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
