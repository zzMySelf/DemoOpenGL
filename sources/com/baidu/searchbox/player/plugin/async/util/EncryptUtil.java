package com.baidu.searchbox.player.plugin.async.util;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.player.plugin.depend.MPDDependManager;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.schemedispatch.SchemeUtility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/player/plugin/async/util/EncryptUtil;", "", "()V", "TAG", "", "encrypt", "text", "key", "ivParameter", "getAntCt", "word", "mpd-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EncryptUtil.kt */
public final class EncryptUtil {
    public static final EncryptUtil INSTANCE = new EncryptUtil();
    private static final String TAG = "EncryptUtil";

    private EncryptUtil() {
    }

    public final String getAntCt(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        StringBuilder append = new StringBuilder().append(SchemeUtility.URL_HOST_TARGET_TYPE).append(TimestampUtil.INSTANCE.getCalibratedTime()).append("&w=");
        MPDDependManager mPDDependManager = MPDDependManager.Companion.get();
        byte[] bytes = word.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String text = append.append(mPDDependManager.toMd5(bytes, false)).toString();
        BdVideoLog.d(TAG, "text=" + text);
        String text2 = encrypt(text, "playserver_baidu", "baidu_playserver");
        BdVideoLog.d(TAG, "encrypt text=" + text2);
        if (TextUtils.isEmpty(text2)) {
            return "";
        }
        try {
            String antCt = URLEncoder.encode(text2, Charsets.UTF_8.name());
            Intrinsics.checkNotNullExpressionValue(antCt, "encode(text, UTF_8.name())");
            return antCt;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final String encrypt(String text, String key, String ivParameter) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(ivParameter, "ivParameter");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            Intrinsics.checkNotNullExpressionValue(cipher, "getInstance(\"AES/CBC/PKCS5Padding\")");
            byte[] raw = key.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(raw, "this as java.lang.String).getBytes(charset)");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            byte[] bytes = ivParameter.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            cipher.init(1, skeySpec, new IvParameterSpec(bytes));
            Intrinsics.checkNotNull(text);
            Charset forName = Charset.forName("utf-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes2 = text.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            byte[] encrypted = cipher.doFinal(bytes2);
            Intrinsics.checkNotNullExpressionValue(encrypted, "cipher.doFinal(text!!.to…eArray(charset(\"utf-8\")))");
            return Base64.encodeToString(encrypted, 2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
