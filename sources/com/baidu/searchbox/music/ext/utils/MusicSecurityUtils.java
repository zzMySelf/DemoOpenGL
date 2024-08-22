package com.baidu.searchbox.music.ext.utils;

import android.util.Base64;
import com.baidu.android.common.security.MD5Util;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/music/ext/utils/MusicSecurityUtils;", "", "()V", "decrypt", "", "encryptData", "key", "ivParameter", "base64Flag", "", "decryptMusicUrl", "encryptUrl", "isValidUrl", "", "url", "verifyMd5", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicSecurityUtils.kt */
public final class MusicSecurityUtils {
    public static final MusicSecurityUtils INSTANCE = new MusicSecurityUtils();

    private MusicSecurityUtils() {
    }

    public static /* synthetic */ String decrypt$default(MusicSecurityUtils musicSecurityUtils, String str, String str2, String str3, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return musicSecurityUtils.decrypt(str, str2, str3, i2);
    }

    public final String decrypt(String encryptData, String key, String ivParameter, int base64Flag) {
        Intrinsics.checkNotNullParameter(encryptData, "encryptData");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(ivParameter, "ivParameter");
        try {
            byte[] encryptText = Base64.decode(encryptData, base64Flag);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bytes = ivParameter.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            IvParameterSpec iv = new IvParameterSpec(bytes);
            Cipher it = cipher;
            byte[] bytes2 = key.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            it.init(2, new SecretKeySpec(bytes2, "AES"), iv);
            byte[] doFinal = it.doFinal(encryptText);
            Intrinsics.checkNotNullExpressionValue(doFinal, "it.doFinal(encryptText)");
            return new String(doFinal, Charsets.UTF_8);
        } catch (Throwable th2) {
            return "";
        }
    }

    public final String decryptMusicUrl(String encryptUrl) {
        Intrinsics.checkNotNullParameter(encryptUrl, "encryptUrl");
        return decrypt(encryptUrl, MusicSecurityUtilsKt.PLAY_URL_KEY, MusicSecurityUtilsKt.PLAY_URL_IV, 2);
    }

    public final boolean isValidUrl(String url, String verifyMd5) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(verifyMd5, "verifyMd5");
        boolean z = true;
        if (!(url.length() == 0)) {
            if (verifyMd5.length() != 0) {
                z = false;
            }
            if (!z) {
                try {
                    byte[] bytes = url.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    return Intrinsics.areEqual((Object) MD5Util.toMd5(bytes, false), (Object) verifyMd5);
                } catch (Throwable th2) {
                    return false;
                }
            }
        }
        return false;
    }
}
