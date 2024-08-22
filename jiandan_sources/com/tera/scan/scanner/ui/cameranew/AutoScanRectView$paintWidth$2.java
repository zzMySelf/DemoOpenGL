package com.tera.scan.scanner.ui.cameranew;

import com.baidu.aiscan.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AutoScanRectView$paintWidth$2 extends Lambda implements Function0<Float> {
    public final /* synthetic */ AutoScanRectView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoScanRectView$paintWidth$2(AutoScanRectView autoScanRectView) {
        super(0);
        this.this$0 = autoScanRectView;
    }

    @NotNull
    public final Float invoke() {
        return Float.valueOf((float) this.this$0.getContext().getResources().getDimensionPixelSize(R.dimen.ocr_auto_scan_rect_corner_width));
    }
}
