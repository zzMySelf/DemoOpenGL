package com.tera.scan.scanner.ocr.control;

import android.content.Intent;
import fe.vvv.qw.xxx.ad;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016¨\u0006!"}, d2 = {"Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoControl;", "", "enterTakeMode", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClear", "onDestroy", "onInitView", "view", "Landroid/app/Activity;", "onPicturePreview", "frame", "Lcom/otaliastudios/cameraview/frame/Frame;", "cameraViewWidth", "cameraViewHeight", "onPictureSizeChanged", "size", "Lcom/otaliastudios/cameraview/size/Size;", "onPictureTake", "pic", "Ljava/io/File;", "onResume", "onSelect", "onStop", "onUnSelect", "pictures", "", "", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IOCRTakePhotoControl {

    public static final class qw {
        public static void ad(@NotNull IOCRTakePhotoControl iOCRTakePhotoControl, @NotNull ad adVar) {
            Intrinsics.checkNotNullParameter(adVar, "size");
        }

        public static void de(@NotNull IOCRTakePhotoControl iOCRTakePhotoControl) {
        }

        public static void fe(@NotNull IOCRTakePhotoControl iOCRTakePhotoControl) {
        }

        public static void qw(@NotNull IOCRTakePhotoControl iOCRTakePhotoControl) {
        }

        @NotNull
        public static List<String> rg(@NotNull IOCRTakePhotoControl iOCRTakePhotoControl) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    void ad();

    void de();

    void fe(@NotNull ad adVar);

    void onActivityResult(int i2, int i3, @Nullable Intent intent);

    void onDestroy();

    void onResume();

    void onStop();

    void qw(@NotNull fe.vvv.qw.o.qw qwVar, int i2, int i3);

    void th(@NotNull File file);

    void uk();

    @NotNull
    List<String> yj();
}
