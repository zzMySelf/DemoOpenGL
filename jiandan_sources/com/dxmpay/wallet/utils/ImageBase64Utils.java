package com.dxmpay.wallet.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Base64;
import com.dxmpay.apollon.imagemanager.ImageProcessor;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageBase64Utils {
    public static int JPEG_QUALITY = 70;
    public static final String TAG = "ImageBase64Utils";

    public class ImageBase64AsyncTask extends AsyncTask<String, Integer, String> {
        public Context mContext;
        public int mFixedWidth;
        public String mImagePath;
        public Uri mImageUri;
        public ImageBase64Listener mListener;
        public ParcelFileDescriptor mParcelFileDescriptor;
        public boolean mPrecise = false;
        public int mQuality;

        public ImageBase64AsyncTask(ImageBase64Listener imageBase64Listener, String str, int i2, int i3) {
            this.mListener = imageBase64Listener;
            this.mImagePath = str;
            this.mFixedWidth = i2;
            this.mQuality = i3;
            this.mParcelFileDescriptor = initFileDescriptorFromPath();
        }

        private ParcelFileDescriptor initFileDescriptonFromUri() {
            Context context = this.mContext;
            if (!(context == null || this.mImageUri == null)) {
                try {
                    return context.getContentResolver().openFileDescriptor(this.mImageUri, "r");
                } catch (FileNotFoundException e) {
                    LogUtil.e("ImageBase64Utils", e.getMessage(), e);
                }
            }
            return null;
        }

        private ParcelFileDescriptor initFileDescriptorFromPath() {
            if (!TextUtils.isEmpty(this.mImagePath)) {
                try {
                    return ParcelFileDescriptor.open(new File(this.mImagePath), 268435456);
                } catch (FileNotFoundException e) {
                    LogUtil.e("ImageBase64Utils", e.getMessage(), e);
                }
            }
            return null;
        }

        public String doInBackground(String... strArr) {
            int i2 = this.mFixedWidth;
            if (i2 <= 0) {
                return ImageBase64Utils.getOriginImageBase64(this.mParcelFileDescriptor, this.mQuality);
            }
            return ImageBase64Utils.getImageBase64(this.mParcelFileDescriptor, i2, this.mQuality);
        }

        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ImageBase64Listener imageBase64Listener = this.mListener;
            if (imageBase64Listener != null) {
                imageBase64Listener.onBase64Result(str);
            }
        }

        public ImageBase64AsyncTask(ImageBase64Listener imageBase64Listener, Context context, Uri uri, int i2, int i3) {
            this.mListener = imageBase64Listener;
            this.mImageUri = uri;
            this.mFixedWidth = i2;
            this.mQuality = i3;
            this.mContext = context;
            this.mParcelFileDescriptor = initFileDescriptonFromUri();
        }
    }

    public interface ImageBase64Listener {
        void onBase64Result(String str);
    }

    public static class SingletonHolder {
        public static ImageBase64Utils sInstance = new ImageBase64Utils();
    }

    public static ImageBase64Utils getInstance() {
        return SingletonHolder.sInstance;
    }

    public static String getOriginImageBase64(ParcelFileDescriptor parcelFileDescriptor, int i2) {
        if (parcelFileDescriptor == null) {
            return "";
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), (Rect) null, options);
            if (decodeFileDescriptor != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                decodeFileDescriptor.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                "compress size:\t" + byteArray.length + "\t\twidth" + decodeFileDescriptor.getWidth();
                decodeFileDescriptor.recycle();
                byteArrayOutputStream.close();
                "base64 size:\t" + (byteArray.length / 1024);
                String str = new String(Base64.encode(byteArray, 0, byteArray.length, 2));
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e) {
                    LogUtil.e("ImageBase64Utils", e.getMessage(), e);
                }
                return str;
            }
            try {
                parcelFileDescriptor.close();
                return "";
            } catch (IOException e2) {
                LogUtil.e("ImageBase64Utils", e2.getMessage(), e2);
                return "";
            }
        } catch (Throwable unused) {
            parcelFileDescriptor.close();
            return "";
        }
    }

    public void getImageBase64(String str, int i2, ImageBase64Listener imageBase64Listener) {
        new ImageBase64AsyncTask(imageBase64Listener, str, i2, JPEG_QUALITY).execute(new String[]{""});
    }

    public ImageBase64Utils() {
    }

    public void getImageBase64(Context context, Uri uri, int i2, ImageBase64Listener imageBase64Listener) {
        new ImageBase64AsyncTask(imageBase64Listener, context, uri, i2, JPEG_QUALITY).execute(new String[]{""});
    }

    public void getImageBase64(String str, int i2, int i3, ImageBase64Listener imageBase64Listener) {
        new ImageBase64AsyncTask(imageBase64Listener, str, i2, i3).execute(new String[]{""});
    }

    public void getImageBase64(Context context, Uri uri, int i2, int i3, ImageBase64Listener imageBase64Listener) {
        new ImageBase64AsyncTask(imageBase64Listener, context, uri, i2, i3).execute(new String[]{""});
    }

    public static String getImageBase64(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3) {
        if (parcelFileDescriptor == null) {
            return "";
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int qw = ImageProcessor.qw(options, i2, -1);
            options.inSampleSize = qw;
            options.inJustDecodeBounds = false;
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), (Rect) null, options);
            if (decodeFileDescriptor != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                decodeFileDescriptor.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                "compress size:\t" + byteArray.length + "\tsampleSize" + qw + "\twidth" + decodeFileDescriptor.getWidth();
                decodeFileDescriptor.recycle();
                byteArrayOutputStream.close();
                "base64 size:\t" + (byteArray.length / 1024);
                String str = new String(Base64.encode(byteArray, 0, byteArray.length, 2));
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e) {
                    LogUtil.e("ImageBase64Utils", e.getMessage(), e);
                }
                return str;
            }
            try {
                parcelFileDescriptor.close();
                return "";
            } catch (IOException e2) {
                LogUtil.e("ImageBase64Utils", e2.getMessage(), e2);
                return "";
            }
        } catch (Throwable unused) {
            parcelFileDescriptor.close();
            return "";
        }
    }
}
