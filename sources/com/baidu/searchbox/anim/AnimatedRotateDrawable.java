package com.baidu.searchbox.anim;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002@AB\u0007\b\u0016¢\u0006\u0002\u0010\u0005B\u001b\b\u0012\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0001H\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u00020\u000fH\u0016J\b\u0010(\u001a\u00020\u0001H\u0016J\b\u0010)\u001a\u00020\u0013H\u0002J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\"H\u0014J\b\u0010,\u001a\u00020\u0013H\u0016J \u0010-\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u001aH\u0016J\u0012\u00103\u001a\u00020\u00132\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u000e\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u001aJ\u000e\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u001aJ\u0018\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000fH\u0016J\b\u0010=\u001a\u00020\u0013H\u0016J\b\u0010>\u001a\u00020\u0013H\u0016J\u0018\u0010?\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0003H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/baidu/searchbox/anim/AnimatedRotateDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Ljava/lang/Runnable;", "Landroid/graphics/drawable/Animatable;", "()V", "rotateState", "Lcom/baidu/searchbox/anim/AnimatedRotateDrawable$AnimatedRotateState;", "res", "Landroid/content/res/Resources;", "(Lcom/baidu/searchbox/anim/AnimatedRotateDrawable$AnimatedRotateState;Landroid/content/res/Resources;)V", "mCurrentDegrees", "", "mIncrement", "mMutated", "", "mRunning", "mState", "draw", "", "canvas", "Landroid/graphics/Canvas;", "fill", "params", "Lcom/baidu/searchbox/anim/AnimatedRotateDrawable$Params;", "getChangingConfigurations", "", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "getPadding", "padding", "Landroid/graphics/Rect;", "init", "invalidateDrawable", "who", "isRunning", "isStateful", "mutate", "nextFrame", "onBoundsChange", "bounds", "run", "scheduleDrawable", "what", "when", "", "setAlpha", "alpha", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "setFramesCount", "framesCount", "setFramesDuration", "framesDuration", "setVisible", "visible", "restart", "start", "stop", "unscheduleDrawable", "AnimatedRotateState", "Params", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: anim.kt */
public final class AnimatedRotateDrawable extends Drawable implements Drawable.Callback, Runnable, Animatable {
    private float mCurrentDegrees;
    private float mIncrement;
    private boolean mMutated;
    private boolean mRunning;
    private AnimatedRotateState mState;

    public /* synthetic */ AnimatedRotateDrawable(AnimatedRotateState animatedRotateState, Resources resources, DefaultConstructorMarker defaultConstructorMarker) {
        this(animatedRotateState, resources);
    }

    public AnimatedRotateDrawable() {
        this((AnimatedRotateState) null, (Resources) null);
    }

    private AnimatedRotateDrawable(AnimatedRotateState rotateState, Resources res) {
        this.mState = new AnimatedRotateState(rotateState, this, res);
        init();
    }

    private final void init() {
        AnimatedRotateState state = this.mState;
        this.mIncrement = 360.0f / ((float) state.getMFramesCount());
        Drawable drawable = state.getDrawable();
        if (drawable != null) {
            drawable.setFilterBitmap(true);
            if (drawable instanceof BitmapDrawable) {
                ((BitmapDrawable) drawable).setAntiAlias(true);
            }
        }
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int saveCount = canvas.save();
        AnimatedRotateState st = this.mState;
        Drawable drawable = st.getDrawable();
        Intrinsics.checkNotNull(drawable);
        Rect bounds = drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "drawable.bounds");
        canvas.rotate(this.mCurrentDegrees, ((float) bounds.left) + (st.getMPivotXRel() ? ((float) (bounds.right - bounds.left)) * st.getMPivotX() : st.getMPivotX()), ((float) bounds.top) + (st.getMPivotYRel() ? ((float) (bounds.bottom - bounds.top)) * st.getMPivotY() : st.getMPivotY()));
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    public void start() {
        if (!this.mRunning) {
            this.mRunning = true;
            nextFrame();
        }
    }

    public void stop() {
        this.mRunning = false;
        unscheduleSelf(this);
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    private final void nextFrame() {
        unscheduleSelf(this);
        scheduleSelf(this, SystemClock.uptimeMillis() + ((long) this.mState.getMFrameDuration()));
    }

    public void run() {
        float f2 = this.mCurrentDegrees;
        float f3 = this.mIncrement;
        float f4 = f2 + f3;
        this.mCurrentDegrees = f4;
        if (f4 > 360.0f - f3) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidateSelf();
        nextFrame();
    }

    public boolean setVisible(boolean visible, boolean restart) {
        Drawable drawable = this.mState.getDrawable();
        Intrinsics.checkNotNull(drawable);
        drawable.setVisible(visible, restart);
        boolean changed = super.setVisible(visible, restart);
        if (!visible) {
            unscheduleSelf(this);
        } else if (changed || restart) {
            this.mCurrentDegrees = 0.0f;
            nextFrame();
        }
        return changed;
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations() | this.mState.getMChangingConfigurations();
        Drawable drawable = this.mState.getDrawable();
        Intrinsics.checkNotNull(drawable);
        return changingConfigurations | drawable.getChangingConfigurations();
    }

    public void setAlpha(int alpha) {
        Drawable drawable = this.mState.getDrawable();
        Intrinsics.checkNotNull(drawable);
        drawable.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        Drawable drawable = this.mState.getDrawable();
        Intrinsics.checkNotNull(drawable);
        drawable.setColorFilter(cf);
    }

    public int getOpacity() {
        Drawable drawable = this.mState.getDrawable();
        Intrinsics.checkNotNull(drawable);
        return drawable.getOpacity();
    }

    public void invalidateDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, PluginInvokerConstants.WHAT);
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, PluginInvokerConstants.WHAT);
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    public boolean getPadding(Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        Drawable drawable = this.mState.getDrawable();
        Intrinsics.checkNotNull(drawable);
        return drawable.getPadding(padding);
    }

    public boolean isStateful() {
        Drawable drawable = this.mState.getDrawable();
        Intrinsics.checkNotNull(drawable);
        return drawable.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Drawable drawable = this.mState.getDrawable();
        Intrinsics.checkNotNull(drawable);
        drawable.setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.mState.getDrawable();
        Intrinsics.checkNotNull(drawable);
        return drawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.mState.getDrawable();
        Intrinsics.checkNotNull(drawable);
        return drawable.getIntrinsicHeight();
    }

    public Drawable.ConstantState getConstantState() {
        if (!this.mState.canConstantState()) {
            return null;
        }
        this.mState.setMChangingConfigurations(getChangingConfigurations());
        return this.mState;
    }

    public final AnimatedRotateDrawable fill(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        setFramesCount(params.getFramesCount() > 0 ? params.getFramesCount() : 12);
        setFramesDuration(params.getFrameDuration() > 0 ? params.getFrameDuration() : 150);
        AnimatedRotateState rotateState = this.mState;
        rotateState.setDrawable(params.getDrawable());
        rotateState.setMPivotXRel(params.getPivotXRel());
        rotateState.setMPivotX(params.getPivotX());
        rotateState.setMPivotYRel(params.getPivotYRel());
        rotateState.setMPivotY(params.getPivotY());
        setVisible(params.getVisible(), true);
        init();
        params.getDrawable().setCallback(this);
        return this;
    }

    public final void setFramesCount(int framesCount) {
        this.mState.setMFramesCount(framesCount);
        this.mIncrement = 360.0f / ((float) this.mState.getMFramesCount());
    }

    public final void setFramesDuration(int framesDuration) {
        this.mState.setMFrameDuration(framesDuration);
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            Drawable drawable = this.mState.getDrawable();
            Intrinsics.checkNotNull(drawable);
            drawable.mutate();
            this.mMutated = true;
        }
        return this;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010.\u001a\u00020\u000fJ\b\u0010/\u001a\u00020\u0011H\u0016J\b\u00100\u001a\u00020\tH\u0016J\u0012\u00100\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001a\u0010+\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'¨\u00061"}, d2 = {"Lcom/baidu/searchbox/anim/AnimatedRotateDrawable$AnimatedRotateState;", "Landroid/graphics/drawable/Drawable$ConstantState;", "source", "owner", "Lcom/baidu/searchbox/anim/AnimatedRotateDrawable;", "res", "Landroid/content/res/Resources;", "(Lcom/baidu/searchbox/anim/AnimatedRotateDrawable$AnimatedRotateState;Lcom/baidu/searchbox/anim/AnimatedRotateDrawable;Landroid/content/res/Resources;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "mCanConstantState", "", "mChangingConfigurations", "", "getMChangingConfigurations", "()I", "setMChangingConfigurations", "(I)V", "mCheckedConstantState", "mFrameDuration", "getMFrameDuration", "setMFrameDuration", "mFramesCount", "getMFramesCount", "setMFramesCount", "mPivotX", "", "getMPivotX", "()F", "setMPivotX", "(F)V", "mPivotXRel", "getMPivotXRel", "()Z", "setMPivotXRel", "(Z)V", "mPivotY", "getMPivotY", "setMPivotY", "mPivotYRel", "getMPivotYRel", "setMPivotYRel", "canConstantState", "getChangingConfigurations", "newDrawable", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: anim.kt */
    public static final class AnimatedRotateState extends Drawable.ConstantState {
        private Drawable drawable;
        private boolean mCanConstantState;
        private int mChangingConfigurations;
        private boolean mCheckedConstantState;
        private int mFrameDuration;
        private int mFramesCount;
        private float mPivotX;
        private boolean mPivotXRel;
        private float mPivotY;
        private boolean mPivotYRel;

        public AnimatedRotateState(AnimatedRotateState source, AnimatedRotateDrawable owner, Resources res) {
            if (source != null) {
                Drawable drawable2 = source.drawable;
                Intrinsics.checkNotNull(drawable2);
                Drawable.ConstantState constantState = drawable2.getConstantState();
                Intrinsics.checkNotNull(constantState);
                if (res != null) {
                    this.drawable = constantState.newDrawable(res);
                } else {
                    this.drawable = constantState.newDrawable();
                }
                Drawable drawable3 = this.drawable;
                Intrinsics.checkNotNull(drawable3);
                drawable3.setCallback(owner);
                this.mPivotXRel = source.mPivotXRel;
                this.mPivotX = source.mPivotX;
                this.mPivotYRel = source.mPivotYRel;
                this.mPivotY = source.mPivotY;
                this.mFramesCount = source.mFramesCount;
                this.mFrameDuration = source.mFrameDuration;
                this.mCheckedConstantState = true;
                this.mCanConstantState = true;
            }
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        public final void setDrawable(Drawable drawable2) {
            this.drawable = drawable2;
        }

        public final int getMChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public final void setMChangingConfigurations(int i2) {
            this.mChangingConfigurations = i2;
        }

        public final boolean getMPivotXRel() {
            return this.mPivotXRel;
        }

        public final void setMPivotXRel(boolean z) {
            this.mPivotXRel = z;
        }

        public final float getMPivotX() {
            return this.mPivotX;
        }

        public final void setMPivotX(float f2) {
            this.mPivotX = f2;
        }

        public final boolean getMPivotYRel() {
            return this.mPivotYRel;
        }

        public final void setMPivotYRel(boolean z) {
            this.mPivotYRel = z;
        }

        public final float getMPivotY() {
            return this.mPivotY;
        }

        public final void setMPivotY(float f2) {
            this.mPivotY = f2;
        }

        public final int getMFrameDuration() {
            return this.mFrameDuration;
        }

        public final void setMFrameDuration(int i2) {
            this.mFrameDuration = i2;
        }

        public final int getMFramesCount() {
            return this.mFramesCount;
        }

        public final void setMFramesCount(int i2) {
            this.mFramesCount = i2;
        }

        public Drawable newDrawable() {
            return new AnimatedRotateDrawable(this, (Resources) null, (DefaultConstructorMarker) null);
        }

        public Drawable newDrawable(Resources res) {
            return new AnimatedRotateDrawable(this, res, (DefaultConstructorMarker) null);
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public final boolean canConstantState() {
            if (!this.mCheckedConstantState) {
                Drawable drawable2 = this.drawable;
                Intrinsics.checkNotNull(drawable2);
                this.mCanConstantState = drawable2.getConstantState() != null;
                this.mCheckedConstantState = true;
            }
            return this.mCanConstantState;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/anim/AnimatedRotateDrawable$Params;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "visible", "", "pivotX", "", "pivotXRel", "pivotY", "pivotYRel", "framesCount", "", "frameDuration", "(Landroid/graphics/drawable/Drawable;ZFZFZII)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getFrameDuration", "()I", "getFramesCount", "getPivotX", "()F", "getPivotXRel", "()Z", "getPivotY", "getPivotYRel", "getVisible", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: anim.kt */
    public static final class Params {
        private final Drawable drawable;
        private final int frameDuration;
        private final int framesCount;
        private final float pivotX;
        private final boolean pivotXRel;
        private final float pivotY;
        private final boolean pivotYRel;
        private final boolean visible;

        public Params(Drawable drawable2, boolean visible2, float pivotX2, boolean pivotXRel2, float pivotY2, boolean pivotYRel2, int framesCount2, int frameDuration2) {
            Intrinsics.checkNotNullParameter(drawable2, "drawable");
            this.drawable = drawable2;
            this.visible = visible2;
            this.pivotX = pivotX2;
            this.pivotXRel = pivotXRel2;
            this.pivotY = pivotY2;
            this.pivotYRel = pivotYRel2;
            this.framesCount = framesCount2;
            this.frameDuration = frameDuration2;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public final float getPivotX() {
            return this.pivotX;
        }

        public final boolean getPivotXRel() {
            return this.pivotXRel;
        }

        public final float getPivotY() {
            return this.pivotY;
        }

        public final boolean getPivotYRel() {
            return this.pivotYRel;
        }

        public final int getFrameDuration() {
            return this.frameDuration;
        }

        public final int getFramesCount() {
            return this.framesCount;
        }
    }
}
