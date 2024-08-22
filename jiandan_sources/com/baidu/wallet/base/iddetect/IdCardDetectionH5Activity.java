package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.camera.CameraBaseActivity;
import com.baidu.wallet.base.camera.IImageProcess;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.Yuv;
import com.baidu.wallet.base.camera.util.ImageUtils;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.base.iddetect.utils.BitmapUtil;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class IdCardDetectionH5Activity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    public static int mSteps = 1;
    public final String TAG = IdCardDetectionH5Activity.class.getSimpleName();
    public Bundle mBundle = new Bundle();
    public View mCameraCtrlArea;
    public View mCameraSwitchIcon = null;
    public LinearLayout mChooseOicLayout = null;
    public String mCurrentFileName = "";
    public View mFlashIcon = null;
    public Bitmap mIamgeBp;
    public Bitmap mImageBp4Result;
    public Bitmap mImageBp4TP;
    public ImageView mPicView = null;
    public TextView mRestartTakePic = null;
    public ImageView mTakePic = null;
    public LinearLayout mTakePicLayout = null;
    public TextView mTakePicOk = null;
    public TextView mTitle;
    public AtomicBoolean mToTakePhoto = new AtomicBoolean(false);
    public TextView tipsView = null;

    private void chage2TakePicView(Boolean bool) {
        if (bool.booleanValue()) {
            Activity activity = getActivity();
            Bitmap bitmap = this.mImageBp4Result;
            this.mCurrentFileName = ImageUtils.saveBitmapToCache(activity, bitmap, System.currentTimeMillis() + ".jpg");
        }
        this.tipsView.setVisibility(0);
        this.mCameraCtrlArea.setVisibility(0);
        this.mTitle.setText(getString(ResUtils.string(getActivity(), "wallet_base_h5_idcard_title_take_pic")));
        this.mTakePicLayout.setVisibility(0);
        this.mChooseOicLayout.setVisibility(8);
        this.mPicView.setVisibility(8);
        onResume();
    }

    public void destroyProcessor() {
    }

    public long getAutoFocusDelay() {
        return 3000;
    }

    public View getCustomizedView() {
        return View.inflate(this, ResUtils.layout(getActivity(), "wallet_base_identity_h5_detection_activity"), (ViewGroup) null);
    }

    public long getFirstFocusDelay() {
        return ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS;
    }

    public float getFocusDataYXRatioal() {
        return 0.631f;
    }

    public IImageProcess getImageProcessor() {
        return this;
    }

    public int getRecycledBufSize(int i2, int i3) {
        return 0;
    }

    public boolean initProcessor() {
        return true;
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
            if (this.mToTakePhoto.compareAndSet(false, true)) {
                view.setClickable(false);
                takePicture();
            }
        } else if (ResUtils.id(getActivity(), "idcard_take_pic_finish") == id) {
            int i2 = mSteps;
            String str = "pic2";
            switch (i2) {
                case 1:
                    this.mBundle.putInt("step", i2);
                    mSteps++;
                    chage2TakePicView(Boolean.TRUE);
                    this.mBundle.putString("pic1", this.mCurrentFileName);
                    return;
                case 2:
                    String saveBitmapToCache = ImageUtils.saveBitmapToCache(getActivity(), this.mImageBp4Result, System.currentTimeMillis() + ".jpg");
                    this.mCurrentFileName = saveBitmapToCache;
                    this.mBundle.putString(str, saveBitmapToCache);
                    mSteps = 1;
                    IdCardDetectionController.getInstance().IdCardDeteSuccess(this.mBundle);
                    finishWithoutAnim();
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    this.mBundle.putInt("step", i2);
                    this.mCurrentFileName = ImageUtils.saveBitmapToCache(getActivity(), this.mImageBp4Result, System.currentTimeMillis() + "");
                    Bundle bundle = this.mBundle;
                    int i3 = mSteps;
                    if (i3 == 5 || i3 == 6) {
                        str = "pic1";
                    }
                    bundle.putString(str, this.mCurrentFileName);
                    mSteps = 1;
                    IdCardDetectionController.getInstance().IdCardDeteSuccess(this.mBundle);
                    finishWithoutAnim();
                    return;
                default:
                    finishWithoutAnim();
                    return;
            }
        } else if (ResUtils.id(getActivity(), "idcard_restart_take_pic") == id) {
            chage2TakePicView(Boolean.FALSE);
        } else if (ResUtils.id(getActivity(), "idcards_title_back") == id) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
            finishWithoutAnim();
        } else if (view == this.mCameraSwitchIcon) {
            stopCamera();
            switchCamera();
            if (!CameraCtrl.isSupprtFlashLight(getPackageManager())) {
                this.mFlashIcon.setVisibility(4);
            } else if (this.cameraId == 1) {
                this.mFlashIcon.setVisibility(4);
                this.mFlashIcon.setBackgroundResource(ResUtils.drawable(getActivity(), "wallet_base_camera_flashlight_off_btn"));
            } else {
                this.mFlashIcon.setVisibility(0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mSteps = extras.getInt("step");
        }
        this.mFlashIcon = findViewById(ResUtils.id(getActivity(), "idcards_flash_light_switch"));
        this.mCameraSwitchIcon = findViewById(ResUtils.id(getActivity(), "idcards_camera_switch"));
        this.tipsView = (TextView) findViewById(ResUtils.id(getActivity(), "bd_wallet_promo"));
        this.mCameraCtrlArea = findViewById(ResUtils.id(getActivity(), "wallet_camera_control_area"));
        this.mTitle = (TextView) findViewById(ResUtils.id(getActivity(), "TextView1"));
        this.mTakePicLayout = (LinearLayout) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_bottom_layout"));
        this.mChooseOicLayout = (LinearLayout) findViewById(ResUtils.id(getActivity(), "idcard_pic_preview_bottom_layout"));
        this.mRestartTakePic = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_restart_take_pic"));
        this.mTakePicOk = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_finish"));
        this.mPicView = (ImageView) findViewById(ResUtils.id(getActivity(), "img_snapshot"));
        int i2 = 0;
        if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
            this.mFlashIcon.setOnClickListener(this);
            this.mFlashIcon.setVisibility(0);
            AccessibilityUtils.setContentDescription(this.mFlashIcon, "打开闪光灯");
        } else {
            this.mFlashIcon.setVisibility(4);
        }
        View view = this.mCameraSwitchIcon;
        if (!CameraCtrl.getInstance().isSupportMultiCamera()) {
            i2 = 8;
        }
        view.setVisibility(i2);
        this.mCameraSwitchIcon.setOnClickListener(this);
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
                IdCardDetectionH5Activity.this.autoFoucus();
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
                IdCardDetectionH5Activity.this.tipsView.setVisibility(8);
                IdCardDetectionH5Activity.this.mCameraCtrlArea.setVisibility(8);
                TextView access$300 = IdCardDetectionH5Activity.this.mTitle;
                IdCardDetectionH5Activity idCardDetectionH5Activity = IdCardDetectionH5Activity.this;
                access$300.setText(idCardDetectionH5Activity.getString(ResUtils.string(idCardDetectionH5Activity.getActivity(), "wallet_base_h5_idcard_title2")));
                IdCardDetectionH5Activity.this.mTakePicLayout.setVisibility(8);
                IdCardDetectionH5Activity.this.mChooseOicLayout.setVisibility(0);
                IdCardDetectionH5Activity.this.mPicView.setVisibility(0);
                Bitmap unused = IdCardDetectionH5Activity.this.mImageBp4Result = (Bitmap) objArr[0];
                IdCardDetectionH5Activity.this.mPicView.setImageBitmap(IdCardDetectionH5Activity.this.mImageBp4Result);
                IdCardDetectionH5Activity.this.restartScan();
                IdCardDetectionH5Activity.this.mToTakePhoto.compareAndSet(true, false);
                IdCardDetectionH5Activity.this.mTakePic.setClickable(true);
            }
        });
    }

    public void onResume() {
        super.onResume();
        switch (mSteps) {
            case 1:
            case 3:
            case 5:
                this.tipsView.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_hand"));
                return;
            case 2:
            case 4:
                this.tipsView.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_hand"));
                return;
            case 6:
                this.tipsView.setText("");
                return;
            default:
                return;
        }
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
            if (this.cameraId == 1) {
                this.mImageBp4TP = ImageUtils.rotateAReversalBitmap(270, decodeSampledBitmapFromByteArray);
            } else {
                this.mImageBp4TP = ImageUtils.rotateBitmap(90, decodeSampledBitmapFromByteArray);
            }
        }
        return new Bitmap[]{this.mImageBp4TP};
    }

    public void relayoutUi() {
    }

    public void setFocusRectValue(Rect rect) {
    }

    public void updateFlashLightUi(boolean z) {
        if (this.mFlashIcon != null) {
            this.mFlashIcon.setBackgroundResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
            AccessibilityUtils.setContentDescription(this.mFlashIcon, z ? "关闭闪光灯" : "打开闪光灯");
        }
    }
}
