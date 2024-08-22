package com.baidu.android.imsdk;

import android.content.Context;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.mcast.CastServiceFactory;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.android.imsdk.mcast.UnLoginCastService;
import com.baidu.android.imsdk.utils.LogUtils;

public class BIMConversationStudio extends BIMConversation {
    private static String TAG = "BIMConversationStudio";
    private String mCastId = "";
    /* access modifiers changed from: private */
    public IMcastSetListener mCastListener;
    private UnLoginCastService mCastService = null;
    /* access modifiers changed from: private */
    public int mCastType;
    private String mCastUrl = null;
    private boolean mIsReliable = false;

    public BIMConversationStudio(Context conxt, BIMManager.CATEGORY category, String id, boolean isReliable, ChatSession chatSession, String url, int type) {
        super(conxt, category, id, chatSession, url, type);
        this.mCastUrl = url;
        this.mCastType = type;
        this.mCastId = id;
        this.mIsReliable = isReliable;
    }

    public void beginWithCompletion(IMcastSetListener listener) {
        this.mCastListener = listener;
        beginWithCompletion(Long.parseLong(this.mCastId), this.mIsReliable, listener);
    }

    /* access modifiers changed from: private */
    public void beginWithCompletion(final long castId, final boolean isReliable, IMcastSetListener listener) {
        this.mCastListener = listener;
        if (this.mCastType == 2) {
            ConversationStudioManImpl.getInstance(this.mContext).beginWithCompletion(castId, isReliable, new IMcastSetListener() {
                public void onResult(int responseCode, long castid, long roomId) {
                    if (responseCode == 1316) {
                        int unused = BIMConversationStudio.this.mCastType = 0;
                        BIMConversationStudio bIMConversationStudio = BIMConversationStudio.this;
                        bIMConversationStudio.beginWithCompletion(castId, isReliable, bIMConversationStudio.mCastListener);
                    }
                    if (BIMConversationStudio.this.mCastListener != null) {
                        BIMConversationStudio.this.mCastListener.onResult(responseCode, castid, roomId);
                    }
                }
            });
        } else {
            beginOtherCastType(listener);
        }
    }

    private void beginOtherCastType(IMcastSetListener listener) {
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.stopService(0);
            LogUtils.d(TAG, "stop service before start as service is not null.");
        }
        UnLoginCastService createCastService = CastServiceFactory.createCastService(this.mContext);
        this.mCastService = createCastService;
        try {
            listener.onResult(createCastService.startService(this.mCastId, this.mCastUrl, this.mCastType), this.session.getContacter(), -1);
        } catch (Exception e2) {
            LogUtils.e(TAG, "Exception ", e2);
        }
    }

    public void setPullInterval(int isms) {
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.setPullInterval(isms);
        }
    }

    public void endWithCompletion(IMcastSetListener listener) {
        if (this.mCastType == 2) {
            ConversationStudioManImpl.getInstance(this.mContext).endWithCompletion(this.session.getContacter(), listener);
        } else {
            UnLoginCastService unLoginCastService = this.mCastService;
            if (unLoginCastService != null) {
                unLoginCastService.stopService(0);
            }
            listener.onResult(0, this.session.getContacter(), -1);
        }
        try {
            unregisterLiveMsgReceiveListener(Long.valueOf(this.mCastId).longValue());
        } catch (NumberFormatException e2) {
            LogUtils.e(TAG, "Exception ", e2);
        }
    }

    public void playCastMessage() {
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.replay(this.mCastId, this.mCastUrl, this.mCastType);
        }
    }

    public void pauseCastMessage() {
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.pause();
        }
    }

    public void seekCastMessage(int position) {
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.seek(position);
        }
    }

    public void sendQuizOpts(long roomId, long mcastId, int optCode, String optExt, IMcastSetListener listener) {
        if (this.mCastType == 2) {
            ConversationStudioManImpl.getInstance(this.mContext).sendQuizOpts(roomId, mcastId, optCode, optExt, listener);
            return;
        }
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.stopService(0);
        }
        listener.onResult(0, this.session.getContacter(), -1);
    }
}
