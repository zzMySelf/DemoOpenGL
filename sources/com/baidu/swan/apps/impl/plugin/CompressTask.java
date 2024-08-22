package com.baidu.swan.apps.impl.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ugc.transcoder.interfaces.IUgcCommonTranscoderInterface;
import com.baidu.searchbox.ugc.videocapture.transcoder.TranscoderPlugin;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.lifecycle.ActivityLifecycleCallbackAdapter;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.helper.SwanAppChooseConstant;
import com.baidu.swan.apps.media.chooser.listener.OnTaskResultListener;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.storage.StorageUtil;
import com.baidu.swan.apps.util.SwanAppImageUtils;
import com.baidu.swan.apps.util.SwanAppIntentUtils;
import com.baidu.swan.utils.SwanAppFileUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class CompressTask implements Runnable {
    private static final int COMPRESS_QUALITY = 20;
    private static final String IMAGE_GIF_TYPE = "gif";
    private static final int MSG_COMPRESS_FINISH = 2;
    private static final int MSG_COMPRESS_START = 1;
    private static final int NO_COMPRESS = 100;
    protected static final String TAG = "CompressTask";
    private CompressHandler mHandler;
    private boolean mIsCompressed;
    private ActivityLifecycleCallback mLifecycleCallback;
    private ArrayList<MediaModel> mMediaModels;
    private OnTaskResultListener mResultListener;
    private String mSwanAppId;
    private String mSwanTmpPath;

    public CompressTask(Context context, Bundle params, OnTaskResultListener listener) {
        this.mMediaModels = params.getParcelableArrayList(SwanAppChooseConstant.KEY_CHOOSE_MEDIA_MODELS);
        this.mSwanAppId = SwanAppIntentUtils.safeGetString(params, "swanAppId");
        this.mIsCompressed = SwanAppIntentUtils.safeGetBoolean(params, "compressed", false);
        this.mSwanTmpPath = SwanAppIntentUtils.safeGetString(params, SwanAppChooseConstant.KEY_SWAN_TMP_PATH);
        this.mResultListener = listener;
        this.mHandler = new CompressHandler(context);
    }

    public void run() {
        registerActivityLifecycleCallbacks();
        CompressHandler compressHandler = this.mHandler;
        if (compressHandler != null) {
            compressHandler.sendEmptyMessage(1);
        }
        if (this.mIsCompressed) {
            Iterator<MediaModel> it = this.mMediaModels.iterator();
            while (it.hasNext()) {
                MediaModel model = it.next();
                if (model != null) {
                    if (model instanceof ImageModel) {
                        if (TextUtils.equals(SwanAppFileUtils.getFileSuffixFromPath(model.getPath()), "gif")) {
                            copyImgOrVideoFile(model);
                        } else {
                            compressImg(model, 20);
                        }
                    } else if (model instanceof VideoModel) {
                        compressVideo((VideoModel) model);
                    }
                }
            }
        } else {
            Iterator<MediaModel> it2 = this.mMediaModels.iterator();
            while (it2.hasNext()) {
                MediaModel model2 = it2.next();
                if (model2 != null) {
                    if (model2 instanceof ImageModel) {
                        compressImg(model2, 100);
                    } else {
                        copyImgOrVideoFile(model2);
                    }
                }
            }
        }
        CompressHandler compressHandler2 = this.mHandler;
        if (compressHandler2 != null) {
            compressHandler2.sendEmptyMessage(2);
        }
        OnTaskResultListener onTaskResultListener = this.mResultListener;
        if (onTaskResultListener != null) {
            onTaskResultListener.onResult(true, (String) null, this.mMediaModels);
        }
        unregisterActivityLifecycleCallbacks();
    }

    private void copyImgOrVideoFile(MediaModel model) {
        if (model != null) {
            File file = new File(model.getPath());
            File tempFile = SwanAppImageUtils.getTempFile(this.mSwanTmpPath, file.getName());
            if (tempFile != null && tempFile.exists() && SwanAppFileUtils.copyFile(file, tempFile) != 0) {
                model.setTempPath(tempFile.getPath());
                if (model instanceof VideoModel) {
                    VideoModel videoModel = (VideoModel) model;
                    videoModel.setThumbnailBitmapUri(saveAndSetThumbnailBitmapUrl(videoModel));
                }
            }
        }
    }

    private void compressImg(MediaModel model, int quality) {
        if (model != null) {
            if (SwanAppChooseConstant.DEBUG) {
                Log.d(TAG, "compressImg : " + model.getPath());
            }
            File file = new File(model.getPath());
            File tempFile = SwanAppImageUtils.getTempFile(this.mSwanTmpPath, file.getName());
            if (tempFile != null) {
                model.setTempPath(tempFile.getAbsolutePath());
                boolean result = SwanAppImageUtils.rotateAndCompressImage(file, tempFile, quality);
                long length = tempFile.length();
                if (!result && length == 0) {
                    length = file.length();
                }
                model.setSize(length);
            }
        }
    }

    private void compressVideo(VideoModel model) {
        if (model != null) {
            if (SwanAppChooseConstant.DEBUG) {
                Log.d(TAG, "compressVideo : " + model.getPath());
            }
            File tempFile = SwanAppImageUtils.getTempFile(this.mSwanTmpPath, new File(model.getPath()).getName());
            if (tempFile != null) {
                String tempPath = tempFile.getPath();
                model.setTempPath(tempPath);
                TranscoderPlugin transcoderPlugin = new TranscoderPlugin(AppRuntime.getAppContext());
                transcoderPlugin.setDataSource(model.getPath());
                transcoderPlugin.setOutputFile(tempPath);
                transcoderPlugin.setOutputMaxEdgeLen(960);
                transcoderPlugin.setVideoFrameRate(25);
                transcoderPlugin.setVideoBitRate((int) (((double) model.getHeight()) * 1.5d * ((double) model.getWidth())));
                transcoderPlugin.setAudioBitRate(160000);
                transcoderPlugin.setOnCompletionListener(new IUgcCommonTranscoderInterface.OnCompletionListener() {
                    public void onCompletion() {
                        if (SwanAppChooseConstant.DEBUG) {
                            Log.d(CompressTask.TAG, "onCompletion");
                        }
                    }
                });
                transcoderPlugin.setOnErrorListener(new IUgcCommonTranscoderInterface.OnErrorListener() {
                    public boolean onError(int what, int extra) {
                        if (!SwanAppChooseConstant.DEBUG) {
                            return false;
                        }
                        Log.d(CompressTask.TAG, "onError : what=" + what + " extra=" + extra);
                        return false;
                    }
                });
                transcoderPlugin.startSync();
                model.setSize(tempFile.length());
                model.setThumbnailBitmapUri(saveAndSetThumbnailBitmapUrl(model));
            }
        }
    }

    private String saveAndSetThumbnailBitmapUrl(VideoModel videoModel) {
        String str = "";
        if (videoModel == null || TextUtils.isEmpty(videoModel.getPath()) || TextUtils.isEmpty(this.mSwanAppId)) {
            return str;
        }
        MediaMetadataRetriever retriever = null;
        try {
            retriever = new MediaMetadataRetriever();
            retriever.setDataSource(videoModel.getPath());
            Bitmap bitmap = retriever.getFrameAtTime(0);
            if (bitmap == null) {
                try {
                    retriever.release();
                } catch (Exception e2) {
                }
                return str;
            }
            String filePath = StorageUtil.getSwanAppTmpDirectory(this.mSwanAppId) + File.separator + "Thumbnail_" + System.currentTimeMillis() + ".png";
            if (SwanAppImageUtils.saveBitmap(bitmap, filePath, 100, Bitmap.CompressFormat.PNG)) {
                str = StorageUtil.path2SchemeWithExt(filePath, this.mSwanAppId);
            }
            try {
                retriever.release();
            } catch (Exception e3) {
            }
            return str;
        } catch (Exception e4) {
            if (SwanAppChooseConstant.DEBUG) {
                e4.printStackTrace();
            }
            if (retriever != null) {
                try {
                    retriever.release();
                } catch (Exception e5) {
                }
            }
            return str;
        } catch (Throwable th2) {
            if (retriever != null) {
                try {
                    retriever.release();
                } catch (Exception e6) {
                }
            }
            throw th2;
        }
    }

    private static class CompressHandler extends Handler {
        /* access modifiers changed from: private */
        public Dialog mProgressDialog;
        private WeakReference<Context> mReference;

        private CompressHandler(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Context c2 = (Context) this.mReference.get();
                    if ((c2 instanceof Activity) && !((Activity) c2).isFinishing()) {
                        Dialog dialog = new Dialog((Context) this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.mProgressDialog = dialog;
                        dialog.setContentView(R.layout.swanapp_progress_dialog);
                        this.mProgressDialog.findViewById(R.id.layer_night).setVisibility(SwanAppRuntime.getNightModeRuntime().getNightModeSwitcherState() ? 0 : 8);
                        this.mProgressDialog.setCancelable(false);
                        this.mProgressDialog.show();
                        return;
                    }
                    return;
                case 2:
                    Dialog dialog2 = this.mProgressDialog;
                    if (dialog2 != null && dialog2.isShowing()) {
                        Context context = (Context) this.mReference.get();
                        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                            this.mProgressDialog.cancel();
                        }
                        this.mProgressDialog = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private class ActivityLifecycleCallback extends ActivityLifecycleCallbackAdapter {
        private CompressHandler mHandler;

        public ActivityLifecycleCallback(CompressHandler handler) {
            this.mHandler = handler;
        }

        public void onActivityDestroyed(Activity activity) {
            if ((activity instanceof SwanAppActivity) || activity == Swan.get().getActivity() || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                CompressHandler compressHandler = this.mHandler;
                if (compressHandler != null) {
                    if (compressHandler.mProgressDialog != null && this.mHandler.mProgressDialog.isShowing()) {
                        this.mHandler.mProgressDialog.cancel();
                        Dialog unused = this.mHandler.mProgressDialog = null;
                    }
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    this.mHandler = null;
                }
                CompressTask.this.unregisterActivityLifecycleCallbacks();
            }
        }
    }

    private void registerActivityLifecycleCallbacks() {
        this.mLifecycleCallback = new ActivityLifecycleCallback(this.mHandler);
        SwanAppRuntime.getAppContext().registerActivityLifecycleCallbacks(this.mLifecycleCallback);
    }

    /* access modifiers changed from: private */
    public void unregisterActivityLifecycleCallbacks() {
        if (this.mLifecycleCallback != null) {
            SwanAppRuntime.getAppContext().unregisterActivityLifecycleCallbacks(this.mLifecycleCallback);
            this.mLifecycleCallback = null;
        }
    }
}
