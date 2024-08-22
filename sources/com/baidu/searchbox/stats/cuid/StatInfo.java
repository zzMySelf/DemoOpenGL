package com.baidu.searchbox.stats.cuid;

import android.os.Build;
import android.util.Log;
import com.baidu.searchbox.aps.invoker.helper.PluginInvokeActivityHelper;
import com.baidu.searchbox.stats.cuid.security.AESUtil;
import com.baidu.searchbox.stats.cuid.security.Base64;
import com.tencent.open.SocialOperation;
import java.io.ByteArrayInputStream;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.List;
import javax.crypto.Cipher;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StatInfo {
    private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    public static final String TAG = "StatInfo";
    private static final int VER = 1;
    public String androidId;
    public final CuidInfo cuidInfo = new CuidInfo();
    public boolean hasSdcardReadPerm;
    public int sdkVersion = Build.VERSION.SDK_INT;
    public final TelephonyInfo telephonyInfo = new TelephonyInfo();
    public final UnionIDInfos unionIDInfos = new UnionIDInfos();

    public static class CuidInfo {
        public List<BuddyInfo> buddyInfos;
        public String cuid270Self;
        public String cuidSelf;
        public String sdcardV1;
        public String sdcardV2;
        public String systemSettingV1;
        public String systemSettingV2;

        public static class BuddyInfo {
            public static final int FLAG_EXIST = 1;
            public static final int FLAG_READBLE = 2;
            public String c270IscCuid;
            public String c270UpcCuid;
            public String cuid;
            public long cuidFileModifyTime = -1;
            public int flags;
            public String pkgName;
            public int priority;
        }
    }

    public static class TelephonyInfo {
        public String defDeviceId;
        public String defImei;
        public String[] deviceIds;
        public boolean hasPerm;
        public String[] imeis;
        public int phoneCount;
    }

    public UnionIDInfos getUnionIDInfos() {
        return this.unionIDInfos;
    }

    private JSONObject toBasicInfoJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("sdk", this.sdkVersion);
            json.put("sdperm", this.hasSdcardReadPerm);
            String str = this.androidId;
            if (str != null) {
                json.put("andid", str);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return json;
    }

    private JSONObject toCuidInfoJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("cuidver", 2);
            if (this.cuidInfo.cuidSelf != null) {
                json.put("mycuid", this.cuidInfo.cuidSelf);
            }
            if (this.cuidInfo.cuid270Self != null) {
                json.put("c270mycuid", this.cuidInfo.cuid270Self);
            }
            if (this.cuidInfo.buddyInfos != null && this.cuidInfo.buddyInfos.size() > 0) {
                JSONArray buddyInfosArray = new JSONArray();
                json.put("buddys", buddyInfosArray);
                for (CuidInfo.BuddyInfo buddy : this.cuidInfo.buddyInfos) {
                    JSONObject buddyJson = new JSONObject();
                    buddyJson.put("pkg", buddy.pkgName);
                    buddyJson.put("pri", buddy.priority);
                    if (buddy.cuid != null) {
                        buddyJson.put("cuid", buddy.cuid);
                    }
                    if (buddy.cuidFileModifyTime > 0) {
                        buddyJson.put("cuidmodTs", buddy.cuidFileModifyTime);
                    }
                    buddyJson.put(PluginInvokeActivityHelper.EXTRA_FLAG, buddy.flags);
                    if (buddy.c270UpcCuid != null) {
                        buddyJson.put("c270upc", buddy.c270UpcCuid);
                    }
                    if (buddy.c270IscCuid != null) {
                        buddyJson.put("c270isc", buddy.c270IscCuid);
                    }
                    buddyInfosArray.put(buddyJson);
                }
            }
            if (this.cuidInfo.systemSettingV2 != null) {
                json.put("sysv2", this.cuidInfo.systemSettingV2);
            }
            if (this.cuidInfo.systemSettingV1 != null) {
                json.put("sysv1", this.cuidInfo.systemSettingV1);
            }
            if (this.cuidInfo.sdcardV2 != null) {
                json.put("sdv2", this.cuidInfo.sdcardV2);
            }
            if (this.cuidInfo.sdcardV1 != null) {
                json.put("sdv1", this.cuidInfo.sdcardV1);
            }
            return json;
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private JSONObject toUnionIDInfoJson() {
        return this.unionIDInfos.toJson();
    }

    private String encryptByAES(String content, byte[] key, byte[] iv) {
        try {
            return Base64.encode(AESUtil.encrypt(iv, key, content.getBytes()), "utf-8");
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    private byte[] generateAesKey() {
        try {
            return AESUtil.generateAesKey(256);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private byte[] generateAesIv() {
        try {
            byte[] iv = new byte[16];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(iv);
            return iv;
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static String encryptByPublicKey(byte[] input, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            return Base64.encode(cipher.doFinal(input), "utf-8");
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    private PublicKey getPublicKey() {
        ByteArrayInputStream in = null;
        try {
            ByteArrayInputStream in2 = new ByteArrayInputStream(UBCCertStore.getCertBytes());
            PublicKey publicKey = CertificateFactory.getInstance("X.509").generateCertificate(in2).getPublicKey();
            try {
                in2.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return publicKey;
        } catch (Exception e3) {
            throw new IllegalStateException(e3);
        } catch (Throwable th2) {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            }
            throw th2;
        }
    }

    private static String byte2hex(byte[] b2) {
        if (b2 != null) {
            String hs = "";
            for (byte b3 : b2) {
                String stmp = Integer.toHexString(b3 & UByte.MAX_VALUE);
                if (stmp.length() == 1) {
                    hs = hs + "0" + stmp;
                } else {
                    hs = hs + stmp;
                }
            }
            return hs.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    public void dump() {
        Log.d(TAG, "basic " + toBasicInfoJson());
        Log.d(TAG, "cuid" + toCuidInfoJson());
        Log.d(TAG, SocialOperation.GAME_UNION_ID + toUnionIDInfoJson());
    }

    public void writeToUbcExtData(JSONObject extJson) {
        byte[] aesKey = generateAesKey();
        byte[] iv = generateAesIv();
        JSONObject keys = new JSONObject();
        try {
            keys.put("key", byte2hex(aesKey));
            keys.put("iv", byte2hex(iv));
            String encryptKey = encryptByPublicKey(keys.toString().getBytes(), getPublicKey());
            String basicInfo = encryptByAES(toBasicInfoJson().toString(), aesKey, iv);
            String cuidInfo2 = encryptByAES(toCuidInfoJson().toString(), aesKey, iv);
            String unionIDInfo = encryptByAES(toUnionIDInfoJson().toString(), aesKey, iv);
            try {
                extJson.put("ver", 1);
                extJson.put("keys", encryptKey);
                extJson.put("basic", basicInfo);
                extJson.put("cuid", cuidInfo2);
                extJson.put(SocialOperation.GAME_UNION_ID, unionIDInfo);
            } catch (JSONException e2) {
                throw new IllegalStateException(e2);
            }
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }
}
