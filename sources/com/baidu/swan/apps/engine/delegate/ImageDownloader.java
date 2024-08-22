package com.baidu.swan.apps.engine.delegate;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.ioc.SwanGameRuntime;
import com.baidu.swan.utils.SwanAppFileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

class ImageDownloader {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String DOWNLOAD_SUFFIX = ".bddownload";
    private static final String TAG = "ImageDownloader";
    /* access modifiers changed from: private */
    public String mDir = "";
    /* access modifiers changed from: private */
    public ImageDownloadListener mDownloadListener;
    private HttpManager mHttpManager;
    /* access modifiers changed from: private */
    public String mSrc = "";

    ImageDownloader(HttpManager manager, String dir, String src, ImageDownloadListener listener) {
        this.mHttpManager = manager;
        this.mDir = dir;
        this.mSrc = src;
        this.mDownloadListener = listener;
    }

    /* access modifiers changed from: package-private */
    public void load() {
        SwanGameRuntime.getSwanGameHttpManager().call(this.mHttpManager, new Request.Builder().url(this.mSrc).build(), new Callback() {
            public void onFailure(Call call, IOException e2) {
                if (ImageDownloader.DEBUG) {
                    Log.e(ImageDownloader.TAG, ImageDownloader.this.mSrc + " load failed");
                    e2.printStackTrace();
                }
                if (ImageDownloader.this.mDownloadListener != null) {
                    ImageDownloader.this.mDownloadListener.fail(-1, ImageDownloader.this.mSrc);
                }
            }

            public void onResponse(Call call, Response response) {
                if (!TextUtils.isEmpty(ImageDownloader.this.mDir)) {
                    InputStream is = null;
                    byte[] buf = new byte[2048];
                    File file = null;
                    try {
                        is = response.body().byteStream();
                        String main = SwanGameRuntime.getSwanGameAudioManager().convertSrc(ImageDownloader.this.mSrc);
                        if (TextUtils.isEmpty(main)) {
                            if (SwanAppLibConfig.DEBUG) {
                                Log.e(SwanGameRuntime.TAG, "非手百环境依赖注入接口convertSrc()未实现，直接返回");
                            }
                            return;
                        }
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
                        SwanAppFileUtils.closeSafely(is);
                        SwanAppFileUtils.closeSafely(fos);
                        SwanAppFileUtils.closeSafely(response);
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
                        SwanAppFileUtils.closeSafely(is);
                        SwanAppFileUtils.closeSafely((Closeable) null);
                        SwanAppFileUtils.closeSafely(response);
                    }
                } else if (SwanAppLibConfig.DEBUG) {
                    Log.e(SwanGameRuntime.TAG, "非手百环境依赖注入接口未实现，直接返回");
                }
            }
        });
    }
}
