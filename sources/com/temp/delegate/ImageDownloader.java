package com.temp.delegate;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.talos.TalosAdapterManager;
import com.baidu.talos.util.Closeables;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class ImageDownloader {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = TalosAdapterManager.getHostConfig().isDebug();
    private static final String DOWNLOAD_SUFFIX = ".talosdownload";
    private static final String TAG = "ImageDownloader";
    /* access modifiers changed from: private */
    public String mDir = "";
    /* access modifiers changed from: private */
    public ImageDownloadListener mDownloadListener;
    /* access modifiers changed from: private */
    public String mSrc = "";

    ImageDownloader(String dir, String src, ImageDownloadListener listener) {
        this.mDir = dir;
        this.mSrc = src;
        this.mDownloadListener = listener;
    }

    /* access modifiers changed from: package-private */
    public void load() {
        TalosAdapterManager.getOKHttpAdapter().getOkHttpClient().newCall(new Request.Builder().url(this.mSrc).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException e2) {
                if (ImageDownloader.DEBUG) {
                    Log.e(ImageDownloader.TAG, ImageDownloader.this.mSrc + " load failed");
                    e2.printStackTrace();
                }
                if (ImageDownloader.this.mDownloadListener != null) {
                    ImageDownloader.this.mDownloadListener.fail(-1, ImageDownloader.this.mSrc);
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (!TextUtils.isEmpty(ImageDownloader.this.mDir)) {
                    InputStream is = null;
                    byte[] buf = new byte[2048];
                    File file = null;
                    try {
                        is = response.body().byteStream();
                        String main = ImageUtils.convertSrc(ImageDownloader.this.mSrc);
                        if (!TextUtils.isEmpty(main)) {
                            String fileDir = ImageDownloader.this.mDir + main.substring(0, main.lastIndexOf("/"));
                            File folder = new File(fileDir);
                            if (!folder.exists() || !folder.isDirectory()) {
                                folder.mkdirs();
                            }
                            String fileName = main.substring(main.lastIndexOf("/") + 1);
                            File file2 = new File(fileDir, fileName + ImageDownloader.DOWNLOAD_SUFFIX);
                            FileOutputStream fos = new FileOutputStream(file2);
                            while (true) {
                                int read = is.read(buf);
                                int len = read;
                                if (read == -1) {
                                    break;
                                }
                                fos.write(buf, 0, len);
                            }
                            fos.flush();
                            File newFile = new File(fileDir, fileName);
                            if (newFile.exists() && !newFile.isDirectory()) {
                                newFile.delete();
                            }
                            String path = newFile.getAbsolutePath();
                            if (file2.renameTo(newFile)) {
                                if (ImageDownloader.DEBUG) {
                                    Log.e(ImageDownloader.TAG, ImageDownloader.this.mSrc + " load rename success path = " + path);
                                }
                                if (ImageDownloader.this.mDownloadListener != null) {
                                    ImageDownloader.this.mDownloadListener.success(ImageDownloader.this.mSrc, path);
                                }
                            } else {
                                if (ImageDownloader.DEBUG) {
                                    Log.e(ImageDownloader.TAG, ImageDownloader.this.mSrc + " load rename error path = " + path);
                                }
                                file2.delete();
                                if (ImageDownloader.this.mDownloadListener != null) {
                                    ImageDownloader.this.mDownloadListener.fail(-1, path);
                                }
                            }
                            Closeables.closeSafely((Closeable) is);
                            Closeables.closeSafely((Closeable) fos);
                            Closeables.closeSafely((Closeable) response);
                        }
                    } catch (Exception e2) {
                        if (ImageDownloader.DEBUG) {
                            Log.e(ImageDownloader.TAG, ImageDownloader.this.mSrc + " load failed", e2);
                        }
                        if (file != null) {
                            file.delete();
                        }
                        if (ImageDownloader.this.mDownloadListener != null) {
                            ImageDownloader.this.mDownloadListener.fail(-1, ImageDownloader.this.mSrc);
                        }
                    } finally {
                        Closeables.closeSafely((Closeable) is);
                        Closeables.closeSafely((Closeable) null);
                        Closeables.closeSafely((Closeable) response);
                    }
                }
            }
        });
    }
}
