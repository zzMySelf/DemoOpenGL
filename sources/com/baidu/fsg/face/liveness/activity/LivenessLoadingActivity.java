package com.baidu.fsg.face.liveness.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.R;
import com.baidu.fsg.face.base.b.a;
import com.baidu.fsg.face.base.c.f;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.beans.g;
import com.baidu.fsg.face.liveness.beans.i;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.fsg.face.liveness.view.LoadingDialog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class LivenessLoadingActivity extends LivenessBaseActivity {
    public static final String CLOSE_LOADING_ACTION = "com.baidu.sapi2.biometrics.liveness.close.loading";
    public static final String TAG = "LivenessLoadingActivity";

    /* renamed from: a  reason: collision with root package name */
    private static boolean f12075a = false;

    /* renamed from: b  reason: collision with root package name */
    private LoadingDialog f12076b;

    /* renamed from: c  reason: collision with root package name */
    private i f12077c;

    /* renamed from: d  reason: collision with root package name */
    private g f12078d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12079e;

    /* renamed from: f  reason: collision with root package name */
    private LivenessRecogCallback f12080f;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f12080f = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
        if (f12075a) {
            a();
            LogUtil.d("hello", "loading callManyTimes");
            return;
        }
        f12075a = true;
        if (this.livenessRecogDTO == null) {
            b();
            return;
        }
        setContentView(R.layout.layout_sapi_liveness_loading);
        f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
        c();
    }

    private void a() {
        if (this.f12080f != null) {
            LivenessRecogResult result = new LivenessRecogResult();
            result.setResultCode(-212);
            result.setResultMsg(a.ERROR_MSG_MANY_CALL);
            this.f12080f.b(result);
        }
        finish();
    }

    private void b() {
        if (this.f12080f != null) {
            LivenessRecogResult regResult = new LivenessRecogResult();
            regResult.setResultCode(-206);
            regResult.setResultMsg(a.ERROR_MSG_SERVER_ERROR);
            this.f12080f.b(regResult);
        }
        finish();
    }

    private void c() {
        if (this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
            i iVar = new i(this);
            this.f12077c = iVar;
            iVar.setResponseCallback(this);
            this.f12077c.execBean();
            a(this);
            RimStatisticsUtil.onEventStart(d.f12389b);
            LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态开始  ");
            return;
        }
        g gVar = new g(this);
        this.f12078d = gVar;
        gVar.setResponseCallback(this);
        this.f12078d.execBean();
        a(this);
        RimStatisticsUtil.onEventStart(d.f12392e);
        LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
    }

    public void handleResponse(int beanId, Object response, String response2) {
        String str = "";
        boolean z = false;
        switch (beanId) {
            case 1:
                if (this.livenessRecogDTO != null) {
                    str = this.livenessRecogDTO.getSpno();
                }
                RimStatisticsUtil.onEventEndWithValue(d.f12389b, 0, str);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态结束  0");
                int isReviewing = 0;
                if (!TextUtils.isEmpty(response2)) {
                    try {
                        isReviewing = new JSONObject(response2).optInt("reviewing");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (isReviewing == 1) {
                    z = true;
                }
                this.f12079e = z;
                if (z) {
                    LivenessRecogResult recogResult = new LivenessRecogResult();
                    recogResult.setResultCode(LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING);
                    recogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_VIDEO_IS_REVIEWING);
                    LivenessRecogCallback livenessRecogCallback = this.f12080f;
                    if (livenessRecogCallback != null) {
                        livenessRecogCallback.b(recogResult);
                    }
                    d();
                    RimStatisticsUtil.getInstance().triggerSending();
                    LogUtil.d("hello", "triggerSending():  发送日志");
                    return;
                }
                RimStatisticsUtil.onEventStart(d.f12392e);
                g gVar = new g(this);
                this.f12078d = gVar;
                gVar.setResponseCallback(this);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图开始");
                this.f12078d.execBean();
                return;
            case 2:
                if (this.livenessRecogDTO != null) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(this.livenessRecogDTO.getSpno() + str);
                    if (!TextUtils.isEmpty(this.livenessRecogDTO.processid)) {
                        str = this.livenessRecogDTO.processid;
                    }
                    list.add(str);
                    RimStatisticsUtil.onEventEndWithValues(d.f12392e, 0, list);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图结束  0");
                }
                if (this.livenessRecogDTO.showGuidePage) {
                    if (this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS && !TextUtils.isEmpty(response2)) {
                        try {
                            this.livenessRecogDTO.realName = new JSONObject(response2).optString("display_name");
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    d();
                    Intent intent = new Intent(this, LivenessRecogGuidActivity.class);
                    intent.setFlags(268435456);
                    startActivity(intent);
                    return;
                }
                d();
                Intent intent2 = new Intent(this, LivenessRecogActivity.class);
                intent2.setFlags(268435456);
                startActivity(intent2);
                return;
            default:
                super.handleResponse(beanId, response, response2);
                return;
        }
    }

    public void handleFailure(int beanId, int errcode, String errMsg) {
        String str = "";
        switch (beanId) {
            case 1:
                d();
                if (this.livenessRecogDTO != null) {
                    str = this.livenessRecogDTO.getSpno();
                }
                RimStatisticsUtil.onEventEndWithValue(d.f12389b, errcode, str);
                LogUtil.d("hello", "onEventStart(StatServiceEvent.QUERYVIDEO):  查询视频状态结束  " + errcode);
                LivenessRecogResult recogResult = new LivenessRecogResult();
                recogResult.setResultCode(errcode);
                recogResult.setResultMsg(errMsg);
                LivenessRecogCallback livenessRecogCallback = this.f12080f;
                if (livenessRecogCallback != null) {
                    livenessRecogCallback.b(recogResult);
                }
                RimStatisticsUtil.getInstance().triggerSending();
                LogUtil.d("hello", "triggerSending():  发送日志");
                return;
            case 2:
                if (this.livenessRecogDTO != null) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(this.livenessRecogDTO.getSpno() + str);
                    if (!TextUtils.isEmpty(this.livenessRecogDTO.processid)) {
                        str = this.livenessRecogDTO.processid;
                    }
                    list.add(str);
                    RimStatisticsUtil.onEventEndWithValues(d.f12392e, errcode, list);
                    LogUtil.d("hello", "onEventStart(StatServiceEvent.GETPORTRAIT):  获取公安网小图结束  " + errcode + errMsg);
                }
                d();
                LivenessRecogResult recogResult1 = new LivenessRecogResult();
                recogResult1.setResultCode(errcode);
                recogResult1.setResultMsg(errMsg);
                LivenessRecogCallback livenessRecogCallback2 = this.f12080f;
                if (livenessRecogCallback2 != null) {
                    livenessRecogCallback2.b(recogResult1);
                }
                RimStatisticsUtil.getInstance().triggerSending();
                LogUtil.d("hello", "triggerSending():  发送日志");
                return;
            default:
                super.handleFailure(beanId, errcode, errMsg);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isRequestedOrientation() {
        return false;
    }

    private void a(Context context) {
        if (this.f12076b == null) {
            LoadingDialog loadingDialog = new LoadingDialog(context);
            this.f12076b = loadingDialog;
            loadingDialog.setMessage(context.getString(R.string.sapi_liveness_recog_loading));
            this.f12076b.setCancelable(false);
        }
        if ((context instanceof Activity) && isUseable((Activity) context) && !this.f12076b.isShowing()) {
            this.f12076b.show();
        }
    }

    private void d() {
        if (isUseable(this) && this.f12076b.isShowing()) {
            this.f12076b.dismiss();
            finish();
        }
    }

    public boolean isUseable(Activity mActivity) {
        if (mActivity == null || mActivity.isFinishing() || mActivity.isRestricted()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17) {
            return true;
        }
        try {
            if (mActivity.isDestroyed()) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        } catch (Error e3) {
            e3.printStackTrace();
            return true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        f12075a = false;
    }
}
