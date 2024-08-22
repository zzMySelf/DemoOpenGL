package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IMPaGetInfoRequest extends PaBaseHttpRequest {
    private static final String TAG = IMPaGetInfoRequest.class.getSimpleName();
    private long mAppid;
    private String mKey;
    private long mUk;

    public IMPaGetInfoRequest(Context context, String key, long appid, long uk) {
        this.mContext = context;
        this.mAppid = appid;
        this.mKey = key;
        this.mUk = uk;
    }

    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long timeStamp = System.currentTimeMillis() / 1000;
        StringBuilder builder = new StringBuilder();
        builder.append("method=pa_detail_list");
        builder.append("&appid=").append(this.mAppid);
        builder.append("&timestamp=").append(timeStamp);
        builder.append("&uk=").append(this.mUk);
        builder.append("&sdk_version=").append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        builder.append("&sign=").append(getMd5("" + timeStamp + bduss + this.mAppid));
        builder.append("&is_https=").append(true);
        builder.append("&account_type=").append(AccountManagerImpl.getInstance(this.mContext).getLoginType());
        if (AccountManager.isCuidLogin(this.mContext)) {
            builder.append("&token");
            builder.append(AccountManager.getToken(this.mContext));
        }
        return builder.toString().getBytes();
    }

    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    public boolean shouldAbort() {
        return false;
    }

    public void onSuccess(int errorCode, byte[] resultContent) {
        String resultMsg;
        int resultCode;
        String str;
        String jsonString;
        String str2;
        String str3 = "pa_type";
        String str4 = "";
        String jsonString2 = new String(resultContent);
        LogUtils.d(TAG, "FXF  json is " + jsonString2);
        int i2 = errorCode;
        List<PaInfo> paInfos = null;
        try {
            JSONObject origin = new JSONObject(jsonString2);
            resultCode = origin.getInt("error_code");
            resultMsg = origin.optString("error_msg", str4);
            if (resultCode == 0) {
                if (origin.has("response_params")) {
                    JSONArray params = origin.getJSONArray("response_params");
                    paInfos = new ArrayList<>();
                    int i3 = 0;
                    while (i3 < params.length()) {
                        JSONObject item = params.getJSONObject(i3);
                        if (item.optInt(str3) == 16) {
                            str = str3;
                            str2 = str4;
                            jsonString = jsonString2;
                        } else {
                            PaInfo info = new PaInfo();
                            jsonString = jsonString2;
                            try {
                                info.setPaId(item.optLong("pa_uid"));
                                info.setNickName(item.optString("pa_nickname"));
                                info.setUsername(item.optString("pa_username"));
                                info.setAvatar(item.optString("pa_avatar"));
                                info.setDescription(item.optString("description"));
                                info.setDetail(item.optString("detail_description"));
                                info.setTPL(item.optLong("tpl", -1));
                                info.setAcceptPush(item.optBoolean("is_accept_msg"));
                                info.setUrl(item.optString("pa_url"));
                                info.setSubcribeTime(item.optLong("create_time"));
                                info.setSubtype(item.optInt(str3));
                                info.setClassType(item.optInt("pa_classtype", 0));
                                info.setClasstitle(item.optString("pa_classtitle"));
                                info.setClassAvatar(item.optString("pa_classavatar"));
                                info.setClassshow(item.optInt("pa_classshow", 0));
                                info.setStatus(item.optInt("status", 0));
                                info.setMarkTopTime(item.optLong("upmark_time"));
                                info.setMarkTop(item.optInt("is_upmark", 0));
                                String extStr = item.optString(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT, str4);
                                info.setPaExt(extStr);
                                if (!TextUtils.isEmpty(extStr)) {
                                    try {
                                        JSONObject ext = new JSONObject(extStr);
                                        str = str3;
                                        try {
                                            info.setSubsetType(ext.optInt("sub_pa_type", 0));
                                            if (ext.has("default_do_not_disturb")) {
                                                str2 = str4;
                                                String str5 = extStr;
                                                try {
                                                    if (!Utility.readBooleanData(this.mContext, Utility.readUid(this.mContext) + "_" + info.getPaId(), false)) {
                                                        info.setDisturb(ext.optInt("default_do_not_disturb"));
                                                    }
                                                } catch (JSONException e2) {
                                                    e = e2;
                                                    LogUtils.e(LogUtils.TAG, "IMPaGetInfoListRequest JSONException", e);
                                                    paInfos.add(info);
                                                    i3++;
                                                    str4 = str2;
                                                    jsonString2 = jsonString;
                                                    str3 = str;
                                                    byte[] bArr = resultContent;
                                                }
                                            } else {
                                                str2 = str4;
                                                String str6 = extStr;
                                            }
                                        } catch (JSONException e3) {
                                            e = e3;
                                            str2 = str4;
                                            String str7 = extStr;
                                            LogUtils.e(LogUtils.TAG, "IMPaGetInfoListRequest JSONException", e);
                                            paInfos.add(info);
                                            i3++;
                                            str4 = str2;
                                            jsonString2 = jsonString;
                                            str3 = str;
                                            byte[] bArr2 = resultContent;
                                        }
                                    } catch (JSONException e4) {
                                        e = e4;
                                        str = str3;
                                        str2 = str4;
                                        String str72 = extStr;
                                        LogUtils.e(LogUtils.TAG, "IMPaGetInfoListRequest JSONException", e);
                                        paInfos.add(info);
                                        i3++;
                                        str4 = str2;
                                        jsonString2 = jsonString;
                                        str3 = str;
                                        byte[] bArr22 = resultContent;
                                    }
                                } else {
                                    str = str3;
                                    str2 = str4;
                                    String str8 = extStr;
                                }
                                paInfos.add(info);
                            } catch (JSONException e5) {
                                e = e5;
                                int i4 = errorCode;
                                LogUtils.e(LogUtils.TAG, "IMGetZhidaInfoRequest JSONException", e);
                                resultCode = 1010;
                                resultMsg = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                                PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, resultCode, resultMsg, paInfos);
                            }
                        }
                        i3++;
                        str4 = str2;
                        jsonString2 = jsonString;
                        str3 = str;
                        byte[] bArr222 = resultContent;
                    }
                    localSyncSubscribedPaList(this.mContext, paInfos);
                    int i5 = errorCode;
                } else {
                    int i6 = errorCode;
                }
                PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, resultCode, resultMsg, paInfos);
            }
            resultMsg = "query from local db";
            try {
                paInfos = PaInfoDBManager.getInstance(this.mContext).querySubscribedPaList();
            } catch (JSONException e6) {
                e = e6;
                LogUtils.e(LogUtils.TAG, "IMGetZhidaInfoRequest JSONException", e);
                resultCode = 1010;
                resultMsg = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, resultCode, resultMsg, paInfos);
            }
            PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, resultCode, resultMsg, paInfos);
        } catch (JSONException e7) {
            e = e7;
            String str9 = jsonString2;
            int i7 = errorCode;
            LogUtils.e(LogUtils.TAG, "IMGetZhidaInfoRequest JSONException", e);
            resultCode = 1010;
            resultMsg = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, resultCode, resultMsg, paInfos);
        }
    }

    public void onFailure(int errorCode, byte[] resultContent, Throwable tr) {
        Pair<Integer, String> tips = transErrorCode(errorCode, resultContent, tr);
        PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, ((Integer) tips.first).intValue(), (String) tips.second, (List<PaInfo>) null);
    }

    private void localSyncSubscribedPaList(Context context, List<PaInfo> paList) {
        if (paList != null) {
            if (paList.size() == 0) {
                PaInfoDBManager.getInstance(context).deleteAllSubscribedPa();
                return;
            }
            List<PaInfo> localSubscribedPaList = PaInfoDBManager.getInstance(context).querySubscribedPaList();
            ArrayList<PaInfo> newPaInfoList = new ArrayList<>();
            for (PaInfo paInfo : paList) {
                boolean hit = false;
                if (localSubscribedPaList != null) {
                    Iterator<PaInfo> it = localSubscribedPaList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PaInfo paInfoLocal = it.next();
                        if (paInfo.getPaId() == paInfoLocal.getPaId()) {
                            localSubscribedPaList.remove(paInfoLocal);
                            PaInfoDBManager.getInstance(context).acceptPaPush(paInfo.getPaId(), paInfo.isAcceptPush());
                            hit = true;
                            break;
                        }
                    }
                }
                if (!hit) {
                    newPaInfoList.add(paInfo);
                }
            }
            Iterator<PaInfo> it2 = newPaInfoList.iterator();
            while (it2.hasNext()) {
                PaInfo newPaInfo = it2.next();
                LogUtils.d(TAG, "FXF  add to db " + newPaInfo.toString());
                PaInfoDBManager.getInstance(context).subscribePa(newPaInfo);
            }
        }
    }
}
