package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

public final class FlutterSplashView extends FrameLayout {
    public static String TAG = "FlutterSplashView";
    @NonNull
    public final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener;
    @NonNull
    public final FlutterUiDisplayListener flutterUiDisplayListener;
    @Nullable
    public FlutterView flutterView;
    @NonNull
    public final Runnable onTransitionComplete;
    @Nullable
    public String previousCompletedSplashIsolate;
    @Nullable
    public SplashScreen splashScreen;
    @Nullable
    public Bundle splashScreenState;
    @Nullable
    public View splashScreenView;
    @Nullable
    public String transitioningIsolateId;

    @Keep
    public static class SavedState extends View.BaseSavedState {
        public static Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        public String previousCompletedSplashIsolate;
        public Bundle splashScreenState;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.previousCompletedSplashIsolate);
            parcel.writeBundle(this.splashScreenState);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.previousCompletedSplashIsolate = parcel.readString();
            this.splashScreenState = parcel.readBundle(SavedState.class.getClassLoader());
        }
    }

    public FlutterSplashView(@NonNull Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private boolean hasSplashCompleted() {
        FlutterView flutterView2 = this.flutterView;
        if (flutterView2 == null) {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
        } else if (flutterView2.isAttachedToFlutterEngine()) {
            return this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null && this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.previousCompletedSplashIsolate);
        } else {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    private boolean isSplashScreenNeededNow() {
        FlutterView flutterView2 = this.flutterView;
        return flutterView2 != null && flutterView2.isAttachedToFlutterEngine() && !this.flutterView.hasRenderedFirstFrame() && !hasSplashCompleted();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.splashScreen;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isSplashScreenTransitionNeededNow() {
        /*
            r1 = this;
            io.flutter.embedding.android.FlutterView r0 = r1.flutterView
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isAttachedToFlutterEngine()
            if (r0 == 0) goto L_0x001c
            io.flutter.embedding.android.SplashScreen r0 = r1.splashScreen
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.doesSplashViewRememberItsTransition()
            if (r0 == 0) goto L_0x001c
            boolean r0 = r1.wasPreviousSplashTransitionInterrupted()
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterSplashView.isSplashScreenTransitionNeededNow():boolean");
    }

    /* access modifiers changed from: private */
    public void transitionToFlutter() {
        this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
        String str = TAG;
        Log.v(str, "Transitioning splash screen to a Flutter UI. Isolate: " + this.transitioningIsolateId);
        this.splashScreen.transitionToFlutter(this.onTransitionComplete);
    }

    private boolean wasPreviousSplashTransitionInterrupted() {
        FlutterView flutterView2 = this.flutterView;
        if (flutterView2 == null) {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
        } else if (flutterView2.isAttachedToFlutterEngine()) {
            return this.flutterView.hasRenderedFirstFrame() && !hasSplashCompleted();
        } else {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    public void displayFlutterViewWithSplash(@NonNull FlutterView flutterView2, @Nullable SplashScreen splashScreen2) {
        FlutterView flutterView3 = this.flutterView;
        if (flutterView3 != null) {
            flutterView3.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
            removeView(this.flutterView);
        }
        View view = this.splashScreenView;
        if (view != null) {
            removeView(view);
        }
        this.flutterView = flutterView2;
        addView(flutterView2);
        this.splashScreen = splashScreen2;
        if (splashScreen2 == null) {
            return;
        }
        if (isSplashScreenNeededNow()) {
            Log.v(TAG, "Showing splash screen UI.");
            View createSplashView = splashScreen2.createSplashView(getContext(), this.splashScreenState);
            this.splashScreenView = createSplashView;
            addView(createSplashView);
            flutterView2.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
        } else if (isSplashScreenTransitionNeededNow()) {
            Log.v(TAG, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
            View createSplashView2 = splashScreen2.createSplashView(getContext(), this.splashScreenState);
            this.splashScreenView = createSplashView2;
            addView(createSplashView2);
            transitionToFlutter();
        } else if (!flutterView2.isAttachedToFlutterEngine()) {
            Log.v(TAG, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
            flutterView2.addFlutterEngineAttachmentListener(this.flutterEngineAttachmentListener);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.previousCompletedSplashIsolate = savedState.previousCompletedSplashIsolate;
        this.splashScreenState = savedState.splashScreenState;
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        String unused = savedState.previousCompletedSplashIsolate = this.previousCompletedSplashIsolate;
        SplashScreen splashScreen2 = this.splashScreen;
        Bundle unused2 = savedState.splashScreenState = splashScreen2 != null ? splashScreen2.saveSplashScreenState() : null;
        return savedState;
    }

    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.flutterEngineAttachmentListener = new FlutterView.FlutterEngineAttachmentListener() {
            public void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine flutterEngine) {
                FlutterSplashView.this.flutterView.removeFlutterEngineAttachmentListener(this);
                FlutterSplashView flutterSplashView = FlutterSplashView.this;
                flutterSplashView.displayFlutterViewWithSplash(flutterSplashView.flutterView, FlutterSplashView.this.splashScreen);
            }

            public void onFlutterEngineDetachedFromFlutterView() {
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                if (FlutterSplashView.this.splashScreen != null) {
                    FlutterSplashView.this.transitionToFlutter();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        this.onTransitionComplete = new Runnable() {
            public void run() {
                FlutterSplashView flutterSplashView = FlutterSplashView.this;
                flutterSplashView.removeView(flutterSplashView.splashScreenView);
                FlutterSplashView flutterSplashView2 = FlutterSplashView.this;
                String unused = flutterSplashView2.previousCompletedSplashIsolate = flutterSplashView2.transitioningIsolateId;
            }
        };
        setSaveEnabled(true);
    }
}
