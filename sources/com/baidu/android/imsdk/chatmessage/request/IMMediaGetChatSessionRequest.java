package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class IMMediaGetChatSessionRequest extends IMMediaBaseHttpRequest {
    private static final int INTERACTIVE_MSG_CLASS_TYPE = 11;
    private static final String KEY_MEDIA_TOTAL_NUM_FROM_SERVER = "media_total_num_from_server";
    private static final int MAX_FETCH_COUNT = 20;
    private static final String TAG = "IMMediaGetChatSessionRequest";
    private long mContacter;
    private long mContactorPauid = -1;
    private String mContactorThirdid;
    private int mContactorType = -1;
    private int mCount;
    private long mEndTime;
    private String mKey;
    private int mNeedTop = -1;

    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    public /* bridge */ /* synthetic */ String getMethod() {
        return super.getMethod();
    }

    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
    }

    public IMMediaGetChatSessionRequest(Context context, long contacter, int count, long endTime, String key) {
        this.mContext = context;
        this.mContacter = contacter;
        this.mCount = count;
        this.mEndTime = endTime;
        this.mKey = key;
    }

    public IMMediaGetChatSessionRequest(Context context, long contacter, int contactorType, long contactorPauid, String contactorThirdid, int count, long endTime, int needTop, String key) {
        this.mContext = context;
        this.mContacter = contacter;
        this.mCount = count;
        this.mEndTime = endTime;
        this.mKey = key;
        this.mContactorType = contactorType;
        this.mContactorPauid = contactorPauid;
        this.mContactorThirdid = contactorThirdid;
        this.mNeedTop = needTop;
    }

    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        JSONObject json = new JSONObject();
        try {
            putCommonParams(json);
            long j2 = this.mContacter;
            if (j2 > 0) {
                if (this.mContactorType == 2) {
                    json.put("contacter_im_uk", j2);
                } else {
                    json.put("contacter", Utility.transBDUID(String.valueOf(j2)));
                }
            }
            long j3 = this.mEndTime;
            if (j3 > 0) {
                json.put("end_time", j3);
            }
            int i2 = this.mContactorType;
            if (i2 >= 0) {
                json.put("contacter_type", i2);
            }
            long j4 = this.mContactorPauid;
            if (j4 > 0) {
                json.put("contacter_pa_uid", j4);
            }
            if (!TextUtils.isEmpty(this.mContactorThirdid)) {
                json.put("contacter_third_id", this.mContactorThirdid);
            }
            json.put("need_top", this.mNeedTop);
            int i3 = this.mCount;
            if (i3 > 20) {
                i3 = 20;
            }
            json.put("count", i3);
            json.put("sign", generateSign(json));
        } catch (JSONException e2) {
            LogUtils.e(TAG, "Exception ", e2);
        }
        return json.toString().getBytes();
    }

    public String getContentType() {
        return "application/json";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01ae, code lost:
        if ("null".equalsIgnoreCase(r10) != false) goto L_0x01b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(int r58, byte[] r59) {
        /*
            r57 = this;
            r1 = r57
            java.lang.String r2 = ""
            java.lang.String r0 = new java.lang.String
            r3 = r59
            r0.<init>(r3)
            r4 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "onSuccess resultContent = "
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "IMMediaGetChatSessionRequest"
            com.baidu.android.imsdk.utils.LogUtils.d(r5, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r15 = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r14 = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r13 = r0
            r10 = 0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x038f }
            r0.<init>(r4)     // Catch:{ JSONException -> 0x038f }
            r12 = r0
            java.lang.String r0 = "error_code"
            int r0 = r12.optInt(r0, r10)     // Catch:{ JSONException -> 0x038f }
            r16 = r0
            if (r16 != 0) goto L_0x0384
            java.lang.String r0 = "has_more"
            int r0 = r12.optInt(r0, r10)     // Catch:{ JSONException -> 0x038f }
            r6 = r0
            java.lang.String r0 = "total_unread_num"
            int r0 = r12.optInt(r0, r10)     // Catch:{ JSONException -> 0x0378 }
            r7 = r0
            r1.writeServerUnreadnum(r7)     // Catch:{ JSONException -> 0x036b }
            java.lang.String r0 = "consult_unread_num"
            int r0 = r12.optInt(r0, r10)     // Catch:{ JSONException -> 0x036b }
            r8 = r0
            java.lang.String r0 = "top_has_more"
            int r0 = r12.optInt(r0)     // Catch:{ JSONException -> 0x035c }
            r9 = r0
            java.lang.String r0 = "sessions"
            org.json.JSONArray r0 = r12.optJSONArray(r0)     // Catch:{ JSONException -> 0x034b }
            r17 = r0
            r11 = r17
            if (r11 == 0) goto L_0x0331
            r0 = 0
            r10 = r0
        L_0x007c:
            int r0 = r11.length()     // Catch:{ JSONException -> 0x034b }
            if (r10 >= r0) goto L_0x031d
            org.json.JSONObject r0 = r11.getJSONObject(r10)     // Catch:{ JSONException -> 0x034b }
            r19 = r0
            java.lang.String r0 = "chat_type"
            r3 = r19
            int r0 = r3.optInt(r0)     // Catch:{ JSONException -> 0x034b }
            r19 = r0
            java.lang.String r0 = "contacter_pass_uk"
            java.lang.String r0 = r3.optString(r0)     // Catch:{ JSONException -> 0x034b }
            r20 = r0
            r21 = 0
            java.lang.String r0 = com.baidu.android.imsdk.utils.Utility.transBDUK(r20)     // Catch:{ NumberFormatException -> 0x00b5, JSONException -> 0x00ab }
            long r23 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x00b5, JSONException -> 0x00ab }
            r21 = r23
            r23 = r4
            r24 = r6
            goto L_0x00c1
        L_0x00ab:
            r0 = move-exception
            r23 = r4
            r55 = r5
            r33 = r13
            r2 = r14
            goto L_0x0398
        L_0x00b5:
            r0 = move-exception
            r23 = r4
            java.lang.String r4 = com.baidu.android.imsdk.utils.LogUtils.TAG     // Catch:{ JSONException -> 0x030d }
            r24 = r6
            java.lang.String r6 = "IMMediaGetChatSessionRequest NumberFormatException"
            com.baidu.android.imsdk.utils.LogUtils.e(r4, r6, r0)     // Catch:{ JSONException -> 0x02fd }
        L_0x00c1:
            java.lang.String r0 = "contacter_pa_uid"
            long r25 = r3.optLong(r0)     // Catch:{ JSONException -> 0x02fd }
            r27 = r25
            java.lang.String r0 = "content_type"
            int r31 = r3.optInt(r0)     // Catch:{ JSONException -> 0x02fd }
            java.lang.String r0 = "content"
            java.lang.String r34 = r3.optString(r0)     // Catch:{ JSONException -> 0x02fd }
            r0 = r2
            java.lang.String r4 = "unread_num"
            int r4 = r3.optInt(r4)     // Catch:{ JSONException -> 0x02fd }
            java.lang.String r6 = "last_time"
            long r25 = r3.optLong(r6)     // Catch:{ JSONException -> 0x02fd }
            r35 = r25
            java.lang.String r6 = "contacter_im_uk"
            long r39 = r3.optLong(r6)     // Catch:{ JSONException -> 0x02fd }
            java.lang.String r6 = "is_top"
            r25 = r7
            r7 = 0
            int r6 = r3.optInt(r6, r7)     // Catch:{ JSONException -> 0x02ed }
            r17 = 0
            java.lang.String r7 = "last_msg_bd_uid"
            long r29 = r3.optLong(r7)     // Catch:{ JSONException -> 0x02ed }
            r44 = r29
            java.lang.String r7 = "pa_classtype"
            int r7 = r3.optInt(r7)     // Catch:{ JSONException -> 0x02ed }
            r37 = r0
            java.lang.String r0 = "pa_classtitle"
            java.lang.String r0 = r3.optString(r0)     // Catch:{ JSONException -> 0x02ed }
            r46 = r8
            java.lang.String r8 = "pa_classavatar"
            java.lang.String r8 = r3.optString(r8)     // Catch:{ JSONException -> 0x02dd }
            r47 = r9
            java.lang.String r9 = "last_msg_im_uk"
            long r29 = r3.optLong(r9)     // Catch:{ JSONException -> 0x02cd }
            r48 = r29
            java.lang.String r9 = "contacter_type"
            int r9 = r3.optInt(r9)     // Catch:{ JSONException -> 0x02cd }
            r50 = r11
            java.lang.String r11 = "is_block"
            int r11 = r3.optInt(r11)     // Catch:{ JSONException -> 0x02cd }
            r51 = r12
            java.lang.String r12 = "block_timestamp"
            long r29 = r3.optLong(r12)     // Catch:{ JSONException -> 0x02cd }
            r52 = r29
            java.lang.String r12 = "do_not_disturb"
            int r12 = r3.optInt(r12)     // Catch:{ JSONException -> 0x02cd }
            r54 = r3
            r3 = 57
            r55 = r5
            r5 = r19
            if (r5 != r3) goto L_0x014d
            r21 = r39
            r17 = 1
        L_0x014d:
            android.content.Context r3 = r1.mContext     // Catch:{ JSONException -> 0x02cb }
            r33 = 0
            r29 = r3
            r30 = r17
            r32 = r9
            com.baidu.android.imsdk.chatmessage.messages.ChatMsg r3 = com.baidu.android.imsdk.internal.MessageParser.parseChatMsg(r29, r30, r31, r32, r33, r34)     // Catch:{ JSONException -> 0x02cb }
            r29 = r2
            if (r3 == 0) goto L_0x0197
            r30 = r10
            r10 = 57
            if (r5 != r10) goto L_0x0178
            android.content.Context r10 = r1.mContext     // Catch:{ JSONException -> 0x0189 }
            com.baidu.android.imsdk.group.GroupMessageManagerImpl r10 = com.baidu.android.imsdk.group.GroupMessageManagerImpl.getInstance(r10)     // Catch:{ JSONException -> 0x0189 }
            boolean r10 = r10.isValidGroup(r3)     // Catch:{ JSONException -> 0x0189 }
            if (r10 != 0) goto L_0x0178
            r35 = r2
            r33 = r13
            r2 = r14
            goto L_0x02a1
        L_0x0178:
            java.lang.String r10 = r3.getRecommendDescription()     // Catch:{ JSONException -> 0x0189 }
            java.lang.String r32 = r3.getExtLog()     // Catch:{ JSONException -> 0x0189 }
            r29 = r32
            r56 = r29
            r29 = r3
            r3 = r56
            goto L_0x01a1
        L_0x0189:
            r0 = move-exception
            r33 = r13
            r2 = r14
            r6 = r24
            r7 = r25
            r8 = r46
            r9 = r47
            goto L_0x0398
        L_0x0197:
            r30 = r10
            r10 = r37
            r56 = r29
            r29 = r3
            r3 = r56
        L_0x01a1:
            boolean r32 = android.text.TextUtils.isEmpty(r10)     // Catch:{ JSONException -> 0x02cb }
            if (r32 != 0) goto L_0x01b0
            java.lang.String r1 = "null"
            boolean r1 = r1.equalsIgnoreCase(r10)     // Catch:{ JSONException -> 0x0189 }
            if (r1 == 0) goto L_0x01b1
        L_0x01b0:
            r10 = r2
        L_0x01b1:
            com.baidu.android.imsdk.chatmessage.ChatSession r1 = new com.baidu.android.imsdk.chatmessage.ChatSession     // Catch:{ JSONException -> 0x02cb }
            java.lang.String r43 = ""
            r37 = r1
            r38 = r17
            r41 = r21
            r37.<init>(r38, r39, r41, r43)     // Catch:{ JSONException -> 0x02cb }
            r33 = r13
            r32 = r14
            long r13 = (long) r4
            r1.setNewMsgSum(r13)     // Catch:{ JSONException -> 0x02be }
            r13 = r35
            r1.setLastMsgTime(r13)     // Catch:{ JSONException -> 0x02be }
            r1.setLastOpenTime(r13)     // Catch:{ JSONException -> 0x02be }
            r1.setLastMsg(r10)     // Catch:{ JSONException -> 0x02be }
            r1.setMarkTop(r6)     // Catch:{ JSONException -> 0x02be }
            r1.setMarkTopTime(r13)     // Catch:{ JSONException -> 0x02be }
            r35 = r2
            r2 = 1
            r1.setSessionFrom(r2)     // Catch:{ JSONException -> 0x02be }
            r1.setIsClicked(r2)     // Catch:{ JSONException -> 0x02be }
            r1.setExt(r3)     // Catch:{ JSONException -> 0x02be }
            r36 = r3
            r2 = r44
            r1.setLastMsgUid(r2)     // Catch:{ JSONException -> 0x02be }
            r1.setChatType(r5)     // Catch:{ JSONException -> 0x02be }
            r1.setShield(r11)     // Catch:{ JSONException -> 0x02be }
            r37 = r2
            r2 = r52
            r1.setShieldTime(r2)     // Catch:{ JSONException -> 0x02be }
            r1.setDisturb(r12)     // Catch:{ JSONException -> 0x02be }
            if (r7 <= 0) goto L_0x0233
            r41 = r2
            r2 = 1
            r1.setClassShow(r2)     // Catch:{ JSONException -> 0x0226 }
            r1.setClassType(r7)     // Catch:{ JSONException -> 0x0226 }
            r1.setClassTitle(r0)     // Catch:{ JSONException -> 0x0226 }
            r1.setName(r0)     // Catch:{ JSONException -> 0x0226 }
            r1.setClassAvatar(r8)     // Catch:{ JSONException -> 0x0226 }
            r1.setIconUrl(r8)     // Catch:{ JSONException -> 0x0226 }
            r2 = r48
            r1.setLastMsgUid(r2)     // Catch:{ JSONException -> 0x0226 }
            r1.setBusinessType(r9)     // Catch:{ JSONException -> 0x0226 }
            r43 = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch:{ JSONException -> 0x0226 }
            r15.put(r0, r1)     // Catch:{ JSONException -> 0x0226 }
            r2 = r32
            goto L_0x02a1
        L_0x0226:
            r0 = move-exception
            r6 = r24
            r7 = r25
            r2 = r32
            r8 = r46
            r9 = r47
            goto L_0x0398
        L_0x0233:
            r43 = r0
            r41 = r2
            r2 = r48
            r0 = 57
            if (r5 != r0) goto L_0x0269
            java.lang.String r0 = java.lang.String.valueOf(r39)     // Catch:{ JSONException -> 0x025c }
            r44 = r2
            r2 = r33
            r2.put(r0, r1)     // Catch:{ JSONException -> 0x024d }
            r33 = r2
            r2 = r32
            goto L_0x02a1
        L_0x024d:
            r0 = move-exception
            r33 = r2
            r6 = r24
            r7 = r25
            r2 = r32
            r8 = r46
            r9 = r47
            goto L_0x0398
        L_0x025c:
            r0 = move-exception
            r6 = r24
            r7 = r25
            r2 = r32
            r8 = r46
            r9 = r47
            goto L_0x0398
        L_0x0269:
            r44 = r2
            r2 = r33
            r48 = 0
            r2 = r27
            int r0 = (r2 > r48 ? 1 : (r2 == r48 ? 0 : -1))
            if (r0 == 0) goto L_0x0282
            r1.setPaid(r2)     // Catch:{ JSONException -> 0x0226 }
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch:{ JSONException -> 0x0226 }
            r15.put(r0, r1)     // Catch:{ JSONException -> 0x0226 }
            r2 = r32
            goto L_0x02a1
        L_0x0282:
            int r0 = (r21 > r48 ? 1 : (r21 == r48 ? 0 : -1))
            if (r0 == 0) goto L_0x029d
            java.lang.Long r0 = java.lang.Long.valueOf(r21)     // Catch:{ JSONException -> 0x02be }
            r27 = r2
            r2 = r32
            r2.put(r0, r1)     // Catch:{ JSONException -> 0x0292 }
            goto L_0x02a1
        L_0x0292:
            r0 = move-exception
            r6 = r24
            r7 = r25
            r8 = r46
            r9 = r47
            goto L_0x0398
        L_0x029d:
            r27 = r2
            r2 = r32
        L_0x02a1:
            int r10 = r30 + 1
            r1 = r57
            r3 = r59
            r14 = r2
            r4 = r23
            r6 = r24
            r7 = r25
            r13 = r33
            r2 = r35
            r8 = r46
            r9 = r47
            r11 = r50
            r12 = r51
            r5 = r55
            goto L_0x007c
        L_0x02be:
            r0 = move-exception
            r2 = r32
            r6 = r24
            r7 = r25
            r8 = r46
            r9 = r47
            goto L_0x0398
        L_0x02cb:
            r0 = move-exception
            goto L_0x02d0
        L_0x02cd:
            r0 = move-exception
            r55 = r5
        L_0x02d0:
            r33 = r13
            r2 = r14
            r6 = r24
            r7 = r25
            r8 = r46
            r9 = r47
            goto L_0x0398
        L_0x02dd:
            r0 = move-exception
            r55 = r5
            r47 = r9
            r33 = r13
            r2 = r14
            r6 = r24
            r7 = r25
            r8 = r46
            goto L_0x0398
        L_0x02ed:
            r0 = move-exception
            r55 = r5
            r46 = r8
            r47 = r9
            r33 = r13
            r2 = r14
            r6 = r24
            r7 = r25
            goto L_0x0398
        L_0x02fd:
            r0 = move-exception
            r55 = r5
            r25 = r7
            r46 = r8
            r47 = r9
            r33 = r13
            r2 = r14
            r6 = r24
            goto L_0x0398
        L_0x030d:
            r0 = move-exception
            r55 = r5
            r24 = r6
            r25 = r7
            r46 = r8
            r47 = r9
            r33 = r13
            r2 = r14
            goto L_0x0398
        L_0x031d:
            r23 = r4
            r24 = r6
            r25 = r7
            r46 = r8
            r47 = r9
            r30 = r10
            r50 = r11
            r51 = r12
            r33 = r13
            r2 = r14
            goto L_0x0342
        L_0x0331:
            r23 = r4
            r24 = r6
            r25 = r7
            r46 = r8
            r47 = r9
            r50 = r11
            r51 = r12
            r33 = r13
            r2 = r14
        L_0x0342:
            r6 = r24
            r7 = r25
            r8 = r46
            r9 = r47
            goto L_0x038c
        L_0x034b:
            r0 = move-exception
            r23 = r4
            r55 = r5
            r24 = r6
            r25 = r7
            r46 = r8
            r47 = r9
            r33 = r13
            r2 = r14
            goto L_0x0398
        L_0x035c:
            r0 = move-exception
            r23 = r4
            r55 = r5
            r24 = r6
            r25 = r7
            r46 = r8
            r33 = r13
            r2 = r14
            goto L_0x0398
        L_0x036b:
            r0 = move-exception
            r23 = r4
            r55 = r5
            r24 = r6
            r25 = r7
            r33 = r13
            r2 = r14
            goto L_0x0398
        L_0x0378:
            r0 = move-exception
            r23 = r4
            r55 = r5
            r24 = r6
            r1 = r7
            r33 = r13
            r2 = r14
            goto L_0x0398
        L_0x0384:
            r23 = r4
            r1 = r7
            r51 = r12
            r33 = r13
            r2 = r14
        L_0x038c:
            r0 = r16
            goto L_0x03a3
        L_0x038f:
            r0 = move-exception
            r23 = r4
            r55 = r5
            r1 = r7
            r33 = r13
            r2 = r14
        L_0x0398:
            java.lang.String r1 = "IMMediaGetChatSessionRequest JSONException"
            r3 = r55
            com.baidu.android.imsdk.utils.LogUtils.e(r3, r1, r0)
            r16 = 1010(0x3f2, float:1.415E-42)
            r0 = r16
        L_0x03a3:
            r1 = r57
            android.content.Context r3 = r1.mContext
            com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl r10 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.getInstance(r3)
            r3 = 1
            if (r6 != r3) goto L_0x03b0
            r12 = r3
            goto L_0x03b1
        L_0x03b0:
            r12 = 0
        L_0x03b1:
            int r13 = r1.readTotalUnreadnum(r7)
            java.lang.String r3 = r1.mKey
            r11 = r0
            r4 = r33
            r14 = r8
            r5 = r15
            r15 = r9
            r16 = r5
            r17 = r2
            r18 = r4
            r19 = r3
            r10.onMediaGetChatSessionRequest(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.chatmessage.request.IMMediaGetChatSessionRequest.onSuccess(int, byte[]):void");
    }

    public void onFailure(int errorCode, byte[] resultContent, Throwable tr) {
        Pair<Integer, String> tips = transErrorCode(errorCode, resultContent, tr);
        LogUtils.d(TAG, "onFailure error = " + tips.first + " errormsg = " + ((String) tips.second));
        ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(((Integer) tips.first).intValue(), false, 0, 0, 0, (Map<Long, ChatSession>) null, (Map<Long, ChatSession>) null, (Map<String, ChatSession>) null, this.mKey);
    }

    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/fetch_session";
    }

    private boolean isUsefulUnreadNum() {
        int i2 = this.mContactorType;
        return i2 < 0 || !(i2 == 2 || i2 == 10 || i2 == 27);
    }

    private int getClientUnreadnum() {
        return ChatMessageDBManager.getInstance(this.mContext).getNewMsgCountOfClass(11);
    }

    private int readTotalUnreadnum(int num) {
        if (!isUsefulUnreadNum()) {
            num = ChatSessionManagerImpl.getInstance(this.mContext).readServerUnreadNum();
        }
        return getClientUnreadnum() + num;
    }

    private void writeServerUnreadnum(int num) {
        if (isUsefulUnreadNum()) {
            ChatSessionManagerImpl.getInstance(this.mContext).writeServerUnreadnum(num, false);
        }
    }
}
