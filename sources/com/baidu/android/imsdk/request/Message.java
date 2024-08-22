package com.baidu.android.imsdk.request;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BigEndianDataOutputStream;
import com.baidu.android.imsdk.utils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Message {
    private Context context;
    private boolean isHeartbeat = false;
    /* access modifiers changed from: protected */
    public long mAppid;
    /* access modifiers changed from: protected */
    public String mBody = "";
    private String mEventList;
    private boolean mIsSending = false;
    /* access modifiers changed from: protected */
    public String mListenerKey;
    protected int mPriority = 15;
    private int mType;
    private String mUUId = UUID.randomUUID().toString();
    /* access modifiers changed from: protected */
    public long mUk;
    private long msgId;
    private boolean needReSend = false;
    private boolean needReplay = false;

    /* access modifiers changed from: protected */
    public abstract void buildBody();

    public String getUUID() {
        return this.mUUId;
    }

    public void setUUID(String uuid) {
        this.mUUId = uuid;
    }

    public boolean isNeedReSend() {
        return this.needReSend;
    }

    public void setNeedReSend(boolean needReSend2) {
        this.needReSend = needReSend2;
    }

    public static void saveCmdMessage(Context context2, Message msg, String extra, int priority) {
        DBManager.getInstance(context2).saveCmdMsg(msg.getUUID(), msg.getType(), msg.getBody(), extra, priority, 0);
    }

    public static Message parseBody(Context context2, String uuid, String body, String extra) throws Exception {
        return null;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public byte[] getMessageBytes() {
        addRetryTime();
        ByteArrayOutputStream baos = null;
        try {
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            BigEndianDataOutputStream dos = new BigEndianDataOutputStream(baos2);
            if (!this.isHeartbeat) {
                dos.writeByte((byte) 2);
                dos.writeByte((byte) 1);
                dos.writeInt(this.mBody.getBytes().length);
                dos.writeLong(this.msgId);
                if (this.mBody.length() != 0) {
                    dos.write(this.mBody.getBytes());
                }
            } else {
                dos.writeByte((byte) 2);
                dos.writeByte((byte) 101);
            }
            byte[] byteArray = baos2.toByteArray();
            try {
                baos2.close();
            } catch (IOException e2) {
                LogUtils.e("Message", "baos.close", e2);
            }
            return byteArray;
        } catch (IOException e3) {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e4) {
                    LogUtils.e("Message", "baos.close", e4);
                }
            }
            return null;
        } catch (Throwable th2) {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e5) {
                    LogUtils.e("Message", "baos.close", e5);
                }
            }
            throw th2;
        }
    }

    private void addRetryTime() {
        if (!TextUtils.isEmpty(this.mBody)) {
            try {
                JSONObject body = new JSONObject(this.mBody);
                if (this.context != null) {
                    body.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.context));
                }
                if (TextUtils.isEmpty(body.optString("client_logid"))) {
                    body.put("client_logid", getMicTime());
                }
                if (TextUtils.isEmpty(body.optString("rpc"))) {
                    JSONObject rpc = new JSONObject();
                    rpc.put("rpc_retry_time", 0);
                    body.put("rpc", rpc.toString());
                }
                this.mBody = body.toString();
            } catch (JSONException e2) {
                LogUtils.e("Message", "getBody :", e2);
            }
        }
    }

    public static long getMicTime() {
        long nanoTime = System.nanoTime();
        return ((nanoTime - ((nanoTime / 1000000) * 1000000)) / 1000) + (System.currentTimeMillis() * 1000);
    }

    public long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(long msgId2) {
        this.msgId = msgId2;
    }

    public boolean isNeedReplay() {
        return this.needReplay;
    }

    public void setNeedReplay(boolean needReplay2) {
        this.needReplay = needReplay2;
    }

    public boolean isHeartbeat() {
        return this.isHeartbeat;
    }

    public void setHeartbeat(boolean isHeartbeat2) {
        this.isHeartbeat = isHeartbeat2;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public void onMsgSending(Context context2) {
    }

    public void isSending(boolean isSending) {
        this.mIsSending = isSending;
    }

    /* access modifiers changed from: protected */
    public void setSendingState(Context context2) {
        DBManager.getInstance(context2).updateCmdMsgSendStatus(getUUID(), 2);
    }

    public String toString() {
        if (this.mIsSending) {
            addRetryTime();
        }
        return "MsgId: " + this.msgId + " body: " + (this.isHeartbeat ? "heartbeat" : this.mBody);
    }

    public String getBody() {
        buildBody();
        if (this.mIsSending) {
            addRetryTime();
        }
        return this.mBody;
    }

    public long getUk() {
        return this.mUk;
    }

    public void setUk(long uk) {
        this.mUk = uk;
    }

    public long getAppid() {
        return this.mAppid;
    }

    public void setAppid(long appid) {
        this.mAppid = appid;
    }

    public void initCommonParameter(Context context2) {
        this.context = context2;
        setUk(AccountManager.getUK(context2));
        setAppid(AccountManager.getAppid(context2));
    }

    public void setListenerKey(String key) {
        this.mListenerKey = key;
    }

    public String getListenerKey() {
        return this.mListenerKey;
    }

    public void handleMessageResult(Context context2, JSONObject obj, int errorCode, String strMsg) {
        if (errorCode == 4001 || errorCode == 4004) {
            LoginManager.getInstance(context2).triggleLogoutListener(errorCode, strMsg);
        }
    }

    public String getEventList() {
        return this.mEventList;
    }

    public void setEventList(String eventList) {
        this.mEventList = eventList;
    }
}
