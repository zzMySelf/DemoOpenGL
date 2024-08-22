package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Xml;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.callback.inner.ExecuteJsCallback;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.paysdk.datamodel.Bank;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;

public class SapiCoreUtil {
    public static final String CUSTOM_THEME_SCHEMA = "file:///android_asset/";
    public static final String TAG = "SapiCoreUtil";

    public static void executeJsCode(String str, String str2, String str3, Context context, final ExecuteJsCallback executeJsCallback) {
        try {
            final WebView webView = new WebView(context);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadDataWithBaseURL("", "<html><head><meta charset=\"utf-8\"><script> " + str + str2 + " </script></head></html>", SapiWebView.DATA_MIME_TYPE, "UTF-8", "");
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:moonshade(");
            sb.append(str3);
            sb.append(")");
            final String sb2 = sb.toString();
            webView.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    if (Build.VERSION.SDK_INT >= 19) {
                        webView.evaluateJavascript(sb2, new ValueCallback<String>() {
                            public void onReceiveValue(String str) {
                                executeJsCallback.jsExecuteCompleted(str);
                                webView.destroy();
                            }
                        });
                        return;
                    }
                    executeJsCallback.jsExecuteCompleted((String) null);
                    webView.destroy();
                }
            });
        } catch (Exception unused) {
            if (executeJsCallback != null) {
                executeJsCallback.jsExecuteCompleted((String) null);
            }
        }
    }

    public static InputStream getCacheInputStream(Context context, String str) {
        try {
            if (!str.startsWith("file:///android_asset/")) {
                return new FileInputStream(str);
            }
            return context.getAssets().open(str.replace("file:///android_asset/", ""));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getMatcher(String str, String str2) {
        Pattern compile = Pattern.compile(str);
        String str3 = "";
        if (TextUtils.isEmpty(str2)) {
            return str3;
        }
        Matcher matcher = compile.matcher(str2);
        while (matcher.find()) {
            str3 = matcher.group();
        }
        return str3;
    }

    public static SapiAccountResponse parseAccountXmlToResponse(String str, String str2) {
        SapiAccountResponse sapiAccountResponse;
        String matcher = getMatcher("<client>([\\S\\s]*?)</client>", str2);
        SapiAccountResponse sapiAccountResponse2 = null;
        if (TextUtils.isEmpty(matcher)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(matcher.getBytes()), "UTF-8");
            int eventType = newPullParser.getEventType();
            boolean z = false;
            while (true) {
                boolean z2 = true;
                if (eventType == 1) {
                    break;
                }
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("data")) {
                        if (sapiAccountResponse2 == null) {
                            sapiAccountResponse = new SapiAccountResponse();
                        }
                    } else if (sapiAccountResponse2 != null || !name.equalsIgnoreCase(WXLoginActivity.y)) {
                        if (sapiAccountResponse2 == null) {
                            if (name.equalsIgnoreCase("error_description")) {
                                sapiAccountResponse = new SapiAccountResponse();
                                sapiAccountResponse.errorMsg = newPullParser.nextText();
                            }
                        }
                        if (sapiAccountResponse2 != null) {
                            if (name.equalsIgnoreCase("errno")) {
                                sapiAccountResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("uname")) {
                                sapiAccountResponse2.username = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("errmsg")) {
                                sapiAccountResponse2.errorMsg = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bduss")) {
                                sapiAccountResponse2.bduss = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("ptoken")) {
                                sapiAccountResponse2.ptoken = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("stoken")) {
                                if (z) {
                                    String[] split = newPullParser.nextText().split(Bank.HOT_BANK_LETTER);
                                    if (split != null && split.length > 1) {
                                        sapiAccountResponse2.tplStokenMap.put(split[0], split[1]);
                                    }
                                } else {
                                    sapiAccountResponse2.stoken = newPullParser.nextText();
                                }
                            } else if (name.equalsIgnoreCase("displayname")) {
                                sapiAccountResponse2.displayname = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("uid")) {
                                sapiAccountResponse2.uid = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("authsid")) {
                                String nextText = newPullParser.nextText();
                                sapiAccountResponse2.authSid = nextText;
                                if (TextUtils.isEmpty(nextText)) {
                                    z2 = false;
                                }
                                sapiAccountResponse2.newReg = z2;
                            } else if (name.equalsIgnoreCase("stoken_list")) {
                                z = true;
                            } else if (name.equalsIgnoreCase("os_headurl")) {
                                sapiAccountResponse2.socialPortraitUrl = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_openid")) {
                                sapiAccountResponse2.openid = newPullParser.nextText();
                                String str3 = TAG;
                                Log.d(str3, "parseAccountXmlToResponse: openid" + sapiAccountResponse2.openid);
                            } else if (name.equalsIgnoreCase("os_name")) {
                                sapiAccountResponse2.socialNickname = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_type")) {
                                sapiAccountResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            } else if (name.equalsIgnoreCase("incomplete_user")) {
                                String nextText2 = newPullParser.nextText();
                                if ("0".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.NORMAL;
                                } else if ("1".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.INCOMPLETE_USER;
                                } else {
                                    sapiAccountResponse2.accountType = AccountType.UNKNOWN;
                                }
                            } else if (name.equalsIgnoreCase("actiontype")) {
                                sapiAccountResponse2.actionType = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_FROMTYPE)) {
                                sapiAccountResponse2.fromType = FromType.getFromType(newPullParser.nextText());
                            } else if (name.equals("livinguname")) {
                                sapiAccountResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                            } else if (IWalletLoginListener.KEY_LOGIN_TYPE.equals(name)) {
                                if ("oneKeyLogin".equals(newPullParser.nextText()) || "business_from_one_key_login".equals(str)) {
                                    String operatorType = new OneKeyLoginSdkCall().getOperatorType();
                                    if (OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC.equals(operatorType)) {
                                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CM.getName());
                                    } else if (OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC.equals(operatorType)) {
                                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CU.getName());
                                    } else if (OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC.equals(operatorType)) {
                                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CT.getName());
                                    }
                                }
                            } else if (name.equals("mobilephone")) {
                                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, newPullParser.nextText());
                            } else if (name.equals("app")) {
                                sapiAccountResponse2.app = newPullParser.nextText();
                            } else if (name.equals(SapiAccount.SAPI_ACCOUNT_EXTRA)) {
                                sapiAccountResponse2.extra = newPullParser.nextText();
                            }
                        }
                    } else {
                        sapiAccountResponse = new SapiAccountResponse();
                        try {
                            sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                        } catch (Throwable th2) {
                            th = th2;
                            sapiAccountResponse2 = sapiAccountResponse;
                        }
                    }
                    sapiAccountResponse2 = sapiAccountResponse;
                }
                eventType = newPullParser.next();
            }
        } catch (Throwable th3) {
            th = th3;
            Log.e(th);
            sapiAccountResponse2.errorCode = 0;
            return sapiAccountResponse2;
        }
        if (sapiAccountResponse2 != null && !TextUtils.isEmpty(sapiAccountResponse2.bduss) && sapiAccountResponse2.errorCode == -100) {
            sapiAccountResponse2.errorCode = 0;
        }
        return sapiAccountResponse2;
    }
}
