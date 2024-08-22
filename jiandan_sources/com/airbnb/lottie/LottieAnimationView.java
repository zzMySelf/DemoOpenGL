package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.baidu.aiscan.R;
import com.tera.scan.app.R$styleable;
import fe.qw.qw.i;
import fe.qw.qw.o;
import fe.qw.qw.uk;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class LottieAnimationView extends AppCompatImageView {
    public static final LottieListener<Throwable> DEFAULT_FAILURE_LISTENER = new qw();
    public static final String TAG = LottieAnimationView.class.getSimpleName();
    public String animationName;
    @RawRes
    public int animationResId;
    public boolean autoPlay = false;
    public int buildDrawingCacheDepth = 0;
    public boolean cacheComposition = true;
    @Nullable
    public fe.qw.qw.de composition;
    @Nullable
    public uk<fe.qw.qw.de> compositionTask;
    @Nullable
    public LottieListener<Throwable> failureListener;
    @DrawableRes
    public int fallbackResource = 0;
    public boolean isInitialized;
    public final LottieListener<fe.qw.qw.de> loadedListener = new ad();
    public final fe.qw.qw.rg lottieDrawable = new fe.qw.qw.rg();
    public final Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners = new HashSet();
    public boolean playAnimationWhenShown = false;
    public RenderMode renderMode = RenderMode.AUTOMATIC;
    public boolean wasAnimatingWhenDetached = false;
    public boolean wasAnimatingWhenNotShown = false;
    public final LottieListener<Throwable> wrappedFailureListener = new de();

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new qw();
        public String animationName;
        public int animationResId;
        public String imageAssetsFolder;
        public boolean isAnimating;
        public float progress;
        public int repeatCount;
        public int repeatMode;

        public class qw implements Parcelable.Creator<SavedState> {
            /* renamed from: ad */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* renamed from: qw */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (qw) null);
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, qw qwVar) {
            this(parcel);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() != 1 ? false : true;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }
    }

    public class ad implements LottieListener<fe.qw.qw.de> {
        public ad() {
        }

        /* renamed from: qw */
        public void onResult(fe.qw.qw.de deVar) {
            LottieAnimationView.this.setComposition(deVar);
        }
    }

    public class de implements LottieListener<Throwable> {
        public de() {
        }

        /* renamed from: qw */
        public void onResult(Throwable th2) {
            if (LottieAnimationView.this.fallbackResource != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
            }
            (LottieAnimationView.this.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : LottieAnimationView.this.failureListener).onResult(th2);
        }
    }

    public class fe implements Callable<fe.qw.qw.yj<fe.qw.qw.de>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f548ad;

        public fe(int i2) {
            this.f548ad = i2;
        }

        /* renamed from: qw */
        public fe.qw.qw.yj<fe.qw.qw.de> call() {
            return LottieAnimationView.this.cacheComposition ? fe.qw.qw.fe.ppp(LottieAnimationView.this.getContext(), this.f548ad) : fe.qw.qw.fe.ggg(LottieAnimationView.this.getContext(), this.f548ad, (String) null);
        }
    }

    public class qw implements LottieListener<Throwable> {
        /* renamed from: qw */
        public void onResult(Throwable th2) {
            if (fe.qw.qw.ggg.yj.pf(th2)) {
                fe.qw.qw.ggg.fe.fe("Unable to load composition.", th2);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th2);
        }
    }

    public class rg implements Callable<fe.qw.qw.yj<fe.qw.qw.de>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f550ad;

        public rg(String str) {
            this.f550ad = str;
        }

        /* renamed from: qw */
        public fe.qw.qw.yj<fe.qw.qw.de> call() {
            return LottieAnimationView.this.cacheComposition ? fe.qw.qw.fe.th(LottieAnimationView.this.getContext(), this.f550ad) : fe.qw.qw.fe.yj(LottieAnimationView.this.getContext(), this.f550ad, (String) null);
        }
    }

    public class th extends fe.qw.qw.vvv.de<T> {

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ SimpleLottieValueCallback f552de;

        public th(SimpleLottieValueCallback simpleLottieValueCallback) {
            this.f552de = simpleLottieValueCallback;
        }

        public T qw(fe.qw.qw.vvv.ad<T> adVar) {
            return this.f552de.qw(adVar);
        }
    }

    public static /* synthetic */ class yj {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.RenderMode[] r0 = com.airbnb.lottie.RenderMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.HARDWARE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.SOFTWARE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.yj.<clinit>():void");
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        init((AttributeSet) null, R.attr.lottieAnimationViewStyle);
    }

    private void cancelLoaderTask() {
        uk<fe.qw.qw.de> ukVar = this.compositionTask;
        if (ukVar != null) {
            ukVar.pf(this.loadedListener);
            this.compositionTask.o(this.wrappedFailureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.i();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        if (r3 != false) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void enableOrDisableHardwareLayer() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.yj.qw
            com.airbnb.lottie.RenderMode r1 = r5.renderMode
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x0046
            if (r0 == r1) goto L_0x0013
            r3 = 3
            if (r0 == r3) goto L_0x0015
        L_0x0013:
            r1 = 1
            goto L_0x0046
        L_0x0015:
            fe.qw.qw.de r0 = r5.composition
            r3 = 0
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.ggg()
            if (r0 == 0) goto L_0x0027
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L_0x0027
            goto L_0x0044
        L_0x0027:
            fe.qw.qw.de r0 = r5.composition
            if (r0 == 0) goto L_0x0033
            int r0 = r0.m226if()
            r4 = 4
            if (r0 <= r4) goto L_0x0033
            goto L_0x0044
        L_0x0033:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L_0x003a
            goto L_0x0044
        L_0x003a:
            r4 = 24
            if (r0 == r4) goto L_0x0044
            r4 = 25
            if (r0 != r4) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r3 = 1
        L_0x0044:
            if (r3 == 0) goto L_0x0013
        L_0x0046:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L_0x0050
            r0 = 0
            r5.setLayerType(r1, r0)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.enableOrDisableHardwareLayer():void");
    }

    private uk<fe.qw.qw.de> fromAssets(String str) {
        if (isInEditMode()) {
            return new uk<>(new rg(str), true);
        }
        return this.cacheComposition ? fe.qw.qw.fe.fe(getContext(), str) : fe.qw.qw.fe.rg(getContext(), str, (String) null);
    }

    private uk<fe.qw.qw.de> fromRawRes(@RawRes int i2) {
        if (isInEditMode()) {
            return new uk<>(new fe(i2), true);
        }
        return this.cacheComposition ? fe.qw.qw.fe.m229switch(getContext(), i2) : fe.qw.qw.fe.when(getContext(), i2, (String) null);
    }

    private void init(@Nullable AttributeSet attributeSet, @AttrRes int i2) {
        String string;
        boolean z = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LottieAnimationView, i2, 0);
        this.cacheComposition = obtainStyledAttributes.getBoolean(1, true);
        boolean hasValue = obtainStyledAttributes.hasValue(9);
        boolean hasValue2 = obtainStyledAttributes.hasValue(5);
        boolean hasValue3 = obtainStyledAttributes.hasValue(15);
        if (!hasValue || !hasValue2) {
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(9, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(5);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(15)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(obtainStyledAttributes.getResourceId(4, 0));
            if (obtainStyledAttributes.getBoolean(0, false)) {
                this.wasAnimatingWhenDetached = true;
                this.autoPlay = true;
            }
            if (obtainStyledAttributes.getBoolean(7, false)) {
                this.lottieDrawable.S(-1);
            }
            if (obtainStyledAttributes.hasValue(12)) {
                setRepeatMode(obtainStyledAttributes.getInt(12, 1));
            }
            if (obtainStyledAttributes.hasValue(11)) {
                setRepeatCount(obtainStyledAttributes.getInt(11, -1));
            }
            if (obtainStyledAttributes.hasValue(14)) {
                setSpeed(obtainStyledAttributes.getFloat(14, 1.0f));
            }
            setImageAssetsFolder(obtainStyledAttributes.getString(6));
            setProgress(obtainStyledAttributes.getFloat(8, 0.0f));
            enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(3, false));
            if (obtainStyledAttributes.hasValue(2)) {
                i iVar = new i(obtainStyledAttributes.getColor(2, 0));
                addValueCallback(new fe.qw.qw.p009switch.fe("**"), LottieProperty.c, new fe.qw.qw.vvv.de(iVar));
            }
            if (obtainStyledAttributes.hasValue(13)) {
                this.lottieDrawable.V(obtainStyledAttributes.getFloat(13, 1.0f));
            }
            if (obtainStyledAttributes.hasValue(10)) {
                int i3 = obtainStyledAttributes.getInt(10, RenderMode.AUTOMATIC.ordinal());
                if (i3 >= RenderMode.values().length) {
                    i3 = RenderMode.AUTOMATIC.ordinal();
                }
                setRenderMode(RenderMode.values()[i3]);
            }
            if (getScaleType() != null) {
                this.lottieDrawable.W(getScaleType());
            }
            obtainStyledAttributes.recycle();
            fe.qw.qw.rg rgVar = this.lottieDrawable;
            if (fe.qw.qw.ggg.yj.th(getContext()) != 0.0f) {
                z = true;
            }
            rgVar.Y(Boolean.valueOf(z));
            enableOrDisableHardwareLayer();
            this.isInitialized = true;
            return;
        }
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    }

    private void setCompositionTask(uk<fe.qw.qw.de> ukVar) {
        clearComposition();
        cancelLoaderTask();
        ukVar.th(this.loadedListener);
        ukVar.rg(this.wrappedFailureListener);
        this.compositionTask = ukVar;
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.de(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.fe(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.rg(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        fe.qw.qw.de deVar = this.composition;
        if (deVar != null) {
            lottieOnCompositionLoadedListener.qw(deVar);
        }
        return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener);
    }

    public <T> void addValueCallback(fe.qw.qw.p009switch.fe feVar, T t, fe.qw.qw.vvv.de<T> deVar) {
        this.lottieDrawable.th(feVar, t, deVar);
    }

    public void buildDrawingCache(boolean z) {
        fe.qw.qw.ad.qw("buildDrawingCache");
        this.buildDrawingCacheDepth++;
        super.buildDrawingCache(z);
        if (this.buildDrawingCacheDepth == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.buildDrawingCacheDepth--;
        fe.qw.qw.ad.ad("buildDrawingCache");
    }

    @MainThread
    public void cancelAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.uk();
        enableOrDisableHardwareLayer();
    }

    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.o();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.when(z);
    }

    @Nullable
    public fe.qw.qw.de getComposition() {
        return this.composition;
    }

    public long getDuration() {
        fe.qw.qw.de deVar = this.composition;
        if (deVar != null) {
            return (long) deVar.fe();
        }
        return 0;
    }

    public int getFrame() {
        return this.lottieDrawable.nn();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.lottieDrawable.qqq();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.eee();
    }

    public float getMinFrame() {
        return this.lottieDrawable.tt();
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.a();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.lottieDrawable.b();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.c();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.d();
    }

    public float getScale() {
        return this.lottieDrawable.e();
    }

    public float getSpeed() {
        return this.lottieDrawable.f();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.j();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.k();
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        fe.qw.qw.rg rgVar = this.lottieDrawable;
        if (drawable2 == rgVar) {
            super.invalidateDrawable(rgVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.l();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.n();
    }

    @Deprecated
    public void loop(boolean z) {
        this.lottieDrawable.S(z ? -1 : 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.autoPlay || this.wasAnimatingWhenDetached)) {
            playAnimation();
            this.autoPlay = false;
            this.wasAnimatingWhenDetached = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        super.onDetachedFromWindow();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.animationName;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i2 = savedState.animationResId;
        this.animationResId = i2;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            playAnimation();
        }
        this.lottieDrawable.E(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        savedState.progress = this.lottieDrawable.b();
        savedState.isAnimating = this.lottieDrawable.l() || (!ViewCompat.isAttachedToWindow(this) && this.wasAnimatingWhenDetached);
        savedState.imageAssetsFolder = this.lottieDrawable.qqq();
        savedState.repeatMode = this.lottieDrawable.d();
        savedState.repeatCount = this.lottieDrawable.c();
        return savedState;
    }

    public void onVisibilityChanged(@NonNull View view, int i2) {
        if (this.isInitialized) {
            if (isShown()) {
                if (this.wasAnimatingWhenNotShown) {
                    resumeAnimation();
                } else if (this.playAnimationWhenShown) {
                    playAnimation();
                }
                this.wasAnimatingWhenNotShown = false;
                this.playAnimationWhenShown = false;
            } else if (isAnimating()) {
                pauseAnimation();
                this.wasAnimatingWhenNotShown = true;
            }
        }
    }

    @MainThread
    public void pauseAnimation() {
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.p();
        enableOrDisableHardwareLayer();
    }

    @MainThread
    public void playAnimation() {
        if (isShown()) {
            this.lottieDrawable.q();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = true;
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.r();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.s();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.t(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.u(animatorPauseListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.v(animatorUpdateListener);
    }

    public List<fe.qw.qw.p009switch.fe> resolveKeyPath(fe.qw.qw.p009switch.fe feVar) {
        return this.lottieDrawable.w(feVar);
    }

    @MainThread
    public void resumeAnimation() {
        if (isShown()) {
            this.lottieDrawable.x();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = true;
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.y();
    }

    public void setAnimation(@RawRes int i2) {
        this.animationResId = i2;
        this.animationName = null;
        setCompositionTask(fromRawRes(i2));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.cacheComposition ? fe.qw.qw.fe.vvv(getContext(), str) : fe.qw.qw.fe.xxx(getContext(), str, (String) null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.lottieDrawable.z(z);
    }

    public void setCacheComposition(boolean z) {
        this.cacheComposition = z;
    }

    public void setComposition(@NonNull fe.qw.qw.de deVar) {
        if (fe.qw.qw.ad.qw) {
            "Set Composition \n" + deVar;
        }
        this.lottieDrawable.setCallback(this);
        this.composition = deVar;
        boolean A = this.lottieDrawable.A(deVar);
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || A) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (LottieOnCompositionLoadedListener qw2 : this.lottieOnCompositionLoadedListeners) {
                qw2.qw(deVar);
            }
        }
    }

    public void setFailureListener(@Nullable LottieListener<Throwable> lottieListener) {
        this.failureListener = lottieListener;
    }

    public void setFallbackResource(@DrawableRes int i2) {
        this.fallbackResource = i2;
    }

    public void setFontAssetDelegate(fe.qw.qw.qw qwVar) {
        this.lottieDrawable.B(qwVar);
    }

    public void setFrame(int i2) {
        this.lottieDrawable.C(i2);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.lottieDrawable.D(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.E(str);
    }

    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i2) {
        cancelLoaderTask();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.lottieDrawable.F(i2);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lottieDrawable.H(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.J(str);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lottieDrawable.L(f, f2);
    }

    public void setMinFrame(int i2) {
        this.lottieDrawable.M(i2);
    }

    public void setMinProgress(float f) {
        this.lottieDrawable.O(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.lottieDrawable.P(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.Q(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lottieDrawable.R(f);
    }

    public void setRenderMode(RenderMode renderMode2) {
        this.renderMode = renderMode2;
        enableOrDisableHardwareLayer();
    }

    public void setRepeatCount(int i2) {
        this.lottieDrawable.S(i2);
    }

    public void setRepeatMode(int i2) {
        this.lottieDrawable.T(i2);
    }

    public void setSafeMode(boolean z) {
        this.lottieDrawable.U(z);
    }

    public void setScale(float f) {
        this.lottieDrawable.V(f);
        if (getDrawable() == this.lottieDrawable) {
            setImageDrawable((Drawable) null);
            setImageDrawable(this.lottieDrawable);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        fe.qw.qw.rg rgVar = this.lottieDrawable;
        if (rgVar != null) {
            rgVar.W(scaleType);
        }
    }

    public void setSpeed(float f) {
        this.lottieDrawable.X(f);
    }

    public void setTextDelegate(o oVar) {
        this.lottieDrawable.Z(oVar);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.lottieDrawable.a0(str, bitmap);
    }

    public <T> void addValueCallback(fe.qw.qw.p009switch.fe feVar, T t, SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.lottieDrawable.th(feVar, t, new th(simpleLottieValueCallback));
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.G(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.lottieDrawable.K(str, str2, z);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.N(str);
    }

    public void setMinAndMaxFrame(int i2, int i3) {
        this.lottieDrawable.I(i2, i3);
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(fromAssets(str));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(fe.qw.qw.fe.xxx(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(fe.qw.qw.fe.uk(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(attributeSet, i2);
    }
}
