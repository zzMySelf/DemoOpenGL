package com.baidu.wallet.utils.compress;

import android.content.Context;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import com.baidu.wallet.core.NoProguard;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class VideoBase64Utils implements NoProguard {

    public interface VideoBase64Listener extends NoProguard {
        void onBase64Result(String str);
    }

    public static class a extends AsyncTask<String, Integer, String> {
        public VideoBase64Listener a;
        public ParcelFileDescriptor b;
        public String c;
        public boolean d = false;
        public Context e;

        public a(VideoBase64Listener videoBase64Listener, String str) {
            this.a = videoBase64Listener;
            this.c = str;
        }

        private String b(String str) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(str);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                fileInputStream = null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            if (fileInputStream != null) {
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        }

        /* renamed from: a */
        public String doInBackground(String... strArr) {
            return b(this.c);
        }

        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            VideoBase64Listener videoBase64Listener = this.a;
            if (videoBase64Listener != null) {
                videoBase64Listener.onBase64Result(str);
            }
        }
    }

    public static void video2base64(String str, VideoBase64Listener videoBase64Listener) {
        new a(videoBase64Listener, str).execute(new String[0]);
    }
}
