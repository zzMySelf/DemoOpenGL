package com.cmic.sso.sdk.e;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.baidu.android.common.security.AESUtil;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.util.Calendar;
import javax.crypto.KeyGenerator;
import javax.security.auth.x500.X500Principal;

public class b {
    public static byte[] a;

    public static boolean a(Context context, boolean z) {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            if (instance.getKey("CMCC_SDK_V1", (char[]) null) != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            return a(context);
        }
        return false;
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] b = b(context);
        if (b != null) {
            return a.b(b, str, a);
        }
        a();
        return null;
    }

    public static String c() {
        return k.b("AES_IV", "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00fc, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized byte[] b(android.content.Context r9) {
        /*
            java.lang.Class<com.cmic.sso.sdk.e.b> r0 = com.cmic.sso.sdk.e.b.class
            monitor-enter(r0)
            r1 = 0
            java.lang.String r2 = "AndroidKeyStore"
            java.security.KeyStore r2 = java.security.KeyStore.getInstance(r2)     // Catch:{ Exception -> 0x0101 }
            r2.load(r1)     // Catch:{ Exception -> 0x0101 }
            r3 = 0
            boolean r9 = a((android.content.Context) r9, (boolean) r3)     // Catch:{ Exception -> 0x0101 }
            if (r9 != 0) goto L_0x0016
            monitor-exit(r0)
            return r1
        L_0x0016:
            java.lang.String r9 = b()     // Catch:{ Exception -> 0x0101 }
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0101 }
            r5 = 1
            if (r4 == 0) goto L_0x008f
            byte[] r9 = com.cmic.sso.sdk.e.q.a()     // Catch:{ Exception -> 0x0101 }
            byte[] r4 = com.cmic.sso.sdk.e.q.a()     // Catch:{ Exception -> 0x0101 }
            a = r4     // Catch:{ Exception -> 0x0101 }
            java.lang.String r4 = "CMCC_SDK_V1"
            java.security.Key r4 = r2.getKey(r4, r1)     // Catch:{ Exception -> 0x0101 }
            boolean r6 = r4 instanceof javax.crypto.SecretKey     // Catch:{ Exception -> 0x0101 }
            if (r6 == 0) goto L_0x004d
            java.lang.String r2 = "KeystoreUtil"
            java.lang.String r6 = "随机生成aes秘钥"
            com.cmic.sso.sdk.e.c.b(r2, r6)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r2 = "AES/CBC/PKCS7Padding"
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ Exception -> 0x0101 }
            javax.crypto.spec.IvParameterSpec r6 = new javax.crypto.spec.IvParameterSpec     // Catch:{ Exception -> 0x0101 }
            byte[] r7 = a     // Catch:{ Exception -> 0x0101 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0101 }
            r2.init(r5, r4, r6)     // Catch:{ Exception -> 0x0101 }
            goto L_0x006c
        L_0x004d:
            boolean r4 = r4 instanceof java.security.PrivateKey     // Catch:{ Exception -> 0x0101 }
            if (r4 == 0) goto L_0x008d
            java.lang.String r4 = "CMCC_SDK_V1"
            java.security.cert.Certificate r2 = r2.getCertificate(r4)     // Catch:{ Exception -> 0x0101 }
            java.security.PublicKey r2 = r2.getPublicKey()     // Catch:{ Exception -> 0x0101 }
            java.lang.String r4 = "RSA/ECB/OAEPWithSHA256AndMGF1Padding"
            javax.crypto.Cipher r4 = javax.crypto.Cipher.getInstance(r4)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r6 = "KeystoreUtil"
            java.lang.String r7 = "生成rsa密"
            com.cmic.sso.sdk.e.c.b(r6, r7)     // Catch:{ Exception -> 0x0101 }
            r4.init(r5, r2)     // Catch:{ Exception -> 0x0101 }
            r2 = r4
        L_0x006c:
            byte[] r2 = r2.doFinal(r9)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r3)     // Catch:{ Exception -> 0x0101 }
            byte[] r4 = a     // Catch:{ Exception -> 0x0101 }
            java.lang.String r3 = android.util.Base64.encodeToString(r4, r3)     // Catch:{ Exception -> 0x0101 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x0101 }
            r4.<init>()     // Catch:{ Exception -> 0x0101 }
            java.lang.String r5 = "AES_IV"
            r4.put(r5, r3)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r3 = "AES_KEY"
            r4.put(r3, r2)     // Catch:{ Exception -> 0x0101 }
            com.cmic.sso.sdk.e.k.a((java.util.Map<java.lang.String, java.lang.Object>) r4)     // Catch:{ Exception -> 0x0101 }
            goto L_0x00fb
        L_0x008d:
            monitor-exit(r0)
            return r1
        L_0x008f:
            java.lang.String r4 = c()     // Catch:{ Exception -> 0x0101 }
            byte[] r4 = android.util.Base64.decode(r4, r3)     // Catch:{ Exception -> 0x0101 }
            a = r4     // Catch:{ Exception -> 0x0101 }
            byte[] r9 = android.util.Base64.decode(r9, r3)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r4 = "CMCC_SDK_V1"
            java.security.Key r2 = r2.getKey(r4, r1)     // Catch:{ Exception -> 0x0101 }
            if (r2 != 0) goto L_0x00a7
            monitor-exit(r0)
            return r1
        L_0x00a7:
            boolean r4 = r2 instanceof javax.crypto.SecretKey     // Catch:{ Exception -> 0x0101 }
            r6 = 2
            if (r4 == 0) goto L_0x00c4
            java.lang.String r4 = "AES/CBC/PKCS7Padding"
            javax.crypto.Cipher r4 = javax.crypto.Cipher.getInstance(r4)     // Catch:{ Exception -> 0x0101 }
            javax.crypto.spec.IvParameterSpec r7 = new javax.crypto.spec.IvParameterSpec     // Catch:{ Exception -> 0x0101 }
            byte[] r8 = a     // Catch:{ Exception -> 0x0101 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0101 }
            r4.init(r6, r2, r7)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r2 = "KeystoreUtil"
            java.lang.String r6 = "使用aes"
            com.cmic.sso.sdk.e.c.b(r2, r6)     // Catch:{ Exception -> 0x0101 }
            goto L_0x00d8
        L_0x00c4:
            boolean r4 = r2 instanceof java.security.PrivateKey     // Catch:{ Exception -> 0x0101 }
            if (r4 == 0) goto L_0x00fd
            java.lang.String r4 = "RSA/ECB/OAEPWithSHA256AndMGF1Padding"
            javax.crypto.Cipher r4 = javax.crypto.Cipher.getInstance(r4)     // Catch:{ Exception -> 0x0101 }
            r4.init(r6, r2)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r2 = "KeystoreUtil"
            java.lang.String r6 = "使用rsa"
            com.cmic.sso.sdk.e.c.b(r2, r6)     // Catch:{ Exception -> 0x0101 }
        L_0x00d8:
            byte[] r9 = r4.doFinal(r9)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r2 = "KeystoreUtil"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0101 }
            r4.<init>()     // Catch:{ Exception -> 0x0101 }
            java.lang.String r6 = "是否解密出秘钥："
            r4.append(r6)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r3 = android.util.Base64.encodeToString(r9, r3)     // Catch:{ Exception -> 0x0101 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0101 }
            r3 = r3 ^ r5
            r4.append(r3)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0101 }
            com.cmic.sso.sdk.e.c.b(r2, r3)     // Catch:{ Exception -> 0x0101 }
        L_0x00fb:
            monitor-exit(r0)
            return r9
        L_0x00fd:
            monitor-exit(r0)
            return r1
        L_0x00ff:
            r9 = move-exception
            goto L_0x0107
        L_0x0101:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x00ff }
            monitor-exit(r0)
            return r1
        L_0x0107:
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.sso.sdk.e.b.b(android.content.Context):byte[]");
    }

    public static boolean a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            try {
                KeyGenerator instance = KeyGenerator.getInstance(AESUtil.ALGORITHM_NAME, "AndroidKeyStore");
                instance.init(new KeyGenParameterSpec.Builder("CMCC_SDK_V1", 3).setDigests(new String[]{"SHA-256", "SHA-512"}).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setRandomizedEncryptionRequired(false).setKeySize(256).build());
                Thread.sleep(1000);
                instance.generateKey();
                return true;
            } catch (Exception e) {
                c.a("KeystoreUtil", e.getMessage());
                return false;
            }
        } else {
            Calendar instance2 = Calendar.getInstance();
            Calendar instance3 = Calendar.getInstance();
            instance3.add(1, 30);
            if (i2 >= 18) {
                try {
                    KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context).setAlias("CMCC_SDK_V1").setSubject(new X500Principal("CN=CMCC_SDK_V1")).setSerialNumber(BigInteger.TEN).setStartDate(instance2.getTime()).setEndDate(instance3.getTime()).build();
                    KeyPairGenerator instance4 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance4.initialize(build);
                    Thread.sleep(1000);
                    instance4.generateKeyPair();
                    return true;
                } catch (Exception e2) {
                    c.a("KeystoreUtil", e2.getMessage());
                }
            }
            return false;
        }
    }

    public static String a(Context context, String str) {
        a();
        byte[] b = b(context);
        if (b != null) {
            return a.a(b, str, a);
        }
        a();
        return null;
    }

    public static void a() {
        k.a("AES_KEY");
    }

    public static String b() {
        return k.b("AES_KEY", "");
    }
}
