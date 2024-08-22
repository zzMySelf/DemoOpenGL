package com.tera.scan.scanner.ui.camera;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.baidu.aiscan.R;
import com.tera.scan.scanner.ui.camera.CameraView;
import com.tera.scan.scanner.ui.crop.CropView;
import com.tera.scan.scanner.ui.crop.FrameOverlayView;
import java.io.File;

public class CameraActivity extends Activity {
    public static final String CONTENT_TYPE_BANK_CARD = "bankCard";
    public static final String CONTENT_TYPE_GENERAL = "general";
    public static final String CONTENT_TYPE_ID_CARD_BACK = "IDCardBack";
    public static final String CONTENT_TYPE_ID_CARD_FRONT = "IDCardFront";
    public static final String KEY_CONTENT_TYPE = "contentType";
    public static final String KEY_OUTPUT_FILE_PATH = "outputFilePath";
    public static final int PERMISSIONS_EXTERNAL_STORAGE = 801;
    public static final int PERMISSIONS_REQUEST_CAMERA = 800;
    public static final int REQUEST_CODE_PICK_IMAGE = 100;
    public static final String TAG = "CameraActivity";
    public View.OnClickListener albumButtonOnClickListener = new fe();
    public CameraView cameraView;
    public View.OnClickListener closeButtonOnClickListener = new o();
    public View.OnClickListener confirmButtonOnClickListener = new pf();
    public View.OnClickListener confirmCancelButtonOnClickListener = new qw();
    public OCRCameraLayout confirmResultContainer;
    public String contentType;
    public View.OnClickListener cropCancelButtonListener = new uk();
    public View.OnClickListener cropConfirmButtonListener = new i();
    public OCRCameraLayout cropContainer;
    public MaskView cropMaskView;
    public CropView cropView;
    public ImageView displayImageView;
    public Handler handler = new Handler();
    public ImageView lightButton;
    public View.OnClickListener lightButtonOnClickListener = new rg();
    public File outputFile;
    public String outputPath;
    public FrameOverlayView overlayView;
    public PermissionCallback permissionCallback = new de();
    public View.OnClickListener rotateButtonOnClickListener = new ad();
    public View.OnClickListener takeButtonOnClickListener = new th();
    public CameraView.de takePictureCallback = new yj();
    public OCRCameraLayout takePictureContainer;

    public class ad implements View.OnClickListener {
        public ad() {
        }

        public void onClick(View view) {
            CameraActivity.this.cropView.rotate(90);
        }
    }

    public class de implements PermissionCallback {
        public de() {
        }

        public boolean qw() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{"android.permission.CAMERA"}, 800);
            return false;
        }
    }

    public class fe implements View.OnClickListener {
        public fe() {
        }

        public void onClick(View view) {
            if (ContextCompat.checkSelfPermission(CameraActivity.this.getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0 || Build.VERSION.SDK_INT < 16) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                CameraActivity.this.startActivityForResult(intent, 100);
                return;
            }
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 801);
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            Rect rect;
            int maskType = CameraActivity.this.cropMaskView.getMaskType();
            if (maskType == 1 || maskType == 2 || maskType == 11) {
                rect = CameraActivity.this.cropMaskView.getFrameRect();
            } else {
                rect = CameraActivity.this.overlayView.getFrameRect();
            }
            CameraActivity.this.displayImageView.setImageBitmap(CameraActivity.this.cropView.crop(rect));
            CameraActivity.this.showResultConfirm();
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        public void onClick(View view) {
            CameraActivity.this.setResult(0);
            CameraActivity.this.finish();
        }
    }

    public class pf implements View.OnClickListener {

        public class qw extends fe.mmm.qw.a.uk.rg {
            public qw(String str) {
                super(str);
            }

            /* JADX WARNING: Removed duplicated region for block: B:15:0x0041 A[SYNTHETIC, Splitter:B:15:0x0041] */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x007f A[SYNTHETIC, Splitter:B:23:0x007f] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void when() {
                /*
                    r6 = this;
                    java.lang.String r0 = "CameraActivity"
                    r1 = 0
                    java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0034, all -> 0x002f }
                    com.tera.scan.scanner.ui.camera.CameraActivity$pf r3 = com.tera.scan.scanner.ui.camera.CameraActivity.pf.this     // Catch:{ IOException -> 0x0034, all -> 0x002f }
                    com.tera.scan.scanner.ui.camera.CameraActivity r3 = com.tera.scan.scanner.ui.camera.CameraActivity.this     // Catch:{ IOException -> 0x0034, all -> 0x002f }
                    java.io.File r3 = r3.outputFile     // Catch:{ IOException -> 0x0034, all -> 0x002f }
                    r2.<init>(r3)     // Catch:{ IOException -> 0x0034, all -> 0x002f }
                    com.tera.scan.scanner.ui.camera.CameraActivity$pf r1 = com.tera.scan.scanner.ui.camera.CameraActivity.pf.this     // Catch:{ IOException -> 0x002d }
                    com.tera.scan.scanner.ui.camera.CameraActivity r1 = com.tera.scan.scanner.ui.camera.CameraActivity.this     // Catch:{ IOException -> 0x002d }
                    android.widget.ImageView r1 = r1.displayImageView     // Catch:{ IOException -> 0x002d }
                    android.graphics.drawable.Drawable r1 = r1.getDrawable()     // Catch:{ IOException -> 0x002d }
                    android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1     // Catch:{ IOException -> 0x002d }
                    android.graphics.Bitmap r1 = r1.getBitmap()     // Catch:{ IOException -> 0x002d }
                    android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x002d }
                    r4 = 100
                    r1.compress(r3, r4, r2)     // Catch:{ IOException -> 0x002d }
                    r2.close()     // Catch:{ IOException -> 0x0045 }
                    goto L_0x004d
                L_0x002d:
                    r1 = move-exception
                    goto L_0x0038
                L_0x002f:
                    r2 = move-exception
                    r5 = r2
                    r2 = r1
                    r1 = r5
                    goto L_0x007d
                L_0x0034:
                    r2 = move-exception
                    r5 = r2
                    r2 = r1
                    r1 = r5
                L_0x0038:
                    java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x007c }
                    fe.mmm.qw.i.qw.th(r0, r3, r1)     // Catch:{ all -> 0x007c }
                    if (r2 == 0) goto L_0x004d
                    r2.close()     // Catch:{ IOException -> 0x0045 }
                    goto L_0x004d
                L_0x0045:
                    r1 = move-exception
                    java.lang.String r2 = r1.getMessage()
                    fe.mmm.qw.i.qw.th(r0, r2, r1)
                L_0x004d:
                    android.content.Intent r0 = new android.content.Intent
                    r0.<init>()
                    com.tera.scan.scanner.ui.camera.CameraActivity$pf r1 = com.tera.scan.scanner.ui.camera.CameraActivity.pf.this
                    com.tera.scan.scanner.ui.camera.CameraActivity r1 = com.tera.scan.scanner.ui.camera.CameraActivity.this
                    java.lang.String r1 = r1.contentType
                    java.lang.String r2 = "contentType"
                    r0.putExtra(r2, r1)
                    com.tera.scan.scanner.ui.camera.CameraActivity$pf r1 = com.tera.scan.scanner.ui.camera.CameraActivity.pf.this
                    com.tera.scan.scanner.ui.camera.CameraActivity r1 = com.tera.scan.scanner.ui.camera.CameraActivity.this
                    java.lang.String r1 = r1.outputPath
                    java.lang.String r2 = "outputFilePath"
                    r0.putExtra(r2, r1)
                    com.tera.scan.scanner.ui.camera.CameraActivity$pf r1 = com.tera.scan.scanner.ui.camera.CameraActivity.pf.this
                    com.tera.scan.scanner.ui.camera.CameraActivity r1 = com.tera.scan.scanner.ui.camera.CameraActivity.this
                    r2 = -1
                    r1.setResult(r2, r0)
                    com.tera.scan.scanner.ui.camera.CameraActivity$pf r0 = com.tera.scan.scanner.ui.camera.CameraActivity.pf.this
                    com.tera.scan.scanner.ui.camera.CameraActivity r0 = com.tera.scan.scanner.ui.camera.CameraActivity.this
                    r0.finish()
                    return
                L_0x007c:
                    r1 = move-exception
                L_0x007d:
                    if (r2 == 0) goto L_0x008b
                    r2.close()     // Catch:{ IOException -> 0x0083 }
                    goto L_0x008b
                L_0x0083:
                    r2 = move-exception
                    java.lang.String r3 = r2.getMessage()
                    fe.mmm.qw.i.qw.th(r0, r3, r2)
                L_0x008b:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ui.camera.CameraActivity.pf.qw.when():void");
            }
        }

        public pf() {
        }

        public void onClick(View view) {
            new qw("CameraActivityconfirmButtonOnClickListener").mmm();
        }
    }

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            CameraActivity.this.displayImageView.setImageBitmap((Bitmap) null);
            CameraActivity.this.showTakePicture();
        }
    }

    public class rg implements View.OnClickListener {
        public rg() {
        }

        public void onClick(View view) {
            if (CameraActivity.this.cameraView.getCameraControl().uk() == 0) {
                CameraActivity.this.cameraView.getCameraControl().ad(1);
            } else {
                CameraActivity.this.cameraView.getCameraControl().ad(0);
            }
            CameraActivity.this.updateFlashMode();
        }
    }

    public class th implements View.OnClickListener {
        public th() {
        }

        public void onClick(View view) {
            CameraActivity.this.cameraView.takePicture(CameraActivity.this.outputFile, CameraActivity.this.takePictureCallback);
        }
    }

    public class uk implements View.OnClickListener {
        public uk() {
        }

        public void onClick(View view) {
            CameraActivity.this.cropView.setFilePath((String) null);
            CameraActivity.this.showTakePicture();
        }
    }

    public class yj implements CameraView.de {

        public class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ Bitmap f7307ad;

            public qw(Bitmap bitmap) {
                this.f7307ad = bitmap;
            }

            public void run() {
                CameraActivity.this.takePictureContainer.setVisibility(4);
                if (CameraActivity.this.cropMaskView.getMaskType() == 0) {
                    CameraActivity.this.cropView.setFilePath(CameraActivity.this.outputFile.getAbsolutePath());
                    CameraActivity.this.showCrop();
                    return;
                }
                CameraActivity.this.displayImageView.setImageBitmap(this.f7307ad);
                CameraActivity.this.showResultConfirm();
            }
        }

        public yj() {
        }

        public void qw(Bitmap bitmap) {
            CameraActivity.this.handler.post(new qw(bitmap));
        }
    }

    private String getRealPathFromURI(Uri uri) {
        Cursor query = getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return uri.getPath();
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("_data"));
        query.close();
        return string;
    }

    private void initParams() {
        String stringExtra = getIntent().getStringExtra("outputFilePath");
        this.outputPath = stringExtra;
        if (stringExtra != null) {
            this.outputFile = new File(this.outputPath);
        }
        String stringExtra2 = getIntent().getStringExtra("contentType");
        this.contentType = stringExtra2;
        if (stringExtra2 == null) {
            this.contentType = "general";
        }
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
        } else if (c != 2) {
            this.cropMaskView.setVisibility(4);
        } else {
            i2 = 11;
            this.overlayView.setVisibility(4);
        }
        this.cameraView.setMaskType(i2);
        this.cropMaskView.setMaskType(i2);
    }

    private void setOrientation(Configuration configuration) {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        fe.mmm.qw.i.qw.ad(TAG, ", Camera2Control orientation = " + configuration.orientation + ", rotation =" + rotation + ", requestorientation = " + getRequestedOrientation());
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

    /* access modifiers changed from: private */
    public void showCrop() {
        this.cameraView.getCameraControl().pause();
        updateFlashMode();
        this.takePictureContainer.setVisibility(4);
        this.confirmResultContainer.setVisibility(4);
        this.cropContainer.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void showResultConfirm() {
        this.cameraView.getCameraControl().pause();
        updateFlashMode();
        this.takePictureContainer.setVisibility(4);
        this.confirmResultContainer.setVisibility(0);
        this.cropContainer.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void showTakePicture() {
        this.cameraView.getCameraControl().th();
        updateFlashMode();
        this.takePictureContainer.setVisibility(0);
        this.confirmResultContainer.setVisibility(4);
        this.cropContainer.setVisibility(4);
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
            this.cropView.setFilePath(getRealPathFromURI(intent.getData()));
            showCrop();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setOrientation(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.takePictureContainer = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.confirmResultContainer = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        CameraView cameraView2 = (CameraView) findViewById(R.id.camera_view);
        this.cameraView = cameraView2;
        cameraView2.getCameraControl().de(this.permissionCallback);
        ImageView imageView = (ImageView) findViewById(R.id.light_button);
        this.lightButton = imageView;
        imageView.setOnClickListener(this.lightButtonOnClickListener);
        findViewById(R.id.album_button).setOnClickListener(this.albumButtonOnClickListener);
        findViewById(R.id.take_photo_button).setOnClickListener(this.takeButtonOnClickListener);
        findViewById(R.id.close_button).setOnClickListener(this.closeButtonOnClickListener);
        this.displayImageView = (ImageView) findViewById(R.id.display_image_view);
        this.confirmResultContainer.findViewById(R.id.confirm_button).setOnClickListener(this.confirmButtonOnClickListener);
        this.confirmResultContainer.findViewById(R.id.cancel_button).setOnClickListener(this.confirmCancelButtonOnClickListener);
        findViewById(R.id.rotate_button).setOnClickListener(this.rotateButtonOnClickListener);
        this.cropView = (CropView) findViewById(R.id.crop_view);
        this.cropContainer = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.overlayView = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.cropContainer.findViewById(R.id.confirm_button).setOnClickListener(this.cropConfirmButtonListener);
        this.cropMaskView = (MaskView) this.cropContainer.findViewById(R.id.crop_mask_view);
        this.cropContainer.findViewById(R.id.cancel_button).setOnClickListener(this.cropCancelButtonListener);
        setOrientation(getResources().getConfiguration());
        initParams();
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 800) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(getApplicationContext(), R.string.camera_permission_required, 1).show();
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
}
