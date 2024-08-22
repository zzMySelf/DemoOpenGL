package com.baidu.android.imsdk.media.request;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IMBuildSessionListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.BIMGroupManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.media.SessionManager;
import com.baidu.android.imsdk.media.bean.GetSessionResult;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.pms.constants.PmsConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class IMFetchBusinessSessionMsg extends Message {
    public static final int REQ_TYPE_B_FETCH_MULTI_SESSION = 3;
    public static final int REQ_TYPE_B_FETCH_SINGLE_SESSION = 2;
    public static final int REQ_TYPE_C_FETCH_MULTI_SESSION = 5;
    public static final int REQ_TYPE_C_FETCH_SINGLE_SESSION = 4;
    public static final int REQ_TYPE_FETCH_BUSINESS_SESSION = 1;
    private static final String TAG = "IMFetchBusinessSessionMsg";
    /* access modifiers changed from: private */
    public int mAggrType;
    /* access modifiers changed from: private */
    public long mBeginTime;
    /* access modifiers changed from: private */
    public int mBusinessType;
    private long mContacterUk;
    Context mContext;
    /* access modifiers changed from: private */
    public int mCount;
    /* access modifiers changed from: private */
    public long mEndTime;
    /* access modifiers changed from: private */
    public int mMode;
    /* access modifiers changed from: private */
    public int mNeedTop;
    /* access modifiers changed from: private */
    public int mReason;
    int mRequestType;
    /* access modifiers changed from: private */
    public String mScreenKey;
    /* access modifiers changed from: private */
    public ScreenUbc.MethodInfo mScreenMethodInfo;
    int mSessionType;
    private long mSyncSessionVersion;
    long mToContacterPaUid;
    long mToContacterUk;
    int mToContacterUserType = -1;

    public IMFetchBusinessSessionMsg(Context context, int businessType, long contacterUk, long beginTime, long endTime, int count, int mode, int needtop, int sessionType, long syncSessionVersion, int reason, String key, String screenKey, int aggrType) {
        this.mContext = context;
        initCommonParameter(context);
        this.mBusinessType = businessType;
        this.mContacterUk = contacterUk;
        this.mBeginTime = beginTime;
        this.mEndTime = endTime;
        this.mCount = count;
        this.mMode = mode;
        this.mNeedTop = needtop;
        this.mSessionType = sessionType;
        this.mSyncSessionVersion = syncSessionVersion;
        this.mReason = reason;
        this.mScreenKey = screenKey;
        setListenerKey(key);
        this.mRequestType = isBusinessConsultType(this.mBusinessType) ? 1 : 3;
        this.mAggrType = aggrType;
        setType(206);
    }

    public IMFetchBusinessSessionMsg(Context context, int businessType, long contacterUk, String key, int toContacterUserType, long toContacterPaUid, long toContacterUk) {
        this.mContext = context;
        initCommonParameter(context);
        this.mBusinessType = businessType;
        this.mContacterUk = contacterUk;
        this.mToContacterUserType = toContacterUserType;
        this.mToContacterPaUid = toContacterPaUid;
        this.mToContacterUk = toContacterUk;
        setListenerKey(key);
        this.mRequestType = 2;
        setType(206);
    }

    public static IMFetchBusinessSessionMsg newInstance(Context context, Intent intent) {
        Intent intent2 = intent;
        if (intent2.hasExtra("contacter_user_type") && (intent2.hasExtra("contacter_pa_uid") || intent2.hasExtra("contacter_uk"))) {
            int toContacterUserType = intent2.getIntExtra("contacter_user_type", -1);
            long toContacterPaUid = intent2.getLongExtra("contacter_pa_uid", -1);
            long toContacterUk = intent2.getLongExtra("contacter_uk", -1);
            long imuk = intent2.getLongExtra("contacter", -1);
            return new IMFetchBusinessSessionMsg(context, intent2.getIntExtra("bussiness_type", -1), imuk, intent2.getStringExtra(Constants.EXTRA_LISTENER_ID), toContacterUserType, toContacterPaUid, toContacterUk);
        } else if (!intent2.hasExtra("count") || !intent2.hasExtra("bussiness_type")) {
            return null;
        } else {
            long longExtra = intent2.getLongExtra("contacter", -1);
            long longExtra2 = intent2.getLongExtra("msgid_begin", -1);
            long longExtra3 = intent2.getLongExtra("msgid_end", -1);
            return new IMFetchBusinessSessionMsg(context, intent2.getIntExtra("bussiness_type", -1), longExtra, longExtra2, longExtra3, intent2.getIntExtra("count", -1), intent2.getIntExtra(Constants.EXTRA_FETCH_SESSION_MODE, 0), intent2.getIntExtra(Constants.EXTRA_FETCH_SESSION_TOP, 1), intent2.getIntExtra("session_type", -1), intent2.getLongExtra(Constants.EXTRA_FETCH_SESSION_VERSION, -1), intent2.getIntExtra(Constants.EXTRA_TRIGGER_REASON, -1), intent2.getStringExtra(Constants.EXTRA_LISTENER_ID), intent2.getStringExtra(Constants.EXTRA_SCREEN_KEY), intent2.getIntExtra(Constants.EXTRA_FETCH_AGGR_TYPE, 0));
        }
    }

    /* access modifiers changed from: protected */
    public void buildBody() {
        if (isBusinessConsultType(this.mBusinessType)) {
            this.mBody = buildAdvisoryRequestParam();
        } else if (this.mRequestType == 2) {
            this.mBody = buildSingleMediaRequestParam();
        } else {
            this.mBody = buildCommonRequestParam();
        }
    }

    private String buildAdvisoryRequestParam() {
        JSONObject objMsg = new JSONObject();
        try {
            objMsg.put("method", getType());
            objMsg.put("appid", this.mAppid);
            objMsg.put("business_type", this.mBusinessType);
            objMsg.put("uk", this.mUk);
            objMsg.put("user_type", getUserType(this.mBusinessType));
            long j2 = this.mContacterUk;
            if (j2 > 0) {
                objMsg.put("to", j2);
            }
            objMsg.put("sort_update_time_us_begin", this.mBeginTime);
            objMsg.put("sort_update_time_us_end", this.mEndTime);
            objMsg.put("count", this.mCount);
            objMsg.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            objMsg.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
            int i2 = this.mSessionType;
            if (i2 >= 0) {
                objMsg.put("session_type", i2);
            }
            String result = objMsg.toString();
            LogUtils.d(TAG, "拉取咨询会话" + result);
            return result;
        } catch (JSONException e2) {
            LogUtils.e(TAG, "Exception ", e2);
            return null;
        }
    }

    private int getUserType(int businessType) {
        if (!AccountManagerImpl.getInstance(this.mContext).getMediaRole()) {
            return 0;
        }
        if (businessType == 3 || businessType == 0) {
            return 1;
        }
        return 0;
    }

    private String buildCommonRequestParam() {
        JSONObject objMsg = new JSONObject();
        try {
            objMsg.put("method", getType());
            objMsg.put("appid", this.mAppid);
            objMsg.put("business_type", this.mBusinessType);
            objMsg.put("uk", this.mUk);
            objMsg.put("user_type", getUserType(this.mBusinessType));
            objMsg.put("pa_uid", SessionManager.getInstance(this.mContext).getMeidaPaid());
            objMsg.put("sort_update_time_us_begin", this.mBeginTime);
            objMsg.put("sort_update_time_us_end", this.mEndTime);
            objMsg.put("count", this.mCount);
            objMsg.put("stranger_mode", this.mMode);
            int i2 = this.mAggrType;
            if (i2 > 0) {
                objMsg.put(Constants.EXTRA_AGGR_TYPE, i2);
            }
            if (this.mMode != 2) {
                objMsg.put("need_top", this.mNeedTop);
            }
            objMsg.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            objMsg.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
            if (BIMManager.weakIntervalTime > 0) {
                objMsg.put("weak_reminder_msgid_begin", (System.currentTimeMillis() - (BIMManager.weakIntervalTime * 1000)) * 1000);
            }
            long j2 = this.mSyncSessionVersion;
            if (j2 >= 0) {
                objMsg.put("session_version", j2);
            }
            int i3 = this.mToContacterUserType;
            if (i3 >= 0) {
                objMsg.put("contacter_user_type", i3);
            }
            long j3 = this.mToContacterUk;
            if (j3 > 0) {
                objMsg.put("contacter_uk", j3);
            }
            long j4 = this.mToContacterPaUid;
            if (j4 > 0) {
                objMsg.put("contacter_pa_uid", j4);
            }
            String result = objMsg.toString();
            LogUtils.d(TAG, "request param = " + result);
            LogUtils.d(TAG, "request param reason:" + this.mReason);
            return result;
        } catch (JSONException e2) {
            return null;
        }
    }

    public void handleMessageResult(Context context, JSONObject obj, int errorCode, String strMsg) {
        LogUtils.d(TAG, "handleMessageResult err : " + errorCode + ", msg :" + strMsg + ", method:" + getType() + ", reason:" + this.mReason + ", requestType:" + this.mRequestType + ", result = " + obj);
        super.handleMessageResult(context, obj, errorCode, strMsg);
        if (isBusinessConsultType(this.mBusinessType)) {
            TaskManager.getInstance(this.mContext).submitForNetWork(new AdvisorySessionResultTask(context, errorCode, strMsg, obj));
        } else if (isFetchSingleSessionType(this.mRequestType)) {
            TaskManager.getInstance(this.mContext).submitForNetWork(new SingleMediaSessionResultTask(context, errorCode, strMsg, obj));
        } else {
            TaskManager.getInstance(this.mContext).submitForNetWork(new SessionResultCommonParseTask(context, errorCode, strMsg, obj));
        }
    }

    private String buildSingleMediaRequestParam() {
        JSONObject objMsg = new JSONObject();
        try {
            objMsg.put("method", getType());
            objMsg.put("appid", this.mAppid);
            objMsg.put("business_type", this.mBusinessType);
            objMsg.put("uk", AccountManager.getUK(this.mContext));
            objMsg.put("user_type", getUserType(this.mBusinessType));
            int i2 = this.mToContacterUserType;
            if (i2 >= 0) {
                objMsg.put("contacter_user_type", i2);
            }
            objMsg.put("contacter_pa_uid", this.mToContacterPaUid);
            objMsg.put("contacter_uk", this.mToContacterUk);
            objMsg.put("pa_uid", SessionManager.getInstance(this.mContext).getMeidaPaid());
            objMsg.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            objMsg.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
            String result = objMsg.toString();
            LogUtils.d(TAG, "request param = " + result);
            return result;
        } catch (JSONException e2) {
            return null;
        }
    }

    private boolean isBusinessConsultType(int businessType) {
        return businessType == 27;
    }

    private boolean isFetchMultiSessionType(int requestType) {
        return requestType == 3 || requestType == 5;
    }

    private boolean isFetchSingleSessionType(int requestType) {
        return requestType == 2 || requestType == 4;
    }

    private class AdvisorySessionResultTask extends TaskManager.Task {
        private Context mContext;
        private int mError;
        private JSONObject mResponse;
        private String mStrMsg;

        public AdvisorySessionResultTask(Context context, int errorCode, String strMsg, JSONObject jsonObject) {
            this.mContext = context;
            this.mError = errorCode;
            this.mStrMsg = strMsg;
            this.mResponse = jsonObject;
        }

        public void run() {
            List<ChatSession> sessionList = null;
            int hasMore = 0;
            int totalUnreadUnm = 0;
            int errorCode = 0;
            JSONObject jSONObject = this.mResponse;
            if (jSONObject != null) {
                try {
                    errorCode = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
                    if (errorCode == 0) {
                        sessionList = IMFetchBusinessSessionMsg.this.parseBusinessSessions(this.mResponse.optJSONArray("sessions"));
                        hasMore = this.mResponse.getInt("has_more");
                        totalUnreadUnm = this.mResponse.getInt("consult_unread_num");
                    }
                } catch (JSONException e2) {
                    errorCode = 1005;
                    LogUtils.d(IMFetchBusinessSessionMsg.TAG, "FetchSessionTask exception");
                }
            }
            if (!TextUtils.isEmpty(IMFetchBusinessSessionMsg.this.mScreenKey)) {
                IMFetchBusinessSessionMsg iMFetchBusinessSessionMsg = IMFetchBusinessSessionMsg.this;
                ScreenUbc.MethodInfo unused = iMFetchBusinessSessionMsg.mScreenMethodInfo = Utility.getScreenMethodInfo(iMFetchBusinessSessionMsg.mScreenKey);
                try {
                    JSONObject body = new JSONObject(IMFetchBusinessSessionMsg.this.mBody);
                    if (body.has("client_logid")) {
                        IMFetchBusinessSessionMsg.this.mScreenMethodInfo.clientLogId = body.optString("client_logid");
                    }
                } catch (JSONException e3) {
                }
                Utility.addEventList(IMFetchBusinessSessionMsg.this.mScreenMethodInfo.eventList, "AdvisorySessionResultTask");
            }
            ChatSessionManagerImpl instance = ChatSessionManagerImpl.getInstance(this.mContext);
            boolean z = true;
            if (hasMore != 1) {
                z = false;
            }
            instance.onFetchBusiChatSessionResult(errorCode, z, totalUnreadUnm, sessionList, IMFetchBusinessSessionMsg.this.getListenerKey());
        }
    }

    private class SessionResultCommonParseTask extends TaskManager.Task {
        private Context mContext;
        private int mError;
        private JSONObject mResponse;
        private String mStrMsg;

        public SessionResultCommonParseTask(Context context, int errorCode, String strMsg, JSONObject jsonObject) {
            this.mContext = context;
            this.mError = errorCode;
            this.mStrMsg = strMsg;
            this.mResponse = jsonObject;
        }

        /* JADX WARNING: Removed duplicated region for block: B:39:0x00f3  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0134  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0161  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0207  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x020c A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r28 = this;
                r1 = r28
                java.lang.String r2 = "client_logid"
                java.lang.String r3 = "IMFetchBusinessSessionMsg"
                java.lang.String r0 = "SessionResultCommonParseTask start"
                com.baidu.android.imsdk.utils.LogUtils.d(r3, r0)
                r4 = 0
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r15 = r0
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r14 = r0
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r13 = r0
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r12 = r0
                r5 = 0
                r6 = -1
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = -1003(0xfffffffffffffc15, float:NaN)
                r16 = -1
                org.json.JSONObject r0 = r1.mResponse
                if (r0 == 0) goto L_0x0148
                r18 = r4
                java.lang.String r4 = "err_code"
                int r0 = r0.optInt(r4)     // Catch:{ Exception -> 0x00e2 }
                r11 = r0
                if (r11 != 0) goto L_0x00df
                org.json.JSONObject r0 = r1.mResponse     // Catch:{ Exception -> 0x00e2 }
                java.lang.String r4 = "sessions"
                org.json.JSONArray r0 = r0.optJSONArray(r4)     // Catch:{ Exception -> 0x00e2 }
                com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg r4 = com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg.this     // Catch:{ Exception -> 0x00e2 }
                java.util.List r4 = r4.parseBusinessSessions(r0)     // Catch:{ Exception -> 0x00e2 }
                r19 = r0
                org.json.JSONObject r0 = r1.mResponse     // Catch:{ Exception -> 0x00db }
                r18 = r4
                java.lang.String r4 = "has_more"
                int r0 = r0.optInt(r4)     // Catch:{ Exception -> 0x00e2 }
                r5 = r0
                org.json.JSONObject r0 = r1.mResponse     // Catch:{ Exception -> 0x00e2 }
                java.lang.String r4 = "total_unread_num"
                int r0 = r0.optInt(r4)     // Catch:{ Exception -> 0x00e2 }
                r6 = r0
                org.json.JSONObject r0 = r1.mResponse     // Catch:{ Exception -> 0x00e2 }
                java.lang.String r4 = "consult_unread_num"
                int r0 = r0.optInt(r4)     // Catch:{ Exception -> 0x00e2 }
                r7 = r0
                org.json.JSONObject r0 = r1.mResponse     // Catch:{ Exception -> 0x00d5 }
                java.lang.String r4 = "top_has_more"
                int r0 = r0.optInt(r4)     // Catch:{ Exception -> 0x00d5 }
                r8 = r0
                org.json.JSONObject r0 = r1.mResponse     // Catch:{ Exception -> 0x00cd }
                java.lang.String r4 = "stranger_unread_num"
                int r0 = r0.optInt(r4)     // Catch:{ Exception -> 0x00cd }
                r9 = r0
                org.json.JSONObject r0 = r1.mResponse     // Catch:{ Exception -> 0x00cd }
                java.lang.String r4 = "do_not_disturb_unread_number"
                int r0 = r0.optInt(r4)     // Catch:{ Exception -> 0x00cd }
                r10 = r0
                org.json.JSONObject r0 = r1.mResponse     // Catch:{ Exception -> 0x00cd }
                java.lang.String r4 = "session_version"
                r20 = r7
                r21 = r8
                r7 = -1
                long r7 = r0.optLong(r4, r7)     // Catch:{ Exception -> 0x00c5 }
                r16 = r7
                com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg r0 = com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg.this     // Catch:{ Exception -> 0x00c5 }
                int r0 = r0.mMode     // Catch:{ Exception -> 0x00c5 }
                r4 = 2
                if (r0 == r4) goto L_0x00be
                android.content.Context r0 = r1.mContext     // Catch:{ Exception -> 0x00c5 }
                com.baidu.android.imsdk.media.SessionManager r0 = com.baidu.android.imsdk.media.SessionManager.getInstance(r0)     // Catch:{ Exception -> 0x00c5 }
                r0.setTotalUnread(r6)     // Catch:{ Exception -> 0x00c5 }
                android.content.Context r0 = r1.mContext     // Catch:{ Exception -> 0x00c5 }
                com.baidu.android.imsdk.media.SessionManager r0 = com.baidu.android.imsdk.media.SessionManager.getInstance(r0)     // Catch:{ Exception -> 0x00c5 }
                r0.setStrangerUnread(r9)     // Catch:{ Exception -> 0x00c5 }
                android.content.Context r0 = r1.mContext     // Catch:{ Exception -> 0x00c5 }
                com.baidu.android.imsdk.media.SessionManager r0 = com.baidu.android.imsdk.media.SessionManager.getInstance(r0)     // Catch:{ Exception -> 0x00c5 }
                r0.setPrivateChatNoDisturbNum(r10)     // Catch:{ Exception -> 0x00c5 }
            L_0x00be:
                r4 = r18
                r7 = r20
                r8 = r21
                goto L_0x00e1
            L_0x00c5:
                r0 = move-exception
                r4 = r18
                r7 = r20
                r8 = r21
                goto L_0x00e5
            L_0x00cd:
                r0 = move-exception
                r20 = r7
                r21 = r8
                r4 = r18
                goto L_0x00e5
            L_0x00d5:
                r0 = move-exception
                r20 = r7
                r4 = r18
                goto L_0x00e5
            L_0x00db:
                r0 = move-exception
                r18 = r4
                goto L_0x00e5
            L_0x00df:
                r4 = r18
            L_0x00e1:
                goto L_0x00e7
            L_0x00e2:
                r0 = move-exception
                r4 = r18
            L_0x00e5:
                r11 = 1005(0x3ed, float:1.408E-42)
            L_0x00e7:
                com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg r0 = com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg.this
                java.lang.String r0 = r0.mScreenKey
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0134
                com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg r0 = com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg.this
                java.lang.String r18 = r0.mScreenKey
                r19 = r4
                com.baidu.android.imsdk.ubc.ScreenUbc$MethodInfo r4 = com.baidu.android.imsdk.utils.Utility.getScreenMethodInfo(r18)
                com.baidu.android.imsdk.ubc.ScreenUbc.MethodInfo unused = r0.mScreenMethodInfo = r4
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0120 }
                com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg r4 = com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg.this     // Catch:{ JSONException -> 0x0120 }
                java.lang.String r4 = r4.mBody     // Catch:{ JSONException -> 0x0120 }
                r0.<init>(r4)     // Catch:{ JSONException -> 0x0120 }
                boolean r4 = r0.has(r2)     // Catch:{ JSONException -> 0x0120 }
                if (r4 == 0) goto L_0x011f
                com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg r4 = com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg.this     // Catch:{ JSONException -> 0x0120 }
                com.baidu.android.imsdk.ubc.ScreenUbc$MethodInfo r4 = r4.mScreenMethodInfo     // Catch:{ JSONException -> 0x0120 }
                java.lang.String r2 = r0.optString(r2)     // Catch:{ JSONException -> 0x0120 }
                r4.clientLogId = r2     // Catch:{ JSONException -> 0x0120 }
            L_0x011f:
                goto L_0x0126
            L_0x0120:
                r0 = move-exception
                java.lang.String r2 = "mScreenKey exception "
                com.baidu.android.imsdk.utils.LogUtils.e(r3, r2, r0)
            L_0x0126:
                com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg r0 = com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg.this
                com.baidu.android.imsdk.ubc.ScreenUbc$MethodInfo r0 = r0.mScreenMethodInfo
                org.json.JSONArray r0 = r0.eventList
                java.lang.String r2 = "SessionResultCommonParseTask"
                com.baidu.android.imsdk.utils.Utility.addEventList(r0, r2)
                goto L_0x0136
            L_0x0134:
                r19 = r4
            L_0x0136:
                r0 = r5
                r2 = r6
                r18 = r10
                r4 = r19
                r19 = r11
                r11 = r8
                r26 = r16
                r16 = r7
                r17 = r9
                r9 = r26
                goto L_0x0159
            L_0x0148:
                r18 = r4
                r0 = r5
                r2 = r6
                r19 = r11
                r11 = r8
                r18 = r10
                r26 = r16
                r16 = r7
                r17 = r9
                r9 = r26
            L_0x0159:
                if (r4 == 0) goto L_0x0207
                int r6 = r4.size()
                if (r6 <= 0) goto L_0x0207
                java.util.Iterator r6 = r4.iterator()
            L_0x0165:
                boolean r7 = r6.hasNext()
                if (r7 == 0) goto L_0x0204
                java.lang.Object r7 = r6.next()
                com.baidu.android.imsdk.chatmessage.ChatSession r7 = (com.baidu.android.imsdk.chatmessage.ChatSession) r7
                int r8 = r7.getClassType()
                if (r8 <= 0) goto L_0x0186
                int r8 = r7.getClassType()
                r5 = 13
                if (r8 == r5) goto L_0x0186
                r12.add(r7)
                r21 = r2
                goto L_0x01fe
            L_0x0186:
                long r21 = r7.getPaid()
                r23 = 0
                int r5 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
                if (r5 <= 0) goto L_0x019e
                long r21 = r7.getPaid()
                java.lang.Long r5 = java.lang.Long.valueOf(r21)
                r15.put(r5, r7)
                r21 = r2
                goto L_0x01fe
            L_0x019e:
                int r5 = r7.getCategory()
                r8 = 1
                if (r5 != r8) goto L_0x01e9
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r8 = "SessionResultCommonParseTask-certDebug-session.contacter: "
                java.lang.StringBuilder r5 = r5.append(r8)
                r21 = r2
                long r1 = r7.getContacter()
                java.lang.StringBuilder r1 = r5.append(r1)
                java.lang.String r2 = ", name: "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = r7.getName()
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = ", session.cert: "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = r7.getCertification()
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.baidu.android.imsdk.utils.LogUtils.d(r3, r1)
                long r1 = r7.getContacter()
                java.lang.String r1 = java.lang.String.valueOf(r1)
                r13.put(r1, r7)
                goto L_0x01fe
            L_0x01e9:
                r21 = r2
                long r1 = r7.getContacterId()
                int r1 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
                if (r1 <= 0) goto L_0x01fe
                long r1 = r7.getContacterId()
                java.lang.Long r1 = java.lang.Long.valueOf(r1)
                r14.put(r1, r7)
            L_0x01fe:
                r1 = r28
                r2 = r21
                goto L_0x0165
            L_0x0204:
                r21 = r2
                goto L_0x0209
            L_0x0207:
                r21 = r2
            L_0x0209:
                r1 = 1
                if (r0 == r1) goto L_0x0211
                if (r11 != r1) goto L_0x020f
                goto L_0x0211
            L_0x020f:
                r5 = 0
                goto L_0x0212
            L_0x0211:
                r5 = r1
            L_0x0212:
                r1 = r5
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "SessionResultCommonParseTask-certDebug-realHasMore: "
                java.lang.StringBuilder r2 = r2.append(r5)
                java.lang.StringBuilder r2 = r2.append(r1)
                java.lang.String r5 = ";fetchSessionVersion："
                java.lang.StringBuilder r2 = r2.append(r5)
                java.lang.StringBuilder r2 = r2.append(r9)
                java.lang.String r2 = r2.toString()
                com.baidu.android.imsdk.utils.LogUtils.d(r3, r2)
                r2 = r28
                com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg r5 = com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg.this
                r6 = r19
                r7 = r9
                r22 = r9
                r9 = r1
                r10 = r11
                r3 = r11
                r11 = r15
                r20 = r12
                r12 = r14
                r24 = r13
                r25 = r14
                r14 = r20
                r5.completeSessionInfo(r6, r7, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg.SessionResultCommonParseTask.run():void");
        }
    }

    private class SingleMediaSessionResultTask extends TaskManager.Task {
        private Context mContext;
        private int mError;
        private JSONObject mResponse;
        private String mStrMsg;

        public SingleMediaSessionResultTask(Context context, int errorCode, String strMsg, JSONObject jsonObject) {
            this.mContext = context;
            this.mError = errorCode;
            this.mStrMsg = strMsg;
            this.mResponse = jsonObject;
        }

        public void run() {
            IMListener listener;
            GetSessionResult sessionResult;
            int errorCode;
            LogUtils.d(IMFetchBusinessSessionMsg.TAG, "SingleMediaSessionResultTask start");
            List<ChatSession> sessionList = null;
            JSONObject jSONObject = this.mResponse;
            if (jSONObject != null) {
                try {
                    errorCode = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
                    if (errorCode == 0) {
                        sessionList = IMFetchBusinessSessionMsg.this.parseBusinessSessions(this.mResponse.optJSONArray("sessions"));
                    }
                    sessionResult = new GetSessionResult();
                    sessionResult.sessionList = sessionList;
                    listener = ListenerManager.getInstance().removeListener(IMFetchBusinessSessionMsg.this.mListenerKey);
                    if (listener == null || !(listener instanceof BIMValuesCallBack)) {
                        return;
                    }
                } catch (Exception e2) {
                    errorCode = 1005;
                    sessionResult = new GetSessionResult();
                    sessionResult.sessionList = null;
                    listener = ListenerManager.getInstance().removeListener(IMFetchBusinessSessionMsg.this.mListenerKey);
                    if (listener == null || !(listener instanceof BIMValuesCallBack)) {
                        return;
                    }
                } catch (Throwable th2) {
                    GetSessionResult sessionResult2 = new GetSessionResult();
                    sessionResult2.sessionList = null;
                    IMListener listener2 = ListenerManager.getInstance().removeListener(IMFetchBusinessSessionMsg.this.mListenerKey);
                    if (listener2 != null && (listener2 instanceof BIMValuesCallBack)) {
                        ((BIMValuesCallBack) listener2).onResult(0, this.mStrMsg, sessionResult2, null);
                    }
                    throw th2;
                }
                ((BIMValuesCallBack) listener).onResult(errorCode, this.mStrMsg, sessionResult, null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x046d A[Catch:{ Exception -> 0x061d }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04fd A[Catch:{ Exception -> 0x061d }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0538 A[SYNTHETIC, Splitter:B:195:0x0538] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0626 A[SYNTHETIC, Splitter:B:221:0x0626] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x064b A[SYNTHETIC, Splitter:B:228:0x064b] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0200 A[SYNTHETIC, Splitter:B:56:0x0200] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0207 A[SYNTHETIC, Splitter:B:59:0x0207] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x022e A[Catch:{ Exception -> 0x0680 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0233 A[Catch:{ Exception -> 0x0680 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0245 A[SYNTHETIC, Splitter:B:82:0x0245] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x026f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.baidu.android.imsdk.chatmessage.ChatSession> parseBusinessSessions(org.json.JSONArray r63) {
        /*
            r62 = this;
            r1 = r62
            r2 = r63
            java.lang.String r3 = "desc_text"
            java.lang.String r4 = "desc"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "parseBusinessSessions start requestType:"
            java.lang.StringBuilder r0 = r0.append(r5)
            int r5 = r1.mRequestType
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "IMFetchBusinessSessionMsg"
            com.baidu.android.imsdk.utils.LogUtils.d(r5, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6 = r0
            if (r2 == 0) goto L_0x06b6
            int r0 = r63.length()
            if (r0 != 0) goto L_0x0035
            r9 = r1
            r4 = r6
            goto L_0x06b8
        L_0x0035:
            android.content.Context r0 = r1.mContext
            long r7 = com.baidu.android.imsdk.chatmessage.sync.SyncManager.getMinSyncMillisecondTime(r0)
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = "parseBusinessSessions-certDebug-minSyncSubtleTime = "
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.baidu.android.imsdk.utils.LogUtils.d(r5, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = "parseBusinessSessions-certDebug-size = "
            java.lang.StringBuilder r0 = r0.append(r9)
            int r9 = r63.length()
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.baidu.android.imsdk.utils.LogUtils.d(r5, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = "parseBusinessSessions  type: "
            java.lang.StringBuilder r0 = r0.append(r9)
            int r9 = r62.getType()
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r9 = ";obj"
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.baidu.android.imsdk.utils.LogUtils.d(r5, r0)
            r0 = 0
            r9 = r0
        L_0x0097:
            int r0 = r63.length()
            if (r9 >= r0) goto L_0x06b4
            org.json.JSONObject r0 = r2.getJSONObject(r9)     // Catch:{ Exception -> 0x0692 }
            r10 = r0
            java.lang.String r0 = "sort_update_time_us"
            long r11 = r10.optLong(r0)     // Catch:{ Exception -> 0x0692 }
            java.lang.String r0 = "contacter_uk"
            long r13 = r10.optLong(r0)     // Catch:{ Exception -> 0x0692 }
            java.lang.String r0 = "contacter_bduid"
            long r19 = r10.optLong(r0)     // Catch:{ Exception -> 0x0692 }
            java.lang.String r0 = "contacter_pa_uid"
            r22 = r13
            r13 = -1
            long r13 = r10.optLong(r0, r13)     // Catch:{ Exception -> 0x0692 }
            java.lang.String r0 = "unread_num"
            long r15 = r10.optLong(r0)     // Catch:{ Exception -> 0x0692 }
            java.lang.String r0 = "last_msgid"
            long r17 = r10.optLong(r0)     // Catch:{ Exception -> 0x0692 }
            r24 = r17
            java.lang.String r0 = "last_msgtype"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0692 }
            r32 = r0
            java.lang.String r0 = "last_content"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0692 }
            r33 = r0
            java.lang.String r0 = "last_time"
            long r17 = r10.optLong(r0)     // Catch:{ Exception -> 0x0692 }
            r34 = r17
            java.lang.String r0 = "pa_classtype"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0692 }
            r17 = r0
            java.lang.String r0 = "pa_classshow"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0692 }
            r36 = r0
            java.lang.String r0 = "pa_classavatar"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0692 }
            r37 = r0
            java.lang.String r0 = "pa_classtitle"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0692 }
            r38 = r0
            java.lang.String r0 = "is_top"
            r39 = r13
            r13 = 0
            long r26 = r10.optLong(r0, r13)     // Catch:{ Exception -> 0x0692 }
            int r0 = (r26 > r13 ? 1 : (r26 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x011a
            r0 = 1
            goto L_0x011b
        L_0x011a:
            r0 = 0
        L_0x011b:
            r43 = r0
            java.lang.String r0 = "block_timestamp"
            long r26 = r10.optLong(r0)     // Catch:{ Exception -> 0x0692 }
            r44 = r26
            java.lang.String r0 = "aggr_type"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0692 }
            r46 = r0
            java.lang.String r0 = "stranger_type"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0692 }
            r47 = r0
            r0 = 0
            r13 = 12
            r14 = r46
            if (r14 == r13) goto L_0x0147
            r13 = r47
            r2 = 1
            if (r13 != r2) goto L_0x0143
            goto L_0x0149
        L_0x0143:
            r2 = r0
            r0 = r17
            goto L_0x0150
        L_0x0147:
            r13 = r47
        L_0x0149:
            r2 = r14
            r0 = 1
            r61 = r2
            r2 = r0
            r0 = r61
        L_0x0150:
            r17 = r0
            java.lang.String r0 = "do_not_disturb"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0692 }
            r46 = r0
            r47 = r13
            r13 = 13
            if (r14 != r13) goto L_0x01d6
            r0 = r14
            java.lang.String r13 = "do_not_disturb_unread_num"
            r17 = r0
            r0 = 0
            int r13 = r10.optInt(r13, r0)     // Catch:{ Exception -> 0x01c8 }
            r0 = r13
            r13 = r46
            if (r13 != 0) goto L_0x017d
            if (r0 <= 0) goto L_0x017d
            r26 = 0
            int r18 = (r26 > r15 ? 1 : (r26 == r15 ? 0 : -1))
            if (r18 != 0) goto L_0x017d
            r15 = -1
            r46 = r14
            r14 = r15
            goto L_0x0187
        L_0x017d:
            r46 = r14
            r14 = 1
            if (r13 != r14) goto L_0x0186
            if (r0 <= 0) goto L_0x0186
            long r14 = (long) r0
            goto L_0x0187
        L_0x0186:
            r14 = r15
        L_0x0187:
            r48 = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bc }
            r9.<init>()     // Catch:{ Exception -> 0x01bc }
            r49 = r6
            java.lang.String r6 = "~~~~ parseBusinessSessions doNotDisturbUnreadNumber = "
            java.lang.StringBuilder r6 = r9.append(r6)     // Catch:{ Exception -> 0x01af }
            java.lang.StringBuilder r6 = r6.append(r0)     // Catch:{ Exception -> 0x01af }
            java.lang.String r9 = ", unreadNum = "
            java.lang.StringBuilder r6 = r6.append(r9)     // Catch:{ Exception -> 0x01af }
            java.lang.StringBuilder r6 = r6.append(r14)     // Catch:{ Exception -> 0x01af }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01af }
            com.baidu.android.imsdk.utils.LogUtils.d(r5, r6)     // Catch:{ Exception -> 0x01af }
            r6 = r17
            goto L_0x01e1
        L_0x01af:
            r0 = move-exception
            r9 = r1
            r55 = r3
            r54 = r4
            r1 = r5
            r57 = r7
            r4 = r49
            goto L_0x069e
        L_0x01bc:
            r0 = move-exception
            r9 = r1
            r55 = r3
            r54 = r4
            r1 = r5
            r4 = r6
            r57 = r7
            goto L_0x069e
        L_0x01c8:
            r0 = move-exception
            r48 = r9
            r9 = r1
            r55 = r3
            r54 = r4
            r1 = r5
            r4 = r6
            r57 = r7
            goto L_0x069e
        L_0x01d6:
            r49 = r6
            r48 = r9
            r13 = r46
            r46 = r14
            r14 = r15
            r6 = r17
        L_0x01e1:
            java.lang.String r0 = "chat_type"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0686 }
            r9 = r0
            java.lang.String r0 = "last_msg_bduid"
            long r16 = r10.optLong(r0)     // Catch:{ Exception -> 0x0686 }
            r50 = r16
            java.lang.String r0 = "last_msg_uk"
            long r16 = r10.optLong(r0)     // Catch:{ Exception -> 0x0686 }
            r52 = r16
            java.lang.String r0 = ""
            boolean r16 = r10.has(r4)     // Catch:{ Exception -> 0x0686 }
            if (r16 == 0) goto L_0x0207
            java.lang.String r16 = r10.optString(r4)     // Catch:{ Exception -> 0x01af }
            r0 = r16
            goto L_0x0213
        L_0x0207:
            boolean r16 = r10.has(r3)     // Catch:{ Exception -> 0x0686 }
            if (r16 == 0) goto L_0x0213
            java.lang.String r16 = r10.optString(r3)     // Catch:{ Exception -> 0x01af }
            r0 = r16
        L_0x0213:
            int r16 = r1.getCategory(r9)     // Catch:{ Exception -> 0x0686 }
            r54 = r16
            r55 = r3
            r3 = r54
            int r16 = r1.getAggBusinessType(r3, r6)     // Catch:{ Exception -> 0x0683 }
            r54 = r4
            java.lang.String r4 = "business_type"
            r17 = r14
            r14 = -1
            int r4 = r10.optInt(r4, r14)     // Catch:{ Exception -> 0x0680 }
            if (r4 <= r14) goto L_0x0233
            r16 = r4
            r15 = r16
            goto L_0x0235
        L_0x0233:
            r15 = r16
        L_0x0235:
            int r14 = r1.mRequestType     // Catch:{ Exception -> 0x0680 }
            boolean r14 = r1.isFetchMultiSessionType(r14)     // Catch:{ Exception -> 0x0680 }
            if (r14 == 0) goto L_0x026f
            r14 = 27
            if (r15 == r14) goto L_0x026f
            int r14 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r14 >= 0) goto L_0x026f
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0266 }
            r14.<init>()     // Catch:{ Exception -> 0x0266 }
            r56 = r4
            java.lang.String r4 = "parseBusinessSessions-certDebug-sortTime < minSyncSubtleTime："
            java.lang.StringBuilder r4 = r14.append(r4)     // Catch:{ Exception -> 0x0266 }
            java.lang.StringBuilder r4 = r4.append(r11)     // Catch:{ Exception -> 0x0266 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0266 }
            com.baidu.android.imsdk.utils.LogUtils.d(r5, r4)     // Catch:{ Exception -> 0x0266 }
            r9 = r1
            r1 = r5
            r57 = r7
            r4 = r49
            goto L_0x06a4
        L_0x0266:
            r0 = move-exception
            r9 = r1
            r1 = r5
            r57 = r7
            r4 = r49
            goto L_0x069e
        L_0x026f:
            r56 = r4
            java.lang.String r4 = "delete_status"
            r14 = -1
            int r4 = r10.optInt(r4, r14)     // Catch:{ Exception -> 0x0680 }
            r26 = r22
            r28 = 0
            int r14 = (r39 > r28 ? 1 : (r39 == r28 ? 0 : -1))
            if (r14 <= 0) goto L_0x0287
            r26 = r39
            r57 = r7
            r7 = r26
            goto L_0x028b
        L_0x0287:
            r57 = r7
            r7 = r26
        L_0x028b:
            android.content.Context r14 = r1.mContext     // Catch:{ Exception -> 0x067a }
            r30 = 0
            r26 = r14
            r27 = r3
            r28 = r32
            r29 = r15
            r31 = r33
            com.baidu.android.imsdk.chatmessage.messages.ChatMsg r14 = com.baidu.android.imsdk.internal.MessageParser.parseChatMsg(r26, r27, r28, r29, r30, r31)     // Catch:{ Exception -> 0x067a }
            boolean r16 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x067a }
            if (r16 == 0) goto L_0x02b4
            java.lang.String r16 = r1.getLastMsgDesc(r14)     // Catch:{ Exception -> 0x02ad }
            r0 = r16
            r26 = r10
            r10 = r0
            goto L_0x02b7
        L_0x02ad:
            r0 = move-exception
            r9 = r1
            r1 = r5
            r4 = r49
            goto L_0x069e
        L_0x02b4:
            r26 = r10
            r10 = r0
        L_0x02b7:
            r16 = r15
            r15 = 1
            if (r3 != r15) goto L_0x02f2
            android.content.Context r0 = r1.mContext     // Catch:{ Exception -> 0x02ad }
            com.baidu.android.imsdk.group.GroupMessageManagerImpl r0 = com.baidu.android.imsdk.group.GroupMessageManagerImpl.getInstance(r0)     // Catch:{ Exception -> 0x02ad }
            boolean r0 = r0.isGroupNeedRetain(r14, r4, r7)     // Catch:{ Exception -> 0x02ad }
            if (r0 != 0) goto L_0x02eb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ad }
            r0.<init>()     // Catch:{ Exception -> 0x02ad }
            java.lang.String r15 = "parseBusinessSessions-certDebug-invalid group: "
            java.lang.StringBuilder r0 = r0.append(r15)     // Catch:{ Exception -> 0x02ad }
            r27 = r13
            r28 = r14
            r13 = r22
            java.lang.StringBuilder r0 = r0.append(r13)     // Catch:{ Exception -> 0x02ad }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02ad }
            com.baidu.android.imsdk.utils.LogUtils.d(r5, r0)     // Catch:{ Exception -> 0x02ad }
            r9 = r1
            r1 = r5
            r4 = r49
            goto L_0x06a4
        L_0x02eb:
            r27 = r13
            r28 = r14
            r13 = r22
            goto L_0x02f8
        L_0x02f2:
            r27 = r13
            r28 = r14
            r13 = r22
        L_0x02f8:
            com.baidu.android.imsdk.chatmessage.ChatSession r0 = new com.baidu.android.imsdk.chatmessage.ChatSession     // Catch:{ Exception -> 0x067a }
            java.lang.String r21 = ""
            r23 = r4
            r22 = r5
            r1 = r16
            r4 = r17
            r15 = r0
            r16 = r3
            r17 = r7
            r15.<init>(r16, r17, r19, r21)     // Catch:{ Exception -> 0x0674 }
            r15 = r0
            r15.setChatType(r9)     // Catch:{ Exception -> 0x0674 }
            r15.setLastMsg(r10)     // Catch:{ Exception -> 0x0674 }
            r15.setNewMsgSum(r4)     // Catch:{ Exception -> 0x0674 }
            r17 = r4
            r4 = r32
            r15.setLastMsgType(r4)     // Catch:{ Exception -> 0x0674 }
            r16 = r4
            r4 = r24
            r15.setLastMsgId(r4)     // Catch:{ Exception -> 0x0674 }
            r24 = r4
            r4 = r34
            r15.setLastMsgTime(r4)     // Catch:{ Exception -> 0x0674 }
            r29 = r4
            r4 = r36
            r15.setClassShow(r4)     // Catch:{ Exception -> 0x0674 }
            r15.setClassType(r6)     // Catch:{ Exception -> 0x0674 }
            r5 = r37
            r15.setClassAvatar(r5)     // Catch:{ Exception -> 0x0674 }
            r21 = r4
            r4 = r38
            r15.setClassTitle(r4)     // Catch:{ Exception -> 0x0674 }
            r15.setBusinessType(r1)     // Catch:{ Exception -> 0x0674 }
            r31 = 0
            int r0 = (r39 > r31 ? 1 : (r39 == r31 ? 0 : -1))
            if (r0 <= 0) goto L_0x035d
            r32 = r4
            r31 = r5
            r4 = r39
            r15.setPaid(r4)     // Catch:{ Exception -> 0x0354 }
            goto L_0x0363
        L_0x0354:
            r0 = move-exception
            r9 = r62
            r1 = r22
            r4 = r49
            goto L_0x069e
        L_0x035d:
            r32 = r4
            r31 = r5
            r4 = r39
        L_0x0363:
            r34 = r1
            r1 = r43
            r15.setMarkTop(r1)     // Catch:{ Exception -> 0x0674 }
            r39 = r4
            r4 = r44
            r15.setShieldTime(r4)     // Catch:{ Exception -> 0x0674 }
            r15.setSortTime(r11)     // Catch:{ Exception -> 0x0674 }
            r15.setIsStranger(r2)     // Catch:{ Exception -> 0x0674 }
            r0 = 0
            r15.setState(r0)     // Catch:{ Exception -> 0x0674 }
            r35 = r1
            r1 = 1
            r15.setIsClicked(r1)     // Catch:{ Exception -> 0x0674 }
            r1 = r27
            r15.setDisturb(r1)     // Catch:{ Exception -> 0x0674 }
            r15.setContacterImuk(r13)     // Catch:{ Exception -> 0x0674 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0674 }
            r0.<init>()     // Catch:{ Exception -> 0x0674 }
            r27 = r1
            java.lang.String r1 = "remote session:"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x0674 }
            java.lang.StringBuilder r0 = r0.append(r15)     // Catch:{ Exception -> 0x0674 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0674 }
            r1 = r22
            com.baidu.android.imsdk.utils.LogUtils.d(r1, r0)     // Catch:{ Exception -> 0x0670 }
            r22 = r2
            r2 = 1
            if (r3 != r2) goto L_0x0522
            r36 = r4
            r4 = r50
            r15.setLastMsgUid(r4)     // Catch:{ Exception -> 0x051b }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x043b }
            r2 = r33
            r0.<init>(r2)     // Catch:{ JSONException -> 0x042d }
            r33 = r2
            java.lang.String r2 = "ext"
            org.json.JSONObject r2 = r0.optJSONObject(r2)     // Catch:{ JSONException -> 0x043b }
            r38 = 0
            if (r2 == 0) goto L_0x03db
            r43 = r0
            java.lang.String r0 = "group_member_name"
            java.lang.String r0 = r2.optString(r0)     // Catch:{ JSONException -> 0x03ce }
            r38 = r0
            goto L_0x03df
        L_0x03ce:
            r0 = move-exception
            r38 = r9
            r44 = r10
            r50 = r11
            r12 = r34
            r9 = r62
            goto L_0x0446
        L_0x03db:
            r43 = r0
            r0 = r38
        L_0x03df:
            java.lang.String r38 = r15.getLastMsg()     // Catch:{ JSONException -> 0x043b }
            boolean r38 = android.text.TextUtils.isEmpty(r38)     // Catch:{ JSONException -> 0x043b }
            if (r38 != 0) goto L_0x0420
            r38 = r9
            r44 = r10
            r9 = 0
            int r41 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r41 <= 0) goto L_0x0417
            r9 = r62
            r10 = r34
            r34 = r2
            android.content.Context r2 = r9.mContext     // Catch:{ JSONException -> 0x0412 }
            java.lang.String r2 = com.baidu.android.imsdk.account.AccountManager.getUid(r2)     // Catch:{ JSONException -> 0x0412 }
            r50 = r11
            r12 = r10
            r10 = 0
            long r59 = com.baidu.android.imsdk.utils.Utility.getLongByString(r2, r10)     // Catch:{ JSONException -> 0x0410 }
            int r2 = (r4 > r59 ? 1 : (r4 == r59 ? 0 : -1))
            if (r2 == 0) goto L_0x042c
            r15.setLastMsgSenderName(r0)     // Catch:{ JSONException -> 0x0410 }
            goto L_0x042c
        L_0x0410:
            r0 = move-exception
            goto L_0x0446
        L_0x0412:
            r0 = move-exception
            r50 = r11
            r12 = r10
            goto L_0x0446
        L_0x0417:
            r9 = r62
            r50 = r11
            r12 = r34
            r34 = r2
            goto L_0x042c
        L_0x0420:
            r38 = r9
            r44 = r10
            r50 = r11
            r12 = r34
            r9 = r62
            r34 = r2
        L_0x042c:
            goto L_0x0460
        L_0x042d:
            r0 = move-exception
            r33 = r2
            r38 = r9
            r44 = r10
            r50 = r11
            r12 = r34
            r9 = r62
            goto L_0x0446
        L_0x043b:
            r0 = move-exception
            r38 = r9
            r44 = r10
            r50 = r11
            r12 = r34
            r9 = r62
        L_0x0446:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061d }
            r2.<init>()     // Catch:{ Exception -> 0x061d }
            java.lang.String r10 = "JSON PARSER ERROR: "
            java.lang.StringBuilder r2 = r2.append(r10)     // Catch:{ Exception -> 0x061d }
            java.lang.String r10 = r0.getMessage()     // Catch:{ Exception -> 0x061d }
            java.lang.StringBuilder r2 = r2.append(r10)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x061d }
            com.baidu.android.imsdk.utils.LogUtils.e(r1, r2)     // Catch:{ Exception -> 0x061d }
        L_0x0460:
            android.content.Context r0 = r9.mContext     // Catch:{ Exception -> 0x061d }
            com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager r0 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.getInstance(r0)     // Catch:{ Exception -> 0x061d }
            r2 = 1
            com.baidu.android.imsdk.chatmessage.ChatSession r0 = r0.getChatRecord(r2, r7)     // Catch:{ Exception -> 0x061d }
            if (r0 == 0) goto L_0x04fd
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061d }
            r2.<init>()     // Catch:{ Exception -> 0x061d }
            java.lang.String r10 = "local session:"
            java.lang.StringBuilder r2 = r2.append(r10)     // Catch:{ Exception -> 0x061d }
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x061d }
            com.baidu.android.imsdk.utils.LogUtils.d(r1, r2)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r0.getName()     // Catch:{ Exception -> 0x061d }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x061d }
            if (r2 != 0) goto L_0x0494
            java.lang.String r2 = r0.getName()     // Catch:{ Exception -> 0x061d }
            r15.setName(r2)     // Catch:{ Exception -> 0x061d }
        L_0x0494:
            long r10 = r0.getNewMsgSum()     // Catch:{ Exception -> 0x061d }
            r15.setNewMsgSum(r10)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r0.getLastMsg()     // Catch:{ Exception -> 0x061d }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x061d }
            if (r2 != 0) goto L_0x04ac
            java.lang.String r2 = r0.getLastMsg()     // Catch:{ Exception -> 0x061d }
            r15.setLastMsg(r2)     // Catch:{ Exception -> 0x061d }
        L_0x04ac:
            long r17 = r0.getLastMsgId()     // Catch:{ Exception -> 0x061d }
            r41 = 0
            int r2 = (r17 > r41 ? 1 : (r17 == r41 ? 0 : -1))
            if (r2 <= 0) goto L_0x04c0
            r59 = r4
            long r4 = r0.getLastMsgId()     // Catch:{ Exception -> 0x061d }
            r15.setLastMsgId(r4)     // Catch:{ Exception -> 0x061d }
            goto L_0x04c2
        L_0x04c0:
            r59 = r4
        L_0x04c2:
            java.lang.String r2 = r0.getLastMsgSenderName()     // Catch:{ Exception -> 0x061d }
            r15.setLastMsgSenderName(r2)     // Catch:{ Exception -> 0x061d }
            int r2 = r0.getRemindType()     // Catch:{ Exception -> 0x061d }
            r15.setRemindType(r2)     // Catch:{ Exception -> 0x061d }
            long r4 = r0.getRemindMsgid()     // Catch:{ Exception -> 0x061d }
            r15.setRemindMsgId(r4)     // Catch:{ Exception -> 0x061d }
            long r4 = r0.getRemindUid()     // Catch:{ Exception -> 0x061d }
            r15.setRemindUid(r4)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r0.getRemindRoleDisplayName()     // Catch:{ Exception -> 0x061d }
            r15.setRemindRoleDisplayName(r2)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r0.getExt()     // Catch:{ Exception -> 0x061d }
            r15.setExt(r2)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r0.getCertification()     // Catch:{ Exception -> 0x061d }
            r15.setCertification(r2)     // Catch:{ Exception -> 0x061d }
            int r2 = r0.getDisturb()     // Catch:{ Exception -> 0x061d }
            r15.setDisturb(r2)     // Catch:{ Exception -> 0x061d }
            r17 = r10
            goto L_0x0530
        L_0x04fd:
            r59 = r4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061d }
            r2.<init>()     // Catch:{ Exception -> 0x061d }
            java.lang.String r4 = "parseBusinessSessions-certDebug-localCSession is null, session.contacter: "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Exception -> 0x061d }
            long r4 = r15.getContacter()     // Catch:{ Exception -> 0x061d }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x061d }
            com.baidu.android.imsdk.utils.LogUtils.d(r1, r2)     // Catch:{ Exception -> 0x061d }
            goto L_0x0530
        L_0x051b:
            r0 = move-exception
            r9 = r62
            r4 = r49
            goto L_0x069e
        L_0x0522:
            r36 = r4
            r38 = r9
            r44 = r10
            r59 = r50
            r9 = r62
            r50 = r11
            r12 = r34
        L_0x0530:
            int r0 = r9.mRequestType     // Catch:{ Exception -> 0x066e }
            boolean r0 = r9.isFetchMultiSessionType(r0)     // Catch:{ Exception -> 0x066e }
            if (r0 == 0) goto L_0x0622
            android.content.Context r0 = r9.mContext     // Catch:{ Exception -> 0x061d }
            com.baidu.android.imsdk.media.db.SessionDBManager r0 = com.baidu.android.imsdk.media.db.SessionDBManager.getInstance(r0)     // Catch:{ Exception -> 0x061d }
            com.baidu.android.imsdk.chatmessage.ChatSession r0 = r0.getChatRecord(r3, r7)     // Catch:{ Exception -> 0x061d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061d }
            r2.<init>()     // Catch:{ Exception -> 0x061d }
            java.lang.String r4 = "parseBusinessSessions  local session:"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Exception -> 0x061d }
            if (r0 != 0) goto L_0x0554
            java.lang.String r4 = "null"
            goto L_0x0558
        L_0x0554:
            java.lang.String r4 = r0.toString()     // Catch:{ Exception -> 0x061d }
        L_0x0558:
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x061d }
            com.baidu.android.imsdk.utils.LogUtils.d(r1, r2)     // Catch:{ Exception -> 0x061d }
            if (r0 == 0) goto L_0x05e5
            long r4 = r0.getLastMsgId()     // Catch:{ Exception -> 0x061d }
            long r10 = r15.getLastMsgTime()     // Catch:{ Exception -> 0x061d }
            long r41 = r0.getLastMsgTime()     // Catch:{ Exception -> 0x061d }
            int r2 = (r10 > r41 ? 1 : (r10 == r41 ? 0 : -1))
            if (r2 >= 0) goto L_0x05b9
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061d }
            r2.<init>()     // Catch:{ Exception -> 0x061d }
            java.lang.String r10 = "parseBusinessSessions  session lastMsgId is low, remote lastMsgId:"
            java.lang.StringBuilder r2 = r2.append(r10)     // Catch:{ Exception -> 0x061d }
            long r10 = r15.getLastMsgId()     // Catch:{ Exception -> 0x061d }
            java.lang.StringBuilder r2 = r2.append(r10)     // Catch:{ Exception -> 0x061d }
            java.lang.String r10 = ";local lastMsgId:"
            java.lang.StringBuilder r2 = r2.append(r10)     // Catch:{ Exception -> 0x061d }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x061d }
            com.baidu.android.imsdk.utils.LogUtils.d(r1, r2)     // Catch:{ Exception -> 0x061d }
            r15.setLastMsgId(r4)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r0.getLastMsg()     // Catch:{ Exception -> 0x061d }
            r15.setLastMsg(r2)     // Catch:{ Exception -> 0x061d }
            long r10 = r0.getLastMsgTime()     // Catch:{ Exception -> 0x061d }
            r15.setLastMsgTime(r10)     // Catch:{ Exception -> 0x061d }
            long r10 = r0.getLastMsgUid()     // Catch:{ Exception -> 0x061d }
            r15.setLastMsgUid(r10)     // Catch:{ Exception -> 0x061d }
            int r2 = r0.getLastMsgType()     // Catch:{ Exception -> 0x061d }
            r15.setLastMsgType(r2)     // Catch:{ Exception -> 0x061d }
        L_0x05b9:
            android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x061d }
            boolean r2 = com.baidu.android.imsdk.media.SessionManager.needUseRemoteNewMsgUnread(r2, r15)     // Catch:{ Exception -> 0x061d }
            if (r2 != 0) goto L_0x05c8
            long r10 = r0.getNewMsgSum()     // Catch:{ Exception -> 0x061d }
            r15.setNewMsgSum(r10)     // Catch:{ Exception -> 0x061d }
        L_0x05c8:
            java.lang.String r2 = r0.getHighlightDesc()     // Catch:{ Exception -> 0x061d }
            r15.setHighlightDesc(r2)     // Catch:{ Exception -> 0x061d }
            int r2 = r0.getHighlightPriority()     // Catch:{ Exception -> 0x061d }
            r15.setHighlightPriority(r2)     // Catch:{ Exception -> 0x061d }
            int r2 = r0.getHighlightDataId()     // Catch:{ Exception -> 0x061d }
            r15.setHighlightDataId(r2)     // Catch:{ Exception -> 0x061d }
            long r10 = r0.getLastMsgIdFromMe()     // Catch:{ Exception -> 0x061d }
            r15.setLastMsgIdFromMe(r10)     // Catch:{ Exception -> 0x061d }
            goto L_0x0605
        L_0x05e5:
            android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x061d }
            boolean r2 = com.baidu.android.imsdk.media.SessionManager.needUseRemoteNewMsgUnread(r2, r15)     // Catch:{ Exception -> 0x061d }
            if (r2 != 0) goto L_0x0605
            int r2 = r15.getClassType()     // Catch:{ Exception -> 0x061d }
            r4 = 13
            if (r2 != r4) goto L_0x05ff
            android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x061d }
            com.baidu.android.imsdk.media.SessionManager r2 = com.baidu.android.imsdk.media.SessionManager.getInstance(r2)     // Catch:{ Exception -> 0x061d }
            r2.checkGfhAggrSession(r15)     // Catch:{ Exception -> 0x061d }
            goto L_0x0606
        L_0x05ff:
            r4 = 0
            r15.setNewMsgSum(r4)     // Catch:{ Exception -> 0x061d }
            goto L_0x0606
        L_0x0605:
        L_0x0606:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061d }
            r2.<init>()     // Catch:{ Exception -> 0x061d }
            java.lang.String r4 = "aligned session:"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Exception -> 0x061d }
            java.lang.StringBuilder r2 = r2.append(r15)     // Catch:{ Exception -> 0x061d }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x061d }
            com.baidu.android.imsdk.utils.LogUtils.d(r1, r2)     // Catch:{ Exception -> 0x061d }
            goto L_0x0622
        L_0x061d:
            r0 = move-exception
            r4 = r49
            goto L_0x069e
        L_0x0622:
            boolean r0 = com.baidu.android.imsdk.BIMManager.hudongTop     // Catch:{ Exception -> 0x066e }
            if (r0 == 0) goto L_0x0647
            int r0 = r15.getClassType()     // Catch:{ Exception -> 0x061d }
            r2 = 11
            if (r0 != r2) goto L_0x0647
            r4 = 9223372036854774807(0x7ffffffffffffc17, double:NaN)
            r15.setMarkTopTime(r4)     // Catch:{ Exception -> 0x061d }
            r2 = 1
            r15.setMarkTop(r2)     // Catch:{ Exception -> 0x061d }
            java.lang.String r0 = "im_session_extra_interact_ext_key"
            java.lang.String r2 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.getInteractiveSessionExt(r28)     // Catch:{ Exception -> 0x061d }
            r15.addExt(r0, r2)     // Catch:{ Exception -> 0x061d }
            r9.updateAggSessionFromServerWithCSession(r15, r6)     // Catch:{ Exception -> 0x061d }
            goto L_0x065f
        L_0x0647:
            boolean r0 = com.baidu.android.imsdk.BIMManager.consultTop     // Catch:{ Exception -> 0x066e }
            if (r0 == 0) goto L_0x065f
            int r0 = r15.getClassType()     // Catch:{ Exception -> 0x061d }
            r2 = 10
            if (r0 != r2) goto L_0x065f
            r4 = 9223372036854773807(0x7ffffffffffff82f, double:NaN)
            r15.setMarkTopTime(r4)     // Catch:{ Exception -> 0x061d }
            r2 = 1
            r15.setMarkTop(r2)     // Catch:{ Exception -> 0x061d }
        L_0x065f:
            r2 = r26
            com.baidu.android.imsdk.chatmessage.ChatSession r0 = r9.addAdvisoryValue(r2, r15)     // Catch:{ Exception -> 0x066e }
            r4 = r49
            r4.add(r0)     // Catch:{ Exception -> 0x066c }
            goto L_0x06a4
        L_0x066c:
            r0 = move-exception
            goto L_0x069e
        L_0x066e:
            r0 = move-exception
            goto L_0x067d
        L_0x0670:
            r0 = move-exception
            r9 = r62
            goto L_0x067d
        L_0x0674:
            r0 = move-exception
            r9 = r62
            r1 = r22
            goto L_0x067d
        L_0x067a:
            r0 = move-exception
            r9 = r1
            r1 = r5
        L_0x067d:
            r4 = r49
            goto L_0x069e
        L_0x0680:
            r0 = move-exception
            r9 = r1
            goto L_0x068c
        L_0x0683:
            r0 = move-exception
            r9 = r1
            goto L_0x068a
        L_0x0686:
            r0 = move-exception
            r9 = r1
            r55 = r3
        L_0x068a:
            r54 = r4
        L_0x068c:
            r1 = r5
            r57 = r7
            r4 = r49
            goto L_0x069e
        L_0x0692:
            r0 = move-exception
            r55 = r3
            r54 = r4
            r4 = r6
            r57 = r7
            r48 = r9
            r9 = r1
            r1 = r5
        L_0x069e:
            java.lang.String r2 = "parseBusinessSessions-certDebug-exception "
            com.baidu.android.imsdk.utils.LogUtils.e(r1, r2, r0)
        L_0x06a4:
            int r0 = r48 + 1
            r2 = r63
            r5 = r1
            r6 = r4
            r1 = r9
            r4 = r54
            r3 = r55
            r7 = r57
            r9 = r0
            goto L_0x0097
        L_0x06b4:
            r4 = r6
            return r4
        L_0x06b6:
            r9 = r1
            r4 = r6
        L_0x06b8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg.parseBusinessSessions(org.json.JSONArray):java.util.List");
    }

    private int getAggBusinessType(int category, int classType) {
        if (category == 1) {
            return 2;
        }
        if (category == 9) {
            return 27;
        }
        if (classType == 11) {
            return 10;
        }
        if (classType == 9) {
            return 29;
        }
        if (classType == 10) {
            return 27;
        }
        return 3;
    }

    private int getCategory(int chattype) {
        if (isBusinessConsultType(this.mBusinessType)) {
            return 9;
        }
        if (chattype == 57 || chattype == 3) {
            return 1;
        }
        if (chattype == 58) {
            return 9;
        }
        return 0;
    }

    private ChatSession addAdvisoryValue(JSONObject object, ChatSession session) {
        JSONObject jSONObject = object;
        ChatSession chatSession = session;
        if (jSONObject == null || chatSession == null || this.mBusinessType != 27) {
            return chatSession;
        }
        try {
            int sessionType = jSONObject.getInt("session_type");
            long dialogId = jSONObject.optLong(TableDefine.BusiSessionColumns.COLUMN_LAST_DIALOGUE_ID);
            String businessExt = jSONObject.optString("last_dialogue_business_ext");
            String resourceId = jSONObject.optString(TableDefine.BusiSessionColumns.COLUMN_LAST_RESOURCE_ID);
            int aidType = jSONObject.optInt("aid_type");
            int lastDialogueStatus = jSONObject.optInt("status");
            long lastAskUk = jSONObject.optLong(TableDefine.BusiSessionColumns.COLUMN_LAST_ASK_UK);
            long lastAnswerUk = jSONObject.optLong(TableDefine.BusiSessionColumns.COLUMN_LAST_ANSWER_UK);
            String desc = jSONObject.optString("desc");
            String lastStatusShow = jSONObject.optString(TableDefine.BusiSessionColumns.COLUMN_STATUS_SHOW);
            String businessExt2 = businessExt;
            int followStatus = jSONObject.optInt("follow_state", 0);
            int collectState = jSONObject.optInt("consult_collect_state");
            chatSession.setDesc(desc);
            chatSession.setLastStatusShow(lastStatusShow);
            chatSession.setSessionType(sessionType);
            chatSession.setLastDialogueId(dialogId);
            chatSession.setLastResourceId(resourceId);
            chatSession.setAidType(aidType);
            chatSession.setLastDialogueStatus(lastDialogueStatus);
            chatSession.setLastAnswerUk(lastAnswerUk);
            chatSession.setLastAskUk(lastAskUk);
            int i2 = sessionType;
            chatSession.setBusinessType(27);
            chatSession.setSubscribe(followStatus);
            chatSession.setCollectState(collectState);
            chatSession.setExt(businessExt2);
        } catch (Exception e2) {
        }
        return chatSession;
    }

    private String getLastMsgDesc(ChatMsg msg) {
        if (msg == null) {
            return "";
        }
        String lastMsg = msg.getRecommendDescription();
        LogUtils.w(TAG, "getLastMsgDesc Description:" + lastMsg);
        if (!TextUtils.isEmpty(msg.getPreviewDesc())) {
            return msg.getPreviewDesc();
        }
        return lastMsg;
    }

    /* access modifiers changed from: private */
    public void completeSessionInfo(int resultCode, long versionCode, boolean hasMore, int topHasMore, Map<Long, ChatSession> paMap, Map<Long, ChatSession> userMap, Map<String, ChatSession> groupMap, List<ChatSession> classSessions) {
        IGetUsersProfileBatchListener userListener;
        ArrayList<Long> pauids;
        ArrayList<String> groupids;
        ArrayList<Long> bduids;
        IGetUsersProfileBatchListener userListener2;
        ArrayList<Long> bduids2;
        ArrayList<Long> pauids2;
        ArrayList<String> groupids2;
        boolean z;
        int i2 = resultCode;
        Map<Long, ChatSession> map = paMap;
        Map<Long, ChatSession> map2 = userMap;
        Map<String, ChatSession> map3 = groupMap;
        CompleteSessionInfoListener listener = new CompleteSessionInfoListener(resultCode, versionCode, hasMore, topHasMore, classSessions);
        IMBuildSessionListener buildSessionListener = new IMBuildSessionListener(this.mContext, listener);
        if (i2 == 0) {
            ArrayList<String> groupids3 = null;
            ArrayList<Long> bduids3 = null;
            ArrayList<Long> pauids3 = null;
            IGetUsersProfileBatchListener userListener3 = null;
            IGetPaInfosListener paListener = null;
            BIMValueCallBack<ArrayList<GroupInfo>> groupListener = null;
            if (classSessions == null || classSessions.size() <= 0) {
                groupids = null;
                bduids = null;
                pauids = null;
                userListener = null;
            } else {
                Iterator<ChatSession> it = classSessions.iterator();
                while (it.hasNext()) {
                    ChatSession classSession = it.next();
                    if (classSession != null) {
                        ArrayList<String> groupids4 = groupids3;
                        if (classSession.getIsStranger() == 1) {
                            IGetUsersProfileBatchListener iGetUsersProfileBatchListener = userListener3;
                            Iterator<ChatSession> it2 = it;
                            ArrayList<Long> arrayList = bduids3;
                            groupids3 = groupids4;
                            it = it2;
                        } else if (classSession.getClassType() == 12) {
                            groupids3 = groupids4;
                        } else if (classSession.getBusinessType() == 27) {
                            SessionManager.getInstance(this.mContext).handleConsultUnreadNum(classSession);
                            Iterator<ChatSession> it3 = it;
                            int gfhUnread = ChatMsgManager.getAdvisoryGfhUnReadMsgCount(this.mContext, 0);
                            ArrayList<Long> bduids4 = bduids3;
                            ArrayList<Long> pauids4 = pauids3;
                            IGetUsersProfileBatchListener userListener4 = userListener3;
                            List<ChatSession> gfhSession = ChatSessionManagerImpl.getInstance(this.mContext).getSessionByGfhPA(27, 0);
                            List<ChatSession> busiSession = ChatSessionManagerImpl.getInstance(this.mContext).getNewAdvisoryChatSessions(27, -1, 0, 0, Long.MAX_VALUE, -1, 1, gfhUnread);
                            Pair<ChatSession, Boolean> pair = ChatSessionManagerImpl.getInstance(this.mContext).getAndCompareLastBusiSession(27, busiSession, gfhSession, gfhUnread);
                            ChatSession newSession = (ChatSession) pair.first;
                            int i3 = gfhUnread;
                            boolean isGfhSession = ((Boolean) pair.second).booleanValue();
                            if (newSession != null) {
                                List<ChatSession> list = gfhSession;
                                List<ChatSession> list2 = busiSession;
                                LogUtils.d(TAG, "notifyBusiSessionChange newSession = " + newSession.toString());
                                ChatSessionManagerImpl.getInstance(this.mContext).updateLastBusiSession(newSession, isGfhSession);
                                if (isGfhSession) {
                                    classSession.setClassShow(1);
                                    classSession.setCategory(9);
                                    classSession.setChatType(58);
                                }
                                classSession.setLastMsg(newSession.getLastMsg());
                                classSession.setExt(newSession.getExt());
                                classSession.setLastMsgSenderName(newSession.getLastMsgSenderName());
                                bduids3 = bduids4;
                                groupids3 = groupids4;
                                it = it3;
                                pauids3 = pauids4;
                                userListener3 = userListener4;
                            } else {
                                List<ChatSession> list3 = busiSession;
                                bduids3 = bduids4;
                                groupids3 = groupids4;
                                it = it3;
                                pauids3 = pauids4;
                                userListener3 = userListener4;
                            }
                        } else {
                            ArrayList<Long> pauids5 = pauids3;
                            IGetUsersProfileBatchListener userListener5 = userListener3;
                            Iterator<ChatSession> it4 = it;
                            ArrayList<Long> bduids5 = bduids3;
                            List<Integer> arrayList2 = new ArrayList<>();
                            arrayList2.add(Integer.valueOf(classSession.getClassType()));
                            ArrayList<ChatSession> chatRecordsByClass = ChatMessageDBManager.getInstance(this.mContext).getChatRecordsByClass(1, arrayList2);
                            if (chatRecordsByClass != null && chatRecordsByClass.size() > 0) {
                                classSession.setLastMsgSenderName(chatRecordsByClass.get(0).getNickName());
                            }
                            if (classSession.getClassType() != 13) {
                                ArrayList arrayList3 = arrayList2;
                                ArrayList<ChatSession> arrayList4 = chatRecordsByClass;
                                classSession.setNewMsgSum((long) ChatMessageDBManager.getInstance(this.mContext).getNewMsgCountOfClass(classSession.getClassType()));
                            } else {
                                List<Integer> types = arrayList2;
                                ArrayList<ChatSession> arrayList5 = chatRecordsByClass;
                            }
                            bduids3 = bduids5;
                            groupids3 = groupids4;
                            it = it4;
                            pauids3 = pauids5;
                            userListener3 = userListener5;
                        }
                    } else {
                        ArrayList<Long> arrayList6 = pauids3;
                        IGetUsersProfileBatchListener iGetUsersProfileBatchListener2 = userListener3;
                        Iterator<ChatSession> it5 = it;
                        ArrayList<Long> arrayList7 = bduids3;
                        it = it5;
                    }
                }
                groupids = groupids3;
                bduids = bduids3;
                pauids = pauids3;
                userListener = userListener3;
            }
            if (map2 == null || userMap.size() <= 0) {
                bduids2 = bduids;
                userListener2 = userListener;
            } else {
                bduids2 = new ArrayList<>(userMap.keySet());
                userListener2 = buildSessionListener.getUserIdentityListener(map2);
            }
            if (map == null || paMap.size() <= 0) {
                pauids2 = pauids;
            } else {
                pauids2 = new ArrayList<>(paMap.keySet());
                paListener = buildSessionListener.getPaInfosListener(map);
            }
            if (map3 == null || groupMap.size() <= 0) {
                groupids2 = groupids;
            } else {
                groupids2 = new ArrayList<>(groupMap.keySet());
                groupListener = buildSessionListener.getGroupInfoListener(map3);
            }
            if (userListener2 != null) {
                z = false;
                ChatUserManagerImpl.getInstance(this.mContext).getUsersProfileBatchByBuid(bduids2, false, userListener2);
            } else {
                z = false;
            }
            if (paListener != null) {
                PaManager.getPaInfos(this.mContext, pauids2, z, paListener);
            }
            if (groupListener != null) {
                BIMGroupManager.getFansGroupInfo(this.mContext, groupids2, z, groupListener);
            }
            if (bduids2 == null && pauids2 == null && groupids2 == null) {
                buildSessionListener.onResult(i2, (List<ChatSession>) null, listener);
                return;
            }
            return;
        }
        buildSessionListener.onResult(i2, (List<ChatSession>) null, listener);
    }

    public class CompleteSessionInfoListener implements BIMValueCallBack<List<ChatSession>> {
        private List<ChatSession> mClassSessions;
        boolean mHasMore;
        int mResponseCode;
        long mSessionsVersionCode;
        int mTopHasMore;

        public CompleteSessionInfoListener(int responseCode, long versionCode, boolean hasMore, int topHasMore, List<ChatSession> classSession) {
            this.mResponseCode = responseCode;
            this.mSessionsVersionCode = versionCode;
            this.mHasMore = hasMore;
            this.mTopHasMore = topHasMore;
            this.mClassSessions = classSession;
        }

        public void onResult(int responseCode, String errMsg, List<ChatSession> sessions) {
            List<ChatSession> sessions2;
            if (this.mClassSessions != null) {
                if (sessions == null) {
                    sessions2 = new ArrayList<>();
                } else {
                    sessions2 = sessions;
                }
                sessions2.addAll(this.mClassSessions);
            } else {
                sessions2 = sessions;
            }
            if (sessions2 != null) {
                for (ChatSession session : sessions2) {
                    LogUtils.d(IMFetchBusinessSessionMsg.TAG, "CompleteSessionInfoListener-certDebug-session.name: " + session);
                }
            }
            SessionManager.getInstance(IMFetchBusinessSessionMsg.this.mContext).handleFetchSessionListResultFromServer(this.mResponseCode, this.mSessionsVersionCode, sessions2, this.mTopHasMore, this.mHasMore, IMFetchBusinessSessionMsg.this.mReason, IMFetchBusinessSessionMsg.this.mMode, IMFetchBusinessSessionMsg.this.getListenerKey(), IMFetchBusinessSessionMsg.this.mBeginTime, IMFetchBusinessSessionMsg.this.mEndTime, IMFetchBusinessSessionMsg.this.mCount, IMFetchBusinessSessionMsg.this.mNeedTop, IMFetchBusinessSessionMsg.this.mBusinessType, IMFetchBusinessSessionMsg.this.mAggrType);
        }
    }

    public void updateAggSessionFromServerWithCSession(ChatSession session, int classType) {
        ArrayList<Integer> classTypes = new ArrayList<>();
        ChatSession localSession = null;
        classTypes.add(Integer.valueOf(classType));
        ArrayList<ChatSession> chatSessions = ChatMessageDBManager.getInstance(this.mContext).getChatRecordsByClass(1, classTypes);
        if (chatSessions != null && chatSessions.size() > 0 && chatSessions.get(0) != null) {
            localSession = chatSessions.get(0);
            session.setLastMsg(localSession.getLastMsg());
            session.setExt(localSession.getExt());
        } else if (classType == 11) {
            session.setLastMsg(IMConstants.HUDONG_DESC_DEFAULT);
            session.setExt("");
        }
        LogUtils.d(TAG, "聚合会话修正，session = " + session + "localSession = " + localSession);
    }
}
