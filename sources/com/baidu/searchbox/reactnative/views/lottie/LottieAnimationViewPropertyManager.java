package com.baidu.searchbox.reactnative.views.lottie;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.talos.core.data.ParamArray;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.util.ViewIDConvertUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

public class LottieAnimationViewPropertyManager implements LottieOnCompositionLoadedListener, LottieListener<Throwable> {
    private static final String TAG = LottieAnimationViewPropertyManager.class.getSimpleName();
    private String animationFile;
    private boolean animationFileDirty;
    private String animationJson;
    private String animationName;
    private boolean animationNameDirty;
    /* access modifiers changed from: private */
    public boolean autoplay = true;
    private ParamArray colorFilters;
    private Boolean enableMergePaths;
    private String imageAssetsFolder;
    private Boolean loop;
    private final LottieOnCompositionLoadedListener mLottieOnCompositionLoadedListener = new LottieOnCompositionLoadedListener() {
        public void onCompositionLoaded(LottieComposition composition) {
            LottieAnimationView view2 = (LottieAnimationView) LottieAnimationViewPropertyManager.this.viewWeakReference.get();
            if (view2 != null && LottieAnimationViewPropertyManager.this.autoplay && !view2.isAnimating()) {
                view2.playAnimation();
            }
        }
    };
    private Float progress;
    private ImageView.ScaleType scaleType;
    private Float speed;
    /* access modifiers changed from: private */
    public final WeakReference<LottieAnimationView> viewWeakReference;
    private String zipUrl;
    private boolean zipUrlChanged = false;

    public LottieAnimationViewPropertyManager(LottieAnimationView view2) {
        this.viewWeakReference = new WeakReference<>(view2);
    }

    public void setAnimationName(String animationName2) {
        this.animationName = animationName2;
        this.animationNameDirty = true;
    }

    public void setAnimationJson(String json) {
        this.animationJson = json;
    }

    public void setAnimationFile(String path) {
        this.animationFile = path;
        this.animationFileDirty = true;
    }

    public void setZipUrl(String url) {
        if (!TextUtils.equals(this.zipUrl, url)) {
            this.zipUrl = url;
            this.zipUrlChanged = true;
        }
    }

    public void setProgress(Float progress2) {
        this.progress = progress2;
    }

    public void setSpeed(float speed2) {
        this.speed = Float.valueOf(speed2);
    }

    public void setLoop(boolean loop2) {
        this.loop = Boolean.valueOf(loop2);
    }

    public void setScaleType(ImageView.ScaleType scaleType2) {
        this.scaleType = scaleType2;
    }

    public void setImageAssetsFolder(String imageAssetsFolder2) {
        this.imageAssetsFolder = imageAssetsFolder2;
    }

    public void setEnableMergePaths(boolean enableMergePaths2) {
        this.enableMergePaths = Boolean.valueOf(enableMergePaths2);
    }

    public void setColorFilters(ParamArray colorFilters2) {
        this.colorFilters = colorFilters2;
    }

    public void setAutoplay(boolean autoplay2) {
        this.autoplay = autoplay2;
    }

    public void commitChanges() {
        String str;
        LottieAnimationView view2 = (LottieAnimationView) this.viewWeakReference.get();
        if (view2 != null) {
            String str2 = this.animationJson;
            if (str2 != null) {
                view2.setAnimationFromJson(str2, Integer.toString(str2.hashCode()));
                this.animationJson = null;
            }
            String str3 = this.zipUrl;
            if (str3 != null && this.zipUrlChanged) {
                view2.setAnimationFromUrl(str3, Integer.toString(str3.hashCode()));
                view2.setFailureListener(this);
                view2.addLottieOnCompositionLoadedListener(this);
                this.zipUrlChanged = false;
            }
            if (this.animationNameDirty) {
                view2.setAnimation(this.animationName);
                this.animationNameDirty = false;
            }
            if (this.animationFileDirty && (str = this.animationFile) != null) {
                File file = null;
                if (str.startsWith("file://")) {
                    file = new File(this.animationFile.substring("file://".length()));
                } else if (this.animationFile.startsWith("/")) {
                    file = new File(this.animationFile);
                }
                if (file != null && file.isFile()) {
                    try {
                        view2.setAnimation(new FileInputStream(file), this.animationFile);
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
                this.animationFileDirty = false;
            }
            if (this.autoplay) {
                view2.addLottieOnCompositionLoadedListener(this.mLottieOnCompositionLoadedListener);
            } else {
                view2.removeLottieOnCompositionLoadedListener(this.mLottieOnCompositionLoadedListener);
            }
            Float f2 = this.progress;
            if (f2 != null) {
                view2.setProgress(f2.floatValue());
                this.progress = null;
            }
            Boolean bool = this.loop;
            if (bool != null) {
                view2.setRepeatCount(bool.booleanValue() ? -1 : 0);
                this.loop = null;
            }
            Float f3 = this.speed;
            if (f3 != null) {
                view2.setSpeed(f3.floatValue());
                this.speed = null;
            }
            ImageView.ScaleType scaleType2 = this.scaleType;
            if (scaleType2 != null) {
                view2.setScaleType(scaleType2);
                this.scaleType = null;
            }
            String str4 = this.imageAssetsFolder;
            if (str4 != null) {
                view2.setImageAssetsFolder(str4);
                this.imageAssetsFolder = null;
            }
            Boolean bool2 = this.enableMergePaths;
            if (bool2 != null) {
                view2.enableMergePathsForKitKatAndAbove(bool2.booleanValue());
                this.enableMergePaths = null;
            }
            ParamArray paramArray = this.colorFilters;
            if (paramArray != null && paramArray.size() > 0) {
                for (int i2 = 0; i2 < this.colorFilters.size(); i2++) {
                    ParamMap current = this.colorFilters.getMap(i2);
                    String color = current.getString("color");
                    view2.addValueCallback(new KeyPath(current.getString("keypath"), "**"), LottieProperty.COLOR_FILTER, new LottieValueCallback<>(new SimpleColorFilter(Color.parseColor(color))));
                }
            }
        }
    }

    private void sendDownloadEvent(int status) {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "sendDownloadEvent  status = " + status);
        }
        LottieAnimationView view2 = (LottieAnimationView) this.viewWeakReference.get();
        if (view2 != null) {
            Context reactContext = view2.getContext();
            if (reactContext instanceof TalosPageContext) {
                ((TalosPageContext) reactContext).dispatchEvent(new LottieResDownloadEvent(ViewIDConvertUtil.getTalosViewTag(view2), status));
            }
        }
    }

    public void onResult(Throwable result) {
        if (this.zipUrl != null) {
            sendDownloadEvent(0);
            this.zipUrl = null;
        }
    }

    public void onCompositionLoaded(LottieComposition composition) {
        sendDownloadEvent(1);
    }
}
