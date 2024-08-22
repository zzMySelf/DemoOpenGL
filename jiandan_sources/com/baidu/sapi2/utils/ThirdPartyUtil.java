package com.baidu.sapi2.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.HashMap;

public class ThirdPartyUtil implements NoProguard {
    public static final String TYPE_QQ = "qzone";
    public static final String TYPE_WEIBO = "tsina";
    public static final String TYPE_WEIXIN = "weixin";
    public static HashMap<String, Integer> dingdingAuthMap = new HashMap<>();
    public static HashMap<String, String> wxAuthCodeMap = new HashMap<>();

    public static boolean checkAliPayInstalled(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }

    public static Message getVerificationMsg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        if (str.equals(TYPE_QQ)) {
            message.what = SocialType.QQ_SSO.getType();
            message.obj = SocialType.QQ_SSO;
        } else if (str.equals(TYPE_WEIXIN)) {
            message.what = SocialType.WEIXIN.getType();
            message.obj = SocialType.WEIXIN;
        } else if (str.equals("tsina")) {
            message.what = SocialType.SINA_WEIBO_SSO.getType();
            message.obj = SocialType.SINA_WEIBO_SSO;
        }
        return message;
    }

    public static boolean isQQClientAvailable(Context context) {
        return SapiUtils.isAppInstalled(context, "com.tencent.mobileqq") || SapiUtils.isAppInstalled(context, "com.tencent.qqlite");
    }

    public static boolean isSinaInstalled(Context context) {
        return SapiUtils.isAppInstalled(context, "com.sina.weibo");
    }

    public static boolean isWeixinAvilible(Context context) {
        return SapiUtils.isAppInstalled(context, "com.tencent.mm");
    }
}
