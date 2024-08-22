package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.camera.CameraBaseActivity;
import com.baidu.wallet.base.camera.IImageProcess;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.Yuv;
import com.baidu.wallet.base.camera.util.ImageUtils;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.base.iddetect.statistics.IdCardDetectStatistics;
import com.baidu.wallet.base.iddetect.utils.BitmapUtil;
import com.baidu.wallet.base.iddetect.view.MistViewForIdCard;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.permission.CommonPermissionCallback;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class IdentityCardDetectionActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    public static int mSteps = 1;
    public final int ID_REQUST_STORAGE_PERMISSION = 18;
    public final int SELECT_PICTURE_FROM_ALBUM = 17;
    public final String TAG = IdentityCardDetectionActivity.class.getSimpleName();
    public Bundle mBundle = new Bundle();
    public RelativeLayout mChooseOicLayout = null;
    public String mCurrentFileName = "";
    public ImageView mFlashIcon = null;
    public View mFocusView = null;
    public ImageView mGuoHuiPicView = null;
    public Bitmap mIamgeBp;
    public Bitmap mImageBp4TP;
    public MistViewForIdCard mMistView;
    public TextView mOpenAlbum = null;
    public CommonPermissionCallback mPermissionCallBack;
    public FrameLayout mPicDisplayView = null;
    public ImageView mPicView = null;
    public ImageView mRenTouPicView = null;
    public TextView mRestartTakePic = null;
    public ImageView mTakePic = null;
    public RelativeLayout mTakePicLayout = null;
    public TextView mTakePicOk = null;
    public AtomicBoolean mToTakePhoto = new AtomicBoolean(false);
    public String ready2UseFileName = "";
    public boolean showAlbum = true;
    public TextView tipsView = null;

    private void chage2TakePicView(Boolean bool) {
        if (bool.booleanValue()) {
            this.mCurrentFileName = this.ready2UseFileName;
        }
        this.mFocusView.setVisibility(0);
        this.tipsView.setVisibility(0);
        this.mTakePicLayout.setVisibility(0);
        this.mChooseOicLayout.setVisibility(8);
        this.mPicDisplayView.setVisibility(8);
        this.mPicView.setImageDrawable((Drawable) null);
        onResume();
    }

    private void gotoSysAlbum() {
        Intent intent = new Intent();
        if (!"nubia".equals(Build.BRAND) || !"NX595J".equals(Build.MODEL)) {
            intent.addCategory("android.intent.category.OPENABLE");
            if (Build.VERSION.SDK_INT < 19) {
                intent.setAction("android.intent.action.GET_CONTENT");
            } else {
                intent.setAction("android.intent.action.OPEN_DOCUMENT");
            }
        } else {
            intent.setAction("android.intent.action.PICK");
        }
        intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(Intent.createChooser(intent, "选择图片"), 17);
    }

    /* access modifiers changed from: private */
    public void handleNoStoragePermission() {
        restartScan();
        GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_permission_open_album_error"));
    }

    private void openSysAlbum() {
        if (PermissionManager.checkCallingPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
            gotoSysAlbum();
        } else {
            this.mPermissionCallBack = BaiduWalletUtils.requestPermissionsDialog("", this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new BaiduWalletUtils.IRequestPermissionCallBack() {
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        if (!PermissionManager.checkCallingOrSelfPermission(IdentityCardDetectionActivity.this.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 18)) {
                            IdentityCardDetectionActivity.this.handleNoStoragePermission();
                        }
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        IdentityCardDetectionActivity.this.onRequestPermissionsResult(1, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new int[]{-1});
                    }
                }

                public void isShow(String str, Boolean bool) {
                }

                public void requestResult(String str, Boolean bool) {
                }
            });
        }
    }

    public void deleteReady2USeFile() {
        File file = new File(this.ready2UseFileName);
        if (file.exists()) {
            file.delete();
        }
        this.ready2UseFileName = "";
    }

    public void destroyProcessor() {
    }

    public long getAutoFocusDelay() {
        return 3000;
    }

    public View getCustomizedView() {
        MistViewForIdCard mistViewForIdCard = (MistViewForIdCard) View.inflate(this, ResUtils.layout(getActivity(), "wallet_base_identity_card_detection_activity"), (ViewGroup) null);
        this.mMistView = mistViewForIdCard;
        return mistViewForIdCard;
    }

    public long getFirstFocusDelay() {
        return ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS;
    }

    public float getFocusDataYXRatioal() {
        return 0.62416106f;
    }

    public IImageProcess getImageProcessor() {
        return this;
    }

    public void getPicFinished() {
        int i2 = mSteps;
        String str = "pic1";
        if (i2 == 1) {
            this.mBundle.putInt("step", i2);
            mSteps++;
            chage2TakePicView(Boolean.TRUE);
            this.mBundle.putString(str, this.mCurrentFileName);
            restartScan();
        } else if (i2 == 2) {
            String str2 = this.ready2UseFileName;
            this.mCurrentFileName = str2;
            this.mBundle.putString("pic2", str2);
            mSteps = 1;
            IdCardDetectionController.getInstance().IdCardDeteSuccess(this.mBundle);
            finishWithoutAnim();
        } else if (i2 == 3 || i2 == 4) {
            this.mBundle.putInt("step", mSteps);
            this.mCurrentFileName = this.ready2UseFileName;
            Bundle bundle = this.mBundle;
            if (mSteps != 3) {
                str = "pic2";
            }
            bundle.putString(str, this.mCurrentFileName);
            mSteps = 1;
            IdCardDetectionController.getInstance().IdCardDeteSuccess(this.mBundle);
            finishWithoutAnim();
        } else {
            finishWithoutAnim();
        }
    }

    public int getRecycledBufSize(int i2, int i3) {
        return 0;
    }

    public boolean initProcessor() {
        return true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1 && i2 == 17) {
            pauseCamera();
            Uri uri = null;
            if (!(intent == null || intent.getData() == null)) {
                uri = intent.getData();
            }
            if (uri != null) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = ImageUtils.calSampleSize(getActivity(), uri);
                    Bitmap bitmapFromUri = ImageUtils.getBitmapFromUri(getActivity(), uri, options);
                    Activity activity = getActivity();
                    this.ready2UseFileName = ImageUtils.saveBitmapToCache(activity, bitmapFromUri, System.currentTimeMillis() + ".jpg", 90);
                    if (bitmapFromUri != null) {
                        bitmapFromUri.recycle();
                    }
                    if (mSteps == 1) {
                        GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_idcard_promo_f_album_tips"));
                    }
                    getPicFinished();
                } catch (Exception e) {
                    e.printStackTrace();
                    DXMSdkSAUtils.onEventWithValues(StatServiceEvent.SDK_SELF_DEFINE_GET_SELECT_PIC_FAILED, Arrays.asList(new String[]{e.getMessage()}));
                }
            }
        }
    }

    public void onBackPressed() {
        IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
        super.onBackPressed();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (ResUtils.id(getActivity(), "idcards_flash_light_switch") == id) {
            triggerFlash();
        } else if (ResUtils.id(getActivity(), "idcards_take_pic_start") == id) {
            DXMSdkSAUtils.onEvent(IdCardDetectStatistics.IDCARD_PHOTO_SHUTTER);
            if (this.mToTakePhoto.compareAndSet(false, true)) {
                view.setClickable(false);
                takePicture();
            }
        } else if (ResUtils.id(getActivity(), "idcard_take_pic_finish") == id) {
            int i2 = mSteps;
            if (i2 == 2 || i2 == 3 || i2 == 4) {
                DXMSdkSAUtils.onEvent(IdCardDetectStatistics.IDCARD_PHOTO_COMPLETE);
            }
            getPicFinished();
        } else if (ResUtils.id(getActivity(), "idcard_restart_take_pic") == id) {
            DXMSdkSAUtils.onEvent(IdCardDetectStatistics.IDCARD_PHOTO_RESET);
            deleteReady2USeFile();
            chage2TakePicView(Boolean.FALSE);
            restartScan();
        } else if (ResUtils.id(getActivity(), "idcards_title_back") == id) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
            finishWithoutAnim();
        } else if (ResUtils.id(getActivity(), "idcards_open_album") == id && !CheckUtils.isFastDoubleClick()) {
            openSysAlbum();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mSteps = extras.getInt("step");
            this.showAlbum = extras.getBoolean("show_album");
        }
        this.mFocusView = findViewById(ResUtils.id(getActivity(), "focus_view"));
        this.mFlashIcon = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_flash_light_switch"));
        this.tipsView = (TextView) findViewById(ResUtils.id(getActivity(), "bd_wallet_promo"));
        this.mTakePicLayout = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_bottom_layout"));
        this.mChooseOicLayout = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "idcard_pic_preview_bottom_layout"));
        this.mRestartTakePic = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_restart_take_pic"));
        this.mTakePicOk = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_finish"));
        this.mPicView = (ImageView) findViewById(ResUtils.id(getActivity(), "img_snapshot"));
        this.mPicDisplayView = (FrameLayout) findViewById(ResUtils.id(getActivity(), "img_display_layout"));
        this.mGuoHuiPicView = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_prompt_image_view_b"));
        this.mRenTouPicView = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_prompt_image_view_f"));
        TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "idcards_open_album"));
        this.mOpenAlbum = textView;
        textView.setOnClickListener(this);
        if (!this.showAlbum) {
            this.mOpenAlbum.setVisibility(8);
        }
        if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
            this.mFlashIcon.setOnClickListener(this);
            this.mFlashIcon.setVisibility(0);
            AccessibilityUtils.setContentDescription(this.mFlashIcon, "打开闪光灯");
        } else {
            this.mFlashIcon.setVisibility(4);
        }
        this.mRestartTakePic.setOnClickListener(this);
        this.mTakePicOk.setOnClickListener(this);
        findViewById(ResUtils.id(getActivity(), "idcards_title_back")).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_take_pic_start"));
        this.mTakePic = imageView;
        imageView.setOnClickListener(this);
        this.mPreviewView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                IdentityCardDetectionActivity.this.autoFoucus();
                return true;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.mIamgeBp;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mIamgeBp.recycle();
            this.mIamgeBp = null;
        }
    }

    public void onPermissionDenied() {
        IdCardDetectionController.getInstance().IdCardDeteFailed(-1, "permission denied");
    }

    public void onProcessImageOk(final Object[] objArr) {
        runOnUiThread(new Runnable() {
            public void run() {
                if (IdentityCardDetectionActivity.this.mGuoHuiPicView.getVisibility() == 0) {
                    IdentityCardDetectionActivity.this.mGuoHuiPicView.setVisibility(8);
                }
                if (IdentityCardDetectionActivity.this.mRenTouPicView.getVisibility() == 0) {
                    IdentityCardDetectionActivity.this.mRenTouPicView.setVisibility(8);
                }
                IdentityCardDetectionActivity.this.tipsView.setVisibility(8);
                IdentityCardDetectionActivity.this.mTakePicLayout.setVisibility(8);
                IdentityCardDetectionActivity.this.mChooseOicLayout.setVisibility(0);
                long currentTimeMillis = System.currentTimeMillis();
                IdentityCardDetectionActivity identityCardDetectionActivity = IdentityCardDetectionActivity.this;
                String unused = identityCardDetectionActivity.ready2UseFileName = ImageUtils.saveBitmapToCache(identityCardDetectionActivity.getActivity(), (Bitmap) objArr[0], System.currentTimeMillis() + ".jpg", 90);
                Bitmap bPfromsdcard = ImageUtils.getBPfromsdcard(IdentityCardDetectionActivity.this.ready2UseFileName);
                LogUtil.i("IdentityCardDetectionActivity", "re save and show time:" + (System.currentTimeMillis() - currentTimeMillis));
                IdentityCardDetectionActivity.this.mPicView.setImageBitmap(bPfromsdcard);
                IdentityCardDetectionActivity.this.pauseCamera();
                IdentityCardDetectionActivity.this.mToTakePhoto.compareAndSet(true, false);
                IdentityCardDetectionActivity.this.mTakePic.setClickable(true);
            }
        });
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        CommonPermissionCallback commonPermissionCallback = this.mPermissionCallBack;
        if (commonPermissionCallback != null) {
            commonPermissionCallback.onRequestPermissionsResult(i2, strArr, iArr);
            this.mPermissionCallBack = null;
        }
        if (i2 != 18) {
            return;
        }
        if (strArr == null || iArr == null || strArr.length == 0 || iArr.length == 0) {
            handleNoStoragePermission();
            return;
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if ("android.permission.READ_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i3]) && iArr != null && iArr.length > i3) {
                if (iArr[i3] == 0) {
                    gotoSysAlbum();
                } else if (-1 == iArr[i3]) {
                    handleNoStoragePermission();
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
        int i2 = mSteps;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return;
                    }
                }
            }
            this.mTakePicOk.setText(ResUtils.string(getActivity(), "wallet_base_idcard_retake_pic_finish"));
            this.tipsView.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_b"));
            this.mGuoHuiPicView.setVisibility(0);
            this.mRenTouPicView.setVisibility(8);
            return;
        }
        this.mTakePicOk.setText(ResUtils.string(getActivity(), "wallet_base_idcard_take_another"));
        this.tipsView.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_f"));
        this.mGuoHuiPicView.setVisibility(8);
        this.mRenTouPicView.setVisibility(0);
    }

    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        if (this.mInCaptureTimeOut.compareAndSet(true, false)) {
            LogUtil.d(this.TAG, "preview process");
            if (this.mToTakePhoto.get()) {
                rect.set(0, 0, i2, i3);
                if (this.mIamgeBp == null) {
                    this.mIamgeBp = Bitmap.createBitmap(rect.height(), rect.width(), Bitmap.Config.ARGB_8888);
                }
                Yuv.rotateCropBmp(bArr, i2, i3, rect.left, rect.top, 270, this.mIamgeBp);
                return new Bitmap[]{this.mIamgeBp};
            }
        }
        return null;
    }

    public Object[] processImageJpegData(byte[] bArr, int i2, int i3) {
        if (!this.mToTakePhoto.get()) {
            return null;
        }
        LogUtil.d(this.TAG, "takepic process");
        Bitmap decodeSampledBitmapFromByteArray = BitmapUtil.decodeSampledBitmapFromByteArray(bArr, (float) i2, (float) i3);
        this.mImageBp4TP = decodeSampledBitmapFromByteArray;
        if (decodeSampledBitmapFromByteArray != null) {
            this.mImageBp4TP = ImageUtils.rotateBitmap(90, decodeSampledBitmapFromByteArray);
        }
        return new Bitmap[]{this.mImageBp4TP};
    }

    public void relayoutUi() {
        final ViewGroup.LayoutParams layoutParams = this.mFocusView.getLayoutParams();
        int width = this.mFocusView.getWidth();
        layoutParams.width = width;
        layoutParams.height = (int) (((float) width) * getFocusDataYXRatioal() * this.mScaleCoefficient);
        this.mFocusView.post(new Runnable() {
            public void run() {
                IdentityCardDetectionActivity.this.mFocusView.setLayoutParams(layoutParams);
            }
        });
        int[] iArr = new int[2];
        getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        int[] iArr2 = new int[2];
        this.mPreviewView.getLocationOnScreen(iArr2);
        this.mFocusView.getLocationOnScreen(iArr);
        Rect rect = this.mFocusViewRect;
        int i2 = iArr[0] - iArr2[0];
        rect.left = i2;
        rect.right = i2 + layoutParams.width;
        int i3 = iArr[1] - iArr2[1];
        rect.top = i3;
        rect.bottom = i3 + layoutParams.height;
        this.mMistView.getFocusFrame().set(this.mFocusViewRect);
        ViewGroup.LayoutParams layoutParams2 = this.mPicView.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        this.mPicView.setLayoutParams(layoutParams2);
        this.mPicView.requestLayout();
        ((FrameLayout.LayoutParams) this.tipsView.getLayoutParams()).topMargin = this.mFocusViewRect.bottom + DisplayUtils.dip2px(getActivity(), 25.0f);
        this.tipsView.requestLayout();
    }

    public void setFocusRectValue(Rect rect) {
    }

    public void updateFlashLightUi(boolean z) {
        if (this.mFlashIcon != null) {
            this.mFlashIcon.setImageResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
            AccessibilityUtils.setContentDescription(this.mFlashIcon, z ? "关闭闪光灯" : "打开闪光灯");
        }
    }
}
