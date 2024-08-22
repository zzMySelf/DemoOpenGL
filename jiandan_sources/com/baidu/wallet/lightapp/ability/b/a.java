package com.baidu.wallet.lightapp.ability.b;

import android.content.Context;
import android.os.Bundle;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AesUtils;
import com.baidu.wallet.utils.RsaUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.interfaces.RSAPublicKey;

public class a {
    public RSAPublicKey a;

    /* renamed from: com.baidu.wallet.lightapp.ability.b.a$a  reason: collision with other inner class name */
    public static class C0153a {
        public static a a = new a();
    }

    public static a a() {
        return C0153a.a;
    }

    public static String b(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(DxmApplicationContextImpl.getApplicationContext(context).getAssets().open("na_public.key")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public a() {
    }

    public Bundle a(Context context, String str) {
        Bundle bundle = new Bundle();
        String aesKey = AesUtils.getAesKey();
        if (!(context == null || aesKey == null)) {
            try {
                String aesEncryptString = AesUtils.aesEncryptString(str, aesKey);
                bundle.putString("aesKey", RsaUtils.encrypt(a(context), aesKey));
                bundle.putString("aesContent", aesEncryptString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bundle;
    }

    private RSAPublicKey a(Context context) {
        if (this.a == null) {
            try {
                this.a = RsaUtils.loadPublicKeyByStr(b(context));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LogUtil.d("NA", "path mPublicKey = " + this.a);
        return this.a;
    }
}
