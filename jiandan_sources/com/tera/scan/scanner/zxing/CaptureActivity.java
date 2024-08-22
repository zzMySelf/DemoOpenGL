package com.tera.scan.scanner.zxing;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.baidu.aiscan.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import fe.mmm.qw.tt.th.ad;
import fe.mmm.qw.tt.th.rg;
import fe.mmm.qw.tt.th.th;
import fe.mmm.qw.tt.th.uk.fe;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public final class CaptureActivity extends Activity implements SurfaceHolder.Callback {
    public static final int PERMISSIONS_REQUEST_CAMERA = 800;
    public static final String TAG = CaptureActivity.class.getSimpleName();
    public fe.mmm.qw.tt.th.qw ambientLightManager;
    public fe cameraManager;
    public String characterSet;
    public Collection<BarcodeFormat> decodeFormats;
    public CaptureActivityHandler handler;
    public boolean hasSurface;
    public th inactivityTimer;
    public Result savedResultToShow;
    public IntentSource source;
    public SurfaceHolder surfaceHolder;
    public ViewfinderView viewfinderView;

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        static {
            int[] iArr = new int[IntentSource.values().length];
            qw = iArr;
            try {
                iArr[IntentSource.NATIVE_APP_INTENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void decodeOrStoreSavedBitmap(Bitmap bitmap, Result result) {
        if (this.handler == null) {
            this.savedResultToShow = result;
            return;
        }
        if (result != null) {
            this.savedResultToShow = result;
        }
        Result result2 = this.savedResultToShow;
        if (result2 != null) {
            this.handler.sendMessage(Message.obtain(this.handler, R.id.decode_succeeded, result2));
        }
        this.savedResultToShow = null;
    }

    private void displayFrameworkBugMessageAndExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(getString(R.string.zxing_camera_failed));
        builder.setPositiveButton(R.string.know_it, new rg(this));
        builder.setOnCancelListener(new rg(this));
        builder.show();
    }

    public static void drawLine(Canvas canvas, Paint paint, ResultPoint resultPoint, ResultPoint resultPoint2, float f) {
        if (resultPoint != null && resultPoint2 != null) {
            canvas.drawLine(f * resultPoint.getX(), f * resultPoint.getY(), f * resultPoint2.getX(), f * resultPoint2.getY(), paint);
        }
    }

    private void drawResultPoints(Bitmap bitmap, float f, Result result) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints != null && resultPoints.length > 0) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(R.color.result_points));
            if (resultPoints.length == 2) {
                paint.setStrokeWidth(4.0f);
                drawLine(canvas, paint, resultPoints[0], resultPoints[1], f);
            } else if (resultPoints.length == 4 && (result.getBarcodeFormat() == BarcodeFormat.UPC_A || result.getBarcodeFormat() == BarcodeFormat.EAN_13)) {
                drawLine(canvas, paint, resultPoints[0], resultPoints[1], f);
                drawLine(canvas, paint, resultPoints[2], resultPoints[3], f);
            } else {
                paint.setStrokeWidth(10.0f);
                for (ResultPoint resultPoint : resultPoints) {
                    if (resultPoint != null) {
                        canvas.drawPoint(resultPoint.getX() * f, resultPoint.getY() * f, paint);
                    }
                }
            }
        }
    }

    private int getCurrentOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        return getResources().getConfiguration().orientation == 2 ? (rotation == 0 || rotation == 1) ? 0 : 8 : (rotation == 0 || rotation == 3) ? 1 : 9;
    }

    private void handleDecodeExternally(Result result, Bitmap bitmap) {
        if (bitmap != null) {
            this.viewfinderView.drawResultBitmap(bitmap);
        }
        if (qw.qw[this.source.ordinal()] == 1) {
            Intent intent = new Intent(getIntent().getAction());
            intent.addFlags(524288);
            intent.putExtra("SCAN_RESULT", result.toString());
            intent.putExtra("SCAN_RESULT_FORMAT", result.getBarcodeFormat().toString());
            byte[] rawBytes = result.getRawBytes();
            if (rawBytes != null && rawBytes.length > 0) {
                intent.putExtra("SCAN_RESULT_BYTES", rawBytes);
            }
            Map<ResultMetadataType, Object> resultMetadata = result.getResultMetadata();
            if (resultMetadata != null) {
                if (resultMetadata.containsKey(ResultMetadataType.UPC_EAN_EXTENSION)) {
                    intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", resultMetadata.get(ResultMetadataType.UPC_EAN_EXTENSION).toString());
                }
                Number number = (Number) resultMetadata.get(ResultMetadataType.ORIENTATION);
                if (number != null) {
                    intent.putExtra("SCAN_RESULT_ORIENTATION", number.intValue());
                }
                String str = (String) resultMetadata.get(ResultMetadataType.ERROR_CORRECTION_LEVEL);
                if (str != null) {
                    intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str);
                }
                Iterable<byte[]> iterable = (Iterable) resultMetadata.get(ResultMetadataType.BYTE_SEGMENTS);
                if (iterable != null) {
                    int i2 = 0;
                    for (byte[] putExtra : iterable) {
                        intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i2, putExtra);
                        i2++;
                    }
                }
            }
            sendReplyMessage(R.id.return_scan_result, intent, 0);
        }
    }

    private void initCamera(SurfaceHolder surfaceHolder2) {
        if (surfaceHolder2 == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        } else if (!this.cameraManager.th()) {
            try {
                this.cameraManager.yj(surfaceHolder2);
                if (this.handler == null) {
                    this.handler = new CaptureActivityHandler(this, (Collection<BarcodeFormat>) null, (Map<DecodeHintType, ?>) null, this.characterSet, this.cameraManager);
                }
                decodeOrStoreSavedBitmap((Bitmap) null, (Result) null);
            } catch (IOException unused) {
                displayFrameworkBugMessageAndExit();
            } catch (RuntimeException unused2) {
                displayFrameworkBugMessageAndExit();
            }
        }
    }

    private void resetStatusView() {
        this.viewfinderView.setVisibility(0);
    }

    private void sendReplyMessage(int i2, Object obj, long j) {
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            Message obtain = Message.obtain(captureActivityHandler, i2, obj);
            if (j > 0) {
                this.handler.sendMessageDelayed(obtain, j);
            } else {
                this.handler.sendMessage(obtain);
            }
        }
    }

    public void drawViewfinder() {
        this.viewfinderView.drawViewfinder();
    }

    public fe getCameraManager() {
        return this.cameraManager;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public ViewfinderView getViewfinderView() {
        return this.viewfinderView;
    }

    public void handleDecode(Result result, Bitmap bitmap, float f) {
        this.inactivityTimer.rg();
        if (bitmap != null) {
            drawResultPoints(bitmap, f, result);
        }
        if (qw.qw[this.source.ordinal()] == 1) {
            handleDecodeExternally(result, bitmap);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView(R.layout.capture);
        this.hasSurface = false;
        this.inactivityTimer = new th(this);
        this.ambientLightManager = new fe.mmm.qw.tt.th.qw(this);
    }

    public void onDestroy() {
        this.inactivityTimer.uk();
        super.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (!(i2 == 27 || i2 == 80)) {
                if (i2 == 24) {
                    this.cameraManager.o(true);
                } else if (i2 == 25) {
                    this.cameraManager.o(false);
                    return true;
                }
            }
            return true;
        } else if (this.source == IntentSource.NATIVE_APP_INTENT) {
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onPause() {
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.qw();
            this.handler = null;
        }
        this.inactivityTimer.th();
        this.ambientLightManager.ad();
        this.cameraManager.ad();
        if (!this.hasSurface) {
            this.surfaceHolder.removeCallback(this);
        }
        super.onPause();
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        SurfaceHolder surfaceHolder2;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 800) {
            if (iArr.length <= 0 || iArr[0] != 0 || !this.hasSurface || (surfaceHolder2 = this.surfaceHolder) == null) {
                displayFrameworkBugMessageAndExit();
            } else {
                initCamera(surfaceHolder2);
            }
        }
    }

    public void onResume() {
        super.onResume();
        this.cameraManager = new fe(getApplication());
        ViewfinderView viewfinderView2 = (ViewfinderView) findViewById(R.id.viewfinder_view);
        this.viewfinderView = viewfinderView2;
        viewfinderView2.setCameraManager(this.cameraManager);
        this.handler = null;
        PreferenceManager.getDefaultSharedPreferences(this);
        setRequestedOrientation(getCurrentOrientation());
        resetStatusView();
        this.ambientLightManager.qw(this.cameraManager);
        this.inactivityTimer.yj();
        Intent intent = getIntent();
        this.source = IntentSource.NATIVE_APP_INTENT;
        this.decodeFormats = ad.qw(intent);
        this.characterSet = intent.getStringExtra("CHARACTER_SET");
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.preview_view)).getHolder();
        this.surfaceHolder = holder;
        if (!this.hasSurface) {
            holder.addCallback(this);
        } else if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 800);
        } else {
            initCamera(this.surfaceHolder);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder2, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder2) {
        if (!this.hasSurface) {
            this.hasSurface = true;
            this.surfaceHolder = surfaceHolder2;
            if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.CAMERA") != 0) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 800);
            } else {
                initCamera(surfaceHolder2);
            }
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder2) {
        this.hasSurface = false;
    }
}
