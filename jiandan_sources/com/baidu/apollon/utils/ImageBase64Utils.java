package com.baidu.apollon.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.apollon.imagemanager.ImageProcessor;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class ImageBase64Utils {
    public static final String a = "ImageBase64Utils";
    public static int b = 70;
    public static ImageBase64Utils c;

    public interface ImageBase64Listener {
        void onBase64Result(String str);
    }

    public class a extends AsyncTask<String, Integer, String> {
        public ImageBase64Listener b;
        public String c;
        public int d;

        public a(ImageBase64Listener imageBase64Listener, String str, int i2) {
            this.b = imageBase64Listener;
            this.c = str;
            this.d = i2;
        }

        /* renamed from: a */
        public String doInBackground(String... strArr) {
            return ImageBase64Utils.b(this.c, this.d);
        }

        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ImageBase64Listener imageBase64Listener = this.b;
            if (imageBase64Listener != null) {
                imageBase64Listener.onBase64Result(str);
            }
        }
    }

    public static String b(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                return "";
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            LogUtil.d("ImageBase64Utils", "original size\t " + (file.length() / 1000) + "\twidth" + options.outWidth + "\theight" + options.outHeight);
            int a2 = ImageProcessor.a(options, i2, -1);
            options.inSampleSize = a2;
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeFile.compress(Bitmap.CompressFormat.JPEG, b, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            LogUtil.d("ImageBase64Utils", "compress size:\t" + byteArray.length + "\tsampleSize" + a2 + "\twidth" + decodeFile.getWidth());
            decodeFile.recycle();
            byteArrayOutputStream.close();
            byte[] encode = Base64.encode(byteArray, 0, byteArray.length, 2);
            StringBuilder sb = new StringBuilder();
            sb.append("base64 size:\t");
            sb.append(byteArray.length / 1024);
            LogUtil.d("ImageBase64Utils", sb.toString());
            return new String(encode);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static ImageBase64Utils getInstance() {
        if (c == null) {
            c = new ImageBase64Utils();
        }
        return c;
    }

    public void getImgageBase64(String str, int i2, ImageBase64Listener imageBase64Listener) {
        new a(imageBase64Listener, str, i2).execute(new String[]{""});
    }
}
