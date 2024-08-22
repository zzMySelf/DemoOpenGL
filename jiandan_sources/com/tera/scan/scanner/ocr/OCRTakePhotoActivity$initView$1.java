package com.tera.scan.scanner.ocr;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class OCRTakePhotoActivity$initView$1 extends FunctionReferenceImpl implements Function1<Integer, View> {
    public OCRTakePhotoActivity$initView$1(Object obj) {
        super(1, obj, OCRTakePhotoActivity.class, "findViewById", "findViewById(I)Landroid/view/View;", 0);
    }

    public final View invoke(int i2) {
        return ((OCRTakePhotoActivity) this.receiver).findViewById(i2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
