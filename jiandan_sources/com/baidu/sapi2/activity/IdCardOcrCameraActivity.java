package com.baidu.sapi2.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.callback.IdCardOcrCallback;
import com.baidu.sapi2.result.IdCardOcrResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.views.a;
import com.tera.scan.ui.widget.RotateProgress;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class IdCardOcrCameraActivity extends Activity implements Camera.PreviewCallback, View.OnClickListener {
    public static final String D = "IdCardOcrCameraActivity";
    public static final int E = 2001;
    public static final int F = 2002;
    public static final int G = 1920;
    public static final int H = 1080;
    public static final int I = 1001;
    public static final String IAMGE_TYPE_EMBLEM = "1";
    public static final String IAMGE_TYPE_PEOPLE = "2";
    public static final int J = 1002;
    public static final String PARAM_KEY_ID_CARD_TYPE = "PARAM_KEY_ID_CARD_TYPE";
    public static final String PERMISSION_TYPE_ALBUM = "PERMISSION_TYPE_ALBUM";
    public static final String PERMISSION_TYPE_CAMERA = "PERMISSION_TYPE_CAMERA";
    public int A = 300;
    public int B = 80;
    public String C;
    public Dialog a;
    public FrameLayout b;
    public FrameLayout c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public ImageView g;
    public Camera h;

    /* renamed from: i  reason: collision with root package name */
    public Camera.Parameters f952i;
    public byte[] j;
    public int k;
    public int l;
    public int m;
    public int n;

    /* renamed from: o  reason: collision with root package name */
    public int f953o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public float t;
    public a u;
    public IdCardOcrCallback v;
    public boolean w;
    public long x = System.currentTimeMillis();
    public int y = 0;
    public long[] z = {255, 255, 255, 255};

    private void b() {
        this.b = (FrameLayout) findViewById(R.id.sapi_sdk_ocr_frame_layout);
        this.c = (FrameLayout) findViewById(R.id.sapi_sdk_fl_ocr_camera_border);
        this.d = (TextView) findViewById(R.id.sapi_sdk_tv_light_tip);
        this.e = (TextView) findViewById(R.id.sapi_sdk_tv_type_tip);
        this.f = (ImageView) findViewById(R.id.sapi_sdk_iv_ocr_id_card_people);
        this.g = (ImageView) findViewById(R.id.sapi_sdk_iv_ocr_id_card_emblem);
        if ("1".equals(this.C)) {
            this.f.setVisibility(8);
            this.g.setVisibility(0);
            this.e.setText("请将二代身份证的国徽页放入识别框内");
        } else if ("2".equals(this.C)) {
            this.f.setVisibility(0);
            this.g.setVisibility(8);
            this.e.setText("请将二代身份证的人像页放入识别框内");
        } else {
            a(true, -405, IdCardOcrResult.MESSAGE_PAGE_PARAMS_ERROR, "", "");
        }
        ((FrameLayout) findViewById(R.id.sapi_sdk_fl_take_photo)).setOnClickListener(this);
    }

    private void c() {
        boolean z2 = false;
        try {
            if (this.h == null) {
                Camera open = Camera.open(0);
                this.h = open;
                Camera.Parameters parameters = open.getParameters();
                this.f952i = parameters;
                parameters.setJpegQuality(100);
                this.f952i.setPreviewFormat(17);
                this.f952i.setPictureFormat(256);
                setCameraDisplayOrientation(0, this.h);
                g();
                h();
                f();
                this.h.setParameters(this.f952i);
            }
            if (this.u == null) {
                a aVar = new a(this, this.h);
                this.u = aVar;
                aVar.setPreviewCallback(this);
                this.b.addView(this.u);
            }
            z2 = true;
        } catch (Exception e2) {
            Log.e(D, (Throwable) e2);
            a aVar2 = this.u;
            if (aVar2 != null) {
                aVar2.a();
                d();
            }
        }
        if (!z2) {
            i();
        }
    }

    private void d() {
        FrameLayout frameLayout = this.c;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setVisibility(8);
        }
        a aVar = this.u;
        if (aVar != null) {
            this.b.removeView(aVar);
            this.u.a();
            this.u = null;
        }
        Camera camera = this.h;
        if (camera != null) {
            camera.setPreviewCallback((Camera.PreviewCallback) null);
            this.h.stopPreview();
            this.h.release();
            this.h = null;
        }
    }

    private void e() {
        if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.CAMERA") == 0) {
            this.s = true;
            c();
        } else if (shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
            CommonDialog.qw qwVar = new CommonDialog.qw(this);
            qwVar.uk(String.format("%1$sApp将使用“%2$s", new Object[]{PassBiometricUtil.getAppName(this), "摄像头/相机"}));
            qwVar.rg(String.format("为了您使用识别功能，请允许%1$sApp使用%2$s。您可以通过系统“设置”进行权限的管理", new Object[]{PassBiometricUtil.getAppName(this), "摄像头/相机"}));
            qwVar.yj("继续", new View.OnClickListener() {
                public void onClick(View view) {
                    IdCardOcrCameraActivity.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 2001);
                }
            });
            qwVar.th("关闭", new View.OnClickListener() {
                public void onClick(View view) {
                    IdCardOcrCameraActivity idCardOcrCameraActivity = IdCardOcrCameraActivity.this;
                    idCardOcrCameraActivity.a(false, -401, IdCardOcrResult.MESSAGE_NO_CAMERA_PERMISSION, idCardOcrCameraActivity.C, "");
                }
            });
            qwVar.de().show();
        } else {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 2001);
        }
    }

    private void f() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        int min = Math.min(this.n - ((int) ((Resources.getSystem().getDisplayMetrics().density * 80.0f) + 0.5f)), dp2px(300.0f));
        this.k = min;
        int i2 = (int) (((float) min) * 1.585f);
        this.l = i2;
        layoutParams.width = min;
        layoutParams.height = i2;
        Log.e("ocr-test", "设置框尺寸： mBorderWidth = " + this.k + "，mBorderHeight = " + this.l);
        this.c.setLayoutParams(layoutParams);
        this.e.setVisibility(0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams2.rightMargin = (int) (((float) this.l) * 0.14f);
        layoutParams2.bottomMargin = (int) (((float) this.k) * 0.082f);
        this.f.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams3.rightMargin = (int) (((float) this.l) * 0.098f);
        layoutParams3.topMargin = (int) (((float) this.k) * 0.048f);
        this.g.setLayoutParams(layoutParams3);
    }

    private void g() {
        Camera.Parameters parameters;
        if (this.h != null && (parameters = this.f952i) != null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            List<Camera.Size> supportedPictureSizes = this.f952i.getSupportedPictureSizes();
            ArrayList<CameraSize> arrayList = new ArrayList<>();
            for (Camera.Size next : supportedPreviewSizes) {
                if (next != null) {
                    arrayList.add(new CameraSize(next));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Camera.Size next2 : supportedPictureSizes) {
                if (next2 != null) {
                    arrayList2.add(new CameraSize(next2));
                }
            }
            arrayList.retainAll(arrayList2);
            CameraSize cameraSize = null;
            for (CameraSize cameraSize2 : arrayList) {
                Log.e("ocr-test", "相机支持设置的尺寸： width = " + cameraSize2.a + ", height = " + cameraSize2.b);
                float f2 = ((float) cameraSize2.b) / ((float) this.n);
                int i2 = (int) (((float) cameraSize2.a) / f2);
                if (i2 >= this.q && f2 > this.t) {
                    this.t = f2;
                    this.f953o = i2;
                    Log.e("ocr-test", "有合适尺寸：" + cameraSize2.toString());
                    cameraSize = cameraSize2;
                }
            }
            if (cameraSize == null) {
                Log.e("ocr-test", "未匹配到合适，默认尺寸: 1920*1080");
                this.t = 1.0f;
                this.f953o = 1920;
                cameraSize = new CameraSize(1920, 1080);
            }
            this.f952i.setPictureSize(cameraSize.a, cameraSize.b);
            this.f952i.setPreviewSize(cameraSize.a, cameraSize.b);
        }
    }

    private void h() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.height = this.f953o;
        layoutParams.width = this.p;
        Log.e("ocr-test", "设置preview尺寸： mPreviewHeight = " + this.f953o + "，mPreviewWidth = " + this.p + ",预览分辨率 / 屏幕 = " + this.t);
        this.b.setLayoutParams(layoutParams);
    }

    private void i() {
        if (this.a == null) {
            CommonDialog.qw qwVar = new CommonDialog.qw(this);
            qwVar.uk("开启摄像头权限");
            qwVar.rg("为了使用正常拍照服务\n请开启摄像头权限");
            qwVar.yj("去设置", new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.addFlags(268435456);
                    intent.setData(Uri.fromParts("package", IdCardOcrCameraActivity.this.getPackageName(), (String) null));
                    if (intent.resolveActivity(IdCardOcrCameraActivity.this.getPackageManager()) != null) {
                        IdCardOcrCameraActivity.this.startActivity(intent);
                    }
                    IdCardOcrCameraActivity idCardOcrCameraActivity = IdCardOcrCameraActivity.this;
                    idCardOcrCameraActivity.a(false, -401, IdCardOcrResult.MESSAGE_NO_CAMERA_PERMISSION, idCardOcrCameraActivity.C, "");
                }
            });
            qwVar.th("关闭", new View.OnClickListener() {
                public void onClick(View view) {
                    IdCardOcrCameraActivity idCardOcrCameraActivity = IdCardOcrCameraActivity.this;
                    idCardOcrCameraActivity.a(false, -401, IdCardOcrResult.MESSAGE_NO_CAMERA_PERMISSION, idCardOcrCameraActivity.C, "");
                }
            });
            this.a = qwVar.de();
        }
        this.a.setCancelable(false);
        if (!isFinishing() && !this.a.isShowing()) {
            this.a.show();
        }
    }

    public int dp2px(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public void onBackPressed() {
        super.onBackPressed();
        IdCardOcrResult idCardOcrResult = new IdCardOcrResult();
        idCardOcrResult.setResultCode(-301);
        this.v.onFailure(idCardOcrResult);
    }

    public void onClick(View view) {
        Camera.Parameters parameters;
        if (view.getId() == R.id.sapi_sdk_fl_take_photo && this.j != null && (parameters = this.f952i) != null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            byte[] a2 = b.a(a(b.a(this.j, previewSize.width, previewSize.height)), 100);
            if (a2 == null) {
                IdCardOcrResult idCardOcrResult = new IdCardOcrResult();
                idCardOcrResult.setResultCode(IdCardOcrResult.CODE_CAMERA_ERROR);
                idCardOcrResult.setResultMsg(IdCardOcrResult.MESSAGE_CAMERA_ERROR);
                this.v.onFailure(idCardOcrResult);
                finish();
                return;
            }
            a(true, 0, "", this.C, Base64Utils.encodeToString(a2));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setContentView(R.layout.layout_activity_ocr_id_card);
        a();
        b();
        if (!this.w) {
            d();
            if (this.s) {
                FrameLayout frameLayout = this.c;
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                }
                c();
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_ocr_id_card);
        this.v = CoreViewRouter.getInstance().getIdCardOcrCallback();
        a();
        b();
        e();
    }

    public void onDestroy() {
        super.onDestroy();
        d();
    }

    public void onPause() {
        super.onPause();
        if (!this.w) {
            d();
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.j = bArr;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.x >= ((long) this.A)) {
            this.x = currentTimeMillis;
            long j2 = 0;
            long j3 = (long) (camera.getParameters().getPreviewSize().width * camera.getParameters().getPreviewSize().height);
            if (Math.abs(((float) bArr.length) - (((float) j3) * 1.5f)) < 1.0E-5f) {
                for (int i2 = 0; ((long) i2) < j3; i2 += 10) {
                    j2 += ((long) bArr[i2]) & 255;
                }
                long j4 = j2 / (j3 / ((long) 10));
                long[] jArr = this.z;
                int length = jArr.length;
                int i3 = this.y % length;
                this.y = i3;
                jArr[i3] = j4;
                boolean z2 = true;
                this.y = i3 + 1;
                for (int i4 = 0; i4 < length; i4++) {
                    if (this.z[i4] > ((long) this.B)) {
                        z2 = false;
                    }
                }
                if (isFinishing()) {
                    return;
                }
                if (z2) {
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 2001) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            i();
            return;
        }
        this.s = true;
        c();
    }

    public void onResume() {
        super.onResume();
        if (this.s) {
            FrameLayout frameLayout = this.c;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            c();
        }
    }

    public void setCameraDisplayOrientation(int i2, Camera camera) {
        int i3;
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        int i4 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i4 = 90;
            } else if (rotation == 2) {
                i4 = 180;
            } else if (rotation == 3) {
                i4 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        if (cameraInfo.facing == 1) {
            i3 = (360 - ((cameraInfo.orientation + i4) % RotateProgress.FULL_DEGREE)) % RotateProgress.FULL_DEGREE;
        } else {
            i3 = ((cameraInfo.orientation - i4) + RotateProgress.FULL_DEGREE) % RotateProgress.FULL_DEGREE;
        }
        camera.setDisplayOrientation(i3);
    }

    public class CameraSize {
        public int a;
        public int b;

        public CameraSize(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CameraSize.class != obj.getClass()) {
                return false;
            }
            CameraSize cameraSize = (CameraSize) obj;
            if (this.a == cameraSize.a && this.b == cameraSize.b) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "CameraSize{width=" + this.a + ", height=" + this.b + ExtendedMessageFormat.END_FE;
        }

        public CameraSize(Camera.Size size) {
            this.a = size.width;
            this.b = size.height;
        }
    }

    private void a() {
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.n = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        this.m = height;
        this.p = this.n;
        this.q = height - dp2px(120.0f);
        this.C = getIntent().getStringExtra(PARAM_KEY_ID_CARD_TYPE);
        Log.e("ocr-test", "屏幕宽度 = " + this.n);
        Log.e("ocr-test", "屏幕高度 = " + this.m);
        Log.e("ocr-test", "预览区域最小高度 = " + this.q);
    }

    private Bitmap a(Bitmap bitmap) {
        try {
            int[] iArr = new int[2];
            int identifier = getApplicationContext().getResources().getIdentifier("status_bar_height", ResUtils.f719i, SapiDeviceInfo.OS_TYPE);
            int dimensionPixelSize = identifier > 0 ? getApplicationContext().getResources().getDimensionPixelSize(identifier) : 0;
            this.c.getLocationInWindow(iArr);
            int i2 = (int) (((float) (iArr[1] - dimensionPixelSize)) * this.t);
            int i3 = (int) (((float) iArr[0]) * this.t);
            int i4 = (int) (((float) this.l) * this.t);
            int i5 = (int) (((float) this.k) * this.t);
            Log.e("ocr-test", "计算点坐标：x = " + i2 + ", y = " + i3);
            Log.e("ocr-test", "计算点坐标：borderWidth = " + i4 + ", borderHeight = " + i5);
            return Bitmap.createBitmap(bitmap, i2, i3, i4, i5);
        } catch (Exception unused) {
            Toast.makeText(this, "取图失败，请使用系统相机，并从相册选取", 1).show();
            a(false, IdCardOcrResult.CODE_CAMERA_ERROR, IdCardOcrResult.MESSAGE_CAMERA_ERROR, this.C, "");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, int i2, String str, String str2, String str3) {
        IdCardOcrResult idCardOcrResult = new IdCardOcrResult();
        idCardOcrResult.setResultCode(i2);
        idCardOcrResult.setResultMsg(str);
        idCardOcrResult.image = str3;
        idCardOcrResult.type = str2;
        if (z2) {
            this.v.onSuccess(idCardOcrResult);
        } else {
            this.v.onFailure(idCardOcrResult);
        }
        finish();
        this.w = true;
    }
}
