package org.apache.commons.codec.digest4util;

import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.base.Charsets;

public class Sha2Crypt {
    public static final int ROUNDS_DEFAULT = 5000;
    public static final int ROUNDS_MAX = 999999999;
    public static final int ROUNDS_MIN = 1000;
    public static final String ROUNDS_PREFIX = "rounds=";
    public static final Pattern SALT_PATTERN = Pattern.compile("^\\$([56])\\$(rounds=(\\d+)\\$)?([\\.\\/a-zA-Z0-9]{1,16}).*");
    public static final int SHA256_BLOCKSIZE = 32;
    public static final String SHA256_PREFIX = "$5$";
    public static final int SHA512_BLOCKSIZE = 64;
    public static final String SHA512_PREFIX = "$6$";

    public static String sha256Crypt(byte[] bArr) {
        return sha256Crypt(bArr, (String) null);
    }

    public static String sha2Crypt(byte[] bArr, String str, String str2, int i2, String str3) {
        boolean z;
        int i3;
        byte b;
        byte[] bArr2;
        int i4;
        byte[] bArr3 = bArr;
        String str4 = str;
        int i5 = i2;
        int length = bArr3.length;
        if (str4 != null) {
            Matcher matcher = SALT_PATTERN.matcher(str4);
            if (matcher.find()) {
                if (matcher.group(3) != null) {
                    i3 = Math.max(1000, Math.min(ROUNDS_MAX, Integer.parseInt(matcher.group(3))));
                    z = true;
                } else {
                    i3 = 5000;
                    z = false;
                }
                String group = matcher.group(4);
                byte[] bytes = group.getBytes(Charsets.UTF_8);
                int length2 = bytes.length;
                MessageDigest digest = DigestUtils.getDigest(str3);
                digest.update(bArr3);
                digest.update(bytes);
                MessageDigest digest2 = DigestUtils.getDigest(str3);
                digest2.update(bArr3);
                digest2.update(bytes);
                digest2.update(bArr3);
                byte[] digest3 = digest2.digest();
                int length3 = bArr3.length;
                while (length3 > i5) {
                    digest.update(digest3, 0, i5);
                    length3 -= i5;
                }
                digest.update(digest3, 0, length3);
                for (int length4 = bArr3.length; length4 > 0; length4 >>= 1) {
                    if ((length4 & 1) != 0) {
                        digest.update(digest3, 0, i5);
                    } else {
                        digest.update(bArr3);
                    }
                }
                byte[] digest4 = digest.digest();
                MessageDigest digest5 = DigestUtils.getDigest(str3);
                for (int i6 = 1; i6 <= length; i6++) {
                    digest5.update(bArr3);
                }
                byte[] digest6 = digest5.digest();
                byte[] bArr4 = new byte[length];
                int i7 = 0;
                while (i7 < length - i5) {
                    System.arraycopy(digest6, 0, bArr4, i7, i5);
                    i7 += i5;
                }
                System.arraycopy(digest6, 0, bArr4, i7, length - i7);
                MessageDigest digest7 = DigestUtils.getDigest(str3);
                for (int i8 = 1; i8 <= (digest4[0] & 255) + Ascii.DLE; i8++) {
                    digest7.update(bytes);
                }
                byte[] digest8 = digest7.digest();
                byte[] bArr5 = new byte[length2];
                MessageDigest messageDigest = digest;
                int i9 = 0;
                while (i9 < length2 - i5) {
                    System.arraycopy(digest8, 0, bArr5, i9, i5);
                    i9 += i5;
                }
                System.arraycopy(digest8, 0, bArr5, i9, length2 - i9);
                MessageDigest messageDigest2 = messageDigest;
                int i10 = 0;
                while (i10 <= i3 - 1) {
                    messageDigest2 = DigestUtils.getDigest(str3);
                    int i11 = i10 & 1;
                    if (i11 != 0) {
                        bArr2 = bytes;
                        i4 = 0;
                        messageDigest2.update(bArr4, 0, length);
                    } else {
                        bArr2 = bytes;
                        i4 = 0;
                        messageDigest2.update(digest4, 0, i5);
                    }
                    if (i10 % 3 != 0) {
                        messageDigest2.update(bArr5, i4, length2);
                    }
                    if (i10 % 7 != 0) {
                        messageDigest2.update(bArr4, i4, length);
                    }
                    if (i11 != 0) {
                        messageDigest2.update(digest4, i4, i5);
                    } else {
                        messageDigest2.update(bArr4, i4, length);
                    }
                    digest4 = messageDigest2.digest();
                    i10++;
                    bytes = bArr2;
                }
                byte[] bArr6 = bytes;
                StringBuilder sb = new StringBuilder(str2);
                if (z) {
                    sb.append(ROUNDS_PREFIX);
                    sb.append(i3);
                    sb.append("$");
                }
                sb.append(group);
                sb.append("$");
                if (i5 == 32) {
                    B64.b64from24bit(digest4[0], digest4[10], digest4[20], 4, sb);
                    B64.b64from24bit(digest4[21], digest4[1], digest4[11], 4, sb);
                    B64.b64from24bit(digest4[12], digest4[22], digest4[2], 4, sb);
                    B64.b64from24bit(digest4[3], digest4[13], digest4[23], 4, sb);
                    B64.b64from24bit(digest4[24], digest4[4], digest4[14], 4, sb);
                    B64.b64from24bit(digest4[15], digest4[25], digest4[5], 4, sb);
                    B64.b64from24bit(digest4[6], digest4[16], digest4[26], 4, sb);
                    B64.b64from24bit(digest4[27], digest4[7], digest4[17], 4, sb);
                    B64.b64from24bit(digest4[18], digest4[28], digest4[8], 4, sb);
                    B64.b64from24bit(digest4[9], digest4[19], digest4[29], 4, sb);
                    B64.b64from24bit((byte) 0, digest4[31], digest4[30], 3, sb);
                    b = 0;
                } else {
                    B64.b64from24bit(digest4[0], digest4[21], digest4[42], 4, sb);
                    B64.b64from24bit(digest4[22], digest4[43], digest4[1], 4, sb);
                    B64.b64from24bit(digest4[44], digest4[2], digest4[23], 4, sb);
                    B64.b64from24bit(digest4[3], digest4[24], digest4[45], 4, sb);
                    B64.b64from24bit(digest4[25], digest4[46], digest4[4], 4, sb);
                    B64.b64from24bit(digest4[47], digest4[5], digest4[26], 4, sb);
                    B64.b64from24bit(digest4[6], digest4[27], digest4[48], 4, sb);
                    B64.b64from24bit(digest4[28], digest4[49], digest4[7], 4, sb);
                    B64.b64from24bit(digest4[50], digest4[8], digest4[29], 4, sb);
                    B64.b64from24bit(digest4[9], digest4[30], digest4[51], 4, sb);
                    B64.b64from24bit(digest4[31], digest4[52], digest4[10], 4, sb);
                    B64.b64from24bit(digest4[53], digest4[11], digest4[32], 4, sb);
                    B64.b64from24bit(digest4[12], digest4[33], digest4[54], 4, sb);
                    B64.b64from24bit(digest4[34], digest4[55], digest4[13], 4, sb);
                    B64.b64from24bit(digest4[56], digest4[14], digest4[35], 4, sb);
                    B64.b64from24bit(digest4[15], digest4[36], digest4[57], 4, sb);
                    B64.b64from24bit(digest4[37], digest4[58], digest4[16], 4, sb);
                    B64.b64from24bit(digest4[59], digest4[17], digest4[38], 4, sb);
                    B64.b64from24bit(digest4[18], digest4[39], digest4[60], 4, sb);
                    B64.b64from24bit(digest4[40], digest4[61], digest4[19], 4, sb);
                    B64.b64from24bit(digest4[62], digest4[20], digest4[41], 4, sb);
                    b = 0;
                    B64.b64from24bit((byte) 0, (byte) 0, digest4[63], 2, sb);
                }
                Arrays.fill(digest8, b);
                Arrays.fill(bArr4, b);
                Arrays.fill(bArr5, b);
                messageDigest2.reset();
                digest7.reset();
                Arrays.fill(bArr3, b);
                Arrays.fill(bArr6, b);
                return sb.toString();
            }
            throw new IllegalArgumentException("Invalid salt value: " + str4);
        }
        throw new IllegalArgumentException("Salt must not be null");
    }

    public static String sha512Crypt(byte[] bArr) {
        return sha512Crypt(bArr, (String) null);
    }

    public static String sha256Crypt(byte[] bArr, String str) {
        if (str == null) {
            str = SHA256_PREFIX + B64.getRandomSalt(8);
        }
        return sha2Crypt(bArr, str, SHA256_PREFIX, 32, "SHA-256");
    }

    public static String sha512Crypt(byte[] bArr, String str) {
        if (str == null) {
            str = SHA512_PREFIX + B64.getRandomSalt(8);
        }
        return sha2Crypt(bArr, str, SHA512_PREFIX, 64, "SHA-512");
    }
}
