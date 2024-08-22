package fe.fe.ddd.pf.qw.rg;

import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.security.AESUtil;
import com.baidu.apollon.heartbeat.a;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONException;
import org.json.JSONObject;

public class de {
    public static byte[] qw = {48, -126, 3, Ascii.CAN, 48, -126, 2, 0, 2, 9, 0, -46, 74, 92, -68, 76, 89, -37, 110, 48, 13, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 78, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 11, 48, 9, 6, 3, 85, 4, 8, 12, 2, 66, 74, 49, 11, 48, 9, 6, 3, 85, 4, 7, 12, 2, 66, 74, 49, 11, 48, 9, 6, 3, 85, 4, 10, 12, 2, 66, 68, 49, 11, 48, 9, 6, 3, 85, 4, 11, 12, 2, 66, 68, 49, 11, 48, 9, 6, 3, 85, 4, 3, 12, 2, 66, 68, 48, Ascii.RS, Ascii.ETB, 13, 50, 48, 49, 50, 49, 54, 48, 57, 53, 49, 49, 53, 90, Ascii.ETB, 13, 51, 48, 49, 50, 49, 52, 48, 57, 53, 49, 49, 53, 90, 48, 78, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 11, 48, 9, 6, 3, 85, 4, 8, 12, 2, 66, 74, 49, 11, 48, 9, 6, 3, 85, 4, 7, 12, 2, 66, 74, 49, 11, 48, 9, 6, 3, 85, 4, 10, 12, 2, 66, 68, 49, 11, 48, 9, 6, 3, 85, 4, 11, 12, 2, 66, 68, 49, 11, 48, 9, 6, 3, 85, 4, 3, 12, 2, 66, 68, 48, -126, 1, 34, 48, 13, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, Ascii.SI, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -47, -118, 50, 5, -99, -115, 57, 89, ExifInterface.MARKER_SOF11, 77, ExifInterface.MARKER_SOF5, 94, 37, -74, -91, 71, 77, -83, 6, 81, 124, Ascii.EM, 0, ExifInterface.MARKER_SOI, 37, 38, 92, 77, 92, 74, -48, 78, ExifInterface.MARKER_SOF13, 75, -81, -115, -105, -121, Ascii.RS, -18, -22, SignedBytes.MAX_POWER_OF_TWO, -76, -93, 58, 85, Ascii.CAN, 73, -26, 48, 55, 13, 6, -74, 76, 9, -16, 85, -94, 83, 86, -78, 90, -36, -42, -120, -36, 0, -75, 95, -98, 118, -26, 32, 55, ExifInterface.MARKER_SOS, 111, 10, ExifInterface.MARKER_SOF14, -105, -45, -28, 109, -108, ExifInterface.MARKER_SOS, 78, -18, ExifInterface.MARKER_SOI, -127, -47, 119, -99, 97, -103, -123, -88, 103, 7, -14, -120, ExifInterface.MARKER_EOI, Ascii.DLE, -104, -105, -46, -25, Ascii.GS, Byte.MAX_VALUE, -102, -104, -37, -70, -99, -17, 76, 35, -69, -76, -52, -22, 88, -33, -37, ExifInterface.MARKER_SOF1, -124, -73, 71, -9, -4, Ascii.RS, -126, -15, Byte.MIN_VALUE, 34, Ascii.NAK, 103, -118, SignedBytes.MAX_POWER_OF_TWO, 86, 45, -20, 95, -77, 79, -10, 44, 44, 96, 77, -69, 59, -89, -23, ExifInterface.MARKER_SOF13, -12, 90, 76, -48, 65, Ascii.DC2, 2, 38, -9, 40, Ascii.EM, 54, 9, Ascii.DC2, 50, 10, 39, -28, 99, -100, 74, Ascii.ETB, ExifInterface.MARKER_SOF1, 84, -95, -120, Ascii.FS, 73, -121, -94, -19, -22, ExifInterface.MARKER_APP1, Ascii.ETB, -108, -124, -85, ExifInterface.MARKER_SOF0, 60, -17, 122, -52, -47, -36, 61, 57, -111, Ascii.DC4, -82, 54, 43, 62, ExifInterface.MARKER_EOI, 55, 120, 58, 81, 65, ExifInterface.MARKER_SOF9, -80, -126, 12, 66, 32, 49, 123, ExifInterface.WEBP_VP8L_SIGNATURE, -47, Ascii.NAK, Byte.MIN_VALUE, -72, -56, -45, 92, -99, 3, -2, 85, 83, -112, -125, -107, 114, -11, 65, 53, 60, -122, -91, 121, -93, 85, SignedBytes.MAX_POWER_OF_TWO, -119, 41, ExifInterface.MARKER_SOF0, 119, ExifInterface.START_CODE, -104, 53, 52, 43, 2, 3, 1, 0, 1, 48, 13, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 5, 104, -81, 59, -92, ExifInterface.MARKER_SOF13, PublicSuffixDatabase.EXCEPTION_MARKER, -1, 98, 91, 105, 94, -16, 17, 54, -28, 74, 44, 122, Ascii.DLE, 9, ExifInterface.MARKER_SOS, 36, 105, -124, -29, 96, -101, -25, 5, -52, ExifInterface.MARKER_SOF11, -45, 65, 70, -115, -36, -105, 114, -93, -65, 68, Ascii.CAN, ExifInterface.MARKER_EOI, 71, 5, Ascii.SI, 88, 122, 12, 65, 40, -11, 51, -13, 50, 0, -66, 45, 123, Ascii.NAK, -1, -86, -116, -37, -46, 92, ExifInterface.MARKER_SOF10, -88, -122, 36, -88, -18, Ascii.DC4, -27, -4, -22, 9, -37, -127, Ascii.FS, 117, -120, 68, -29, ExifInterface.MARKER_SOF1, Byte.MAX_VALUE, -36, -19, 69, -67, -95, 115, Byte.MAX_VALUE, 78, Ascii.ESC, ExifInterface.START_CODE, -56, -126, 74, 61, 12, -106, -92, -113, 105, -56, ExifInterface.MARKER_SOF2, 80, ExifInterface.MARKER_SOF5, -107, 76, Ascii.DLE, -111, -24, Byte.MAX_VALUE, 65, 5, -33, ExifInterface.MARKER_SOF10, -118, -19, -42, -105, 48, 48, 39, 111, -105, -112, -13, 114, -73, Ascii.GS, 12, 113, -113, Ascii.US, 84, 69, 12, 43, 38, 101, -44, ExifInterface.START_CODE, -48, -81, Byte.MIN_VALUE, -96, -47, -91, -127, -83, -28, 100, ExifInterface.MARKER_EOI, -122, -78, 5, -8, 37, 19, 10, 37, 92, 56, -75, 77, 123, 110, -115, 122, 108, Byte.MIN_VALUE, -25, -114, 119, -93, 67, -9, 59, -42, ExifInterface.MARKER_SOF1, Ascii.DC2, -97, 120, 122, 68, 53, -14, 110, -79, -116, Byte.MAX_VALUE, -28, 72, 89, -34, -35, 37, 52, -42, ExifInterface.MARKER_SOF5, 10, -102, -36, 2, -110, 69, 4, -28, 119, Ascii.NAK, 75, 78, -35, 97, -91, -76, 14, 8, -10, 11, 58, -4, Ascii.ETB, ExifInterface.MARKER_SOF0, -117, -113, 36, -42, -26, -77, 116, 55, -126, ExifInterface.MARKER_SOF3, Ascii.CAN, -48, 40, -60, 35, 79, 82, ExifInterface.MARKER_SOS, -43, 44, 53, -44, -113, -12, 112, 17, 113, -86};

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f1552ad;
        public String qw;
    }

    public static String ad(byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, th());
            return new String(Base64.encode(instance.doFinal(bArr), 2), a.h);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static qw de(String str) {
        if (!TextUtils.isEmpty(str)) {
            byte[] rg2 = rg(128);
            byte[] fe2 = fe();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key", Base64.encodeToString(rg2, 2));
                jSONObject.put("iv", Base64.encodeToString(fe2, 2));
                String ad2 = ad(jSONObject.toString().getBytes());
                String qw2 = qw(str.getBytes(), rg2, fe2);
                qw qwVar = new qw();
                qwVar.qw = ad2;
                qwVar.f1552ad = qw2;
                return qwVar;
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static byte[] fe() {
        try {
            byte[] bArr = new byte[16];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
            return bArr;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String qw(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, AESUtil.ALGORITHM_NAME);
            Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return new String(Base64.encode(instance.doFinal(bArr), 2), a.h);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static byte[] rg(int i2) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(AESUtil.ALGORITHM_NAME);
            instance.init(i2);
            return instance.generateKey().getEncoded();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0033 A[SYNTHETIC, Splitter:B:21:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.PublicKey th() {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0026, all -> 0x0021 }
            byte[] r2 = qw     // Catch:{ Exception -> 0x0026, all -> 0x0021 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0026, all -> 0x0021 }
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch:{ Exception -> 0x001f }
            java.security.cert.Certificate r0 = r0.generateCertificate(r1)     // Catch:{ Exception -> 0x001f }
            java.security.PublicKey r0 = r0.getPublicKey()     // Catch:{ Exception -> 0x001f }
            r1.close()     // Catch:{ Exception -> 0x001a }
            goto L_0x001e
        L_0x001a:
            r1 = move-exception
            r1.printStackTrace()
        L_0x001e:
            return r0
        L_0x001f:
            r0 = move-exception
            goto L_0x002a
        L_0x0021:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0031
        L_0x0026:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x002a:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0030 }
            r2.<init>(r0)     // Catch:{ all -> 0x0030 }
            throw r2     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r0 = move-exception
        L_0x0031:
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ Exception -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.pf.qw.rg.de.th():java.security.PublicKey");
    }
}
