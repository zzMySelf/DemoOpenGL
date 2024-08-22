package com.baidu.searchbox.playerserver;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.cyberplayer.sdk.statistics.DuMediaStatConstants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.swan.apps.process.def.MsgClientColumns;
import com.baidu.ubc.UBCManager;
import com.baidu.webkit.internal.ETAG;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

class PlayerPolicyImplement implements IPlayerPolicy {
    private static final int ADD_OBSERVER_WORK_MSG = 2;
    private static final int JELLY_BEAN_MR2 = 18;
    private static final int MAX_RETRY_COUNT = 1;
    private static final int MIN_UPDATE_INTERVAL = 10;
    private static final String PLAYER_SERVER = "https://mbd.baidu.com/playserver/ctlconf?";
    private static final int REMOVE_OBSERVER_WORK_MSG = 3;
    private static final String TAG = "PS_PlcyImplmnt";
    private static final int TIMER_UPDATE_WORK_MSG = 1;
    private volatile long lastReqSendTimestamp = 0;
    private volatile long mFirstReqSendTimestamp = 0;
    private HandlerThread mHandlerThread = null;
    private volatile long mLastReqSendTime = 0;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<IPlayerConfig> mList = new CopyOnWriteArrayList<>();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    OkHttpClient mOkHttpClient = null;
    /* access modifiers changed from: private */
    public volatile int mPullCfgSuccessfully = 0;
    private volatile int mRequested = 0;
    /* access modifiers changed from: private */
    public volatile long mRetryCount = 0;
    private volatile int mSendRequestManually = 0;
    /* access modifiers changed from: private */
    public long mUpdateInterval = 180;
    private Handler mWorkHandler = null;

    static /* synthetic */ long access$004(PlayerPolicyImplement x0) {
        long j2 = x0.mRetryCount + 1;
        x0.mRetryCount = j2;
        return j2;
    }

    public static class PPSessionModel {
        public static final int ERR_APPEND_COMMON_PARAMS_TO_URL_FAILED = -101;
        public static final int ERR_ASSEMBLE_URL_FAILED = -102;
        public static final int ERR_CODE_REQUEST_FAILED = -201;
        public static final int ERR_ERRNO_NOT_EQUAL_TO_ZERO = -103;
        public static final int ERR_PARSE_RESPONSE_JSON_OBJECT_FAILED = -104;
        public static final int ERR_RESPONSE_JSON_OBJECT_IS_EMPTY = -105;
        public static final int ERR_RESPONSE_OR_RESPONSE_BODY_IS_EMPTY = -106;
        public static final int ERR_RESPONSE_PARSE_FAILED = -107;
        public static final String ERR_STR_APPEND_COMMON_PARAMS_TO_URL_FAILED = "Append common params to url failed";
        public static final String ERR_STR_ASSEMBLE_URL_FAILED = "Assemble url failed";
        public static final String ERR_STR_ERRNO_NOT_EQUAL_TO_ZERO = "Errno in config dict is not zero";
        public static final String ERR_STR_PARSE_RESPONSE_JSON_OBJECT_FAILED = "Parse response json object failed";
        public static final String ERR_STR_REQUEST_FAILED = "OKHttp request failed";
        public static final String ERR_STR_RESPONSE_JSON_OBJECT_IS_EMPTY = "Response json object is empty";
        public static final String ERR_STR_RESPONSE_OR_RESPONSE_BODY_IS_EMPTY = "Response or Response body is empty";
        public static final String ERR_STR_RESPONSE_PARSE_FAILED = "Response parse failed";
        public static final String UBC_ID = "5054";
        public static HashMap<Integer, String> errCodeMsgMap;
        long mActuralInterval = 0;
        long mDelaySecond = 180;
        String mDetailErrMsg = "";
        Integer mErrCode = 0;
        String mErrMsg = "";
        long mHttpRespStatusCode = 0;
        long mPID = 0;
        long mProcessID = 0;
        long mReqStartTime = 0;
        String mRespConfigStr = "";
        long mUpdateInterval = 180;
        String mUrl = "";

        static {
            HashMap<Integer, String> hashMap = new HashMap<>();
            errCodeMsgMap = hashMap;
            hashMap.put(-101, ERR_STR_APPEND_COMMON_PARAMS_TO_URL_FAILED);
            errCodeMsgMap.put(-102, ERR_STR_ASSEMBLE_URL_FAILED);
            errCodeMsgMap.put(-103, ERR_STR_ERRNO_NOT_EQUAL_TO_ZERO);
            errCodeMsgMap.put(-104, ERR_STR_PARSE_RESPONSE_JSON_OBJECT_FAILED);
            errCodeMsgMap.put(-105, ERR_STR_RESPONSE_JSON_OBJECT_IS_EMPTY);
            errCodeMsgMap.put(-106, ERR_STR_RESPONSE_OR_RESPONSE_BODY_IS_EMPTY);
            errCodeMsgMap.put(-107, ERR_STR_RESPONSE_PARSE_FAILED);
            errCodeMsgMap.put(-201, ERR_STR_REQUEST_FAILED);
        }

        PPSessionModel() {
        }

        public static String errStrFromCode(Integer errCode) {
            return errCodeMsgMap.get(errCode);
        }
    }

    public PlayerPolicyImplement() {
        HandlerThread handlerThread = new HandlerThread("player_policy_implement");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mWorkHandler = new Handler(this.mHandlerThread.getLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        if (PlayerPolicyImplement.access$004(PlayerPolicyImplement.this) > 1) {
                            int unused = PlayerPolicyImplement.this.mPullCfgSuccessfully = 1;
                        }
                        long delaySecond = PlayerPolicyImplement.this.mPullCfgSuccessfully == 1 ? PlayerPolicyImplement.this.mUpdateInterval : 10;
                        sendEmptyMessageDelayed(1, 1000 * delaySecond);
                        PlayerPolicyImplement.this.onUpdateConfig(delaySecond);
                        return;
                    case 2:
                        if (msg.obj instanceof IPlayerConfig) {
                            PlayerPolicyImplement.this.onRegister((IPlayerConfig) msg.obj);
                            return;
                        }
                        return;
                    case 3:
                        if (msg.obj instanceof IPlayerConfig) {
                            PlayerPolicyImplement.this.onUnregister((IPlayerConfig) msg.obj);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void onRegister(IPlayerConfig config) {
        CopyOnWriteArrayList<IPlayerConfig> copyOnWriteArrayList = this.mList;
        if (copyOnWriteArrayList != null && config != null) {
            copyOnWriteArrayList.add(config);
        }
    }

    /* access modifiers changed from: private */
    public void onUnregister(IPlayerConfig config) {
        CopyOnWriteArrayList<IPlayerConfig> copyOnWriteArrayList = this.mList;
        if (copyOnWriteArrayList != null && config != null) {
            copyOnWriteArrayList.remove(config);
        }
    }

    /* access modifiers changed from: private */
    public void assemblePPSession(PPSessionModel model) {
        try {
            JSONObject sessionObj = new JSONObject();
            sessionObj.put("url", model.mUrl);
            sessionObj.put(DuMediaStatConstants.KEY_P_ID, model.mPID);
            sessionObj.put(MsgClientColumns.STATUS_PROCESS_ID, model.mProcessID);
            sessionObj.put(ETAG.KEY_HTTP_CODE, model.mHttpRespStatusCode);
            sessionObj.put("cost_time", SystemClock.uptimeMillis() - model.mReqStartTime);
            sessionObj.put(PmsConstant.Statistic.STATISTIC_ERRCODE, model.mErrCode);
            sessionObj.put("err_msg", model.mErrMsg);
            sessionObj.put("detail_err_msg", model.mDetailErrMsg);
            sessionObj.put("update_interval", model.mUpdateInterval);
            sessionObj.put("actual_interval", model.mActuralInterval);
            sessionObj.put("config", model.mRespConfigStr);
            sessionObj.put("delay_second", model.mDelaySecond);
            sessionObj.put("req_source", DuPlayerPolicyManager.sRequestSource);
            onUpload(PPSessionModel.UBC_ID, sessionObj.toString());
        } catch (Exception e2) {
            Log.e(TAG, "assemblePPSession failed:  ", e2);
        }
    }

    private void onUpload(String ubcID, String content) {
        try {
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(ubcID, content);
        } catch (Exception e2) {
            Log.e(TAG, "onUploadPPSession failed:  ", e2);
        } catch (Error e3) {
            Log.e(TAG, "onUploadPPSession failed:  ", e3);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onUpdateConfig(long delaySecond) {
        long curTime = SystemClock.uptimeMillis() / 1000;
        long intervalSinceLastReq = curTime - this.lastReqSendTimestamp;
        if (intervalSinceLastReq >= 10) {
            long actualReqInteval = intervalSinceLastReq;
            if (this.lastReqSendTimestamp == 0) {
                actualReqInteval = -1;
            }
            this.lastReqSendTimestamp = curTime;
            final PPSessionModel model = new PPSessionModel();
            model.mPID = System.currentTimeMillis();
            model.mProcessID = (long) Process.myPid();
            model.mReqStartTime = SystemClock.uptimeMillis();
            model.mErrCode = 0;
            model.mErrMsg = "";
            model.mUrl = "";
            model.mDelaySecond = delaySecond;
            model.mActuralInterval = actualReqInteval;
            try {
                String url = CommonUrlParamManager.getInstance().appendParam(PLAYER_SERVER, 1);
                if (url == null) {
                    model.mErrCode = -102;
                    model.mErrMsg = PPSessionModel.errStrFromCode(model.mErrCode);
                    assemblePPSession(model);
                    return;
                }
                model.mUrl = url;
                Request.Builder builder = new Request.Builder().url(url);
                if (!TextUtils.isEmpty(DuPlayerPolicyCfgManager.getInstance().getHashTag())) {
                    try {
                        JSONObject bodyJsonObj = new JSONObject();
                        bodyJsonObj.put("hash_tag", DuPlayerPolicyCfgManager.getInstance().getHashTag());
                        builder.post(RequestBody.create(MediaType.parse("application/json"), bodyJsonObj.toString()));
                    } catch (Exception e2) {
                    }
                }
                Request request = builder.build();
                if (this.mOkHttpClient == null) {
                    this.mOkHttpClient = new OkHttpClient();
                }
                this.mOkHttpClient.newCall(request).enqueue(new Callback() {
                    public void onFailure(Call call, IOException e2) {
                        Log.d(PlayerPolicyImplement.TAG, "onFailure: ");
                        model.mErrCode = -201;
                        PPSessionModel pPSessionModel = model;
                        pPSessionModel.mErrMsg = PPSessionModel.errStrFromCode(pPSessionModel.mErrCode);
                        model.mDetailErrMsg = e2.toString();
                        PlayerPolicyImplement.this.assemblePPSession(model);
                    }

                    public void onResponse(Call call, Response response) {
                        int unused = PlayerPolicyImplement.this.mPullCfgSuccessfully = 0;
                        if (response != null) {
                            try {
                                if (response.body() != null) {
                                    String json = response.body().string();
                                    if (json == null || json.isEmpty()) {
                                        model.mErrCode = -105;
                                        PPSessionModel pPSessionModel = model;
                                        pPSessionModel.mErrMsg = PPSessionModel.errStrFromCode(pPSessionModel.mErrCode);
                                    } else {
                                        DuPlayerPolicyCfgManager.getInstance().mergePlayConfigAndSave(json);
                                        String json2 = DuPlayerPolicyCfgManager.getInstance().getPlayConfigMerged();
                                        if (!TextUtils.isEmpty(json2)) {
                                            PlayerPolicyImplement.this.notify(json2);
                                            try {
                                                JSONObject jsonObj = new JSONObject(json2);
                                                int errno = jsonObj.getInt("errno");
                                                if (errno == 0) {
                                                    long unused2 = PlayerPolicyImplement.this.mUpdateInterval = (long) Math.max(10, jsonObj.getJSONObject("bandwidth_config").getInt("update_interval"));
                                                    int unused3 = PlayerPolicyImplement.this.mPullCfgSuccessfully = 1;
                                                    long unused4 = PlayerPolicyImplement.this.mRetryCount = 0;
                                                    model.mErrCode = 0;
                                                    model.mUpdateInterval = PlayerPolicyImplement.this.mUpdateInterval;
                                                } else {
                                                    model.mErrCode = -103;
                                                    model.mErrMsg = PPSessionModel.errStrFromCode(model.mErrCode) + " errno: " + errno;
                                                    model.mRespConfigStr = json2;
                                                }
                                            } catch (Exception e2) {
                                                model.mErrCode = -104;
                                                PPSessionModel pPSessionModel2 = model;
                                                pPSessionModel2.mErrMsg = PPSessionModel.errStrFromCode(pPSessionModel2.mErrCode);
                                                model.mRespConfigStr = json2;
                                                model.mDetailErrMsg = e2.toString();
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    model.mHttpRespStatusCode = (long) response.code();
                                    PlayerPolicyImplement.this.assemblePPSession(model);
                                }
                            } catch (IOException e3) {
                                model.mErrCode = -107;
                                PPSessionModel pPSessionModel3 = model;
                                pPSessionModel3.mErrMsg = PPSessionModel.errStrFromCode(pPSessionModel3.mErrCode);
                                model.mDetailErrMsg = e3.toString();
                            }
                        }
                        model.mErrCode = -106;
                        PPSessionModel pPSessionModel4 = model;
                        pPSessionModel4.mErrMsg = PPSessionModel.errStrFromCode(pPSessionModel4.mErrCode);
                        model.mHttpRespStatusCode = (long) response.code();
                        PlayerPolicyImplement.this.assemblePPSession(model);
                    }
                });
            } catch (Exception e3) {
                Log.e(TAG, "onUpdateConfig:  ", e3);
                model.mErrCode = -101;
                model.mErrMsg = PPSessionModel.errStrFromCode(model.mErrCode);
                assemblePPSession(model);
            }
        }
    }

    public void start() {
        if (this.mRequested == 0) {
            this.mRequested = 1;
            this.mWorkHandler.sendEmptyMessage(1);
        }
    }

    public void sendRequestManually(int fstStageUpdateInterval) {
        boolean z = true;
        this.mSendRequestManually = 1;
        long curTime = SystemClock.uptimeMillis() / 1000;
        if (this.mFirstReqSendTimestamp == 0) {
            this.mFirstReqSendTimestamp = curTime;
            this.mLastReqSendTime = curTime;
            onUpdateConfig(0);
            return;
        }
        if (curTime - this.mFirstReqSendTimestamp > this.mUpdateInterval) {
            z = false;
        }
        if (curTime - this.mLastReqSendTime >= (Boolean.valueOf(z).booleanValue() ? (long) fstStageUpdateInterval : this.mUpdateInterval)) {
            this.mLastReqSendTime = curTime;
            onUpdateConfig(0);
        }
    }

    public void stop() {
        if (this.mHandlerThread == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.mHandlerThread.getLooper().quitSafely();
            } catch (NoSuchMethodError e2) {
                this.mHandlerThread.getLooper().quit();
            }
        } else {
            this.mHandlerThread.getLooper().quit();
        }
    }

    public void register(IPlayerConfig config) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            Message.obtain(handler, 2, 0, 0, config).sendToTarget();
        }
    }

    public void unregister(IPlayerConfig config) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            Message.obtain(handler, 3, 0, 0, config).sendToTarget();
        }
    }

    public void notify(String json) {
        Handler handler = this.mMainHandler;
        if (handler != null) {
            final String theJson = json;
            handler.post(new Runnable() {
                public void run() {
                    try {
                        Iterator it = PlayerPolicyImplement.this.mList.iterator();
                        while (it.hasNext()) {
                            IPlayerConfig config = (IPlayerConfig) it.next();
                            if (config != null) {
                                config.update(theJson);
                            }
                        }
                    } catch (Exception e2) {
                        Log.e(PlayerPolicyImplement.TAG, "config.update failed:  ", e2);
                    }
                }
            });
        }
    }
}
