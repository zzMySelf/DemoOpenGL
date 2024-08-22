package com.tera.scan.scanner.ocr.control;

import android.graphics.Rect;
import fe.vvv.qw.xxx.ad;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "", "getPictureSize", "Lcom/otaliastudios/cameraview/size/Size;", "getPreviewRect", "Landroid/graphics/Rect;", "setCarmeSize", "", "layoutWHParams", "", "setPictureSize", "size", "setZoom", "zoom", "", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IOCRTakePhotoView {
    @Nullable
    ad getPictureSize();

    @NotNull
    Rect getPreviewRect();

    void setCarmeSize(int i2);

    void setZoom(float f);
}
