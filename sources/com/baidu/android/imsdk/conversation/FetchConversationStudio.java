package com.baidu.android.imsdk.conversation;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.media.message.ChatMessageCloudManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.IMServiceImpl;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class FetchConversationStudio {
    private static final int FETCH_INTERVAL_TIME = 1000;
    private static final int FIRST_RETRY = 0;
    private static final long FIRST_RETRY_TIME = 1000;
    private static final int MAX_RETRY_NUM = 3;
    /* access modifiers changed from: private */
    public static int PULL_COUNT = 160;
    private static final long SECOND_RETRY_TIME = 5000;
    private static final String TAG = "FetchConversationStudio";
    private static final long THIRD_RETRY_TIME = 10000;
    private static long mLocalCursorMsgId = 0;
    /* access modifiers changed from: private */
    public Runnable fetchRunnable = new Runnable() {
        public void run() {
            IMServiceImpl.mHandler.removeCallbacks(FetchConversationStudio.this.fetchRunnable);
            if (FetchConversationStudio.this.mReliableFetchCount.get() > 0) {
                FetchConversationStudio.this.mReliableFetchCount.set(0);
                if (ConversationStudioManImpl.getInstance(FetchConversationStudio.this.mContext).isReliable(FetchConversationStudio.this.mCastId)) {
                    FetchConversationStudio.this.fetchCastMsgByMsgId();
                    IMServiceImpl.mHandler.postDelayed(FetchConversationStudio.this.fetchRunnable, 1000);
                    return;
                }
                return;
            }
            LogUtils.d(FetchConversationStudio.TAG, "fetchRunnable reliableFetching reset ");
            FetchConversationStudio.this.mReliableFetching.set(false);
        }
    };
    /* access modifiers changed from: private */
    public long mCastId = -1;
    /* access modifiers changed from: private */
    public Context mContext;
    private IFetchMsgByIdListener mFetchMsgListener = new IFetchMsgByIdListener() {
        public void onFetchMsgByIdResult(int responseCode, String strMsg, String uuid, int category, long contacter, long beginId, long endId, int count, int realCount, long maxMsgId, ArrayList<ChatMsg> fetchedMsgs) {
            int i2 = responseCode;
            long j2 = endId;
            int i3 = count;
            int i4 = realCount;
            LogUtils.w(FetchConversationStudio.TAG, "onFetchCChannelMsgsResult response :" + responseCode + ", maxMsgid :" + maxMsgId + ", fetch :" + (fetchedMsgs != null ? Integer.valueOf(fetchedMsgs.size()) : "null") + ", real :" + i4 + ", count :" + i3 + "，  mcastId ： " + contacter + ", end :" + j2);
            long unused = FetchConversationStudio.this.mMaxMsgId = j2;
            if (i2 == 0) {
                if (i4 >= i3) {
                    IMServiceImpl.mHandler.removeCallbacks(FetchConversationStudio.this.fetchRunnable);
                    IMServiceImpl.mHandler.postDelayed(FetchConversationStudio.this.fetchRunnable, 1000);
                }
            } else if (i2 == 1024) {
                int unused2 = FetchConversationStudio.PULL_COUNT = 80;
                LogUtils.e(FetchConversationStudio.TAG, "onFetchCChannelMsgsResult：fetch msg length over 1024*1024");
            } else if (FetchConversationStudio.this.mFetchNum == 0) {
                LogUtils.e(FetchConversationStudio.TAG, "onFetchCChannelMsgsResult：fetch msg failed and first retry.");
                IMServiceImpl.mHandler.postDelayed(FetchConversationStudio.this.mReliableRunnable, 1000);
            }
        }
    };
    /* access modifiers changed from: private */
    public int mFetchNum = 0;
    /* access modifiers changed from: private */
    public long mMaxMsgId = 0;
    /* access modifiers changed from: private */
    public AtomicInteger mReliableFetchCount = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public AtomicBoolean mReliableFetching = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public Runnable mReliableRunnable = new Runnable() {
        public void run() {
            FetchConversationStudio.access$708(FetchConversationStudio.this);
            if (FetchConversationStudio.this.mFetchNum <= 3) {
                FetchConversationStudio.this.fetchCastMsgByMsgId();
                IMServiceImpl.mHandler.removeCallbacks(this);
                IMServiceImpl.mHandler.postDelayed(this, FetchConversationStudio.this.mFetchNum != 3 ? 5000 : 10000);
                return;
            }
            int unused = FetchConversationStudio.this.mFetchNum = 0;
            IMServiceImpl.mHandler.removeCallbacks(this);
        }
    };

    static /* synthetic */ int access$708(FetchConversationStudio x0) {
        int i2 = x0.mFetchNum;
        x0.mFetchNum = i2 + 1;
        return i2;
    }

    public FetchConversationStudio(Context context, long castId) {
        this.mContext = context;
        this.mCastId = castId;
    }

    public long getMcastId() {
        return this.mCastId;
    }

    public void toFetch(long maxMsgId) {
        if (this.mCastId > 0) {
            this.mMaxMsgId = maxMsgId;
            this.mReliableFetchCount.incrementAndGet();
            if (!this.mReliableFetching.get()) {
                LogUtils.d(TAG, "begin set fetchRunnable");
                this.mReliableFetching.set(true);
                IMServiceImpl.mHandler.removeCallbacks(this.fetchRunnable);
                IMServiceImpl.mHandler.postDelayed(this.fetchRunnable, 1000);
            }
        }
    }

    private void fetchCastMsg(long castId, long begigmsgid, long endmsgid) {
        ChatMessageCloudManager.fetchCChannelMsgsFromServer(this.mContext, 4, castId, begigmsgid, endmsgid, -1, -1, "", PULL_COUNT, 2, 0, this.mFetchMsgListener, this.mFetchNum);
    }

    public void fetchCastMsgByMsgId() {
        long localCursorMsgId = Utility.getReliableMaxMsgId(this.mContext, this.mCastId).longValue();
        LogUtils.d(TAG, "sp reliableMaxMsg:" + localCursorMsgId);
        if (localCursorMsgId > 0) {
            mLocalCursorMsgId = localCursorMsgId;
        }
        fetchCastMsg(this.mCastId, 1 + localCursorMsgId, Long.MAX_VALUE);
    }
}
