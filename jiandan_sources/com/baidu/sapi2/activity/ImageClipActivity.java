package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.baidu.aiscan.R;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.result.GetCertStatusResult;
import com.baidu.sapi2.utils.FileUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.UIOrientation;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.ZoomImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageClipActivity extends Activity {
    public static final int BUSSINESS_FROM_INVOICE_BUILD = 1;
    public static final int BUSSINESS_ID_CARD_OCR = 2;
    public static final int BUSSINESS_SET_PORTRAIT = 0;
    public static final int DEFAULT_CLIP_IMAGE_MAX_SIDE_LENGTH = 1000;
    public static final int DEFAULT_UPLOAD_IMAGE_MAX_SIZE = 512;
    public static String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_PARAM_FROM_BUSINESS = "extra_business_from";
    public static final String EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE = "extra_upload_image_max_size";
    public static final int INVALID_ANIM = 0;
    public static final int UPLOAD_IMAGE_HEIGHT = 160;
    public static final int UPLOAD_IMAGE_WIDTH = 160;
    public static final String j = ImageClipActivity.class.getSimpleName();
    public static final String k = "com.android.providers.media.documents";
    public static final String l = "com.android.providers.downloads.documents";
    public static final String m = "com.android.externalstorage.documents";
    public static final String n = "content://downloads/public_downloads";
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e;
    public int f;
    public String g;
    public ClipBoxView h;

    /* renamed from: i  reason: collision with root package name */
    public ZoomImageView f954i;

    private void d() {
        if (this.c != 0 || this.d != 0) {
            overridePendingTransition(this.c, this.d);
            this.c = 0;
            this.d = 0;
        }
    }

    public void finish() {
        super.finish();
        d();
    }

    public void lockScreenOrientation() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28 || i2 <= 25) {
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration == null || sapiConfiguration.getUIOrientation() == null) {
                setRequestedOrientation(1);
                return;
            }
            UIOrientation uIOrientation = sapiConfiguration.getUIOrientation();
            if (uIOrientation == UIOrientation.SCREEN_ORIENTATION_LANDSCAPE) {
                setRequestedOrientation(0);
            } else if (uIOrientation == UIOrientation.SCREEN_ORIENTATION_USER) {
                setRequestedOrientation(2);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            setContentView(R.layout.layout_sapi_sdk_image_clip_land);
        } else {
            setContentView(R.layout.layout_sapi_sdk_image_clip);
        }
        b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lockScreenOrientation();
        if (getResources().getConfiguration().orientation == 2) {
            setContentView(R.layout.layout_sapi_sdk_image_clip_land);
        } else {
            setContentView(R.layout.layout_sapi_sdk_image_clip);
        }
        b();
    }

    public void onDestroy() {
        super.onDestroy();
        ClipBoxView.b();
        ZoomImageView.c();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c();
    }

    public Bitmap operateBitmap(String str) {
        Bitmap a2 = a(str);
        if (a2 == null) {
            return null;
        }
        float f2 = 0.0f;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                f2 = 180.0f;
            } else if (attributeInt == 6) {
                f2 = 90.0f;
            } else if (attributeInt == 8) {
                f2 = 270.0f;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(f2, (float) (a2.getWidth() / 2), (float) (a2.getHeight() / 2));
        return Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
    }

    public void setPendingTransition(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
    }

    /* access modifiers changed from: private */
    @TargetApi(3)
    public void a() {
        Bitmap a2 = ZoomImageView.getInstance() == null ? null : ZoomImageView.getInstance().a();
        if (a2 != null && !a2.isRecycled()) {
            new AsyncTask<Bitmap, Void, byte[]>() {
                public byte[] doInBackground(Bitmap... bitmapArr) {
                    int i2;
                    if (bitmapArr[0] == null || bitmapArr[0].isRecycled()) {
                        return null;
                    }
                    int i3 = 160;
                    if (ImageClipActivity.this.e != 0) {
                        i3 = bitmapArr[0].getWidth();
                        i2 = bitmapArr[0].getHeight();
                    } else {
                        i2 = 160;
                    }
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapArr[0], i3, i2, true);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int i4 = 100;
                    createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    while (byteArrayOutputStream.toByteArray().length > ImageClipActivity.this.f && i4 > 0 && i4 - 5 > 0) {
                        byteArrayOutputStream.reset();
                        createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                    }
                    if (createScaledBitmap != bitmapArr[0]) {
                        createScaledBitmap.recycle();
                    }
                    bitmapArr[0].recycle();
                    return byteArrayOutputStream.toByteArray();
                }

                public void onPostExecute(byte[] bArr) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray(ImageClipActivity.EXTRA_IMAGE, bArr);
                    intent.putExtras(bundle);
                    ImageClipActivity.this.setResult(-1, intent);
                    ImageClipActivity.this.finish();
                }
            }.execute(new Bitmap[]{a2});
        }
    }

    private void b() {
        this.e = getIntent().getIntExtra(EXTRA_PARAM_FROM_BUSINESS, 0);
        int intExtra = getIntent().getIntExtra(EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, 512);
        this.f = intExtra;
        if (intExtra <= 0) {
            this.f = 512;
        }
        this.f *= 1024;
        this.h = (ClipBoxView) findViewById(R.id.sapi_clip_box);
        this.f954i = (ZoomImageView) findViewById(R.id.sapi_background_picture);
        if (this.e == 1) {
            ClipBoxView clipBoxView = this.h;
            clipBoxView.E = ClipBoxView.H;
            clipBoxView.F = false;
        }
        if (this.e == 2) {
            ClipBoxView clipBoxView2 = this.h;
            clipBoxView2.E = ClipBoxView.H;
            clipBoxView2.F = false;
        }
        setPendingTransition(R.anim.sapi_sdk_slide_right_in, R.anim.sapi_sdk_slide_left_out, R.anim.sapi_sdk_slide_left_in, R.anim.sapi_sdk_slide_right_out);
        Button button = (Button) findViewById(R.id.sure_clip_btn);
        Button button2 = (Button) findViewById(R.id.cancel_clip_btn);
        if (Build.VERSION.SDK_INT >= 19) {
            b(getIntent());
        } else {
            a(getIntent());
        }
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageClipActivity.this.setResult(0);
                ImageClipActivity.this.finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageClipActivity.this.a();
            }
        });
    }

    private void c() {
        if (this.a != 0 || this.b != 0) {
            overridePendingTransition(this.a, this.b);
            this.a = 0;
            this.b = 0;
        }
    }

    private void a(Intent intent) {
        b(a(intent.getData(), (String) null));
    }

    private String a(Uri uri, String str) {
        String str2;
        Cursor query = getContentResolver().query(uri, (String[]) null, str, (String[]) null, (String) null);
        String str3 = null;
        if (query != null) {
            if (query.moveToFirst()) {
                if (query.getColumnIndex("_data") > -1) {
                    str2 = query.getString(query.getColumnIndex("_data"));
                } else {
                    str2 = a(getBaseContext(), uri);
                    this.g = str2;
                }
                str3 = str2;
            }
            query.close();
        }
        return str3;
    }

    @TargetApi(12)
    private Bitmap a(String str) {
        if (str == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i4 > i3) {
            i3 = i4;
        }
        while (i3 / i2 > 1000) {
            i2++;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i2;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeFile(str, options);
    }

    @TargetApi(19)
    private void b(Intent intent) {
        Uri data = intent.getData();
        String str = null;
        if (data != null) {
            if (DocumentsContract.isDocumentUri(this, data)) {
                String documentId = DocumentsContract.getDocumentId(data);
                if (k.equals(data.getAuthority())) {
                    str = a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(":")[1]);
                } else if (l.equals(data.getAuthority())) {
                    str = a(ContentUris.withAppendedId(Uri.parse(n), Long.valueOf(documentId).longValue()), (String) null);
                } else if (m.equals(data.getAuthority())) {
                    String[] split = documentId.split(":");
                    if (GetCertStatusResult.VALUE_PRIMARY_REAL_NAME.equalsIgnoreCase(split[0])) {
                        str = getExternalCacheDir() + "/" + split[1];
                    }
                }
            } else if ("content".equalsIgnoreCase(data.getScheme())) {
                str = a(data, (String) null);
            } else if ("file".equalsIgnoreCase(data.getScheme())) {
                str = data.getPath();
            }
        }
        b(str);
    }

    private String a(Context context, Uri uri) {
        String a2 = a(uri);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        File file = new File(context.getExternalCacheDir().getPath() + File.separator + "pass_temp_" + a2);
        a(context, uri, file);
        return file.getAbsolutePath();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r4 = r4.getPath();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(android.net.Uri r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r4 = r4.getPath()
            r1 = 47
            int r1 = r4.lastIndexOf(r1)
            r2 = -1
            if (r1 == r2) goto L_0x0017
            int r1 = r1 + 1
            java.lang.String r0 = r4.substring(r1)
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.activity.ImageClipActivity.a(android.net.Uri):java.lang.String");
    }

    private void a(Context context, Uri uri, File file) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                FileUtil.copy(openInputStream, fileOutputStream);
                openInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    private void b(String str) {
        Bitmap operateBitmap = operateBitmap(str);
        if (operateBitmap != null) {
            this.f954i.setImageBitmap(operateBitmap);
            if (!TextUtils.isEmpty(this.g)) {
                FileUtil.deleteFile(new File(this.g));
                return;
            }
            return;
        }
        Toast.makeText(this, "加载图片失败", 0).show();
    }
}
