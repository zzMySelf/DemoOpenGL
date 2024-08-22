package com.baidu.searchbox.ui.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class LazyStateListDrawable extends StateListDrawable {
    private static final boolean DEBUG = false;
    private static final String KEY_USE_NEW_STATE_LIST_DRAWABLE = "use_new_state_list_drawable";
    private static final String TAG = "BdDrawable";
    private Drawable mBaseDrawable;
    private WeakReference<Resources> mContext;
    private List<StateSetValue> mStateDrawable = new ArrayList();

    LazyStateListDrawable(Resources resources) {
        this.mContext = new WeakReference<>(resources);
    }

    /* access modifiers changed from: package-private */
    public void addAndDecodeState(int[] stateSet, int drawable) {
        Drawable d2 = decodeDrawable(drawable);
        if (d2 != null) {
            super.addState(stateSet, d2);
            if (this.mBaseDrawable == null) {
                this.mBaseDrawable = d2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addState(int[] stateSet, int drawable) {
        StateSetValue value = new StateSetValue(stateSet, drawable);
        super.addState(stateSet, value.delegateDrawable);
        this.mStateDrawable.add(value);
    }

    /* access modifiers changed from: package-private */
    public void refreshAsyncDrawable() {
        if (this.mBaseDrawable != null) {
            for (StateSetValue value : this.mStateDrawable) {
                value.delegateDrawable.setDelegate(this.mBaseDrawable);
            }
        }
    }

    private Drawable decodeDrawable(int drawable) {
        Resources r = (Resources) this.mContext.get();
        if (r != null) {
            return r.getDrawable(drawable);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] stateSet) {
        List<StateSetValue> list = this.mStateDrawable;
        int n = list == null ? 0 : list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= n) {
                break;
            } else if (StateSet.stateSetMatches(this.mStateDrawable.get(i2).state, stateSet)) {
                StateSetValue value = this.mStateDrawable.remove(i2);
                Drawable d2 = decodeDrawable(value.drawable);
                if (d2 != null) {
                    value.delegateDrawable.setDelegate(d2);
                }
            } else {
                i2++;
            }
        }
        return super.onStateChange(stateSet);
    }

    private static final class StateSetValue {
        DelegateDrawable delegateDrawable = new DelegateDrawable();
        int drawable;
        int[] state;

        StateSetValue(int[] state2, int drawable2) {
            this.state = state2;
            this.drawable = drawable2;
        }
    }

    private static final class DelegateDrawable extends Drawable implements Drawable.Callback {
        private Drawable mCurrDrawable;

        private DelegateDrawable() {
        }

        /* access modifiers changed from: package-private */
        public void setDelegate(Drawable delegate) {
            this.mCurrDrawable = delegate;
            if (delegate instanceof Animatable) {
                delegate.setCallback(this);
                delegate.setVisible(true, true);
                ((Animatable) delegate).start();
            }
        }

        public void draw(Canvas canvas) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }

        public void setAlpha(int alpha) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setAlpha(alpha);
            }
        }

        public void setColorFilter(ColorFilter colorFilter) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }

        public int getOpacity() {
            Drawable drawable = this.mCurrDrawable;
            if (drawable == null) {
                return 0;
            }
            return drawable.getOpacity();
        }

        public int getIntrinsicWidth() {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicWidth();
            }
            return super.getIntrinsicWidth();
        }

        public int getIntrinsicHeight() {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicHeight();
            }
            return super.getIntrinsicHeight();
        }

        public int getMinimumWidth() {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getMinimumWidth();
            }
            return super.getMinimumWidth();
        }

        public int getMinimumHeight() {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getMinimumHeight();
            }
            return super.getMinimumHeight();
        }

        public void setBounds(Rect bounds) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setBounds(bounds);
            }
        }

        public void setBounds(int left, int top, int right, int bottom) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setBounds(left, top, right, bottom);
            }
        }

        public void invalidateDrawable(Drawable who) {
            if (who == this.mCurrDrawable) {
                invalidateSelf();
            }
        }

        public void scheduleDrawable(Drawable who, Runnable what, long when) {
            if (who == this.mCurrDrawable) {
                scheduleSelf(what, when);
            }
        }

        public void unscheduleDrawable(Drawable who, Runnable what) {
            if (who == this.mCurrDrawable) {
                unscheduleSelf(what);
            }
        }
    }

    public static final class DrawableStateBuilder {
        private static boolean mEnableLazy = new SharedPrefsWrapper("").getBoolean("use_new_state_list_drawable", true);
        private LazyStateListDrawable mInnerDrawable;
        private WeakReference<Resources> mResources;
        private StateListDrawable mSysDrawable;

        public DrawableStateBuilder(Resources resources) {
            this.mResources = new WeakReference<>(resources);
            this.mInnerDrawable = new LazyStateListDrawable(resources);
        }

        /* access modifiers changed from: package-private */
        public void addStateDrawable(int[] state, int drawable, boolean decodeNow) {
            if (!mEnableLazy) {
                addDrawableToSystemStateList(state, drawable);
            } else if (decodeNow) {
                this.mInnerDrawable.addAndDecodeState(state, drawable);
            } else {
                this.mInnerDrawable.addState(state, drawable);
            }
        }

        public Drawable build() {
            StateListDrawable stateListDrawable = this.mSysDrawable;
            if (stateListDrawable != null) {
                return stateListDrawable;
            }
            this.mInnerDrawable.refreshAsyncDrawable();
            return this.mInnerDrawable;
        }

        private void addDrawableToSystemStateList(int[] state, int drawable) {
            if (this.mSysDrawable == null) {
                this.mSysDrawable = new StateListDrawable();
            }
            Resources r = (Resources) this.mResources.get();
            if (r != null) {
                this.mSysDrawable.addState(state, r.getDrawable(drawable));
            }
        }
    }
}
