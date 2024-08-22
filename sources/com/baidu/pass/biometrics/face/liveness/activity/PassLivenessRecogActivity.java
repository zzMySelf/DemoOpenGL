package com.baidu.pass.biometrics.face.liveness.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.app.account.BoxAccountContants;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.pass.biometrics.R;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.dynamicupdate.LocalConfigOptions;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.http.result.ContrastPortraitResult;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.ViewUtility;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.c.b;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceOperationCallback;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.callback.PixelCopyCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.enums.ProgressStatus;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.biometrics.face.liveness.view.face.CameraSurfaceView;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleImageView;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SafeService;
import com.baidu.sapi2.utils.enums.UIOrientation;
import com.baidu.search.tcstatistic.TcStatisticConstantKt;
import com.baidu.searchbox.feed.model.FeedItemDataHotStripe;
import com.baidu.sofire.face.api.Degree;
import com.baidu.sofire.face.api.FaceApi;
import com.baidu.sofire.face.api.FaceEnum;
import com.baidu.sofire.face.api.FaceProcessCallback;
import com.baidu.sofire.face.api.FaceVerifyInfo;
import com.baidu.sofire.face.api.RequestInfo;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PassLivenessRecogActivity extends LivenessBaseActivity implements NoProguard, FaceProcessCallback, View.OnClickListener {
    private static final String W = "LivenessRecogActivity";
    private static final int X = 2002;
    private static final int Y = 7126;
    private static final int Z = 7127;
    private static final int a0 = 1;
    private static final int b0 = 2;
    private static final int c0 = 3;
    private static final int d0 = 112;
    private static final int e0 = 255;
    private static final String f0 = "recog_upload_portrait_count";
    private static final String g0 = "abtest_illum_list";
    private boolean A = true;
    private boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    private boolean D;
    private boolean E;
    private Timer F = new Timer(true);
    private TimerTask G;
    private ProgressStatus H;
    /* access modifiers changed from: private */
    public com.baidu.pass.biometrics.face.liveness.b.a I;
    private LivenessTypeEnum J;
    private long K;
    /* access modifiers changed from: private */
    public PassFaceRecogCallback L;
    private ImageView M;
    private TextView N;
    private TextView O;
    private ImageView P;
    private RelativeLayout Q;
    private Boolean R = true;
    private String S;
    /* access modifiers changed from: private */
    public boolean T = false;
    boolean U = false;
    private HashMap<String, Integer> V = new HashMap<>();
    public List<Integer> abtestIllumList = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private ViewGroup f15846e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CircleProgressView f15847f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f15848g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f15849h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f15850i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15851j = true;
    private boolean k = true;
    private FrameLayout l;
    /* access modifiers changed from: private */
    public ImageView m;
    private TextView n;
    private CameraSurfaceView o;
    /* access modifiers changed from: private */
    public CircleImageView p;
    private CircleImageView q;
    private LinearLayout r;
    public String recogUploadPortraitCount;
    /* access modifiers changed from: private */
    public com.baidu.pass.biometrics.face.liveness.d.a s;
    private SdkConfigOptions.LivenessConfigOption t;
    private int u;
    private com.baidu.pass.biometrics.face.liveness.c.b v;
    private boolean w;
    private boolean x;
    private boolean y = false;
    private boolean z = true;

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a f15852a;

        a(com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            this.f15852a = aVar;
        }

        public void onClick(View view2) {
            PassLivenessRecogActivity.this.I.e0 = 1;
            PassLivenessRecogActivity.this.I.A = 1;
            PassLivenessRecogActivity.this.j();
            this.f15852a.dismiss();
        }
    }

    class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a f15854a;

        b(com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            this.f15854a = aVar;
        }

        public void onClick(View view2) {
            this.f15854a.dismiss();
            if (PassLivenessRecogActivity.this.L != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                PassLivenessRecogActivity.this.a(passFaceRecogResult, -204, PassBiometricResult.ERROR_MSG_USER_CANCEL);
                PassLivenessRecogActivity.this.L.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.I.z = 1;
            PassLivenessRecogActivity.this.I.e0 = 2;
            PassLivenessRecogActivity.this.I.Z = 3;
            PassLivenessRecogActivity.this.setActivityResult(0);
            PassLivenessRecogActivity.this.a();
        }
    }

    class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a f15856a;

        c(com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            this.f15856a = aVar;
        }

        public void onClick(View view2) {
            PassLivenessRecogActivity.this.j();
            PassLivenessRecogActivity.this.I.f0 = 2;
            this.f15856a.dismiss();
        }
    }

    class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.a f15858a;

        d(com.baidu.pass.biometrics.face.liveness.d.a aVar) {
            this.f15858a = aVar;
        }

        public void onClick(View view2) {
            this.f15858a.dismiss();
            PassLivenessRecogActivity.this.I.C = 1;
            PassLivenessRecogActivity.this.I.f0 = 1;
            PassLivenessRecogActivity.this.setActivityResult(-1);
            if (PassLivenessRecogActivity.this.L != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                PassLivenessRecogActivity.this.a(passFaceRecogResult, -301, PassFaceRecogResult.ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT);
                PassLivenessRecogActivity.this.L.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.a();
        }
    }

    class e implements PixelCopy.OnPixelCopyFinishedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PixelCopyCallback f15860a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bitmap f15861b;

        e(PixelCopyCallback pixelCopyCallback, Bitmap bitmap) {
            this.f15860a = pixelCopyCallback;
            this.f15861b = bitmap;
        }

        public void onPixelCopyFinished(int i2) {
            if (i2 == 0) {
                this.f15860a.onFinsh(this.f15861b);
            }
        }
    }

    class f extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f15863a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Looper looper, long j2) {
            super(looper);
            this.f15863a = j2;
        }

        /* access modifiers changed from: protected */
        public void onFailure(Throwable th2, int i2, String str) {
            PassLivenessRecogActivity.this.I.h0 = i2;
            PassLivenessRecogActivity.this.I.j0 = System.currentTimeMillis() - this.f15863a;
            PassLivenessRecogActivity.this.a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR + "(D" + -206 + ")");
        }

        /* access modifiers changed from: protected */
        public void onSuccess(int i2, String str) {
            PassLivenessRecogActivity.this.I.h0 = i2;
            PassLivenessRecogActivity.this.I.j0 = System.currentTimeMillis() - this.f15863a;
            PassLivenessRecogActivity.this.b(str);
        }
    }

    class g extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f15865a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Looper looper, long j2) {
            super(looper);
            this.f15865a = j2;
        }

        /* access modifiers changed from: protected */
        public void onFailure(Throwable th2, int i2, String str) {
            Log.d(PassLivenessRecogActivity.W, "livenessWithCert onFailure: " + i2);
            PassLivenessRecogActivity.this.I.i0 = i2;
            PassLivenessRecogActivity.this.I.l0 = System.currentTimeMillis() - this.f15865a;
            PassLivenessRecogActivity.this.a(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR + "(M" + -206 + ")");
        }

        /* access modifiers changed from: protected */
        public void onSuccess(int i2, String str) {
            PassLivenessRecogActivity.this.I.i0 = i2;
            PassLivenessRecogActivity.this.I.l0 = System.currentTimeMillis() - this.f15865a;
            PassLivenessRecogActivity.this.a(str);
        }
    }

    class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b f15867a;

        h(com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            this.f15867a = bVar;
        }

        public void onClick(View view2) {
            PassLivenessRecogActivity.this.j();
            PassLivenessRecogActivity.this.I.a0 = 1;
            this.f15867a.dismiss();
        }
    }

    class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b f15869a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f15870b;

        i(com.baidu.pass.biometrics.face.liveness.d.b bVar, int i2) {
            this.f15869a = bVar;
            this.f15870b = i2;
        }

        public void onClick(View view2) {
            this.f15869a.dismiss();
            PassLivenessRecogActivity.this.a(this.f15870b);
            PassLivenessRecogActivity.this.I.a0 = 2;
            if (PassLivenessRecogActivity.this.L != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                PassLivenessRecogActivity.this.a(passFaceRecogResult, -204, PassBiometricResult.ERROR_MSG_USER_CANCEL);
                PassLivenessRecogActivity.this.L.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.setActivityResult(0);
            PassLivenessRecogActivity.this.a();
        }
    }

    static /* synthetic */ class j {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15872a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f15873b;

        static {
            int[] iArr = new int[ProgressStatus.values().length];
            f15873b = iArr;
            try {
                iArr[ProgressStatus.GO.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15873b[ProgressStatus.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[FaceStatusNewEnum.values().length];
            f15872a = iArr2;
            try {
                iArr2[FaceStatusNewEnum.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15872a[FaceStatusNewEnum.DetectRemindCodeTooClose.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15872a[FaceStatusNewEnum.DetectRemindCodeTooFar.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f15872a[FaceStatusNewEnum.DetectRemindCodePoorIllumination.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f15872a[FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f15872a[FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f15872a[FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.ordinal()] = 7;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f15872a[FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.ordinal()] = 8;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f15872a[FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.ordinal()] = 9;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f15872a[FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.ordinal()] = 10;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f15872a[FaceStatusNewEnum.FaceLivenessActionTypeLiveEye.ordinal()] = 11;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f15872a[FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth.ordinal()] = 12;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f15872a[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp.ordinal()] = 13;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f15872a[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown.ordinal()] = 14;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f15872a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft.ordinal()] = 15;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f15872a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight.ordinal()] = 16;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f15872a[FaceStatusNewEnum.FaceLivenessActionTypeLiveYaw.ordinal()] = 17;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f15872a[FaceStatusNewEnum.FaceLivenessActionComplete.ordinal()] = 18;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f15872a[FaceStatusNewEnum.DetectRemindCodeTimeout.ordinal()] = 19;
            } catch (NoSuchFieldError e22) {
            }
        }
    }

    class k implements b.C0246b {
        k() {
        }

        public void a(float f2) {
            PassLivenessRecogActivity.this.b(f2);
        }
    }

    class l implements CircleProgressView.b {
        l() {
        }

        public void a(float f2, float f3) {
            if (f2 == 100.0f) {
                PassLivenessRecogActivity.this.f15847f.setShowTick(false);
            } else {
                PassLivenessRecogActivity.this.f15847f.setShowTick(true);
            }
        }
    }

    class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b f15876a;

        m(com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            this.f15876a = bVar;
        }

        public void onClick(View view2) {
            ViewUtility.dismissDialog(PassLivenessRecogActivity.this, this.f15876a);
            boolean unused = PassLivenessRecogActivity.this.C = true;
            Log.d(PassLivenessRecogActivity.W, "face requestCameraPermission: shouldShowRequestPermissionRationale-go");
            PassLivenessRecogActivity.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 2002);
        }
    }

    class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.baidu.pass.biometrics.face.liveness.d.b f15878a;

        n(com.baidu.pass.biometrics.face.liveness.d.b bVar) {
            this.f15878a = bVar;
        }

        public void onClick(View view2) {
            ViewUtility.dismissDialog(PassLivenessRecogActivity.this, this.f15878a);
            if (PassLivenessRecogActivity.this.L != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                PassLivenessRecogActivity.this.a(passFaceRecogResult, -307, PassFaceRecogResult.ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION);
                PassLivenessRecogActivity.this.L.onFailure(passFaceRecogResult);
            }
            Log.d(PassLivenessRecogActivity.W, "face requestCameraPermission: shouldShowRequestPermissionRationale-close");
            PassLivenessRecogActivity.this.a();
        }
    }

    class o extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f15880a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(Looper looper, long j2) {
            super(looper);
            this.f15880a = j2;
        }

        /* access modifiers changed from: protected */
        public void onFailure(Throwable th2, int i2, String str) {
            Log.d(PassLivenessRecogActivity.W, "face requestLivingAction: onFailure:" + i2);
            PassLivenessRecogActivity.this.I.g0 = i2;
            PassLivenessRecogActivity.this.I.k0 = System.currentTimeMillis() - this.f15880a;
            if (!PassLivenessRecogActivity.this.isFinishing()) {
                PassLivenessRecogActivity.this.hideLoadingView();
                PassLivenessRecogActivity.this.h();
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSuccess(int r17, java.lang.String r18) {
            /*
                r16 = this;
                r1 = r16
                r0 = r17
                java.lang.String r2 = "_"
                java.lang.String r3 = ""
                r4 = 1
                java.lang.Object[] r5 = new java.lang.Object[r4]
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "face requestLivingAction: onSuccess: setFaceConfig:"
                java.lang.StringBuilder r6 = r6.append(r7)
                java.lang.StringBuilder r6 = r6.append(r0)
                java.lang.String r6 = r6.toString()
                r7 = 0
                r5[r7] = r6
                java.lang.String r6 = "LivenessRecogActivity"
                com.baidu.sapi2.utils.Log.d(r6, r5)
                com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity r5 = com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.this
                com.baidu.pass.biometrics.face.liveness.b.a r5 = r5.I
                r5.g0 = r0
                com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity r0 = com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.this
                com.baidu.pass.biometrics.face.liveness.b.a r0 = r0.I
                long r8 = java.lang.System.currentTimeMillis()
                long r10 = r1.f15880a
                long r8 = r8 - r10
                r0.k0 = r8
                com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity r0 = com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.this
                boolean r0 = r0.isFinishing()
                if (r0 == 0) goto L_0x0046
                return
            L_0x0046:
                com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity r0 = com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.this
                r0.hideLoadingView()
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0257 }
                r5 = r18
                r0.<init>(r5)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r5 = "code"
                int r5 = r0.optInt(r5)     // Catch:{ Exception -> 0x0257 }
                r8 = 110000(0x1adb0, float:1.54143E-40)
                if (r5 != r8) goto L_0x0279
                com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity r5 = com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.this     // Catch:{ Exception -> 0x0257 }
                boolean unused = r5.T = r4     // Catch:{ Exception -> 0x0257 }
                java.lang.String r5 = "data"
                org.json.JSONObject r0 = r0.optJSONObject(r5)     // Catch:{ Exception -> 0x0257 }
                if (r0 == 0) goto L_0x0279
                java.lang.String r5 = "use_gzip"
                java.lang.String r5 = r0.optString(r5, r3)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r8 = "hide_true_name"
                java.lang.String r8 = r0.optString(r8, r3)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r9 = "face_match_msg"
                java.lang.String r9 = r0.optString(r9, r3)     // Catch:{ Exception -> 0x0257 }
                boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0257 }
                r11 = -1
                java.lang.String r12 = "null"
                if (r10 != 0) goto L_0x00ce
                boolean r10 = r12.equals(r8)     // Catch:{ Exception -> 0x0257 }
                if (r10 != 0) goto L_0x00ce
                boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0257 }
                if (r10 != 0) goto L_0x00ce
                boolean r10 = r12.equals(r9)     // Catch:{ Exception -> 0x0257 }
                if (r10 != 0) goto L_0x00ce
                android.text.SpannableString r10 = new android.text.SpannableString     // Catch:{ Exception -> 0x0257 }
                r10.<init>(r9)     // Catch:{ Exception -> 0x0257 }
                com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity r13 = com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.this     // Catch:{ Exception -> 0x0257 }
                android.widget.TextView r13 = r13.f15849h     // Catch:{ Exception -> 0x0257 }
                r13.setVisibility(r7)     // Catch:{ Exception -> 0x0257 }
                r13 = r11
            L_0x00a7:
                int r13 = r13 + r4
                int r13 = r9.indexOf(r8, r13)     // Catch:{ Exception -> 0x0257 }
                if (r13 == r11) goto L_0x00c5
                android.text.style.ForegroundColorSpan r14 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x0257 }
                java.lang.String r15 = "#4E6FF2"
                int r15 = android.graphics.Color.parseColor(r15)     // Catch:{ Exception -> 0x0257 }
                r14.<init>(r15)     // Catch:{ Exception -> 0x0257 }
                int r15 = r8.length()     // Catch:{ Exception -> 0x0257 }
                int r15 = r15 + r13
                r11 = 33
                r10.setSpan(r14, r13, r15, r11)     // Catch:{ Exception -> 0x0257 }
                r11 = -1
                goto L_0x00a7
            L_0x00c5:
                com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity r8 = com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.this     // Catch:{ Exception -> 0x0257 }
                android.widget.TextView r8 = r8.f15849h     // Catch:{ Exception -> 0x0257 }
                r8.setText(r10)     // Catch:{ Exception -> 0x0257 }
            L_0x00ce:
                boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r9 = "1"
                if (r8 != 0) goto L_0x00e6
                boolean r8 = r12.equals(r5)     // Catch:{ Exception -> 0x0257 }
                if (r8 != 0) goto L_0x00e6
                com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager r8 = com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager.getInstance()     // Catch:{ Exception -> 0x0257 }
                boolean r5 = r9.equals(r5)     // Catch:{ Exception -> 0x0257 }
                r8.useGzip = r5     // Catch:{ Exception -> 0x0257 }
            L_0x00e6:
                java.lang.String r5 = "face_config"
                java.lang.String r5 = r0.optString(r5)     // Catch:{ Exception -> 0x0257 }
                java.lang.String[] r5 = r5.split(r2)     // Catch:{ Exception -> 0x0257 }
                int r8 = r5.length     // Catch:{ Exception -> 0x0257 }
                java.lang.String r10 = "UTF-8"
                if (r8 <= r4) goto L_0x0150
                r8 = r5[r7]     // Catch:{ Exception -> 0x0257 }
                r5 = r5[r4]     // Catch:{ Exception -> 0x0257 }
                java.lang.String r8 = com.baidu.pass.biometrics.base.utils.RSA.decrypt(r8)     // Catch:{ Exception -> 0x0257 }
                java.lang.StringBuffer r11 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0257 }
                r11.<init>(r8)     // Catch:{ Exception -> 0x0257 }
                java.lang.StringBuffer r11 = r11.reverse()     // Catch:{ Exception -> 0x0257 }
                java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0257 }
                byte[] r5 = android.util.Base64.decode(r5, r7)     // Catch:{ Exception -> 0x0257 }
                byte[] r5 = com.baidu.pass.common.SecurityUtil.aesDecrypt(r5, r11, r8)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r8 = new java.lang.String     // Catch:{ Exception -> 0x0257 }
                r8.<init>(r5, r10)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r5 = r8.trim()     // Catch:{ Exception -> 0x0257 }
                java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0257 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0257 }
                r11.<init>()     // Catch:{ Exception -> 0x0257 }
                java.lang.String r12 = "face_config onSuccess: "
                java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x0257 }
                java.lang.StringBuilder r11 = r11.append(r5)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0257 }
                r8[r7] = r11     // Catch:{ Exception -> 0x0257 }
                com.baidu.sapi2.utils.Log.i(r6, r8)     // Catch:{ Exception -> 0x0257 }
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0257 }
                r8.<init>(r5)     // Catch:{ Exception -> 0x0257 }
                com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity r5 = com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.this     // Catch:{ Exception -> 0x0257 }
                java.lang.String r11 = "recog_upload_portrait_count"
                java.lang.String r11 = r8.optString(r11)     // Catch:{ Exception -> 0x0257 }
                r5.recogUploadPortraitCount = r11     // Catch:{ Exception -> 0x0257 }
                com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity r5 = com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.this     // Catch:{ Exception -> 0x0257 }
                java.lang.String r11 = "abtest_illum_list"
                org.json.JSONArray r8 = r8.optJSONArray(r11)     // Catch:{ Exception -> 0x0257 }
                r5.a((org.json.JSONArray) r8)     // Catch:{ Exception -> 0x0257 }
                goto L_0x0176
            L_0x0150:
                java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0257 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0257 }
                r11.<init>()     // Catch:{ Exception -> 0x0257 }
                java.lang.String r13 = "face_config unSuccess:"
                java.lang.StringBuilder r11 = r11.append(r13)     // Catch:{ Exception -> 0x0257 }
                int r13 = r5.length     // Catch:{ Exception -> 0x0257 }
                if (r13 <= 0) goto L_0x0163
                r12 = r5[r7]     // Catch:{ Exception -> 0x0257 }
            L_0x0163:
                java.lang.StringBuilder r5 = r11.append(r12)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r11 = "end"
                java.lang.StringBuilder r5 = r5.append(r11)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0257 }
                r8[r7] = r5     // Catch:{ Exception -> 0x0257 }
                com.baidu.sapi2.utils.Log.d(r6, r8)     // Catch:{ Exception -> 0x0257 }
            L_0x0176:
                java.lang.String r5 = "actions"
                java.lang.String r0 = r0.optString(r5)     // Catch:{ Exception -> 0x0257 }
                java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x0257 }
                r2 = r0[r7]     // Catch:{ Exception -> 0x0257 }
                r0 = r0[r4]     // Catch:{ Exception -> 0x0257 }
                java.lang.String r2 = com.baidu.pass.biometrics.base.utils.RSA.decrypt(r2)     // Catch:{ Exception -> 0x0257 }
                java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0257 }
                r5.<init>(r2)     // Catch:{ Exception -> 0x0257 }
                java.lang.StringBuffer r5 = r5.reverse()     // Catch:{ Exception -> 0x0257 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0257 }
                byte[] r0 = android.util.Base64.decode(r0, r7)     // Catch:{ Exception -> 0x0257 }
                byte[] r0 = com.baidu.pass.common.SecurityUtil.aesDecrypt(r0, r5, r2)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0257 }
                r2.<init>(r0, r10)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r0 = r2.trim()     // Catch:{ Exception -> 0x0257 }
                boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0257 }
                if (r2 == 0) goto L_0x01b2
                com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity r0 = com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.this     // Catch:{ Exception -> 0x0257 }
                r0.h()     // Catch:{ Exception -> 0x0257 }
                return
            L_0x01b2:
                java.lang.String r2 = "["
                java.lang.String r0 = r0.replace(r2, r3)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r2 = "]"
                java.lang.String r0 = r0.replace(r2, r3)     // Catch:{ Exception -> 0x0257 }
                java.lang.String r2 = ","
                java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x0257 }
                com.baidu.pass.face.platform.FaceSDKManager r2 = com.baidu.pass.face.platform.FaceSDKManager.getInstance()     // Catch:{ Exception -> 0x0257 }
                com.baidu.pass.face.platform.FaceConfig r2 = r2.getFaceConfig()     // Catch:{ Exception -> 0x0257 }
                if (r2 != 0) goto L_0x01d3
                com.baidu.pass.face.platform.FaceConfig r2 = new com.baidu.pass.face.platform.FaceConfig     // Catch:{ Exception -> 0x0257 }
                r2.<init>()     // Catch:{ Exception -> 0x0257 }
            L_0x01d3:
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0257 }
                r3.<init>()     // Catch:{ Exception -> 0x0257 }
                int r5 = r0.length     // Catch:{ Exception -> 0x0257 }
                r8 = r7
            L_0x01da:
                if (r8 >= r5) goto L_0x024c
                r10 = r0[r8]     // Catch:{ Exception -> 0x0257 }
                int r11 = r10.hashCode()     // Catch:{ Exception -> 0x0257 }
                switch(r11) {
                    case 49: goto L_0x0218;
                    case 50: goto L_0x020e;
                    case 51: goto L_0x0204;
                    case 52: goto L_0x01fa;
                    case 53: goto L_0x01f0;
                    case 54: goto L_0x01e6;
                    default: goto L_0x01e5;
                }     // Catch:{ Exception -> 0x0257 }
            L_0x01e5:
                goto L_0x0220
            L_0x01e6:
                java.lang.String r11 = "6"
                boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x0257 }
                if (r10 == 0) goto L_0x01e5
                r10 = 5
                goto L_0x0221
            L_0x01f0:
                java.lang.String r11 = "5"
                boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x0257 }
                if (r10 == 0) goto L_0x01e5
                r10 = 4
                goto L_0x0221
            L_0x01fa:
                java.lang.String r11 = "4"
                boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x0257 }
                if (r10 == 0) goto L_0x01e5
                r10 = 3
                goto L_0x0221
            L_0x0204:
                java.lang.String r11 = "3"
                boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x0257 }
                if (r10 == 0) goto L_0x01e5
                r10 = 2
                goto L_0x0221
            L_0x020e:
                java.lang.String r11 = "2"
                boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x0257 }
                if (r10 == 0) goto L_0x01e5
                r10 = r4
                goto L_0x0221
            L_0x0218:
                boolean r10 = r10.equals(r9)     // Catch:{ Exception -> 0x0257 }
                if (r10 == 0) goto L_0x01e5
                r10 = r7
                goto L_0x0221
            L_0x0220:
                r10 = -1
            L_0x0221:
                switch(r10) {
                    case 0: goto L_0x0243;
                    case 1: goto L_0x023d;
                    case 2: goto L_0x0237;
                    case 3: goto L_0x0231;
                    case 4: goto L_0x022b;
                    case 5: goto L_0x0225;
                    default: goto L_0x0224;
                }     // Catch:{ Exception -> 0x0257 }
            L_0x0224:
                goto L_0x0249
            L_0x0225:
                com.baidu.pass.face.platform.LivenessTypeEnum r10 = com.baidu.pass.face.platform.LivenessTypeEnum.HeadDown     // Catch:{ Exception -> 0x0257 }
                r3.add(r10)     // Catch:{ Exception -> 0x0257 }
                goto L_0x0248
            L_0x022b:
                com.baidu.pass.face.platform.LivenessTypeEnum r10 = com.baidu.pass.face.platform.LivenessTypeEnum.HeadUp     // Catch:{ Exception -> 0x0257 }
                r3.add(r10)     // Catch:{ Exception -> 0x0257 }
                goto L_0x0248
            L_0x0231:
                com.baidu.pass.face.platform.LivenessTypeEnum r10 = com.baidu.pass.face.platform.LivenessTypeEnum.HeadRight     // Catch:{ Exception -> 0x0257 }
                r3.add(r10)     // Catch:{ Exception -> 0x0257 }
                goto L_0x0248
            L_0x0237:
                com.baidu.pass.face.platform.LivenessTypeEnum r10 = com.baidu.pass.face.platform.LivenessTypeEnum.HeadLeft     // Catch:{ Exception -> 0x0257 }
                r3.add(r10)     // Catch:{ Exception -> 0x0257 }
                goto L_0x0248
            L_0x023d:
                com.baidu.pass.face.platform.LivenessTypeEnum r10 = com.baidu.pass.face.platform.LivenessTypeEnum.Mouth     // Catch:{ Exception -> 0x0257 }
                r3.add(r10)     // Catch:{ Exception -> 0x0257 }
                goto L_0x0248
            L_0x0243:
                com.baidu.pass.face.platform.LivenessTypeEnum r10 = com.baidu.pass.face.platform.LivenessTypeEnum.Eye     // Catch:{ Exception -> 0x0257 }
                r3.add(r10)     // Catch:{ Exception -> 0x0257 }
            L_0x0248:
            L_0x0249:
                int r8 = r8 + 1
                goto L_0x01da
            L_0x024c:
                r2.setLivenessTypeList(r3)     // Catch:{ Exception -> 0x0257 }
                com.baidu.pass.face.platform.FaceSDKManager r0 = com.baidu.pass.face.platform.FaceSDKManager.getInstance()     // Catch:{ Exception -> 0x0257 }
                r0.setFaceConfig(r2)     // Catch:{ Exception -> 0x0257 }
                goto L_0x0279
            L_0x0257:
                r0 = move-exception
                java.lang.Object[] r2 = new java.lang.Object[r4]
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "face requestLivingAction Exception = "
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.String r4 = r0.getMessage()
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.String r3 = r3.toString()
                r2[r7] = r3
                com.baidu.sapi2.utils.Log.e((java.lang.String) r6, (java.lang.Object[]) r2)
                r0.printStackTrace()
            L_0x0279:
                com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity r0 = com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.this
                r0.h()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity.o.onSuccess(int, java.lang.String):void");
        }
    }

    class p implements View.OnClickListener {
        p() {
        }

        public void onClick(View view2) {
            Log.d(PassLivenessRecogActivity.W, "showPermissionDialog: cancel");
            PassLivenessRecogActivity.this.s.dismiss();
            PassLivenessRecogActivity.this.I.d0 = 2;
            boolean unused = PassLivenessRecogActivity.this.C = false;
            if (PassLivenessRecogActivity.this.L != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                PassLivenessRecogActivity.this.a(passFaceRecogResult, -307, PassFaceRecogResult.ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION);
                PassLivenessRecogActivity.this.L.onFailure(passFaceRecogResult);
            }
            PassLivenessRecogActivity.this.a();
        }
    }

    class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f15883a;

        q(boolean z) {
            this.f15883a = z;
        }

        public void onClick(View view2) {
            PassLivenessRecogActivity.this.s.dismiss();
            if (!this.f15883a || Build.VERSION.SDK_INT < 23) {
                Log.d(PassLivenessRecogActivity.W, "showPermissionDialog: set");
                PassLivenessRecogActivity.this.I.d0 = 1;
                boolean unused = PassLivenessRecogActivity.this.C = false;
                if (PassLivenessRecogActivity.this.L != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    PassLivenessRecogActivity.this.a(passFaceRecogResult, -307, PassFaceRecogResult.ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION);
                    PassLivenessRecogActivity.this.L.onFailure(passFaceRecogResult);
                }
                PassLivenessRecogActivity.this.a();
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addFlags(268435456);
                intent.setData(Uri.fromParts("package", PassLivenessRecogActivity.this.getPackageName(), (String) null));
                if (intent.resolveActivity(PassLivenessRecogActivity.this.getPackageManager()) != null) {
                    PassLivenessRecogActivity.this.startActivity(intent);
                    return;
                }
                return;
            }
            PassLivenessRecogActivity.this.I.d0 = 3;
            SapiContext.getInstance().setAlreadyRequestPermisson(true);
            boolean unused2 = PassLivenessRecogActivity.this.C = true;
            Log.d(PassLivenessRecogActivity.W, "showPermissionDialog: sure");
            PassLivenessRecogActivity.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 2002);
        }
    }

    class r implements PixelCopyCallback {
        r() {
        }

        public void onFinsh(Bitmap bitmap) {
            Log.d(PassLivenessRecogActivity.W, "onCollectCompletion- OK - onFinsh: ");
            PassLivenessRecogActivity.this.p.setImageBitmap(com.baidu.pass.biometrics.face.liveness.c.c.a(PassLivenessRecogActivity.this, bitmap));
        }
    }

    class s implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Animation f15886a;

        s(Animation animation) {
            this.f15886a = animation;
        }

        public void onAnimationEnd(Animation animation) {
            PassLivenessRecogActivity.this.m.startAnimation(this.f15886a);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    private void k() {
        if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.CAMERA") == 0) {
            Log.d(W, "face requestCameraPermission: ret");
            this.I.E = System.currentTimeMillis();
            i();
            return;
        }
        PassBiometricConfiguration passBiometricConfiguration = this.mConfiguration;
        if (passBiometricConfiguration != null && !passBiometricConfiguration.showPmnRationaleDialog) {
            Log.d(W, "face requestCameraPermission: !PERMISSION_GRANTED - !showPmnRationaleDialog");
            this.C = true;
            requestPermissions(new String[]{"android.permission.CAMERA"}, 2002);
        } else if (shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
            Log.d(W, "face requestCameraPermission: shouldShowRequestPermissionRationale");
            com.baidu.pass.biometrics.face.liveness.d.b bVar = new com.baidu.pass.biometrics.face.liveness.d.b(this);
            bVar.c(getString(R.string.pass_bio_pmn_ok), new m(bVar));
            bVar.a(getString(R.string.pass_bio_pmn_cancel), new n(bVar));
            bVar.b(String.format(getString(R.string.pass_bio_pmn_title_liveness), new Object[]{PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)}));
            bVar.a(String.format(getString(R.string.pass_bio_pmn_msg_liveness), new Object[]{PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)}));
            bVar.show();
        } else {
            Log.d(W, "face requestCameraPermission: !PERMISSION_GRANTED");
            this.C = true;
            requestPermissions(new String[]{"android.permission.CAMERA"}, 2002);
        }
    }

    private void l() {
        if (this.mPassFaceRecogDTO != null && this.mConfiguration != null) {
            showLoadingView();
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("tpl", this.mConfiguration.tpl);
            httpHashMapWrap.put("client", "android");
            httpHashMapWrap.put("clientfrom", "native");
            JSONObject jSONObject = new JSONObject();
            PassFaceRecogType passFaceRecogType = this.mPassFaceRecogDTO.livenessType;
            if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
                httpHashMapWrap.put("type", "bduss");
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
                try {
                    httpHashMapWrap.put("type", "certinfo");
                    jSONObject.put("name", this.mPassFaceRecogDTO.realName);
                    jSONObject.put("cert", this.mPassFaceRecogDTO.idCardNum);
                    httpHashMapWrap.put("idnum", PassBioDataEncryptor.encryptParams(jSONObject.toString()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                httpHashMapWrap.put("type", "authtoken");
                httpHashMapWrap.put("authtoken", this.mPassFaceRecogDTO.authToken);
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_OUTER) {
                httpHashMapWrap.put("type", "outer");
                httpHashMapWrap.put("exuid", this.mPassFaceRecogDTO.exUid);
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_FACEIMAGE) {
                httpHashMapWrap.put("type", ConstPath.KEY_DETECT);
                httpHashMapWrap.put("atbc", PassBioDataEncryptor.encryptParams(getAtbc(this.mPassFaceRecogDTO)));
            }
            Log.e(W, "face requestLivingAction: " + httpHashMapWrap.get("type"));
            try {
                if (this.mPassFaceRecogDTO.extraParams != null) {
                    for (String str : this.mPassFaceRecogDTO.extraParams.keySet()) {
                        httpHashMapWrap.put(str, (String) this.mPassFaceRecogDTO.extraParams.get(str));
                    }
                }
            } catch (Exception e3) {
                Log.e(W, "face extraParams Exception:" + e3.getMessage());
            }
            httpHashMapWrap.put(TcStatisticConstantKt.KEY_CLK_SIG, HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
            new HttpClientWrap(this).post(getLivingActionUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new o(Looper.getMainLooper(), System.currentTimeMillis()));
        }
    }

    private void m() {
        this.l.setVisibility(4);
        this.f15848g.setVisibility(0);
        this.f15848g.setText(R.string.pass_liveness_frist_text);
        c(0);
        this.J = null;
    }

    private void n() {
        PassFaceOperationCallback passFaceOperationCallback;
        HashMap<String, Integer> faceGrayOptionMap;
        boolean z2 = true;
        Log.d(W, "setUpView: ");
        PassBioDisplayUtil.enableNavigationBarTint(this, getResources().getColor(17170445));
        this.f15847f = (CircleProgressView) findViewById(R.id.pass_bio_liveness_recog_cpv);
        this.f15848g = (TextView) findViewById(R.id.pass_bio_liveness_recog_tip_text);
        this.f15849h = (TextView) findViewById(R.id.pass_bio_check_user_tip_text);
        this.f15850i = (ImageView) findViewById(R.id.pass_liveness_face_wireframe);
        PassBiometricConfiguration configuration = PassFaceRecogManager.getInstance().getConfiguration();
        if (!(configuration == null || (passFaceOperationCallback = configuration.mCallBackFaceOption) == null || (faceGrayOptionMap = passFaceOperationCallback.faceGrayOptionMap()) == null)) {
            this.I.n0 = new JSONObject(faceGrayOptionMap).toString();
            this.V.put("custom_compress_value", Integer.valueOf(configuration.mCallBackFaceOption.callbackFaceCompressValue()));
            this.V.put("final_compress_value", Integer.valueOf(PassFaceRecogManager.getInstance().getFinalCompressValue()));
            if (faceGrayOptionMap.get("face_wireframe") != null) {
                this.f15851j = faceGrayOptionMap.get("face_wireframe").intValue() == 1;
            }
            if (faceGrayOptionMap.get("request_permission") != null) {
                if (faceGrayOptionMap.get("request_permission").intValue() != 1) {
                    z2 = false;
                }
                this.k = z2;
            }
        }
        c(0);
        this.f15847f.setNormalColor(Color.parseColor("#FFE0E0E0"));
        this.f15847f.setOnChangeListener(new l());
        this.l = (FrameLayout) findViewById(R.id.layout_pose_warning);
        this.m = (ImageView) findViewById(R.id.iv_pose_warning_tip);
        this.n = (TextView) findViewById(R.id.tv_pose_warning_tip);
        this.o = (CameraSurfaceView) findViewById(R.id.pass_bio_camera_pre_view);
        this.p = (CircleImageView) findViewById(R.id.pass_bio_circle_image_view);
        this.q = (CircleImageView) findViewById(R.id.pass_bio_circle_hide_view);
        this.r = (LinearLayout) findViewById(R.id.pass_bio_loading_view);
        setBrightness(this, 255);
        ((ImageView) findViewById(R.id.pass_bio_liveness_recog_close)).setOnClickListener(this);
        PassFaceRecogDTO passFaceRecogDTO = this.mPassFaceRecogDTO;
        if (passFaceRecogDTO != null && passFaceRecogDTO.needAuthorizeCertInfo) {
            this.S = passFaceRecogDTO.extraParamsMap.get("yyOrderId");
            this.R = false;
            ((TextView) findViewById(R.id.sapi_sdk_titlebar_title_tv)).setText(R.string.home_face_yy_title);
            this.P = (ImageView) findViewById(R.id.pass_bio_circle_image_yy_view);
            this.Q = (RelativeLayout) findViewById(R.id.pass_bio_liveness_recog_yy_bottom);
            ImageView imageView = (ImageView) findViewById(R.id.pass_bio_liveness_agreement_selector);
            this.M = imageView;
            imageView.setOnClickListener(this);
            this.Q.setVisibility(0);
            this.P.setVisibility(0);
            findViewById(R.id.pass_bio_liveness_recog_tv_href).setOnClickListener(this);
            findViewById(R.id.pass_bio_liveness_recog_argee_btn).setOnClickListener(this);
            this.f15848g.setText(R.string.home_face_yy_tips);
        }
    }

    private void o() {
        this.I.B = 1;
        com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
        aVar.b(getString(R.string.pass_liveness_recog_fail_dialog_title));
        aVar.c(getString(R.string.pass_liveness_recog_fail_dialog_msg));
        aVar.c("重试", new c(aVar));
        aVar.a(getString(R.string.pass_bio_alert_dialog_btn_back), new d(aVar));
        aVar.setCancelable(false);
        if (!isFinishing() && !aVar.isShowing()) {
            aVar.show();
        }
    }

    private void p() {
        CircleProgressView circleProgressView = this.f15847f;
        if (circleProgressView != null) {
            circleProgressView.setVisibility(8);
        }
        showLoadingView();
        this.x = true;
    }

    private void q() {
        String str;
        Log.d(W, "showPermissionDialog: ");
        this.C = true;
        if (this.s == null) {
            com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
            this.s = aVar;
            aVar.b(getString(R.string.pass_bio_permission_request));
            this.s.b(true);
            this.s.c(getString(R.string.pass_liveness_permission_camera));
            this.s.a(getString(R.string.pass_bio_alert_dialog_btn_cancel), new p());
        }
        boolean z2 = this.k && !SapiContext.getInstance().getAlreadyRequestPermisson() && Build.VERSION.SDK_INT >= 23;
        if (z2) {
            str = getString(R.string.pass_bio_alert_dialog_btn_sure);
        } else {
            str = getString(R.string.pass_bio_alert_dialog_btn_go_setting);
        }
        this.s.c(str, new q(z2));
        this.s.setCancelable(false);
        if (!isFinishing() && !this.s.isShowing()) {
            Log.d(W, "showPermissionDialog: show");
            this.s.show();
        }
    }

    private void r() {
        this.p.c();
    }

    private void s() {
        Log.d(W, "showTimeOutDialog: mIsFristTimeOut" + this.z);
        m();
        onPause();
        if (this.z) {
            t();
            this.z = false;
            return;
        }
        o();
    }

    public static void setBrightness(Activity activity, int i2) {
        Log.d(W, "face setBrightness: " + i2);
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = ((float) i2) * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    private void t() {
        Log.d(W, "showVerifyTimeoutDialog: ");
        this.I.y = 1;
        com.baidu.pass.biometrics.face.liveness.d.a aVar = new com.baidu.pass.biometrics.face.liveness.d.a(this);
        aVar.b(getString(R.string.pass_face_timeout_dialog_title));
        aVar.c(0);
        aVar.a(getString(R.string.pass_face_timeout_dialog_msg));
        aVar.c(getString(R.string.pass_bio_alert_dialog_btn_again), new a(aVar));
        aVar.a(getString(R.string.pass_bio_cancel), new b(aVar));
        aVar.setCancelable(false);
        if (!isFinishing() && !aVar.isShowing()) {
            aVar.show();
        }
    }

    private void u() {
        this.l.setVisibility(8);
        this.l.clearAnimation();
        this.w = false;
    }

    public void animStop() {
    }

    public void backBtnClick() {
        if (this.L != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            a(passFaceRecogResult, -204, PassBiometricResult.ERROR_MSG_USER_CANCEL);
            this.L.onFailure(passFaceRecogResult);
        }
        a(1);
        setActivityResult(0);
        a();
    }

    public void getBitmapFromSurfaceView(SurfaceView surfaceView, PixelCopyCallback pixelCopyCallback) {
        if (surfaceView != null) {
            Bitmap createBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
            if (Build.VERSION.SDK_INT >= 24) {
                PixelCopy.request(surfaceView, createBitmap, new e(pixelCopyCallback, createBitmap), surfaceView.getHandler());
            }
        }
    }

    public void hideLoadingView() {
        if (this.o != null) {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            this.r.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void lockScreenOrientation() {
        Log.d(W, "lockScreenOrientation: ");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28 || i2 <= 25) {
            PassBiometricConfiguration configuration = PassFaceRecogManager.getInstance().getConfiguration();
            if (configuration == null || configuration.getUIOrientation() == null) {
                setRequestedOrientation(1);
            } else if (configuration.getUIOrientation() == UIOrientation.SCREEN_ORIENTATION_LANDSCAPE) {
                setRequestedOrientation(0);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    public void onBegin() {
        this.p.setVisibility(0);
        this.p.setBackgroundColor(-1);
        this.f15848g.setText(R.string.pass_liveness_frist_text);
        c(0);
    }

    public void onBeginBuildData() {
    }

    public void onBeginCollectFaceInfo() {
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.I;
        if (aVar.I == 0) {
            aVar.I = System.currentTimeMillis();
        }
        this.K = System.currentTimeMillis();
        this.o.setVisibility(0);
        this.E = true;
    }

    public void onClick(View view2) {
        Drawable drawable;
        if (view2.getId() == R.id.pass_bio_liveness_recog_close) {
            b(1);
        } else if (view2.getId() == R.id.pass_bio_liveness_recog_argee_btn) {
            this.Q.setVisibility(8);
            this.P.setVisibility(8);
            this.R = true;
            i();
        } else if (view2.getId() == R.id.pass_bio_liveness_recog_tv_href) {
            startActivity(new Intent(this, YYProtocolActivity.class));
        } else if (view2.getId() == R.id.pass_bio_liveness_agreement_selector) {
            Boolean valueOf = Boolean.valueOf(!this.R.booleanValue());
            this.R = valueOf;
            ImageView imageView = this.M;
            if (valueOf.booleanValue()) {
                drawable = getResources().getDrawable(R.drawable.pass_bio_liveness_selector_checked);
            } else {
                drawable = getResources().getDrawable(R.drawable.pass_bio_liveness_selector_narmol);
            }
            imageView.setBackgroundDrawable(drawable);
            findViewById(R.id.pass_bio_liveness_recog_argee_btn).setBackground(getResources().getDrawable(this.R.booleanValue() ? R.drawable.pass_liveness_agree_btn_bg : R.drawable.pass_liveness_agree_btn_bg_disable));
            findViewById(R.id.pass_bio_liveness_recog_argee_btn).setEnabled(this.R.booleanValue());
        }
    }

    public void onCollectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i2) {
        Log.i(W, "onCollectCompletion-faceStatusNewEnum:" + faceStatusNewEnum + ",message:" + str + ",mHasOpenLiveness:" + this.B + ",mHadHideCamare:" + this.E);
        this.I.H++;
        if (this.B) {
            if (this.E) {
                r();
                this.E = false;
            }
            switch (j.f15872a[faceStatusNewEnum.ordinal()]) {
                case 1:
                    u();
                    if (Build.VERSION.SDK_INT >= 24) {
                        getBitmapFromSurfaceView(this.o, new r());
                        return;
                    }
                    return;
                case 2:
                    this.I.t++;
                    c(str);
                    return;
                case 3:
                    this.I.u++;
                    c(str);
                    return;
                case 4:
                    this.I.x++;
                    c(str);
                    return;
                case 5:
                    com.baidu.pass.biometrics.face.liveness.b.a aVar = this.I;
                    aVar.f15898h = 0;
                    aVar.I = System.currentTimeMillis();
                    this.I.w++;
                    c(str);
                    return;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    this.I.v++;
                    c(str);
                    return;
                case 11:
                    this.J = LivenessTypeEnum.Eye;
                    com.baidu.pass.biometrics.face.liveness.b.a aVar2 = this.I;
                    aVar2.Y = com.baidu.pass.biometrics.face.liveness.b.a.D0;
                    aVar2.K = System.currentTimeMillis();
                    d(str);
                    return;
                case 12:
                    this.J = LivenessTypeEnum.Mouth;
                    com.baidu.pass.biometrics.face.liveness.b.a aVar3 = this.I;
                    aVar3.Y = "mouth";
                    aVar3.M = System.currentTimeMillis();
                    d(str);
                    return;
                case 13:
                    this.J = LivenessTypeEnum.HeadUp;
                    com.baidu.pass.biometrics.face.liveness.b.a aVar4 = this.I;
                    aVar4.Y = com.baidu.pass.biometrics.face.liveness.b.a.H0;
                    aVar4.S = System.currentTimeMillis();
                    d(str);
                    return;
                case 14:
                    this.J = LivenessTypeEnum.HeadDown;
                    com.baidu.pass.biometrics.face.liveness.b.a aVar5 = this.I;
                    aVar5.Y = com.baidu.pass.biometrics.face.liveness.b.a.I0;
                    aVar5.U = System.currentTimeMillis();
                    d(str);
                    return;
                case 15:
                    this.J = LivenessTypeEnum.HeadLeft;
                    com.baidu.pass.biometrics.face.liveness.b.a aVar6 = this.I;
                    aVar6.Y = com.baidu.pass.biometrics.face.liveness.b.a.G0;
                    aVar6.Q = System.currentTimeMillis();
                    d(str);
                    return;
                case 16:
                    this.J = LivenessTypeEnum.HeadRight;
                    com.baidu.pass.biometrics.face.liveness.b.a aVar7 = this.I;
                    aVar7.Y = com.baidu.pass.biometrics.face.liveness.b.a.F0;
                    aVar7.O = System.currentTimeMillis();
                    d(str);
                    return;
                case 17:
                    d(str);
                    return;
                case 18:
                    LivenessTypeEnum livenessTypeEnum = this.J;
                    if (livenessTypeEnum == LivenessTypeEnum.Eye) {
                        com.baidu.pass.biometrics.face.liveness.b.a aVar8 = this.I;
                        aVar8.f15900j++;
                        aVar8.L = System.currentTimeMillis();
                        return;
                    } else if (livenessTypeEnum == LivenessTypeEnum.Mouth) {
                        com.baidu.pass.biometrics.face.liveness.b.a aVar9 = this.I;
                        aVar9.k++;
                        aVar9.N = System.currentTimeMillis();
                        return;
                    } else if (livenessTypeEnum == LivenessTypeEnum.HeadRight) {
                        this.I.P = System.currentTimeMillis();
                        return;
                    } else if (livenessTypeEnum == LivenessTypeEnum.HeadLeft) {
                        this.I.R = System.currentTimeMillis();
                        return;
                    } else if (livenessTypeEnum == LivenessTypeEnum.HeadUp) {
                        this.I.T = System.currentTimeMillis();
                        return;
                    } else if (livenessTypeEnum == LivenessTypeEnum.HeadDown) {
                        this.I.V = System.currentTimeMillis();
                        return;
                    } else {
                        return;
                    }
                case 19:
                    s();
                    return;
                default:
                    return;
            }
        }
    }

    public void onConfigCamera(Camera camera, Rect rect, Rect rect2, Degree degree) {
        if (this.o != null) {
            Camera.Parameters parameters = camera.getParameters();
            CameraSurfaceView.a a2 = this.o.a(parameters);
            Log.e("new_face", "cameraSize = " + a2);
            parameters.setPreviewSize(a2.f15957a, a2.f15958b);
            camera.setParameters(parameters);
            parameters.setJpegQuality(50);
            camera.setParameters(parameters);
            if (!this.D) {
                ViewGroup.LayoutParams layoutParams = this.o.getLayoutParams();
                layoutParams.height = (int) (((float) a2.f15957a) * (((float) layoutParams.width) / ((float) a2.f15958b)));
                this.o.setLayoutParams(layoutParams);
                this.D = true;
            }
            rect.set(0, 0, a2.f15958b, a2.f15957a);
            int i2 = a2.f15958b;
            rect2.set(0, 0, i2, i2);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        Log.d(W, "onConfigurationChanged: " + configuration.orientation);
        super.onConfigurationChanged(configuration);
        int i2 = configuration.orientation;
        if (i2 == 2) {
            setContentView(R.layout.layout_pass_liveness_recognize_new_land);
        } else if (i2 == 1) {
            setContentView(R.layout.layout_pass_liveness_recognize_new);
        }
        n();
        if (!this.x && !this.C) {
            b();
            i();
        }
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        getWindow().addFlags(128);
        super.onCreate(bundle);
        if (getResources().getConfiguration().orientation == 1) {
            setContentView(R.layout.layout_pass_liveness_recognize_new);
        } else {
            setContentView(R.layout.layout_pass_liveness_recognize_new_land);
        }
        f();
        g();
        n();
        com.baidu.pass.biometrics.face.liveness.c.b bVar = this.v;
        if (bVar != null) {
            bVar.a((b.C0246b) new k());
        }
        k();
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(W, "onDestroy: ");
        com.baidu.pass.biometrics.face.liveness.c.b bVar = this.v;
        if (bVar != null) {
            bVar.b();
        }
        TimerTask timerTask = this.G;
        if (timerTask != null) {
            timerTask.cancel();
            this.F.purge();
            this.G = null;
            this.F = null;
        }
        ViewGroup viewGroup = this.f15846e;
        if (viewGroup != null) {
            a((View) viewGroup);
            this.f15846e.removeCallbacks((Runnable) null);
            this.f15846e = null;
        }
        PassFaceRecogManager.getInstance().cleanPassFaceRecogCallback();
        try {
            System.gc();
        } catch (Exception e2) {
            Log.e("TAG", e2.getMessage());
        }
    }

    public void onDeviceCheckResult(int i2) {
    }

    public void onEnd(int i2, RequestInfo requestInfo) {
        Log.i(W, "onEnd() Code = " + i2 + ",requestInfo = ");
        this.I.G += System.currentTimeMillis() - this.K;
        this.f15848g.setVisibility(4);
        if (this.L != null) {
            switch (i2) {
                case -18:
                case -14:
                case -13:
                case -12:
                case -11:
                case -10:
                case -9:
                case -8:
                case -7:
                case -5:
                case -4:
                case -3:
                case -2:
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    a(passFaceRecogResult, i2, "检测人脸超时,请把脸移入框内");
                    this.L.onFailure(passFaceRecogResult);
                    a();
                    return;
                case -15:
                    if (this.mConfiguration != null) {
                        SafeService instance = SafeService.getInstance();
                        PassBiometricConfiguration passBiometricConfiguration = this.mConfiguration;
                        instance.init(this, passBiometricConfiguration.sofireAppKey, passBiometricConfiguration.sofireSecKey, passBiometricConfiguration.sofireHostID, true);
                        SafeService.getInstance().setAgreeDangerousProtocol(this, this.mConfiguration.isAgreeDangerousProtocol());
                    }
                    PassFaceRecogResult passFaceRecogResult2 = new PassFaceRecogResult();
                    a(passFaceRecogResult2, i2, "未成功加载安全模块(-15)");
                    this.L.onFailure(passFaceRecogResult2);
                    a();
                    return;
                case 1:
                    a(requestInfo);
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        b(2);
        return false;
    }

    public void onPause() {
        super.onPause();
        if (this.C) {
            Log.d(W, "face onPause: mShouldRequestPermission");
            return;
        }
        this.U = true;
        Log.d(W, "face onPause: cancelLiveness");
        b();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.C = false;
        Log.d(W, "face onRequestPermissionsResult: " + i2);
        if (i2 != 2002) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            this.I.c0 = 2;
            q();
            return;
        }
        SapiContext.getInstance().setAlreadyRequestPermisson(false);
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.I;
        aVar.c0 = 1;
        aVar.E = System.currentTimeMillis();
        com.baidu.pass.biometrics.face.liveness.b.a aVar2 = this.I;
        aVar2.f15895e = 1;
        aVar2.f15896f = 1;
        i();
    }

    public void onResume() {
        super.onResume();
        if (this.x) {
            Log.d(W, "onResume: mIsStartLoading");
            return;
        }
        RelativeLayout relativeLayout = this.Q;
        if ((relativeLayout == null || relativeLayout.getVisibility() != 0) && !this.C && this.U) {
            Log.d(W, "onResume: prepareOpenLiveness");
            this.U = false;
            i();
        }
    }

    public void onTestFrame(Bitmap bitmap) {
    }

    public void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum) {
    }

    public void setFaceInfo(FaceExtInfo faceExtInfo) {
    }

    public void showLoadingView() {
        if (this.o != null) {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            this.r.setVisibility(0);
        }
    }

    public void viewReset() {
    }

    private void c(String str) {
        a(ProgressStatus.BACK);
        this.f15848g.setVisibility(0);
        this.f15848g.setText(str);
        if (getString(R.string.detect_face_in).equals(str)) {
            c(0);
        } else {
            c(4);
        }
        e(str);
    }

    private int d() {
        List<Integer> c2 = c();
        if (c2 != null && !c2.isEmpty()) {
            int illumVlaueGray = LocalConfigOptions.getInstance(this).getIllumVlaueGray();
            if (illumVlaueGray == -1) {
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());
                illumVlaueGray = random.nextInt(c2.size());
                LocalConfigOptions.getInstance(this).setIllumValueGray(illumVlaueGray);
            }
            if (illumVlaueGray >= 0 && illumVlaueGray <= c2.size() - 1) {
                int intValue = c2.get(illumVlaueGray).intValue();
                Log.d(W, "face_config getOnlineIllum: gray:" + illumVlaueGray + ", illum=" + intValue);
                return intValue;
            }
        }
        return 8;
    }

    private void e(String str) {
        if (!this.A) {
            this.l.setVisibility(0);
            this.n.setText(str);
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.pass_liveness_tip_warning);
            loadAnimation.setAnimationListener(new s(loadAnimation));
            if (!this.w) {
                this.m.startAnimation(loadAnimation);
                this.w = true;
            }
        }
    }

    private void f() {
        if (this.mPassFaceRecogDTO == null) {
            PassFaceRecogCallback passFaceRecogCallback = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
            if (passFaceRecogCallback != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                a(passFaceRecogResult, -205, PassBiometricResult.ERROR_MSG_PARAM);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            }
            a();
            return;
        }
        this.L = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
        this.t = LocalConfigOptions.getInstance(this).getBioOptions().livenessConfigOption;
        this.u = d();
        this.v = new com.baidu.pass.biometrics.face.liveness.c.b(this);
    }

    private void g() {
        if (this.I == null) {
            this.I = new com.baidu.pass.biometrics.face.liveness.b.a();
        }
        this.I.D = System.currentTimeMillis();
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.I;
        aVar.f15897g = 1;
        PassFaceRecogDTO passFaceRecogDTO = this.mPassFaceRecogDTO;
        aVar.f15892b = passFaceRecogDTO != null ? passFaceRecogDTO.getSpno() : "unknown";
        com.baidu.pass.biometrics.face.liveness.b.a aVar2 = this.I;
        PassFaceRecogDTO passFaceRecogDTO2 = this.mPassFaceRecogDTO;
        aVar2.f15893c = passFaceRecogDTO2 != null ? passFaceRecogDTO2.uid : "";
        com.baidu.pass.biometrics.face.liveness.b.a aVar3 = this.I;
        aVar3.n = this.u;
        aVar3.o = 1;
        PassFaceRecogDTO passFaceRecogDTO3 = this.mPassFaceRecogDTO;
        aVar3.f15891a = passFaceRecogDTO3 != null ? passFaceRecogDTO3.livenessType.getRecogTypeName() : "unknown_type";
    }

    /* access modifiers changed from: private */
    public void h() {
        CameraSurfaceView cameraSurfaceView = this.o;
        if (cameraSurfaceView != null && cameraSurfaceView.getHolder() != null && !this.B && this.R.booleanValue()) {
            SdkConfigOptions.LivenessConfigOption livenessConfigOption = this.t;
            if (livenessConfigOption != null && livenessConfigOption.mCloseFace) {
                this.A = false;
                e("当前刷脸功能正在升级中...");
            } else if (this.t != null) {
                FaceVerifyInfo faceVerifyInfo = new FaceVerifyInfo("null", "null", 0, (String) null, (FaceEnum.LivenessControl) null, (FaceEnum.SpoofingControl) null, (FaceEnum.QualityControl) null, "null");
                int e2 = e();
                Log.w(W, "face openLiveness: startFaceSurfaceLiveness, recogUploadPortraitCount:" + e2);
                FaceApi.startFaceSurfaceLiveness(this, this.o.getHolder(), this, 0, faceVerifyInfo, true, e2);
                this.B = true;
            }
        }
    }

    private void i() {
        Log.d(W, "face prepareOpenLiveness: hadRequestLivingAction:" + this.T);
        if (!this.T) {
            l();
        } else {
            h();
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        Log.d(W, "refreshFaceSurfaceLiveness: ");
        this.I.a();
        this.I.Z = 0;
        onResume();
    }

    /* access modifiers changed from: private */
    public void b(float f2) {
        if (!this.y && a(f2)) {
            this.y = true;
            this.v.b();
            com.baidu.pass.biometrics.face.liveness.b.a aVar = this.I;
            aVar.m = f2;
            aVar.l = 1;
        }
    }

    private boolean a(float f2) {
        return f2 <= ((float) this.u);
    }

    private void a(View view2) {
        if (view2 != null) {
            if (view2.getBackground() != null) {
                view2.getBackground().setCallback((Drawable.Callback) null);
                view2.setBackgroundResource(0);
            }
            if (view2 instanceof ImageView) {
                ((ImageView) view2).setImageBitmap((Bitmap) null);
            }
            if (view2 instanceof ViewGroup) {
                int i2 = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    if (i2 < viewGroup.getChildCount()) {
                        a(viewGroup.getChildAt(i2));
                        i2++;
                    } else {
                        viewGroup.removeAllViews();
                        view2.setBackgroundResource(0);
                        return;
                    }
                }
            }
        }
    }

    private void c(int i2) {
        ImageView imageView = this.f15850i;
        if (imageView != null) {
            if (!this.f15851j || i2 != 0) {
                imageView.setVisibility(4);
            } else {
                imageView.setVisibility(0);
            }
        }
    }

    private void b() {
        Log.d(W, "cancelLiveness: ");
        FaceApi.cancelFaceProcess();
        this.B = false;
    }

    private List<Integer> c() {
        List<Integer> list = this.abtestIllumList;
        if (list == null || list.isEmpty()) {
            return Arrays.asList(new Integer[]{8});
        }
        Log.d(W, "face_config getABtestIllumList: " + this.abtestIllumList.get(0));
        return this.abtestIllumList;
    }

    private void d(String str) {
        this.A = false;
        a(ProgressStatus.GO);
        this.f15848g.setText(str);
        this.f15848g.setVisibility(0);
        c(4);
        u();
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.I;
        aVar.f15898h = 1;
        aVar.J = System.currentTimeMillis();
    }

    private void b(String str, String str2, String str3) {
        String str4;
        Log.d(W, "onlyLiveness: faceDetectUrl");
        if (this.mPassFaceRecogDTO != null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("processid", this.mPassFaceRecogDTO.processid);
            httpHashMapWrap.put("exuid", this.mPassFaceRecogDTO.exUid);
            httpHashMapWrap.put("image", str3);
            httpHashMapWrap.put("version", "1");
            httpHashMapWrap.put("client", "android");
            if (this.t.isOriginImg()) {
                str4 = "1";
            } else {
                str4 = "0";
            }
            httpHashMapWrap.put("isOriginImg", str4);
            String zid = PassBioGlobalUtils.getZid(getApplicationContext(), this.mPassFaceRecogDTO.exUid, 112);
            if (!TextUtils.isEmpty(zid)) {
                httpHashMapWrap.put("zid", zid);
            }
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, this.mPassFaceRecogDTO.di);
            if (!TextUtils.isEmpty(str)) {
                httpHashMapWrap.put("sKey", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                httpHashMapWrap.put("xDeviceId", str2);
            }
            httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
            String nonce = HttpClientWrap.getNonce(this, this.mPassFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
            if (!TextUtils.isEmpty(nonce)) {
                httpHashMapWrap.put("nonce", nonce);
            }
            httpHashMapWrap.put("isSafeSDK", "1");
            httpHashMapWrap.put("face_debug", String.valueOf(this.mPassFaceRecogDTO.faceDebug));
            try {
                if (this.mPassFaceRecogDTO.extraParams != null) {
                    for (String str5 : this.mPassFaceRecogDTO.extraParams.keySet()) {
                        httpHashMapWrap.put(str5, (String) this.mPassFaceRecogDTO.extraParams.get(str5));
                    }
                }
            } catch (Exception e2) {
                Log.e(W, e2.getMessage());
            }
            httpHashMapWrap.put(TcStatisticConstantKt.KEY_CLK_SIG, HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Encoding", "gzip");
            new HttpClientWrap(this).post(getFaceDetectUrl(), ReqPriority.IMMEDIATE, (HttpHashMap) httpHashMapWrap, (HttpHandlerWrap) new f(Looper.getMainLooper(), System.currentTimeMillis()), hashMap);
        }
    }

    private void a(RequestInfo requestInfo) {
        if (requestInfo != null) {
            JSONObject jSONObject = requestInfo.data;
            String str = null;
            if (jSONObject != null) {
                str = jSONObject.optString("data");
                this.V.put("image_size", Integer.valueOf(str.getBytes(Charset.forName("UTF-8")).length / 1024));
            }
            p();
            if (this.mPassFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
                b(requestInfo.sKey, requestInfo.xDeviceId, str);
            } else {
                a(requestInfo.sKey, requestInfo.xDeviceId, str);
            }
        }
    }

    private int e() {
        try {
            if (!TextUtils.isEmpty(this.recogUploadPortraitCount)) {
                return Math.max(1, Integer.valueOf(this.recogUploadPortraitCount).intValue());
            }
            return 3;
        } catch (NumberFormatException e2) {
            Log.e(W, "face_config getRecogUploadPortraitCount: " + e2.getMessage());
            return 3;
        }
    }

    private void a(ProgressStatus progressStatus) {
        ProgressStatus progressStatus2 = this.H;
        if ((progressStatus2 == null || progressStatus2 != progressStatus) && this.F != null && progressStatus2 != progressStatus) {
            this.H = progressStatus;
            int i2 = j.f15873b[progressStatus.ordinal()];
            if (i2 == 1) {
                TimerTask timerTask = this.G;
                if (timerTask != null) {
                    timerTask.cancel();
                    this.F.purge();
                }
                com.baidu.pass.biometrics.face.liveness.enums.b bVar = new com.baidu.pass.biometrics.face.liveness.enums.b(this.f15847f);
                this.G = bVar;
                this.F.schedule(bVar, 0, 10);
            } else if (i2 == 2) {
                TimerTask timerTask2 = this.G;
                if (timerTask2 != null) {
                    timerTask2.cancel();
                    this.F.purge();
                }
                com.baidu.pass.biometrics.face.liveness.enums.a aVar = new com.baidu.pass.biometrics.face.liveness.enums.a(this.f15847f);
                this.G = aVar;
                this.F.schedule(aVar, 0, 10);
            }
        }
    }

    private void a(String str, String str2, String str3) {
        String str4;
        if (this.mPassFaceRecogDTO != null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("processid", this.mPassFaceRecogDTO.processid);
            PassFaceRecogType passFaceRecogType = this.mPassFaceRecogDTO.livenessType;
            if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
                httpHashMapWrap.put("type", "contrastportrait");
                httpHashMapWrap.put("atbc", PassBioDataEncryptor.encryptParams(getAtbc(this.mPassFaceRecogDTO)));
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
                httpHashMapWrap.put("type", "certinfo");
                httpHashMapWrap.put("exuid", this.mPassFaceRecogDTO.exUid);
                if (!TextUtils.isEmpty(this.mPassFaceRecogDTO.verifyType)) {
                    httpHashMapWrap.put("verify_type", this.mPassFaceRecogDTO.verifyType);
                }
                if (!TextUtils.isEmpty(this.mPassFaceRecogDTO.nation)) {
                    httpHashMapWrap.put("nation", this.mPassFaceRecogDTO.nation);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.mPassFaceRecogDTO.realName);
                    jSONObject.put("cert", this.mPassFaceRecogDTO.idCardNum);
                    jSONObject.put("bankmobile", this.mPassFaceRecogDTO.phoneNum);
                    if (!TextUtils.isEmpty(this.S)) {
                        jSONObject.put("yyOrderId", this.S);
                    }
                    httpHashMapWrap.put("certinfo", PassBioDataEncryptor.encryptParams(jSONObject.toString()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                httpHashMapWrap.put("type", "authtoken");
                httpHashMapWrap.put("authtoken", this.mPassFaceRecogDTO.authToken);
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_OUTER) {
                httpHashMapWrap.put("type", "outer");
                httpHashMapWrap.put("exuid", this.mPassFaceRecogDTO.exUid);
            } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_FACEIMAGE) {
                httpHashMapWrap.put("type", ConstPath.KEY_DETECT);
                httpHashMapWrap.put("atbc", PassBioDataEncryptor.encryptParams(getAtbc(this.mPassFaceRecogDTO)));
            }
            httpHashMapWrap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.mPassFaceRecogDTO.serviceType);
            httpHashMapWrap.put("image", str3);
            httpHashMapWrap.put("version", "1");
            if (this.t.isOriginImg()) {
                str4 = "1";
            } else {
                str4 = "0";
            }
            httpHashMapWrap.put("isOriginImg", str4);
            httpHashMapWrap.put("client", "android");
            String zid = PassBioGlobalUtils.getZid(getApplicationContext(), this.mPassFaceRecogDTO.exUid, 112);
            if (!TextUtils.isEmpty(zid)) {
                httpHashMapWrap.put("zid", zid);
            }
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, this.mPassFaceRecogDTO.di);
            httpHashMapWrap.put(FeedItemDataHotStripe.POSITION_LAST, "1");
            if (!TextUtils.isEmpty(str)) {
                httpHashMapWrap.put("sKey", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                httpHashMapWrap.put("xDeviceId", str2);
            }
            httpHashMapWrap.put("isSafeSDK", "1");
            httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
            String nonce = HttpClientWrap.getNonce(this, this.mPassFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
            if (!TextUtils.isEmpty(nonce)) {
                httpHashMapWrap.put("nonce", nonce);
            }
            httpHashMapWrap.put("face_debug", String.valueOf(this.mPassFaceRecogDTO.faceDebug));
            try {
                if (this.mPassFaceRecogDTO.extraParams != null) {
                    for (String str5 : this.mPassFaceRecogDTO.extraParams.keySet()) {
                        httpHashMapWrap.put(str5, (String) this.mPassFaceRecogDTO.extraParams.get(str5));
                    }
                }
            } catch (Exception e3) {
                Log.e(W, e3.getMessage());
            }
            httpHashMapWrap.put(TcStatisticConstantKt.KEY_CLK_SIG, HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Encoding", "gzip");
            long currentTimeMillis = System.currentTimeMillis();
            Log.w(W, "face livenessWithCert: + authFaceMatch");
            new HttpClientWrap(this).post(getAuthFaceMatchUrl(), ReqPriority.IMMEDIATE, (HttpHashMap) httpHashMapWrap, (HttpHandlerWrap) new g(Looper.getMainLooper(), currentTimeMillis), hashMap);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        Log.d(W, "setLivenessSuccess: ");
        if (this.L != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaiduRimConstants.RETCODE_KEY);
                String optString = jSONObject.optString("retMsg");
                this.I.X = optInt;
                this.I.m0 = optString;
                passFaceRecogResult.extraJson = new JSONObject(str).getJSONObject("result");
                passFaceRecogResult.callbackkey = passFaceRecogResult.extraJson.optString("faceid");
                if (TextUtils.isEmpty(passFaceRecogResult.callbackkey)) {
                    a(optInt, optString);
                    return;
                }
                a(passFaceRecogResult, 0, PassBiometricResult.RESULT_MSG_SUCCESS);
                this.I.q = "pass";
                this.L.onSuccess(passFaceRecogResult);
                a();
            } catch (JSONException e2) {
                a(-207, PassBiometricResult.ERROR_MSG_SERVER_JSON_PARSE_ERROR);
            }
        }
    }

    private void b(int i2) {
        m();
        onPause();
        com.baidu.pass.biometrics.face.liveness.d.b bVar = new com.baidu.pass.biometrics.face.liveness.d.b(this);
        bVar.c("重新刷脸", new h(bVar));
        bVar.a("放弃刷脸", new i(bVar, i2));
        bVar.a(getResources().getDrawable(R.drawable.icon_face_back_alert));
        bVar.b("确定放弃刷脸吗？");
        bVar.a("刷脸验证通过后可以提升账号的安全性和使用的便捷性，建议您继续完成刷脸验证~");
        bVar.show();
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        ContrastPortraitResult contrastPortraitResult = new ContrastPortraitResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(BaiduRimConstants.RETCODE_KEY);
            String optString = jSONObject.optString("retMsg");
            Log.w(W, "face livenessWithCertSuccess: " + optInt);
            contrastPortraitResult.setResultCode(optInt);
            contrastPortraitResult.setResultMsg(optString);
            this.I.X = optInt;
            this.I.m0 = optString;
            if (contrastPortraitResult.getResultCode() == 0) {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("result");
                if (this.mPassFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                    contrastPortraitResult.authsid = optJSONObject.optString(BoxAccountContants.AUTH_SID);
                }
                contrastPortraitResult.callbackkey = optJSONObject.optString("callbackkey");
                contrastPortraitResult.contrastres = optJSONObject.optInt("contrastres");
                contrastPortraitResult.finalres = optJSONObject.optInt("finalres");
                contrastPortraitResult.finish = optJSONObject.optInt("finish");
                contrastPortraitResult.imgdigests = optJSONObject.optString("imgdigests");
                contrastPortraitResult.recordvideo = optJSONObject.optInt("recordvideo");
            } else {
                a(optInt, optString);
            }
        } catch (JSONException e2) {
            a(-207, PassBiometricResult.ERROR_MSG_SERVER_JSON_PARSE_ERROR);
        }
        a(contrastPortraitResult);
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        Log.d(W, "setLivenessFail: err:" + i2 + " msg:" + str);
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.I;
        aVar.X = i2;
        aVar.m0 = str;
        aVar.q = "fail";
        if (this.L != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(i2);
            passFaceRecogResult.setResultMsg(str);
            this.L.onFailure(passFaceRecogResult);
            setActivityResult(-1);
        }
        a();
    }

    private void a(ContrastPortraitResult contrastPortraitResult) {
        Log.d(W, "face goToFaceMatchResult: ");
        if (this.L != null && contrastPortraitResult != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            if (contrastPortraitResult.isProcessPass()) {
                a(passFaceRecogResult, 0, PassBiometricResult.RESULT_MSG_SUCCESS);
            } else {
                a(passFaceRecogResult, contrastPortraitResult.getResultCode(), contrastPortraitResult.getResultMsg());
            }
            passFaceRecogResult.callbackkey = contrastPortraitResult.callbackkey;
            passFaceRecogResult.authSid = contrastPortraitResult.authsid;
            if (contrastPortraitResult.isProcessPass()) {
                this.I.q = "pass";
                this.L.onSuccess(passFaceRecogResult);
            } else {
                this.I.q = "fail";
                this.L.onFailure(passFaceRecogResult);
            }
            a();
        }
    }

    /* access modifiers changed from: private */
    public void a(PassFaceRecogResult passFaceRecogResult, int i2, String str) {
        Log.e(W, "face setResultCodeAndMsg: result:" + i2 + ", msg:" + str);
        passFaceRecogResult.setResultCode(i2);
        passFaceRecogResult.setResultMsg(str);
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.I;
        aVar.X = i2;
        aVar.m0 = str;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.I;
        aVar.Z = i2;
        LivenessTypeEnum livenessTypeEnum = this.J;
        if (livenessTypeEnum == null) {
            aVar.r = com.baidu.pass.biometrics.face.liveness.b.a.J0;
        } else if (livenessTypeEnum == LivenessTypeEnum.Eye) {
            aVar.r = com.baidu.pass.biometrics.face.liveness.b.a.K0;
        } else if (livenessTypeEnum == LivenessTypeEnum.Mouth) {
            aVar.r = com.baidu.pass.biometrics.face.liveness.b.a.L0;
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        Log.d(W, "activityFinish: ");
        com.baidu.pass.biometrics.face.liveness.b.a aVar = this.I;
        if (aVar != null) {
            aVar.W = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject(this.V);
            this.I.o0 = jSONObject.toString();
            this.I.a(this);
        }
        PassFaceRecogManager.getInstance().cleanPassFaceRecogCallback();
        if (this.L != null) {
            this.L = null;
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void a(JSONArray jSONArray) {
        try {
            this.abtestIllumList = new ArrayList();
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                        this.abtestIllumList.add(Integer.valueOf(jSONArray.optInt(i2)));
                    }
                }
            }
        } catch (Exception e2) {
            Log.e(W, "setJsonArrayToList: ", e2.getMessage());
        }
        this.u = d();
    }
}
