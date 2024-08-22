package com.tera.scan.scanner.ocr.decode;

import android.graphics.Rect;
import com.google.zxing.Result;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/tera/scan/scanner/ocr/decode/ScannerCallback;", "", "decodeSuccess", "", "result", "Lcom/google/zxing/Result;", "getPreviewRect", "Landroid/graphics/Rect;", "getRootViewHeight", "", "getRootViewWidth", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ScannerCallback {
    @Nullable
    Rect getPreviewRect();

    void i(@Nullable Result result);

    int o();

    int rg();
}
