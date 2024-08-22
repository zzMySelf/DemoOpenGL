package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.aiscan.R;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.IdCardOcrCallback;
import com.baidu.sapi2.callback.IdcardOcrImageCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.NFCReadCardCallback;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.IdCardOcrDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.provider.FileProvider;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.IdCardOcrResult;
import com.baidu.sapi2.result.IdcardOcrImageRusult;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.listener.IScreenShotListener;
import com.baidu.sapi2.shell.manager.ScreenShotManager;
import com.baidu.sapi2.social.DingDingInvokeCallback;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.social.WXInvokeCallback;
import com.baidu.sapi2.touchid.FingerprintCallback;
import com.baidu.sapi2.touchid.FingerprintHelper;
import com.baidu.sapi2.utils.AccessibleUtils;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.Security;
import com.baidu.sapi2.utils.VibrateUtils;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.utils.c;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.FingerprintDialog;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import fe.fe.ppp.de.ad;
import fe.fe.ppp.de.de;
import fe.fe.ppp.de.qw;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseActivity extends TitleActivity {
    public static final String EXTRA_PARAM_BUSINESS_FROM = "extra_params_business_from";
    public static final int EXTRA_PARAM_FROM_ACCOUNT_CENTER = 2003;
    public static final int EXTRA_PARAM_FROM_ACCOUNT_THIRD_VERIFICATION = 2006;
    public static final int EXTRA_PARAM_FROM_CHOICE_SHARE = 2004;
    public static final int EXTRA_PARAM_FROM_GRANT_WAP = 2005;
    public static final int EXTRA_PARAM_FROM_LOGIN = 2001;
    public static final int EXTRA_PARAM_FROM_PASS_SDK_ENTER = 2002;
    public static final String EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN = "accessToken";
    public static final String EXTRA_PARAM_THIRD_VERIFY_APP_ID = "appId";
    public static final String EXTRA_PARAM_THIRD_VERIFY_AUTHORIZATION_CODE = "authorizationCode";
    public static final String EXTRA_PARAM_THIRD_VERIFY_OPEN_ID = "openId";
    public static final String EXTRA_PARAM_THIRD_VERIFY_TPL = "tpl";
    public static final String EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE = "typeCode";
    public static final String EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME = "typeName";
    public static final String EXTRA_PARAM_THIRD_VERIFY_UNION_ID = "unionId";
    public static final String EXTRA_PARAM_THIRD_VERIFY_USER_ID = "userId";
    public static final int REQUEST_CODE_FILECHOOSER = 1010;
    public static final int REQUEST_CODE_FILECHOOSER_FOR_ANDROID_5 = 1011;
    public static final int REQUEST_CODE_LOGIN = 1004;
    public static final int RESULT_CODE_THIRD_PARTY_VERIFY = 4001;
    public static final String n = BaseActivity.class.getSimpleName();

    /* renamed from: o  reason: collision with root package name */
    public static final String f948o = "javascript:(function(){if(window.Pass && window.Pass.client && window.Pass.client.screenShot){Pass.client.screenShot()}}())";
    public static final String p = "camera_temp_image.jpg";
    public static final int q = 1001;
    public static final int r = 1002;
    public static final int s = 1003;
    public static final int t = 1005;
    public static final int u = 1006;
    public static final int v = 2001;
    public ValueCallback<Uri> a;
    public ValueCallback<Uri[]> b;
    public SapiWebView.PickPhotoResult c;
    public SapiWebView.BiometricsIdentifyResult d;
    public SapiScheme e;
    public int f;
    public int g;
    public ImageCropCallback.ImageCropResult h;

    /* renamed from: i  reason: collision with root package name */
    public ScreenShotManager f949i;
    public IdcardOcrImageCallback j;
    public boolean k;
    public boolean l;
    public boolean loginStatusChange;
    public Handler m = new NFCHandle(this);
    public boolean mCanChangeUiMode = true;
    public boolean mDarkMode;
    public SapiWebView sapiWebView;

    public static class NFCHandle extends Handler {
        public WeakReference<BaseActivity> a;

        public NFCHandle(BaseActivity baseActivity) {
            this.a = new WeakReference<>(baseActivity);
        }

        public void handleMessage(@NonNull Message message) {
        }
    }

    public void initScreenShotManager() {
        ScreenShotManager screenShotManager = new ScreenShotManager();
        this.f949i = screenShotManager;
        screenShotManager.init(getContentResolver(), new IScreenShotListener() {
            public void onScreenShot() {
                BaseActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        SapiWebView sapiWebView = BaseActivity.this.sapiWebView;
                        if (sapiWebView != null) {
                            sapiWebView.loadUrl(BaseActivity.f948o);
                        }
                    }
                });
            }
        });
        this.f949i.register();
    }

    public void livenessRecognize(String str, SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
        String str2;
        PassFaceRecogType passFaceRecogType;
        String str3;
        SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult2 = biometricsIdentifyResult;
        BiometricsManager instance = BiometricsManager.getInstance();
        PassFaceRecogType passFaceRecogType2 = PassFaceRecogType.RECOG_TYPE_BDUSS;
        if ("bduss".equals(biometricsIdentifyResult2.livenessRecogType)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null) {
                str3 = "";
            } else {
                str3 = currentAccount.bduss;
            }
            str2 = str3;
            passFaceRecogType = passFaceRecogType2;
        } else {
            if ("authtoken".equals(biometricsIdentifyResult2.livenessRecogType)) {
                passFaceRecogType2 = PassFaceRecogType.RECOG_TYPE_AUTHTOKEN;
            } else if ("certinfo".equals(biometricsIdentifyResult2.livenessRecogType)) {
                passFaceRecogType2 = PassFaceRecogType.RECOG_TYPE_CERTINFO;
            }
            passFaceRecogType = passFaceRecogType2;
            str2 = null;
        }
        String str4 = biometricsIdentifyResult2.subPro;
        String str5 = biometricsIdentifyResult2.authToken;
        String str6 = biometricsIdentifyResult2.realName;
        String str7 = biometricsIdentifyResult2.idCardNum;
        String str8 = biometricsIdentifyResult2.verifyType;
        String str9 = biometricsIdentifyResult2.nation;
        String str10 = biometricsIdentifyResult2.phoneNum;
        Bundle bundle = biometricsIdentifyResult2.extraParams;
        AnonymousClass21 r19 = r0;
        AnonymousClass21 r0 = new PassFaceRecogCallback() {
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a2 = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), (String) null, (String) null);
                if (BaseActivity.this.d != null) {
                    BaseActivity.this.d.setIdentifyToken(a2.toString());
                }
            }

            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a2 = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid);
                if (BaseActivity.this.d != null) {
                    BaseActivity.this.d.setIdentifyToken(a2.toString());
                }
            }
        };
        instance.livenessRecognize(this, passFaceRecogType, str4, (Map<String, String>) null, "0", str2, str, str5, "", str6, str7, str8, str9, str10, false, false, bundle, r19);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        ImageCropCallback imageCropCallback = CoreViewRouter.getInstance().getImageCropCallback();
        ActivityResultCallback activityResultCallback = CoreViewRouter.getInstance().getActivityResultCallback();
        if (imageCropCallback == null || activityResultCallback == null) {
            imageCropCallback = d();
            activityResultCallback = c();
        }
        ImageCropCallback imageCropCallback2 = imageCropCallback;
        if (activityResultCallback != null) {
            activityResultCallback.onActivityResult(i2, i3, intent);
        }
        if (i2 == 1001) {
            if (this.c != null) {
                if (i3 != -1 || imageCropCallback2 == null) {
                    this.c.setImageData("");
                } else {
                    imageCropCallback2.onImageCrop(this, Uri.fromFile(new File(getExternalCacheDir(), "camera_temp_image.jpg")), this.f, this.g, new ImageCropCallback.ImageCropResult() {
                        public void onImageResult(String str) {
                            if (str != null) {
                                BaseActivity.this.c.setImageData(str);
                            } else {
                                BaseActivity.this.c.setImageData("");
                            }
                        }
                    });
                }
            }
        } else if (i2 == 1002) {
            if (this.c != null) {
                if (i3 != -1 || intent.getData() == null || imageCropCallback2 == null) {
                    this.c.setImageData("");
                } else {
                    imageCropCallback2.onImageCrop(this, intent.getData(), this.f, this.g, new ImageCropCallback.ImageCropResult() {
                        public void onImageResult(String str) {
                            if (str != null) {
                                BaseActivity.this.c.setImageData(str);
                            } else {
                                BaseActivity.this.c.setImageData("");
                            }
                        }
                    });
                }
            }
        } else if (i2 == 2001 && i3 == 4001) {
            a(intent);
        } else if (i2 == 1005) {
            if (intent != null) {
                a(intent.getData());
            } else if (this.j != null) {
                IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                idcardOcrImageRusult.setResultCode(-404);
                idcardOcrImageRusult.setResultMsg(IdCardOcrResult.MESSAGE_ALBUM_ERROR);
                this.j.onFailure(idcardOcrImageRusult);
            }
        } else if (i2 == 1006) {
            if (this.j != null) {
                if (intent == null || intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE) == null) {
                    IdcardOcrImageRusult idcardOcrImageRusult2 = new IdcardOcrImageRusult();
                    idcardOcrImageRusult2.setResultCode(-404);
                    idcardOcrImageRusult2.setResultMsg(IdCardOcrResult.MESSAGE_ALBUM_ERROR);
                    this.j.onFailure(idcardOcrImageRusult2);
                    return;
                }
                byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
                if (decodeByteArray.getHeight() > decodeByteArray.getWidth()) {
                    decodeByteArray = b.b(decodeByteArray, -90);
                }
                byte[] a2 = b.a(decodeByteArray, 100);
                IdcardOcrImageRusult idcardOcrImageRusult3 = new IdcardOcrImageRusult();
                idcardOcrImageRusult3.setResultCode(0);
                idcardOcrImageRusult3.image = Base64Utils.encodeToString(a2);
                this.j.onSuccess(idcardOcrImageRusult3);
            }
        } else if (i2 == 1010) {
            if (this.a != null) {
                this.a.onReceiveValue((intent == null || i3 != -1) ? null : intent.getData());
                this.a = null;
            }
        } else if (i2 == 1011 && this.b != null) {
            Uri data = (intent == null || i3 != -1) ? null : intent.getData();
            if (data != null) {
                this.b.onReceiveValue(new Uri[]{data});
            } else {
                this.b.onReceiveValue(new Uri[0]);
            }
            this.b = null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = n;
        Log.d(str, getClass().getSimpleName() + " base_onCreate");
        if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this)) {
            initScreenShotManager();
        }
    }

    public void onDestroy() {
        JsPromptResult jsPromptResult;
        super.onDestroy();
        releaseScreenShotManager();
        if (this.loginStatusChange) {
            SapiAccountManager.getGlobalCallback().onLoginStatusChange();
        }
        try {
            ((RelativeLayout) findViewById(R.id.root_view)).removeView(this.sapiWebView);
        } catch (Exception e2) {
            Log.e(e2);
        }
        try {
            if (this.sapiWebView != null) {
                SapiJsCallBacks.CallBacks jsCallBacks = this.sapiWebView.getJsCallBacks();
                if (!(jsCallBacks == null || (jsPromptResult = jsCallBacks.getJsPromptResult()) == null)) {
                    jsPromptResult.cancel();
                }
                this.sapiWebView.removeAllViews();
                this.sapiWebView.destroy();
                this.sapiWebView = null;
            }
        } catch (Exception e3) {
            Log.e(e3);
        }
        if (this.l) {
            CoreViewRouter.getInstance().stopNFCReadCard(this);
        }
        this.m.removeCallbacksAndMessages((Object) null);
        this.m = null;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        SapiWebView sapiWebView2 = this.sapiWebView;
        if (sapiWebView2 == null || !sapiWebView2.onKeyUp(i2)) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        SapiUtils.hideSoftInput(this);
        this.executeSubClassMethod = true;
        TitleBtnCallback titleBtnCallback = this.titleBtnCallback;
        if (titleBtnCallback != null) {
            this.executeSubClassMethod = true ^ titleBtnCallback.onLeftBtnClick();
        }
    }

    public void onPause() {
        super.onPause();
        try {
            if (this.sapiWebView != null) {
                this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_PAUSE);
                this.sapiWebView.onPause();
            }
        } catch (Exception unused) {
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 2001) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            g();
        } else {
            e();
        }
    }

    public void onResume() {
        super.onResume();
        String str = n;
        Log.d(str, getClass().getSimpleName() + " base_onResume");
        try {
            if (this.sapiWebView != null) {
                this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_RESUME);
                this.sapiWebView.onResume();
            }
            if (this.mCanChangeUiMode) {
                a();
            }
        } catch (Exception unused) {
        }
    }

    public void pickPhoto() {
        de deVar = new de();
        deVar.f2992ad = this.configuration.context;
        if (Build.VERSION.SDK_INT >= 33) {
            deVar.f2996th = new String[]{"android.permission.READ_MEDIA_IMAGES"};
        } else {
            deVar.f2996th = new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION};
        }
        deVar.f2998yj = "存储权限";
        deVar.f2997uk = "为了正常使用图片上传、图片识别服务，请允许使用存储权限。你可以通过系统\"设置\"进行权限的管理";
        qw.rg().uk(deVar, new ad() {
            public void onFailure(int i2) {
                Toast.makeText(BaseActivity.this, BaseOptionActivity.NO_STORAGE_PERM_MSG, 1).show();
                if (BaseActivity.this.c != null) {
                    BaseActivity.this.c.setImageData("");
                }
            }

            public void onSuccess() {
                try {
                    if (Build.VERSION.SDK_INT >= 33) {
                        Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                        intent.setType("image/*");
                        BaseActivity.this.startActivityForResult(intent, 1002);
                    } else if (Build.VERSION.SDK_INT == 19) {
                        Intent intent2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent2.setType("image/*");
                        BaseActivity.this.startActivityForResult(intent2, 1002);
                    } else {
                        Intent intent3 = new Intent();
                        intent3.setType("image/*");
                        intent3.setAction("android.intent.action.PICK");
                        BaseActivity.this.startActivityForResult(intent3, 1002);
                    }
                } catch (Throwable th2) {
                    Log.e(th2);
                }
            }
        });
    }

    public void releaseScreenShotManager() {
        ScreenShotManager screenShotManager = this.f949i;
        if (screenShotManager != null) {
            screenShotManager.unRegister();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.widget.ImageView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setNewLoginTitleAndSetStyleChangeCallBack() {
        /*
            r8 = this;
            com.baidu.sapi2.SapiConfiguration r0 = r8.configuration
            if (r0 == 0) goto L_0x00b6
            boolean r0 = r0.isNewLogin
            if (r0 != 0) goto L_0x000a
            goto L_0x00b6
        L_0x000a:
            r0 = 1
            r8.k = r0
            com.baidu.sapi2.views.ViewUtility.newLoginStatusBarTint(r8)
            r1 = 2131363304(0x7f0a05e8, float:1.8346413E38)
            r2 = 0
            android.view.View r1 = r8.findViewById(r1)     // Catch:{ Exception -> 0x0023 }
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()     // Catch:{ Exception -> 0x0023 }
            android.widget.RelativeLayout$LayoutParams r1 = (android.widget.RelativeLayout.LayoutParams) r1     // Catch:{ Exception -> 0x0023 }
            r3 = 3
            r1.addRule(r3, r2)     // Catch:{ Exception -> 0x0023 }
            goto L_0x002e
        L_0x0023:
            java.lang.String r1 = n
            java.lang.Object[] r3 = new java.lang.Object[r0]
            java.lang.String r4 = "子activity重写了webview布局"
            r3[r2] = r4
            com.baidu.sapi2.utils.Log.e((java.lang.String) r1, (java.lang.Object[]) r3)
        L_0x002e:
            com.baidu.sapi2.SapiWebView r1 = r8.sapiWebView
            r1.setHadMakeBarHide(r0)
            r1 = 2131363207(0x7f0a0587, float:1.8346216E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            android.widget.RelativeLayout r3 = r8.mTitleLayout
            if (r3 != 0) goto L_0x004b
            r3 = 2131363302(0x7f0a05e6, float:1.8346409E38)
            android.view.View r3 = r8.findViewById(r3)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r8.mTitleLayout = r3
        L_0x004b:
            r3 = 0
            android.widget.RelativeLayout r4 = r8.mTitleLayout
            if (r4 == 0) goto L_0x00ac
            int r4 = r4.getChildCount()
            if (r4 == 0) goto L_0x00ac
            android.widget.RelativeLayout r4 = r8.mTitleLayout
            r1.removeView(r4)
            android.widget.RelativeLayout r4 = r8.mTitleLayout
            r4.setBackgroundColor(r2)
            r4 = 0
        L_0x0061:
            android.widget.RelativeLayout r5 = r8.mTitleLayout
            int r5 = r5.getChildCount()
            if (r4 >= r5) goto L_0x008d
            android.widget.RelativeLayout r5 = r8.mTitleLayout
            android.view.View r5 = r5.getChildAt(r4)
            int r6 = r5.getId()
            r7 = 2131363531(0x7f0a06cb, float:1.8346873E38)
            if (r6 != r7) goto L_0x0085
            com.baidu.sapi2.SapiConfiguration r6 = r8.configuration
            boolean r6 = r6.showBottomBack
            if (r6 == 0) goto L_0x0085
            r5.setVisibility(r2)
            r3 = r5
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            goto L_0x008a
        L_0x0085:
            r6 = 8
            r5.setVisibility(r6)
        L_0x008a:
            int r4 = r4 + 1
            goto L_0x0061
        L_0x008d:
            android.widget.RelativeLayout r4 = r8.mTitleLayout     // Catch:{ Exception -> 0x009c }
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()     // Catch:{ Exception -> 0x009c }
            android.widget.RelativeLayout$LayoutParams r4 = (android.widget.RelativeLayout.LayoutParams) r4     // Catch:{ Exception -> 0x009c }
            int r5 = com.baidu.sapi2.views.ViewUtility.getStatusBarHeight(r8)     // Catch:{ Exception -> 0x009c }
            r4.topMargin = r5     // Catch:{ Exception -> 0x009c }
            goto L_0x00a7
        L_0x009c:
            java.lang.String r4 = n
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r5 = "子activity重写了title布局"
            r0[r2] = r5
            com.baidu.sapi2.utils.Log.e((java.lang.String) r4, (java.lang.Object[]) r0)
        L_0x00a7:
            android.widget.RelativeLayout r0 = r8.mTitleLayout
            r1.addView(r0)
        L_0x00ac:
            com.baidu.sapi2.SapiWebView r0 = r8.sapiWebView
            com.baidu.sapi2.activity.BaseActivity$28 r1 = new com.baidu.sapi2.activity.BaseActivity$28
            r1.<init>(r3)
            r0.setSwitchStyleForCloseBtnAndStatusBarCallBack(r1)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.activity.BaseActivity.setNewLoginTitleAndSetStyleChangeCallBack():void");
    }

    public void setupViews() {
        super.setupViews();
        SapiWebView sapiWebView2 = (SapiWebView) findViewById(R.id.sapi_webview);
        this.sapiWebView = sapiWebView2;
        if (sapiWebView2 != null) {
            if (DarkModeUtil.isDarkMode(this)) {
                this.sapiWebView.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_color));
            }
            if (getWebDTO() == null || getWebDTO().loadingView == null) {
                c.a((Context) this, this.sapiWebView, getWebDTO() != null ? getWebDTO().sweepLightLoading : true);
            } else {
                c.a((Context) this, this.sapiWebView, getWebDTO().loadingView);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            this.sapiWebView.setWebViewTitleCallback(new SapiWebView.WebViewTitleCallback() {
                public void onTitleChange(String str) {
                    String string = BaseActivity.this.getString(R.string.sapi_sdk_account_center_webview_title_online_service);
                    String string2 = BaseActivity.this.getString(R.string.sapi_sdk_account_center_webview_title_common_problem);
                    if (string.equals(str)) {
                        str = string2;
                    }
                    BaseActivity.this.setTitleText(str);
                }
            });
            this.sapiWebView.setLocalConfigCallback(new SapiWebView.LocalConfigCallback() {
                public List<FastLoginFeature> getFastLoginFeatureList() {
                    WebLoginDTO.Config config;
                    WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
                    if (webLoginDTO == null || (config = webLoginDTO.config) == null) {
                        return null;
                    }
                    return config.fastLoginFeatureList;
                }
            });
            this.sapiWebView.setFileChooserCallback(new SapiWebView.FileChooserCallback() {
                public void onFileChooser(ValueCallback<Uri> valueCallback) {
                    BaseActivity.this.a(valueCallback);
                }

                public void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback) {
                    BaseActivity.this.b(valueCallback);
                }
            });
            this.sapiWebView.setPickPhotoCallback(new SapiWebView.PickPhotoCallback() {
                public void onPickImage(int i2, int i3, int i4, SapiWebView.PickPhotoResult pickPhotoResult) {
                    SapiWebView.PickPhotoResult unused = BaseActivity.this.c = pickPhotoResult;
                    int unused2 = BaseActivity.this.f = i3;
                    int unused3 = BaseActivity.this.g = i4;
                    if (1 == i2) {
                        BaseActivity.this.takePhoto();
                    } else {
                        BaseActivity.this.pickPhoto();
                    }
                }
            });
            this.sapiWebView.setBiometricsIdentifyCallback(new SapiWebView.BiometricsIdentifyCallback() {
                public void onBiometricsIdentify(SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
                    SapiWebView.BiometricsIdentifyResult unused = BaseActivity.this.d = biometricsIdentifyResult;
                    if ("bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
                        BaseActivity.this.a(biometricsIdentifyResult);
                    } else if ("certinfo".equals(biometricsIdentifyResult.livenessRecogType) || "authtoken".equals(biometricsIdentifyResult.livenessRecogType)) {
                        BaseActivity.this.livenessRecognize((String) null, biometricsIdentifyResult);
                    }
                }
            });
            this.sapiWebView.setPageStateCallback(new SapiJsCallBacks.PageStateCallback() {
                public void pageState(int i2) {
                    BaseActivity.this.updateBottomBack(i2);
                }
            });
            this.sapiWebView.setBioScanFaceCallback(new SapiWebView.BioScanFaceCallback() {
                public void onBioScanFace(SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
                    BaseActivity baseActivity = BaseActivity.this;
                    baseActivity.a((Activity) baseActivity, bioScanFaceResult);
                }
            });
            this.sapiWebView.setInvokeScAppCallback(new SapiWebView.InvokeScAppCallback() {
                public void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult) {
                    SapiScheme unused = BaseActivity.this.e = new SapiScheme();
                    BaseActivity.this.e.invokeScApp(BaseActivity.this, str, str2, list, invokeScAppResult);
                }
            });
            this.sapiWebView.setLoginStatusChangeCallback(new SapiJsCallBacks.LoginStatusChangeCallback() {
                public void onChange() {
                    BaseActivity.this.loginStatusChange = true;
                }
            });
            this.sapiWebView.setFingerprintCallback(new SapiJsCallBacks.FingerprintCallback() {
                public void onCallback(final SapiJsCallBacks.FingerprintResult fingerprintResult) {
                    BaseActivity baseActivity = BaseActivity.this;
                    new FingerprintHelper(baseActivity, new FingerprintDialog(baseActivity)).startAuthenticate(fingerprintResult.authType, new FingerprintCallback() {
                        public void onCall(int i2) {
                            fingerprintResult.setResult(i2);
                        }
                    });
                }
            });
            this.sapiWebView.setSocialVerificationHandler(new Handler() {
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    AbstractThirdPartyService thirdPartyService = CoreViewRouter.getInstance().getThirdPartyService();
                    if (thirdPartyService != null) {
                        thirdPartyService.loadThirdPartyLogin(BaseActivity.this, (SocialType) message.obj, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_THIRD_VERIFICATION, (String) null, true);
                        SocialLoginBase.setWXLoginCallback(new WXInvokeCallback() {
                            public void onResult(int i2, Intent intent) {
                                String b = BaseActivity.n;
                                Log.d(b, "base activity onResult: " + i2);
                                if (i2 == 4001) {
                                    BaseActivity.this.a(intent);
                                }
                            }
                        });
                        SocialLoginBase.setDingDingInvokeCallback(new DingDingInvokeCallback() {
                            public void onResult(int i2, Intent intent) {
                                if (i2 == 4001) {
                                    BaseActivity.this.a(intent);
                                }
                            }
                        });
                    }
                }
            });
            this.sapiWebView.setBiometricsIdentificationLiveCallBack(new SapiJsCallBacks.BiometricsIdentificationLiveCallBack() {
                public void getLiveImage(int i2, PassFaceRecogCallback passFaceRecogCallback) {
                    BiometricsManager.getInstance().recogWithFaceLive(BaseActivity.this, i2, passFaceRecogCallback);
                }
            });
            this.sapiWebView.setIdcardOcrImageCallBack(new SapiJsCallBacks.IdcardOcrImageCallBack() {
                public void getIdcardImage(String str, String str2, IdcardOcrImageCallback idcardOcrImageCallback) {
                    IdcardOcrImageCallback unused = BaseActivity.this.j = idcardOcrImageCallback;
                    if ("album".equals(str)) {
                        BaseActivity.this.f();
                    } else if ("camera".equals(str)) {
                        BaseActivity.this.a(str2);
                    }
                }
            });
            this.sapiWebView.setMakeVibrateCallBack(new SapiJsCallBacks.MakeVibrateCallBack() {
                public void presetVibrate(String str) {
                    VibrateUtils.presetVibrate(BaseActivity.this);
                    AccessibleUtils.accessible(BaseActivity.this, str);
                }

                public void vibrate(long[] jArr, int i2, String str) {
                    VibrateUtils.vibrate(BaseActivity.this, jArr, i2);
                    AccessibleUtils.accessible(BaseActivity.this, str);
                }
            });
            this.sapiWebView.setIsForbidRecord(new SapiJsCallBacks.IsForbidRecordCallBack() {
                public void onForbidRecord(Boolean bool) {
                    if (bool.booleanValue()) {
                        BaseActivity.this.getWindow().addFlags(8192);
                    } else {
                        BaseActivity.this.getWindow().clearFlags(8192);
                    }
                }
            });
            this.sapiWebView.setIdCardNfcCallback(new SapiJsCallBacks.IdCardNfcCallback() {
                public String checkAvailable() {
                    if (!CoreViewRouter.getInstance().isDeviceSupportNFC(BaseActivity.this)) {
                        return "";
                    }
                    return Security.getZid(BaseActivity.this, 127);
                }

                public boolean checkOpenNFC() {
                    return CoreViewRouter.getInstance().isDeviceOpenNFC(BaseActivity.this);
                }

                public void gotoOpenNFC() {
                    BaseActivity.this.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                }

                public void startIdCardRead(final int i2, int i3, final NFCReadCardCallback nFCReadCardCallback) {
                    if (!BaseActivity.this.l) {
                        boolean unused = BaseActivity.this.l = true;
                        BaseActivity.this.m.postDelayed(new Runnable() {
                            public void run() {
                                NFCReadCardCallback nFCReadCardCallback;
                                if (!BaseActivity.this.isFinishing() && BaseActivity.this.l && (nFCReadCardCallback = nFCReadCardCallback) != null) {
                                    nFCReadCardCallback.onFailure(-201, "读卡超时", "");
                                    CoreViewRouter.getInstance().stopNFCReadCard(BaseActivity.this);
                                    boolean unused = BaseActivity.this.l = false;
                                }
                            }
                        }, (long) i3);
                        final int[] iArr = {0};
                        CoreViewRouter.getInstance().startNFCReadCard(BaseActivity.this, new NFCReadCardCallback() {
                            public void onBegin() {
                            }

                            public void onFailure(int i2, String str, String str2) {
                                int[] iArr = iArr;
                                iArr[0] = iArr[0] + 1;
                                if (iArr[0] >= i2) {
                                    boolean unused = BaseActivity.this.l = false;
                                    NFCReadCardCallback nFCReadCardCallback = nFCReadCardCallback;
                                    if (nFCReadCardCallback != null) {
                                        nFCReadCardCallback.onFailure(i2, str, str2);
                                        CoreViewRouter.getInstance().stopNFCReadCard(BaseActivity.this);
                                    }
                                }
                            }

                            public void onSuccess(String str) {
                                NFCReadCardCallback nFCReadCardCallback = nFCReadCardCallback;
                                if (nFCReadCardCallback != null) {
                                    nFCReadCardCallback.onSuccess(str);
                                    CoreViewRouter.getInstance().stopNFCReadCard(BaseActivity.this);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void takePhoto() {
        de deVar = new de();
        deVar.f2992ad = this.configuration.context;
        deVar.f2996th = new String[]{"android.permission.CAMERA"};
        deVar.f2998yj = "权限申请";
        deVar.f2997uk = "为了正常使用拍照服务、图片上传、图片识别服务，请允许使用摄像头权限。你可以通过系统\"设置\"进行权限的管理";
        qw.rg().uk(deVar, new ad() {
            public void onFailure(int i2) {
                Toast.makeText(BaseActivity.this, BaseOptionActivity.NO_CAMERA_PERM_MSG, 1).show();
                if (BaseActivity.this.c != null) {
                    BaseActivity.this.c.setImageData("");
                }
            }

            public void onSuccess() {
                try {
                    if (!"mounted".equals(Environment.getExternalStorageState())) {
                        Toast.makeText(BaseActivity.this, R.string.sapi_sdk_user_profile_sdcard_unavailable, 0).show();
                        return;
                    }
                    File file = new File(BaseActivity.this.getExternalCacheDir(), "camera_temp_image.jpg");
                    if (file.exists()) {
                        file.delete();
                    }
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.setAction("android.media.action.IMAGE_CAPTURE");
                    File file2 = new File(BaseActivity.this.getExternalCacheDir(), "camera_temp_image.jpg");
                    if (Build.VERSION.SDK_INT >= 24) {
                        if (BaseActivity.this.getApplicationInfo().targetSdkVersion >= 24) {
                            BaseActivity baseActivity = BaseActivity.this;
                            intent.putExtra("output", FileProvider.getUriForFile(baseActivity, BaseActivity.this.getPackageName() + ".passfileprovider", file2));
                            intent.putExtra("orientation", 0);
                            BaseActivity.this.startActivityForResult(intent, 1001);
                        }
                    }
                    intent.putExtra("output", Uri.fromFile(file2));
                    intent.putExtra("orientation", 0);
                    BaseActivity.this.startActivityForResult(intent, 1001);
                } catch (Throwable th2) {
                    Log.e(th2);
                }
            }
        });
    }

    private ImageCropCallback d() {
        return new ImageCropCallback() {
            public void onImageCrop(Context context, Uri uri, int i2, int i3, ImageCropCallback.ImageCropResult imageCropResult) {
                ImageCropCallback.ImageCropResult unused = BaseActivity.this.h = imageCropResult;
                Intent intent = new Intent(context, ImageClipActivity.class);
                if (i2 == ClipBoxView.I) {
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 0);
                } else {
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 1);
                }
                intent.putExtra(ImageClipActivity.EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, i3);
                intent.setData(uri);
                BaseActivity.this.startActivityForResult(intent, 1003);
            }
        };
    }

    private void e() {
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                startActivityForResult(new Intent("android.provider.action.PICK_IMAGES"), 1005);
            } else if (Build.VERSION.SDK_INT == 19) {
                Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent, 1005);
            } else {
                Intent intent2 = new Intent();
                intent2.setType("image/*");
                intent2.setAction("android.intent.action.GET_CONTENT");
                startActivityForResult(intent2, 1005);
            }
        } catch (Throwable th2) {
            Log.e(th2);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            if (checkSelfPermission("android.permission.READ_MEDIA_IMAGES") != 0) {
                requestPermissions(new String[]{"android.permission.READ_MEDIA_IMAGES"}, 2001);
            } else {
                e();
            }
        } else if (i2 < 23) {
            e();
        } else if (checkSelfPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION) == 0) {
            e();
        } else if (shouldShowRequestPermissionRationale(StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            CommonDialog.qw qwVar = new CommonDialog.qw(this);
            qwVar.uk(String.format("%1$sApp将打开“%2$s", new Object[]{PassBiometricUtil.getAppName(this), "相册"}));
            qwVar.rg(String.format("为了您使用识别功能，请允许%1$sApp打开%2$s。您可以通过系统“设置”进行权限的管理", new Object[]{PassBiometricUtil.getAppName(this), "相册"}));
            qwVar.yj("继续", new View.OnClickListener() {
                public void onClick(View view) {
                    BaseActivity.this.requestPermissions(new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 2001);
                }
            });
            qwVar.th("关闭", new View.OnClickListener() {
                public void onClick(View view) {
                    if (BaseActivity.this.j != null) {
                        IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                        idcardOcrImageRusult.setResultCode(-402);
                        idcardOcrImageRusult.setResultMsg(IdCardOcrResult.MESSAGE_NO_ALBUM_PERMISSION);
                        BaseActivity.this.j.onFailure(idcardOcrImageRusult);
                    }
                }
            });
            qwVar.de().show();
        } else {
            requestPermissions(new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 2001);
        }
    }

    private void g() {
        CommonDialog.qw qwVar = new CommonDialog.qw(this);
        qwVar.uk("开启文件权限");
        qwVar.rg("为了使用相册服务\n请开启文件权限");
        qwVar.yj("去设置", new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addFlags(268435456);
                intent.setData(Uri.fromParts("package", BaseActivity.this.getPackageName(), (String) null));
                if (intent.resolveActivity(BaseActivity.this.getPackageManager()) != null) {
                    BaseActivity.this.startActivity(intent);
                }
                if (BaseActivity.this.j != null) {
                    IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                    idcardOcrImageRusult.setResultCode(-402);
                    idcardOcrImageRusult.setResultMsg(IdCardOcrResult.MESSAGE_NO_ALBUM_PERMISSION);
                    BaseActivity.this.j.onFailure(idcardOcrImageRusult);
                }
            }
        });
        qwVar.th("取消", new View.OnClickListener() {
            public void onClick(View view) {
                if (BaseActivity.this.j != null) {
                    IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                    idcardOcrImageRusult.setResultCode(-402);
                    idcardOcrImageRusult.setResultMsg(IdCardOcrResult.MESSAGE_NO_ALBUM_PERMISSION);
                    BaseActivity.this.j.onFailure(idcardOcrImageRusult);
                }
            }
        });
        CommonDialog de2 = qwVar.de();
        de2.setCancelable(false);
        if (!isFinishing() && !de2.isShowing()) {
            de2.show();
        }
    }

    private ActivityResultCallback c() {
        return new ActivityResultCallback() {
            public void onActivityResult(int i2, int i3, Intent intent) {
                if (i2 != 1003) {
                    return;
                }
                if (i3 == -1) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                    if (byteArrayExtra != null && BaseActivity.this.h != null) {
                        BaseActivity.this.h.onImageResult(fe.fe.ppp.ad.ad.fe(byteArrayExtra));
                    }
                } else if (BaseActivity.this.h != null) {
                    BaseActivity.this.h.onImageResult((String) null);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void b(ValueCallback<Uri[]> valueCallback) {
        this.b = valueCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            startActivityForResult(new Intent("android.provider.action.PICK_IMAGES"), 1011);
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent);
        intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
        startActivityForResult(intent2, 1011);
    }

    public void a() {
        boolean isDarkMode = DarkModeUtil.isDarkMode(this);
        if (this.mDarkMode != isDarkMode) {
            this.mDarkMode = isDarkMode;
            a(isDarkMode);
            if (this.k) {
                setNewLoginTitleAndSetStyleChangeCallBack();
            }
            SapiWebView sapiWebView2 = this.sapiWebView;
            if (sapiWebView2 != null) {
                SapiUtils.syncCookies(this, sapiWebView2.buildDarkModeCookie());
                this.sapiWebView.reload();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final ValueCallback<Uri> valueCallback) {
        if (Build.VERSION.SDK_INT >= 33) {
            de deVar = new de();
            deVar.f2992ad = getApplicationContext();
            deVar.f2996th = new String[]{"android.permission.READ_MEDIA_IMAGES"};
            deVar.f2998yj = "权限申请";
            deVar.f2997uk = "为了正常使用图片上传服务，请允许使用相册权限。你可以通过系统\"设置\"进行权限的管理";
            qw.rg().uk(deVar, new ad() {
                public void onFailure(int i2) {
                    Toast.makeText(BaseActivity.this, "请开启相册权限", 1).show();
                }

                public void onSuccess() {
                    ValueCallback unused = BaseActivity.this.a = valueCallback;
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.setType("image/*");
                    BaseActivity.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1010);
                }
            });
            return;
        }
        this.a = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1010);
    }

    /* access modifiers changed from: private */
    public void a(final SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            Toast.makeText(this, "请先登录", 1).show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() {
            public void onFinish() {
            }

            public void onStart() {
            }

            public void onFailure(GetTplStokenResult getTplStokenResult) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", getTplStokenResult.getResultCode());
                    jSONObject.put("errmsg", getTplStokenResult.getResultMsg());
                } catch (JSONException e) {
                    Log.e(e);
                }
                if (BaseActivity.this.d != null) {
                    BaseActivity.this.d.setIdentifyToken(jSONObject.toString());
                }
            }

            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                String str = getTplStokenResult.tplStokenMap.get("pp");
                if (!TextUtils.isEmpty(str)) {
                    SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = biometricsIdentifyResult;
                    if (biometricsIdentifyResult.biometricType == 1) {
                        BaseActivity.this.livenessRecognize(str, biometricsIdentifyResult);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", -402);
                    jSONObject.put("errmsg", "服务异常，请稍后再试");
                } catch (JSONException e) {
                    Log.e(e);
                }
                if (BaseActivity.this.d != null) {
                    BaseActivity.this.d.setIdentifyToken(jSONObject.toString());
                }
            }
        }, currentAccount.bduss, arrayList);
    }

    /* access modifiers changed from: private */
    public void a(Activity activity, final SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
        BiometricsManager instance = BiometricsManager.getInstance();
        AnonymousClass22 r7 = new PassFaceRecogCallback() {
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a2 = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), (String) null, (String) null);
                SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult = bioScanFaceResult;
                if (bioScanFaceResult != null) {
                    bioScanFaceResult.setScanFaceIdentifyResult(a2.toString());
                }
            }

            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                String str;
                SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult = bioScanFaceResult;
                if (bioScanFaceResult != null) {
                    if (bioScanFaceResult.type == 1) {
                        try {
                            JSONObject jSONObject = passFaceRecogResult.extraJson;
                            if (jSONObject != null) {
                                jSONObject.remove("faceimage");
                                jSONObject.remove("imgdigests");
                                jSONObject.put("errno", passFaceRecogResult.getResultCode());
                                jSONObject.put("errmsg", passFaceRecogResult.getResultMsg());
                                str = jSONObject.toString();
                                bioScanFaceResult.setScanFaceIdentifyResult(str);
                                return;
                            }
                        } catch (JSONException e) {
                            Log.e(e);
                        }
                        str = "";
                        bioScanFaceResult.setScanFaceIdentifyResult(str);
                        return;
                    }
                    bioScanFaceResult.setScanFaceIdentifyResult(BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid).toString());
                }
            }
        };
        if (bioScanFaceResult.type == 1) {
            instance.recogWithFaceDetect(activity, bioScanFaceResult.subpro, bioScanFaceResult.transParamsMap, "0", bioScanFaceResult.uid, "", r7);
            return;
        }
        instance.recogWithFaceOuter(activity, bioScanFaceResult.subpro, bioScanFaceResult.transParamsMap, "0", bioScanFaceResult.uid, r7);
    }

    /* access modifiers changed from: private */
    public JSONObject a(int i2, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", i2);
            jSONObject.put("errmsg", str);
            if (i2 == 0) {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("credentialKey", str2);
                    jSONObject.put("callbackkey", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("authsid", str3);
                }
            }
        } catch (JSONException e2) {
            Log.e(e2);
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public void a(Intent intent) {
        SapiJsCallBacks.CallBacks jsCallBacks;
        JsPromptResult promptResult;
        SapiWebView sapiWebView2 = this.sapiWebView;
        if (sapiWebView2 != null && (jsCallBacks = sapiWebView2.getJsCallBacks()) != null && (promptResult = jsCallBacks.getPromptResult()) != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", "0");
                if (intent == null) {
                    promptResult.confirm(jSONObject.toString());
                    Toast.makeText(this, jSONObject.toString(), 0).show();
                    return;
                }
                jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_AUTHORIZATION_CODE, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_AUTHORIZATION_CODE));
                jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_OPEN_ID));
                jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_USER_ID, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_USER_ID));
                jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN));
                jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_UNION_ID, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_UNION_ID));
                jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE));
                jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME));
                jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_APP_ID, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                jSONObject.put("tpl", SapiAccountManager.getInstance().getConfignation().tpl);
                String str = n;
                Log.d(str, "base activity resultThirdPartyVerify: " + jSONObject.toString());
                promptResult.confirm(jSONObject.toString());
            } catch (JSONException unused) {
                promptResult.cancel();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        IdCardOcrDTO idCardOcrDTO = new IdCardOcrDTO();
        idCardOcrDTO.context = this;
        idCardOcrDTO.type = str;
        CoreViewRouter.getInstance().loadIdCardOcr(idCardOcrDTO, new IdCardOcrCallback() {
            public void onFailure(IdCardOcrResult idCardOcrResult) {
                if (BaseActivity.this.j != null) {
                    IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                    idcardOcrImageRusult.type = idCardOcrResult.type;
                    idcardOcrImageRusult.image = idCardOcrResult.image;
                    idcardOcrImageRusult.setResultCode(idCardOcrResult.getResultCode());
                    idcardOcrImageRusult.setResultMsg(idCardOcrResult.getResultMsg());
                    BaseActivity.this.j.onFailure(idcardOcrImageRusult);
                }
            }

            public void onSuccess(IdCardOcrResult idCardOcrResult) {
                if (BaseActivity.this.j != null) {
                    IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                    idcardOcrImageRusult.type = idCardOcrResult.type;
                    idcardOcrImageRusult.image = idCardOcrResult.image;
                    idcardOcrImageRusult.setResultCode(idCardOcrResult.getResultCode());
                    idcardOcrImageRusult.setResultMsg(idCardOcrResult.getResultMsg());
                    BaseActivity.this.j.onSuccess(idcardOcrImageRusult);
                }
            }
        });
    }

    private void a(Uri uri) {
        Intent intent = new Intent(this, ImageClipActivity.class);
        intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 2);
        intent.setData(uri);
        startActivityForResult(intent, 1006);
    }
}
