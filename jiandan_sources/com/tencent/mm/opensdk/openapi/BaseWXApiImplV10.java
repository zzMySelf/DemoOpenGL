package com.tencent.mm.opensdk.openapi;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.sapi2.SapiAccount;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.google.android.gms.common.Scopes;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom;
import com.tencent.mm.opensdk.modelbiz.HandleScanResult;
import com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage;
import com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg;
import com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo;
import com.tencent.mm.opensdk.modelbiz.WXChannelJumpMiniProgramInfo;
import com.tencent.mm.opensdk.modelbiz.WXChannelJumpUrlInfo;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenFeed;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenLive;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenProfile;
import com.tencent.mm.opensdk.modelbiz.WXChannelShareVideo;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.mm.opensdk.modelbiz.WXOpenCustomerServiceChat;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgramEnvironment;
import com.tencent.mm.opensdk.modelbiz.WXQRCodePay;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.SendTdiAuth;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class BaseWXApiImplV10 implements IWXAPI {
    public static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    public static String wxappPayEntryClassname;
    public String appId;
    public boolean checkSignature = false;
    public Context context;
    public boolean detached = false;
    public int launchMode = 2;
    public int wxSdkVersion;

    public BaseWXApiImplV10(Context context2, String str, boolean z, int i2) {
        Log.d(TAG, "<init>, appId = " + str + ", checkSignature = " + z + ", launchMode = " + i2);
        this.context = context2;
        this.appId = str;
        this.checkSignature = z;
        this.launchMode = i2;
        b.a = context2.getApplicationContext();
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        String str;
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            str = "checkSumConsistent fail, invalid arguments";
        } else if (bArr.length != bArr2.length) {
            str = "checkSumConsistent fail, length is different";
        } else {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        Log.e(TAG, str);
        return false;
    }

    private boolean createChatroom(Context context2, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), (String[]) null, (String) null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_create_chatroom_group_id", ""), bundle.getString("_wxapi_create_chatroom_chatroom_name", ""), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_create_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private String finderShareVideoJumpInfoToString(IWXChannelJumpInfo iWXChannelJumpInfo) {
        String str;
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jumpType", iWXChannelJumpInfo.type());
            if (iWXChannelJumpInfo instanceof WXChannelBaseJumpInfo) {
                jSONObject.put("wording", ((WXChannelBaseJumpInfo) iWXChannelJumpInfo).wording);
                jSONObject.put(SapiAccount.SAPI_ACCOUNT_EXTRA, ((WXChannelBaseJumpInfo) iWXChannelJumpInfo).extra);
                if (iWXChannelJumpInfo instanceof WXChannelJumpMiniProgramInfo) {
                    jSONObject.put("username", ((WXChannelJumpMiniProgramInfo) iWXChannelJumpInfo).username);
                    str = ((WXChannelJumpMiniProgramInfo) iWXChannelJumpInfo).path;
                    str2 = "path";
                } else if (iWXChannelJumpInfo instanceof WXChannelJumpUrlInfo) {
                    str = ((WXChannelJumpUrlInfo) iWXChannelJumpInfo).url;
                    str2 = "url";
                }
                jSONObject.put(str2, str);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private String getTokenFromWX(Context context2) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), (String[]) null, (String) null, new String[]{this.appId, "638058496"}, (String) null);
        if (query == null || !query.moveToFirst()) {
            Log.e(TAG, "getTokenFromWX , token is null , if your app targetSdkVersion >= 30, include 'com.tencent.mm' in a set of <package> elements inside the <queries> element");
            return null;
        }
        String string = query.getString(0);
        Log.i(TAG, "getTokenFromWX token is " + string);
        query.close();
        return string;
    }

    private boolean handleWxInternalRespType(String str, IWXAPIEventHandler iWXAPIEventHandler) {
        Log.i(TAG, "handleWxInternalRespType, extInfo = " + str);
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("wx_internal_resptype");
            Log.i(TAG, "handleWxInternalRespType, respType = " + queryParameter);
            if (b.b(queryParameter)) {
                Log.e(TAG, "handleWxInternalRespType fail, respType is null");
                return false;
            } else if (queryParameter.equals("subscribemessage")) {
                SubscribeMessage.Resp resp = new SubscribeMessage.Resp();
                String queryParameter2 = parse.getQueryParameter("ret");
                if (queryParameter2 != null && queryParameter2.length() > 0) {
                    resp.errCode = b.a(queryParameter2, 0);
                }
                resp.openId = parse.getQueryParameter(Scopes.OPEN_ID);
                resp.templateID = parse.getQueryParameter("template_id");
                resp.scene = b.a(parse.getQueryParameter("scene"), 0);
                resp.action = parse.getQueryParameter("action");
                resp.reserved = parse.getQueryParameter("reserved");
                iWXAPIEventHandler.onResp(resp);
                return true;
            } else if (queryParameter.contains("invoice_auth_insert")) {
                WXInvoiceAuthInsert.Resp resp2 = new WXInvoiceAuthInsert.Resp();
                String queryParameter3 = parse.getQueryParameter("ret");
                if (queryParameter3 != null && queryParameter3.length() > 0) {
                    resp2.errCode = b.a(queryParameter3, 0);
                }
                resp2.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp2);
                return true;
            } else if (queryParameter.contains("payinsurance")) {
                WXPayInsurance.Resp resp3 = new WXPayInsurance.Resp();
                String queryParameter4 = parse.getQueryParameter("ret");
                if (queryParameter4 != null && queryParameter4.length() > 0) {
                    resp3.errCode = b.a(queryParameter4, 0);
                }
                resp3.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp3);
                return true;
            } else if (queryParameter.contains("nontaxpay")) {
                WXNontaxPay.Resp resp4 = new WXNontaxPay.Resp();
                String queryParameter5 = parse.getQueryParameter("ret");
                if (queryParameter5 != null && queryParameter5.length() > 0) {
                    resp4.errCode = b.a(queryParameter5, 0);
                }
                resp4.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp4);
                return true;
            } else {
                if (!"subscribeminiprogrammsg".equals(queryParameter)) {
                    if (!BannerBaseItemInfo.TYPE_LOGIN.equals(queryParameter)) {
                        Log.e(TAG, "this open sdk version not support the request type");
                        return false;
                    }
                }
                SubscribeMiniProgramMsg.Resp resp5 = new SubscribeMiniProgramMsg.Resp();
                String queryParameter6 = parse.getQueryParameter("ret");
                if (queryParameter6 != null && queryParameter6.length() > 0) {
                    resp5.errCode = b.a(queryParameter6, 0);
                }
                resp5.openId = parse.getQueryParameter(Scopes.OPEN_ID);
                resp5.unionId = parse.getQueryParameter("unionid");
                resp5.nickname = parse.getQueryParameter("nickname");
                resp5.errStr = parse.getQueryParameter("errmsg");
                iWXAPIEventHandler.onResp(resp5);
                return true;
            }
        } catch (Exception e) {
            Log.e(TAG, "handleWxInternalRespType fail, ex = " + e.getMessage());
        }
    }

    private boolean joinChatroom(Context context2, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), (String[]) null, (String) null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_join_chatroom_group_id", ""), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_join_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private void launchWXIfNeed() {
        if (Build.VERSION.SDK_INT < 29 || this.launchMode != 2) {
            openWXApp();
        } else {
            launchWXUsingPendingIntent();
        }
    }

    private void launchWXUsingPendingIntent() {
        if (this.detached) {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        } else if (!isWXAppInstalled()) {
            Log.e(TAG, "openWXApp failed, not installed or signature check failed");
        } else {
            try {
                Log.i(TAG, "launchWXUsingPendingIntent");
                PendingIntent.getActivity(this.context, 1, this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"), 134217728).send(this.context, 2, (Intent) null, new PendingIntent.OnFinished() {
                    public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
                        Log.d(BaseWXApiImplV10.TAG, "onSendFinished resultCode: " + i2 + ", resultData: " + str);
                    }
                }, (Handler) null);
            } catch (Exception e) {
                Log.e(TAG, "launchWXUsingPendingIntent pendingIntent send failed: " + e.getMessage());
                openWXApp();
            }
        }
    }

    private boolean sendAddCardToWX(Context context2, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), (String[]) null, (String) null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendChooseCardFromWX(Context context2, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), (String[]) null, (String) null, new String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendFinderOpenFeed(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        Log.i(TAG, "sendFinderOpenFeed");
        WXChannelOpenFeed.Req req = (WXChannelOpenFeed.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenFeed"), (String[]) null, (String) null, new String[]{this.appId, req.feedID, req.nonceID, String.valueOf(req.notGetReleatedList)}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendFinderOpenLive(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        Log.i(TAG, "sendFinderOpenLive");
        WXChannelOpenLive.Req req = (WXChannelOpenLive.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenLive"), (String[]) null, (String) null, new String[]{this.appId, req.feedID, req.nonceID}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendFinderOpenProfile(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        Log.i(TAG, "sendFinderOpenProfile");
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenProfile"), (String[]) null, (String) null, new String[]{this.appId, ((WXChannelOpenProfile.Req) baseReq).userName}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendFinderShareVideo(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        Log.i(TAG, "sendFinderShareVideo");
        WXChannelShareVideo.Req req = (WXChannelShareVideo.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderShareVideo"), (String[]) null, (String) null, new String[]{this.appId, req.videoPath, "", "", req.extData, finderShareVideoJumpInfoToString(req.jumpInfo)}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendHandleScanResult(Context context2, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), (String[]) null, (String) null, new String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendInvoiceAuthInsert(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), (String[]) null, (String) null, new String[]{this.appId, String.valueOf(2), URLEncoder.encode(String.format("url=%s", new Object[]{URLEncoder.encode(((WXInvoiceAuthInsert.Req) baseReq).url)}))}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToOfflinePayReq(Context context2, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), (String[]) null, (String) null, new String[]{this.appId}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendLaunchWXMiniprogram(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        WXLaunchMiniProgram.Req req = (WXLaunchMiniProgram.Req) baseReq;
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
        Cursor query = contentResolver.query(parse, (String[]) null, (String) null, new String[]{this.appId, req.userName, req.path, req.miniprogramType + "", req.extData}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendLaunchWXMiniprogramWithToken(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogramWithToken"), (String[]) null, (String) null, new String[]{this.appId, ((WXLaunchMiniProgramWithToken.Req) baseReq).token}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendNonTaxPay(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), (String[]) null, (String) null, new String[]{this.appId, String.valueOf(3), URLEncoder.encode(String.format("url=%s", new Object[]{URLEncoder.encode(((WXNontaxPay.Req) baseReq).url)}))}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(Context context2, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), (String[]) null, (String) null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusinessView(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        WXOpenBusinessView.Req req = (WXOpenBusinessView.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), (String[]) null, (String) null, new String[]{this.appId, req.businessType, req.query, req.extInfo, req.transaction, req.openId}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusinessWebview(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        WXOpenBusinessWebview.Req req = (WXOpenBusinessWebview.Req) baseReq;
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
        HashMap<String, String> hashMap = req.queryInfo;
        String jSONObject = (hashMap == null || hashMap.size() <= 0) ? "" : new JSONObject(req.queryInfo).toString();
        Cursor query = contentResolver.query(parse, (String[]) null, (String) null, new String[]{this.appId, req.businessType + "", jSONObject}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenCustomerServiceChat(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        WXOpenCustomerServiceChat.Req req = (WXOpenCustomerServiceChat.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openCustomerServiceChat"), (String[]) null, (String) null, new String[]{this.appId, req.corpId, req.url}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenRankListReq(Context context2, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), (String[]) null, (String) null, new String[0], (String) null);
        if (query == null) {
            return true;
        }
        query.close();
        return true;
    }

    private boolean sendOpenWebview(Context context2, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), (String[]) null, (String) null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayInSurance(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), (String[]) null, (String) null, new String[]{this.appId, String.valueOf(4), URLEncoder.encode(String.format("url=%s", new Object[]{URLEncoder.encode(((WXPayInsurance.Req) baseReq).url)}))}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context2, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context2).getString("_wxapp_pay_entry_classname_", (String) null);
            Log.d(TAG, "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                try {
                    wxappPayEntryClassname = context2.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", (String) null);
                } catch (Exception e) {
                    Log.e(TAG, "get from metaData failed : " + e.getMessage());
                }
            }
            if (wxappPayEntryClassname == null) {
                Log.e(TAG, "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.bundle = bundle;
        args.targetPkgName = "com.tencent.mm";
        args.targetClassName = wxappPayEntryClassname;
        args.launchMode = this.launchMode;
        try {
            String tokenFromWX = getTokenFromWX(context2);
            if (tokenFromWX != null) {
                args.token = tokenFromWX;
            }
        } catch (Exception e2) {
            Log.e(TAG, "getTokenFromWX fail, exception = " + e2);
        }
        return MMessageActV2.send(context2, args);
    }

    private boolean sendPreloadWXMiniProgramEnvironment(Context context2, BaseReq baseReq) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogramEnvironment"), (String[]) null, (String) null, new String[]{this.appId, ((WXPreloadMiniProgramEnvironment.Req) baseReq).extData}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPreloadWXMiniprogram(Context context2, BaseReq baseReq) {
        WXPreloadMiniProgram.Req req = (WXPreloadMiniProgram.Req) baseReq;
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram");
        Cursor query = contentResolver.query(parse, (String[]) null, (String) null, new String[]{this.appId, req.userName, req.path, req.miniprogramType + "", req.extData}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendQRCodePayReq(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        WXQRCodePay.Req req = (WXQRCodePay.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/QRCodePay"), (String[]) null, (String) null, new String[]{this.appId, req.codeContent, req.extraMsg}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendSubscribeMessage(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        SubscribeMessage.Req req = (SubscribeMessage.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), (String[]) null, (String) null, new String[]{this.appId, String.valueOf(1), String.valueOf(req.scene), req.templateID, req.reserved}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendSubscribeMiniProgramMsg(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), (String[]) null, (String) null, new String[]{this.appId, String.valueOf(5), ((SubscribeMiniProgramMsg.Req) baseReq).miniProgramAppId}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendToWxaRedirectingPage(Context context2, BaseReq baseReq) {
        launchWXIfNeed();
        WXLaunchWxaRedirectingPage.Req req = (WXLaunchWxaRedirectingPage.Req) baseReq;
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWxaOpenApiRedirectingPage");
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, this.appId);
        arrayList.addAll(Arrays.asList(req.toArray()));
        Cursor query = contentResolver.query(parse, (String[]) null, (String) null, (String[]) arrayList.toArray(new String[0]), (String) null);
        if (query == null) {
            return true;
        }
        query.close();
        return true;
    }

    public void detach() {
        Log.d(TAG, "detach");
        this.detached = true;
        this.context = null;
    }

    public int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        } else if (!isWXAppInstalled()) {
            Log.e(TAG, "open wx app failed, not installed or signature check failed");
            return 0;
        } else {
            this.wxSdkVersion = 0;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            b.e.submit(new Runnable() {
                public void run() {
                    try {
                        int unused = BaseWXApiImplV10.this.wxSdkVersion = new MMSharedPreferences(BaseWXApiImplV10.this.context).getInt("_build_info_sdk_int_", 0);
                    } catch (Exception e) {
                        Log.w(BaseWXApiImplV10.TAG, e.getMessage());
                    }
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Log.w(TAG, e.getMessage());
            }
            Log.d(TAG, "wxSdkVersion = " + this.wxSdkVersion);
            if (this.wxSdkVersion == 0) {
                try {
                    this.wxSdkVersion = this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
                    Log.d(TAG, "OPEN_SDK_VERSION = " + this.wxSdkVersion);
                } catch (Exception e2) {
                    Log.e(TAG, "get from metaData failed : " + e2.getMessage());
                }
            }
            return this.wxSdkVersion;
        }
    }

    public boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        try {
            if (!WXApiImplComm.isIntentFromWx(intent, ConstantsAPI.Token.WX_TOKEN_VALUE_MSG)) {
                Log.i(TAG, "handleIntent fail, intent not from weixin msg");
                return false;
            } else if (!this.detached) {
                String stringExtra = intent.getStringExtra(ConstantsAPI.CONTENT);
                int intExtra = intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0);
                String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
                if (stringExtra2 != null) {
                    if (stringExtra2.length() != 0) {
                        if (!checkSumConsistent(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), a.a(stringExtra, intExtra, stringExtra2))) {
                            Log.e(TAG, "checksum fail");
                            return false;
                        }
                        int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                        Log.i(TAG, "handleIntent, cmd = " + intExtra2);
                        switch (intExtra2) {
                            case 1:
                                iWXAPIEventHandler.onResp(new SendAuth.Resp(intent.getExtras()));
                                return true;
                            case 2:
                                iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                                return true;
                            case 3:
                                iWXAPIEventHandler.onReq(new GetMessageFromWX.Req(intent.getExtras()));
                                return true;
                            case 4:
                                ShowMessageFromWX.Req req = new ShowMessageFromWX.Req(intent.getExtras());
                                String str = req.message.messageExt;
                                if (str == null || !str.contains("wx_internal_resptype")) {
                                    if (str != null && str.contains("openbusinesswebview")) {
                                        try {
                                            Uri parse = Uri.parse(str);
                                            if (parse == null || !"openbusinesswebview".equals(parse.getHost())) {
                                                Log.d(TAG, "not openbusinesswebview %" + str);
                                            } else {
                                                WXOpenBusinessWebview.Resp resp = new WXOpenBusinessWebview.Resp();
                                                String queryParameter = parse.getQueryParameter("ret");
                                                if (queryParameter != null && queryParameter.length() > 0) {
                                                    resp.errCode = b.a(queryParameter, 0);
                                                }
                                                resp.resultInfo = parse.getQueryParameter("resultInfo");
                                                resp.errStr = parse.getQueryParameter("errmsg");
                                                String queryParameter2 = parse.getQueryParameter("type");
                                                if (queryParameter2 != null && queryParameter2.length() > 0) {
                                                    resp.businessType = b.a(queryParameter2, 0);
                                                }
                                                iWXAPIEventHandler.onResp(resp);
                                                return true;
                                            }
                                        } catch (Exception e) {
                                            Log.e(TAG, "parse fail, ex = " + e.getMessage());
                                        }
                                    }
                                    iWXAPIEventHandler.onReq(req);
                                    return true;
                                }
                                boolean handleWxInternalRespType = handleWxInternalRespType(str, iWXAPIEventHandler);
                                Log.i(TAG, "handleIntent, extInfo contains wx_internal_resptype, ret = " + handleWxInternalRespType);
                                return handleWxInternalRespType;
                            case 5:
                                iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                                return true;
                            case 6:
                                iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                                return true;
                            case 9:
                                iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                                return true;
                            case 12:
                                iWXAPIEventHandler.onResp(new OpenWebview.Resp(intent.getExtras()));
                                return true;
                            case 14:
                                iWXAPIEventHandler.onResp(new CreateChatroom.Resp(intent.getExtras()));
                                return true;
                            case 15:
                                iWXAPIEventHandler.onResp(new JoinChatroom.Resp(intent.getExtras()));
                                return true;
                            case 16:
                                iWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(intent.getExtras()));
                                return true;
                            case 17:
                                iWXAPIEventHandler.onResp(new HandleScanResult.Resp(intent.getExtras()));
                                return true;
                            case 19:
                                iWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(intent.getExtras()));
                                return true;
                            case 24:
                                iWXAPIEventHandler.onResp(new JumpToOfflinePay.Resp(intent.getExtras()));
                                return true;
                            case 25:
                                iWXAPIEventHandler.onResp(new WXOpenBusinessWebview.Resp(intent.getExtras()));
                                return true;
                            case 26:
                                iWXAPIEventHandler.onResp(new WXOpenBusinessView.Resp(intent.getExtras()));
                                return true;
                            case 27:
                                iWXAPIEventHandler.onResp(new WXJointPay.JointPayResp(intent.getExtras()));
                                return true;
                            case 28:
                                iWXAPIEventHandler.onResp(new WXPreloadMiniProgram.Resp(intent.getExtras()));
                                return true;
                            case 29:
                                iWXAPIEventHandler.onResp(new WXLaunchMiniProgramWithToken.Resp(intent.getExtras()));
                                return true;
                            case 30:
                                iWXAPIEventHandler.onResp(new WXLaunchWxaRedirectingPage.Resp(intent.getExtras()));
                                return true;
                            case 31:
                                iWXAPIEventHandler.onResp(new SendTdiAuth.Resp(intent.getExtras()));
                                return true;
                            case 32:
                                iWXAPIEventHandler.onResp(new WXPreloadMiniProgramEnvironment.Resp(intent.getExtras()));
                                return true;
                            case 33:
                                iWXAPIEventHandler.onResp(new WXChannelShareVideo.Resp(intent.getExtras()));
                                return true;
                            case 34:
                                iWXAPIEventHandler.onResp(new WXChannelOpenProfile.Resp(intent.getExtras()));
                                return true;
                            case 35:
                                iWXAPIEventHandler.onResp(new WXChannelOpenLive.Resp(intent.getExtras()));
                                return true;
                            case 36:
                                iWXAPIEventHandler.onResp(new WXChannelOpenFeed.Resp(intent.getExtras()));
                                return true;
                            case 37:
                                iWXAPIEventHandler.onResp(new WXOpenCustomerServiceChat.Resp(intent.getExtras()));
                                return true;
                            case 38:
                                iWXAPIEventHandler.onResp(new WXQRCodePay.Resp(intent.getExtras()));
                                return true;
                            default:
                                Log.e(TAG, "unknown cmd = " + intExtra2);
                                break;
                        }
                        return false;
                    }
                }
                Log.e(TAG, "invalid argument");
                return false;
            } else {
                throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
            }
        } catch (Exception e2) {
            Log.e(TAG, "handleIntent fail, ex = " + e2.getMessage());
        }
    }

    public boolean isWXAppInstalled() {
        if (!this.detached) {
            try {
                PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
                if (packageInfo == null) {
                    return false;
                }
                return WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
            } catch (Exception unused) {
                return false;
            }
        } else {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
    }

    public boolean openWXApp() {
        String str;
        if (!this.detached) {
            if (!isWXAppInstalled()) {
                str = "open wx app failed, not installed or signature check failed";
            } else {
                try {
                    this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                    return true;
                } catch (Exception e) {
                    str = "startActivity fail, exception = " + e.getMessage();
                }
            }
            Log.e(TAG, str);
            return false;
        }
        throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    }

    public boolean registerApp(String str) {
        return registerApp(str, 0);
    }

    public boolean registerApp(String str, long j) {
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "register app failed for wechat app signature check failed");
            return false;
        } else {
            Log.d(TAG, "registerApp, appId = " + str);
            if (str != null) {
                this.appId = str;
            }
            Log.d(TAG, "registerApp, appId = " + str);
            if (str != null) {
                this.appId = str;
            }
            Log.d(TAG, "register app " + this.context.getPackageName());
            a.C0262a aVar = new a.C0262a();
            aVar.a = "com.tencent.mm";
            aVar.b = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
            aVar.c = "weixin://registerapp?appid=" + this.appId;
            aVar.d = j;
            return a.a(this.context, aVar);
        }
    }

    public boolean sendReq(BaseReq baseReq) {
        StringBuilder sb;
        String str;
        WXWebpageObject wXWebpageObject;
        String str2;
        String str3;
        if (!this.detached) {
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                str2 = "sendReq failed for wechat app signature check failed";
            } else {
                if (baseReq.getType() == 2) {
                    SendMessageToWX.Req req = (SendMessageToWX.Req) baseReq;
                    if (req.scene == 4) {
                        SendMessageToWX.IWXSceneDataObject iWXSceneDataObject = req.sceneDataObject;
                        if (iWXSceneDataObject instanceof WXStateSceneDataObject) {
                            WXStateSceneDataObject wXStateSceneDataObject = (WXStateSceneDataObject) iWXSceneDataObject;
                            WXMediaMessage wXMediaMessage = req.message;
                            if (wXMediaMessage.mediaObject == null) {
                                wXMediaMessage.mediaObject = new WXTextObject();
                            }
                            if (req.message.getType() == 1 && ((str3 = wXStateSceneDataObject.stateTitle) == null || str3.length() <= 0)) {
                                wXStateSceneDataObject.stateTitle = ((WXTextObject) req.message.mediaObject).text;
                            }
                        }
                    }
                }
                if (!baseReq.checkArgs()) {
                    str2 = "sendReq checkArgs fail";
                } else {
                    Log.i(TAG, "sendReq, req type = " + baseReq.getType());
                    Bundle bundle = new Bundle();
                    baseReq.toBundle(bundle);
                    if (baseReq.getType() == 5 || baseReq.getType() == 27) {
                        return sendPayReq(this.context, bundle);
                    }
                    if (baseReq.getType() == 9) {
                        return sendAddCardToWX(this.context, bundle);
                    }
                    if (baseReq.getType() == 16) {
                        return sendChooseCardFromWX(this.context, bundle);
                    }
                    if (baseReq.getType() == 11) {
                        return sendOpenRankListReq(this.context, bundle);
                    }
                    if (baseReq.getType() == 12) {
                        return sendOpenWebview(this.context, bundle);
                    }
                    if (baseReq.getType() == 25) {
                        return sendOpenBusinessWebview(this.context, baseReq);
                    }
                    if (baseReq.getType() == 13) {
                        return sendOpenBusiLuckyMoney(this.context, bundle);
                    }
                    if (baseReq.getType() == 14) {
                        return createChatroom(this.context, bundle);
                    }
                    if (baseReq.getType() == 15) {
                        return joinChatroom(this.context, bundle);
                    }
                    if (baseReq.getType() == 17) {
                        return sendHandleScanResult(this.context, bundle);
                    }
                    if (baseReq.getType() == 18) {
                        return sendSubscribeMessage(this.context, baseReq);
                    }
                    if (baseReq.getType() == 28) {
                        return sendPreloadWXMiniprogram(this.context, baseReq);
                    }
                    if (baseReq.getType() == 29) {
                        return sendLaunchWXMiniprogramWithToken(this.context, baseReq);
                    }
                    if (baseReq.getType() == 23) {
                        return sendSubscribeMiniProgramMsg(this.context, baseReq);
                    }
                    if (baseReq.getType() == 19) {
                        return sendLaunchWXMiniprogram(this.context, baseReq);
                    }
                    if (baseReq.getType() == 32) {
                        return sendPreloadWXMiniProgramEnvironment(this.context, baseReq);
                    }
                    if (baseReq.getType() == 30) {
                        return sendToWxaRedirectingPage(this.context, baseReq);
                    }
                    if (baseReq.getType() == 26) {
                        return sendOpenBusinessView(this.context, baseReq);
                    }
                    if (baseReq.getType() == 33) {
                        return sendFinderShareVideo(this.context, baseReq);
                    }
                    if (baseReq.getType() == 34) {
                        return sendFinderOpenProfile(this.context, baseReq);
                    }
                    if (baseReq.getType() == 35) {
                        return sendFinderOpenLive(this.context, baseReq);
                    }
                    if (baseReq.getType() == 36) {
                        return sendFinderOpenFeed(this.context, baseReq);
                    }
                    if (baseReq.getType() == 37) {
                        return sendOpenCustomerServiceChat(this.context, baseReq);
                    }
                    if (baseReq.getType() == 38) {
                        return sendQRCodePayReq(this.context, baseReq);
                    }
                    if (baseReq.getType() == 20) {
                        return sendInvoiceAuthInsert(this.context, baseReq);
                    }
                    if (baseReq.getType() == 21) {
                        return sendNonTaxPay(this.context, baseReq);
                    }
                    if (baseReq.getType() == 22) {
                        return sendPayInSurance(this.context, baseReq);
                    }
                    if (baseReq.getType() == 24) {
                        return sendJumpToOfflinePayReq(this.context, bundle);
                    }
                    if (baseReq.getType() == 2) {
                        SendMessageToWX.Req req2 = (SendMessageToWX.Req) baseReq;
                        int type = req2.message.getType();
                        if (b.a(type)) {
                            if (getWXAppSupportAPI() < 620756993) {
                                wXWebpageObject = new WXWebpageObject();
                            } else if (type != 46 || getWXAppSupportAPI() >= 620953856) {
                                WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) req2.message.mediaObject;
                                wXMiniProgramObject.userName += "@app";
                                String str4 = wXMiniProgramObject.path;
                                if (!b.b(str4)) {
                                    String[] split = str4.split("\\?");
                                    if (split.length > 1) {
                                        sb = new StringBuilder();
                                        sb.append(split[0]);
                                        sb.append(".html?");
                                        str = split[1];
                                    } else {
                                        sb = new StringBuilder();
                                        sb.append(split[0]);
                                        str = ".html";
                                    }
                                    sb.append(str);
                                    wXMiniProgramObject.path = sb.toString();
                                }
                                int i2 = req2.scene;
                                if (!(i2 == 3 || i2 == 1)) {
                                    req2.scene = 0;
                                }
                                baseReq.toBundle(bundle);
                            } else {
                                wXWebpageObject = new WXWebpageObject();
                            }
                            wXWebpageObject.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
                            req2.message.mediaObject = wXWebpageObject;
                            int i22 = req2.scene;
                            req2.scene = 0;
                            baseReq.toBundle(bundle);
                        }
                    }
                    MMessageActV2.Args args = new MMessageActV2.Args();
                    args.bundle = bundle;
                    args.content = "weixin://sendreq?appid=" + this.appId;
                    args.targetPkgName = "com.tencent.mm";
                    args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                    args.launchMode = this.launchMode;
                    try {
                        String tokenFromWX = getTokenFromWX(this.context);
                        if (tokenFromWX != null) {
                            args.token = tokenFromWX;
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "getTokenFromWX fail, exception = " + e);
                    }
                    return MMessageActV2.send(this.context, args);
                }
            }
            Log.e(TAG, str2);
            return false;
        }
        throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
    }

    public boolean sendResp(BaseResp baseResp) {
        String str;
        if (!this.detached) {
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                str = "sendResp failed for wechat app signature check failed";
            } else if (!baseResp.checkArgs()) {
                str = "sendResp checkArgs fail";
            } else {
                Bundle bundle = new Bundle();
                baseResp.toBundle(bundle);
                MMessageActV2.Args args = new MMessageActV2.Args();
                args.bundle = bundle;
                args.content = "weixin://sendresp?appid=" + this.appId;
                args.targetPkgName = "com.tencent.mm";
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                try {
                    String tokenFromWX = getTokenFromWX(this.context);
                    if (tokenFromWX != null) {
                        args.token = tokenFromWX;
                    }
                } catch (Exception e) {
                    Log.e(TAG, "getTokenFromWX fail, exception = " + e);
                }
                return MMessageActV2.send(this.context, args);
            }
            Log.e(TAG, str);
            return false;
        }
        throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
    }

    public void setLogImpl(ILog iLog) {
        Log.setLogImpl(iLog);
    }

    public void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "unregister app failed for wechat app signature check failed");
        } else {
            Log.d(TAG, "unregisterApp, appId = " + this.appId);
            String str = this.appId;
            if (str == null || str.length() == 0) {
                Log.e(TAG, "unregisterApp fail, appId is empty");
                return;
            }
            Log.d(TAG, "unregister app " + this.context.getPackageName());
            a.C0262a aVar = new a.C0262a();
            aVar.a = "com.tencent.mm";
            aVar.b = ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
            aVar.c = "weixin://unregisterapp?appid=" + this.appId;
            a.a(this.context, aVar);
        }
    }
}
