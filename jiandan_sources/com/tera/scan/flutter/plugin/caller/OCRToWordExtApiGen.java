package com.tera.scan.flutter.plugin.caller;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public interface OCRToWordExtApiGen {
    void localFileOCRRecognition(Context context, String str, String str2, int i2);

    void remoteFileOCRRecognition(Context context, String str, String str2, int i2);

    int sourceImagePreviewDefine();
}
