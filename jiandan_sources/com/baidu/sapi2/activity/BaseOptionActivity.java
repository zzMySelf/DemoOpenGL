package com.baidu.sapi2.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.provider.FileProvider;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.UIOrientation;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import fe.fe.ppp.de.ad;
import fe.fe.ppp.de.de;
import fe.fe.ppp.de.qw;
import java.io.File;

public class BaseOptionActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int IMG_RESULT_OK_CODE = 10000;
    public static final long LIMIT_TIME = 500;
    public static final int NO_CAMERA_PERM_CODE = 10001;
    public static final String NO_CAMERA_PERM_MSG = "请开启相机和存储权限";
    public static final int NO_STORAGE_PERM_CODE = 10002;
    public static final String NO_STORAGE_PERM_MSG = "请开启存储权限";
    public static final String b = "camera_temp_image.jpg";
    public static final int c = 1001;
    public static final int d = 1002;
    public static final int e = 1003;
    public static final int f = 1;
    public static final int g = 512;
    public static long lastClickTime;
    public ImageCropCallback.ImageCropResult a;
    public long enterTimeMills;

    private ImageCropCallback b() {
        return new ImageCropCallback() {
            public void onImageCrop(Context context, Uri uri, int i2, int i3, ImageCropCallback.ImageCropResult imageCropResult) {
                ImageCropCallback.ImageCropResult unused = BaseOptionActivity.this.a = imageCropResult;
                Intent intent = new Intent(context, ImageClipActivity.class);
                if (i2 == ClipBoxView.I) {
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 0);
                } else {
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 1);
                }
                intent.putExtra(ImageClipActivity.EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, i3);
                intent.setData(uri);
                BaseOptionActivity.this.startActivityForResult(intent, 1003);
            }
        };
    }

    public long gapTimeFromEnter() {
        return System.currentTimeMillis() - this.enterTimeMills;
    }

    public void lockScreenOrientation() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28 || i2 <= 25) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation == null || confignation.getUIOrientation() == null) {
                setRequestedOrientation(1);
                return;
            }
            UIOrientation uIOrientation = confignation.getUIOrientation();
            if (uIOrientation == UIOrientation.SCREEN_ORIENTATION_LANDSCAPE) {
                setRequestedOrientation(0);
            } else if (uIOrientation == UIOrientation.SCREEN_ORIENTATION_USER) {
                setRequestedOrientation(2);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        ImageCropCallback imageCropCallback = CoreViewRouter.getInstance().getImageCropCallback();
        ActivityResultCallback activityResultCallback = CoreViewRouter.getInstance().getActivityResultCallback();
        if (imageCropCallback == null || activityResultCallback == null) {
            imageCropCallback = b();
            activityResultCallback = a();
        }
        ImageCropCallback imageCropCallback2 = imageCropCallback;
        if (activityResultCallback != null) {
            activityResultCallback.onActivityResult(i2, i3, intent);
        }
        if (i2 == 1001) {
            if (i3 != -1 || imageCropCallback2 == null) {
                processImgBase64Data(i3, (String) null, (String) null);
                return;
            }
            imageCropCallback2.onImageCrop(this, Uri.fromFile(new File(getExternalCacheDir(), "camera_temp_image.jpg")), 1, 512, new ImageCropCallback.ImageCropResult() {
                public void onImageResult(String str) {
                    BaseOptionActivity.this.processImgBase64Data(10000, "", str);
                }
            });
        } else if (i2 != 1002) {
        } else {
            if (i3 != -1 || intent.getData() == null || imageCropCallback2 == null) {
                processImgBase64Data(i3, (String) null, (String) null);
                return;
            }
            imageCropCallback2.onImageCrop(this, intent.getData(), 1, 512, new ImageCropCallback.ImageCropResult() {
                public void onImageResult(String str) {
                    BaseOptionActivity.this.processImgBase64Data(10000, "", str);
                }
            });
        }
    }

    public void onClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lockScreenOrientation();
        this.enterTimeMills = System.currentTimeMillis();
    }

    public void pickPhoto() {
        boolean z = SapiAccountManager.getInstance().getConfignation().isNightMode || DarkModeUtil.isDarkMode(this);
        de deVar = new de();
        deVar.f2992ad = this;
        deVar.f2993i = z;
        if (Build.VERSION.SDK_INT >= 33) {
            deVar.f2996th = new String[]{"android.permission.READ_MEDIA_IMAGES"};
        } else {
            deVar.f2996th = new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION};
        }
        deVar.f2998yj = "存储权限";
        deVar.f2997uk = "为了正常使用图片上传服务，请允许使用存储权限。你可以通过系统\"设置\"进行权限的管理";
        qw.rg().uk(deVar, new ad() {
            public void onFailure(int i2) {
                BaseOptionActivity.this.processImgBase64Data(10002, BaseOptionActivity.NO_STORAGE_PERM_MSG, (String) null);
            }

            public void onSuccess() {
                try {
                    if (Build.VERSION.SDK_INT >= 33) {
                        BaseOptionActivity.this.startActivityForResult(new Intent("android.provider.action.PICK_IMAGES"), 1002);
                    } else if (Build.VERSION.SDK_INT == 19) {
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");
                        BaseOptionActivity.this.startActivityForResult(intent, 1002);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.setType("image/*");
                        intent2.setAction("android.intent.action.PICK");
                        BaseOptionActivity.this.startActivityForResult(intent2, 1002);
                    }
                } catch (Throwable th2) {
                    Log.e(th2);
                }
            }
        });
    }

    public void processImgBase64Data(int i2, String str, String str2) {
    }

    public void takePhoto() {
        boolean z = SapiAccountManager.getInstance().getConfignation().isNightMode || DarkModeUtil.isDarkMode(this);
        de deVar = new de();
        deVar.f2992ad = this;
        deVar.f2993i = z;
        deVar.f2996th = new String[]{"android.permission.CAMERA"};
        deVar.f2998yj = "权限申请";
        deVar.f2997uk = "为了正常使用图片上传服务，请允许使用摄像头权限。你可以通过系统\"设置\"进行权限的管理";
        qw.rg().uk(deVar, new ad() {
            public void onFailure(int i2) {
                BaseOptionActivity.this.processImgBase64Data(10001, BaseOptionActivity.NO_CAMERA_PERM_MSG, "");
            }

            public void onSuccess() {
                try {
                    if (!"mounted".equals(Environment.getExternalStorageState())) {
                        Toast.makeText(BaseOptionActivity.this, R.string.sapi_sdk_user_profile_sdcard_unavailable, 0).show();
                        return;
                    }
                    File file = new File(BaseOptionActivity.this.getExternalCacheDir(), "camera_temp_image.jpg");
                    if (file.exists()) {
                        file.delete();
                    }
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.setAction("android.media.action.IMAGE_CAPTURE");
                    File file2 = new File(BaseOptionActivity.this.getExternalCacheDir(), "camera_temp_image.jpg");
                    if (Build.VERSION.SDK_INT >= 24) {
                        if (BaseOptionActivity.this.getApplicationInfo().targetSdkVersion >= 24) {
                            BaseOptionActivity baseOptionActivity = BaseOptionActivity.this;
                            intent.putExtra("output", FileProvider.getUriForFile(baseOptionActivity, BaseOptionActivity.this.getPackageName() + ".passfileprovider", file2));
                            intent.putExtra("orientation", 0);
                            BaseOptionActivity.this.startActivityForResult(intent, 1001);
                        }
                    }
                    intent.putExtra("output", Uri.fromFile(file2));
                    intent.putExtra("orientation", 0);
                    BaseOptionActivity.this.startActivityForResult(intent, 1001);
                } catch (Throwable th2) {
                    Log.e(th2);
                }
            }
        });
    }

    private ActivityResultCallback a() {
        return new ActivityResultCallback() {
            public void onActivityResult(int i2, int i3, Intent intent) {
                if (i2 != 1003) {
                    return;
                }
                if (i3 == -1) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                    if (byteArrayExtra != null && BaseOptionActivity.this.a != null) {
                        BaseOptionActivity.this.a.onImageResult(fe.fe.ppp.ad.ad.fe(byteArrayExtra));
                    }
                } else if (BaseOptionActivity.this.a != null) {
                    BaseOptionActivity.this.a.onImageResult((String) null);
                }
            }
        };
    }
}
