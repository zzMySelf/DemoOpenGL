package com.baidu.mms.voicesearch.voice.bean.dao;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.mms.voicesearch.api.VoiceSearchManager;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.appletsentrance.CircleImageView;
import com.baidu.mms.voicesearch.voice.common.FileUtil;
import com.baidu.mms.voicesearch.voice.utils.DownLoadUtil;
import com.baidu.mms.voicesearch.voice.utils.SkinManager;
import com.baidu.voicesearch.component.net.DownloadListener;
import com.baidu.voicesearch.component.utils.NormalTask;
import com.baidu.voicesearch.component.utils.TaskDispatcher;
import com.baidu.voicesearch.middleware.utils.SkinUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class VoiceImageDownloadDao {
    private static final String TAG = "VoiceImageDownloadDao";
    private static VoiceImageDownloadDao instance;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, SoftReference<Drawable>> mEixtImagePath = new ConcurrentHashMap<>();

    public interface OnImageLoadListener {
        void onError();

        void onSucces(String str, Drawable drawable);
    }

    public VoiceImageDownloadDao() {
        if (this.mContext == null) {
            this.mContext = VoiceSearchManager.getApplicationContext();
        }
    }

    public static VoiceImageDownloadDao getInstance() {
        if (instance == null) {
            synchronized (VoiceImageDownloadDao.class) {
                instance = new VoiceImageDownloadDao();
            }
        }
        return instance;
    }

    public void downloadCircleImageWithUrl(Context context, CircleImageView imageView, String url, final Drawable defaultDrawable, final Drawable defaultDrawableNight) {
        if (imageView != null) {
            if (TextUtils.isEmpty(url)) {
                if (SkinManager.getInstance().isNightMode()) {
                    imageView.setImageDrawable(defaultDrawableNight);
                } else {
                    imageView.setImageDrawable(defaultDrawable);
                }
            }
            final WeakReference<CircleImageView> weakRef = new WeakReference<>(imageView);
            downloadImageWithUrl(context, url, new OnImageLoadListener() {
                public void onError() {
                    WeakReference weakReference = weakRef;
                    if (weakReference != null && weakReference.get() != null) {
                        if (SkinManager.getInstance().isNightMode()) {
                            ((CircleImageView) weakRef.get()).setImageDrawable(defaultDrawableNight);
                        } else {
                            ((CircleImageView) weakRef.get()).setImageDrawable(defaultDrawable);
                        }
                    }
                }

                public void onSucces(String url, Drawable drawable) {
                    WeakReference weakReference = weakRef;
                    if (weakReference != null && weakReference.get() != null) {
                        ((CircleImageView) weakRef.get()).setImageDrawable(drawable);
                        if (SkinManager.getInstance().isNightMode()) {
                            ((CircleImageView) weakRef.get()).setNightMode();
                        } else {
                            ((CircleImageView) weakRef.get()).setNormalMode();
                        }
                    }
                }
            });
        }
    }

    public void downloadImageWithUrl(Context context, ImageView imageView, String url, final Drawable defaultDrawable) {
        if (imageView != null) {
            if (imageView.getDrawable() == null) {
                imageView.setImageDrawable(defaultDrawable);
            }
            final WeakReference<ImageView> weakRef = new WeakReference<>(imageView);
            downloadImageWithUrl(context, url, new OnImageLoadListener() {
                public void onError() {
                    WeakReference weakReference = weakRef;
                    if (weakReference != null && weakReference.get() != null) {
                        ((ImageView) weakRef.get()).setImageDrawable(defaultDrawable);
                    }
                }

                public void onSucces(String url, Drawable drawable) {
                    WeakReference weakReference = weakRef;
                    if (weakReference != null && weakReference.get() != null) {
                        ((ImageView) weakRef.get()).setImageDrawable(drawable);
                    }
                }
            });
        }
    }

    public void downloadImageWithUrl(Context context, final String url, final OnImageLoadListener imageLoadListener) {
        Context context2 = this.mContext;
        if (context2 != null || context != null) {
            if (context2 == null) {
                this.mContext = context.getApplicationContext();
            }
            if (this.mContext != null && imageLoadListener != null && !TextUtils.isEmpty(url)) {
                if (this.mEixtImagePath.containsKey(url)) {
                    final Drawable drawable = getDrawableFromCache(url);
                    if (drawable != null) {
                        TaskDispatcher.getSharedInstance().addToMainLooper(new NormalTask() {
                            public boolean doTask() {
                                imageLoadListener.onSucces(url, drawable);
                                return super.doTask();
                            }
                        });
                    } else {
                        getDrawableFromFileAndNet(url, imageLoadListener);
                    }
                } else {
                    getDrawableFromFileAndNet(url, imageLoadListener);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void download(final String url, String fileName, final OnImageLoadListener imageLoadListener) {
        Context context = this.mContext;
        if (context != null && imageLoadListener != null) {
            DownLoadUtil.downLoadWithUrlAndTag(TAG, url, SkinManager.getSkinImagePath(context), fileName, new DownloadListener() {
                public void onSuccess(final String url, String filePath) {
                    try {
                        VoiceImageDownloadDao voiceImageDownloadDao = VoiceImageDownloadDao.this;
                        final Drawable drawable = voiceImageDownloadDao.getDrawableWithFilePath(voiceImageDownloadDao.mContext, filePath);
                        VoiceImageDownloadDao.this.mEixtImagePath.put(url, new SoftReference<>(drawable));
                        TaskDispatcher.getSharedInstance().addToMainLooper(new NormalTask() {
                            public boolean doTask() {
                                if (imageLoadListener != null) {
                                    imageLoadListener.onSucces(url, drawable);
                                }
                                return super.doTask();
                            }
                        });
                    } catch (Throwable th2) {
                    }
                }

                public void onError(Exception error) {
                    OnImageLoadListener onImageLoadListener;
                    if (error != null && (onImageLoadListener = imageLoadListener) != null) {
                        onImageLoadListener.onError();
                    }
                }
            });
        }
    }

    private void getDrawableFromFileAndNet(final String url, final OnImageLoadListener imageLoadListener) {
        if (this.mContext != null && imageLoadListener != null && !TextUtils.isEmpty(url)) {
            TaskDispatcher.getSharedInstance().addToAsyncWorkingLoop(new NormalTask() {
                public boolean doTask() {
                    String imageFileName = FileUtil.getDownloadFileNameWithUrl(url);
                    if (!TextUtils.isEmpty(imageFileName)) {
                        VoiceImageDownloadDao voiceImageDownloadDao = VoiceImageDownloadDao.this;
                        String filePath = voiceImageDownloadDao.getIamgeFilePath(voiceImageDownloadDao.mContext, url, imageFileName, false);
                        if (TextUtils.isEmpty(filePath)) {
                            VoiceImageDownloadDao.this.download(url, imageFileName, imageLoadListener);
                        } else {
                            VoiceImageDownloadDao voiceImageDownloadDao2 = VoiceImageDownloadDao.this;
                            final Drawable drawable = voiceImageDownloadDao2.getDrawableWithFilePath(voiceImageDownloadDao2.mContext, filePath);
                            VoiceImageDownloadDao.this.mEixtImagePath.put(url, new SoftReference<>(drawable));
                            TaskDispatcher.getSharedInstance().addToMainLooper(new NormalTask() {
                                public boolean doTask() {
                                    if (imageLoadListener != null) {
                                        imageLoadListener.onSucces(url, drawable);
                                    }
                                    return super.doTask();
                                }
                            });
                        }
                    }
                    return super.doTask();
                }
            });
        }
    }

    public void reloadDrawableFromNet(final String url, final OnImageLoadListener imageLoadListener) {
        if (this.mContext != null && imageLoadListener != null && !TextUtils.isEmpty(url)) {
            TaskDispatcher.getSharedInstance().addToAsyncWorkingLoop(new NormalTask() {
                public boolean doTask() {
                    String imageFileName = FileUtil.getDownloadFileNameWithUrl(url);
                    VoiceImageDownloadDao voiceImageDownloadDao = VoiceImageDownloadDao.this;
                    String unused = voiceImageDownloadDao.getIamgeFilePath(voiceImageDownloadDao.mContext, url, imageFileName, true);
                    VoiceImageDownloadDao.this.download(url, imageFileName, imageLoadListener);
                    return super.doTask();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public String getIamgeFilePath(Context context, String url, String fileName, boolean isDelete) {
        if (context == null || TextUtils.isEmpty(fileName)) {
            return null;
        }
        String filePath = SkinManager.getSkinImagePath(context);
        String downloadTempPath = SkinManager.getSkinImageTempPath(context);
        if (TextUtils.isEmpty(filePath) || TextUtils.isEmpty(downloadTempPath)) {
            return null;
        }
        File isExitFile = new File(filePath, fileName);
        if (!isExitFile.exists()) {
            File isExitFileInTempFile = new File(downloadTempPath, fileName);
            if (isExitFileInTempFile.exists()) {
                return isExitFileInTempFile.getAbsolutePath();
            }
            return null;
        } else if (!isDelete || !isExitFile.isFile()) {
            return isExitFile.getAbsolutePath();
        } else {
            isExitFile.delete();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public Drawable getDrawableWithFilePath(Context context, String filePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        if (bitmap == null || context == null) {
            return null;
        }
        byte[] chunk = bitmap.getNinePatchChunk();
        if (!NinePatch.isNinePatchChunk(chunk)) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        return new NinePatchDrawable(context.getResources(), bitmap, chunk, SkinUtils.getPadding(chunk), (String) null);
    }

    private Drawable getDrawableFromCache(String key) {
        SoftReference<Drawable> drawableCache;
        ConcurrentHashMap<String, SoftReference<Drawable>> concurrentHashMap = this.mEixtImagePath;
        if (concurrentHashMap == null || (drawableCache = concurrentHashMap.get(key)) == null) {
            return null;
        }
        return drawableCache.get();
    }
}
