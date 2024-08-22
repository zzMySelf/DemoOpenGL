package com.tera.scan.scanner.ui.camera;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.baidu.aiscan.R;
import com.tera.scan.framework.kernel.architecture.ui.BaseFragment;
import com.tera.scan.scanner.ui.camera.CameraView;
import com.tera.scan.scanner.ui.crop.CropView;
import com.tera.scan.scanner.ui.crop.FrameOverlayView;
import java.io.File;

public class CameraFragment extends BaseFragment {
    public static final String BACK_GALLERY = "back_gallery";
    public static final String BACK_PHOTO = "back_photo";
    public static final String CONTENT_TYPE_BANK_CARD = "bankCard";
    public static final String CONTENT_TYPE_GENERAL = "general";
    public static final String CONTENT_TYPE_ID_CARD_BACK = "IDCardBack";
    public static final String CONTENT_TYPE_ID_CARD_FRONT = "IDCardFront";
    public static final String CONTENT_TYPE_OCR = "ocr";
    public static final String IMAGE_TYPE_BACK = "image_type_back";
    public static final String IS_NEED_CAMERA_FULL = "is_need_camera_full";
    public static final String IS_NEED_ENTER_LOTTIE = "is_need_enter_lottie";
    public static final String IS_NEED_LIGHT = "is_need_light";
    public static final String IS_NEED_NINE_LINE = "is_need_nine_line";
    public static final String IS_NOT_NEED_JUMP_CROP = "is_not_need_jump_crop";
    public static final String KEY_CONTENT_TYPE = "contentType";
    public static final String KEY_OUTPUT_FILE_PATH = "outputFilePath";
    public static final int PERMISSIONS_EXTERNAL_STORAGE = 801;
    public static final int PERMISSIONS_REQUEST_CAMERA = 800;
    public static final String RATION_TYPE = "ration_type";
    public static final int RATIO_TYPE_16_9 = 1;
    public static final int REQUEST_CODE_PICK_IMAGE = 100;
    public static final String TAG = "CameraFragment";
    public View.OnClickListener albumButtonOnClickListener = new rg();
    public CameraView cameraView;
    public View.OnClickListener closeButtonOnClickListener = new pf();
    public View.OnClickListener confirmButtonOnClickListener = new Cif();
    public View.OnClickListener confirmCancelButtonOnClickListener = new ad();
    public OCRCameraLayout confirmResultContainer;
    public String contentType;
    public View.OnClickListener cropCancelButtonListener = new i();
    public View.OnClickListener cropConfirmButtonListener = new o();
    public OCRCameraLayout cropContainer;
    public MaskView cropMaskView;
    public CropView cropView;
    public ImageView displayImageView;
    public Handler handler = new Handler();
    public boolean isNeedCameraFull = false;
    public boolean isNeedEnterLottie = false;
    public boolean isNeedLightButton = true;
    public boolean isNeedNineLine = false;
    public boolean isNotNeedCrop = false;
    public ImageView lightButton;
    public View.OnClickListener lightButtonOnClickListener = new th();
    public LinearLayout mBottom;
    public int mRatio;
    public File outputFile;
    public String outputPath;
    public FrameOverlayView overlayView;
    public PermissionCallback permissionCallback = new fe();
    public View.OnClickListener rotateButtonOnClickListener = new de();
    public View.OnClickListener takeButtonOnClickListener = new yj();
    public CameraView.de takePictureCallback = new uk();
    public OCRCameraLayout takePictureContainer;

    public class ad implements View.OnClickListener {
        public ad() {
        }

        public void onClick(View view) {
            CameraFragment.this.displayImageView.setImageBitmap((Bitmap) null);
            CameraFragment.this.showTakePicture();
        }
    }

    public class de implements View.OnClickListener {
        public de() {
        }

        public void onClick(View view) {
            CameraFragment.this.ocrUBC("Rotate_clk");
            CameraFragment.this.cropView.rotate(90);
        }
    }

    public class fe implements PermissionCallback {
        public fe() {
        }

        public boolean qw() {
            if (CameraFragment.this.getActivity() == null) {
                return false;
            }
            ActivityCompat.requestPermissions(CameraFragment.this.getActivity(), new String[]{"android.permission.CAMERA"}, 800);
            return false;
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            CameraFragment.this.cropView.setFilePath((String) null);
            CameraFragment.this.showTakePicture();
        }
    }

    /* renamed from: com.tera.scan.scanner.ui.camera.CameraFragment$if  reason: invalid class name */
    public class Cif implements View.OnClickListener {
        public Cif() {
        }

        public void onClick(View view) {
            CameraFragment.this.generateImage(((BitmapDrawable) CameraFragment.this.displayImageView.getDrawable()).getBitmap());
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        public void onClick(View view) {
            Rect rect;
            int maskType = CameraFragment.this.cropMaskView.getMaskType();
            if (maskType == 1 || maskType == 2 || maskType == 11) {
                rect = CameraFragment.this.cropMaskView.getFrameRect();
            } else {
                rect = CameraFragment.this.overlayView.getFrameRect();
            }
            CameraFragment.this.generateImage(CameraFragment.this.cropView.crop(rect));
            CameraFragment.this.ocrUBC("RecogButton_clk");
            if (CameraFragment.this.overlayView.getIsMove()) {
                CameraFragment.this.ocrUBC("Adjust");
            }
        }
    }

    public class pf implements View.OnClickListener {
        public pf() {
        }

        public void onClick(View view) {
            if (CameraFragment.this.getActivity() != null && !CameraFragment.this.getActivity().isFinishing() && CameraFragment.this.isAdded()) {
                CameraFragment.this.getActivity().setResult(0);
                CameraFragment.this.getActivity().finish();
            }
        }
    }

    public class qw extends fe.mmm.qw.a.uk.rg {
        public final /* synthetic */ Bitmap xxx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public qw(String str, Bitmap bitmap) {
            super(str);
            this.xxx = bitmap;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[SYNTHETIC, Splitter:B:15:0x002f] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[SYNTHETIC, Splitter:B:23:0x0046] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void when() {
            /*
                r6 = this;
                java.lang.String r0 = "CameraFragment"
                r1 = 0
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0022, all -> 0x001d }
                com.tera.scan.scanner.ui.camera.CameraFragment r3 = com.tera.scan.scanner.ui.camera.CameraFragment.this     // Catch:{ IOException -> 0x0022, all -> 0x001d }
                java.io.File r3 = r3.outputFile     // Catch:{ IOException -> 0x0022, all -> 0x001d }
                r2.<init>(r3)     // Catch:{ IOException -> 0x0022, all -> 0x001d }
                android.graphics.Bitmap r1 = r6.xxx     // Catch:{ IOException -> 0x001b }
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x001b }
                r4 = 100
                r1.compress(r3, r4, r2)     // Catch:{ IOException -> 0x001b }
                r2.close()     // Catch:{ IOException -> 0x0033 }
                goto L_0x003b
            L_0x001b:
                r1 = move-exception
                goto L_0x0026
            L_0x001d:
                r2 = move-exception
                r5 = r2
                r2 = r1
                r1 = r5
                goto L_0x0044
            L_0x0022:
                r2 = move-exception
                r5 = r2
                r2 = r1
                r1 = r5
            L_0x0026:
                java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x0043 }
                fe.mmm.qw.i.qw.th(r0, r3, r1)     // Catch:{ all -> 0x0043 }
                if (r2 == 0) goto L_0x003b
                r2.close()     // Catch:{ IOException -> 0x0033 }
                goto L_0x003b
            L_0x0033:
                r1 = move-exception
                java.lang.String r2 = r1.getMessage()
                fe.mmm.qw.i.qw.th(r0, r2, r1)
            L_0x003b:
                com.tera.scan.scanner.ui.camera.CameraFragment r0 = com.tera.scan.scanner.ui.camera.CameraFragment.this
                java.lang.String r1 = "back_photo"
                r0.closeActivity(r1)
                return
            L_0x0043:
                r1 = move-exception
            L_0x0044:
                if (r2 == 0) goto L_0x0052
                r2.close()     // Catch:{ IOException -> 0x004a }
                goto L_0x0052
            L_0x004a:
                r2 = move-exception
                java.lang.String r3 = r2.getMessage()
                fe.mmm.qw.i.qw.th(r0, r3, r2)
            L_0x0052:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ui.camera.CameraFragment.qw.when():void");
        }
    }

    public class rg implements View.OnClickListener {
        public rg() {
        }

        public void onClick(View view) {
            if (CameraFragment.this.getActivity() != null && CameraFragment.this.getContext() != null) {
                if (ContextCompat.checkSelfPermission(CameraFragment.this.getContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0 || Build.VERSION.SDK_INT < 16) {
                    Intent intent = new Intent("android.intent.action.PICK");
                    intent.setType("image/*");
                    CameraFragment.this.startActivityForResult(intent, 100);
                    return;
                }
                ActivityCompat.requestPermissions(CameraFragment.this.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 801);
            }
        }
    }

    public class th implements View.OnClickListener {
        public th() {
        }

        public void onClick(View view) {
            if (CameraFragment.this.cameraView.getCameraControl().uk() == 0) {
                CameraFragment.this.cameraView.getCameraControl().ad(1);
            } else {
                CameraFragment.this.cameraView.getCameraControl().ad(0);
            }
            CameraFragment.this.updateFlashMode();
        }
    }

    public class uk implements CameraView.de {

        public class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ Bitmap f7317ad;

            public qw(Bitmap bitmap) {
                this.f7317ad = bitmap;
            }

            public void run() {
                CameraFragment.this.takePictureContainer.setVisibility(4);
                if (CameraFragment.this.isNotNeedCrop) {
                    fe.mmm.qw.i.qw.ad(CameraFragment.TAG, "拍照后结束页面");
                    CameraFragment.this.cameraView.getCameraControl().pause();
                    CameraFragment.this.updateFlashMode();
                    CameraFragment.this.generateImage(this.f7317ad);
                    return;
                }
                fe.mmm.qw.i.qw.ad(CameraFragment.TAG, "拍照后跳剪切页面");
                CameraFragment.this.cropView.setFilePath(CameraFragment.this.outputFile.getAbsolutePath());
                CameraFragment.this.showCrop();
            }
        }

        public uk() {
        }

        public void qw(Bitmap bitmap) {
            CameraFragment.this.handler.post(new qw(bitmap));
        }
    }

    public class yj implements View.OnClickListener {
        public yj() {
        }

        public void onClick(View view) {
            CameraFragment.this.cameraView.takePicture(CameraFragment.this.outputFile, CameraFragment.this.takePictureCallback);
        }
    }

    /* access modifiers changed from: private */
    public void closeActivity(String str) {
        Intent intent = new Intent();
        intent.putExtra("contentType", this.contentType);
        intent.putExtra("outputFilePath", this.outputPath);
        intent.putExtra(IMAGE_TYPE_BACK, str);
        if (getActivity() != null && !getActivity().isFinishing() && isAdded()) {
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    /* access modifiers changed from: private */
    public void generateImage(Bitmap bitmap) {
        new qw("CameraFragmentgenerateImage", bitmap).mmm();
    }

    private String getRealPathFromURI(Uri uri) {
        if (getActivity() == null || getActivity().isFinishing() || !isAdded()) {
            return null;
        }
        Cursor query = getActivity().getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return uri.getPath();
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("_data"));
        query.close();
        return string;
    }

    private void initBottomTab(View view) {
        this.mBottom = (LinearLayout) view.findViewById(R.id.ocr_bottom_tab);
        if (TextUtils.equals(this.contentType, CONTENT_TYPE_OCR)) {
            this.mBottom.setVisibility(0);
        }
    }

    private void initConfirmResultContainer(View view) {
        this.confirmResultContainer = (OCRCameraLayout) view.findViewById(R.id.confirm_result_container);
        this.displayImageView = (ImageView) view.findViewById(R.id.display_image_view);
        this.confirmResultContainer.findViewById(R.id.confirm_button).setOnClickListener(this.confirmButtonOnClickListener);
        this.confirmResultContainer.findViewById(R.id.cancel_button).setOnClickListener(this.confirmCancelButtonOnClickListener);
    }

    private void initCropContainer(View view) {
        OCRCameraLayout oCRCameraLayout = (OCRCameraLayout) view.findViewById(R.id.crop_container);
        this.cropContainer = oCRCameraLayout;
        oCRCameraLayout.setRatioType(this.mRatio);
        this.cropView = (CropView) view.findViewById(R.id.crop_view);
        FrameOverlayView frameOverlayView = (FrameOverlayView) view.findViewById(R.id.overlay_view);
        this.overlayView = frameOverlayView;
        frameOverlayView.setRatioType(this.mRatio);
        this.cropMaskView = (MaskView) view.findViewById(R.id.crop_mask_view);
        this.cropContainer.findViewById(R.id.confirm_button).setOnClickListener(this.cropConfirmButtonListener);
        this.cropContainer.findViewById(R.id.cancel_button).setOnClickListener(this.cropCancelButtonListener);
        this.cropContainer.findViewById(R.id.rotate_button).setOnClickListener(this.rotateButtonOnClickListener);
    }

    private void initData() {
        if (getArguments() != null) {
            this.outputPath = getArguments().getString("outputFilePath");
            this.contentType = getArguments().getString("contentType");
            this.isNeedCameraFull = getArguments().getBoolean(IS_NEED_CAMERA_FULL);
            this.isNotNeedCrop = getArguments().getBoolean(IS_NOT_NEED_JUMP_CROP);
            this.isNeedLightButton = getArguments().getBoolean(IS_NEED_LIGHT);
            this.isNeedNineLine = getArguments().getBoolean(IS_NEED_NINE_LINE);
            this.isNeedEnterLottie = getArguments().getBoolean(IS_NEED_ENTER_LOTTIE);
            this.mRatio = getArguments().getInt(RATION_TYPE);
        }
    }

    private void initParams() {
        if (getActivity() != null && !getActivity().isFinishing() && isAdded()) {
            if (this.outputPath != null) {
                this.outputFile = new File(this.outputPath);
            }
            if (this.contentType == null) {
                this.contentType = "general";
            }
            fe.mmm.qw.i.qw.ad(TAG, "CameraFragment 初始化 outputPath = " + this.outputPath);
            fe.mmm.qw.i.qw.ad(TAG, "CameraFragment 初始化 contentType = " + this.contentType);
            String str = this.contentType;
            char c = 65535;
            int i2 = 0;
            switch (str.hashCode()) {
                case -1859618964:
                    if (str.equals("bankCard")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1070661090:
                    if (str.equals("IDCardFront")) {
                        c = 0;
                        break;
                    }
                    break;
                case -80148248:
                    if (str.equals("general")) {
                        c = 4;
                        break;
                    }
                    break;
                case 109854:
                    if (str.equals(CONTENT_TYPE_OCR)) {
                        c = 3;
                        break;
                    }
                    break;
                case 242421330:
                    if (str.equals("IDCardBack")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                this.overlayView.setVisibility(4);
                i2 = 1;
            } else if (c == 1) {
                this.overlayView.setVisibility(4);
                i2 = 2;
            } else if (c == 2) {
                i2 = 11;
                this.overlayView.setVisibility(4);
            } else if (c != 3) {
                this.cropMaskView.setVisibility(4);
            } else {
                i2 = 12;
                this.cropMaskView.setVisibility(4);
            }
            this.cameraView.setMaskType(i2);
            this.cropMaskView.setMaskType(i2);
        }
    }

    private void initTakePictureContainer(View view) {
        OCRCameraLayout oCRCameraLayout = (OCRCameraLayout) view.findViewById(R.id.take_picture_container);
        this.takePictureContainer = oCRCameraLayout;
        oCRCameraLayout.setIsNeedCameraFull(this.isNeedCameraFull);
        this.takePictureContainer.setRatioType(this.mRatio);
        CameraView cameraView2 = (CameraView) view.findViewById(R.id.camera_view);
        this.cameraView = cameraView2;
        cameraView2.setIShowNineLine(this.isNeedNineLine);
        this.cameraView.isNeedEnterLottie(this.isNeedEnterLottie);
        this.cameraView.startEnterLottie();
        this.cameraView.getCameraControl().de(this.permissionCallback);
        view.findViewById(R.id.album_button).setOnClickListener(this.albumButtonOnClickListener);
        view.findViewById(R.id.take_photo_button).setOnClickListener(this.takeButtonOnClickListener);
        view.findViewById(R.id.close_button).setOnClickListener(this.closeButtonOnClickListener);
        ImageView imageView = (ImageView) view.findViewById(R.id.light_button);
        this.lightButton = imageView;
        imageView.setOnClickListener(this.lightButtonOnClickListener);
        if (this.isNeedLightButton) {
            this.lightButton.setVisibility(0);
        } else {
            this.lightButton.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void ocrUBC(String str) {
    }

    private void setOrientation(Configuration configuration) {
        if (getActivity() != null && !getActivity().isFinishing() && isAdded()) {
            int rotation = getActivity().getWindowManager().getDefaultDisplay().getRotation();
            fe.mmm.qw.i.qw.ad(TAG, ", Camera2Control orientation = " + configuration.orientation + ", rotation =" + rotation + ", requestorientation = " + getActivity().getRequestedOrientation());
            int i2 = configuration.orientation;
            int i3 = 1;
            int i4 = 0;
            if (i2 != 1) {
                if (i2 != 2) {
                    this.cameraView.setOrientation(0);
                } else {
                    i4 = (rotation == 0 || rotation == 1) ? 90 : 270;
                    this.cameraView.setOrientation(i4);
                    this.takePictureContainer.setOrientation(i3);
                    this.cropContainer.setOrientation(i3);
                    this.confirmResultContainer.setOrientation(i3);
                }
            }
            i3 = 0;
            this.cameraView.setOrientation(i4);
            this.takePictureContainer.setOrientation(i3);
            this.cropContainer.setOrientation(i3);
            this.confirmResultContainer.setOrientation(i3);
        }
    }

    /* access modifiers changed from: private */
    public void showCrop() {
        this.cameraView.getCameraControl().pause();
        this.cameraView.hideNineLine();
        updateFlashMode();
        this.takePictureContainer.setVisibility(4);
        this.confirmResultContainer.setVisibility(4);
        this.cropContainer.setVisibility(0);
        if (TextUtils.equals(this.contentType, CONTENT_TYPE_OCR)) {
            this.mBottom.setVisibility(8);
        }
    }

    private void showResultConfirm() {
        this.cameraView.getCameraControl().pause();
        updateFlashMode();
        this.takePictureContainer.setVisibility(4);
        this.confirmResultContainer.setVisibility(0);
        this.cropContainer.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void showTakePicture() {
        this.cameraView.getCameraControl().th();
        this.cameraView.showNineLine();
        updateFlashMode();
        this.takePictureContainer.setVisibility(0);
        this.confirmResultContainer.setVisibility(4);
        this.cropContainer.setVisibility(4);
        if (TextUtils.equals(this.contentType, CONTENT_TYPE_OCR)) {
            this.mBottom.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void updateFlashMode() {
        if (this.cameraView.getCameraControl().uk() == 1) {
            this.lightButton.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.lightButton.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100 && i3 == -1) {
            String realPathFromURI = getRealPathFromURI(intent.getData());
            if (this.isNotNeedCrop) {
                this.outputPath = realPathFromURI;
                closeActivity(BACK_GALLERY);
                fe.mmm.qw.i.qw.ad(TAG, "从相册选择后关闭页面");
                return;
            }
            fe.mmm.qw.i.qw.ad(TAG, "从相册选择后跳转剪切页面");
            this.cropView.setFilePath(realPathFromURI);
            showCrop();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setOrientation(configuration);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(R.layout.bd_ocr_activity_camera, (ViewGroup) null, false);
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 800) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(getContext(), R.string.camera_permission_required, 1).show();
            } else {
                this.cameraView.getCameraControl().qw();
            }
        }
    }

    public void onStart() {
        super.onStart();
        this.cameraView.start();
    }

    public void onStop() {
        super.onStop();
        this.cameraView.stop();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
        initTakePictureContainer(view);
        initCropContainer(view);
        initConfirmResultContainer(view);
        setOrientation(getResources().getConfiguration());
        initParams();
        initBottomTab(view);
    }
}
