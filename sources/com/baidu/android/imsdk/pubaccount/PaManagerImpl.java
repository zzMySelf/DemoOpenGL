package com.baidu.android.imsdk.pubaccount;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.UserSettingPaCmdMsg;
import com.baidu.android.imsdk.conversation.aggregate.LocalAggregateSessionManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.pubaccount.request.IMGetPaTypeRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaAcceptPushMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaClickQuickReply;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetInfoListRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetInfoRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetOneInfoRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetQuickReplies;
import com.baidu.android.imsdk.pubaccount.request.IMPaSearchListMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaSubscribeMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaSubscribedListMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaSubscribedMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaUnsubscribeMsg;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.IMServiceImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class PaManagerImpl {
    /* access modifiers changed from: private */
    public static final String TAG = PaManagerImpl.class.getSimpleName();
    /* access modifiers changed from: private */
    public static ArrayList<IAcceptMsgChangeListener> mAcceptMsgChangeListeners = new ArrayList<>();
    /* access modifiers changed from: private */
    public static Context mContext;
    private static volatile PaManagerImpl mInstance;
    /* access modifiers changed from: private */
    public static ArrayList<IPaSubscriptionChangeListener> mPaSubscriptionChangeListeners = new ArrayList<>();
    /* access modifiers changed from: private */
    public static ArrayList<ISubscriptionChangeListener> mSubscriptionChangeListeners = new ArrayList<>();
    private Dispatcher.MsgListener listener;
    private Timer mTimer = null;
    private Dispatcher.MsgListener userSettingPaListener = new Dispatcher.MsgListener() {
        public void dealMessage(int triggerReason, ChatMsg msg) {
            LogUtils.d(PaManagerImpl.TAG, "dealpa setting chnge Message " + (msg == null ? null : " msgs size is" + msg.toString()));
            if (msg == null) {
                LogUtils.d(PaManagerImpl.TAG, "dealpa setting chnge Message is null!");
            } else if (!(msg instanceof UserSettingPaCmdMsg)) {
                LogUtils.d(PaManagerImpl.TAG, "msg is not UserSettingPaCmdMsg!");
            } else {
                UserSettingPaCmdMsg paSettingMsg = (UserSettingPaCmdMsg) msg;
                final long paId = paSettingMsg.getPaId();
                final boolean acception = paSettingMsg.getSyncStatus() == 1;
                GetChatObjectInfoForRecordHandler handler = (GetChatObjectInfoForRecordHandler) GetChatObjectInfoForRecordManager.newInstance(PaManagerImpl.mContext, 0, paId, 1);
                if (handler != null) {
                    handler.getChatObjectInfo(paId, new CallBack() {
                        public void onSuccess(int type, int category, Object object) {
                            if (type == 1) {
                                PaInfoDBManager.getInstance(PaManagerImpl.mContext).acceptPaPush(paId, acception);
                            }
                            AnonymousClass2.this.sendPaSettingChangeBoradCast(type, paId, acception);
                            synchronized (PaManagerImpl.mAcceptMsgChangeListeners) {
                                Iterator it = PaManagerImpl.mAcceptMsgChangeListeners.iterator();
                                while (it.hasNext()) {
                                    ((IAcceptMsgChangeListener) it.next()).onAcceptMsgChange(type, paId, acception);
                                }
                            }
                        }

                        public void onError(int type, int category, long contacterId) {
                        }
                    });
                }
            }
        }

        public void dealMessage(int triggerReason, ArrayList<ChatMsg> arrayList) {
        }

        /* access modifiers changed from: private */
        public void sendPaSettingChangeBoradCast(int type, long paId, boolean acception) {
            Intent intent = new Intent(IMConstants.PA_SETTING_CHANGE_ACTION);
            intent.setPackage(PaManagerImpl.mContext.getPackageName());
            intent.putExtra("type", type);
            intent.putExtra("paId", paId);
            intent.putExtra("status", acception);
            PaManagerImpl.mContext.sendBroadcast(intent);
        }
    };

    private PaManagerImpl() {
        Class[] clsArr = {IMPaAcceptPushMsg.class, IMPaSearchListMsg.class, IMPaSubscribedListMsg.class, IMPaSubscribedMsg.class, IMPaSubscribeMsg.class, IMPaUnsubscribeMsg.class};
        int[] type = {105, 103, 104, 109, 100, 101};
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            MessageFactory.getInstance().addType(type[i2], clsArr[i2]);
        }
        this.listener = new Dispatcher.MsgListener() {
            public void dealMessage(int triggerReason, ChatMsg msg) {
                LogUtils.d(PaManagerImpl.TAG, "dealMessage " + (msg == null ? null : " msgs size is" + msg.toString()));
                if (msg != null) {
                    try {
                        JSONObject paSyncObj = new JSONObject(msg.getMsgContent());
                        final long paId = paSyncObj.optLong("pa_uid");
                        final boolean subscription = paSyncObj.optBoolean("subscription");
                        if (subscription) {
                            LogUtils.d(PaManagerImpl.TAG, "dealmessage subscription " + msg.toString());
                            GetChatObjectInfoForRecordHandler handler = (GetChatObjectInfoForRecordHandler) GetChatObjectInfoForRecordManager.newInstance(PaManagerImpl.mContext, 0, paId, 1);
                            if (handler != null) {
                                handler.getChatObjectInfo(paId, new CallBack() {
                                    public void onSuccess(int type, int category, Object object) {
                                        if (PaManagerImpl.mPaSubscriptionChangeListeners != null) {
                                            Iterator it = PaManagerImpl.mPaSubscriptionChangeListeners.iterator();
                                            while (it.hasNext()) {
                                                IPaSubscriptionChangeListener listener = (IPaSubscriptionChangeListener) it.next();
                                                if (listener != null) {
                                                    listener.onPaSubscriptionChangeResult(paId, subscription);
                                                }
                                            }
                                            synchronized (PaManagerImpl.mPaSubscriptionChangeListeners) {
                                                Iterator it2 = PaManagerImpl.mSubscriptionChangeListeners.iterator();
                                                while (it2.hasNext()) {
                                                    ISubscriptionChangeListener listener2 = (ISubscriptionChangeListener) it2.next();
                                                    if (listener2 != null) {
                                                        listener2.onSubscriptionResult(type, paId, object);
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    public void onError(int type, int category, long contacterId) {
                                    }
                                });
                                PaManagerImpl.this.getPaInfo(paId, (IGetPaInfoListener) null);
                                return;
                            }
                            return;
                        }
                        PaInfoDBManager.getInstance(PaManagerImpl.mContext).unSubscribePa(paId);
                        if (PaManagerImpl.mPaSubscriptionChangeListeners != null) {
                            Iterator it = PaManagerImpl.mPaSubscriptionChangeListeners.iterator();
                            while (it.hasNext()) {
                                ((IPaSubscriptionChangeListener) it.next()).onPaSubscriptionChangeResult(paId, subscription);
                            }
                            synchronized (PaManagerImpl.mPaSubscriptionChangeListeners) {
                                Iterator it2 = PaManagerImpl.mSubscriptionChangeListeners.iterator();
                                while (it2.hasNext()) {
                                    ISubscriptionChangeListener listener = (ISubscriptionChangeListener) it2.next();
                                    if (listener != null) {
                                        listener.onUnSubscriptionResult(paId);
                                    }
                                }
                            }
                        }
                    } catch (JSONException e2) {
                        LogUtils.e(LogUtils.TAG, "json error dealMessage:", e2);
                    }
                }
            }

            public void dealMessage(int triggerReason, ArrayList<ChatMsg> arrayList) {
            }
        };
        Dispatcher.Event event = new Dispatcher.Event();
        event.setCategory(2);
        event.setType(20);
        Dispatcher.registerListener(event, this.listener);
        Dispatcher.Event userSettingPaEvent = new Dispatcher.Event();
        userSettingPaEvent.setCategory(2);
        userSettingPaEvent.setType(23);
        Dispatcher.registerListener(userSettingPaEvent, this.userSettingPaListener);
    }

    public void delPaLocalInfosByPaType(final int paType) {
        TaskManager.getInstance(mContext).submitForNetWork(new Runnable() {
            public void run() {
                LogUtils.d(PaManagerImpl.TAG, "---delPaLocalInfosByPaType---paType = " + paType);
                ChatMessageDBManager.getInstance(PaManagerImpl.mContext).delPaLocalInfosByPaType(paType);
            }
        });
    }

    public void syncAndQueryAllPaInfo() {
        LogUtils.d(TAG, "syncAndQueryAllPaInfo begin");
        String synkey = Constants.KEY_PA_SUBSCRIBE_SYNC_TIME + AccountManager.getAppid(mContext) + AccountManager.getUid(mContext);
        if (Utility.readBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, true) && Utility.isNeedSync(mContext, synkey)) {
            Utility.writeLongData(mContext, synkey, System.currentTimeMillis() + Utility.getPaSyncDelay());
            syncAllPainfo(mContext);
        }
    }

    public static synchronized PaManagerImpl getInstance(Context context) {
        PaManagerImpl paManagerImpl;
        synchronized (PaManagerImpl.class) {
            if (mInstance == null && mInstance == null) {
                mContext = context.getApplicationContext();
                mInstance = new PaManagerImpl();
            }
            paManagerImpl = mInstance;
        }
        return paManagerImpl;
    }

    public void registerPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener listener2) {
        if (listener2 != null && !mPaSubscriptionChangeListeners.contains(listener2)) {
            mPaSubscriptionChangeListeners.add(listener2);
        }
    }

    public void unregisterPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener listener2) {
        if (listener2 != null && mPaSubscriptionChangeListeners.contains(listener2)) {
            mPaSubscriptionChangeListeners.remove(listener2);
        }
    }

    public List<PaInfo> querySubscribedPaListSync(Context context) {
        List<PaInfo> list = PaInfoDBManager.getInstance(mContext).querySubscribedPaList();
        List<PaInfo> newlist = new ArrayList<>();
        if (list != null) {
            for (PaInfo p : list) {
                if (p.getTPL() == AccountManagerImpl.getInstance(mContext).getAppid()) {
                    newlist.add(p);
                }
            }
        }
        return newlist;
    }

    public PaInfo getPaInfo(long paId) {
        return PaInfoDBManager.getInstance(mContext).queryPaInfo(paId);
    }

    public int setPaQuickRelies(long paId, String quickRelies, long lastRefreshTime) {
        return PaInfoDBManager.getInstance(mContext).setPaQuickRelies(paId, quickRelies, lastRefreshTime);
    }

    public void subscribePa(final long paId, ISubscribePaListener listener2) {
        final String key = ListenerManager.getInstance().addListener(listener2);
        if (AccountManager.isLogin(mContext)) {
            getPaInfo(paId, new IGetPaInfoListener() {
                public void onGetPaInfoResult(int errorCode, String strMsg, PaInfo paInfo) {
                    if (errorCode == 0) {
                        Intent intent = Utility.creatMethodIntent(PaManagerImpl.mContext, 100);
                        intent.putExtra(Constants.EXTRA_LISTENER_ID, key);
                        intent.putExtra("pa_id", paId);
                        intent.putExtra(Constants.EXTRA_PA_INFO, paInfo);
                        try {
                            IMServiceImpl.getInstance(PaManagerImpl.mContext).enqueueWork(PaManagerImpl.mContext, intent);
                        } catch (Exception e2) {
                            ListenerManager.getInstance().removeListener(key);
                            PaManagerImpl.this.onSubscribePaResult(key, 1003, Constants.ERROR_MSG_SERVICE_ERROR, paId);
                            LogUtils.e(PaManagerImpl.TAG, "Exception ", e2);
                        }
                    } else {
                        PaManagerImpl.this.onSubscribePaResult(key, errorCode, strMsg, paId);
                    }
                }
            });
        } else {
            onSubscribePaResult(key, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, paId);
        }
    }

    public void unsubscribePa(long paId, ISubscribePaListener listener2) {
        String key = ListenerManager.getInstance().addListener(listener2);
        if (AccountManager.isLogin(mContext)) {
            Intent intent = Utility.creatMethodIntent(mContext, 101);
            intent.putExtra(Constants.EXTRA_LISTENER_ID, key);
            intent.putExtra("pa_id", paId);
            try {
                IMServiceImpl.getInstance(mContext).enqueueWork(mContext, intent);
            } catch (Exception e2) {
                ListenerManager.getInstance().removeListener(key);
                onUnsubscribePaResult(key, 1003, Constants.ERROR_MSG_SERVICE_ERROR, paId);
                LogUtils.e(TAG, "Exception ", e2);
            }
        } else {
            onUnsubscribePaResult(key, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, paId);
        }
    }

    public void getPaInfo(long paId, IGetPaInfoListener listener2) {
        IGetPaInfoListener iGetPaInfoListener = listener2;
        if (AccountManager.isLogin(mContext)) {
            String key = ListenerManager.getInstance().addListener(iGetPaInfoListener);
            long appid = AccountManager.getAppid(mContext);
            long uk = AccountManager.getUK(mContext);
            ArrayList<Long> paids = new ArrayList<>();
            paids.add(Long.valueOf(paId));
            IMPaGetOneInfoRequest painfoRequest = new IMPaGetOneInfoRequest(mContext, key, paids, appid, uk);
            HttpHelper.executor(mContext, painfoRequest, painfoRequest);
        } else if (iGetPaInfoListener != null) {
            iGetPaInfoListener.onGetPaInfoResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, (PaInfo) null);
        }
    }

    public void getPaQuickReplies(long paId, IGetQuickReplyListener listener2) {
        if (AccountManager.isLogin(mContext)) {
            PaInfo paInfo = getPaInfo(paId);
            QuickReply quickReply = QuickReply.createQuickReply(paInfo.getRepliesStr());
            if (quickReply == null || System.currentTimeMillis() >= (quickReply.getRefreshTime() * 1000) + paInfo.getLastRefreshTime()) {
                setPaQuickRelies(paId, "", System.currentTimeMillis());
                IMPaGetQuickReplies paGetQuickReplies = new IMPaGetQuickReplies(mContext, paId, ListenerManager.getInstance().addListener(listener2));
                HttpHelper.executor(mContext, paGetQuickReplies, paGetQuickReplies);
            } else if (quickReply.getStatus() == 0) {
                listener2.onGetQuickReply(quickReply, true);
            } else {
                listener2.onGetQuickReply((QuickReply) null, true);
            }
        } else if (listener2 != null) {
            listener2.onGetQuickReply((QuickReply) null, true);
        }
    }

    public void clickPaQuickReply(long paId, String buttonId, long versionId, IClickPaQuickReplyListener listener2) {
        IClickPaQuickReplyListener iClickPaQuickReplyListener = listener2;
        if (AccountManager.isLogin(mContext)) {
            IMPaClickQuickReply paClickQuickReply = new IMPaClickQuickReply(mContext, paId, buttonId, versionId, ListenerManager.getInstance().addListener(iClickPaQuickReplyListener));
            HttpHelper.executor(mContext, paClickQuickReply, paClickQuickReply);
        } else if (iClickPaQuickReplyListener != null) {
            iClickPaQuickReplyListener.onClickQuickReply(1000);
        }
    }

    public void getPaInfos(ArrayList<Long> paids, IGetPaInfosListener listener2) {
        ArrayList<Long> arrayList = paids;
        IGetPaInfosListener iGetPaInfosListener = listener2;
        if (AccountManager.isLogin(mContext)) {
            if (arrayList == null || paids.size() == 0) {
                iGetPaInfosListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, (ArrayList<PaInfo>) null);
                return;
            }
            long appid = AccountManager.getAppid(mContext);
            long uk = AccountManager.getUK(mContext);
            int times = paids.size() / 20;
            int times2 = paids.size() % 20 > 0 ? times + 1 : times;
            GetPaInfoSliceListener sliceListener = new GetPaInfoSliceListener(iGetPaInfosListener, times2);
            for (int i2 = 0; i2 < times2; i2++) {
                int toIndex = (i2 + 1) * 20 > paids.size() ? paids.size() : (i2 + 1) * 20;
                int i3 = toIndex;
                requestPaInfos(arrayList.subList(i2 * 20, toIndex), appid, uk, sliceListener);
            }
        } else if (iGetPaInfosListener != null) {
            iGetPaInfosListener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, (ArrayList<PaInfo>) null);
        }
    }

    private void requestPaInfos(List<Long> paids, long appid, long uk, GetPaInfoSliceListener listener2) {
        IMPaGetInfoListRequest getpainfolistrequest = new IMPaGetInfoListRequest(mContext, paids, appid, uk, listener2);
        HttpHelper.executor(mContext, getpainfolistrequest, getpainfolistrequest);
    }

    public void queryPaInfoList(IQuerySubscribedPaListListener listener2) {
        if (!AccountManager.isCuidLogin(mContext)) {
            IMPaGetInfoRequest getpainforequest = new IMPaGetInfoRequest(mContext, ListenerManager.getInstance().addListener(listener2), AccountManager.getAppid(mContext), AccountManager.getUK(mContext));
            HttpHelper.executor(mContext, getpainforequest, getpainforequest);
        }
    }

    public void searchPaList(String content, ISearchPaListListener listener2) {
        String key = ListenerManager.getInstance().addListener(listener2);
        if (AccountManager.isLogin(mContext)) {
            Intent intent = Utility.creatMethodIntent(mContext, 103);
            intent.putExtra(Constants.EXTRA_LISTENER_ID, key);
            intent.putExtra(Constants.EXTRA_PA_SEARCH_CONTENT, content);
            try {
                IMServiceImpl.getInstance(mContext).enqueueWork(mContext, intent);
            } catch (Exception e2) {
                ListenerManager.getInstance().removeListener(key);
                onSearchPaListResult(key, 1003, Constants.ERROR_MSG_SERVICE_ERROR, (List<PaInfo>) null);
                LogUtils.e(TAG, "Exception ", e2);
            }
        } else {
            onSearchPaListResult(key, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, (List<PaInfo>) null);
        }
    }

    public void querySubscribedPaList(IQuerySubscribedPaListListener listener2) {
        String key = ListenerManager.getInstance().addListener(listener2);
        if (AccountManager.isLogin(mContext)) {
            Intent intent = Utility.creatMethodIntent(mContext, 104);
            intent.putExtra(Constants.EXTRA_LISTENER_ID, key);
            try {
                IMServiceImpl.getInstance(mContext).enqueueWork(mContext, intent);
            } catch (Exception e2) {
                ListenerManager.getInstance().removeListener(key);
                onQueryScribedPaListResult(key, 1003, Constants.ERROR_MSG_SERVICE_ERROR, (List<PaInfo>) null);
                LogUtils.e(TAG, "Exception ", e2);
            }
        } else {
            onQueryScribedPaListResult(key, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, (List<PaInfo>) null);
        }
    }

    public void acceptPaPush(long paId, boolean acceptPush, IAcceptPaPushListener listener2) {
        String key = ListenerManager.getInstance().addListener(listener2);
        if (AccountManager.isLogin(mContext)) {
            Intent intent = Utility.creatMethodIntent(mContext, 105);
            intent.putExtra(Constants.EXTRA_LISTENER_ID, key);
            intent.putExtra("pa_id", paId);
            intent.putExtra(Constants.EXTRA_PA_ACCEPT_PUSH, acceptPush);
            try {
                IMServiceImpl.getInstance(mContext).enqueueWork(mContext, intent);
            } catch (Exception e2) {
                ListenerManager.getInstance().removeListener(key);
                onAcceptPaPushResult(key, 1003, Constants.ERROR_MSG_SERVICE_ERROR, paId);
                LogUtils.e(TAG, "Exception ", e2);
            }
        } else {
            onAcceptPaPushResult(key, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, paId);
        }
    }

    public void isSubscribed(long paId, IIsSubscribedListener listener2) {
        String key = ListenerManager.getInstance().addListener(listener2);
        if (AccountManager.isLogin(mContext)) {
            Intent intent = Utility.creatMethodIntent(mContext, 109);
            intent.putExtra(Constants.EXTRA_LISTENER_ID, key);
            intent.putExtra("pa_id", paId);
            try {
                IMServiceImpl.getInstance(mContext).enqueueWork(mContext, intent);
            } catch (Exception e2) {
                ListenerManager.getInstance().removeListener(key);
                onIsSubscribedResult(key, 1003, Constants.ERROR_MSG_SERVICE_ERROR, paId, false);
                LogUtils.e(TAG, "Exception ", e2);
            }
        } else {
            onIsSubscribedResult(key, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, paId, false);
        }
    }

    public void onSubscribePaResult(String key, int errorCode, String errMsg, long paId) {
        String str = TAG;
        LogUtils.d(str, "onSubscribePaResult----errorCode: " + errorCode + " msg: " + errMsg);
        ISubscribePaListener listener2 = (ISubscribePaListener) ListenerManager.getInstance().removeListener(key);
        if (listener2 != null) {
            listener2.onSubsribePaResult(errorCode, errMsg, paId);
        } else {
            LogUtils.d(str, "ISubscribePaListener is null");
        }
    }

    public void onUnsubscribePaResult(String key, int errorCode, String errMsg, long paId) {
        String str = TAG;
        LogUtils.d(str, "onUnscribePaResult----errorCode: " + errorCode + " msg: " + errMsg);
        ISubscribePaListener listener2 = (ISubscribePaListener) ListenerManager.getInstance().removeListener(key);
        if (listener2 != null) {
            listener2.onUnsubsribePaResult(errorCode, errMsg, paId);
        } else {
            LogUtils.d(str, "ISubscribePaListener is null");
        }
    }

    public void onGetPaInfoResult(String key, int errorCode, String errMsg, PaInfo paInfo) {
        String str = TAG;
        LogUtils.d(str, "onGetPaInfoResult----errorCode: " + errorCode + " msg: " + errMsg);
        IGetPaInfoListener listener2 = (IGetPaInfoListener) ListenerManager.getInstance().removeListener(key);
        if (listener2 != null) {
            listener2.onGetPaInfoResult(errorCode, errMsg, paInfo);
        } else {
            LogUtils.d(str, "IGetPaInfoListener is null");
        }
    }

    public void onSearchPaListResult(String key, int errorCode, String errMsg, List<PaInfo> paInfos) {
        String str = TAG;
        LogUtils.d(str, "onSearchPaResult----errorCode: " + errorCode + " msg: " + errMsg);
        ISearchPaListListener listener2 = (ISearchPaListListener) ListenerManager.getInstance().removeListener(key);
        if (listener2 != null) {
            listener2.onSearchPaListResult(errorCode, errMsg, paInfos);
        } else {
            LogUtils.d(str, "ISearchPaListListener is null");
        }
    }

    public void onQueryScribedPaListResult(String key, int errorCode, String errMsg, List<PaInfo> paList) {
        String str = TAG;
        LogUtils.d(str, "onQueryScribedPaListResult----errorCode: " + errorCode + " msg: " + errMsg);
        IQuerySubscribedPaListListener listener2 = (IQuerySubscribedPaListListener) ListenerManager.getInstance().removeListener(key);
        if (listener2 != null) {
            listener2.onQuerySubscribedPaResult(errorCode, errMsg, paList);
        } else {
            LogUtils.d(str, "IQuerySubscribePaListListener is null");
        }
    }

    public void onAcceptPaPushResult(String key, int errorCode, String errMsg, long paId) {
        String str = TAG;
        LogUtils.d(str, "onAcceptPaPushResult----errorCode: " + errorCode + " msg: " + errMsg);
        IAcceptPaPushListener listener2 = (IAcceptPaPushListener) ListenerManager.getInstance().removeListener(key);
        if (listener2 != null) {
            listener2.onAcceptPaPushResult(errorCode, errMsg, paId);
        } else {
            LogUtils.d(str, "IAcceptPaPushListener is null");
        }
    }

    public void onIsSubscribedResult(String key, int errorCode, String errMsg, long paId, boolean subscribed) {
        String str = TAG;
        LogUtils.d(str, "onIsSubscribedResult----errorCode: " + errorCode + " msg: " + errMsg);
        IIsSubscribedListener listener2 = (IIsSubscribedListener) ListenerManager.getInstance().removeListener(key);
        if (listener2 != null) {
            listener2.onIsSubscribedResult(errorCode, errMsg, paId, subscribed);
        } else {
            LogUtils.d(str, "IIsSubscribedListener is null");
        }
    }

    public void registerSubscriptionChangeListener(ISubscriptionChangeListener listener2) {
        synchronized (mSubscriptionChangeListeners) {
            mSubscriptionChangeListeners.add(listener2);
        }
    }

    public void unregisterPaSubscriptionChangeListener(ISubscriptionChangeListener listener2) {
        synchronized (mSubscriptionChangeListeners) {
            mSubscriptionChangeListeners.remove(listener2);
        }
    }

    public void registerAcceptChangeListener(IAcceptMsgChangeListener listener2) {
        if (listener2 != null) {
            synchronized (mAcceptMsgChangeListeners) {
                if (!mAcceptMsgChangeListeners.contains(listener2)) {
                    mAcceptMsgChangeListeners.add(listener2);
                }
            }
        }
    }

    public void unRegisterAcceptChangeListener(IAcceptMsgChangeListener listener2) {
        if (listener2 != null) {
            synchronized (mAcceptMsgChangeListeners) {
                mAcceptMsgChangeListeners.remove(listener2);
            }
        }
    }

    public void getPaType(long paId, IGetPaTypeListener listener2) {
        LogUtils.d(TAG, "getPaType listener =" + listener2);
        IMGetPaTypeRequest getPaTypeRequest = new IMGetPaTypeRequest(mContext, ListenerManager.getInstance().addListener(listener2), paId);
        HttpHelper.executor(mContext, getPaTypeRequest, getPaTypeRequest);
    }

    public void onGetPaTypeResult(String key, int errorCode, String errMsg, long paId, int type) {
        String str = TAG;
        LogUtils.d(str, "onGETPaTypeResult----errorCode: " + errorCode + " msg: " + errMsg);
        IGetPaTypeListener listener2 = (IGetPaTypeListener) ListenerManager.getInstance().removeListener(key);
        if (listener2 != null) {
            listener2.onGetPaType(errorCode, errMsg, paId, type);
        } else {
            LogUtils.d(str, "IGetPaTypeListener is null!");
        }
    }

    public void syncAllPainfo(Context context) {
        syncAllPainfo(context, (IGetPaInfosListener) null);
    }

    public void syncAllPainfo(Context context, final IGetPaInfosListener listener2) {
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        this.mTimer.schedule(new TimerTask() {
            public void run() {
                LogUtils.d(PaManagerImpl.TAG, "syncpa sdkversion =  " + IMConfigInternal.getInstance().getSDKVersionValue(PaManagerImpl.mContext));
                ArrayList<Long> paidlist = PaInfoDBManager.getInstance(PaManagerImpl.mContext).queryPaidList();
                if (paidlist == null) {
                    paidlist = new ArrayList<>();
                }
                LocalAggregateSessionManager.appendAggFolderContactIdOnSyncPaInfo(paidlist);
                if (paidlist == null || paidlist.size() == 0) {
                    LogUtils.e(PaManagerImpl.TAG, "syncpa syncAllPainfo paidlist is null");
                    IGetPaInfosListener iGetPaInfosListener = listener2;
                    if (iGetPaInfosListener != null) {
                        iGetPaInfosListener.onResult(0, Constants.ERROR_MSG_SUCCESS, (ArrayList<PaInfo>) null);
                        return;
                    }
                    return;
                }
                LogUtils.d(PaManagerImpl.TAG, "syncAllPainfo> paidlist = " + paidlist.toString());
                PaManagerImpl.this.getPaInfos(paidlist, new IGetPaInfosListener() {
                    public void onResult(int responseCode, String strMsg, ArrayList<PaInfo> painfos) {
                        if (responseCode == 0) {
                            Iterator<PaInfo> it = painfos.iterator();
                            while (it.hasNext()) {
                                PaInfo painfo = it.next();
                                LogUtils.d(PaManagerImpl.TAG, "syncAllPainfo> paid=" + painfo.getPaId() + ", classtype=" + painfo.getClassType() + ", classtitle=" + painfo.getClassTitle() + ", classshow=" + painfo.getClassshow() + ", marktop=" + painfo.getMarkTop() + ", markTopTime=" + painfo.getMarkTopTime());
                                PaInfoDBManager.getInstance(PaManagerImpl.mContext).subscribePa(painfo);
                                LocalAggregateSessionManager.aggOrSpreadOutSessionAfterPaInfoUpdate(PaManagerImpl.mContext, painfo);
                            }
                            ChatMessageDBManager.getInstance(PaManagerImpl.mContext).updateSessionClassAndNotify(painfos);
                            LocalAggregateSessionManager.handleAggSessionAfterPaInfoUpdate(PaManagerImpl.mContext, painfos);
                        }
                        if (listener2 != null) {
                            listener2.onResult(responseCode, strMsg, painfos);
                        }
                    }
                });
            }
        }, 1000);
    }

    public String getPaThirdId(long paid) {
        PaInfo paInfo = PaManager.getPaInfo(mContext, paid);
        if (paInfo != null) {
            return paInfo.getThirdId();
        }
        return "";
    }

    public List<PaInfo> getPaInfoListFromDb(List<Long> paids) {
        return PaInfoDBManager.getInstance(mContext).getPaInfoListFromDb(paids);
    }

    public PaInfo getPaInfoByThirdId(String thirdId) {
        return PaInfoDBManager.getInstance(mContext).getPaInfoByThirdId(thirdId);
    }
}
