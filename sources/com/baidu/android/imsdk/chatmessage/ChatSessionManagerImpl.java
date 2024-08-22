package com.baidu.android.imsdk.chatmessage;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.Pair;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.UnSupportedMsg;
import com.baidu.android.imsdk.chatmessage.request.IMAggrSyncFromServerRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaDeleteSessionRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaGetChatSessionRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaGetContactorPauidRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaGetContactorSettingRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaSetSessionReadRequest;
import com.baidu.android.imsdk.chatmessage.response.MediaGetChatSessionResult;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecord;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.consult.db.BusinessMessageDBManager;
import com.baidu.android.imsdk.consult.request.IMUpdateCollectSessionTagRequest;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.group.BIMGroupManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.request.IMQueryMemberRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.media.SessionManager;
import com.baidu.android.imsdk.media.bean.GetSessionResult;
import com.baidu.android.imsdk.media.bean.SessionParam;
import com.baidu.android.imsdk.media.db.SessionDBManager;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.android.imsdk.media.update.ChatSessionUpdateManager;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.CaseUbc;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.IMServiceImpl;
import com.baidu.searchbox.card.util.CardConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatSessionManagerImpl {
    private static final int ADVISORY_FETCH_BUSINESS_COUNT_FOR_LOGIN = -20;
    private static final long BUSINESS_EXPIRED_SESSION_TIME = 259200000;
    private static final String KEY_BUSINESS_CREDIBLE_MSGID = "busi_session_credible_msgid";
    private static final String KEY_BUSINESS_TOTAL_UNREAD = "busi_session_total_unread";
    private static final String KEY_DELETE_EXPIRED_SESSION_TIME = "business_expired_time";
    private static final String TAG = "SessionManagerImpl";
    /* access modifiers changed from: private */
    public static Context mContext;
    private static volatile ChatSessionManagerImpl mInstance;
    Dispatcher.MsgListener dialogSyncListener = new Dispatcher.MsgListener() {
        public void dealMessage(int triggerReason, ArrayList<ChatMsg> arrayList) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:59:0x01e0 A[LOOP:1: B:57:0x01da->B:59:0x01e0, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void dealMessage(int r29, com.baidu.android.imsdk.chatmessage.messages.ChatMsg r30) {
            /*
                r28 = this;
                r0 = r28
                r1 = r30
                r2 = -1
                boolean r3 = r1 instanceof com.baidu.android.imsdk.chatmessage.messages.DialogSyncMsg
                if (r3 == 0) goto L_0x022d
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "start handle DialogSyncMsg:"
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.String r4 = r30.toString()
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.String r3 = r3.toString()
                java.lang.String r4 = "SessionManagerImpl"
                com.baidu.android.imsdk.utils.LogUtils.d(r4, r3)
                long r5 = r30.getTriggerId()
                r7 = 0
                int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r3 <= 0) goto L_0x004d
                android.content.Context r3 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                if (r3 == 0) goto L_0x004d
                long r5 = r30.getTriggerId()
                android.content.Context r3 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                long r9 = com.baidu.android.imsdk.utils.Utility.getTriggerId(r3)
                int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                if (r3 != 0) goto L_0x004d
                java.lang.String r3 = "start handle DialogSyncMsg#dealMessage triggerId is same"
                com.baidu.android.imsdk.utils.LogUtils.d(r4, r3)
                return
            L_0x004d:
                r3 = r1
                com.baidu.android.imsdk.chatmessage.messages.DialogSyncMsg r3 = (com.baidu.android.imsdk.chatmessage.messages.DialogSyncMsg) r3
                int r5 = r3.getSyncCategory()
                long r14 = r3.getSyncFromUid()
                long r12 = r3.getOperatedMaxMsgid()
                int r6 = r3.getSyncStatus()
                long r19 = r3.getPaid()
                int r11 = r3.getRemainEmptySession()
                int r10 = r3.getAggrType()
                r9 = 1
                if (r6 != 0) goto L_0x0146
                com.baidu.android.imsdk.ChatObject r7 = new com.baidu.android.imsdk.ChatObject
                android.content.Context r8 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                r16 = -1
                r1 = r9
                r9 = r7
                r21 = r10
                r10 = r8
                r8 = r11
                r11 = r5
                r22 = r12
                r12 = r14
                r24 = r14
                r14 = r19
                r9.<init>(r10, r11, r12, r14, r16)
                r9 = 0
                int r11 = r7.getCategory()
                if (r1 != r11) goto L_0x00a2
                android.content.Context r11 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                long r12 = r7.getContacter()
                java.lang.String r12 = java.lang.String.valueOf(r12)
                long r9 = com.baidu.android.imsdk.group.db.GroupMessageDAOImpl.getMaxMsgId(r11, r12)
                r13 = r9
                goto L_0x00af
            L_0x00a2:
                android.content.Context r11 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager r11 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.getInstance(r11)
                long r9 = r11.getMaxMsgId(r7)
                r13 = r9
            L_0x00af:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r10 = "start handle DialogSyncMsg#deleteAllMsgWithMsgid maxMsgid :"
                java.lang.StringBuilder r9 = r9.append(r10)
                r11 = r22
                java.lang.StringBuilder r9 = r9.append(r11)
                java.lang.String r10 = ", localMaxMsgId :"
                java.lang.StringBuilder r9 = r9.append(r10)
                java.lang.StringBuilder r9 = r9.append(r13)
                java.lang.String r9 = r9.toString()
                com.baidu.android.imsdk.utils.LogUtils.d(r4, r9)
                int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r4 >= 0) goto L_0x00e7
                android.content.Context r4 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager r4 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.getInstance(r4)
                int r2 = r4.deleteAllMsgWithMsgid(r7, r11, r8)
                r22 = r11
                r26 = r13
                goto L_0x0106
            L_0x00e7:
                android.content.Context r4 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                com.baidu.android.imsdk.media.SessionManager r9 = com.baidu.android.imsdk.media.SessionManager.getInstance(r4)
                r15 = 0
                r16 = 0
                r17 = 0
                r10 = r5
                r22 = r11
                r11 = r24
                r26 = r13
                r13 = r19
                r18 = r8
                boolean r4 = r9.handleSessionDelete(r10, r11, r13, r15, r16, r17, r18)
                if (r4 == 0) goto L_0x0106
                r2 = 1
            L_0x0106:
                if (r2 <= 0) goto L_0x013e
                com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl r4 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.this
                java.util.List r4 = r4.mDialogSyncListeners
                if (r4 == 0) goto L_0x013e
                com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl r4 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.this
                java.util.List r4 = r4.mDialogSyncListeners
                int r4 = r4.size()
                if (r4 == 0) goto L_0x013b
                com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl r4 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.this
                java.util.List r4 = r4.mDialogSyncListeners
                java.util.Iterator r4 = r4.iterator()
            L_0x0126:
                boolean r9 = r4.hasNext()
                if (r9 == 0) goto L_0x0138
                java.lang.Object r9 = r4.next()
                com.baidu.android.imsdk.chatmessage.IDialogSyncListener r9 = (com.baidu.android.imsdk.chatmessage.IDialogSyncListener) r9
                r13 = r24
                r9.onDialogDel(r5, r13)
                goto L_0x0126
            L_0x0138:
                r13 = r24
                goto L_0x0140
            L_0x013b:
                r13 = r24
                goto L_0x0140
            L_0x013e:
                r13 = r24
            L_0x0140:
                r15 = r8
                r7 = r13
                r4 = r21
                goto L_0x01ed
            L_0x0146:
                r1 = r9
                r21 = r10
                r22 = r12
                r13 = r14
                r15 = r11
                if (r6 != r1) goto L_0x01ea
                int r9 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
                if (r9 != 0) goto L_0x016c
                r11 = r21
                if (r11 != 0) goto L_0x016e
                java.lang.String r7 = "start handle DialogSyncMsg#handleMediaAllRead"
                com.baidu.android.imsdk.utils.LogUtils.d(r4, r7)
                android.content.Context r4 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                com.baidu.android.imsdk.media.SessionManager r4 = com.baidu.android.imsdk.media.SessionManager.getInstance(r4)
                r4.handleAllRead()
                r2 = 1
                r4 = r11
                r7 = r13
                goto L_0x01ba
            L_0x016c:
                r11 = r21
            L_0x016e:
                int r7 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
                if (r7 != 0) goto L_0x018b
                r7 = 12
                if (r11 != r7) goto L_0x018b
                java.lang.String r7 = "start handle DialogSyncMsg#handleStrangerAllRead"
                com.baidu.android.imsdk.utils.LogUtils.d(r4, r7)
                android.content.Context r4 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                com.baidu.android.imsdk.media.SessionManager r4 = com.baidu.android.imsdk.media.SessionManager.getInstance(r4)
                int r2 = r4.handleStrangerAllRead()
                r4 = r11
                r7 = r13
                goto L_0x01ba
            L_0x018b:
                if (r11 <= 0) goto L_0x01a2
                java.lang.String r7 = "start handle DialogSyncMsg#handleAggrAllRead"
                com.baidu.android.imsdk.utils.LogUtils.d(r4, r7)
                android.content.Context r4 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                com.baidu.android.imsdk.media.SessionManager r4 = com.baidu.android.imsdk.media.SessionManager.getInstance(r4)
                int r2 = r4.handleAggrAllRead(r11)
                r4 = r11
                r7 = r13
                goto L_0x01ba
            L_0x01a2:
                java.lang.String r7 = "start handle DialogSyncMsg#handleMediaSessionRead"
                com.baidu.android.imsdk.utils.LogUtils.d(r4, r7)
                android.content.Context r4 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                com.baidu.android.imsdk.media.SessionManager r9 = com.baidu.android.imsdk.media.SessionManager.getInstance(r4)
                r10 = r5
                r4 = r11
                r11 = r13
                r7 = r13
                r13 = r22
                r9.handleSessionRead(r10, r11, r13)
                r2 = 1
            L_0x01ba:
                if (r2 < 0) goto L_0x01ed
                com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl r9 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.this
                java.util.List r9 = r9.mDialogSyncListeners
                if (r9 == 0) goto L_0x01ed
                com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl r9 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.this
                java.util.List r9 = r9.mDialogSyncListeners
                int r9 = r9.size()
                if (r9 == 0) goto L_0x01ed
                com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl r9 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.this
                java.util.List r9 = r9.mDialogSyncListeners
                java.util.Iterator r9 = r9.iterator()
            L_0x01da:
                boolean r10 = r9.hasNext()
                if (r10 == 0) goto L_0x01ed
                java.lang.Object r10 = r9.next()
                com.baidu.android.imsdk.chatmessage.IDialogSyncListener r10 = (com.baidu.android.imsdk.chatmessage.IDialogSyncListener) r10
                r10.onDialogReaded(r5, r7)
                goto L_0x01da
            L_0x01ea:
                r7 = r13
                r4 = r21
            L_0x01ed:
                if (r2 <= 0) goto L_0x022b
                android.content.Intent r9 = new android.content.Intent
                java.lang.String r10 = "com.baidu.android.imsdk.sync"
                r9.<init>(r10)
                android.content.Context r10 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                android.content.Context r10 = r10.getApplicationContext()
                java.lang.String r10 = r10.getPackageName()
                r9.setPackage(r10)
                java.lang.String r10 = "category"
                r9.putExtra(r10, r5)
                java.lang.String r10 = "contacter"
                r9.putExtra(r10, r7)
                java.lang.String r10 = "sync_msgid"
                r11 = r22
                r9.putExtra(r10, r11)
                java.lang.String r10 = "sync_status"
                r9.putExtra(r10, r6)
                java.lang.String r10 = "sync_type"
                r9.putExtra(r10, r1)
                android.content.Context r1 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.mContext
                r1.sendBroadcast(r9)
                goto L_0x022d
            L_0x022b:
                r11 = r22
            L_0x022d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.AnonymousClass3.dealMessage(int, com.baidu.android.imsdk.chatmessage.messages.ChatMsg):void");
        }
    };
    private volatile int mBusinessTotalUnread = -1;
    /* access modifiers changed from: private */
    public List<IDialogSyncListener> mDialogSyncListeners = new LinkedList();
    private volatile int mMediaTotalUnread = 0;
    private ISyncDialogListener syncDialogListener = new ISyncDialogListener() {
        public void onSyncDialogResult(int responseCode, String strMsg, long maxMsgid, List<DialogRecord> records) {
            int i2 = responseCode;
            if (i2 != 0) {
                long j2 = maxMsgid;
            } else if (records == null) {
                long j3 = maxMsgid;
            } else {
                List<DialogRecord> mmds = new LinkedList<>();
                for (DialogRecord record : records) {
                    if (record.getCategory() == 1) {
                        DialogRecord mmd = DialogRecordDBManager.getInstance(ChatSessionManagerImpl.mContext).getDialogRecord(record.getCategory(), record.getContacter());
                        LogUtils.i(ChatSessionManagerImpl.TAG, " onSyncDialogResult " + record.getContacter() + " mmd: " + mmd);
                        if (mmd == null) {
                            mmd = new DialogRecord();
                            mmd.setCategory(record.getCategory()).setContacter(record.getContacter()).setJumpToRecent(1).setMaxMsgid(0);
                        }
                        mmd.setState(0).setUpdateTime(System.currentTimeMillis()).setDialogueMsgid(record.getDialogueMsgid());
                        mmds.add(mmd);
                    }
                }
                LogUtils.i(ChatSessionManagerImpl.TAG, "add DialogRecord mmds : " + mmds);
                if (DialogRecordDBManager.getInstance(ChatSessionManagerImpl.mContext).addBatch(mmds) > 0) {
                    Utility.writeLongData(ChatSessionManagerImpl.mContext, "sync_max_msgid_" + Utility.getUK(ChatSessionManagerImpl.mContext), maxMsgid);
                    Utility.writeIntData(ChatSessionManagerImpl.mContext, Constants.KEY_SYNC_FIRST_TIME, 0);
                    for (DialogRecord mmd2 : DialogRecordDBManager.getInstance(ChatSessionManagerImpl.mContext).getDialogRecord(-1)) {
                        SyncGroupMessageService.getInstance().execute(ChatSessionManagerImpl.mContext, mmd2, 0, -1, -1, "");
                    }
                    return;
                }
                long j4 = maxMsgid;
                return;
            }
            LogUtils.d(ChatSessionManagerImpl.TAG, "onSyncDialogResult return, responseCode:" + i2);
        }
    };

    private ChatSessionManagerImpl() {
        Dispatcher.Event dailogSyncEvent = new Dispatcher.Event();
        dailogSyncEvent.setCategory(2);
        dailogSyncEvent.setType(22);
        Dispatcher.registerListener(dailogSyncEvent, this.dialogSyncListener);
        DBBase.registerObserver(ChatSessionUpdateManager.getInstance(mContext).getSessionDbOberser());
        BusinessMessageDBManager.getInstance(mContext).registerSessionChangeListener(ChatSessionUpdateManager.getInstance(mContext).getBusiSessionChangeListener());
    }

    public static ChatSessionManagerImpl getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ChatSessionManagerImpl.class) {
                if (mInstance == null) {
                    if (mContext == null) {
                        mContext = context.getApplicationContext();
                    }
                    mInstance = new ChatSessionManagerImpl();
                }
            }
        }
        return mInstance;
    }

    public boolean deleteChatSession(ChatSession session) {
        return ChatMessageDBManager.getInstance(mContext).delChatRecord(new ChatObject(mContext, session.getCategory(), session.getContacter())) >= 0;
    }

    public ArrayList<SessionClass> getAllClassType() {
        ArrayList<SessionClass> scarray = ChatMessageDBManager.getInstance(mContext).getAllClassType();
        if (scarray != null && scarray.size() > 0) {
            Iterator<SessionClass> it = scarray.iterator();
            while (it.hasNext()) {
                SessionClass sc = it.next();
                sc.setUnread(ChatMessageDBManager.getInstance(mContext).getNewMsgCountOfClass(sc.getType()));
                LogUtils.d(TAG, " class session is " + sc.getType() + " " + sc.getTitle() + " " + sc.getUnread());
            }
        }
        return scarray;
    }

    public void createChatSession(ChatObject chatObject, String name, int chatType, String iconUrl, int classtype, String classtitle, String classicon, int classshow, int markTop, long markTopTime, int shield, long shieldTime, String vipId, String vPortrait, String certification, String extraJson) {
        int i2 = chatType;
        long result = ChatMessageDBManager.getInstance(mContext).createChatSession(chatObject, name, chatType, iconUrl, classtype, classtitle, classicon, classshow, markTop, markTopTime, shield, shieldTime, vipId, vPortrait, certification, extraJson);
        int i3 = chatType;
        LogUtils.i(TAG, "createChatSession result : " + result + " chatType: " + i3 + "  name:" + name + ";category:" + chatObject.getCategory());
        if (result > 0) {
            ArrayList<ChatMsg> msgs = ChatMsgManagerImpl.getInstance(mContext).fetchMessageSync(chatObject.getCategory(), chatObject.getContacter(), 50, (ChatMsg) null);
            if (msgs == null || msgs.size() == 0) {
                LogUtils.i(TAG, "createChatSession:  fetch msgs is null : ");
                return;
            }
            for (int i4 = 0; i4 < msgs.size(); i4++) {
                msgs.get(i4).setChatType(i3);
            }
            ChatMsgManagerImpl.getInstance(mContext).broadcastMessage(msgs, true);
        }
    }

    public int delDbBusiChatSession(int category, int businessType, int sessionType, long contacteruk) {
        if (category == 9) {
            return BusinessMessageDBManager.getInstance(mContext).delBusiChatSession(businessType, sessionType, contacteruk);
        }
        return -1;
    }

    public ArrayList<ChatSession> getChatRecordsByClass(long count, List<Integer> classtypes) {
        if (AccountManager.isLogin(mContext)) {
            return SessionDBManager.getInstance(mContext).getChatRecordsByClass(count, classtypes);
        }
        return null;
    }

    public ArrayList<ChatSession> getChatRecordsBySubClassType(long count, List<Integer> classtypes) {
        if (AccountManager.isLogin(mContext)) {
            return SessionDBManager.getInstance(mContext).getChatRecordsBySubClassType(count, classtypes);
        }
        return null;
    }

    public ArrayList<ChatSession> getChatRecords(long offset, long count, List<Integer> chatTypes) {
        ArrayList<ChatSession> sessions = SessionDBManager.getInstance(mContext).getChatRecords(offset, count, chatTypes);
        completeSessionInfo(sessions);
        return sessions;
    }

    public List<ChatSession> completeSessionInfo(List<ChatSession> sessions) {
        if (sessions == null || sessions.size() == 0) {
            return sessions;
        }
        LogUtils.d(TAG, "completeSessionInfo :" + sessions.size());
        for (ChatSession s : sessions) {
            updateGroupChatSession(s);
            String lastMsg = s.getLastMsg();
            updateUnSupportDesc(s, lastMsg, s.getCategory(), s.getChatType());
            updatePADesc(s, lastMsg);
        }
        return sessions;
    }

    public ArrayList<ChatSession> getChatRecords(long lastMsgNum, long count) {
        LogUtils.enter();
        if (AccountManager.isLogin(mContext)) {
            return ChatMessageDBManager.getInstance(mContext).getChatRecords(lastMsgNum, count, (List<Integer>) null);
        }
        return null;
    }

    public ChatSession getChatRecord(int category, long contacter) {
        LogUtils.enter();
        ChatSession session = ChatMessageDBManager.getInstance(mContext).getChatRecord(new ChatObject(mContext, category, contacter));
        if (category == 1) {
            ArrayList<String> groupids = new ArrayList<>();
            groupids.add(String.valueOf(contacter));
            ArrayList<GroupInfo> groupsinfo = GroupInfoDAOImpl.getGroupInfo(mContext, groupids);
            if (groupsinfo != null && groupsinfo.size() > 0 && groupsinfo.get(0).getType() == 2 && session != null) {
                session.setChatType(4);
            }
        }
        return session;
    }

    private void updateUnSupportDesc(ChatSession s, String lastMsg, int sessionCategory, int sessionChatType) {
        ChatMsg latestMsg;
        if (IMConstants.IS_UPDATE_VERSION && !TextUtils.isEmpty(lastMsg) && lastMsg.equals(UnSupportedMsg.unSupportedMsgDesc) && (latestMsg = ChatMessageDBManager.getInstance(mContext).getLatestMsg(s.getCategory(), s.getContacter())) != null && BIMManager.isSupportMsgType(latestMsg.getMsgType())) {
            String content = latestMsg.getRecommendDescription();
            if (latestMsg instanceof HtmlMsg) {
                content = ((HtmlMsg) latestMsg).getLocalUrl();
            }
            if (!TextUtils.isEmpty(content) && !lastMsg.equals(content)) {
                s.setLastMsg(content);
                if (ChatMsgManagerImpl.isCChannel(sessionCategory, s.getContacter(), sessionChatType)) {
                    ChatMessageDBManager.getInstance(mContext).updateChatSession(4, s);
                } else {
                    SessionDBManager.getInstance(mContext).updateChatSession(4, s);
                }
            }
        }
    }

    private void updatePADesc(ChatSession s, String lastMsg) {
        int chatType = s.getChatType();
        if (chatType == 7 || chatType == 16 || chatType == 17 || chatType == 27 || chatType == 23 || chatType == 25 || chatType == 26 || chatType == 5 || chatType == 32 || chatType == 61 || chatType == 62 || chatType == 65) {
            try {
                JSONObject jsonObject = new JSONObject(lastMsg);
                if (jsonObject.has("msg")) {
                    JSONObject msgObj = new JSONObject(jsonObject.optString("msg"));
                    String title = lastMsg;
                    if (msgObj.has("template_version") && msgObj.optInt("template_version") > 0) {
                        title = msgObj.optString(CardConstants.COLUMN_CARD_TITLE);
                        if (TextUtils.isEmpty(title)) {
                            title = msgObj.optString("title");
                        }
                    } else if (!TextUtils.isEmpty(msgObj.optString("ext"))) {
                        title = msgObj.optString("title");
                    }
                    if (!TextUtils.isEmpty(title)) {
                        s.setLastMsg(title);
                        if (s.getBusinessType() == 27) {
                            s.setLastMsgId(jsonObject.optLong("id", -1));
                        }
                    } else {
                        s.setLastMsg("你收到了一条消息");
                    }
                } else if (s.getBusinessType() == 27) {
                    s.setLastMsg(jsonObject.optString("title", lastMsg));
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "it doesn't matter>" + e2.getMessage());
            }
        }
    }

    public List<ChatSession> getGroupSession() {
        return ChatMessageDBManager.getInstance(mContext).getGroupSession();
    }

    private void updateGroupChatSession(ChatSession s) {
        ChatSession chatSession = s;
        if (s.getChatType() == 3 || s.getChatType() == 4 || s.getChatType() == 57) {
            ArrayList<String> groupids = new ArrayList<>();
            groupids.add(String.valueOf(s.getContacter()));
            ArrayList<GroupInfo> groupsinfo = GroupInfoDAOImpl.getGroupInfo(mContext, groupids);
            if (groupsinfo == null || groupsinfo.size() <= 0) {
                return;
            }
            LogUtils.d(TAG, "set session name as " + groupsinfo.get(0).getGroupName() + "，groupId :" + s.getContacter());
            GroupInfo ginfo = groupsinfo.get(0);
            if (ginfo.getType() == 2) {
                chatSession.setChatType(4);
                String url = ginfo.getHeadUrl();
                if (!TextUtils.isEmpty(url)) {
                    url = url.trim();
                }
                chatSession.setIconUrl(url);
            } else if (ginfo.getType() == 3) {
                if (TextUtils.isEmpty(s.getName())) {
                    chatSession.setName(ginfo.getGroupName());
                }
                chatSession.setChatType(57);
                chatSession.setChatSubType(ginfo.getSubType());
            } else if (ginfo.getType() == 1) {
                if (TextUtils.isEmpty(s.getName())) {
                    if (!TextUtils.isEmpty(ginfo.getGroupName())) {
                        chatSession.setName(ginfo.getGroupName());
                    } else {
                        List<GroupMember> members = GroupInfoDAOImpl.getGroupMember(mContext, String.valueOf(s.getContacter()), (ArrayList<String>) null, 0);
                        LogUtils.d(TAG, "groupName is null, members ：" + (members != null ? members.size() : -1));
                        List<Long> bduids = new ArrayList<>();
                        StringBuilder name = new StringBuilder();
                        if (members != null) {
                            if (members.size() > 0) {
                                LogUtils.e(TAG, "groupName is null, members :" + members.size());
                                for (int i2 = 0; i2 < members.size(); i2++) {
                                    String showName = members.get(i2).getShowName();
                                    LogUtils.e(TAG, "normalGroup name=null ，uid :" + members.get(i2).getBduid() + ", show :" + showName + ", nick :" + members.get(i2).getNickName() + ", name :" + members.get(i2).getName());
                                    if (!TextUtils.equals(String.valueOf(members.get(i2).getBduid()), AccountManager.getUid(mContext))) {
                                        if (TextUtils.isEmpty(showName)) {
                                            if (!TextUtils.isEmpty(members.get(i2).getNickName())) {
                                                showName = members.get(i2).getNickName();
                                            } else {
                                                showName = members.get(i2).getName();
                                            }
                                            LogUtils.d(TAG, "groupName is null, showName ：" + showName);
                                        }
                                        if (!TextUtils.isEmpty(showName)) {
                                            name.append(showName).append("、");
                                        } else {
                                            ChatUser user = ChatUserDBManager.getInstance(mContext).getChatUserByBuid(members.get(i2).getBduid());
                                            if (user != null) {
                                                name.append(user.getUserName()).append("、");
                                            } else {
                                                bduids.add(Long.valueOf(members.get(i2).getBduid()));
                                            }
                                        }
                                    }
                                }
                                if (name.length() >= 1) {
                                    name = name.deleteCharAt(name.length() - 1);
                                }
                                if (bduids.size() > 0) {
                                    LogUtils.e(TAG, "group bduids  ：" + bduids.toString());
                                    ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(bduids, new IGetUserIdentityListener() {
                                        public void onGetUserIdentityResult(int responseCode, List<ChatUser> users) {
                                            for (ChatUser chatUser : users) {
                                                ChatUserDBManager.getInstance(ChatSessionManagerImpl.mContext).updateUser(chatUser);
                                            }
                                        }
                                    });
                                }
                                chatSession.setName(name.toString());
                            }
                        }
                        LogUtils.e(TAG, "groupName is null, IMQueryMemberRequest begin");
                        Context context = mContext;
                        IMQueryMemberRequest iMQueryMemberRequest = new IMQueryMemberRequest(context, "", AccountManager.getAppid(context), String.valueOf(s.getContacter()), (ArrayList<String>) null, 1);
                        HttpHelper.executor(mContext, iMQueryMemberRequest, iMQueryMemberRequest);
                        chatSession.setName(name.toString());
                    }
                }
                LogUtils.e(TAG, "normalGroup setName：" + s.getName());
            }
        }
    }

    private long getMaxMsgid() {
        return Math.max(Utility.readLongData(mContext, "sync_max_msgid_" + Utility.getUK(mContext), 0), DialogRecordDBManager.getInstance(mContext).getMaxMsgid());
    }

    public void syncDialog() {
        ISyncDialogListener listener = this.syncDialogListener;
        if (listener != null) {
            String key = ListenerManager.getInstance().addListener(listener);
            long maxMsgid = getMaxMsgid();
            if (maxMsgid < 0) {
                listener.onSyncDialogResult(1009, Constants.ERROR_MSG_INTERNAL_DB_ERROR, maxMsgid, (List<DialogRecord>) null);
                LogUtils.d(TAG, "syncDialog intercept because maxMsgid < 0");
            } else if (!LoginManager.getInstance(mContext).isIMLogined()) {
                listener.onSyncDialogResult(5, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1, (List<DialogRecord>) null);
                LogUtils.d(TAG, "syncDialog methodId :94 by intercept because unlogin ");
            } else {
                Intent intent = Utility.creatMethodIntent(mContext, 94);
                intent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, maxMsgid);
                intent.putExtra(Constants.EXTRA_LISTENER_ID, key);
                try {
                    IMServiceImpl.getInstance(mContext).enqueueWork(mContext, intent);
                } catch (Exception e2) {
                    onSyncDialogResult(1003, Constants.ERROR_MSG_SERVICE_ERROR, key, maxMsgid, (List<DialogRecord>) null);
                    LogUtils.e(TAG, "Exception ", e2);
                }
            }
        }
    }

    public void onSyncDialogResult(int responseCode, String msg, String key, long maxMsgid, List<DialogRecord> records) {
        IMListener listener = ListenerManager.getInstance().removeListener(key);
        if (listener instanceof ISyncDialogListener) {
            ((ISyncDialogListener) listener).onSyncDialogResult(responseCode, msg, maxMsgid, records);
        }
    }

    public void registerDialogSyncListener(Context context, IDialogSyncListener listener) {
        if (listener != null && !this.mDialogSyncListeners.contains(listener)) {
            this.mDialogSyncListeners.add(listener);
        }
    }

    public void unregisterDialogSyncListener(Context context, IDialogSyncListener listener) {
        if (listener != null && this.mDialogSyncListeners.contains(listener)) {
            this.mDialogSyncListeners.remove(listener);
        }
    }

    public void mediaGetChatSessions(long contactor, int contactorType, long contactorPauid, String contactorThirdid, long startSessionTime, int count, int needTop, IMediaGetChatSessionListener listener) {
        IMediaGetChatSessionListener iMediaGetChatSessionListener = listener;
        LogUtils.d(TAG, "BC> contactor=" + contactor + ", contactorType" + contactorType + ", contactorPauid" + contactorPauid + ", contactorThirdid" + contactorThirdid + ", startSessionTime=" + startSessionTime + ", count=" + count + ", needTop=" + needTop + ", listener=" + iMediaGetChatSessionListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaGetChatSessionListener != null) {
                listener.onMediaGetChatSessionResult(1000, 0, 0, false, (List<ChatSession>) null);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaGetChatSessionRequest request = new IMMediaGetChatSessionRequest(mContext, contactor, contactorType, contactorPauid, contactorThirdid, count, startSessionTime, needTop, ListenerManager.getInstance().addListener(iMediaGetChatSessionListener));
            HttpHelper.executor(mContext, request, request);
        } else if (iMediaGetChatSessionListener != null) {
            listener.onMediaGetChatSessionResult(2000, 0, 0, false, (List<ChatSession>) null);
        }
    }

    public void getMediaMixedChatSessions(long contactor, int contactorType, long contactorPauid, String contactorThirdid, long startSessionTime, int count, int needTop, IGetMediaMixedChatSessionListener listener) {
        IGetMediaMixedChatSessionListener iGetMediaMixedChatSessionListener = listener;
        LogUtils.d(TAG, "BC> contactor=" + contactor + ", contactorType" + contactorType + ", contactorPauid" + contactorPauid + ", contactorThirdid" + contactorThirdid + ", startSessionTime=" + startSessionTime + ", count=" + count + ", needTop=" + needTop + ", listener=" + iGetMediaMixedChatSessionListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iGetMediaMixedChatSessionListener != null) {
                listener.onMediaGetChatSessionResult(1000, 0, 0, 0, false, (List<ChatSession>) null);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaGetChatSessionRequest request = new IMMediaGetChatSessionRequest(mContext, contactor, contactorType, contactorPauid, contactorThirdid, count, startSessionTime, needTop, ListenerManager.getInstance().addListener(iGetMediaMixedChatSessionListener));
            HttpHelper.executor(mContext, request, request);
        } else if (iGetMediaMixedChatSessionListener != null) {
            listener.onMediaGetChatSessionResult(2000, 0, 0, 0, false, (List<ChatSession>) null);
        }
    }

    public void mediaGetChatSessions(long contactor, long startSessionTime, int count, IMediaGetChatSessionListener listener) {
        IMediaGetChatSessionListener iMediaGetChatSessionListener = listener;
        LogUtils.d(TAG, "BC> contactor=" + contactor + ", startSessionTime=" + startSessionTime + ", count=" + count + ", listener=" + iMediaGetChatSessionListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaGetChatSessionListener != null) {
                listener.onMediaGetChatSessionResult(1000, 0, 0, false, (List<ChatSession>) null);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaGetChatSessionRequest iMMediaGetChatSessionRequest = new IMMediaGetChatSessionRequest(mContext, contactor, count, startSessionTime, ListenerManager.getInstance().addListener(iMediaGetChatSessionListener));
            HttpHelper.executor(mContext, iMMediaGetChatSessionRequest, iMMediaGetChatSessionRequest);
        } else if (iMediaGetChatSessionListener != null) {
            listener.onMediaGetChatSessionResult(2000, 0, 0, false, (List<ChatSession>) null);
        }
    }

    public void mediaSetSessionRead(long contactor, int contactorType, long contactorPauid, String contactorThirdid, long lastTime, IMediaSetSessionReadListener listener) {
        int i2 = contactorType;
        IMediaSetSessionReadListener iMediaSetSessionReadListener = listener;
        LogUtils.d(TAG, "BC> contactor=" + contactor + ", contactorType" + i2 + ", contactorPauid" + contactorPauid + ", contactorThirdid" + contactorThirdid + ", lastTime=" + lastTime + ", listener=" + iMediaSetSessionReadListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaSetSessionReadListener != null) {
                iMediaSetSessionReadListener.onMediaSetSessionReadResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        } else if (AccountManager.getMediaRole(mContext) || i2 == -1) {
            IMMediaSetSessionReadRequest request = new IMMediaSetSessionReadRequest(mContext, contactor, contactorType, contactorPauid, contactorThirdid, lastTime, ListenerManager.getInstance().addListener(iMediaSetSessionReadListener));
            HttpHelper.executor(mContext, request, request);
        } else if (iMediaSetSessionReadListener != null) {
            iMediaSetSessionReadListener.onMediaSetSessionReadResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
        }
    }

    public void mediaSetSessionRead(long contactor, long lastTime, IMediaSetSessionReadListener listener) {
        LogUtils.d(TAG, "BC> contactor=" + contactor + ", lastTime" + lastTime + ", listener=" + listener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (listener != null) {
                listener.onMediaSetSessionReadResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaSetSessionReadRequest request = new IMMediaSetSessionReadRequest(mContext, contactor, lastTime, ListenerManager.getInstance().addListener(listener));
            HttpHelper.executor(mContext, request, request);
        } else if (listener != null) {
            listener.onMediaSetSessionReadResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
        }
    }

    public void mediaDeleteChatSession(long contactor, long lastTime, IMediaDeleteChatSessionListener listener) {
        LogUtils.d(TAG, "BC> contactor=" + contactor + ", lastTime=" + lastTime + ", listener=" + listener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (listener != null) {
                listener.onMediaDeleteChatSessionResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaDeleteSessionRequest request = new IMMediaDeleteSessionRequest(mContext, contactor, lastTime, ListenerManager.getInstance().addListener(listener));
            HttpHelper.executor(mContext, request, request);
        } else if (listener != null) {
            listener.onMediaDeleteChatSessionResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
        }
    }

    public void mediaDeleteChatSession(long contactor, int contactorType, long contactorPauid, String contactorThirdid, long lastTime, int classType, IMediaDeleteChatSessionListener listener) {
        IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener = listener;
        LogUtils.d(TAG, "BC> contactor=" + contactor + ", contactorType" + contactorType + ", contactorPauid" + contactorPauid + ", contactorThirdid" + contactorThirdid + ", lastTime=" + lastTime + ", listener=" + iMediaDeleteChatSessionListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaDeleteChatSessionListener != null) {
                iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaDeleteSessionRequest request = new IMMediaDeleteSessionRequest(mContext, contactor, contactorType, contactorPauid, contactorThirdid, classType, lastTime, ListenerManager.getInstance().addListener(iMediaDeleteChatSessionListener));
            HttpHelper.executor(mContext, request, request);
        } else if (iMediaDeleteChatSessionListener != null) {
            iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
        }
    }

    public void onMediaGetChatSessionRequest(int resultCode, boolean hasMore, int totalUnreadNum, int consultUnreadNum, int topHasMore, Map<Long, ChatSession> paMap, Map<Long, ChatSession> userMap, Map<String, ChatSession> groupMap, String key) {
        int i2 = resultCode;
        Map<Long, ChatSession> map = paMap;
        Map<Long, ChatSession> map2 = userMap;
        Map<String, ChatSession> map3 = groupMap;
        IMListener listener = ListenerManager.getInstance().removeListener(key);
        if (listener != null) {
            IMBuildSessionListener buildSessionListener = new IMBuildSessionListener(mContext, totalUnreadNum, consultUnreadNum, topHasMore, hasMore, listener);
            if (i2 == 0) {
                ArrayList<String> groupids = null;
                ArrayList<Long> bduids = null;
                ArrayList<Long> pauids = null;
                IGetUsersProfileBatchListener userListener = null;
                IGetPaInfosListener paListener = null;
                BIMValueCallBack<ArrayList<GroupInfo>> groupListener = null;
                if (map2 != null && userMap.size() > 0) {
                    bduids = new ArrayList<>(userMap.keySet());
                    userListener = buildSessionListener.getUserIdentityListener(map2);
                }
                if (map != null && paMap.size() > 0) {
                    pauids = new ArrayList<>(paMap.keySet());
                    paListener = buildSessionListener.getPaInfosListener(map);
                }
                if (map3 != null && groupMap.size() > 0) {
                    groupids = new ArrayList<>(groupMap.keySet());
                    groupListener = buildSessionListener.getGroupInfoListener(map3);
                }
                if (userListener != null) {
                    ChatUserManagerImpl.getInstance(mContext).getUsersProfileBatchByBuid(bduids, false, userListener);
                }
                if (paListener != null) {
                    PaManager.getPaInfos(mContext, pauids, false, paListener);
                }
                if (groupListener != null) {
                    BIMGroupManager.getFansGroupInfo(mContext, groupids, false, groupListener);
                }
                if (bduids == null && pauids == null && groupids == null) {
                    buildSessionListener.onResult(i2, (List<ChatSession>) null, listener);
                    return;
                }
                return;
            }
            buildSessionListener.onResult(i2, (List<ChatSession>) null, listener);
        }
    }

    public void mediaContactorSetting(long contactor, int operation, IMediaContactorSettingListener listener) {
        LogUtils.d(TAG, "13.60 已废弃BC> contactor=" + contactor + ", operation" + operation + ", listener=" + listener);
    }

    public void mediaContactorSetting(long contactor, int contactorType, long contactorPauid, String contactorThirdid, int operation, IMediaContactorSettingListener listener) {
        LogUtils.d(TAG, "mediaContactorSetting 13.60废弃");
    }

    public void aggrSyncFromServer(int aggrType, BIMValueCallBack listener) {
        if (aggrType > 0) {
            IMAggrSyncFromServerRequest request = new IMAggrSyncFromServerRequest(mContext, aggrType, ListenerManager.getInstance().addListener(listener));
            HttpHelper.executor(mContext, request, request);
        }
    }

    public void mediaGetContactorPauid(long contactor, int contactorType, long contactorPauid, String contactorThirdid, IMediaGetContactorPauidListener listener) {
        IMediaGetContactorPauidListener iMediaGetContactorPauidListener = listener;
        LogUtils.d(TAG, "BC> contactor=" + contactor + ", contactorType" + contactorType + ", contactorPauid" + contactorPauid + ", contactorThirdid" + contactorThirdid + ", listener=" + iMediaGetContactorPauidListener);
        if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
            IMMediaGetContactorPauidRequest request = new IMMediaGetContactorPauidRequest(mContext, contactor, contactorType, contactorPauid, contactorThirdid, ListenerManager.getInstance().addListener(iMediaGetContactorPauidListener));
            HttpHelper.executor(mContext, request, request);
        } else if (iMediaGetContactorPauidListener != null) {
            listener.onMediaGetContactorPauidResult(1000, "", -1, -1, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        }
    }

    public void mediaGetContactorPauid(long contactor, IMediaGetContactorPauidListener listener) {
        LogUtils.d(TAG, "BC> contactor=" + contactor + ", listener=" + listener);
        if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
            IMMediaGetContactorPauidRequest request = new IMMediaGetContactorPauidRequest(mContext, contactor, ListenerManager.getInstance().addListener(listener));
            HttpHelper.executor(mContext, request, request);
        } else if (listener != null) {
            listener.onMediaGetContactorPauidResult(1000, "", -1, -1, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        }
    }

    public void mediaGetContactorSetting(long contactor, int setting, IMediaContactorSettingListener listener) {
        LogUtils.d(TAG, "BC> contactor=" + contactor + ", setting=" + setting + ", listener=" + listener);
        if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
            IMMediaGetContactorSettingRequest request = new IMMediaGetContactorSettingRequest(mContext, contactor, setting, ListenerManager.getInstance().addListener(listener));
            HttpHelper.executor(mContext, request, request);
        } else if (listener != null) {
            listener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
        }
    }

    public void mediaGetContactorSetting(long contactor, int contactorType, long contactorPauid, String contactorThirdid, int setting, IMediaContactorSettingListener listener) {
        LogUtils.d(TAG, "13.60 废弃 BC> contactor=" + contactor + ", contactorType" + contactorType + ", contactorPauid" + contactorPauid + ", contactorThirdid" + contactorThirdid + ", setting=" + setting + ", listener=" + listener);
    }

    public void getChatSessionsByBusiness(int businessType, int sessionType, long contacterImUk, long beginMsgid, long endMsgid, int count, int reason, int fetchType, IMediaGetChatSessionListener listener) {
        if (!AccountManager.isCuidLogin(mContext)) {
            final int i2 = businessType;
            final long j2 = contacterImUk;
            final long j3 = beginMsgid;
            final long j4 = endMsgid;
            final int i3 = sessionType;
            final int i4 = count;
            final int i5 = fetchType;
            final IMediaGetChatSessionListener iMediaGetChatSessionListener = listener;
            final int i6 = reason;
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() {
                public void run() {
                    LogUtils.d(ChatSessionManagerImpl.TAG, "getChatSessionsByBusiness businessType = " + i2 + " contacterImUk = " + j2 + " beginMsgid = " + j3 + " endMsgid = " + j4 + " sessionType = " + i3 + " count = " + i4 + " sessionType = " + i3);
                    List<ChatSession> sessions = ChatSessionManagerImpl.this.getBusiChatSessionsFromDb(i2, i3, j2, j3, j4, i4, i5);
                    long credibleMsgid = BIMManager.isIMLogined(ChatSessionManagerImpl.mContext) ? ChatSessionManagerImpl.this.getBusiSessionCredibleMsgid(i2) : -1;
                    if (i5 == 2 || credibleMsgid <= j3) {
                    } else if (sessions != null && sessions.size() == Math.abs(i4)) {
                        long j2 = credibleMsgid;
                    } else if (BIMManager.isIMLogined(ChatSessionManagerImpl.mContext)) {
                        long j3 = credibleMsgid;
                        ChatSessionManagerImpl.this.updateBusiSessionAndGet(i2, i3, j2, j3, j4, i4, i6, i5, iMediaGetChatSessionListener);
                        return;
                    } else {
                        if (iMediaGetChatSessionListener != null) {
                            ChatSessionManagerImpl.this.onMediaGetSessionResult(iMediaGetChatSessionListener, (sessions == null || sessions.size() <= 0) ? 1030 : 0, ChatSessionManagerImpl.this.getBusiSessionTotalUnread(i2), 0, sessions != null && sessions.size() == Math.abs(i4), sessions, j2);
                            return;
                        }
                        return;
                    }
                    if (iMediaGetChatSessionListener != null) {
                        boolean hasMore = sessions != null && sessions.size() == Math.abs(i4);
                        ChatSessionManagerImpl chatSessionManagerImpl = ChatSessionManagerImpl.this;
                        chatSessionManagerImpl.onMediaGetSessionResult(iMediaGetChatSessionListener, 0, chatSessionManagerImpl.getBusiSessionTotalUnread(i2), 0, hasMore, sessions, j2);
                    }
                }
            });
        } else if (listener != null) {
            listener.onMediaGetChatSessionResult(0, 0, 0, false, (List<ChatSession>) null);
        }
    }

    /* access modifiers changed from: private */
    public void onMediaGetSessionResult(IMediaGetChatSessionListener listener, int responseCode, int totalUnReadMsgNum, int topHasMore, boolean hasMore, List<ChatSession> sessions, long contacterImUk) {
        listener.onMediaGetChatSessionResult(responseCode, totalUnReadMsgNum, topHasMore, hasMore, sessions);
        CaseUbc.DebugInfo info = new CaseUbc.DebugInfo();
        info.curClassName = "onMediaGetSessionResult";
        info.extInfo = "totalUnReadMsgNum = " + totalUnReadMsgNum;
        info.extInfo += ", contacterImUk = " + contacterImUk;
        info.extInfo += ",session = " + ((sessions == null || sessions.size() <= 0) ? "null" : sessions.get(0).getLastResourceId());
        CaseUbc.debugUbc(mContext, "Business", responseCode, "", info);
    }

    public List<ChatSession> getBusiChatSessionsFromDb(int businessType, int sessionType, long contacterImUk, long beginMsgid, long endMsgid, int count, int fetchType, boolean isNewUnRead) {
        long beginMsgid2;
        long j2 = endMsgid;
        if (BIMManager.isIMLogined(mContext)) {
            long credibleMsgid = getBusiSessionCredibleMsgid(businessType);
            if (credibleMsgid > j2) {
                return null;
            }
            if (beginMsgid < credibleMsgid) {
                beginMsgid2 = credibleMsgid;
                LogUtils.d(TAG, "getBusiChatSessionsFromDb beginMsgid = " + beginMsgid2 + " endMsgid = " + j2);
                return BusinessMessageDBManager.getInstance(mContext).getBusiChatSessions(businessType, sessionType, contacterImUk, beginMsgid2, endMsgid, count, fetchType, isNewUnRead);
            }
        }
        beginMsgid2 = beginMsgid;
        LogUtils.d(TAG, "getBusiChatSessionsFromDb beginMsgid = " + beginMsgid2 + " endMsgid = " + j2);
        return BusinessMessageDBManager.getInstance(mContext).getBusiChatSessions(businessType, sessionType, contacterImUk, beginMsgid2, endMsgid, count, fetchType, isNewUnRead);
    }

    public List<ChatSession> getBusiChatSessionsFromDb(int businessType, int sessionType, long contacterImUk, long beginMsgid, long endMsgid, int count, int fetchType) {
        return getBusiChatSessionsFromDb(businessType, sessionType, contacterImUk, beginMsgid, endMsgid, count, fetchType, false);
    }

    public List<ChatSession> getNewAdvisoryChatSessions(int businessType, int sessionType, long contacterImUk, long beginMsgid, long endMsgid, int count, int fetchType, int ghfUnreadNum) {
        List<ChatSession> busiSessions = getBusiChatSessionsFromDb(businessType, sessionType, contacterImUk, beginMsgid, endMsgid, count, fetchType, ghfUnreadNum > 0);
        if (busiSessions == null || busiSessions.isEmpty()) {
            return getBusiChatSessionsFromDb(businessType, sessionType, contacterImUk, beginMsgid, endMsgid, count, fetchType);
        }
        return busiSessions;
    }

    public Pair<ChatSession, Boolean> getAndCompareLastBusiSession(int businessType, List<ChatSession> busiSession, List<ChatSession> gfhSession, int gfhUnreadNumber) {
        ChatSession newSession;
        ChatSession newSession2 = null;
        ChatSession newUnReadGfhSession = null;
        boolean isGfhSession = false;
        if (busiSession != null && busiSession.size() > 0) {
            newSession2 = busiSession.get(0);
        }
        if (businessType == 27 && gfhSession != null && gfhSession.size() > 0) {
            if (gfhUnreadNumber > 0) {
                Iterator<ChatSession> it = gfhSession.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ChatSession unReadGfhSession = it.next();
                    if (unReadGfhSession.getNewMsgSum() > 0) {
                        newUnReadGfhSession = unReadGfhSession;
                        break;
                    }
                }
            }
            if (newSession == null) {
                newSession = newUnReadGfhSession;
                if (newSession == null) {
                    newSession = gfhSession.get(0);
                }
                isGfhSession = true;
            } else if ((newSession.getNewMsgSum() > 0 && newUnReadGfhSession != null) || (newSession.getNewMsgSum() == 0 && newUnReadGfhSession == null)) {
                if (newUnReadGfhSession == null) {
                    newUnReadGfhSession = gfhSession.get(0);
                }
                if (newUnReadGfhSession.getLastMsgTime() > newSession.getLastMsgTime()) {
                    newSession = newUnReadGfhSession;
                    isGfhSession = true;
                }
            } else if (newSession.getNewMsgSum() == 0 && newUnReadGfhSession != null) {
                newSession = newUnReadGfhSession;
                isGfhSession = true;
            }
        }
        return new Pair<>(newSession, Boolean.valueOf(isGfhSession));
    }

    public void updateLastBusiSession(ChatSession newSession, boolean isGfhSession) {
        if (newSession != null) {
            int type = 1;
            if (isGfhSession) {
                newSession.setClassShow(1);
                newSession.setCategory(9);
                newSession.setChatType(58);
                if (newSession.getSortTime() < newSession.getLastMsgTime() * 1000 * 1000) {
                    newSession.setSortTime(newSession.getLastMsgTime() * 1000 * 1000);
                }
            }
            newSession.setSessionFrom(2);
            newSession.setClassType(10);
            try {
                JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = new JSONArray();
                String name = newSession.getName();
                if (!isGfhSession) {
                    if (newSession.getSessionType() == 1) {
                        if (newSession.getLastAskUk() == AccountManager.getUK(mContext)) {
                            name = name + "(匿名)";
                        } else {
                            String uid = Utility.transBDUID(String.valueOf(newSession.getContacterId()));
                            if (!TextUtils.isEmpty(uid)) {
                                if (uid.length() >= 5) {
                                    name = "匿名用户" + uid.substring(uid.length() - 5);
                                }
                            }
                            name = "匿名用户";
                        }
                    }
                    ChatMsg lastMsg = BusinessMessageDBManager.getInstance(mContext).getBusinessChatByMsgId(newSession.getLastMsgId());
                    if (lastMsg == null || lastMsg.getFromUser() != AccountManager.getUK(mContext)) {
                        newSession.setLastMsg(newSession.getDesc());
                    } else {
                        String lastMsgDesc = "";
                        if (newSession.getLastDialogueStatus() == 1) {
                            lastMsgDesc = String.format(IMConstants.ADVISORY_AGG_DOING_DESC, new Object[]{name});
                        } else if (newSession.getLastDialogueStatus() == 2) {
                            lastMsgDesc = String.format(IMConstants.ADVISORY_AGG_DONE_DESC, new Object[]{name});
                        }
                        newSession.setLastMsg(lastMsgDesc);
                        jsonObject.put("isLastMsgMySelf", true);
                        jsonObject.put("lastMsgUid", lastMsg.getFromUser());
                    }
                }
                newSession.setLastMsgSenderName(name);
                jsonArray.put(newSession.getIconUrl());
                if (!isGfhSession) {
                    if (newSession.getSessionType() == 1) {
                        type = 2;
                    } else {
                        type = 0;
                    }
                }
                jsonObject.put("iconUrls", jsonArray);
                jsonObject.put("lastMsgType", type);
                newSession.addExt(IMConstants.IM_SESSION_EXTRA_ADVISORY_KEY, jsonObject.toString());
            } catch (Exception e2) {
            }
        }
    }

    public void fetchBusinessSessionForLogin(int count) {
        long endMsg;
        final int i2 = count;
        if (!AccountManager.isCuidLogin(mContext)) {
            if (i2 <= 0) {
                notifyBusinessUnread(27);
                return;
            }
            if (i2 != 5) {
                endMsg = getBusiSessionCredibleMsgid(27) - 1;
            } else {
                endMsg = Long.MAX_VALUE;
            }
            updateBusiSessionAndGet(27, 0, 0, 0, endMsg, -20, 0, 1, new IMediaGetChatSessionListener() {
                public void onMediaGetChatSessionResult(int responseCode, int totalUnReadMsgNum, int topHasMore, boolean hasMore, List<ChatSession> list) {
                    if (responseCode != 0 || !hasMore) {
                        ChatSessionManagerImpl.this.notifyBusinessUnread(27);
                    } else {
                        ChatSessionManagerImpl.this.fetchBusinessSessionForLogin(i2 - 1);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void notifyBusinessUnread(final int business) {
        TaskManager.getInstance(mContext).submitForLocalOperation(new Runnable() {
            public void run() {
                BusinessMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).notifyUnreadSessionChange(business);
            }
        });
    }

    public void deleteExpiredBusinessSession() {
        if (!AccountManager.isCuidLogin(mContext)) {
            final String key = KEY_DELETE_EXPIRED_SESSION_TIME + AccountManager.getUK(mContext);
            long time = Utility.readLongData(mContext, key, 0);
            final long curTime = System.currentTimeMillis();
            if (curTime - time > 259200000) {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable() {
                    public void run() {
                        BusinessMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).deleteExpiredBusinessSession(27, (curTime - 259200000) / 1000);
                        Utility.writeLongData(ChatSessionManagerImpl.mContext, key, curTime);
                    }
                });
            }
        }
    }

    public boolean delBusinessChatSession(long contacterImUk, int sessionType, int businessType, int category, long dialogueId, long lastMsgId, final IDelBusinessChatSessionListener listener) {
        LogUtils.d(TAG, "sendDelBusinessSessionMsg start");
        SessionParam delAggParam = SessionParam.getBjhReadOrDelParam(0, 0, 0, 1);
        delAggParam.category = category;
        delAggParam.contacterImUk = contacterImUk;
        delAggParam.businessType = businessType;
        delAggParam.sessionType = sessionType;
        delAggParam.clientMaxMsgid = lastMsgId;
        SessionManager.getInstance(mContext).deleteSession(delAggParam, new BIMValueCallBack<Object>() {
            public void onResult(int responseCode, String errMsg, Object response) {
                IDelBusinessChatSessionListener iDelBusinessChatSessionListener = listener;
                if (iDelBusinessChatSessionListener != null) {
                    iDelBusinessChatSessionListener.onResult(responseCode, errMsg);
                }
            }
        });
        return true;
    }

    public void updateBusiSessionAndGet(int businessType, int sessionType, long contacterImUk, long beginMsgid, long endMsgid, int count, int reason, int fetchType, IMediaGetChatSessionListener listener) {
        long fetchEndMsgId = endMsgid;
        if (reason == 3 && contacterImUk == 0) {
            fetchEndMsgId = Math.min(fetchEndMsgId, getBusiSessionCredibleMsgid(businessType) - 1);
        }
        final int i2 = businessType;
        final int i3 = reason;
        final IMediaGetChatSessionListener iMediaGetChatSessionListener = listener;
        final int i4 = sessionType;
        final long j2 = contacterImUk;
        final long j3 = beginMsgid;
        final long j4 = endMsgid;
        final int i5 = count;
        final int i6 = fetchType;
        getBusiSessionFromServer(i2, sessionType, contacterImUk, beginMsgid, fetchEndMsgId, count, new IMediaGetChatSessionListener() {
            public void onMediaGetChatSessionResult(int responseCode, int totalUnReadMsgNum, int topHasMore, boolean hasMore, List<ChatSession> sessions) {
                List<ChatSession> list = sessions;
                if (responseCode != 0 || list == null || sessions.size() <= 0) {
                    int i2 = totalUnReadMsgNum;
                } else {
                    ChatSessionManagerImpl.this.setBusiSessionTotalUnread(i2, totalUnReadMsgNum);
                    long credibleMsgid = Long.MAX_VALUE;
                    for (ChatSession session : sessions) {
                        if (credibleMsgid > session.getLastMsgId()) {
                            credibleMsgid = session.getLastMsgId();
                        }
                    }
                    if (i3 == 0) {
                        ChatSessionManagerImpl.this.setBusiSessionCredibleMsgid(i2, credibleMsgid);
                    } else if (credibleMsgid < ChatSessionManagerImpl.this.getBusiSessionCredibleMsgid(i2)) {
                        ChatSessionManagerImpl.this.setBusiSessionCredibleMsgid(i2, credibleMsgid);
                    }
                    BusinessMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).replaceBusinessSession(list);
                }
                IMediaGetChatSessionListener iMediaGetChatSessionListener = iMediaGetChatSessionListener;
                if (iMediaGetChatSessionListener == null) {
                    return;
                }
                if (i3 == 2) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(responseCode, totalUnReadMsgNum, 0, hasMore, sessions);
                    return;
                }
                List<ChatSession> result = ChatSessionManagerImpl.this.getBusiChatSessionsFromDb(i2, i4, j2, j3, j4, i5, i6);
                iMediaGetChatSessionListener.onMediaGetChatSessionResult(0, ChatSessionManagerImpl.this.getBusiSessionTotalUnread(i2), 0, result != null && result.size() > 0 && hasMore, result);
            }
        });
    }

    public void getBusiSessionFromServer(int businessType, int sessionType, long contacterImUk, long beginMsgid, long endMsgid, int count, IMediaGetChatSessionListener listener) {
        int i2 = businessType;
        IMediaGetChatSessionListener iMediaGetChatSessionListener = listener;
        boolean isShield = BIMManager.isShieldSession(9, i2);
        LogUtils.d(TAG, "问一问拉会话屏蔽状态：" + isShield);
        if (isShield) {
            if (iMediaGetChatSessionListener != null) {
                listener.onMediaGetChatSessionResult(0, 0, 0, false, (List<ChatSession>) null);
            }
        } else if (!BIMManager.isIMLogined(mContext)) {
            LogUtils.d(TAG, "getBusiSessionFromServer im not login, triggle im relogin");
            LoginManager.getInstance(mContext).triggleLogoutListener(1000, Constants.ERROR_LOGIN_STATE_ERROR);
            boolean z = isShield;
            getChatSessionsByBusiness(businessType, sessionType, contacterImUk, beginMsgid, endMsgid, count, 3, 1, listener);
        } else {
            if (!AccountManager.isCuidLogin(mContext)) {
                Intent intent = Utility.creatMethodIntent(mContext, 206);
                String msgkey = ListenerManager.getInstance().addListener(iMediaGetChatSessionListener);
                intent.putExtra("count", count);
                intent.putExtra("contacter", contacterImUk);
                intent.putExtra("msgid_begin", beginMsgid);
                intent.putExtra("msgid_end", endMsgid);
                intent.putExtra("bussiness_type", i2);
                intent.putExtra(Constants.EXTRA_LISTENER_ID, msgkey);
                intent.putExtra("session_type", sessionType);
                try {
                    IMServiceImpl.getInstance(mContext).enqueueWork(mContext, intent);
                } catch (Exception e2) {
                    LogUtils.e(TAG, "getBusiSessionFromServer Exception ", e2);
                    ListenerManager.getInstance().removeListener(msgkey);
                    if (iMediaGetChatSessionListener != null) {
                        listener.onMediaGetChatSessionResult(1003, 0, 0, false, (List<ChatSession>) null);
                    }
                }
            } else if (iMediaGetChatSessionListener != null) {
                listener.onMediaGetChatSessionResult(0, 0, 0, false, (List<ChatSession>) null);
            }
        }
    }

    public void onFetchBusiChatSessionResult(int resultCode, boolean hasMore, int totalUnread, List<ChatSession> chatSessions, String key) {
        List<ChatSession> list = chatSessions;
        IMediaGetChatSessionListener listener = (IMediaGetChatSessionListener) ListenerManager.getInstance().removeListener(key);
        if (resultCode != 0) {
            if (listener != null) {
                listener.onMediaGetChatSessionResult(resultCode, totalUnread, 0, hasMore, (List<ChatSession>) null);
            }
        } else if (list == null || chatSessions.size() <= 0) {
            if (listener != null) {
                listener.onMediaGetChatSessionResult(resultCode, totalUnread, 0, hasMore, (List<ChatSession>) null);
            }
        } else {
            List<Long> bduids = new ArrayList<>();
            for (ChatSession session : chatSessions) {
                if (session != null) {
                    bduids.add(Long.valueOf(session.getContacterId()));
                }
            }
            LongSparseArray<ChatUser> usersArray = ChatUserDBManager.getInstance(mContext).getChatUserByBduids(bduids);
            List<ChatSession> result = new ArrayList<>();
            if (usersArray != null) {
                for (int i2 = 0; i2 < usersArray.size(); i2++) {
                    for (int j2 = 0; j2 < chatSessions.size(); j2++) {
                        if (usersArray.valueAt(i2).getBuid() == list.get(j2).getContacterId()) {
                            ChatSession session2 = updateChatSessionByChatUser(list.get(j2), usersArray.valueAt(i2));
                            if (session2 != null) {
                                result.add(session2);
                            }
                            bduids.remove(Long.valueOf(usersArray.keyAt(i2)));
                        }
                    }
                }
            }
            if (bduids.size() > 0) {
                ChatUserManagerImpl instance = ChatUserManagerImpl.getInstance(mContext);
                final List<ChatSession> list2 = chatSessions;
                final List<ChatSession> list3 = result;
                final IMediaGetChatSessionListener iMediaGetChatSessionListener = listener;
                final int i3 = resultCode;
                final int i4 = totalUnread;
                AnonymousClass10 r8 = r0;
                final boolean z = hasMore;
                AnonymousClass10 r0 = new IGetUserIdentityListener() {
                    public void onGetUserIdentityResult(int responseCode, List<ChatUser> users) {
                        ChatSession session;
                        if (responseCode == 0 && users.size() > 0) {
                            ChatUserDBManager.getInstance(ChatSessionManagerImpl.mContext).updateUserIdentity(users);
                            for (ChatUser user : users) {
                                for (int i2 = 0; i2 < list2.size(); i2++) {
                                    if (user.getBuid() == ((ChatSession) list2.get(i2)).getContacterId() && (session = ChatSessionManagerImpl.this.updateChatSessionByChatUser((ChatSession) list2.get(i2), user)) != null) {
                                        list3.add(session);
                                    }
                                }
                            }
                        }
                        IMediaGetChatSessionListener iMediaGetChatSessionListener = iMediaGetChatSessionListener;
                        if (iMediaGetChatSessionListener != null) {
                            iMediaGetChatSessionListener.onMediaGetChatSessionResult(i3, i4, 0, z, list3);
                        }
                    }
                };
                instance.updateUserIdentity(bduids, r8);
            } else if (listener != null) {
                listener.onMediaGetChatSessionResult(resultCode, totalUnread, 0, hasMore, result);
            }
        }
    }

    /* access modifiers changed from: private */
    public ChatSession updateChatSessionByChatUser(ChatSession session, ChatUser user) {
        if (session == null || user == null) {
            return null;
        }
        session.setName(user.getUserName());
        session.setChatType(58);
        session.setBusinessType(27);
        session.setIconUrl(user.getIconUrl());
        session.setContacter(user.getUk());
        session.setVPortrait(user.getVPortrait());
        return session;
    }

    public void setBusiSessionTotalUnread(int busiType, int unread) {
        LogUtils.d(TAG, "setBusiSessionTotalUnread busiType = " + busiType + ";unread:" + unread);
        this.mBusinessTotalUnread = unread;
        Utility.writeIntData(mContext, getBusiSessionTotalUnreadKey(busiType), unread);
    }

    public int getBusiSessionTotalUnread(int busiType) {
        if (this.mBusinessTotalUnread != -1) {
            LogUtils.d(TAG, "getBusiSessionTotalUnread busiType = " + busiType + ";memory cache unread:" + this.mBusinessTotalUnread);
            return this.mBusinessTotalUnread;
        }
        int fileCacheUnread = Utility.readIntData(mContext, getBusiSessionTotalUnreadKey(busiType), 0);
        LogUtils.d(TAG, "getBusiSessionTotalUnread busiType = " + busiType + ";file cache unread:" + this.mBusinessTotalUnread);
        return fileCacheUnread;
    }

    /* access modifiers changed from: private */
    public void setBusiSessionCredibleMsgid(int busiType, long msgid) {
        LogUtils.d(TAG, "setBusiSessionCredibleMsgid busiType = " + busiType + " msgid = " + msgid);
        Utility.writeLongData(mContext, getBusiSessionCredibleMsgidKey(busiType), msgid);
    }

    /* access modifiers changed from: private */
    public long getBusiSessionCredibleMsgid(int busiType) {
        return Utility.readLongData(mContext, getBusiSessionCredibleMsgidKey(busiType), Long.MAX_VALUE);
    }

    private String getBusiSessionCredibleMsgidKey(int busiType) {
        return AccountManager.getUK(mContext) + KEY_BUSINESS_CREDIBLE_MSGID + busiType;
    }

    private String getBusiSessionTotalUnreadKey(int busiType) {
        return AccountManager.getUK(mContext) + KEY_BUSINESS_TOTAL_UNREAD + busiType;
    }

    public void setChatSessionReadByBusiness(int businessType, int sessionType, int category, long contacterImUk, long maxMsgId, long beginMsgId, IMediaSetSessionReadListener listener) {
        IMediaSetSessionReadListener iMediaSetSessionReadListener = listener;
        if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
            LogUtils.e(TAG, "setChatSessionReadByBusiness start");
            String key = ListenerManager.getInstance().addListener(iMediaSetSessionReadListener);
            final int i2 = businessType;
            final int i3 = sessionType;
            final int i4 = category;
            final long j2 = contacterImUk;
            final long j3 = maxMsgId;
            final String str = key;
            SessionManager.getInstance(mContext).setSessionRead(SessionParam.getAdvisoryReadOrDelParam(contacterImUk, maxMsgId, beginMsgId, sessionType, 0), new BIMValueCallBack<Object>() {
                public void onResult(int responseCode, String errMsg, Object object) {
                    ChatSessionManagerImpl.this.onMarkBusinessSessionReadResult(responseCode, errMsg, i2, i3, i4, j2, j3, str);
                }
            });
        } else if (iMediaSetSessionReadListener != null) {
            iMediaSetSessionReadListener.onMediaSetSessionReadResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        }
    }

    public void onMarkBusinessSessionReadResult(int businessType, int category, long contacterImUk, long maxMsgId) {
        LogUtils.d(TAG, "onMarkBusinessSessionReadResult businessType = " + businessType + ";contacterImUk = " + contacterImUk);
        List<ChatSession> sessions = BusinessMessageDBManager.getInstance(mContext).getBusiChatSessions(businessType, -1, contacterImUk, 0, Long.MAX_VALUE, 1, 1, false);
        if (sessions != null && sessions.size() > 0) {
            onMarkBusinessSessionReadResult(0, " ", businessType, sessions.get(0).getSessionType(), category, contacterImUk, maxMsgId, "");
        }
    }

    public void onMarkBusinessSessionReadResult(int error, String strMsg, int businessType, int sessionType, int category, long contacterImUk, long maxMsgId, String key) {
        long lastUnreadCount;
        int i2 = error;
        String str = strMsg;
        final int i3 = businessType;
        if (i2 == 0) {
            BusinessMessageDBManager.getInstance(mContext).setBusinessChatMsgRead(businessType, sessionType, contacterImUk, maxMsgId);
            List<ChatSession> sessions = BusinessMessageDBManager.getInstance(mContext).getBusiChatSessions(businessType, sessionType, contacterImUk, 0, Long.MAX_VALUE, -1, 1, false);
            int resultTotal = 0;
            if (sessions == null || sessions.size() <= 0) {
                lastUnreadCount = 0;
            } else {
                lastUnreadCount = sessions.get(0).getNewMsgSum();
            }
            final int totalUnread = getBusiSessionTotalUnread(i3);
            if (totalUnread > 99) {
                List<ChatSession> list = sessions;
                int i4 = i3;
                getBusiSessionFromServer(businessType, sessionType, contacterImUk, 0, Long.MAX_VALUE, 1, new IMediaGetChatSessionListener() {
                    public void onMediaGetChatSessionResult(int responseCode, int totalUnReadMsgNum, int topHasMore, boolean hasMore, List<ChatSession> list) {
                        if (totalUnread != totalUnReadMsgNum) {
                            ChatSessionManagerImpl.this.setBusiSessionTotalUnread(i3, totalUnReadMsgNum);
                            BusinessMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).notifySessionChange(3);
                        }
                    }
                });
                int i5 = totalUnread;
            } else {
                List<ChatSession> list2 = sessions;
                int i6 = i3;
                int totalUnread2 = totalUnread;
                if (((long) totalUnread2) - lastUnreadCount >= 0) {
                    resultTotal = (int) (((long) totalUnread2) - lastUnreadCount);
                }
                setBusiSessionTotalUnread(i6, resultTotal);
            }
            BusinessMessageDBManager.getInstance(mContext).setBusinessSessionRead(businessType, sessionType, contacterImUk, 0);
        } else {
            int i7 = i3;
        }
        IMListener listener = ListenerManager.getInstance().removeListener(key);
        if (listener == null) {
            LogUtils.d(TAG, "onMarkBusinessSessionReadResult listener is null");
        } else if (listener instanceof IMediaSetSessionReadListener) {
            ((IMediaSetSessionReadListener) listener).onMediaSetSessionReadResult(i2, str);
        } else if (listener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) listener).onResult(i2, str, null);
        }
    }

    public void onDelBusinessSessionResult(int error, String strMsg, int businessType, int sessionType, int category, long contacterImUk, String key) {
        long lastUnreadCount;
        int i2;
        int i3 = error;
        String str = strMsg;
        final int i4 = businessType;
        if (i3 == 0) {
            List<ChatSession> sessions = BusinessMessageDBManager.getInstance(mContext).getBusiChatSessions(businessType, sessionType, contacterImUk, 0, Long.MAX_VALUE, -1, 1, false);
            int resultTotal = 0;
            if (sessions == null || sessions.size() <= 0) {
                lastUnreadCount = 0;
            } else {
                lastUnreadCount = sessions.get(0).getNewMsgSum();
            }
            LogUtils.d(TAG, "lastUnreadCount : " + lastUnreadCount);
            final int totalUnread = getBusiSessionTotalUnread(i4);
            if (totalUnread > 99) {
                long j2 = lastUnreadCount;
                List<ChatSession> list = sessions;
                i2 = i4;
                getBusiSessionFromServer(businessType, sessionType, contacterImUk, 0, Long.MAX_VALUE, 1, new IMediaGetChatSessionListener() {
                    public void onMediaGetChatSessionResult(int responseCode, int totalUnReadMsgNum, int topHasMore, boolean hasMore, List<ChatSession> list) {
                        if (totalUnread != totalUnReadMsgNum) {
                            ChatSessionManagerImpl.this.setBusiSessionTotalUnread(i4, totalUnReadMsgNum);
                            BusinessMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).notifySessionChange(3);
                        }
                    }
                });
                int i5 = totalUnread;
            } else {
                long lastUnreadCount2 = lastUnreadCount;
                List<ChatSession> list2 = sessions;
                i2 = i4;
                int totalUnread2 = totalUnread;
                if (((long) totalUnread2) - lastUnreadCount2 >= 0) {
                    resultTotal = (int) (((long) totalUnread2) - lastUnreadCount2);
                }
                setBusiSessionTotalUnread(i2, resultTotal);
            }
            LogUtils.d(TAG, "delMsgCount : " + ChatMsgManagerImpl.getInstance(mContext).deleteDBBusiMsgs(category, contacterImUk, (long) i2, sessionType) + " -- delSessionCount: " + getInstance(mContext).delDbBusiChatSession(category, businessType, sessionType, contacterImUk));
        } else {
            int i6 = i4;
        }
        IMListener listener = ListenerManager.getInstance().removeListener(key);
        if (listener instanceof IDelBusinessChatSessionListener) {
            ((IDelBusinessChatSessionListener) listener).onResult(i3, str);
        } else if (listener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) listener).onResult(i3, str, null);
        }
    }

    public void setAllBusinessSessionRead(int businessType) {
        setBusiSessionTotalUnread(businessType, 0);
        BusinessMessageDBManager.getInstance(mContext).setAllBusinessSessionRead(businessType);
    }

    public List<Integer> getUnreadChatTypesByAllClassType() {
        return ChatMessageDBManager.getInstance(mContext).getUnreadChatTypesByAllClassType();
    }

    public String getBusinessSessionLastMsg(ChatSession session) {
        if (session == null || session.getBusinessType() != 27) {
            return "";
        }
        String name = session.getNickName();
        if (TextUtils.isEmpty(name)) {
            name = session.getName();
        }
        if (session.getSessionType() == 1) {
            if (session.getLastAskUk() == AccountManager.getUK(mContext)) {
                name = name + "(匿名)";
            } else {
                String uid = Utility.transBDUID(String.valueOf(session.getContacterId()));
                if (TextUtils.isEmpty(uid) || uid.length() < 5) {
                    name = "匿名用户";
                } else {
                    name = "匿名用户" + uid.substring(uid.length() - 5);
                }
            }
        }
        if (session.getLastDialogueStatus() == 1) {
            return String.format(IMConstants.ADVISORY_AGG_DOING_DESC, new Object[]{name});
        } else if (session.getLastDialogueStatus() != 2) {
            return "";
        } else {
            return String.format(IMConstants.ADVISORY_AGG_DONE_DESC, new Object[]{name});
        }
    }

    public void writeServerUnreadnum(int num, boolean request) {
        if (!request) {
            this.mMediaTotalUnread = num;
        } else {
            mediaGetChatSessions(-1, -1, -1, "", 0, 1, -1, (IMediaGetChatSessionListener) null);
        }
    }

    public int readServerUnreadNum() {
        return this.mMediaTotalUnread;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0258  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getChatSession(com.baidu.android.imsdk.media.bean.SessionParam r32, com.baidu.android.imsdk.media.listener.BIMValuesCallBack<com.baidu.android.imsdk.media.bean.GetSessionResult, com.baidu.android.imsdk.media.bean.SessionParam> r33, com.baidu.android.imsdk.ubc.ScreenUbc.MethodInfo r34) {
        /*
            r31 = this;
            r0 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            if (r11 != 0) goto L_0x0019
            if (r12 == 0) goto L_0x0018
            r1 = 1005(0x3ed, float:1.408E-42)
            com.baidu.android.imsdk.media.bean.GetSessionResult r2 = com.baidu.android.imsdk.media.bean.GetSessionResult.getFailResult()
            r3 = 0
            java.lang.String r4 = "Parameter error!"
            r12.onResult(r1, r4, r2, r3)
        L_0x0018:
            return
        L_0x0019:
            int r1 = r11.classType
            if (r1 <= 0) goto L_0x0025
            int r1 = r11.classType
            java.lang.String r2 = r11.screenKey
            r0.fetchSessionListByClass(r1, r12, r13, r2)
            return
        L_0x0025:
            int r1 = r11.count
            r14 = 1
            if (r1 < 0) goto L_0x002e
            int r1 = r11.count
            int r1 = r1 + r14
            goto L_0x0031
        L_0x002e:
            int r1 = r11.count
            int r1 = r1 - r14
        L_0x0031:
            r6 = r1
            android.content.Context r1 = mContext
            com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager r1 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.getInstance(r1)
            long r2 = r11.sortUpdateTimeBegin
            long r4 = r11.sortUpdateTimeEnd
            int r7 = r11.mode
            int r8 = r11.needTop
            java.util.List<java.lang.Integer> r9 = r11.allChatTypes
            r10 = r32
            java.util.List r1 = r1.getSessionList(r2, r4, r6, r7, r8, r9, r10)
            org.json.JSONArray r2 = r13.eventList
            java.lang.String r3 = "getSessionList"
            com.baidu.android.imsdk.utils.Utility.addEventList(r2, r3)
            com.baidu.android.imsdk.media.bean.GetSessionResult r2 = new com.baidu.android.imsdk.media.bean.GetSessionResult
            r2.<init>()
            r3 = 0
            r2.hasMore = r3
            if (r1 == 0) goto L_0x0071
            int r4 = r1.size()
            int r5 = r11.count
            int r5 = java.lang.Math.abs(r5)
            if (r4 <= r5) goto L_0x0071
            int r4 = r11.count
            int r4 = java.lang.Math.abs(r4)
            java.util.List r1 = r1.subList(r3, r4)
            r2.hasMore = r14
        L_0x0071:
            java.util.List r4 = r0.completeSessionInfo(r1)
            r2.sessionList = r4
            org.json.JSONArray r4 = r13.eventList
            java.lang.String r5 = "completeSessionInfo_end"
            com.baidu.android.imsdk.utils.Utility.addEventList(r4, r5)
            r4 = 0
            r7 = 0
            if (r1 == 0) goto L_0x00b9
            int r5 = r1.size()
            if (r5 <= 0) goto L_0x00b9
            int r5 = r1.size()
            int r5 = r5 - r14
            java.lang.Object r5 = r1.get(r5)
            com.baidu.android.imsdk.chatmessage.ChatSession r5 = (com.baidu.android.imsdk.chatmessage.ChatSession) r5
            long r7 = r5.getLastMsgTime()
            int r5 = r1.size()
            int r5 = r5 - r14
        L_0x009d:
            if (r5 < 0) goto L_0x00b9
            java.lang.Object r9 = r1.get(r5)
            com.baidu.android.imsdk.chatmessage.ChatSession r9 = (com.baidu.android.imsdk.chatmessage.ChatSession) r9
            int r10 = r9.getClassType()
            if (r10 > r14) goto L_0x00b6
            int r10 = r9.getIsStranger()
            if (r10 != 0) goto L_0x00b6
            int r4 = r9.getMarkTop()
            goto L_0x00b9
        L_0x00b6:
            int r5 = r5 + -1
            goto L_0x009d
        L_0x00b9:
            org.json.JSONArray r5 = r13.eventList
            java.lang.String r9 = "markTop_end"
            com.baidu.android.imsdk.utils.Utility.addEventList(r5, r9)
            java.lang.String r5 = r11.screenKey
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x0278
            android.content.Context r5 = mContext
            com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl r5 = getInstance(r5)
            r9 = 27
            int r5 = r5.getBusiSessionTotalUnread(r9)
            android.content.Context r10 = mContext
            r14 = 0
            int r10 = com.baidu.android.imsdk.chatmessage.ChatMsgManager.getAdvisoryGfhUnReadMsgCount(r10, r14)
            r16 = 0
            r17 = -1
            if (r5 > 0) goto L_0x00e9
            if (r10 <= 0) goto L_0x00e5
            goto L_0x00e9
        L_0x00e5:
            r21 = r1
            goto L_0x0161
        L_0x00e9:
            android.content.Context r18 = mContext
            com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl r3 = getInstance(r18)
            long r14 = r11.timeInterval
            java.util.List r3 = r3.getSessionByGfhPA((int) r9, (long) r14)
            if (r3 == 0) goto L_0x012d
            boolean r9 = r3.isEmpty()
            if (r9 != 0) goto L_0x012d
            boolean r9 = com.baidu.android.imsdk.BIMManager.isD4Bar
            if (r9 != 0) goto L_0x0109
            if (r5 <= 0) goto L_0x0105
            r9 = r5
            goto L_0x0107
        L_0x0105:
            r9 = r17
        L_0x0107:
            r2.weakConsultUnread = r9
        L_0x0109:
            java.util.Iterator r9 = r3.iterator()
            r14 = r16
        L_0x010f:
            boolean r15 = r9.hasNext()
            if (r15 == 0) goto L_0x012a
            java.lang.Object r15 = r9.next()
            com.baidu.android.imsdk.chatmessage.ChatSession r15 = (com.baidu.android.imsdk.chatmessage.ChatSession) r15
            r21 = r1
            long r0 = (long) r14
            long r22 = r15.getNewMsgSum()
            long r0 = r0 + r22
            int r14 = (int) r0
            r0 = r31
            r1 = r21
            goto L_0x010f
        L_0x012a:
            r21 = r1
            goto L_0x0163
        L_0x012d:
            r21 = r1
            boolean r0 = com.baidu.android.imsdk.BIMManager.isD4Bar
            if (r0 != 0) goto L_0x0161
            android.content.Context r0 = mContext
            com.baidu.android.imsdk.consult.db.BusinessMessageDBManager r22 = com.baidu.android.imsdk.consult.db.BusinessMessageDBManager.getInstance(r0)
            r23 = 27
            r24 = 1
            long r0 = r11.timeInterval
            long r14 = java.lang.System.currentTimeMillis()
            r25 = 1000(0x3e8, double:4.94E-321)
            long r27 = r14 / r25
            r29 = 0
            r30 = 0
            r25 = r0
            java.util.List r0 = r22.getBusinessChatSessions(r23, r24, r25, r27, r29, r30)
            if (r0 == 0) goto L_0x0161
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0161
            if (r5 <= 0) goto L_0x015d
            r1 = r5
            goto L_0x015f
        L_0x015d:
            r1 = r17
        L_0x015f:
            r2.weakConsultUnread = r1
        L_0x0161:
            r14 = r16
        L_0x0163:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "时间区间 : "
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r4
            long r3 = r11.timeInterval
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r3 = " 秒 , 咨询订单未读 : "
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r3 = ", 问一问官方号未读（未弱化） : "
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r3 = ", 问一问官方号未读（弱化后） : "
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r14)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "SessionManagerImpl"
            com.baidu.android.imsdk.utils.LogUtils.d(r3, r0)
            if (r5 <= 0) goto L_0x01a2
            r2.consultUnread = r5
            goto L_0x01aa
        L_0x01a2:
            if (r10 <= 0) goto L_0x01a7
            r0 = r17
            goto L_0x01a8
        L_0x01a7:
            r0 = 0
        L_0x01a8:
            r2.consultUnread = r0
        L_0x01aa:
            android.content.Context r0 = mContext
            com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager r0 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.getInstance(r0)
            r9 = r5
            r4 = 0
            int r0 = r0.getStrangerUnReadCount(r4)
            r2.dotUnread = r0
            r15 = r9
            r0 = r10
            long r9 = r11.timeInterval
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x01e7
            int r4 = r2.dotUnread
            if (r4 <= 0) goto L_0x01e7
            android.content.Context r4 = mContext
            com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager r22 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.getInstance(r4)
            long r4 = r11.timeInterval
            long r23 = com.baidu.android.imsdk.utils.TimeUtil.getTimeSecondByInterval(r4)
            r25 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r27 = 1
            java.util.List r4 = r22.getStrangerSessionList(r23, r25, r27)
            if (r4 == 0) goto L_0x01e4
            int r5 = r4.size()
            if (r5 != 0) goto L_0x01e7
        L_0x01e4:
            r5 = 0
            r2.dotUnread = r5
        L_0x01e7:
            android.content.Context r4 = mContext
            com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager r4 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.getInstance(r4)
            java.util.List<java.lang.Integer> r5 = r11.unreadNumChatTypes
            long r9 = r11.timeInterval
            r16 = r0
            r0 = 0
            int r4 = r4.getNewMsgCountWithStranger(r5, r0, r9)
            android.content.Context r5 = mContext
            com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager r5 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.getInstance(r5)
            java.util.List<java.lang.Integer> r9 = r11.unreadNumChatTypes
            r10 = r6
            r22 = r7
            long r6 = r11.timeInterval
            int r5 = r5.getNewMsgCountWithStrangerAndNoDisturb(r9, r0, r6)
            r2.privateChatNoDisturbNumber = r5
            int r5 = r2.privateChatNoDisturbNumber
            if (r5 > 0) goto L_0x0212
            r2.privateChatNoDisturbNumber = r0
            goto L_0x021b
        L_0x0212:
            int r5 = r2.privateChatNoDisturbNumber
            int r6 = java.lang.Math.max(r14, r0)
            int r5 = r5 - r6
            r2.privateChatNoDisturbNumber = r5
        L_0x021b:
            int r0 = r2.privateChatNoDisturbNumber
            int r0 = r4 - r0
            boolean r5 = com.baidu.android.imsdk.BIMManager.isD4Bar
            if (r5 == 0) goto L_0x0225
            r5 = r15
            goto L_0x0226
        L_0x0225:
            r5 = 0
        L_0x0226:
            int r0 = r0 + r5
            r2.totalUnread = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "最终返回结果 ===> 陌生人未读 : "
            java.lang.StringBuilder r0 = r0.append(r5)
            int r5 = r2.dotUnread
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r5 = " 咨询的总未读数: "
            java.lang.StringBuilder r0 = r0.append(r5)
            int r5 = r2.consultUnread
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r5 = " 包含官方号的总未读 : "
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.StringBuilder r0 = r0.append(r4)
            boolean r5 = com.baidu.android.imsdk.BIMManager.isD4Bar
            if (r5 == 0) goto L_0x0258
            java.lang.String r5 = " 去除官方号、包含咨询的总未读: "
            goto L_0x025a
        L_0x0258:
            java.lang.String r5 = " 去除官方号的总未读: "
        L_0x025a:
            java.lang.StringBuilder r0 = r0.append(r5)
            int r5 = r2.totalUnread
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r5 = " 私信免打扰未读数："
            java.lang.StringBuilder r0 = r0.append(r5)
            int r5 = r2.privateChatNoDisturbNumber
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.baidu.android.imsdk.utils.LogUtils.d(r3, r0)
            goto L_0x027e
        L_0x0278:
            r21 = r1
            r1 = r4
            r10 = r6
            r22 = r7
        L_0x027e:
            org.json.JSONArray r0 = r13.eventList
            java.lang.String r3 = "session_onResult"
            com.baidu.android.imsdk.utils.Utility.addEventList(r0, r3)
            if (r12 == 0) goto L_0x02b3
            android.content.Context r15 = mContext
            int r0 = r11.businessType
            int r3 = r11.mode
            r16 = r0
            r17 = r3
            r18 = r22
            r20 = r1
            com.baidu.android.imsdk.media.bean.SessionParam r0 = com.baidu.android.imsdk.media.bean.SessionParam.getListNextParam(r15, r16, r17, r18, r20)
            java.lang.String r3 = "Sucess!"
            r4 = 0
            r12.onResult(r4, r3, r2, r0)
            r13.errCode = r4
            java.lang.String r0 = "getChatSession_Sucess!"
            r13.errMsg = r0
            long r3 = java.lang.System.currentTimeMillis()
            r13.endTime = r3
            android.content.Context r0 = mContext
            java.lang.String r3 = r11.screenKey
            com.baidu.android.imsdk.ubc.ScreenUbc.onEvent(r0, r3, r13)
        L_0x02b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.getChatSession(com.baidu.android.imsdk.media.bean.SessionParam, com.baidu.android.imsdk.media.listener.BIMValuesCallBack, com.baidu.android.imsdk.ubc.ScreenUbc$MethodInfo):void");
    }

    public void updateAggBusinessChatSessions(ChatSession classSession) {
        ChatSession chatSession = classSession;
        SessionManager.getInstance(mContext).handleConsultUnreadNum(chatSession);
        int gfhUnread = ChatMsgManager.getAdvisoryGfhUnReadMsgCount(mContext, 0);
        List<ChatSession> gfhSession = getInstance(mContext).getSessionByGfhPA(27, 0);
        if (gfhSession != null && gfhSession.size() > 1) {
            Collections.sort(gfhSession, new Comparator<ChatSession>() {
                public int compare(ChatSession session1, ChatSession session2) {
                    if (session1.getLastMsgTime() > session2.getLastMsgTime()) {
                        return -1;
                    }
                    if (session1.getLastMsgTime() < session2.getLastMsgTime()) {
                        return 1;
                    }
                    return 0;
                }
            });
        }
        Pair<ChatSession, Boolean> pair = getInstance(mContext).getAndCompareLastBusiSession(27, getInstance(mContext).getNewAdvisoryChatSessions(27, -1, 0, 0, Long.MAX_VALUE, -1, 1, 1), gfhSession, gfhUnread);
        ChatSession newSession = (ChatSession) pair.first;
        boolean isGfhSession = ((Boolean) pair.second).booleanValue();
        if (newSession != null) {
            LogUtils.d(TAG, "notifyBusiSessionChange newSession = " + newSession.toString());
            getInstance(mContext).updateLastBusiSession(newSession, isGfhSession);
            if (isGfhSession) {
                chatSession.setClassShow(1);
                chatSession.setCategory(9);
                chatSession.setChatType(58);
            }
            chatSession.setLastMsg(newSession.getLastMsg());
            chatSession.setExt(newSession.getExt());
            chatSession.setLastMsgSenderName(newSession.getLastMsgSenderName());
            chatSession.setDraft(newSession.getDraft());
        }
    }

    public void updateUserSessionExtAndNotify(int category, long contacts, String sessionExt) {
        ChatMessageDBManager.getInstance(mContext).updateChatRecordExtAndNotify(category, contacts, sessionExt);
    }

    public void fetchSessionListByClass(int classType, BIMValuesCallBack<GetSessionResult, SessionParam> callBack, ScreenUbc.MethodInfo info, String screenKey) {
        if (classType > 0) {
            final int i2 = classType;
            final ScreenUbc.MethodInfo methodInfo = info;
            final BIMValuesCallBack<GetSessionResult, SessionParam> bIMValuesCallBack = callBack;
            final String str = screenKey;
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() {
                public void run() {
                    List<Integer> types = new ArrayList<>();
                    types.add(Integer.valueOf(i2));
                    Utility.addEventList(methodInfo.eventList, "! getChatRecordsByClass");
                    ArrayList<ChatSession> sessions = ChatSessionManagerImpl.this.getChatRecordsByClass(0, types);
                    GetSessionResult result = new GetSessionResult();
                    result.hasMore = false;
                    result.sessionList = sessions;
                    BIMValuesCallBack bIMValuesCallBack = bIMValuesCallBack;
                    if (bIMValuesCallBack != null) {
                        bIMValuesCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, result, null);
                        methodInfo.errCode = 0;
                        methodInfo.errMsg = "fetchSessionListByClass_Sucess!";
                        methodInfo.endTime = System.currentTimeMillis();
                        ScreenUbc.onEvent(ChatSessionManagerImpl.mContext, str, methodInfo);
                    }
                }
            });
        }
    }

    public void getSessionByGfhPA(IMediaGetChatSessionListener listener, int businessType) {
        ChatSession chatSession;
        if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
            List<PaInfo> list = PaInfoDBManager.getInstance(mContext).queryPaInfoByExt(String.valueOf(businessType));
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (PaInfo pa : list) {
                    if (!(pa == null || pa.getPaId() <= 0 || (chatSession = ChatMessageDBManager.getInstance(mContext).getChatRecord(new ChatObject(mContext, 0, pa.getPaId()))) == null)) {
                        chatSession.setBusinessType(businessType);
                        updatePADesc(chatSession, chatSession.getLastMsg());
                        arrayList.add(chatSession);
                    }
                }
                if (listener != null) {
                    listener.onMediaGetChatSessionResult(0, ChatMsgManager.getAdvisoryGfhUnReadMsgCount(mContext, 0), 0, false, arrayList);
                }
            } else if (listener != null) {
                listener.onMediaGetChatSessionResult(0, 0, 0, false, (List<ChatSession>) null);
            }
        } else if (listener != null) {
            listener.onMediaGetChatSessionResult(1000, 0, 0, false, (List<ChatSession>) null);
        }
    }

    public MediaGetChatSessionResult getSessionByGfhPA(int businessType) {
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            int i2 = businessType;
            return new MediaGetChatSessionResult(1000, 0, 0, false, (List<ChatSession>) null);
        }
        List<PaInfo> list = PaInfoDBManager.getInstance(mContext).queryPaInfoByExt(String.valueOf(businessType));
        if (list == null) {
            int i3 = businessType;
        } else if (list.isEmpty()) {
            int i4 = businessType;
        } else {
            List<ChatSession> chatSessions = new ArrayList<>();
            for (PaInfo pa : list) {
                if (pa == null) {
                    int i5 = businessType;
                } else if (pa.getPaId() > 0) {
                    ChatSession chatSession = ChatMessageDBManager.getInstance(mContext).getChatRecord(new ChatObject(mContext, 0, pa.getPaId()));
                    if (chatSession != null) {
                        chatSession.setBusinessType(businessType);
                        updatePADesc(chatSession, chatSession.getLastMsg());
                        chatSessions.add(chatSession);
                    } else {
                        int i6 = businessType;
                    }
                }
            }
            int i7 = businessType;
            return new MediaGetChatSessionResult(0, ChatMsgManager.getAdvisoryGfhUnReadMsgCount(mContext, 0), 0, false, chatSessions);
        }
        return new MediaGetChatSessionResult(0, 0, 0, false, (List<ChatSession>) null);
    }

    public List<ChatSession> getSessionByGfhPA(int businessType, long timeInterval) {
        List<PaInfo> list;
        ChatSession chatSession;
        List<ChatSession> chatSessions = new ArrayList<>();
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext) || (list = PaInfoDBManager.getInstance(mContext).queryPaInfoByExt(String.valueOf(businessType))) == null || list.isEmpty()) {
            return chatSessions;
        }
        for (PaInfo pa : list) {
            if (!(pa == null || pa.getPaId() <= 0 || (chatSession = ChatMessageDBManager.getInstance(mContext).getChatRecord(new ChatObject(mContext, 0, pa.getPaId(), timeInterval))) == null)) {
                chatSession.setBusinessType(businessType);
                updatePADesc(chatSession, chatSession.getLastMsg());
                chatSessions.add(chatSession);
            }
        }
        return chatSessions;
    }

    public void getUnReadChatSession(final SessionParam param, final BIMValuesCallBack<GetSessionResult, SessionParam> callBack) {
        if (param != null) {
            param.sortUpdateTimeEnd = Long.MAX_VALUE;
            if (param.count <= 0) {
                param.count = 3;
            }
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() {
                public void run() {
                    List<ChatSession> sessions = SessionDBManager.getInstance(ChatSessionManagerImpl.mContext).getNewUnReadSessionList(param.sortUpdateTimeBegin, param.sortUpdateTimeEnd, param.count, param.asyncUnReadChatTypes);
                    GetSessionResult result = new GetSessionResult();
                    result.sessionList = ChatSessionManagerImpl.this.completeSessionInfo(sessions);
                    result.totalUnread = ChatMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).getAllNewMsgCount(param.unreadNumChatTypes);
                    BIMValuesCallBack bIMValuesCallBack = callBack;
                    if (bIMValuesCallBack != null) {
                        bIMValuesCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, result, null);
                    }
                }
            });
        } else if (callBack != null) {
            callBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, GetSessionResult.getFailResult(), null);
        }
    }

    public void getFilterSessionsByBusiness(int businessType, long beginMsgid, long endMsgid, int count, Map<String, Integer> filters, List<Integer> follows, IMediaGetChatSessionListener listener) {
        IMediaGetChatSessionListener iMediaGetChatSessionListener = listener;
        if (!AccountManager.isCuidLogin(mContext)) {
            JSONObject filterJson = new JSONObject();
            if (filters != null) {
                try {
                    if (!filters.isEmpty()) {
                        for (Map.Entry<String, Integer> entry : filters.entrySet()) {
                            filterJson.put(entry.getKey(), entry.getValue());
                        }
                    }
                } catch (JSONException e2) {
                }
            }
            if (follows != null && !follows.isEmpty()) {
                JSONArray array = new JSONArray();
                for (Integer intValue : follows) {
                    array.put(intValue.intValue());
                }
                filterJson.put("consult_follow_state", array);
            }
            Intent intent = Utility.creatMethodIntent(mContext, Constants.METHOD_IM_CONSULT_IM_FILTER_SESSION_MSG);
            String listenerKey = ListenerManager.getInstance().addListener(iMediaGetChatSessionListener);
            intent.putExtra("count", count);
            intent.putExtra("msgid_begin", beginMsgid);
            intent.putExtra("msgid_end", endMsgid);
            intent.putExtra("bussiness_type", businessType);
            intent.putExtra(Constants.EXTRA_LISTENER_ID, listenerKey);
            intent.putExtra(Constants.EXTRA_BUSINESS_FILTER_INFO, filterJson.toString());
            try {
                IMServiceImpl.getInstance(mContext).enqueueWork(mContext, intent);
            } catch (Exception e3) {
                LogUtils.e(TAG, "getFilterSessionsByBusiness Exception ", e3);
                ListenerManager.getInstance().removeListener(listenerKey);
                if (iMediaGetChatSessionListener != null) {
                    listener.onMediaGetChatSessionResult(1003, 0, 0, false, (List<ChatSession>) null);
                }
            }
        } else if (iMediaGetChatSessionListener != null) {
            listener.onMediaGetChatSessionResult(0, 0, 0, false, (List<ChatSession>) null);
        }
    }

    public void setSessionCollectStatusByBusiness(int businessType, long contacterImUk, int sessionType, int status, BIMValueCallBack<Void> listener) {
        BIMValueCallBack<Void> bIMValueCallBack = listener;
        if (!AccountManager.isCuidLogin(mContext)) {
            IMUpdateCollectSessionTagRequest request = new IMUpdateCollectSessionTagRequest(mContext, businessType, contacterImUk, sessionType, status, listener);
            HttpHelper.executor(mContext, request, request);
        } else if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public int setSessionSubscribeStatusByBusiness(int businessType, long contacterImuk, int status) {
        if (AccountManager.isCuidLogin(mContext)) {
            return 0;
        }
        return BusinessMessageDBManager.getInstance(mContext).setSessionSubscribeStatusByBusiness(businessType, contacterImuk, status);
    }

    public List<ChatSession> getSessionsByContacter(ArrayList<String> contacterList) {
        return ChatMessageDBManager.getInstance(mContext).getMediaSessionsByContacters(contacterList);
    }

    public void updateChatRecordInternal(ContentValues values, String whereClause, String[] whereArgs) {
        ChatMessageDBManager.getInstance(mContext).updateChatRecordInternal(values, whereClause, whereArgs);
        SessionDBManager.getInstance(mContext).updateChatRecordInternal(values, whereClause, whereArgs);
    }

    public void getNovelChatSessions(SessionParam param, BIMValuesCallBack<GetSessionResult, SessionParam> callBack) {
        SessionParam sessionParam = param;
        BIMValuesCallBack<GetSessionResult, SessionParam> bIMValuesCallBack = callBack;
        if (sessionParam != null) {
            List<ChatSession> sessions = ChatMessageDBManager.getInstance(mContext).getNovelSessionList(sessionParam.sortUpdateTimeBegin, sessionParam.sortUpdateTimeEnd, sessionParam.count >= 0 ? sessionParam.count + 1 : sessionParam.count - 1, sessionParam.needTop, sessionParam.botChatTypes);
            GetSessionResult result = new GetSessionResult();
            result.hasMore = false;
            if (sessions != null && sessions.size() > Math.abs(sessionParam.count)) {
                sessions = sessions.subList(0, Math.abs(sessionParam.count));
                result.hasMore = true;
            }
            result.sessionList = completeSessionInfo(sessions);
            long end = 0;
            if (sessions != null && sessions.size() > 0) {
                end = sessions.get(sessions.size() - 1).getLastMsgTime();
            }
            if (bIMValuesCallBack != null) {
                bIMValuesCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, result, SessionParam.getListNextParam(mContext, sessionParam.businessType, sessionParam.mode, end, sessionParam.needTop));
            }
        } else if (bIMValuesCallBack != null) {
            bIMValuesCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, GetSessionResult.getFailResult(), null);
        }
    }
}
