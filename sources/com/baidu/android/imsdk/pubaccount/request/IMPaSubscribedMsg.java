package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class IMPaSubscribedMsg extends Message {
    private Context mContext;
    private long mPaId;

    public IMPaSubscribedMsg(Context context, long paId) {
        this.mContext = context;
        initCommonParameter(context);
        this.mPaId = paId;
        setNeedReplay(true);
        setType(109);
    }

    public long getPaId() {
        return this.mPaId;
    }

    public static IMPaSubscribedMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("pa_id")) {
            return new IMPaSubscribedMsg(context, intent.getLongExtra("pa_id", -1));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void buildBody() {
        JSONObject objMsg = new JSONObject();
        try {
            objMsg.put("method", 109);
            objMsg.put("appid", this.mAppid);
            objMsg.put("uk", this.mUk);
            objMsg.put("pa_uid", this.mPaId);
            this.mBody = objMsg.toString();
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "buildBody:", e2);
        }
    }

    public void handleMessageResult(Context context, JSONObject obj, int errorCode, String errMsg) {
        boolean subscribed = false;
        if (errorCode == 0) {
            try {
                subscribed = obj.optBoolean(TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE);
            } catch (Exception e2) {
                LogUtils.e(LogUtils.TAG, "handleMessageResult:", e2);
            }
        } else if (1001 == errorCode) {
            errorCode = 0;
            errMsg = "query from local db";
            subscribed = PaInfoDBManager.getInstance(context).isSubscribed(this.mPaId);
        }
        super.handleMessageResult(context, obj, errorCode, errMsg);
        PaManagerImpl.getInstance(context).onIsSubscribedResult(getListenerKey(), errorCode, errMsg, this.mPaId, subscribed);
    }
}
