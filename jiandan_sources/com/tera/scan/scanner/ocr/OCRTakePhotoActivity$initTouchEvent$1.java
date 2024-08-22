package com.tera.scan.scanner.ocr;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.mars.kotlin.extension.LoggerKt;
import fe.mmm.qw.tt.ad.Cif;
import fe.mmm.qw.tt.ad.ggg.de;
import fe.mmm.qw.tt.ad.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"com/tera/scan/scanner/ocr/OCRTakePhotoActivity$initTouchEvent$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "touchInCertNavigatorView", "touchPoint", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCRTakePhotoActivity$initTouchEvent$1 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ OCRTakePhotoActivity this$0;

    public OCRTakePhotoActivity$initTouchEvent$1(OCRTakePhotoActivity oCRTakePhotoActivity) {
        this.this$0 = oCRTakePhotoActivity;
    }

    private final boolean touchInCertNavigatorView(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(@NotNull MotionEvent motionEvent, @NotNull MotionEvent motionEvent2, float f, float f2) {
        List<i> items;
        Intrinsics.checkNotNullParameter(motionEvent, "e1");
        Intrinsics.checkNotNullParameter(motionEvent2, "e2");
        OCRBottomAdapter bottomUIAdapter$scanner_aiscanConfigRelease = this.this$0.getBottomUIAdapter$scanner_aiscanConfigRelease();
        int curPosition = bottomUIAdapter$scanner_aiscanConfigRelease != null ? bottomUIAdapter$scanner_aiscanConfigRelease.getCurPosition() : -1;
        if (motionEvent.getPointerCount() > 1) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
        if (motionEvent2.getPointerCount() > 1) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
        ImageView access$getTakePhotoButton$p = this.this$0.takePhotoButton;
        if (access$getTakePhotoButton$p != null && de.qw(access$getTakePhotoButton$p, motionEvent.getRawX(), motionEvent.getRawY())) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
        OCRBottomAdapter bottomUIAdapter$scanner_aiscanConfigRelease2 = this.this$0.getBottomUIAdapter$scanner_aiscanConfigRelease();
        if ((bottomUIAdapter$scanner_aiscanConfigRelease2 != null && bottomUIAdapter$scanner_aiscanConfigRelease2.getCurrentTab() == 3) && this.this$0.getTakePhotoViewModel().isTakingMode()) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
        if (motionEvent.getRawX() - motionEvent2.getRawX() > 100.0f) {
            LoggerKt.d$default("显示下一页", (Object) null, 1, (Object) null);
            int i2 = curPosition + 1;
            OCRBottomAdapter bottomUIAdapter$scanner_aiscanConfigRelease3 = this.this$0.getBottomUIAdapter$scanner_aiscanConfigRelease();
            if (i2 < ((bottomUIAdapter$scanner_aiscanConfigRelease3 == null || (items = bottomUIAdapter$scanner_aiscanConfigRelease3.getItems()) == null) ? 0 : items.size())) {
                Cif access$getVibrateManager$p = this.this$0.vibrateManager;
                if (access$getVibrateManager$p != null) {
                    access$getVibrateManager$p.ad();
                }
                if (this.this$0.getTakePhotoViewModel().isTakingMode()) {
                    OCRTakePhotoActivity oCRTakePhotoActivity = this.this$0;
                    OCRTakePhotoActivity.exitTakingModeWithConfirm$default(oCRTakePhotoActivity, false, new OCRTakePhotoActivity$initTouchEvent$1$onFling$1(oCRTakePhotoActivity, curPosition), 1, (Object) null);
                } else {
                    this.this$0.onItemClick(i2);
                }
            }
        }
        if (motionEvent2.getRawX() - motionEvent.getRawX() > 100.0f) {
            LoggerKt.d$default("显示上一页", (Object) null, 1, (Object) null);
            if (curPosition > 0) {
                Cif access$getVibrateManager$p2 = this.this$0.vibrateManager;
                if (access$getVibrateManager$p2 != null) {
                    access$getVibrateManager$p2.ad();
                }
                if (this.this$0.getTakePhotoViewModel().isTakingMode()) {
                    OCRTakePhotoActivity oCRTakePhotoActivity2 = this.this$0;
                    OCRTakePhotoActivity.exitTakingModeWithConfirm$default(oCRTakePhotoActivity2, false, new OCRTakePhotoActivity$initTouchEvent$1$onFling$2(oCRTakePhotoActivity2, curPosition), 1, (Object) null);
                } else {
                    this.this$0.onItemClick(curPosition - 1);
                }
            }
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }
}
