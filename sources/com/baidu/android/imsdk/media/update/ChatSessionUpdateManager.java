package com.baidu.android.imsdk.media.update;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.response.MediaGetChatSessionResult;
import com.baidu.android.imsdk.consult.listener.IBusiSessionChangeListener;
import com.baidu.android.imsdk.conversation.aggregate.LocalAggregateSessionManager;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.media.SessionManager;
import com.baidu.android.imsdk.media.bean.GetSessionResult;
import com.baidu.android.imsdk.media.bean.SessionParam;
import com.baidu.android.imsdk.media.db.SessionDBManager;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.android.imsdk.media.listener.IBaseSessionUpdateListener;
import com.baidu.android.imsdk.media.listener.IChatSessionUpdateListener;
import com.baidu.android.imsdk.media.listener.IClearListener;
import com.baidu.android.imsdk.media.listener.ISessionUpdateManager;
import com.baidu.android.imsdk.pubaccount.IGetPaInfoListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatSessionUpdateManager implements DBBase.ChatSessionChangeOberser, IBusiSessionChangeListener {
    private static final String TAG = "ChatSessionUpdateManager";
    private static volatile ChatSessionUpdateManager mInstance;
    private Context mContext;
    private CopyOnWriteArrayList<IBaseSessionUpdateListener> mSessionChangeListener = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<IClearListener> mSessionClearListenerList = new CopyOnWriteArrayList<>();
    private ISessionUpdateManager mUpdateManager;

    private ChatSessionUpdateManager(Context context) {
        this.mContext = context.getApplicationContext();
        this.mUpdateManager = new DefaultUpdateManager(this.mContext);
    }

    public static ChatSessionUpdateManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ChatSessionUpdateManager.class) {
                if (mInstance == null) {
                    mInstance = new ChatSessionUpdateManager(context);
                }
            }
        }
        return mInstance;
    }

    public void registerRecordChangeListener(IBaseSessionUpdateListener listener) {
        LogUtils.d(TAG, "registerRecordChangeListener");
        if (listener != null && !this.mSessionChangeListener.contains(listener)) {
            this.mSessionChangeListener.add(listener);
        }
    }

    public void unregisterRecordChangeListener(IBaseSessionUpdateListener listener) {
        LogUtils.d(TAG, "unregisterMessageReceiveListener");
        if (listener != null) {
            this.mSessionChangeListener.remove(listener);
        }
    }

    public void registerClearListener(IClearListener listener) {
        LogUtils.d(TAG, "registerClearListener");
        if (listener != null && !this.mSessionClearListenerList.contains(listener)) {
            this.mSessionClearListenerList.add(listener);
        }
    }

    public void unRegisterClearListener(IClearListener listener) {
        LogUtils.d(TAG, "unRegisterClearListener");
        if (listener != null) {
            this.mSessionClearListenerList.remove(listener);
        }
    }

    public void doClearListenerNotify() {
        LogUtils.d(TAG, "doClearListenerNotify:" + this.mSessionClearListenerList.size());
        Iterator<IClearListener> iterator = this.mSessionClearListenerList.iterator();
        while (iterator.hasNext()) {
            IClearListener listener = iterator.next();
            if (listener == null) {
                iterator.remove();
            } else {
                LogUtils.d(TAG, "doClearListenerNotify onClear");
                listener.onClear();
            }
        }
    }

    public DBBase.ChatSessionChangeOberser getSessionDbOberser() {
        return this;
    }

    public IBusiSessionChangeListener getBusiSessionChangeListener() {
        return this;
    }

    public void setSessionUpdateManager(ISessionUpdateManager manager) {
        if (manager != null) {
            this.mUpdateManager = manager;
        }
    }

    public void notifyDbChange(int sessionFrom, int operation, List<ChatSession> sessions, boolean updateRelate) {
        if (sessions != null && sessions.size() != 0) {
            if (!updateRelate || containsAggSession(sessions)) {
                notifySessionChange(operation, sessions, this.mSessionChangeListener);
                return;
            }
            notifyUserSessionChange(sessionFrom, operation, this.mUpdateManager.filterNormalChatSessionUpdate(sessionFrom, operation, sessions));
            redirectToBusiSessionHandler(sessionFrom, operation, sessions);
            notifyUnifiedSessionChange(sessionFrom, operation, this.mUpdateManager.filterUnifiedSessionUpdate(sessionFrom, operation, sessions));
            notifySessionFromCChannel(sessionFrom, operation, this.mUpdateManager.filterCChannelSessionToUnifiedSession(sessionFrom, operation, sessions));
        }
    }

    private void redirectToBusiSessionHandler(int sessionFrom, final int operation, List<ChatSession> sessions) {
        ChatSession session;
        if (sessionFrom == 0) {
            Iterator<ChatSession> it = sessions.iterator();
            while (it.hasNext() && (session = it.next()) != null) {
                if (session.getBusinessType() == 27) {
                    PaInfo paInfo = IMBoxManager.getPaInfoSync(this.mContext, session.getPaid());
                    if (paInfo == null) {
                        IMBoxManager.getPaInfo(this.mContext, session.getPaid(), new IGetPaInfoListener() {
                            public void onGetPaInfoResult(int responseCode, String strMsg, PaInfo paInfo) {
                                if (paInfo != null && paInfo.getBusinessType() == 27) {
                                    ChatSessionUpdateManager.this.notifyBusiSessionChange(27, operation);
                                }
                            }
                        });
                    } else if (paInfo.getBusinessType() == 27) {
                        notifyBusiSessionChange(27, operation);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean containsAggSession(java.util.List<com.baidu.android.imsdk.chatmessage.ChatSession> r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0056
            int r1 = r6.size()
            if (r1 != 0) goto L_0x000a
            goto L_0x0056
        L_0x000a:
            java.util.Iterator r1 = r6.iterator()
        L_0x000e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0055
            java.lang.Object r2 = r1.next()
            com.baidu.android.imsdk.chatmessage.ChatSession r2 = (com.baidu.android.imsdk.chatmessage.ChatSession) r2
            int r3 = r2.getSessionFrom()
            r4 = 2
            if (r3 == r4) goto L_0x0037
            int r3 = r2.getClassSubType()
            r4 = 13
            if (r3 == r4) goto L_0x0037
            int r3 = r2.getClassType()
            if (r3 == r4) goto L_0x0037
            boolean r3 = com.baidu.android.imsdk.conversation.aggregate.LocalAggregateSessionManager.isAggFolderSession(r2)
            if (r3 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            goto L_0x000e
        L_0x0037:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "containsAggSession = true， session "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ChatSessionUpdateManager"
            com.baidu.android.imsdk.utils.LogUtils.d(r1, r0)
            r0 = 1
            return r0
        L_0x0055:
            return r0
        L_0x0056:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.media.update.ChatSessionUpdateManager.containsAggSession(java.util.List):boolean");
    }

    private void notifyUserSessionChange(int sessionFrom, int type, List<ChatSession> sessions) {
        if (sessions != null && sessions.size() != 0) {
            notifySessionChange(type, sessions, this.mSessionChangeListener);
            doNotifyUserClassTypeAgg(type, this.mUpdateManager.filterNotifyAggVirtualSession(sessionFrom, type, sessions));
        }
    }

    private void notifySessionFromCChannel(int sessionFrom, int type, List<ChatSession> sessions) {
        if (sessions != null && sessions.size() != 0) {
            doUnifiedSessionChange(sessionFrom, type, sessions);
        }
    }

    private void notifyUnifiedSessionChange(int sessionFrom, int type, List<ChatSession> sessions) {
        if (sessions != null && sessions.size() != 0) {
            notifySessionChange(type, sessions, this.mSessionChangeListener);
            doNotifyStrangerFolder(type, this.mUpdateManager.filterNotifyStrangerFolder(sessionFrom, type, sessions));
            if (this.mUpdateManager.needUpdateLocalAggFolder(sessionFrom, type, sessions)) {
                LocalAggregateSessionManager.updateLocalAggFolderOnSecondarySessionUpdate(this.mContext, type, sessions);
            }
        }
    }

    private void doNotifyStrangerFolder(int type, List<ChatSession> sessions) {
        ChatSession stranger;
        if (sessions != null && sessions.size() != 0) {
            List<ChatSession> sessionList = SessionDBManager.getInstance(this.mContext).getNoAggStrangerSessionList(0, Long.MAX_VALUE, 1);
            if (sessionList == null || sessionList.size() == 0) {
                SessionDBManager.getInstance(this.mContext).delAllStrangerSession();
                return;
            }
            if (Constants.isDebugMode()) {
                for (ChatSession session : sessionList) {
                    LogUtils.e(TAG, "doNotifyStrangerFolder session :" + session.toString());
                }
            }
            updateStrangerCount(type, sessions);
            ChatSession stranger2 = SessionDBManager.getInstance(this.mContext).getStrangerFolderSession();
            if (stranger2 != null) {
                stranger = buildStrangerFolder(stranger2, sessionList.get(0));
                if (type == 2) {
                    type = 1;
                }
            } else {
                stranger = buildStrangerFolder((ChatSession) null, sessionList.get(0));
                type = 0;
            }
            List<ChatSession> strangers = new ArrayList<>();
            strangers.add(stranger);
            SessionDBManager.getInstance(this.mContext).updateSessionListWithNotify(strangers, 1, type);
        }
    }

    private void updateStrangerCount(int type, List<ChatSession> sessions) {
        if (sessions != null && sessions.size() != 0 && type == 8) {
            int count = 0;
            for (ChatSession session : sessions) {
                if (session.getIsStranger() == 0) {
                    count = (int) (((long) count) - session.getNewMsgSum());
                } else {
                    count = (int) (((long) count) + session.getNewMsgSum());
                }
            }
            SessionManager.getInstance(this.mContext).updateStrangerFolderCount(count);
        }
    }

    private ChatSession buildStrangerFolder(ChatSession stranger, ChatSession lastStranger) {
        if (lastStranger == null) {
            return null;
        }
        if (stranger == null) {
            stranger = new ChatSession(0, 0, 0, "");
        }
        stranger.setIsStranger(1);
        stranger.setClassType(12);
        stranger.setSessionFrom(2);
        stranger.setLastMsg(lastStranger.getLastMsg());
        stranger.setLastMsgTime(lastStranger.getLastMsgTime());
        stranger.setNewMsgSum((long) SessionManager.getInstance(this.mContext).getStrangerUnread());
        stranger.setChatType(0);
        stranger.setLastMsgId(lastStranger.getLastMsgId());
        stranger.setBusinessType(3);
        stranger.setSortTime(lastStranger.getSortTime());
        stranger.setIsClicked(lastStranger.getIsClicked());
        stranger.setState(lastStranger.getState());
        return stranger;
    }

    private void notifySessionChange(int operation, List<ChatSession> sessions, List<IBaseSessionUpdateListener> listeners) {
        ArrayList<IBaseSessionUpdateListener> chatRecordChangeListener = new ArrayList<>(listeners);
        if (chatRecordChangeListener.size() != 0) {
            completeSessionBusinessType(sessions);
            ChatSessionManagerImpl.getInstance(this.mContext).completeSessionInfo(sessions);
            LogUtils.d(TAG, "notifySessionChange type = " + operation + " session size = " + sessions.size());
            for (ChatSession session : sessions) {
                LogUtils.d(TAG, "notifySessionChange name = " + session.getName() + ", lastMsg = " + session.getLastMsg());
            }
            doSessionChangeListenerNotify(operation, sessions, chatRecordChangeListener);
        }
    }

    private void completeSessionBusinessType(List<ChatSession> sessions) {
        if (sessions != null && sessions.size() != 0) {
            for (ChatSession session : sessions) {
                if (session.getBusinessType() <= 0) {
                    if (session.getCategory() == 0) {
                        if (session.getChatType() == 0) {
                            session.setBusinessType(1);
                        } else {
                            PaInfo info = PaInfoDBManager.getInstance(this.mContext).queryPaInfo(session.getPaid());
                            if (info != null) {
                                int busiType = info.getBusinessType();
                                session.setBusinessType(busiType <= 0 ? Utility.getBusinessType(info.getSubtype(), info.getSubsetType()) : busiType);
                            }
                        }
                    } else if (session.getCategory() == 1) {
                        session.setBusinessType(2);
                    } else if (session.getCategory() == 9) {
                        session.setBusinessType(27);
                    }
                }
            }
        }
    }

    public void doSessionChangeListenerNotify(int operation, List<ChatSession> sessions, ArrayList<IBaseSessionUpdateListener> listeners) {
        List<ChatSession> callBackSessions = new ArrayList<>();
        for (ChatSession session : sessions) {
            if (session.getClassSubType() != 13 && (IMConfigInternal.getInstance().getProductLine(this.mContext) != 4 || session.getCategory() == 1)) {
                if (session.getNewMsgSum() > 0 && BIMManager.isD4Bar && session.getClassType() == 10) {
                    int advisoryUnreadNum = ChatSessionManagerImpl.getInstance(this.mContext).getBusiSessionTotalUnread(27);
                    if (advisoryUnreadNum > 0) {
                        session.setNewMsgSum((long) advisoryUnreadNum);
                    } else if (ChatMsgManager.getAdvisoryGfhUnReadMsgCount(this.mContext, 0) > 0) {
                        session.setNewMsgSum(-1);
                    }
                }
                LogUtils.d(TAG, "doSessionChangeListenerNotify session :" + session);
                try {
                    callBackSessions.add(session.clone());
                } catch (CloneNotSupportedException e2) {
                    LogUtils.e(TAG, "ChatSessionChangerCallBack throw RuntimeException", e2);
                }
            }
        }
        if (callBackSessions.size() != 0) {
            Iterator<IBaseSessionUpdateListener> iterator = listeners.iterator();
            while (iterator.hasNext()) {
                IBaseSessionUpdateListener listener = iterator.next();
                if (listener == null) {
                    iterator.remove();
                } else if (listener instanceof IChatSessionUpdateListener) {
                    ((IChatSessionUpdateListener) listener).onChatSessionUpdate(operation, callBackSessions);
                } else if (listener instanceof IChatSessionChangeListener) {
                    for (ChatSession callBack : callBackSessions) {
                        if (operation == 2) {
                            ((IChatSessionChangeListener) listener).onChatRecordDelete(callBack.getCategory(), callBack.getContacter());
                        } else {
                            ((IChatSessionChangeListener) listener).onChatSessionUpdate(callBack, false);
                        }
                    }
                }
            }
        }
    }

    private void doNotifyUserClassTypeAgg(int type, List<ChatSession> sessions) {
        if (sessions != null && sessions.size() != 0) {
            List<Integer> types = new ArrayList<>();
            for (ChatSession session : sessions) {
                int classType = session.getClassType();
                if (Utility.isValidAggSession(classType, session.getClassShow()) && !types.contains(Integer.valueOf(classType))) {
                    types.add(Integer.valueOf(classType));
                }
            }
            if (types.size() > 0) {
                for (Integer intValue : types) {
                    int classtype = intValue.intValue();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(classtype));
                    List<ChatSession> sessionList = ChatMessageDBManager.getInstance(this.mContext).getChatRecordsByClass(2, arrayList);
                    if (sessionList == null || sessionList.size() == 0) {
                        type = 2;
                        ChatSession session2 = null;
                        try {
                            session2 = sessions.get(0).clone();
                        } catch (CloneNotSupportedException e2) {
                            LogUtils.d(TAG, "doAggSessionChangeNotify classtype exception");
                        }
                        if (session2 != null) {
                            session2.setSessionFrom(2);
                            sessionList = new ArrayList<>();
                            sessionList.add(session2);
                        }
                    } else {
                        sessionList.get(0).setSessionFrom(2);
                        sessionList.get(0).setNewMsgSum((long) ChatMessageDBManager.getInstance(this.mContext).getNewMsgCountOfClass(classtype));
                        if (type == 2) {
                            type = 1;
                        } else if (type == 0 && sessionList.size() > 1) {
                            type = 1;
                        }
                        if (sessionList.size() > 1) {
                            sessionList = sessionList.subList(0, 1);
                        }
                    }
                    notifySessionChange(type, sessionList, this.mSessionChangeListener);
                }
            }
        }
    }

    private void doNotifyUserStrangerFolder(int type, List<ChatSession> sessions) {
        if (sessions != null && sessions.size() != 0) {
            List<ChatSession> sessionList = ChatMessageDBManager.getInstance(this.mContext).getStrangerSessionList(0, Long.MAX_VALUE, 2);
            if (sessionList == null || sessionList.size() == 0) {
                type = 2;
                ChatSession session = null;
                try {
                    session = sessions.get(0).clone();
                } catch (CloneNotSupportedException e2) {
                    LogUtils.d(TAG, "doAggSessionChangeNotify stanger exception");
                }
                if (session != null) {
                    session.setSessionFrom(2);
                    session.setIsStranger(1);
                    sessionList = new ArrayList<>();
                    sessionList.add(session);
                }
            } else {
                sessionList.get(0).setSessionFrom(2);
                sessionList.get(0).setIsStranger(1);
                sessionList.get(0).setNewMsgSum((long) ChatMessageDBManager.getInstance(this.mContext).getStrangerUnReadCount(0));
                if (type == 2) {
                    type = 1;
                } else if (type == 0 && sessionList.size() > 1) {
                    type = 1;
                }
                if (sessionList.size() > 1) {
                    sessionList = sessionList.subList(0, 1);
                }
            }
            notifySessionChange(type, sessionList, this.mSessionChangeListener);
        }
    }

    private void doUnifiedSessionChange(int sessionFrom, int type, List<ChatSession> sessions) {
        LogUtils.d(TAG, "doUnifiedSessionChange onChatSessionUpdate type = " + type);
        List<ChatSession> sessionList = new ArrayList<>();
        if (sessions != null && sessions.size() > 0) {
            for (ChatSession session : sessions) {
                if (needForwardToUnifiedSession(session) || Utility.isValidAggSession(session.getClassType(), session.getClassShow())) {
                    LogUtils.d(TAG, "doUnifiedSessionChange onChatSessionUpdate isFullPushSession = " + session.isFullPushSession() + ";session:" + session);
                    sessionList.add(session);
                }
            }
        }
        if (sessionList.size() > 0) {
            completeSessionBusinessType(sessionList);
            ChatSession first = sessionList.get(0);
            switch (type) {
                case 0:
                    if (!updateMediaSessionNewSum(sessionList) && !insertFansGroupDraftSession(sessionList)) {
                        SessionManager.getInstance(this.mContext).getChatSessionFromServer(SessionParam.getNotifyRequestParam(this.mContext), (BIMValuesCallBack<GetSessionResult, SessionParam>) null);
                        return;
                    }
                    return;
                case 1:
                case 3:
                case 4:
                case 9:
                    if (Utility.isValidAggSession(first.getClassType(), first.getClassShow())) {
                        updateSessionByClassAndNotify(first.getClassType(), 1, first);
                        return;
                    } else {
                        updateMediaChatSession(type, sessionList);
                        return;
                    }
                case 2:
                    if (Utility.isValidAggSession(first.getClassType(), first.getClassShow())) {
                        updateSessionByClassAndNotify(first.getClassType(), 1, first);
                        return;
                    }
                    for (ChatSession session2 : sessionList) {
                        SessionDBManager.getInstance(this.mContext).delChatRecord(session2.getCategory(), session2.getContacter());
                    }
                    return;
                case 5:
                    for (ChatSession session3 : sessionList) {
                        SessionDBManager.getInstance(this.mContext).updateChatSessionMarkTop(session3.getCategory(), session3.getContacter(), session3.getMarkTop(), session3.getMarkTopTime());
                    }
                    return;
                case 6:
                    for (ChatSession session4 : sessionList) {
                        SessionDBManager.getInstance(this.mContext).updateChatSessionShield(session4.getCategory(), session4.getContacter(), session4.getShield(), session4.getShieldTime());
                    }
                    return;
                case 7:
                    for (ChatSession session5 : sessionList) {
                        SessionDBManager.getInstance(this.mContext).updateChatSessionDisturb(session5.getCategory(), session5.getContacter(), session5.getDisturb());
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean updateMediaSessionNewSum(List<ChatSession> sessions) {
        if (sessions == null || sessions.size() == 0) {
            return false;
        }
        List<ChatSession> sessionList = new ArrayList<>();
        for (ChatSession session : sessions) {
            if (session.getState() == 0) {
                ChatSession mediaSession = null;
                if (Utility.isValidAggSession(session.getClassType(), session.getClassShow())) {
                    mediaSession = SessionDBManager.getInstance(this.mContext).getChatSessionByClassType(session.getClassType());
                    if (mediaSession != null && mediaSession.getLastMsgTime() >= session.getLastMsgTime()) {
                        mediaSession.setNewMsgSum((long) ChatMessageDBManager.getInstance(this.mContext).getNewMsgCountOfClass(session.getClassType()));
                    }
                    if (BIMManager.hudongTop && session.getClassType() == 11) {
                        session.setNewMsgSum((long) ChatMessageDBManager.getInstance(this.mContext).getNewMsgCountOfClass(session.getClassType()));
                        mediaSession = session;
                    }
                } else if (session.getChatType() == 3 || session.getChatType() == 57) {
                    mediaSession = session;
                    ChatSession localSession = SessionDBManager.getInstance(this.mContext).getChatRecord(session.getCategory(), session.getContacter());
                    if (localSession != null && localSession.getLastMsgTime() >= session.getLastMsgTime()) {
                        localSession.setNewMsgSum(session.getNewMsgSum());
                    }
                } else if (session.isFullPushSession()) {
                    mediaSession = session;
                }
                if (mediaSession != null) {
                    LogUtils.d(TAG, "updateMeidaSessionNewSum-certDebug-待更新session.name: " + mediaSession.getName() + ", cert: " + mediaSession.getCertification());
                    LogUtils.d(TAG, "updateMediaSessionNewSum-certDebug-已更新session: " + mediaSession);
                    sessionList.add(mediaSession);
                }
            }
        }
        if (sessionList.size() > 0) {
            updateMediaChatSession(3, sessionList);
        }
        if (sessionList.size() == sessions.size()) {
            return true;
        }
        return false;
    }

    private boolean insertFansGroupDraftSession(List<ChatSession> sessions) {
        if (sessions == null || sessions.size() == 0) {
            return false;
        }
        List<ChatSession> result = new ArrayList<>();
        for (ChatSession session : sessions) {
            if (session.getState() == 3) {
                long maxId = ChatMessageDBManager.getInstance(this.mContext).getMaxMsgId();
                if (session.getLastMsgId() <= 0) {
                    session.setLastMsgId(maxId);
                }
                if (session.getSortTime() <= 0) {
                    session.setSortTime(maxId);
                }
                if (session.getChatType() == 57) {
                    session.setBusinessType(2);
                }
                result.add(session);
            }
        }
        SessionDBManager.getInstance(this.mContext).updateSessionListWithNotify(result, 1, 4);
        if (result.size() == sessions.size()) {
            return true;
        }
        return false;
    }

    private void updateMediaChatSession(int type, List<ChatSession> sessionList) {
        if (sessionList != null && sessionList.size() != 0) {
            for (ChatSession session : sessionList) {
                long maxId = ChatMessageDBManager.getInstance(this.mContext).getMaxMsgId(new ChatObject(this.mContext, session.getCategory(), session.getContacter()));
                if (session.getCategory() == 1) {
                    maxId = Math.max(maxId, GroupMessageDAOImpl.getMaxLocalMsgId(this.mContext, String.valueOf(session.getContacterId())));
                }
                if (session.getLastMsgId() <= 0) {
                    session.setLastMsgId(maxId);
                }
                if (session.getSortTime() <= 0) {
                    session.setSortTime(maxId);
                }
                if (session.getChatType() == 3 || session.getChatType() == 57) {
                    session.setBusinessType(2);
                }
            }
            SessionDBManager.getInstance(this.mContext).updateSessionListWithNotify(sessionList, 1, type);
        }
    }

    private void updateSessionByClassAndNotify(int classType, int notifyType, ChatSession session) {
        if (SessionDBManager.getInstance(this.mContext).getChatSessionByClassType(classType) != null) {
            List<ChatSession> userSessions = ChatMessageDBManager.getInstance(this.mContext).getChatRecordsByClass(1, Collections.singletonList(Integer.valueOf(classType)));
            boolean isHuDdong = session != null && session.getClassType() == 11;
            if (userSessions == null || userSessions.size() == 0) {
                if (!BIMManager.hudongTop || !isHuDdong) {
                    SessionManager.getInstance(this.mContext).deleteSession(SessionParam.getBjhReadOrDelParam(0, 0, classType, 1), (BIMValueCallBack<Object>) null);
                    return;
                } else if (session != null) {
                    session.setLastMsg(IMConstants.HUDONG_DESC_DEFAULT);
                    session.setExt("");
                    session.setIsClicked(1);
                    session.setNewMsgSum(0);
                }
            }
            SessionDBManager.getInstance(this.mContext).updateSessionByClassAndNotify(classType, notifyType, session);
        }
    }

    public void notifyBusiSessionChange(int businessType, int operation) {
        List<ChatSession> busiSessions;
        LogUtils.d(TAG, "notifyBusiSessionChange operation = " + operation);
        MediaGetChatSessionResult result = ChatSessionManagerImpl.getInstance(this.mContext).getSessionByGfhPA(27);
        List<ChatSession> gfhSessions = result.sessions;
        int totalUnreadNum = ChatSessionManagerImpl.getInstance(this.mContext).getBusiSessionTotalUnread(businessType);
        List<ChatSession> busiSessions2 = ChatSessionManagerImpl.getInstance(this.mContext).getBusiChatSessionsFromDb(businessType, -1, 0, 0, Long.MAX_VALUE, -1, 1, totalUnreadNum > 0);
        if (busiSessions2 != null || totalUnreadNum > 0) {
            busiSessions = busiSessions2;
        } else {
            busiSessions = ChatSessionManagerImpl.getInstance(this.mContext).getBusiChatSessionsFromDb(businessType, -1, 0, 0, Long.MAX_VALUE, -1, 1);
        }
        if (gfhSessions != null && gfhSessions.size() > 1) {
            Collections.sort(gfhSessions, new Comparator<ChatSession>() {
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
        handleBusinessAndGfhSessionChange(businessType, operation, busiSessions, gfhSessions, result.totalUnReadMsgNum);
    }

    private void handleBusinessAndGfhSessionChange(int businessType, int operation, List<ChatSession> busiSession, List<ChatSession> gfhSession, int gfhUnreadNumber) {
        LogUtils.d(TAG, "handleBusinessAndGfhSessionChange operation = " + operation);
        ChatSession newSession = getNewConsultAggSession(businessType, busiSession, gfhSession, gfhUnreadNumber);
        ChatSession localSession = SessionDBManager.getInstance(this.mContext).getChatSessionByClassType(10);
        int notifyType = operation;
        if (localSession != null && newSession == null) {
            notifyType = 2;
        } else if (localSession == null && newSession != null) {
            notifyType = 0;
        } else if (notifyType == 2 && newSession != null) {
            notifyType = 1;
        } else if (notifyType == 0 && localSession != null) {
            notifyType = 1;
        }
        LogUtils.d(TAG, "notifyBusiSessionChange final notifyType = " + notifyType);
        if (notifyType == 2 || newSession == null) {
            SessionDBManager.getInstance(this.mContext).delChatRecordByClassType(10);
            return;
        }
        List<ChatSession> list = new ArrayList<>();
        list.add(newSession);
        SessionDBManager.getInstance(this.mContext).updateSessionListWithNotify(list, 1, notifyType);
    }

    public ChatSession getNewConsultAggSession(int businessType, List<ChatSession> busiSession, List<ChatSession> gfhSession, int gfhUnreadNumber) {
        LogUtils.d(TAG, "getNewConsultAggSession businessType = " + businessType);
        Pair<ChatSession, Boolean> pair = ChatSessionManagerImpl.getInstance(this.mContext).getAndCompareLastBusiSession(businessType, busiSession, gfhSession, gfhUnreadNumber);
        ChatSession newSession = (ChatSession) pair.first;
        boolean isGfhSession = ((Boolean) pair.second).booleanValue();
        if (newSession != null) {
            LogUtils.d(TAG, "notifyBusiSessionChange newSession = " + newSession.toString() + ", isGfhSession = " + isGfhSession);
            SessionManager.getInstance(this.mContext).handleConsultUnreadNum(newSession);
            ChatSessionManagerImpl.getInstance(this.mContext).updateLastBusiSession(newSession, isGfhSession);
        }
        return newSession;
    }

    public static boolean needForwardToUnifiedSession(ChatSession chatSession) {
        if (chatSession == null) {
            return false;
        }
        LogUtils.d(TAG, "needForwardToUnifiedSession isFullPushSession = " + chatSession.isFullPushSession() + ";session:" + chatSession);
        if (DefaultUpdateManager.C_CHANNEL_TO_UNIFIED_CHAT_TYPES.contains(Integer.valueOf(chatSession.getChatType())) || chatSession.isFullPushSession()) {
            return true;
        }
        return false;
    }
}
