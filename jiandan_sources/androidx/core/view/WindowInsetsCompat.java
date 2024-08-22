package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class WindowInsetsCompat {
    @NonNull
    public static final WindowInsetsCompat CONSUMED;
    public static final String TAG = "WindowInsetsCompat";
    public final Impl mImpl;

    @RequiresApi(21)
    public static class Api21ReflectionHolder {
        public static Field sContentInsets;
        public static boolean sReflectionSucceeded = true;
        public static Field sStableInsets;
        public static Field sViewAttachInfoField;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                sViewAttachInfoField = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                sStableInsets = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                sContentInsets = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                "Failed to get visible insets from AttachInfo " + e.getMessage();
            }
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
            if (sReflectionSucceeded && view.isAttachedToWindow()) {
                try {
                    Object obj = sViewAttachInfoField.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) sStableInsets.get(obj);
                        Rect rect2 = (Rect) sContentInsets.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            WindowInsetsCompat build = new Builder().setStableInsets(Insets.of(rect)).setSystemWindowInsets(Insets.of(rect2)).build();
                            build.setRootWindowInsets(build);
                            build.copyRootViewBounds(view.getRootView());
                            return build;
                        }
                    }
                } catch (IllegalAccessException e) {
                    "Failed to get insets from AttachInfo. " + e.getMessage();
                }
            }
            return null;
        }
    }

    public static class BuilderImpl {
        public final WindowInsetsCompat mInsets;
        public Insets[] mInsetsTypeMask;

        public BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        public final void applyInsetTypes() {
            Insets[] insetsArr = this.mInsetsTypeMask;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.indexOf(1)];
                Insets insets2 = this.mInsetsTypeMask[Type.indexOf(2)];
                if (insets2 == null) {
                    insets2 = this.mInsets.getInsets(2);
                }
                if (insets == null) {
                    insets = this.mInsets.getInsets(1);
                }
                setSystemWindowInsets(Insets.max(insets, insets2));
                Insets insets3 = this.mInsetsTypeMask[Type.indexOf(16)];
                if (insets3 != null) {
                    setSystemGestureInsets(insets3);
                }
                Insets insets4 = this.mInsetsTypeMask[Type.indexOf(32)];
                if (insets4 != null) {
                    setMandatorySystemGestureInsets(insets4);
                }
                Insets insets5 = this.mInsetsTypeMask[Type.indexOf(64)];
                if (insets5 != null) {
                    setTappableElementInsets(insets5);
                }
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            applyInsetTypes();
            return this.mInsets;
        }

        public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        }

        public void setInsets(int i2, @NonNull Insets insets) {
            if (this.mInsetsTypeMask == null) {
                this.mInsetsTypeMask = new Insets[9];
            }
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    this.mInsetsTypeMask[Type.indexOf(i3)] = insets;
                }
            }
        }

        public void setInsetsIgnoringVisibility(int i2, @NonNull Insets insets) {
            if (i2 == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        public void setMandatorySystemGestureInsets(@NonNull Insets insets) {
        }

        public void setStableInsets(@NonNull Insets insets) {
        }

        public void setSystemGestureInsets(@NonNull Insets insets) {
        }

        public void setSystemWindowInsets(@NonNull Insets insets) {
        }

        public void setTappableElementInsets(@NonNull Insets insets) {
        }

        public void setVisible(int i2, boolean z) {
        }

        public BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.mInsets = windowInsetsCompat;
        }
    }

    @RequiresApi(30)
    public static class BuilderImpl30 extends BuilderImpl29 {
        public BuilderImpl30() {
        }

        public void setInsets(int i2, @NonNull Insets insets) {
            this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(i2), insets.toPlatformInsets());
        }

        public void setInsetsIgnoringVisibility(int i2, @NonNull Insets insets) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl30.toPlatformType(i2), insets.toPlatformInsets());
        }

        public void setVisible(int i2, boolean z) {
            this.mPlatBuilder.setVisible(TypeImpl30.toPlatformType(i2), z);
        }

        public BuilderImpl30(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    public static class Impl {
        @NonNull
        public static final WindowInsetsCompat CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        public final WindowInsetsCompat mHost;

        public Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.mHost = windowInsetsCompat;
        }

        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        public void copyRootViewBounds(@NonNull View view) {
        }

        public void copyWindowDataInto(@NonNull WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            if (isRound() != impl.isRound() || isConsumed() != impl.isConsumed() || !ObjectsCompat.equals(getSystemWindowInsets(), impl.getSystemWindowInsets()) || !ObjectsCompat.equals(getStableInsets(), impl.getStableInsets()) || !ObjectsCompat.equals(getDisplayCutout(), impl.getDisplayCutout())) {
                return false;
            }
            return true;
        }

        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        @NonNull
        public Insets getInsets(int i2) {
            return Insets.NONE;
        }

        @NonNull
        public Insets getInsetsIgnoringVisibility(int i2) {
            if ((i2 & 8) == 0) {
                return Insets.NONE;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        public Insets getStableInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        public Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
        }

        @NonNull
        public WindowInsetsCompat inset(int i2, int i3, int i4, int i5) {
            return CONSUMED;
        }

        public boolean isConsumed() {
            return false;
        }

        public boolean isRound() {
            return false;
        }

        public boolean isVisible(int i2) {
            return true;
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
        }

        public void setRootViewData(@NonNull Insets insets) {
        }

        public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        }

        public void setStableInsets(Insets insets) {
        }
    }

    @RequiresApi(20)
    public static class Impl20 extends Impl {
        public static Class<?> sAttachInfoClass = null;
        public static Field sAttachInfoField = null;
        public static Method sGetViewRootImplMethod = null;
        public static Class<?> sViewRootImplClass = null;
        public static Field sVisibleInsetsField = null;
        public static boolean sVisibleRectReflectionFetched = false;
        public Insets[] mOverriddenInsets;
        @NonNull
        public final WindowInsets mPlatformInsets;
        public Insets mRootViewVisibleInsets;
        public WindowInsetsCompat mRootWindowInsets;
        public Insets mSystemWindowInsets;

        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = windowInsets;
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.getStableInsets();
            }
            return Insets.NONE;
        }

        @Nullable
        private Insets getVisibleInsets(@NonNull View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!sVisibleRectReflectionFetched) {
                    loadReflectionField();
                }
                Method method = sGetViewRootImplMethod;
                if (!(method == null || sAttachInfoClass == null || sVisibleInsetsField == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            new NullPointerException();
                            return null;
                        }
                        Rect rect = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(invoke));
                        if (rect != null) {
                            return Insets.of(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e) {
                        "Failed to get visible insets. (Reflection error). " + e.getMessage();
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        public static void loadReflectionField() {
            try {
                sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                sViewRootImplClass = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                sAttachInfoClass = cls;
                sVisibleInsetsField = cls.getDeclaredField("mVisibleInsets");
                sAttachInfoField = sViewRootImplClass.getDeclaredField("mAttachInfo");
                sVisibleInsetsField.setAccessible(true);
                sAttachInfoField.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                "Failed to get visible insets. (Reflection error). " + e.getMessage();
            }
            sVisibleRectReflectionFetched = true;
        }

        public void copyRootViewBounds(@NonNull View view) {
            Insets visibleInsets = getVisibleInsets(view);
            if (visibleInsets == null) {
                visibleInsets = Insets.NONE;
            }
            setRootViewData(visibleInsets);
        }

        public void copyWindowDataInto(@NonNull WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.setRootWindowInsets(this.mRootWindowInsets);
            windowInsetsCompat.setRootViewData(this.mRootViewVisibleInsets);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) obj).mRootViewVisibleInsets);
        }

        @NonNull
        public Insets getInsets(int i2) {
            return getInsets(i2, false);
        }

        @NonNull
        public Insets getInsetsForType(int i2, boolean z) {
            int i3;
            DisplayCutoutCompat displayCutoutCompat;
            if (i2 != 1) {
                Insets insets = null;
                if (i2 != 2) {
                    if (i2 == 8) {
                        Insets[] insetsArr = this.mOverriddenInsets;
                        if (insetsArr != null) {
                            insets = insetsArr[Type.indexOf(8)];
                        }
                        if (insets != null) {
                            return insets;
                        }
                        Insets systemWindowInsets = getSystemWindowInsets();
                        Insets rootStableInsets = getRootStableInsets();
                        int i4 = systemWindowInsets.bottom;
                        if (i4 > rootStableInsets.bottom) {
                            return Insets.of(0, 0, 0, i4);
                        }
                        Insets insets2 = this.mRootViewVisibleInsets;
                        if (insets2 == null || insets2.equals(Insets.NONE) || (i3 = this.mRootViewVisibleInsets.bottom) <= rootStableInsets.bottom) {
                            return Insets.NONE;
                        }
                        return Insets.of(0, 0, 0, i3);
                    } else if (i2 == 16) {
                        return getSystemGestureInsets();
                    } else {
                        if (i2 == 32) {
                            return getMandatorySystemGestureInsets();
                        }
                        if (i2 == 64) {
                            return getTappableElementInsets();
                        }
                        if (i2 != 128) {
                            return Insets.NONE;
                        }
                        WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
                        if (windowInsetsCompat != null) {
                            displayCutoutCompat = windowInsetsCompat.getDisplayCutout();
                        } else {
                            displayCutoutCompat = getDisplayCutout();
                        }
                        if (displayCutoutCompat != null) {
                            return Insets.of(displayCutoutCompat.getSafeInsetLeft(), displayCutoutCompat.getSafeInsetTop(), displayCutoutCompat.getSafeInsetRight(), displayCutoutCompat.getSafeInsetBottom());
                        }
                        return Insets.NONE;
                    }
                } else if (z) {
                    Insets rootStableInsets2 = getRootStableInsets();
                    Insets stableInsets = getStableInsets();
                    return Insets.of(Math.max(rootStableInsets2.left, stableInsets.left), 0, Math.max(rootStableInsets2.right, stableInsets.right), Math.max(rootStableInsets2.bottom, stableInsets.bottom));
                } else {
                    Insets systemWindowInsets2 = getSystemWindowInsets();
                    WindowInsetsCompat windowInsetsCompat2 = this.mRootWindowInsets;
                    if (windowInsetsCompat2 != null) {
                        insets = windowInsetsCompat2.getStableInsets();
                    }
                    int i5 = systemWindowInsets2.bottom;
                    if (insets != null) {
                        i5 = Math.min(i5, insets.bottom);
                    }
                    return Insets.of(systemWindowInsets2.left, 0, systemWindowInsets2.right, i5);
                }
            } else if (z) {
                return Insets.of(0, Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0);
            } else {
                return Insets.of(0, getSystemWindowInsets().top, 0, 0);
            }
        }

        @NonNull
        public Insets getInsetsIgnoringVisibility(int i2) {
            return getInsets(i2, true);
        }

        @NonNull
        public final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets == null) {
                this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        @NonNull
        public WindowInsetsCompat inset(int i2, int i3, int i4, int i5) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), i2, i3, i4, i5));
            builder.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), i2, i3, i4, i5));
            return builder.build();
        }

        public boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        public boolean isTypeVisible(int i2) {
            if (!(i2 == 1 || i2 == 2)) {
                if (i2 == 4) {
                    return false;
                }
                if (!(i2 == 8 || i2 == 128)) {
                    return true;
                }
            }
            return !getInsetsForType(i2, false).equals(Insets.NONE);
        }

        @SuppressLint({"WrongConstant"})
        public boolean isVisible(int i2) {
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0 && !isTypeVisible(i3)) {
                    return false;
                }
            }
            return true;
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
            this.mOverriddenInsets = insetsArr;
        }

        public void setRootViewData(@NonNull Insets insets) {
            this.mRootViewVisibleInsets = insets;
        }

        public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
            this.mRootWindowInsets = windowInsetsCompat;
        }

        @SuppressLint({"WrongConstant"})
        @NonNull
        private Insets getInsets(int i2, boolean z) {
            Insets insets = Insets.NONE;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    insets = Insets.max(insets, getInsetsForType(i3, z));
                }
            }
            return insets;
        }

        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.mPlatformInsets));
        }
    }

    @RequiresApi(28)
    public static class Impl28 extends Impl21 {
        public Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            if (!Objects.equals(this.mPlatformInsets, impl28.mPlatformInsets) || !Objects.equals(this.mRootViewVisibleInsets, impl28.mRootViewVisibleInsets)) {
                return false;
            }
            return true;
        }

        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }

        public Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl28 impl28) {
            super(windowInsetsCompat, (Impl21) impl28);
        }
    }

    @RequiresApi(30)
    public static class Impl30 extends Impl29 {
        @NonNull
        public static final WindowInsetsCompat CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

        public Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public final void copyRootViewBounds(@NonNull View view) {
        }

        @NonNull
        public Insets getInsets(int i2) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(i2)));
        }

        @NonNull
        public Insets getInsetsIgnoringVisibility(int i2) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(i2)));
        }

        public boolean isVisible(int i2) {
            return this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(i2));
        }

        public Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl30 impl30) {
            super(windowInsetsCompat, (Impl29) impl30);
        }
    }

    public static final class Type {
        public static final int CAPTION_BAR = 4;
        public static final int DISPLAY_CUTOUT = 128;
        public static final int FIRST = 1;
        public static final int IME = 8;
        public static final int LAST = 256;
        public static final int MANDATORY_SYSTEM_GESTURES = 32;
        public static final int NAVIGATION_BARS = 2;
        public static final int SIZE = 9;
        public static final int STATUS_BARS = 1;
        public static final int SYSTEM_GESTURES = 16;
        public static final int TAPPABLE_ELEMENT = 64;
        public static final int WINDOW_DECOR = 256;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface InsetsType {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        public static int indexOf(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            if (i2 == 16) {
                return 4;
            }
            if (i2 == 32) {
                return 5;
            }
            if (i2 == 64) {
                return 6;
            }
            if (i2 == 128) {
                return 7;
            }
            if (i2 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i2);
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    @RequiresApi(30)
    public static final class TypeImpl30 {
        public static int toPlatformType(int i2) {
            int i3;
            int i4 = 0;
            for (int i5 = 1; i5 <= 256; i5 <<= 1) {
                if ((i2 & i5) != 0) {
                    if (i5 == 1) {
                        i3 = WindowInsets.Type.statusBars();
                    } else if (i5 == 2) {
                        i3 = WindowInsets.Type.navigationBars();
                    } else if (i5 == 4) {
                        i3 = WindowInsets.Type.captionBar();
                    } else if (i5 == 8) {
                        i3 = WindowInsets.Type.ime();
                    } else if (i5 == 16) {
                        i3 = WindowInsets.Type.systemGestures();
                    } else if (i5 == 32) {
                        i3 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i5 == 64) {
                        i3 = WindowInsets.Type.tappableElement();
                    } else if (i5 == 128) {
                        i3 = WindowInsets.Type.displayCutout();
                    }
                    i4 |= i3;
                }
            }
            return i4;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = Impl30.CONSUMED;
        } else {
            CONSUMED = Impl.CONSUMED;
        }
    }

    @RequiresApi(20)
    public WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.mImpl = new Impl30(this, windowInsets);
        } else if (i2 >= 29) {
            this.mImpl = new Impl29(this, windowInsets);
        } else if (i2 >= 28) {
            this.mImpl = new Impl28(this, windowInsets);
        } else if (i2 >= 21) {
            this.mImpl = new Impl21(this, windowInsets);
        } else if (i2 >= 20) {
            this.mImpl = new Impl20(this, windowInsets);
        } else {
            this.mImpl = new Impl(this);
        }
    }

    public static Insets insetInsets(@NonNull Insets insets, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, insets.left - i2);
        int max2 = Math.max(0, insets.top - i3);
        int max3 = Math.max(0, insets.right - i4);
        int max4 = Math.max(0, insets.bottom - i5);
        if (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) {
            return insets;
        }
        return Insets.of(max, max2, max3, max4);
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, (View) null);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    public void copyRootViewBounds(@NonNull View view) {
        this.mImpl.copyRootViewBounds(view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    @NonNull
    public Insets getInsets(int i2) {
        return this.mImpl.getInsets(i2);
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int i2) {
        return this.mImpl.getInsetsIgnoringVisibility(i2);
    }

    @NonNull
    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    @NonNull
    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @NonNull
    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    @NonNull
    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @NonNull
    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        return !getInsets(Type.all()).equals(Insets.NONE) || !getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(Insets.NONE) || getDisplayCutout() != null;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.getStableInsets().equals(Insets.NONE);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.getSystemWindowInsets().equals(Insets.NONE);
    }

    public int hashCode() {
        Impl impl = this.mImpl;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int i2) {
        return this.mImpl.isVisible(i2);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i2, int i3, int i4, int i5) {
        return new Builder(this).setSystemWindowInsets(Insets.of(i2, i3, i4, i5)).build();
    }

    public void setOverriddenInsets(Insets[] insetsArr) {
        this.mImpl.setOverriddenInsets(insetsArr);
    }

    public void setRootViewData(@NonNull Insets insets) {
        this.mImpl.setRootViewData(insets);
    }

    public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.setRootWindowInsets(windowInsetsCompat);
    }

    public void setStableInsets(@Nullable Insets insets) {
        this.mImpl.setStableInsets(insets);
    }

    @RequiresApi(20)
    @Nullable
    public WindowInsets toWindowInsets() {
        Impl impl = this.mImpl;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).mPlatformInsets;
        }
        return null;
    }

    @RequiresApi(api = 20)
    public static class BuilderImpl20 extends BuilderImpl {
        public static Constructor<WindowInsets> sConstructor = null;
        public static boolean sConstructorFetched = false;
        public static Field sConsumedField = null;
        public static boolean sConsumedFieldFetched = false;
        public WindowInsets mPlatformInsets;
        public Insets mStableInsets;

        public BuilderImpl20() {
            this.mPlatformInsets = createWindowInsetsInstance();
        }

        @Nullable
        public static WindowInsets createWindowInsetsInstance() {
            if (!sConsumedFieldFetched) {
                try {
                    sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                sConsumedFieldFetched = true;
            }
            Field field = sConsumedField;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!sConstructorFetched) {
                try {
                    sConstructor = WindowInsets.class.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException unused3) {
                }
                sConstructorFetched = true;
            }
            Constructor<WindowInsets> constructor = sConstructor;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        @NonNull
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            windowInsetsCompat.setStableInsets(this.mStableInsets);
            return windowInsetsCompat;
        }

        public void setStableInsets(@Nullable Insets insets) {
            this.mStableInsets = insets;
        }

        public void setSystemWindowInsets(@NonNull Insets insets) {
            WindowInsets windowInsets = this.mPlatformInsets;
            if (windowInsets != null) {
                this.mPlatformInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        public BuilderImpl20(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.mPlatformInsets = windowInsetsCompat.toWindowInsets();
        }
    }

    @RequiresApi(api = 29)
    public static class BuilderImpl29 extends BuilderImpl {
        public final WindowInsets.Builder mPlatBuilder;

        public BuilderImpl29() {
            this.mPlatBuilder = new WindowInsets.Builder();
        }

        @NonNull
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            return windowInsetsCompat;
        }

        public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.mPlatBuilder.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.unwrap() : null);
        }

        public void setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        public void setStableInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
        }

        public void setSystemGestureInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
        }

        public void setSystemWindowInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
        }

        public void setTappableElementInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
        }

        public BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder builder;
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                builder = new WindowInsets.Builder(windowInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.mPlatBuilder = builder;
        }
    }

    @RequiresApi(21)
    public static class Impl21 extends Impl20 {
        public Insets mStableInsets = null;

        public Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @NonNull
        public final Insets getStableInsets() {
            if (this.mStableInsets == null) {
                this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        public boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        public void setStableInsets(@Nullable Insets insets) {
            this.mStableInsets = insets;
        }

        public Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl21 impl21) {
            super(windowInsetsCompat, (Impl20) impl21);
            this.mStableInsets = impl21.mStableInsets;
        }
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets, @Nullable View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, @IntRange(from = 0) int i5) {
        return this.mImpl.inset(i2, i3, i4, i5);
    }

    @RequiresApi(29)
    public static class Impl29 extends Impl28 {
        public Insets mMandatorySystemGestureInsets = null;
        public Insets mSystemGestureInsets = null;
        public Insets mTappableElementInsets = null;

        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets == null) {
                this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
            }
            return this.mMandatorySystemGestureInsets;
        }

        @NonNull
        public Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets == null) {
                this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
            }
            return this.mSystemGestureInsets;
        }

        @NonNull
        public Insets getTappableElementInsets() {
            if (this.mTappableElementInsets == null) {
                this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
            }
            return this.mTappableElementInsets;
        }

        @NonNull
        public WindowInsetsCompat inset(int i2, int i3, int i4, int i5) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(i2, i3, i4, i5));
        }

        public void setStableInsets(@Nullable Insets insets) {
        }

        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl29 impl29) {
            super(windowInsetsCompat, (Impl28) impl29);
        }
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.of(rect)).build();
    }

    public static final class Builder {
        public final BuilderImpl mImpl;

        public Builder() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.mImpl = new BuilderImpl30();
            } else if (i2 >= 29) {
                this.mImpl = new BuilderImpl29();
            } else if (i2 >= 20) {
                this.mImpl = new BuilderImpl20();
            } else {
                this.mImpl = new BuilderImpl();
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.mImpl.setDisplayCutout(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder setInsets(int i2, @NonNull Insets insets) {
            this.mImpl.setInsets(i2, insets);
            return this;
        }

        @NonNull
        public Builder setInsetsIgnoringVisibility(int i2, @NonNull Insets insets) {
            this.mImpl.setInsetsIgnoringVisibility(i2, insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.setMandatorySystemGestureInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setStableInsets(@NonNull Insets insets) {
            this.mImpl.setStableInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.setSystemGestureInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            this.mImpl.setSystemWindowInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            this.mImpl.setTappableElementInsets(insets);
            return this;
        }

        @NonNull
        public Builder setVisible(int i2, boolean z) {
            this.mImpl.setVisible(i2, z);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.mImpl = new BuilderImpl30(windowInsetsCompat);
            } else if (i2 >= 29) {
                this.mImpl = new BuilderImpl29(windowInsetsCompat);
            } else if (i2 >= 20) {
                this.mImpl = new BuilderImpl20(windowInsetsCompat);
            } else {
                this.mImpl = new BuilderImpl(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.mImpl;
            if (Build.VERSION.SDK_INT >= 30 && (impl instanceof Impl30)) {
                this.mImpl = new Impl30(this, (Impl30) impl);
            } else if (Build.VERSION.SDK_INT >= 29 && (impl instanceof Impl29)) {
                this.mImpl = new Impl29(this, (Impl29) impl);
            } else if (Build.VERSION.SDK_INT >= 28 && (impl instanceof Impl28)) {
                this.mImpl = new Impl28(this, (Impl28) impl);
            } else if (Build.VERSION.SDK_INT >= 21 && (impl instanceof Impl21)) {
                this.mImpl = new Impl21(this, (Impl21) impl);
            } else if (Build.VERSION.SDK_INT < 20 || !(impl instanceof Impl20)) {
                this.mImpl = new Impl(this);
            } else {
                this.mImpl = new Impl20(this, (Impl20) impl);
            }
            impl.copyWindowDataInto(this);
            return;
        }
        this.mImpl = new Impl(this);
    }
}
