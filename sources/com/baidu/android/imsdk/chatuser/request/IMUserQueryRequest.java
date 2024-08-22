package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import java.util.List;

public class IMUserQueryRequest extends IMUserBaseHttpRequest {
    private long mAppid;
    private String mKey;

    public IMUserQueryRequest(Context context, long appid) {
        this.mContext = context;
        this.mAppid = appid;
    }

    public IMUserQueryRequest(Context context, long appid, String key) {
        this(context, appid);
        this.mKey = key;
    }

    public byte[] getRequestParameter() {
        StringBuilder builder = new StringBuilder();
        builder.append("method=read_contacter_setting");
        builder.append("&appid=").append(this.mAppid);
        return builder.toString().getBytes();
    }

    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    public boolean shouldAbort() {
        if (!AccountManager.isCuidLogin(this.mContext)) {
            return false;
        }
        onFailure(1000, "Account not login! pls login first!, uid login required".getBytes(), (Throwable) null);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f0 A[LOOP:1: B:27:0x00ea->B:29:0x00f0, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(int r25, byte[] r26) {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r0 = "response_params"
            java.lang.String r2 = new java.lang.String
            r3 = r26
            r2.<init>(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "IMUserQueryRequest  "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = ""
            com.baidu.android.imsdk.utils.LogUtils.d(r5, r4)
            r4 = r25
            java.lang.String r6 = "Sucess!"
            java.util.LinkedList r7 = new java.util.LinkedList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00d2 }
            r9.<init>(r2)     // Catch:{ JSONException -> 0x00d2 }
            boolean r10 = r9.has(r0)     // Catch:{ JSONException -> 0x00d2 }
            java.lang.String r11 = "error_code"
            if (r10 == 0) goto L_0x00c1
            org.json.JSONObject r0 = r9.getJSONObject(r0)     // Catch:{ JSONException -> 0x00d2 }
            int r10 = r0.getInt(r11)     // Catch:{ JSONException -> 0x00d2 }
            r4 = r10
            java.lang.String r10 = "contacters"
            org.json.JSONArray r10 = r0.getJSONArray(r10)     // Catch:{ JSONException -> 0x00d2 }
            r11 = 0
        L_0x004f:
            int r12 = r10.length()     // Catch:{ JSONException -> 0x00d2 }
            if (r11 >= r12) goto L_0x00bc
            org.json.JSONObject r12 = r10.getJSONObject(r11)     // Catch:{ JSONException -> 0x00d2 }
            java.lang.String r13 = "contacter"
            long r15 = r12.optLong(r13)     // Catch:{ JSONException -> 0x00d2 }
            java.lang.String r13 = "contacter_type"
            int r13 = r12.optInt(r13)     // Catch:{ JSONException -> 0x00d2 }
            java.lang.String r14 = "do_not_disturb"
            int r14 = r12.optInt(r14)     // Catch:{ JSONException -> 0x00d2 }
            r21 = r0
            java.lang.String r0 = "blacklist"
            int r0 = r12.optInt(r0)     // Catch:{ JSONException -> 0x00d2 }
            if (r13 != 0) goto L_0x009e
            com.baidu.android.imsdk.chatuser.ChatUser r22 = new com.baidu.android.imsdk.chatuser.ChatUser     // Catch:{ JSONException -> 0x00d2 }
            r17 = 0
            r19 = 0
            r20 = 0
            r23 = r2
            r2 = r14
            r14 = r22
            r14.<init>(r15, r17, r19, r20)     // Catch:{ JSONException -> 0x00d0 }
            r14 = r22
            r14.setDisturb(r2)     // Catch:{ JSONException -> 0x00d0 }
            r14.setBlack(r0)     // Catch:{ JSONException -> 0x00d0 }
            r17 = r0
            java.lang.String r0 = "user_ext"
            java.lang.String r0 = r12.optString(r0, r5)     // Catch:{ JSONException -> 0x00d0 }
            r14.setUserExt(r0)     // Catch:{ JSONException -> 0x00d0 }
            r7.add(r14)     // Catch:{ JSONException -> 0x00d0 }
            goto L_0x00b5
        L_0x009e:
            r17 = r0
            r23 = r2
            r2 = r14
            r0 = 1
            if (r0 != r13) goto L_0x00b5
            com.baidu.android.imsdk.group.GroupInfo r0 = new com.baidu.android.imsdk.group.GroupInfo     // Catch:{ JSONException -> 0x00d0 }
            java.lang.String r14 = java.lang.String.valueOf(r15)     // Catch:{ JSONException -> 0x00d0 }
            r0.<init>((java.lang.String) r14)     // Catch:{ JSONException -> 0x00d0 }
            r0.setDisturb(r2)     // Catch:{ JSONException -> 0x00d0 }
            r8.add(r0)     // Catch:{ JSONException -> 0x00d0 }
        L_0x00b5:
            int r11 = r11 + 1
            r0 = r21
            r2 = r23
            goto L_0x004f
        L_0x00bc:
            r21 = r0
            r23 = r2
            goto L_0x00cf
        L_0x00c1:
            r23 = r2
            int r0 = r9.getInt(r11)     // Catch:{ JSONException -> 0x00d0 }
            r4 = r0
            java.lang.String r0 = "error_msg"
            java.lang.String r0 = r9.optString(r0, r5)     // Catch:{ JSONException -> 0x00d0 }
            r6 = r0
        L_0x00cf:
            goto L_0x00e1
        L_0x00d0:
            r0 = move-exception
            goto L_0x00d5
        L_0x00d2:
            r0 = move-exception
            r23 = r2
        L_0x00d5:
            java.lang.String r2 = "IMUserQueryRequest"
            java.lang.String r5 = "JSONException"
            com.baidu.android.imsdk.utils.LogUtils.e(r2, r5, r0)
            r4 = 1010(0x3f2, float:1.415E-42)
            java.lang.String r6 = "parse json exception!"
        L_0x00e1:
            android.content.Context r0 = r1.mContext
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.setAllStarDisturbDefault(r0)
            java.util.Iterator r0 = r8.iterator()
        L_0x00ea:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0104
            java.lang.Object r2 = r0.next()
            com.baidu.android.imsdk.group.GroupInfo r2 = (com.baidu.android.imsdk.group.GroupInfo) r2
            android.content.Context r5 = r1.mContext
            java.lang.String r9 = r2.getGroupId()
            int r10 = r2.getDisturb()
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.setGroupDisturb(r5, r9, r10)
            goto L_0x00ea
        L_0x0104:
            android.content.Context r0 = r1.mContext
            com.baidu.android.imsdk.chatuser.ChatUserManagerImpl r0 = com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.getInstance(r0)
            java.lang.String r2 = r1.mKey
            r0.onQueryResult(r4, r6, r7, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.chatuser.request.IMUserQueryRequest.onSuccess(int, byte[]):void");
    }

    public void onFailure(int errorCode, byte[] resultContent, Throwable tr) {
        int realErrorCode = errorCode;
        String errorMsg = "";
        if (resultContent != null) {
            errorMsg = new String(resultContent);
        }
        if (!(tr != null || errorCode == 1005 || errorCode == 1000)) {
            realErrorCode = 1011;
            errorMsg = "http response is error! response code:" + errorCode;
        }
        ChatUserManagerImpl.getInstance(this.mContext).onQueryResult(realErrorCode, errorMsg, (List<ChatUser>) null, this.mKey);
    }
}
