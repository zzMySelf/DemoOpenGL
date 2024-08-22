package com.baidu.searchbox.net.interceptor.handlerthread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.baidu.searchbox.net.interceptor.UrlCollectionInterceptor;
import com.baidu.searchbox.net.interceptor.sqlite.UrlCollectionDatabaseHelper;
import com.baidu.searchbox.net.interceptor.sqlite.Utils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class UrlProcessHandlerThread extends HandlerThread {
    /* access modifiers changed from: private */
    public static String TAG = "UrlCollection";
    private static final String THREAD_NAME = "UrlProcessHandlerThread";
    private static UrlProcessHandlerThread sInstance;
    /* access modifiers changed from: private */
    public Handler urlProcessHandler = new Handler(getLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    UrlProcessHandlerThread.this.insertDBAction(msg);
                    return;
                case 1:
                    UrlProcessHandlerThread.this.netChangeAction(msg);
                    return;
                case 2:
                    UrlProcessHandlerThread.this.uploadAction(msg);
                    return;
                case 3:
                    UrlCollectionInterceptor.setIsReachable(Utils.isReachableServer());
                    return;
                default:
                    return;
            }
        }
    };

    private UrlProcessHandlerThread() {
        super(THREAD_NAME);
        start();
    }

    public static UrlProcessHandlerThread getInstance() {
        if (sInstance == null) {
            synchronized (UrlProcessHandlerThread.class) {
                if (sInstance == null) {
                    sInstance = new UrlProcessHandlerThread();
                }
            }
        }
        return sInstance;
    }

    public Handler getUrlProcessHandler() {
        return this.urlProcessHandler;
    }

    /* access modifiers changed from: private */
    public void insertDBAction(Message msg) {
        if (msg.obj != null) {
            JSONObject insertData = (JSONObject) msg.obj;
            try {
                if (UrlCollectionInterceptor.sIsReachable) {
                    insertData.put(UrlCollectionDatabaseHelper.UPLOAD_STATUS, "0");
                } else {
                    insertData.put(UrlCollectionDatabaseHelper.UPLOAD_STATUS, "1");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            long insertID = UrlCollectionDatabaseHelper.getInstance().insert(insertData);
            UrlCollectionInterceptor.sInsertDBNumber.incrementAndGet();
            if (UrlCollectionInterceptor.sIsReachable) {
                this.urlProcessHandler.sendMessage(UrlProcessMessage.getSendMessage(2, UrlProcessMessage.UPLOAD_DATA_ZERO, (int) insertID, msg.obj));
            }
        }
    }

    /* access modifiers changed from: private */
    public void netChangeAction(Message msg) {
        UrlCollectionInterceptor.setIsReachable(Utils.isReachableServer());
        if (UrlCollectionInterceptor.sIsReachable) {
            this.urlProcessHandler.sendMessage(UrlProcessMessage.getSendMessage(2, UrlProcessMessage.UPLOAD_DATA_ONE, UrlProcessMessage.DEFAULT_ID, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    public void uploadAction(final Message msg) {
        if (msg.arg1 == UrlProcessMessage.UPLOAD_DATA_ONE) {
            final List<JSONObject> list = UrlCollectionDatabaseHelper.getInstance().fetch(1);
            if (list.size() > 0) {
                Utils.asyncSendCollectionUrl(list.get(0), Utils.getServerAddressFromSDCard(), new PostDataCallback() {
                    public void onSuccess(int status, JSONObject postData) {
                        UrlCollectionDatabaseHelper.getInstance().delete(((JSONObject) list.get(0)).optInt("id", -1));
                        UrlCollectionInterceptor.sUploadSuccessNumber.incrementAndGet();
                        if (ProcessUtils.getCurProcessName() != null) {
                            Log.e(UrlProcessHandlerThread.TAG, ProcessUtils.getCurProcessName() + ",拦截的个数：" + UrlCollectionInterceptor.sEnQueueNumber.toString() + ",插入数据库个数：" + UrlCollectionInterceptor.sInsertDBNumber.toString() + ", 上传成功个数：" + UrlCollectionInterceptor.sUploadSuccessNumber.toString());
                        }
                        UrlProcessHandlerThread.this.urlProcessHandler.sendMessage(UrlProcessMessage.getSendMessage(2, UrlProcessMessage.UPLOAD_DATA_ONE, UrlProcessMessage.DEFAULT_ID, (Object) null));
                    }

                    public void onFail(int status, JSONObject postData) {
                    }
                });
            }
        } else if (msg.arg1 == UrlProcessMessage.UPLOAD_DATA_ZERO) {
            Utils.asyncSendCollectionUrl((JSONObject) msg.obj, Utils.getServerAddressFromSDCard(), new PostDataCallback() {
                public void onSuccess(int status, JSONObject postData) {
                    UrlCollectionDatabaseHelper.getInstance().delete(msg.arg2);
                    UrlCollectionInterceptor.sUploadSuccessNumber.incrementAndGet();
                }

                public void onFail(int status, JSONObject postData) {
                    UrlCollectionDatabaseHelper.getInstance().updateStatus(msg.arg2);
                }
            });
        }
    }
}
